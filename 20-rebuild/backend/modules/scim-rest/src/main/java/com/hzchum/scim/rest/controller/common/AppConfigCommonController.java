package com.hzchum.scim.rest.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.vo.CargoPackVO;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo.dto.AppCommonConfigWeight;
import com.hzchum.scim.system.core.api.pojo.dto.AppWarehouseWeightConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.CarModelVO;
import com.hzchum.scim.system.core.api.pojo.dto.DriverConfigureVO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.config.VehicleConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-公共配置")
@RestController
@RequestMapping("/api/app/config/base")
public class AppConfigCommonController {
   private static final Logger log = LoggerFactory.getLogger(AppConfigCommonController.class);
   @Autowired
   private ConfigService configService;
   @Autowired
   private ConfigProperties configProperties;
   @Resource
   private BasicConfigService basicConfigService;
   @Value("${mes-enum}")
   private String mesEnum;

   @ApiOperation("系统配置")
   @GetMapping
   public ResultVO get() {
      log.info("API 调用 ：系统配置");
      Map<String, Object> map = new HashMap<>();
      DriverConfigureVO driver = this.configService.getDriverConfigure();
      CarModelVO carModel = this.configService.getCarModel();
      PrintConfigVO print = this.configService.getPrint();
      AppCommonConfigWeight weightConfig = this.configService.getWeightConfig();
      AppWarehouseWeightConfigVO weightConfigVO = this.configService.getAppWarehouseWeightConfig();
      map.put("driver", driver);
      map.put("carModel", carModel.getCarModels());
      map.put("print", print);
      map.put("weight", weightConfig);
      map.put("appWarehouseWeight", weightConfigVO);
      Config vehicle = this.configService.getOne(Wrappers.lambdaQuery(Config.class).eq(Config::getCode, "VEHICLE"));
      if (this.configProperties.getIot().contains("cargoWeight")) {
         VehicleConfigDTO vehicleConfigDTO = new VehicleConfigDTO();
         if (vehicle != null) {
            vehicleConfigDTO = JSONObject.parseObject(vehicle.getValue(), VehicleConfigDTO.class);
         }

         map.put("vehicle", vehicleConfigDTO);
      }

      CargoPackVO cargoPackVO = new CargoPackVO();
      cargoPackVO.setBoolCrossMonomerCargo(Boolean.TRUE);
      cargoPackVO.setBoolCrossMonomerPack(Boolean.TRUE);
      map.put("cargoPackInfo", cargoPackVO);
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      map.put("inventoryGainType", inventoryTypeConfig);
      map.put("boolMultiFactory", false);
      List<Integer> buildingAndBridgeModels = new ArrayList<>();
      if (this.mesEnum.contains("building")) {
         buildingAndBridgeModels.add(WorkShopTypeEnum.BUILDING.getType());
      }

      if (this.mesEnum.contains("bridge")) {
      }

      map.put("buildingAndBridgeModels", buildingAndBridgeModels);
      return ResultBuilder.success(map);
   }
}
