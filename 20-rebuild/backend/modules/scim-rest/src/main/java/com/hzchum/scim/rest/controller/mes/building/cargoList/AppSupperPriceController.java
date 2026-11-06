package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingSupplierPriceBiz;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.cargoList.save.SupplierPriceSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.cargoList.update.SupplierPriceUpdateVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES发运-物流管理")
@RestController
@RequestMapping("/api/app/mes/building/supper/price")
public class AppSupperPriceController {
   private static final Logger log = LoggerFactory.getLogger(AppSupperPriceController.class);
   @Autowired
   private MesBuildingSupplierPriceService supplierPriceService;
   @Autowired
   private MesBuildingSupplierPriceBiz supplierPriceBiz;

   @ApiOperation("分页获取物流单位列表")
   @GetMapping("")
   public ResultVO getSupplierPricePage(
      Long projectId,
      String name,
      Integer status,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取物流单位列表");
      return ResultBuilder.success(this.supplierPriceService.page(projectId, name, status, pageNumber, pageSize));
   }

   @ApiOperation("新增物流单位")
   @PostMapping
   @PreAuthorize("@permission.check('logisticsManager')")
   @SignerCheck(lockKey = "#request.projectId", message = "该项目正在新增物流单位中，请稍后刷新重试")
   public ResultVO saveSupplierPrice(@RequestBody @Valid SupplierPriceSaveVORequest request) {
      log.info("API 调用 ：新增物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.save(request));
   }

   @ApiOperation("修改物流单位")
   @PutMapping("")
   @PreAuthorize("@permission.check('logisticsManager')")
   @SignerCheck(constantKey = "supplier", lockKey = "#request.projectId", message = "该项目正在修改物流单位中,请稍后重试!")
   public ResultVO addCargoList(@RequestBody @Valid SupplierPriceUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.update(request));
   }

   @ApiOperation("删除物流单位")
   @DeleteMapping("{id}")
   @PreAuthorize("@permission.check('logisticsManager')")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API 调用 ：删除物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.deleteById(id));
   }
}
