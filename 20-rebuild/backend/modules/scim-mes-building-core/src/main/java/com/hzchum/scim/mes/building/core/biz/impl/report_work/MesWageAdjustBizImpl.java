package com.hzchum.scim.mes.building.core.biz.impl.report_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesWageAdjustBiz;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigArtifactConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigAssembleConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMachinePartConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.ArtifactCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleClassificationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.MachinePartCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustListSelectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesArtifactQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesMachinePartQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustListSelectQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigArtifactService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigAssembleService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesWageAdjustMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesWageAdjustBizImpl extends IBizImpl<MesWageAdjustService, MesWageAdjustMapper, MesWageAdjust> implements MesWageAdjustBiz {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private SysStructureClassificationService structureClassificationService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private SysAssembleConfigService assembleConfigService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechMachineHoleRadiusLinkService machineHoleRadiusLinkService;
   @Autowired
   private SysSteelClassificationService steelClassificationService;
   @Autowired
   private MesArtifactQuotaConfigService artifactQuotaConfigService;
   @Autowired
   private MesAssembleQuotaConfigService assembleQuotaConfigService;
   @Autowired
   private MesMachinePartQuotaConfigService machinePartQuotaConfigService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesQuotaConfigArtifactService quotaConfigArtifactService;
   @Autowired
   private MesQuotaConfigAssembleService quotaConfigAssembleService;
   @Autowired
   private MesQuotaConfigMachinePartService quotaConfigMachinePartService;

   @Override
   public PageVO<MesWageAdjustListSelectDTO> listSelect(MesWageAdjustListSelectQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Preconditions.checkArgument(query.getProjectId() != null, "项目不能为空");
      Preconditions.checkArgument(query.getMonomerId() != null, "单体不能为空");
      Preconditions.checkArgument(query.getTypeEnum() != null, "产品类型不能为空");
      List<MesWageAdjustListSelectDTO> list;
      switch (ProductTypeEnum.getEnumByType(query.getTypeEnum())) {
         case ARTIFACT:
            list = this.fetchArtifacts(query);
            break;
         case ASSEMBLE:
            list = this.fetchAssembles(query);
            break;
         case MACHINE_PART:
            list = this.fetchMachineParts(query);
            break;
         default:
            throw new IllegalArgumentException("产品类型错误");
      }

      return new PageVO<>(PageUtils.getPageVO(list, pageNumber, pageSize));
   }

   private List<MesWageAdjustListSelectDTO> fetchArtifacts(MesWageAdjustListSelectQuery query) {
      return this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, query.getProjectId())
               .eq(TechArtifact::getMonomerId, query.getMonomerId())
               .eq(query.getClassId() != null, TechArtifact::getStructureClassId, query.getClassId())
               .like(StrUtil.isNotBlank(query.getSerialNumber()), TechArtifact::getSerialNumber, query.getSerialNumber())
               .like(StrUtil.isNotBlank(query.getSpecification()), TechArtifact::getSpecification, query.getSpecification())
               .like(StrUtil.isNotBlank(query.getMaterial()), TechArtifact::getMaterial, query.getMaterial())
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getSerialNumber))
         .values()
         .stream()
         .map(productList -> {
            MesWageAdjustListSelectDTO dto = new MesWageAdjustListSelectDTO();
            TechArtifact product = productList.get(0);
            int quantity = productList.stream().mapToInt(TechArtifact::getQuantity).sum();
            product.setQuantity(quantity);
            dto.setProduct(BeanUtil.toBean(product, ProductInfo.class));
            return dto;
         })
         .collect(Collectors.toList());
   }

   private List<MesWageAdjustListSelectDTO> fetchAssembles(MesWageAdjustListSelectQuery query) {
      return this.assembleService
         .list(
            Wrappers.lambdaQuery(TechAssemble.class)
               .eq(TechAssemble::getProjectId, query.getProjectId())
               .eq(TechAssemble::getMonomerId, query.getMonomerId())
               .eq(query.getClassId() != null, TechAssemble::getAssembleConfigId, query.getClassId())
               .like(StrUtil.isNotBlank(query.getSerialNumber()), TechAssemble::getSerialNumber, query.getSerialNumber())
               .like(StrUtil.isNotBlank(query.getSpecification()), TechAssemble::getSpecification, query.getSpecification())
               .like(StrUtil.isNotBlank(query.getMaterial()), TechAssemble::getMaterial, query.getMaterial())
         )
         .stream()
         .collect(Collectors.groupingBy(TechAssemble::getSerialNumber))
         .values()
         .stream()
         .map(productList -> {
            MesWageAdjustListSelectDTO dto = new MesWageAdjustListSelectDTO();
            TechAssemble product = productList.get(0);
            int quantity = productList.stream().mapToInt(TechAssemble::getQuantity).sum();
            product.setQuantity(quantity);
            dto.setProduct(BeanUtil.toBean(product, ProductInfo.class));
            return dto;
         })
         .collect(Collectors.toList());
   }

   private List<MesWageAdjustListSelectDTO> fetchMachineParts(MesWageAdjustListSelectQuery query) {
      return this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getProjectId, query.getProjectId())
               .eq(TechMachinePart::getMonomerId, query.getMonomerId())
               .eq(query.getClassId() != null, TechMachinePart::getSteelId, query.getClassId())
               .like(StrUtil.isNotBlank(query.getSerialNumber()), TechMachinePart::getSerialNumber, query.getSerialNumber())
               .like(StrUtil.isNotBlank(query.getSpecification()), TechMachinePart::getSpecification, query.getSpecification())
               .like(StrUtil.isNotBlank(query.getMaterial()), TechMachinePart::getMaterial, query.getMaterial())
         )
         .stream()
         .collect(Collectors.groupingBy(TechMachinePart::getSerialNumber))
         .values()
         .stream()
         .map(productList -> {
            MesWageAdjustListSelectDTO dto = new MesWageAdjustListSelectDTO();
            TechMachinePart product = productList.get(0);
            int quantity = productList.stream().mapToInt(TechMachinePart::getQuantity).sum();
            product.setQuantity(quantity);
            ProductInfo productInfo = BeanUtil.toBean(product, ProductInfo.class, CopyOptions.create().setIgnoreProperties("thick"));
            if (!Objects.equals(product.getSteelPlateTypeEnum(), SteelPlateTypeEnum.SECTIONSTEEL.getType()) && StrUtil.isNotBlank(product.getThick())) {
               productInfo.setThick(new BigDecimal(product.getThick()));
            }
            dto.setProduct(productInfo);
            return dto;
         })
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getArtifactWage(Long workshopId, Long processId, List<Long> artifactIds) {
      List<MesArtifactQuotaConfigDTO> quotaConfigList = this.artifactQuotaConfigService
         .listInfo(MesQuotaConfigQuery.builder().workshopId(workshopId).processId(processId).status(true).build());
      List<TechArtifact> artifactList = this.artifactService.listByIds(artifactIds);
      List<Long> classIds = artifactList.stream().map(TechArtifact::getStructureClassId).distinct().collect(Collectors.toList());
      Map<Long, SysStructureClassification> classMap = this.structureClassificationService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      Map<Long, Integer> machinePartQuantityMap = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.toMap(TechArtifactMachinePartLink::getArtifactId, TechArtifactMachinePartLink::getQuantity, Integer::sum));
      TechArtifact artifact = artifactList.get(0);
      List<String> serialNumbers = artifactList.stream().map(TechArtifact::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, artifact.getProjectId())
               .eq(TechArtifact::getMonomerId, artifact.getMonomerId())
               .in(TechArtifact::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechArtifact::getSerialNumber, TechArtifact::getQuantity, Integer::sum));
      return artifactList.stream()
         .map(
            a -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(a, ProductInfo.class);
               product.setClassId(a.getStructureClassId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysStructureClassification()).getClassificationName());
               product.setQuantity(quantityMap.getOrDefault(a.getSerialNumber(), a.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(a.getId());
               dto.setProductTypeEnum(ProductTypeEnum.ARTIFACT.getType());
               Integer machinePartQuantity = machinePartQuantityMap.get(a.getId());
               MesArtifactQuotaConfigDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getArtifactClassIdList().contains(a.getStructureClassId()))
                  .filter(
                     qc -> {
                        if (qc.getBoolSpecificationClass()) {
                           if (Objects.equals(ArtifactCalculationWayEnum.ARTIFACT_WEIGHT.getType(), qc.getCalculationWay())) {
                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                          qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), a.getNetWeight())) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           } else {
                              return Objects.equals(ArtifactCalculationWayEnum.MACHINE_PART_QUANTITY.getType(), qc.getCalculationWay())
                                 ? qc.getDetailList()
                                    .stream()
                                    .anyMatch(
                                       qcd -> {
                                          MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                             qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                          );
                                          if (MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), machinePartQuantity)) {
                                             qc.setPrice(qcd.getPrice());
                                             return true;
                                          } else {
                                             return false;
                                          }
                                       }
                                    )
                                 : false;
                           }
                        } else {
                           return true;
                        }
                     }
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = ArtifactCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
                  dto.setUnit(unit);
                  dto.setCalculationWay(quotaConfig.getCalculationWay());
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getQuotaNumber());
                  dto.setQuotaPrice(quotaConfig.getPrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getArtifactWageV2(Long workshopId, Long processId, List<Long> artifactIds) {
      MesQuotaConfigConditionQuery query = new MesQuotaConfigConditionQuery();
      query.setWorkshopId(workshopId);
      query.setProcessId(processId);
      List<MesQuotaConfigArtifactDTO> quotaConfigList = this.quotaConfigArtifactService.listInfo(query);
      List<TechArtifact> artifactList = this.artifactService.listByIds(artifactIds);
      List<Long> classIds = artifactList.stream().map(TechArtifact::getStructureClassId).distinct().collect(Collectors.toList());
      Map<Long, SysStructureClassification> classMap = this.structureClassificationService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      Map<Long, Integer> machinePartQuantityMap = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.toMap(TechArtifactMachinePartLink::getArtifactId, TechArtifactMachinePartLink::getQuantity, Integer::sum));
      TechArtifact artifact = artifactList.get(0);
      List<String> serialNumbers = artifactList.stream().map(TechArtifact::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, artifact.getProjectId())
               .eq(TechArtifact::getMonomerId, artifact.getMonomerId())
               .in(TechArtifact::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechArtifact::getSerialNumber, TechArtifact::getQuantity, Integer::sum));
      return artifactList.stream()
         .map(
            a -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(a, ProductInfo.class);
               product.setClassId(a.getStructureClassId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysStructureClassification()).getClassificationName());
               product.setQuantity(quantityMap.getOrDefault(a.getSerialNumber(), a.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(a.getId());
               dto.setProductTypeEnum(ProductTypeEnum.ARTIFACT.getType());
               Integer machinePartQuantity = machinePartQuantityMap.get(a.getId());
               MesQuotaConfigArtifactDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getArtifactClassIdList().contains(a.getStructureClassId()))
                  .filter(
                     qc -> {
                        if (Objects.equals(qc.getQuotaType(), 1)) {
                           return true;
                        } else {
                           return Objects.equals(qc.getQuotaType(), 2)
                              ? qc.getConditionList()
                                 .stream()
                                 .allMatch(
                                    qcc -> {
                                       if (Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.WEIGHT.getType())) {
                                          BigDecimal weight = a.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                                          MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                             qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                          );
                                          return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), weight);
                                       } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.MACHINE_PART_QUANTITY.getType())) {
                                          MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                             qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                          );
                                          return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), machinePartQuantity);
                                       } else {
                                          return Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.CORBEL_QUANTITY.getType())
                                             ? false
                                             : false;
                                       }
                                    }
                                 )
                              : false;
                        }
                     }
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = quotaConfig.getMeasureUnit();
                  dto.setUnit(unit);
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getSerialNumber());
                  dto.setOrganizationInsidePrice(quotaConfig.getOrganizationInsidePrice());
                  dto.setOrganizationOutsidePrice(quotaConfig.getOrganizationOutsidePrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getAssembleWage(Long workshopId, Long processId, List<Long> assembleIds) {
      List<MesAssembleQuotaConfigDTO> quotaConfigList = this.assembleQuotaConfigService
         .listInfo(MesQuotaConfigQuery.builder().workshopId(workshopId).processId(processId).status(true).build());
      List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
      List<Long> classIds = assembleList.stream().map(TechAssemble::getAssembleConfigId).distinct().collect(Collectors.toList());
      Map<Long, SysAssembleConfig> classMap = this.assembleConfigService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
      TechAssemble assemble = assembleList.get(0);
      List<String> serialNumbers = assembleList.stream().map(TechAssemble::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.assembleService
         .list(
            Wrappers.lambdaQuery(TechAssemble.class)
               .eq(TechAssemble::getProjectId, assemble.getProjectId())
               .eq(TechAssemble::getMonomerId, assemble.getMonomerId())
               .in(TechAssemble::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechAssemble::getSerialNumber, TechAssemble::getQuantity, Integer::sum));
      return assembleList.stream()
         .map(
            a -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(a, ProductInfo.class);
               product.setClassId(a.getAssembleConfigId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysAssembleConfig()).getName());
               product.setQuantity(quantityMap.getOrDefault(a.getSerialNumber(), a.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(a.getId());
               dto.setProductTypeEnum(ProductTypeEnum.ASSEMBLE.getType());
               MesAssembleQuotaConfigDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getAssembleClassIdList().contains(a.getAssembleConfigId()))
                  .filter(
                     qc -> {
                        if (qc.getBoolSpecificationClass()) {
                           String[] specList = TechUtils.getSpecList(a.getSpecification());
                           BigDecimal sectionHeight = new BigDecimal(specList[0]);
                           if (Objects.equals(AssembleClassificationWayEnum.SECTION_HEIGHT.getType(), qc.getClassificationWayEnum())) {
                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin sectionHeightRange = MaxAndMin.getMaxAndMin(
                                          qcd.getSectionHeightComparisonOperatorOne(),
                                          qcd.getSectionHeightNumberOne(),
                                          qcd.getSectionHeightComparisonOperatorTwo(),
                                          qcd.getSectionHeightNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(sectionHeightRange.getMin(), sectionHeightRange.getMax(), sectionHeight)) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           }

                           if (Objects.equals(AssembleClassificationWayEnum.SECTION_HEIGHT_AND_WEB_THICKNESS.getType(), qc.getClassificationWayEnum())) {
                              BigDecimal webThickness;
                              if (specList.length >= 3) {
                                 webThickness = new BigDecimal(specList[2]);
                              } else {
                                 webThickness = null;
                              }

                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin sectionHeightRange = MaxAndMin.getMaxAndMin(
                                          qcd.getSectionHeightComparisonOperatorOne(),
                                          qcd.getSectionHeightNumberOne(),
                                          qcd.getSectionHeightComparisonOperatorTwo(),
                                          qcd.getSectionHeightNumberTwo()
                                       );
                                       MaxAndMin webThicknessRange = MaxAndMin.getMaxAndMin(
                                          qcd.getWebThicknessComparisonOperatorOne(),
                                          qcd.getWebThicknessNumberOne(),
                                          qcd.getWebThicknessComparisonOperatorTwo(),
                                          qcd.getWebThicknessNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(sectionHeightRange.getMin(), sectionHeightRange.getMax(), sectionHeight)
                                          && MaxAndMin.isValueInRange(webThicknessRange.getMin(), webThicknessRange.getMax(), webThickness)) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           } else {
                              return false;
                           }
                        } else {
                           return true;
                        }
                     }
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = AssembleCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
                  dto.setUnit(unit);
                  dto.setCalculationWay(quotaConfig.getCalculationWay());
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getQuotaNumber());
                  dto.setQuotaPrice(quotaConfig.getPrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getAssembleWageV2(Long workshopId, Long processId, List<Long> assembleIds) {
      MesQuotaConfigConditionQuery query = new MesQuotaConfigConditionQuery();
      query.setWorkshopId(workshopId);
      query.setProcessId(processId);
      List<MesQuotaConfigAssembleDTO> quotaConfigList = this.quotaConfigAssembleService.listInfo(query);
      List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
      List<Long> classIds = assembleList.stream().map(TechAssemble::getAssembleConfigId).distinct().collect(Collectors.toList());
      Map<Long, SysAssembleConfig> classMap = this.assembleConfigService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
      TechAssemble assemble = assembleList.get(0);
      List<String> serialNumbers = assembleList.stream().map(TechAssemble::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.assembleService
         .list(
            Wrappers.lambdaQuery(TechAssemble.class)
               .eq(TechAssemble::getProjectId, assemble.getProjectId())
               .eq(TechAssemble::getMonomerId, assemble.getMonomerId())
               .in(TechAssemble::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechAssemble::getSerialNumber, TechAssemble::getQuantity, Integer::sum));
      return assembleList.stream()
         .map(
            a -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(a, ProductInfo.class);
               product.setClassId(a.getAssembleConfigId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysAssembleConfig()).getName());
               product.setQuantity(quantityMap.getOrDefault(a.getSerialNumber(), a.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(a.getId());
               dto.setProductTypeEnum(ProductTypeEnum.ASSEMBLE.getType());
               MesQuotaConfigAssembleDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getAssembleClassIdList().contains(a.getAssembleConfigId()))
                  .filter(
                     qc -> Objects.equals(qc.getQuotaType(), 2)
                        ? qc.getConditionList()
                           .stream()
                           .allMatch(
                              qcc -> {
                                 if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.WEIGHT.getType())) {
                                    BigDecimal weight = a.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), weight);
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.SECTION.getType())) {
                                    BigDecimal section = Stream.of(TechUtils.getSpecList(a.getSpecification()))
                                       .map(BigDecimal::new)
                                       .max(BigDecimal::compareTo)
                                       .orElse(null);
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), section);
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.WEB_THICKNESS.getType())) {
                                    BigDecimal webThickness = Stream.of(TechUtils.getSpecList(a.getSpecification()))
                                       .map(BigDecimal::new)
                                       .min(BigDecimal::compareTo)
                                       .orElse(null);
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), webThickness);
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.LENGTH.getType())) {
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), a.getLength());
                                 } else {
                                    return false;
                                 }
                              }
                           )
                        : Objects.equals(qc.getQuotaType(), 1)
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = quotaConfig.getMeasureUnit();
                  dto.setUnit(unit);
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getSerialNumber());
                  dto.setOrganizationInsidePrice(quotaConfig.getOrganizationInsidePrice());
                  dto.setOrganizationOutsidePrice(quotaConfig.getOrganizationOutsidePrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getMachinePartWage(Long workshopId, Long processId, List<Long> machinePartIds) {
      List<MesMachinePartQuotaConfigDTO> quotaConfigList = this.machinePartQuotaConfigService
         .listInfo(MesQuotaConfigQuery.builder().workshopId(workshopId).processId(processId).status(true).build());
      MesBuildingProcess process = this.processService.getById(processId);
      List<TechMachinePart> machinePartList = this.machinePartService.listByIds(machinePartIds);
      List<Long> classIds = machinePartList.stream().map(TechMachinePart::getSteelId).distinct().collect(Collectors.toList());
      Map<Long, SysSteelClassification> classMap = this.steelClassificationService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysSteelClassification::getId, Function.identity()));
      TechMachinePart machinePart = machinePartList.get(0);
      List<String> serialNumbers = machinePartList.stream().map(TechMachinePart::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getProjectId, machinePart.getProjectId())
               .eq(TechMachinePart::getMonomerId, machinePart.getMonomerId())
               .in(TechMachinePart::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getSerialNumber, TechMachinePart::getQuantity, Integer::sum));
      return machinePartList.stream()
         .map(
            mp -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(mp, ProductInfo.class);
               product.setClassId(mp.getSteelId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysSteelClassification()).getName());
               product.setQuantity(quantityMap.getOrDefault(mp.getSerialNumber(), mp.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(mp.getId());
               dto.setProductTypeEnum(ProductTypeEnum.MACHINE_PART.getType());
               MesMachinePartQuotaConfigDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getMachinePartClassIdList().contains(mp.getSteelId()))
                  .filter(
                     qc -> {
                        if (qc.getBoolSpecificationClass()) {
                           if (Objects.equals("钻孔", process.getName())) {
                              TechMachineHoleRadiusLink machineHoleRadius = this.machineHoleRadiusLinkService
                                 .getOne(
                                    Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                                       .eq(TechMachineHoleRadiusLink::getSerialNumber, mp.getSerialNumber())
                                       .eq(TechMachineHoleRadiusLink::getMonomerId, mp.getMonomerId())
                                 );
                              BigDecimal aperture = machineHoleRadius.getRadius();
                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin maxAndMin = MaxAndMin.getMaxAndMin(
                                          qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(maxAndMin.getMin(), maxAndMin.getMax(), aperture)) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           } else if (Objects.equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType(), mp.getProductClassificationEnum())) {
                              BigDecimal thick = new BigDecimal(mp.getThick());
                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin maxAndMin = MaxAndMin.getMaxAndMin(
                                          qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(maxAndMin.getMin(), maxAndMin.getMax(), thick)) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           } else if (Objects.equals(ProductClassificationEnum.SECTION_PRODUCT.getType(), mp.getProductClassificationEnum())) {
                              BigDecimal sectionHeight = new BigDecimal(StrUtil.subAfter(mp.getSpecification(), "*", true));
                              return qc.getDetailList()
                                 .stream()
                                 .anyMatch(
                                    qcd -> {
                                       MaxAndMin maxAndMin = MaxAndMin.getMaxAndMin(
                                          qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                       );
                                       if (MaxAndMin.isValueInRange(maxAndMin.getMin(), maxAndMin.getMax(), sectionHeight)) {
                                          qc.setPrice(qcd.getPrice());
                                          return true;
                                       } else {
                                          return false;
                                       }
                                    }
                                 );
                           } else {
                              return false;
                           }
                        } else {
                           return true;
                        }
                     }
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = MachinePartCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
                  dto.setUnit(unit);
                  dto.setCalculationWay(quotaConfig.getCalculationWay());
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getQuotaNumber());
                  dto.setQuotaPrice(quotaConfig.getPrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesWageAdjustProductDTO> getMachinePartWageV2(Long workshopId, Long processId, List<Long> machinePartIds) {
      MesQuotaConfigConditionQuery query = new MesQuotaConfigConditionQuery();
      query.setWorkshopId(workshopId);
      query.setProcessId(processId);
      List<MesQuotaConfigMachinePartDTO> quotaConfigList = this.quotaConfigMachinePartService.listInfo(query);
      MesBuildingProcess process = this.processService.getById(processId);
      List<TechMachinePart> machinePartList = this.machinePartService.listByIds(machinePartIds);
      List<Long> classIds = machinePartList.stream().map(TechMachinePart::getSteelId).distinct().collect(Collectors.toList());
      Map<Long, SysSteelClassification> classMap = this.steelClassificationService
         .listByIds(classIds)
         .stream()
         .collect(Collectors.toMap(SysSteelClassification::getId, Function.identity()));
      TechMachinePart machinePart = machinePartList.get(0);
      List<String> serialNumbers = machinePartList.stream().map(TechMachinePart::getSerialNumber).distinct().collect(Collectors.toList());
      Map<String, Integer> quantityMap = this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getProjectId, machinePart.getProjectId())
               .eq(TechMachinePart::getMonomerId, machinePart.getMonomerId())
               .in(TechMachinePart::getSerialNumber, serialNumbers)
         )
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getSerialNumber, TechMachinePart::getQuantity, Integer::sum));
      return machinePartList.stream()
         .map(
            mp -> {
               MesWageAdjustProductDTO dto = new MesWageAdjustProductDTO();
               ProductInfo product = BeanUtil.toBean(mp, ProductInfo.class);
               product.setClassId(mp.getSteelId());
               product.setClassName(classMap.getOrDefault(product.getClassId(), new SysSteelClassification()).getName());
               product.setQuantity(quantityMap.getOrDefault(mp.getSerialNumber(), mp.getQuantity()));
               dto.setProduct(product);
               dto.setProductId(mp.getId());
               dto.setProductTypeEnum(ProductTypeEnum.MACHINE_PART.getType());
               MesQuotaConfigMachinePartDTO quotaConfig = quotaConfigList.stream()
                  .filter(qc -> qc.getMachinePartClassIdList().contains(mp.getSteelId()))
                  .filter(
                     qc -> Objects.equals(qc.getQuotaType(), 2)
                        ? qc.getConditionList()
                           .stream()
                           .allMatch(
                              qcc -> {
                                 if (Objects.equals(qcc.getConditionEnum(), QuotaConfigMachinePartConditionEnum.PLATE_THICKNESS.getType())) {
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), new BigDecimal(mp.getThick()));
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigMachinePartConditionEnum.CUTTING_LENGTH.getType())) {
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), mp.getLength());
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigMachinePartConditionEnum.PROFILE_SECTION.getType())) {
                                    BigDecimal section = Stream.of(TechUtils.getSpecList(mp.getSpecification()))
                                       .map(BigDecimal::new)
                                       .max(BigDecimal::compareTo)
                                       .orElse(null);
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), section);
                                 } else {
                                    return false;
                                 }
                              }
                           )
                        : Objects.equals(qc.getQuotaType(), 1)
                  )
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  String unit = quotaConfig.getMeasureUnit();
                  dto.setUnit(unit);
                  dto.setQuotaConfigId(quotaConfig.getId());
                  dto.setQuotaNumber(quotaConfig.getSerialNumber());
                  dto.setOrganizationInsidePrice(quotaConfig.getOrganizationInsidePrice());
                  dto.setOrganizationOutsidePrice(quotaConfig.getOrganizationOutsidePrice());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean initiateApproval(MesWageAdjustParam param) {
      return this.baseService.initiateApprovalV2(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(MesWageAdjustApprovalParam param) {
      return this.baseService.approvalV2(param);
   }

   @Override
   public PageVO<MesWageAdjustDTO> pageInfo(MesWageAdjustQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesWageAdjustDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public MesWageAdjustDTO detailById(Long id) {
      return this.baseService.detailById(id);
   }

   @Override
   public Boolean revocation(Long id) {
      return this.baseService.revocation(id);
   }
}
