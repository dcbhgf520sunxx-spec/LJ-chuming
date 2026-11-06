package com.hzchum.scim.rest.controller.operational;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.plan.core.api.biz.ProjectExecutionDynamicsBiz;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目分析")
@RestController
@RequestMapping("/api/pc/operational/project")
public class ProjectAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(ProjectAnalysisController.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ProjectExecutionDynamicsBiz projectExecutionDynamicsBiz;
   @Resource
   private ContractInvoiceService contractInvoiceService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private ContractProjectBiz contractProjectBiz;

   @ApiOperation("项目列表")
   @GetMapping("/listAllProject")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO<PageVO<ContractProjectListDTO>> listPageByCondition(
      ProjectListQueryParam queryParam, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取 项目列表");
      Preconditions.checkArgument(queryParam.getBranchCompanyId() != null, "分支机构不能为空！");
      return ResultBuilder.success(this.projectService.listAnalysisProjects(queryParam, pageNumber, pageSize));
   }

   @ApiOperation("收款及开票")
   @GetMapping("/projectSelfOwned")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO projectSelfOwnedPageSize(ProjectLedgerDtoParam param) {
      log.info("收款及开票");
      param.setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType());
      Preconditions.checkArgument(param.getBranchCompanyId() != null, "分支机构不能为空！");
      BranchCompany company = this.branchCompanyService.getById(param.getBranchCompanyId());
      Preconditions.checkArgument(company != null, "获取分支机构信息失败！");
      param.setLevel(company.getLevel());
      PageVO<ProjectLedgerDTO> pageVO = this.contractProjectBiz.getProjectSelfOwnedPageSize(param, 1, 20);
      ProjectLedgerDTO projectLedgerDTO = null;
      if (CollectionUtils.isNotEmpty(pageVO.getContent())) {
         projectLedgerDTO = pageVO.getContent().get(0);
      }

      return ResultBuilder.success(projectLedgerDTO);
   }

   @ApiOperation("生产状态")
   @GetMapping("/getProjectProductionMete")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO getProjectProductionMete(@RequestParam Long projectId, Long branchCompanyId) {
      log.info("API 调用 ：获取 生产状态");
      return ResultBuilder.success(this.projectService.getProjectProductionMete(projectId, branchCompanyId));
   }

   @ApiOperation("项目执行状态")
   @GetMapping("/status")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO executionStatus(@RequestParam Long projectId, Long branchCompanyId) {
      log.info("API调用: 项目执行状态");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.getProjectExecutionDynamics(projectId, branchCompanyId));
   }

   @ApiOperation("项目开票收款详情")
   @GetMapping("/openUp")
   @PreAuthorize("@permission.check('program_invoice_analysis:detail')")
   public ResultVO getAnalysisOpenUpDetails(@RequestParam Long projectId, Long branchCompanyId) {
      log.info("API调用: 项目执行状态");
      return ResultBuilder.success(this.contractInvoiceService.getAnalysisOpenUpDetails(projectId, branchCompanyId));
   }

   @ApiOperation("生产状态详情")
   @GetMapping("/productionState")
   @PreAuthorize("@permission.check('program_product_analysis:detail')")
   public ResultVO getProductionGroupMonth(@RequestParam Long projectId, Long branchCompanyId, @RequestParam Integer taskType) {
      log.info("API调用: 生产状态详情");
      return ResultBuilder.success(this.teamReportService.getProductionGroupMonth(projectId, null, branchCompanyId, taskType));
   }

   @ApiOperation("项目投料状态")
   @GetMapping("/projectFeedingState")
   @PreAuthorize("(#isRecently == true and @permission.check('program_analysis:get')) or (#isRecently == false and @permission.check('program_feeding_analysis:detail','program_execution_analysis:detail'))")
   public ResultVO getProjectFeedingState(@RequestParam Long projectId, Long branchCompanyId, @RequestParam Boolean isRecently) {
      log.info("API 调用 ：获取 项目投料状态");
      return ResultBuilder.success(this.projectService.getProjectFeedingState(projectId, branchCompanyId, isRecently));
   }

   @ApiOperation("项目执行状态详情")
   @GetMapping("/projectExecuteState")
   @PreAuthorize("@permission.check('program_execution_analysis:detail')")
   public ResultVO getProjectExecuteStateDTO(@RequestParam Long projectId, Long branchCompanyId) {
      log.info("API 调用 ：获取 项目执行状态详情");
      return ResultBuilder.success(this.projectService.getProjectExecuteStateDTO(projectId, branchCompanyId));
   }

   @ApiOperation("项目成本汇总")
   @GetMapping("/cost/summary")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO manufactureCost(ProjectLedgerDtoParam param) {
      return ResultBuilder.success(this.contractProjectBiz.getCostSummary(param));
   }

   @ApiOperation("项目成本分析")
   @GetMapping("/projectCost")
   @PreAuthorize("@permission.check('program_analysis:get')")
   public ResultVO getProjectCost(@RequestParam Long projectId, @RequestParam Long branchCompanyId) {
      log.info("API 调用 ：项目成本分析");
      return ResultBuilder.success(this.contractProjectBiz.getProjectExpenseCostReportDTO(projectId, branchCompanyId));
   }
}
