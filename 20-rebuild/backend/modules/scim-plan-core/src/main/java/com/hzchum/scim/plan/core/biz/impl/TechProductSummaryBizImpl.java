package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.biz.TechProductSummaryBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechProductSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.EnclosureCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechProductSummaryService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class TechProductSummaryBizImpl implements TechProductSummaryBiz {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechProductSummaryService productSummaryService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;

   @Override
   public void summaryProductData(Long projectId, Long monomerId, Long areaId, Integer productType) {
      this.productSummaryService.remove((Wrapper<TechProductSummary>)Wrappers.<TechProductSummary>lambdaQuery().eq(TechProductSummary::getAreaId, productType));
      if (!ProductTypeEnum.ARTIFACT.getType().equals(productType) && !ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         if (!ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
            throw new BusinessException("暂不支持改类型汇总");
         }

         List<EnclosureCategoryMeteDTO> metes = this.enclosureService.sumCategoryByAreaId(areaId);
         metes.forEach(mete -> {
            TechProductSummary summaryx = new TechProductSummary();
            summaryx.setProjectId(projectId);
            summaryx.setMonomerId(monomerId);
            summaryx.setAreaId(areaId);
            summaryx.setProductType(productType);
            summaryx.setCategory(mete.getCategory());
            summaryx.setQuantity(mete.getQuantity());
            summaryx.setMeteOne(mete.getMete());
            this.productSummaryService.save(summaryx);
         });
      } else {
         ProductMeteDTO productMete;
         if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            productMete = this.artifactService.sumMeteByCondition(projectId, monomerId, areaId);
         } else {
            productMete = this.machinePartService.sumMeteByCondition(areaId);
         }

         TechProductSummary summary = new TechProductSummary();
         summary.setProjectId(projectId);
         summary.setMonomerId(monomerId);
         summary.setAreaId(areaId);
         summary.setProductType(productType);
         summary.setCategory(null);
         summary.setQuantity(productMete.getQuantity());
         summary.setMeteOne(productMete.getMete());
         summary.setMeteTwo(productMete.getMeteTwo());
         this.productSummaryService.save(summary);
      }
   }

   @Override
   public ListVO<ProductMeteGroupDTO> summaryProduct(Long projectId, Long monomerId, Integer productType, Integer category, Integer permissionCheck) {
      if (UserUtil.getCurrentUser().isAdmin()) {
         permissionCheck = null;
      }

      if (permissionCheck != null && monomerId != null) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(
               Wrappers.lambdaQuery(MonomerUserLink.class)
                  .eq(MonomerUserLink::getMonomerId, monomerId)
                  .eq(MonomerUserLink::getDeepenedPersonId, UserUtil.getCurrentUser().getId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(monomerUserLinkList), "您没有查看此清单的权限!");
      }

      if (!ProductTypeEnum.ARTIFACT.getType().equals(productType) && !ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
            return new ListVO<>(this.enclosureService.sumMeteGroup(projectId, monomerId, category, permissionCheck, UserUtil.getCurrentUser().getId()));
         } else {
            throw new BusinessException("暂不支持改类型汇总");
         }
      } else {
         return ProductTypeEnum.ARTIFACT.getType().equals(productType)
            ? new ListVO<>(this.artifactService.sumMeteGroup(projectId, monomerId, permissionCheck, UserUtil.getCurrentUser().getId()))
            : new ListVO<>(this.machinePartService.sumMeteGroup(projectId, monomerId, permissionCheck, UserUtil.getCurrentUser().getId()));
      }
   }

   @Override
   public Map<String, Object> summaryProject(Long projectId, Integer productType) {
      Map<String, Object> map = new HashMap<>();
      int totalQuantity = 0;
      BigDecimal totalNetWeight = BigDecimal.ZERO;
      BigDecimal totalGrossWeight = BigDecimal.ZERO;
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         List<TechArtifact> artifacts = this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, projectId));
         if (CollectionUtils.isNotEmpty(artifacts)) {
            totalQuantity = artifacts.stream().mapToInt(TechArtifact::getQuantity).sum();
            totalNetWeight = artifacts.stream()
               .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            totalGrossWeight = artifacts.stream()
               .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         }
      }

      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         List<TechMachinePart> parts = this.machinePartService
            .list(
               (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, projectId))
                  .in(TechMachinePart::getRelationType, 2, 16)
            );
         if (CollectionUtils.isNotEmpty(parts)) {
            totalQuantity = parts.stream().mapToInt(TechMachinePart::getQuantity).sum();
            totalNetWeight = parts.stream()
               .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            totalGrossWeight = parts.stream()
               .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         }
      }

      map.put("totalQuantity", totalQuantity);
      map.put("totalNetWeight", totalNetWeight);
      map.put("totalGrossWeight", totalGrossWeight);
      return map;
   }
}
