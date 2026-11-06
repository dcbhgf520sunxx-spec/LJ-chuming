package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.NewPricingMannerEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReturnProductStatusEnum;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWarehouse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.biz.ProjectReturnProductBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductChildDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductMainService;
import com.hzchum.scim.project.core.mapper.ProjectReturnProductMainMapper;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectReturnProductBizImpl
   extends IBizImpl<ProjectReturnProductMainService, ProjectReturnProductMainMapper, ProjectReturnProductMain>
   implements ProjectReturnProductBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectReturnProductBizImpl.class);
   private final RedisUtils redisUtils;
   private final AttachmentService attachmentService;
   private final UserService userService;
   private final BranchCompanyService branchCompanyService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final EnclosurePlanService enclosurePlanService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final MesBuildingWarehouseSummaryService warehouseSummaryService;
   private final MesBuildingWarehouseRecordService warehouseRecordService;
   private final WarehouseBiz warehouseBiz;
   private final MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   private final MesBuildingWarehouseService warehouseService;
   private final MesBuildingTaskService mesBuildingTaskService;
   private final MesEnclosureTaskService mesEnclosureTaskService;
   private final ProjectReturnProductMainService projectReturnProductMainService;
   private final ProjectReturnProductChildService projectReturnProductChildService;

   @Override
   public PageVO<ProjectReturnProductChildDO> listShipCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject contractProject = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(contractProject != null, "项目信息不存在");
      List<ProjectReturnProductChildDO> projectReturnProductChildDOList = Collections.emptyList();
      if (ProductTypeEnum.ARTIFACT.getType().equals(param.getType())) {
         projectReturnProductChildDOList = this.projectReturnProductChildService.projectReturnChildsByTypeArtifact(param);
      } else if (ProductTypeEnum.ENCLOSURE.getType().equals(param.getType())) {
         projectReturnProductChildDOList = this.projectReturnProductChildService.projectReturnChildsByTypeEenclosure(param);
      } else if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(param.getType())) {
         Preconditions.checkArgument(param.getRelationType() != null, "配套件关联类型不能为空!");
         if (param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            projectReturnProductChildDOList = this.projectReturnProductChildService.projectReturnChildsByTypeStandardPartArtifact(param);
         } else {
            projectReturnProductChildDOList = this.projectReturnProductChildService.projectReturnChildsByTypeStandardPartEenclosure(param);
         }
      }

      if (projectReturnProductChildDOList.isEmpty()) {
         return new PageVO<>();
      }

      List<Long> cargoLinkIds = projectReturnProductChildDOList.stream().map(ProjectReturnProductChildDO::getId).collect(Collectors.toList());
      List<ProjectReturnProductChild> projectReturnProductChildList = this.projectReturnProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductChild.class)
               .in(ProjectReturnProductChild::getCargoLinkId, cargoLinkIds)
               .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> cargoLinkIdReturnQuantityMap = projectReturnProductChildList.stream()
         .collect(
            Collectors.groupingBy(
               ProjectReturnProductChild::getCargoLinkId, Collectors.reducing(BigDecimal.ZERO, ProjectReturnProductChild::getQuantity, BigDecimal::add)
            )
         );
      projectReturnProductChildDOList = projectReturnProductChildDOList.stream()
         .filter(s -> s.getQuantity().compareTo(cargoLinkIdReturnQuantityMap.getOrDefault(s.getId(), BigDecimal.ZERO)) > 0)
         .peek(s -> s.setQuantity(s.getQuantity().subtract(cargoLinkIdReturnQuantityMap.getOrDefault(s.getId(), BigDecimal.ZERO))))
         .collect(Collectors.toList());
      projectReturnProductChildDOList.forEach(projectReturnProductChildDO -> {
         if (ProductTypeEnum.ARTIFACT.getType().equals(param.getType())) {
            projectReturnProductChildDO.setNetWeight(projectReturnProductChildDO.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            projectReturnProductChildDO.setGrossWeight(projectReturnProductChildDO.getGrossWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            projectReturnProductChildDO.setTotalNetWeight(projectReturnProductChildDO.getQuantity().multiply(projectReturnProductChildDO.getNetWeight()));
            projectReturnProductChildDO.setTotalGrossWeight(projectReturnProductChildDO.getQuantity().multiply(projectReturnProductChildDO.getGrossWeight()));
            projectReturnProductChildDO.setTotalLength(projectReturnProductChildDO.getQuantity().multiply(projectReturnProductChildDO.getLength()));
            projectReturnProductChildDO.setPricingManner(NewPricingMannerEnum.WEIGHT.getType());
         } else if (ProductTypeEnum.ENCLOSURE.getType().equals(param.getType())) {
            projectReturnProductChildDO.setTotalLength(projectReturnProductChildDO.getQuantity().multiply(projectReturnProductChildDO.getLength()));
            projectReturnProductChildDO.setTotalArea(projectReturnProductChildDO.getQuantity().multiply(projectReturnProductChildDO.getSurfaceArea()));
         } else if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(param.getType())) {
            projectReturnProductChildDO.setMete(projectReturnProductChildDO.getSingleMete().multiply(projectReturnProductChildDO.getQuantity()));
         }
      });
      return PageUtil.listPage(pageNumber, pageSize, projectReturnProductChildDOList);
   }

   @Override
   public PageVO<ProjectReturnProductChildDO> listWarehouseCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .eq(MesBuildingWarehouseSummary::getProductType, param.getType())
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .in(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
               .eq(param.getProjectId() != null, MesBuildingWarehouseSummary::getProjectId, param.getProjectId())
               .eq(param.getMonomerId() != null, MesBuildingWarehouseSummary::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, MesBuildingWarehouseSummary::getAreaId, param.getAreaId())
               .eq(param.getPlanId() != null, MesBuildingWarehouseSummary::getPlanId, param.getPlanId())
               .apply("quantity > package_quantity + cargo_quantity")
         );
      if (warehouseSummaryList.isEmpty()) {
         return new PageVO<>();
      }

      Set<Long> productIds = warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).collect(Collectors.toSet());
      List<ProjectReturnProductChildDO> resultList = new ArrayList<>();
      if (param.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<TechArtifact> artifactList = this.artifactService
            .listByIds(productIds)
            .stream()
            .filter(artifact -> StringUtils.isBlank(param.getName()) || artifact.getName().contains(param.getName()))
            .filter(artifact -> StringUtils.isBlank(param.getSerialNumber()) || artifact.getSerialNumber().contains(param.getSerialNumber()))
            .filter(artifact -> StringUtils.isBlank(param.getSpecification()) || artifact.getSpecification().contains(param.getSpecification()))
            .filter(artifact -> StringUtils.isBlank(param.getMaterial()) || artifact.getMaterial().contains(param.getMaterial()))
            .collect(Collectors.toList());
         if (artifactList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<Long, String> monomerMap = this.monomerService
            .listByIds(artifactList.stream().map(TechArtifact::getMonomerId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
         Map<Long, String> areaMap = this.areaService
            .listByIds(artifactList.stream().map(TechArtifact::getAreaId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
         Map<Long, Integer> summaryIdScrapQuantityMap = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .eq(ProjectReturnProductChild::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .in(ProjectReturnProductChild::getProductId, artifactMap.keySet())
                  .eq(ProjectReturnProductChild::getStatus, ReturnProductStatusEnum.WAREHOUSED.getType())
                  .eq(ProjectReturnProductChild::getHandleMethod, HandleMethodEnum.SCRAP.getType())
                  .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, Collectors.summingInt(s -> s.getQuantity().intValue())));
         warehouseSummaryList.stream()
            .filter(
               summary -> summary.getQuantity().intValue()
                  > summary.getCargoQuantity().intValue()
                     + summary.getPackageQuantity().intValue()
                     + summaryIdScrapQuantityMap.getOrDefault(summary.getId(), 0)
            )
            .filter(warehouseSummary -> artifactMap.containsKey(warehouseSummary.getProductId()))
            .forEach(
               warehouseSummary -> {
                  TechArtifact artifact = artifactMap.get(warehouseSummary.getProductId());
                  Integer scrapQuantity = summaryIdScrapQuantityMap.getOrDefault(warehouseSummary.getId(), 0);
                  int quantity = warehouseSummary.getQuantity().intValue()
                     - warehouseSummary.getPackageQuantity().intValue()
                     - warehouseSummary.getCargoQuantity().intValue()
                     - scrapQuantity;
                  ProjectReturnProductChildDO returnProductChildDO = ProjectReturnProductChildDO.builder()
                     .mesBuildingWarehouseRecordId(warehouseSummary.getId())
                     .projectId(warehouseSummary.getProjectId())
                     .monomerId(warehouseSummary.getMonomerId())
                     .monomerName(monomerMap.get(warehouseSummary.getMonomerId()))
                     .areaId(warehouseSummary.getAreaId())
                     .areaName(areaMap.get(warehouseSummary.getAreaId()))
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .productId(warehouseSummary.getProductId())
                     .productName(artifact.getName())
                     .serialNumber(artifact.getSerialNumber())
                     .specification(artifact.getSpecification())
                     .material(artifact.getMaterial())
                     .length(artifact.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP))
                     .quantity(BigDecimal.valueOf(quantity))
                     .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP))
                     .netWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP))
                     .totalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP))
                     .grossWeight(artifact.getGrossWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP))
                     .totalGrossWeight(
                        artifact.getGrossWeight().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP)
                     )
                     .pricingManner(NewPricingMannerEnum.WEIGHT.getType())
                     .build();
                  resultList.add(returnProductChildDO);
               }
            );
      }

      if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(productIds)
            .stream()
            .filter(enclosure -> StringUtils.isBlank(param.getName()) || enclosure.getName().contains(param.getName()))
            .filter(enclosure -> StringUtils.isBlank(param.getSerialNumber()) || enclosure.getSerialNumber().contains(param.getSerialNumber()))
            .filter(enclosure -> StringUtils.isBlank(param.getMaterial()) || enclosure.getMaterial().contains(param.getMaterial()))
            .collect(Collectors.toList());
         if (enclosureList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         Map<Long, String> enclosurePlanMap = this.enclosurePlanService
            .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(EnclosurePlan::getId, EnclosurePlan::getName));
         warehouseSummaryList.stream()
            .filter(warehouseSummary -> enclosureMap.containsKey(warehouseSummary.getProductId()))
            .forEach(
               warehouseSummary -> {
                  TechEnclosure enclosure = enclosureMap.get(warehouseSummary.getProductId());
                  int quantity = warehouseSummary.getQuantity().intValue()
                     - warehouseSummary.getPackageQuantity().intValue()
                     - warehouseSummary.getCargoQuantity().intValue();
                  ProjectReturnProductChildDO returnProductChildDO = ProjectReturnProductChildDO.builder()
                     .mesBuildingWarehouseRecordId(warehouseSummary.getId())
                     .projectId(warehouseSummary.getProjectId())
                     .planId(warehouseSummary.getPlanId())
                     .planName(enclosurePlanMap.get(warehouseSummary.getPlanId()))
                     .productType(ProductTypeEnum.ENCLOSURE.getType())
                     .productId(warehouseSummary.getProductId())
                     .productName(enclosure.getName())
                     .serialNumber(enclosure.getSerialNumber())
                     .specification("/")
                     .plate(enclosure.getPlate())
                     .material(enclosure.getMaterial())
                     .length(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP))
                     .surfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP))
                     .quantity(BigDecimal.valueOf(quantity))
                     .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP))
                     .totalArea(enclosure.getSurfaceArea().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP))
                     .build();
                  resultList.add(returnProductChildDO);
               }
            );
      }

      if (param.getType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         List<TechStandardPart> standardPartList = this.standardPartService
            .listByIds(productIds)
            .stream()
            .filter(standardPart -> param.getRelationType() == null || standardPart.getRelationType().equals(param.getRelationType()))
            .filter(standardPart -> StringUtils.isBlank(param.getName()) || standardPart.getName().contains(param.getName()))
            .filter(standardPart -> StringUtils.isBlank(param.getSerialNumber()) || standardPart.getSerialNumber().contains(param.getSerialNumber()))
            .filter(standardPart -> StringUtils.isBlank(param.getSpecification()) || standardPart.getSpecification().contains(param.getSpecification()))
            .collect(Collectors.toList());
         if (standardPartList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, TechStandardPart> standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         Map<Long, String> monomerMap = this.monomerService
            .listByIds(standardPartList.stream().map(TechStandardPart::getMonomerId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
         Map<Long, String> areaMap = this.areaService
            .listByIds(standardPartList.stream().map(TechStandardPart::getAreaId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
         warehouseSummaryList.stream()
            .filter(warehouseSummary -> standardPartMap.containsKey(warehouseSummary.getProductId()))
            .forEach(
               warehouseSummary -> {
                  TechStandardPart standardPart = standardPartMap.get(warehouseSummary.getProductId());
                  BigDecimal quantity = warehouseSummary.getQuantity()
                     .subtract(warehouseSummary.getPackageQuantity())
                     .subtract(warehouseSummary.getCargoQuantity());
                  ProjectReturnProductChildDO returnProductChildDO = ProjectReturnProductChildDO.builder()
                     .mesBuildingWarehouseRecordId(warehouseSummary.getId())
                     .projectId(warehouseSummary.getProjectId())
                     .monomerId(warehouseSummary.getMonomerId())
                     .monomerName(monomerMap.get(warehouseSummary.getMonomerId()))
                     .areaId(warehouseSummary.getAreaId())
                     .areaName(areaMap.get(warehouseSummary.getAreaId()))
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .productId(warehouseSummary.getProductId())
                     .productName(standardPart.getName())
                     .serialNumber(standardPart.getSerialNumber())
                     .specification(standardPart.getSpecification())
                     .quantity(quantity)
                     .measureUnit(standardPart.getMeasureUnit())
                     .mete(standardPart.getMete().multiply(quantity).divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP))
                     .accountingUnit(standardPart.getAccountingUnit())
                     .build();
                  resultList.add(returnProductChildDO);
               }
            );
      }

      return PageUtil.listPage(pageNumber, pageSize, resultList);
   }

   @Override
   public PageVO<ProjectReturnProductChildDO> listSchedulingCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      if (param.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTask> buildingTaskList = this.mesBuildingTaskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType())
                  .eq(param.getProjectId() != null, MesBuildingTask::getProjectId, param.getProjectId())
                  .eq(param.getMonomerId() != null, MesBuildingTask::getMonomerId, param.getMonomerId())
                  .eq(param.getAreaId() != null, MesBuildingTask::getAreaId, param.getAreaId())
                  .apply("in_production_quantity > complete_quantity")
            );
         if (buildingTaskList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, Integer> taskIdScrapQuantityMap = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .eq(ProjectReturnProductChild::getStatus, ReturnProductStatusEnum.UN_WAREHOUSE.getType())
                  .eq(ProjectReturnProductChild::getHandleMethod, HandleMethodEnum.SCRAP.getType())
                  .eq(ProjectReturnProductChild::getProductType, param.getType())
                  .in(
                     ProjectReturnProductChild::getMesBuildingWarehouseRecordId,
                     buildingTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList())
                  )
                  .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, Collectors.summingInt(s -> s.getQuantity().intValue())));
         buildingTaskList = buildingTaskList.stream()
            .filter(t -> t.getInProductionQuantity() - t.getCompleteQuantity() - taskIdScrapQuantityMap.getOrDefault(t.getId(), 0) > 0)
            .collect(Collectors.toList());
         if (buildingTaskList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(buildingTaskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toSet()))
            .stream()
            .filter(artifact -> StringUtils.isBlank(param.getName()) || artifact.getName().contains(param.getName()))
            .filter(artifact -> StringUtils.isBlank(param.getSerialNumber()) || artifact.getSerialNumber().contains(param.getSerialNumber()))
            .filter(artifact -> StringUtils.isBlank(param.getSpecification()) || artifact.getSpecification().contains(param.getSpecification()))
            .filter(artifact -> StringUtils.isBlank(param.getMaterial()) || artifact.getMaterial().contains(param.getMaterial()))
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         buildingTaskList = buildingTaskList.stream().filter(task -> artifactMap.containsKey(task.getProductId())).collect(Collectors.toList());
         if (buildingTaskList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, String> monomerMap = this.monomerService
            .listByIds(buildingTaskList.stream().map(MesBuildingTask::getMonomerId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
         Map<Long, String> areaMap = this.areaService
            .listByIds(buildingTaskList.stream().map(MesBuildingTask::getAreaId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
         List<ProjectReturnProductChildDO> productChildDOList = new ArrayList<>(buildingTaskList.size());
         buildingTaskList.forEach(
            task -> {
               int quantity = task.getInProductionQuantity() - task.getCompleteQuantity() - taskIdScrapQuantityMap.getOrDefault(task.getId(), 0);
               TechArtifact artifact = artifactMap.get(task.getProductId());
               ProjectReturnProductChildDO childDO = BeanUtil.copy(task, ProjectReturnProductChildDO.class);
               childDO.setMesBuildingWarehouseRecordId(task.getId());
               childDO.setQuantity(BigDecimal.valueOf(quantity));
               childDO.setMonomerName(monomerMap.get(task.getMonomerId()));
               childDO.setAreaName(areaMap.get(task.getAreaId()));
               childDO.setProductType(task.getTaskTypeEnum());
               childDO.setProductName(artifact.getName());
               childDO.setSerialNumber(artifact.getSerialNumber());
               childDO.setSpecification(artifact.getSpecification());
               childDO.setMaterial(artifact.getMaterial());
               childDO.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               childDO.setPricingManner(NewPricingMannerEnum.WEIGHT.getType());
               childDO.setTotalLength(artifact.getLength().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               childDO.setNetWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               childDO.setTotalNetWeight(
                  artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP)
               );
               childDO.setGrossWeight(artifact.getGrossWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               childDO.setTotalGrossWeight(
                  artifact.getGrossWeight().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP)
               );
               productChildDOList.add(childDO);
            }
         );
         return PageUtil.listPage(pageNumber, pageSize, productChildDOList);
      } else if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         List<MesEnclosureTask> taskList = this.mesEnclosureTaskService
            .list(
               Wrappers.lambdaQuery(MesEnclosureTask.class)
                  .eq(param.getProjectId() != null, MesEnclosureTask::getProjectId, param.getProjectId())
                  .eq(param.getPlanId() != null, MesEnclosureTask::getPlanId, param.getPlanId())
                  .apply("task_quantity > complete_quantity")
            );
         if (taskList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, Integer> taskIdScrapQuantityMap = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .eq(ProjectReturnProductChild::getStatus, ReturnProductStatusEnum.UN_WAREHOUSE.getType())
                  .eq(ProjectReturnProductChild::getHandleMethod, HandleMethodEnum.SCRAP.getType())
                  .eq(ProjectReturnProductChild::getProductType, param.getType())
                  .in(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, taskList.stream().map(MesEnclosureTask::getId).collect(Collectors.toList()))
                  .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, Collectors.summingInt(s -> s.getQuantity().intValue())));
         taskList = taskList.stream()
            .filter(t -> t.getTaskQuantity() - t.getCompleteQuantity() - taskIdScrapQuantityMap.getOrDefault(t.getId(), 0) > 0)
            .collect(Collectors.toList());
         if (taskList.isEmpty()) {
            return new PageVO<>();
         }

         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(taskList.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toSet()))
            .stream()
            .filter(enclosure -> StringUtils.isBlank(param.getName()) || enclosure.getName().contains(param.getName()))
            .filter(enclosure -> StringUtils.isBlank(param.getSerialNumber()) || enclosure.getSerialNumber().contains(param.getSerialNumber()))
            .filter(enclosure -> StringUtils.isBlank(param.getMaterial()) || enclosure.getMaterial().contains(param.getMaterial()))
            .collect(Collectors.toList());
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         taskList = taskList.stream().filter(e -> enclosureMap.containsKey(e.getProductId())).collect(Collectors.toList());
         if (taskList.isEmpty()) {
            return new PageVO<>();
         }

         Map<Long, String> monomerMap = this.monomerService
            .listByIds(taskList.stream().map(MesEnclosureTask::getMonomerId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
         Map<Long, String> areaMap = this.areaService
            .listByIds(taskList.stream().map(MesEnclosureTask::getAreaId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
         List<ProjectReturnProductChildDO> productChildDOList = new ArrayList<>(taskList.size());
         taskList.forEach(
            task -> {
               int quantity = task.getTaskQuantity() - task.getCompleteQuantity() - taskIdScrapQuantityMap.getOrDefault(task.getId(), 0);
               TechEnclosure enclosure = enclosureMap.get(task.getProductId());
               ProjectReturnProductChildDO childDO = BeanUtil.copy(task, ProjectReturnProductChildDO.class);
               childDO.setMesBuildingWarehouseRecordId(task.getId());
               childDO.setProductType(ProductTypeEnum.ENCLOSURE.getType());
               childDO.setQuantity(BigDecimal.valueOf(quantity));
               childDO.setMonomerName(monomerMap.get(task.getMonomerId()));
               childDO.setAreaName(areaMap.get(task.getAreaId()));
               childDO.setProductName(enclosure.getName());
               childDO.setSerialNumber(enclosure.getSerialNumber());
               childDO.setSpecification("/");
               childDO.setPlate(enclosure.getPlate());
               childDO.setMaterial(enclosure.getMaterial());
               childDO.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
               childDO.setTotalLength(enclosure.getLength().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
               childDO.setSurfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
               childDO.setTotalArea(
                  enclosure.getSurfaceArea().multiply(BigDecimal.valueOf(quantity)).divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP)
               );
               productChildDOList.add(childDO);
            }
         );
         return PageUtil.listPage(pageNumber, pageSize, productChildDOList);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<ProjectReturnProductMainDTO> pageList(ProjectReturnProductMainQueryParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReturnProductMainDTO> dtoList = this.getList(param);
      return new PageVO<>(dtoList);
   }

   private List<ProjectReturnProductMainDTO> getList(ProjectReturnProductMainQueryParam param) {
      List<ProjectReturnProductMainDTO> projectReturnProductMainList = this.baseService.selectByCondition(param);
      if (CollectionUtils.isNotEmpty(projectReturnProductMainList)) {
         List<Long> mainIds = projectReturnProductMainList.stream()
            .filter(m -> m.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
            .map(ProjectReturnProductMainDTO::getId)
            .collect(Collectors.toList());
         Map<Long, BigDecimal> mainIdArtifactTotalWeightMap = this.getMainIdArtifactTotalWeight(mainIds);
         projectReturnProductMainList.forEach(
            m -> {
               m.setMete(
                  mainIdArtifactTotalWeightMap.containsKey(m.getId()) ? mainIdArtifactTotalWeightMap.get(m.getId()).setScale(2, RoundingMode.HALF_UP) : null
               );
               m.setAccountingUnit("吨");
               m.setAttachmentList(this.attachmentService.listByIds(m.getAttachmentIds()));
            }
         );
      }

      return projectReturnProductMainList;
   }

   private Map<Long, BigDecimal> getMainIdArtifactTotalWeight(List<Long> mainIds) {
      Map<Long, BigDecimal> mainIdTotalWeightMap = new HashMap<>(mainIds.size() * 2);
      if (CollectionUtils.isNotEmpty(mainIds)) {
         List<ProjectReturnProductChild> returnProductChildList = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .in(ProjectReturnProductChild::getMainId, mainIds)
                  .eq(ProjectReturnProductChild::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         Map<Long, BigDecimal> artifactIdNetWightMap = this.artifactService
            .listByIds(returnProductChildList.stream().map(ProjectReturnProductChild::getProductId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getNetWeight));
         Map<Long, BigDecimal> totalWeightMap = returnProductChildList.stream()
            .filter(s -> artifactIdNetWightMap.containsKey(s.getProductId()))
            .collect(
               Collectors.groupingBy(
                  ProjectReturnProductChild::getMainId,
                  Collectors.mapping(
                     s -> artifactIdNetWightMap.get(s.getProductId()).multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP),
                     Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         mainIdTotalWeightMap.putAll(totalWeightMap);
      }

      return mainIdTotalWeightMap;
   }

   @Override
   public PrintVO<List<ProjectReturnProductMainDTO>> returnProductPrint(ProjectReturnProductMainQueryParam param) {
      PrintVO<List<ProjectReturnProductMainDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ProjectReturnProductMainDTO> dtoList = this.getList(param);
      printVO.setTable(dtoList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveReturn(ProjectReturnProductMainDTOParam param) {
      Preconditions.checkArgument(param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()), "仅支持构件退货!");
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getAttachmentIds()), "未上传图片!");
      Preconditions.checkArgument(ReturnProductStatusEnum.getByType(param.getStatus()) != null, "产品状态有误!");
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      Preconditions.checkArgument(
         param.getStatus().equals(ReturnProductStatusEnum.SHIPPED.getType()) || param.getHandleMethod().equals(HandleMethodEnum.SCRAP.getType()),
         "选择产品只能选择报废处理!"
      );
      if (!param.getHandleMethod().equals(HandleMethodEnum.REPAIR.getType())) {
         MesBuildingWarehouse warehouse = this.warehouseService.getById(param.getWarehouseId());
         Preconditions.checkArgument(warehouse != null, "存储仓库不存在!");
      }

      if (param.getHandleMethod().equals(HandleMethodEnum.RECYCLE.getType())) {
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "回收单位(购买方)不存在!");
      }

      ProjectReturnProductMain returnMain = new ProjectReturnProductMain();
      BeanUtils.copyProperties(param, returnMain);
      String returnSerialNumber = this.getReturnSerialNumber(param);
      returnMain.setSerialNumber(returnSerialNumber);
      returnMain.setCustomerUnit(param.getHandleMethod().equals(HandleMethodEnum.RECYCLE.getType()) ? project.getCustomerUnit() : null);
      List<ProjectReturnProductChildDTOParam> returnChildParamList = param.getProjectReturnProductChildDTOParamList();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(returnChildParamList), "产品列表不能为空!");
      BigDecimal quantity = returnChildParamList.stream().map(ProjectReturnProductChildDTOParam::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
      returnMain.setQuantity(quantity);
      Map<Long, MesBuildingWarehouseSummary> warehouseSummaryMap = new HashMap<>(param.getProjectReturnProductChildDTOParamList().size());
      Map<Long, MesBuildingTask> artifactTaskMap = new HashMap<>(param.getProjectReturnProductChildDTOParamList().size());
      Map<Long, MesEnclosureTask> enclosureTaskMap = new HashMap<>(param.getProjectReturnProductChildDTOParamList().size());
      this.checkReturnQuantity(param, warehouseSummaryMap, artifactTaskMap, enclosureTaskMap);
      BigDecimal totalAmount = this.checkReturnAmount(param.getHandleMethod(), returnChildParamList);
      returnMain.setTotalAmount(totalAmount);
      returnMain.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      returnMain.setCreateUserId(UserUtil.getCurrentUserId());
      returnMain.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.projectReturnProductMainService.save(returnMain);
      this.saveReturnChildList(returnMain, warehouseSummaryMap, artifactTaskMap, enclosureTaskMap, returnChildParamList);
      return true;
   }

   private void saveReturnChildList(
      ProjectReturnProductMain returnMain,
      Map<Long, MesBuildingWarehouseSummary> warehouseSummaryMap,
      Map<Long, MesBuildingTask> artifactTaskMap,
      Map<Long, MesEnclosureTask> enclosureTaskMap,
      List<ProjectReturnProductChildDTOParam> projectReturnProductChildParamList
   ) {
      projectReturnProductChildParamList.forEach(dtoParam -> {
         ProjectReturnProductChild returnChild = BeanUtil.copy(dtoParam, ProjectReturnProductChild.class);
         returnChild.setMainId(returnMain.getId());
         returnChild.setStatus(returnMain.getStatus());
         returnChild.setWarehouseId(returnMain.getWarehouseId());
         returnChild.setHandleMethod(returnMain.getHandleMethod());
         returnChild.setProjectId(returnMain.getProjectId());
         returnChild.setBranchCompanyId(returnMain.getBranchCompanyId());
         returnChild.setCustomerUnit(returnMain.getCustomerUnit());
         returnChild.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         if (returnMain.getStatus().equals(ReturnProductStatusEnum.SHIPPED.getType())) {
            returnChild.setCargoLinkId(dtoParam.getId());
            MesBuildingWarehouseSummary warehouseSummary = warehouseSummaryMap.get(dtoParam.getMesBuildingWarehouseRecordId());
            returnChild.setFactoryId(warehouseSummary.getFactoryId());
            returnChild.setWorkshopId(warehouseSummary.getWorkshopId());
            returnChild.setMonomerId(warehouseSummary.getMonomerId());
            returnChild.setAreaId(warehouseSummary.getAreaId());
            returnChild.setPlanId(warehouseSummary.getPlanId());
         } else if (returnMain.getStatus().equals(ReturnProductStatusEnum.WAREHOUSED.getType())) {
            MesBuildingWarehouseSummary warehouseSummary = warehouseSummaryMap.get(dtoParam.getMesBuildingWarehouseRecordId());
            returnChild.setFactoryId(warehouseSummary.getFactoryId());
            returnChild.setWorkshopId(warehouseSummary.getWorkshopId());
            returnChild.setMonomerId(warehouseSummary.getMonomerId());
            returnChild.setAreaId(warehouseSummary.getAreaId());
            returnChild.setPlanId(warehouseSummary.getPlanId());
         } else if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            MesBuildingTask task = artifactTaskMap.get(dtoParam.getMesBuildingWarehouseRecordId());
            returnChild.setFactoryId(task.getFactoryId());
            returnChild.setWorkshopId(task.getWorkshopId());
            returnChild.setMonomerId(task.getMonomerId());
            returnChild.setAreaId(task.getAreaId());
         } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            MesEnclosureTask task = enclosureTaskMap.get(dtoParam.getMesBuildingWarehouseRecordId());
            returnChild.setFactoryId(task.getFactoryId());
            returnChild.setWorkshopId(task.getWorkshopId());
            returnChild.setMonomerId(task.getMonomerId());
            returnChild.setAreaId(task.getAreaId());
            returnChild.setPlanId(task.getPlanId());
         }

         this.projectReturnProductChildService.save(returnChild);
      });
   }

   private void checkReturnQuantity(
      ProjectReturnProductMainDTOParam param,
      Map<Long, MesBuildingWarehouseSummary> warehouseSummaryMap,
      Map<Long, MesBuildingTask> artifactTaskMap,
      Map<Long, MesEnclosureTask> enclosureTaskMap
   ) {
      if (param.getStatus().equals(ReturnProductStatusEnum.SHIPPED.getType()) || param.getStatus().equals(ReturnProductStatusEnum.WAREHOUSED.getType())) {
         List<Long> warehouseSummaryIds = param.getProjectReturnProductChildDTOParamList()
            .stream()
            .map(ProjectReturnProductChildDTOParam::getMesBuildingWarehouseRecordId)
            .collect(Collectors.toList());
         Map<Long, MesBuildingWarehouseSummary> collect = this.warehouseSummaryService
            .listByIds(warehouseSummaryIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
         warehouseSummaryMap.putAll(collect);
         Map<Long, BigDecimal> warehouseSummaryIdHandleQuantityMap = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .in(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, warehouseSummaryIds)
                  .eq(ProjectReturnProductChild::getStatus, param.getStatus())
                  .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  ProjectReturnProductChild::getMesBuildingWarehouseRecordId,
                  Collectors.reducing(BigDecimal.ZERO, ProjectReturnProductChild::getQuantity, BigDecimal::add)
               )
            );
         param.getProjectReturnProductChildDTOParamList()
            .forEach(
               childParam -> {
                  if (param.getStatus().equals(ReturnProductStatusEnum.SHIPPED.getType())) {
                     MesBuildingWarehouseSummary warehouseSummary = warehouseSummaryMap.get(childParam.getMesBuildingWarehouseRecordId());
                     Preconditions.checkArgument(warehouseSummary != null, "入库记录不存在");
                     BigDecimal handleQuantity = warehouseSummaryIdHandleQuantityMap.getOrDefault(warehouseSummary.getId(), BigDecimal.ZERO);
                     Preconditions.checkArgument(
                        warehouseSummary.getCargoQuantity()
                              .add(warehouseSummary.getPackageQuantity())
                              .subtract(handleQuantity)
                              .compareTo(childParam.getQuantity())
                           >= 0,
                        "可操作数量不足!!请刷新重试!!"
                     );
                  }

                  if (param.getStatus().equals(ReturnProductStatusEnum.WAREHOUSED.getType())) {
                     MesBuildingWarehouseSummary warehouseSummary = warehouseSummaryMap.get(childParam.getMesBuildingWarehouseRecordId());
                     Preconditions.checkArgument(warehouseSummary != null, "入库记录不存在");
                     BigDecimal scrapQuantity = warehouseSummaryIdHandleQuantityMap.getOrDefault(warehouseSummary.getId(), BigDecimal.ZERO);
                     Preconditions.checkArgument(
                        warehouseSummary.getQuantity()
                              .subtract(warehouseSummary.getCargoQuantity())
                              .subtract(warehouseSummary.getPackageQuantity())
                              .subtract(scrapQuantity)
                              .compareTo(childParam.getQuantity())
                           >= 0,
                        "可报废数量不足!!请刷新重试!!"
                     );
                  }
               }
            );
      }

      if (param.getStatus().equals(ReturnProductStatusEnum.UN_WAREHOUSE.getType())) {
         List<Long> taskIds = param.getProjectReturnProductChildDTOParamList()
            .stream()
            .map(ProjectReturnProductChildDTOParam::getMesBuildingWarehouseRecordId)
            .collect(Collectors.toList());
         Map<Long, Integer> taskIdScrapQuantityMap = this.projectReturnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .eq(ProjectReturnProductChild::getStatus, param.getStatus())
                  .eq(ProjectReturnProductChild::getProductType, param.getProductType())
                  .eq(ProjectReturnProductChild::getHandleMethod, HandleMethodEnum.SCRAP.getType())
                  .in(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, taskIds)
                  .in(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectReturnProductChild::getMesBuildingWarehouseRecordId, Collectors.summingInt(s -> s.getQuantity().intValue())));
         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Map<Long, MesBuildingTask> collect = this.mesBuildingTaskService
               .listByIds(taskIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
            artifactTaskMap.putAll(collect);
         }

         if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            Map<Long, MesEnclosureTask> collect = this.mesEnclosureTaskService
               .listByIds(taskIds)
               .stream()
               .collect(Collectors.toMap(MesEnclosureTask::getId, Function.identity()));
            enclosureTaskMap.putAll(collect);
         }

         param.getProjectReturnProductChildDTOParamList()
            .forEach(
               childParam -> {
                  if (childParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     MesBuildingTask task = artifactTaskMap.get(childParam.getMesBuildingWarehouseRecordId());
                     Preconditions.checkArgument(task != null, "构件任务不存在!");
                     Integer scrapQuantity = taskIdScrapQuantityMap.getOrDefault(childParam.getMesBuildingWarehouseRecordId(), 0);
                     Preconditions.checkArgument(
                        childParam.getQuantity().intValue() <= task.getInProductionQuantity() - task.getCompleteQuantity() - scrapQuantity, "可报废数量不足!!请刷新重试!!"
                     );
                  }

                  if (childParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     MesEnclosureTask task = enclosureTaskMap.get(childParam.getMesBuildingWarehouseRecordId());
                     Preconditions.checkArgument(task != null, "围护任务不存在!");
                     Integer scrapQuantity = taskIdScrapQuantityMap.getOrDefault(childParam.getMesBuildingWarehouseRecordId(), 0);
                     Preconditions.checkArgument(
                        childParam.getQuantity().intValue() <= task.getTaskQuantity() - task.getCompleteQuantity() - scrapQuantity, "可报废数量不足!!请刷新重试!!"
                     );
                  }
               }
            );
      }
   }

   private BigDecimal checkReturnAmount(Integer handleMethod, List<ProjectReturnProductChildDTOParam> projectReturnProductChildParamList) {
      List<BigDecimal> totalAmountList = new ArrayList<>(projectReturnProductChildParamList.size() * 2);
      projectReturnProductChildParamList.forEach(
         childParam -> {
            if (handleMethod.equals(HandleMethodEnum.REPAIR.getType())) {
               childParam.setUnitPrice(null);
            } else {
               Preconditions.checkArgument(childParam.getUnitPrice() != null, "未填写价格");
               BigDecimal totalAmount = BigDecimal.ZERO;
               if (childParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(childParam.getProductId());
                  totalAmount = artifact.getNetWeight()
                     .multiply(childParam.getQuantity())
                     .multiply(childParam.getUnitPrice())
                     .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
               }

               if (childParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(childParam.getProductId());
                  totalAmount = childParam.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                     ? enclosure.getLength()
                        .multiply(childParam.getQuantity())
                        .multiply(childParam.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                     : enclosure.getSurfaceArea()
                        .multiply(childParam.getQuantity())
                        .multiply(childParam.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP);
               }

               if (childParam.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart standardPart = this.standardPartService.getById(childParam.getProductId());
                  totalAmount = standardPart.getMete()
                     .multiply(childParam.getQuantity())
                     .multiply(childParam.getUnitPrice())
                     .divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP);
               }

               childParam.setTotalAmount(totalAmount);
               totalAmountList.add(totalAmount);
            }
         }
      );
      return totalAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   private String getReturnSerialNumber(ProjectReturnProductMainDTOParam projectReturnProductMainDTOParam) {
      String returnSerialNumber = "";
      String handleMethod = "";
      String nowDateStr = DateTimeUtils.localDateToString(LocalDate.now(), "yyyy-MM-dd");
      String productReturnNumber = "";
      if (this.redisUtils.hasKey("product_return_number")) {
         this.redisUtils.incr("product_return_number", 1L);
         productReturnNumber = String.format("%02d", this.redisUtils.get("product_return_number"));
      } else {
         this.redisUtils.set("product_return_number", 1L, 86400L);
         productReturnNumber = "01";
      }

      if (HandleMethodEnum.REPAIR.getType().equals(projectReturnProductMainDTOParam.getHandleMethod())) {
         handleMethod = "返修-";
         returnSerialNumber = handleMethod + nowDateStr + "-" + productReturnNumber;
      } else if (HandleMethodEnum.RECYCLE.getType().equals(projectReturnProductMainDTOParam.getHandleMethod())) {
         handleMethod = "回收-";
         returnSerialNumber = handleMethod + nowDateStr + "-" + productReturnNumber;
      } else if (HandleMethodEnum.SCRAP.getType().equals(projectReturnProductMainDTOParam.getHandleMethod())) {
         handleMethod = "报废-";
         returnSerialNumber = handleMethod + nowDateStr + "-" + productReturnNumber;
      }

      List<ProjectReturnProductMain> projectReturnProductMainList = this.projectReturnProductMainService
         .list((Wrapper<ProjectReturnProductMain>)new LambdaQueryWrapper<ProjectReturnProductMain>().eq(ProjectReturnProductMain::getSerialNumber, returnSerialNumber));
      return CollectionUtils.isNotEmpty(projectReturnProductMainList) ? this.getReturnSerialNumber(projectReturnProductMainDTOParam) : returnSerialNumber;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditReturn(ProjectReturnProductCheckDTOParam param) {
      Preconditions.checkArgument(param.getAuditStatus() != null, "审核状态不能为空");
      ProjectReturnProductMain returnMain = this.projectReturnProductMainService.getById(param.getId());
      Preconditions.checkArgument(returnMain != null, "要审核的数据不存在");
      List<ProjectReturnProductChild> returnChildList = this.projectReturnProductChildService
         .list(Wrappers.lambdaQuery(ProjectReturnProductChild.class).eq(ProjectReturnProductChild::getMainId, returnMain.getId()));
      if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) && returnMain.getHandleMethod().equals(HandleMethodEnum.REPAIR.getType())) {
         returnChildList.forEach(
            returnChild -> {
               MesBuildingWarehouseSummary mesBuildingWarehouseSummary = this.warehouseSummaryService.getById(returnChild.getMesBuildingWarehouseRecordId());
               WarehouseSaveDTOParam warehouseSaveDTOParam = new WarehouseSaveDTOParam();
               warehouseSaveDTOParam.setWorkshopId(mesBuildingWarehouseSummary.getWorkshopId());
               warehouseSaveDTOParam.setProjectId(returnMain.getProjectId());
               warehouseSaveDTOParam.setMonomerId(returnChild.getMonomerId());
               warehouseSaveDTOParam.setAreaId(returnChild.getAreaId());
               warehouseSaveDTOParam.setPlanId(returnChild.getPlanId());
               warehouseSaveDTOParam.setFactoryId(returnChild.getFactoryId());
               warehouseSaveDTOParam.setProductId(returnChild.getProductId());
               warehouseSaveDTOParam.setProductType(returnChild.getProductType());
               warehouseSaveDTOParam.setType(WarehouseTypeEnum.INTO.getType());
               warehouseSaveDTOParam.setQuantity(returnChild.getQuantity());
               warehouseSaveDTOParam.setWarehouseType(WarehouseTypeProductReturnEnum.REPAIR.getType());
               if (returnChild.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact techArtifact = this.artifactService.getById(returnChild.getProductId());
                  Preconditions.checkArgument(techArtifact != null, "构件不存在");
                  if (techArtifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
                     List<MesBuildingCargoListProductNumberLink> mesBuildingCargoListProductNumberLinkList = this.cargoListProductNumberLinkService
                        .list(
                           (Wrapper<MesBuildingCargoListProductNumberLink>)new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                              .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, returnChild.getCargoLinkId())
                        );
                     List<Integer> numberList = mesBuildingCargoListProductNumberLinkList.stream()
                        .map(MesBuildingCargoListProductNumberLink::getNumber)
                        .collect(Collectors.toList());
                     List<MesBuildingWarehouseRecord> mesBuildingWarehouseRecordList = this.warehouseRecordService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                              .eq(MesBuildingWarehouseRecord::getProductId, returnChild.getProductId())
                              .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                              .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
                        );
                     List<Integer> numberUsedList = mesBuildingWarehouseRecordList.stream()
                        .map(MesBuildingWarehouseRecord::getNumber)
                        .collect(Collectors.toList());
                     List<Integer> numberListNew = numberList.stream().filter(number -> !numberUsedList.contains(number)).collect(Collectors.toList());
                     Preconditions.checkArgument(numberListNew.size() >= returnChild.getQuantity().intValue(), "构件码号数据异常");
                     List<Integer> numberResultList = numberListNew.stream().limit(returnChild.getQuantity().intValue()).collect(Collectors.toList());
                     warehouseSaveDTOParam.setNumberList(numberResultList);
                  }
               }

               this.warehouseBiz.setStockQuantityProductReturn(warehouseSaveDTOParam);
            }
         );
      }

      returnMain.setAuditStatus(param.getAuditStatus());
      returnMain.setAuditRemark(param.getAuditRemark());
      returnMain.setAuditTime(LocalDateTime.now());
      returnMain.setAuditUserId(UserUtil.getCurrentUserId());
      this.projectReturnProductMainService.updateById(returnMain);
      returnChildList.forEach(s -> {
         s.setAuditStatus(param.getAuditStatus());
         s.setAuditTime(returnMain.getAuditTime());
      });
      this.projectReturnProductChildService.updateBatchById(returnChildList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteReturn(List<Long> idList) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(idList), "要删除的数据不能为空");
      idList.forEach(
         id -> {
            List<ProjectReturnProductChild> projectReturnProductChildList = this.projectReturnProductChildService
               .list((Wrapper<ProjectReturnProductChild>)new LambdaQueryWrapper<ProjectReturnProductChild>().eq(ProjectReturnProductChild::getMainId, id));
            if (CollectionUtils.isNotEmpty(projectReturnProductChildList)) {
               List<Long> projectReturnProductChildIdList = projectReturnProductChildList.stream()
                  .map(ProjectReturnProductChild::getId)
                  .collect(Collectors.toList());
               this.projectReturnProductChildService.removeByIds(projectReturnProductChildIdList);
            }

            this.baseService.removeById(id);
         }
      );
      return true;
   }

   @Override
   public List<ProjectReturnProductChildDTO> listReturnChild(Long id) {
      ProjectReturnProductMain returnProductMain = this.projectReturnProductMainService.getById(id);
      Preconditions.checkArgument(returnProductMain != null, "退货记录不存在!");
      List<ProjectReturnProductChild> returnProductChildList = this.projectReturnProductChildService
         .list(Wrappers.lambdaQuery(ProjectReturnProductChild.builder().mainId(id).build()));
      if (returnProductChildList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> monomerMap = new HashMap<>(16);
      Map<Long, String> areaMap = new HashMap<>(16);
      Map<Long, String> planMap = new HashMap<>(16);
      Map<Long, TechArtifact> artifactMap = new HashMap<>(32);
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(32);
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(32);
      Set<Long> productIds = returnProductChildList.stream().map(ProjectReturnProductChild::getProductId).collect(Collectors.toSet());
      if (returnProductMain.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         || returnProductMain.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.builder().projectId(returnProductMain.getProjectId()).build())).forEach(m -> {
            String var10000 = monomerMap.put(m.getId(), m.getName());
         });
         this.areaService.list(Wrappers.lambdaQuery(PlanArea.builder().projectId(returnProductMain.getProjectId()).build())).forEach(a -> {
            String var10000 = areaMap.put(a.getId(), a.getName());
         });
         if (returnProductMain.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            this.artifactService.listByIds(productIds).forEach(a -> {
               TechArtifact var10000 = artifactMap.put(a.getId(), a);
            });
         }

         if (returnProductMain.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            this.standardPartService.listByIds(productIds).forEach(s -> {
               TechStandardPart var10000 = standardPartMap.put(s.getId(), s);
            });
         }
      }

      if (returnProductMain.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         this.enclosurePlanService.list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(returnProductMain.getProjectId()).build())).forEach(plan -> {
            String var10000 = planMap.put(plan.getId(), plan.getName());
         });
         this.enclosureService.listByIds(productIds).forEach(e -> {
            TechEnclosure var10000 = enclosureMap.put(e.getId(), e);
         });
      }

      return returnProductChildList.stream().map(c -> {
         ProjectReturnProductChildDTO productChildDTO = BeanUtil.copy(c, ProjectReturnProductChildDTO.class);
         if (c.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = artifactMap.get(c.getProductId());
            BeanUtil.copy(artifact, productChildDTO);
            productChildDTO.setProductName(artifact.getName());
            productChildDTO.setNetWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            productChildDTO.setTotalNetWeight(artifact.getNetWeight().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            productChildDTO.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
            productChildDTO.setTotalLength(productChildDTO.getLength().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
         }

         if (c.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = enclosureMap.get(c.getProductId());
            BeanUtil.copy(enclosure, productChildDTO);
            productChildDTO.setProductName(enclosure.getName());
            productChildDTO.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
            productChildDTO.setSurfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
            productChildDTO.setTotalLength(enclosure.getLength().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            productChildDTO.setTotalArea(enclosure.getSurfaceArea().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
         }

         if (c.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            TechStandardPart standardPart = standardPartMap.get(c.getProductId());
            BeanUtil.copy(standardPart, productChildDTO);
            productChildDTO.setProductName(standardPart.getName());
            productChildDTO.setMete(standardPart.getMete().multiply(c.getQuantity()).divide(standardPart.getQuantity(), 6, RoundingMode.HALF_UP));
         }

         productChildDTO.setQuantity(c.getQuantity());
         productChildDTO.setMonomerName(monomerMap.get(c.getMonomerId()));
         productChildDTO.setAreaName(areaMap.get(c.getAreaId()));
         productChildDTO.setPlanName(planMap.get(c.getPlanId()));
         return productChildDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ProjectReturnProductChildDTO>> printListReturnChild(Long id) {
      ProjectReturnProductMain returnMain = this.projectReturnProductMainService.getById(id);
      Preconditions.checkArgument(returnMain != null, "退货记录不存在!");
      PrintVO<List<ProjectReturnProductChildDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("serialNumber", returnMain.getSerialNumber());
      header.put("projectName", this.projectService.getById(returnMain.getProjectId()).getName());
      header.put("handleMethod", HandleMethodEnum.getNameByType(returnMain.getHandleMethod()));
      header.put("totalAmount", returnMain.getTotalAmount());
      MesBuildingWarehouse warehouse = this.warehouseService.getById(returnMain.getWarehouseId());
      header.put("warehouse", warehouse != null ? warehouse.getName() : "/");
      header.put("createUserName", this.userService.getNameById(returnMain.getCreateUserId()));
      header.put("createTime", returnMain.getCreateTime());
      String auditUserName = this.userService.getNameById(returnMain.getAuditUserId());
      header.put("auditUserName", StringUtils.isNotBlank(auditUserName) ? auditUserName : "/");
      header.put("auditTime", returnMain.getAuditTime());
      printVO.setHeader(header);
      printVO.setTable(this.listReturnChild(id));
      return printVO;
   }

   public ProjectReturnProductBizImpl(
      final RedisUtils redisUtils,
      final AttachmentService attachmentService,
      final UserService userService,
      final BranchCompanyService branchCompanyService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final EnclosurePlanService enclosurePlanService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseRecordService warehouseRecordService,
      final WarehouseBiz warehouseBiz,
      final MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService,
      final MesBuildingWarehouseService warehouseService,
      final MesBuildingTaskService mesBuildingTaskService,
      final MesEnclosureTaskService mesEnclosureTaskService,
      final ProjectReturnProductMainService projectReturnProductMainService,
      final ProjectReturnProductChildService projectReturnProductChildService
   ) {
      this.redisUtils = redisUtils;
      this.attachmentService = attachmentService;
      this.userService = userService;
      this.branchCompanyService = branchCompanyService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.enclosurePlanService = enclosurePlanService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseRecordService = warehouseRecordService;
      this.warehouseBiz = warehouseBiz;
      this.cargoListProductNumberLinkService = cargoListProductNumberLinkService;
      this.warehouseService = warehouseService;
      this.mesBuildingTaskService = mesBuildingTaskService;
      this.mesEnclosureTaskService = mesEnclosureTaskService;
      this.projectReturnProductMainService = projectReturnProductMainService;
      this.projectReturnProductChildService = projectReturnProductChildService;
   }
}
