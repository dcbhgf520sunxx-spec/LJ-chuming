package com.hzchum.scim.rest.controller.mes.building.statistica;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingCoatingConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES涂装配置")
@RestController
@RequestMapping("/api/mes/building/coating")
public class MesBuildingCoatingConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCoatingConfigController.class);
   @Resource
   private MesBuildingCoatingConfigService mesBuildingCoatingConfigService;

   @ApiOperation("获取MES涂装配置列表")
   @GetMapping
   public ResultVO coatingConfigList() {
      log.info("API 调用 ：获取MES涂装配置列表");
      return ResultBuilder.success(this.mesBuildingCoatingConfigService.getCoatingConfigAll());
   }

   @ApiOperation("修改MES涂装配置")
   @PutMapping
   public ResultVO setCoatingConfig(@RequestBody @Validated MesBuildingCoatingConfigVO vo) {
      log.info("API 调用 ：修改MES涂装配置");
      MesBuildingCoatingConfigDTO copy = BeanUtil.copy(vo, MesBuildingCoatingConfigDTO.class);
      return ResultBuilder.success(this.mesBuildingCoatingConfigService.setCoatingConfig(copy));
   }

   @ApiOperation("删除MES涂装配置")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：删除MES涂装配置");
      return ResultBuilder.success(this.mesBuildingCoatingConfigService.deleteById(id));
   }
}
