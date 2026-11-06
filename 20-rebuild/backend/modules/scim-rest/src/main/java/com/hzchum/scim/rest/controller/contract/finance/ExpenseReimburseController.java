package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractExpenseReimburseBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractExpenseReimburseDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "合同管理-费用报销")
@RestController
@RequestMapping("/api/contract/expense-reimburse")
public class ExpenseReimburseController {
   private static final Logger log = LoggerFactory.getLogger(ExpenseReimburseController.class);
   @Resource
   private ContractExpenseReimburseBiz expenseReimburseBiz;

   @ApiOperation("费用报销-列表")
   @GetMapping
   @PreAuthorize("@permission.check('expense_reporting:get')")
   public ResultVO<PageVO<ContractExpenseReimburseDTO>> list(
      Integer year,
      Integer month,
      Long expenseTypeId,
      Long expenseSubjectId,
      String reimbursementPerson,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:费用报销列表");
      return ResultBuilder.success(
         this.expenseReimburseBiz.listByCondition(year, month, expenseTypeId, expenseSubjectId, reimbursementPerson, pageNumber, pageSize)
      );
   }

   @ApiOperation("费用报销-新增")
   @PostMapping
   @PreAuthorize("@permission.check('expense_reporting:add')")
   public ResultVO saveList(@RequestBody @Valid List<ContractExpenseReimburseDtoParam> paramList) {
      log.info("Api调用: 费用报销新增");
      return ResultBuilder.success(this.expenseReimburseBiz.saveList(paramList));
   }

   @ApiOperation("费用报销-修改")
   @PutMapping
   @PreAuthorize("@permission.check('expense_reporting:edit')")
   public ResultVO update(@RequestBody @Valid ContractExpenseReimburseDtoParam param) {
      log.info("Api调用: 费用报销修改");
      return ResultBuilder.success(this.expenseReimburseBiz.update(param));
   }

   @ApiOperation("费用报销-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('expense_reporting:del')")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用: 费用报销删除");
      return ResultBuilder.success(this.expenseReimburseBiz.deleteList(ids));
   }

   @ApiOperation("费用报销-打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('expense_reporting:print')")
   public ResultVO printList(Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName) {
      log.info("Api调用:费用报销列表打印");
      return ResultBuilder.success(this.expenseReimburseBiz.printList(year, month, expenseTypeId, expenseSubjectId, reimburseUserName));
   }
}
