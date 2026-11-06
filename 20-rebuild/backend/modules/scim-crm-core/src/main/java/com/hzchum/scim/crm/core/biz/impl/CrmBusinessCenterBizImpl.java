package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessCenterBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmInformationValidityPeriodConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmInformationValidityPeriodConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectInformationConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmRecordTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmGovernmentWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPrequalificationRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCenterProjectListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectFollowUpRecordDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheNumberOfCustomProjectConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmprojectInformationWarehousingFollowUpTimesAndDateDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.ProjectPublicPoolDTO;
import com.hzchum.scim.crm.core.api.pojo.param.ProjectAssignmentParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectTerminatedUpdateDTO;
import com.hzchum.scim.crm.core.mapper.CrmBusinessCenterMapper;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmBusinessCenterBizImpl implements CrmBusinessCenterBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;
   @Resource
   private CrmInformationValidityPeriodConfigBiz crmInformationValidityPeriodConfigBiz;
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private CrmPrequalificationRecordBiz crmPrequalificationRecordBiz;
   @Resource
   private CrmBusinessCenterMapper crmBusinessCenterMapper;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private UserService userService;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   private SysRoleLookPermissionConfigBiz sysRoleLookPermissionConfigBiz;
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;

   @Override
   public PageVO<ProjectPublicPoolDTO> getProjectPublicPoolAPP(
      Long projectLevelConfigId, LocalDate startDate, LocalDate endDate, String projectName, Integer pageNumber, Integer pageSize
   ) {
      List<Integer> crmProjectScheduleTypeEnumList = new ArrayList<>();
      crmProjectScheduleTypeEnumList.add(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType());
      crmProjectScheduleTypeEnumList.add(CrmProjectScheduleTypeEnum.PROJECT_TERMINATION.getType());
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(projectLevelConfigId != null, CrmProjectInformationWarehousing::getProjectLevelConfigId, projectLevelConfigId)
               .like(StringUtils.isNotBlank(projectName), CrmProjectInformationWarehousing::getProjectName, projectName)
               .apply(endDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') <= {0}", endDate)
               .apply(startDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') >= {0}", startDate)
               .in(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, crmProjectScheduleTypeEnumList)
               .orderByDesc(BaseEntity::getUpdateTime)
         );
      Map<Long, CrmProjectInformationConfig> informationConfigMap = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      Map<Long, List<CrmProjectFollowUpRecord>> map = this.crmProjectFollowUpRecordBiz
         .list()
         .stream()
         .collect(Collectors.groupingBy(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId));
      return new PageVO<>(
         objects,
         crmProjectInformationWarehousingList.stream()
            .map(
               item -> {
                  ProjectPublicPoolDTO build = ProjectPublicPoolDTO.builder()
                     .id(item.getId())
                     .crmProjectScheduleTypeEnum(item.getCrmProjectScheduleTypeEnum())
                     .crmProjectScheduleTypeEnumName(CrmProjectScheduleTypeEnum.getNameByType(item.getCrmProjectScheduleTypeEnum()))
                     .projectName(item.getProjectName())
                     .serialNumber(item.getSerialNumber())
                     .informantDateTime(item.getInformantDateTime())
                     .projectLevelConfigName(
                        informationConfigMap.get(item.getProjectLevelConfigId()) != null
                           ? informationConfigMap.get(item.getProjectLevelConfigId()).getName()
                           : null
                     )
                     .build();
                  List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = map.get(item.getId());
                  if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords)) {
                     build.setFollowUpTimes(crmProjectFollowUpRecords.size());
                  }

                  return build;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<ProjectPublicPoolDTO> getProjectPublicPool(
      Long projectLevelConfigId, LocalDate startDate, LocalDate endDate, String projectName, Integer pageNumber, Integer pageSize
   ) {
      List<Integer> crmProjectScheduleTypeEnumList = new ArrayList<>();
      crmProjectScheduleTypeEnumList.add(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType());
      crmProjectScheduleTypeEnumList.add(CrmProjectScheduleTypeEnum.PROJECT_TERMINATION.getType());
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(projectLevelConfigId != null, CrmProjectInformationWarehousing::getProjectLevelConfigId, projectLevelConfigId)
               .like(StringUtils.isNotBlank(projectName), CrmProjectInformationWarehousing::getProjectName, projectName)
               .apply(endDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') <= {0}", endDate)
               .apply(startDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') >= {0}", startDate)
               .in(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, crmProjectScheduleTypeEnumList)
               .orderByDesc(BaseEntity::getUpdateTime)
         );
      Map<Long, CrmProjectInformationConfig> informationConfigMap = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      Map<Long, List<CrmProjectFollowUpRecord>> map = this.crmProjectFollowUpRecordBiz
         .list()
         .stream()
         .collect(Collectors.groupingBy(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId));
      return crmProjectInformationWarehousingList.stream()
         .map(
            item -> {
               ProjectPublicPoolDTO build = ProjectPublicPoolDTO.builder()
                  .id(item.getId())
                  .crmProjectScheduleTypeEnum(item.getCrmProjectScheduleTypeEnum())
                  .crmProjectScheduleTypeEnumName(CrmProjectScheduleTypeEnum.getNameByType(item.getCrmProjectScheduleTypeEnum()))
                  .projectName(item.getProjectName())
                  .serialNumber(item.getSerialNumber())
                  .informantDateTime(item.getInformantDateTime())
                  .projectLevelConfigName(
                     informationConfigMap.get(item.getProjectLevelConfigId()) != null
                        ? informationConfigMap.get(item.getProjectLevelConfigId()).getName()
                        : null
                  )
                  .build();
               List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = map.get(item.getId());
               if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords)) {
                  build.setFollowUpTimes(crmProjectFollowUpRecords.size());
               }

               return build;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean assignmentProject(ProjectAssignmentParam projectAssignmentParam) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(projectAssignmentParam.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案信息不存在");
      Preconditions.checkArgument(
         projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
            || projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.PROJECT_TERMINATION.getType()),
         "项目备案状态不为失效不可进行重新分配"
      );
      CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.crmInformationValidityPeriodConfigBiz
         .getOne(
            Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
               .eq(
                  CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                  CrmInformationValidityPeriodConfigEnum.NUMBER_OF_PROJECT_QUOTA_ALLOCATION.getType()
               )
         );
      Preconditions.checkArgument(crmInformationValidityPeriodConfig != null, "请先配置项目名额数量");
      List<CrmTheNumberOfCustomProjectConfigDTO> crmTheNumberOfCustomProjectConfigDTOS = this.crmProjectInformationConfigBiz
         .customQuantityList(projectAssignmentParam.getUserId());
      if (CollectionUtil.isNotEmpty(crmTheNumberOfCustomProjectConfigDTOS)) {
         crmInformationValidityPeriodConfig.setProjectQuota(crmTheNumberOfCustomProjectConfigDTOS.get(0).getProjectQuota());
      }

      CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig1 = this.crmInformationValidityPeriodConfigBiz
         .getOne(
            Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
               .eq(
                  CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                  CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
               )
         );
      Preconditions.checkArgument(crmInformationValidityPeriodConfig1 != null, "请先配置项目信息登记有效期");
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, projectAssignmentParam.getUserId())
               .notIn(
                  CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                  CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType(),
                  CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType(),
                  CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
               )
               .notIn(
                  CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.FAIL.getType(), CrmCheckStatusEnum.TEMPORARY_STORAGE.getType()
               )
         );
      int[] count = new int[]{0};
      if (CollectionUtil.isNotEmpty(crmProjectInformationWarehousings)) {
         int[] size = new int[]{crmProjectInformationWarehousings.size()};
         crmProjectInformationWarehousings.forEach(
            item -> {
               boolean flag = false;
               if (!flag) {
                  List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                           .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                           .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, item.getId())
                     );
                  if (CollectionUtil.isNotEmpty(crmApplyBusinessBiddingRecords)) {
                     flag = true;
                  }
               }

               if (!flag) {
                  List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                           .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                           .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, item.getId())
                     );
                  if (CollectionUtil.isNotEmpty(crmApplyTechnologyBiddingRecords)) {
                     flag = true;
                  }
               }

               if (!flag) {
                  List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                           .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                           .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, item.getId())
                     );
                  if (CollectionUtil.isNotEmpty(crmApplyStructuralDesignBiddingRecords)) {
                     flag = true;
                  }
               }

               if (!flag) {
                  List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                           .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                           .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, item.getId())
                     );
                  if (CollectionUtil.isNotEmpty(crmApplyDeepDesignBiddingRecords)) {
                     flag = true;
                  }
               }

               if (flag) {
                  size[0]--;
               }

               count[0] = size[0];
            }
         );
         Preconditions.checkArgument(crmInformationValidityPeriodConfig.getProjectQuota() > count[0], "当前无项目名额请先完成手上项目");
      }

      projectInformationWarehousing.setInformationOperatorUserId(projectAssignmentParam.getUserId());
      projectInformationWarehousing.setInformantUserId(projectAssignmentParam.getUserId());
      User user = this.userService.getById(projectAssignmentParam.getUserId());
      projectInformationWarehousing.setInformantUserName(user.getName());
      if (user.getDepartmentId() != null) {
         projectInformationWarehousing.setInformationOperatorDeptId(user.getDepartmentId());
      }

      projectInformationWarehousing.setValidityOfRegistration(crmInformationValidityPeriodConfig1.getValidityOfRegistration());
      projectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.FILING_STATUS.getType());
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
               .eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, projectAssignmentParam.getCrmProjectInformationWarehousingId())
         );
      if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords)) {
         crmProjectFollowUpRecords.forEach(
            item -> {
               this.wmsApproveRecordService
                  .remove(
                     Wrappers.lambdaQuery(WmsApproveRecord.class)
                        .eq(WmsApproveRecord::getDataId, item.getId())
                        .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.CRM_PROJECT_FOLLOW_UP.getType())
                  );
               this.wmsApproveRecordDetailService
                  .remove(
                     Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                        .eq(WmsApproveRecordDetail::getDataId, item.getId())
                        .eq(WmsApproveRecordDetail::getApproveProcessType, ApproveProcessTypeEnumV2.CRM_PROJECT_FOLLOW_UP.getType())
                  );
               this.crmProjectFollowUpRecordBiz.removeById(item.getId());
            }
         );
      }

      projectInformationWarehousing.setLastDistributionTime(LocalDateTime.now());
      return this.crmProjectInformationWarehousingBiz.updateById(projectInformationWarehousing);
   }

   @Override
   public HashMap<String, Object> summary() {
      HashMap<String, Object> map = new HashMap<>();
      map.put("numberOfIcpFilingsCount", 0);
      map.put("numberOfIcpFilingsCountByThisMonth", 0);
      map.put("projectFollowUpCount", 0);
      map.put("projectFollowUpCountByThisMonth", 0);
      map.put("preQualificationCount", 0);
      map.put("preQualificationCountByThisMonth", 0);
      map.put("biddingRegistrationCount", 0);
      map.put("biddingRegistrationCountByThisMonth", 0);
      map.put("winningBidCount", 0);
      map.put("WinningRate", 0);
      Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      new ArrayList();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings;
      if (CollectionUtil.isEmpty(crmCanLookInfoDeptIdsByModuleAndUserId)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
            );
      } else if (crmCanLookInfoDeptIdsByModuleAndUserId.contains(0L)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .and(qr -> {
                     qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId);
                     qr.or();
                     qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                  })
            );
      } else {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId)
            );
      }

      if (CollectionUtils.isNotEmpty(crmProjectInformationWarehousings)) {
         int monthValue = LocalDate.now().getMonth().getValue();
         map.put("numberOfIcpFilingsCount", crmProjectInformationWarehousings.size());
         map.put(
            "numberOfIcpFilingsCountByThisMonth",
            (int)crmProjectInformationWarehousings.stream().filter(item -> item.getCreateTime().getMonth().getValue() == monthValue).count()
         );
         List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
                  .eq(CrmProjectFollowUpRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .in(
                     CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId,
                     crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords)) {
            map.put("projectFollowUpCount", crmProjectFollowUpRecords.size());
            map.put(
               "projectFollowUpCountByThisMonth",
               (int)crmProjectFollowUpRecords.stream().filter(item -> item.getCreateTime().getMonth().getValue() == monthValue).count()
            );
         }

         List<CrmPrequalificationRecord> crmPrequalificationRecords = this.crmPrequalificationRecordBiz
            .list(
               Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
                  .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .in(
                     CrmPrequalificationRecord::getCrmProjectInformationWarehousingId,
                     crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(crmPrequalificationRecords)) {
            map.put("preQualificationCount", crmPrequalificationRecords.size());
            map.put(
               "preQualificationCountByThisMonth",
               (int)crmPrequalificationRecords.stream().filter(item -> item.getCreateTime().getMonth().getValue() == monthValue).count()
            );
         }

         List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
            .list(
               Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
                  .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .in(
                     CrmApplyForBidRecord::getCrmProjectInformationWarehousingId,
                     crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(crmApplyForBidRecords)) {
            map.put("biddingRegistrationCount", crmApplyForBidRecords.size());
            map.put(
               "biddingRegistrationCountByThisMonth",
               (int)crmApplyForBidRecords.stream().filter(item -> item.getCreateTime().getMonth().getValue() == monthValue).count()
            );
         }

         map.put(
            "winningBidCount",
            crmProjectInformationWarehousings.stream()
               .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
               .collect(Collectors.toList())
               .size()
         );
         map.put(
            "WinningRate",
            BigDecimal.valueOf(
                  crmProjectInformationWarehousings.stream()
                     .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                     .collect(Collectors.toList())
                     .size()
               )
               .divide(BigDecimal.valueOf(crmProjectInformationWarehousings.size()), 4, RoundingMode.HALF_UP)
               .multiply(BigDecimal.valueOf(100L))
         );
      }

      return map;
   }

   @Override
   public PageVO<CrmCenterProjectListDTO> centerProjectList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmCenterProjectListDTO> list = this.crmBusinessCenterMapper
         .getCrmCenterProjectList(
            startDate,
            endDate,
            countryId,
            provinceId,
            cityId,
            regionId,
            structureTypeConfigurationId,
            departmentIds,
            projectName,
            informantUserName,
            crmEnterpriseWarehousingName,
            UserUtil.getCurrentUserId(),
            crmCanLookDeptIds
         );
      list.forEach(this::applyProjectListDisplayFields);
      return new PageVO<>(objects, list);
   }

   private void applyProjectListDisplayFields(CrmCenterProjectListDTO item) {
      StringBuilder region = new StringBuilder();
      region.append(item.getCountryName());
      region.append(item.getProvinceName());
      region.append(item.getCityName());
      region.append(item.getRegionName());
      item.setRegionNameList(region.toString());

      Integer stage = item.getCrmProjectScheduleTypeEnum();
      if (item.getValidityOfRegistration() != null
         && !CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType().equals(stage)
         && !CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType().equals(stage)) {
         CrmprojectInformationWarehousingFollowUpTimesAndDateDTO followUp = this.crmProjectFollowUpRecordBiz.getFollowUpTimesAndDate(item.getId());
         Integer remaining = followUp.getEffectiveRemainingTime();
         item.setValidityOfRegistration(remaining != null ? remaining : 0);
         item.setValidityOfRegistrationDate(LocalDate.now().plusDays(item.getValidityOfRegistration().intValue()));
      }
   }

   @Override
   public List<CrmProjectFollowUpRecordDTO> getFollowUpRecord(Long crmProjectInformationWarehousingId) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
               .eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
         );
      Map<Long, CrmProjectInformationConfig> informationConfigMap = this.crmProjectInformationConfigBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
               .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, CrmProjectInformationConfigEnum.FOLLOW_UP_METHODS.getType())
         )
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      return crmProjectFollowUpRecords.stream().map(item -> {
         CrmProjectFollowUpRecordDTO crmProjectFollowUpRecordDTO = new CrmProjectFollowUpRecordDTO();
         BeanUtils.copyProperties(item, crmProjectFollowUpRecordDTO);
         crmProjectFollowUpRecordDTO.setFollowUpMethodsName(informationConfigMap.get(item.getFollowUpMethods()).getName());
         crmProjectFollowUpRecordDTO.setFollowUpAttachment(this.attachmentService.listByIds(item.getFollowUpAttachment()));
         return crmProjectFollowUpRecordDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public HashMap<String, Integer> getEnterpriseSummary() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz.list();
      map.put("enterprisesCount", crmEnterpriseWarehousings.size());
      map.put(
         "domesticEnterprisesCount",
         (int)crmEnterpriseWarehousings.stream()
            .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() == 1L)
            .count()
      );
      map.put(
         "foreignEnterprisesCount",
         (int)crmEnterpriseWarehousings.stream()
            .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() != 1L)
            .count()
      );
      return map;
   }

   @Override
   public PageVO<CrmEnterpriseWarehousingPageDTO> getCrmEnterpriseWarehousingPage(
      Integer crmCheckStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmEnterpriseWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmEnterpriseWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmEnterpriseWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmEnterpriseWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmEnterpriseWarehousing::getRegionId, regionId)
               .eq(unitPropertyAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitPropertyAllocationConfigId, unitPropertyAllocationConfigId)
               .eq(unitClassConfigurationId != null, CrmEnterpriseWarehousing::getUnitClassConfigurationId, unitClassConfigurationId)
               .eq(industryConfigurationId != null, CrmEnterpriseWarehousing::getIndustryConfigurationId, industryConfigurationId)
               .eq(unitReputationAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitReputationAllocationConfigId, unitReputationAllocationConfigId)
               .like(StringUtils.isNotBlank(businessName), CrmEnterpriseWarehousing::getBusinessName, businessName)
               .like(StringUtils.isNotBlank(creditCode), CrmEnterpriseWarehousing::getCreditCode, creditCode)
               .like(StringUtils.isNotBlank(informantUserName), CrmEnterpriseWarehousing::getInformantUserName, informantUserName)
               .orderByDesc(CrmEnterpriseWarehousing::getInformantDateTime)
         );
      Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      return new PageVO<>(
         objects,
         crmEnterpriseWarehousings.stream()
            .map(
               item -> {
                  CrmEnterpriseWarehousingPageDTO crmEnterpriseWarehousingPageDTO = BeanUtil.copy(item, CrmEnterpriseWarehousingPageDTO.class);
                  if (item.getUnitPropertyAllocationConfigId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitPropertyAllocationConfigName(
                        basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName()
                     );
                  }

                  if (item.getUnitClassConfigurationId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
                  }

                  if (item.getIndustryConfigurationId() != null) {
                     crmEnterpriseWarehousingPageDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
                  }

                  if (item.getUnitReputationAllocationConfigId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitReputationAllocationConfigName(
                        basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
                     );
                  }

                  if (item.getInformantUserId() != null) {
                     crmEnterpriseWarehousingPageDTO.setInformantUserName(
                        userMap.get(item.getInformantUserId()) != null ? userMap.get(item.getInformantUserId()).getName() : null
                     );
                  }

                  if (item.getCreateUserId() != null) {
                     crmEnterpriseWarehousingPageDTO.setCreateUserName(
                        userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                     );
                  }

                  return crmEnterpriseWarehousingPageDTO;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetail(Long id) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "企业备案信息不存在");
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetailDTO = BeanUtil.copy(crmEnterpriseWarehousing, CrmEnterpriseWarehousingDetailDTO.class);
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmEnterpriseWarehousing.getAttachmentIds())) {
         crmEnterpriseWarehousingDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmEnterpriseWarehousing.getAttachmentIds()));
      }

      if (crmEnterpriseWarehousingDetailDTO.getDepartmentId() != null) {
         crmEnterpriseWarehousingDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(crmEnterpriseWarehousingDetailDTO.getDepartmentId()).getName()
         );
      }

      if (crmEnterpriseWarehousingDetailDTO.getUnitPropertyAllocationConfigId() != null) {
         crmEnterpriseWarehousingDetailDTO.setUnitPropertyAllocationConfigName(
            basicsConfigMap.get(crmEnterpriseWarehousingDetailDTO.getUnitPropertyAllocationConfigId()).getName()
         );
      }

      if (crmEnterpriseWarehousingDetailDTO.getUnitClassConfigurationId() != null) {
         crmEnterpriseWarehousingDetailDTO.setUnitClassConfigurationName(
            basicsConfigMap.get(crmEnterpriseWarehousingDetailDTO.getUnitClassConfigurationId()).getName()
         );
      }

      if (crmEnterpriseWarehousingDetailDTO.getIndustryConfigurationId() != null) {
         crmEnterpriseWarehousingDetailDTO.setIndustryConfigurationName(
            basicsConfigMap.get(crmEnterpriseWarehousingDetailDTO.getIndustryConfigurationId()).getName()
         );
      }

      if (crmEnterpriseWarehousingDetailDTO.getUnitReputationAllocationConfigId() != null) {
         crmEnterpriseWarehousingDetailDTO.setUnitReputationAllocationConfigName(
            basicsConfigMap.get(crmEnterpriseWarehousingDetailDTO.getUnitReputationAllocationConfigId()).getName()
         );
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmEnterpriseWarehousing.getCountryName());
      stringBuilder.append(crmEnterpriseWarehousing.getProvinceName());
      stringBuilder.append(crmEnterpriseWarehousing.getCityName());
      stringBuilder.append(crmEnterpriseWarehousing.getRegionName());
      crmEnterpriseWarehousingDetailDTO.setRegionNameList(stringBuilder.toString());
      return crmEnterpriseWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "企业备案不存在");
      String resourcePath = "files/CrmEnterpriseWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmEnterpriseWarehousingDetailTemplate";
      String exportFileName = crmEnterpriseWarehousing.getBusinessName() + "企业备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmEnterpriseWarehousing);
      if (crmEnterpriseWarehousing.getDepartmentId() != null) {
         map.put("departmentName", this.departmentService.getDepartmentById(crmEnterpriseWarehousing.getDepartmentId()).getName());
      }

      if (crmEnterpriseWarehousing.getCountryId() == 1L) {
         StringBuilder set = new StringBuilder();
         set.append(StringUtils.isNotBlank(crmEnterpriseWarehousing.getProvinceName()) ? crmEnterpriseWarehousing.getProvinceName() : "");
         set.append(StringUtils.isNotBlank(crmEnterpriseWarehousing.getCityName()) ? crmEnterpriseWarehousing.getCityName() : "");
         map.put("provinceNameAndCityName", set.toString());
      }

      if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
         map.put("unitPropertyAllocationConfigName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName());
      }

      if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
         map.put("unitClassConfigurationName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
      }

      if (crmEnterpriseWarehousing.getIndustryConfigurationId() != null) {
         map.put("industryConfigurationName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getIndustryConfigurationId()).getName());
      }

      if (crmEnterpriseWarehousing.getUnitReputationAllocationConfigId() != null) {
         map.put(
            "unitReputationAllocationConfigName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitReputationAllocationConfigId()).getName()
         );
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
   public PrintVO<List<Map<String, Object>>> downLoadCrmEnterpriseWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   ) {
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmEnterpriseWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmEnterpriseWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmEnterpriseWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmEnterpriseWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmEnterpriseWarehousing::getRegionId, regionId)
               .eq(unitPropertyAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitPropertyAllocationConfigId, unitPropertyAllocationConfigId)
               .eq(unitClassConfigurationId != null, CrmEnterpriseWarehousing::getUnitClassConfigurationId, unitClassConfigurationId)
               .eq(industryConfigurationId != null, CrmEnterpriseWarehousing::getIndustryConfigurationId, industryConfigurationId)
               .eq(unitReputationAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitReputationAllocationConfigId, unitReputationAllocationConfigId)
               .like(StringUtils.isNotBlank(businessName), CrmEnterpriseWarehousing::getBusinessName, businessName)
               .like(StringUtils.isNotBlank(creditCode), CrmEnterpriseWarehousing::getCreditCode, creditCode)
               .like(StringUtils.isNotBlank(informantUserName), CrmEnterpriseWarehousing::getInformantUserName, informantUserName)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      List<CrmEnterpriseWarehousingPageDTO> crmEnterpriseWarehousingPageDTOS = crmEnterpriseWarehousings.stream()
         .map(
            item -> {
               CrmEnterpriseWarehousingPageDTO crmEnterpriseWarehousingPageDTO = BeanUtil.copy(item, CrmEnterpriseWarehousingPageDTO.class);
               if (item.getUnitPropertyAllocationConfigId() != null) {
                  crmEnterpriseWarehousingPageDTO.setUnitPropertyAllocationConfigName(basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName());
               }

               if (item.getUnitClassConfigurationId() != null) {
                  crmEnterpriseWarehousingPageDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
               }

               if (item.getIndustryConfigurationId() != null) {
                  crmEnterpriseWarehousingPageDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
               }

               if (item.getUnitReputationAllocationConfigId() != null) {
                  crmEnterpriseWarehousingPageDTO.setUnitReputationAllocationConfigName(
                     basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
                  );
               }

               if (item.getInformantUserId() != null) {
                  crmEnterpriseWarehousingPageDTO.setInformantUserName(
                     userMap.get(item.getInformantUserId()) != null ? userMap.get(item.getInformantUserId()).getName() : null
                  );
               }

               if (item.getCreateUserId() != null) {
                  crmEnterpriseWarehousingPageDTO.setCreateUserName(
                     userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                  );
               }

               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(item.getCountryName());
               stringBuilder.append(item.getProvinceName());
               stringBuilder.append(item.getCityName());
               stringBuilder.append(item.getRegionName());
               crmEnterpriseWarehousingPageDTO.setRegionNameList(stringBuilder.toString());
               return crmEnterpriseWarehousingPageDTO;
            }
         )
         .collect(Collectors.toList());
      List<Map<String, Object>> collect = crmEnterpriseWarehousingPageDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public HashMap<String, Integer> supplierSummary() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getCrmRecordTypeEnum, CrmRecordTypeEnum.RECORD.getType()));
      if (CollectionUtils.isNotEmpty(crmSupplierWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
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

   @Override
   public PageVO<CrmSupplierWarehousingPageDTO> getCrmSupplierWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmSupplierWarehousingPageDTO> crmSupplierWarehousingPageDTOS = this.crmBusinessCenterMapper
         .getCrmSupplierWarehousingPage(
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
            businessName,
            creditCode,
            informantUserName
         );
      crmSupplierWarehousingPageDTOS.stream().forEach(item -> {
         if (StringUtils.isNotBlank(item.getAttachmentIdsByString())) {
            item.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIdsByString()));
         }
      });
      return new PageVO<>(objects, crmSupplierWarehousingPageDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmSupplierWarehousingList(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   ) {
      List<CrmSupplierWarehousingPageDTO> crmSupplierWarehousingPageDTOS = this.crmBusinessCenterMapper
         .getCrmSupplierWarehousingPage(
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
            businessName,
            creditCode,
            informantUserName
         );
      crmSupplierWarehousingPageDTOS.stream().forEach(item -> {
         if (StringUtils.isNotBlank(item.getAttachmentIdsByString())) {
            item.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIdsByString()));
         }

         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(item.getCountryName());
         stringBuilder.append(item.getProvinceName());
         stringBuilder.append(item.getCityName());
         stringBuilder.append(item.getRegionName());
         item.setRegionNameList(stringBuilder.toString());
      });
      List<Map<String, Object>> collect = crmSupplierWarehousingPageDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetail(Long id) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.crmSupplierWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "供应商备案不存在");
      CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetailDTO = BeanUtil.copy(crmSupplierWarehousing, CrmSupplierWarehousingDetailDTO.class);
      Map<Long, CrmBasicsConfig> configMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (crmSupplierWarehousingDetailDTO.getInformantUserId() != null) {
         crmSupplierWarehousingDetailDTO.setInformantUserName(userMap.get(crmSupplierWarehousingDetailDTO.getInformantUserId()).getName());
      }

      if (crmSupplierWarehousingDetailDTO.getDepartmentId() != null) {
         crmSupplierWarehousingDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(crmSupplierWarehousingDetailDTO.getDepartmentId()).getName()
         );
      }

      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmSupplierWarehousing.getCrmEnterpriseWarehousingId());
      if (crmEnterpriseWarehousing != null) {
         crmSupplierWarehousingDetailDTO.setBusinessName(crmEnterpriseWarehousing.getBusinessName());
         crmSupplierWarehousingDetailDTO.setCrmEnterpriseWarehousingId(crmEnterpriseWarehousing.getId());
         crmSupplierWarehousingDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         crmSupplierWarehousingDetailDTO.setCreditCode(crmEnterpriseWarehousing.getCreditCode());
         crmSupplierWarehousingDetailDTO.setQualificationAndAbility(crmEnterpriseWarehousing.getQualificationAndAbility());
         crmSupplierWarehousingDetailDTO.setBusinessPhone(crmEnterpriseWarehousing.getBusinessPhone());
         crmSupplierWarehousingDetailDTO.setBusinessEmail(crmEnterpriseWarehousing.getBusinessEmail());
         crmSupplierWarehousingDetailDTO.setAddress(crmEnterpriseWarehousing.getAddress());
         crmSupplierWarehousingDetailDTO.setLiaisons(crmEnterpriseWarehousing.getLiaisons());
         if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
            crmSupplierWarehousingDetailDTO.setUnitClassConfigurationId(crmEnterpriseWarehousing.getUnitClassConfigurationId());
            crmSupplierWarehousingDetailDTO.setUnitClassConfigurationName(configMap.get(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
         }

         if (crmEnterpriseWarehousing.getIndustryConfigurationId() != null) {
            crmSupplierWarehousingDetailDTO.setIndustryConfigurationId(crmEnterpriseWarehousing.getIndustryConfigurationId());
            crmSupplierWarehousingDetailDTO.setIndustryConfigurationName(configMap.get(crmEnterpriseWarehousing.getIndustryConfigurationId()).getName());
         }

         if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
            crmSupplierWarehousingDetailDTO.setUnitPropertyAllocationConfigId(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId());
            crmSupplierWarehousingDetailDTO.setUnitPropertyAllocationConfigName(
               configMap.get(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName()
            );
         }
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmSupplierWarehousing.getCountryName());
      stringBuilder.append(crmSupplierWarehousing.getProvinceName());
      stringBuilder.append(crmSupplierWarehousing.getCityName());
      stringBuilder.append(crmSupplierWarehousing.getRegionName());
      crmSupplierWarehousingDetailDTO.setRegionNameList(stringBuilder.toString());
      if (StringUtils.isNotBlank(crmSupplierWarehousing.getAttachmentIds())) {
         crmSupplierWarehousingDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmSupplierWarehousing.getAttachmentIds()));
      }

      return crmSupplierWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.crmSupplierWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "供应商备案不存在");
      CrmEnterpriseWarehousing enterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmSupplierWarehousing.getCrmEnterpriseWarehousingId());
      String resourcePath = "files/CrmSupplierWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmSupplierWarehousingDetailTemplate";
      String exportFileName = enterpriseWarehousing.getBusinessName() + "供应商备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmSupplierWarehousing);
      map.put("informantUserName", this.userService.getById(crmSupplierWarehousing.getInformantUserId()).getName());
      map.put("departmentName", this.departmentService.getDepartmentById(crmSupplierWarehousing.getDepartmentId()).getName());
      map.put("crmEnterpriseWarehousingName", enterpriseWarehousing.getBusinessName());
      Map<Long, CrmBasicsConfig> configMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      if (configMap.get(enterpriseWarehousing.getUnitPropertyAllocationConfigId()) != null) {
         map.put("reasonForRegistration", configMap.get(enterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName());
      }
      if (configMap.get(enterpriseWarehousing.getUnitClassConfigurationId()) != null) {
         map.put("unitClassConfigurationName", configMap.get(enterpriseWarehousing.getUnitClassConfigurationId()).getName());
      }
      map.put("countryName", crmSupplierWarehousing.getCountryName());
      map.put(
         "provinceNameAndCityName", crmSupplierWarehousing.getProvinceName() + crmSupplierWarehousing.getCityName() + crmSupplierWarehousing.getRegionName()
      );
      map.put("address", enterpriseWarehousing.getAddress());
      map.put("creditCode", enterpriseWarehousing.getCreditCode());
      if (configMap.get(enterpriseWarehousing.getIndustryConfigurationId()) != null) {
         map.put("industryConfigurationName", configMap.get(enterpriseWarehousing.getIndustryConfigurationId()).getName());
      }
      map.put("qualificationAndAbility", enterpriseWarehousing.getQualificationAndAbility());
      map.put("businessPhone", enterpriseWarehousing.getBusinessPhone());
      map.put("businessEmail", enterpriseWarehousing.getBusinessEmail());
      map.put("liaisons", enterpriseWarehousing.getLiaisons());
      map.put("acceptanceAddress", crmSupplierWarehousing.getAcceptanceAddress());
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
   public PageVO<CrmGovernmentWarehousingPageDTO> getCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmGovernmentWarehousingPageDTO> crmGovernmentWarehousingPageDTOS = this.crmBusinessCenterMapper
         .getGovernmentList(
            checkRecord,
            crmCheckStatusEnum,
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
            businessName,
            creditCode,
            informantUserName
         );
      crmGovernmentWarehousingPageDTOS.forEach(item -> {
         if (StringUtils.isNotBlank(item.getAttachmentIds())) {
            item.setAttachmentDTOS(this.attachmentService.listByIds(item.getAttachmentIds()));
         }
      });
      return new PageVO<>(objects, crmGovernmentWarehousingPageDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   ) {
      List<CrmGovernmentWarehousingPageDTO> crmGovernmentWarehousingPageDTOS = this.crmBusinessCenterMapper
         .getGovernmentList(
            checkRecord,
            crmCheckStatusEnum,
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
            businessName,
            creditCode,
            informantUserName
         );
      crmGovernmentWarehousingPageDTOS.forEach(item -> {
         if (StringUtils.isNotBlank(item.getAttachmentIds())) {
            item.setAttachmentDTOS(this.attachmentService.listByIds(item.getAttachmentIds()));
         }

         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(item.getCountryName());
         stringBuilder.append(item.getProvinceName());
         stringBuilder.append(item.getCityName());
         stringBuilder.append(item.getRegionName());
         item.setRegionNameList(stringBuilder.toString());
      });
      List<Map<String, Object>> collect = crmGovernmentWarehousingPageDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmGovernmentWarehousingDetailDTO crmGovernmentWarehousingDetail(Long id) {
      CrmGovernmentWarehousing governmentWarehousing = this.crmGovernmentWarehousingBiz.getById(id);
      Preconditions.checkArgument(governmentWarehousing != null, "政府备案不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(governmentWarehousing.getCrmEnterpriseWarehousingId());
      CrmGovernmentWarehousingDetailDTO warehousingDetailDTO = BeanUtil.copy(governmentWarehousing, CrmGovernmentWarehousingDetailDTO.class);
      warehousingDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      warehousingDetailDTO.setRecordBindProject(governmentWarehousing.getCrmProjectInformationWarehousingId() != null);
      warehousingDetailDTO.setInformantUserName(this.userService.getById(warehousingDetailDTO.getInformantUserId()).getName());
      if (warehousingDetailDTO.getDepartmentId() != null) {
         Department department = this.departmentService.getDepartmentById(warehousingDetailDTO.getDepartmentId());
         if (department != null) {
            warehousingDetailDTO.setDepartmentName(department.getName());
         }
      }
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmEnterpriseWarehousing.getCountryName());
      stringBuilder.append(crmEnterpriseWarehousing.getProvinceName());
      stringBuilder.append(crmEnterpriseWarehousing.getCityName());
      stringBuilder.append(crmEnterpriseWarehousing.getRegionName());
      warehousingDetailDTO.setRegionNameList(stringBuilder.toString());
      warehousingDetailDTO.setAddress(crmEnterpriseWarehousing.getAddress());
      if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
         warehousingDetailDTO.setUnitPropertyAllocationConfigId(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId());
         warehousingDetailDTO.setUnitPropertyAllocationConfigName(
            this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName()
         );
      }

      if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
         warehousingDetailDTO.setUnitClassConfigurationId(crmEnterpriseWarehousing.getUnitClassConfigurationId());
         warehousingDetailDTO.setUnitClassConfigurationName(this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
      }

      List<Long> regionIds = Arrays.asList(
            crmEnterpriseWarehousing.getCountryId(),
            crmEnterpriseWarehousing.getProvinceId(),
            crmEnterpriseWarehousing.getCityId(),
            crmEnterpriseWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      warehousingDetailDTO.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
      if (governmentWarehousing.getCrmProjectInformationWarehousingId() != null) {
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
            .getById(governmentWarehousing.getCrmProjectInformationWarehousingId());
         warehousingDetailDTO.setCrmProjectInformationWarehousingId(projectInformationWarehousing.getId());
         warehousingDetailDTO.setCrmProjectInformationWarehousingName(projectInformationWarehousing.getProjectName());
      }

      if (StringUtils.isNotBlank(governmentWarehousing.getAttachmentIds())) {
         warehousingDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(governmentWarehousing.getAttachmentIds()));
      }

      return warehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.crmGovernmentWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmGovernmentWarehousing != null, "政府备案不存在");
      String resourcePath = "files/CrmGovernmentWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmGovernmentWarehousingDetailTemplate";
      String exportFileName = crmGovernmentWarehousing.getSerialNumber() + "政府备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmGovernmentWarehousing);
      if (crmGovernmentWarehousing.getInformantUserId() != null) {
         map.put("informantUserName", this.userService.getById(crmGovernmentWarehousing.getInformantUserId()).getName());
      }

      if (crmGovernmentWarehousing.getDepartmentId() != null) {
         map.put("departmentName", this.departmentService.getDepartmentById(crmGovernmentWarehousing.getDepartmentId()).getName());
      }
      map.put("acceptanceAddress", crmGovernmentWarehousing.getAcceptanceAddress());
      if (crmGovernmentWarehousing.getCrmProjectInformationWarehousingId() != null) {
         CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
            .getById(crmGovernmentWarehousing.getCrmProjectInformationWarehousingId());
         if (crmProjectInformationWarehousing != null) {
            map.put(
               "regionalFullName",
               StringUtils.defaultString(crmProjectInformationWarehousing.getCountryName())
                  + StringUtils.defaultString(crmProjectInformationWarehousing.getProvinceName())
                  + StringUtils.defaultString(crmProjectInformationWarehousing.getCityName())
                  + StringUtils.defaultString(crmProjectInformationWarehousing.getRegionName())
            );
         }
      }
      Map<Long, CrmBasicsConfig> configMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      if (crmGovernmentWarehousing.getCrmEnterpriseWarehousingId() != null) {
         CrmEnterpriseWarehousing warehousingBizById = this.crmEnterpriseWarehousingBiz.getById(crmGovernmentWarehousing.getCrmEnterpriseWarehousingId());
         map.put("countryName", warehousingBizById.getCountryName());
         map.put("provinceNameAndCityName", warehousingBizById.getProvinceName() + warehousingBizById.getCityName() + warehousingBizById.getRegionName());
         map.put("biddingPlatformName", warehousingBizById.getBusinessName());
         if (warehousingBizById.getUnitPropertyAllocationConfigId() != null) {
            if (warehousingBizById.getUnitPropertyAllocationConfigId() != null) {
               map.put("reasonForRegistration", configMap.get(warehousingBizById.getUnitPropertyAllocationConfigId()).getName());
            }

            if (warehousingBizById.getUnitClassConfigurationId() != null) {
               map.put("unitClassConfigurationName", configMap.get(warehousingBizById.getUnitPropertyAllocationConfigId()).getName());
            }

            if (StringUtils.isNotBlank(warehousingBizById.getAddress())) {
               map.put("address", warehousingBizById.getAddress());
            }
         }
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
   public HashMap<String, Integer> governmentSummary() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getCrmRecordTypeEnum, CrmRecordTypeEnum.RECORD.getType()));
      if (CollectionUtils.isNotEmpty(crmGovernmentWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmGovernmentWarehousings.stream().map(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
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

   @Override
   public HashMap<String, Integer> platformSummary() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .eq(CrmBiddingPlatformWarehousing::getCrmRecordTypeEnum, CrmRecordTypeEnum.RECORD.getType())
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
            (int)crmBiddingPlatformWarehousings.stream()
               .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() == 1L)
               .count()
         );
         map.put(
            "foreignEnterprisesCount",
            (int)crmBiddingPlatformWarehousings.stream()
               .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() != 1L)
               .count()
         );
      }

      return map;
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
      String biddingPlatformName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmBiddingPlatformWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(checkRecord != null, CrmBiddingPlatformWarehousing::getCrmRecordTypeEnum, checkRecord)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmBiddingPlatformWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmBiddingPlatformWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmBiddingPlatformWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmBiddingPlatformWarehousing::getRegionId, regionId)
               .like(
                  com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(biddingPlatformName),
                  CrmBiddingPlatformWarehousing::getBiddingPlatformName,
                  biddingPlatformName
               )
               .like(
                  com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(informantUserName),
                  CrmBiddingPlatformWarehousing::getInformantUserName,
                  informantUserName
               )
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<CrmBiddingPlatformWarehousingPageDTO> crmBiddingPlatformWarehousingPageDTOList = crmBiddingPlatformWarehousings.stream()
         .map(
            item -> {
               CrmBiddingPlatformWarehousingPageDTO crmBiddingPlatformWarehousingPageDTO = BeanUtil.copy(item, CrmBiddingPlatformWarehousingPageDTO.class);
               crmBiddingPlatformWarehousingPageDTO.setInformantDateTime(item.getCreateTime());
               if (item.getCrmEnterpriseWarehousingId() != null) {
                  CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(item.getCrmEnterpriseWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingId(crmEnterpriseWarehousing.getId());
                  crmBiddingPlatformWarehousingPageDTO.setAddress(crmEnterpriseWarehousing.getAddress());
               }

               if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                  crmBiddingPlatformWarehousingPageDTO.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIds()));
               }

               if (item.getCrmProjectInformationWarehousingId() != null) {
                  CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
                     .getById(item.getCrmProjectInformationWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setCrmProjectInformationWarehousingName(crmProjectInformationWarehousing.getProjectName());
               }

               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(item.getCountryName());
               stringBuilder.append(item.getProvinceName());
               stringBuilder.append(item.getCityName());
               stringBuilder.append(item.getRegionName());
               crmBiddingPlatformWarehousingPageDTO.setRegionNameList(stringBuilder.toString());
               if (item.getCreateUserId() != null) {
                  crmBiddingPlatformWarehousingPageDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
               }

               if (item.getInformantUserId() != null) {
                  crmBiddingPlatformWarehousingPageDTO.setInformantUserName(this.userService.getById(item.getInformantUserId()).getName());
               }

               if (item.getCrmEnterpriseWarehousingId() != null) {
                  CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(item.getCrmEnterpriseWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setBusinessPhone(crmEnterpriseWarehousing.getBusinessPhone());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
               }

               return crmBiddingPlatformWarehousingPageDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(objects, crmBiddingPlatformWarehousingPageDTOList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmBiddingPlatformWarehousingList(
      Integer checkRecord,
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
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmBiddingPlatformWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(checkRecord != null, CrmBiddingPlatformWarehousing::getCrmRecordTypeEnum, checkRecord)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmBiddingPlatformWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmBiddingPlatformWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmBiddingPlatformWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmBiddingPlatformWarehousing::getRegionId, regionId)
               .like(
                  com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(biddingPlatformName),
                  CrmBiddingPlatformWarehousing::getBiddingPlatformName,
                  biddingPlatformName
               )
               .like(
                  com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(informantUserName),
                  CrmBiddingPlatformWarehousing::getInformantUserName,
                  informantUserName
               )
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<CrmBiddingPlatformWarehousingPageDTO> crmBiddingPlatformWarehousingPageDTOList = crmBiddingPlatformWarehousings.stream()
         .map(
            item -> {
               CrmBiddingPlatformWarehousingPageDTO crmBiddingPlatformWarehousingPageDTO = BeanUtil.copy(item, CrmBiddingPlatformWarehousingPageDTO.class);
               crmBiddingPlatformWarehousingPageDTO.setInformantDateTime(item.getCreateTime());
               if (item.getCrmEnterpriseWarehousingId() != null) {
                  CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(item.getCrmEnterpriseWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingId(crmEnterpriseWarehousing.getId());
                  crmBiddingPlatformWarehousingPageDTO.setAddress(crmEnterpriseWarehousing.getAddress());
               }

               if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                  crmBiddingPlatformWarehousingPageDTO.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIds()));
               }

               if (item.getCrmProjectInformationWarehousingId() != null) {
                  CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
                     .getById(item.getCrmProjectInformationWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setCrmProjectInformationWarehousingName(crmProjectInformationWarehousing.getProjectName());
               }

               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(item.getCountryName());
               stringBuilder.append(item.getProvinceName());
               stringBuilder.append(item.getCityName());
               stringBuilder.append(item.getRegionName());
               crmBiddingPlatformWarehousingPageDTO.setRegionNameList(stringBuilder.toString());
               if (item.getCreateUserId() != null) {
                  crmBiddingPlatformWarehousingPageDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
               }

               if (item.getInformantUserId() != null) {
                  crmBiddingPlatformWarehousingPageDTO.setInformantUserName(this.userService.getById(item.getInformantUserId()).getName());
               }

               if (item.getCrmEnterpriseWarehousingId() != null) {
                  CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(item.getCrmEnterpriseWarehousingId());
                  crmBiddingPlatformWarehousingPageDTO.setBusinessPhone(crmEnterpriseWarehousing.getBusinessPhone());
                  crmBiddingPlatformWarehousingPageDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
               }

               return crmBiddingPlatformWarehousingPageDTO;
            }
         )
         .collect(Collectors.toList());
      List<Map<String, Object>> collect = crmBiddingPlatformWarehousingPageDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetail(Long id) {
      CrmBiddingPlatformWarehousing biddingPlatformWarehousing = this.crmBiddingPlatformWarehousingBiz.getById(id);
      Preconditions.checkArgument(biddingPlatformWarehousing != null, "招标备案不存在");
      CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetailDTO = BeanUtil.copy(
         biddingPlatformWarehousing, CrmBiddingPlatformWarehousingDetailDTO.class
      );
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(biddingPlatformWarehousing.getAttachmentIds())) {
         crmBiddingPlatformWarehousingDetailDTO.setAttachmentIds(this.attachmentService.listByIds(biddingPlatformWarehousing.getAttachmentIds()));
      }

      if (biddingPlatformWarehousing.getInformantUserId() != null) {
         crmBiddingPlatformWarehousingDetailDTO.setInformantUserName(this.userService.getById(biddingPlatformWarehousing.getInformantUserId()).getName());
      }

      if (biddingPlatformWarehousing.getDepartmentId() != null) {
         crmBiddingPlatformWarehousingDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(biddingPlatformWarehousing.getDepartmentId()).getName()
         );
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(biddingPlatformWarehousing.getCountryName());
      stringBuilder.append(biddingPlatformWarehousing.getProvinceName());
      stringBuilder.append(biddingPlatformWarehousing.getCityName());
      stringBuilder.append(biddingPlatformWarehousing.getRegionName());
      crmBiddingPlatformWarehousingDetailDTO.setRegionNameList(stringBuilder.toString());
      if (StringUtils.isNotBlank(biddingPlatformWarehousing.getAttachmentIds())) {
         crmBiddingPlatformWarehousingDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(biddingPlatformWarehousing.getAttachmentIds()));
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
      CrmBiddingPlatformWarehousing biddingPlatformWarehousing = this.crmBiddingPlatformWarehousingBiz.getById(id);
      Preconditions.checkArgument(biddingPlatformWarehousing != null, "招标备案不存在");
      String resourcePath = "files/CrmBiddingPlatformWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmBiddingPlatformWarehousingDetailTemplate";
      String exportFileName = biddingPlatformWarehousing.getBiddingPlatformName() + "招标备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(biddingPlatformWarehousing);
      if (biddingPlatformWarehousing.getDepartmentId() != null) {
         map.put("departmentName", this.departmentService.getDepartmentById(biddingPlatformWarehousing.getDepartmentId()).getName());
      }

      map.put("informantUserName", this.userService.getById(biddingPlatformWarehousing.getInformantUserId()).getName());
      map.put("acceptanceAddress", biddingPlatformWarehousing.getAcceptanceAddress());
      if (biddingPlatformWarehousing.getCrmProjectInformationWarehousingId() != null) {
         CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
            .getById(biddingPlatformWarehousing.getCrmProjectInformationWarehousingId());
         map.put(
            "regionalFullName",
            crmProjectInformationWarehousing.getCountryName()
               + crmProjectInformationWarehousing.getProvinceName()
               + crmProjectInformationWarehousing.getCityName()
               + crmProjectInformationWarehousing.getRegionName()
         );
      }

      if (biddingPlatformWarehousing.getCountryId() != null && biddingPlatformWarehousing.getCountryId() == 1L) {
         StringBuilder set = new StringBuilder();
         set.append(StringUtils.isNotBlank(biddingPlatformWarehousing.getProvinceName()) ? biddingPlatformWarehousing.getProvinceName() : "");
         set.append(StringUtils.isNotBlank(biddingPlatformWarehousing.getCityName()) ? biddingPlatformWarehousing.getCityName() : "");
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
   public PrintVO<List<Map<String, Object>>> centerProjectListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName
   ) {
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      List<CrmCenterProjectListDTO> list = this.crmBusinessCenterMapper
         .getCrmCenterProjectList(
            startDate,
            endDate,
            countryId,
            provinceId,
            cityId,
            regionId,
            structureTypeConfigurationId,
            departmentIds,
            projectName,
            informantUserName,
            crmEnterpriseWarehousingName,
            UserUtil.getCurrentUserId(),
            crmCanLookDeptIds
         );
      list.forEach(this::applyProjectListDisplayFields);
      List<Map<String, Object>> collect = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Transactional
   @Override
   public Boolean projectTerminated(CrmProjectTerminatedUpdateDTO dto) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(dto.getId());
      crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.PROJECT_TERMINATION.getType());
      this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }
}
