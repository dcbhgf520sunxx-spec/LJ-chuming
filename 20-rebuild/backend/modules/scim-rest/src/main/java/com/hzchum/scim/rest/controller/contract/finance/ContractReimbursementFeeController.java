package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractReimbursementFeeBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractReimbursementFeeSaveParam;
import com.hzchum.scim.contract.core.api.pojo.query.ContractReimbursementFeeQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-报销费用")
@RestController
@RequestMapping("/api/contract/reimbursement-fee")
public class ContractReimbursementFeeController {
   private static final Logger log = LoggerFactory.getLogger(ContractReimbursementFeeController.class);
   @Autowired
   private ContractReimbursementFeeBiz reimbursementFeeBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('reimburse_cost:get')")
   public ResultVO page(@Validated ContractReimbursementFeeQuery query) {
      log.info("Api调用:报销费用-分页");
      return ResultBuilder.success(this.reimbursementFeeBiz.pageInfo(query));
   }

   @ApiOperation("打印")
   @GetMapping("print")
   @PreAuthorize("@permission.check('reimburse_cost:print')")
   public ResultVO listPrint(ContractReimbursementFeeQuery query) {
      log.info("Api调用:报销费用-分页打印");
      return ResultBuilder.success(this.reimbursementFeeBiz.listPrint(query));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('reimburse_cost:add')")
   public ResultVO save(@RequestBody @Validated(Add.class) ContractReimbursementFeeSaveParam param) {
      log.info("Api调用:报销费用-新增");
      return ResultBuilder.success(this.reimbursementFeeBiz.saveInfo(param));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('reimburse_cost:edit')")
   public ResultVO update(@RequestBody @Validated(Update.class) ContractReimbursementFeeSaveParam param) {
      log.info("Api调用:报销费用-修改");
      return ResultBuilder.success(this.reimbursementFeeBiz.updateInfo(param));
   }

   @ApiOperation("删除")
   @DeleteMapping("/{id}")
   @PreAuthorize("@permission.check('reimburse_cost:del')")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用:报销费用-删除");
      return ResultBuilder.success(this.reimbursementFeeBiz.deleteById(id));
   }
}
