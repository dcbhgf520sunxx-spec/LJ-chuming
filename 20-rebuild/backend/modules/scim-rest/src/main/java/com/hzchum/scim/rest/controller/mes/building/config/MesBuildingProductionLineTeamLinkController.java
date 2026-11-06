package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingProductionLineTeamLinkDTO;
import com.hzchum.scim.system.core.api.service.MesBuildingProductionLineTeamLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "产线关联班组")
@RestController
@RequestMapping("/api/mes/building/ProductionLine/TeamLink")
public class MesBuildingProductionLineTeamLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProductionLineTeamLinkController.class);
   @Resource
   private MesBuildingProductionLineTeamLinkService lineTeamLinkService;

   @ApiOperation("产线关联班组")
   @GetMapping("/page")
   public ResultVO inspectConfigPage(
      @Valid MesBuildingProductionLineTeamLinkDTO lineTeamLinkDTO,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询产线关联班组");
      return ResultBuilder.success(this.lineTeamLinkService.getTeamByProdLine(lineTeamLinkDTO, pageNumber, pageSize));
   }
}
