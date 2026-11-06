package com.hzchum.scim.rest.controller.mes.building.statistica;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Delete;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.statistica.MesBuildingFabricatedPartConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingFabricatedPartConfigService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingFabricatedPartConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES配套件单价配置")
@RestController
@RequestMapping("/api/mes/building/fabricated")
public class MesBuildingFabricatedPartsController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingFabricatedPartsController.class);
   @Resource
   private MesBuildingFabricatedPartConfigService mesBuildingFabricatedPartConfigService;

   @ApiOperation("获取配套件单价配置列表")
   @GetMapping
   public ResultVO fabricatedParList() {
      log.info("API 调用 ：获取配套件单价配置列表");
      return ResultBuilder.success(new ListVO<>(this.mesBuildingFabricatedPartConfigService.fabricatedParList()));
   }

   @ApiOperation("修改MES配套件单价配置")
   @PutMapping
   public ResultVO setFabricatedParts(@Validated(Update.class) @RequestBody MesBuildingFabricatedPartConfigVO vo) {
      log.info("API 调用 ：修改MES配套件单价配置");
      return ResultBuilder.success(
         this.mesBuildingFabricatedPartConfigService.setFabricatedParts(BeanUtil.copy(vo, MesBuildingFabricatedPartConfigDTOParam.class))
      );
   }

   @ApiOperation("删除MES配套件单价配置")
   @DeleteMapping
   public ResultVO removeFabricatedParts(@Validated(Delete.class) @RequestBody MesBuildingFabricatedPartConfigVO vo) {
      log.info("API 调用 ：删除MES配套件单价配置");
      return ResultBuilder.success(
         this.mesBuildingFabricatedPartConfigService.removeFabricatedParts(BeanUtil.copy(vo, MesBuildingFabricatedPartConfigDTOParam.class))
      );
   }
}
