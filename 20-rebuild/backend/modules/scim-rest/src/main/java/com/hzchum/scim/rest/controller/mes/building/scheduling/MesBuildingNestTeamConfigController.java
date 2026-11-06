package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestTeamConfigService;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.delete.NestTeamConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES套料班组规则")
@RestController
@RequestMapping("/api/mes/building/nestTeamConfig")
public class MesBuildingNestTeamConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingNestTeamConfigController.class);
   @Resource
   private MesBuildingNestTeamConfigService mesBuildingNestTeamConfigService;

   @RequestMapping("/page")
   @PreAuthorize("@permission.check('nesting_cutting_config:get')")
   public ResultVO pageNestTeamConfig(
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber, @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      return ResultBuilder.success(this.mesBuildingNestTeamConfigService.pageNestTeamConfig(pageNumber, pageSize));
   }

   @ApiOperation("添加套料班组代号")
   @ApiImplicitParams(@ApiImplicitParam(name = "mesBuildingNestTeamConfig", value = "套料班组规则信息", required = true))
   @PostMapping("/add")
   @PreAuthorize("@permission.check('nesting_cutting_config:add')")
   public ResultVO addNestTeamConfig(@RequestBody @Validated MesBuildingNestTeamConfig mesBuildingNestTeamConfig) {
      return ResultBuilder.success(this.mesBuildingNestTeamConfigService.addNestTeamConfig(mesBuildingNestTeamConfig));
   }

   @PostMapping("/update")
   @PreAuthorize("@permission.check('nesting_cutting_config:edit')")
   public ResultVO updateNestTeamConfig(@RequestBody MesBuildingNestTeamConfig mesBuildingNestTeamConfig) {
      log.info("修改套料班组规则信息:{}", mesBuildingNestTeamConfig);
      return ResultBuilder.success(this.mesBuildingNestTeamConfigService.updateNestTeamConfig(mesBuildingNestTeamConfig));
   }

   @ApiOperation("修改套料班组代号规则")
   @PostMapping("/updateaAll")
   @PreAuthorize("@permission.check('nesting_cutting_config:editRule')")
   public ResultVO updateNestTeamConfigALL(@RequestParam Boolean codeRule, @RequestParam Boolean displayRule, @RequestParam Boolean teamDisplayRule) {
      return ResultBuilder.success(this.mesBuildingNestTeamConfigService.updateNestTeamConfigALL(codeRule, displayRule, teamDisplayRule));
   }

   @PostMapping("/delete")
   @PreAuthorize("@permission.check('nesting_cutting_config:del')")
   public ResultVO deleteNestTeamConfig(@RequestBody NestTeamConfigParam nestTeamConfigParam) {
      return ResultBuilder.success(this.mesBuildingNestTeamConfigService.removeByIds(nestTeamConfigParam.getIds()));
   }
}
