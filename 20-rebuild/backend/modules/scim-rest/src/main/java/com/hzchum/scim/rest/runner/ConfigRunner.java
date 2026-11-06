package com.hzchum.scim.rest.runner;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.AESUtils;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.RawMaterialLossEnum;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.MachinePartSchedulingTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.BimModelRestrictedTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.config.PriceEditModeEnum;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo._do.SteelPlateConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AmountVO;
import com.hzchum.scim.system.core.api.pojo.dto.AppCommonConfigWeight;
import com.hzchum.scim.system.core.api.pojo.dto.AppWarehouseWeightConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.DriverConfigureVO;
import com.hzchum.scim.system.core.api.pojo.dto.FeatureDefinitionConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.LogoConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.OldUserCheckVO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectModeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SafetyFactorVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserCheckVO;
import com.hzchum.scim.system.core.api.pojo.dto.WeighSMSConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractPriceEditMode;
import com.hzchum.scim.system.core.api.pojo.dto.config.VehicleConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class ConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ConfigRunner.class);
   private final ConfigService configService;
   private final ConfigProperties configProperties;
   private final WeighingScaleEquipmentInfoService scaleEquipmentInfoService;

   @Override
   public void run(String... strings) {
      log.info("初始化配置信息开始............................................");
      // Rebuild: historical SMS recipient migration is not replayed at normal startup.
      WeighSMSConfigDTO weighSMSConfigDTO = this.configService.getOverweightSMSRecipientInfo();
      if (weighSMSConfigDTO == null) {
         weighSMSConfigDTO = new WeighSMSConfigDTO();
         weighSMSConfigDTO.setMaxWeight(0.0);
         List<UserCheckVO> userCheckVOList = new ArrayList<>();
         UserCheckVO userCheckVO = new UserCheckVO();
         userCheckVO.setName("超级管理员");
         userCheckVO.setPhone(this.configProperties.getPhone());
         userCheckVO.setWorkshops(new ArrayList<>());
         userCheckVOList.add(userCheckVO);
         weighSMSConfigDTO.setUserChecks(userCheckVOList);
         Config config = new Config();
         config.setCode("NEW_OVERWEIGHT_SMS_RECIPIENT");
         config.setName("过磅短信接收人");
         config.setValue(JSON.toJSONString(weighSMSConfigDTO));
         this.configService.save(config);
      }

      CompanyConfigVO companyConfigVO = this.configService.getCompanyConfig();
      if (companyConfigVO == null) {
         companyConfigVO = new CompanyConfigVO();
         companyConfigVO.setCompanyName(this.configProperties.getCompanyName());
         companyConfigVO.setCompanyNo(this.configProperties.getCompanyNo());
         companyConfigVO.setUUID(UUIDUtil.getUUID());
         Config config = new Config();
         config.setCode("COMPANY_NAME");
         config.setName("公司名称");
         config.setValue(JSON.toJSONString(companyConfigVO));
         this.configService.save(config);
      } else if (companyConfigVO.getUUID() == null) {
         companyConfigVO.setUUID(UUIDUtil.getUUID());
         this.configService.updateConfig("COMPANY_NAME", JSON.toJSONString(companyConfigVO));
      }

      AmountVO amountVO = this.configService.getAmountDecimal();
      if (amountVO == null) {
         amountVO = new AmountVO();
         amountVO.setYuanDecimal(this.configProperties.getYuanDecimal());
         Config config = Config.builder().build();
         config.setCode("AMOUNT_DECIMAL");
         config.setName("金额精确度");
         config.setValue(JSON.toJSONString(amountVO));
         this.configService.save(config);
      }

      ProjectConfigVO projectConfigVO = this.configService.getProjectConfig();
      if (projectConfigVO == null) {
         projectConfigVO = new ProjectConfigVO();
         projectConfigVO.setArrangement(this.configProperties.getProjectNameShowMode());
         projectConfigVO.setShowSerialNumber(this.configProperties.getShowContractNo());
         projectConfigVO.setShowProjectFullName(this.configProperties.getShowProjectFullName());
         Config config = new Config();
         config.setCode("PROJECT");
         config.setName("项目配置信息");
         config.setValue(JSON.toJSONString(projectConfigVO));
         this.configService.save(config);
      }

      List<LogoConfigVO> logoList = this.configService.getLogoConfig();
      if (logoList == null) {
         List<LogoConfigVO> var35 = new ArrayList();
         Config config = new Config();
         config.setCode("LOGO");
         config.setName("公司LOGO配置信息");
         config.setValue(JSON.toJSONString(var35));
         this.configService.save(config);
      }

      SafetyFactorVO safetyFactorVO = this.configService.getSafetyFactorConfig();
      if (safetyFactorVO == null) {
         safetyFactorVO = new SafetyFactorVO();
         safetyFactorVO.setSafetyFactor(BigDecimal.ZERO);
         Config config = new Config();
         config.setCode("SAFETY_FACTOR");
         config.setName("加工承揽安全余额系数");
         config.setValue(JSON.toJSONString(safetyFactorVO));
         this.configService.save(config);
      }

      DriverConfigureVO driverConfigureVO = this.configService.getDriverConfigure();
      if (driverConfigureVO == null) {
         driverConfigureVO = new DriverConfigureVO();
         driverConfigureVO.setConfigure(false);
         Config config = new Config();
         config.setCode("DRIVER_CONFIGURE");
         config.setName("装车时司机信息填写配置");
         config.setValue(JSON.toJSONString(driverConfigureVO));
         this.configService.save(config);
      }

      AppWarehouseWeightConfigVO appWarehouseWeightConfig = this.configService.getAppWarehouseWeightConfig();
      if (appWarehouseWeightConfig == null) {
         AppWarehouseWeightConfigVO appWarehouseWeight = new AppWarehouseWeightConfigVO();
         appWarehouseWeight.setPack(1);
         appWarehouseWeight.setCarLoading(1);
         appWarehouseWeight.setWeighingGoods(1);
         appWarehouseWeight.setCheckOutWarehouse(1);
         appWarehouseWeight.setLogisticsManagement(1);
         appWarehouseWeight.setReceiveGoods(1);
         Config config = new Config();
         config.setCode("APP_WAREHOUSE_WEIGHT");
         config.setName("APP仓库显示重量配置");
         config.setValue(JSON.toJSONString(appWarehouseWeight));
         this.configService.save(config);
      }

      ProjectModeDTO projectMode = this.configService.getCurrentProjectMode();
      if (projectMode == null) {
         projectMode = ProjectModeDTO.builder().projectMode(ProjectModeEnum.ARTIFACT_MODE.getType()).build();
         Config config = Config.builder().code("PROJECT_MODE").name("项目模式").value(JSON.toJSONString(projectMode)).build();
         this.configService.save(config);
      }

      if (this.configService.getSteelPlateConfig() == null) {
         this.configService
            .save(
               Config.builder()
                  .code("STEEL_PLATE_CONFIG")
                  .name("是否绑定钢板")
                  .value(JSON.toJSONString(SteelPlateConfigDTO.builder().steelPlateType(true).build()))
                  .build()
            );
      }

      // Rebuild: BIM licensing/cryptographic external configuration is not reseeded locally.

      if (this.configService.getSowNeed() == null) {
         this.configService
            .save(Config.builder().code("SHOW_NEED").name("零件排产展示需求级别").value(JSON.toJSONString(MachinePartSchedulingTypeEnum.NOT.getType())).build());
      }

      if (this.configService.getWeightConfig() == null) {
         this.configService
            .save(
               Config.builder()
                  .code("APP_WEIGHT_CONFIG")
                  .name("是否显示重量")
                  .value(JSON.toJSONString(AppCommonConfigWeight.builder().boolShowWeightInManufacture(true).boolShowWeightInRecord(true).build()))
                  .build()
            );
      }

      if (this.configService.getFeatureDefinitionConfig() == null) {
         this.configService
            .save(
               Config.builder()
                  .code("FEATURE_DEFINITION_CONFIG")
                  .name("构件、部件特征定义配置")
                  .value(JSON.toJSONString(FeatureDefinitionConfigDTO.builder().auditType(false).build()))
                  .build()
            );
      }

      // Rebuild: initialization must preserve user-edited vehicle preferences.
      int count = this.scaleEquipmentInfoService.count();
      Config config = this.configService.getOne(Wrappers.lambdaQuery(Config.class).eq(Config::getCode, "VEHICLE"));
      VehicleConfigDTO build = VehicleConfigDTO.builder()
         .showPlateAGButton(false)
         .showEmptyTruckAGButton(false)
         .showEmptyTruckMEButton(false)
         .showFullTruckAGButton(false)
         .requestLimitingTime(0L)
         .showFullTruckMEButton(false)
         .boolGetWeightByPlate(false)
         .boolGetWeightByDevice(false)
         .build();
      if (this.configProperties.getIot().contains("cargoWeight")) {
         build.setShowEmptyTruckAGButton(true);
         build.setShowEmptyTruckMEButton(true);
         build.setShowFullTruckAGButton(true);
         build.setShowFullTruckMEButton(true);
         build.setRequestLimitingTime(this.configProperties.getWeightTimeOut());
      }

      if (this.configProperties.getIot().contains("plate")) {
         build.setShowPlateAGButton(true);
      }

      if (this.configProperties.getIot().contains("device")) {
         build.setBoolGetWeightByDevice(true);
      }

      if (count > 0) {
         build.setBoolGetWeightByDevice(true);
      }

      if (config == null) {
         this.configService.save(Config.builder().code("VEHICLE").name("过磅按钮配置").value(JSON.toJSONString(build)).build());
      }

      Config priceEditModeConfig = this.configService.getByCode("PRICE_EDIT_MODE");
      String name = "价格管理编辑模式:1立即审核 2暂时保存";
      ContractPriceEditMode priceEditMode = ContractPriceEditMode.builder().priceEditMode(PriceEditModeEnum.INSTANT_AUDIT.getType()).build();
      if (priceEditModeConfig == null) {
         priceEditModeConfig = Config.builder().code("PRICE_EDIT_MODE").name(name).value(JSON.toJSONString(priceEditMode)).build();
         this.configService.save(priceEditModeConfig);
      } else if (StringUtils.isBlank(priceEditModeConfig.getValue())) {
         priceEditModeConfig.setName(name);
         priceEditModeConfig.setValue(JSON.toJSONString(priceEditMode));
         this.configService.updateById(priceEditModeConfig);
      } else {
         ContractPriceEditMode mode = JSON.parseObject(priceEditModeConfig.getValue(), ContractPriceEditMode.class);
         if (!PriceEditModeEnum.boolExist(mode.getPriceEditMode())) {
            priceEditModeConfig.setName(name);
            priceEditModeConfig.setValue(JSON.toJSONString(priceEditMode));
            this.configService.updateById(priceEditModeConfig);
         }
      }

      if (this.configService.getByCode("COATING_CONFIG_MEASUREMENT_MANNER") == null) {
         this.configService.save(Config.builder().code("COATING_CONFIG_MEASUREMENT_MANNER").name("工价配置-涂装配置计量方式").value(null).build());
      }

      if (this.configService.getByCode("RAW_MATERIAL_LOSS_CALCULATION_FORMULA") == null) {
         this.configService
            .save(
               Config.builder()
                  .code("RAW_MATERIAL_LOSS_CALCULATION_FORMULA")
                  .name("原料损耗计算公式")
                  .value(String.valueOf(RawMaterialLossEnum.FORMULA_ONE.getType()))
                  .build()
            );
      }

      Config numericalControlConfig = this.configService.getByCode("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
      if (numericalControlConfig == null) {
         numericalControlConfig = new Config();
         numericalControlConfig.setCode("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
         numericalControlConfig.setName("");
         numericalControlConfig.setValue(SysMatchRangeEnum.MONOMER.getType().toString());
         this.configService.save(numericalControlConfig);
      }

      if (this.configService.getByCode("PRINT_CONFIGURATION") == null) {
         this.configService
            .save(
               Config.builder()
                  .code("PRINT_CONFIGURATION")
                  .name("打印配置")
                  .value(JSON.toJSONString(PrintConfigurationDTO.builder().boolPrintWarehousing(false).build()))
                  .build()
            );
      }

      log.info("初始化配置信息结束............................................");
   }

   public ConfigRunner(
      final ConfigService configService, final ConfigProperties configProperties, final WeighingScaleEquipmentInfoService scaleEquipmentInfoService
   ) {
      this.configService = configService;
      this.configProperties = configProperties;
      this.scaleEquipmentInfoService = scaleEquipmentInfoService;
   }
}
