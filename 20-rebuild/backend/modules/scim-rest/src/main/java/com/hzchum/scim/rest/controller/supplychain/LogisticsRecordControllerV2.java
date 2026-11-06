package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-物流记录")
@RestController
@RequestMapping("/api/v2/supply-chain/logistics")
public class LogisticsRecordControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(LogisticsRecordControllerV2.class);
   @Autowired
   private LogisticsOrderService logisticsOrderService;
   @Autowired
   private LogisticsBiz logisticsBiz;

   @ApiOperation("原材料装车费记录查询")
   @GetMapping("/record/loadingCharge")
   @PreAuthorize("@permission.check('supplier_logistics_Log:detail','contract_supplier_logistics_log:get','scm_loading_fee_record:get')")
   public ResultVO recordLoadingCharge(
      @RequestParam(required = false) LocalDateTime passStartDate,
      @RequestParam(required = false) LocalDateTime passEndDate,
      @RequestParam(required = false) String licensePlate,
      @RequestParam(required = false) String inboundSN,
      @RequestParam(required = false) String purchaseOrderSN,
      @RequestParam(required = false) String userName,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：原材料装车费记录查询");
      return ResultBuilder.success(
         this.logisticsOrderService.recordLoadingCharge(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName, pageNumber, pageSize)
      );
   }

   @ApiOperation("装车费汇总")
   @GetMapping("/loadingChargeCount")
   @PreAuthorize("@permission.check('supplier_logistics_Log:detail','contract_supplier_logistics_log:get','scm_loading_fee_record:get')")
   public ResultVO loadingChargeCount(
      @RequestParam(required = false) LocalDateTime passStartDate,
      @RequestParam(required = false) LocalDateTime passEndDate,
      @RequestParam(required = false) String licensePlate,
      @RequestParam(required = false) String inboundSN,
      @RequestParam(required = false) String purchaseOrderSN,
      @RequestParam(required = false) String userName
   ) {
      log.info("API 调用 ：装车费汇总");
      return ResultBuilder.success(
         this.logisticsOrderService.loadingChargeCount(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName)
      );
   }

   @ApiOperation("装车费下载")
   @GetMapping("/loadingCharge/export")
   @PreAuthorize("@permission.check('supplier_reconciliation_Log:download','scm_loading_fee_record:download')")
   public void supplierReconciliationExport(
      @RequestParam(required = false) LocalDateTime passStartDate,
      @RequestParam(required = false) LocalDateTime passEndDate,
      @RequestParam(required = false) String licensePlate,
      @RequestParam(required = false) String inboundSN,
      @RequestParam(required = false) String purchaseOrderSN,
      @RequestParam(required = false) String userName,
      HttpServletResponse response
   ) {
      log.info("Api调用: 装车费下载");
      this.logisticsBiz.loadingChargeExport(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName, response);
   }
}
