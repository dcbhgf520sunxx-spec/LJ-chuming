package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractEquipmentDepreciationBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEquipmentDepreciationSaveDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-设备折旧")
@RestController
@RequestMapping("/api/contract/equipment-depreciation")
public class ContractEquipmentDepreciationController {
   private static final Logger log = LoggerFactory.getLogger(ContractEquipmentDepreciationController.class);
   @Autowired
   private ContractEquipmentDepreciationBiz equipmentDepreciationBiz;

   @ApiOperation("固定资产折旧-设备折旧分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('device_depreciation:get')")
   public ResultVO page(
      @ApiParam("费用归属") @RequestParam(required = false) Long branchCompanyId,
      @ApiParam("分类名称") @RequestParam(required = false) String classificationName,
      @ApiParam("设备名称") @RequestParam(required = false) String equipmentName,
      @ApiParam("状态(TRUE: 启用,FALSE: 关闭)") @RequestParam(required = false) Boolean boolStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用:固定资产折旧-设备折旧分页");
      return ResultBuilder.success(
         this.equipmentDepreciationBiz.pageInfo(branchCompanyId, classificationName, equipmentName, boolStatus, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("固定资产折旧-设备折旧打印")
   @GetMapping("page/print")
   @PreAuthorize("@permission.check('device_depreciation:print')")
   public ResultVO pagePrint(
      @ApiParam("费用归属") @RequestParam(required = false) Long branchCompanyId,
      @ApiParam("分类名称") @RequestParam(required = false) String classificationName,
      @ApiParam("设备名称") @RequestParam(required = false) String equipmentName,
      @ApiParam("状态(TRUE: 启用,FALSE: 关闭)") @RequestParam(required = false) Boolean boolStatus
   ) {
      log.info("Api调用:固定资产折旧-设备折旧打印");
      return ResultBuilder.success(this.equipmentDepreciationBiz.pagePrint(branchCompanyId, classificationName, equipmentName, boolStatus));
   }

   @ApiOperation("固定资产折旧-设备折旧新增")
   @PostMapping
   @PreAuthorize("@permission.check('device_depreciation:add')")
   public ResultVO save(@RequestBody @Validated(Add.class) ContractEquipmentDepreciationSaveDTOParam param) {
      log.info("Api调用:固定资产折旧-设备折旧新增");
      return ResultBuilder.success(this.equipmentDepreciationBiz.saveInfo(param));
   }

   @ApiOperation("固定资产折旧-设备折旧更新")
   @PutMapping
   @PreAuthorize("@permission.check('device_depreciation:edit')")
   public ResultVO update(@RequestBody @Validated(Update.class) ContractEquipmentDepreciationSaveDTOParam param) {
      log.info("Api调用:固定资产折旧-设备折旧更新");
      return ResultBuilder.success(this.equipmentDepreciationBiz.updateInfo(param));
   }

   @ApiOperation("固定资产折旧-设备折旧修改状态")
   @PutMapping("update-status")
   @PreAuthorize("@permission.check('device_depreciation:change_status')")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean boolStatus) {
      log.info("Api调用:固定资产折旧-设备折旧修改状态");
      return ResultBuilder.success(this.equipmentDepreciationBiz.updateStatus(id, boolStatus));
   }

   @ApiOperation("固定资产折旧-设备折旧删除")
   @DeleteMapping("/{id}")
   @PreAuthorize("@permission.check('device_depreciation:del')")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用:固定资产折旧-设备折旧删除");
      return ResultBuilder.success(this.equipmentDepreciationBiz.deleteById(id));
   }
}
