package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigMachinePartBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigMachinePartParam;
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
@Api(tags = "定额配置零件")
@RequestMapping("/api/mes/building/quota-config/machine-part")
public class MesQuotaConfigMachinePartController {
   private static final Logger log = LoggerFactory.getLogger(MesQuotaConfigMachinePartController.class);
   @Autowired
   private MesQuotaConfigMachinePartBiz biz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('machine_part_quota_config:get')")
   public ResultVO page(
      MesQuotaConfigConditionQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 定额配置零件-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("列表")
   @GetMapping("list")
   @PreAuthorize("@permission.check('machine_part_quota_config:get','mes_work_review:get')")
   public ResultVO page(MesQuotaConfigConditionQuery query) {
      log.info("API调用: 定额配置零件-列表");
      return ResultBuilder.success(this.biz.listInfo(query));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('machine_part_quota_config:add')")
   public ResultVO add(@RequestBody @Validated(Add.class) MesQuotaConfigMachinePartParam param) {
      log.info("API调用: 定额配置零件-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("批量新增")
   @PostMapping("batch-add")
   @PreAuthorize("@permission.check('machine_part_quota_config:add')")
   public ResultVO batchAdd(@RequestBody @Validated(Add.class) ValidList<MesQuotaConfigMachinePartParam> param) {
      log.info("API调用: 定额配置零件-批量新增");
      return ResultBuilder.success(this.biz.batchAdd(param));
   }

   @ApiOperation("编辑")
   @PutMapping
   @PreAuthorize("@permission.check('machine_part_quota_config:edit')")
   public ResultVO edit(@RequestBody @Validated(Update.class) MesQuotaConfigMachinePartParam param) {
      log.info("API调用: 定额配置零件-编辑");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('machine_part_quota_config:del')")
   public ResultVO delete(@RequestParam Long id) {
      log.info("API调用: 定额配置零件-删除");
      return ResultBuilder.success(this.biz.delete(id));
   }
}
