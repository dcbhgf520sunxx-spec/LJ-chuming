package com.hzchum.scim.rest.controller.system;

import com.alibaba.fastjson.JSON;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.enums.NestingTaskModeEnum;
import com.hzchum.scim.common.core.api.enums.RawMaterialLossEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.system.core.api.annotation.Log;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.enums.BusinessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ModuleEnum;
import com.hzchum.scim.system.core.api.pojo._do.SteelPlateConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AmountVO;
import com.hzchum.scim.system.core.api.pojo.dto.AppCommonConfigWeight;
import com.hzchum.scim.system.core.api.pojo.dto.CarModelVO;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.DriverConfigureVO;
import com.hzchum.scim.system.core.api.pojo.dto.ExpireUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.FeatureDefinitionConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.FlangingPiecePriceVO;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.NumericalControlDrawingMatchRangeConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.PartDrawingLayerSettingDTO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectModeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SafetyFactorVO;
import com.hzchum.scim.system.core.api.pojo.dto.SystemChargingMethodUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TechnicalTypeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.WeighSMSConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.CappWeldingCraftConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractPriceEditMode;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractTechConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountShowConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinishedProductWareConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesWageConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysPasswordPolicyDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.SystemWatermarkConfigDTO;
import com.hzchum.scim.system.core.api.pojo.vo.InventoryConfigurationVO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "系统管理-配置管理")
@RestController
@RequestMapping("/api/config")
public class ConfigApi {
   private static final Logger log = LoggerFactory.getLogger(ConfigApi.class);
   private final ConfigService configService;

   @ApiOperation("获取金额配置")
   @GetMapping("/amount")
   @Log(module = ModuleEnum.CONFIG, name = BusinessTypeEnum.AMOUNT_CONFIG)
   public Result getAmountDecimal() {
      log.info("API 调用 ：获取金额配置");
      return ResultGenerator.genSuccessResult(this.configService.getAmountDecimal());
   }

   @ApiOperation("编辑金额配置")
   @PutMapping("/amount")
   public Result updateAmountDecimal(@Validated @RequestBody AmountVO requestVO) {
      log.info("API 调用 ：编辑金额配置");
      return ResultGenerator.genSuccessResult(this.configService.updateConfig("AMOUNT_DECIMAL", JSON.toJSONString(requestVO)));
   }

   @ApiOperation("获取项目配置(公共接口-无权限)")
   @GetMapping("/project/public")
   public Result getProjectConfigPublic() {
      log.info("API 调用 ：获取项目配置");
      return ResultGenerator.genSuccessResult(this.configService.getProjectConfig());
   }

   @ApiOperation("获取项目配置")
   @GetMapping("/project")
   @PreAuthorize("@permission.check('config_project:get')")
   public Result getProjectConfig() {
      log.info("API 调用 ：获取项目配置");
      return ResultGenerator.genSuccessResult(this.configService.getProjectConfig());
   }

   @ApiOperation("编辑项目配置")
   @PutMapping("/project")
   @PreAuthorize("@permission.check('config_project:edit')")
   public Result updateProjectConfig(@Validated @RequestBody ProjectConfigVO requestVO) {
      log.info("API 调用 ：编辑项目配置");
      return ResultGenerator.genSuccessResult(this.configService.updateConfig("PROJECT", JSON.toJSONString(requestVO)));
   }

   @ApiOperation("获取过磅短信接收人")
   @GetMapping("/mes/overweightSMSRecipient")
   @PreAuthorize("@permission.check('overweight_sms_recipient:get')")
   public Result getOverweightSMSRecipientInfo() {
      log.info("API 调用 ：获取过磅短信接收人");
      return ResultGenerator.genSuccessResult(this.configService.getOverweightSMSRecipientInfo());
   }

   @ApiOperation("更新过磅短信接收人")
   @PutMapping("/mes/overweightSMSRecipient")
   @PreAuthorize("@permission.check('overweight_sms_recipient:edit')")
   public Result updateOverweightSMSRecipientInfo(@Valid @RequestBody WeighSMSConfigDTO dto) {
      log.info("API 调用 ：更新过磅短信接收人");
      return ResultGenerator.genSuccessResult(this.configService.updateOverweightSMSRecipientInfo(dto));
   }

   @ApiOperation("获取司机信息填写配置")
   @GetMapping("/driver")
   public Result getDriverConfigure() {
      log.info("API 调用 ：获取过磅短信接收人");
      return ResultGenerator.genSuccessResult(this.configService.getDriverConfigure());
   }

   @ApiOperation("更新司机信息填写配置")
   @PutMapping("/driver")
   public Result updateDriverConfigure(@RequestBody DriverConfigureVO driverConfigureVO) {
      log.info("API 调用 ：更新司机信息填写配置");
      return ResultGenerator.genSuccessResult(this.configService.updateDriverConfigure(driverConfigureVO.getConfigure()));
   }

