package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveSourceEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaArgumentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAttachmentsDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaProjectInformationRegistrationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmInformationValidityPeriodConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectAbandonRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectTrackerWireBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmCountryTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmInformationValidityPeriodConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmNumberPrefixConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmPageManagementConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmRecordTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequirementTypeEnum;
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
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectAbandonRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectTrackerWire;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCanBeReleasedSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCheckProjectHaveRecordingDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectCanCarryOutTypeDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectCanCarryOutTypeDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDetailAPPDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheNumberOfCustomProjectConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmThisProjectBindEnterRecordInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmprojectInformationWarehousingFollowUpTimesAndDateDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectInformationWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectTrackerWireSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBiddingPlatformWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmGovernmentWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmSupplierWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationWarehousingMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmProjectInformationWarehousingBizImpl
   extends IBizImpl<CrmProjectInformationWarehousingService, CrmProjectInformationWarehousingMapper, CrmProjectInformationWarehousing>
   implements CrmProjectInformationWarehousingBiz {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectInformationWarehousingBizImpl.class);
   private static final String OA_PROJECT_INFORMATION_REGISTRATION = "项目信息登记";
   private static final String OA_PROJECT_INFORMATION_REGISTRATION_WORKFLOW = "CRM项目信息登记立项流程（初鸣）";
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private CrmInformationValidityPeriodConfigBiz crmInformationValidityPeriodConfigBiz;
   @Resource
   private UserService userService;
   @Resource
   private CrmProjectTrackerWireBiz crmProjectTrackerWireBiz;
   @Resource
   private CrmNumberPrefixConfigBiz crmNumberPrefixConfigBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private CrmOaConfigBiz crmOaConfigBiz;
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;
   @Resource
   private CrmPrequalificationRecordBiz crmPrequalificationRecordBiz;
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private CrmProjectAbandonRecordBiz crmProjectAbandonRecordBiz;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;
   @Resource
   private SysDictionaryService sysDictionaryService;
   @Resource
   private OaBusinessProcessService oaBusinessProcessService;

   @Override
   public PageVO<CrmProjectInformationWarehousingDTO> getCrmProjectInformationWarehousingList(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName,
      String condition,
      Integer pageNumber,
      Integer pageSize
   ) {
      String yyyy = null;
      if (informantDateTime != null) {
         yyyy = informantDateTime.format(DateTimeFormatter.ofPattern("yyyy"));
      }

      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .like(StringUtils.isNotBlank(informantUserName), CrmProjectInformationWarehousing::getInformantUserName, informantUserName)
               .eq(structureTypeConfigurationId != null, CrmProjectInformationWarehousing::getStructureTypeConfigurationId, structureTypeConfigurationId)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .apply(StringUtils.isNotBlank(yyyy), "DATE_FORMAT(informant_date_time, '%Y') = {0}", yyyy)
               .eq(!UserUtil.getCurrentUser().isAdmin(), CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
               .eq(crmCheckStatusEnum != null, CrmProjectInformationWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(keyProjectId != null, CrmProjectInformationWarehousing::getKeyProjectId, keyProjectId)
               .eq(projectLevelConfigId != null, CrmProjectInformationWarehousing::getProjectLevelConfigId, projectLevelConfigId)
               .eq(crmProjectScheduleTypeEnum != null, CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, crmProjectScheduleTypeEnum)
               .and(
                  projectNameOrRecordNumber != null,
                  q -> {
                     LambdaQueryWrapper var10000 = q.like(CrmProjectInformationWarehousing::getProjectName, projectNameOrRecordNumber)
                        .or()
                        .like(CrmProjectInformationWarehousing::getSerialNumber, projectNameOrRecordNumber);
                  }
               )
               .and(
                  condition != null,
                  q -> {
                     LambdaQueryWrapper var10000 = q.like(CrmProjectInformationWarehousing::getProjectName, condition)
                        .or()
                        .like(CrmProjectInformationWarehousing::getSerialNumber, condition);
                  }
               )
               .orderByDesc(CrmProjectInformationWarehousing::getInformantDateTime)
         );
      Map<Long, CrmProjectInformationConfig> map = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      List<CrmProjectInformationWarehousingDTO> collect = crmProjectInformationWarehousings.stream()
         .map(
            item -> {
               CrmProjectInformationWarehousingDTO crmProjectInformationWarehousingDTO = new CrmProjectInformationWarehousingDTO();
               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(item.getCountryName());
               stringBuilder.append(item.getProvinceName());
               stringBuilder.append(item.getCityName());
               stringBuilder.append(item.getRegionName());
               crmProjectInformationWarehousingDTO.setRegionNameList(stringBuilder.toString());
               crmProjectInformationWarehousingDTO.setEstimatedWorks(item.getEstimatedWorks());
               crmProjectInformationWarehousingDTO.setEstimatedCost(item.getEstimatedCost());
               crmProjectInformationWarehousingDTO.setAreaOfStructure(item.getAreaOfStructure());
               if (item.getStructureTypeConfigurationId() != null) {
                  crmProjectInformationWarehousingDTO.setStructureTypeConfigurationName(map.get(item.getStructureTypeConfigurationId()).getName());
               }

               crmProjectInformationWarehousingDTO.setAddress(item.getAddress());
               crmProjectInformationWarehousingDTO.setInformantUserName(item.getInformantUserName());
               crmProjectInformationWarehousingDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
               crmProjectInformationWarehousingDTO.setCrmProjectScheduleTypeEnum(item.getCrmProjectScheduleTypeEnum());
               crmProjectInformationWarehousingDTO.setId(item.getId());
               crmProjectInformationWarehousingDTO.setSerialNumber(item.getSerialNumber());
               crmProjectInformationWarehousingDTO.setInformantDateTime(item.getInformantDateTime());
               crmProjectInformationWarehousingDTO.setCrmCheckStatusEnum(item.getCrmCheckStatusEnum());
               crmProjectInformationWarehousingDTO.setProjectName(item.getProjectName());
               if (item.getKeyProjectId() != null) {
                  crmProjectInformationWarehousingDTO.setKeyProjectName(map.get(item.getKeyProjectId()).getName());
               }

               if (item.getProjectLevelConfigId() != null) {
                  crmProjectInformationWarehousingDTO.setProjectLevelConfigName(map.get(item.getProjectLevelConfigId()).getName());
               }

               crmProjectInformationWarehousingDTO.setCrmProjectScheduleTypeEnumName(
                  CrmProjectScheduleTypeEnum.getNameByType(item.getCrmProjectScheduleTypeEnum())
               );
               CrmprojectInformationWarehousingFollowUpTimesAndDateDTO upTimesAndDate = this.crmProjectFollowUpRecordBiz.getFollowUpTimesAndDate(item.getId());
               crmProjectInformationWarehousingDTO.setFollowUpTimes(upTimesAndDate.getFollowUpTimes() != null ? upTimesAndDate.getFollowUpTimes() : 0);
               crmProjectInformationWarehousingDTO.setEffectiveRemainingTime(
                  upTimesAndDate.getEffectiveRemainingTime() != null ? upTimesAndDate.getEffectiveRemainingTime() : 0
               );
               return crmProjectInformationWarehousingDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(objects, collect);
   }

   @Transactional
   @Override
   public Boolean saveCrmProjectInformationWarehousing(CrmProjectInformationWarehousingSaveParam copy) {
      CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.crmInformationValidityPeriodConfigBiz
         .getOne(
            Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
               .eq(
                  CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                  CrmInformationValidityPeriodConfigEnum.NUMBER_OF_PROJECT_QUOTA_ALLOCATION.getType()
               )
               .last("FOR UPDATE")
         );
      Preconditions.checkArgument(crmInformationValidityPeriodConfig != null, "请先配置项目名额数量");
      List<CrmTheNumberOfCustomProjectConfigDTO> crmTheNumberOfCustomProjectConfigDTOS = this.crmProjectInformationConfigBiz
         .customQuantityList(UserUtil.getCurrentUserId());
      if (CollectionUtil.isNotEmpty(crmTheNumberOfCustomProjectConfigDTOS)) {
         crmInformationValidityPeriodConfig.setProjectQuota(crmTheNumberOfCustomProjectConfigDTOS.get(0).getProjectQuota());
      }

      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
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

      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService
         .getOne(Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class).eq(CrmProjectInformationWarehousing::getProjectName, copy.getProjectName()));
      if (crmProjectInformationWarehousing != null) {
         Preconditions.checkArgument(
            false, crmProjectInformationWarehousing.getProjectName() + "项目已存在,备案号为:" + crmProjectInformationWarehousing.getSerialNumber()
         );
      }

      CrmProjectInformationWarehousing informationWarehousing = BeanUtil.copy(copy, CrmProjectInformationWarehousing.class);
      informationWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      informationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.FILING_STATUS.getType());
      informationWarehousing.setInformationOperatorUserId(copy.getInformantUserId());
      User user = this.userService.getById(copy.getInformantUserId());
      Preconditions.checkArgument(user != null, "填报人不存在");
      if (user.getDepartmentId() != null) {
         informationWarehousing.setInformationOperatorDeptId(user.getDepartmentId());
      }

      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(copy.getRegionList());
      informationWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      informationWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      informationWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      informationWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      informationWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      informationWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      informationWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      informationWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      informationWarehousing.setSerialNumber(
         this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.PROJECT_INFORMATION_REGISTRATION.getType())
      );
      informationWarehousing.setValidityOfRegistration(0);
      informationWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      if (copy.getInformantUserId() != null) {
         User userServiceById = this.userService.getById(copy.getInformantUserId());
         informationWarehousing.setInformantUserName(userServiceById.getName());
      }

      if (CollectionUtil.isNotEmpty(copy.getProjectAttachments())) {
         informationWarehousing.setProjectAttachments(
            StrUtil.join(",", copy.getProjectAttachments().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
      }

      this.baseService.save(informationWarehousing);
      if (CollectionUtil.isNotEmpty(copy.getCrmProjectTrackerWireSaveParamList())) {
         List<CrmProjectTrackerWire> crmProjectTrackerWires = new ArrayList<>();
         List<CrmProjectTrackerWireSaveParam> paramList = copy.getCrmProjectTrackerWireSaveParamList();
         paramList.forEach(
            item -> crmProjectTrackerWires.add(
               CrmProjectTrackerWire.builder()
                  .crmEnterpriseWarehousingId(item.getCrmEnterpriseWarehousingId())
                  .name(item.getName())
                  .phone(item.getPhone())
                  .position(item.getPosition())
                  .unitClassConfigurationId(item.getUnitClassConfigurationId())
                  .crmProjectInformationWarehousingId(informationWarehousing.getId())
                  .build()
            )
         );
         crmProjectTrackerWires.forEach(item -> this.crmProjectTrackerWireBiz.save(item));
      }

      if (!Boolean.TRUE.equals(this.crmOaConfigBiz.getOaConfig().getEnabled())) {
         WmsApproveRecord record = this.wmsApproveRecordService
            .createRecord(
               informationWarehousing.getId(),
               informationWarehousing.getProjectName(),
               ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType(),
               null,
               null,
               null,
               false,
               null,
               null,
               null
            );
         if (ReviewStatusEnum.REVIEWED.getType().equals(record.getReviewStatus())) {
            informationWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            CrmInformationValidityPeriodConfig validityConfig = this.crmInformationValidityPeriodConfigBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            Preconditions.checkArgument(validityConfig != null, "项目有效期配置不存在");
            informationWarehousing.setValidityOfRegistration(validityConfig.getValidityOfRegistration());
         }

         informationWarehousing.setApproveRecordId(record.getId());
         Preconditions.checkArgument(this.baseService.updateById(informationWarehousing), "项目登记回写审批记录失败");
         return Boolean.TRUE;
      } else {
         String requestId = this.createOaProjectInformationRegistration(informationWarehousing.getId(), user);

         try {
            WmsApproveRecord record = this.createOaApproveRecord(informationWarehousing, user, requestId);
            informationWarehousing.setApproveRecordId(record.getId());
            Preconditions.checkArgument(this.baseService.updateById(informationWarehousing), "项目登记回写审批记录失败");
         } catch (RuntimeException e) {
            this.compensateOaRequest(requestId, user, ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType(), e);
            throw e;
         }

         return Boolean.TRUE;
      }
   }

   private String createOaProjectInformationRegistration(Long projectId, User applicant) {
      Preconditions.checkArgument(applicant.getOaUserId() != null, "填报人未配置OA人员ID");
      Preconditions.checkArgument(applicant.getOaSubDeptId() != null, "填报人未配置OA所属公司ID");
      Preconditions.checkArgument(applicant.getOaDeptId() != null, "填报人未配置OA所属部门ID");
      CrmProjectInformationWarehousingDetailDTO project = this.crmProjectInformationWarehousingDetail(projectId);
      Preconditions.checkArgument(StringUtils.isNotBlank(project.getProjectName()), "项目名称不能为空");
      CrmProjectInformationWarehousingBizImpl.RelatedUnit relatedUnit = this.selectRelatedUnit(project);
      String requestTitle = project.getProjectName() + "项目信息登记";
      LocalDate applicationDate = project.getInformantDateTime() == null ? LocalDate.now() : project.getInformantDateTime().toLocalDate();
      OaProjectInformationRegistrationDTOParam oaParam = OaProjectInformationRegistrationDTOParam.builder()
         .requestName("CRM项目信息登记立项流程（初鸣）")
         .title(requestTitle)
         .sqrq(applicationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         .sqr(applicant.getOaUserId().toString())
         .fj(this.buildOaAttachments(project.getProjectAttachmentList()))
         .bz(project.getRemark())
         .sqrszgs(applicant.getOaSubDeptId().toString())
         .sqrszbm(applicant.getOaDeptId().toString())
         .xmmc(project.getProjectName())
         .xmlb(project.getItemCategoryName())
         .xmgzd(this.getCountryTypeName(project.getCrmCountryTypeEnum()))
         .zdxm(project.getKeyProjectName())
         .gssq(this.buildRegionName(project))
         .xxdz(project.getAddress())
         .xmgk(project.getProjectOverview())
         .yggcld(this.toPlainString(project.getEstimatedWorks()))
         .jzmjpfm(this.toPlainString(project.getAreaOfStructure()))
         .ygzjwy(this.toPlainString(project.getEstimatedCost()))
         .cjlb(project.getTypeOfContractorName())
         .jglx(project.getStructureTypeConfigurationName())
         .jzxs(project.getConfigurationOfArchitecturalFormName())
         .szxy(project.getIndustryConfigurationName())
         .xmxxly(project.getInfoSource())
         .xgdw(project.getCrmEnterpriseWarehousingName())
         .sfxmjlph(this.toYesOrNo(project.getIsProjectManagerCoordinate()))
         .xmjlmc(project.getProjectManagerName())
         .zbfs(project.getBiddingMethodName())
         .jsdwsjdwzbdw(relatedUnit.name)
         .lxrmc(relatedUnit.contactName)
         .lxrzw(relatedUnit.office)
         .lxrdh(relatedUnit.phone)
         .build();
      ZhongNanWorkFlowDTO workflow = this.oaBusinessProcessService.checkPermission(oaParam.getSqr(), oaParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(workflow.getWorkflowId()), "该用户没有提交项目信息登记流程权限");

      List<OaArgumentDTO> mainData;
      try {
         mainData = this.oaBusinessProcessService.resultData(oaParam);
      } catch (IllegalAccessException e) {
         throw new IllegalArgumentException("构建项目信息登记OA请求参数失败", e);
      }

      String response = this.oaBusinessProcessService.doCreateRequest(requestTitle, workflow.getWorkflowId(), oaParam.getSqr(), mainData, null);
      JSONObject responseJson = JSONObject.parseObject(response);
      Preconditions.checkArgument(responseJson != null, "OA项目信息登记接口返回为空");
      Preconditions.checkArgument("SUCCESS".equals(responseJson.getString("code")), responseJson.getString("errMsg"));
      JSONObject data = responseJson.getJSONObject("data");
      Preconditions.checkArgument(data != null && StringUtils.isNotBlank(data.getString("requestid")), "OA项目信息登记未返回requestId");
      return data.getString("requestid");
   }

   private void compensateOaRequest(String requestId, User applicant, Integer approveProcessType, RuntimeException originalException) {
      try {
         ResultVO withdrawResult = this.oaBusinessProcessService
            .withdrawRequest(
               OaRevocationDTOParam.builder()
                  .requestId(requestId)
                  .isremind("0")
                  .remark("CRM本地数据保存失败，系统自动撤回OA流程")
                  .oaUserId(String.valueOf(applicant.getOaUserId()))
                  .approveProcessType(approveProcessType)
                  .build()
            );
         if (withdrawResult == null || !Long.valueOf(20000L).equals(withdrawResult.getCode())) {
            IllegalStateException compensationFailure = new IllegalStateException(withdrawResult == null ? "OA补偿撤回未返回结果" : withdrawResult.getMessage());
            originalException.addSuppressed(compensationFailure);
            log.error("CRM项目登记OA补偿撤回失败，requestId={}", requestId, compensationFailure);
         }
      } catch (RuntimeException compensationFailure) {
         originalException.addSuppressed(compensationFailure);
         log.error("CRM项目登记OA补偿撤回失败，requestId={}", requestId, compensationFailure);
      }
   }

   private WmsApproveRecord createOaApproveRecord(CrmProjectInformationWarehousing project, User applicant, String requestId) {
      ApproveProcessTypeEnumV2 approveType = ApproveProcessTypeEnumV2.CRM_PROJECT_FILING;
      LocalDateTime now = LocalDateTime.now();

      String serialNumber;
      do {
         serialNumber = this.wmsApproveRecordService.createApproveSerialNumber("wms_approve_flow_operation");
      } while (this.wmsApproveRecordService.count(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getSerialNumber, serialNumber)) > 0);

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .dataId(project.getId())
         .dataSerialNumber(project.getProjectName())
         .serialNumber(serialNumber)
         .startTime(now)
         .applicantId(applicant.getId())
         .departmentId(applicant.getDepartmentId())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .lastApproverId(applicant.getId())
         .lastApprovalTime(now)
         .componentName(ComponentNameUtils.getComponentName(approveType.getType(), null))
         .approveSource(ApproveSourceEnum.OA.getType())
         .requestId(requestId)
         .build();
      Preconditions.checkArgument(this.wmsApproveRecordService.save(record), "本地审批主记录保存失败");
      WmsApproveRecordDetail recordDetail = WmsApproveRecordDetail.builder()
         .dataId(project.getId())
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .approveRecordSerialNumber(serialNumber)
         .flowType(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())
         .checkUserId(applicant.getId())
         .arrivalTime(now)
         .approveTime(now)
         .decision(CheckStatusEnum.PASS.getType())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .approveSource(ApproveSourceEnum.OA.getType())
         .requestId(requestId)
         .build();
      Preconditions.checkArgument(this.wmsApproveRecordDetailService.save(recordDetail), "本地审批明细保存失败");
      return record;
   }

   private List<OaAttachmentsDTO> buildOaAttachments(List<AttachmentDTO> attachments) {
      return CollectionUtil.isEmpty(attachments)
         ? Collections.emptyList()
         : attachments.stream()
            .filter(Objects::nonNull)
            .filter(item -> StringUtils.isNotBlank(item.getName()) && StringUtils.isNotBlank(item.getRelativePath()))
            .map(item -> OaAttachmentsDTO.builder().fileName(item.getName()).filePath(item.getRelativePath()).build())
            .collect(Collectors.toList());
   }

   private String getCountryTypeName(Integer countryType) {
      if (CrmCountryTypeEnum.DOMESTIC.getType().equals(countryType)) {
         return CrmCountryTypeEnum.DOMESTIC.getName();
      } else {
         return CrmCountryTypeEnum.FOREIGN.getType().equals(countryType) ? CrmCountryTypeEnum.FOREIGN.getName() : null;
      }
   }

   private String buildRegionName(CrmProjectInformationWarehousingDetailDTO project) {
      return Arrays.asList(project.getCountryName(), project.getProvinceName(), project.getCityName(), project.getRegionName())
         .stream()
         .filter(StringUtils::isNotBlank)
         .collect(Collectors.joining("/"));
   }

   private String toPlainString(BigDecimal value) {
      return value == null ? null : value.stripTrailingZeros().toPlainString();
   }

   private String toYesOrNo(Boolean value) {
      return value == null ? null : (value ? "是" : "否");
   }

   private CrmProjectInformationWarehousingBizImpl.RelatedUnit selectRelatedUnit(CrmProjectInformationWarehousingDetailDTO project) {
      List<CrmProjectInformationWarehousingBizImpl.RelatedUnit> units = Arrays.asList(
         new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
            project.getAUnitClassConfigurationName(),
            project.getAUnitClassConfigurationContactName(),
            project.getAUnitClassConfigurationOffice(),
            project.getAUnitClassConfigurationPhone()
         ),
         new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
            project.getBUnitClassConfigurationName(),
            project.getBUnitClassConfigurationContactName(),
            project.getBUnitClassConfigurationOffice(),
            project.getBUnitClassConfigurationPhone()
         ),
         new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
            project.getCUnitClassConfigurationName(),
            project.getCUnitClassConfigurationContactName(),
            project.getCUnitClassConfigurationOffice(),
            project.getCUnitClassConfigurationPhone()
         ),
         new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
            project.getDUnitClassConfigurationName(),
            project.getDUnitClassConfigurationContactName(),
            project.getDUnitClassConfigurationOffice(),
            project.getDUnitClassConfigurationPhone()
         ),
         new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
            project.getEUnitClassConfigurationName(),
            project.getEUnitClassConfigurationContactName(),
            project.getEUnitClassConfigurationOffice(),
            project.getEUnitClassConfigurationPhone()
         )
      );
      return units.stream().filter(item -> StringUtils.isNotBlank(item.name)).findFirst().orElse(CrmProjectInformationWarehousingBizImpl.RelatedUnit.EMPTY);
   }

   @Transactional
   @Override
   public Boolean deleteCrmProjectInformationWarehousing(Long id) {
      CrmProjectInformationWarehousing warehousing = this.baseService.getById(id);
      Preconditions.checkArgument(warehousing != null, "项目备案信息不存在");
      Preconditions.checkArgument(warehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.TEMPORARY_STORAGE.getType()), "项目备案信息已发起审核不可删除");
      this.baseService.removeById(id);
      this.crmProjectTrackerWireBiz
         .remove(Wrappers.lambdaQuery(CrmProjectTrackerWire.class).eq(CrmProjectTrackerWire::getCrmProjectInformationWarehousingId, id));
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateCrmProjectInformationWarehousing(CrmProjectInformationWarehousingUpdateParam copy) {
      CrmProjectInformationWarehousing warehousing = this.baseService.getById(copy.getId());
      Preconditions.checkArgument(warehousing != null, "项目备案信息不存在");
      Preconditions.checkArgument(!warehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案信息已通过审核不可进行修改");
      WmsApproveRecord previousApproveRecord = this.wmsApproveRecordService.getById(warehousing.getApproveRecordId());
      Preconditions.checkArgument(previousApproveRecord != null, "项目备案审批记录不存在");
      if (ApproveSourceEnum.OA.getType().equals(previousApproveRecord.getApproveSource())) {
         Preconditions.checkArgument(ApproveRecordStatusEnum.END.getType().equals(previousApproveRecord.getStatus()), "OA项目登记审批尚未结束，不可重复提交");
      }

      BeanUtil.copy(copy, warehousing);
      warehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      if (CollectionUtil.isNotEmpty(copy.getProjectAttachments())) {
         warehousing.setProjectAttachments(StrUtil.join(",", copy.getProjectAttachments().stream().map(AttachmentDTO::getId).collect(Collectors.toList())));
      }

      Preconditions.checkArgument(this.baseService.updateById(warehousing), "项目备案信息修改失败");
      if (Boolean.FALSE.equals(copy.getIsProjectManagerCoordinate())) {
         this.baseService
            .update(
               Wrappers.lambdaUpdate(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getId, copy.getId())
                  .set(CrmProjectInformationWarehousing::getProjectManagerName, "")
            );
         warehousing.setProjectManagerName("");
      }

      User applicant = this.userService.getById(warehousing.getInformantUserId());
      Preconditions.checkArgument(applicant != null, "填报人不存在");
      if (!Boolean.TRUE.equals(this.crmOaConfigBiz.getOaConfig().getEnabled())) {
         if (ApproveSourceEnum.SYSTEM.getType().equals(previousApproveRecord.getApproveSource())) {
            List<WmsApproveRecordDetail> previousDetails = this.wmsApproveRecordDetailService
               .list(
                  Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, previousApproveRecord.getSerialNumber())
               );
            if (CollectionUtil.isNotEmpty(previousDetails)) {
               this.wmsApproveRecordDetailService.removeByIds(previousDetails.stream().map(WmsApproveRecordDetail::getId).collect(Collectors.toList()));
            }

            this.wmsApproveRecordService.removeById(previousApproveRecord.getId());
         }

         WmsApproveRecord record = this.wmsApproveRecordService
            .createRecord(
               warehousing.getId(),
               warehousing.getProjectName(),
               ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType(),
               null,
               null,
               null,
               false,
               null,
               null,
               null
            );
         if (ReviewStatusEnum.REVIEWED.getType().equals(record.getReviewStatus())) {
            warehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            CrmInformationValidityPeriodConfig validityConfig = this.crmInformationValidityPeriodConfigBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            Preconditions.checkArgument(validityConfig != null, "项目有效期配置不存在");
            warehousing.setValidityOfRegistration(validityConfig.getValidityOfRegistration());
         }

         warehousing.setApproveRecordId(record.getId());
         Preconditions.checkArgument(this.baseService.updateById(warehousing), "项目登记回写审批记录失败");
         return Boolean.TRUE;
      } else {
         String requestId = this.createOaProjectInformationRegistration(warehousing.getId(), applicant);

         try {
            WmsApproveRecord record = this.createOaApproveRecord(warehousing, applicant, requestId);
            warehousing.setApproveRecordId(record.getId());
            Preconditions.checkArgument(this.baseService.updateById(warehousing), "项目登记回写审批记录失败");
            if (ApproveSourceEnum.SYSTEM.getType().equals(previousApproveRecord.getApproveSource())) {
               List<WmsApproveRecordDetail> previousDetails = this.wmsApproveRecordDetailService
                  .list(
                     Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                        .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, previousApproveRecord.getSerialNumber())
                  );
               if (CollectionUtil.isNotEmpty(previousDetails)) {
                  Preconditions.checkArgument(
                     this.wmsApproveRecordDetailService.removeByIds(previousDetails.stream().map(WmsApproveRecordDetail::getId).collect(Collectors.toList())),
                     "清理原项目登记审批明细失败"
                  );
               }

               Preconditions.checkArgument(this.wmsApproveRecordService.removeById(previousApproveRecord.getId()), "清理原项目登记审批记录失败");
            }
         } catch (RuntimeException e) {
            this.compensateOaRequest(requestId, applicant, ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType(), e);
            throw e;
         }

         return Boolean.TRUE;
      }
   }

   @Override
   public CrmProjectInformationWarehousingDetailDTO crmProjectInformationWarehousingDetail(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseMapper.getDetailByDelete(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmProjectInformationWarehousingDetailDTO crmProjectInformationWarehousingDetailDTO = BeanUtil.copy(
         crmProjectInformationWarehousing, CrmProjectInformationWarehousingDetailDTO.class
      );
      Map<Long, String> informationConfigMap = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, CrmProjectInformationConfig::getName));
      Map<Long, String> basicsConfigMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, CrmBasicsConfig::getName));
      Map<Long, String> tenderConfigMap = this.crmTenderRequestConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmTenderRequestConfig::getId, CrmTenderRequestConfig::getName));
      Map<Long, String> enterpriseWarehousingMap = this.crmEnterpriseWarehousingBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmEnterpriseWarehousing::getId, CrmEnterpriseWarehousing::getBusinessName));
      if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getProjectAttachments())) {
         crmProjectInformationWarehousingDetailDTO.setProjectAttachmentList(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getProjectAttachments())
         );
      }

      crmProjectInformationWarehousingDetailDTO.setCreateUserName(this.userService.getById(crmProjectInformationWarehousing.getCreateUserId()).getName());
      crmProjectInformationWarehousingDetailDTO.setProjectSerialNumber(crmProjectInformationWarehousing.getSerialNumber());
      crmProjectInformationWarehousingDetailDTO.setTypeOfContractorName(informationConfigMap.get(crmProjectInformationWarehousing.getTypeOfContractorId()));
      crmProjectInformationWarehousingDetailDTO.setKeyProjectName(informationConfigMap.get(crmProjectInformationWarehousing.getKeyProjectId()));
      crmProjectInformationWarehousingDetailDTO.setItemCategoryName(informationConfigMap.get(crmProjectInformationWarehousing.getItemCategoryId()));
      crmProjectInformationWarehousingDetailDTO.setConfigurationOfArchitecturalFormName(
         informationConfigMap.get(crmProjectInformationWarehousing.getConfigurationOfArchitecturalFormId())
      );
      crmProjectInformationWarehousingDetailDTO.setStructureTypeConfigurationName(
         informationConfigMap.get(crmProjectInformationWarehousing.getStructureTypeConfigurationId())
      );
      crmProjectInformationWarehousingDetailDTO.setIndustryConfigurationName(basicsConfigMap.get(crmProjectInformationWarehousing.getIndustryConfigurationId()));
      crmProjectInformationWarehousingDetailDTO.setBiddingMethodName(tenderConfigMap.get(crmProjectInformationWarehousing.getBiddingMethodId()));
      if (crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmProjectInformationWarehousingDetailDTO.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      crmProjectInformationWarehousingDetailDTO.setProjectManagerName(crmProjectInformationWarehousing.getProjectManagerName());
      crmProjectInformationWarehousingDetailDTO.setInfoSource(crmProjectInformationWarehousing.getInfoSource());
      crmProjectInformationWarehousingDetailDTO.setIsProjectManagerCoordinate(crmProjectInformationWarehousing.getIsProjectManagerCoordinate());
      List<Long> regionIds = Arrays.asList(
            crmProjectInformationWarehousing.getCountryId(),
            crmProjectInformationWarehousing.getProvinceId(),
            crmProjectInformationWarehousing.getCityId(),
            crmProjectInformationWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmProjectInformationWarehousingDetailDTO.setRegionList(regionIds);
      if (crmProjectInformationWarehousing.getProjectLevelConfigId() != null) {
         crmProjectInformationWarehousingDetailDTO.setProjectLevelConfigId(crmProjectInformationWarehousing.getProjectLevelConfigId());
         crmProjectInformationWarehousingDetailDTO.setProjectLevelConfigName(
            this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getProjectLevelConfigId()).getName()
         );
      }

      crmProjectInformationWarehousingDetailDTO.setCrmCountryTypeEnum(crmProjectInformationWarehousing.getCrmCountryTypeEnum());
      if (crmProjectInformationWarehousing.getAUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setAUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getAUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getBUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setBUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getBUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getCUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setCUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getCUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getDUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setDUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getDUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getEUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setEUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getEUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousingDetailDTO.getDepartmentId() != null) {
         crmProjectInformationWarehousingDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(crmProjectInformationWarehousing.getDepartmentId()).getName()
         );
      }

      return crmProjectInformationWarehousingDetailDTO;
   }

   @Override
   public CrmProjectInformationWarehousingDetailAPPDTO crmProjectInformationWarehousingDetailAPP(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseMapper.getDetailByDelete(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmProjectInformationWarehousingDetailAPPDTO crmProjectInformationWarehousingDetailDTO = BeanUtil.copy(
         crmProjectInformationWarehousing, CrmProjectInformationWarehousingDetailAPPDTO.class
      );
      Map<Long, String> informationConfigMap = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, CrmProjectInformationConfig::getName));
      Map<Long, String> basicsConfigMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, CrmBasicsConfig::getName));
      Map<Long, String> tenderConfigMap = this.crmTenderRequestConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmTenderRequestConfig::getId, CrmTenderRequestConfig::getName));
      Map<Long, String> enterpriseWarehousingMap = this.crmEnterpriseWarehousingBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmEnterpriseWarehousing::getId, CrmEnterpriseWarehousing::getBusinessName));
      if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getProjectAttachments())) {
         crmProjectInformationWarehousingDetailDTO.setProjectAttachmentList(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getProjectAttachments())
         );
      }

      crmProjectInformationWarehousingDetailDTO.setCreateUserName(this.userService.getById(crmProjectInformationWarehousing.getCreateUserId()).getName());
      crmProjectInformationWarehousingDetailDTO.setProjectSerialNumber(crmProjectInformationWarehousing.getSerialNumber());
      crmProjectInformationWarehousingDetailDTO.setTypeOfContractorName(informationConfigMap.get(crmProjectInformationWarehousing.getTypeOfContractorId()));
      crmProjectInformationWarehousingDetailDTO.setKeyProjectName(informationConfigMap.get(crmProjectInformationWarehousing.getKeyProjectId()));
      crmProjectInformationWarehousingDetailDTO.setItemCategoryName(informationConfigMap.get(crmProjectInformationWarehousing.getItemCategoryId()));
      crmProjectInformationWarehousingDetailDTO.setConfigurationOfArchitecturalFormName(
         informationConfigMap.get(crmProjectInformationWarehousing.getConfigurationOfArchitecturalFormId())
      );
      crmProjectInformationWarehousingDetailDTO.setStructureTypeConfigurationName(
         informationConfigMap.get(crmProjectInformationWarehousing.getStructureTypeConfigurationId())
      );
      crmProjectInformationWarehousingDetailDTO.setIndustryConfigurationName(basicsConfigMap.get(crmProjectInformationWarehousing.getIndustryConfigurationId()));
      crmProjectInformationWarehousingDetailDTO.setBiddingMethodName(tenderConfigMap.get(crmProjectInformationWarehousing.getBiddingMethodId()));
      if (crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmProjectInformationWarehousingDetailDTO.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      crmProjectInformationWarehousingDetailDTO.setProjectManagerName(crmProjectInformationWarehousing.getProjectManagerName());
      crmProjectInformationWarehousingDetailDTO.setInfoSource(Long.valueOf(crmProjectInformationWarehousing.getInfoSource()));
      crmProjectInformationWarehousingDetailDTO.setIsProjectManagerCoordinate(crmProjectInformationWarehousing.getIsProjectManagerCoordinate());
      List<Long> regionIds = Arrays.asList(
            crmProjectInformationWarehousing.getCountryId(),
            crmProjectInformationWarehousing.getProvinceId(),
            crmProjectInformationWarehousing.getCityId(),
            crmProjectInformationWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmProjectInformationWarehousingDetailDTO.setRegionList(regionIds);
      if (crmProjectInformationWarehousing.getProjectLevelConfigId() != null) {
         crmProjectInformationWarehousingDetailDTO.setProjectLevelConfigId(crmProjectInformationWarehousing.getProjectLevelConfigId());
         crmProjectInformationWarehousingDetailDTO.setProjectLevelConfigName(
            this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getProjectLevelConfigId()).getName()
         );
      }

      crmProjectInformationWarehousingDetailDTO.setCrmCountryTypeEnum(crmProjectInformationWarehousing.getCrmCountryTypeEnum());
      if (crmProjectInformationWarehousing.getAUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setAUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getAUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getBUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setBUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getBUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getCUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setCUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getCUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getDUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setDUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getDUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousing.getEUnitClassConfigurationId() != null) {
         crmProjectInformationWarehousingDetailDTO.setEUnitClassConfigurationName(
            enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getEUnitClassConfigurationId())
         );
      }

      if (crmProjectInformationWarehousingDetailDTO.getDepartmentId() != null) {
         crmProjectInformationWarehousingDetailDTO.setDepartmentName(
            this.departmentService.getDepartmentById(crmProjectInformationWarehousing.getDepartmentId()).getName()
         );
      }

      return crmProjectInformationWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmProjectInformationWarehousingDetail(Long id, HttpServletResponse response) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      String resourcePath = "files/CrmProjectWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmProjectWarehousingDetailTemplate";
      String exportFileName = crmProjectInformationWarehousing.getProjectName() + "项目备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmProjectInformationWarehousing);
      Map<Long, String> projectConfigMap = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, CrmProjectInformationConfig::getName));
      Map<Long, String> baseConfigMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, CrmBasicsConfig::getName));
      Map<Long, String> enterpriseWarehousingMap = this.crmEnterpriseWarehousingBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmEnterpriseWarehousing::getId, CrmEnterpriseWarehousing::getBusinessName));
      if (crmProjectInformationWarehousing.getDepartmentId() != null) {
         map.put("departmentName", this.departmentService.getDepartmentById(crmProjectInformationWarehousing.getDepartmentId()).getName());
      }

      if (crmProjectInformationWarehousing.getItemCategoryId() != null) {
         map.put("itemCategoryName", projectConfigMap.get(crmProjectInformationWarehousing.getItemCategoryId()));
      }

      if (crmProjectInformationWarehousing.getKeyProjectId() != null) {
         map.put("keyProjectName", projectConfigMap.get(crmProjectInformationWarehousing.getKeyProjectId()));
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(crmProjectInformationWarehousing.getCountryName());
      stringBuilder.append(crmProjectInformationWarehousing.getProvinceName());
      stringBuilder.append(crmProjectInformationWarehousing.getCityName());
      stringBuilder.append(crmProjectInformationWarehousing.getRegionName());
      map.put("regionNameList", stringBuilder.toString());
      if (crmProjectInformationWarehousing.getStructureTypeConfigurationId() != null) {
         map.put("structureTypeConfigurationName", projectConfigMap.get(crmProjectInformationWarehousing.getStructureTypeConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getTypeOfContractorId() != null) {
         map.put("typeOfContractorName", projectConfigMap.get(crmProjectInformationWarehousing.getTypeOfContractorId()));
      }

      if (crmProjectInformationWarehousing.getIndustryConfigurationId() != null) {
         map.put("industryConfigurationName", projectConfigMap.get(crmProjectInformationWarehousing.getIndustryConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getConfigurationOfArchitecturalFormId() != null) {
         map.put("configurationOfArchitecturalFormName", projectConfigMap.get(crmProjectInformationWarehousing.getIndustryConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         map.put(
            "crmEnterpriseWarehousingName",
            this.crmEnterpriseWarehousingBiz.getById(crmProjectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      if (crmProjectInformationWarehousing.getBiddingMethodId() != null) {
         map.put("biddingMethodName", this.crmTenderRequestConfigBiz.getById(crmProjectInformationWarehousing.getBiddingMethodId()).getName());
      }

      if (crmProjectInformationWarehousing.getProjectLevelConfigId() != null) {
         map.put("projectLevelConfigName", projectConfigMap.get(crmProjectInformationWarehousing.getProjectLevelConfigId()));
      }

      if (crmProjectInformationWarehousing.getAUnitClassConfigurationId() != null) {
         map.put("AUnitClassConfigurationName", enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getAUnitClassConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getBUnitClassConfigurationId() != null) {
         map.put("BUnitClassConfigurationName", enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getBUnitClassConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getCUnitClassConfigurationId() != null) {
         map.put("CUnitClassConfigurationName", enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getCUnitClassConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getDUnitClassConfigurationId() != null) {
         map.put("DUnitClassConfigurationName", enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getDUnitClassConfigurationId()));
      }

      if (crmProjectInformationWarehousing.getEUnitClassConfigurationId() != null) {
         map.put("EUnitClassConfigurationName", enterpriseWarehousingMap.get(crmProjectInformationWarehousing.getEUnitClassConfigurationId()));
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

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean filingTaskGrant(CrmFilingTaskGrantUpdateParam crmFilingTaskGrantUpdateParam) {
      if (crmFilingTaskGrantUpdateParam.getCrmSupplierWarehousingUpdateParam() != null) {
         CrmSupplierWarehousingUpdateParam warehousingUpdateParam = crmFilingTaskGrantUpdateParam.getCrmSupplierWarehousingUpdateParam();
         if (warehousingUpdateParam.getCrmProjectInformationWarehousingId() != null) {
            List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
                     .isNull(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId)
                     .eq(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId, warehousingUpdateParam.getCrmEnterpriseWarehousingId())
               );
            Preconditions.checkArgument(CollectionUtil.isEmpty(crmSupplierWarehousings), "当前企业下的供应商备案已存在");
            CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService
               .getById(warehousingUpdateParam.getCrmProjectInformationWarehousingId());
            projectInformationWarehousing.setCrmEnterpriseWarehousingId(warehousingUpdateParam.getCrmEnterpriseWarehousingId());
            this.baseService.updateById(projectInformationWarehousing);
         }

         CrmSupplierWarehousing supplierWarehousing = BeanUtil.copy(
            crmFilingTaskGrantUpdateParam.getCrmSupplierWarehousingUpdateParam(), CrmSupplierWarehousing.class
         );
         supplierWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.UN_RECORD.getType());
         supplierWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.TO_BE_CLAIMED.getType());
         supplierWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
         supplierWarehousing.setSerialNumber(this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.SUPPLIER_FILING.getType()));
         if (CollectionUtil.isNotEmpty(crmFilingTaskGrantUpdateParam.getCrmSupplierWarehousingUpdateParam().getAttachmentIds())) {
            supplierWarehousing.setAttachmentIds(
               org.apache.commons.lang3.StringUtils.join(
                  crmFilingTaskGrantUpdateParam.getCrmSupplierWarehousingUpdateParam()
                     .getAttachmentIds()
                     .stream()
                     .map(AttachmentDTO::getId)
                     .collect(Collectors.toList()),
                  ","
               )
            );
         }

         this.crmSupplierWarehousingBiz.save(supplierWarehousing);
      }

      if (crmFilingTaskGrantUpdateParam.getCrmBiddingPlatformWarehousingUpdateParam() != null) {
         CrmBiddingPlatformWarehousingUpdateParam biddingPlatformWarehousingUpdateParam = crmFilingTaskGrantUpdateParam.getCrmBiddingPlatformWarehousingUpdateParam();
         if (biddingPlatformWarehousingUpdateParam.getCrmProjectInformationWarehousingId() != null) {
            List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
                     .isNull(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId)
                     .eq(CrmBiddingPlatformWarehousing::getCrmEnterpriseWarehousingId, biddingPlatformWarehousingUpdateParam.getCrmEnterpriseWarehousingId())
               );
            Preconditions.checkArgument(CollectionUtil.isEmpty(crmBiddingPlatformWarehousings), "当前企业下的供应商备案已存在");
            CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService
               .getById(biddingPlatformWarehousingUpdateParam.getCrmProjectInformationWarehousingId());
            projectInformationWarehousing.setCrmEnterpriseWarehousingId(biddingPlatformWarehousingUpdateParam.getCrmEnterpriseWarehousingId());
            this.baseService.updateById(projectInformationWarehousing);
         }

         CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = BeanUtil.copy(
            crmFilingTaskGrantUpdateParam.getCrmBiddingPlatformWarehousingUpdateParam(), CrmBiddingPlatformWarehousing.class
         );
         crmBiddingPlatformWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.UN_RECORD.getType());
         crmBiddingPlatformWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.TO_BE_CLAIMED.getType());
         crmBiddingPlatformWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
         crmBiddingPlatformWarehousing.setSerialNumber(
            this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.BIDDING_PLATFORM_FILING.getType())
         );
         if (CollectionUtil.isNotEmpty(crmFilingTaskGrantUpdateParam.getCrmBiddingPlatformWarehousingUpdateParam().getAttachmentIds())) {
            crmBiddingPlatformWarehousing.setAttachmentIds(
               org.apache.commons.lang3.StringUtils.join(
                  crmFilingTaskGrantUpdateParam.getCrmBiddingPlatformWarehousingUpdateParam()
                     .getAttachmentIds()
                     .stream()
                     .map(AttachmentDTO::getId)
                     .collect(Collectors.toList()),
                  ","
               )
            );
         }

         this.crmBiddingPlatformWarehousingBiz.save(crmBiddingPlatformWarehousing);
      }

      if (crmFilingTaskGrantUpdateParam.getCrmGovernmentWarehousingUpdateParam() != null) {
         CrmGovernmentWarehousingUpdateParam governmentWarehousingUpdateParam = crmFilingTaskGrantUpdateParam.getCrmGovernmentWarehousingUpdateParam();
         if (governmentWarehousingUpdateParam.getCrmProjectInformationWarehousingId() != null) {
            List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.crmGovernmentWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
                     .isNull(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId)
                     .eq(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, governmentWarehousingUpdateParam.getCrmEnterpriseWarehousingId())
               );
            Preconditions.checkArgument(CollectionUtil.isEmpty(crmGovernmentWarehousings), "当前企业下的供应商备案已存在");
            CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService
               .getById(governmentWarehousingUpdateParam.getCrmProjectInformationWarehousingId());
            projectInformationWarehousing.setCrmEnterpriseWarehousingId(governmentWarehousingUpdateParam.getCrmEnterpriseWarehousingId());
            this.baseService.updateById(projectInformationWarehousing);
         }

         CrmGovernmentWarehousing crmGovernmentWarehousing = BeanUtil.copy(
            crmFilingTaskGrantUpdateParam.getCrmGovernmentWarehousingUpdateParam(), CrmGovernmentWarehousing.class
         );
         crmGovernmentWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.UN_RECORD.getType());
         crmGovernmentWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.TO_BE_CLAIMED.getType());
         crmGovernmentWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
         crmGovernmentWarehousing.setSerialNumber(this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.GOVERNMENT_FILING.getType()));
         if (CollectionUtil.isNotEmpty(crmFilingTaskGrantUpdateParam.getCrmGovernmentWarehousingUpdateParam().getAttachmentIds())) {
            crmGovernmentWarehousing.setAttachmentIds(
               org.apache.commons.lang3.StringUtils.join(
                  crmFilingTaskGrantUpdateParam.getCrmGovernmentWarehousingUpdateParam()
                     .getAttachmentIds()
                     .stream()
                     .map(AttachmentDTO::getId)
                     .collect(Collectors.toList()),
                  ","
               )
            );
         }

         this.crmGovernmentWarehousingBiz.save(crmGovernmentWarehousing);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目信息登记审批记录不存在");
      Preconditions.checkArgument(!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource()), "该单据由OA审批，请在OA中处理");
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService.getById(crmAuditCommonDTO.getDataId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.crmInformationValidityPeriodConfigBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            projectInformationWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            projectInformationWarehousing.setValidityOfRegistration(crmInformationValidityPeriodConfig.getValidityOfRegistration());
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            projectInformationWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.baseService.updateById(projectInformationWarehousing);
      }

      return Boolean.TRUE;
   }

   @Override
   public List<CrmCanBeReleasedSimpleDTO> canBeReleased() {
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(!UserUtil.getCurrentUser().isAdmin(), CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
         );
      List<CrmCanBeReleasedSimpleDTO> crmCanBeReleasedSimpleDTOS = new ArrayList<>();
      List<Long> crmSupplierWarehousingIds = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class))
         .stream()
         .map(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId)
         .collect(Collectors.toList());
      crmProjectInformationWarehousings.stream().filter(item -> !crmSupplierWarehousingIds.contains(item.getId())).forEach(item -> {
         CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
         copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT.getType());
         crmCanBeReleasedSimpleDTOS.add(copy);
      });
      List<Long> crmGovernmentWarehousingIds = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class))
         .stream()
         .map(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId)
         .collect(Collectors.toList());
      crmProjectInformationWarehousings.stream().filter(item -> !crmGovernmentWarehousingIds.contains(item.getId())).forEach(item -> {
         CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
         copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.GOVERNMENT_RECORD_PAGE_MANAGEMENT.getType());
         crmCanBeReleasedSimpleDTOS.add(copy);
      });
      List<Long> crmBiddingPlatformWarehousingIds = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class))
         .stream()
         .map(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId)
         .collect(Collectors.toList());
      crmProjectInformationWarehousings.stream().filter(item -> !crmBiddingPlatformWarehousingIds.contains(item.getId())).forEach(item -> {
         CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
         copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.getType());
         crmCanBeReleasedSimpleDTOS.add(copy);
      });
      return crmCanBeReleasedSimpleDTOS;
   }

   @Override
   public List<CrmProjectInformationWarehousingSimpleDTO> getCrmAllProjectInformationWarehousingSimpleList() {
      return this.baseService.list().stream().map(item -> BeanUtil.copy(item, CrmProjectInformationWarehousingSimpleDTO.class)).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean projectFilingQuash(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmProjectInformationWarehousing.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目审批不存在");
      if (!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
         wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         this.baseService.removeById(crmProjectInformationWarehousing.getId());
         this.wmsApproveRecordService.updateById(wmsApproveRecord);
         this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         return Boolean.TRUE;
      } else {
         Preconditions.checkArgument(StringUtils.isNotBlank(wmsApproveRecord.getRequestId()), "OA项目信息登记审批缺少requestId");
         User applicant = this.userService.getById(wmsApproveRecord.getApplicantId());
         Preconditions.checkArgument(applicant != null && applicant.getOaUserId() != null, "填报人未配置OA人员ID");
         ResultVO withdrawResult = this.oaBusinessProcessService
            .withdrawRequest(
               OaRevocationDTOParam.builder()
                  .requestId(wmsApproveRecord.getRequestId())
                  .isremind("0")
                  .remark("初鸣系统撤回项目信息登记审批")
                  .oaUserId(applicant.getOaUserId().toString())
                  .approveProcessType(wmsApproveRecord.getApproveProcessType())
                  .build()
            );
         Preconditions.checkArgument(
            withdrawResult != null && Long.valueOf(20000L).equals(withdrawResult.getCode()),
            withdrawResult == null ? "OA项目信息登记撤回失败" : withdrawResult.getMessage()
         );
         this.baseService.removeById(crmProjectInformationWarehousing.getId());
         return Boolean.TRUE;
      }
   }

   @Override
   public List<CrmCanBeReleasedSimpleDTO> canUpdateProjectList(Integer crmPageManagementConfigEnum, Long id) {
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
         );
      Map<Long, CrmProjectInformationWarehousing> map = crmProjectInformationWarehousings.stream()
         .collect(Collectors.toMap(CrmProjectInformationWarehousing::getId, Function.identity()));
      List<CrmCanBeReleasedSimpleDTO> crmCanBeReleasedSimpleDTOS = new ArrayList<>();
      if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.GOVERNMENT_RECORD_PAGE_MANAGEMENT.getType())) {
         CrmGovernmentWarehousing crmGovernmentWarehousing = this.crmGovernmentWarehousingBiz.getById(id);
         Preconditions.checkArgument(crmGovernmentWarehousing != null, "备案不存在");
         if (crmGovernmentWarehousing.getCrmProjectInformationWarehousingId() != null) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = map.get(crmGovernmentWarehousing.getCrmProjectInformationWarehousingId());
            crmCanBeReleasedSimpleDTOS.add(
               CrmCanBeReleasedSimpleDTO.builder()
                  .crmPageManagementConfigEnum(CrmPageManagementConfigEnum.GOVERNMENT_RECORD_PAGE_MANAGEMENT.getType())
                  .id(crmProjectInformationWarehousing.getId())
                  .projectName(crmProjectInformationWarehousing.getProjectName())
                  .build()
            );
         }

         List<Long> crmGovernmentWarehousingIds = this.crmGovernmentWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class))
            .stream()
            .map(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId)
            .collect(Collectors.toList());
         crmProjectInformationWarehousings.stream().filter(item -> !crmGovernmentWarehousingIds.contains(item.getId())).forEach(item -> {
            CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
            copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.GOVERNMENT_RECORD_PAGE_MANAGEMENT.getType());
            crmCanBeReleasedSimpleDTOS.add(copy);
         });
      }

      if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.getType())) {
         CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = this.crmBiddingPlatformWarehousingBiz.getById(id);
         Preconditions.checkArgument(crmBiddingPlatformWarehousing != null, "备案不存在");
         if (crmBiddingPlatformWarehousing.getCrmProjectInformationWarehousingId() != null) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = map.get(crmBiddingPlatformWarehousing.getCrmProjectInformationWarehousingId());
            crmCanBeReleasedSimpleDTOS.add(
               CrmCanBeReleasedSimpleDTO.builder()
                  .crmPageManagementConfigEnum(CrmPageManagementConfigEnum.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.getType())
                  .id(crmProjectInformationWarehousing.getId())
                  .projectName(crmProjectInformationWarehousing.getProjectName())
                  .build()
            );
         }

         List<Long> crmBiddingPlatformWarehousingIds = this.crmBiddingPlatformWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class))
            .stream()
            .map(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId)
            .collect(Collectors.toList());
         crmProjectInformationWarehousings.stream().filter(item -> !crmBiddingPlatformWarehousingIds.contains(item.getId())).forEach(item -> {
            CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
            copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.getType());
            crmCanBeReleasedSimpleDTOS.add(copy);
         });
      }

      if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT.getType())) {
         CrmSupplierWarehousing crmSupplierWarehousing = this.crmSupplierWarehousingBiz.getById(id);
         Preconditions.checkArgument(crmSupplierWarehousing != null, "备案不存在");
         if (crmSupplierWarehousing.getCrmProjectInformationWarehousingId() != null) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = map.get(crmSupplierWarehousing.getCrmProjectInformationWarehousingId());
            crmCanBeReleasedSimpleDTOS.add(
               CrmCanBeReleasedSimpleDTO.builder()
                  .crmPageManagementConfigEnum(CrmPageManagementConfigEnum.SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT.getType())
                  .id(crmProjectInformationWarehousing.getId())
                  .projectName(crmProjectInformationWarehousing.getProjectName())
                  .build()
            );
         }

         List<Long> crmSupplierWarehousingIds = this.crmSupplierWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class))
            .stream()
            .map(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId)
            .collect(Collectors.toList());
         crmProjectInformationWarehousings.stream().filter(item -> !crmSupplierWarehousingIds.contains(item.getId())).forEach(item -> {
            CrmCanBeReleasedSimpleDTO copy = BeanUtil.copy(item, CrmCanBeReleasedSimpleDTO.class);
            copy.setCrmPageManagementConfigEnum(CrmPageManagementConfigEnum.SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT.getType());
            crmCanBeReleasedSimpleDTOS.add(copy);
         });
      }

      return crmCanBeReleasedSimpleDTOS;
   }

   @Override
   public CrmProjectCanCarryOutTypeDTO projectCanCarryOutType(Long id) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      CrmProjectCanCarryOutTypeDTO crmProjectCanCarryOutTypeDTO = new CrmProjectCanCarryOutTypeDTO();
      if (projectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType())) {
         crmProjectCanCarryOutTypeDTO.setCanFollowUpStatus(Boolean.TRUE);
      } else {
         crmProjectCanCarryOutTypeDTO.setCanFollowUpStatus(Boolean.FALSE);
      }

      crmProjectCanCarryOutTypeDTO.setCanAbandonProjectTrackingStatus(Boolean.FALSE);
      crmProjectCanCarryOutTypeDTO.setCanBidApplicationStatus(Boolean.FALSE);
      crmProjectCanCarryOutTypeDTO.setCanPrequalificationStatus(Boolean.FALSE);
      if (!projectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType())) {
         return crmProjectCanCarryOutTypeDTO;
      }

      List<CrmPrequalificationRecord> list = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  Wrapper -> {
                     LambdaQueryWrapper var10000 = Wrapper.eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isEmpty(list)) {
         crmProjectCanCarryOutTypeDTO.setCanPrequalificationStatus(Boolean.TRUE);
      }

      List<CrmApplyForBidRecord> list1 = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  Wrapper -> {
                     LambdaQueryWrapper var10000 = Wrapper.eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isEmpty(list1)) {
         crmProjectCanCarryOutTypeDTO.setCanBidApplicationStatus(Boolean.TRUE);
      }

      List<CrmProjectAbandonRecord> crmProjectAbandonRecordList = this.crmProjectAbandonRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectAbandonRecord.class)
               .eq(CrmProjectAbandonRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  Wrapper -> {
                     LambdaQueryWrapper var10000 = Wrapper.eq(CrmProjectAbandonRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmProjectAbandonRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      List<CrmPrequalificationRecord> prequalificationRecordList = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      if (!projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
         && !projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
         && !projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
         && CollectionUtil.isEmpty(crmProjectAbandonRecordList)
         && CollectionUtil.isEmpty(prequalificationRecordList)
         && CollectionUtil.isEmpty(crmApplyForBidRecords)) {
         crmProjectCanCarryOutTypeDTO.setCanAbandonProjectTrackingStatus(Boolean.TRUE);
      }

      return crmProjectCanCarryOutTypeDTO;
   }

   @Override
   public CrmThisProjectBindEnterRecordInfoDTO thisProjectBindEnterRecordInfo(Long id) {
      CrmThisProjectBindEnterRecordInfoDTO crmThisProjectBindEnterRecordInfoDTO = new CrmThisProjectBindEnterRecordInfoDTO();
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.crmGovernmentWarehousingBiz
         .getOne(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId, id));
      if (crmGovernmentWarehousing != null && crmGovernmentWarehousing.getCrmEnterpriseWarehousingId() != null) {
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmGovernmentWarehousing.getCrmEnterpriseWarehousingId());
         crmThisProjectBindEnterRecordInfoDTO.setId(crmEnterpriseWarehousing.getId());
         crmThisProjectBindEnterRecordInfoDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      if (crmThisProjectBindEnterRecordInfoDTO.getId() != null) {
         return crmThisProjectBindEnterRecordInfoDTO;
      }

      CrmSupplierWarehousing crmSupplierWarehousing = this.crmSupplierWarehousingBiz
         .getOne(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId, id));
      if (crmSupplierWarehousing != null && crmSupplierWarehousing.getCrmEnterpriseWarehousingId() != null) {
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmSupplierWarehousing.getCrmEnterpriseWarehousingId());
         crmThisProjectBindEnterRecordInfoDTO.setId(crmEnterpriseWarehousing.getId());
         crmThisProjectBindEnterRecordInfoDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      if (crmThisProjectBindEnterRecordInfoDTO.getId() != null) {
         return crmThisProjectBindEnterRecordInfoDTO;
      }

      CrmBiddingPlatformWarehousing crmBiddingPlatformWarehousing = this.crmBiddingPlatformWarehousingBiz
         .getOne(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId, id));
      if (crmBiddingPlatformWarehousing != null && crmBiddingPlatformWarehousing.getCrmEnterpriseWarehousingId() != null) {
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz
            .getById(crmBiddingPlatformWarehousing.getCrmEnterpriseWarehousingId());
         crmThisProjectBindEnterRecordInfoDTO.setId(crmEnterpriseWarehousing.getId());
         crmThisProjectBindEnterRecordInfoDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      return crmThisProjectBindEnterRecordInfoDTO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getCrmProjectInformationWarehousingListDownLoad(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName
   ) {
      String yyyy = null;
      if (informantDateTime != null) {
         yyyy = informantDateTime.format(DateTimeFormatter.ofPattern("yyyy"));
      }

      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .like(StringUtils.isNotBlank(informantUserName), CrmProjectInformationWarehousing::getInformantUserName, informantUserName)
               .eq(structureTypeConfigurationId != null, CrmProjectInformationWarehousing::getStructureTypeConfigurationId, structureTypeConfigurationId)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .apply(StringUtils.isNotBlank(yyyy), "DATE_FORMAT(informant_date_time, '%Y') = {0}", yyyy)
               .eq(!UserUtil.getCurrentUser().isAdmin(), CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
               .eq(crmCheckStatusEnum != null, CrmProjectInformationWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(keyProjectId != null, CrmProjectInformationWarehousing::getKeyProjectId, keyProjectId)
               .eq(projectLevelConfigId != null, CrmProjectInformationWarehousing::getProjectLevelConfigId, projectLevelConfigId)
               .eq(crmProjectScheduleTypeEnum != null, CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, crmProjectScheduleTypeEnum)
               .and(
                  projectNameOrRecordNumber != null,
                  q -> {
                     LambdaQueryWrapper var10000 = q.like(CrmProjectInformationWarehousing::getProjectName, projectNameOrRecordNumber)
                        .or()
                        .like(CrmProjectInformationWarehousing::getSerialNumber, projectNameOrRecordNumber);
                  }
               )
               .orderByDesc(BaseEntity::getCreateTime)
         );
      Map<Long, CrmProjectInformationConfig> map = this.crmProjectInformationConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      List<Map<String, Object>> collect = crmProjectInformationWarehousings.stream()
         .map(
            item -> {
               CrmProjectInformationWarehousingDownLoadDTO crmProjectInformationWarehousingDTO = new CrmProjectInformationWarehousingDownLoadDTO();
               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(item.getCountryName());
               stringBuilder.append(item.getProvinceName());
               stringBuilder.append(item.getCityName());
               stringBuilder.append(item.getRegionName());
               crmProjectInformationWarehousingDTO.setRegionNameList(stringBuilder.toString());
               crmProjectInformationWarehousingDTO.setEstimatedWorks(item.getEstimatedWorks());
               crmProjectInformationWarehousingDTO.setEstimatedCost(item.getEstimatedCost());
               crmProjectInformationWarehousingDTO.setAreaOfStructure(item.getAreaOfStructure());
               if (item.getStructureTypeConfigurationId() != null) {
                  crmProjectInformationWarehousingDTO.setStructureTypeConfigurationName(map.get(item.getStructureTypeConfigurationId()).getName());
               }

               crmProjectInformationWarehousingDTO.setAddress(item.getAddress());
               crmProjectInformationWarehousingDTO.setInformantUserName(item.getInformantUserName());
               crmProjectInformationWarehousingDTO.setCrmProjectScheduleTypeEnum(item.getCrmProjectScheduleTypeEnum());
               crmProjectInformationWarehousingDTO.setId(item.getId());
               crmProjectInformationWarehousingDTO.setSerialNumber(item.getSerialNumber());
               crmProjectInformationWarehousingDTO.setInformantDateTime(item.getInformantDateTime());
               crmProjectInformationWarehousingDTO.setCrmCheckStatusEnum(item.getCrmCheckStatusEnum());
               crmProjectInformationWarehousingDTO.setProjectName(item.getProjectName());
               if (item.getKeyProjectId() != null) {
                  crmProjectInformationWarehousingDTO.setKeyProjectName(map.get(item.getKeyProjectId()).getName());
               }

               if (item.getProjectLevelConfigId() != null) {
                  crmProjectInformationWarehousingDTO.setProjectLevelConfigName(map.get(item.getProjectLevelConfigId()).getName());
               }

               crmProjectInformationWarehousingDTO.setCrmProjectScheduleTypeEnumName(
                  CrmProjectScheduleTypeEnum.getNameByType(item.getCrmProjectScheduleTypeEnum())
               );
               CrmprojectInformationWarehousingFollowUpTimesAndDateDTO upTimesAndDate = this.crmProjectFollowUpRecordBiz.getFollowUpTimesAndDate(item.getId());
               crmProjectInformationWarehousingDTO.setFollowUpTimes(upTimesAndDate.getFollowUpTimes() != null ? upTimesAndDate.getFollowUpTimes() : 0);
               crmProjectInformationWarehousingDTO.setEffectiveRemainingTime(
                  upTimesAndDate.getEffectiveRemainingTime() != null ? upTimesAndDate.getEffectiveRemainingTime() : 0
               );
               if (item.getCreateUserId() != null) {
                  crmProjectInformationWarehousingDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
               }

               return crmProjectInformationWarehousingDTO;
            }
         )
         .collect(Collectors.toList())
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmCheckProjectHaveRecordingDTO checkProjectHaveRecording(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案信息不存在");
      CrmCheckProjectHaveRecordingDTO crmCheckProjectHaveRecordingDTO = new CrmCheckProjectHaveRecordingDTO();
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
               .eq(CrmProjectFollowUpRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHaveFollowUp(!CollectionUtil.isEmpty(crmProjectFollowUpRecords));
      List<CrmPrequalificationRecord> crmPreQualificationRecords = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHavePreQualification(!CollectionUtil.isEmpty(crmPreQualificationRecords));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHaveApplyForBidRecord(!CollectionUtil.isEmpty(crmApplyForBidRecords));
      return crmCheckProjectHaveRecordingDTO;
   }

   @Override
   public CrmCheckProjectHaveRecordingDTO checkProjectHaveRecordingCustom(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案信息不存在");
      CrmCheckProjectHaveRecordingDTO crmCheckProjectHaveRecordingDTO = new CrmCheckProjectHaveRecordingDTO();
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
               .eq(CrmProjectFollowUpRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHaveFollowUp(!CollectionUtil.isEmpty(crmProjectFollowUpRecords));
      List<CrmPrequalificationRecord> crmPreQualificationRecords = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHavePreQualification(!CollectionUtil.isEmpty(crmPreQualificationRecords));
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, id)
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, id)
         );
      List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
         );
      List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
         );
      crmCheckProjectHaveRecordingDTO.setHaveApplyForBidRecord(
         !CollectionUtil.isEmpty(crmApplyBusinessBiddingRecords)
            || !CollectionUtil.isEmpty(crmApplyTechnologyBiddingRecords)
            || !CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)
            || !CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords)
      );
      return crmCheckProjectHaveRecordingDTO;
   }

   @Override
   public CrmProjectCanCarryOutTypeDTOV2 projectCanCarryOutTypeCustom(Long id) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      CrmProjectCanCarryOutTypeDTOV2 crmProjectCanCarryOutTypeDTOV2 = new CrmProjectCanCarryOutTypeDTOV2();
      if (projectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType())) {
         crmProjectCanCarryOutTypeDTOV2.setCanFollowUpStatus(Boolean.TRUE);
      } else {
         crmProjectCanCarryOutTypeDTOV2.setCanFollowUpStatus(Boolean.FALSE);
      }

      crmProjectCanCarryOutTypeDTOV2.setCanAbandonProjectTrackingStatus(Boolean.FALSE);
      crmProjectCanCarryOutTypeDTOV2.setCanBidApplicationStatus(Boolean.FALSE);
      crmProjectCanCarryOutTypeDTOV2.setCanPrequalificationStatus(Boolean.FALSE);
      if (!projectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType())) {
         return crmProjectCanCarryOutTypeDTOV2;
      }

      List<CrmPrequalificationRecord> list = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  Wrapper -> {
                     LambdaQueryWrapper var10000 = Wrapper.eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isEmpty(list)) {
         crmProjectCanCarryOutTypeDTOV2.setCanPrequalificationStatus(Boolean.TRUE);
      }

      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
                        .or()
                        .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType());
                  }
               )
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isEmpty(crmApplyBusinessBiddingRecords)
         || CollectionUtil.isEmpty(crmApplyTechnologyBiddingRecords)
         || CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords)
         || CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
         crmProjectCanCarryOutTypeDTOV2.setCanBidApplicationStatus(Boolean.TRUE);
      }

      List<CrmProjectAbandonRecord> crmProjectAbandonRecordList = this.crmProjectAbandonRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectAbandonRecord.class)
               .eq(CrmProjectAbandonRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmProjectAbandonRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      List<CrmPrequalificationRecord> prequalificationRecordList = this.crmPrequalificationRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      if (!projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
         && !projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
         && !projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
         && !projectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType())
         && CollectionUtil.isEmpty(crmProjectAbandonRecordList)
         && CollectionUtil.isEmpty(prequalificationRecordList)
         && CollectionUtil.isEmpty(crmApplyBusinessBiddingRecords)
         && CollectionUtil.isEmpty(crmApplyTechnologyBiddingRecords)
         && CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords)
         && CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
         crmProjectCanCarryOutTypeDTOV2.setCanAbandonProjectTrackingStatus(Boolean.TRUE);
      }

      return crmProjectCanCarryOutTypeDTOV2;
   }

   @Override
   public List<Integer> getCanBidApplicationType(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null);
      List<Integer> list = new ArrayList<>();
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
                        .or()
                        .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType());
                  }
               )
         );
      if (CollectionUtil.isNotEmpty(crmApplyBusinessBiddingRecords)) {
         list.add(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType());
      }

      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isNotEmpty(crmApplyTechnologyBiddingRecords)) {
         list.add(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
      }

      List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isNotEmpty(crmApplyDeepDesignBiddingRecords)) {
         list.add(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType());
      }

      List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
               .and(
                  q -> {
                     LambdaQueryWrapper var10000 = q.eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                        .or()
                        .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType());
                  }
               )
         );
      if (CollectionUtil.isNotEmpty(crmApplyStructuralDesignBiddingRecords)) {
         list.add(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType());
      }

      return list;
   }

   private static class RelatedUnit {
      private static final CrmProjectInformationWarehousingBizImpl.RelatedUnit EMPTY = new CrmProjectInformationWarehousingBizImpl.RelatedUnit(
         null, null, null, null
      );
      private final String name;
      private final String contactName;
      private final String office;
      private final String phone;

      private RelatedUnit(String name, String contactName, String office, String phone) {
         this.name = name;
         this.contactName = contactName;
         this.office = office;
         this.phone = phone;
      }
   }
}
