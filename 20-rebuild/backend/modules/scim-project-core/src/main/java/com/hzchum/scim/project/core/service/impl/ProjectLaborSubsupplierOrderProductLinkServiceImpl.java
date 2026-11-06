package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.mapper.ProjectLaborSubsupplierOrderProductLinkMapper;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectLaborSubsupplierOrderProductLinkServiceImpl
   extends ServiceImpl<ProjectLaborSubsupplierOrderProductLinkMapper, ProjectLaborSubsupplierOrderProductLink>
   implements ProjectLaborSubsupplierOrderProductLinkService {
   @Resource
   private ProjectLaborSubsupplierOrderProductLinkService orderProductLinkService;

   @Override
   public boolean saveInstallInfo(Long projectId, Long supplier, Integer productType, Long productId, BigDecimal reportQuantity) {
      ProjectLaborSubsupplierOrderProductLink updateProductLink = this.getOne(
         Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
            .eq(ProjectLaborSubsupplierOrderProductLink::getProjectId, projectId)
            .eq(ProjectLaborSubsupplierOrderProductLink::getSupplierId, supplier)
            .eq(ProjectLaborSubsupplierOrderProductLink::getProductType, productType)
            .eq(ProjectLaborSubsupplierOrderProductLink::getProductId, productId)
      );
      if (updateProductLink != null) {
         updateProductLink.setActualQuantity(updateProductLink.getActualQuantity().add(reportQuantity));
         if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
            updateProductLink.setActualMete(updateProductLink.getNetWeight().multiply(updateProductLink.getActualQuantity()));
            updateProductLink.setActualTotalArea(updateProductLink.getSurfaceArea().multiply(updateProductLink.getActualQuantity()));
         }

         if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            updateProductLink.setActualMete(updateProductLink.getLength().multiply(updateProductLink.getActualQuantity()));
            updateProductLink.setActualTotalArea(
               updateProductLink.getWeight().multiply(updateProductLink.getLength()).multiply(updateProductLink.getActualQuantity())
            );
         }

         this.orderProductLinkService.updateById(updateProductLink);
      }

      return true;
   }
}
