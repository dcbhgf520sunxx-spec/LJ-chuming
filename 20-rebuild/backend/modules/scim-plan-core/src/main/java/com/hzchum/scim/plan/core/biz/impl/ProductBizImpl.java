package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductCategoryMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductDeepenMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.EnclosureCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.PlanProjectDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupByProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProjectProductMeteSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBizImpl implements ProductBiz {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAuxiliaryPartService auxiliaryPartService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private TechStandardPartService techStandardPartService;

   @Override
   public PageVO<ProjectProductMeteSumDTO> listMetByProduct(PlanProjectDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<ContractProject> projects = this.projectService.listByCondition(BeanUtil.copy(param, ProjectDTOParam.class));
      PageVO<ContractProject> projectPages = new PageVO<>(projects);
      PageVO<ProjectProductMeteSumDTO> result = new PageVO<>();
      result.setContent(
         projectPages.getContent()
            .stream()
            .map(
               project -> {
                  ProjectProductMeteSumDTO copy = new ProjectProductMeteSumDTO();
                  copy.setProject(BeanUtil.copy(project, ProjectInfo.class));
                  copy.setBusinessType(project.getBusinessType());
                  List<ProductCategoryMeteDTO> products = new ArrayList<>();
                  List<ProductMeteGroupByProjectDTO> artifactMenus = this.artifactService.sumMeteGroupByProject(project.getId());
                  List<EnclosureCategoryMeteDTO> enclosureMenus = this.enclosureService.sumCategoryMete(project.getId());
                  ProductMeteDO artifactIn = this.warehouseSummaryService
                     .sumMeteByCondition(project.getId(), null, null, ProductTypeEnum.ARTIFACT.getType(), WarehouseTypeEnum.INTO.getType());
                  ProductCategoryMeteDTO artifact = ProductCategoryMeteDTO.builder()
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .menuMete(CollectionUtils.isEmpty(artifactMenus) ? BigDecimal.ZERO : artifactMenus.get(0).getMete())
                     .finishMete(artifactIn.getMete())
                     .build();
                  products.add(artifact);
                  List<ProductCategoryMeteDO> enclosureIns = this.warehouseSummaryService.sumEnclosureMeteGroupCategory(project.getId());

                  for (EnclosureCategoryEnum value : EnclosureCategoryEnum.values()) {
                     BigDecimal finishMete = BigDecimal.ZERO;
                     Optional<ProductCategoryMeteDO> first = enclosureIns.stream().filter(e -> e.getCategory().equals(value.getCategory())).findFirst();
                     if (first.isPresent()) {
                        finishMete = first.get().getMete();
                     }

                     ProductCategoryMeteDTO enclosure = ProductCategoryMeteDTO.builder()
                        .productType(ProductTypeEnum.ENCLOSURE.getType())
                        .category(value.getCategory())
                        .menuMete(CollectionUtils.isEmpty(enclosureMenus) ? BigDecimal.ZERO : enclosureMenus.get(0).getMete())
                        .finishMete(finishMete)
                        .build();
                     products.add(enclosure);
                  }

                  copy.setProducts(products);
                  return copy;
               }
            )
            .collect(Collectors.toList())
      );
      result.setHasNextPage(projectPages.isHasNextPage());
      result.setHasPreviousPage(projectPages.isHasPreviousPage());
      result.setTotalElements(projectPages.getTotalElements());
      return result;
   }

   @Override
   public TechProductDTO getProductInfoBy(Long productId, Integer productType) {
      Preconditions.checkArgument(productId != null && productType != null, "产品id和产品类型不能为空!");
      TechProductDTO techProductDTO = new TechProductDTO();
      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         Preconditions.checkArgument(machinePart != null, "产品id有误,零件不存在!");
         BeanUtil.copy(machinePart, techProductDTO);
      }

      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "产品id有误,构件不存在!");
         BeanUtil.copy(artifact, techProductDTO);
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "产品id有误,组立不存在!");
         BeanUtil.copy(assemble, techProductDTO);
      }

      if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "产品id有误,围护不存在!");
         BeanUtil.copy(enclosure, techProductDTO);
      }

      if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(productType)) {
         TechStandardPart standardPart = this.techStandardPartService.getById(productId);
         Preconditions.checkArgument(standardPart != null, "产品id有误,配套件不存在!");
         BeanUtil.copy(standardPart, techProductDTO);
      }

      return techProductDTO;
   }

   @Override
   public TechProductDTO getProductIgnoreDelete(Long productId, Integer productType) {
      TechProductDTO techProductDTO = new TechProductDTO();
      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         TechMachinePart machinePart = this.machinePartService.getByIdIgnoreDelete(productId);
         Preconditions.checkArgument(machinePart != null, "产品id有误,零件不存在!");
         BeanUtil.copy(machinePart, techProductDTO);
      }

      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getByIdIgnoreDelete(productId);
         Preconditions.checkArgument(artifact != null, "产品id有误,构件不存在!");
         BeanUtil.copy(artifact, techProductDTO);
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getByIdIgnoreDelete(productId);
         Preconditions.checkArgument(assemble != null, "产品id有误,组立不存在!");
         BeanUtil.copy(assemble, techProductDTO);
      }

      if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         TechEnclosure enclosure = this.enclosureService.getByIdIgnoreDelete(productId);
         Preconditions.checkArgument(enclosure != null, "产品id有误,围护不存在!");
         BeanUtil.copy(enclosure, techProductDTO);
      }

      return techProductDTO;
   }

   @Override
   public ProductMeteDTO getDeepenMete(Long monomerId, Integer areaProductType) {
      Preconditions.checkArgument(monomerId != null && areaProductType != null, "缺少参数");
      ProductMeteDTO productMeteDTO = ProductMeteDTO.builder().quantity(0).mete(BigDecimal.ZERO).meteTwo(BigDecimal.ZERO).build();
      if (areaProductType.equals(AreaProductTypeEnum.STRUCTURE.getType()) || areaProductType.equals(AreaProductTypeEnum.BODY_PARTS.getType())) {
         productMeteDTO = this.artifactService.sumMeteByCondition(null, monomerId, null);
         productMeteDTO.setMete(productMeteDTO.getMete().divide(BigDecimal.valueOf(1000L)));
         productMeteDTO.setMeteTwo(productMeteDTO.getMeteTwo().divide(BigDecimal.valueOf(1000L)));
      }

      return productMeteDTO;
   }

   @Override
   public ProductMeteDTO getDeepenMete(Long projectId, Long monomerId, Long areaId, Integer productType) {
      Preconditions.checkArgument(productType != null, "产品类型不为空");
      Preconditions.checkArgument(productType.equals(ProductTypeEnum.ENCLOSURE.getType()) || productType.equals(ProductTypeEnum.ARTIFACT.getType()), "产品类型错误");
      ProductMeteDTO productMeteDTO;
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         productMeteDTO = this.enclosureService.sumMeteByProjectIdOrMonomerId(projectId, monomerId, areaId);
      } else {
         productMeteDTO = this.artifactService.sumMeteByCondition(projectId, monomerId, areaId);
      }

      return productMeteDTO;
   }

   @Override
   public ProductMeteDTO getDeepenMete(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在");
      if (AreaProductTypeEnum.STRUCTURE.getType().equals(area.getProductType())) {
         ProductMeteDTO productMeteDTO = this.artifactService.sumMeteByCondition(null, null, areaId);
         productMeteDTO.setMete(productMeteDTO.getMete().divide(BigDecimal.valueOf(1000L)));
         productMeteDTO.setMeteTwo(productMeteDTO.getMeteTwo().divide(BigDecimal.valueOf(1000L)));
         return productMeteDTO;
      } else {
         return this.enclosureService.sumMeteByProjectIdOrMonomerId(null, null, areaId);
      }
   }

   @Override
   public ProductMeteDTO getDeepenMeteV2(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在");
      if (ProjectPlanProductCategoryEnum.ARTIFACT.getType().equals(area.getProjectPlanProductCategory())) {
         ProductMeteDTO productMeteDTO = this.artifactService.sumMeteByCondition(null, null, areaId);
         productMeteDTO.setMete(productMeteDTO.getMete().divide(BigDecimal.valueOf(1000L)));
         productMeteDTO.setMeteTwo(productMeteDTO.getMeteTwo().divide(BigDecimal.valueOf(1000L)));
         return productMeteDTO;
      }

      if (ProjectPlanProductCategoryEnum.ENCLOSURE.getType().equals(area.getProjectPlanProductCategory())) {
         return this.enclosureService.sumMeteByProjectIdOrMonomerId(null, null, areaId);
      }

      Preconditions.checkArgument(false, "暂时支持的类型！");
      return null;
   }

   @Override
   public ProductDeepenMeteDTO getDeepenMete(Integer productType, Long productId) {
      ProductDeepenMeteDTO productMeteDTO = new ProductDeepenMeteDTO();
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "产品不存在");
         productMeteDTO.setQuantity(artifact.getQuantity());
         productMeteDTO.setMete(artifact.getTotalNetWeight());
         productMeteDTO.setTotalArea(
            artifact.getSurfaceArea().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L))
         );
      }

      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "产品不存在");
         productMeteDTO.setQuantity(enclosure.getQuantity());
         productMeteDTO.setMete(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
         productMeteDTO.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
      }

      if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         TechAuxiliaryPart auxiliaryPart = this.auxiliaryPartService.getById(productId);
         Preconditions.checkArgument(auxiliaryPart != null, "产品不存在");
         productMeteDTO.setQuantity(auxiliaryPart.getQuantity());
         productMeteDTO.setMete(auxiliaryPart.getTotalNetWeight());
         productMeteDTO.setTotalArea(
            auxiliaryPart.getSurfaceArea().multiply(BigDecimal.valueOf(auxiliaryPart.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L))
         );
      }

      return productMeteDTO;
   }

   @Override
   public void checkChangeArea(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      if (area.getProductType().equals(AreaProductTypeEnum.STRUCTURE.getType())) {
         int count = this.artifactService.count((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaId, areaId));
         Preconditions.checkArgument(count == 0, "该区域已存在零构件数据！");
         count = this.assembleService.count((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getAreaId, areaId));
         Preconditions.checkArgument(count == 0, "该区域已存在组立数据");
      } else {
         int count = this.enclosureService.count(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getEnclosurePlanId, areaId));
         Preconditions.checkArgument(count == 0, "该区域已存在围护数据");
      }
   }
}
