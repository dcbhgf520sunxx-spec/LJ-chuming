package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.SubcontractOrderPaymentBiz;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubcontractOrderPayInvoiceDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.SubOrderPaymentQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderSettlementDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-分包订单-付款和结算")
@RestController
@RequestMapping("/api/project/sub-payment")
public class SubcontractOrderPaymentController {
   private static final Logger log = LoggerFactory.getLogger(SubcontractOrderPaymentController.class);
   @Resource
   private SubcontractOrderPaymentBiz subcontractOrderPaymentBiz;

   @ApiOperation("分包订单列表")
   @GetMapping("/list-subOrder")
   @PreAuthorize("@permission.check('subcontract_order_payment:get','contract_supplier_subcontract:get')")
   public ResultVO<PageVO<SubcontractOrderPayInvoiceDTO>> listSubOrder(
      SubOrderPaymentQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分包订单列表");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.listSubOrderPayment(param, pageNumber, pageSize));
   }

   @ApiOperation("新增-分包订单付款")
   @PostMapping
   @PreAuthorize("@permission.check('subcontract_order_payment_manage:add')")
   public ResultVO saveOrderPayment(@RequestBody @Valid SubOrderPaymentDTOParam param) {
      log.info("Api调用: 新增-分包订单付款 ");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.saveSubOrderPayment(param));
   }

   @ApiOperation("修改-分包订单付款")
   @PutMapping
   @PreAuthorize("@permission.check('subcontract_order_payment_manage:edit')")
   public ResultVO updateOrderPayment(@RequestBody @Valid SubOrderPaymentDTOParam param) {
      log.info("Api调用: 修改-分包订单付款 ");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.updateSubOrderPayment(param));
   }

   @ApiOperation("新增-分包订单结算")
   @PostMapping("/settle")
   @PreAuthorize("@permission.check('subcontract_order_payment:settle')")
   public ResultVO saveOrderSettle(@RequestBody @Valid SubOrderSettlementDTOParam param) {
      log.info("Api调用: 新增-分包订单结算");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.saveSubOrderSettle(param));
   }

   @ApiOperation("修改-分包订单结算")
   @PutMapping("/settle")
   @PreAuthorize("@permission.check('subcontract_order_payment:settle')")
   public ResultVO updateOrderSettle(@RequestBody @Valid SubOrderSettlementDTOParam param) {
      log.info("Api调用: 新增-分包订单结算");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.updateSubOrderSettle(param));
   }

   @ApiOperation("审核-分包订单付款")
   @PutMapping("/check-payment")
   public ResultVO updateOrderPayment(@RequestBody @Valid SubOrderPaymentCheckDTOParam param) {
      log.info("Api调用: 审核-分包订单付款");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.checkSubOrderPayment(param));
   }

   @ApiOperation("审核-分包订单结算")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "结算表ID", paramType = "query", required = true),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态 2通过 4驳回", paramType = "query", required = true)
      }
   )
   @PutMapping("/check-settle")
   public ResultVO updateOrderSettle(@RequestParam Long id, @RequestParam Integer auditStatus) {
      log.info("Api调用: 审核-分包订单结算");
      return ResultBuilder.success(this.subcontractOrderPaymentBiz.checkSubOrderSettle(id, auditStatus));
   }
}
