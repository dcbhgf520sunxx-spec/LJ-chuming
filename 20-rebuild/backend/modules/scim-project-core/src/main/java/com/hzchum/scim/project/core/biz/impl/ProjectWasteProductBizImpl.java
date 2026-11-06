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
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
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
import com.hzchum.scim.project.core.api.biz.ProjectWasteProductBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectWasteProductChildDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectWasteProductMainDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductChildQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductMainService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectWasteProductBizImpl implements ProjectWasteProductBiz {
   private final RedisUtils redisUtils;
   private final UserService userService;
   private final BranchCompanyService branchCompanyService;
   private final ContractWasteService contractWasteService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final MesBuildingWarehouseService mesBuildingWarehouseService;
   private final EnclosurePlanService enclosurePlanService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final ProjectReturnProductChildService returnChildService;
   private final ProjectWasteProductMainService wasteMainService;
   private final ProjectWasteProductChildService wasteChildService;

   @Override
   public PageVO<ProjectReturnProductChildDO> listReturnAndWaste(ProjectReturnProductChildQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<ProjectReturnProductChild> returnProductChildList = this.returnChildService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductChild.class)
               .orderByDesc(ProjectReturnProductChild::getId)
               .eq(param.getProjectId() != null, ProjectReturnProductChild::getProjectId, param.getProjectId())
               .eq(param.getType() != null, ProjectReturnProductChild::getProductType, param.getType())
               .in(ProjectReturnProductChild::getHandleMethod, HandleMethodEnum.RECYCLE.getType(), HandleMethodEnum.SCRAP.getType())
               .eq(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .apply("quantity > reuse_quantity + waste_sale_quantity")
         );
      if (returnProductChildList.isEmpty()) {
         return new PageVO<>();
      }

      Map<Integer, List<ProjectReturnProductChild>> productTypeListMap = returnProductChildList.stream()
         .collect(Collectors.groupingBy(ProjectReturnProductChild::getProductType));
      Map<Long, TechArtifact> artifactMap = new HashMap<>(productTypeListMap.getOrDefault(ProductTypeEnum.ARTIFACT.getType(), Collections.emptyList()).size());
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(
         productTypeListMap.getOrDefault(ProductTypeEnum.ENCLOSURE.getType(), Collections.emptyList()).size()
      );
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(
         productTypeListMap.getOrDefault(ProductTypeEnum.AUXILIARY_MATERIAL.getType(), Collections.emptyList()).size()
      );
      productTypeListMap.forEach(
         (productType, list) -> {
            Set<Long> productIds = list.stream().map(ProjectReturnProductChild::getProductId).collect(Collectors.toSet());
            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               Map<Long, TechArtifact> collect = this.artifactService
                  .listByIds(productIds)
                  .stream()
                  .filter(s -> StringUtils.isBlank(param.getName()) || s.getName().contains(param.getName()))
                  .filter(s -> StringUtils.isBlank(param.getSerialNumber()) || s.getSerialNumber().contains(param.getSerialNumber()))
                  .filter(s -> StringUtils.isBlank(param.getSpecification()) || s.getSpecification().contains(param.getSpecification()))
                  .filter(s -> StringUtils.isBlank(param.getMaterial()) || s.getMaterial().contains(param.getMaterial()))
                  .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               artifactMap.putAll(collect);
            }

            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               Map<Long, TechEnclosure> collect = this.enclosureService
                  .listByIds(productIds)
                  .stream()
                  .filter(s -> StringUtils.isBlank(param.getName()) || s.getName().contains(param.getName()))
                  .filter(s -> StringUtils.isBlank(param.getSerialNumber()) || s.getSerialNumber().contains(param.getSerialNumber()))
                  .filter(s -> StringUtils.isBlank(param.getSpecification()) || s.getPlate().contains(param.getSpecification()))
                  .filter(s -> StringUtils.isBlank(param.getMaterial()) || s.getMaterial().contains(param.getMaterial()))
                  .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
               enclosureMap.putAll(collect);
            }

            if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               Map<Long, TechStandardPart> collect = this.standardPartService
                  .listByIds(productIds)
                  .stream()
                  .filter(s -> StringUtils.isBlank(param.getName()) || s.getName().contains(param.getName()))
                  .filter(s -> StringUtils.isBlank(param.getSpecification()) || s.getSpecification().contains(param.getSpecification()))
                  .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
               standardPartMap.putAll(collect);
            }
         }
      );
      returnProductChildList = returnProductChildList.stream()
         .filter(
            s -> {
               if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  return artifactMap.containsKey(s.getProductId());
               } else {
                  return s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
                     ? enclosureMap.containsKey(s.getProductId())
                     : standardPartMap.containsKey(s.getProductId());
               }
            }
         )
         .collect(Collectors.toList());
      if (returnProductChildList.isEmpty()) {
         return new PageVO<>();
      }

      Map<Long, String> monomerMap = this.monomerService
         .listByIds(returnProductChildList.stream().map(ProjectReturnProductChild::getMonomerId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
      Map<Long, String> areaMap = this.areaService
         .listByIds(returnProductChildList.stream().map(ProjectReturnProductChild::getAreaId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
      Map<Long, String> enclosurePlanMap = this.enclosurePlanService
         .listByIds(returnProductChildList.stream().map(ProjectReturnProductChild::getPlanId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(EnclosurePlan::getId, EnclosurePlan::getName));
      Map<Long, NameInfo> warehouseMap = this.mesBuildingWarehouseService
         .list()
         .stream()
         .map(wh -> NameInfo.builder().id(wh.getId()).name(wh.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      List<ProjectReturnProductChildDO> productChildDOList = new ArrayList<>(returnProductChildList.size());
      returnProductChildList.forEach(
         returnChild -> {
            ProjectReturnProductChildDO dto = ProjectReturnProductChildDO.builder()
               .id(returnChild.getId())
               .mesBuildingReturnWarehouseRecordId(returnChild.getId())
               .mainId(returnChild.getMainId())
               .factoryId(returnChild.getFactoryId())
               .workshopId(returnChild.getWorkshopId())
               .monomerId(returnChild.getMonomerId())
               .areaId(returnChild.getAreaId())
               .planId(returnChild.getPlanId())
               .productType(returnChild.getProductType())
               .productId(returnChild.getProductId())
               .pricingManner(returnChild.getPricingManner())
               .quantity(returnChild.getQuantity().subtract(returnChild.getReuseQuantity()).subtract(returnChild.getWasteSaleQuantity()))
               .unitPrice(returnChild.getUnitPrice())
               .warehouseId(returnChild.getWarehouseId())
               .warehouse(warehouseMap.get(returnChild.getWarehouseId()))
               .build();
            if (returnChild.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(returnChild.getProductId());
               dto.setMonomerName(monomerMap.get(returnChild.getMonomerId()));
               dto.setAreaName(areaMap.get(returnChild.getAreaId()));
               dto.setProductName(artifact.getName());
               dto.setSerialNumber(artifact.getSerialNumber());
               dto.setSpecification(artifact.getSpecification());
               dto.setMaterial(artifact.getMaterial());
               dto.setNetWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               dto.setTotalNetWeight(artifact.getNetWeight().multiply(dto.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               dto.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setTotalLength(artifact.getLength().multiply(dto.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("件");
               dto.setAccountingUnit("吨");
               dto.setTotalAmount(
                  artifact.getNetWeight()
                     .multiply(dto.getQuantity())
                     .multiply(returnChild.getUnitPrice())
                     .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               );
            }

            if (returnChild.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure enclosure = enclosureMap.get(returnChild.getProductId());
               dto.setPlanName(enclosurePlanMap.get(returnChild.getPlanId()));
               dto.setProductName(enclosure.getName());
               dto.setSerialNumber(enclosure.getSerialNumber());
               dto.setSpecification(enclosure.getPlate());
               dto.setPlate(enclosure.getPlate());
               dto.setColor(enclosure.getColor());
               dto.setThickness(enclosure.getThickness());
               dto.setMaterial(enclosure.getMaterial());
               dto.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setTotalLength(enclosure.getLength().multiply(dto.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setTotalArea(enclosure.getSurfaceArea().multiply(dto.getQuantity()).divide(BigDecimal.valueOf(1000000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("张");
               dto.setAccountingUnit(returnChild.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType()) ? "米" : "平方米");
               dto.setTotalAmount(
                  returnChild.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                     ? returnChild.getUnitPrice()
                        .multiply(enclosure.getLength())
                        .multiply(dto.getQuantity())
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                     : returnChild.getUnitPrice()
                        .multiply(enclosure.getSurfaceArea())
                        .multiply(dto.getQuantity())
                        .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP)
               );
            }

            if (returnChild.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               TechStandardPart standardPart = standardPartMap.get(returnChild.getProductId());
               dto.setMonomerName(monomerMap.get(returnChild.getMonomerId()));
               dto.setAreaName(areaMap.get(returnChild.getAreaId()));
               dto.setProductName(standardPart.getName());
               dto.setSpecification(standardPart.getSpecification());
               dto.setSingleMete(standardPart.getMete().divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP));
               dto.setMete(standardPart.getMete().multiply(dto.getQuantity()).divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP));
               dto.setMeasureUnit(standardPart.getMeasureUnit());
               dto.setAccountingUnit(standardPart.getAccountingUnit());
               dto.setTotalAmount(
                  returnChild.getUnitPrice()
                     .multiply(standardPart.getMete())
                     .multiply(dto.getQuantity())
                     .divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP)
               );
            }

            Date createTimeDate = Date.from(returnChild.getCreateTime().atZone(ZoneId.systemDefault()).toInstant());
            String getStorageDuration = this.getStorageDuration(createTimeDate, new Date());
            dto.setStorageDuration(getStorageDuration);
            dto.setCreateTime(returnChild.getCreateTime());
            productChildDOList.add(dto);
         }
      );
      return PageUtil.listPage(pageNumber, pageSize, productChildDOList);
   }

   private String getStorageDuration(Date startDate, Date endDate) {
      long differ = endDate.getTime() - startDate.getTime();
      BigDecimal workTime = new BigDecimal(differ * 1.0 / 3600000.0);
      return String.valueOf(workTime.setScale(1, RoundingMode.HALF_UP).doubleValue());
   }

   @Override
   public PageVO<ProjectWasteProductMainDTO> pageListWasteMain(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectWasteProductMainDTO> productMainDTOList = this.getList(
         productType, relationType, serialNumber, projectName, createTimeStartDate, createTimeEndDate, createUserName, auditUserName, auditStatus
      );
      return new PageVO<>(productMainDTOList);
   }

   private List<ProjectWasteProductMainDTO> getList(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus
   ) {
      List<ProjectWasteProductMainDTO> projectWasteProductMainVOList = this.wasteMainService
         .listByCondition(
            productType, relationType, serialNumber, projectName, createTimeStartDate, createTimeEndDate, createUserName, auditUserName, auditStatus
         );
      if (projectWasteProductMainVOList.isEmpty()) {
         return projectWasteProductMainVOList;
      }

      List<ProjectWasteProductMainDTO> artifactWasteProductMainList = projectWasteProductMainVOList.stream()
         .filter(w -> w.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactWasteProductMainList)) {
         List<ProjectWasteProductChild> wasteProductChildList = this.wasteChildService
            .list(
               Wrappers.lambdaQuery(ProjectWasteProductChild.class)
                  .in(
                     ProjectWasteProductChild::getMainId,
                     artifactWasteProductMainList.stream().map(ProjectWasteProductMainDTO::getId).collect(Collectors.toList())
                  )
                  .eq(ProjectWasteProductChild::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         Set<Long> artifactIds = wasteProductChildList.stream().map(ProjectWasteProductChild::getProductId).collect(Collectors.toSet());
         Map<Long, BigDecimal> artifactIdNetWightMap = this.artifactService
            .listByIds(artifactIds)
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getNetWeight));
         Map<Long, BigDecimal> mainIdArtifactTotalWeightMap = wasteProductChildList.stream()
            .filter(s -> artifactIdNetWightMap.containsKey(s.getProductId()))
            .collect(
               Collectors.groupingBy(
                  ProjectWasteProductChild::getMainId,
                  Collectors.mapping(
                     s -> artifactIdNetWightMap.get(s.getProductId()).multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP),
                     Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         artifactWasteProductMainList.forEach(s -> {
            s.setMete(mainIdArtifactTotalWeightMap.get(s.getId()).setScale(2, RoundingMode.HALF_UP));
            s.setAccountingUnit("吨");
         });
      }

      return projectWasteProductMainVOList;
   }

   @Override
   public PrintVO<List<ProjectWasteProductMainDTO>> printListWasteMain(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus
   ) {
      List<ProjectWasteProductMainDTO> wasteProductMainDTOList = this.getList(
         productType, relationType, serialNumber, projectName, createTimeStartDate, createTimeEndDate, createUserName, auditUserName, auditStatus
      );
      PrintVO<List<ProjectWasteProductMainDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(wasteProductMainDTOList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveWasteHandle(ProjectWasteProductMainDTOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "制成品类型不能为空");
      Preconditions.checkArgument(WasteHandleMethodEnum.getByType(param.getWasteHandleMethod()) != null, "废品处理方式有误!");
      String purchaser = null;
      if (param.getWasteHandleMethod().equals(WasteHandleMethodEnum.REUSE.getType())) {
         Preconditions.checkArgument(param.getUseProjectId() != null, "未选择二次利用项目!");
         this.projectService.checkProjectStatus(param.getUseProjectId());
      } else {
         Preconditions.checkArgument(param.getTotalAmount() != null, "废品出售总金额不能为空!");
         ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
         Preconditions.checkArgument(contractWaste != null, "购买方不存在!");
         purchaser = contractWaste.getPurchaser();
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "出售方不存在!");
      }

      ProjectWasteProductMain wasteMain = BeanUtil.copy(param, ProjectWasteProductMain.class);
      wasteMain.setCreateUserId(UserUtil.getCurrentUserId());
      wasteMain.setProjectId(0L);
      String returnSerialNumber = this.getWasteSerialNumber(wasteMain);
      wasteMain.setSerialNumber(returnSerialNumber);
      wasteMain.setPurchaser(purchaser);
      wasteMain.setQuantity(
         param.getProjectWasteProductChildVOList().stream().map(ProjectWasteProductChildDTOParam::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      wasteMain.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.wasteMainService.save(wasteMain);
      param.getProjectWasteProductChildVOList()
         .forEach(
            childParam -> {
               ProjectReturnProductChild returnChild = this.returnChildService.getById(childParam.getMesBuildingReturnWarehouseRecordId());
               Preconditions.checkArgument(returnChild != null, "退货记录不存在!");
               Preconditions.checkArgument(
                  returnChild.getQuantity().compareTo(childParam.getQuantity().add(returnChild.getReuseQuantity()).add(returnChild.getWasteSaleQuantity()))
                     >= 0,
                  "产品数量不足!!请刷新重试!!"
               );
               if (param.getWasteHandleMethod().equals(WasteHandleMethodEnum.REUSE.getType())) {
                  returnChild.setReuseQuantity(returnChild.getReuseQuantity().add(childParam.getQuantity()));
               } else {
                  returnChild.setWasteSaleQuantity(returnChild.getWasteSaleQuantity().add(childParam.getQuantity()));
               }

               this.returnChildService.updateById(returnChild);
               ProjectWasteProductChild wasteChild = this.buildWasteChild(wasteMain, returnChild, childParam.getQuantity());
               this.wasteChildService.save(wasteChild);
            }
         );
      return true;
   }

   private ProjectWasteProductChild buildWasteChild(ProjectWasteProductMain wasteMain, ProjectReturnProductChild returnChild, BigDecimal quantity) {
      return ProjectWasteProductChild.builder()
         .mainId(wasteMain.getId())
         .wasteHandleMethod(wasteMain.getWasteHandleMethod())
         .branchCompanyId(wasteMain.getBranchCompanyId())
         .contractWasteId(wasteMain.getContractWasteId())
         .purchaser(wasteMain.getPurchaser())
         .useProjectId(wasteMain.getUseProjectId())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .mesBuildingReturnWarehouseRecordId(returnChild.getId())
         .mesBuildingWarehouseRecordId(returnChild.getMesBuildingWarehouseRecordId())
         .projectId(returnChild.getProjectId())
         .monomerId(returnChild.getMonomerId() != null ? returnChild.getMonomerId() : 0L)
         .areaId(returnChild.getAreaId() != null ? returnChild.getAreaId() : 0L)
         .planId(returnChild.getPlanId())
         .productType(returnChild.getProductType())
         .productId(returnChild.getProductId())
         .quantity(quantity)
         .build();
   }

   private BigDecimal getAmount(ProjectReturnProductChild returnChild, Integer quantity) {
      if (returnChild.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(returnChild.getProductId());
         Preconditions.checkArgument(artifact != null, "构件未查询到!");
         return artifact.getNetWeight()
            .multiply(BigDecimal.valueOf(quantity.intValue()))
            .multiply(returnChild.getUnitPrice())
            .divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
      } else if (returnChild.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(returnChild.getProductId());
         Preconditions.checkArgument(enclosure != null, "围护未查询到!");
         return returnChild.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
            ? enclosure.getLength()
               .multiply(BigDecimal.valueOf(quantity.intValue()))
               .multiply(returnChild.getUnitPrice())
               .divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
            : enclosure.getSurfaceArea()
               .multiply(BigDecimal.valueOf(quantity.intValue()))
               .multiply(returnChild.getUnitPrice())
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
      } else if (returnChild.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         TechStandardPart standardPart = this.standardPartService.getById(returnChild.getProductId());
         Preconditions.checkArgument(standardPart != null, "配套件未查询到!");
         return standardPart.getMete()
            .multiply(BigDecimal.valueOf(quantity.intValue()))
            .multiply(returnChild.getUnitPrice())
            .divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP);
      } else {
         return BigDecimal.ZERO;
      }
   }

   private String getWasteSerialNumber(ProjectWasteProductMain projectWasteProductMain) {
      String wasteSerialNumber = "";
      String handleMethod = "";
      String nowDateStr = DateTimeUtils.localDateToString(LocalDate.now(), "yyyy-MM-dd");
      String productWasteNumber = "";
      if (this.redisUtils.hasKey("waste_product_number")) {
         this.redisUtils.incr("waste_product_number", 1L);
         productWasteNumber = String.format("%02d", this.redisUtils.get("waste_product_number"));
      } else {
         this.redisUtils.set("waste_product_number", 1L, 86400L);
         productWasteNumber = "01";
      }

      if (WasteHandleMethodEnum.REUSE.getType().equals(projectWasteProductMain.getWasteHandleMethod())) {
         handleMethod = "二次利用-";
         wasteSerialNumber = handleMethod + nowDateStr + "-" + productWasteNumber;
      } else if (WasteHandleMethodEnum.WASTE_SALE.getType().equals(projectWasteProductMain.getWasteHandleMethod())) {
         handleMethod = "废品出售-";
         wasteSerialNumber = handleMethod + nowDateStr + "-" + productWasteNumber;
      }

      List<ProjectWasteProductMain> ProjectWasteProductMainList = this.wasteMainService
         .list((Wrapper<ProjectWasteProductMain>)new LambdaQueryWrapper<ProjectWasteProductMain>().eq(ProjectWasteProductMain::getSerialNumber, wasteSerialNumber));
      return CollectionUtils.isNotEmpty(ProjectWasteProductMainList) ? this.getWasteSerialNumber(projectWasteProductMain) : wasteSerialNumber;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditWasteHandle(ProjectReturnProductCheckDTOParam param) {
      ProjectWasteProductMain wasteMain = this.wasteMainService.getById(param.getId());
      Preconditions.checkArgument(wasteMain != null, "废品出库记录不存在!");
      BeanUtil.copy(param, wasteMain);
      wasteMain.setAuditUserId(UserUtil.getCurrentUserId());
      wasteMain.setAuditTime(LocalDateTime.now());
      this.wasteMainService.updateById(wasteMain);
      List<ProjectWasteProductChild> wasteProductChildList = this.wasteChildService
         .list(Wrappers.lambdaQuery(ProjectWasteProductChild.builder().mainId(param.getId()).build()));
      Map<Long, ProjectReturnProductChild> returnChildMap = new HashMap<>(wasteProductChildList.size());
      if (param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType())) {
         List<ProjectReturnProductChild> productChildList = this.returnChildService
            .listByIds(wasteProductChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet()));
         Map<Long, ProjectReturnProductChild> collect = productChildList.stream()
            .collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
         returnChildMap.putAll(collect);
      }

      wasteProductChildList.forEach(wasteProductChild -> {
         wasteProductChild.setAuditStatus(param.getAuditStatus());
         wasteProductChild.setAuditTime(wasteMain.getAuditTime());
         if (param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType())) {
            ProjectReturnProductChild returnChild = returnChildMap.get(wasteProductChild.getMesBuildingReturnWarehouseRecordId());
            if (wasteProductChild.getWasteHandleMethod().equals(WasteHandleMethodEnum.REUSE.getType())) {
               returnChild.setReuseQuantity(returnChild.getReuseQuantity().subtract(wasteProductChild.getQuantity()));
            } else {
               returnChild.setWasteSaleQuantity(returnChild.getWasteSaleQuantity().subtract(wasteProductChild.getQuantity()));
            }
         }
      });
      this.wasteChildService.updateBatchById(wasteProductChildList);
      if (param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType())) {
         this.returnChildService.updateBatchById(returnChildMap.values());
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> idList) {
      Preconditions.checkArgument(!CollectionUtils.isEmpty(idList), "请选择要删除的数据");
      idList.forEach(
         id -> {
            ProjectWasteProductMain projectWasteProductMain = this.wasteMainService.getById(id);
            Preconditions.checkArgument(projectWasteProductMain != null, "要删除的数据数据不存在");
            Preconditions.checkArgument(projectWasteProductMain.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "删除失败!出库记录已审核!");
            List<ProjectWasteProductChild> projectWasteProductChildList = this.wasteChildService
               .list((Wrapper<ProjectWasteProductChild>)new LambdaQueryWrapper<ProjectWasteProductChild>().eq(ProjectWasteProductChild::getMainId, id));
            List<Long> childIdList = projectWasteProductChildList.stream().map(ProjectWasteProductChild::getId).collect(Collectors.toList());
            this.wasteChildService.removeByIds(childIdList);
            this.wasteMainService.removeById(id);
         }
      );
      return true;
   }

   @Override
   public List<ProjectWasteProductChildDTO> listWasteChildByMainId(Long id) {
      ProjectWasteProductMain wasteMain = this.wasteMainService.getById(id);
      Preconditions.checkArgument(wasteMain != null, "废品出库记录不存在!");
      List<ProjectWasteProductChild> wasteChildList = this.wasteChildService.list(Wrappers.lambdaQuery(ProjectWasteProductChild.builder().mainId(id).build()));
      if (wasteChildList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> monomerMap = new HashMap<>(16);
      Map<Long, String> areaMap = new HashMap<>(16);
      Map<Long, String> planMap = new HashMap<>(16);
      Map<Long, TechArtifact> artifactMap = new HashMap<>(32);
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(32);
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(32);
      Set<Long> productIds = wasteChildList.stream().map(ProjectWasteProductChild::getProductId).collect(Collectors.toSet());
      if (wasteMain.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         || wasteMain.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         Set<Long> monomerIds = wasteChildList.stream().map(ProjectWasteProductChild::getMonomerId).collect(Collectors.toSet());
         Set<Long> areaIds = wasteChildList.stream().map(ProjectWasteProductChild::getAreaId).collect(Collectors.toSet());
         this.monomerService.listByIds(monomerIds).forEach(m -> {
            String var10000 = monomerMap.put(m.getId(), m.getName());
         });
         this.areaService.listByIds(areaIds).forEach(a -> {
            String var10000 = areaMap.put(a.getId(), a.getName());
         });
         if (wasteMain.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            this.artifactService.listByIds(productIds).forEach(a -> {
               TechArtifact var10000 = artifactMap.put(a.getId(), a);
            });
         }

         if (wasteMain.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            this.standardPartService.listByIds(productIds).forEach(s -> {
               TechStandardPart var10000 = standardPartMap.put(s.getId(), s);
            });
         }
      }

      if (wasteMain.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Set<Long> planIds = wasteChildList.stream().map(ProjectWasteProductChild::getPlanId).collect(Collectors.toSet());
         this.enclosurePlanService.listByIds(planIds).forEach(plan -> {
            String var10000 = planMap.put(plan.getId(), plan.getName());
         });
         this.enclosureService.listByIds(productIds).forEach(e -> {
            TechEnclosure var10000 = enclosureMap.put(e.getId(), e);
         });
      }

      Map<Long, ProjectReturnProductChild> returnChildMap = this.returnChildService
         .listByIds(wasteChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
      return wasteChildList.stream().map(c -> {
         ProjectWasteProductChildDTO wasteChildVO = BeanUtil.copy(c, ProjectWasteProductChildDTO.class);
         ProjectReturnProductChild returnChild = returnChildMap.get(c.getMesBuildingReturnWarehouseRecordId());
         wasteChildVO.setPricingManner(returnChild.getPricingManner());
         if (c.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = artifactMap.get(c.getProductId());
            BeanUtil.copy(artifact, wasteChildVO);
            wasteChildVO.setProductName(artifact.getName());
            wasteChildVO.setNetWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            wasteChildVO.setTotalNetWeight(artifact.getNetWeight().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            wasteChildVO.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
            wasteChildVO.setTotalLength(wasteChildVO.getLength().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
         }

         if (c.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = enclosureMap.get(c.getProductId());
            BeanUtil.copy(enclosure, wasteChildVO);
            wasteChildVO.setProductName(enclosure.getName());
            wasteChildVO.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
            wasteChildVO.setSurfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
            wasteChildVO.setTotalLength(enclosure.getLength().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            wasteChildVO.setTotalArea(enclosure.getSurfaceArea().multiply(c.getQuantity()).divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
         }

         if (c.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            TechStandardPart standardPart = standardPartMap.get(c.getProductId());
            BeanUtil.copy(standardPart, wasteChildVO);
            wasteChildVO.setProductName(standardPart.getName());
            wasteChildVO.setMete(standardPart.getMete().multiply(c.getQuantity()).divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP));
         }

         wasteChildVO.setQuantity(c.getQuantity());
         wasteChildVO.setMonomerName(monomerMap.get(c.getMonomerId()));
         wasteChildVO.setAreaName(areaMap.get(c.getAreaId()));
         wasteChildVO.setPlanName(planMap.get(c.getPlanId()));
         return wasteChildVO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ProjectWasteProductChildDTO>> printListWasteChild(Long id) {
      ProjectWasteProductMain wasteMain = this.wasteMainService.getById(id);
      Preconditions.checkArgument(wasteMain != null, "废品出库记录不存在!");
      PrintVO<List<ProjectWasteProductChildDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("serialNumber", wasteMain.getSerialNumber());
      header.put("projectName", wasteMain.getUseProjectId() == null ? "/" : this.projectService.getById(wasteMain.getUseProjectId()).getName());
      header.put("handleMethod", WasteHandleMethodEnum.getNameByType(wasteMain.getWasteHandleMethod()));
      String createUserName = this.userService.getNameById(wasteMain.getCreateUserId());
      header.put("createUserName", StringUtils.isNotBlank(createUserName) ? createUserName : "/");
      header.put("createTime", wasteMain.getCreateTime());
      String auditUserName = this.userService.getNameById(wasteMain.getAuditUserId());
      header.put("auditUserName", StringUtils.isNotBlank(auditUserName) ? auditUserName : "/");
      header.put("auditTime", wasteMain.getAuditTime());
      printVO.setHeader(header);
      printVO.setTable(this.listWasteChildByMainId(id));
      return printVO;
   }

   public ProjectWasteProductBizImpl(
      final RedisUtils redisUtils,
      final UserService userService,
      final BranchCompanyService branchCompanyService,
      final ContractWasteService contractWasteService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final MesBuildingWarehouseService mesBuildingWarehouseService,
      final EnclosurePlanService enclosurePlanService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final ProjectReturnProductChildService returnChildService,
      final ProjectWasteProductMainService wasteMainService,
      final ProjectWasteProductChildService wasteChildService
   ) {
      this.redisUtils = redisUtils;
      this.userService = userService;
      this.branchCompanyService = branchCompanyService;
      this.contractWasteService = contractWasteService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.mesBuildingWarehouseService = mesBuildingWarehouseService;
      this.enclosurePlanService = enclosurePlanService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.returnChildService = returnChildService;
      this.wasteMainService = wasteMainService;
      this.wasteChildService = wasteChildService;
   }
}
