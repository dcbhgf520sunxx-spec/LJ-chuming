package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.PlanDetailBiz;
import com.hzchum.scim.plan.core.api.biz.PlanSummaryBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-工作计划")
@RestController
@RequestMapping("/api/plan/planDetail")
@Validated
public class PlanDetailApi {
   private static final Logger log = LoggerFactory.getLogger(PlanDetailApi.class);
   @Resource
   private PlanDetailBiz planDetailBiz;
   @Autowired
   private PlanSummaryBiz summaryBiz;

   @ApiOperation(value = "工作计划列表", notes = "根据项目id 单体id 查看工作计划列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
      }
   )
   @GetMapping("/list/{projectId}")
   @PreAuthorize("@permission.check('plan_make_manage:get')")
   public ResultVO<ListVO<PlanMonomerDTO>> listDetails(@PathVariable("projectId") Long projectId, Long monomerId) {
      log.info("Api调用: 查询工作详细计划列表");
      return ResultBuilder.success(this.planDetailBiz.listDetailsByConditions(projectId, monomerId));
   }

   @ApiOperation(value = "导出工作计划列表", notes = "根据项目id 单体id 产品类型 导出工作计划表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型  1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query", required = true)
      }
   )
   @GetMapping("/export")
   @PreAuthorize("@permission.check('plan_make_manage:print')")
   public void exportPlanDetail(@RequestParam Long monomerId, @RequestParam Integer productType, HttpServletResponse response) {
      log.info("Api调用: 导出工作计划列表");
      this.planDetailBiz.exportPlanDetails(monomerId, productType, response);
   }

   @ApiOperation(value = "编辑计划详情", notes = "修改计划详情的日期 和 备注")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('plan_make_manage:edit')")
   public ResultVO updatePlanDetail(@RequestBody @Valid PlanDetailUpdateDTOParam updateDTOParam) {
      log.info("Api调用: 编辑计划详情");
      return ResultBuilder.success(this.planDetailBiz.updatePlanDetail(updateDTOParam));
   }

   @ApiOperation(value = "批量编辑区域计划详情", notes = "批量修改计划详情的日期和备注")
   @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "path", required = true)
   @PutMapping("/updateList/{areaId}")
   @PreAuthorize("@permission.check('plan_make_manage:edit')")
   public ResultVO updatePlanDetailList(@PathVariable Long areaId, @RequestBody @Valid List<PlanDetailUpdateDTOParam> paramList) {
      log.info("Api调用: 批量编辑计划详情");
      return ResultBuilder.success(this.planDetailBiz.editPlanDetailList(areaId, paramList));
   }

   @ApiOperation("打印计划表单")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型  1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query", required = true),
            @ApiImplicitParam(name = "type", value = "计划类型 1-深化计划 2-加工计划 4-安装计划 ", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
      }
   )
   @GetMapping("/print")
   @PreAuthorize("@permission.check('plan_make_manage:print')")
   public ResultVO printOverallPlan(@RequestParam Long monomerId, @RequestParam Integer productType, @RequestParam Integer type) {
      log.info("API 调用 ：打印计划表单");
      return ResultBuilder.success(this.planDetailBiz.printOverallPlan(monomerId, productType, type));
   }

   @ApiOperation("计划跟踪列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目ID", paramType = "query", required = true)
      }
   )
   @GetMapping("/listTrace")
   @PreAuthorize("@permission.check('plan_progress:get','subcontract_progress:get','project_progress:get')")
   public ResultVO<ListVO<PlanMonomerDTO>> listMonomerTraces(@RequestParam Long projectId, Long monomerId) {
      log.info("Api调用: 计划跟踪列表");
      return ResultBuilder.success(this.planDetailBiz.listDetailsByCondition(projectId, monomerId));
   }

   @ApiOperation("计划跟踪列表V2")
   @GetMapping("/listTracev2")
   @PreAuthorize("@permission.check('plan_progress:get','subcontract_progress:get','project_progress:get','product_progress:get')")
   public ResultVO listMonomerTracesV2(@RequestParam Long projectId, @RequestParam(required = false) Long monomerId) {
      log.info("Api调用: 计划跟踪列表");
      return ResultBuilder.success(this.planDetailBiz.listDetailsByConditionV4(projectId, monomerId));
   }

   @ApiOperation("区域下构件生产详情")
   @GetMapping("/areaArtifactComplete/detail")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getAreaArtifactOneCodeCompleteDetails(
      @RequestParam Long areaId,
      @RequestParam(required = false, defaultValue = "0") Long processId,
      @RequestParam(name = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 区域下构件生产详情");
      return ResultBuilder.success(this.planDetailBiz.getAreaArtifactOneCodeCompleteDetails(areaId, processId, pageNumber, pageSize));
   }

   @ApiOperation("打印-区域下构件生产详情")
   @GetMapping("/areaArtifactComplete/detail/print")
   @PreAuthorize("@permission.check('product_progress:print')")
   public ResultVO areaArtifactOneCodeCompleteDetailsPrint(@RequestParam Long areaId, @RequestParam(required = false, defaultValue = "0") Long processId) {
      log.info("Api调用:区域下构件生产详情");
      return ResultBuilder.success(this.planDetailBiz.areaArtifactOneCodeCompleteDetailsPrint(areaId, processId));
   }

   @ApiOperation("打印-区域下构件深化详情")
   @GetMapping("/areaArtifact/detail/print")
   @PreAuthorize("@permission.check('product_progress:print')")
   public ResultVO areaArtifactOneCodeCompleteDetailsPrint(@RequestParam Long areaId) {
      log.info("Api调用:区域下构件深化详情");
      return ResultBuilder.success(this.planDetailBiz.areaArtifactDetailsPrint(areaId));
   }

   @ApiOperation("区域下构件生产汇总")
   @GetMapping("/areaArtifactComplete/summary")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getAreaArtifactOneCodeCompleteSummary(@RequestParam Long areaId, @RequestParam(required = false, defaultValue = "0") Long processId) {
      log.info("Api调用: 区域下构件生产汇总");
      return ResultBuilder.success(this.planDetailBiz.getAreaArtifactOneCodeCompleteSummary(areaId, processId));
   }

   @ApiOperation("区域下构件生产工序")
   @GetMapping("/areaArtifactComplete/process")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getAreaArtifactOneCodeCompleteProcess(@RequestParam Long areaId) {
      log.info("Api调用: 区域下构件生产工序");
      return ResultBuilder.success(this.planDetailBiz.getAreaArtifactOneCodeCompleteProcessList(areaId));
   }

   @ApiOperation("排产汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('plan_summary:get')")
   public ResultVO listTaskRecord(@RequestParam String year, @RequestParam Integer type) {
      log.info("API 调用 ：排产汇总");
      return ResultBuilder.success(this.summaryBiz.listMetByProduct(year, type));
   }

   @ApiOperation("区域下围护生产工序")
   @GetMapping("/enclosureComplete/process")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getEnclosureCompleteProcessList(@RequestParam Long areaId) {
      log.info("Api调用: 区域下构件生产工序");
      return ResultBuilder.success(this.planDetailBiz.getEnclosureCompleteProcessList(areaId));
   }

   @ApiOperation("区域下围护生产详情")
   @GetMapping("/enclosureComplete/detail")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getEnclosureCompleteDetails(
      @RequestParam Long areaId,
      @RequestParam(required = false, defaultValue = "0") Long processId,
      @RequestParam(name = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 区域下围护生产详情");
      return ResultBuilder.success(this.planDetailBiz.getEnclosureCompleteDetails(areaId, processId, pageNumber, pageSize));
   }

   @ApiOperation("区域下围护生产汇总")
   @GetMapping("/enclosureComplete/summary")
   @PreAuthorize("@permission.check('product_progress:detail')")
   public ResultVO getEnclosureCompleteSummary(@RequestParam Long areaId, @RequestParam(required = false, defaultValue = "0") Long processId) {
      log.info("Api调用: 区域下围护生产汇总");
      return ResultBuilder.success(this.planDetailBiz.getEnclosureCompleteSummary(areaId, processId));
   }

   @ApiOperation("打印-区域下围护生产详情")
   @GetMapping("/enclosureComplete/detail/print")
   @PreAuthorize("@permission.check('product_progress:print')")
   public ResultVO getEnclosureCompleteDetailsPrint(@RequestParam Long areaId, @RequestParam(required = false, defaultValue = "0") Long processId) {
      log.info("Api调用:区域下围护生产详情");
      return ResultBuilder.success(this.planDetailBiz.getEnclosureCompleteDetailsPrint(areaId, processId));
   }

   @ApiOperation("打印-区域下围护深化详情")
   @GetMapping("/areaEnclosure/detail/print")
   @PreAuthorize("@permission.check('product_progress:print')")
   public ResultVO areaEnclosureDetailsPrint(@RequestParam Long areaId) {
      log.info("Api调用:区域下围护深化详情");
      return ResultBuilder.success(this.planDetailBiz.areaEnclosureDetailsPrint(areaId));
   }
}
