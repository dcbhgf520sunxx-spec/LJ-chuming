package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.AESUtils;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.NestingTaskModeEnum;
import com.hzchum.scim.common.core.api.enums.RawMaterialLossEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.common.core.api.enums.WarehouseNumberModeEnum;
import com.hzchum.scim.common.core.api.enums.WeightTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.system.core.api.common.enums.BimModelRestrictedTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.SystemChargingMethodEnum;
import com.hzchum.scim.system.core.api.common.enums.WastePriceEntryTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.config.PriceEditModeEnum;
import com.hzchum.scim.system.core.api.common.utils.AliYunSMSUtil;
import com.hzchum.scim.system.core.api.common.utils.RSAUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.CappWeldingCraftUsageModeEnum;
import com.hzchum.scim.system.core.api.enums.PartDrawingLayerProcessMethodEnum;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo._do.CraftConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.SteelPlateConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.SysBusinessDataStatistics;
import com.hzchum.scim.system.core.api.pojo._do.SysSmsRecords;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
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
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.LogoConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.NumericalControlDrawingMatchRangeConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.PartDrawingLayerSettingDTO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.PrintConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectModeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SafetyFactorVO;
import com.hzchum.scim.system.core.api.pojo.dto.SmsSendResult;
import com.hzchum.scim.system.core.api.pojo.dto.SystemChargingMethodUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TechnicalTypeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserCheckVO;
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
import com.hzchum.scim.system.core.api.service.BimModelRestrictConfigService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesCoatingConfigService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.SysSmsRecordsService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.utils.PasswordPolicyUtil;
import com.hzchum.scim.system.core.mapper.ConfigMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {
   @Resource
   @Lazy
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private MesBuildingWorkshopService buildingWorkshopService;
   @Resource
   private RedisUtils redisUtils;
   @Autowired
   private MesCoatingConfigService coatingConfigService;
   @Autowired
   private MesBuildingCoatingConfigService buildingCoatingConfigService;
   @Resource
   private RoleService roleService;
   @Resource
   private UserRoleLinkService userRoleLinkService;
   @Resource
   private BusinessPriceTempService businessPriceTempService;
   @Resource
   private SysSmsRecordsService sysSmsRecordsService;
   @Resource
   private BimModelRestrictConfigService restrictConfigService;

   @Override
   public Config getByCode(String code) {
      return this.baseMapper.getByCode(code);
   }

   @Override
   public AmountVO getAmountDecimal() {
      Config config = this.baseMapper.getByCode("AMOUNT_DECIMAL");
      if (config == null) {
         return null;
      }

      AmountVO amountVO = null;

      try {
         amountVO = JSON.parseObject(config.getValue(), AmountVO.class);
      } catch (Exception e) {
         this.log.error("获取金额配置信息失败", e);
      }

      return amountVO;
   }

   @Override
   public AppWarehouseWeightConfigVO getAppWarehouseWeightConfig() {
      Config config = this.baseMapper.getByCode("APP_WAREHOUSE_WEIGHT");
      if (config == null) {
         return null;
      }

      AppWarehouseWeightConfigVO weightConfigVO = null;

      try {
         weightConfigVO = JSON.parseObject(config.getValue(), AppWarehouseWeightConfigVO.class);
      } catch (Exception e) {
         this.log.error("获取APP仓库显示重量配置信息", e);
      }

      return weightConfigVO;
   }

   @Override
   public ProjectConfigVO getProjectConfig() {
      Config config = this.baseMapper.getByCode("PROJECT");
      if (config == null) {
         return null;
      }

      ProjectConfigVO projectConfigVO = null;

      try {
         projectConfigVO = JSON.parseObject(config.getValue(), ProjectConfigVO.class);
      } catch (Exception e) {
         this.log.error("获取项目配置信息失败", e);
      }

      return projectConfigVO;
   }

   @DS("master")
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   @Override
   public CompanyConfigVO getCompanyConfig() {
      Config config = this.baseMapper.getByCode("COMPANY_NAME");
      if (config == null) {
         return null;
      }

      CompanyConfigVO companyConfigVO = null;

      try {
         companyConfigVO = JSON.parseObject(config.getValue(), CompanyConfigVO.class);
      } catch (Exception e) {
         this.log.error("获取公司配置信息失败", e);
      }

      return companyConfigVO;
   }

   @Override
   public List<LogoConfigVO> getLogoConfig() {
      Config config = this.baseMapper.getByCode("LOGO");
      if (config != null && !StringUtils.isBlank(config.getValue())) {
         List<LogoConfigVO> logoConfigVOS = null;

         try {
            logoConfigVOS = JSON.parseArray(config.getValue(), LogoConfigVO.class);
         } catch (Exception e) {
            this.log.error("获取公司LOGO配置信息失败", e);
         }

         return logoConfigVOS;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public SafetyFactorVO getSafetyFactorConfig() {
      Config config = this.baseMapper.getByCode("SAFETY_FACTOR");
      if (config == null) {
         return null;
      }

      SafetyFactorVO safetyFactorVO = null;

      try {
         safetyFactorVO = JSON.parseObject(config.getValue(), SafetyFactorVO.class);
      } catch (Exception e) {
         this.log.error("获取安全系数信息失败", e);
      }

      return safetyFactorVO;
   }

   @Override
   public Boolean updateConfig(String code, String value) {
      Preconditions.checkArgument(StringUtils.isNotBlank(value), "更新失败，配置信息不能为空");
      Config config = this.baseMapper.getByCode(code);
      if (config == null) {
         config = new Config();
         config.setCode(code);
         config.setName("");
         config.setValue(value);
         return this.baseMapper.insert(config) == 1;
      }

      config.setValue(value);
      this.baseMapper.updateById(config);
      if ("COMPANY_NAME".equals(code)) {
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if (authentication != null) {
            GeneratorUserDetailService.USER_MAP.remove(UserUtil.getCurrentUserId());
         }
      }

      return true;
   }

   @Override
   public WeighSMSConfigDTO getOverweightSMSRecipientInfo() {
      Config config = this.baseMapper.getByCode("NEW_OVERWEIGHT_SMS_RECIPIENT");
      if (config == null) {
         return null;
      }

      WeighSMSConfigDTO dto = null;

      try {
         dto = JSON.parseObject(config.getValue(), WeighSMSConfigDTO.class);
         if (dto.getWeightTypeEnum() == null) {
            dto.setWeightTypeEnum(WeightTypeEnum.NET_WEIGHT.getType());
         }
      } catch (Exception e) {
         this.log.error("获取过磅短信接收人失败", e);
      }

      return dto;
   }

   @Override
   public Boolean updateOverweightSMSRecipientInfo(WeighSMSConfigDTO configDTO) {
      int emptyConfigWorkshopCount = 0;
      Set<String> registeredPhones = CollUtil.newHashSet();

      for (UserCheckVO userCheck : configDTO.getUserChecks()) {
         Preconditions.checkArgument(
            Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", userCheck.getPhone()), "更新失败，手机格式错误"
         );
         registeredPhones.add(userCheck.getPhone());
         User dbUser = this.userService.getById(userCheck.getId());
         Preconditions.checkArgument(dbUser != null, "更新失败，用户不存在");
         userCheck.setName(dbUser.getName());
         if (CollUtil.isEmpty(userCheck.getWorkshops())) {
            emptyConfigWorkshopCount++;
         } else {
            for (IdAndNameDTO workshop : userCheck.getWorkshops()) {
               MesBuildingWorkshop dbWorkShop = this.buildingWorkshopService.getById(workshop.getId());
               Preconditions.checkArgument(dbWorkShop != null, "更新失败，车间不存在");
               workshop.setName(dbWorkShop.getName());
            }
         }
      }

      Preconditions.checkArgument(registeredPhones.size() == configDTO.getUserChecks().size(), "更新失败， 手机号不能重复");
      Preconditions.checkArgument(emptyConfigWorkshopCount < 2, "更新失败，最多只能有一条配置不选车间");
      return this.updateConfig("NEW_OVERWEIGHT_SMS_RECIPIENT", JSON.toJSONString(configDTO));
   }

   @Override
   public LogoConfigVO uploadLogo(MultipartFile file) {
      Attachment attachment = this.attachmentService.uploadFile(file, AttachmentTypeEnum.CONFIG.getType());
      Preconditions.checkArgument(attachment != null, "上传失败");
      List<LogoConfigVO> logoConfigVOS = this.getLogoConfig();
      Preconditions.checkArgument(logoConfigVOS.size() < 10, "上传失败，logo图片上传数量最大为10张");
      LogoConfigVO logoConfigVO = new LogoConfigVO();
      logoConfigVO.setId(attachment.getId());
      logoConfigVO.setPath(this.attachmentService.getById(attachment.getId()).getImageUrl());
      if (CollectionUtils.isNotEmpty(logoConfigVOS)) {
         logoConfigVO.setIsDefault(Boolean.FALSE);
      } else {
         logoConfigVO.setIsDefault(Boolean.TRUE);
         logoConfigVOS = new ArrayList<>();
      }

      logoConfigVOS.add(logoConfigVO);
      this.updateConfig("LOGO", JSON.toJSONString(logoConfigVOS));
      return logoConfigVO;
   }

   @Override
   public Boolean setLogoDefault(Long id) {
      List<LogoConfigVO> logoConfigs = this.getLogoConfig();
      List<LogoConfigVO> checkLogo = logoConfigs.stream().filter(logo -> logo.getId().equals(id)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(checkLogo), "设置默认失败，无logo图片");
      logoConfigs.forEach(logo -> {
         if (logo.getId().equals(id) && !logo.getIsDefault()) {
            logo.setIsDefault(true);
         }

         if (!logo.getId().equals(id) && logo.getIsDefault()) {
            logo.setIsDefault(false);
         }
      });
      return this.updateConfig("LOGO", JSON.toJSONString(logoConfigs));
   }

   @Override
   public Boolean deleteLogo(Long id) {
      List<LogoConfigVO> logoConfigs = this.getLogoConfig();
      List<LogoConfigVO> checkLogo = logoConfigs.stream().filter(logo -> logo.getId().equals(id)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(checkLogo), "删除失败，无logo图片");
      List<LogoConfigVO> logoList = logoConfigs.stream().filter(logo -> !logo.getId().equals(id)).collect(Collectors.toList());
      if (logoList.size() > 0 && checkLogo.get(0).getIsDefault()) {
         logoList.get(0).setIsDefault(true);
      }

      this.attachmentService.deleteFile(id);
      return this.updateConfig("LOGO", JSON.toJSONString(logoList));
   }

   @Override
   public DriverConfigureVO getDriverConfigure() {
      Config config = this.baseMapper.getByCode("DRIVER_CONFIGURE");
      if (config == null) {
         return null;
      }

      DriverConfigureVO driverConfigureVO = null;

      try {
         driverConfigureVO = JSON.parseObject(config.getValue(), DriverConfigureVO.class);
      } catch (Exception e) {
         this.log.error("获取配置失败信息失败", e);
      }

      return driverConfigureVO;
   }

   @Override
   public Boolean updateDriverConfigure(Boolean type) {
      DriverConfigureVO driverConfigureVO = new DriverConfigureVO();
      driverConfigureVO.setConfigure(type);
      this.updateConfig("DRIVER_CONFIGURE", JSON.toJSONString(driverConfigureVO));
      return true;
   }

   @Override
   public CarModelVO getCarModel() {
      Config config = this.baseMapper.getByCode("CAR_MODEL");
      CarModelVO result = new CarModelVO();
      result.setCarModels(new ArrayList<>());
      if (config == null) {
         return result;
      }

      try {
         return JSON.parseObject(config.getValue(), CarModelVO.class);
      } catch (Exception e) {
         this.log.error("获取车型配置失败", e);
         return result;
      }
   }

   @Override
   public Boolean updateAppWarehouseWeight(AppWarehouseWeightConfigDTOParam dtoParam) {
      return this.updateConfig("APP_WAREHOUSE_WEIGHT", JSON.toJSONString(dtoParam));
   }

   @Override
   public Boolean updateCarModel(CarModelVO vo) {
      return this.updateConfig("CAR_MODEL", JSON.toJSONString(vo));
   }

   @Override
   public PrintConfigVO getPrint() {
      Config config = this.baseMapper.getByCode("APP_PRINT");
      PrintConfigVO result = new PrintConfigVO();
      if (config == null) {
         result.setEnclosureType(1);
         return result;
      }

      try {
         return JSON.parseObject(config.getValue(), PrintConfigVO.class);
      } catch (Exception e) {
         this.log.error("获取APP打印配置失败", e);
         return result;
      }
   }

   @Override
   public Boolean updatePrint(PrintConfigVO vo) {
      return this.updateConfig("APP_PRINT", JSON.toJSONString(vo));
   }

   @Override
   public Boolean setProjectMode(ProjectModeDTO projectModeDTO) {
      String jsonString = JSON.toJSONString(projectModeDTO);
      Config config = this.baseMapper.getByCode("PROJECT_MODE");
      if (config != null) {
         config.setValue(jsonString);
         return this.baseMapper.updateById(config) == 1;
      } else {
         config = Config.builder().code("PROJECT_MODE").name("项目模式").value(jsonString).build();
         return this.baseMapper.insert(config) == 1;
      }
   }

   @Override
   public ProjectModeDTO getCurrentProjectMode() {
      Config config = this.baseMapper.getByCode("PROJECT_MODE");
      return config != null ? JSON.parseObject(config.getValue(), ProjectModeDTO.class) : null;
   }

   @Override
   public ListVO<Integer> listModes() {
      return new ListVO<>(ProjectModeEnum.listAll());
   }

   @Override
   public FlangingPiecePriceVO getFlangingPiecePrice() {
      Config config = this.baseMapper.getByCode("FLANGING_PIECE_PRICE");
      return config == null ? null : JSON.parseObject(config.getValue(), FlangingPiecePriceVO.class);
   }

   @Override
   public Boolean putFlangingPiecePrice(FlangingPiecePriceVO vo) {
      return this.updateConfig("FLANGING_PIECE_PRICE", JSON.toJSONString(vo));
   }

   @Override
   public Boolean setTechnical(TechnicalTypeDTO technicalTypeDTO) {
      String jsonString = JSON.toJSONString(technicalTypeDTO);
      Config config = this.baseMapper.getByCode("TECHNICAL_CLARIFICATION_MODEL");
      if (config != null) {
         config.setValue(jsonString);
         return this.baseMapper.updateById(config) == 1;
      } else {
         config = Config.builder().code("TECHNICAL_CLARIFICATION_MODEL").name("是否关联技术交底").value(jsonString).build();
         return this.baseMapper.insert(config) == 1;
      }
   }

   @Override
   public TechnicalTypeDTO getTechnicalType() {
      Config config = this.baseMapper.getByCode("TECHNICAL_CLARIFICATION_MODEL");
      return config == null ? null : JSON.parseObject(config.getValue(), TechnicalTypeDTO.class);
   }

   @Override
   public Boolean setSteelPlateConfig(SteelPlateConfigDTO steelPlateConfigDTO) {
      return this.updateConfig("STEEL_PLATE_CONFIG", JSON.toJSONString(steelPlateConfigDTO));
   }

   @Override
   public Boolean setSowNeed(Integer type) {
      return this.updateConfig("SHOW_NEED", JSON.toJSONString(type));
   }

   @Override
   public SteelPlateConfigDTO getSteelPlateConfig() {
      Config config = this.baseMapper.getByCode("STEEL_PLATE_CONFIG");
      return config == null ? null : JSON.parseObject(config.getValue(), SteelPlateConfigDTO.class);
   }

   @Override
   public Integer getSowNeed() {
      Config config = this.baseMapper.getByCode("SHOW_NEED");
      return config == null ? null : JSON.parseObject(config.getValue(), Integer.class);
   }

   @Override
   public Boolean setWeightConfig(AppCommonConfigWeight appCommonConfigWeight) {
      return this.updateConfig("APP_WEIGHT_CONFIG", JSON.toJSONString(appCommonConfigWeight));
   }

   @Override
   public CraftConfigDTO getCraftConfig() {
      return null;
   }

   @Override
   public Boolean setCraftConfig(CraftConfigDTO configDTO) {
      return null;
   }

   @Override
   public AppCommonConfigWeight getWeightConfig() {
      Config config = this.baseMapper.getByCode("APP_WEIGHT_CONFIG");
      return config == null ? null : JSON.parseObject(config.getValue(), AppCommonConfigWeight.class);
   }

   @Override
   public FeatureDefinitionConfigDTO getFeatureDefinitionConfig() {
      Config config = this.baseMapper.getByCode("FEATURE_DEFINITION_CONFIG");
      return config == null ? null : JSON.parseObject(config.getValue(), FeatureDefinitionConfigDTO.class);
   }

   @Override
   public Boolean setFeatureDefinitionConfig(FeatureDefinitionConfigDTO dto) {
      return this.updateConfig("FEATURE_DEFINITION_CONFIG", JSON.toJSONString(dto));
   }

   @Transactional
   @Override
   public Boolean saveOrUpdateExpireDate(ExpireUpdateDTO dto) {
      Config config = this.baseMapper.getByCode("SERVER_EXPIRE_DATE");
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime ldt = LocalDateTime.parse(df.format(dto.getExpireDate()), df);
      String localDateTimeStr = ldt.format(df);
      this.log.warn("LocalDateTime转成String类型的时间：" + localDateTimeStr);
      if (Objects.isNull(config)) {
         Config saveConfig = new Config();
         saveConfig.setCode("SERVER_EXPIRE_DATE");
         saveConfig.setName("系统时间配置");
         saveConfig.setValue(AESUtils.encrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), localDateTimeStr));
         this.save(saveConfig);
      } else {
         config.setValue(AESUtils.encrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), localDateTimeStr));
         this.updateById(config);
      }

      this.redisUtils.del("SERVER_EXPIRE_DATE");
      return Boolean.TRUE;
   }

   @Override
   public String getServerExpireDate() {
      Config config = this.baseMapper.getByCode("SERVER_EXPIRE_DATE");
      return Objects.nonNull(config) ? AESUtils.decrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), config.getValue()) : null;
   }

   @Override
   public ContractPriceEditMode getPriceEditMode() {
      Config config = this.baseMapper.getByCode("PRICE_EDIT_MODE");
      return config != null && config.getValue() != null ? JSON.parseObject(config.getValue(), ContractPriceEditMode.class) : null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editPriceEditMode(ContractPriceEditMode priceEditMode) {
      Config config = this.baseMapper.getByCode("PRICE_EDIT_MODE");
      String name = "价格修改模式:1立即审核 2暂时保存";
      if (config == null) {
         config = Config.builder().code("PRICE_EDIT_MODE").name(name).value(JSON.toJSONString(priceEditMode)).build();
         this.baseMapper.insert(config);
         this.businessPriceTempService.remove(null);
      } else {
         config.setName(name);
         config.setValue(JSON.toJSONString(priceEditMode));
         this.baseMapper.updateById(config);
         if (priceEditMode.getPriceEditMode().equals(PriceEditModeEnum.INSTANT_AUDIT.getType())) {
            this.businessPriceTempService.remove(null);
         }
      }

      return true;
   }

   @Override
   public BimModelStatisticsDTO getBimModelConfig() {
      BimModelConfigDTO bimModelConfigDTO = this.getBimConfig();
      if (bimModelConfigDTO != null) {
         Map<String, List<SysBusinessDataStatistics>> collect = this.restrictConfigService
            .list()
            .stream()
            .collect(Collectors.groupingBy(SysBusinessDataStatistics::getCode));
         Integer maxModelUploadNum = bimModelConfigDTO.getMaxModelUploadNum();
         Integer currentModelUploadNum = CollectionUtils.isNotEmpty(collect.get("TOTAL_QUANTITY"))
            ? (int)Double.parseDouble(collect.get("TOTAL_QUANTITY").get(0).getValue())
            : 0;
         Integer poor = maxModelUploadNum - currentModelUploadNum;
         Integer uploadNumPoor = poor > 0 ? poor : 0;
         double value = CollectionUtils.isNotEmpty(collect.get("FILE_SIZE")) ? Double.valueOf(collect.get("FILE_SIZE").get(0).getValue()) : 0.0;
         Double maxModelUploadFileSize = bimModelConfigDTO.getMaxModelUploadFileSize() * 1024.0;
         Double filepoor = maxModelUploadFileSize - value;
         Double fileSizePoor = filepoor > 0.0 ? filepoor : 0.0;
         BigDecimal bigDecimal = new BigDecimal(value / 1024.0);
         bigDecimal = bigDecimal.setScale(3, RoundingMode.UP);
         Double currentModelUploadFileSize = bigDecimal.doubleValue();
         DecimalFormat df = new DecimalFormat("#.00");
         return BimModelStatisticsDTO.builder()
            .enabled(bimModelConfigDTO.getEnabled())
            .modelUploadLimitType(bimModelConfigDTO.getModelUploadLimitType())
            .maxModelUploadNum(maxModelUploadNum)
            .currentModelUploadNum(currentModelUploadNum)
            .uploadNumPoor(uploadNumPoor)
            .maxModelUploadFileSize(bimModelConfigDTO.getMaxModelUploadFileSize())
            .currentModelUploadFileSize(currentModelUploadFileSize)
            .fileSizePoor(Double.parseDouble(df.format(fileSizePoor)))
            .build();
      } else {
         return new BimModelStatisticsDTO();
      }
   }

   @Override
   public BimModelConfigDTO getBimConfig() {
      Config config = this.baseMapper.getByCode("BIM_MODEL_CONVERT_RESTRICT_ENCIPHER");
      return this.readBimConfig(config);
   }

   private BimModelConfigDTO readBimConfig(Config config) {
      String key = System.getenv("LJAPS_BIM_CONFIG_AES_KEY");
      if (config == null || StrUtil.isBlank(key) || StrUtil.isBlank(config.getValue())) {
         return null;
      }
      String plain = AESUtils.decrypt(key, config.getValue());
      return StrUtil.isBlank(plain) ? null : JSON.parseObject(plain, BimModelConfigDTO.class);
   }

   @Override
   public Boolean bimModelConfigStatus(Boolean enabled) {
      Config config = this.baseMapper.getByCode("BIM_MODEL_CONVERT_RESTRICT_ENCIPHER");
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(config), "配置数据不存在");
      BimModelConfigDTO bimModelConfigDTO = this.readBimConfig(config);
      Preconditions.checkArgument(bimModelConfigDTO != null, "无法读取模型转换限制配置");
      bimModelConfigDTO.setEnabled(enabled);
      config.setValue(AESUtils.encrypt(System.getenv("LJAPS_BIM_CONFIG_AES_KEY"), JSON.toJSONString(bimModelConfigDTO)));
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public Boolean bimModelConfigRestrictedType(Integer modelUploadLimitType) {
      Config config = this.baseMapper.getByCode("BIM_MODEL_CONVERT_RESTRICT_ENCIPHER");
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(config), "配置数据不存在");
      BimModelConfigDTO bimModelConfigDTO = this.readBimConfig(config);
      Preconditions.checkArgument(bimModelConfigDTO != null, "无法读取模型转换限制配置");
      bimModelConfigDTO.setModelUploadLimitType(modelUploadLimitType);
      config.setValue(AESUtils.encrypt(System.getenv("LJAPS_BIM_CONFIG_AES_KEY"), JSON.toJSONString(bimModelConfigDTO)));
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public Boolean bimModelConfigMaxNumOrFileSize(Double maxModelUploadNumOrFileSize) {
      Config config = this.baseMapper.getByCode("BIM_MODEL_CONVERT_RESTRICT_ENCIPHER");
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(config), "配置数据不存在");
      BimModelConfigDTO bimModelConfigDTO = this.readBimConfig(config);
      Preconditions.checkArgument(bimModelConfigDTO != null, "无法读取模型转换限制配置");
      if (bimModelConfigDTO.getModelUploadLimitType() == BimModelRestrictedTypeEnum.TOTAL_QUANTITY.getType()) {
         bimModelConfigDTO.setMaxModelUploadNum(maxModelUploadNumOrFileSize.intValue());
      } else {
         bimModelConfigDTO.setMaxModelUploadFileSize(maxModelUploadNumOrFileSize);
      }

      config.setValue(AESUtils.encrypt(System.getenv("LJAPS_BIM_CONFIG_AES_KEY"), JSON.toJSONString(bimModelConfigDTO)));
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public void removeBool(String code) {
      this.baseMapper.remove(code);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setWastePriceEntryType(Integer type) {
      Preconditions.checkArgument(WastePriceEntryTypeEnum.boolExist(type), "废料价格录入类型有误!");
      Config config = this.baseMapper.getByCode("WASTE_PRICE_ENTRY_TYPE");
      if (config != null) {
         config.setValue(String.valueOf(type));
         config.setCode("WASTE_PRICE_ENTRY_TYPE");
         config.setName("废料价格录入类型");
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().code("WASTE_PRICE_ENTRY_TYPE").name("废料价格录入类型").value(String.valueOf(type)).build();
         this.baseMapper.insert(config);
      }

      return true;
   }

   @Override
   public Integer getWastePriceEntryType() {
      Config code = this.baseMapper.getByCode("WASTE_PRICE_ENTRY_TYPE");
      Integer type = WastePriceEntryTypeEnum.CREATE_ENTRY_PRICE.getType();
      if (code != null && NumberUtils.isDigits(code.getValue())) {
         Integer value = Integer.valueOf(code.getValue());
         if (WastePriceEntryTypeEnum.boolExist(value)) {
            type = value;
         }
      }

      return type;
   }

   @Override
   public FinishedProductWareConfigDTO getFinishedProductWareConfig() {
      Config config = this.baseMapper.getByCode("FINISHED_PRODUCT_WAREHOUSE");
      if (config != null && !StringUtils.isBlank(config.getValue())) {
         FinishedProductWareConfigDTO configDTO = JSON.parseObject(config.getValue(), FinishedProductWareConfigDTO.class);
         configDTO.setBoolRequiredWarehouse(
            configDTO.getBoolEnableWarehouse() && configDTO.getBoolRequiredWarehouse() != null && configDTO.getBoolRequiredWarehouse()
         );
         return configDTO;
      } else {
         return FinishedProductWareConfigDTO.builder()
            .boolEnableWarehouse(false)
            .warehouseNumberModeEnum(WarehouseNumberModeEnum.AUTO_MODE.getType())
            .boolRequiredWarehouse(false)
            .build();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setFinishedProductWareConfig(FinishedProductWareConfigDTO param) {
      Preconditions.checkArgument(param.getBoolEnableWarehouse() != null, "参数错误!");
      if (param.getBoolEnableWarehouse()) {
         Preconditions.checkArgument(WarehouseNumberModeEnum.check(param.getWarehouseNumberModeEnum()), "码号选择方式有误!");
      } else {
         Preconditions.checkArgument(
            param.getWarehouseNumberModeEnum() == null || WarehouseNumberModeEnum.check(param.getWarehouseNumberModeEnum()), "码号选择方式有误!"
         );
      }

      param.setWarehouseNumberModeEnum(
         param.getWarehouseNumberModeEnum() == null ? WarehouseNumberModeEnum.AUTO_MODE.getType() : param.getWarehouseNumberModeEnum()
      );
      String value = JSON.toJSONString(param);
      Config config = this.baseMapper.getByCode("FINISHED_PRODUCT_WAREHOUSE");
      if (config != null) {
         config.setValue(value);
         config.setCode("FINISHED_PRODUCT_WAREHOUSE");
         config.setName("MES成品仓库配置");
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().code("FINISHED_PRODUCT_WAREHOUSE").name("MES成品仓库配置").value(value).build();
         this.baseMapper.insert(config);
      }

      return null;
   }

   @Transactional
   @Override
   public Boolean saveOrUpdateSystemChargingMethod(SystemChargingMethodUpdateDTO dto) {
      Config config = this.baseMapper.getByCode("SYSTEM_CHARGING_METHOD");
      if (Objects.isNull(config)) {
         Config saveConfig = new Config();
         saveConfig.setCode("SYSTEM_CHARGING_METHOD");
         saveConfig.setName("系统收费方式");
         saveConfig.setValue(SystemChargingMethodEnum.MAINTENANCE_FEE.getType());
         this.save(saveConfig);
      } else {
         config.setValue(dto.getSystemChargingMethod());
         this.updateById(config);
      }

      return Boolean.TRUE;
   }

   @Override
   public String getSystemChargingMethod() {
      Config config = this.baseMapper.getByCode("SYSTEM_CHARGING_METHOD");
      Preconditions.checkArgument(Objects.nonNull(config), "系统收费方式记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(config.getValue()), "系统收费方式值为空");
      return config.getValue();
   }

   @Transactional
   @Override
   public void checkSystemExpirationAndSendSms(LocalDateTime now) {
      User user = this.getUser();
      Config config = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SERVER_EXPIRE_DATE"));
      Preconditions.checkArgument(Objects.nonNull(config), "系统过期时间配置记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(config.getValue()), "系统过期时间配置为空");
      Config companyNameConfig = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "COMPANY_NAME"));
      Preconditions.checkArgument(Objects.nonNull(companyNameConfig), "公司配置记录不存在");
      CompanyConfigVO companyConfigVO = JSONUtil.toBean(companyNameConfig.getValue(), CompanyConfigVO.class);
      String expireDateStr = AESUtils.decrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), config.getValue());
      LocalDateTime expireDate = LocalDateTime.parse(expireDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      if (expireDate.isAfter(now)) {
         this.handleSmsSending(user.getPhone(), companyConfigVO.getCompanyName(), expireDate, now);
      }
   }

   private void handleSmsSending(String phone, String companyName, LocalDateTime expireDate, LocalDateTime now) {
      Config systemChargingMethod = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SYSTEM_CHARGING_METHOD"));
      Preconditions.checkArgument(Objects.nonNull(systemChargingMethod), "系统收费方式记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(systemChargingMethod.getValue()), "系统收费方式值为空");
      Preconditions.checkArgument(SystemChargingMethodEnum.isExist(systemChargingMethod.getValue()), "已存在的系统收费方式与实际定义不匹配");
      LocalDateTime nowTruncated = now.withSecond(0).withNano(0);
      LocalDateTime expireDateTruncated = expireDate.withSecond(0).withNano(0);
      long daysDifference = ChronoUnit.DAYS.between(nowTruncated, expireDateTruncated);
      this.log.debug("now（精确到分钟）：" + DateUtil.format(nowTruncated, "yyyy-MM-dd HH:mm:ss"));
      this.log.debug("expireDate（精确到分钟）：" + DateUtil.format(expireDateTruncated, "yyyy-MM-dd HH:mm:ss"));
      this.log.debug("剩余天数：" + daysDifference);
      Map<String, String> mapParam = new HashMap<>();
      mapParam.put("customer", companyName);
      if (SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(systemChargingMethod.getValue())) {
         if (daysDifference == 30L) {
            this.sendSms(phone, mapParam, systemChargingMethod.getValue(), "30日");
         } else if (daysDifference == 3L) {
            mapParam.put("expirationDate", DateUtil.format(Date.from(expireDate.atZone(ZoneId.systemDefault()).toInstant()), "yyyy年M月d日"));
            this.sendSms(phone, mapParam, systemChargingMethod.getValue(), "3日");
         }
      }

      if (SystemChargingMethodEnum.RENTAL_FEE.getType().equals(systemChargingMethod.getValue())) {
         if (daysDifference == 30L) {
            this.sendSms(phone, mapParam, systemChargingMethod.getValue(), "30日");
         } else if (daysDifference == 10L) {
            mapParam.put("expirationDate", DateUtil.format(Date.from(expireDate.atZone(ZoneId.systemDefault()).toInstant()), "yyyy年M月d日"));
            this.sendSms(phone, mapParam, systemChargingMethod.getValue(), "10日");
         }
      }
   }

   private void sendSms(String phone, Map<String, String> mapParam, String chargingMethod, String expirationTime) {
      String template = "";
      if (SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(chargingMethod)) {
         template = expirationTime.equals("30日") ? "SMS_472985039" : "SMS_473045044";
      }

      if (SystemChargingMethodEnum.RENTAL_FEE.getType().equals(chargingMethod)) {
         template = "SMS_473045027";
      }

      if (StrUtil.isNotBlank(template)) {
         mapParam.put("expirationTime", expirationTime);
         SmsSendResult result = AliYunSMSUtil.sendMessage(phone, template, mapParam);
         this.saveSmsRecord(result, chargingMethod, expirationTime);
         this.log.debug("【" + chargingMethod + "】 剩余" + expirationTime + "短信已发送");
      }
   }

   private void saveSmsRecord(SmsSendResult result, String chargingMethod, String expirationTime) {
      SysSmsRecords smsRecords = new SysSmsRecords();
      smsRecords.setCreateTime(LocalDateTime.now());
      smsRecords.setBoolSuccess(result.isBoolSuccess());
      smsRecords.setAttemptCount(1);
      smsRecords.setSendTime(LocalDateTime.now());
      smsRecords.setErrorMessage(result.getErrorMessage());
      smsRecords.setChargingMethod(chargingMethod);
      smsRecords.setDaysRemaining(expirationTime);
      this.sysSmsRecordsService.save(smsRecords);
   }

   private User getUser() {
      Role role = this.roleService.getByName("超级管理员");
      Preconditions.checkArgument(Objects.nonNull(role), "超级管理员角色不存在");
      UserRoleLink userRoleLink = this.userRoleLinkService.lambdaQuery().eq(UserRoleLink::getRoleId, role.getId()).one();
      Preconditions.checkArgument(Objects.nonNull(userRoleLink), "超级管理员角色与用户关联记录不存在");
      User user = this.userService.getById(userRoleLink.getUserId());
      Preconditions.checkArgument(Objects.nonNull(user), "超级管理员用户记录不存在");
      return user;
   }

   @Transactional
   @Override
   public Boolean sendProgressPaymentSms() {
      User user = this.getUser();
      Config config = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SERVER_EXPIRE_DATE"));
      Preconditions.checkArgument(Objects.nonNull(config), "系统过期时间配置记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(config.getValue()), "系统过期时间配置为空");
      Config companyNameConfig = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "COMPANY_NAME"));
      Preconditions.checkArgument(Objects.nonNull(companyNameConfig), "公司配置记录不存在");
      CompanyConfigVO companyConfigVO = JSONUtil.toBean(companyNameConfig.getValue(), CompanyConfigVO.class);
      String expireDateStr = AESUtils.decrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), config.getValue());
      Date expireDate = DateUtil.parse(expireDateStr);
      String expireD = DateUtil.format(expireDate, "yyyy年M月d日");
      String phone = user.getPhone();
      Config systemChargingMethod = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SYSTEM_CHARGING_METHOD"));
      Preconditions.checkArgument(Objects.nonNull(systemChargingMethod), "系统收费方式记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(systemChargingMethod.getValue()), "系统收费方式值为空");
      Preconditions.checkArgument(SystemChargingMethodEnum.isExist(systemChargingMethod.getValue()), "已存在的系统收费方式与实际定义不匹配");
      Preconditions.checkArgument(SystemChargingMethodEnum.PROGRESS_PAYMENT.getType().equals(systemChargingMethod.getValue()), "当前系统收费方式不是【进度款】，无法调用该接口");
      Map<String, String> mapParam = new HashMap<>();
      mapParam.put("customer", companyConfigVO.getCompanyName());
      mapParam.put("expirationDate", expireD);
      SmsSendResult result = AliYunSMSUtil.sendMessage(phone, "SMS_473190026", mapParam);
      this.saveSmsRecord(result, SystemChargingMethodEnum.PROGRESS_PAYMENT.getType(), null);
      this.log.debug("【" + SystemChargingMethodEnum.PROGRESS_PAYMENT.getType() + "】 短信已发送");
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public void smsCompensation() {
      LocalDateTime now = LocalDateTime.now();
      User user = this.getUser();
      String phone = user.getPhone();
      Config config = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SERVER_EXPIRE_DATE"));
      Preconditions.checkArgument(Objects.nonNull(config), "系统过期时间配置记录不存在");
      Preconditions.checkArgument(StrUtil.isNotBlank(config.getValue()), "系统过期时间配置为空");
      Config companyNameConfig = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "COMPANY_NAME"));
      Preconditions.checkArgument(Objects.nonNull(companyNameConfig), "公司配置记录不存在");
      CompanyConfigVO companyConfigVO = JSONUtil.toBean(companyNameConfig.getValue(), CompanyConfigVO.class);
      String expireDateStr = AESUtils.decrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), config.getValue());
      LocalDateTime expireDate = LocalDateTime.parse(expireDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      String expireD = DateUtil.format(expireDate, "yyyy年M月d日");
      if (expireDate.isAfter(now)) {
         Config systemChargingMethod = this.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SYSTEM_CHARGING_METHOD"));
         Preconditions.checkArgument(Objects.nonNull(systemChargingMethod), "系统收费方式记录不存在");
         Preconditions.checkArgument(StrUtil.isNotBlank(systemChargingMethod.getValue()), "系统收费方式值为空");
         Preconditions.checkArgument(SystemChargingMethodEnum.isExist(systemChargingMethod.getValue()), "已存在的系统收费方式与实际定义不匹配");
         LocalDate nowTruncated = LocalDateTime.now().toLocalDate();
         LocalDate expireDateTruncated = expireDate.toLocalDate();
         long daysDifference = ChronoUnit.DAYS.between(nowTruncated, expireDateTruncated);
         this.log.debug("now 年月日：" + nowTruncated);
         this.log.debug("expireDate 年月日：" + expireDateTruncated);
         this.log.debug("剩余天数：" + daysDifference);
         Map<String, String> mapParam = new HashMap<>();
         mapParam.put("customer", companyConfigVO.getCompanyName());
         String expirationDate = DateUtil.format(Date.from(expireDate.atZone(ZoneId.systemDefault()).toInstant()), "yyyy年M月d日");
         List<SysSmsRecords> recordsList = this.sysSmsRecordsService
            .lambdaQuery()
            .apply("date_format(send_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", now)
            .list();
         if (SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(systemChargingMethod.getValue())) {
            if (daysDifference <= 30L && daysDifference > 3L && ObjectUtil.isEmpty(recordsList)) {
               this.sendSms(phone, mapParam, systemChargingMethod.getValue(), daysDifference + "日");
               this.log.debug("规定时间未发重新补发=============");
            } else if (daysDifference <= 3L && ObjectUtil.isEmpty(recordsList)) {
               mapParam.put("expirationDate", expirationDate);
               this.sendSms(phone, mapParam, systemChargingMethod.getValue(), daysDifference + "日");
               this.log.debug("规定时间未发重新补发=============");
            }
         }

         if (SystemChargingMethodEnum.RENTAL_FEE.getType().equals(systemChargingMethod.getValue())) {
            if (daysDifference <= 30L && daysDifference > 10L && ObjectUtil.isEmpty(recordsList)) {
               this.sendSms(phone, mapParam, systemChargingMethod.getValue(), daysDifference + "日");
               this.log.debug("规定时间未发重新补发=============");
            } else if (daysDifference <= 10L && ObjectUtil.isEmpty(recordsList)) {
               mapParam.put("expirationDate", expirationDate);
               this.sendSms(phone, mapParam, systemChargingMethod.getValue(), daysDifference + "日");
               this.log.debug("规定时间未发重新补发=============");
            }
         }

         this.failCompensation(companyConfigVO, expireD, phone);
      }
   }

   @Override
   public List<LogoConfigVO> getProductLabelLogoAll() {
      Config config = this.baseMapper.getByCode("productLabelLogo");
      if (config != null && !StringUtils.isBlank(config.getValue())) {
         List<LogoConfigVO> logoConfigVOS = null;

         try {
            logoConfigVOS = JSON.parseArray(config.getValue(), LogoConfigVO.class);
         } catch (Exception e) {
            this.log.error("获取产品标签LOGO配置信息失败", e);
         }

         return logoConfigVOS;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public LogoConfigVO uploadProductLabelLogo(MultipartFile file) {
      Attachment attachment = this.attachmentService.uploadFile(file, AttachmentTypeEnum.CONFIG.getType());
      Preconditions.checkArgument(attachment != null, "上传失败");
      List<LogoConfigVO> logoConfigVOS = this.getProductLabelLogoAll();
      Preconditions.checkArgument(logoConfigVOS.size() <= 1, "上传失败，产品标签logo图片上传数量最大为1张");
      LogoConfigVO logoConfigVO = new LogoConfigVO();
      logoConfigVO.setId(attachment.getId());
      logoConfigVO.setPath(this.attachmentService.getById(attachment.getId()).getImageUrl());
      if (CollectionUtils.isNotEmpty(logoConfigVOS)) {
         logoConfigVO.setIsDefault(Boolean.FALSE);
      } else {
         logoConfigVO.setIsDefault(Boolean.TRUE);
         logoConfigVOS = new ArrayList<>();
      }

      logoConfigVOS.add(logoConfigVO);
      this.updateConfig("productLabelLogo", JSON.toJSONString(logoConfigVOS));
      return logoConfigVO;
   }

   @Override
   public Boolean deleteProductLabelLogo(Long id) {
      List<LogoConfigVO> logoConfigs = this.getProductLabelLogoAll();
      List<LogoConfigVO> checkLogo = logoConfigs.stream().filter(logo -> logo.getId().equals(id)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(checkLogo), "删除失败，无logo图片");
      List<LogoConfigVO> logoList = logoConfigs.stream().filter(logo -> !logo.getId().equals(id)).collect(Collectors.toList());
      if (logoList.size() > 0 && checkLogo.get(0).getIsDefault()) {
         logoList.get(0).setIsDefault(true);
      }

      this.attachmentService.deleteFile(id);
      return this.updateConfig("productLabelLogo", JSON.toJSONString(logoList));
   }

   private void failCompensation(CompanyConfigVO companyConfigVO, String expireD, String phone) {
      for (SysSmsRecords smsRecord : this.sysSmsRecordsService.lambdaQuery().eq(SysSmsRecords::getBoolSuccess, false).list()) {
         String template = "";
         Map<String, String> mapParam2 = new HashMap<>();
         mapParam2.put("customer", companyConfigVO.getCompanyName());
         if (SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(smsRecord.getChargingMethod())) {
            template = smsRecord.getDaysRemaining().equals("30日") ? "SMS_472985039" : "SMS_473045044";
            mapParam2.put("expirationTime", smsRecord.getDaysRemaining());
         } else if (SystemChargingMethodEnum.RENTAL_FEE.getType().equals(smsRecord.getChargingMethod())) {
            template = "SMS_473045027";
            mapParam2.put("expirationTime", smsRecord.getDaysRemaining());
         } else if (SystemChargingMethodEnum.PROGRESS_PAYMENT.getType().equals(smsRecord.getChargingMethod())) {
            template = "SMS_473190026";
            mapParam2.put("expirationDate", expireD);
         }

         SmsSendResult result = AliYunSMSUtil.sendMessage(phone, template, mapParam2);
         this.log.debug("发送失败短信已重新补发");
         smsRecord.setAttemptCount(smsRecord.getAttemptCount() + 1);
         smsRecord.setBoolSuccess(result.isBoolSuccess());
         smsRecord.setErrorMessage(result.getErrorMessage());
         smsRecord.setCompensationTime(LocalDateTime.now());
         smsRecord.setUpdateTime(LocalDateTime.now());
         this.sysSmsRecordsService.updateById(smsRecord);
      }
   }

   @Override
   public Integer getCoatingConfigMeasurementManner() {
      Config code = this.baseMapper.getByCode("COATING_CONFIG_MEASUREMENT_MANNER");
      if (code != null && NumberUtils.isDigits(code.getValue())) {
         Integer value = Integer.valueOf(code.getValue());
         if (WageQuotaTypeEnum.isExist(value)) {
            return value;
         }
      }

      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setCoatingConfigMeasurementManner(Integer type) {
      ArrayList<Integer> wageQuotaTypeEnumList = CollUtil.newArrayList(WageQuotaTypeEnum.WEIGHT_PRICE.getType(), WageQuotaTypeEnum.AREA_PRICE.getType());
      Preconditions.checkArgument(wageQuotaTypeEnumList.contains(type), "涂装配置计量方式有误");
      Config config = this.baseMapper.getByCode("COATING_CONFIG_MEASUREMENT_MANNER");
      if (config != null) {
         if (config.getValue() != null && !config.getValue().equals(String.valueOf(type))) {
            if (WageQuotaTypeEnum.WEIGHT_PRICE.getType() == Integer.parseInt(config.getValue())) {
               int count = this.coatingConfigService.count();
               Preconditions.checkArgument(count == 0, "已有涂装配置, 无法修改");
            }

            if (WageQuotaTypeEnum.AREA_PRICE.getType() == Integer.parseInt(config.getValue())) {
               int count = this.buildingCoatingConfigService.count();
               Preconditions.checkArgument(count == 0, "已有涂装配置, 无法修改");
            }
         }

         config.setValue(String.valueOf(type));
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().code("COATING_CONFIG_MEASUREMENT_MANNER").name("工价配置-涂装配置计量方式").value(String.valueOf(type)).build();
         this.baseMapper.insert(config);
      }

      return Boolean.TRUE;
   }

   @Override
   public InventoryConfigurationDTO getListInventoryConfiguration() {
      Config code = this.baseMapper.getByCode("LIST_ERROR_CONFIGURATION");
      return code != null && StringUtils.isNotBlank(code.getValue()) ? JSON.parseObject(code.getValue(), InventoryConfigurationDTO.class) : null;
   }

   @Override
   public Boolean saveInventoryConfiguration(InventoryConfigurationVO configurationVO) {
      Config config = this.baseMapper.getByCode("LIST_ERROR_CONFIGURATION");
      Preconditions.checkArgument(config != null, "操作失败,清单误差配置不存在!");
      config.setValue(JSON.toJSONString(configurationVO));
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public FinanceAmountLimitConfigDTO getFinanceAmountLimitConfig() {
      Config config = this.baseMapper.getByCode("FINANCE_AMOUNT_LIMIT_CONFIG");
      if (config != null && !StringUtils.isBlank(config.getValue())) {
         FinanceAmountLimitConfigDTO configDTO = JSON.parseObject(config.getValue(), FinanceAmountLimitConfigDTO.class);
         configDTO.setBoolAllowOverContractAmount(configDTO.getBoolAllowOverContractAmount() == null || configDTO.getBoolAllowOverContractAmount());
         configDTO.setBoolAllowOverSettleAmount(configDTO.getBoolAllowOverSettleAmount() != null && configDTO.getBoolAllowOverSettleAmount());
         return configDTO;
      } else {
         return FinanceAmountLimitConfigDTO.builder().boolAllowOverContractAmount(true).boolAllowOverSettleAmount(false).build();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setFinanceAmountLimitConfig(FinanceAmountLimitConfigDTO dto) {
      Config config = this.baseMapper.getByCode("FINANCE_AMOUNT_LIMIT_CONFIG");
      if (config != null) {
         config.setValue(JSON.toJSONString(dto));
         config.setName("业财金额额度限制配置");
         config.setCode("FINANCE_AMOUNT_LIMIT_CONFIG");
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().name("业财金额额度限制配置").code("FINANCE_AMOUNT_LIMIT_CONFIG").value(JSON.toJSONString(dto)).build();
         this.baseMapper.insert(config);
      }

      return true;
   }

   @Override
   public FinanceAmountShowConfigDTO getFinanceAmountShowConfig() {
      Config config = this.baseMapper.getByCode("FINANCE_AMOUNT_SHOW_CONFIG");
      return config != null && !StringUtils.isBlank(config.getValue())
         ? JSON.parseObject(config.getValue(), FinanceAmountShowConfigDTO.class)
         : FinanceAmountShowConfigDTO.builder().boolShowUnsettledUncollectedAmount(true).boolShowUnsettledUnpaidAmount(true).build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editFinanceAmountShowConfig(FinanceAmountShowConfigDTO param) {
      String jsonString = JSON.toJSONString(param);
      Config config = this.baseMapper.getByCode("FINANCE_AMOUNT_SHOW_CONFIG");
      if (config != null) {
         config.setName("未结算时,未收款额/未付款额是否显示");
         config.setValue(jsonString);
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().code("FINANCE_AMOUNT_SHOW_CONFIG").name("未结算时,未收款额/未付款额是否显示").value(jsonString).build();
         this.baseMapper.insert(config);
      }

      return true;
   }

   @Override
   public SystemWatermarkConfigDTO getWatermarkConfig() {
      Config config = this.baseMapper.getByCode("SYSTEM_WATERMARK_CONFIG");
      return config != null && !StringUtils.isBlank(config.getValue())
         ? JSON.parseObject(config.getValue(), SystemWatermarkConfigDTO.class)
         : SystemWatermarkConfigDTO.builder()
            .boolEnableWatermark(false)
            .fontSize(BigDecimal.ZERO)
            .spacing(BigDecimal.ZERO)
            .angle(BigDecimal.ZERO)
            .transparency(BigDecimal.ZERO)
            .build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setWatermarkConfig(SystemWatermarkConfigDTO param) {
      if (param.getBoolEnableWatermark()) {
         Preconditions.checkArgument(
            param.getFontSize() != null && param.getFontSize().compareTo(BigDecimal.ZERO) > 0 && param.getFontSize().compareTo(BigDecimal.valueOf(1000L)) < 0,
            "水印字体大小有误!"
         );
         Preconditions.checkArgument(
            param.getSpacing() != null && param.getSpacing().compareTo(BigDecimal.ZERO) > 0 && param.getSpacing().compareTo(BigDecimal.valueOf(1000L)) < 0,
            "水印间隔有误!"
         );
         Preconditions.checkArgument(param.getAngle() != null && param.getAngle().abs().compareTo(BigDecimal.valueOf(360L)) <= 0, "水印倾斜角度有误(-360°~360°)!");
         Preconditions.checkArgument(
            param.getTransparency() != null
               && param.getTransparency().compareTo(BigDecimal.ZERO) >= 0
               && param.getTransparency().compareTo(BigDecimal.ONE) <= 0,
            "水印透明度有误(0~1)!"
         );
      }

      Config config = this.baseMapper.getByCode("SYSTEM_WATERMARK_CONFIG");
      if (config != null) {
         config.setValue(JSON.toJSONString(param));
         config.setName("系统水印配置");
         config.setCode("SYSTEM_WATERMARK_CONFIG");
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().value(JSON.toJSONString(param)).name("系统水印配置").code("SYSTEM_WATERMARK_CONFIG").build();
         this.baseMapper.insert(config);
      }

      return true;
   }

   @Override
   public ContractTechConfigDTO getContractTechConfig() {
      Config config = this.baseMapper.getByCode("PROJECT_CONTRACT_TECH_CONFIG");
      return config != null && !StringUtils.isBlank(config.getValue())
         ? JSON.parseObject(config.getValue(), ContractTechConfigDTO.class)
         : ContractTechConfigDTO.builder().boolRequiredInput(false).build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setContractTechConfig(ContractTechConfigDTO param) {
      Config config = this.baseMapper.getByCode("PROJECT_CONTRACT_TECH_CONFIG");
      if (config != null) {
         config.setValue(JSON.toJSONString(param));
         config.setName("项目合同-技术交底配置");
         config.setCode("PROJECT_CONTRACT_TECH_CONFIG");
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().value(JSON.toJSONString(param)).name("项目合同-技术交底配置").code("PROJECT_CONTRACT_TECH_CONFIG").build();
         this.baseMapper.insert(config);
      }

      return true;
   }

   @Override
   public Integer wageStatisticsDeadlineGet() {
      Config config = this.baseMapper.getByCode("WAGE_STATISTICS_DEADLINE");
      return BeanUtil.isNotEmpty(config) ? Integer.valueOf(config.getValue()) : null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean wageStatisticsDeadlineEdit(Integer deadline) {
      Config config = this.baseMapper.getByCode("WAGE_STATISTICS_DEADLINE");
      if (BeanUtil.isNotEmpty(config)) {
         config.setValue(deadline.toString());
      } else {
         config = Config.builder().code("WAGE_STATISTICS_DEADLINE").name("工价统计截止日期").value(deadline.toString()).build();
      }

      this.saveOrUpdate(config);
      return true;
   }

   @Override
   public Integer getRawMaterialLossCalculationFormula() {
      Config code = this.baseMapper.getByCode("RAW_MATERIAL_LOSS_CALCULATION_FORMULA");
      if (code != null && NumberUtils.isDigits(code.getValue())) {
         Integer value = Integer.valueOf(code.getValue());
         if (RawMaterialLossEnum.isExist(value)) {
            return value;
         }
      }

      return null;
   }

   @Override
   public Boolean updateRawMaterialLossCalculationFormula(Integer rawMaterialLossEnum) {
      Config config = this.baseMapper.getByCode("RAW_MATERIAL_LOSS_CALCULATION_FORMULA");
      if (config != null) {
         config.setValue(String.valueOf(rawMaterialLossEnum));
         this.baseMapper.updateById(config);
      } else {
         config = Config.builder().code("RAW_MATERIAL_LOSS_CALCULATION_FORMULA").name("原料损耗计算公式").value(String.valueOf(rawMaterialLossEnum)).build();
         this.baseMapper.insert(config);
      }

      return Boolean.TRUE;
   }

   @Override
   public Integer getNumericalControlDrawingMatchRange() {
      Config config = this.baseMapper.getByCode("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
      return Integer.valueOf(config.getValue());
   }

   @Transactional
   @Override
   public Boolean updateNumericalControlDrawingMatchRange(NumericalControlDrawingMatchRangeConfigVO configVO) {
      Config config = this.baseMapper.getByCode("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
      if (config == null) {
         config = new Config();
         config.setCode("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
         config.setName("");
         config.setValue(configVO.getMatchRangeEnum().toString());
         return this.baseMapper.insert(config) == 1;
      } else {
         config.setValue(configVO.getMatchRangeEnum().toString());
         this.baseMapper.updateById(config);
         return true;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean nestingTaskSettingEdit(Integer nestingTaskModeEnum) {
      Config config = this.baseMapper.getByCode("NESTING_TASK_SETTING");
      if (BeanUtil.isEmpty(config)) {
         config = Config.builder().code("NESTING_TASK_SETTING").name("套料任务设置").value(nestingTaskModeEnum.toString()).build();
      } else {
         config.setValue(nestingTaskModeEnum.toString());
      }

      this.saveOrUpdate(config);
      return true;
   }

   @Override
   public Integer nestingTaskSettingGet() {
      Config config = this.baseMapper.getByCode("NESTING_TASK_SETTING");
      return BeanUtil.isNotEmpty(config) ? Integer.parseInt(config.getValue()) : NestingTaskModeEnum.MODE_ONE.getType();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<PartDrawingLayerSettingDTO> getPartDrawingLayerSetting() {
      Config config = this.baseMapper.getByCode("PART_DRAWING_LAYER_SETTING");
      if (BeanUtil.isEmpty(config)) {
         List<PartDrawingLayerSettingDTO> initializationList = ListUtil.toList(
            PartDrawingLayerSettingDTO.builder()
               .layerName("POWDER_CONTOUR_MARKING")
               .processMethod(PartDrawingLayerProcessMethodEnum.PROCESS_MARK.getType())
               .objectType(0)
               .build(),
            PartDrawingLayerSettingDTO.builder()
               .layerName("TEXT")
               .processMethod(PartDrawingLayerProcessMethodEnum.PROCESS_NOWORK.getType())
               .objectType(0)
               .build(),
            PartDrawingLayerSettingDTO.builder()
               .layerName("SCRIBE")
               .processMethod(PartDrawingLayerProcessMethodEnum.PROCESS_NOWORK.getType())
               .objectType(0)
               .build()
         );
         config = Config.builder().code("PART_DRAWING_LAYER_SETTING").name("零件图纸加工图层设置").value(JSONObject.toJSONString(initializationList)).build();
         this.save(config);
      }

      return Optional.ofNullable(config.getValue()).map(o -> JSONUtil.toList(o, PartDrawingLayerSettingDTO.class)).orElseGet(Collections::emptyList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editPartDrawingLayerSetting(List<PartDrawingLayerSettingDTO> paramList) {
      if (CollUtil.isNotEmpty(paramList)) {
         Set<String> layerNameSet = new HashSet<>();

         for (PartDrawingLayerSettingDTO dto : paramList) {
            Preconditions.checkArgument(layerNameSet.add(dto.getLayerName()), "图层名称重复: " + dto.getLayerName());
         }
      }

      String value = JSONObject.toJSONString(paramList);
      Config config = this.baseMapper.getByCode("PART_DRAWING_LAYER_SETTING");
      if (BeanUtil.isEmpty(config)) {
         config = Config.builder().code("PART_DRAWING_LAYER_SETTING").name("零件图纸加工图层设置").value(value).build();
      } else {
         config.setValue(value);
      }

      this.saveOrUpdate(config);
      return true;
   }

   @Override
   public PaintThicknessDO getPaintThicknessConfig() {
      Config config = this.getByCode("PAINT_THICKNESS_DETECTION");
      if (config == null) {
         return null;
      }

      PaintThicknessDO paintThicknessDO = null;

      try {
         paintThicknessDO = JSON.parseObject(config.getValue(), PaintThicknessDO.class);
      } catch (Exception e) {
         this.log.error("获取漆膜配置失败", e);
      }

      return paintThicknessDO;
   }

   @Override
   public CappWeldingCraftConfigDTO getCappWeldingCraft() {
      Config config = this.baseMapper.getByCode("CAPP_WELDING_CRAFT");
      if (ObjectUtil.isNotNull(config)) {
         return JSONUtil.toBean(config.getValue(), CappWeldingCraftConfigDTO.class);
      }

      CappWeldingCraftConfigDTO dto = new CappWeldingCraftConfigDTO();
      dto.setUsageMode(CappWeldingCraftUsageModeEnum.INDEPENDENT_MANIFESTATION.getUsageMode());
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCappWeldingCraft(CappWeldingCraftConfigDTO dto) {
      Config config = this.baseMapper.getByCode("CAPP_WELDING_CRAFT");
      if (ObjectUtil.isNull(config)) {
         config = Config.builder().code("CAPP_WELDING_CRAFT").name("焊接工艺配置").value(JSONUtil.toJsonStr(dto)).build();
      } else {
         config.setValue(JSONUtil.toJsonStr(dto));
      }

      return this.saveOrUpdate(config);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean wageConfigEdit(MesWageConfigDTO param) {
      Config config = this.baseMapper.getByCode("WAGE_CONFIG");
      String value = JSONObject.toJSONString(param);
      if (BeanUtil.isNotEmpty(config)) {
         config.setValue(value);
      } else {
         config = Config.builder().code("WAGE_CONFIG").name("工价统计截止日期").value(value).build();
      }

      this.saveOrUpdate(config);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public MesWageConfigDTO wageConfigGet() {
      Config config = this.baseMapper.getByCode("WAGE_CONFIG");
      MesWageConfigDTO dto = new MesWageConfigDTO();
      if (BeanUtil.isEmpty(config)) {
         Integer wageStatisticsDeadline = this.wageStatisticsDeadlineGet();
         if (wageStatisticsDeadline == null) {
            wageStatisticsDeadline = 31;
         }

         dto.setWageStatisticsDeadline(wageStatisticsDeadline);
         dto.setWageDisplayPrecision(2);
      } else {
         dto = JSONUtil.toBean(config.getValue(), MesWageConfigDTO.class);
      }

      return dto;
   }

   @Override
   public SysPasswordPolicyDTO getPasswordPolicy() {
      Config config = this.baseMapper.getByCode("PASSWORD_POLICY");
      if (config == null) {
         String password = "";

         try {
            password = RSAUtils.encryptWithPublicKey(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required"));
         } catch (Exception e) {
            e.printStackTrace();
         }

         SysPasswordPolicyDTO defaultPasswordPolicy = SysPasswordPolicyDTO.builder()
            .containNumbers(Boolean.TRUE)
            .containSpecialCharacters(Boolean.FALSE)
            .containLetter(Boolean.FALSE)
            .minLength(6)
            .loginVerification(Boolean.FALSE)
            .password(password)
            .build();
         String value = JSONObject.toJSONString(defaultPasswordPolicy);
         config = Config.builder().code("PASSWORD_POLICY").name("系统密码策略").value(value).build();
      }

      return JSONObject.parseObject(config.getValue(), SysPasswordPolicyDTO.class);
   }

   @Override
   public Boolean editPasswordPolicy(SysPasswordPolicyDTO param) {
      Config existingPolicy = this.baseMapper.getByCode("PASSWORD_POLICY");
      if ((param.getPassword() == null || param.getPassword().trim().isEmpty()) && existingPolicy != null) {
         param.setPassword(JSONObject.parseObject(existingPolicy.getValue(), SysPasswordPolicyDTO.class).getPassword());
      }
      Preconditions.checkArgument(param.getMinLength() != null, "最小密码长度不能为空！");
      Preconditions.checkArgument(param.getPassword() != null, "默认密码不能为空！");
      Preconditions.checkArgument(param.getLoginVerification() != null, "登录是否校验不能为空！");
      Preconditions.checkArgument(this.hasRuleSetUp(param.getContainNumbers(), param.getContainSpecialCharacters(), param.getContainLetter()), "请设置密码组成规则！");
      Preconditions.checkArgument(param.getMinLength() >= 6 && param.getMinLength() <= 20, "最小密码长度在6~20之间！");
      String password = this.decryptPassword(param.getPassword());
      PasswordPolicyUtil.checkPolicy(password, param, false);
      Config config = this.baseMapper.getByCode("PASSWORD_POLICY");
      if (config == null) {
         config = Config.builder().code("PASSWORD_POLICY").name("系统密码策略").build();
      }

      String value = JSONObject.toJSONString(param);
      config.setValue(value);
      this.saveOrUpdate(config);
      return Boolean.TRUE;
   }

   @Override
   public PrintConfigurationDTO getPrintConfig() {
      Config config = this.baseMapper.getByCode("PRINT_CONFIGURATION");
      return config == null ? null : JSON.parseObject(config.getValue(), PrintConfigurationDTO.class);
   }

   @Override
   public Boolean setPrintConfig(PrintConfigurationDTO dto) {
      return this.updateConfig("PRINT_CONFIGURATION", JSON.toJSONString(dto));
   }

   private String decryptPassword(String password) {
      try {
         return RSAUtils.decryptRSADefault(
            System.getenv("LJAPS_SYSTEM_RSA_PRIVATE_KEY"),
            password
         );
      } catch (Exception e) {
         throw new BusinessException("失败，密码解析错误");
      }
   }

   private Boolean hasRuleSetUp(Boolean... rules) {
      return Arrays.asList(rules).contains(Boolean.TRUE);
   }
}
