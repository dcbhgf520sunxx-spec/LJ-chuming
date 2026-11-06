package com.hzchum.scim.rest.controller.operational;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同分析")
@RestController
@RequestMapping("/api/pc/operational/contract")
public class ContractOperationalAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(ContractOperationalAnalysisController.class);
   @Resource
   private ContractProjectService projectService;

   @ApiOperation("合同汇总")
   @GetMapping("/projectSummary")
   @PreAuthorize("@permission.check('contract_analysis:get')")
   public ResultVO getProjectSummaryDTO(LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：合同汇总");
      return ResultBuilder.success(this.projectService.getProjectSummaryDTO(yearDate, branchCompanyId));
   }

   @ApiOperation("订单统计")
   @GetMapping("/groupProjectDTO")
   @PreAuthorize("@permission.check('contract_analysis:get')")
   public ResultVO getGroupProjectDTO(LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：订单统计");
      return ResultBuilder.success(this.projectService.getGroupProjectDTO(yearDate, branchCompanyId));
   }

   @ApiOperation("订单情况")
   @GetMapping("/groupMonthProjectDTO")
   @PreAuthorize("@permission.check('contract_analysis:get')")
   public ResultVO getGroupMonthProjectDTO(LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：订单情况");
      return ResultBuilder.success(this.projectService.getGroupMonthProjectDTO(yearDate, branchCompanyId));
   }

   @ApiOperation("订单统计详情")
   @GetMapping("/groupProjectDetail/yearDate")
   @PreAuthorize("@permission.check('contract_quantity_analysis:detail','contract_amount_analysis:detail','contract_mete_analysis:detail')")
   public ResultVO getGroupProjectDetailYear(LocalDate yearDate, Integer businessType, Long branchCompanyId) {
      log.info("API 调用 ：订单统计详情");
      return ResultBuilder.success(this.projectService.getGroupProjectDetailDTO(yearDate, businessType, Boolean.TRUE, branchCompanyId));
   }

   @ApiOperation("订单统计详情(合同数量或合同金额)")
   @GetMapping("/groupProjectMeteDetail/mouthDate")
   @PreAuthorize("@permission.check('contract_quantity_analysis:detail','contract_amount_analysis:detail')")
   public ResultVO getGroupProjectDetailMouth(LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：订单统计详情");
      return ResultBuilder.success(this.projectService.getGroupProjectDetailDTO(yearDate, null, Boolean.FALSE, branchCompanyId));
   }

   @ApiOperation("订单统计详情(清单量)")
   @GetMapping("/groupProjectDeepMeteDetail")
   @PreAuthorize("@permission.check('contract_mete_analysis:detail')")
   public ResultVO getGroupProjectDeepMeteDetail(LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：订单统计详情(清单量)");
      return ResultBuilder.success(this.projectService.getGroupProjectDeepMeteDetail(yearDate, branchCompanyId));
   }
}
