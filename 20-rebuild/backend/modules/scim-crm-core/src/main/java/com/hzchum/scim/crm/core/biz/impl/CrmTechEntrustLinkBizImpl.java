package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTechEntrustLinkBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectBidStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSettlementBusinessTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTechEntrustLink;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsApproveDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkSaveDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.service.CrmTechEntrustLinkService;
import com.hzchum.scim.crm.core.mapper.CrmTechEntrustLinkMapper;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmTechEntrustLinkBizImpl
   extends IBizImpl<CrmTechEntrustLinkService, CrmTechEntrustLinkMapper, CrmTechEntrustLink>
   implements CrmTechEntrustLinkBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private UserService userService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private SysRoleLookPermissionConfigBiz sysRoleLookPermissionConfigBiz;

   @Override
   public PageVO<CrmTechEntrustLinkListDTO> list(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmSettlementBusinessTypeEnum,
      Long crmProjectInformationWarehousingId,
      String userName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmTechEntrustLinkListDTO> list = this.baseMapper
         .list(startDate, endDate, crmSettlementBusinessTypeEnum, crmProjectInformationWarehousingId, userName, createUserName);
      return new PageVO<>(objects, list);
   }

   @Transactional
   @Override
   public Boolean delete(List<Long> id) {
      id.forEach(
         item -> {
            CrmTechEntrustLink crmTechEntrustLink = this.baseService.getById(item);
            Preconditions.checkArgument(
               crmTechEntrustLink.getCrmSubmissionStatusEnum().equals(CrmSubmissionStatusEnum.NO_REPORTED.getType()), "当前项目已存在技术服务提报不可删除!!!"
            );
            this.baseService.removeById(item);
         }
      );
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean save(CrmTechEntrustLinkSaveDTO crmTechEntrustLinkSaveDTO) {
      Preconditions.checkArgument(crmTechEntrustLinkSaveDTO.getCrmProjectInformationWarehousingId() != null, "请选择工程信息");
      CrmProjectInformationWarehousing project = this.crmProjectInformationWarehousingBiz.getOne(
         Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
            .eq(CrmProjectInformationWarehousing::getId, crmTechEntrustLinkSaveDTO.getCrmProjectInformationWarehousingId())
            .last("FOR UPDATE"));
      Preconditions.checkArgument(project != null, "工程信息不存在");
      Preconditions.checkArgument(crmTechEntrustLinkSaveDTO.getUserId() != null
         && this.userService.getById(crmTechEntrustLinkSaveDTO.getUserId()) != null, "负责人不存在");
      Preconditions.checkArgument(CrmSettlementBusinessTypeEnum.DIRECT_SALE.getType().equals(crmTechEntrustLinkSaveDTO.getCrmSettlementBusinessTypeEnum())
         || CrmSettlementBusinessTypeEnum.NON_DIRECT_SALE.getType().equals(crmTechEntrustLinkSaveDTO.getCrmSettlementBusinessTypeEnum()), "业务类型不正确");
      Preconditions.checkArgument(this.baseService.count(Wrappers.lambdaQuery(CrmTechEntrustLink.class)
         .eq(CrmTechEntrustLink::getCrmProjectInformationWarehousingId, project.getId())) == 0, "该工程已存在技术委托");
      return this.baseService
         .save(
            CrmTechEntrustLink.builder()
               .userId(crmTechEntrustLinkSaveDTO.getUserId())
               .createUserId(UserUtil.getCurrentUserId())
               .crmSubmissionStatusEnum(CrmSubmissionStatusEnum.NO_REPORTED.getType())
               .crmSettlementBusinessTypeEnum(crmTechEntrustLinkSaveDTO.getCrmSettlementBusinessTypeEnum())
               .crmProjectInformationWarehousingId(crmTechEntrustLinkSaveDTO.getCrmProjectInformationWarehousingId())
               .build()
         );
   }

   @Override
   public List<CrmTechEntrustProjectInfoDTO> listRemain() {
      List<CrmTechEntrustLink> crmTechEntrustLinks = this.baseService.list();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.PROJECT_TERMINATION.getType())
               .notIn(
                  CollectionUtils.isNotEmpty(crmTechEntrustLinks),
                  CrmProjectInformationWarehousing::getId,
                  crmTechEntrustLinks.stream().map(item -> item.getCrmProjectInformationWarehousingId()).collect(Collectors.toList())
               )
         );
      return crmProjectInformationWarehousings.stream().map(item -> {
         CrmTechEntrustProjectInfoDTO crmTechEntrustProjectInfoDTO = new CrmTechEntrustProjectInfoDTO();
         crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingId(item.getId());
         crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingName(item.getProjectName());
         crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingSerialNumber(item.getSerialNumber());
         return crmTechEntrustProjectInfoDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public List<CrmTechEntrustProjectInfoDTO> filterableProjectList() {
      List<CrmTechEntrustLink> crmTechEntrustLinks = this.baseService.list();
      if (CollectionUtils.isNotEmpty(crmTechEntrustLinks)) {
         List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .in(
                     CrmProjectInformationWarehousing::getId,
                     crmTechEntrustLinks.stream().map(item -> item.getCrmProjectInformationWarehousingId()).collect(Collectors.toList())
                  )
            );
         return crmProjectInformationWarehousings.stream().map(item -> {
            CrmTechEntrustProjectInfoDTO crmTechEntrustProjectInfoDTO = new CrmTechEntrustProjectInfoDTO();
            crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingId(item.getId());
            crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingName(item.getProjectName());
            crmTechEntrustProjectInfoDTO.setCrmProjectInformationWarehousingSerialNumber(item.getSerialNumber());
            return crmTechEntrustProjectInfoDTO;
         }).collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<CrmTechEntrustListDTO> getTechEntrustList(
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
      List<CrmTechEntrustListDTO> crmTechEntrustListDTOS = this.baseMapper
         .getTechEntrustList(crmSubmissionStatusEnum, startDate, endDate, projectName, projectNumber, UserUtil.getCurrentUserId(), crmCanLookDeptIds);
      return new PageVO<>(objects, crmTechEntrustListDTOS);
   }

   @Override
   public List<CrmSpecialProgramsDetailDTO> getSpecialProgramsDetail(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目不存在");
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(item -> item.getId(), Function.identity()));
      List<CrmSpecialProgramsDetailDTO> crmSpecialProgramsDetailDTOS = new ArrayList<>();
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .ne(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
         );
      crmApplyTechnologyBiddingRecords.forEach(item -> {
         CrmSpecialProgramsDetailDTO crmSpecialProgramsDetailDTO = new CrmSpecialProgramsDetailDTO();
         crmSpecialProgramsDetailDTO.setReportingTime(item.getCreateTime());
         crmSpecialProgramsDetailDTO.setBusinessEssentials(item.getBusinessEssentials());
         crmSpecialProgramsDetailDTO.setReportUserName(userMap.get(item.getCreateUserId()).getName());
         crmSpecialProgramsDetailDTO.setCrmSpecialBubmissionStatusEnum(item.getCrmSpecialBubmissionStatusEnum());
         crmSpecialProgramsDetailDTOS.add(crmSpecialProgramsDetailDTO);
      });
      return crmSpecialProgramsDetailDTOS;
   }

   @Transactional
   @Override
   public Boolean saveSpecialPrograms(List<CrmSpecialProgramsSaveParam> copy) {
      copy.forEach(
         item -> {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(item.getId());
            Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目不存在!!!");
            CrmTechEntrustLink crmTechEntrustLinkx = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(CrmTechEntrustLink.class)
                     .eq(CrmTechEntrustLink::getUserId, UserUtil.getCurrentUserId())
                     .eq(CrmTechEntrustLink::getCrmProjectInformationWarehousingId, item.getId())
               );
            Preconditions.checkArgument(crmTechEntrustLinkx != null, "项目暂未委托!!!");
            CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = new CrmApplyTechnologyBiddingRecord();
            crmApplyTechnologyBiddingRecord.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousing.getId());
            crmApplyTechnologyBiddingRecord.setInformantDateTime(LocalDateTime.now());
            crmApplyTechnologyBiddingRecord.setDepartmentId(UserUtil.getCurrentDepartment().getId());
            crmApplyTechnologyBiddingRecord.setCreateUserId(UserUtil.getCurrentUserId());
            crmApplyTechnologyBiddingRecord.setInformantUserId(UserUtil.getCurrentUserId());
            crmApplyTechnologyBiddingRecord.setInformantUserName(UserUtil.getCurrentUser().getName());
            crmApplyTechnologyBiddingRecord.setCrmSpecialBubmissionStatusEnum(item.getCrmSpecialBubmissionStatusEnum());
            crmApplyTechnologyBiddingRecord.setCrmSettlementBusinessTypeEnum(crmTechEntrustLinkx.getCrmSettlementBusinessTypeEnum());
            crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
            crmApplyTechnologyBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.NOT_APPOINTED.getType());
            crmApplyTechnologyBiddingRecord.setBusinessEssentials(item.getBusinessEssentials());
            this.crmApplyTechnologyBiddingRecordBiz.save(crmApplyTechnologyBiddingRecord);
            WmsApproveRecord record = this.wmsApproveRecordService
               .createRecord(
                  crmApplyTechnologyBiddingRecord.getId(),
                  crmProjectInformationWarehousing.getProjectName(),
                  crmTechEntrustLinkx.getCrmSettlementBusinessTypeEnum().equals(CrmSettlementBusinessTypeEnum.DIRECT_SALE.getType())
                     ? ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_DIRECT_BIDDING.getType()
                     : ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_NON_DIRECT_BIDDING.getType(),
                  null,
                  null,
                  null,
                  false,
                  null,
                  null,
                  null
               );
            CrmApplyTechnologyBiddingRecord forBidRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(crmApplyTechnologyBiddingRecord.getId());
            forBidRecord.setApproveRecordId(record.getId());
            if (record.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
               forBidRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            }

            this.crmApplyTechnologyBiddingRecordBiz.updateById(forBidRecord);
         }
      );
      CrmTechEntrustLink crmTechEntrustLink = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmTechEntrustLink.class)
               .eq(CrmTechEntrustLink::getUserId, UserUtil.getCurrentUserId())
               .eq(CrmTechEntrustLink::getCrmProjectInformationWarehousingId, copy.get(0).getId())
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmTechEntrustLink.getCrmProjectInformationWarehousingId())
               .ne(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
         );
      Map<Integer, List<CrmApplyTechnologyBiddingRecord>> map = crmApplyTechnologyBiddingRecords.stream()
         .collect(Collectors.groupingBy(item -> item.getCrmSpecialBubmissionStatusEnum()));
      if (map.size() == CrmSpecialBubmissionStatusEnum.values().length - 1) {
         crmTechEntrustLink.setCrmSubmissionStatusEnum(CrmSubmissionStatusEnum.REPORTED.getType());
      } else {
         crmTechEntrustLink.setCrmSubmissionStatusEnum(CrmSubmissionStatusEnum.PARTIAL_SUBMISSION.getType());
      }

      this.baseService.updateById(crmTechEntrustLink);
      return Boolean.TRUE;
   }

   @Override
   public Boolean specialProgramsApprove(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(crmAuditCommonDTO.getDataId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord);
      }

      return Boolean.TRUE;
   }

   @Override
   public CrmSpecialProgramsApproveDetailDTO getSpecialProgramsApproveDetail(Long id) {
      CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(id);
      Preconditions.checkArgument(crmApplyTechnologyBiddingRecord != null, "专项方案不存在!!!");
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmApplyTechnologyBiddingRecord.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目信息不存在!!!");
      CrmSpecialProgramsApproveDetailDTO crmSpecialProgramsApproveDetailDTO = new CrmSpecialProgramsApproveDetailDTO();
      crmSpecialProgramsApproveDetailDTO.setId(crmApplyTechnologyBiddingRecord.getId());
      crmSpecialProgramsApproveDetailDTO.setSerialNumber(crmProjectInformationWarehousing.getSerialNumber());
      crmSpecialProgramsApproveDetailDTO.setInformantDateTime(crmProjectInformationWarehousing.getInformantDateTime());
      crmSpecialProgramsApproveDetailDTO.setProjectName(crmProjectInformationWarehousing.getProjectName());
      crmSpecialProgramsApproveDetailDTO.setCrmEnterpriseWarehousingName(
         crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null
            ? this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
            : null
      );
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
      stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
      stringBuilder.append(crmProjectInformationWarehousing.getCityName());
      stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
      crmSpecialProgramsApproveDetailDTO.setRegionNames(stringBuilder.toString());
      if (crmProjectInformationWarehousing.getStructureTypeConfigurationId() != null) {
         crmSpecialProgramsApproveDetailDTO.setStructureTypeConfigurationName(
            this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getStructureTypeConfigurationId()).getName()
         );
      }

      crmSpecialProgramsApproveDetailDTO.setEstimatedCost(crmProjectInformationWarehousing.getEstimatedCost());
      crmSpecialProgramsApproveDetailDTO.setDepartmentName(
         crmProjectInformationWarehousing.getDepartmentId() != null
            ? this.departmentService.getDepartmentById(crmProjectInformationWarehousing.getDepartmentId()).getName()
            : null
      );
      crmSpecialProgramsApproveDetailDTO.setInformantUserName(
         crmProjectInformationWarehousing.getInformantUserId() != null
            ? this.userService.getById(crmProjectInformationWarehousing.getInformantUserId()).getName()
            : null
      );
      crmSpecialProgramsApproveDetailDTO.setCrmSettlementBusinessTypeEnum(crmApplyTechnologyBiddingRecord.getCrmSettlementBusinessTypeEnum());
      crmSpecialProgramsApproveDetailDTO.setCrmSpecialBubmissionStatusEnum(crmApplyTechnologyBiddingRecord.getCrmSpecialBubmissionStatusEnum());
      crmSpecialProgramsApproveDetailDTO.setBusinessEssentials(crmApplyTechnologyBiddingRecord.getBusinessEssentials());
      return crmSpecialProgramsApproveDetailDTO;
   }

   @Override
   public Boolean specialProgramsCancel(Long id) {
      CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(id);
      Preconditions.checkArgument(crmApplyTechnologyBiddingRecord != null, "委托申请不存在!!!");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmApplyTechnologyBiddingRecord.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目审批不存在");
      wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      this.crmApplyTechnologyBiddingRecordBiz.removeById(crmApplyTechnologyBiddingRecord.getId());
      this.wmsApproveRecordService.updateById(wmsApproveRecord);
      this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
      return Boolean.TRUE;
   }
}
