package com.hzchum.scim.rest.controller.operational;

import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目分析下载")
@RestController
@RequestMapping("/api/pc/operational/project/download")
public class ProjectAnalysisDownloadController {
   private static final Logger log = LoggerFactory.getLogger(ProjectAnalysisDownloadController.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractInvoiceService contractInvoiceService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private ContractProjectBiz contractProjectBiz;

   @ApiOperation("开票收款详情下载")
   @GetMapping("/openUp")
   @PreAuthorize("@permission.check('program_invoice_analysis:download')")
   public void getAnalysisOpenUpDetails(@RequestParam Long projectId, Long branchCompanyId, HttpServletResponse response) {
      log.info("API调用: 开票收款详情下载");
      this.contractInvoiceService.getAnalysisOpenUpDetailsDownload(projectId, branchCompanyId, response);
   }

   @ApiOperation("生产状态详情下载")
   @GetMapping("/productionState")
   @PreAuthorize("@permission.check('program_product_analysis:download')")
   public void getProductionGroupMonth(@RequestParam Long projectId, Long branchCompanyId, @RequestParam Integer taskType, HttpServletResponse response) {
      log.info("API调用: 生产状态详情下载");
      this.teamReportService.getProductionGroupMonthDownload(projectId, branchCompanyId, taskType, response);
   }

   @ApiOperation("项目执行状态详情下载")
   @GetMapping("/projectExecuteState")
   @PreAuthorize("@permission.check('program_execution_analysis:download')")
   public void getProjectExecuteStateDTO(@RequestParam Long projectId, Long branchCompanyId, HttpServletResponse response) {
      log.info("API 调用 ：获取 项目执行状态详情下载");
      this.projectService.getProjectExecuteStateDTODownload(projectId, branchCompanyId, response);
   }

   @ApiOperation("项目成本分析下载")
   @GetMapping("/projectCost")
   @PreAuthorize("@permission.check('program_cost_analysis:download')")
   public void getProjectCost(@RequestParam Long projectId, @RequestParam Long branchCompanyId, HttpServletResponse response) {
      log.info("API 调用 ：项目成本分析下载");
      this.contractProjectBiz.getProjectExpenseCostReportDownload(projectId, branchCompanyId, response);
   }

   @ApiOperation("项目投料状态下载")
   @GetMapping("/projectFeedingState")
   @PreAuthorize("@permission.check('program_feeding_analysis:download','program_execution_analysis:download')")
   public void getProjectFeedingState(@RequestParam Long projectId, Long branchCompanyId, HttpServletResponse response) {
      log.info("API 调用 ：获取 项目投料状态下载");
      this.projectService.getProjectFeedingStateDownload(projectId, branchCompanyId, response);
   }
}
