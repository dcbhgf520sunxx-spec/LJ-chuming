package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.LogisticsPaymentInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsSupplierSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentUpdateDTOParam;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-物流付款台账")
@RestController
@RequestMapping("/api/supply-chain/logistics-payment")
public class LogisticsPaymentController {
   private static final Logger log = LoggerFactory.getLogger(LogisticsPaymentController.class);
   @Resource
   private LogisticsBiz logisticsBiz;

   @ApiOperation("付款台账(物流公司)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "订单创建年份 例2022", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "物流公司名称", paramType = "query")
      }
   )
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('supplier_logistics_payment:get','contract_supplier_logistics:get')")
   public ResultVO<PageVO<LogisticsSupplierSummaryDTO>> listSummaryBySupplier(
      Integer year, String supplierName, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 根据物流公司汇总(付款开票信息)");
      return ResultBuilder.success(this.logisticsBiz.listSummaryOnSupplier(year, supplierName, pageNumber, pageSize));
   }

   @ApiOperation("打印付款台账(物流公司)")
   @GetMapping("/detail/print")
   @PreAuthorize("@permission.check('supplier_logistics_payment:print','contract_supplier_logistics:print')")
   public ResultVO printSummaryBySupplier(Integer year, String supplierName) {
      log.info("Api调用: 打印物流公司汇总(付款开票信息)");
      return ResultBuilder.success(this.logisticsBiz.printSummaryOnSupplier(year, supplierName));
   }

   @ApiOperation("根据物流公司id,和合同主体id,查询付款信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierId", value = "物流公司id", paramType = "query", required = true),
            @ApiImplicitParam(name = "branchCompanyId", value = "合同主体id", paramType = "query", required = true)
      }
   )
   @GetMapping("/list-info")
   public ResultVO<ListVO<LogisticsPaymentInfoDTO>> listInfo(@RequestParam(required = false) Long supplierId, @RequestParam Long branchCompanyId) {
      log.info("Api调用: 根据物流公司id,和合同主体id,查询付款填报信息 ");
      return ResultBuilder.success(this.logisticsBiz.listBySupplierIdAndBranchCompanyId(supplierId, branchCompanyId));
   }

   @ApiOperation("新增物流付款")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('supplier_logistics_payment:add')")
   public ResultVO saveLogisticsPayment(@RequestBody @Valid LogisticsSupplierPaymentSaveDTOParam param) {
      log.info("Api调用: 新增物流付款");
      return ResultBuilder.success(this.logisticsBiz.saveLogisticsPayment(param));
   }

   @ApiOperation("修改物流付款")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('supplier_logistics_payment:edit','supplier_logistics_payment_application:edit')")
   public ResultVO updateLogisticsPayment(@RequestBody @Valid LogisticsSupplierPaymentUpdateDTOParam param) {
      log.info("Api调用: 修改物流付款");
      return ResultBuilder.success(this.logisticsBiz.updateLogisticsPayment(param));
   }
}
