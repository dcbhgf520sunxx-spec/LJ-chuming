package com.hzchum.scim.project.core.utils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallMeteDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.api.utils.ProjectInstallBizUtil;
import java.math.BigDecimal;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectInstallBizUtilImpl implements ProjectInstallBizUtil {
   private static final Logger log = LoggerFactory.getLogger(ProjectInstallBizUtilImpl.class);
   @Resource
   private PlanAreaService areaService;
   @Resource
   private ProjectInstallSummaryService installSummaryService;
   @Resource
   private ProjectInstallReportService installReportService;

   @Override
   public ProjectInstallMeteSummaryDTO getActualInstallMete(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在");
      ProjectInstallMeteDO meteDO = this.installSummaryService.getActualInstallMete(null, null, areaId, null, null);
      ProjectInstallMeteSummaryDTO installMeteSummaryDTO;
      if (area.getProductCategory().equals(ProjectContentCategoryEnum.ENCLOSURE.getType())) {
         installMeteSummaryDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete().divide(BigDecimal.valueOf(1000L)))
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      } else {
         installMeteSummaryDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete())
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      }

      return installMeteSummaryDTO;
   }

   @Override
   public ProjectInstallMeteSummaryDTO getActualInstallMete(Long projectId, Long monomerId, Long areaId, Integer productType, Integer category) {
      Preconditions.checkArgument(productType != null, "产品类型不能为空");
      Preconditions.checkArgument(projectId != null || monomerId != null || areaId != null, "项目/单体/区域的ID不能全为空!");
      ProjectInstallMeteSummaryDTO meteDTO;
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         ProjectInstallMeteDO meteDO = this.installSummaryService.getActualInstallMete(projectId, monomerId, areaId, productType, category);
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete().divide(BigDecimal.valueOf(1000L)))
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      } else {
         ProjectInstallMeteDO meteDO = this.installSummaryService.getActualInstallMete(projectId, monomerId, areaId, productType, null);
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete())
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      }

      return meteDTO;
   }

   @Override
   public ProjectInstallMeteSummaryDTO getActualInstallMete(Integer projectType, Long productId, Integer productType) {
      ProjectInstallSummary installSummary = this.installSummaryService
         .getOne(
            Wrappers.lambdaQuery(ProjectInstallSummary.class)
               .eq(ProjectInstallSummary::getProjectType, projectType)
               .eq(ProjectInstallSummary::getProductType, productType)
               .eq(ProjectInstallSummary::getProductId, productId)
         );
      ProjectInstallMeteSummaryDTO meteDTO;
      if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(installSummary != null ? installSummary.getActualQuantity() : BigDecimal.ZERO)
            .actualMete(installSummary != null ? installSummary.getActualMete().divide(BigDecimal.valueOf(1000L)) : BigDecimal.ZERO)
            .actualTotalArea(installSummary != null ? installSummary.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO)
            .build();
      } else {
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(installSummary != null ? installSummary.getActualQuantity() : BigDecimal.ZERO)
            .actualMete(installSummary != null ? installSummary.getActualMete() : BigDecimal.ZERO)
            .actualTotalArea(installSummary != null ? installSummary.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO)
            .build();
      }

      return meteDTO;
   }

   @Override
   public ProjectInstallMeteSummaryDTO getActualInstallMete(Long supplierId, Long areaId) {
      Preconditions.checkArgument(supplierId != null && areaId != null, "供应商ID和区域id不能为空");
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "有区域不存在");
      ProjectInstallMeteDO meteDO = this.installReportService.getActualInstallMete(supplierId, null, null, areaId, null, null);
      ProjectInstallMeteSummaryDTO meteDTO;
      if (area.getProductType().equals(AreaProductTypeEnum.STRUCTURE.getType())) {
         meteDTO = BeanUtil.copy(meteDO, ProjectInstallMeteSummaryDTO.class);
      } else {
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete().divide(BigDecimal.valueOf(1000L)))
            .build();
      }

      return meteDTO;
   }

   @Override
   public ProjectInstallMeteSummaryDTO getActualInstallMete(
      @NotNull Long supplierId, Long projectId, Long monomerId, Long areaId, @NotNull Integer productType, Integer category
   ) {
      Preconditions.checkArgument(supplierId != null && productType != null, "供应商ID和产品类型不能为空");
      Preconditions.checkArgument(projectId != null || monomerId != null || areaId != null, "项目/单体/区域的id不能全为空!");
      ProjectInstallMeteSummaryDTO meteDTO;
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         ProjectInstallMeteDO meteDO = this.installReportService.getActualInstallMete(supplierId, projectId, monomerId, areaId, productType, category);
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete().divide(BigDecimal.valueOf(1000L)))
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      } else {
         ProjectInstallMeteDO meteDO = this.installReportService.getActualInstallMete(supplierId, projectId, monomerId, null, productType, null);
         meteDTO = ProjectInstallMeteSummaryDTO.builder()
            .actualQuantity(meteDO.getActualQuantity())
            .actualMete(meteDO.getActualMete())
            .actualTotalArea(meteDO.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)))
            .build();
      }

      return meteDTO;
   }
}
