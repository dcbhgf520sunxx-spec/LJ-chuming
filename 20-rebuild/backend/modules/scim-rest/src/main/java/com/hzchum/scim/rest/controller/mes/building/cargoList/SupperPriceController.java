package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
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

@Api(tags = "MES发运-物流管理")
@RestController
@RequestMapping("/api/mes/building/supper/price")
public class SupperPriceController {
   private static final Logger log = LoggerFactory.getLogger(SupperPriceController.class);
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
   @SignerCheck(lockKey = "#request.projectId", message = "该项目正在新增物流单位中，请稍后刷新重试")
   public ResultVO saveSupplierPrice(@RequestBody @Valid SupplierPriceSaveVORequest request) {
      log.info("API 调用 ：新增物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.save(request));
   }

   @ApiOperation("修改物流单位")
   @PutMapping("")
   @SignerCheck(constantKey = "supplier", lockKey = "#request.projectId", message = "该项目正在新增物流单位中,请稍后重试!")
   public ResultVO addCargoList(@RequestBody @Valid SupplierPriceUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.update(request));
   }

   @ApiOperation("删除物流单位")
   @DeleteMapping("{id}")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API 调用 ：删除物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.deleteById(id));
   }

   @ApiOperation("查看物流单位车型配置")
   @GetMapping("{id}/car")
   public ResultVO getCarLinkList(@PathVariable Long id) {
      log.info("API 调用 ：删除物流单位");
      return ResultBuilder.success(new ListVO<>(this.supplierPriceBiz.getCarLinkList(id)));
   }

   @ApiOperation("项目物流单位列表(公共接口-无权限)")
   @GetMapping("/listAllSupplier/{projectId}")
   public ResultVO<ListVO<NameInfo>> listProjectShipSupplier(@PathVariable Long projectId) {
      log.info("Api调用:查询项目配置的全部成品发运物流单位");
      return ResultBuilder.success(new ListVO<>(this.supplierPriceBiz.listProjectSupplier(projectId)));
   }
}
