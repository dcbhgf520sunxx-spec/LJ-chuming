package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmDataCenterBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmWinningContractWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmGovernmentWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmWinningContractWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessSummaryReportListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessSummaryReportListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmNewProjectInformationDTO;
import com.hzchum.scim.crm.core.api.service.CrmApplyForBidRecordService;
import com.hzchum.scim.crm.core.api.service.CrmBiddingPlatformWarehousingService;
import com.hzchum.scim.crm.core.api.service.CrmEnterpriseWarehousingService;
import com.hzchum.scim.crm.core.api.service.CrmGovernmentWarehousingService;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import com.hzchum.scim.crm.core.api.service.CrmSupplierWarehousingService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmDataCenterBizImpl implements CrmDataCenterBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmProjectInformationWarehousingService crmProjectInformationWarehousingService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmEnterpriseWarehousingService crmEnterpriseWarehousingService;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmGovernmentWarehousingService crmGovernmentWarehousingService;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private CrmBiddingPlatformWarehousingService crmBiddingPlatformWarehousingService;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmSupplierWarehousingService crmSupplierWarehousingService;
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private CrmApplyForBidRecordService crmApplyForBidRecordService;
   @Resource
   private CrmWinningContractWarehousingBiz crmWinningContractWarehousingBiz;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;

   @Transactional
   @Override
   public PrintVO<List<Map<String, Object>>> businessSummaryReportPrint(
      LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      Set<Long> userIds = new HashSet<>();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      userIds.addAll(crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmGovernmentWarehousingList.stream().map(CrmGovernmentWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmBiddingPlatformWarehousings.stream().map(CrmBiddingPlatformWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getInformantUserId).collect(Collectors.toSet()));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getInformantUserId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getInformantUserId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getInformantUserId));
      Map<Long, List<CrmApplyForBidRecord>> crmApplyForBidRecordMap = crmApplyForBidRecords.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmApplyForBidRecord::getInformantUserId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTO> crmBusinessSummaryReportListDTOS = new ArrayList<>();
      if (CollectionUtils.isEmpty(userIds)) {
         printVO.setTable(crmBusinessSummaryReportListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
         return printVO;
      } else {
         List<User> userList = this.userService
            .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(informantUserName), User::getName, informantUserName).in(User::getId, userIds));
         userList.forEach(
            item -> {
               CrmBusinessSummaryReportListDTO crmBusinessSummaryReportListDTO = new CrmBusinessSummaryReportListDTO();
               crmBusinessSummaryReportListDTO.setGovernmentWarehousingNum(
                  CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? crmGovernmentMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTO.setSupplierWarehousingNum(
                  CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? crmSupplierMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTO.setBiddingPlatformWarehousingNum(
                  CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? crmBiddingMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTO.setApplyForBidRecordNum(
                  CollectionUtils.isNotEmpty(crmApplyForBidRecordMap.get(item.getId())) ? crmApplyForBidRecordMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTO.setProjectInformationWarehousingNum(
                  CollectionUtils.isNotEmpty(projectMap.get(item.getId())) ? projectMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTO.setInformantUserId(item.getId());
               crmBusinessSummaryReportListDTO.setInformantUserName(item.getName());
               crmBusinessSummaryReportListDTO.setDepartmentId(item.getDepartmentId());
               crmBusinessSummaryReportListDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()));
               crmBusinessSummaryReportListDTOS.add(crmBusinessSummaryReportListDTO);
            }
         );
         printVO.setTable(crmBusinessSummaryReportListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
         return printVO;
      }
   }

   @Transactional
   @Override
   public PrintVO<List<Map<String, Object>>> newProjectInformationPrint(LocalDateTime startDate, LocalDateTime endDate, String projectName, String salesName) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .like(StringUtils.isNotBlank(projectName), CrmProjectInformationWarehousing::getProjectName, projectName)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .like(StringUtils.isNotBlank(salesName), CrmProjectInformationWarehousing::getInformantUserName, salesName)
         );
      Map<Long, Department> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Function.identity()));
      Map<Long, CrmWinningContractWarehousing> winningContractWarehousingMap = this.crmWinningContractWarehousingBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmWinningContractWarehousing::getCrmProjectInformationWarehousingId, Function.identity()));
      List<CrmNewProjectInformationDTO> crmNewProjectInformationDTOS = crmProjectInformationWarehousings.stream().map(item -> {
         CrmNewProjectInformationDTO crmNewProjectInformationDTO = new CrmNewProjectInformationDTO();
         if (item.getDepartmentId() != null) {
            crmNewProjectInformationDTO.setDepartmentId(item.getDepartmentId());
            crmNewProjectInformationDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()).getName());
         }

         crmNewProjectInformationDTO.setInformantUserName(item.getInformantUserName());
         crmNewProjectInformationDTO.setProjectName(item.getProjectName());
         crmNewProjectInformationDTO.setInformantDateTime(item.getInformantDateTime());
         crmNewProjectInformationDTO.setEstimatedCost(item.getEstimatedCost());
         CrmWinningContractWarehousing crmWinningContractWarehousing = winningContractWarehousingMap.get(item.getId());
         if (crmWinningContractWarehousing != null) {
            crmNewProjectInformationDTO.setAmount(crmWinningContractWarehousing.getAmount());
            crmNewProjectInformationDTO.setIsWinningBidder(Boolean.TRUE);
         } else {
            crmNewProjectInformationDTO.setIsWinningBidder(Boolean.FALSE);
         }

         return crmNewProjectInformationDTO;
      }).collect(Collectors.toList());
      List<Map<String, Object>> mapList = crmNewProjectInformationDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getInfoByInformantUserPrint(Long informantUserId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformantUserId, informantUserId)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getInformantUserId, informantUserId));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getInformantUserId, informantUserId));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getInformantUserId, informantUserId));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(Wrappers.lambdaQuery(CrmApplyForBidRecord.class).eq(CrmApplyForBidRecord::getInformantUserId, informantUserId));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyForBidRecord>> crmApplyForBidRecordMap = crmApplyForBidRecords.stream()
         .collect(Collectors.groupingBy(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTO> crmBusinessSummaryReportListDTOS = new ArrayList<>();
      crmProjectInformationWarehousings.forEach(
         item -> {
            CrmBusinessSummaryReportListDTO crmBusinessSummaryReportListDTO = new CrmBusinessSummaryReportListDTO();
            crmBusinessSummaryReportListDTO.setGovernmentWarehousingNum(
               CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? crmGovernmentMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setSupplierWarehousingNum(
               CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? crmSupplierMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setBiddingPlatformWarehousingNum(
               CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? crmBiddingMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setApplyForBidRecordNum(
               CollectionUtils.isNotEmpty(crmApplyForBidRecordMap.get(item.getId())) ? crmApplyForBidRecordMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setProjectInformationWarehousingNum(1);
            crmBusinessSummaryReportListDTO.setProjectName(item.getProjectName());
            crmBusinessSummaryReportListDTO.setInformantUserId(item.getInformantUserId());
            crmBusinessSummaryReportListDTO.setInformantUserName(item.getInformantUserName());
            crmBusinessSummaryReportListDTO.setDepartmentId(item.getDepartmentId());
            crmBusinessSummaryReportListDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()));
            crmBusinessSummaryReportListDTOS.add(crmBusinessSummaryReportListDTO);
         }
      );
      List<Map<String, Object>> mapList = crmBusinessSummaryReportListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<CrmBusinessSummaryReportListDTO> businessSummaryReport(
      LocalDateTime startDate, LocalDateTime endDate, String informantUserName, Integer pageNumber, Integer pageSize
   ) {
      Set<Long> userIds = new HashSet<>();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      userIds.addAll(crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmGovernmentWarehousingList.stream().map(CrmGovernmentWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmBiddingPlatformWarehousings.stream().map(CrmBiddingPlatformWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmApplyForBidRecords.stream().map(CrmApplyForBidRecord::getInformantUserId).collect(Collectors.toSet()));
      if (CollectionUtils.isEmpty(userIds)) {
         return new PageVO<>();
      }

      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<User> userList = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(informantUserName), User::getName, informantUserName).in(User::getId, userIds));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getInformantUserId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getInformantUserId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getInformantUserId));
      Map<Long, List<CrmApplyForBidRecord>> crmApplyForBidRecordMap = crmApplyForBidRecords.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmApplyForBidRecord::getInformantUserId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTO> crmBusinessSummaryReportListDTOS = new ArrayList<>();
      userList.forEach(
         item -> {
            CrmBusinessSummaryReportListDTO crmBusinessSummaryReportListDTO = new CrmBusinessSummaryReportListDTO();
            crmBusinessSummaryReportListDTO.setGovernmentWarehousingNum(
               CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? crmGovernmentMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setSupplierWarehousingNum(
               CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? crmSupplierMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setBiddingPlatformWarehousingNum(
               CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? crmBiddingMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setApplyForBidRecordNum(
               CollectionUtils.isNotEmpty(crmApplyForBidRecordMap.get(item.getId())) ? crmApplyForBidRecordMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setProjectInformationWarehousingNum(
               CollectionUtils.isNotEmpty(projectMap.get(item.getId())) ? projectMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setInformantUserId(item.getId());
            crmBusinessSummaryReportListDTO.setInformantUserName(item.getName());
            crmBusinessSummaryReportListDTO.setDepartmentId(item.getDepartmentId());
            crmBusinessSummaryReportListDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()));
            crmBusinessSummaryReportListDTOS.add(crmBusinessSummaryReportListDTO);
         }
      );
      return new PageVO<>(objects, crmBusinessSummaryReportListDTOS);
   }

   @Override
   public PageVO<CrmBusinessSummaryReportListDTO> getInfoByInformantUser(Long informantUserId, Integer pageNumber, Integer pageSize) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformantUserId, informantUserId)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getInformantUserId, informantUserId));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getInformantUserId, informantUserId));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getInformantUserId, informantUserId));
      List<CrmApplyForBidRecord> crmApplyForBidRecords = this.crmApplyForBidRecordBiz
         .list(Wrappers.lambdaQuery(CrmApplyForBidRecord.class).eq(CrmApplyForBidRecord::getInformantUserId, informantUserId));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyForBidRecord>> crmApplyForBidRecordMap = crmApplyForBidRecords.stream()
         .collect(Collectors.groupingBy(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTO> crmBusinessSummaryReportListDTOS = new ArrayList<>();
      crmProjectInformationWarehousings.forEach(
         item -> {
            CrmBusinessSummaryReportListDTO crmBusinessSummaryReportListDTO = new CrmBusinessSummaryReportListDTO();
            crmBusinessSummaryReportListDTO.setGovernmentWarehousingNum(
               CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? crmGovernmentMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setSupplierWarehousingNum(
               CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? crmSupplierMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setBiddingPlatformWarehousingNum(
               CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? crmBiddingMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setApplyForBidRecordNum(
               CollectionUtils.isNotEmpty(crmApplyForBidRecordMap.get(item.getId())) ? crmApplyForBidRecordMap.get(item.getId()).size() : 0
            );
            crmBusinessSummaryReportListDTO.setProjectInformationWarehousingNum(1);
            crmBusinessSummaryReportListDTO.setProjectName(item.getProjectName());
            crmBusinessSummaryReportListDTO.setInformantUserId(item.getInformantUserId());
            crmBusinessSummaryReportListDTO.setInformantUserName(item.getInformantUserName());
            crmBusinessSummaryReportListDTO.setDepartmentId(item.getDepartmentId());
            crmBusinessSummaryReportListDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()));
            crmBusinessSummaryReportListDTOS.add(crmBusinessSummaryReportListDTO);
         }
      );
      return new PageVO<>(objects, crmBusinessSummaryReportListDTOS);
   }

   @Override
   public PageVO<CrmNewProjectInformationDTO> newProjectInformation(
      LocalDateTime startDate, LocalDateTime endDate, String projectName, String salesName, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .like(StringUtils.isNotBlank(projectName), CrmProjectInformationWarehousing::getProjectName, projectName)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .like(StringUtils.isNotBlank(salesName), CrmProjectInformationWarehousing::getInformantUserName, salesName)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(crmProjectInformationWarehousings)) {
         return new PageVO<>();
      }

      Map<Long, Department> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Function.identity()));
      Map<Long, CrmWinningContractWarehousing> winningContractWarehousingMap = this.crmWinningContractWarehousingBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmWinningContractWarehousing::getCrmProjectInformationWarehousingId, Function.identity()));
      List<CrmNewProjectInformationDTO> crmNewProjectInformationDTOS = crmProjectInformationWarehousings.stream().map(item -> {
         CrmNewProjectInformationDTO crmNewProjectInformationDTO = new CrmNewProjectInformationDTO();
         if (item.getDepartmentId() != null) {
            crmNewProjectInformationDTO.setDepartmentId(item.getDepartmentId());
            Department department = departmentMap.get(item.getDepartmentId());
            if (department != null) {
               crmNewProjectInformationDTO.setDepartmentName(departmentMap.get(item.getDepartmentId()).getName());
            }
         }

         crmNewProjectInformationDTO.setInformantUserName(item.getInformantUserName());
         crmNewProjectInformationDTO.setProjectName(item.getProjectName());
         crmNewProjectInformationDTO.setInformantDateTime(item.getInformantDateTime());
         crmNewProjectInformationDTO.setEstimatedCost(item.getEstimatedCost());
         CrmWinningContractWarehousing crmWinningContractWarehousing = winningContractWarehousingMap.get(item.getId());
         if (crmWinningContractWarehousing != null) {
            crmNewProjectInformationDTO.setAmount(crmWinningContractWarehousing.getAmount());
            crmNewProjectInformationDTO.setIsWinningBidder(Boolean.TRUE);
         } else {
            crmNewProjectInformationDTO.setIsWinningBidder(Boolean.FALSE);
         }

         return crmNewProjectInformationDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(objects, crmNewProjectInformationDTOS);
   }

   @Override
   public PageVO<CrmBusinessSummaryReportListDTOV2> businessSummaryReportCustom(
      LocalDateTime startDate, LocalDateTime endDate, String informantUserName, Integer pageNumber, Integer pageSize
   ) {
      Set<Long> userIds = new HashSet<>();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      userIds.addAll(crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmGovernmentWarehousingList.stream().map(CrmGovernmentWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmBiddingPlatformWarehousings.stream().map(CrmBiddingPlatformWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Map<Long, List<CrmApplyBusinessBiddingRecord>> crmbusinessMap = crmApplyBusinessBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmTechnologyMap = crmApplyTechnologyBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyDeepDesignBiddingRecord>> crmDeepMap = crmApplyDeepDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyStructuralDesignBiddingRecord>> crmStructuralMap = crmApplyStructuralDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      userIds.addAll(crmApplyBusinessBiddingRecords.stream().map(CrmApplyBusinessBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyTechnologyBiddingRecords.stream().map(CrmApplyTechnologyBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyDeepDesignBiddingRecords.stream().map(CrmApplyDeepDesignBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyStructuralDesignBiddingRecords.stream().map(CrmApplyStructuralDesignBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      if (CollectionUtils.isEmpty(userIds)) {
         return new PageVO<>();
      }

      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<User> userList = this.userService
         .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(informantUserName), User::getName, informantUserName).in(User::getId, userIds));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getInformantUserId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getInformantUserId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getInformantUserId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTOV2> crmBusinessSummaryReportListDTOSV2 = new ArrayList<>();
      userList.forEach(
         item -> {
            CrmBusinessSummaryReportListDTOV2 crmBusinessSummaryReportListDTOV2 = new CrmBusinessSummaryReportListDTOV2();
            crmBusinessSummaryReportListDTOV2.setGovernmentWarehousingNum(
               CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? String.valueOf(crmGovernmentMap.get(item.getId()).size()) : "0"
            );
            crmBusinessSummaryReportListDTOV2.setSupplierWarehousingNum(
               CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? String.valueOf(crmSupplierMap.get(item.getId()).size()) : "0"
            );
            crmBusinessSummaryReportListDTOV2.setBiddingPlatformWarehousingNum(
               CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? String.valueOf(crmBiddingMap.get(item.getId()).size()) : "0"
            );
            crmBusinessSummaryReportListDTOV2.setProjectInformationWarehousingNum(
               CollectionUtils.isNotEmpty(projectMap.get(item.getId())) ? projectMap.get(item.getId()).size() : 0
            );
            List<CrmProjectInformationWarehousing> projectInformationWarehousings = projectMap.get(item.getId());
            int count = 0;
            if (CollectionUtils.isNotEmpty(projectInformationWarehousings)) {
               for (CrmProjectInformationWarehousing projectInformationWarehousing : projectInformationWarehousings) {
                  List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords1 = crmbusinessMap.get(projectInformationWarehousing.getId());
                  if (CollectionUtils.isNotEmpty(crmApplyBusinessBiddingRecords1)) {
                     count += crmApplyBusinessBiddingRecords1.size();
                  }

                  List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords1 = crmTechnologyMap.get(projectInformationWarehousing.getId());
                  if (CollectionUtils.isNotEmpty(crmApplyTechnologyBiddingRecords1)) {
                     count += crmApplyTechnologyBiddingRecords1.size();
                  }

                  List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords1 = crmDeepMap.get(projectInformationWarehousing.getId());
                  if (CollectionUtils.isNotEmpty(crmApplyDeepDesignBiddingRecords1)) {
                     count += crmApplyDeepDesignBiddingRecords1.size();
                  }

                  List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords1 = crmStructuralMap.get(
                     projectInformationWarehousing.getId()
                  );
                  if (CollectionUtils.isNotEmpty(crmApplyStructuralDesignBiddingRecords1)) {
                     count += crmApplyStructuralDesignBiddingRecords1.size();
                  }
               }
            }

            crmBusinessSummaryReportListDTOV2.setApplyForBidRecordNum(count);
            crmBusinessSummaryReportListDTOV2.setInformantUserId(item.getId());
            crmBusinessSummaryReportListDTOV2.setInformantUserName(item.getName());
            crmBusinessSummaryReportListDTOV2.setDepartmentId(item.getDepartmentId());
            crmBusinessSummaryReportListDTOV2.setDepartmentName(departmentMap.get(item.getDepartmentId()));
            crmBusinessSummaryReportListDTOSV2.add(crmBusinessSummaryReportListDTOV2);
         }
      );
      return new PageVO<>(objects, crmBusinessSummaryReportListDTOSV2);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> businessSummaryReportPrintCustom(
      LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      Set<Long> userIds = new HashSet<>();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      userIds.addAll(crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmGovernmentWarehousingList.stream().map(CrmGovernmentWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      userIds.addAll(crmBiddingPlatformWarehousings.stream().map(CrmBiddingPlatformWarehousing::getInformantUserId).collect(Collectors.toSet()));
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Map<Long, List<CrmApplyBusinessBiddingRecord>> crmbusinessMap = crmApplyBusinessBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmTechnologyMap = crmApplyTechnologyBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyDeepDesignBiddingRecord>> crmDeepMap = crmApplyDeepDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyStructuralDesignBiddingRecord>> crmStructuralMap = crmApplyStructuralDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      userIds.addAll(crmApplyBusinessBiddingRecords.stream().map(CrmApplyBusinessBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyTechnologyBiddingRecords.stream().map(CrmApplyTechnologyBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyDeepDesignBiddingRecords.stream().map(CrmApplyDeepDesignBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      userIds.addAll(crmApplyStructuralDesignBiddingRecords.stream().map(CrmApplyStructuralDesignBiddingRecord::getInformantUserId).collect(Collectors.toSet()));
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getInformantUserId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getInformantUserId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getInformantUserId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getInformantUserId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTOV2> crmBusinessSummaryReportListDTOV2s = new ArrayList<>();
      if (CollectionUtils.isEmpty(userIds)) {
         printVO.setTable(crmBusinessSummaryReportListDTOV2s.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
         return printVO;
      } else {
         List<User> userList = this.userService
            .list(Wrappers.lambdaQuery(User.class).like(StringUtils.isNotBlank(informantUserName), User::getName, informantUserName).in(User::getId, userIds));
         userList.forEach(
            item -> {
               CrmBusinessSummaryReportListDTOV2 crmBusinessSummaryReportListDTOV2 = new CrmBusinessSummaryReportListDTOV2();
               crmBusinessSummaryReportListDTOV2.setGovernmentWarehousingNum(
                  CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? String.valueOf(crmGovernmentMap.get(item.getId()).size()) : "0"
               );
               crmBusinessSummaryReportListDTOV2.setSupplierWarehousingNum(
                  CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? String.valueOf(crmSupplierMap.get(item.getId()).size()) : "0"
               );
               crmBusinessSummaryReportListDTOV2.setBiddingPlatformWarehousingNum(
                  CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? String.valueOf(crmBiddingMap.get(item.getId()).size()) : "0"
               );
               List<CrmProjectInformationWarehousing> projectInformationWarehousings = projectMap.get(item.getId());
               int count = 0;
               if (CollectionUtils.isNotEmpty(projectInformationWarehousings)) {
                  for (CrmProjectInformationWarehousing projectInformationWarehousing : projectInformationWarehousings) {
                     List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords1 = crmbusinessMap.get(projectInformationWarehousing.getId());
                     if (CollectionUtils.isNotEmpty(crmApplyBusinessBiddingRecords1)) {
                        count += crmApplyBusinessBiddingRecords1.size();
                     }

                     List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords1 = crmTechnologyMap.get(projectInformationWarehousing.getId());
                     if (CollectionUtils.isNotEmpty(crmApplyTechnologyBiddingRecords1)) {
                        count += crmApplyTechnologyBiddingRecords1.size();
                     }

                     List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords1 = crmDeepMap.get(projectInformationWarehousing.getId());
                     if (CollectionUtils.isNotEmpty(crmApplyDeepDesignBiddingRecords1)) {
                        count += crmApplyDeepDesignBiddingRecords1.size();
                     }

                     List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords1 = crmStructuralMap.get(
                        projectInformationWarehousing.getId()
                     );
                     if (CollectionUtils.isNotEmpty(crmApplyStructuralDesignBiddingRecords1)) {
                        count += crmApplyStructuralDesignBiddingRecords1.size();
                     }
                  }
               }

               crmBusinessSummaryReportListDTOV2.setApplyForBidRecordNum(count);
               crmBusinessSummaryReportListDTOV2.setProjectInformationWarehousingNum(
                  CollectionUtils.isNotEmpty(projectMap.get(item.getId())) ? projectMap.get(item.getId()).size() : 0
               );
               crmBusinessSummaryReportListDTOV2.setInformantUserId(item.getId());
               crmBusinessSummaryReportListDTOV2.setInformantUserName(item.getName());
               crmBusinessSummaryReportListDTOV2.setDepartmentId(item.getDepartmentId());
               crmBusinessSummaryReportListDTOV2.setDepartmentName(departmentMap.get(item.getDepartmentId()));
               crmBusinessSummaryReportListDTOV2s.add(crmBusinessSummaryReportListDTOV2);
            }
         );
         printVO.setTable(crmBusinessSummaryReportListDTOV2s.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
         return printVO;
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getInfoByInformantUserPrintCustom(Long informantUserId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformantUserId, informantUserId)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getInformantUserId, informantUserId));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getInformantUserId, informantUserId));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getInformantUserId, informantUserId));
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
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
      Map<Long, List<CrmProjectInformationWarehousing>> projectMap = crmProjectInformationWarehousings.stream()
         .collect(Collectors.groupingBy(CrmProjectInformationWarehousing::getInformantUserId));
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyBusinessBiddingRecord>> crmbusinessMap = crmApplyBusinessBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmTechnologyMap = crmApplyTechnologyBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyDeepDesignBiddingRecord>> crmDeepMap = crmApplyDeepDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyStructuralDesignBiddingRecord>> crmStructuralMap = crmApplyStructuralDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTOV2> crmBusinessSummaryReportListDTOSV2 = new ArrayList<>();
      crmProjectInformationWarehousings.forEach(item -> {
         int count = 0;
         List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords1 = crmbusinessMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyBusinessBiddingRecords1)) {
            count += crmApplyBusinessBiddingRecords1.size();
         }

         List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords1 = crmTechnologyMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyTechnologyBiddingRecords1)) {
            count += crmApplyTechnologyBiddingRecords1.size();
         }

         List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords1 = crmDeepMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyDeepDesignBiddingRecords1)) {
            count += crmApplyDeepDesignBiddingRecords1.size();
         }

         List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords1 = crmStructuralMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyStructuralDesignBiddingRecords1)) {
            count += crmApplyStructuralDesignBiddingRecords1.size();
         }

         CrmBusinessSummaryReportListDTOV2 crmBusinessSummaryReportListDTOV2 = new CrmBusinessSummaryReportListDTOV2();
         crmBusinessSummaryReportListDTOV2.setGovernmentWarehousingNum(CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setSupplierWarehousingNum(CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setBiddingPlatformWarehousingNum(CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setApplyForBidRecordNum(count);
         crmBusinessSummaryReportListDTOV2.setProjectInformationWarehousingNum(1);
         crmBusinessSummaryReportListDTOV2.setProjectName(item.getProjectName());
         crmBusinessSummaryReportListDTOV2.setInformantUserId(item.getInformantUserId());
         crmBusinessSummaryReportListDTOV2.setInformantUserName(item.getInformantUserName());
         crmBusinessSummaryReportListDTOV2.setDepartmentId(item.getDepartmentId());
         crmBusinessSummaryReportListDTOV2.setDepartmentName(departmentMap.get(item.getDepartmentId()));
         crmBusinessSummaryReportListDTOSV2.add(crmBusinessSummaryReportListDTOV2);
      });
      List<Map<String, Object>> mapList = crmBusinessSummaryReportListDTOSV2.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<CrmBusinessSummaryReportListDTOV2> getInfoByInformantUserCustom(Long informantUserId, Integer pageNumber, Integer pageSize) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getInformantUserId, informantUserId)
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmGovernmentWarehousing> crmGovernmentWarehousingList = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getInformantUserId, informantUserId));
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getInformantUserId, informantUserId));
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getInformantUserId, informantUserId));
      List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
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
      Map<Long, List<CrmGovernmentWarehousing>> crmGovernmentMap = crmGovernmentWarehousingList.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmGovernmentWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmSupplierWarehousing>> crmSupplierMap = crmSupplierWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmSupplierWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmBiddingPlatformWarehousing>> crmBiddingMap = crmBiddingPlatformWarehousings.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmBiddingPlatformWarehousing::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyBusinessBiddingRecord>> crmbusinessMap = crmApplyBusinessBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyTechnologyBiddingRecord>> crmTechnologyMap = crmApplyTechnologyBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyDeepDesignBiddingRecord>> crmDeepMap = crmApplyDeepDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, List<CrmApplyStructuralDesignBiddingRecord>> crmStructuralMap = crmApplyStructuralDesignBiddingRecords.stream()
         .filter(item -> item.getCrmProjectInformationWarehousingId() != null)
         .collect(Collectors.groupingBy(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId));
      Map<Long, String> departmentMap = this.departmentService
         .getAllDepartmentList()
         .stream()
         .collect(Collectors.toMap(Department::getId, Department::getName));
      List<CrmBusinessSummaryReportListDTOV2> crmBusinessSummaryReportListDTOSV2 = new ArrayList<>();
      crmProjectInformationWarehousings.forEach(item -> {
         int count = 0;
         List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords1 = crmbusinessMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyBusinessBiddingRecords1)) {
            count += crmApplyBusinessBiddingRecords1.size();
         }

         List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords1 = crmTechnologyMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyTechnologyBiddingRecords1)) {
            count += crmApplyTechnologyBiddingRecords1.size();
         }

         List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords1 = crmDeepMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyDeepDesignBiddingRecords1)) {
            count += crmApplyDeepDesignBiddingRecords1.size();
         }

         List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords1 = crmStructuralMap.get(item.getId());
         if (CollectionUtils.isNotEmpty(crmApplyStructuralDesignBiddingRecords1)) {
            count += crmApplyStructuralDesignBiddingRecords1.size();
         }

         CrmBusinessSummaryReportListDTOV2 crmBusinessSummaryReportListDTOV2 = new CrmBusinessSummaryReportListDTOV2();
         crmBusinessSummaryReportListDTOV2.setGovernmentWarehousingNum(CollectionUtils.isNotEmpty(crmGovernmentMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setSupplierWarehousingNum(CollectionUtils.isNotEmpty(crmSupplierMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setBiddingPlatformWarehousingNum(CollectionUtils.isNotEmpty(crmBiddingMap.get(item.getId())) ? "是" : "否");
         crmBusinessSummaryReportListDTOV2.setApplyForBidRecordNum(count);
         crmBusinessSummaryReportListDTOV2.setProjectInformationWarehousingNum(1);
         crmBusinessSummaryReportListDTOV2.setProjectName(item.getProjectName());
         crmBusinessSummaryReportListDTOV2.setInformantUserId(item.getInformantUserId());
         crmBusinessSummaryReportListDTOV2.setInformantUserName(item.getInformantUserName());
         crmBusinessSummaryReportListDTOV2.setDepartmentId(item.getDepartmentId());
         crmBusinessSummaryReportListDTOV2.setDepartmentName(departmentMap.get(item.getDepartmentId()));
         crmBusinessSummaryReportListDTOSV2.add(crmBusinessSummaryReportListDTOV2);
      });
      return new PageVO<>(objects, crmBusinessSummaryReportListDTOSV2);
   }
}
