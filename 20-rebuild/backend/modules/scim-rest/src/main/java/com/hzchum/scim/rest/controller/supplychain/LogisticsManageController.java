package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.enums.logistics.LogisticsTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsPaymentDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SporadicLogisticsSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-物流管理v2")
@RestController
@RequestMapping("/api/supply-chain/logisticsManage")
public class LogisticsManageController {
   private static final Logger log = LoggerFactory.getLogger(LogisticsManageController.class);
   @Autowired
   private SupplierPaymentService service;
   @Autowired
   private LogisticsBiz logisticsBiz;

   @ApiOperation("物流管理-首页(作废)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商(物流单位)", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审批状态", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = " 页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = " 页大小", paramType = "query")
      }
   )
   @GetMapping("/showAll")
   public ResultVO<Map<String, Object>> showAll(
      Integer settlementStatus,
      String supplierName,
      Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：物流管理-首页");
      return ResultBuilder.success(this.service.showAll(settlementStatus, supplierName, auditStatus, pageNumber, pageSize));
   }

   @ApiOperation("物流台账")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "executeStatus", value = "执行状态", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "  1原材料物流 2制成品物流", paramType = "query", required = true),
            @ApiImplicitParam(name = "level", value = "单位属性（1,工地，2工厂）PlaceEnum", paramType = "query"),
            @ApiImplicitParam(name = "date", value = "时间", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = " 页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = " 页大小", paramType = "query")
      }
   )
   @GetMapping("/showLogisticsLedger")
   public ResultVO<PageVO<LogisticsStandingBookDTO>> showLogisticsLedger(
      @RequestParam @EnumValidator(value = LogisticsTypeEnum.class, message = "物流类型不存在") Integer type,
      @RequestParam(required = false) Integer executeStatus,
      @RequestParam(required = false) Integer level,
      @RequestParam(required = false) LocalDate date,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：物流管理-首页");
      return ResultBuilder.success(this.logisticsBiz.showLogisticsLedger(executeStatus, type, level, date, pageNumber, pageSize));
   }

   @ApiOperation("根据物流单位id获取物流记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id(物流单位)", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = " 页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = " 页大小", paramType = "query")
      }
   )
   @GetMapping("/detail")
   public ResultVO<Map<String, Object>> detail(
      String projectName,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：根据物流单位id获取物流记录");
      return ResultBuilder.success(this.service.detail(projectName, supplierId, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("根据物流单位id获取付款详情")
   @ApiImplicitParams(@ApiImplicitParam(name = "supplierId", value = "供应商id(物流单位)", paramType = "query"))
   @GetMapping("/paymentDetails")
   public ResultVO<LogisticsPaymentDetailDTO> paymentDetails(Long supplierId) {
      log.info("API 调用 ：根据物流单位id获取付款详情");
      return ResultBuilder.success(this.service.paymentDetails(supplierId));
   }

   @ApiOperation("新增物流付款")
   @PostMapping("/savePayment")
   public ResultVO saveLogisticsPayment(@RequestBody @Valid SupplierPaymentSaveDTOParam param) {
      log.info("Api调用: 新增物流付款");
      return ResultBuilder.success(this.service.saveLogisticsPayment(param));
   }

   @ApiOperation("获取发票入账申请明细")
   @ApiImplicitParams(@ApiImplicitParam(name = "supplierId", value = "供应商id(物流单位)", paramType = "query"))
   @GetMapping("/invoicePayment")
   public ResultVO invoicePayment(Long supplierId) {
      log.info("Api调用: 获取发票入账申请明细");
      return ResultBuilder.success(this.service.invoicePayment(supplierId));
   }

   @ApiOperation("新增物流开票")
   @PostMapping("/saveInvoicePayment")
   public ResultVO saveInvoicePayment(@RequestBody @Valid LogisticsInvoiceSaveDTOParam param) {
      log.info("Api调用: 新增物流付款");
      return ResultBuilder.success(this.service.saveLogisticsInvoice(param));
   }

   @ApiOperation("添加零星物流")
   @PostMapping("/saveSporadicLogistics")
   public ResultVO saveSporadicLogistics(@RequestBody @Valid SporadicLogisticsSaveDTOParam param) {
      log.info("Api调用: 添加零星物流");
      return ResultBuilder.success(this.service.saveSporadicLogistics(param));
   }
}
