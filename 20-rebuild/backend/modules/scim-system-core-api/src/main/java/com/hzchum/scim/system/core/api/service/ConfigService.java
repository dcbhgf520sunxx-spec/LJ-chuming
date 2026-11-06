package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo._do.CraftConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import com.hzchum.scim.system.core.api.pojo._do.SteelPlateConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AmountVO;
import com.hzchum.scim.system.core.api.pojo.dto.AppCommonConfigWeight;
import com.hzchum.scim.system.core.api.pojo.dto.AppWarehouseWeightConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.AppWarehouseWeightConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelStatisticsDTO;
import com.hzchum.scim.system.core.api.pojo.dto.CarModelVO;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.DriverConfigureVO;
import com.hzchum.scim.system.core.api.pojo.dto.ExpireUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.FeatureDefinitionConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.FlangingPiecePriceVO;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.LogoConfigVO;
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
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ConfigService extends IService<Config> {
   Config getByCode(String code);

   Boolean updateConfig(String code, String value);

   Boolean updateOverweightSMSRecipientInfo(WeighSMSConfigDTO dto);

   WeighSMSConfigDTO getOverweightSMSRecipientInfo();

   AmountVO getAmountDecimal();

   ProjectConfigVO getProjectConfig();

   AppWarehouseWeightConfigVO getAppWarehouseWeightConfig();

   CompanyConfigVO getCompanyConfig();

   List<LogoConfigVO> getLogoConfig();

   LogoConfigVO uploadLogo(MultipartFile file);

   Boolean setLogoDefault(Long id);

   Boolean deleteLogo(Long id);

   SafetyFactorVO getSafetyFactorConfig();

   DriverConfigureVO getDriverConfigure();

   Boolean updateDriverConfigure(Boolean type);

   CarModelVO getCarModel();

   Boolean updateAppWarehouseWeight(AppWarehouseWeightConfigDTOParam dtoParam);

   Boolean updateCarModel(CarModelVO vo);

   PrintConfigVO getPrint();

   Boolean updatePrint(PrintConfigVO vo);

   Boolean setProjectMode(ProjectModeDTO projectModeDTO);

   ProjectModeDTO getCurrentProjectMode();

   ListVO<Integer> listModes();

   FlangingPiecePriceVO getFlangingPiecePrice();

   Boolean putFlangingPiecePrice(FlangingPiecePriceVO vo);

   Boolean setTechnical(TechnicalTypeDTO technicalTypeDTO);

   TechnicalTypeDTO getTechnicalType();

   Boolean setSteelPlateConfig(SteelPlateConfigDTO steelPlateConfigDTO);

   Boolean setSowNeed(Integer type);

   SteelPlateConfigDTO getSteelPlateConfig();

   Integer getSowNeed();

   Boolean setWeightConfig(AppCommonConfigWeight appCommonConfigWeight);

   CraftConfigDTO getCraftConfig();

   Boolean setCraftConfig(CraftConfigDTO configDTO);

   AppCommonConfigWeight getWeightConfig();

   FeatureDefinitionConfigDTO getFeatureDefinitionConfig();

   Boolean setFeatureDefinitionConfig(FeatureDefinitionConfigDTO dto);

   Boolean saveOrUpdateExpireDate(ExpireUpdateDTO dto);

   String getServerExpireDate();

   ContractPriceEditMode getPriceEditMode();

   Boolean editPriceEditMode(ContractPriceEditMode priceEditMode);

   BimModelStatisticsDTO getBimModelConfig();

   BimModelConfigDTO getBimConfig();

   Boolean bimModelConfigStatus(Boolean enabled);

   Boolean bimModelConfigRestrictedType(Integer modelUploadLimitType);

   Boolean bimModelConfigMaxNumOrFileSize(Double maxModelUploadNumOrFileSize);

   void removeBool(String code);

   Boolean setWastePriceEntryType(Integer type);

   Integer getWastePriceEntryType();

   FinishedProductWareConfigDTO getFinishedProductWareConfig();

   Boolean setFinishedProductWareConfig(FinishedProductWareConfigDTO param);

   Boolean saveOrUpdateSystemChargingMethod(SystemChargingMethodUpdateDTO dto);

   String getSystemChargingMethod();

   void checkSystemExpirationAndSendSms(LocalDateTime now);

   Boolean sendProgressPaymentSms();

   void smsCompensation();

   Integer getCoatingConfigMeasurementManner();

   Boolean setCoatingConfigMeasurementManner(Integer type);

   InventoryConfigurationDTO getListInventoryConfiguration();

   Boolean saveInventoryConfiguration(InventoryConfigurationVO configurationVO);

   List<LogoConfigVO> getProductLabelLogoAll();

   LogoConfigVO uploadProductLabelLogo(MultipartFile file);

   Boolean deleteProductLabelLogo(Long id);

   FinanceAmountLimitConfigDTO getFinanceAmountLimitConfig();

   Boolean setFinanceAmountLimitConfig(FinanceAmountLimitConfigDTO dto);

   FinanceAmountShowConfigDTO getFinanceAmountShowConfig();

   Boolean editFinanceAmountShowConfig(FinanceAmountShowConfigDTO param);

   SystemWatermarkConfigDTO getWatermarkConfig();

   Boolean setWatermarkConfig(SystemWatermarkConfigDTO param);

   ContractTechConfigDTO getContractTechConfig();

   Boolean setContractTechConfig(ContractTechConfigDTO param);

   Integer wageStatisticsDeadlineGet();

   Boolean wageStatisticsDeadlineEdit(Integer deadline);

   Integer getRawMaterialLossCalculationFormula();

   Boolean updateRawMaterialLossCalculationFormula(Integer rawMaterialLossEnum);

   Integer getNumericalControlDrawingMatchRange();

   Boolean updateNumericalControlDrawingMatchRange(NumericalControlDrawingMatchRangeConfigVO configVO);

   Boolean nestingTaskSettingEdit(Integer nestingTaskModeEnum);

   Integer nestingTaskSettingGet();

   List<PartDrawingLayerSettingDTO> getPartDrawingLayerSetting();

   Boolean editPartDrawingLayerSetting(List<PartDrawingLayerSettingDTO> paramList);

   PaintThicknessDO getPaintThicknessConfig();

   CappWeldingCraftConfigDTO getCappWeldingCraft();

   Boolean updateCappWeldingCraft(CappWeldingCraftConfigDTO dto);

   Boolean wageConfigEdit(MesWageConfigDTO param);

   MesWageConfigDTO wageConfigGet();

   SysPasswordPolicyDTO getPasswordPolicy();

   Boolean editPasswordPolicy(SysPasswordPolicyDTO param);

   PrintConfigurationDTO getPrintConfig();

   Boolean setPrintConfig(PrintConfigurationDTO dto);
}