   @ApiOperation("获取车型配置")
   @GetMapping("/car/model")
   @PreAuthorize("@permission.check('car_model_config:get','mes_logistics:get','scm_logisticsOrder:get')")
   public Result getCarModel() {
      log.info("API 调用 ：获取过磅短信接收人");
      return ResultGenerator.genSuccessResult(this.configService.getCarModel());
   }

   @ApiOperation("更新车型配置")
   @PutMapping("/car/model")
   @PreAuthorize("@permission.check('car_model_config:edit')")
   public Result updateCarModel(@RequestBody @Validated CarModelVO vo) {
      log.info("API 调用 ：更新车型配置");
      return ResultGenerator.genSuccessResult(this.configService.updateCarModel(vo));
   }

   @ApiOperation("获取打印配置")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('app_print_config:get')")
   public Result getPrint() {
      log.info("API 调用 ：获取打印配置");
      return ResultGenerator.genSuccessResult(this.configService.getPrint());
   }

   @ApiOperation("更新打印配置")
   @PutMapping("/print")
   @PreAuthorize("@permission.check('app_print_config:edit')")
   public Result updateCarModel(@RequestBody @Validated PrintConfigVO vo) {
      log.info("API 调用 ：更新打印配置");
      return ResultGenerator.genSuccessResult(this.configService.updatePrint(vo));
   }

   @ApiOperation("获取公司名称")
   @GetMapping("/company")
   @PreAuthorize("@permission.check('config_company:get')")
   public Result getCompanyConfig() {
      log.info("API 调用 ：获取公司名称");
      return ResultGenerator.genSuccessResult(this.configService.getCompanyConfig());
   }

   @ApiOperation("获取公司名称")
   @GetMapping("/company/name")
   public Result getCompanyName() {
      log.info("API 调用 ：获取公司名称");
      return ResultGenerator.genSuccessResult(this.configService.getCompanyConfig());
   }

   @ApiOperation("获取公司名称(公共接口-无权限)")
   @GetMapping("/company/all")
   public Result getCompanyConfigAll() {
      log.info("API 调用 ：获取公司名称");
      return ResultGenerator.genSuccessResult(this.configService.getCompanyConfig());
   }

   @ApiOperation("更新公司名称")
   @PutMapping("/company")
   @PreAuthorize("@permission.check('config_company:edit')")
   @Log(module = ModuleEnum.CONFIG, name = BusinessTypeEnum.BASE_CONFIG)
   public Result updateCompany(@RequestBody CompanyConfigVO requestVO) {
      log.info("API 调用 ：更新公司名称");
      return ResultGenerator.genSuccessResult(this.configService.updateConfig("COMPANY_NAME", JSON.toJSONString(requestVO)));
   }

