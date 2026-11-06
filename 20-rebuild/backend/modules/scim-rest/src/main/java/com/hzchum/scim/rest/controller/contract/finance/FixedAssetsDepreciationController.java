package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractFixedAssetsDepreciationBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationSaveDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-固定资产折旧")
@RestController
@RequestMapping("/api/contract/fixed-assets-depreciation")
public class FixedAssetsDepreciationController {
   private static final Logger log = LoggerFactory.getLogger(FixedAssetsDepreciationController.class);
   @Resource
   private ContractFixedAssetsDepreciationBiz fixedAssetsDepreciationBiz;

   @ApiOperation("固定资产折旧-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "类型 1厂房折旧 ", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", paramType = "query"),
            @ApiImplicitParam(name = "boolStatus", value = "状态 TRUE 启用 false 关闭", paramType = "query", dataType = "Boolean")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('plant_depreciation:get')")
   public ResultVO<PageVO<ContractFixedAssetsDepreciationDTO>> list(
      Integer type, String name, Boolean boolStatus, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:固定资产折旧列表");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.listByCondition(type, name, boolStatus, pageNumber, pageSize));
   }

   @ApiOperation("固定资产折旧-新增")
   @PostMapping
   @PreAuthorize("@permission.check('plant_depreciation:add')")
   public ResultVO saveList(@RequestBody @Valid List<ContractFixedAssetsDepreciationDtoParam> paramList) {
      log.info("Api调用:固定资产折旧新增");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.saveList(paramList));
   }

   @ApiOperation("固定资产折旧-修改")
   @PutMapping
   @PreAuthorize("@permission.check('plant_depreciation:edit')")
   public ResultVO updateList(@RequestBody @Validated(Update.class) List<ContractFixedAssetsDepreciationDtoParam> paramList) {
      log.info("Api调用:固定资产折旧修改");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.updateList(paramList));
   }

   @ApiOperation("固定资产折旧-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('plant_depreciation:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:固定资产折旧删除");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.deleteList(ids));
   }

   @ApiOperation("固定资产折旧-修改状态")
   @ApiImplicitParam(name = "boolStatus", value = "状态 TRUE 启用 false 关闭", paramType = "path", dataType = "Boolean", required = true)
   @DeleteMapping("/{id}/{boolStatus}")
   @PreAuthorize("@permission.check('plant_depreciation:change_status')")
   public ResultVO updateStatus(@PathVariable Long id, @PathVariable Boolean boolStatus) {
      log.info("Api调用:固定资产折旧修改状态");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.updateStatus(id, boolStatus));
   }

   @ApiOperation("固定资产折旧-厂房折旧分页")
   @GetMapping("factory-building-depreciation/page")
   @PreAuthorize("@permission.check('plant_depreciation:get')")
   public ResultVO factoryBuildingDepreciationPage(
      @ApiParam("费用归属") @RequestParam(required = false) Long branchCompanyId,
      @ApiParam("名称") @RequestParam(required = false) String name,
      @ApiParam("状态(TRUE: 启用,FALSE: 关闭)") @RequestParam(required = false) Boolean boolStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用:固定资产折旧-厂房折旧分页");
      return ResultBuilder.success(
         this.fixedAssetsDepreciationBiz.factoryBuildingDepreciationPage(branchCompanyId, name, boolStatus, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("固定资产折旧-厂房折旧打印")
   @GetMapping("factory-building-depreciation/print")
   @PreAuthorize("@permission.check('plant_depreciation:print')")
   public ResultVO factoryBuildingDepreciationPrint(
      @ApiParam("费用归属") @RequestParam(required = false) Long branchCompanyId,
      @ApiParam("名称") @RequestParam(required = false) String name,
      @ApiParam("状态(TRUE: 启用,FALSE: 关闭)") @RequestParam(required = false) Boolean boolStatus
   ) {
      log.info("Api调用:固定资产折旧-厂房折旧打印");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.factoryBuildingDepreciationPrint(branchCompanyId, name, boolStatus));
   }

   @ApiOperation("固定资产折旧-厂房折旧新增")
   @PostMapping("factory-building-depreciation")
   @PreAuthorize("@permission.check('plant_depreciation:add')")
   public ResultVO saveFactoryBuildingDepreciation(@RequestBody @Validated(Add.class) ContractFixedAssetsDepreciationSaveDtoParam param) {
      log.info("Api调用:固定资产折旧-厂房折旧新增");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.saveFactoryBuildingDepreciation(param));
   }

   @ApiOperation("固定资产折旧-厂房折旧更新")
   @PutMapping("factory-building-depreciation")
   @PreAuthorize("@permission.check('plant_depreciation:edit')")
   public ResultVO updateFactoryBuildingDepreciation(@RequestBody @Validated(Update.class) ContractFixedAssetsDepreciationSaveDtoParam param) {
      log.info("Api调用:固定资产折旧-厂房折旧更新");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.updateFactoryBuildingDepreciation(param));
   }

   @ApiOperation("固定资产折旧-厂房折旧状态修改")
   @PutMapping("factory-building-depreciation/update-status")
   @PreAuthorize("@permission.check('plant_depreciation:change_status')")
   public ResultVO updateStatusFactoryBuildingDepreciation(@RequestParam Long id, @RequestParam Boolean boolStatus) {
      log.info("Api调用:固定资产折旧-厂房折旧状态修改");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.updateStatusFactoryBuildingDepreciation(id, boolStatus));
   }

   @ApiOperation("固定资产折旧-厂房折旧删除")
   @DeleteMapping("factory-building-depreciation/{id}")
   @PreAuthorize("@permission.check('plant_depreciation:del')")
   public ResultVO deleteFactoryBuildingDepreciation(@PathVariable Long id) {
      log.info("Api调用:固定资产折旧-厂房折旧删除");
      return ResultBuilder.success(this.fixedAssetsDepreciationBiz.deleteFactoryBuildingDepreciation(id));
   }
}
