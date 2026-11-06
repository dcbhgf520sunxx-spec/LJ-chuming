package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingSupplierPriceBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveVORequestParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-物流管理v2")
@RestController
@RequestMapping("/api/v2/supply-chain/logisticsManage")
public class LogisticsManageControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(LogisticsManageControllerV2.class);
   @Autowired
   private SupplierPaymentService service;
   @Autowired
   private LogisticsBiz logisticsBiz;
   @Autowired
   private MesBuildingSupplierPriceService supplierPriceService;
   @Autowired
   private MesBuildingSupplierPriceBiz supplierPriceBiz;

   @ApiOperation("物流管理-新增物流费用设置")
   @PostMapping("/saveLogisticsExpense")
   public ResultVO saveLogisticsExpense(@RequestBody @Valid SupplierPriceSaveVORequestParam body) {
      log.info("API 调用 ： 物流管理-新增物流费用设置");
      return ResultBuilder.success(this.supplierPriceBiz.saveV2(body));
   }

   @ApiOperation("物流管理-修改物流费用设置")
   @PutMapping("/putLogisticsExpense")
   public ResultVO putLogisticsExpense(@RequestBody @Valid SupplierPriceUpdateDTOParam body) {
      log.info("API 调用 ： 物流管理-修改物流费用设置");
      return ResultBuilder.success(this.supplierPriceBiz.updateV2(body));
   }

   @ApiOperation("物流管理-物流台账列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年度", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "statusEnum", value = "状态", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "1 原材料物流 2制成品物流", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "branchCompanyId", value = "公司id", dataType = "Long", paramType = "query")
      }
   )
   @GetMapping("/listLogisticsLedger")
   public ResultVO listLogisticsLedger(
      Integer year,
      Integer statusEnum,
      @RequestParam Integer propertyType,
      Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ： 物流台账列表");
      return ResultBuilder.success(this.logisticsBiz.getMaterialFlowLedger(year, statusEnum, propertyType, branchCompanyId, pageNumber, pageSize));
   }
}
