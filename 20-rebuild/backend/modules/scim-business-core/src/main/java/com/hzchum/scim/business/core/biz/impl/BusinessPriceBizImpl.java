package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.biz.BusinessPriceBiz;
import com.hzchum.scim.business.core.api.enums.NewPricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingStatusEnum;
import com.hzchum.scim.business.core.api.enums.PricingUnitTypeEnum;
import com.hzchum.scim.business.core.api.enums.PricingWeightTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDetailDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceProjectDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceSummaryInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceAddParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceCheckParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceDetailParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceUpdateParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceDetailService;
import com.hzchum.scim.business.core.api.service.BusinessPriceService;
import com.hzchum.scim.business.core.mapper.BusinessPriceMapper;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessPriceBizImpl extends IBizImpl<BusinessPriceService, BusinessPriceMapper, BusinessPrice> implements BusinessPriceBiz {
   private static final Logger log = LoggerFactory.getLogger(BusinessPriceBizImpl.class);
   private final ContractProjectService projectService;
   private final ProjectUserLinkService projectUserLinkService;
   private final BranchCompanyService branchCompanyService;
   private final ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final UserService userService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final BusinessPriceDetailService businessPriceDetailService;

   @Override
   public List<BusinessPriceProjectDTO> listProjectForBusiness(LocalDateTime dateTime, String name, Long branchCompanyId) {
      List<Long> projectIds = this.getProjectIdList(branchCompanyId);
      if (projectIds.isEmpty()) {
         return Collections.emptyList();
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .apply(dateTime != null, "YEAR(create_time) = YEAR({0})", dateTime)
               .orderByDesc(ContractProject::getId)
         );
      projectList = projectList.stream()
         .filter(s -> StringUtils.isBlank(name) || s.getName().contains(name) || s.getShortName().contains(name) || s.getSerialNumber().contains(name))
         .collect(Collectors.toList());
      if (projectList.isEmpty()) {
         return Collections.emptyList();
      }

      projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, Integer> projectIdArtifactQuantityMap = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getProjectId, Collectors.summingInt(TechArtifact::getQuantity)));
      Map<Long, Integer> projectIdEnclosureQuantityMap = this.enclosureService
         .list(Wrappers.lambdaQuery(TechEnclosure.class).in(TechEnclosure::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(TechEnclosure::getProjectId, Collectors.summingInt(TechEnclosure::getQuantity)));
      Map<Long, BigDecimal> projectIdStandardPartQuantityMap = this.standardPartService
         .list(Wrappers.lambdaQuery(TechStandardPart.class).in(TechStandardPart::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(TechStandardPart::getProjectId, Collectors.reducing(BigDecimal.ZERO, TechStandardPart::getQuantity, BigDecimal::add)));
      Map<Long, BigDecimal> projectIdPricingQuantityMap = this.businessPriceDetailService
         .list(
            Wrappers.lambdaQuery(BusinessPriceDetail.class)
               .in(BusinessPriceDetail::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(BusinessPriceDetail::getProjectId, projectIds)
               .eq(branchCompanyId != null, BusinessPriceDetail::getBranchCompanyId, branchCompanyId)
         )
         .stream()
         .collect(
            Collectors.groupingBy(BusinessPriceDetail::getProjectId, Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetail::getQuantity, BigDecimal::add))
         );
      Map<Long, BigDecimal> projectQuantityMap = new HashMap<>(projectIds.size());
      projectIds.forEach(
         projectId -> {
            Integer artifactQuantity = projectIdArtifactQuantityMap.getOrDefault(projectId, 0);
            Integer enclosureQuantity = projectIdEnclosureQuantityMap.getOrDefault(projectId, 0);
            BigDecimal standardPartQuantity = projectIdStandardPartQuantityMap.getOrDefault(projectId, BigDecimal.ZERO);
            projectQuantityMap.put(
               projectId, BigDecimal.valueOf(artifactQuantity.intValue()).add(BigDecimal.valueOf(enclosureQuantity.intValue())).add(standardPartQuantity)
            );
         }
      );
      return projectList.stream()
         .filter(project -> projectQuantityMap.getOrDefault(project.getId(), BigDecimal.ZERO).compareTo(BigDecimal.ZERO) > 0)
         .map(project -> {
            BusinessPriceProjectDTO dto = BeanUtil.copy(project, BusinessPriceProjectDTO.class);
            BigDecimal totalQuantity = projectQuantityMap.get(project.getId());
            BigDecimal pricingQuantity = projectIdPricingQuantityMap.getOrDefault(project.getId(), BigDecimal.ZERO);
            if (pricingQuantity.compareTo(BigDecimal.ZERO) == 0) {
               dto.setPricingStatusEnum(PricingStatusEnum.UN_PRICING.getType());
            } else if (totalQuantity.compareTo(pricingQuantity) <= 0) {
               dto.setPricingStatusEnum(PricingStatusEnum.WHOLE_PRICING.getType());
            } else {
               dto.setPricingStatusEnum(PricingStatusEnum.PART_PRICING.getType());
            }

            return dto;
         })
         .collect(Collectors.toList());
   }

   @Override
   public BusinessPriceSummaryInfoDTO getPriceInfo(Long projectId, Integer productType, Long branchCompanyId) {
      Preconditions.checkArgument(branchCompanyId != null, "公司单位未知!");
      if (projectId == null) {
         return BusinessPriceSummaryInfoDTO.builder()
            .pricingQuantity(BigDecimal.ZERO)
            .pricingAmount(BigDecimal.ZERO)
            .unPricingQuantity(BigDecimal.ZERO)
            .build();
      }

      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      ProjectBranchCompanyLink companyLink = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, projectId)
               .eq(ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyId)
         );
      Preconditions.checkArgument(companyLink != null, "单位出现异常!!请刷新页面重试!!");
      List<BusinessPriceDetail> businessPriceDetailList = this.businessPriceDetailService
         .list(
            Wrappers.lambdaQuery(BusinessPriceDetail.class)
               .eq(BusinessPriceDetail::getProjectId, projectId)
               .eq(BusinessPriceDetail::getBranchCompanyId, branchCompanyId)
               .eq(productType != null, BusinessPriceDetail::getProductType, productType)
               .in(BusinessPriceDetail::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal pricingQuantity = businessPriceDetailList.stream().map(BusinessPriceDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<BusinessPriceDetailDTO> businessPriceDetailDTOList = this.getBusinessPriceDetailPricingMetePrice(businessPriceDetailList);
      BigDecimal pricingAmount = businessPriceDetailDTOList.stream().map(BusinessPriceDetailDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
      BusinessPriceSummaryInfoDTO priceSummaryInfoDTO = BusinessPriceSummaryInfoDTO.builder()
         .pricingQuantity(pricingQuantity)
         .pricingAmount(pricingAmount)
         .build();
      if (productType == null) {
         int artifactQuantity = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getProjectId, projectId))
            .stream()
            .mapToInt(TechArtifact::getQuantity)
            .sum();
         int enclosureQuantity = this.enclosureService
            .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId))
            .stream()
            .mapToInt(TechEnclosure::getQuantity)
            .sum();
         BigDecimal standardPartQuantity = this.standardPartService
            .list(
               Wrappers.lambdaQuery(TechStandardPart.class)
                  .eq(TechStandardPart::getProjectId, projectId)
                  .eq(
                     companyLink.getBranchCompanyLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType()),
                     TechStandardPart::getUseProperty,
                     AuxiliaryUsePropertyEnum.SITE_USE.getType()
                  )
            )
            .stream()
            .map(TechStandardPart::getQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal totalQuantity = BigDecimal.valueOf(artifactQuantity).add(BigDecimal.valueOf(enclosureQuantity)).add(standardPartQuantity);
         priceSummaryInfoDTO.setUnPricingQuantity(totalQuantity.compareTo(pricingQuantity) >= 0 ? totalQuantity.subtract(pricingQuantity) : BigDecimal.ZERO);
      } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         int totalQuantity = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getProjectId, projectId))
            .stream()
            .mapToInt(TechArtifact::getQuantity)
            .sum();
         priceSummaryInfoDTO.setUnPricingQuantity(
            totalQuantity >= pricingQuantity.intValue() ? BigDecimal.valueOf(totalQuantity).subtract(pricingQuantity) : BigDecimal.ZERO
         );
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         int totalQuantity = this.enclosureService
            .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId))
            .stream()
            .mapToInt(TechEnclosure::getQuantity)
            .sum();
         priceSummaryInfoDTO.setUnPricingQuantity(
            totalQuantity >= pricingQuantity.intValue() ? BigDecimal.valueOf(totalQuantity).subtract(pricingQuantity) : BigDecimal.ZERO
         );
      } else if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         BigDecimal totalQuantity = this.standardPartService
            .list(
               Wrappers.lambdaQuery(TechStandardPart.class)
                  .eq(TechStandardPart::getProjectId, projectId)
                  .eq(
                     companyLink.getBranchCompanyLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType()),
                     TechStandardPart::getUseProperty,
                     AuxiliaryUsePropertyEnum.SITE_USE.getType()
                  )
            )
            .stream()
            .map(TechStandardPart::getQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         priceSummaryInfoDTO.setUnPricingQuantity(totalQuantity.compareTo(pricingQuantity) >= 0 ? totalQuantity.subtract(pricingQuantity) : BigDecimal.ZERO);
      }

      return priceSummaryInfoDTO;
   }

   @Override
   public PageVO<BusinessBriceProductDTO> listUnPricingProduct(BusinessPriceProductQueryParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      ProjectBranchCompanyLink companyLink = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
               .eq(ProjectBranchCompanyLink::getBranchCompanyId, param.getBranchCompanyId())
         );
      Preconditions.checkArgument(companyLink != null, "单位出现异常!!请刷新页面重试!!");
      param.setBoolContractSignBody(param.getBranchCompanyId().equals(project.getContractSignBodyId()));
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.businessPriceDetailService.listUnPricingProduct(param));
   }

   @Override
   public PageVO<BusinessPriceDTO> pageListBusinessPrice(BusinessPriceQueryParam param, Integer pageNumber, Integer pageSize) {
      if (param.getProjectId() != null) {
         ProjectBranchCompanyLink companyLink = this.projectBranchCompanyLinkService
            .getOne(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
                  .eq(ProjectBranchCompanyLink::getBranchCompanyId, param.getBranchCompanyId())
            );
         Preconditions.checkArgument(companyLink != null, "单位出现异常!!请刷新页面重试!!");
      }

      List<Long> projectIdList = this.getProjectIdList(param.getBranchCompanyId());
      if (projectIdList.isEmpty()) {
         return new PageVO<>();
      }

      param.setProjectIds(projectIdList);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      if (param.getProjectId() == null) {
         param.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      }

      List<BusinessPrice> businessPriceList = this.baseService.listByCondition(param);
      List<BusinessPriceDTO> dtoList = this.listBusinessPrice(businessPriceList);
      return new PageVO<>(page, dtoList);
   }

   private List<BusinessPriceDTO> listBusinessPrice(List<BusinessPrice> businessPriceList) {
      if (businessPriceList.isEmpty()) {
         return Collections.emptyList();
      }

      List<BusinessPriceDetail> businessPriceDetailList = this.businessPriceDetailService
         .list(
            Wrappers.lambdaQuery(BusinessPriceDetail.class)
               .in(BusinessPriceDetail::getBusinessPriceId, businessPriceList.stream().map(BusinessPrice::getId).collect(Collectors.toList()))
         );
      List<BusinessPriceDetailDTO> businessPriceDetailDTOList = this.getBusinessPriceDetailPricingMetePrice(businessPriceDetailList);
      Map<Long, BigDecimal> businessPriceIdMeteMap = businessPriceDetailDTOList.stream()
         .collect(
            Collectors.groupingBy(
               BusinessPriceDetailDTO::getBusinessPriceId,
               Collectors.mapping(BusinessPriceDetailDTO::getPricingMete, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> businessPriceIdTotalPriceMap = businessPriceDetailDTOList.stream()
         .collect(
            Collectors.groupingBy(
               BusinessPriceDetailDTO::getBusinessPriceId,
               Collectors.mapping(BusinessPriceDetailDTO::getTotalPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> businessPriceIdTotalQuantityMap = businessPriceDetailDTOList.stream()
         .collect(
            Collectors.groupingBy(
               BusinessPriceDetailDTO::getBusinessPriceId, Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetailDTO::getQuantity, BigDecimal::add)
            )
         );
      Map<Long, BusinessPriceProjectDTO> projectMap = this.projectService
         .listByIds(businessPriceList.stream().map(BusinessPrice::getProjectId).collect(Collectors.toSet()))
         .stream()
         .map(project -> BeanUtil.copy(project, BusinessPriceProjectDTO.class))
         .collect(Collectors.toMap(BusinessPriceProjectDTO::getId, Function.identity()));
      Set<Long> userIds = businessPriceList.stream().map(BusinessPrice::getCreateUserId).collect(Collectors.toSet());
      Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
      return businessPriceList.stream().map(bp -> {
         BusinessPriceDTO dto = BeanUtil.copy(bp, BusinessPriceDTO.class);
         if (!bp.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            dto.setTotalQuantity(businessPriceIdTotalQuantityMap.get(bp.getId()));
            dto.setPricingMete(businessPriceIdMeteMap.get(bp.getId()).setScale(3, RoundingMode.HALF_UP));
         }

         dto.setTotalPrice(businessPriceIdTotalPriceMap.get(bp.getId()).setScale(2, RoundingMode.HALF_UP));
         dto.setProject(projectMap.get(bp.getProjectId()));
         dto.setCreateUserName(userMap.get(bp.getCreateUserId()));
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PageVO<BusinessPriceDetailDTO> listBusinessPriceDetail(Long businessPriceId, Integer pageNumber, Integer pageSize) {
      BusinessPrice businessPrice = this.baseService.getById(businessPriceId);
      Preconditions.checkArgument(businessPrice != null, "计价记录不存在!");
      List<BusinessPriceDetail> businessPriceDetailList = this.businessPriceDetailService
         .list(Wrappers.lambdaQuery(BusinessPriceDetail.class).eq(BusinessPriceDetail::getBusinessPriceId, businessPriceId));
      List<BusinessPriceDetailDTO> businessPriceDetailDTOList = this.getBusinessPriceDetailPricingMetePrice(businessPriceDetailList);
      businessPriceDetailDTOList.forEach(de -> {
         if (de.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            if (PricingUnitTypeEnum.KG.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(2, RoundingMode.HALF_UP));
            }

            if (PricingUnitTypeEnum.DUN.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(3, RoundingMode.HALF_UP));
            }

            if (PricingUnitTypeEnum.METRE.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(4, RoundingMode.HALF_UP));
            }
         }

         if (de.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            if (PricingUnitTypeEnum.METRE.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(2, RoundingMode.HALF_UP));
            }

            if (PricingUnitTypeEnum.SQUARE_METER.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(2, RoundingMode.HALF_UP));
            }

            if (PricingUnitTypeEnum.KG.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(2, RoundingMode.HALF_UP));
            }

            if (PricingUnitTypeEnum.DUN.getType().equals(de.getPricingUnitTypeEnum())) {
               de.setPricingMete(de.getPricingMete().setScale(3, RoundingMode.HALF_UP));
            }
         }
      });
      businessPriceDetailDTOList = businessPriceDetailDTOList.stream()
         .sorted(Comparator.comparing(BusinessPriceDetailDTO::getAuditStatus).thenComparing(BusinessPriceDetailDTO::getId))
         .collect(Collectors.toList());
      return new PageVO<>(businessPriceDetailDTOList);
   }

   private List<Long> getProjectIdList(Long branchCompanyId) {
      List<ProjectBranchCompanyLink> projectBranchCompanyLinkList = this.projectBranchCompanyLinkService
         .list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class).eq(branchCompanyId != null, ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyId));
      List<Long> projectIds = projectBranchCompanyLinkList.stream().map(ProjectBranchCompanyLink::getProjectId).collect(Collectors.toList());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!currentUser.isAdmin()) {
         List<ProjectUserLink> projectUserLinkList = this.projectUserLinkService
            .list(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getUserId, currentUser.getId()));
         List<Long> list = projectUserLinkList.stream().map(ProjectUserLink::getProjectId).collect(Collectors.toList());
         projectIds = projectIds.stream().filter(list::contains).collect(Collectors.toList());
      }

      return projectIds;
   }

   @Override
   public PrintVO<List<BusinessPriceDetailDTO>> printBusinessPriceDetail(Long businessPriceId) {
      BusinessPrice businessPrice = this.baseService.getById(businessPriceId);
      Preconditions.checkArgument(businessPrice != null, "计价记录不存在!");
      List<BusinessPriceDetail> businessPriceDetailList = this.businessPriceDetailService
         .list(Wrappers.lambdaQuery(BusinessPriceDetail.class).eq(BusinessPriceDetail::getBusinessPriceId, businessPriceId));
      List<BusinessPriceDetailDTO> businessPriceDetailDTOList = this.getBusinessPriceDetailPricingMetePrice(businessPriceDetailList);
      PrintVO<List<BusinessPriceDetailDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(businessPrice.getProjectId());
      header.put("project", project);
      header.put("pricingMannerEnum", businessPrice.getPricingMannerEnum());
      header.put("pricingUnitTypeEnum", businessPrice.getPricingUnitTypeEnum());
      header.put("pricingWeightTypeEnum", businessPrice.getPricingWeightTypeEnum());
      header.put("unitPrice", businessPrice.getUnitPrice());
      BigDecimal pricingMete = businessPriceDetailDTOList.stream().map(BusinessPriceDetailDTO::getPricingMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("pricingMete", pricingMete);
      BigDecimal totalPrice = businessPriceDetailDTOList.stream().map(BusinessPriceDetailDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalPrice", totalPrice);
      header.put("createUserName", this.userService.getNameById(businessPrice.getCreateUserId()));
      header.put("createTime", businessPrice.getCreateTime());
      printVO.setHeader(header);
      printVO.setTable(businessPriceDetailDTOList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addBusinessPrice(BusinessPriceAddParam param) {
      ProjectBranchCompanyLink projectBranchCompanyLink = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
               .eq(ProjectBranchCompanyLink::getBranchCompanyId, param.getBranchCompanyId())
         );
      Preconditions.checkArgument(projectBranchCompanyLink != null, "单位出现异常!!请刷新页面重试!!");
      BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "单位不存在!!请刷新重试!!");
      BusinessPrice businessPrice;
      if (param.getBoolAddEnum() != null && param.getBoolAddEnum()) {
         businessPrice = this.baseService.getById(param.getId());
         Preconditions.checkArgument(businessPrice != null, "选择的已创建名称不存在!");
         this.projectService.checkProjectStatus(businessPrice.getProjectId());
         BeanUtil.copy(businessPrice, param);
         param.setBoolAddEnum(true);
         businessPrice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         this.baseService.updateById(businessPrice);
      } else {
         this.projectService.checkProjectStatus(param.getProjectId());
         this.check(param);
         businessPrice = BeanUtil.copy(param, BusinessPrice.class);
         businessPrice.setLevel(branchCompany.getLevel());
         businessPrice.setCreateUserId(UserUtil.getCurrentUserId());
         businessPrice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         this.baseService.save(businessPrice);
      }

      List<BusinessPriceDetail> businessPriceDetailList = this.checkAddPriceDetails(param, branchCompany.getLevel());
      businessPriceDetailList.forEach(detail -> {
         detail.setBusinessPriceId(businessPrice.getId());
         detail.setBoolAddEnum(param.getBoolAddEnum());
         detail.setCreateUserId(UserUtil.getCurrentUserId());
         detail.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      });
      this.businessPriceDetailService.saveBatch(businessPriceDetailList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean checkBusinessPrice(BusinessPriceCheckParam param) {
      BusinessPrice businessPrice = this.baseService.getById(param.getId());
      Preconditions.checkArgument(businessPrice != null, "计价记录不存在!");
      Preconditions.checkArgument(businessPrice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "计价记录已审核!");
      List<BusinessPriceDetail> detailList = this.businessPriceDetailService
         .list(Wrappers.lambdaQuery(BusinessPriceDetail.class).eq(BusinessPriceDetail::getBusinessPriceId, param.getId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailList), "未查询到产品!");
      detailList.forEach(detail -> {
         if (detail.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())) {
            detail.setAuditStatus(param.getAuditStatus());
            detail.setAuditUserId(UserUtil.getCurrentUserId());
            detail.setAuditTime(LocalDateTime.now());
         }
      });
      this.businessPriceDetailService.updateBatchById(detailList);
      boolean anyMatch = detailList.stream().anyMatch(detail -> detail.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()));
      businessPrice.setAuditStatus(anyMatch ? AuditStatusEnum.SUCCEED.getType() : AuditStatusEnum.FAILED.getType());
      this.baseService.updateById(businessPrice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateBusinessPrice(BusinessPriceUpdateParam param) {
      BusinessPrice businessPrice = this.baseService.getById(param.getId());
      Preconditions.checkArgument(businessPrice != null, "计价记录不存在!");
      this.projectService.checkProjectStatus(businessPrice.getProjectId());
      BusinessPriceAddParam addParam = BeanUtil.copy(param, BusinessPriceAddParam.class);
      addParam.setProjectId(businessPrice.getProjectId());
      addParam.setBranchCompanyId(businessPrice.getBranchCompanyId());
      addParam.setProductType(businessPrice.getProductType());
      this.check(addParam);
      this.checkPricingQuantities(param.getBusinessPriceDetailList());
      this.businessPriceDetailService.remove(Wrappers.lambdaQuery(BusinessPriceDetail.builder().businessPriceId(param.getId()).build()));
      if (!businessPrice.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         && !businessPrice.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Map<Long, Map<BigDecimal, BigDecimal>> productIdUnitPriceQuantityMap = param.getBusinessPriceDetailList()
            .stream()
            .collect(
               Collectors.groupingBy(
                  BusinessPriceDetailParam::getProductId,
                  Collectors.groupingBy(
                     BusinessPriceDetailParam::getUnitPrice, Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetailParam::getQuantity, BigDecimal::add)
                  )
               )
            );
         List<BusinessPriceDetailParam> newDetailList = new ArrayList<>(productIdUnitPriceQuantityMap.keySet().size() * 2);
         productIdUnitPriceQuantityMap.forEach((productId, priceQuantityMap) -> priceQuantityMap.forEach((price, quantity) -> {
            BusinessPriceDetailParam detailParam = BusinessPriceDetailParam.builder().productId(productId).quantity(quantity).unitPrice(price).build();
            newDetailList.add(detailParam);
         }));
         addParam.setBusinessPriceDetailList(newDetailList);
      } else {
         Map<Long, BigDecimal> productIdQuantityMap = param.getBusinessPriceDetailList()
            .stream()
            .collect(
               Collectors.groupingBy(
                  BusinessPriceDetailParam::getProductId, Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetailParam::getQuantity, BigDecimal::add)
               )
            );
         List<BusinessPriceDetailParam> newDetailList = new ArrayList<>(productIdQuantityMap.keySet().size());
         productIdQuantityMap.forEach((productId, quantity) -> {
            BusinessPriceDetailParam detailParam = BusinessPriceDetailParam.builder().productId(productId).quantity(quantity).build();
            newDetailList.add(detailParam);
         });
         addParam.setBusinessPriceDetailList(newDetailList);
      }

      List<BusinessPriceDetail> businessPriceDetailList = this.checkAddPriceDetails(addParam, businessPrice.getLevel());
      this.businessPriceDetailService.saveBatch(businessPriceDetailList);
      BeanUtil.copy(addParam, businessPrice);
      businessPrice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.baseService.updateById(businessPrice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeBusinessPrice(Collection<Long> ids) {
      ids.forEach(id -> {
         BusinessPrice businessPrice = this.baseService.getById(id);
         Preconditions.checkArgument(businessPrice != null, "计价记录不存在!");
         this.projectService.checkProjectStatus(businessPrice.getProjectId());
         this.baseService.removeById(id);
         this.businessPriceDetailService.remove(Wrappers.lambdaQuery(BusinessPriceDetail.builder().businessPriceId(id).build()));
      });
      return true;
   }

   private List<BusinessPriceDetailDTO> getBusinessPriceDetailPricingMetePrice(List<BusinessPriceDetail> businessPriceDetailList) {
      Map<Integer, Set<Long>> productTypeProductIdsMap = businessPriceDetailList.stream()
         .collect(Collectors.groupingBy(BusinessPriceDetail::getProductType, Collectors.mapping(BusinessPriceDetail::getProductId, Collectors.toSet())));
      Map<Long, TechArtifact> artifactMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ARTIFACT.getType(), Collections.emptySet()).size()
      );
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ENCLOSURE.getType(), Collections.emptySet()).size()
      );
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.AUXILIARY_MATERIAL.getType(), Collections.emptySet()).size()
      );
      productTypeProductIdsMap.forEach(
         (productType, productIds) -> {
            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               artifactMap.putAll(this.artifactService.listByIds(productIds).stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity())));
            }

            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               enclosureMap.putAll(this.enclosureService.listByIds(productIds).stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity())));
            }

            if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               standardPartMap.putAll(
                  this.standardPartService.listByIds(productIds).stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()))
               );
            }
         }
      );
      businessPriceDetailList = businessPriceDetailList.stream()
         .filter(
            de -> {
               if (de.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  return artifactMap.containsKey(de.getProductId());
               } else {
                  return de.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
                     ? enclosureMap.containsKey(de.getProductId())
                     : standardPartMap.containsKey(de.getProductId());
               }
            }
         )
         .collect(Collectors.toList());
      if (businessPriceDetailList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> userMap = this.userService
         .listByIds(businessPriceDetailList.stream().map(BusinessPriceDetail::getAuditUserId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      List<BusinessPriceDetailDTO> businessPriceDetailDTOList = new ArrayList<>(businessPriceDetailList.size());
      businessPriceDetailList.forEach(
         s -> {
            BigDecimal pricingMete = BigDecimal.ZERO;
            BigDecimal totalPrice = BigDecimal.ZERO;
            BusinessPriceDetailDTO priceDetailDTO = BeanUtil.copy(s, BusinessPriceDetailDTO.class);
            priceDetailDTO.setAuditUserName(userMap.get(s.getAuditUserId()));
            if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(s.getProductId());
               pricingMete = this.getArtifactPricingMete(s, artifact);
               totalPrice = this.getArtifactTotalPrice(s, artifact);
               priceDetailDTO.setName(artifact.getName());
               priceDetailDTO.setSerialNumber(artifact.getSerialNumber());
               priceDetailDTO.setSpecification(artifact.getSpecification());
               priceDetailDTO.setMaterial(artifact.getMaterial());
               priceDetailDTO.setLength(artifact.getLength());
               priceDetailDTO.setTotalLength(artifact.getLength().multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               priceDetailDTO.setNetWeight(artifact.getNetWeight());
               priceDetailDTO.setTotalNetWeight(artifact.getNetWeight().multiply(s.getQuantity()));
               priceDetailDTO.setGrossWeight(artifact.getGrossWeight());
               priceDetailDTO.setTotalGrossWeight(artifact.getGrossWeight().multiply(s.getQuantity()));
               priceDetailDTO.setDrawingWeight(artifact.getDrawingWeight());
               priceDetailDTO.setDrawingTotalWeight(artifact.getDrawingWeight().multiply(s.getQuantity()));
            }

            if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure enclosure = enclosureMap.get(s.getProductId());
               pricingMete = this.getEnclosurePricingMete(s, enclosure);
               totalPrice = pricingMete.multiply(s.getUnitPrice());
               priceDetailDTO.setEnclosureType(EnclosureCategoryEnum.getNameByCategory(enclosure.getCategory()));
               priceDetailDTO.setName(enclosure.getName());
               priceDetailDTO.setSerialNumber(enclosure.getSerialNumber());
               priceDetailDTO.setSpecification(enclosure.getPlate());
               priceDetailDTO.setMaterial(enclosure.getMaterial());
               priceDetailDTO.setLength(enclosure.getLength());
               priceDetailDTO.setTotalLength(enclosure.getLength().multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               priceDetailDTO.setSurfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
               priceDetailDTO.setTotalArea(enclosure.getSurfaceArea().multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
               priceDetailDTO.setWeight(enclosure.getWeight());
               priceDetailDTO.setTotalWeight(enclosure.getWeight().multiply(s.getQuantity()));
            }

            if (s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               TechStandardPart standardPart = standardPartMap.get(s.getProductId());
               pricingMete = standardPart.getMete().multiply(s.getQuantity()).divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP);
               totalPrice = standardPart.getMete()
                  .multiply(s.getQuantity())
                  .multiply(s.getUnitPrice())
                  .divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP);
               priceDetailDTO.setName(standardPart.getName());
               priceDetailDTO.setSerialNumber(standardPart.getSerialNumber());
               priceDetailDTO.setSpecification(standardPart.getSpecification());
               priceDetailDTO.setMeasureUnit(standardPart.getMeasureUnit());
               priceDetailDTO.setAccountingUnit(standardPart.getAccountingUnit());
            }

            priceDetailDTO.setPricingMete(pricingMete);
            priceDetailDTO.setTotalPrice(totalPrice);
            businessPriceDetailDTOList.add(priceDetailDTO);
         }
      );
      return businessPriceDetailDTOList;
   }

   private BigDecimal getArtifactPricingMete(BusinessPriceDetail businessPriceDetail, TechArtifact artifact) {
      BigDecimal pricingMete = BigDecimal.ZERO;
      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
         BigDecimal singleWeight = businessPriceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.NET_WEIGHT.getType())
            ? artifact.getNetWeight()
            : (
               businessPriceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.GROSS_WEIGHT.getType())
                  ? artifact.getGrossWeight()
                  : artifact.getDrawingWeight()
            );
         pricingMete = businessPriceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
            ? singleWeight.multiply(businessPriceDetail.getQuantity())
            : singleWeight.multiply(businessPriceDetail.getQuantity()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
         pricingMete = artifact.getLength().multiply(businessPriceDetail.getQuantity()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
         pricingMete = businessPriceDetail.getQuantity();
      }

      return pricingMete;
   }

   private BigDecimal getArtifactTotalPrice(BusinessPriceDetail businessPriceDetail, TechArtifact artifact) {
      BigDecimal totalPrice = BigDecimal.ZERO;
      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
         BigDecimal singleWeight = businessPriceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.NET_WEIGHT.getType())
            ? artifact.getNetWeight()
            : (
               businessPriceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.GROSS_WEIGHT.getType())
                  ? artifact.getGrossWeight()
                  : artifact.getDrawingWeight()
            );
         totalPrice = singleWeight.multiply(businessPriceDetail.getQuantity()).multiply(businessPriceDetail.getUnitPrice());
         if (businessPriceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.DUN.getType())) {
            totalPrice = totalPrice.divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
         }
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
         totalPrice = artifact.getLength()
            .multiply(businessPriceDetail.getQuantity())
            .multiply(businessPriceDetail.getUnitPrice())
            .divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
         totalPrice = businessPriceDetail.getQuantity().multiply(businessPriceDetail.getUnitPrice());
      }

      return totalPrice;
   }

   private BigDecimal getEnclosurePricingMete(BusinessPriceDetail businessPriceDetail, TechEnclosure enclosure) {
      BigDecimal pricingMete = BigDecimal.ZERO;
      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
         pricingMete = enclosure.getLength().multiply(businessPriceDetail.getQuantity()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.AREA.getType())) {
         pricingMete = enclosure.getSurfaceArea().multiply(businessPriceDetail.getQuantity()).divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
         pricingMete = businessPriceDetail.getQuantity();
      }

      if (businessPriceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
         pricingMete = enclosure.getWeight().multiply(businessPriceDetail.getQuantity());
         if (businessPriceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.DUN.getType())) {
            pricingMete = pricingMete.divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
         }
      }

      return pricingMete;
   }

   private void check(BusinessPriceAddParam param) {
      Preconditions.checkArgument(
         param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()) || StringUtils.isNotBlank(param.getPricingName()), "未填写计价类型名称!"
      );
      if (!param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) && !param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Preconditions.checkArgument(
            param.getPricingMannerEnum() == null || param.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType()), "计价方式选择有误!"
         );
         if (param.getPricingMannerEnum() == null) {
            param.getBusinessPriceDetailList().forEach(de -> {
               Preconditions.checkArgument(de.getUnitPrice() != null, "配套件未填写单价!");
               Preconditions.checkArgument(de.getUnitPrice().compareTo(BigDecimal.ZERO) >= 0, "配套件单价填写有误!");
            });
         } else {
            Preconditions.checkArgument(param.getUnitPrice() != null, "未输入单价!");
            Preconditions.checkArgument(param.getUnitPrice().compareTo(BigDecimal.ZERO) >= 0, "单价填写有误!");
         }
      } else {
         Preconditions.checkArgument(NewPricingMannerEnum.isExist(param.getPricingMannerEnum()), "计价方式选择有误!");
         Preconditions.checkArgument(param.getUnitPrice() != null, "未输入单价!");
         Preconditions.checkArgument(param.getUnitPrice().compareTo(BigDecimal.ZERO) >= 0, "单价填写有误!");
         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Preconditions.checkArgument(!param.getPricingMannerEnum().equals(NewPricingMannerEnum.AREA.getType()), "计价方式选择有误!");
            if (param.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
               Preconditions.checkArgument(PricingWeightTypeEnum.isExist(param.getPricingWeightTypeEnum()), "构件计价重量类型选择有误!");
            } else {
               param.setPricingWeightTypeEnum(null);
               if (param.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
                  Preconditions.checkArgument(PricingUnitTypeEnum.JIAN.getType().equals(param.getPricingUnitTypeEnum()), "构件计价单位只能选择[件]!");
               }
            }
         }

         if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            param.setPricingWeightTypeEnum(null);
            if (param.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
               Preconditions.checkArgument(PricingUnitTypeEnum.ZHANG.getType().equals(param.getPricingUnitTypeEnum()), "围护计价单位只能选择[张]!");
            }
         }

         Preconditions.checkArgument(param.getPricingUnitTypeEnum() != null, "未选择计价单位!");
         List<Integer> pricingUnitTypeList = PricingUnitTypeEnum.listUnitTypeByPricingMannerEnum(param.getPricingMannerEnum());
         Preconditions.checkArgument(pricingUnitTypeList.contains(param.getPricingUnitTypeEnum()), "构件计价单位选择有误!");
      }
   }

   private void checkPricingQuantities(List<BusinessPriceDetailParam> details) {
      Preconditions.checkArgument(details != null && !details.isEmpty(), "计价产品不能为空!");
      for (BusinessPriceDetailParam detail : details)
         Preconditions.checkArgument(detail != null && detail.getProductId() != null && detail.getQuantity() != null
            && detail.getQuantity().compareTo(BigDecimal.ZERO) > 0, "计价数量必须大于0!");
   }

   private List<BusinessPriceDetail> checkAddPriceDetails(BusinessPriceAddParam param, Integer level) {
      this.checkPricingQuantities(param.getBusinessPriceDetailList());
      Map<Long, BigDecimal> requestedQuantityMap = param.getBusinessPriceDetailList().stream()
         .collect(Collectors.groupingBy(BusinessPriceDetailParam::getProductId,
            Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetailParam::getQuantity, BigDecimal::add)));
      List<Long> productIds = param.getBusinessPriceDetailList().stream().map(BusinessPriceDetailParam::getProductId).collect(Collectors.toList());
      Map<Long, BigDecimal> productIdPricingQuantityMap = this.businessPriceDetailService
         .list(
            Wrappers.lambdaQuery(BusinessPriceDetail.class)
               .eq(BusinessPriceDetail::getProjectId, param.getProjectId())
               .eq(BusinessPriceDetail::getBranchCompanyId, param.getBranchCompanyId())
               .eq(BusinessPriceDetail::getProductType, param.getProductType())
               .in(BusinessPriceDetail::getProductId, productIds)
               .in(BusinessPriceDetail::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(BusinessPriceDetail::getProductId, Collectors.reducing(BigDecimal.ZERO, BusinessPriceDetail::getQuantity, BigDecimal::add))
         );
      Map<Long, TechArtifact> artifactMap = new HashMap<>(productIds.size() * 2);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         artifactMap.putAll(this.artifactService.listByIds(productIds).stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity())));
      }

      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(productIds.size() * 2);
      if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         enclosureMap.putAll(this.enclosureService.listByIds(productIds).stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity())));
      }

      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(productIds.size() * 2);
      if (param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         standardPartMap.putAll(this.standardPartService.listByIds(productIds).stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity())));
      }

      List<BusinessPriceDetail> newBusinessPriceDetailList = new ArrayList<>(param.getBusinessPriceDetailList().size() * 2);
      param.getBusinessPriceDetailList()
         .forEach(
            detailParam -> {
               BusinessPriceDetail detail = BeanUtil.copy(param, BusinessPriceDetail.class);
               detail.setBusinessPriceId(param.getId());
               detail.setBranchCompanyId(param.getBranchCompanyId());
               detail.setLevel(level);
               detail.setProductId(detailParam.getProductId());
               detail.setQuantity(detailParam.getQuantity());
               detail.setUnitPrice(param.getUnitPrice() != null ? param.getUnitPrice() : detailParam.getUnitPrice());
               detail.setCreateUserId(UserUtil.getCurrentUserId());
               detail.setAuditStatus(AuditStatusEnum.AUDITING.getType());
               BigDecimal pricingQuantity = productIdPricingQuantityMap.getOrDefault(detailParam.getProductId(), BigDecimal.ZERO);
               BigDecimal requiredQuantity = requestedQuantityMap.get(detailParam.getProductId()).add(pricingQuantity);
               if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = artifactMap.get(detailParam.getProductId());
                  Preconditions.checkArgument(artifact != null, "构件不存在!");
                  Preconditions.checkArgument(Objects.equals(artifact.getProjectId(), param.getProjectId()), "构件不属于当前项目!");
                  log.info("构件id:[" + detailParam.getProductId() + "]");
                  Preconditions.checkArgument(
                     BigDecimal.valueOf(artifact.getQuantity()).compareTo(requiredQuantity) >= 0,
                     "[" + artifact.getSerialNumber() + "]计价数量超出可计价数量!!"
                  );
                  detail.setMonomerId(artifact.getMonomerId());
                  detail.setAreaId(artifact.getAreaId());
               }

               if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = enclosureMap.get(detailParam.getProductId());
                  Preconditions.checkArgument(enclosure != null, "围护不存在!");
                  Preconditions.checkArgument(Objects.equals(enclosure.getProjectId(), param.getProjectId()), "围护不属于当前项目!");
                  log.info("围护id:[" + detailParam.getProductId() + "]");
                  Preconditions.checkArgument(
                     BigDecimal.valueOf(enclosure.getQuantity()).compareTo(requiredQuantity) >= 0,
                     "[" + enclosure.getSerialNumber() + "]计价数量超出可计价数量!!"
                  );
                  detail.setMonomerId(enclosure.getMonomerId());
                  detail.setAreaId(enclosure.getAreaId());
               }

               if (param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart standardPart = standardPartMap.get(detailParam.getProductId());
                  Preconditions.checkArgument(standardPart != null, "配套件不存在!");
                  Preconditions.checkArgument(Objects.equals(standardPart.getProjectId(), param.getProjectId()), "配套件不属于当前项目!");
                  log.info("配套件id:[" + detailParam.getProductId() + "]");
                  Preconditions.checkArgument(
                     standardPart.getQuantity().compareTo(requiredQuantity) >= 0,
                     "[" + standardPart.getSerialNumber() + "]计价数量超出可计价数量!!"
                  );
                  detail.setMonomerId(standardPart.getMonomerId());
                  detail.setAreaId(standardPart.getAreaId());
               }

               newBusinessPriceDetailList.add(detail);
            }
         );
      return newBusinessPriceDetailList;
   }

   public BusinessPriceBizImpl(
      final ContractProjectService projectService,
      final ProjectUserLinkService projectUserLinkService,
      final BranchCompanyService branchCompanyService,
      final ProjectBranchCompanyLinkService projectBranchCompanyLinkService,
      final UserService userService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final BusinessPriceDetailService businessPriceDetailService
   ) {
      this.projectService = projectService;
      this.projectUserLinkService = projectUserLinkService;
      this.branchCompanyService = branchCompanyService;
      this.projectBranchCompanyLinkService = projectBranchCompanyLinkService;
      this.userService = userService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.businessPriceDetailService = businessPriceDetailService;
   }
}
