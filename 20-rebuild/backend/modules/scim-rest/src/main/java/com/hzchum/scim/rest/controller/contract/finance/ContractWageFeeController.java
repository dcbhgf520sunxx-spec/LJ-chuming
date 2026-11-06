package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWageFeeBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageFeeSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-工资费用")
@RestController
@RequestMapping("/api/contract/wage-fee")
public class ContractWageFeeController {
   private static final Logger log = LoggerFactory.getLogger(ContractWageFeeController.class);
   @Autowired
   private ContractWageFeeBiz wageFeeBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('expense_entry_wage_cost:get')")
   public ResultVO page(
      @ApiParam("年份") Integer year,
      @ApiParam("费用归属") Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用:工资费用-分页");
      return ResultBuilder.success(this.wageFeeBiz.pageInfo(year, branchCompanyId, pageNumber, pageSize, sort));
   }

   @ApiOperation("打印")
   @GetMapping("print")
   @PreAuthorize("@permission.check('expense_entry_wage_cost:print')")
   public ResultVO listPrint(@ApiParam("年份") Integer year, @ApiParam("费用归属") Long branchCompanyId) {
      log.info("Api调用:工资费用-分页打印");
      return ResultBuilder.success(this.wageFeeBiz.listPrint(year, branchCompanyId));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('expense_entry_wage_cost:add')")
   public ResultVO save(@RequestBody @Validated(Add.class) ContractWageFeeSaveParam param) {
      log.info("Api调用:工资费用-新增");
      return ResultBuilder.success(this.wageFeeBiz.saveInfo(param));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('expense_entry_wage_cost:edit')")
   public ResultVO update(@RequestBody @Validated(Update.class) ContractWageFeeSaveParam param) {
      log.info("Api调用:工资费用-修改");
      return ResultBuilder.success(this.wageFeeBiz.updateInfo(param));
   }

   @ApiOperation("删除")
   @DeleteMapping("/{id}")
   @PreAuthorize("@permission.check('expense_entry_wage_cost:del')")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用:工资费用-删除");
      return ResultBuilder.success(this.wageFeeBiz.deleteById(id));
   }
}
