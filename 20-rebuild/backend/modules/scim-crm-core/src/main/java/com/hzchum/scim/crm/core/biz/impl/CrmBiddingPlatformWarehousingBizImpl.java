package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
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
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmNumberPrefixConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmRecordTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmBiddingPlatformWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBiddingPlatformWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmBiddingPlatformWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmBiddingPlatformWarehousingMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmBiddingPlatformWarehousingBizImpl
   extends IBizImpl<CrmBiddingPlatformWarehousingService, CrmBiddingPlatformWarehousingMapper, CrmBiddingPlatformWarehousing>
   implements CrmBiddingPlatformWarehousingBiz {
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private UserService userService;
   @Resource
   private CrmNumberPrefixConfigBiz crmNumberPrefixConfigBiz;

   @Override
   public HashMap<String, Integer> summary(Integer checkRecord) {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(checkRecord != null, CrmBiddingPlatformWarehousing::getCrmRecordTypeEnum, checkRecord)
         );
      if (CollectionUtils.isNotEmpty(crmBiddingPlatformWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmBiddingPlatformWarehousings.stream().map(CrmBiddingPlatformWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
                  )
            );
         map.put("enterprisesCount", crmEnterpriseWarehousings.size());
         map.put(
            "domesticEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() == 1L).count()
         );
         map.put(
            "foreignEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != 1L).count()
         );
      }

      return map;
   }

   @Transactional
   @Override
   public Boolean deleteCrmBiddingPlatformWarehousing(Long id) {
      CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmBiddingPlatformWarehousing != null, "招标备案不存在不存在");
      return this.baseService.removeById(id);
   }

   @Override
   public PageVO<CrmBiddingPlatformWarehousingPageDTO> getCrmBiddingPlatformWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitClassConfigurationId,
      Long unitPropertyAllocationConfigId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String biddingPlatformName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmBiddingPlatformWarehousingPageDTO> crmBiddingPlatformWarehousingPageDTOS = this.baseMapper
         .getCrmBiddingPlatformWarehousingPage(
            crmCheckStatusEnum,
            checkRecord,
            startDate,
            endDate,
            countryId,
            provinceId,
            cityId,
            regionId,
            unitPropertyAllocationConfigId,
            unitClassConfigurationId,
            industryConfigurationId,
            unitReputationAllocationConfigId,
            biddingPlatformName,
            informantUserName
         );
      List<CrmBiddingPlatformWarehousingPageDTO> crmBiddingPlatformWarehousingPageDTOList = crmBiddingPlatformWarehousingPageDTOS.stream()
         .map(
            item -> {
               List<Long> regionIds = Arrays.asList(item.getCountryId(), item.getProvinceId(), item.getCityId(), item.getRegionId())
                  .stream()
                  .filter(Objects::nonNull)
                  .collect(Collectors.toList());
               item.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
               if (StringUtils.isNotBlank(item.getAttachmentIdsList())) {
                  item.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIdsList()));
               }

               return (CrmBiddingPlatformWarehousingPageDTO)item;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(objects, crmBiddingPlatformWarehousingPageDTOList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmBiddingPlatformWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      String biddingPlatformName,
      String informantUserName
   ) {
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousingList = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmBiddingPlatformWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmBiddingPlatformWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmBiddingPlatformWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmBiddingPlatformWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmBiddingPlatformWarehousing::getRegionId, regionId)
               .like(
                  org.apache.commons.lang3.StringUtils.isNotBlank(biddingPlatformName),
                  CrmBiddingPlatformWarehousing::getBiddingPlatformName,
                  biddingPlatformName
               )
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(informantUserName), CrmBiddingPlatformWarehousing::getInformantUserName, informantUserName)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<CrmBiddingPlatformWarehousingPageDownLoadDTO> crmBiddingPlatformWarehousingPageDownLoadDTOS = new ArrayList<>();
      crmBiddingPlatformWarehousingList.forEach(
         item -> {
            CrmBiddingPlatformWarehousingPageDownLoadDTO crmEnterpriseWarehousingPageDownLoadDTO = BeanUtil.copy(
               item, CrmBiddingPlatformWarehousingPageDownLoadDTO.class
            );
            if (item.getCountryId() != null && item.getCountryId() == 1L) {
               StringBuilder set = new StringBuilder();
               set.append(org.apache.commons.lang3.StringUtils.isNotBlank(item.getProvinceName()) ? item.getProvinceName() : "");
               set.append(org.apache.commons.lang3.StringUtils.isNotBlank(item.getCityName()) ? item.getCityName() : "");
               crmEnterpriseWarehousingPageDownLoadDTO.setProvinceNameAndCityName(set.toString());
            }

            if (item.getCrmProjectInformationWarehousingId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setCrmProjectInformationWarehousingName(
                  this.crmProjectInformationWarehousingBiz.getById(item.getCrmProjectInformationWarehousingId()).getProjectName()
               );
            }

            if (item.getCrmEnterpriseWarehousingId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setCrmEnterpriseWarehousingName(
                  this.crmEnterpriseWarehousingBiz.getById(item.getCrmEnterpriseWarehousingId()).getBusinessName()
               );
            }

            crmEnterpriseWarehousingPageDownLoadDTO.setReasonForRegistration(item.getReasonForRegistration());
            crmEnterpriseWarehousingPageDownLoadDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
            if (item.getCrmCheckStatusEnum() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setCrmCheckStatusEnumName(CrmCheckStatusEnum.getNameByType(item.getCrmCheckStatusEnum()));
            }

            crmBiddingPlatformWarehousingPageDownLoadDTOS.add(crmEnterpriseWarehousingPageDownLoadDTO);
         }
      );
      List<Map<String, Object>> collect = crmBiddingPlatformWarehousingPageDownLoadDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Transactional
   @Override
   public Boolean saveCrmBiddingPlatformWarehousing(CrmBiddingPlatformWarehousingSaveParam copy) {
      if (StringUtils.isNotBlank(copy.getBiddingPlatformName())) {
         List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
                  .eq(CrmBiddingPlatformWarehousing::getBiddingPlatformName, copy.getBiddingPlatformName())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(crmBiddingPlatformWarehousings), "当前招标平台名称已被使用");
      }

      CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = BeanUtil.copy(copy, CrmBiddingPlatformWarehousing.class);
      crmBiddingPlatformWarehousing.setSerialNumber(this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.BIDDING_PLATFORM_FILING.getType()));
      crmBiddingPlatformWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmBiddingPlatformWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      crmBiddingPlatformWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmBiddingPlatformWarehousing.setAttachmentIds(
            org.apache.commons.lang3.StringUtils.join(",", copy.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
      }

      this.baseService.save(crmBiddingPlatformWarehousing);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateCrmBiddingPlatformWarehousing(CrmBiddingPlatformWarehousingUpdateParam copy) {
      CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = this.baseService.getById(copy.getId());
      BeanUtil.copy(copy, crmBiddingPlatformWarehousing);
      crmBiddingPlatformWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(copy.getRegionList());
      crmBiddingPlatformWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      crmBiddingPlatformWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      crmBiddingPlatformWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      crmBiddingPlatformWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      crmBiddingPlatformWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      crmBiddingPlatformWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      crmBiddingPlatformWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      crmBiddingPlatformWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      this.baseService.updateById(crmBiddingPlatformWarehousing);
      return Boolean.TRUE;
   }

   @Override
   public CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetail(Long id) {
      CrmBiddingPlatformWarehousing biddingPlatformWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(biddingPlatformWarehousing != null, "招标备案不存在");
      CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetailDTO = BeanUtil.copy(
         biddingPlatformWarehousing, CrmBiddingPlatformWarehousingDetailDTO.class
      );
      if (StringUtils.isNotBlank(biddingPlatformWarehousing.getAttachmentIds())) {
         crmBiddingPlatformWarehousingDetailDTO.setAttachmentIds(this.attachmentService.listByIds(biddingPlatformWarehousing.getAttachmentIds()));
      }

      List<Long> regionIds = Arrays.asList(
            biddingPlatformWarehousing.getCountryId(),
            biddingPlatformWarehousing.getProvinceId(),
            biddingPlatformWarehousing.getCityId(),
            biddingPlatformWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmBiddingPlatformWarehousingDetailDTO.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
      return crmBiddingPlatformWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmBiddingPlatformWarehousingDetail(Long id, HttpServletResponse response) {
      CrmBiddingPlatformWarehousing biddingPlatformWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(biddingPlatformWarehousing != null, "招标备案不存在");
      String resourcePath = "files/CrmBiddingPlatformWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmBiddingPlatformWarehousingDetailTemplate";
      String exportFileName = biddingPlatformWarehousing.getBiddingPlatformName() + "招标备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(biddingPlatformWarehousing);
      if (biddingPlatformWarehousing.getDepartmentId() != null) {
         map.put("mediaTypeName", this.departmentService.getDepartmentById(biddingPlatformWarehousing.getDepartmentId()).getName());
      }

      if (Objects.equals(biddingPlatformWarehousing.getCountryId(), 1L)) {
         StringBuilder set = new StringBuilder();
         set.append(
            org.apache.commons.lang3.StringUtils.isNotBlank(biddingPlatformWarehousing.getProvinceName()) ? biddingPlatformWarehousing.getProvinceName() : ""
         );
         set.append(org.apache.commons.lang3.StringUtils.isNotBlank(biddingPlatformWarehousing.getCityName()) ? biddingPlatformWarehousing.getCityName() : "");
         map.put("provinceNameAndCityName", set.toString());
      }

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
   public HashMap<String, Integer> getCrmBiddingPlatformTaskSum() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .eq(CrmBiddingPlatformWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.TO_BE_CLAIMED.getType())
               .or()
               .eq(CrmBiddingPlatformWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.FAIL.getType())
         );
      map.put("enterprisesCount", crmBiddingPlatformWarehousings.size());
      map.put(
         "domesticEnterprisesCount",
         (int)crmBiddingPlatformWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() == 1L).count()
      );
      map.put(
         "foreignEnterprisesCount",
         (int)crmBiddingPlatformWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != 1L).count()
      );
      return map;
   }

   @Transactional
   @Override
   public Boolean overruleTask(Long id) {
      CrmBiddingPlatformWarehousing biddingPlatformWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(biddingPlatformWarehousing != null, "招标备案任务不存在");
      Preconditions.checkArgument(biddingPlatformWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.TO_BE_CLAIMED.getType()), "招标备案任务不为待领取不可驳回");
      biddingPlatformWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
      biddingPlatformWarehousing.setOverruleUserName(UserUtil.getCurrentName());
      return this.baseService.updateById(biddingPlatformWarehousing);
   }

   @Transactional
   @Override
   public Boolean caLocked(CaLockedParam caLockedParam) {
      CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = this.baseService.getById(caLockedParam.getId());
      Preconditions.checkArgument(crmBiddingPlatformWarehousing != null, "备案信息不存在");
      crmBiddingPlatformWarehousing.setCaLockDate(caLockedParam.getCaDate());
      crmBiddingPlatformWarehousing.setPlatformFees(caLockedParam.getPlatformFees());
      return this.baseService.updateById(crmBiddingPlatformWarehousing);
   }
}
