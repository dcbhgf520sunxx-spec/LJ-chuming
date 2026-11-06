package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigAuxiliaryMaterialBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAuxiliaryMaterialParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "定额配置辅材")
@RequestMapping("/api/mes/building/quota-config/auxiliary-material")
public class MesQuotaConfigAuxiliaryMaterialController {
   private static final Logger log = LoggerFactory.getLogger(MesQuotaConfigAuxiliaryMaterialController.class);
   @Autowired
   private MesQuotaConfigAuxiliaryMaterialBiz biz;

   @ApiOperation("类型选择列表")
   @GetMapping("type-select-list")
   public ResultVO typeSelectList() {
      log.info("API调用: 定额配置辅材-分页");
      return ResultBuilder.success(this.biz.typeSelectList());
   }

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('auxiliary_material_config:get')")
   public ResultVO pageInfo(
      MesQuotaConfigConditionQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 定额配置辅材-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('auxiliary_material_config:add')")
   public ResultVO add(@RequestBody @Validated(Add.class) MesQuotaConfigAuxiliaryMaterialParam param) {
      log.info("API调用: 定额配置辅材-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("编辑")
   @PutMapping
   @PreAuthorize("@permission.check('auxiliary_material_config:edit')")
   public ResultVO edit(@RequestBody @Validated(Update.class) MesQuotaConfigAuxiliaryMaterialParam param) {
      log.info("API调用: 定额配置辅材-编辑");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('auxiliary_material_config:del')")
   public ResultVO delete(@RequestParam Long id) {
      log.info("API调用: 定额配置辅材-删除");
      return ResultBuilder.success(this.biz.delete(id));
   }
}
