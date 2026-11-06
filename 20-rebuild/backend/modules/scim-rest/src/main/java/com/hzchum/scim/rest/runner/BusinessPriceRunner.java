package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.NewPricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingUnitTypeEnum;
import com.hzchum.scim.business.core.api.enums.PricingWeightTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessPriceDetailService;
import com.hzchum.scim.business.core.api.service.BusinessPriceService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BusinessPriceRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(BusinessPriceRunner.class);
   private final ContractProjectService projectService;
   private final BranchCompanyService branchCompanyService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final BusinessArtifactService businessArtifactService;
   private final BusinessEnclosureService businessEnclosureService;
   private final BusinessStandardPartService businessStandardPartService;
   private final BusinessPriceService businessPriceService;
   private final BusinessPriceDetailService businessPriceDetailService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<BusinessArtifact> businessArtifactList = this.businessArtifactService
         .list(Wrappers.lambdaQuery(BusinessArtifact.class).isNotNull(BusinessArtifact::getUnitPrice).last("limit 1"));
      List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
         .list(Wrappers.lambdaQuery(BusinessEnclosure.class).isNotNull(BusinessEnclosure::getUnitPrice).last("limit 1"));
      List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
         .list(Wrappers.lambdaQuery(BusinessStandardPart.class).isNotNull(BusinessStandardPart::getUnitPrice).last("limit 1"));
      List<BusinessPrice> businessPriceList = this.businessPriceService.list(Wrappers.lambdaQuery(BusinessPrice.class).last("limit 1"));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractProject> projectList = this.projectService.list();
      boolean existBusinessPrice = CollectionUtils.isNotEmpty(businessArtifactList)
         || CollectionUtils.isNotEmpty(businessEnclosureList)
         || CollectionUtils.isNotEmpty(businessStandardPartList);
      if (existBusinessPrice && businessPriceList.isEmpty()) {
         projectList.forEach(project -> {
            BranchCompany branchCompany = branchCompanyMap.get(project.getContractSignBodyId());
            Integer level = branchCompany != null ? branchCompany.getLevel() : null;
            this.initArtifactPrice(project.getId(), project.getContractSignBodyId(), level);
            this.initEnclosurePrice(project.getId(), project.getContractSignBodyId(), level);
            this.initStandardPart(project.getId(), project.getContractSignBodyId(), level);
         });
      }

      businessPriceList = this.businessPriceService.list(Wrappers.lambdaQuery(BusinessPrice.class).eq(BusinessPrice::getBranchCompanyId, 0L));
      if (CollectionUtils.isNotEmpty(businessPriceList)) {
         Map<Long, List<BusinessPrice>> projectIdListMap = businessPriceList.stream().collect(Collectors.groupingBy(BusinessPrice::getProjectId));
         Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         projectIdListMap.forEach((projectId, priceList) -> {
            ContractProject project = projectMap.get(projectId);
            Long branchCompanyId = project != null ? project.getContractSignBodyId() : null;
            BranchCompany branchCompany = branchCompanyMap.get(branchCompanyId);
            Integer level = branchCompany != null ? branchCompany.getLevel() : null;
            priceList.forEach(businessPrice -> {
               businessPrice.setBranchCompanyId(branchCompanyId);
               businessPrice.setLevel(level);
            });
         });
         List<BusinessPriceDetail> priceDetailList = this.businessPriceDetailService
            .list(Wrappers.lambdaQuery(BusinessPriceDetail.class).eq(BusinessPriceDetail::getBranchCompanyId, 0L));
         Map<Long, List<BusinessPriceDetail>> projectIdDetailsMap = priceDetailList.stream().collect(Collectors.groupingBy(BusinessPriceDetail::getProjectId));
         projectIdDetailsMap.forEach((projectId, priceDetails) -> {
            ContractProject project = projectMap.get(projectId);
            BranchCompany branchCompany = branchCompanyMap.get(project.getContractSignBodyId());
            priceDetails.forEach(detail -> {
               detail.setBranchCompanyId(project.getContractSignBodyId());
               detail.setLevel(branchCompany.getLevel());
            });
         });
         this.businessPriceService.updateBatchById(businessPriceList);
         this.businessPriceDetailService.updateBatchById(priceDetailList);
      }
   }

   private void initArtifactPrice(Long projectId, Long branchCompanyId, Integer level) {
      List<BusinessArtifact> businessArtifactList = this.businessArtifactService
         .list(Wrappers.lambdaQuery(BusinessArtifact.class).eq(BusinessArtifact::getProjectId, projectId).isNotNull(BusinessArtifact::getUnitPrice));
      if (!businessArtifactList.isEmpty()) {
         List<TechArtifact> artifactList = this.artifactService
            .list(
               Wrappers.lambdaQuery(TechArtifact.class)
                  .eq(TechArtifact::getProjectId, projectId)
                  .in(TechArtifact::getBusinessId, businessArtifactList.stream().map(BusinessArtifact::getId).collect(Collectors.toList()))
            );
         Map<Long, List<TechArtifact>> businessIdListMap = artifactList.stream().collect(Collectors.groupingBy(TechArtifact::getBusinessId));
         businessArtifactList.forEach(
            bs -> {
               List<TechArtifact> artifacts = businessIdListMap.get(bs.getId());
               int sum = artifacts.stream().mapToInt(TechArtifact::getQuantity).sum();
               if (!bs.getTotalQuantity().equals(sum)) {
                  BigDecimal totalWeight = artifacts.stream().map(TechArtifact::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal totalLength = artifacts.stream()
                     .map(artifact -> artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  bs.setTotalQuantity(sum);
                  bs.setTotalWeight(totalWeight);
                  bs.setTotalLength(totalLength.divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP));
               }

               if (bs.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())) {
                  bs.setTotalPrice(bs.getTotalWeight().multiply(bs.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP));
               } else {
                  bs.setTotalPrice(bs.getTotalLength().multiply(bs.getUnitPrice()));
               }
            }
         );
         Map<String, List<BusinessArtifact>> collectMap = businessArtifactList.stream()
            .collect(Collectors.groupingBy(bs -> bs.getPricingManner() + "_" + bs.getName() + "_" + bs.getUnitPrice()));
         collectMap.forEach(
            (key, bsArtifactList) -> {
               String[] splitArr = key.split("_");
               Integer oldPricingManner = Integer.valueOf(splitArr[0]);
               String name = splitArr[1];
               BigDecimal unitPrice = new BigDecimal(splitArr[2]);
               BusinessPrice businessPrice = BusinessPrice.builder()
                  .projectId(projectId)
                  .branchCompanyId(branchCompanyId)
                  .level(level)
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .pricingName(name)
                  .pricingMannerEnum(
                     oldPricingManner.equals(PricingMannerEnum.WEIGHT.getType())
                        ? NewPricingMannerEnum.WEIGHT.getType()
                        : NewPricingMannerEnum.LENGTH.getType()
                  )
                  .pricingUnitTypeEnum(
                     oldPricingManner.equals(PricingMannerEnum.WEIGHT.getType()) ? PricingUnitTypeEnum.DUN.getType() : PricingUnitTypeEnum.METRE.getType()
                  )
                  .pricingWeightTypeEnum(oldPricingManner.equals(PricingMannerEnum.WEIGHT.getType()) ? PricingWeightTypeEnum.NET_WEIGHT.getType() : null)
                  .unitPrice(unitPrice)
                  .remark("初始化旧数据")
                  .createUserId(0L)
                  .auditStatus(AuditStatusEnum.SUCCEED.getType())
                  .build();
               this.businessPriceService.save(businessPrice);
               List<BusinessPriceDetail> businessPriceDetailList = new ArrayList<>(artifactList.size() * 2);
               bsArtifactList.forEach(
                  bs -> {
                     List<TechArtifact> artifacts = businessIdListMap.get(bs.getId());
                     artifacts.forEach(
                        artifact -> {
                           BusinessPriceDetail businessPriceDetail = this.buildBusinessPriceDetail(
                              businessPrice,
                              null,
                              artifact.getProjectId(),
                              artifact.getMonomerId(),
                              artifact.getAreaId(),
                              artifact.getId(),
                              BigDecimal.valueOf(artifact.getQuantity().intValue())
                           );
                           businessPriceDetailList.add(businessPriceDetail);
                        }
                     );
                  }
               );
               this.businessPriceDetailService.saveBatch(businessPriceDetailList);
            }
         );
      }
   }

   private void initEnclosurePrice(Long projectId, Long branchCompanyId, Integer level) {
      List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
         .list(Wrappers.lambdaQuery(BusinessEnclosure.class).eq(BusinessEnclosure::getProjectId, projectId).isNotNull(BusinessEnclosure::getUnitPrice));
      if (!businessEnclosureList.isEmpty()) {
         businessEnclosureList.forEach(bs -> {
            if (bs.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())) {
               bs.setTotalPrice(bs.getTotalLength().multiply(bs.getUnitPrice()));
            } else {
               bs.setTotalPrice(bs.getTotalArea().multiply(bs.getUnitPrice()));
            }
         });
         Map<String, List<BusinessEnclosure>> collectMap = businessEnclosureList.stream()
            .collect(Collectors.groupingBy(bs -> bs.getPricingManner() + "_" + bs.getName() + "_" + bs.getUnitPrice()));
         List<TechEnclosure> enclosureList = this.enclosureService
            .list(
               Wrappers.lambdaQuery(TechEnclosure.class)
                  .eq(TechEnclosure::getProjectId, projectId)
                  .in(TechEnclosure::getBusinessId, businessEnclosureList.stream().map(BusinessEnclosure::getId).collect(Collectors.toList()))
            );
         Map<Long, List<TechEnclosure>> businessIdListMap = enclosureList.stream().collect(Collectors.groupingBy(TechEnclosure::getBusinessId));
         collectMap.forEach(
            (key, businessEnclosures) -> {
               String[] splitArr = key.split("_");
               Integer oldPricingManner = Integer.valueOf(splitArr[0]);
               String name = splitArr[1];
               BigDecimal unitPrice = new BigDecimal(splitArr[2]);
               if (oldPricingManner.equals(EnclosurePricingMannerEnum.LENGTH.getType())) {
                  BigDecimal pricingMete = businessEnclosures.stream().map(BusinessEnclosure::getTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add);
               } else {
                  BigDecimal pricingMete = businessEnclosures.stream().map(BusinessEnclosure::getTotalArea).reduce(BigDecimal.ZERO, BigDecimal::add);
               }

               BusinessPrice businessPrice = BusinessPrice.builder()
                  .projectId(projectId)
                  .branchCompanyId(branchCompanyId)
                  .level(level)
                  .productType(ProductTypeEnum.ENCLOSURE.getType())
                  .pricingName(name)
                  .pricingMannerEnum(
                     oldPricingManner.equals(EnclosurePricingMannerEnum.LENGTH.getType())
                        ? NewPricingMannerEnum.LENGTH.getType()
                        : NewPricingMannerEnum.AREA.getType()
                  )
                  .pricingUnitTypeEnum(
                     oldPricingManner.equals(EnclosurePricingMannerEnum.LENGTH.getType())
                        ? PricingUnitTypeEnum.METRE.getType()
                        : PricingUnitTypeEnum.SQUARE_METER.getType()
                  )
                  .pricingWeightTypeEnum(null)
                  .unitPrice(unitPrice)
                  .remark("初始化旧数据")
                  .createUserId(0L)
                  .auditStatus(AuditStatusEnum.SUCCEED.getType())
                  .build();
               this.businessPriceService.save(businessPrice);
               List<BusinessPriceDetail> businessPriceDetailList = new ArrayList<>(enclosureList.size() * 2);
               businessEnclosures.forEach(
                  bs -> {
                     List<TechEnclosure> enclosures = businessIdListMap.get(bs.getId());
                     enclosures.forEach(
                        enclosure -> {
                           BusinessPriceDetail businessPriceDetail = this.buildBusinessPriceDetail(
                              businessPrice,
                              null,
                              enclosure.getProjectId(),
                              null,
                              null,
                              enclosure.getId(),
                              BigDecimal.valueOf(enclosure.getQuantity().intValue())
                           );
                           businessPriceDetailList.add(businessPriceDetail);
                        }
                     );
                  }
               );
               this.businessPriceDetailService.saveBatch(businessPriceDetailList);
            }
         );
      }
   }

   private void initStandardPart(Long projectId, Long branchCompanyId, Integer level) {
      List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
         .list(Wrappers.lambdaQuery(BusinessStandardPart.class).eq(BusinessStandardPart::getProjectId, projectId).isNotNull(BusinessStandardPart::getUnitPrice));
      if (!businessStandardPartList.isEmpty()) {
         businessStandardPartList.forEach(bs -> bs.setTotalPrice(bs.getUnitPrice().multiply(bs.getMete())));
         List<TechStandardPart> standardPartList = this.standardPartService
            .list(
               Wrappers.lambdaQuery(TechStandardPart.class)
                  .eq(TechStandardPart::getProjectId, projectId)
                  .in(TechStandardPart::getBusinessId, businessStandardPartList.stream().map(BusinessStandardPart::getId).collect(Collectors.toList()))
            );
         Map<Long, List<TechStandardPart>> businessIdListMap = standardPartList.stream().collect(Collectors.groupingBy(TechStandardPart::getBusinessId));
         BusinessPrice businessPrice = BusinessPrice.builder()
            .projectId(projectId)
            .branchCompanyId(branchCompanyId)
            .level(level)
            .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
            .remark("初始化旧数据")
            .createUserId(0L)
            .auditStatus(AuditStatusEnum.SUCCEED.getType())
            .build();
         this.businessPriceService.save(businessPrice);
         List<BusinessPriceDetail> businessPriceDetailList = new ArrayList<>(standardPartList.size() * 2);
         businessStandardPartList.forEach(
            bs -> {
               List<TechStandardPart> standardParts = businessIdListMap.get(bs.getId());
               standardParts.forEach(
                  standardPart -> {
                     BusinessPriceDetail businessPriceDetail = this.buildBusinessPriceDetail(
                        businessPrice,
                        bs.getUnitPrice(),
                        standardPart.getProjectId(),
                        standardPart.getMonomerId(),
                        standardPart.getAreaId(),
                        standardPart.getId(),
                        standardPart.getQuantity()
                     );
                     businessPriceDetailList.add(businessPriceDetail);
                  }
               );
            }
         );
         this.businessPriceDetailService.saveBatch(businessPriceDetailList);
      }
   }

   private BusinessPriceDetail buildBusinessPriceDetail(
      BusinessPrice businessPrice, BigDecimal unitPrice, Long projectId, Long monomerId, Long areaId, Long productId, BigDecimal quantity
   ) {
      return BusinessPriceDetail.builder()
         .businessPriceId(businessPrice.getId())
         .projectId(projectId)
         .monomerId(monomerId)
         .areaId(areaId)
         .branchCompanyId(businessPrice.getBranchCompanyId())
         .level(businessPrice.getLevel())
         .pricingMannerEnum(businessPrice.getPricingMannerEnum())
         .pricingUnitTypeEnum(businessPrice.getPricingUnitTypeEnum())
         .pricingWeightTypeEnum(businessPrice.getPricingWeightTypeEnum())
         .productType(businessPrice.getProductType())
         .productId(productId)
         .quantity(quantity)
         .unitPrice(businessPrice.getUnitPrice() != null ? businessPrice.getUnitPrice() : unitPrice)
         .createUserId(0L)
         .auditStatus(AuditStatusEnum.SUCCEED.getType())
         .auditTime(LocalDateTime.now())
         .auditUserId(0L)
         .build();
   }

   public BusinessPriceRunner(
      final ContractProjectService projectService,
      final BranchCompanyService branchCompanyService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final BusinessArtifactService businessArtifactService,
      final BusinessEnclosureService businessEnclosureService,
      final BusinessStandardPartService businessStandardPartService,
      final BusinessPriceService businessPriceService,
      final BusinessPriceDetailService businessPriceDetailService
   ) {
      this.projectService = projectService;
      this.branchCompanyService = branchCompanyService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.businessArtifactService = businessArtifactService;
      this.businessEnclosureService = businessEnclosureService;
      this.businessStandardPartService = businessStandardPartService;
      this.businessPriceService = businessPriceService;
      this.businessPriceDetailService = businessPriceDetailService;
   }
}
