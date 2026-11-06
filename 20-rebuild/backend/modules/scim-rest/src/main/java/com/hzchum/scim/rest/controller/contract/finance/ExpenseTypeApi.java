package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractExpenseTypeBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ExpenseTypeSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ExpenseTypeUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配置管理-费用分类")
@RestController
@RequestMapping("/api/expenseType")
public class ExpenseTypeApi {
   private static final Logger log = LoggerFactory.getLogger(ExpenseTypeApi.class);
   @Resource
   private ContractExpenseTypeBiz expenseTypeBiz;
   @Resource
   private ContractExpenseTypeService expenseTypeService;

   @ApiOperation("费用类型-列表")
   @GetMapping
   @PreAuthorize("@permission.check('expense_management:get')")
   public ResultVO<PageVO<ContractExpenseTypeDTO>> listByCondition(
      String name, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：费用类型列表");
      return ResultBuilder.success(this.expenseTypeBiz.listByCondition(name, pageNumber, pageSize));
   }

   @ApiOperation("费用类型-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('expense_management:del')")
   public ResultVO deleteExpenseType(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除费用类型");
      return ResultBuilder.success(this.expenseTypeBiz.deleteExpenseType(ids));
   }

   @ApiOperation("费用类型-修改")
   @PutMapping
   @PreAuthorize("@permission.check('expense_management:edit')")
   public ResultVO updateExpenseType(@Valid @RequestBody ExpenseTypeUpdateDTOParam requestVO) {
      log.info("API 调用 ： 更新费用类型");
      return ResultBuilder.success(this.expenseTypeBiz.updateExpenseType(requestVO));
   }

   @ApiOperation("费用类型-新增")
   @PostMapping
   @PreAuthorize("@permission.check('expense_management:add')")
   public ResultVO saveExpenseType(@Valid @RequestBody ExpenseTypeSaveDtoParam requestVO) {
      log.info("API 调用 ：新增费用类型");
      return ResultBuilder.success(this.expenseTypeBiz.saveExpenseType(requestVO));
   }

   @ApiOperation("所有费用类型-明细")
   @GetMapping("/all")
   public ResultVO<ListVO<ContractExpenseTypeDTO>> listAll(String name) {
      log.info("Api调用:所有费用类型和明细");
      return ResultBuilder.success(new ListVO<>(this.expenseTypeService.listAll(name)));
   }

   @ApiOperation("按类别查询费用归类")
   @GetMapping("/by-category")
   public ResultVO listByCategory(@ApiParam(value = "类别(1: 其他类, 2: 工资类)", required = true) @RequestParam Integer category) {
      log.info("Api调用:按类别查询费用归类");
      return ResultBuilder.success(new ListVO<>(this.expenseTypeService.listByCategory(category)));
   }
}
