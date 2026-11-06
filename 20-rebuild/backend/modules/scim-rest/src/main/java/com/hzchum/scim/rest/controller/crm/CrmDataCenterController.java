package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmDataCenterBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-数据中心")
@RestController
@RequestMapping("/api/crm/data/center")
public class CrmDataCenterController {
   private static final Logger log = LoggerFactory.getLogger(CrmDataCenterController.class);
   @Resource
   private CrmDataCenterBiz crmDataCenterBiz;

   @ApiOperation("商务部汇总报表打印")
   @GetMapping("/business/print")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:print')")
   public ResultVO businessSummaryReportPrint(LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName) {
      log.info("API调用：商务部汇总报表打印");
      return ResultBuilder.success(this.crmDataCenterBiz.businessSummaryReportPrint(startDate, endDate, projectName, informantUserName));
   }

   @ApiOperation("商务部汇总报表")
   @GetMapping("/business")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:get')")
   public ResultVO businessSummaryReport(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用：商务部汇总报表");
      return ResultBuilder.success(this.crmDataCenterBiz.businessSummaryReport(startDate, endDate, informantUserName, pageNumber, pageSize));
   }

   @ApiOperation("商务部人员项目信息列表打印")
   @GetMapping("/get/info/by/informant/user/print")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:detailPrint')")
   public ResultVO getInfoByInformantUserPrint(Long informantUserId) {
      log.info("API调用:商务部人员项目信息列表");
      return ResultBuilder.success(this.crmDataCenterBiz.getInfoByInformantUserPrint(informantUserId));
   }

   @ApiOperation("商务部人员项目信息列表")
   @GetMapping("/get/info/by/informant/user")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:detail')")
   public ResultVO getInfoByInformantUser(
      Long informantUserId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:商务部人员项目信息列表");
      return ResultBuilder.success(this.crmDataCenterBiz.getInfoByInformantUser(informantUserId, pageNumber, pageSize));
   }

   @ApiOperation("新增工程信息登记数据分析报表打印")
   @GetMapping("/new/project/print")
   @PreAuthorize("@permission.check('crm_engineer_infomation_statistics:get')")
   public ResultVO newProjectInformationPrint(LocalDateTime startDate, LocalDateTime endDate, String projectName, String salesName) {
      log.info("API调用：新增工程信息登记数据分析报表打印");
      return ResultBuilder.success(this.crmDataCenterBiz.newProjectInformationPrint(startDate, endDate, projectName, salesName));
   }

   @ApiOperation("新增工程信息登记数据分析报表")
   @GetMapping("/new/project")
   @PreAuthorize("@permission.check('crm_engineer_infomation_statistics:get')")
   public ResultVO newProjectInformation(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String salesName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用：新增工程信息登记数据分析报表");
      return ResultBuilder.success(this.crmDataCenterBiz.newProjectInformation(startDate, endDate, projectName, salesName, pageNumber, pageSize));
   }

   @ApiOperation("商务部汇总报表打印(定制)")
   @GetMapping("/business/print/custom")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:print')")
   public ResultVO businessSummaryReportPrintCustom(LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName) {
      log.info("API调用：商务部汇总报表打印(定制)");
      return ResultBuilder.success(this.crmDataCenterBiz.businessSummaryReportPrintCustom(startDate, endDate, projectName, informantUserName));
   }

   @ApiOperation("商务部汇总报表(定制)")
   @GetMapping("/business/custom")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:get')")
   public ResultVO businessSummaryReportCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用：商务部汇总报表(定制)");
      return ResultBuilder.success(this.crmDataCenterBiz.businessSummaryReportCustom(startDate, endDate, informantUserName, pageNumber, pageSize));
   }

   @ApiOperation("商务部人员项目信息列表打印(定制)")
   @GetMapping("/get/info/by/informant/user/print/custom")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:detailPrint')")
   public ResultVO getInfoByInformantUserPrintCustom(Long informantUserId) {
      log.info("API调用:商务部人员项目信息列表(定制)");
      return ResultBuilder.success(this.crmDataCenterBiz.getInfoByInformantUserPrintCustom(informantUserId));
   }

   @ApiOperation("商务部人员项目信息列表(定制)")
   @GetMapping("/get/info/by/informant/user/custom")
   @PreAuthorize("@permission.check('crm_business_summary_statistics:detail')")
   public ResultVO getInfoByInformantUserCustom(
      Long informantUserId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:商务部人员项目信息列表(定制)");
      return ResultBuilder.success(this.crmDataCenterBiz.getInfoByInformantUserCustom(informantUserId, pageNumber, pageSize));
   }
}