   @ApiOperation("LOGO获取")
   @GetMapping("/company/logo")
   @PreAuthorize("@permission.check('config_logo:get')")
   public Result getLogo() {
      log.info("API 调用 ：LOGO获取");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.configService.getLogoConfig()));
   }

   @ApiOperation("LOGO获取(无权限)")
   @GetMapping("/company/logo/all")
   public Result getLogoAll() {
      log.info("API 调用 ：LOGO获取(无权限)");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.configService.getLogoConfig()));
   }

   @ApiOperation("LOGO上传")
   @PostMapping("/company/logo")
   @PreAuthorize("@permission.check('config_logo:edit')")
   @Log(module = ModuleEnum.CONFIG, name = BusinessTypeEnum.BASE_CONFIG)
   public ResultVO uploadLogo(@RequestPart MultipartFile file) {
      log.info("API 调用 ：LOGO上传");
      return ResultBuilder.success(this.configService.uploadLogo(file));
   }

   @ApiOperation("LOGO修改默认")
   @PutMapping("/company/logo/default/{id}")
   @PreAuthorize("@permission.check('config_logo:edit')")
   @Log(module = ModuleEnum.CONFIG, name = BusinessTypeEnum.BASE_CONFIG)
   public Result setLogoDefault(@PathVariable Long id) {
      log.info("API 调用 ：LOGO修改默认");
      return ResultGenerator.genSuccessResult(this.configService.setLogoDefault(id));
   }

   @ApiOperation("LOGO删除")
   @DeleteMapping("/company/logo/{id}")
   @PreAuthorize("@permission.check('config_logo:edit')")
   @Log(module = ModuleEnum.CONFIG, name = BusinessTypeEnum.BASE_CONFIG)
   public Result deleteLogo(@PathVariable Long id) {
      log.info("API 调用 ：LOGO删除");
      return ResultGenerator.genSuccessResult(this.configService.deleteLogo(id));
   }

   @ApiOperation("获取安全系数")
   @GetMapping("/safety/factor")
   @PreAuthorize("@permission.check('safe_amount_factor:get')")
   public Result getSafetyFactorConfig() {
      log.info("API 调用 ：获取安全系数");
      return ResultGenerator.genSuccessResult(this.configService.getSafetyFactorConfig());
   }

   @ApiOperation("更新安全系数")
   @PutMapping("/safety/factor")
   @PreAuthorize("@permission.check('safe_amount_factor:edit')")
   public Result updateSafetyFactorConfig(@Validated @RequestBody SafetyFactorVO requestVO) {
      log.info("API 调用 ：更新安全系数");
      return ResultGenerator.genSuccessResult(this.configService.updateConfig("SAFETY_FACTOR", JSON.toJSONString(requestVO)));
   }

   @ApiOperation("设置项目模式")
   @PutMapping("/setProjectMode")
   @PreAuthorize("@permission.check('project_mode:edit')")
   public ResultVO setProjectMode(@Valid @RequestBody ProjectModeDTO projectModeDTO) {
      log.info("API 调用 ：设置项目模式");
      return ResultBuilder.success(this.configService.setProjectMode(projectModeDTO));
   }

   @ApiOperation("获取当前项目模式")
   @GetMapping("/getProjectMode")
   @PreAuthorize("@permission.check('project_mode:get')")
   public ResultVO getProjectMode() {
      log.info("API 调用 ：获取当前项目模式");
      return ResultBuilder.success(this.configService.getCurrentProjectMode());
   }

   @ApiOperation("获取可选项目模式列表")
   @GetMapping("/listProjectMode")
   @PreAuthorize("@permission.check('project_mode:get')")
   public ResultVO listProjectMode() {
      log.info("API 调用 ：获取可选项目模式列表");
      return ResultBuilder.success(this.configService.listModes());
   }

   @ApiOperation("获取围护-折边件工资计价方式")
   @GetMapping("/flanging_piece_price")
   @PreAuthorize("@permission.check('folding_price_method:get')")
   public ResultVO getFlangingPiecePrice() {
      log.info("API 调用 ：获取围护-折边件工资计价方式");
      return ResultBuilder.success(this.configService.getFlangingPiecePrice());
   }

   @ApiOperation("修改围护-折边件工资计价方式")
   @PutMapping("/flanging_piece_price")
   @PreAuthorize("@permission.check('folding_price_method:edit')")
   public ResultVO putFlangingPiecePrice(@RequestBody FlangingPiecePriceVO vo) {
      log.info("API 调用 ：修改围护-折边件工资计价方式");
      return ResultBuilder.success(this.configService.putFlangingPiecePrice(vo));
   }

   @ApiOperation("设置是否关联技术交底")
   @PutMapping("/setTechnicalType")
   public ResultVO setTechnicalType(@RequestBody @Valid TechnicalTypeDTO technicalTypeDTO) {
      log.info("API 调用 ：设置是否关联技术交底");
      return ResultBuilder.success(this.configService.setTechnical(technicalTypeDTO));
   }

   @ApiOperation("获取当前技术交底类型")
   @GetMapping("/getTechnicalType")
   public ResultVO getTechnicalType() {
      log.info("API 调用 ：获取当前技术交底类型");
      return ResultBuilder.success(this.configService.getTechnicalType());
   }

   @ApiOperation("绑定钢板配置")
   @PutMapping("/setSteelPlate")
   @PreAuthorize("@permission.check('steel_bind_config:edit')")
   public ResultVO setSteelPlateConfig(@RequestBody @Valid SteelPlateConfigDTO steelPlateConfigDTO) {
      log.info("API 调用 ：绑定钢板配置");
      return ResultBuilder.success(this.configService.setSteelPlateConfig(steelPlateConfigDTO));
   }

   @ApiOperation("零件需求展示级别")
   @PutMapping("/show/need/{type}")
   @PreAuthorize("@permission.check('machine_part_scheduling:edit')")
   public ResultVO setSowNeed(@PathVariable(name = "type") Integer type) {
      log.info("API 调用 ：零件需求展示级别");
      return ResultBuilder.success(this.configService.setSowNeed(type));
   }

   @ApiOperation("零件需求展示级别")
   @GetMapping("/show/need")
   @PreAuthorize("@permission.check('machine_part_scheduling:get','mes_scheduling_machine_part:get','mes_scheduling_section_machine_part:get')")
   public ResultVO getSowNeed() {
      log.info("API 调用 ：零件需求展示级别");
      return ResultBuilder.success(this.configService.getSowNeed());
   }

   @ApiOperation("获取当前绑定钢板配置")
   @GetMapping("/getSteelPlate")
   @PreAuthorize("@permission.check('steel_bind_config:get')")
   public ResultVO getSteelPlateConfig() {
      log.info("API 调用 ：获取当前绑定钢板配置");
      return ResultBuilder.success(this.configService.getSteelPlateConfig());
   }

   @ApiOperation("APP任务上报重量字段配置")
   @PutMapping("/setWeight")
   @PreAuthorize("@permission.check('app_task_report:edit')")
   public ResultVO setWeightConfig(@RequestBody @Valid AppCommonConfigWeight commonConfigWeight) {
      log.info("API 调用 ：APP任务上报重量字段配置");
      return ResultBuilder.success(this.configService.setWeightConfig(commonConfigWeight));
   }

   @ApiOperation("获取APP任务上报重量字段配置")
   @GetMapping("/getWeight")
   @PreAuthorize("@permission.check('app_task_report:get')")
   public ResultVO getWeightConfig() {
      log.info("API 调用 ：获取APP任务上报重量字段配置");
      return ResultBuilder.success(this.configService.getWeightConfig());
   }

   @ApiOperation("获取构件、部件特征定义配置")
   @GetMapping("/getFeatureDefinitionConfig")
   @PreAuthorize("@permission.check('machine_part_structure:get')")
   public Result<?> getFeatureDefinitionConfig() {
      log.info("API 调用 ：获取构件、部件特征定义配置");
      return ResultGenerator.genSuccessResult(this.configService.getFeatureDefinitionConfig());
   }

   @ApiOperation("更新构件、部件特征定义配置")
   @PutMapping("/setFeatureDefinitionConfig")
   @PreAuthorize("@permission.check('machine_part_structure:edit')")
   public Result<?> setFeatureDefinitionConfig(@RequestBody @Valid FeatureDefinitionConfigDTO dto) {
      log.info("API 调用 ：更新构件、部件特征定义配置");
      return ResultGenerator.genSuccessResult(this.configService.setFeatureDefinitionConfig(dto));
   }

   @ApiOperation("新增或更新系统到期时间")
   @PutMapping("saveOrUpdateExpireDate")
   public Result<?> saveOrUpdateExpireDate(@RequestBody @Valid ExpireUpdateDTO dto) {
      log.info("API 调用 ：新增或更新系统到期时间");
      return ResultGenerator.genSuccessResult(this.configService.saveOrUpdateExpireDate(dto));
   }

   @ApiOperation("查询系统到期时间")
   @GetMapping("getServerExpireDate")
   public Result<?> getServerExpireDate() {
      log.info("API 调用 ：查询系统到期时间");
      return ResultGenerator.genSuccessResult(this.configService.getServerExpireDate());
   }

   @ApiOperation("模型-查看上传数量限制配置")
   @GetMapping("getBimModelConfigConvertRestrict")
   public ResultVO<Object> getBimModelConfigConvertRestrict() {
      log.info("API 调用 查看bim模型文件转换成功限制配置数据");
      return ResultBuilder.success(this.configService.getBimModelConfig());
   }

   @ApiOperation("模型-开启上传数量限制")
   @ApiImplicitParam(name = "enabled", value = "状态，是否启用 true是 false否", paramType = "query")
   @PutMapping("bimModelConfigStatus")
   public Result<?> bimModelConfigStatus(@RequestParam Boolean enabled) {
      log.info("API 调用 ：开启/关闭");
      return ResultGenerator.genSuccessResult(this.configService.bimModelConfigStatus(enabled));
   }

   @ApiOperation("模型-设置上传数量限制类型")
   @ApiImplicitParam(name = "modelUploadLimitType", value = "限制方式。1 总数 2 文件大小。BimModelRestrictedTypeEnum", paramType = "query")
   @PutMapping("bimModelConfigRestrictedType")
   public Result<?> bimModelConfigRestrictedType(@RequestParam Integer modelUploadLimitType) {
      log.info("API 调用 ：文件上传方式");
      return ResultGenerator.genSuccessResult(this.configService.bimModelConfigRestrictedType(modelUploadLimitType));
   }

   @ApiOperation("模型-更新最大上传数量")
   @ApiImplicitParam(name = "maxModelUploadNumOrFileSize", value = "修改bim模型文件上传限制的最大值,根据限制方式决定", paramType = "query")
   @PutMapping("bimModelConfigMaxNumOrFileSize")
   public Result<?> bimModelConfigMaxNumOrFileSize(@RequestParam Double maxModelUploadNumOrFileSize) {
      log.info("API 调用 ：修改bim模型文件上传限制的最大值");
      return ResultGenerator.genSuccessResult(this.configService.bimModelConfigMaxNumOrFileSize(maxModelUploadNumOrFileSize));
   }

   @ApiOperation("获取-价格管理-价格修改模式")
   @GetMapping("/getPriceEditMode")
   @PreAuthorize("@permission.check('contract_price_config:get')")
   public ResultVO<ContractPriceEditMode> getPriceEditMode() {
      log.info("API调用 ：获取价格管理-价格修改模式");
      return ResultBuilder.success(this.configService.getPriceEditMode());
   }

   @ApiOperation("获取-价格管理-价格修改模式(公共接口-无权限)")
   @GetMapping("/getPriceEditMode/public")
   public ResultVO<ContractPriceEditMode> commonGetPriceEditMode() {
      log.info("API调用 ：获取价格管理-价格修改模式(公共接口-无权限)");
      return ResultBuilder.success(this.configService.getPriceEditMode());
   }

   @ApiOperation("修改-价格管理-价格修改模式")
   @PostMapping("/editPriceEditMode")
   @PreAuthorize("@permission.check('contract_price_config:edit')")
   public ResultVO editPriceEditMode(@RequestBody @Valid ContractPriceEditMode priceEditMode) {
      log.info("API调用:修改-价格管理-价格修改模式");
      return ResultBuilder.success(this.configService.editPriceEditMode(priceEditMode));
   }

   @ApiOperation("获取-废料价格录入类型")
   @GetMapping("/getWastePriceEntryType")
   @PreAuthorize("@permission.check('config_wms_scrapPrice:get')")
   public ResultVO<Integer> getWastePriceEntryType() {
      log.info("API调用 ：获取-废料价格录入类型");
      return ResultBuilder.success(this.configService.getWastePriceEntryType());
   }

   @ApiOperation("获取-废料价格录入类型(公共接口-无权限)")
   @GetMapping("/getWastePriceEntryType/public")
   public ResultVO<Integer> commonWastePriceEntryType() {
      log.info("API调用 ：获取废料价格录入类型(公共接口-无权限)");
      return ResultBuilder.success(this.configService.getWastePriceEntryType());
   }

   @ApiOperation("修改-废料价格录入类型")
   @PutMapping("/setWastePriceEntryType")
   @PreAuthorize("@permission.check('config_wms_scrapPrice:edit')")
   public ResultVO setWastePriceEntryType(@RequestParam Integer type) {
      log.info("API调用:修改-废料价格录入类型");
      return ResultBuilder.success(this.configService.setWastePriceEntryType(type));
   }

   @ApiOperation("新增或更新系统收费方式")
   @PutMapping("saveOrUpdateSystemChargingMethod")
   public Result<?> saveOrUpdateSystemChargingMethod(@RequestBody @Valid SystemChargingMethodUpdateDTO dto) {
      log.info("API 调用 ：新增或更新系统收费方式");
      return ResultGenerator.genSuccessResult(this.configService.saveOrUpdateSystemChargingMethod(dto));
   }

   @ApiOperation("查询系统收费方式")
   @GetMapping("getSystemChargingMethod")
   public Result<?> getSystemChargingMethod() {
      log.info("API 调用 ：查询系统收费方式");
      return ResultGenerator.genSuccessResult(this.configService.getSystemChargingMethod());
   }

   @ApiOperation("发送进度款提醒短信")
   @PostMapping("sendProgressPaymentSms")
   public Result<?> sendProgressPaymentSms() {
      log.info("API 调用 ：发送进度款提醒短信");
      return ResultGenerator.genSuccessResult(this.configService.sendProgressPaymentSms());
   }

   @ApiOperation("获取-MES成品仓库配置")
   @GetMapping("/getMesWarehouseConfig")
   @PreAuthorize("@permission.check('mes_warehouse_manage:get')")
   public ResultVO<FinishedProductWareConfigDTO> getFinishedProductWareConfig() {
      log.info("API调用:获取-MES成品仓库配置");
      return ResultBuilder.success(this.configService.getFinishedProductWareConfig());
   }

   @ApiOperation("获取-MES成品仓库配置(公共接口)")
   @GetMapping("/getMesWarehouseConfig/public")
   public ResultVO<FinishedProductWareConfigDTO> getFinishedProductWareConfigPublic() {
      log.info("API调用:获取-MES成品仓库配置");
      return ResultBuilder.success(this.configService.getFinishedProductWareConfig());
   }

   @ApiOperation("修改-MES成品仓库配置")
   @PostMapping("/setMesWarehouseConfig")
   @PreAuthorize("@permission.check('mes_warehouse_manage:edit')")
   public ResultVO setBoolEnableWarehouse(@RequestBody FinishedProductWareConfigDTO param) {
      log.info("API调用:修改-MES成品仓库配置");
      return ResultBuilder.success(this.configService.setFinishedProductWareConfig(param));
   }

   @ApiOperation("获取-工价配置-涂装配置计量方式(公共接口-无权限)")
   @GetMapping("/getCoatingConfigMeasurementManner/public")
   public ResultVO<Integer> getCoatingConfigMeasurementManner() {
      log.info("API调用 ：获取工价配置-涂装配置计量方式(公共接口-无权限)");
      return ResultBuilder.success(this.configService.getCoatingConfigMeasurementManner());
   }

   @ApiOperation("修改-工价配置-涂装配置计量方式")
   @PutMapping("/setCoatingConfigMeasurementManner")
   @PreAuthorize("@permission.check('coating_create_type_config:edit')")
   public ResultVO setCoatingConfigMeasurementManner(@RequestParam @EnumValidator(value = WageQuotaTypeEnum.class, message = "计量方式不存在") Integer type) {
      log.info("API调用:修修改-工价配置-涂装配置计量方式");
      return ResultBuilder.success(this.configService.setCoatingConfigMeasurementManner(type));
   }

   @ApiOperation("获取清单误差配置")
   @GetMapping("/inventoryConfiguration")
   public Result<InventoryConfigurationDTO> getListInventoryConfiguration() {
      log.info("API 调用 ：获取清单误差配置");
      return ResultGenerator.genSuccessResult(this.configService.getListInventoryConfiguration());
   }

   @ApiOperation("修改清单误差配置")
   @PutMapping("/inventoryConfiguration")
   public Result saveInventoryConfiguration(@RequestBody @Valid InventoryConfigurationVO configurationVO) {
      log.info("API 调用 ：修改清单误差配置");
      return ResultGenerator.genSuccessResult(this.configService.saveInventoryConfiguration(configurationVO));
   }

   @ApiOperation("产品标签LOGO获取")
   @GetMapping("/company/productLabel/logo")
   @PreAuthorize("@permission.check('config_logo:get')")
   public Result getProductLabelLogoAll() {
      log.info("API 调用 ：产品标签LOGO获取");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.configService.getProductLabelLogoAll()));
   }

   @ApiOperation("产品标签LOGO上传")
   @PostMapping("/company/productLabel/logo")
   @PreAuthorize("@permission.check('config_logo:edit')")
   public ResultVO uploadProductLabelLogo(@RequestPart MultipartFile file) {
      log.info("API 调用 ：产品标签LOGO上传");
      return ResultBuilder.success(this.configService.uploadProductLabelLogo(file));
   }

   @ApiOperation("产品标签LOGO删除")
   @DeleteMapping("/company/productLabel/logo/{id}")
   @PreAuthorize("@permission.check('config_logo:edit')")
   public Result deleteProductLabelLogo(@PathVariable Long id) {
      log.info("API 调用 ：产品标签LOGO删除");
      return ResultGenerator.genSuccessResult(this.configService.deleteProductLabelLogo(id));
   }

   @ApiOperation("获取-业财金额额度配置")
   @GetMapping("/financeAmountLimit")
   @PreAuthorize("@permission.check('amount_apply_config:get')")
   public ResultVO<FinanceAmountLimitConfigDTO> getFinanceAmountLimitConfig() {
      log.info("API调用:获取-业财金额限制配置");
      return ResultBuilder.success(this.configService.getFinanceAmountLimitConfig());
   }

   @ApiOperation("修改-业财金额额度配置")
   @PostMapping("/financeAmountLimit")
   @PreAuthorize("@permission.check('amount_apply_config:edit')")
   public ResultVO<Boolean> setFinanceAmountLimitConfig(@RequestBody @Valid FinanceAmountLimitConfigDTO param) {
      log.info("API调用:修改-业财金额限制配置");
      return ResultBuilder.success(this.configService.setFinanceAmountLimitConfig(param));
   }

   @ApiOperation("获取-业财未结算(项目/订单)的(未收款/未付款)金额显示配置")
   @GetMapping("/finance/unsettled-order/uncollected-unpaid/amount/show")
   @PreAuthorize("@permission.check('amount_related_config:getUncollectedUnpaidAmountCalculationMethod')")
   public ResultVO<FinanceAmountShowConfigDTO> getFinanceAmountShowConfig() {
      log.info("API调用:获取-业财金额限制配置");
      return ResultBuilder.success(this.configService.getFinanceAmountShowConfig());
   }

   @ApiOperation("修改-业财未结算(项目/订单)的(未收款/未付款)金额显示配置")
   @PostMapping("/finance/unsettled-order/uncollected-unpaid/amount/show")
   @PreAuthorize("@permission.check('amount_related_config:editUncollectedUnpaidAmountCalculationMethod')")
   public ResultVO<Boolean> setFinanceAmountShowConfig(@RequestBody @Valid FinanceAmountShowConfigDTO param) {
      log.info("API调用:修改-业财金额限制配置");
      return ResultBuilder.success(this.configService.editFinanceAmountShowConfig(param));
   }

   @ApiOperation("获取-系统水印配置(公共方法)")
   @GetMapping("/watermarkConfig/get/public")
   public ResultVO<SystemWatermarkConfigDTO> getWatermarkConfigPublic() {
      log.info("Api调用:获取-系统水印配置(公共方法)");
      return ResultBuilder.success(this.configService.getWatermarkConfig());
   }

   @ApiOperation("获取-系统水印配置")
   @GetMapping("/watermarkConfig/get")
   @PreAuthorize("@permission.check('config_watermark:get')")
   public ResultVO<SystemWatermarkConfigDTO> getWatermarkConfig() {
      log.info("Api调用:获取-系统水印配置");
      return ResultBuilder.success(this.configService.getWatermarkConfig());
   }

   @ApiOperation("编辑-系统水印配置")
   @PostMapping("/watermarkConfig/edit")
   @PreAuthorize("@permission.check('config_watermark:edit')")
   public ResultVO<Boolean> setWatermarkConfig(@RequestBody @Valid SystemWatermarkConfigDTO param) {
      log.info("Api调用:编辑-系统水印配置");
      return ResultBuilder.success(this.configService.setWatermarkConfig(param));
   }

   @ApiOperation("获取-项目技术交底配置(公共方法)")
   @GetMapping("/contractTechConfig/get/public")
   public ResultVO<ContractTechConfigDTO> getContractTechConfigPublic() {
      log.info("Api调用:获取-项目技术交底配置(公共方法)");
      return ResultBuilder.success(this.configService.getContractTechConfig());
   }

   @ApiOperation("获取-项目技术交底配置")
   @GetMapping("/contractTechConfig/get")
   @PreAuthorize("@permission.check('technical_disclosure_config:get')")
   public ResultVO<ContractTechConfigDTO> getContractTechConfig() {
      log.info("Api调用:获取-项目技术交底配置");
      return ResultBuilder.success(this.configService.getContractTechConfig());
   }

   @ApiOperation("编辑-项目技术交底配置")
   @PostMapping("/contractTechConfig/edit")
   @PreAuthorize("@permission.check('technical_disclosure_config:get')")
   public ResultVO<Boolean> setContractTechConfig(@RequestBody @Valid ContractTechConfigDTO param) {
      log.info("Api调用:编辑-项目技术交底配置");
      return ResultBuilder.success(this.configService.setContractTechConfig(param));
   }

   @ApiOperation("工价统计截止日期-获取")
   @GetMapping("wage-statistics-deadline/get")
   public ResultVO wageStatisticsDeadlineGet() {
      log.info("API调用: 工价统计截止日期-获取");
      return ResultBuilder.success(this.configService.wageStatisticsDeadlineGet());
   }

   @ApiOperation("工价统计截止日期-修改")
   @PostMapping("wage-statistics-deadline/edit")
   public ResultVO wageStatisticsDeadlineEdit(@Min(1L) @Max(31L) @RequestParam Integer deadline) {
      log.info("API调用: 工价统计截止日期-修改");
      return ResultBuilder.success(this.configService.wageStatisticsDeadlineEdit(deadline));
   }

   @ApiOperation("工价配置-获取")
   @GetMapping("/wage-config/get")
   @PreAuthorize("@permission.check('wage_statistics_deadline_config:get','artifact_quota_config:get','assemble_quota_config:get','machine_part_quota_config:get','painting_quota_config:get','auxiliary_material_config:get','enclosure_product_quota:get','mes_work_review:get','mes_group_payroll_summary:get')")
   public ResultVO wageConfigGet() {
      log.info("API调用: 工价配置-获取");
      return ResultBuilder.success(this.configService.wageConfigGet());
   }

   @ApiOperation("工价配置-编辑")
   @PostMapping("/wage-config/edit")
   @PreAuthorize("@permission.check('wage_statistics_deadline_config:edit')")
   public ResultVO wageConfigEdit(@RequestBody @Validated MesWageConfigDTO param) {
      log.info("API调用: 工价配置-编辑");
      return ResultBuilder.success(this.configService.wageConfigEdit(param));
   }

   @ApiOperation("获取原料损耗计算公式")
   @GetMapping("/material/loss")
   @PreAuthorize("@permission.check('raw_material_loss_formula:get')")
   public ResultVO getRawMaterialLossCalculationFormula() {
      log.info("API 调用 ：获取原料损耗计算公式");
      return ResultBuilder.success(this.configService.getRawMaterialLossCalculationFormula());
   }

   @ApiOperation("修改原料损耗计算公式")
   @PutMapping("/material/loss")
   @PreAuthorize("@permission.check('raw_material_loss_formula:edit')")
   public ResultVO updateRawMaterialLossCalculationFormula(
      @RequestParam @EnumValidator(value = RawMaterialLossEnum.class, message = "原料损耗计算公式不存在") Integer rawMaterialLossEnum
   ) {
      log.info("API 调用 ：修改原料损耗计算公式");
      return ResultBuilder.success(this.configService.updateRawMaterialLossCalculationFormula(rawMaterialLossEnum));
   }

   @ApiOperation(value = "查询数控图纸匹配范围", notes = "查询数控图纸匹配范围")
   @GetMapping("/numerical/drawing")
   public Result getNumericalControlDrawingMatchRange() {
      log.info("API 调用 ：查询数控图纸匹配范围");
      return ResultGenerator.genSuccessResult(this.configService.getNumericalControlDrawingMatchRange());
   }

   @ApiOperation(value = "更新数控图纸匹配范围", notes = "更新数控图纸匹配范围")
   @PutMapping("/numerical/drawing")
   public Result updateNumericalControlDrawingMatchRange(@RequestBody @Validated NumericalControlDrawingMatchRangeConfigVO configVO) {
      log.info("API 调用 ：更新数控图纸匹配范围");
      return ResultGenerator.genSuccessResult(this.configService.updateNumericalControlDrawingMatchRange(configVO));
   }

   @ApiOperation("套料任务设置-编辑")
   @PostMapping("/nesting-task-setting/edit")
   @PreAuthorize("@permission.check('mes_nest_task_config:edit')")
   public ResultVO nestingTaskSettingEdit(
      @ApiParam("套料任务模式(1:根据铆焊班组独立生成套料任务, 2:根据零件和翼腹板统一生成套料任务)") @EnumValidator(value = NestingTaskModeEnum.class, message = "套料任务模式不存在") @RequestParam Integer nestingTaskModeEnum
   ) {
      log.info("API调用: 套料任务设置-编辑");
      return ResultBuilder.success(this.configService.nestingTaskSettingEdit(nestingTaskModeEnum));
   }

   @ApiOperation("套料任务设置-获取")
   @GetMapping("/nesting-task-setting/get")
   @PreAuthorize("@permission.check('mes_nest_task_config:get')")
   public ResultVO nestingTaskSettingGet() {
      log.info("API调用: 套料任务设置-获取");
      return ResultBuilder.success(this.configService.nestingTaskSettingGet());
   }

   @ApiOperation("零件图纸加工图层设置-获取")
   @GetMapping("/part-drawing-layer-setting/get")
   @PreAuthorize("@permission.check('part_drawing_layer_setting:get')")
   public ResultVO getPartDrawingLayerSetting() {
      log.info("API调用: 零件图纸加工图层设置-获取");
      return ResultBuilder.success(this.configService.getPartDrawingLayerSetting());
   }

   @ApiOperation("零件图纸加工图层设置-编辑")
   @PostMapping("/part-drawing-layer-setting/edit")
   @PreAuthorize("@permission.check('part_drawing_layer_setting:edit')")
   public ResultVO editPartDrawingLayerSetting(@RequestBody @Validated ValidList<PartDrawingLayerSettingDTO> paramList) {
      log.info("API调用: 零件图纸加工图层设置-编辑");
      return ResultBuilder.success(this.configService.editPartDrawingLayerSetting(paramList));
   }

   @ApiOperation("获取 CAPP 焊接工艺配置")
   @GetMapping("/cappWeldingCraft/get")
   public Result<CappWeldingCraftConfigDTO> getCappWeldingCraft() {
      log.info("API 调用 ：获取 CAPP 焊接工艺配置");
      return ResultGenerator.genSuccessResult(this.configService.getCappWeldingCraft());
   }

   @ApiOperation("更新 CAPP 焊接工艺配置")
   @PutMapping("/cappWeldingCraft/update")
   public Result<Boolean> updateCappWeldingCraft(@RequestBody @Valid CappWeldingCraftConfigDTO dto) {
      log.info("API 调用 ：更新 CAPP 焊接工艺配置");
      return ResultGenerator.genSuccessResult(this.configService.updateCappWeldingCraft(dto));
   }

   @ApiOperation("查询密码策略配置")
   @GetMapping("/passwordPolicy/get")
   public ResultVO getPasswordPolicy() {
      log.info("API调用: 查询密码策略配置");
      return ResultBuilder.success(this.configService.getPasswordPolicy());
   }

   @ApiOperation("编辑密码策略配置")
   @PostMapping("/passwordPolicy/edit")
   @PreAuthorize("@permission.check('user:editPasswordPolicy')")
   public ResultVO editPasswordPolicy(@RequestBody @Validated SysPasswordPolicyDTO param) {
      log.info("API调用: 编辑密码策略配置");
      return ResultBuilder.success(this.configService.editPasswordPolicy(param));
   }

   @ApiOperation("获取打印配置")
   @GetMapping("/print/config")
   @PreAuthorize("@permission.check('label_print_config:get','mes_label_artifact:get','mes_label_enclosure:get','mes_label_auxiliary_material:get','mes_label_part:get')")
   public Result<?> getPrintConfig() {
      log.info("API 调用 ：获取获取打印配置");
      return ResultGenerator.genSuccessResult(this.configService.getPrintConfig());
   }

   @ApiOperation("更新打印配置")
   @PutMapping("/print/config")
   @PreAuthorize("@permission.check('label_print_config:edit')")
   public Result<?> setPrintConfig(@RequestBody @Valid PrintConfigurationDTO dto) {
      log.info("API 调用 ：更新打印配置");
      return ResultGenerator.genSuccessResult(this.configService.setPrintConfig(dto));
   }

   public ConfigApi(final ConfigService configService) {
      this.configService = configService;
   }
}
