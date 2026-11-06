package com.hzchum.scim.mes.building.core.service.impl.report_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.ArtifactCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleClassificationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.MachinePartCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamWageSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesArtifactQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesMachinePartQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkApprovedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustProductQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesReportWorkApprovedService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustProductService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustService;
import com.hzchum.scim.mes.building.core.api.service.temp_work.MesTempWorkService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesReportWorkApprovedMapper;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesReportWorkApprovedServiceImpl extends ServiceImpl<MesReportWorkApprovedMapper, MesReportWorkApproved> implements MesReportWorkApprovedService {
   @Autowired
   MesWageAdjustService wageAdjustService;
   @Autowired
   private MesArtifactQuotaConfigService artifactQuotaConfigService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesAssembleQuotaConfigService assembleQuotaConfigService;
   @Autowired
   private MesMachinePartQuotaConfigService machinePartQuotaConfigService;
   @Autowired
   private MesWageAdjustProductService wageAdjustProductService;
   @Autowired
   private TechMachineHoleRadiusLinkService machineHoleRadiusLinkService;
   @Autowired
   private MesTempWorkService tempWorkService;
   @Autowired
   private TechDrawingService drawingService;

   @Override
   public List<MesReportWorkUnapprovedDTO> unapprovedList(MesReportWorkUnapprovedQuery query) {
      Preconditions.checkArgument(query.getProductTypeEnum() != null, "产品类型不能为空");
      Preconditions.checkArgument(
         ProductTypeEnum.isExist(
            query.getProductTypeEnum() & (ProductTypeEnum.ARTIFACT.getType() | ProductTypeEnum.ASSEMBLE.getType() | ProductTypeEnum.MACHINE_PART.getType())
         ),
         "产品类型不合法"
      );
      List<MesReportWorkUnapprovedDTO> list = this.baseMapper.unapprovedList(query);
      if (CollUtil.isNotEmpty(list)) {
         List<String> productSerialNumberAndMonomerIds = list.stream()
            .map(i -> i.getProduct().getSerialNumber() + "&" + i.getMonomer().getId())
            .distinct()
            .collect(Collectors.toList());
         LambdaQueryWrapper<TechDrawing> tdqw = (LambdaQueryWrapper<TechDrawing>)(new LambdaQueryWrapper<TechDrawing>()
               .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
            .eq(TechDrawing::getProductType, query.getProductTypeEnum());
         tdqw.and(
            tdq -> productSerialNumberAndMonomerIds.forEach(
               i -> {
                  List<String> serialNumberAndMonomerId = StrUtil.split(i, "&");
                  tdq.or(
                     w -> {
                        LambdaQueryWrapper var10000 = (w.eq(
                              TechDrawing::getSerialNumber, serialNumberAndMonomerId.get(0)
                           ))
                           .eq(TechDrawing::getMonomerId, serialNumberAndMonomerId.get(1));
                     }
                  );
               }
            )
         );
         Map<String, List<TechDrawing>> drawingListMap = this.drawingService
            .list(tdqw)
            .stream()
            .collect(Collectors.groupingBy(td -> td.getSerialNumber() + "&" + td.getMonomerId()));
         ProductTypeEnum productTypeEnum = ProductTypeEnum.getEnumByType(query.getProductTypeEnum());
         switch (productTypeEnum) {
            case ARTIFACT:
               list = this.artifactHandle(list, drawingListMap);
               break;
            case ASSEMBLE:
               list = this.assembleHandle(list, drawingListMap);
               break;
            case MACHINE_PART:
               list = this.machinePartHandle(list, drawingListMap);
         }
      }

      return list;
   }

   private List<MesReportWorkUnapprovedDTO> machinePartHandle(List<MesReportWorkUnapprovedDTO> list, Map<String, List<TechDrawing>> drawingListMap) {
      List<MesMachinePartQuotaConfigDTO> machinePartQuotaConfigList = this.machinePartQuotaConfigService
         .listInfo(MesQuotaConfigQuery.builder().status(true).build());
      List<String> productSerialNumbers = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.MACHINE_PART.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(productSerialNumbers)
               .build()
         );
      ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
      List<CompletableFuture<MesReportWorkUnapprovedDTO>> futures = list.stream()
         .map(
            i -> CompletableFuture.supplyAsync(
               () -> this.machinePartSingleHandle(drawingListMap, i, machinePartQuotaConfigList, wageAdjustProductList), executorService
            )
         )
         .collect(Collectors.toList());
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
   }

   private MesReportWorkUnapprovedDTO machinePartSingleHandle(
      Map<String, List<TechDrawing>> drawingListMap,
      MesReportWorkUnapprovedDTO i,
      List<MesMachinePartQuotaConfigDTO> machinePartQuotaConfigList,
      List<MesWageAdjustProductDTO> wageAdjustProductList
   ) {
      List<MesMachinePartQuotaConfigDTO> currentQuotaConfigList = BeanUtil.copyToList(machinePartQuotaConfigList, MesMachinePartQuotaConfigDTO.class);
      if (CollUtil.isNotEmpty(drawingListMap)) {
         List<TechDrawing> drawingList = drawingListMap.get(i.getProduct().getSerialNumber() + "&" + i.getMonomer().getId());
         if (CollUtil.isNotEmpty(drawingList)) {
            i.setDrawingNumbers(drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
            i.setDrawingAndSerialNumber(
               drawingList.stream()
                  .map(drawing -> com.hzchum.pangu.common.util.BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                  .collect(Collectors.toList())
            );
         }
      }

      MesMachinePartQuotaConfigDTO quotaConfig = currentQuotaConfigList.stream()
         .filter(
            qc -> qc.getWorkshopIdList().contains(i.getWorkshop().getId())
               && Objects.equals(qc.getMachinePartType(), i.getProduct().getProductClassificationEnum())
               && qc.getMachinePartClassIdList().contains(i.getProduct().getClassId())
               && Objects.equals(qc.getProcessId(), i.getProcess().getId())
         )
         .filter(
            qc -> {
               if (Objects.equals(ProcessTypeEnum.DRILL_HOLE.getType(), i.getProcessType())) {
                  if (Objects.equals(ProcessTypeEnum.DRILL_HOLE.getType(), qc.getProcessType())) {
                     if (qc.getBoolSpecificationClass()) {
                        StringBuilder defineType = new StringBuilder();
                        return qc.getDetailList()
                           .stream()
                           .anyMatch(
                              qcd -> {
                                 List<TechMachineHoleRadiusLink> machineHoleRadiusList = this.machineHoleRadiusLinkService
                                    .list(
                                       Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                                          .eq(TechMachineHoleRadiusLink::getSerialNumber, i.getProduct().getSerialNumber())
                                          .eq(TechMachineHoleRadiusLink::getMonomerId, i.getProduct().getMonomerId())
                                    );
                                 MaxAndMin maxAndMin = MaxAndMin.getMaxAndMin(
                                    qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                 );
                                 if (machineHoleRadiusList.stream()
                                    .anyMatch(
                                       machineHoleRadius -> MaxAndMin.isValueInRange(maxAndMin.getMin(), maxAndMin.getMax(), machineHoleRadius.getRadius())
                                    )) {
                                    qc.setPrice(qcd.getPrice());
                                    String rangeDescription = MaxAndMin.getRangeDescription(
                                       qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                                    );
                                    if (StrUtil.isBlank(defineType.toString())) {
                                       defineType.append("孔径: ").append(rangeDescription);
                                    }

                                    i.setDefineType(defineType.toString());
                                    return true;
                                 } else {
                                    return false;
                                 }
                              }
                           );
                     } else {
                        return true;
                     }
                  } else {
                     return false;
                  }
               } else if (qc.getBoolSpecificationClass()) {
                  StringBuilder defineType = new StringBuilder();
                  return qc.getDetailList()
                     .stream()
                     .anyMatch(
                        qcd -> {
                           BigDecimal comparisonValue = null;
                           if (Objects.equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType(), i.getProduct().getProductClassificationEnum())) {
                              comparisonValue = i.getProduct().getThick();
                              if (StrUtil.isBlank(defineType.toString())) {
                                 defineType.append("板厚: ");
                              }
                           }

                           if (Objects.equals(ProductClassificationEnum.SECTION_PRODUCT.getType(), i.getProduct().getProductClassificationEnum())) {
                              comparisonValue = new BigDecimal(StrUtil.subAfter(i.getProduct().getSpecification(), "*", true));
                              if (StrUtil.isBlank(defineType.toString())) {
                                 defineType.append("截面: ");
                              }
                           }

                           MaxAndMin maxAndMin = MaxAndMin.getMaxAndMin(
                              qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                           );
                           if (MaxAndMin.isValueInRange(maxAndMin.getMin(), maxAndMin.getMax(), comparisonValue)) {
                              qc.setPrice(qcd.getPrice());
                              String rangeDescription = MaxAndMin.getRangeDescription(
                                 qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                              );
                              defineType.append(rangeDescription);
                              i.setDefineType(defineType.toString());
                              return true;
                           } else {
                              return false;
                           }
                        }
                     );
               } else {
                  return true;
               }
            }
         )
         .findFirst()
         .orElse(null);
      if (quotaConfig != null) {
         String unit = MachinePartCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
         i.setUnit(unit);
         i.setPrice(quotaConfig.getPrice());
         i.setQuotaConfigId(quotaConfig.getId());
         i.setQuotaConfigNumber(quotaConfig.getQuotaNumber());
         i.setCalculationWay(quotaConfig.getCalculationWay());
         if (Objects.equals(MachinePartCalculationWayEnum.MACHINE_PART_QUANTITY.getType(), quotaConfig.getCalculationWay())) {
            i.setAccountingQuantity(i.getInspectionQuantity());
         }

         if (Objects.equals(MachinePartCalculationWayEnum.MACHINE_PART_WEIGHT.getType(), quotaConfig.getCalculationWay())
            && i.getProduct().getNetWeight() != null) {
            i.setAccountingQuantity(i.getInspectionQuantity().multiply(i.getProduct().getNetWeight().divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP)));
         }

         if (Objects.equals(MachinePartCalculationWayEnum.MACHINE_PART_LENGTH.getType(), quotaConfig.getCalculationWay()) && i.getProduct().getLength() != null
            )
          {
            i.setAccountingQuantity(i.getInspectionQuantity().multiply(i.getProduct().getLength().divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP)));
         }

         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      MesWageAdjustProduct wageAdjustProduct = wageAdjustProductList.stream()
         .filter(
            wap -> Objects.equals(wap.getWorkshopId(), i.getWorkshop().getId())
               && Objects.equals(wap.getProcessId(), i.getProcess().getId())
               && (CollUtil.isEmpty(wap.getTeamIdList()) || wap.getTeamIdList().contains(i.getTeam().getId()))
               && Objects.equals(wap.getProjectId(), i.getProject().getId())
               && Objects.equals(wap.getMonomerId(), i.getMonomer().getId())
               && Objects.equals(wap.getProductSerialNumber(), i.getProduct().getSerialNumber())
         )
         .findFirst()
         .orElse(null);
      if (BeanUtil.isNotEmpty(wageAdjustProduct)) {
         i.setUnit(wageAdjustProduct.getUnit());
         i.setPrice(wageAdjustProduct.getNewPrice());
         i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
         i.setQuotaConfigNumber("修" + wageAdjustProduct.getQuotaNumber());
         i.setCalculationWay(wageAdjustProduct.getCalculationWay());
         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      return i;
   }

   private List<MesReportWorkUnapprovedDTO> assembleHandle(List<MesReportWorkUnapprovedDTO> list, Map<String, List<TechDrawing>> drawingListMap) {
      List<MesAssembleQuotaConfigDTO> assembleQuotaConfigList = this.assembleQuotaConfigService.listInfo(MesQuotaConfigQuery.builder().status(true).build());
      List<String> productSerialNumbers = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.ASSEMBLE.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(productSerialNumbers)
               .build()
         );
      ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
      List<CompletableFuture<MesReportWorkUnapprovedDTO>> futures = list.stream()
         .map(
            i -> CompletableFuture.supplyAsync(
               () -> this.assembleSingleHandle(drawingListMap, i, assembleQuotaConfigList, wageAdjustProductList), executorService
            )
         )
         .collect(Collectors.toList());
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
   }

   private MesReportWorkUnapprovedDTO assembleSingleHandle(
      Map<String, List<TechDrawing>> drawingListMap,
      MesReportWorkUnapprovedDTO i,
      List<MesAssembleQuotaConfigDTO> assembleQuotaConfigList,
      List<MesWageAdjustProductDTO> wageAdjustProductList
   ) {
      List<MesAssembleQuotaConfigDTO> currentQuotaConfigList = BeanUtil.copyToList(assembleQuotaConfigList, MesAssembleQuotaConfigDTO.class);
      if (CollUtil.isNotEmpty(drawingListMap)) {
         List<TechDrawing> drawingList = drawingListMap.get(i.getProduct().getSerialNumber() + "&" + i.getMonomer().getId());
         if (CollUtil.isNotEmpty(drawingList)) {
            i.setDrawingNumbers(drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
            i.setDrawingAndSerialNumber(
               drawingList.stream()
                  .map(drawing -> com.hzchum.pangu.common.util.BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                  .collect(Collectors.toList())
            );
         }
      }

      MesAssembleQuotaConfigDTO quotaConfig = currentQuotaConfigList.stream()
         .filter(
            qc -> qc.getWorkshopIdList().contains(i.getWorkshop().getId())
               && qc.getAssembleClassIdList().contains(i.getProduct().getClassId())
               && Objects.equals(qc.getProcessId(), i.getProcess().getId())
         )
         .filter(
            qc -> {
               if (qc.getBoolSpecificationClass()) {
                  List<BigDecimal> specList = Convert.toList(BigDecimal.class, TechUtils.getSpecList(i.getProduct().getSpecification()))
                     .stream()
                     .sorted()
                     .collect(Collectors.toList());
                  BigDecimal sectionHeight = specList.get(specList.size() - 1);
                  BigDecimal webThickness = specList.get(0);
                  Integer classificationWayEnum = qc.getClassificationWayEnum();
                  StringBuilder defineType = new StringBuilder();
                  return qc.getDetailList()
                     .stream()
                     .anyMatch(
                        qcd -> {
                           boolean isInRange = false;
                           MaxAndMin sectionHeightRange = MaxAndMin.getMaxAndMin(
                              qcd.getSectionHeightComparisonOperatorOne(),
                              qcd.getSectionHeightNumberOne(),
                              qcd.getSectionHeightComparisonOperatorTwo(),
                              qcd.getSectionHeightNumberTwo()
                           );
                           if (Objects.equals(AssembleClassificationWayEnum.SECTION_HEIGHT.getType(), classificationWayEnum)) {
                              isInRange = MaxAndMin.isValueInRange(sectionHeightRange.getMin(), sectionHeightRange.getMax(), sectionHeight);
                           }

                           if (Objects.equals(AssembleClassificationWayEnum.SECTION_HEIGHT_AND_WEB_THICKNESS.getType(), classificationWayEnum)) {
                              MaxAndMin webThicknessRange = MaxAndMin.getMaxAndMin(
                                 qcd.getWebThicknessComparisonOperatorOne(),
                                 qcd.getWebThicknessNumberOne(),
                                 qcd.getWebThicknessComparisonOperatorTwo(),
                                 qcd.getWebThicknessNumberTwo()
                              );
                              isInRange = MaxAndMin.isValueInRange(sectionHeightRange.getMin(), sectionHeightRange.getMax(), sectionHeight)
                                 && MaxAndMin.isValueInRange(webThicknessRange.getMin(), webThicknessRange.getMax(), webThickness);
                           }

                           if (isInRange) {
                              qc.setPrice(qcd.getPrice());
                              String sectionHeightRangeDescription = MaxAndMin.getRangeDescription(
                                 qcd.getSectionHeightComparisonOperatorOne(),
                                 qcd.getSectionHeightNumberOne(),
                                 qcd.getSectionHeightComparisonOperatorTwo(),
                                 qcd.getSectionHeightNumberTwo()
                              );
                              String webThicknessRangeDescription = MaxAndMin.getRangeDescription(
                                 qcd.getWebThicknessComparisonOperatorOne(),
                                 qcd.getWebThicknessNumberOne(),
                                 qcd.getWebThicknessComparisonOperatorTwo(),
                                 qcd.getWebThicknessNumberTwo()
                              );
                              if (StrUtil.isNotBlank(sectionHeightRangeDescription)) {
                                 defineType.append("截面高度: ").append(sectionHeightRangeDescription).append(" ");
                              }

                              if (StrUtil.isNotBlank(webThicknessRangeDescription)) {
                                 defineType.append("腹板厚度: ").append(webThicknessRangeDescription).append(" ");
                              }

                              i.setDefineType(defineType.toString());
                              return true;
                           } else {
                              return false;
                           }
                        }
                     );
               } else {
                  return true;
               }
            }
         )
         .findFirst()
         .orElse(null);
      if (quotaConfig != null) {
         String unit = AssembleCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
         i.setUnit(unit);
         i.setPrice(quotaConfig.getPrice());
         i.setQuotaConfigId(quotaConfig.getId());
         i.setQuotaConfigNumber(quotaConfig.getQuotaNumber());
         i.setCalculationWay(quotaConfig.getCalculationWay());
         if (Objects.equals(AssembleCalculationWayEnum.WEIGHT.getType(), quotaConfig.getCalculationWay()) && i.getProduct().getNetWeight() != null) {
            i.setAccountingQuantity(i.getInspectionQuantity().multiply(i.getProduct().getNetWeight().divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP)));
         }

         if (Objects.equals(AssembleCalculationWayEnum.LENGTH.getType(), quotaConfig.getCalculationWay()) && i.getProduct().getLength() != null) {
            i.setAccountingQuantity(i.getInspectionQuantity().multiply(i.getProduct().getLength().divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP)));
         }

         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      MesWageAdjustProduct wageAdjustProduct = wageAdjustProductList.stream()
         .filter(
            wap -> Objects.equals(wap.getWorkshopId(), i.getWorkshop().getId())
               && Objects.equals(wap.getProcessId(), i.getProcess().getId())
               && (CollUtil.isEmpty(wap.getTeamIdList()) || wap.getTeamIdList().contains(i.getTeam().getId()))
               && Objects.equals(wap.getProjectId(), i.getProject().getId())
               && Objects.equals(wap.getMonomerId(), i.getMonomer().getId())
               && Objects.equals(wap.getProductSerialNumber(), i.getProduct().getSerialNumber())
         )
         .findFirst()
         .orElse(null);
      if (BeanUtil.isNotEmpty(wageAdjustProduct)) {
         i.setUnit(wageAdjustProduct.getUnit());
         i.setPrice(wageAdjustProduct.getNewPrice());
         i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
         i.setQuotaConfigNumber("修" + wageAdjustProduct.getQuotaNumber());
         i.setCalculationWay(wageAdjustProduct.getCalculationWay());
         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      return i;
   }

   private List<MesReportWorkUnapprovedDTO> artifactHandle(List<MesReportWorkUnapprovedDTO> list, Map<String, List<TechDrawing>> drawingListMap) {
      List<Long> artifactIds = list.stream().map(i -> i.getProduct().getId()).distinct().collect(Collectors.toList());
      List<MesArtifactQuotaConfigDTO> artifactQuotaConfigList = this.artifactQuotaConfigService.listInfo(MesQuotaConfigQuery.builder().status(true).build());
      Map<Long, Integer> machinePartQuantityMap = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.toMap(TechArtifactMachinePartLink::getArtifactId, TechArtifactMachinePartLink::getQuantity, Integer::sum));
      List<String> productSerialNumbers = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.ARTIFACT.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(productSerialNumbers)
               .build()
         );
      ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
      List<CompletableFuture<MesReportWorkUnapprovedDTO>> futures = list.stream()
         .map(
            i -> CompletableFuture.supplyAsync(
               () -> this.artifactSingleHandle(drawingListMap, i, machinePartQuantityMap, artifactQuotaConfigList, wageAdjustProductList), executorService
            )
         )
         .collect(Collectors.toList());
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
   }

   private MesReportWorkUnapprovedDTO artifactSingleHandle(
      Map<String, List<TechDrawing>> drawingListMap,
      MesReportWorkUnapprovedDTO i,
      Map<Long, Integer> machinePartQuantityMap,
      List<MesArtifactQuotaConfigDTO> artifactQuotaConfigList,
      List<MesWageAdjustProductDTO> wageAdjustProductList
   ) {
      List<MesArtifactQuotaConfigDTO> currentQuotaConfigList = BeanUtil.copyToList(artifactQuotaConfigList, MesArtifactQuotaConfigDTO.class);
      if (CollUtil.isNotEmpty(drawingListMap)) {
         List<TechDrawing> drawingList = drawingListMap.get(i.getProduct().getSerialNumber() + "&" + i.getMonomer().getId());
         if (CollUtil.isNotEmpty(drawingList)) {
            i.setDrawingNumbers(drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
            i.setDrawingAndSerialNumber(
               drawingList.stream()
                  .map(drawing -> com.hzchum.pangu.common.util.BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                  .collect(Collectors.toList())
            );
         }
      }

      Integer machinePartQuantity = machinePartQuantityMap.getOrDefault(i.getProduct().getId(), 0);
      MesArtifactQuotaConfigDTO quotaConfig = currentQuotaConfigList.stream()
         .filter(
            qc -> qc.getWorkshopIdList().contains(i.getWorkshop().getId())
               && qc.getArtifactClassIdList().contains(i.getProduct().getClassId())
               && Objects.equals(qc.getProcessId(), i.getProcess().getId())
         )
         .filter(
            qc -> {
               if (qc.getBoolSpecificationClass()) {
                  Integer calculationWay = qc.getCalculationWay();
                  StringBuilder defineType = new StringBuilder();
                  return qc.getDetailList()
                     .stream()
                     .anyMatch(
                        qcd -> {
                           MaxAndMin mam = MaxAndMin.getMaxAndMin(
                              qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                           );
                           boolean isInRange = false;
                           if (Objects.equals(ArtifactCalculationWayEnum.ARTIFACT_WEIGHT.getType(), calculationWay)) {
                              if (StrUtil.isBlank(defineType.toString())) {
                                 defineType.append("重量: ");
                              }

                              isInRange = MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), i.getProduct().getNetWeight());
                           } else if (Objects.equals(ArtifactCalculationWayEnum.MACHINE_PART_QUANTITY.getType(), calculationWay)) {
                              if (StrUtil.isBlank(defineType.toString())) {
                                 defineType.append("零件数量: ");
                              }

                              isInRange = MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), machinePartQuantity);
                           }

                           if (isInRange) {
                              qc.setPrice(qcd.getPrice());
                              String rangeDescription = MaxAndMin.getRangeDescription(
                                 qcd.getComparisonOperatorOne(), qcd.getNumberOne(), qcd.getComparisonOperatorTwo(), qcd.getNumberTwo()
                              );
                              defineType.append(rangeDescription);
                              i.setDefineType(defineType.toString());
                              return true;
                           } else {
                              return false;
                           }
                        }
                     );
               } else {
                  return true;
               }
            }
         )
         .findFirst()
         .orElse(null);
      if (quotaConfig != null) {
         String unit = ArtifactCalculationWayEnum.getUnitByType(quotaConfig.getCalculationWay());
         i.setUnit(unit);
         i.setPrice(quotaConfig.getPrice());
         i.setQuotaConfigId(quotaConfig.getId());
         i.setQuotaConfigNumber(quotaConfig.getQuotaNumber());
         i.setCalculationWay(quotaConfig.getCalculationWay());
         if (Objects.equals(ArtifactCalculationWayEnum.ARTIFACT_WEIGHT.getType(), quotaConfig.getCalculationWay()) && i.getProduct().getNetWeight() != null) {
            i.setAccountingQuantity(i.getInspectionQuantity().multiply(i.getProduct().getNetWeight().divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP)));
         }

         if (Objects.equals(ArtifactCalculationWayEnum.MACHINE_PART_QUANTITY.getType(), quotaConfig.getCalculationWay()) && machinePartQuantity != null) {
            i.setAccountingQuantity(i.getInspectionQuantity());
         }

         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      MesWageAdjustProduct wageAdjustProduct = wageAdjustProductList.stream()
         .filter(
            wap -> Objects.equals(wap.getWorkshopId(), i.getWorkshop().getId())
               && Objects.equals(wap.getProcessId(), i.getProcess().getId())
               && (CollUtil.isEmpty(wap.getTeamIdList()) || wap.getTeamIdList().contains(i.getTeam().getId()))
               && Objects.equals(wap.getProjectId(), i.getProject().getId())
               && Objects.equals(wap.getMonomerId(), i.getMonomer().getId())
               && Objects.equals(wap.getProductSerialNumber(), i.getProduct().getSerialNumber())
         )
         .findFirst()
         .orElse(null);
      if (BeanUtil.isNotEmpty(wageAdjustProduct)) {
         i.setUnit(wageAdjustProduct.getUnit());
         i.setPrice(wageAdjustProduct.getNewPrice());
         i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
         i.setQuotaConfigNumber("修" + wageAdjustProduct.getQuotaNumber());
         i.setCalculationWay(wageAdjustProduct.getCalculationWay());
         if (i.getPrice() != null && i.getAccountingQuantity() != null) {
            i.setTotalPrice(i.getPrice().multiply(i.getAccountingQuantity()));
         }
      }

      return i;
   }

   @Override
   public Map<String, Object> statistics(Integer year) {
      Map<String, Object> resultMap = new HashMap<>();
      BigDecimal cumulativeWeight = this.baseMapper.cumulativeWeight(year);
      resultMap.put("cumulativeWeight", cumulativeWeight);
      BigDecimal approvedWeight = this.baseMapper.approvedWeight(year);
      resultMap.put("approvedWeight", approvedWeight);
      Integer unapprovedCount = this.baseMapper.unapprovedCount(year);
      resultMap.put("unapprovedCount", unapprovedCount);
      BigDecimal artifactWage = this.unapprovedList(
            MesReportWorkUnapprovedQuery.builder().year(year).productTypeEnum(ProductTypeEnum.ARTIFACT.getType()).build()
         )
         .stream()
         .map(MesReportWorkUnapprovedDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleWage = this.unapprovedList(
            MesReportWorkUnapprovedQuery.builder().year(year).productTypeEnum(ProductTypeEnum.ASSEMBLE.getType()).build()
         )
         .stream()
         .map(MesReportWorkUnapprovedDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal machinePartWage = this.unapprovedList(
            MesReportWorkUnapprovedQuery.builder().year(year).productTypeEnum(ProductTypeEnum.MACHINE_PART.getType()).build()
         )
         .stream()
         .map(MesReportWorkUnapprovedDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalWage = artifactWage.add(assembleWage).add(machinePartWage);
      resultMap.put("totalWage", totalWage);
      return resultMap;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approved(List<MesReportWorkApprovedParam> params) {
      LocalDateTime approvalTime = LocalDateTime.now();
      Long approvalUserId = UserUtil.getCurrentUserId();
      List<MesReportWorkApproved> reportWorkApprovedList = BeanUtil.copyToList(params, MesReportWorkApproved.class);
      reportWorkApprovedList.forEach(i -> {
         i.setApprovalTime(approvalTime);
         i.setApprovalUserId(approvalUserId);
      });
      this.saveBatch(reportWorkApprovedList);
      return true;
   }

   @Override
   public List<MesTeamWageSummaryDTO> teamWageSummary(MesTeamWageSummaryQuery query) {
      List<MesTeamWageSummaryDTO> list = this.baseMapper.teamWageSummary(query);
      if (CollUtil.isNotEmpty(list)) {
         list.forEach(i -> {
            if (i.getProductionQuantity().compareTo(BigDecimal.ZERO) != 0) {
               i.setAverageWage(i.getWage().divide(i.getProductionQuantity(), 8, RoundingMode.HALF_UP));
            }
         });
      }

      return list;
   }

   @Override
   public List<MesTeamProductionDTO> teamProduction(MesTeamWageSummaryQuery query) {
      return this.baseMapper.teamProduction(query);
   }
}
