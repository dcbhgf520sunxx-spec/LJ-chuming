package com.hzchum.scim.rest.controller.operational;

import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同分析下载")
@RestController
@RequestMapping("/api/pc/operational/contract/download")
public class ContractAnalysisDownloadController {
   private static final Logger log = LoggerFactory.getLogger(ContractAnalysisDownloadController.class);
   @Resource
   private ContractProjectService projectService;

   @ApiOperation("合同年度汇总 及 月度数量合同额汇总详情下载")
   @GetMapping("/contract/costSummary/detail")
   @PreAuthorize("@permission.check('contract_quantity_analysis:download','contract_amount_analysis:download')")
   public void downloadPickingDetailDTO(LocalDate yearDate, Boolean year, Integer businessType, Long branchCompanyId, HttpServletResponse response) {
      log.info("API 调用 ：合同汇总详情下载");
      this.projectService.getGroupProjectDetailDTODownload(yearDate, year, businessType, branchCompanyId, response);
   }

   @ApiOperation("月度深化量汇总详情下载")
   @GetMapping("/contract/deepMeteSummary/detail")
   @PreAuthorize("@permission.check('contract_mete_analysis:download')")
   public void getGroupProjectDeepMeteDetailDownload(LocalDate yearDate, Long branchCompanyId, HttpServletResponse response) {
      log.info("API 调用 ：合同汇总详情下载");
      this.projectService.getGroupProjectDeepMeteDetailDownload(yearDate, branchCompanyId, response);
   }
}
