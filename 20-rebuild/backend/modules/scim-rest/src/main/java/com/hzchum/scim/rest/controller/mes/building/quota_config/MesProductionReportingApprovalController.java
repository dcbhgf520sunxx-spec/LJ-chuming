package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesProductionReportingApprovalBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovedParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "报工审核")
@RequestMapping("/api/mes/building/quota-config/production-reporting-approval")
public class MesProductionReportingApprovalController {
   private static final Logger log = LoggerFactory.getLogger(MesProductionReportingApprovalController.class);
   @Autowired
   private MesProductionReportingApprovalBiz biz;

   @ApiOperation("获取日期是否存在未审核数据列表")
   @GetMapping("date-exists-unapproved-data-list")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query) {
      log.info("API调用: 报工审核-获取存在未审核数据日期列表");
      return ResultBuilder.success(this.biz.dateExistsUnapprovedDataList(query));
   }

   @ApiOperation("获取班组上报汇总列表")
   @GetMapping("team-report-summary-list")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO teamReportSummaryList(MesProductionReportingApprovalQuery query) {
      log.info("API调用: 报工审核-获取班组上报汇总列表");
      return ResultBuilder.success(this.biz.teamReportSummaryList(query));
   }

   @ApiOperation("未审核分页")
   @GetMapping("unapproved-page")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO unapprovedPage(
      MesProductionReportingApprovalQuery query,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 报工审核-未审核分页");
      return ResultBuilder.success(this.biz.unapprovedPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("审批通过")
   @PostMapping("approval-passed")
   @PreAuthorize("@permission.check('mes_work_review:passTheAudit')")
   public ResultVO approvalPassed(@RequestBody MesProductionReportingApprovalPassedParam param) {
      log.info("API调用: 报工审核-审批通过");
      return ResultBuilder.success(this.biz.approvalPassed(param));
   }

   @ApiOperation("批量审批通过")
   @PostMapping("batch-approval-passed")
   @PreAuthorize("@permission.check('mes_work_review:passTheAudit')")
   public ResultVO batchApprovalPassed(@RequestBody ValidList<MesProductionReportingApprovalPassedParam> paramList) {
      log.info("API调用: 报工审核-批量审批通过");
      return ResultBuilder.success(this.biz.batchApprovalPassed(paramList));
   }

   @ApiOperation("获取日期是否存在已审核审核数据列表")
   @GetMapping("date-exists-approved-data-list")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO dateExistsApprovedDataList(MesProductionReportingApprovalQuery query) {
      log.info("API调用: 报工审核-获取日期是否存在已审核审核数据列表");
      return ResultBuilder.success(this.biz.dateExistsApprovedDataList(query));
   }

   @ApiOperation("获取班组上报已审核汇总列表")
   @GetMapping("team-report-approved-summary-list")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query) {
      log.info("API调用: 报工审核-获取班组上报已审核汇总列表");
      return ResultBuilder.success(this.biz.teamReportApprovedSummaryList(query));
   }

   @ApiOperation("已审核分页")
   @GetMapping("approved-page")
   @PreAuthorize("@permission.check('mes_work_review:get')")
   public ResultVO approvedPage(
      MesProductionReportingApprovalQuery query,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 报工审核-已审核分页");
      return ResultBuilder.success(this.biz.approvedPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("已审核编辑")
   @PutMapping("approved-edit")
   @PreAuthorize("@permission.check('mes_work_review:wageAdjustment')")
   public ResultVO approvedEdit(@RequestBody MesProductionReportingApprovedParam param) {
      log.info("API调用: 报工审核-已审核编辑");
      return ResultBuilder.success(this.biz.approvedEdit(param));
   }

   @ApiOperation("审核记录导出")
   @GetMapping("approved-record-export")
   @PreAuthorize("@permission.check('mes_work_review:download')")
   public void approvedRecordExport(MesProductionReportingApprovalQuery query, HttpServletResponse response) {
      log.info("API调用: 报工审核-审核记录导出");
      this.biz.approvedRecordExport(query, response);
   }
}
