package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractTestingFeeBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.CheckFeeDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractTestingFeeDtoParam;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-检测费")
@RestController
@RequestMapping("/api/contract/testing-fee")
public class TestingFeeController {
   private static final Logger log = LoggerFactory.getLogger(TestingFeeController.class);
   @Resource
   private ContractTestingFeeBiz testingFeeBiz;

   @ApiOperation("检测费-汇总列表")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('expense_testing_cost:get')")
   public ResultVO<ListVO<ContractTestingFeeSummaryDTO>> listSummary(@RequestParam Integer year, Long projectId, Long testingFeeTypeId) {
      log.info("Api调用: 物业费-汇总列表");
      return ResultBuilder.success(this.testingFeeBiz.listSummary(year, projectId, testingFeeTypeId));
   }

   @ApiOperation("检测费-条件查询列表")
   @GetMapping
   @PreAuthorize("@permission.check('expense_testing_cost:detail')")
   public ResultVO<PageVO<ContractTestingFeeDTO>> list(
      @RequestParam Integer year,
      Integer month,
      Long projectId,
      Long testingFeeTypeId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:物业费-条件查询列表");
      return ResultBuilder.success(this.testingFeeBiz.listByCondition(year, month, projectId, testingFeeTypeId, pageNumber, pageSize));
   }

   @ApiOperation("检测费-新增")
   @PostMapping
   @PreAuthorize("@permission.check('expense_testing_cost:add')")
   public ResultVO saveList(@RequestBody @Valid List<ContractTestingFeeDtoParam> paramList) {
      log.info("Api调用:物业费-新增");
      return ResultBuilder.success(this.testingFeeBiz.saveList(paramList));
   }

   @ApiOperation("检测费-修改")
   @PutMapping
   @PreAuthorize("@permission.check('expense_testing_cost:edit')")
   public ResultVO updateList(@RequestBody @Validated(Update.class) List<ContractTestingFeeDtoParam> paramList) {
      log.info("Api调用:物业费-修改");
      return ResultBuilder.success(this.testingFeeBiz.updateList(paramList));
   }

   @ApiOperation("检测费-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('expense_testing_cost:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:物业费-删除");
      return ResultBuilder.success(this.testingFeeBiz.deleteList(ids));
   }

   @ApiOperation("运营分析-检索费统计—导出Excel")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "query", required = false),
            @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true)
      }
   )
   @GetMapping("/exportExcel")
   @PreAuthorize("@permission.check('operation_testing:download')")
   public void exportTestingFeeExcel(Long projectId, Integer year, HttpServletResponse response) {
      log.info("Api调用:运营分析-检索费统计—导出Excel");
      this.testingFeeBiz.exportTestingFeeExcel(projectId, year, response);
   }

   @GetMapping("/findAll")
   @ApiOperation("运营分析-检索费统计")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "query", required = false),
            @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true)
      }
   )
   @PreAuthorize("@permission.check('operation_testing:get')")
   public ResultVO<ListVO<CheckFeeDto>> findAll(Long projectId, @RequestParam Integer year) {
      log.info("Api调用:运营分析-检索费统计");
      return ResultBuilder.success(new ListVO<>(this.testingFeeBiz.findAll(projectId, year)));
   }
}
