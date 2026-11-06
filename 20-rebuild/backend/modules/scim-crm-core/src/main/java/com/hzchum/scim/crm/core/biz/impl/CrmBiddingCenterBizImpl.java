package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingCenterBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmBiddingRegulationsTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectBidStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequirementTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.ArchivesManagementListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.ArchivesManagementListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmHeadFillOutDetail;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectDocumentationListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectDocumentationListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRegionCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheProjectLeaderDetailsDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheProjectLeaderDetailsDTOV2;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParamV2;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParamV2;
import com.hzchum.scim.crm.core.mapper.CrmBiddingCenterMapper;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationWarehousingMapper;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.enums.SysModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmBiddingCenterBizImpl implements CrmBiddingCenterBiz {
   @Resource
   private CrmBiddingCenterMapper crmBiddingCenterMapper;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private UserService userService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;
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
   @Resource
   private CrmProjectInformationWarehousingMapper crmProjectInformationWarehousingMapper;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;

   @Override
   public PageVO<CrmTenderListDTO> getCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> crmProjectIds = new ArrayList<>();
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (CollectionUtil.isEmpty(crmProjectIds)) {
            return new PageVO<>();
         }
      }

      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .in(CollectionUtil.isNotEmpty(crmProjectIds), CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, crmProjectIds)
         );
      if (CollectionUtil.isEmpty(crmApplyForBidRecords)) {
         return new PageVO<>();
      }

      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmTenderListDTO> crmTenderListDTOS = this.crmBiddingCenterMapper
         .getCrmTenderList(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList()),
            crmTenderRequirementTypeEnum,
            crmCanLookDeptIds,
            UserUtil.getCurrentUserId()
         );

      for (CrmTenderListDTO crmTenderListDTO : crmTenderListDTOS) {
         if (StringUtils.isNotBlank(crmTenderListDTO.getProjectInformantUserIds())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmTenderListDTO.getProjectInformantUserIds(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong)).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTenderListDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }
      }

      return new PageVO<>(objects, crmTenderListDTOS);
   }

   private CrmRegionCommonDTO getRegionInfo(List<Long> regionIds) {
      CrmRegionCommonDTO crmRegionCommonDTO = new CrmRegionCommonDTO();
      if (CollectionUtil.isNotEmpty(regionIds)) {
         for (int i = 0; i < regionIds.size(); i++) {
            if (i == 0) {
               crmRegionCommonDTO.setCountryId(regionIds.get(i));
            } else if (i == 1) {
               crmRegionCommonDTO.setProvinceId(regionIds.get(i));
            } else if (i == 2) {
               crmRegionCommonDTO.setCityId(regionIds.get(i));
            } else if (i == 3) {
               crmRegionCommonDTO.setRegionId(regionIds.get(i));
            }
         }
      }

      return crmRegionCommonDTO;
   }

   @Override
   public HashMap<String, Object> getTenderListSummary(Integer crmTenderRequirementTypeEnum) {
      HashMap<String, Object> map = new HashMap<>();
      map.put("notAppointedCount", 0);
      map.put("ongoingCount", 0);
      map.put("doneCount", 0);
      map.put("winningBidCount", 0);
      if (crmTenderRequirementTypeEnum != null) {
         List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
            .list(Wrappers.lambdaQuery(CrmApplyForBidRecord.class).eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType()));
         if (CollectionUtil.isEmpty(crmApplyForBidRecords)) {
            return map;
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList;
            if (CollectionUtil.isEmpty(deptSet)) {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else if (deptSet.contains(0L)) {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .and(qr -> {
                           qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                           qr.or();
                           qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                        })
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> item.getBusinessCrmProjectBidStatus() != null
                        && item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> item.getBusinessCrmProjectBidStatus() != null
                        && item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> item.getBusinessCrmProjectBidStatus() != null
                        && item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmProjectInformationWarehousing> var8;
            if (CollectionUtil.isEmpty(deptSet)) {
               var8 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else if (deptSet.contains(0L)) {
               var8 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .and(qr -> {
                           qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                           qr.or();
                           qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                        })
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else {
               var8 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               var8.stream()
                  .filter(
                     item -> item.getTechnologyCrmProjectBidStatus() != null
                        && item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               var8.stream()
                  .filter(
                     item -> item.getTechnologyCrmProjectBidStatus() != null
                        && item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               var8.stream()
                  .filter(
                     item -> item.getTechnologyCrmProjectBidStatus() != null
                        && item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               var8.stream().filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())).count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmProjectInformationWarehousing> var9;
            if (CollectionUtil.isEmpty(deptSet)) {
               var9 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else if (deptSet.contains(0L)) {
               var9 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            } else {
               var9 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList())
                        )
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .and(
                           q -> {
                              LambdaQueryWrapper var10000 = q.eq(
                                    CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum,
                                    CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                                 )
                                 .or()
                                 .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                           }
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               var9.stream()
                  .filter(
                     item -> item.getDeviseCrmProjectBidStatus() != null
                        && item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               var9.stream()
                  .filter(
                     item -> item.getDeviseCrmProjectBidStatus() != null
                        && item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               var9.stream()
                  .filter(
                     item -> item.getDeviseCrmProjectBidStatus() != null && item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               var9.stream().filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())).count()
            );
         }
      }

      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setTenderHead(CrmSetTenderHeadParam crmSetTenderHeadParam) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmSetTenderHeadParam.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      if (crmSetTenderHeadParam.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         projectInformationWarehousing.setBusinessProjectBidManagerUserId(
            org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParam.getProjectBidManagerUserIdList(), ",")
         );
         projectInformationWarehousing.setBusinessProjectBidManagerFinishDate(crmSetTenderHeadParam.getProjectBidManagerFinishDate());
         projectInformationWarehousing.setBusinessDifficultyFactorId(crmSetTenderHeadParam.getDifficultyFactorId());
         projectInformationWarehousing.setBusinessCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
      }

      if (crmSetTenderHeadParam.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         projectInformationWarehousing.setTechnologyProjectBidManagerUserId(
            org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParam.getProjectBidManagerUserIdList(), ",")
         );
         projectInformationWarehousing.setTechnologyProjectBidManagerFinishDate(crmSetTenderHeadParam.getProjectBidManagerFinishDate());
         projectInformationWarehousing.setTechnologyDifficultyFactorId(crmSetTenderHeadParam.getDifficultyFactorId());
         projectInformationWarehousing.setTechnologyCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
         projectInformationWarehousing.setTechnologyBidManagerJobDescriptionId(crmSetTenderHeadParam.getTechnologyBidManagerJobDescriptionId());
         projectInformationWarehousing.setTechnologyBidManagerRenderings(crmSetTenderHeadParam.getTechnologyBidManagerRenderings());
         projectInformationWarehousing.setTechnologyBidManagerStructureName(crmSetTenderHeadParam.getTechnologyBidManagerStructureName());
         projectInformationWarehousing.setTechnologyBidManagerCompletion(crmSetTenderHeadParam.getTechnologyBidManagerCompletion());
         projectInformationWarehousing.setTechnologyBidManagerBusinessTrip(crmSetTenderHeadParam.getTechnologyBidManagerBusinessTrip());
         projectInformationWarehousing.setTechnologyBidManagerCustomerReception(crmSetTenderHeadParam.getTechnologyBidManagerCustomerReception());
         projectInformationWarehousing.setTechnologyBidManagerRemarks(crmSetTenderHeadParam.getTechnologyBidManagerRemarks());
      }

      if (crmSetTenderHeadParam.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
         projectInformationWarehousing.setDeviseProjectBidManagerUserId(
            org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParam.getProjectBidManagerUserIdList(), ",")
         );
         projectInformationWarehousing.setDeviseProjectBidManagerFinishDate(crmSetTenderHeadParam.getProjectBidManagerFinishDate());
         projectInformationWarehousing.setDeviseDifficultyFactorId(crmSetTenderHeadParam.getDifficultyFactorId());
         projectInformationWarehousing.setDeviseCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
      }

      return this.crmProjectInformationWarehousingBiz.updateById(projectInformationWarehousing);
   }

   @Override
   public PageVO<CrmMyTenderListDTO> getMyCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> crmProjectIds = new ArrayList<>();
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                     .apply("FIND_IN_SET({0}, business_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .apply("FIND_IN_SET({0}, technology_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .apply("FIND_IN_SET({0}, devise_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (CollectionUtil.isEmpty(crmProjectIds)) {
            return new PageVO<>();
         }
      }

      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .in(CollectionUtil.isNotEmpty(crmProjectIds), CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, crmProjectIds)
         );
      if (CollectionUtil.isEmpty(crmApplyForBidRecords)) {
         return new PageVO<>();
      }

      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmMyTenderListDTO> crmTenderListDTOS = this.crmBiddingCenterMapper
         .getMyCrmTenderList(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList()),
            crmTenderRequirementTypeEnum,
            UserUtil.getCurrentUserId()
         );
      if (CollectionUtil.isNotEmpty(crmTenderListDTOS)) {
         crmTenderListDTOS.forEach(item -> {
            if (StringUtils.isNotBlank(item.getProjectBidManagerUserName()) && StringUtils.isNotBlank(item.getProjectBidManagerUserName())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(item.getProjectBidManagerUserName(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               item.setProjectBidManagerUserName(stringBuilder.toString());
            }
         });
      }

      return new PageVO<>(objects, crmTenderListDTOS);
   }

   @Override
   public HashMap<String, Object> getMyTenderListSummary(Integer crmTenderRequirementTypeEnum) {
      HashMap<String, Object> map = new HashMap<>();
      map.put("myTaskCount", 0);
      map.put("ongoingCount", 0);
      map.put("doneCount", 0);
      map.put("winningBidCount", 0);
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .apply("FIND_IN_SET({0}, business_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType()))
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType()))
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getBusinessCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType()))
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .apply("FIND_IN_SET({0}, technology_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType()))
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType()))
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getTechnologyCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType()))
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .apply("FIND_IN_SET({0}, devise_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
                     .and(
                        q -> {
                           LambdaQueryWrapper var10000 = q.eq(
                                 CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()
                              )
                              .or()
                              .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType());
                        }
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType()))
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType()))
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getDeviseCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType()))
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }
      }

      return map;
   }

   @Transactional
   @Override
   public Boolean uploadTenderDocuments(CrmUploadTenderDocumentsParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(copy.getAttachmentDTOList()), "请先上传附件");
      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         crmProjectInformationWarehousing.setBusinessBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmProjectInformationWarehousing.setBusinessCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerQuote(copy.getBusinessProjectBidManagerQuote());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerActualFinishDate(LocalDateTime.now());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerEstimatedWorks(copy.getBusinessProjectBidManagerEstimatedWorks());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerCost(copy.getBusinessProjectBidManagerCost());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerGrossProfit(copy.getBusinessProjectBidManagerGrossProfit());
         crmProjectInformationWarehousing.setBusinessProjectBidManagerRemark(copy.getBusinessProjectBidManagerRemark());
      }

      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         crmProjectInformationWarehousing.setTechnologyBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmProjectInformationWarehousing.setTechnologyCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
         crmProjectInformationWarehousing.setTechnologyProjectBidManagerActualFinishDate(LocalDateTime.now());
      }

      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
         crmProjectInformationWarehousing.setDeviseBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmProjectInformationWarehousing.setDeviseProjectBidManagerActualFinishDate(LocalDateTime.now());
         crmProjectInformationWarehousing.setDeviseCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
      }

      this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }

   @Override
   public CrmTheProjectLeaderDetailsDTO detailsOfTheProjectLeader(Integer crmTenderRequirementTypeEnum, Long crmProjectInformationWarehousingId) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmTheProjectLeaderDetailsDTO crmTheProjectLeaderDetailsDTO = new CrmTheProjectLeaderDetailsDTO();
      crmTheProjectLeaderDetailsDTO.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousingId);
      crmTheProjectLeaderDetailsDTO.setCrmTenderRequirementTypeEnum(crmTenderRequirementTypeEnum);
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(item -> item.getId(), Function.identity()));
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getBusinessProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTO.setDifficultyFactorId(crmProjectInformationWarehousing.getBusinessDifficultyFactorId());
         if (crmProjectInformationWarehousing.getBusinessDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTO.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getBusinessDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTO.setBidManagerAttachments(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getBusinessBidManagerAttachmentIds())
         );
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getTechnologyProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTO.setDifficultyFactorId(crmProjectInformationWarehousing.getTechnologyDifficultyFactorId());
         if (crmProjectInformationWarehousing.getTechnologyDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTO.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getTechnologyDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTO.setBidManagerAttachments(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getTechnologyBidManagerAttachmentIds())
         );
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
         if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getDeviseProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTO.setDifficultyFactorId(crmProjectInformationWarehousing.getDeviseDifficultyFactorId());
         if (crmProjectInformationWarehousing.getDeviseDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTO.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmProjectInformationWarehousing.getDeviseDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTO.setBidManagerAttachments(
            this.attachmentService.listByIds(crmProjectInformationWarehousing.getDeviseBidManagerAttachmentIds())
         );
      }

      return crmTheProjectLeaderDetailsDTO;
   }

   @Override
   public PageVO<ArchivesManagementListDTO> archivesManagementList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(applyForBidReporterName), User::getName, applyForBidReporterName))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      if (CollectionUtil.isEmpty(userMap)) {
         return new PageVO<>();
      }

      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .like(StringUtils.isNotBlank(applyForBidReporterName), CrmApplyForBidRecord::getInformantUserName, applyForBidReporterName)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Map<Long, CrmApplyForBidRecord> bidRecordMap = crmApplyForBidRecords.stream().collect(Collectors.toMap(CrmApplyForBidRecord::getId, Function.identity()));
      Map<Long, CrmApplyForBidRecord> forBidRecordMap = crmApplyForBidRecords.stream()
         .collect(Collectors.toMap(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, Function.identity()));
      if (CollectionUtil.isEmpty(bidRecordMap)) {
         return new PageVO<>();
      }

      Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      new ArrayList();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings;
      if (CollectionUtil.isEmpty(crmCanLookInfoDeptIdsByModuleAndUserId)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  .apply(
                     startDate != null && endDate != null,
                     "date_format(create_time, '%Y-%m-%d') BETWEEN {0} AND {1}",
                     startDate != null ? startDate.toLocalDate() : null,
                     endDate != null ? endDate.toLocalDate() : null
                  )
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .and(
                     StringUtils.isNotBlank(headUserName),
                     q -> {
                        LambdaQueryWrapper var10000 = q.in(
                              StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet()
                           )
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet());
                     }
                  )
                  .orderByDesc(BaseEntity::getCreateTime)
            );
      } else if (crmCanLookInfoDeptIdsByModuleAndUserId.contains(0L)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .and(qr -> {
                     qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId);
                     qr.or();
                     qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                  })
                  .apply(
                     startDate != null && endDate != null,
                     "date_format(create_time, '%Y-%m-%d') BETWEEN {0} AND {1}",
                     startDate != null ? startDate.toLocalDate() : null,
                     endDate != null ? endDate.toLocalDate() : null
                  )
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .and(
                     StringUtils.isNotBlank(headUserName),
                     q -> {
                        LambdaQueryWrapper var10000 = q.in(
                              StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet()
                           )
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet());
                     }
                  )
                  .orderByDesc(BaseEntity::getCreateTime)
            );
      } else {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId)
                  .apply(
                     startDate != null && endDate != null,
                     "date_format(create_time, '%Y-%m-%d') BETWEEN {0} AND {1}",
                     startDate != null ? startDate.toLocalDate() : null,
                     endDate != null ? endDate.toLocalDate() : null
                  )
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .and(
                     StringUtils.isNotBlank(headUserName),
                     q -> {
                        LambdaQueryWrapper var10000 = q.in(
                              StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet()
                           )
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                           .or()
                           .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet());
                     }
                  )
                  .orderByDesc(BaseEntity::getCreateTime)
            );
      }

      if (CollectionUtil.isEmpty(crmProjectInformationWarehousings)) {
         return new PageVO<>();
      }

      List<ArchivesManagementListDTO> archivesManagementListDTOS = new ArrayList<>();

      for (CrmProjectInformationWarehousing crmProjectInformationWarehousing : crmProjectInformationWarehousings) {
         ArchivesManagementListDTO archivesManagementListDTO = ArchivesManagementListDTO.builder().build();
         archivesManagementListDTO.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousing.getId());
         archivesManagementListDTO.setCreateTime(crmProjectInformationWarehousing.getCreateTime());
         archivesManagementListDTO.setDepartmentName(departmentMap.get(crmProjectInformationWarehousing.getDepartmentId()));
         archivesManagementListDTO.setProjectName(crmProjectInformationWarehousing.getProjectName());
         archivesManagementListDTO.setSerialNumber(crmProjectInformationWarehousing.getSerialNumber());
         if (forBidRecordMap.get(crmProjectInformationWarehousing.getId()) != null) {
            archivesManagementListDTO.setHeadOfCommerceName(forBidRecordMap.get(crmProjectInformationWarehousing.getId()).getInformantUserName());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getBusinessProjectBidManagerFinishDate());
            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getTechnologyProjectBidManagerFinishDate());
            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getDeviseProjectBidManagerFinishDate());
         }

         archivesManagementListDTOS.add(archivesManagementListDTO);
      }

      return new PageVO<>(objects, archivesManagementListDTOS);
   }

   @Override
   public List<CrmProjectDocumentationListDTO> projectDocumentationList(Integer crmTenderRequirementTypeEnum, Long crmProjectInformationWarehousingId) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案信息不存在");
      Map<Long, CrmApplyForBidRecord> bidRecordMap = this.crmApplyForBidRecordBiz
         .list(Wrappers.lambdaQuery(CrmApplyForBidRecord.class).eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType()))
         .stream()
         .collect(Collectors.toMap(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, Function.identity()));
      List<CrmProjectDocumentationListDTO> crmProjectDocumentationListDTOS = new ArrayList<>();
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         if (StringUtils.isNotBlank(projectInformationWarehousing.getBusinessBidManagerAttachmentIds())) {
            List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(projectInformationWarehousing.getBusinessBidManagerAttachmentIds());
            attachmentDTOList.forEach(
               item -> crmProjectDocumentationListDTOS.add(
                  CrmProjectDocumentationListDTO.builder()
                     .createTime(item.getCreateTime())
                     .importUserName(item.getCreateUserName())
                     .fileTypeName("投标文件")
                     .attachmentDTO(item)
                     .build()
               )
            );
         }

         CrmApplyForBidRecord crmApplyForBidRecord = bidRecordMap.get(projectInformationWarehousing.getId());
         if (crmApplyForBidRecord != null && StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
            this.attachmentService
               .listByIds(crmApplyForBidRecord.getAttachmentIds())
               .forEach(
                  item -> crmProjectDocumentationListDTOS.add(
                     CrmProjectDocumentationListDTO.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("招标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         if (StringUtils.isNotBlank(projectInformationWarehousing.getBusinessBidManagerAttachmentIds())) {
            List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(projectInformationWarehousing.getTechnologyBidManagerAttachmentIds());
            attachmentDTOList.forEach(
               item -> crmProjectDocumentationListDTOS.add(
                  CrmProjectDocumentationListDTO.builder()
                     .createTime(item.getCreateTime())
                     .importUserName(item.getCreateUserName())
                     .fileTypeName("投标文件")
                     .attachmentDTO(item)
                     .build()
               )
            );
         }

         CrmApplyForBidRecord crmApplyForBidRecord = bidRecordMap.get(projectInformationWarehousing.getId());
         if (crmApplyForBidRecord != null && StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
            this.attachmentService
               .listByIds(crmApplyForBidRecord.getAttachmentIds())
               .forEach(
                  item -> crmProjectDocumentationListDTOS.add(
                     CrmProjectDocumentationListDTO.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("招标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
         if (StringUtils.isNotBlank(projectInformationWarehousing.getBusinessBidManagerAttachmentIds())) {
            List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(projectInformationWarehousing.getDeviseBidManagerAttachmentIds());
            attachmentDTOList.forEach(
               item -> crmProjectDocumentationListDTOS.add(
                  CrmProjectDocumentationListDTO.builder()
                     .createTime(item.getCreateTime())
                     .importUserName(item.getCreateUserName())
                     .fileTypeName("投标文件")
                     .attachmentDTO(item)
                     .build()
               )
            );
         }

         CrmApplyForBidRecord crmApplyForBidRecord = bidRecordMap.get(projectInformationWarehousing.getId());
         if (crmApplyForBidRecord != null && StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
            this.attachmentService
               .listByIds(crmApplyForBidRecord.getAttachmentIds())
               .forEach(
                  item -> crmProjectDocumentationListDTOS.add(
                     CrmProjectDocumentationListDTO.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("招标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
         }
      }

      return crmProjectDocumentationListDTOS;
   }

   @Override
   public CrmApplyForBidRecordDetailDTO getTenderDetail(Long id, Integer crmTenderRequirementTypeEnum) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(id);
      CrmApplyForBidRecord crmApplyForBidRecord = this.crmApplyForBidRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
         );
      Preconditions.checkArgument(crmApplyForBidRecord != null, "投标申请id不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
      }

      CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailDTO = BeanUtil.copy(crmApplyForBidRecord, CrmApplyForBidRecordDetailDTO.class);
      crmApplyForBidRecordDetailDTO.setBusinessProjectBidManagerQuote(projectInformationWarehousing.getBusinessProjectBidManagerQuote());
      crmApplyForBidRecordDetailDTO.setBusinessProjectBidManagerEstimatedWorks(projectInformationWarehousing.getBusinessProjectBidManagerEstimatedWorks());
      crmApplyForBidRecordDetailDTO.setBusinessProjectBidManagerCost(projectInformationWarehousing.getBusinessProjectBidManagerCost());
      crmApplyForBidRecordDetailDTO.setBusinessProjectBidManagerGrossProfit(projectInformationWarehousing.getBusinessProjectBidManagerGrossProfit());
      crmApplyForBidRecordDetailDTO.setBusinessProjectBidManagerRemark(projectInformationWarehousing.getBusinessProjectBidManagerRemark());
      if (projectInformationWarehousing.getTechnologyBidManagerJobDescriptionId() != null) {
         crmApplyForBidRecordDetailDTO.setTechnologyBidManagerJobDescriptionId(projectInformationWarehousing.getTechnologyBidManagerJobDescriptionId());
         crmApplyForBidRecordDetailDTO.setTechnologyBidManagerJobDescriptionName(
            this.crmTenderRequestConfigBiz.getById(projectInformationWarehousing.getTechnologyBidManagerJobDescriptionId()).getName()
         );
      }

      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerRenderings(projectInformationWarehousing.getTechnologyBidManagerRenderings());
      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerStructureName(projectInformationWarehousing.getTechnologyBidManagerStructureName());
      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerCompletion(projectInformationWarehousing.getTechnologyBidManagerCompletion());
      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerBusinessTrip(projectInformationWarehousing.getTechnologyBidManagerBusinessTrip());
      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerCustomerReception(projectInformationWarehousing.getTechnologyBidManagerCustomerReception());
      crmApplyForBidRecordDetailDTO.setTechnologyBidManagerRemarks(projectInformationWarehousing.getTechnologyBidManagerRemarks());
      if (crmEnterpriseWarehousing != null) {
         crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyForBidRecord.getCreateUserId()).getName());
      if (crmApplyForBidRecord.getInformantUserId() != null) {
         crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyForBidRecord.getInformantUserId()).getName());
      }

      if (crmApplyForBidRecord.getDepartmentId() != null) {
         crmApplyForBidRecordDetailDTO.setDepartmentName(this.departmentService.getDepartmentById(crmApplyForBidRecord.getDepartmentId()).getName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      if (crmApplyForBidRecord.getBiddingMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBiddingMethodName(this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBiddingMethodId()).getName());
      }

      if (crmApplyForBidRecord.getTenderSubmissionMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTenderSubmissionMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setSettlementMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      if (crmApplyForBidRecord.getTypeOfPerformanceBondId() != null) {
         crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTypeOfPerformanceBondId()).getName()
         );
      }

      crmApplyForBidRecordDetailDTO.setTenderRequirement(CrmTenderRequirementTypeEnum.getNameByType(crmTenderRequirementTypeEnum));
      if (StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
         crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyForBidRecord.getAttachmentIds()));
      }

      return crmApplyForBidRecordDetailDTO;
   }

   @Override
   public void downLoadAttachment(Long id) {
      this.attachmentService.downloadFile(id, null);
   }

   @Override
   public void crmTenderDetailDownLoad(Long id, Integer crmTenderRequirementTypeEnum, HttpServletResponse response) {
      CrmApplyForBidRecordDetailDTO recordDetailDTO = this.getTenderDetail(id, crmTenderRequirementTypeEnum);
      if (recordDetailDTO != null) {
         String resourcePath = "files/CrmTenderDetailDownLoadTemplate.xlsx";
         String tempFileName = "CrmTenderDetailDownLoadTemplate";
         String exportFileName = recordDetailDTO.getProjectName() + "招标备案详情.xlsx";
         Map<String, Object> map = BeanUtil.beanToMap(recordDetailDTO);
         if (recordDetailDTO.getCrmBiddingRegulationsTypeEnum() != null) {
            map.put("crmBiddingRegulationsTypeEnumName", CrmBiddingRegulationsTypeEnum.getNameByType(recordDetailDTO.getCrmBiddingRegulationsTypeEnum()));
         }

         if (recordDetailDTO.getStartDate() != null && recordDetailDTO.getEndDate() != null) {
            map.put("allDate", DateTimeUtil.getBetweenDay(recordDetailDTO.getStartDate().toLocalDate(), recordDetailDTO.getEndDate().toLocalDate()) + "天");
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
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Long> crmProjectIds = new ArrayList<>();
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (CollectionUtil.isEmpty(crmProjectIds)) {
            return printVO;
         }
      }

      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .in(CollectionUtil.isNotEmpty(crmProjectIds), CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, crmProjectIds)
         );
      if (CollectionUtil.isEmpty(crmApplyForBidRecords)) {
         return printVO;
      }

      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmTenderListDTO> crmTenderListDTOS = this.crmBiddingCenterMapper
         .getCrmTenderList(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList()),
            crmTenderRequirementTypeEnum,
            crmCanLookDeptIds,
            UserUtil.getCurrentUserId()
         );

      for (CrmTenderListDTO crmTenderListDTO : crmTenderListDTOS) {
         if (StringUtils.isNotBlank(crmTenderListDTO.getProjectInformantUserIds())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmTenderListDTO.getProjectInformantUserIds(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong)).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTenderListDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }

         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(crmTenderListDTO.getCountryName());
         stringBuilder.append(crmTenderListDTO.getProvinceName());
         stringBuilder.append(crmTenderListDTO.getCityName());
         stringBuilder.append(crmTenderListDTO.getRegionName());
         crmTenderListDTO.setRegionNameList(stringBuilder.toString());
      }

      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> collect = crmTenderListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> myTenderListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   ) {
      List<Long> crmProjectIds = new ArrayList<>();
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .eq(CrmProjectInformationWarehousing::getIsBiddingMethod, Boolean.TRUE)
                     .apply("FIND_IN_SET({0}, business_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .apply("FIND_IN_SET({0}, technology_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsSettlementMethod, Boolean.TRUE)
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            crmProjectIds = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
                     .or()
                     .eq(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
                     .apply("FIND_IN_SET({0}, devise_project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond, Boolean.TRUE)
               )
               .stream()
               .map(CrmProjectInformationWarehousing::getId)
               .collect(Collectors.toList());
         }

         if (CollectionUtil.isEmpty(crmProjectIds)) {
            return printVO;
         }
      }

      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .in(CollectionUtil.isNotEmpty(crmProjectIds), CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, crmProjectIds)
         );
      if (CollectionUtil.isEmpty(crmApplyForBidRecords)) {
         return printVO;
      }

      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmMyTenderListDTO> crmTenderListDTOS = this.crmBiddingCenterMapper
         .getMyCrmTenderList(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId).collect(Collectors.toList()),
            crmTenderRequirementTypeEnum,
            UserUtil.getCurrentUserId()
         );

      for (CrmMyTenderListDTO crmTenderListDTO : crmTenderListDTOS) {
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(crmTenderListDTO.getCountryName());
         stringBuilder.append(crmTenderListDTO.getProvinceName());
         stringBuilder.append(crmTenderListDTO.getCityName());
         stringBuilder.append(crmTenderListDTO.getRegionName());
         crmTenderListDTO.setRegionNameList(stringBuilder.toString());
      }

      List<Map<String, Object>> collect = crmTenderListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> archivesManagementListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(applyForBidReporterName), User::getName, applyForBidReporterName))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      if (CollectionUtil.isEmpty(userMap)) {
         return printVO;
      }

      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .like(StringUtils.isNotBlank(applyForBidReporterName), CrmApplyForBidRecord::getInformantUserName, applyForBidReporterName)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Map<Long, CrmApplyForBidRecord> bidRecordMap = crmApplyForBidRecords.stream().collect(Collectors.toMap(CrmApplyForBidRecord::getId, Function.identity()));
      Map<Long, CrmApplyForBidRecord> forBidRecordMap = crmApplyForBidRecords.stream()
         .collect(Collectors.toMap(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, Function.identity()));
      if (CollectionUtil.isEmpty(bidRecordMap)) {
         return printVO;
      }

      Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      new ArrayList();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings;
      if (CollectionUtil.isEmpty(crmCanLookInfoDeptIdsByModuleAndUserId)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  .apply(startDate != null && endDate != null, "create_time BETWEEN {0} AND {1}", startDate, endDate)
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet())
            );
      } else if (crmCanLookInfoDeptIdsByModuleAndUserId.contains(0L)) {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .and(qr -> {
                     qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId);
                     qr.or();
                     qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                  })
                  .apply(startDate != null && endDate != null, "create_time BETWEEN {0} AND {1}", startDate, endDate)
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet())
            );
      } else {
         crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, crmCanLookInfoDeptIdsByModuleAndUserId)
                  .apply(startDate != null && endDate != null, "create_time BETWEEN {0} AND {1}", startDate, endDate)
                  .like(StringUtils.isNotBlank(serialNumber), CrmProjectInformationWarehousing::getSerialNumber, serialNumber)
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsBiddingMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType()),
                     CrmProjectInformationWarehousing::getIsSettlementMethod,
                     Boolean.TRUE
                  )
                  .eq(
                     crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType()),
                     CrmProjectInformationWarehousing::getIsTypeOfPerformanceBond,
                     Boolean.TRUE
                  )
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getBusinessProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getDeviseProjectBidManagerUserId, userMap.keySet())
                  .or()
                  .in(StringUtils.isNotBlank(headUserName), CrmProjectInformationWarehousing::getTechnologyProjectBidManagerUserId, userMap.keySet())
            );
      }

      if (CollectionUtil.isEmpty(crmProjectInformationWarehousings)) {
         return printVO;
      }

      List<ArchivesManagementListDTO> archivesManagementListDTOS = new ArrayList<>();

      for (CrmProjectInformationWarehousing crmProjectInformationWarehousing : crmProjectInformationWarehousings) {
         ArchivesManagementListDTO archivesManagementListDTO = ArchivesManagementListDTO.builder().build();
         archivesManagementListDTO.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousing.getId());
         archivesManagementListDTO.setCreateTime(crmProjectInformationWarehousing.getCreateTime());
         archivesManagementListDTO.setDepartmentName(departmentMap.get(crmProjectInformationWarehousing.getDepartmentId()));
         archivesManagementListDTO.setProjectName(crmProjectInformationWarehousing.getProjectName());
         archivesManagementListDTO.setSerialNumber(crmProjectInformationWarehousing.getSerialNumber());
         if (forBidRecordMap.get(crmProjectInformationWarehousing.getId()) != null) {
            archivesManagementListDTO.setHeadOfCommerceName(forBidRecordMap.get(crmProjectInformationWarehousing.getId()).getInformantUserName());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getBusinessProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getBusinessProjectBidManagerFinishDate());
            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getTechnologyProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getTechnologyProjectBidManagerFinishDate());
            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            if (StringUtils.isNotBlank(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(crmProjectInformationWarehousing.getDeviseProjectBidManagerUserId(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               archivesManagementListDTO.setApplyForBidReporterName(stringBuilder.toString());
            }

            archivesManagementListDTO.setCrmTenderRequirementTypeEnum(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
            archivesManagementListDTO.setProjectBidManagerFinishDate(crmProjectInformationWarehousing.getDeviseProjectBidManagerFinishDate());
         }

         archivesManagementListDTOS.add(archivesManagementListDTO);
      }

      List<Map<String, Object>> collect = archivesManagementListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public PageVO<CrmTenderListDTOV2> getCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cStartDate,
      LocalDateTime cEndDate,
      Integer crmSpecialBubmissionStatusEnum,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSettlementBusinessTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      Preconditions.checkArgument(crmTenderRequirementTypeEnum != null, "请先选择投标类型");
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmTenderListDTOV2> crmTenderListDTOV2s = this.crmBiddingCenterMapper
         .getCrmTenderListCustom(
            startDate,
            endDate,
            cStartDate,
            cEndDate,
            crmSpecialBubmissionStatusEnum,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmTenderRequirementTypeEnum,
            crmCanLookDeptIds,
            UserUtil.getCurrentUserId(),
            crmSettlementBusinessTypeEnum
         );

      for (CrmTenderListDTOV2 crmTenderListDTOV2 : crmTenderListDTOV2s) {
         if (StringUtils.isNotBlank(crmTenderListDTOV2.getProjectInformantUserIds())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmTenderListDTOV2.getProjectInformantUserIds(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong)).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTenderListDTOV2.setProjectBidManagerUserName(stringBuilder.toString());
         }
      }

      return new PageVO<>(objects, crmTenderListDTOV2s);
   }

   @Override
   public PageVO<CrmMyTenderListDTOV2> getMyCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmMyTenderListDTOV2> crmMyTenderListDTOV2s = this.crmBiddingCenterMapper
         .getMyCrmTenderListCustom(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmTenderRequirementTypeEnum,
            UserUtil.getCurrentUserId(),
            crmSpecialBubmissionStatusEnum
         );
      if (CollectionUtil.isNotEmpty(crmMyTenderListDTOV2s)) {
         crmMyTenderListDTOV2s.forEach(item -> {
            if (StringUtils.isNotBlank(item.getProjectInformantUserIds())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(item.getProjectInformantUserIds(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               item.setProjectBidManagerUserName(stringBuilder.toString());
            }
         });
      }

      return new PageVO<>(objects, crmMyTenderListDTOV2s);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cStartDate,
      LocalDateTime cEndDate,
      Integer crmSpecialBubmissionStatusEnum,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmSettlementBusinessTypeEnum,
      Integer crmTenderRequirementTypeEnum
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Set<Long> crmCanLookDeptIds = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmTenderListDTOV2> crmTenderListDTOS = this.crmBiddingCenterMapper
         .getCrmTenderListCustom(
            startDate,
            endDate,
            cStartDate,
            cEndDate,
            crmSpecialBubmissionStatusEnum,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmTenderRequirementTypeEnum,
            crmCanLookDeptIds,
            UserUtil.getCurrentUserId(),
            crmSettlementBusinessTypeEnum
         );

      for (CrmTenderListDTOV2 crmTenderListDTO : crmTenderListDTOS) {
         if (StringUtils.isNotBlank(crmTenderListDTO.getProjectInformantUserIds())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmTenderListDTO.getProjectInformantUserIds(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong)).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTenderListDTO.setProjectBidManagerUserName(stringBuilder.toString());
         }

         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(crmTenderListDTO.getCountryName());
         stringBuilder.append(crmTenderListDTO.getProvinceName());
         stringBuilder.append(crmTenderListDTO.getCityName());
         stringBuilder.append(crmTenderListDTO.getRegionName());
         crmTenderListDTO.setRegionNameList(stringBuilder.toString());
      }

      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> collect = crmTenderListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmApplyForBidRecordDetailDTOV2 getTenderDetailCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingMapper.getDetailByDelete(id);
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
      }

      CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailDTOV2 = new CrmApplyForBidRecordDetailDTOV2();
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
            );
         Preconditions.checkArgument(crmApplyBusinessBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyBusinessBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         crmApplyForBidRecordDetailDTOV2.setBusinessProjectBidManagerQuote(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerQuote());
         crmApplyForBidRecordDetailDTOV2.setBusinessProjectBidManagerEstimatedWorks(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerEstimatedWorks());
         crmApplyForBidRecordDetailDTOV2.setBusinessProjectBidManagerCost(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerCost());
         crmApplyForBidRecordDetailDTOV2.setBusinessProjectBidManagerGrossProfit(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerGrossProfit());
         crmApplyForBidRecordDetailDTOV2.setBusinessProjectBidManagerRemark(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerRemark());
         if (crmApplyBusinessBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyBusinessBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyBusinessBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getCreateUserId()).getName());
         if (crmApplyBusinessBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(
                     crmSpecialBubmissionStatusEnum != null, CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum
                  )
                  .eq(crmSettlementBusinessTypeEnum != null, CrmApplyTechnologyBiddingRecord::getCrmSettlementBusinessTypeEnum, crmSettlementBusinessTypeEnum)
                  .eq(crmApplyTechnologyBiddingRecordId != null, CrmApplyTechnologyBiddingRecord::getId, crmApplyTechnologyBiddingRecordId)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
            );
         Preconditions.checkArgument(crmApplyTechnologyBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyTechnologyBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         if (crmApplyTechnologyBiddingRecord.getTechnologyBidManagerJobDescriptionId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerJobDescriptionId(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerJobDescriptionId());
            crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerJobDescriptionName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerJobDescriptionId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerRenderings(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerRenderings());
         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerStructureName(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerStructureName());
         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerCompletion(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerCompletion());
         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerBusinessTrip(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerBusinessTrip());
         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerCustomerReception(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerCustomerReception());
         crmApplyForBidRecordDetailDTOV2.setTechnologyBidManagerRemarks(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerRemarks());
         if (crmApplyTechnologyBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyTechnologyBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyTechnologyBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyTechnologyBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyTechnologyBiddingRecord.getCreateUserId()).getName());
         if (crmApplyTechnologyBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
            );
         Preconditions.checkArgument(crmApplyStructuralDesignBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyStructuralDesignBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         if (crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyStructuralDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyStructuralDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyStructuralDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
            );
         Preconditions.checkArgument(crmApplyDeepDesignBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyDeepDesignBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         if (crmApplyDeepDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyDeepDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyDeepDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyDeepDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyDeepDesignBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmEnterpriseWarehousing != null) {
         crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(
            this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId()).getBusinessName()
         );
      }

      crmApplyForBidRecordDetailDTOV2.setTenderRequirement(CrmTenderRequirementTypeEnum.getNameByType(crmTenderRequirementTypeEnum));
      return crmApplyForBidRecordDetailDTOV2;
   }

   @Override
   public Boolean setTenderHeadCustom(CrmSetTenderHeadParamV2 crmSetTenderHeadParamV2) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingMapper
         .getDetailByDelete(crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId())
            );
         crmApplyBusinessBiddingRecord.setProjectBidManagerUserId(
            org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList(), ",")
         );
         crmApplyBusinessBiddingRecord.setProjectBidManagerFinishDate(crmSetTenderHeadParamV2.getProjectBidManagerFinishDate());
         crmApplyBusinessBiddingRecord.setDifficultyFactorId(crmSetTenderHeadParamV2.getDifficultyFactorId());
         crmApplyBusinessBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
         this.crmApplyBusinessBiddingRecordBiz.updateById(crmApplyBusinessBiddingRecord);
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .notificationTypeEnum(NotificationModuleTypeEnum.CRM_SETTLEMENT_METHOD.getNotificationType())
                  .contentDetails(this.getPushContent(projectInformationWarehousing, crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum()))
                  .projectId(null)
                  .dataId(crmApplyBusinessBiddingRecord.getId())
                  .createUserId(UserUtil.getCurrentUserId())
                  .userList(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList())
                  .build()
            );
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(
                     crmSetTenderHeadParamV2.getCrmApplyTechnologyBiddingRecordId() != null,
                     CrmApplyTechnologyBiddingRecord::getId,
                     crmSetTenderHeadParamV2.getCrmApplyTechnologyBiddingRecordId()
                  )
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSetTenderHeadParamV2.getCrmSpecialBubmissionStatusEnum())
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId())
            );
         crmApplyTechnologyBiddingRecord.setProjectBidManagerUserId(
            org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList(), ",")
         );
         crmApplyTechnologyBiddingRecord.setProjectBidManagerFinishDate(crmSetTenderHeadParamV2.getProjectBidManagerFinishDate());
         crmApplyTechnologyBiddingRecord.setDifficultyFactorId(crmSetTenderHeadParamV2.getDifficultyFactorId());
         crmApplyTechnologyBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerJobDescriptionId(crmSetTenderHeadParamV2.getTechnologyBidManagerJobDescriptionId());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerRenderings(crmSetTenderHeadParamV2.getTechnologyBidManagerRenderings());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerStructureName(crmSetTenderHeadParamV2.getTechnologyBidManagerStructureName());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerCompletion(crmSetTenderHeadParamV2.getTechnologyBidManagerCompletion());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerBusinessTrip(crmSetTenderHeadParamV2.getTechnologyBidManagerBusinessTrip());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerCustomerReception(crmSetTenderHeadParamV2.getTechnologyBidManagerCustomerReception());
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerRemarks(crmSetTenderHeadParamV2.getTechnologyBidManagerRemarks());
         crmApplyTechnologyBiddingRecord.setVisualizationQuantity(crmSetTenderHeadParamV2.getVisualizationQuantity());
         crmApplyTechnologyBiddingRecord.setContactPerson(crmSetTenderHeadParamV2.getContactPerson());
         this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord);
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .notificationTypeEnum(NotificationModuleTypeEnum.CRM_TYPE_OF_PERFORMANCE_BOND.getNotificationType())
                  .contentDetails(this.getPushContent(projectInformationWarehousing, crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum()))
                  .projectId(null)
                  .dataId(crmApplyTechnologyBiddingRecord.getId())
                  .createUserId(UserUtil.getCurrentUserId())
                  .userList(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList())
                  .build()
            );
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         Preconditions.checkArgument(crmSetTenderHeadParamV2.getIsNeedFill() != null, "请先选择是否需要填报");
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(
                     CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId,
                     crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId()
                  )
            );
         if (crmSetTenderHeadParamV2.getIsNeedFill()) {
            crmApplyStructuralDesignBiddingRecord.setProjectBidManagerUserId(
               org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList(), ",")
            );
            crmApplyStructuralDesignBiddingRecord.setProjectBidManagerFinishDate(crmSetTenderHeadParamV2.getProjectBidManagerFinishDate());
            crmApplyStructuralDesignBiddingRecord.setDifficultyFactorId(crmSetTenderHeadParamV2.getDifficultyFactorId());
            crmApplyStructuralDesignBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
            this.crmApplyStructuralDesignBiddingRecordBiz.updateById(crmApplyStructuralDesignBiddingRecord);
         } else {
            crmApplyStructuralDesignBiddingRecord.setProjectBidManagerUserId(null);
            crmApplyStructuralDesignBiddingRecord.setProjectBidManagerFinishDate(null);
            crmApplyStructuralDesignBiddingRecord.setDifficultyFactorId(null);
            crmApplyStructuralDesignBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
            this.crmApplyStructuralDesignBiddingRecordBiz
               .update(
                  Wrappers.lambdaUpdate(CrmApplyStructuralDesignBiddingRecord.class)
                     .set(CrmApplyStructuralDesignBiddingRecord::getProjectBidManagerUserId, null)
                     .set(CrmApplyStructuralDesignBiddingRecord::getProjectBidManagerFinishDate, null)
                     .set(CrmApplyStructuralDesignBiddingRecord::getDifficultyFactorId, null)
                     .set(CrmApplyStructuralDesignBiddingRecord::getCrmProjectBidStatus, CrmProjectBidStatusEnum.DONE.getType())
                     .eq(CrmApplyStructuralDesignBiddingRecord::getId, crmApplyStructuralDesignBiddingRecord.getId())
               );
         }

         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .notificationTypeEnum(NotificationModuleTypeEnum.CRM_STRUCTURAL_DESIGN_TARGET.getNotificationType())
                  .contentDetails(this.getPushContent(projectInformationWarehousing, crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum()))
                  .projectId(null)
                  .dataId(crmApplyStructuralDesignBiddingRecord.getId())
                  .createUserId(UserUtil.getCurrentUserId())
                  .userList(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList())
                  .build()
            );
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         Preconditions.checkArgument(crmSetTenderHeadParamV2.getIsNeedFill() != null, "请先选择是否需要填报");
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId())
            );
         if (crmSetTenderHeadParamV2.getIsNeedFill()) {
            crmApplyDeepDesignBiddingRecord.setProjectBidManagerUserId(
               org.apache.commons.lang3.StringUtils.join(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList(), ",")
            );
            crmApplyDeepDesignBiddingRecord.setProjectBidManagerFinishDate(crmSetTenderHeadParamV2.getProjectBidManagerFinishDate());
            crmApplyDeepDesignBiddingRecord.setDifficultyFactorId(crmSetTenderHeadParamV2.getDifficultyFactorId());
            crmApplyDeepDesignBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.ONGOING.getType());
            this.crmApplyDeepDesignBiddingRecordBiz.updateById(crmApplyDeepDesignBiddingRecord);
         } else {
            this.crmApplyDeepDesignBiddingRecordBiz
               .update(
                  Wrappers.lambdaUpdate(CrmApplyDeepDesignBiddingRecord.class)
                     .set(CrmApplyDeepDesignBiddingRecord::getProjectBidManagerUserId, null)
                     .set(CrmApplyDeepDesignBiddingRecord::getProjectBidManagerFinishDate, null)
                     .set(CrmApplyDeepDesignBiddingRecord::getDifficultyFactorId, null)
                     .set(CrmApplyDeepDesignBiddingRecord::getCrmProjectBidStatus, CrmProjectBidStatusEnum.DONE.getType())
                     .eq(CrmApplyDeepDesignBiddingRecord::getId, crmApplyDeepDesignBiddingRecord.getId())
               );
         }

         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .notificationTypeEnum(NotificationModuleTypeEnum.CRM_DEEPENING_THE_DESIGN_STANDARD.getNotificationType())
                  .contentDetails(this.getPushContent(projectInformationWarehousing, crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum()))
                  .projectId(null)
                  .dataId(crmApplyDeepDesignBiddingRecord.getId())
                  .createUserId(UserUtil.getCurrentUserId())
                  .userList(crmSetTenderHeadParamV2.getProjectBidManagerUserIdList())
                  .build()
            );
      }

      return Boolean.TRUE;
   }

   private StringBuffer getPushContent(CrmProjectInformationWarehousing projectInformationWarehousing, Integer crmTenderRequirementTypeEnum) {
      String nameByType = CrmTenderRequirementTypeEnum.getNameByType(crmTenderRequirementTypeEnum);
      return this.detailsUtils
         .getUser()
         .append("设置了《")
         .append(projectInformationWarehousing.getSerialNumber())
         .append("+")
         .append(projectInformationWarehousing.getProjectName())
         .append("》项目,")
         .append(nameByType)
         .append("负责人,请关注");
   }

   @Override
   public PrintVO<List<Map<String, Object>>> myTenderListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      CrmRegionCommonDTO regionInfo = this.getRegionInfo(regionIds);
      List<CrmMyTenderListDTOV2> crmTenderListDTOSV2 = this.crmBiddingCenterMapper
         .getMyCrmTenderListCustom(
            startDate,
            endDate,
            regionInfo.getCountryId(),
            regionInfo.getProvinceId(),
            regionInfo.getCityId(),
            regionInfo.getRegionId(),
            structureTypeConfigurationId,
            departmentId,
            projectName,
            crmEnterpriseWarehousingName,
            projectInformantUserName,
            crmTenderRequirementTypeEnum,
            UserUtil.getCurrentUserId(),
            null
         );

      for (CrmMyTenderListDTOV2 crmTenderListDTOV2 : crmTenderListDTOSV2) {
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(crmTenderListDTOV2.getCountryName());
         stringBuilder.append(crmTenderListDTOV2.getProvinceName());
         stringBuilder.append(crmTenderListDTOV2.getCityName());
         stringBuilder.append(crmTenderListDTOV2.getRegionName());
         crmTenderListDTOV2.setRegionNameList(stringBuilder.toString());
      }

      List<Map<String, Object>> collect = crmTenderListDTOSV2.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public Boolean uploadTenderDocumentsCustom(CrmUploadTenderDocumentsParamV2 copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingMapper
         .getDetailByDelete(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(copy.getAttachmentDTOList()), "请先上传附件");
      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
            );
         crmApplyBusinessBiddingRecord.setBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmApplyBusinessBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerQuote(copy.getBusinessProjectBidManagerQuote());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerEstimatedWorks(copy.getBusinessProjectBidManagerEstimatedWorks());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerCost(copy.getBusinessProjectBidManagerCost());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerGrossProfit(copy.getBusinessProjectBidManagerGrossProfit());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerRemark(copy.getBusinessProjectBidManagerRemark());
         crmApplyBusinessBiddingRecord.setBusinessProjectBidManagerActualFinishDate(LocalDateTime.now());
         this.crmApplyBusinessBiddingRecordBiz.updateById(crmApplyBusinessBiddingRecord);
      }

      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(copy.getCrmApplyTechnologyBiddingRecordId() != null, CrmApplyTechnologyBiddingRecord::getId, copy.getCrmApplyTechnologyBiddingRecordId())
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, copy.getCrmSpecialBubmissionStatusEnum())
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
            );
         Preconditions.checkArgument(
            CrmProjectBidStatusEnum.ONGOING.getType().equals(crmApplyTechnologyBiddingRecord.getCrmProjectBidStatus()), "投标状态不为进行中请刷新重试！"
         );
         crmApplyTechnologyBiddingRecord.setBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmApplyTechnologyBiddingRecord.setTechnologyProjectBidManagerActualFinishDate(LocalDateTime.now());
         this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord);
      }

      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
            );
         crmApplyStructuralDesignBiddingRecord.setBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmApplyStructuralDesignBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
         crmApplyStructuralDesignBiddingRecord.setStructuralDesignProjectBidManagerActualFinishDate(LocalDateTime.now());
         this.crmApplyStructuralDesignBiddingRecordBiz.updateById(crmApplyStructuralDesignBiddingRecord);
      }

      if (copy.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
            );
         crmApplyDeepDesignBiddingRecord.setBidManagerAttachmentIds(
            StrUtil.join(",", copy.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
         crmApplyDeepDesignBiddingRecord.setCrmProjectBidStatus(CrmProjectBidStatusEnum.DONE.getType());
         crmApplyDeepDesignBiddingRecord.setDeepDesignProjectBidManagerActualFinishDate(LocalDateTime.now());
         this.crmApplyDeepDesignBiddingRecordBiz.updateById(crmApplyDeepDesignBiddingRecord);
      }

      return Boolean.TRUE;
   }

   @Override
   public PageVO<ArchivesManagementListDTOV2> archivesManagementListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      Integer crmSettlementBusinessTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(headUserName), User::getName, headUserName))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      if (CollectionUtil.isEmpty(userMap)) {
         return new PageVO<>();
      }

      Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId = this.sysRoleLookPermissionConfigBiz
         .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
      Page<Object> objectPage = PageHelper.startPage(pageNumber, pageSize);
      List<ArchivesManagementListDTOV2> archivesManagementListDTOV2s = this.crmBiddingCenterMapper
         .archivesManagementListCustom(
            startDate,
            endDate,
            crmTenderRequirementTypeEnum,
            serialNumber,
            applyForBidReporterName,
            crmCanLookInfoDeptIdsByModuleAndUserId,
            userMap.keySet(),
            crmSettlementBusinessTypeEnum,
            UserUtil.getCurrentUserId()
         );
      archivesManagementListDTOV2s.forEach(item -> {
         if (StringUtils.isNotBlank(item.getHeadOfCommerceIds())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(item.getHeadOfCommerceIds(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong)).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            item.setHeadOfCommerceName(stringBuilder.toString());
         }
      });
      return new PageVO<>(objectPage, archivesManagementListDTOV2s);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> archivesManagementListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      Integer crmSettlementBusinessTypeEnum,
      String headUserName
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(headUserName), User::getName, headUserName))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      if (CollectionUtil.isEmpty(userMap)) {
         List<Map<String, Object>> collect = new ArrayList<>();
         printVO.setTable(collect);
         return printVO;
      } else {
         Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId = this.sysRoleLookPermissionConfigBiz
            .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
         List<ArchivesManagementListDTOV2> archivesManagementListDTOV2s = this.crmBiddingCenterMapper
            .archivesManagementListCustom(
               startDate,
               endDate,
               crmTenderRequirementTypeEnum,
               serialNumber,
               applyForBidReporterName,
               crmCanLookInfoDeptIdsByModuleAndUserId,
               userMap.keySet(),
               crmSettlementBusinessTypeEnum,
               UserUtil.getCurrentUserId()
            );
         archivesManagementListDTOV2s.forEach(item -> {
            if (StringUtils.isNotBlank(item.getHeadOfCommerceIds())) {
               String[] split = org.apache.commons.lang3.StringUtils.split(item.getHeadOfCommerceIds(), ",");
               List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
               StringBuilder stringBuilder = new StringBuilder();

               for (Long aLong : userIdList) {
                  stringBuilder.append(userMap.get(aLong)).append("/");
               }

               stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
               item.setHeadOfCommerceName(stringBuilder.toString());
            }
         });
         List<Map<String, Object>> collect = archivesManagementListDTOV2s.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
         Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
         printVO.setHeader(header);
         printVO.setTable(collect);
         return printVO;
      }
   }

   @Override
   public List<CrmProjectDocumentationListDTOV2> projectDocumentationListCustom(
      Integer crmTenderRequirementTypeEnum,
      Long crmProjectInformationWarehousingId,
      Integer crmSettlementBusinessTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingMapper
         .getDetailByDelete(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案信息不存在");
      List<CrmProjectDocumentationListDTOV2> crmProjectDocumentationListDTOSV2 = new ArrayList<>();
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (crmApplyBusinessBiddingRecord != null) {
            if (StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getBidManagerAttachmentIds())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getAttachmentIds())) {
               this.attachmentService
                  .listByIds(crmApplyBusinessBiddingRecord.getAttachmentIds())
                  .forEach(
                     item -> crmProjectDocumentationListDTOSV2.add(
                        CrmProjectDocumentationListDTOV2.builder()
                           .createTime(item.getCreateTime())
                           .importUserName(item.getCreateUserName())
                           .fileTypeName("招标文件")
                           .attachmentDTO(item)
                           .build()
                     )
                  );
            }
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord;
         if (crmApplyTechnologyBiddingRecordId != null) {
            crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(crmApplyTechnologyBiddingRecordId);
            Preconditions.checkArgument(
               crmApplyTechnologyBiddingRecord != null
                  && crmProjectInformationWarehousingId.equals(crmApplyTechnologyBiddingRecord.getCrmProjectInformationWarehousingId())
                  && crmSpecialBubmissionStatusEnum != null
                  && crmSpecialBubmissionStatusEnum.equals(crmApplyTechnologyBiddingRecord.getCrmSpecialBubmissionStatusEnum())
                  && CrmCheckStatusEnum.PASS.getType().equals(crmApplyTechnologyBiddingRecord.getCrmCheckStatusEnum()),
               "技术申请不存在、未通过审核或与项目及专项类型不一致"
            );
         } else {
            List<CrmApplyTechnologyBiddingRecord> records = this.crmApplyTechnologyBiddingRecordBiz.list(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(crmSettlementBusinessTypeEnum != null, CrmApplyTechnologyBiddingRecord::getCrmSettlementBusinessTypeEnum, crmSettlementBusinessTypeEnum)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
            Preconditions.checkArgument(records.size() <= 1, "存在多条技术申请，请指定技术申请ID");
            crmApplyTechnologyBiddingRecord = records.isEmpty() ? null : records.get(0);
         }
         if (crmApplyTechnologyBiddingRecord != null && crmSettlementBusinessTypeEnum != null) {
            Preconditions.checkArgument(
               crmSettlementBusinessTypeEnum.equals(crmApplyTechnologyBiddingRecord.getCrmSettlementBusinessTypeEnum()),
               "业务类型与技术申请不一致"
            );
         }
         if (crmApplyTechnologyBiddingRecord != null) {
            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.SPECIAL_PROGRAMS.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("专项投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.CONSTRUCTION_ORGANIZATION_DESIGN.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("施工组织设计投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.LIVE_SUPPORT_SERVICE.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("现场支持服务")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.CONSTRUCTION_VERIFICATION.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("施工验算")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.ANIMATION_SET_EFFECT.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("动画集效果")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
               && crmSpecialBubmissionStatusEnum.equals(CrmSpecialBubmissionStatusEnum.TECHNOLOGY_INNOVATION.getType())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("科技创新")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getAttachmentIds())) {
               this.attachmentService
                  .listByIds(crmApplyTechnologyBiddingRecord.getAttachmentIds())
                  .forEach(
                     item -> crmProjectDocumentationListDTOSV2.add(
                        CrmProjectDocumentationListDTOV2.builder()
                           .createTime(item.getCreateTime())
                           .importUserName(item.getCreateUserName())
                           .fileTypeName("招标文件")
                           .attachmentDTO(item)
                           .build()
                     )
                  );
            }
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (crmApplyDeepDesignBiddingRecord != null) {
            if (StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getBidManagerAttachmentIds())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyDeepDesignBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getAttachmentIds())) {
               this.attachmentService
                  .listByIds(crmApplyDeepDesignBiddingRecord.getAttachmentIds())
                  .forEach(
                     item -> crmProjectDocumentationListDTOSV2.add(
                        CrmProjectDocumentationListDTOV2.builder()
                           .createTime(item.getCreateTime())
                           .importUserName(item.getCreateUserName())
                           .fileTypeName("招标文件")
                           .attachmentDTO(item)
                           .build()
                     )
                  );
            }
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (crmApplyStructuralDesignBiddingRecord != null) {
            if (StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getBidManagerAttachmentIds())) {
               List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getBidManagerAttachmentIds());
               attachmentDTOList.forEach(
                  item -> crmProjectDocumentationListDTOSV2.add(
                     CrmProjectDocumentationListDTOV2.builder()
                        .createTime(item.getCreateTime())
                        .importUserName(item.getCreateUserName())
                        .fileTypeName("投标文件")
                        .attachmentDTO(item)
                        .build()
                  )
               );
            }

            if (StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())) {
               this.attachmentService
                  .listByIds(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())
                  .forEach(
                     item -> crmProjectDocumentationListDTOSV2.add(
                        CrmProjectDocumentationListDTOV2.builder()
                           .createTime(item.getCreateTime())
                           .importUserName(item.getCreateUserName())
                           .fileTypeName("招标文件")
                           .attachmentDTO(item)
                           .build()
                     )
                  );
            }
         }
      }

      return crmProjectDocumentationListDTOSV2;
   }

   @Override
   public CrmTheProjectLeaderDetailsDTOV2 detailsOfTheProjectLeaderCustom(
      Integer crmTenderRequirementTypeEnum,
      Long crmProjectInformationWarehousingId,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingMapper
         .getDetailByDelete(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmTheProjectLeaderDetailsDTOV2 crmTheProjectLeaderDetailsDTOV2 = new CrmTheProjectLeaderDetailsDTOV2();
      crmTheProjectLeaderDetailsDTOV2.setCrmProjectInformationWarehousingId(crmProjectInformationWarehousingId);
      crmTheProjectLeaderDetailsDTOV2.setCrmTenderRequirementTypeEnum(crmTenderRequirementTypeEnum);
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(item -> item.getId(), Function.identity()));
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmApplyBusinessBiddingRecord.getProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerFinishDate(crmApplyBusinessBiddingRecord.getProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorId(crmApplyBusinessBiddingRecord.getDifficultyFactorId());
         if (crmApplyBusinessBiddingRecord.getDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmApplyBusinessBiddingRecord.getDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTOV2.setBidManagerAttachments(this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getBidManagerAttachmentIds()));
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(crmApplyTechnologyBiddingRecordId != null, CrmApplyTechnologyBiddingRecord::getId, crmApplyTechnologyBiddingRecordId)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmApplyTechnologyBiddingRecord.getProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerFinishDate(crmApplyTechnologyBiddingRecord.getProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorId(crmApplyTechnologyBiddingRecord.getDifficultyFactorId());
         crmTheProjectLeaderDetailsDTOV2.setBusinessEssentials(crmApplyTechnologyBiddingRecord.getBusinessEssentials());
         if (crmApplyTechnologyBiddingRecord.getDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmApplyTechnologyBiddingRecord.getDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTOV2.setBidManagerAttachments(
            this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getBidManagerAttachmentIds())
         );
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmApplyStructuralDesignBiddingRecord.getProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerFinishDate(crmApplyStructuralDesignBiddingRecord.getProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorId(crmApplyStructuralDesignBiddingRecord.getDifficultyFactorId());
         if (crmApplyStructuralDesignBiddingRecord.getDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getDifficultyFactorId()).getName()
            );
         }

         crmTheProjectLeaderDetailsDTOV2.setBidManagerAttachments(
            this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getBidManagerAttachmentIds())
         );
         if (crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
            && crmApplyStructuralDesignBiddingRecord.getProjectBidManagerFinishDate() == null) {
            crmTheProjectLeaderDetailsDTOV2.setIsNeedFill(Boolean.FALSE);
         } else {
            crmTheProjectLeaderDetailsDTOV2.setIsNeedFill(Boolean.TRUE);
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
            );
         if (StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getProjectBidManagerUserId())) {
            String[] split = org.apache.commons.lang3.StringUtils.split(crmApplyDeepDesignBiddingRecord.getProjectBidManagerUserId(), ",");
            List<Long> userIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserIdList(userIdList);
            StringBuilder stringBuilder = new StringBuilder();

            for (Long aLong : userIdList) {
               stringBuilder.append(userMap.get(aLong).getName()).append("/");
            }

            stringBuilder.setCharAt(stringBuilder.length() - 1, ' ');
            crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerUserName(stringBuilder.toString());
         }

         crmTheProjectLeaderDetailsDTOV2.setProjectBidManagerFinishDate(crmApplyDeepDesignBiddingRecord.getProjectBidManagerFinishDate());
         crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorId(crmApplyDeepDesignBiddingRecord.getDifficultyFactorId());
         if (crmApplyDeepDesignBiddingRecord.getDifficultyFactorId() != null) {
            crmTheProjectLeaderDetailsDTOV2.setDifficultyFactorName(
               this.crmProjectInformationConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getDifficultyFactorId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
            && crmApplyDeepDesignBiddingRecord.getProjectBidManagerFinishDate() == null) {
            crmTheProjectLeaderDetailsDTOV2.setIsNeedFill(Boolean.FALSE);
         } else {
            crmTheProjectLeaderDetailsDTOV2.setIsNeedFill(Boolean.TRUE);
         }

         crmTheProjectLeaderDetailsDTOV2.setBidManagerAttachments(
            this.attachmentService.listByIds(crmApplyDeepDesignBiddingRecord.getBidManagerAttachmentIds())
         );
      }

      return crmTheProjectLeaderDetailsDTOV2;
   }

   @Override
   public void crmTenderDetailDownLoadCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId,
      HttpServletResponse response
   ) {
      CrmApplyForBidRecordDetailDTOV2 recordDetailDTOV2 = this.getTenderDetailCustom(
         id, crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum, crmApplyTechnologyBiddingRecordId
      );
      if (recordDetailDTOV2 != null) {
         String resourcePath = "files/CrmTenderDetailDownLoadTemplate.xlsx";
         String tempFileName = "CrmTenderDetailDownLoadTemplate";
         String exportFileName = recordDetailDTOV2.getProjectName() + "招标备案详情.xlsx";
         Map<String, Object> map = BeanUtil.beanToMap(recordDetailDTOV2);
         if (recordDetailDTOV2.getCrmBiddingRegulationsTypeEnum() != null) {
            map.put("crmBiddingRegulationsTypeEnumName", CrmBiddingRegulationsTypeEnum.getNameByType(recordDetailDTOV2.getCrmBiddingRegulationsTypeEnum()));
         }

         if (recordDetailDTOV2.getStartDate() != null && recordDetailDTOV2.getEndDate() != null) {
            map.put("allDate", DateTimeUtil.getBetweenDay(recordDetailDTOV2.getStartDate().toLocalDate(), recordDetailDTOV2.getEndDate().toLocalDate()) + "天");
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
      }
   }

   @Override
   public HashMap<String, Object> getTenderListSummaryCustom(
      Integer crmTenderRequirementTypeEnum, Integer crmSpecialBubmissionStatusEnum, Integer crmSettlementBusinessTypeEnum
   ) {
      HashMap<String, Object> map = new HashMap<>();
      map.put("notAppointedCount", 0);
      map.put("ongoingCount", 0);
      map.put("doneCount", 0);
      map.put("winningBidCount", 0);
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                     .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyBusinessBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyBusinessBiddingRecord> businessBiddingRecordMap = crmApplyBusinessBiddingRecords.stream()
               .collect(Collectors.toMap(item -> item.getCrmProjectInformationWarehousingId(), Function.identity()));
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList;
            if (CollectionUtil.isEmpty(deptSet)) {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyBusinessBiddingRecords.stream()
                              .map(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  );
            } else if (deptSet.contains(0L)) {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .and(qr -> {
                           qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                           qr.or();
                           qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                        })
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyBusinessBiddingRecords.stream()
                              .map(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            } else {
               crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyBusinessBiddingRecords.stream()
                              .map(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && businessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                     .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
                     .eq(
                        crmSettlementBusinessTypeEnum != null, CrmApplyTechnologyBiddingRecord::getCrmSettlementBusinessTypeEnum, crmSettlementBusinessTypeEnum
                     )
                     .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyTechnologyBiddingRecords)) {
               return map;
            }

            Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmApplyTechnologyBiddingRecordMap = crmApplyTechnologyBiddingRecords.stream()
               .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
            List<CrmProjectInformationWarehousing> var16;
            if (CollectionUtil.isEmpty(deptSet)) {
               var16 = this.crmProjectInformationWarehousingMapper
                  .getListByUser(
                     crmApplyTechnologyBiddingRecords.stream()
                        .map(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId)
                        .collect(Collectors.toList()),
                     UserUtil.getCurrentUserId()
                  );
            } else {
               var16 = this.crmProjectInformationWarehousingMapper
                  .getListByDeptIds(
                     crmApplyTechnologyBiddingRecords.stream()
                        .map(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId)
                        .collect(Collectors.toList()),
                     deptSet,
                     UserUtil.getCurrentUserId()
                  );
            }

            var16.forEach(item -> {
               List<CrmApplyTechnologyBiddingRecord> applyTechnologyBiddingRecords = crmApplyTechnologyBiddingRecordMap.get(item.getId());
               applyTechnologyBiddingRecords.forEach(trem -> {
                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }
               });
            });
            map.put(
               "winningBidCount",
               var16.stream().filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())).count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                     .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecordMap = crmApplyStructuralDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            List<CrmProjectInformationWarehousing> var17;
            if (CollectionUtil.isEmpty(deptSet)) {
               var17 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyStructuralDesignBiddingRecords.stream()
                              .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  );
            } else if (deptSet.contains(0L)) {
               var17 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .and(qr -> {
                           qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                           qr.or();
                           qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                        })
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyStructuralDesignBiddingRecords.stream()
                              .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            } else {
               var17 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyStructuralDesignBiddingRecords.stream()
                              .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               var17.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyStructuralDesignBiddingRecordMap.get(item.getId())
                           .getCrmProjectBidStatus()
                           .equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               var17.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyStructuralDesignBiddingRecordMap.get(item.getId())
                           .getCrmProjectBidStatus()
                           .equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               var17.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyStructuralDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               var17.stream().filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())).count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                     .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecordMap = crmApplyDeepDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            List<CrmProjectInformationWarehousing> var18;
            if (CollectionUtil.isEmpty(deptSet)) {
               var18 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyDeepDesignBiddingRecords.stream()
                              .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  );
            } else if (deptSet.contains(0L)) {
               var18 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .and(qr -> {
                           qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                           qr.or();
                           qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
                        })
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyDeepDesignBiddingRecords.stream()
                              .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            } else {
               var18 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(
                           CrmProjectInformationWarehousing::getId,
                           crmApplyDeepDesignBiddingRecords.stream()
                              .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                              .collect(Collectors.toList())
                        )
                  );
            }

            map.put(
               "notAppointedCount",
               var18.stream()
                  .filter(
                     item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyDeepDesignBiddingRecordMap.get(item.getId())
                           .getCrmProjectBidStatus()
                           .equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               var18.stream()
                  .filter(
                     item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               var18.stream()
                  .filter(
                     item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus() != null
                        && crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               var18.stream().filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())).count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(9)) {
            Set<Long> deptSet = this.sysRoleLookPermissionConfigBiz
               .getCrmCanLookInfoDeptIdsByModuleAndUserId(SysModuleTypeEnum.CRM.getType(), UserUtil.getCurrentUserId());
            new ArrayList();
            List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                     .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                     .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords) && CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
               return map;
            }

            List<Long> proejctIds = new ArrayList<>();
            proejctIds.addAll(
               crmApplyDeepDesignBiddingRecords.stream()
                  .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                  .collect(Collectors.toList())
            );
            proejctIds.addAll(
               crmApplyStructuralDesignBiddingRecords.stream()
                  .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                  .collect(Collectors.toList())
            );
            List<CrmProjectInformationWarehousing> var19;
            if (CollectionUtil.isEmpty(deptSet)) {
               var19 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getId, proejctIds)
                        .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
                  );
            } else if (deptSet.contains(0L)) {
               var19 = this.crmProjectInformationWarehousingBiz.list(Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class).and(qr -> {
                  qr.in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet);
                  qr.or();
                  qr.eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId());
               }).in(CrmProjectInformationWarehousing::getId, proejctIds));
            } else {
               var19 = this.crmProjectInformationWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                        .in(CrmProjectInformationWarehousing::getInformationOperatorDeptId, deptSet)
                        .in(CrmProjectInformationWarehousing::getId, proejctIds)
                  );
            }

            Map<Long, CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecordMap = crmApplyDeepDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            Map<Long, CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecordMap = crmApplyStructuralDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            var19.forEach(
               item -> {
                  CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = crmApplyDeepDesignBiddingRecordMap.get(item.getId());
                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.ONGOING.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.DONE.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }

                  CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = crmApplyStructuralDesignBiddingRecordMap.get(item.getId());
                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.ONGOING.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.DONE.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }

                  if (item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())) {
                     map.put("winningBidCount", Long.parseLong(map.get("winningBidCount").toString()) + 1L);
                  }
               }
            );
         }
      }

      return map;
   }

   @Override
   public HashMap<String, Object> getMyTenderListSummaryCustom(Integer crmTenderRequirementTypeEnum) {
      HashMap<String, Object> map = new HashMap<>();
      map.put("myTaskCount", 0);
      map.put("ongoingCount", 0);
      map.put("doneCount", 0);
      map.put("winningBidCount", 0);
      if (crmTenderRequirementTypeEnum != null) {
         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                     .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
               );
            if (CollectionUtil.isEmpty(crmApplyBusinessBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyBusinessBiddingRecord> applyBusinessBiddingRecordMap = crmApplyBusinessBiddingRecords.stream()
               .collect(Collectors.toMap(item -> item.getCrmProjectInformationWarehousingId(), Function.identity()));
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .in(
                        CrmProjectInformationWarehousing::getId,
                        crmApplyBusinessBiddingRecords.stream()
                           .map(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId)
                           .collect(Collectors.toList())
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> applyBusinessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> applyBusinessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType()))
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> applyBusinessBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType()))
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                     .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
               );
            if (CollectionUtil.isEmpty(crmApplyTechnologyBiddingRecords)) {
               return map;
            }

            Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmApplyTechnologyBiddingRecordMap = crmApplyTechnologyBiddingRecords.stream()
               .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingMapper
               .listByDelete(
                  crmApplyTechnologyBiddingRecords.stream()
                     .map(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId)
                     .collect(Collectors.toList())
               );
            crmProjectInformationWarehousingList.forEach(item -> {
               List<CrmApplyTechnologyBiddingRecord> applyTechnologyBiddingRecords = crmApplyTechnologyBiddingRecordMap.get(item.getId());
               applyTechnologyBiddingRecords.forEach(trem -> {
                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (trem.getCrmProjectBidStatus() != null && trem.getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }
               });
            });
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
            List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                     .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
               );
            if (CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecordMap = crmApplyStructuralDesignBiddingRecords.stream()
               .collect(Collectors.toMap(item -> item.getCrmProjectInformationWarehousingId(), Function.identity()));
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .in(
                        CrmProjectInformationWarehousing::getId,
                        crmApplyStructuralDesignBiddingRecords.stream()
                           .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                           .collect(Collectors.toList())
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId())
                        .getCrmProjectBidStatus()
                        .equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId())
                        .getCrmProjectBidStatus()
                        .equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> crmApplyStructuralDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType())
                  )
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
            List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                     .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
               );
            if (CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords)) {
               return map;
            }

            Map<Long, CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecordMap = crmApplyDeepDesignBiddingRecords.stream()
               .collect(Collectors.toMap(item -> item.getCrmProjectInformationWarehousingId(), Function.identity()));
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .in(
                        CrmProjectInformationWarehousing::getId,
                        crmApplyDeepDesignBiddingRecords.stream()
                           .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                           .collect(Collectors.toList())
                     )
               );
            map.put(
               "myTaskCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId())
                        .getCrmProjectBidStatus()
                        .equals(CrmProjectBidStatusEnum.NOT_APPOINTED.getType())
                  )
                  .count()
            );
            map.put(
               "ongoingCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(
                     item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.ONGOING.getType())
                  )
                  .count()
            );
            map.put(
               "doneCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> crmApplyDeepDesignBiddingRecordMap.get(item.getId()).getCrmProjectBidStatus().equals(CrmProjectBidStatusEnum.DONE.getType()))
                  .count()
            );
            map.put(
               "winningBidCount",
               crmProjectInformationWarehousingList.stream()
                  .filter(item -> item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()))
                  .count()
            );
         }

         if (crmTenderRequirementTypeEnum.equals(9)) {
            List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
               .list(
                  Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                     .apply("FIND_IN_SET({0}, project_bid_manager_user_id) > 0", UserUtil.getCurrentUserId())
                     .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               );
            if (CollectionUtil.isEmpty(crmApplyDeepDesignBiddingRecords) && CollectionUtil.isEmpty(crmApplyStructuralDesignBiddingRecords)) {
               return map;
            }

            List<Long> proejctIds = new ArrayList<>();
            proejctIds.addAll(
               crmApplyDeepDesignBiddingRecords.stream()
                  .map(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                  .collect(Collectors.toList())
            );
            proejctIds.addAll(
               crmApplyStructuralDesignBiddingRecords.stream()
                  .map(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId)
                  .collect(Collectors.toList())
            );
            List<CrmProjectInformationWarehousing> crmProjectInformationWarehousingList = this.crmProjectInformationWarehousingBiz
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                     .in(CrmProjectInformationWarehousing::getId, proejctIds)
                     .eq(CrmProjectInformationWarehousing::getInformationOperatorUserId, UserUtil.getCurrentUserId())
               );
            Map<Long, CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecordMap = crmApplyDeepDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            Map<Long, CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecordMap = crmApplyStructuralDesignBiddingRecords.stream()
               .collect(Collectors.toMap(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, Function.identity()));
            crmProjectInformationWarehousingList.forEach(
               item -> {
                  CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = crmApplyDeepDesignBiddingRecordMap.get(item.getId());
                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.ONGOING.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (crmApplyDeepDesignBiddingRecord != null
                     && crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.DONE.getType().equals(crmApplyDeepDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }

                  CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = crmApplyStructuralDesignBiddingRecordMap.get(item.getId());
                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("notAppointedCount", Long.parseLong(map.get("notAppointedCount").toString()) + 1L);
                  }

                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.ONGOING.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("ongoingCount", Long.parseLong(map.get("ongoingCount").toString()) + 1L);
                  }

                  if (crmApplyStructuralDesignBiddingRecord != null
                     && crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus() != null
                     && CrmProjectBidStatusEnum.DONE.getType().equals(crmApplyStructuralDesignBiddingRecord.getCrmProjectBidStatus())) {
                     map.put("doneCount", Long.parseLong(map.get("doneCount").toString()) + 1L);
                  }

                  if (item.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())) {
                     map.put("winningBidCount", Long.parseLong(map.get("winningBidCount").toString()) + 1L);
                  }
               }
            );
         }
      }

      return map;
   }

   @Override
   public CrmHeadFillOutDetail getHeadFillOutDetail(Long id, Integer crmTenderRequirementTypeEnum) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(id);
      Preconditions.checkArgument(projectInformationWarehousing != null, "当前项目备案不存在");
      CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, projectInformationWarehousing.getId())
         );
      Preconditions.checkArgument(crmApplyBusinessBiddingRecord != null, "投标申请不存在");
      CrmHeadFillOutDetail crmHeadFillOutDetail = new CrmHeadFillOutDetail();
      BeanUtil.copy(crmApplyBusinessBiddingRecord, crmHeadFillOutDetail);
      crmHeadFillOutDetail.setBusinessProjectBidManagerQuote(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerQuote());
      crmHeadFillOutDetail.setBusinessProjectBidManagerEstimatedWorks(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerEstimatedWorks());
      crmHeadFillOutDetail.setBusinessProjectBidManagerCost(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerCost());
      crmHeadFillOutDetail.setBusinessProjectBidManagerGrossProfit(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerGrossProfit());
      crmHeadFillOutDetail.setBusinessProjectBidManagerRemark(crmApplyBusinessBiddingRecord.getBusinessProjectBidManagerRemark());
      crmHeadFillOutDetail.setBidManagerAttachments(this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getBidManagerAttachmentIds()));
      if (StringUtils.isNotBlank(projectInformationWarehousing.getBusinessBidManagerAttachmentIds())) {
         crmHeadFillOutDetail.setBidManagerAttachments(this.attachmentService.listByIds(projectInformationWarehousing.getBusinessBidManagerAttachmentIds()));
      }

      return crmHeadFillOutDetail;
   }

   @Override
   public Boolean updateBiddingStatus(CrmSetTenderHeadParamV2 crmSetTenderHeadParamV2) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingMapper
         .getDetailByDelete(crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
                  .eq(
                     crmSetTenderHeadParamV2.getCrmApplyTechnologyBiddingRecordId() != null,
                     CrmApplyTechnologyBiddingRecord::getId,
                     crmSetTenderHeadParamV2.getCrmApplyTechnologyBiddingRecordId()
                  )
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, crmSetTenderHeadParamV2.getCrmSpecialBubmissionStatusEnum())
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmSetTenderHeadParamV2.getCrmProjectInformationWarehousingId())
            );
         Preconditions.checkArgument(crmSetTenderHeadParamV2.getCrmProjectBidStatus() != null, "投标状态不能为空！");
         Preconditions.checkArgument(
            !CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmSetTenderHeadParamV2.getCrmProjectBidStatus())
               || CrmProjectBidStatusEnum.NOT_APPOINTED.getType().equals(crmApplyTechnologyBiddingRecord.getCrmProjectBidStatus()),
            "投标状态不能修改为未任命！"
         );
         if (!crmApplyTechnologyBiddingRecord.getCrmProjectBidStatus().equals(crmSetTenderHeadParamV2.getCrmProjectBidStatus())) {
            crmApplyTechnologyBiddingRecord.setCrmProjectBidStatus(crmSetTenderHeadParamV2.getCrmProjectBidStatus());
            this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord);
         }
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
      }

      if (crmSetTenderHeadParamV2.getCrmTenderRequirementTypeEnum().equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
      }

      return Boolean.TRUE;
   }
}
