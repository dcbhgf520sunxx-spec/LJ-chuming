package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigArtifactConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigAssembleConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMachinePartConditionEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMeasureUnitEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraftDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassedProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifact;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalPassedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalTeamReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCoatingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustProductQuery;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintingCraftService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigArtifactService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigAssembleService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigCoatingService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigEnclosureService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustProductService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesProductionReportingApprovalPassedMapper;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesProductionReportingApprovalPassedServiceImpl
   extends ServiceImpl<MesProductionReportingApprovalPassedMapper, MesProductionReportingApprovalPassed>
   implements MesProductionReportingApprovalPassedService {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesQuotaConfigArtifactService quotaConfigArtifactService;
   @Autowired
   private MesQuotaConfigCoatingService quotaConfigCoatingService;
   @Autowired
   private MesQuotaConfigAssembleService quotaConfigAssembleService;
   @Autowired
   private MesQuotaConfigMachinePartService quotaConfigMachinePartService;
   @Autowired
   private MesQuotaConfigEnclosureService quotaConfigEnclosureService;
   @Autowired
   private InitializationService service;
   @Autowired
   private Validator validator;
   @Autowired
   private MesProductionReportingApprovalPassedProduceTeamReportService subService;
   @Resource
   private TechDrawingService drawingService;
   @Autowired
   private MesWageAdjustProductService wageAdjustProductService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesPaintingCraftService paintingCraftService;
   @Autowired
   private ConfigService configService;

   @Override
   public List<MesProductionReportingApprovalDateDTO> dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getYearMonth() != null, "年月不能为空");
      LocalDate startDate = query.getYearMonth().with(TemporalAdjusters.firstDayOfMonth());
      LocalDate endDate = query.getYearMonth().with(TemporalAdjusters.lastDayOfMonth());
      List<LocalDate> dateList = Stream.<LocalDate>iterate(startDate, date -> date.plusDays(1L))
         .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1L)
         .collect(Collectors.toList());
      query.setDateList(dateList);
      return this.baseMapper.dateExistsUnapprovedDataList(query);
   }

   @Override
   public List<MesProductionReportingApprovalDateDTO> dateExistsApprovedDataList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getYearMonth() != null, "年月不能为空");
      LocalDate startDate = query.getYearMonth().with(TemporalAdjusters.firstDayOfMonth());
      LocalDate endDate = query.getYearMonth().with(TemporalAdjusters.lastDayOfMonth());
      List<LocalDate> dateList = Stream.<LocalDate>iterate(startDate, date -> date.plusDays(1L))
         .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1L)
         .collect(Collectors.toList());
      query.setDateList(dateList);
      return this.baseMapper.dateExistsApprovedDataList(query);
   }

   @Override
   public List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportSummaryList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getDate() != null, "日期不能为空");
      return this.baseMapper.teamReportSummaryList(query);
   }

   @Override
   public List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getDate() != null, "日期不能为空");
      return this.baseMapper.teamReportApprovedSummaryList(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<MesProductionReportingApprovalReportSummaryDTO> unapprovedList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getDate() != null, "日期不能为空");
      Preconditions.checkArgument(query.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(query.getProcessId() != null, "工序不能为空");
      Preconditions.checkArgument(query.getTeamId() != null, "班组不能为空");
      Preconditions.checkArgument(query.getProductTypeEnum() != null, "产品类型不能为空");
      this.service.updateSql("SET SESSION group_concat_max_len = 4194304");
      new ArrayList();
      List list;
      if (Objects.equals(ProductTypeEnum.ENCLOSURE.getType(), query.getProductTypeEnum())) {
         list = this.baseMapper.unapprovedEnclosureList(query);
      } else {
         list = this.baseMapper.unapprovedList(query);
         if (CollUtil.isNotEmpty(list)) {
            switch (ProductTypeEnum.getEnumByType(query.getProductTypeEnum())) {
               case ARTIFACT:
                  this.artifactQuotaHandle(list);
                  break;
               case ASSEMBLE:
                  this.assembleQuotaHandle(list);
                  break;
               case MACHINE_PART:
                  this.machinePartQuotaHandle(list);
            }
         }
      }

      return list;
   }

   private void machinePartQuotaHandle(List<MesProductionReportingApprovalReportSummaryDTO> list) {
      List<String> machinePartProductSerialNumberList = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<Long> machinePartProductMonomerIdList = list.stream().map(i -> i.getProduct().getMonomerId()).distinct().collect(Collectors.toList());
      Map<String, List<TechDrawing>> machinePartDrawingGroup = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.MACHINE_PART.getType()))
                  .in(TechDrawing::getSerialNumber, machinePartProductSerialNumberList))
               .in(TechDrawing::getMonomerId, machinePartProductMonomerIdList)
         )
         .stream()
         .collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      List<MesWageAdjustProductDTO> machinePartWageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.MACHINE_PART.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(machinePartProductSerialNumberList)
               .build()
         );
      List<MesQuotaConfigMachinePartDTO> quotaConfigMachinePartDTOList = this.quotaConfigMachinePartService
         .listInfo(
            MesQuotaConfigConditionQuery.builder()
               .branchCompanyIdList(list.stream().map(i -> i.getBranchCompanyId()).distinct().collect(Collectors.toList()))
               .workshopIdList(list.stream().map(i -> i.getWorkshop().getId()).distinct().collect(Collectors.toList()))
               .productClassificationEnumList(list.stream().map(i -> i.getProduct().getProductClassificationEnum()).distinct().collect(Collectors.toList()))
               .productClassIdList(list.stream().map(i -> i.getProduct().getClassId()).distinct().collect(Collectors.toList()))
               .processIdList(list.stream().map(i -> i.getProcess().getId()).distinct().collect(Collectors.toList()))
               .build()
         );
      list.forEach(
         i -> {
            List<TechDrawing> nowDrawingList = machinePartDrawingGroup.get(i.getProduct().getMonomerId() + "&" + i.getProduct().getSerialNumber());
            if (CollUtil.isNotEmpty(nowDrawingList)) {
               i.setNumbers(nowDrawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               i.setDrawingAndSerialNumber(
                  nowDrawingList.stream().map(drawing -> BeanUtil.toBean(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }

            List<MesQuotaConfigMachinePartDTO> quotaConfigList = quotaConfigMachinePartDTOList.stream()
               .filter(
                  qc -> qc.getBranchCompanyIdList().contains(i.getBranchCompanyId())
                     && qc.getWorkshopIdList().contains(i.getWorkshop().getId())
                     && Objects.equals(qc.getProductClassificationEnum(), i.getProduct().getProductClassificationEnum())
                     && Objects.equals(qc.getProcessId(), i.getProcess().getId())
                     && qc.getMachinePartClassIdList().contains(i.getProduct().getClassId())
               )
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
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), i.getProduct().getThick());
                              } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigMachinePartConditionEnum.CUTTING_LENGTH.getType())) {
                                 MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                    qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                 );
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), i.getProduct().getLength());
                              } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigMachinePartConditionEnum.PROFILE_SECTION.getType())) {
                                 BigDecimal section = Stream.of(TechUtils.getSpecList(i.getProduct().getSpecification()))
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
               .collect(Collectors.toList());
            if (CollUtil.isNotEmpty(quotaConfigList) && quotaConfigList.size() == 1) {
               MesQuotaConfigMachinePartDTO quotaConfig = quotaConfigList.get(0);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  i.setQuotaConfigId(quotaConfig.getId());
                  i.setQuotaConfigSerialNumber(quotaConfig.getSerialNumber());
                  if (Objects.equals(quotaConfig.getQuotaType(), 2)) {
                     String quotaMatchingCondition = JSONUtil.toJsonStr(quotaConfig.getConditionList());
                     i.setQuotaMatchingCondition(quotaMatchingCondition);
                  }

                  i.setMeasureUnit(quotaConfig.getMeasureUnit());
                  BigDecimal price = i.getTeam().getOrganizationType() ? quotaConfig.getOrganizationInsidePrice() : quotaConfig.getOrganizationOutsidePrice();
                  i.setPrice(price);
                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.TON.getName())) {
                     BigDecimal measurementQuantity = i.getReportWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                     i.setMeasurementQuantity(measurementQuantity);
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }

                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.METER.getName())) {
                     BigDecimal measurementQuantity = i.getReportQuantity()
                        .multiply(i.getProduct().getLength())
                        .divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                     i.setMeasurementQuantity(measurementQuantity);
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }

                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.PIECE.getName())) {
                     i.setMeasurementQuantity(i.getReportQuantity());
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }
               }
            }

            MesWageAdjustProduct wageAdjustProduct = machinePartWageAdjustProductList.stream()
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
               i.setMeasureUnit(wageAdjustProduct.getUnit());
               BigDecimal price = i.getTeam().getOrganizationType()
                  ? wageAdjustProduct.getNewOrganizationInsidePrice()
                  : wageAdjustProduct.getNewOrganizationOutsidePrice();
               i.setPrice(price);
               i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
               i.setQuotaConfigSerialNumber("修" + wageAdjustProduct.getQuotaNumber());
               if (i.getPrice() != null && i.getMeasurementQuantity() != null) {
                  i.setAmount(i.getPrice().multiply(i.getMeasurementQuantity()));
               }
            }
         }
      );
   }

   private void assembleQuotaHandle(List<MesProductionReportingApprovalReportSummaryDTO> list) {
      List<String> assembleProductSerialNumberList = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<Long> assembleProductMonomerIdList = list.stream().map(i -> i.getProduct().getMonomerId()).distinct().collect(Collectors.toList());
      Map<String, List<TechDrawing>> assembleDrawingGroup = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ASSEMBLE.getType()))
                  .in(TechDrawing::getSerialNumber, assembleProductSerialNumberList))
               .in(TechDrawing::getMonomerId, assembleProductMonomerIdList)
         )
         .stream()
         .collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      List<MesWageAdjustProductDTO> assembleWageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.ASSEMBLE.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(assembleProductSerialNumberList)
               .build()
         );
      List<MesQuotaConfigAssembleDTO> quotaConfigAssembleDTOList = this.quotaConfigAssembleService
         .listInfo(
            MesQuotaConfigConditionQuery.builder()
               .branchCompanyIdList(list.stream().map(ni -> ni.getBranchCompanyId()).collect(Collectors.toList()))
               .workshopIdList(list.stream().map(ni -> ni.getWorkshop().getId()).distinct().collect(Collectors.toList()))
               .productClassIdList(list.stream().map(ni -> ni.getProduct().getClassId()).distinct().collect(Collectors.toList()))
               .processIdList(list.stream().map(ni -> ni.getProcess().getId()).distinct().collect(Collectors.toList()))
               .build()
         );
      list.forEach(
         i -> {
            List<TechDrawing> nowDrawingList = assembleDrawingGroup.get(i.getProduct().getMonomerId() + "&" + i.getProduct().getSerialNumber());
            if (CollUtil.isNotEmpty(nowDrawingList)) {
               i.setNumbers(nowDrawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               i.setDrawingAndSerialNumber(
                  nowDrawingList.stream().map(drawing -> BeanUtil.toBean(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }

            List<MesQuotaConfigAssembleDTO> quotaConfigList = quotaConfigAssembleDTOList.stream()
               .filter(
                  qc -> qc.getBranchCompanyIdList().contains(i.getBranchCompanyId())
                     && qc.getWorkshopIdList().contains(i.getWorkshop().getId())
                     && Objects.equals(qc.getProcessId(), i.getProcess().getId())
                     && qc.getAssembleClassIdList().contains(i.getProduct().getClassId())
               )
               .filter(
                  qc -> Objects.equals(qc.getQuotaType(), 2)
                     ? qc.getConditionList()
                        .stream()
                        .allMatch(
                           qcc -> {
                              if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.WEIGHT.getType())) {
                                 BigDecimal weight = i.getProduct().getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                                 MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                    qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                 );
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), weight);
                              } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.SECTION.getType())) {
                                 BigDecimal section = Stream.of(TechUtils.getSpecList(i.getProduct().getSpecification()))
                                    .map(BigDecimal::new)
                                    .max(BigDecimal::compareTo)
                                    .orElse(null);
                                 MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                    qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                 );
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), section);
                              } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.WEB_THICKNESS.getType())) {
                                 BigDecimal webThickness = Stream.of(TechUtils.getSpecList(i.getProduct().getSpecification()))
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
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), i.getProduct().getLength());
                              } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigAssembleConditionEnum.HOLE_QUANTITY.getType())) {
                                 List<Long> artifactIdList = this.assembleDetailService
                                    .lambdaQuery()
                                    .eq(TechAssembleDetail::getAssembleId, i.getProduct().getId())
                                    .list()
                                    .stream()
                                    .map(TechAssembleDetail::getArtifactId)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 List<Long> machinePartIdList = Optional.of(artifactIdList)
                                    .filter(CollUtil::isNotEmpty)
                                    .map(m -> this.artifactMachinePartLinkService.lambdaQuery().in(TechArtifactMachinePartLink::getArtifactId, m).list())
                                    .orElseGet(Collections::emptyList)
                                    .stream()
                                    .map(TechArtifactMachinePartLink::getMachinePartId)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 Integer electroslagWeldingPartitionQuantity = Optional.of(machinePartIdList)
                                    .filter(CollUtil::isNotEmpty)
                                    .map(m -> this.machinePartService.lambdaQuery().in(TechMachinePart::getId, m).eq(TechMachinePart::getName, "电渣焊隔板").list())
                                    .orElseGet(Collections::emptyList)
                                    .stream()
                                    .map(TechMachinePart::getQuantity)
                                    .reduce(Integer::sum)
                                    .orElse(null);
                                 Integer holeQuantity = Optional.ofNullable(electroslagWeldingPartitionQuantity).map(m -> m * 2).orElse(null);
                                 MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                    qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                 );
                                 return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), holeQuantity);
                              } else {
                                 return false;
                              }
                           }
                        )
                     : Objects.equals(qc.getQuotaType(), 1)
               )
               .collect(Collectors.toList());
            if (CollUtil.isNotEmpty(quotaConfigList) && quotaConfigList.size() == 1) {
               MesQuotaConfigAssembleDTO quotaConfig = quotaConfigList.get(0);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  i.setQuotaConfigId(quotaConfig.getId());
                  i.setQuotaConfigSerialNumber(quotaConfig.getSerialNumber());
                  if (Objects.equals(quotaConfig.getQuotaType(), 2)) {
                     String quotaMatchingCondition = JSONUtil.toJsonStr(quotaConfig.getConditionList());
                     i.setQuotaMatchingCondition(quotaMatchingCondition);
                  }

                  i.setMeasureUnit(quotaConfig.getMeasureUnit());
                  BigDecimal price = i.getTeam().getOrganizationType() ? quotaConfig.getOrganizationInsidePrice() : quotaConfig.getOrganizationOutsidePrice();
                  i.setPrice(price);
                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.TON.getName())) {
                     BigDecimal measurementQuantity = i.getReportWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                     i.setMeasurementQuantity(measurementQuantity);
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }

                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.METER.getName())) {
                     BigDecimal measurementQuantity = i.getReportQuantity()
                        .multiply(i.getProduct().getLength())
                        .divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                     i.setMeasurementQuantity(measurementQuantity);
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }

                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.PIECE.getName())) {
                     i.setMeasurementQuantity(i.getReportQuantity());
                     BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                     i.setAmount(amount);
                  }

                  if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.PERFORATE_QUANTITY.getName())) {
                     i.setMeasurementQuantity(i.getPerforateQuantity());
                     if (i.getMeasurementQuantity() != null) {
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }
                  }
               }
            }

            MesWageAdjustProduct wageAdjustProduct = assembleWageAdjustProductList.stream()
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
               i.setMeasureUnit(wageAdjustProduct.getUnit());
               BigDecimal price = i.getTeam().getOrganizationType()
                  ? wageAdjustProduct.getNewOrganizationInsidePrice()
                  : wageAdjustProduct.getNewOrganizationOutsidePrice();
               i.setPrice(price);
               i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
               i.setQuotaConfigSerialNumber("修" + wageAdjustProduct.getQuotaNumber());
               if (i.getPrice() != null && i.getMeasurementQuantity() != null) {
                  i.setAmount(i.getPrice().multiply(i.getMeasurementQuantity()));
               }
            }
         }
      );
   }

   private void artifactQuotaHandle(List<MesProductionReportingApprovalReportSummaryDTO> list) {
      List<String> artifactProductSerialNumberList = list.stream().map(i -> i.getProduct().getSerialNumber()).distinct().collect(Collectors.toList());
      List<Long> artifactProductMonomerIdList = list.stream().map(i -> i.getProduct().getMonomerId()).distinct().collect(Collectors.toList());
      Map<String, List<TechDrawing>> artifactDrawingGroup = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                  .in(TechDrawing::getSerialNumber, artifactProductSerialNumberList))
               .in(TechDrawing::getMonomerId, artifactProductMonomerIdList)
         )
         .stream()
         .collect(Collectors.groupingBy(k -> k.getMonomerId() + "&" + k.getSerialNumber()));
      List<MesWageAdjustProductDTO> artifactWageAdjustProductList = this.wageAdjustProductService
         .listInfo(
            MesWageAdjustProductQuery.builder()
               .productTypeEnum(ProductTypeEnum.ARTIFACT.getType())
               .approvalStatus(ReviewStatusEnum.REVIEWED.getType())
               .productSerialNumberList(artifactProductSerialNumberList)
               .build()
         );
      List<MesProductionReportingApprovalReportSummaryDTO> paintList = list.stream()
         .filter(i -> Objects.equals(ProcessTypeEnum.PAINT.getType(), i.getProcess().getType()))
         .collect(Collectors.toList());
      List<MesQuotaConfigCoatingDTO> quotaConfigCoatingDTOList = this.quotaConfigCoatingService
         .listInfo(
            MesQuotaConfigConditionQuery.builder()
               .branchCompanyIdList(
                  paintList.stream().map(MesProductionReportingApprovalReportSummaryDTO::getBranchCompanyId).distinct().collect(Collectors.toList())
               )
               .workshopIdList(paintList.stream().map(pi -> pi.getWorkshop().getId()).distinct().collect(Collectors.toList()))
               .productClassIdList(paintList.stream().map(pi -> pi.getProduct().getClassId()).distinct().collect(Collectors.toList()))
               .processIdList(paintList.stream().map(pi -> pi.getProcess().getId()).distinct().collect(Collectors.toList()))
               .build()
         );
      List<MesProductionReportingApprovalReportSummaryDTO> notPaintList = list.stream()
         .filter(i -> !Objects.equals(ProcessTypeEnum.PAINT.getType(), i.getProcess().getType()))
         .collect(Collectors.toList());
      List<MesQuotaConfigArtifactDTO> quotaConfigArtifactDTOList = this.quotaConfigArtifactService
         .listInfo(
            MesQuotaConfigConditionQuery.builder()
               .branchCompanyIdList(
                  notPaintList.stream().map(MesProductionReportingApprovalReportSummaryDTO::getBranchCompanyId).distinct().collect(Collectors.toList())
               )
               .workshopIdList(notPaintList.stream().map(npi -> npi.getWorkshop().getId()).distinct().collect(Collectors.toList()))
               .productClassificationEnumList(
                  notPaintList.stream().map(npi -> npi.getProduct().getProductClassificationEnum()).distinct().collect(Collectors.toList())
               )
               .productClassIdList(notPaintList.stream().map(npi -> npi.getProduct().getClassId()).distinct().collect(Collectors.toList()))
               .processIdList(notPaintList.stream().map(npi -> npi.getProcess().getId()).distinct().collect(Collectors.toList()))
               .build()
         );
      List<Long> projectIdList = list.stream().map(i -> i.getProject().getId()).distinct().collect(Collectors.toList());
      List<MesPaintingCraftDTO> paintingCraftDTOList = this.paintingCraftService.listInfo(MesPaintingCraftQuery.builder().projectIdList(projectIdList).build());
      list.forEach(
         i -> {
            List<TechDrawing> nowDrawingList = artifactDrawingGroup.get(i.getProduct().getMonomerId() + "&" + i.getProduct().getSerialNumber());
            if (CollUtil.isNotEmpty(nowDrawingList)) {
               i.setNumbers(nowDrawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               i.setDrawingAndSerialNumber(
                  nowDrawingList.stream().map(drawing -> BeanUtil.toBean(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }

            if (Objects.equals(i.getProcess().getType(), ProcessTypeEnum.PAINT.getType())) {
               MesQuotaConfigCoatingDTO quotaConfig = quotaConfigCoatingDTOList.stream()
                  .filter(qc -> qc.getBranchCompanyIdList().contains(i.getBranchCompanyId()))
                  .filter(qc -> qc.getWorkshopIdList().contains(i.getWorkshop().getId()))
                  .filter(qc -> qc.getArtifactClassIdList().contains(i.getProduct().getClassId()))
                  .filter(qc -> Objects.equals(qc.getProcessId(), i.getProcess().getId()))
                  .findFirst()
                  .orElse(null);
               if (BeanUtil.isNotEmpty(quotaConfig)) {
                  i.setQuotaConfigId(quotaConfig.getId());
                  i.setQuotaConfigSerialNumber(quotaConfig.getSerialNumber());
                  i.setMeasureUnit(quotaConfig.getMeasureUnit());
                  MesPaintingCraftDTO paintingCraftDTO = paintingCraftDTOList.stream()
                     .filter(pc -> ObjectUtil.equal(pc.getProject().getId(), i.getProject().getId()))
                     .filter(pc -> CollUtil.isEmpty(pc.getMonomerIdList()) || pc.getMonomerIdList().contains(i.getMonomer().getId()))
                     .peek(pc -> pc.setMonomerIds(StrUtil.blankToDefault(pc.getMonomerIds(), null)))
                     .min(
                        Comparator.comparing(MesPaintingCraft::getMonomerIds, Comparator.nullsLast(Comparator.naturalOrder()))
                           .thenComparing(MesPaintingCraft::getId, Comparator.naturalOrder())
                     )
                     .orElse(null);
                  BigDecimal paintFilmThickness = Optional.ofNullable(paintingCraftDTO)
                     .filter(x$0 -> BeanUtil.isNotEmpty(x$0))
                     .map(m -> m.getDetailList().stream().map(MesPaintingCraftDetail::getPaintFilmThickness).reduce(BigDecimal::add).orElse(BigDecimal.ZERO))
                     .orElse(BigDecimal.ZERO);
                  i.setPaintFilmThickness(paintFilmThickness);
                  if (paintFilmThickness.compareTo(BigDecimal.ZERO) > 0) {
                     if (paintFilmThickness.compareTo(quotaConfig.getPaintFilmThicknessBase()) <= 0) {
                        BigDecimal price = i.getTeam().getOrganizationType()
                           ? quotaConfig.getStartOrganizationInsidePrice()
                           : quotaConfig.getStartOrganizationOutsidePrice();
                        i.setPrice(price);
                     } else {
                        BigDecimal startPrice = i.getTeam().getOrganizationType()
                           ? quotaConfig.getStartOrganizationInsidePrice()
                           : quotaConfig.getStartOrganizationOutsidePrice();
                        BigDecimal addPrice = i.getTeam().getOrganizationType()
                           ? quotaConfig.getStartAddOrganizationInsidePrice()
                           : quotaConfig.getStartAddOrganizationOutsidePrice();
                        BigDecimal exceed = paintFilmThickness.subtract(quotaConfig.getPaintFilmThicknessBase());
                        BigDecimal[] divideAndRemainder = exceed.divideAndRemainder(quotaConfig.getStartAddPaintFilmThickness());
                        BigDecimal quotient = divideAndRemainder[0];
                        BigDecimal remainder = divideAndRemainder[1];
                        if (remainder.compareTo(BigDecimal.ZERO) > 0) {
                           quotient = quotient.add(BigDecimal.ONE);
                        }

                        BigDecimal price = addPrice.multiply(quotient).add(startPrice);
                        i.setPrice(price);
                     }

                     if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.SQUARE_METER.getName())) {
                        i.setMeasurementQuantity(i.getProduct().getSurfaceArea().multiply(i.getReportQuantity()).multiply(BigDecimal.valueOf(1.0E-6)));
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }

                     if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.TON.getName())) {
                        i.setMeasurementQuantity(i.getProduct().getNetWeight().multiply(i.getReportQuantity()).multiply(BigDecimal.valueOf(0.001)));
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }
                  }
               }
            } else {
               List<MesQuotaConfigArtifactDTO> quotaConfigList = quotaConfigArtifactDTOList.stream()
                  .filter(qc -> qc.getBranchCompanyIdList().contains(i.getBranchCompanyId()))
                  .filter(qc -> qc.getWorkshopIdList().contains(i.getWorkshop().getId()))
                  .filter(qc -> Objects.equals(qc.getProductClassificationEnum(), i.getProduct().getProductClassificationEnum()))
                  .filter(qc -> qc.getArtifactClassIdList().contains(i.getProduct().getClassId()))
                  .filter(qc -> CollUtil.isEmpty(qc.getArtifactNameList()) || qc.getArtifactNameList().contains(i.getProduct().getName()))
                  .filter(qc -> Objects.equals(qc.getProcessId(), i.getProcess().getId()))
                  .filter(
                     qc -> Objects.equals(qc.getQuotaType(), 2)
                        ? qc.getConditionList()
                           .stream()
                           .allMatch(
                              qcc -> {
                                 if (Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.WEIGHT.getType())) {
                                    BigDecimal weight = i.getProduct().getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), weight);
                                 } else if (Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.MACHINE_PART_QUANTITY.getType())) {
                                    MaxAndMin mam = MaxAndMin.getMaxAndMin(
                                       qcc.getComparisonOperatorOne(), qcc.getNumberOne(), qcc.getComparisonOperatorTwo(), qcc.getNumberTwo()
                                    );
                                    return MaxAndMin.isValueInRange(mam.getMin(), mam.getMax(), i.getProduct().getMachinePartQuantity());
                                 } else {
                                    return Objects.equals(qcc.getConditionEnum(), QuotaConfigArtifactConditionEnum.CORBEL_QUANTITY.getType()) ? false : false;
                                 }
                              }
                           )
                        : Objects.equals(qc.getQuotaType(), 1)
                  )
                  .sorted(Comparator.comparing(MesQuotaConfigArtifact::getArtifactNames, Comparator.nullsLast(Comparator.naturalOrder())))
                  .collect(Collectors.toList());
               if (CollUtil.isNotEmpty(quotaConfigList) && quotaConfigList.size() <= 2) {
                  MesQuotaConfigArtifactDTO quotaConfig = quotaConfigList.get(0);
                  if (BeanUtil.isNotEmpty(quotaConfig)) {
                     i.setQuotaConfigId(quotaConfig.getId());
                     i.setQuotaConfigSerialNumber(quotaConfig.getSerialNumber());
                     if (Objects.equals(quotaConfig.getQuotaType(), 2)) {
                        String quotaMatchingCondition = JSONUtil.toJsonStr(quotaConfig.getConditionList());
                        i.setQuotaMatchingCondition(quotaMatchingCondition);
                     }

                     i.setMeasureUnit(quotaConfig.getMeasureUnit());
                     BigDecimal price = i.getTeam().getOrganizationType()
                        ? quotaConfig.getOrganizationInsidePrice()
                        : quotaConfig.getOrganizationOutsidePrice();
                     i.setPrice(price);
                     if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.TON.getName())) {
                        BigDecimal measurementQuantity = i.getReportWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                        i.setMeasurementQuantity(measurementQuantity);
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }

                     if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.METER.getName())) {
                        BigDecimal measurementQuantity = i.getReportQuantity()
                           .multiply(i.getProduct().getLength())
                           .divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP);
                        i.setMeasurementQuantity(measurementQuantity);
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }

                     if (Objects.equals(quotaConfig.getMeasureUnit(), QuotaConfigMeasureUnitEnum.PIECE.getName())) {
                        i.setMeasurementQuantity(i.getReportQuantity());
                        BigDecimal amount = i.getMeasurementQuantity().multiply(i.getPrice());
                        i.setAmount(amount);
                     }
                  }
               }
            }

            MesWageAdjustProduct wageAdjustProduct = artifactWageAdjustProductList.stream()
               .filter(wap -> Objects.equals(wap.getWorkshopId(), i.getWorkshop().getId()))
               .filter(wap -> Objects.equals(wap.getProcessId(), i.getProcess().getId()))
               .filter(wap -> CollUtil.isEmpty(wap.getTeamIdList()) || wap.getTeamIdList().contains(i.getTeam().getId()))
               .filter(wap -> Objects.equals(wap.getProjectId(), i.getProject().getId()))
               .filter(wap -> Objects.equals(wap.getMonomerId(), i.getMonomer().getId()))
               .filter(wap -> Objects.equals(wap.getProductSerialNumber(), i.getProduct().getSerialNumber()))
               .findFirst()
               .orElse(null);
            if (BeanUtil.isNotEmpty(wageAdjustProduct)) {
               i.setMeasureUnit(wageAdjustProduct.getUnit());
               BigDecimal price = i.getTeam().getOrganizationType()
                  ? wageAdjustProduct.getNewOrganizationInsidePrice()
                  : wageAdjustProduct.getNewOrganizationOutsidePrice();
               i.setPrice(price);
               i.setQuotaConfigId(wageAdjustProduct.getQuotaConfigId());
               i.setQuotaConfigSerialNumber("修" + wageAdjustProduct.getQuotaNumber());
               if (i.getPrice() != null && i.getMeasurementQuantity() != null) {
                  i.setAmount(i.getPrice().multiply(i.getMeasurementQuantity()));
               }
            }
         }
      );
   }

   @Override
   public List<MesProductionReportingApprovalReportSummaryDTO> approvedList(MesProductionReportingApprovalQuery query) {
      Preconditions.checkArgument(query.getDate() != null, "日期不能为空");
      Preconditions.checkArgument(query.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(query.getProcessId() != null, "工序不能为空");
      Preconditions.checkArgument(query.getTeamId() != null, "班组不能为空");
      Preconditions.checkArgument(query.getProductTypeEnum() != null, "产品类型不能为空");
      return this.baseMapper.approvedList(query);
   }

   private void verifyParam(MesProductionReportingApprovalPassedParam param) {
      Set<ConstraintViolation<MesProductionReportingApprovalPassedParam>> validate;
      if (Objects.equals(param.getProductTypeEnum(), ProductTypeEnum.ENCLOSURE.getType())) {
         validate = this.validator.validate(param, TechEnclosureService.class);
      } else {
         validate = this.validator.validate(param, Add.class);
      }

      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<MesProductionReportingApprovalPassedProduceTeamReport> subList = this.subService
         .list(
            (Wrapper<MesProductionReportingApprovalPassedProduceTeamReport>)new LambdaQueryWrapper<MesProductionReportingApprovalPassedProduceTeamReport>()
               .in(MesProductionReportingApprovalPassedProduceTeamReport::getProduceTeamReportId, param.getProduceTeamReportIdList())
         );
      Preconditions.checkArgument(CollUtil.isEmpty(subList), "存在已审核过数据, 请刷新后重试");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesProductionReportingApprovalPassedParam param) {
      this.verifyParam(param);
      MesProductionReportingApprovalPassed entity = BeanUtil.toBean(param, MesProductionReportingApprovalPassed.class);
      if (entity.getBoolAutomaticApproval() != null && entity.getBoolAutomaticApproval()) {
         entity.setApproverId(0L);
      } else {
         entity.setApproverId(UserUtil.getCurrentUserId());
      }

      entity.setApprovalDate(LocalDate.now());
      this.save(entity);
      List<MesProductionReportingApprovalPassedProduceTeamReport> subList = param.getProduceTeamReportIdList()
         .stream()
         .map(
            produceTeamReportId -> MesProductionReportingApprovalPassedProduceTeamReport.builder()
               .productionReportingApprovalPassedId(entity.getId())
               .produceTeamReportId(produceTeamReportId)
               .productTypeEnum(entity.getProductTypeEnum())
               .build()
         )
         .collect(Collectors.toList());
      this.subService.saveBatch(subList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAdd(List<MesProductionReportingApprovalPassedParam> paramList) {
      paramList.forEach(this::add);
      return true;
   }

   @Override
   public List<MesTeamSalaryDTO> teamSalaryList(MesTeamSalaryQuery query) {
      return ProductTypeEnum.ENCLOSURE.getType().equals(query.getProductTypeEnum())
         ? this.baseMapper.teamSalaryEnclosureList(query)
         : this.baseMapper.teamSalaryList(query);
   }

   @Override
   public List<MesTeamSalaryTeamProductionDTO> teamProductionList(MesTeamSalaryQuery query) {
      return this.baseMapper.teamProductionList(query);
   }

   @Override
   public List<MesProductionReportingApprovalPassedDTO> listInfo(MesProductionReportingApprovalPassedQuery query) {
      return this.baseMapper.listInfo(query);
   }

   @Override
   public List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedList(
      Integer productTypeEnum, List<Long> workshopIdList, List<Long> processIdList, List<Long> teamIdList, LocalDate date
   ) {
      this.service.updateSql("SET SESSION group_concat_max_len = 4194304");
      List<MesProductionReportingApprovalReportSummaryDTO> list = this.baseMapper
         .whitelistUnapprovedList(productTypeEnum, workshopIdList, processIdList, teamIdList, date);
      if (CollUtil.isNotEmpty(list)) {
         switch (ProductTypeEnum.getEnumByType(productTypeEnum)) {
            case ARTIFACT:
               this.artifactQuotaHandle(list);
               break;
            case ASSEMBLE:
               this.assembleQuotaHandle(list);
               break;
            case MACHINE_PART:
               this.machinePartQuotaHandle(list);
         }
      }

      return list;
   }

   @Override
   public List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedEnclosureList(
      List<Long> workshopIdList, List<Long> processIdList, List<Long> teamIdList, LocalDate date
   ) {
      this.service.updateSql("SET SESSION group_concat_max_len = 4194304");
      return this.baseMapper.whitelistUnapprovedEnclosureList(workshopIdList, processIdList, teamIdList, date);
   }
}
