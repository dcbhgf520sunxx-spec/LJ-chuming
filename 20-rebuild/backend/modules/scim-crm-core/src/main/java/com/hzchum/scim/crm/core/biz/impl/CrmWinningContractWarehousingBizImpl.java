package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmWinningContractWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectBidStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSettlementBusinessTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmWinningContractWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBackfillTheDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUpLoadStampContractParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmNonDirectSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParamV2;
import com.hzchum.scim.crm.core.api.service.CrmWinningContractWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationWarehousingMapper;
import com.hzchum.scim.crm.core.mapper.CrmWinningContractWarehousingMapper;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import jodd.util.StringUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmWinningContractWarehousingBizImpl
   extends IBizImpl<CrmWinningContractWarehousingService, CrmWinningContractWarehousingMapper, CrmWinningContractWarehousing>
   implements CrmWinningContractWarehousingBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private SysRoleLookPermissionConfigBiz sysRoleLookPermissionConfigBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private SysDictionaryService sysDictionaryService;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private CrmProjectInformationWarehousingMapper crmProjectInformationWarehousingMapper;

   @Override
   public List<CrmRemainderCanEstablishProjectInfoDTO> getRemainderCanEstablishProjectInfo(Long id) {
      CrmWinningContractWarehousing byId1 = this.baseService.getById(id);
      if (id != null) {
         CrmProjectInformationWarehousing byId = this.crmProjectInformationWarehousingBiz.getById(byId1.getCrmProjectInformationWarehousingId());
         List<CrmRemainderCanEstablishProjectInfoDTO> crmRemainderCanEstablishProjectInfoDTOS = new ArrayList<>();
         if (byId != null) {
            crmRemainderCanEstablishProjectInfoDTOS.add(
               CrmRemainderCanEstablishProjectInfoDTO.builder()
                  .id(byId.getId())
                  .projectName(byId.getProjectName())
                  .serialNumber(byId.getSerialNumber())
                  .build()
            );
         }

         return crmRemainderCanEstablishProjectInfoDTOS;
      } else {
         List<CrmWinningContractWarehousing> crmWinningContractWarehousings = this.baseService.list();
         List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                  .notIn(
                     CollectionUtils.isNotEmpty(crmWinningContractWarehousings),
                     CrmProjectInformationWarehousing::getId,
                     crmWinningContractWarehousings.stream()
                        .map(CrmWinningContractWarehousing::getCrmProjectInformationWarehousingId)
                        .collect(Collectors.toList())
                  )
            );
         return crmProjectInformationWarehousings.stream()
            .map(
               item -> CrmRemainderCanEstablishProjectInfoDTO.builder()
                  .id(item.getId())
                  .projectName(item.getProjectName())
                  .serialNumber(item.getSerialNumber())
                  .build()
            )
            .collect(Collectors.toList());
      }
   }

   @Override
   public PageVO<CrmWinningContractWarehousingPageDTO> getContractList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum,
      String condition,
      List<Integer> tenderRequirement,
      Integer pageNumber,
      Integer pageSize
   ) {
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmWinningContractWarehousingPageDTO> crmWinningContractWarehousingPageDTOS = this.baseMapper
         .getContractList(
            startDate,
            endDate,
            projectName,
            serialNumber,
            crmEnterpriseWarehousingName,
            UserUtil.getCurrentUserId(),
            crmCanLookDeptIds,
            crmProjectScheduleTypeEnum,
            condition,
            tenderRequirement
         );
      crmWinningContractWarehousingPageDTOS.forEach(
         item -> {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
               .getById(item.getCrmProjectInformationWarehousingId());
            item.setIsUploadStampedContract(StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds()) ? "已上传" : "未上传");
            if (StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds())) {
               item.setSealContractAttachmentList(this.attachmentService.listByIds(crmProjectInformationWarehousing.getSealContractAttachmentIds()));
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
            stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
            stringBuilder.append(crmProjectInformationWarehousing.getCityName());
            stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
            item.setRegionNames(stringBuilder.toString());
         }
      );
      return new PageVO<>(objects, crmWinningContractWarehousingPageDTOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCrmWinningContractWarehousing(CrmWinningContractWarehousingSaveParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmWinningContractWarehousing winningContractWarehousing = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmWinningContractWarehousing.class)
               .eq(CrmWinningContractWarehousing::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
         );
      Preconditions.checkArgument(winningContractWarehousing == null, "当前项目备案已经创建中标合同");
      Preconditions.checkArgument(
         copy.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
            || copy.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.UNWINNING_BID.getType()),
         "请先选择中标状态!!!"
      );
      CrmWinningContractWarehousing crmWinningContractWarehousing = BeanUtil.copy(copy, CrmWinningContractWarehousing.class);
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmWinningContractWarehousing.setAttachmentIds(StrUtil.join(",", copy.getAttachmentIds()));
      }

      crmWinningContractWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmWinningContractWarehousing.setProjectName(crmProjectInformationWarehousing.getProjectName());
      this.baseService.save(crmWinningContractWarehousing);
      crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(copy.getCrmProjectScheduleTypeEnum());
      this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean upLoadStampContract(CrmUpLoadStampContractParam crmUpLoadStampContractParam) {
      CrmWinningContractWarehousing crmWinningContractWarehousing = this.baseService.getById(crmUpLoadStampContractParam.getId());
      Preconditions.checkArgument(crmWinningContractWarehousing != null, "中标项目不存在");
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmWinningContractWarehousing.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      if (CollectionUtils.isNotEmpty(crmUpLoadStampContractParam.getAttachmentDTOList())) {
         List<Long> attachmentIds = crmUpLoadStampContractParam.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList());
         crmProjectInformationWarehousing.setSealContractAttachmentIds(StringUtil.join(attachmentIds, ","));
         this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      }

      return Boolean.TRUE;
   }

   @Override
   public CrmWinningContractWarehousingDetailDTO getContractDetail(Long id) {
      CrmWinningContractWarehousing crmWinningContractWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmWinningContractWarehousing != null, "中标信息不存在");
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmWinningContractWarehousing.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案信息不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz
         .getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId());
      CrmWinningContractWarehousingDetailDTO crmWinningContractWarehousingDetailDTO = new CrmWinningContractWarehousingDetailDTO();
      BeanUtil.copy(crmWinningContractWarehousing, crmWinningContractWarehousingDetailDTO);
      crmWinningContractWarehousingDetailDTO.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousing.getId());
      if (crmEnterpriseWarehousing != null) {
         crmWinningContractWarehousingDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         if (crmEnterpriseWarehousing.getIndustryConfigurationId() != null) {
            crmWinningContractWarehousingDetailDTO.setIndustryConfigurationName(
               this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getIndustryConfigurationId()).getName()
            );
         }
      }

      if (StringUtil.isNotBlank(crmWinningContractWarehousing.getReasonsForBidFail())) {
         SysDictionary byNameAndValue = this.sysDictionaryService
            .getByNameAndValue(DictionaryEnum.REASONS_FOR_BID_FAIL.getName(), crmWinningContractWarehousing.getReasonsForBidFail());
         if (byNameAndValue != null) {
            crmWinningContractWarehousingDetailDTO.setReasonsForBidFail(byNameAndValue.getValue());
            crmWinningContractWarehousingDetailDTO.setReasonsForBidFailName(byNameAndValue.getLabel());
         }
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
      stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
      stringBuilder.append(crmProjectInformationWarehousing.getCityName());
      stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
      crmWinningContractWarehousingDetailDTO.setRegionNameList(stringBuilder.toString());
      crmWinningContractWarehousingDetailDTO.setCrmProjectScheduleTypeEnum(crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum());
      crmWinningContractWarehousingDetailDTO.setInformantUserName(this.userService.getById(crmWinningContractWarehousing.getInformantUserId()).getName());
      crmWinningContractWarehousingDetailDTO.setShortName(crmWinningContractWarehousing.getShortName());
      crmWinningContractWarehousingDetailDTO.setDepartmentName(
         this.departmentService.getDepartmentById(crmWinningContractWarehousing.getDepartmentId()).getName()
      );
      crmWinningContractWarehousingDetailDTO.setProjectName(crmProjectInformationWarehousing.getProjectName());
      if (crmWinningContractWarehousing.getStructureTypeConfigurationId() != null) {
         crmWinningContractWarehousingDetailDTO.setStructureTypeConfigurationName(
            this.crmProjectInformationConfigBiz.getById(crmWinningContractWarehousing.getStructureTypeConfigurationId()).getName()
         );
      }

      if (StringUtil.isNotBlank(crmWinningContractWarehousing.getAttachmentIds())) {
         crmWinningContractWarehousingDetailDTO.setAttachmentList(this.attachmentService.listByIds(crmWinningContractWarehousing.getAttachmentIds()));
      }

      if (StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds())) {
         crmWinningContractWarehousingDetailDTO.setSealContractAttachmentList(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getSealContractAttachmentIds())
         );
      }

      return crmWinningContractWarehousingDetailDTO;
   }

   @Override
   public CrmRemainderCanEstablishProjectDetailDTO getRemainderCanEstablishProjectDetail(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmRemainderCanEstablishProjectDetailDTO crmRemainderCanEstablishProjectDetailDTO = new CrmRemainderCanEstablishProjectDetailDTO();
      crmRemainderCanEstablishProjectDetailDTO.setId(crmProjectInformationWarehousing.getId());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
      stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
      stringBuilder.append(crmProjectInformationWarehousing.getCityName());
      stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
      crmRemainderCanEstablishProjectDetailDTO.setRegionNameList(stringBuilder.toString());
      if (crmProjectInformationWarehousing.getIndustryConfigurationId() != null) {
         crmRemainderCanEstablishProjectDetailDTO.setIndustryConfigurationName(
            this.crmBasicsConfigBiz.getById(crmProjectInformationWarehousing.getIndustryConfigurationId()).getName()
         );
      }

      if (crmProjectInformationWarehousing.getDepartmentId() != null) {
         crmRemainderCanEstablishProjectDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(crmProjectInformationWarehousing.getDepartmentId()).getName()
         );
      }

      if (crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmRemainderCanEstablishProjectDetailDTO.setBusinessName(
            this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      return crmRemainderCanEstablishProjectDetailDTO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getContractListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      Integer crmProjectScheduleTypeEnum,
      String crmEnterpriseWarehousingName
   ) {
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      List<CrmWinningContractWarehousingPageDTO> crmWinningContractWarehousingPageDTOS = this.baseMapper
         .getContractList(
            startDate,
            endDate,
            projectName,
            serialNumber,
            crmEnterpriseWarehousingName,
            UserUtil.getCurrentUserId(),
            crmCanLookDeptIds,
            crmProjectScheduleTypeEnum,
            null,
            null
         );
      crmWinningContractWarehousingPageDTOS.forEach(
         item -> {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
               .getById(item.getCrmProjectInformationWarehousingId());
            item.setIsUploadStampedContract(StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds()) ? "已上传" : "未上传");
            if (StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds())) {
               item.setSealContractAttachmentList(this.attachmentService.listByIds(crmProjectInformationWarehousing.getSealContractAttachmentIds()));
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
            stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
            stringBuilder.append(crmProjectInformationWarehousing.getCityName());
            stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
            item.setRegionNames(stringBuilder.toString());
         }
      );
      List<Map<String, Object>> collect = crmWinningContractWarehousingPageDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public Boolean getContractDetailDownLoad(Long id, HttpServletResponse response) {
      CrmWinningContractWarehousingDetailDTO contractDetail = this.getContractDetail(id);
      Preconditions.checkArgument(contractDetail != null, "中标项目不存在");
      String resourcePath = null;
      String tempFileName = null;
      String exportFileName = null;
      Preconditions.checkArgument(
         contractDetail.getCrmProjectScheduleTypeEnum() != null
            && (
               contractDetail.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.UNWINNING_BID.getType())
                  || contractDetail.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
            ),
         "只有中标或未中标详情可以下载!!!!!"
      );
      if (contractDetail.getStartDate() != null && contractDetail.getEndDate() != null) {
         contractDetail.setAllDateCount(String.valueOf(ChronoUnit.DAYS.between(contractDetail.getStartDate(), contractDetail.getEndDate())));
      }

      if (contractDetail.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.UNWINNING_BID.getType())) {
         contractDetail.setCrmProjectScheduleTypeEnumName(CrmProjectScheduleTypeEnum.UNWINNING_BID.getName());
         resourcePath = "files/CrmBidNotAwardedWarehousingDetailTemplate.xlsx";
         tempFileName = "CrmBidNotAwardedWarehousingDetailTemplate";
         exportFileName = contractDetail.getProjectName() + "未中标项目.xlsx";
      }

      if (contractDetail.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())) {
         contractDetail.setCrmProjectScheduleTypeEnumName(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getName());
         resourcePath = "files/CrmWinningBidderWarehousingDetailTemplate.xlsx";
         tempFileName = "CrmWinningBidderWarehousingDetailTemplate";
         exportFileName = contractDetail.getProjectName() + "中标项目.xlsx";
      }

      Map<String, Object> map = BeanUtil.beanToMap(contractDetail);
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public List<CrmWinningContractWarehousingSimpleDTO> getSimpleList() {
      List<CrmWinningContractWarehousing> crmWinningContractWarehousings = this.baseService
         .list(Wrappers.lambdaQuery(CrmWinningContractWarehousing.class).orderByDesc(BaseEntity::getCreateTime));
      List<CrmWinningContractWarehousingSimpleDTO> crmWinningContractWarehousingSimpleDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(crmWinningContractWarehousings)) {
         Map<Long, CrmProjectInformationWarehousing> projectMap = this.crmProjectInformationWarehousingBiz
            .list()
            .stream()
            .collect(Collectors.toMap(CrmProjectInformationWarehousing::getId, Function.identity()));
         crmWinningContractWarehousings.forEach(
            item -> {
               CrmProjectInformationWarehousing crmProjectInformationWarehousing = projectMap.get(item.getCrmProjectInformationWarehousingId());
               crmWinningContractWarehousingSimpleDTOS.add(
                  CrmWinningContractWarehousingSimpleDTO.builder()
                     .id(item.getId())
                     .projectName(crmProjectInformationWarehousing.getSerialNumber() + crmProjectInformationWarehousing.getProjectName())
                     .build()
               );
            }
         );
      }

      return crmWinningContractWarehousingSimpleDTOS;
   }

   @Override
   public CrmBackfillTheDetailDTO backfillTheDetails(Long id) {
      CrmWinningContractWarehousing crmWinningContractWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmWinningContractWarehousing != null, "中标合同不存在");
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmWinningContractWarehousing.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmBackfillTheDetailDTO crmBackfillTheDetailDTO = new CrmBackfillTheDetailDTO();
      crmBackfillTheDetailDTO.setProjectName(
         StringUtils.isNotBlank(crmProjectInformationWarehousing.getProjectName()) ? crmProjectInformationWarehousing.getProjectName() : ""
      );
      if (crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmBackfillTheDetailDTO.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      crmBackfillTheDetailDTO.setCountryId(crmProjectInformationWarehousing.getCountryId() != null ? crmProjectInformationWarehousing.getCountryId() : null);
      crmBackfillTheDetailDTO.setProvinceId(crmProjectInformationWarehousing.getProvinceId() != null ? crmProjectInformationWarehousing.getProvinceId() : null);
      crmBackfillTheDetailDTO.setCityId(crmProjectInformationWarehousing.getCityId() != null ? crmProjectInformationWarehousing.getCityId() : null);
      crmBackfillTheDetailDTO.setProvinceId(crmProjectInformationWarehousing.getProvinceId() != null ? crmProjectInformationWarehousing.getProvinceId() : null);
      List<Long> regionIds = Arrays.asList(
            crmProjectInformationWarehousing.getCountryId(),
            crmProjectInformationWarehousing.getProvinceId(),
            crmProjectInformationWarehousing.getCityId(),
            crmProjectInformationWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmBackfillTheDetailDTO.setRegionIdList(regionIds);
      crmBackfillTheDetailDTO.setProjectShortName(crmWinningContractWarehousing.getShortName() != null ? crmWinningContractWarehousing.getShortName() : null);
      crmBackfillTheDetailDTO.setContractAmount(crmWinningContractWarehousing.getAmount() != null ? crmWinningContractWarehousing.getAmount() : null);
      crmBackfillTheDetailDTO.setTaxRate(crmWinningContractWarehousing.getTaxRate() != null ? crmWinningContractWarehousing.getTaxRate() : null);
      crmBackfillTheDetailDTO.setStartDate(crmWinningContractWarehousing.getStartDate() != null ? crmWinningContractWarehousing.getStartDate() : null);
      crmBackfillTheDetailDTO.setEndDate(crmWinningContractWarehousing.getEndDate() != null ? crmWinningContractWarehousing.getEndDate() : null);
      crmBackfillTheDetailDTO.setPaymentMethod(
         crmWinningContractWarehousing.getPaymentMethod() != null ? crmWinningContractWarehousing.getPaymentMethod() : null
      );
      crmBackfillTheDetailDTO.setPartyAPersonName(
         crmWinningContractWarehousing.getPartyAPersonName() != null ? crmWinningContractWarehousing.getPartyAPersonName() : null
      );
      crmBackfillTheDetailDTO.setPartyAPhone(crmWinningContractWarehousing.getPartyAPhone() != null ? crmWinningContractWarehousing.getPartyAPhone() : null);
      crmBackfillTheDetailDTO.setDepartId(crmProjectInformationWarehousing.getDepartmentId());
      crmBackfillTheDetailDTO.setDepartName(this.departmentService.getById(crmProjectInformationWarehousing.getDepartmentId()).getName());
      crmBackfillTheDetailDTO.setQuantity(crmProjectInformationWarehousing.getEstimatedWorks());
      if (crmProjectInformationWarehousing.getStructureTypeConfigurationId() != null) {
         SysDictionary sysDictionary = this.sysDictionaryService
            .getOne(
               Wrappers.lambdaQuery(SysDictionary.class)
                  .eq(SysDictionary::getName, "structure_status")
                  .eq(
                     SysDictionary::getLabel,
                     this.crmProjectInformationConfigBiz.getById(crmWinningContractWarehousing.getStructureTypeConfigurationId()).getName()
                  )
            );
         if (sysDictionary != null) {
            crmBackfillTheDetailDTO.setStructureStatus(sysDictionary.getId());
         }
      }

      return crmBackfillTheDetailDTO;
   }

   @Transactional
   @Override
   public Boolean saveCrmWinningContractWarehousingCustom(CrmWinningContractWarehousingSaveParamV2 copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmWinningContractWarehousing winningContractWarehousing = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmWinningContractWarehousing.class)
               .eq(CrmWinningContractWarehousing::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
         );
      Preconditions.checkArgument(winningContractWarehousing == null, "当前项目备案已经创建中标合同");
      Preconditions.checkArgument(
         copy.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
            || copy.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.UNWINNING_BID.getType()),
         "请先选择中标状态!!!"
      );
      crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(copy.getCrmProjectScheduleTypeEnum());
      CrmWinningContractWarehousing crmWinningContractWarehousing = BeanUtil.copy(copy, CrmWinningContractWarehousing.class);
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmWinningContractWarehousing.setAttachmentIds(StrUtil.join(",", copy.getAttachmentIds()));
      }

      crmWinningContractWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmWinningContractWarehousing.setProjectName(crmProjectInformationWarehousing.getProjectName());
      crmWinningContractWarehousing.setReportingStatus(Boolean.FALSE);
      crmWinningContractWarehousing.setConstructionOrganizationReportingStatus(Boolean.FALSE);
      crmWinningContractWarehousing.setAnimationReportingStatus(Boolean.FALSE);
      crmWinningContractWarehousing.setInnovationReportingStatus(Boolean.FALSE);
      crmWinningContractWarehousing.setConstructionSupportServiceReportingStatus(Boolean.FALSE);
      this.baseService.save(crmWinningContractWarehousing);
      this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<CrmSpecialProgramsDTO> getSpecialProgramsList(
      Boolean reportingStatus,
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmSpecialProgramsDTO> crmWinningContractWarehousingPageDTOS = this.baseMapper
         .getSpecialProgramsList(
            reportingStatus, crmSubmissionStatusEnum, startDate, endDate, projectName, projectNumber, UserUtil.getCurrentUserId(), crmCanLookDeptIds
         );
      crmWinningContractWarehousingPageDTOS.forEach(
         item -> {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
               .getById(item.getCrmProjectInformationWarehousingId());
            item.setIsUploadStampedContract(StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds()) ? "已上传" : "未上传");
            if (StringUtil.isNotBlank(crmProjectInformationWarehousing.getSealContractAttachmentIds())) {
               item.setSealContractAttachmentList(this.attachmentService.listByIds(crmProjectInformationWarehousing.getSealContractAttachmentIds()));
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
            stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
            stringBuilder.append(crmProjectInformationWarehousing.getCityName());
            stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
            item.setRegionNames(stringBuilder.toString());
            boolean[] statuses = new boolean[]{
               item.getReportingStatus(),
               item.getConstructionOrganizationReportingStatus(),
               item.getConstructionSupportServiceReportingStatus(),
               item.getConstructionCalculationReportingStatus(),
               item.getAnimationReportingStatus(),
               item.getInnovationReportingStatus()
            };
            int count = 0;

            for (boolean status : statuses) {
               if (Boolean.TRUE.equals(status)) {
                  count++;
               }
            }

            if (count == 0) {
               item.setCrmSubmissionStatusEnum(CrmSubmissionStatusEnum.NO_REPORTED.getType());
            } else if (count < Arrays.stream(CrmSpecialBubmissionStatusEnum.values()).count() - 1L) {
               item.setCrmSubmissionStatusEnum(CrmSubmissionStatusEnum.PARTIAL_SUBMISSION.getType());
            } else if (count == Arrays.stream(CrmSpecialBubmissionStatusEnum.values()).count() - 1L) {
               item.setCrmSubmissionStatusEnum(CrmSubmissionStatusEnum.REPORTED.getType());
            }
         }
      );
      return new PageVO<>(objects, crmWinningContractWarehousingPageDTOS);
   }

   @Transactional
   @Override
   public Boolean saveSpecialPrograms(List<CrmSpecialProgramsSaveParam> copy) {
      copy.forEach(
         item -> {
            CrmWinningContractWarehousing winningContractWarehousing = this.baseService.getById(item.getId());
            Preconditions.checkArgument(winningContractWarehousing != null, "中标合同不存在");
            if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.SPECIAL_PROGRAMS.getType())) {
               winningContractWarehousing.setReportingTime(LocalDateTime.now());
               winningContractWarehousing.setReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            } else if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.CONSTRUCTION_ORGANIZATION_DESIGN.getType())) {
               winningContractWarehousing.setConstructionOrganizationReportingTime(LocalDateTime.now());
               winningContractWarehousing.setConstructionOrganizationReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setConstructionOrganizationReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            } else if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.LIVE_SUPPORT_SERVICE.getType())) {
               winningContractWarehousing.setConstructionSupportServiceReportingTime(LocalDateTime.now());
               winningContractWarehousing.setConstructionSupportServiceReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setConstructionSupportServiceReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            } else if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.CONSTRUCTION_VERIFICATION.getType())) {
               winningContractWarehousing.setConstructionCalculationReportingTime(LocalDateTime.now());
               winningContractWarehousing.setConstructionCalculationReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setConstructionCalculationReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            } else if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.ANIMATION_SET_EFFECT.getType())) {
               winningContractWarehousing.setAnimationReportingTime(LocalDateTime.now());
               winningContractWarehousing.setAnimationReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setAnimationReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            } else if (item.getCrmSpecialBubmissionStatusEnum().equals(CrmSpecialBubmissionStatusEnum.TECHNOLOGY_INNOVATION.getType())) {
               winningContractWarehousing.setInnovationReportingTime(LocalDateTime.now());
               winningContractWarehousing.setInnovationReportingStatus(Boolean.TRUE);
               winningContractWarehousing.setInnovationReportingUserId(UserUtil.getCurrentUserId());
               this.baseService.updateById(winningContractWarehousing);
            }

            CrmApplyTechnologyBiddingRecord technologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                     .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                     .eq(
                        CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId,
                        winningContractWarehousing.getCrmProjectInformationWarehousingId()
                     )
                     .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               );
            Preconditions.checkArgument(technologyBiddingRecord != null, "项目暂未技术投标!!!");
            technologyBiddingRecord.setCrmSpecialBubmissionStatusEnum(item.getCrmSpecialBubmissionStatusEnum());
            technologyBiddingRecord.setCrmSettlementBusinessTypeEnum(CrmSettlementBusinessTypeEnum.DIRECT_SALE.getType());
            technologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            technologyBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.NOT_APPOINTED.getType());
            technologyBiddingRecord.setBusinessEssentials(item.getBusinessEssentials());
            technologyBiddingRecord.setApproveRecordId(null);
            technologyBiddingRecord.setProjectBidManagerUserId(null);
            technologyBiddingRecord.setProjectBidManagerFinishDate(null);
            technologyBiddingRecord.setDifficultyFactorId(null);
            technologyBiddingRecord.setBidManagerAttachmentIds(null);
            technologyBiddingRecord.setTechnologyBidManagerJobDescriptionId(null);
            technologyBiddingRecord.setTechnologyBidManagerRenderings(null);
            technologyBiddingRecord.setTechnologyBidManagerStructureName(null);
            technologyBiddingRecord.setTechnologyBidManagerCompletion(null);
            technologyBiddingRecord.setTechnologyBidManagerBusinessTrip(null);
            technologyBiddingRecord.setTechnologyBidManagerCustomerReception(null);
            technologyBiddingRecord.setTechnologyBidManagerRemarks(null);
            this.crmApplyTechnologyBiddingRecordBiz.save(technologyBiddingRecord);
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<CrmSpecialProgramsDetailDTO> getSpecialProgramsDetail(Long id) {
      CrmWinningContractWarehousing crmWinningContractWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmWinningContractWarehousing != null, "中标合同不存在");
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(item -> item.getId(), Function.identity()));
      return this.packageInformation(crmWinningContractWarehousing, userMap);
   }

   private List<CrmSpecialProgramsDetailDTO> packageInformation(CrmWinningContractWarehousing crmWinningContractWarehousing, Map<Long, User> userMap) {
      List<CrmSpecialProgramsDetailDTO> crmSpecialProgramsDetailDTOS = new ArrayList<>();
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(
                  CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmWinningContractWarehousing.getCrmProjectInformationWarehousingId()
               )
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSettlementBusinessTypeEnum, CrmSettlementBusinessTypeEnum.DIRECT_SALE.getType())
               .ne(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
         );
      crmApplyTechnologyBiddingRecords.forEach(item -> {
         CrmSpecialProgramsDetailDTO crmSpecialProgramsDetailDTO = new CrmSpecialProgramsDetailDTO();
         crmSpecialProgramsDetailDTO.setReportingTime(item.getCreateTime());
         crmSpecialProgramsDetailDTO.setReportUserName(userMap.get(item.getCreateUserId()).getName());
         crmSpecialProgramsDetailDTO.setCrmSpecialBubmissionStatusEnum(item.getCrmSpecialBubmissionStatusEnum());
         crmSpecialProgramsDetailDTOS.add(crmSpecialProgramsDetailDTO);
      });
      return crmSpecialProgramsDetailDTOS;
   }

   @Transactional
   @Override
   public Boolean saveNonDirectSpecialPrograms(CrmNonDirectSpecialProgramsSaveParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = new CrmProjectInformationWarehousing();
      crmProjectInformationWarehousing.setProjectName(copy.getProjectName());
      crmProjectInformationWarehousing.setCrmEnterpriseWarehousingId(copy.getCrmEnterpriseWarehousingId());
      crmProjectInformationWarehousing.setAddress(copy.getAddress());
      crmProjectInformationWarehousing.setProjectSerialNumber(this.createNonDirectProjectSerialNumber());
      crmProjectInformationWarehousing.setSerialNumber(this.createNonDirectProjectSerialNumber());
      crmProjectInformationWarehousing.setInformantDateTime(LocalDateTime.now());
      crmProjectInformationWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmProjectInformationWarehousing.setInformationOperatorDeptId(UserUtil.getCurrentDepartment().getId());
      crmProjectInformationWarehousing.setInformationOperatorUserId(UserUtil.getCurrentUserId());
      crmProjectInformationWarehousing.setCrmSettlementBusinessTypeEnum(CrmSettlementBusinessTypeEnum.NON_DIRECT_SALE.getType());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      crmProjectInformationWarehousing.setInformantUserId(currentUser.getId());
      crmProjectInformationWarehousing.setDepartmentId(currentUser.getDepartment().getId());
      crmProjectInformationWarehousing.setInformationOperatorUserId(currentUser.getId());
      crmProjectInformationWarehousing.setInformationOperatorDeptId(currentUser.getDepartment().getId());
      crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(copy.getRegionList());
      crmProjectInformationWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      crmProjectInformationWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      crmProjectInformationWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      crmProjectInformationWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      crmProjectInformationWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      crmProjectInformationWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      crmProjectInformationWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      crmProjectInformationWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      this.crmProjectInformationWarehousingBiz.save(crmProjectInformationWarehousing);
      CrmApplyTechnologyBiddingRecord technologyBiddingRecord = new CrmApplyTechnologyBiddingRecord();
      technologyBiddingRecord.setCrmSpecialBubmissionStatusEnum(copy.getCrmSpecialBubmissionStatusEnum());
      technologyBiddingRecord.setInformantUserId(currentUser.getId());
      technologyBiddingRecord.setDepartmentId(currentUser.getDepartment().getId());
      technologyBiddingRecord.setCreateUserId(currentUser.getId());
      technologyBiddingRecord.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousing.getId());
      technologyBiddingRecord.setInformantDateTime(LocalDateTime.now());
      technologyBiddingRecord.setCrmSettlementBusinessTypeEnum(CrmSettlementBusinessTypeEnum.NON_DIRECT_SALE.getType());
      technologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      technologyBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.NOT_APPOINTED.getType());
      this.crmApplyTechnologyBiddingRecordBiz.save(technologyBiddingRecord);
      this.crmProjectInformationWarehousingBiz.removeById(crmProjectInformationWarehousing.getId());
      return Boolean.TRUE;
   }

   private String createNonDirectProjectSerialNumber() {
      String serialNumber = "FZ-" + DateUtil.format(new Date(), "yyyyMMdd") + "-";
      Integer count = this.crmProjectInformationWarehousingMapper.getNonDirectProjectSerialNumberCount();
      return serialNumber + (count + 1);
   }

   @Override
   public HashMap<String, Integer> getContractSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum
   ) {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("winningBidder", 0);
      map.put("winningBidProcessing", 0);
      map.put("unwinningBid", 0);
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      List<CrmWinningContractWarehousingPageDTO> crmWinningContractWarehousingPageDTOS = this.baseMapper
         .getContractList(
            startDate,
            endDate,
            projectName,
            serialNumber,
            crmEnterpriseWarehousingName,
            UserUtil.getCurrentUserId(),
            crmCanLookDeptIds,
            crmProjectScheduleTypeEnum,
            null,
            null
         );
      if (CollectionUtils.isNotEmpty(crmWinningContractWarehousingPageDTOS)) {
         List<CrmProjectInformationWarehousing> warehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .in(
                     CrmProjectInformationWarehousing::getId,
                     crmWinningContractWarehousingPageDTOS.stream()
                        .map(CrmWinningContractWarehousingPageDTO::getCrmProjectInformationWarehousingId)
                        .collect(Collectors.toList())
                  )
            );
         warehousings.forEach(item -> {
            if (item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.UNWINNING_BID.getType())) {
               map.put("unwinningBid", map.get("unwinningBid") + 1);
            }

            if (item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())) {
               map.put("winningBidder", map.get("winningBidder") + 1);
            }

            if (item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())) {
               map.put("winningBidProcessing", map.get("winningBidProcessing") + 1);
            }
         });
      }

      return map;
   }
}
