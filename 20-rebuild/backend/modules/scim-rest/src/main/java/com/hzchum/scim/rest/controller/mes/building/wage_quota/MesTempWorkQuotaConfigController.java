package com.hzchum.scim.rest.controller.mes.building.wage_quota;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota.MesTempWorkQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesTempWorkQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesTempWorkQuotaConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "点工定额配置")
@RestController
@RequestMapping("/api/mes/building/wage-quota/temp-work-quota-config")
public class MesTempWorkQuotaConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesTempWorkQuotaConfigController.class);
   @Autowired
   private MesTempWorkQuotaConfigBiz tempWorkQuotaConfigBiz;

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO listInfo() {
      log.info("API 调用 ：点工定额配置列表");
      return ResultBuilder.success(new ListVO<>(this.tempWorkQuotaConfigBiz.listInfo()));
   }

   @ApiOperation("选择列表")
   @GetMapping("select-list")
   public ResultVO selectList() {
      log.info("API 调用 ：点工定额配置选择列表");
      List<MesTempWorkQuotaConfigDTO> selectList = this.tempWorkQuotaConfigBiz
         .listInfo()
         .stream()
         .filter(MesTempWorkQuotaConfig::getStatus)
         .collect(Collectors.toList());
      return ResultBuilder.success(new ListVO<>(selectList));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO add(@RequestBody @Validated(Add.class) MesTempWorkQuotaConfigParam param) {
      log.info("API 调用 ：新增点工定额配置");
      return ResultBuilder.success(this.tempWorkQuotaConfigBiz.add(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesTempWorkQuotaConfigParam param) {
      log.info("API 调用 ：修改点工定额配置");
      return ResultBuilder.success(this.tempWorkQuotaConfigBiz.edit(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("status")
   public ResultVO editStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：修改点工定额配置状态");
      return ResultBuilder.success(this.tempWorkQuotaConfigBiz.editStatus(id, status));
   }

   @ApiOperation("删除")
   @DeleteMapping
   public ResultVO delete(@RequestParam Long id) {
      log.info("API 调用 ：删除点工定额配置");
      return ResultBuilder.success(this.tempWorkQuotaConfigBiz.deleteById(id));
   }
}
