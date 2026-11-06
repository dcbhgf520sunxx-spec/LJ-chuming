package com.hzchum.scim.rest.controller.mes.building.record;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintConfigService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.AppWarehouseWeightConfigDTOParam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-配置")
@RestController
@RequestMapping("/api/mes/building/print/config")
public class PrintConfigController {
   private static final Logger log = LoggerFactory.getLogger(PrintConfigController.class);
   @Autowired
   private MesBuildingPrintConfigService printConfigService;
   @Autowired
   private ConfigService configService;

   @ApiOperation("获取打印配置")
   @GetMapping
   public ResultVO get(@RequestParam Long projectId, @RequestParam Integer printType) {
      log.info("API 调用 ：获取打印配置");
      return ResultBuilder.success(this.printConfigService.getByProjectIdOrUserId(projectId, null, printType));
   }

   @ApiOperation("更新打印配置")
   @PostMapping
   @PreAuthorize("(#p0.printType == 1 and @permission.check('mes_label_artifact:printSetting')) or "
      + "(#p0.printType == 2 and @permission.check('enclosure_label:printSetting')) or "
      + "(#p0.printType == 4 and @permission.check())")
   public ResultVO update(@Validated @RequestBody PrintConfigDTOParam param) {
      log.info("API 调用 ：更新打印配置");
      Preconditions.checkArgument(param.getProjectId() != null, "更新失败，项目不存在");
      return ResultBuilder.success(this.printConfigService.setPrintConfig(param, null));
   }

   @ApiOperation("获取打印配置(报工机)")
   @GetMapping("terminal/report")
   public ResultVO getTerminalPrint(@RequestParam Integer printType) {
      log.info("API 调用 ：获取打印配置");
      return ResultBuilder.success(this.printConfigService.getByProjectIdOrUserId(null, UserUtil.getCurrentUserId(), printType));
   }

   @ApiOperation("更新打印配置(报工机)")
   @PostMapping("terminal/report")
   public ResultVO updateTerminalPrint(@Validated @RequestBody PrintConfigDTOParam param) {
      log.info("API 调用 ：更新打印配置");
      param.setProjectId(null);
      return ResultBuilder.success(this.printConfigService.setPrintConfig(param, UserUtil.getCurrentUserId()));
   }

   @ApiOperation("获取APP仓库显示重量配置")
   @GetMapping("app/getConfig")
   @PreAuthorize("@permission.check('app_show_weight_config:get')")
   public ResultVO getAppConfig() {
      log.info("API 调用 ：获取APP仓库显示重量配置");
      return ResultBuilder.success(this.configService.getAppWarehouseWeightConfig());
   }

   @ApiOperation("更新APP仓库显示重量配置")
   @PostMapping("app/updateConfig")
   @PreAuthorize("@permission.check('app_show_weight_config:edit')")
   public ResultVO updateAppConfig(@Validated @RequestBody AppWarehouseWeightConfigDTOParam dtoParam) {
      log.info("API 调用 ：更新获取APP仓库显示重量配置");
      return ResultBuilder.success(this.configService.updateAppWarehouseWeight(dtoParam));
   }
}
