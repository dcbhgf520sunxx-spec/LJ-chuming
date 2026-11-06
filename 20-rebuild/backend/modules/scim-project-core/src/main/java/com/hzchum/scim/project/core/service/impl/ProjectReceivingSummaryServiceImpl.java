package com.hzchum.scim.project.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReceivingMeteDO;
import com.hzchum.scim.project.core.api.pojo.daoParam.ReceivingBoardQueryDOParam;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.project.core.mapper.ProjectReceivingSummaryMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectReceivingSummaryServiceImpl
   extends ServiceImpl<ProjectReceivingSummaryMapper, ProjectReceivingSummary>
   implements ProjectReceivingSummaryService {
   @Resource
   private MeasureService measureService;
   @Resource
   private PurchaseOrderDetailService orderDetailService;

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateReceivingSummary(ProjectReceivingRecord record) {
      ProjectReceivingSummary receivingSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectReceivingSummary.class)
               .eq(ProjectReceivingSummary::getProjectType, record.getProjectType())
               .eq(ProjectReceivingSummary::getProductType, record.getProductType())
               .eq(ProjectReceivingSummary::getProductId, record.getProductId())
         );
      if (receivingSummary == null) {
         receivingSummary = BeanUtil.copy(record, ProjectReceivingSummary.class);
         receivingSummary.setInstallQuantity(BigDecimal.ZERO);
         this.baseMapper.insert(receivingSummary);
      } else {
         receivingSummary.setQuantity(receivingSummary.getQuantity().add(record.getQuantity()));
         receivingSummary.setMete(receivingSummary.getMete().add(record.getMete()));
         receivingSummary.setTotalArea(receivingSummary.getTotalArea().add(record.getTotalArea()));
         this.baseMapper.updateById(receivingSummary);
      }

      return true;
   }

   @Override
   public Boolean reduceMete(ProjectReceivingRecord record) {
      if (record.getProductType() == 32) {
         ProjectReceivingSummary receivingSummary = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(ProjectReceivingSummary.class)
                  .eq(ProjectReceivingSummary::getProjectType, record.getProjectType())
                  .eq(ProjectReceivingSummary::getProductType, record.getProductType())
                  .eq(ProjectReceivingSummary::getPurchaseDetailsId, record.getPurchaseDetailsId())
            );
         if (receivingSummary == null) {
            throw new BusinessException("操作失败，未获取到库存中产品信息！");
         }

         receivingSummary.setQuantity(receivingSummary.getQuantity().subtract(record.getQuantity()));
         receivingSummary.setMete(receivingSummary.getMete().subtract(record.getMete()));
         receivingSummary.setActualReceivedMete(receivingSummary.getActualReceivedMete().subtract(record.getActualReceivedMete()));
         this.baseMapper.updateById(receivingSummary);
         PurchaseOrderDetail orderDetail = this.orderDetailService.getById(receivingSummary.getPurchaseDetailsId());
         Preconditions.checkArgument(orderDetail != null, "获取采购详情信息失败！");
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(orderDetail.getClassifyId());
         Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
         if (StrUtil.isNotBlank(subjectMeasureDTO.getMeasureUnit())) {
            if (receivingSummary.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
               this.baseMapper.deleteById(receivingSummary.getId());
            }
         } else if (BigDecimal.ZERO.compareTo(receivingSummary.getMete()) == 0) {
            this.baseMapper.deleteById(receivingSummary.getId());
         }
      } else {
         ProjectReceivingSummary receivingSummary = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(ProjectReceivingSummary.class)
                  .eq(ProjectReceivingSummary::getProjectType, record.getProjectType())
                  .eq(ProjectReceivingSummary::getProductType, record.getProductType())
                  .eq(ProjectReceivingSummary::getProductId, record.getProductId())
            );
         if (receivingSummary == null) {
            throw new BusinessException("操作失败，未获取到库存中产品信息！");
         }

         receivingSummary.setQuantity(receivingSummary.getQuantity().subtract(record.getQuantity()));
         receivingSummary.setMete(receivingSummary.getMete().subtract(record.getMete()));
         receivingSummary.setTotalArea(receivingSummary.getTotalArea().subtract(record.getTotalArea()));
         this.baseMapper.updateById(receivingSummary);
         if (receivingSummary.getQuantity().equals(0) && receivingSummary.getInstallQuantity().equals(0)) {
            this.baseMapper.deleteById(receivingSummary.getId());
         }
      }

      return true;
   }

   @Override
   public Boolean updateRawMaterialReceivingSummary(ProjectReceivingRecord record) {
      ProjectReceivingSummary receivingSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectReceivingSummary.class)
               .eq(ProjectReceivingSummary::getProjectType, record.getProjectType())
               .eq(ProjectReceivingSummary::getProductType, record.getProductType())
               .eq(ProjectReceivingSummary::getPurchaseDetailsId, record.getPurchaseDetailsId())
         );
      if (receivingSummary == null) {
         receivingSummary = BeanUtil.copy(record, ProjectReceivingSummary.class);
         receivingSummary.setInstallQuantity(BigDecimal.ZERO);
         this.baseMapper.insert(receivingSummary);
      } else {
         receivingSummary.setQuantity(receivingSummary.getQuantity().add(record.getQuantity()));
         receivingSummary.setMete(receivingSummary.getMete().add(record.getMete()));
         receivingSummary.setActualReceivedMete(receivingSummary.getActualReceivedMete().add(record.getActualReceivedMete()));
         this.baseMapper.updateById(receivingSummary);
      }

      return true;
   }

   @Override
   public ProjectReceivingMeteDTO getReceivingMete(Integer projectType, Integer productType, Long productId) {
      Preconditions.checkArgument(projectType != null && productId != null && productType != null, "参数不能为空");
      ProjectReceivingSummary receivingSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectReceivingSummary.class)
               .eq(ProjectReceivingSummary::getProjectType, projectType)
               .eq(ProjectReceivingSummary::getProductType, productType)
               .eq(ProjectReceivingSummary::getProductId, productId)
         );
      ProjectReceivingMeteDTO receivingMeteDTO = ProjectReceivingMeteDTO.builder()
         .quantity(BigDecimal.ZERO)
         .mete(BigDecimal.ZERO)
         .totalArea(BigDecimal.ZERO)
         .build();
      if (receivingSummary != null) {
         if (!projectType.equals(ProjectTypeEnum.MES.getType()) && !productType.equals(ProjectTypeEnum.BRIDGE.getType())) {
            throw new BusinessException("暂不支持其他项目类型!!");
         }

         if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            receivingMeteDTO = ProjectReceivingMeteDTO.builder()
               .quantity(receivingSummary.getQuantity())
               .mete(receivingSummary.getMete().divide(BigDecimal.valueOf(1000L)))
               .totalArea(receivingSummary.getTotalArea().divide(BigDecimal.valueOf(1000000L)))
               .build();
         } else {
            receivingMeteDTO = ProjectReceivingMeteDTO.builder()
               .quantity(receivingSummary.getQuantity())
               .mete(receivingSummary.getMete())
               .totalArea(receivingSummary.getTotalArea().divide(BigDecimal.valueOf(1000000L)))
               .build();
         }
      }

      return receivingMeteDTO;
   }

   @Override
   public ProjectReceivingMeteDTO getReceivingMete(Long projectId, Long monomerId, Long areaId, Integer productType, Integer category) {
      Preconditions.checkArgument(productType != null, "产品类型不为空");
      ProjectReceivingMeteDO meteDO = this.baseMapper.selectReceivingMete(projectId, monomerId, areaId, productType, category);
      ProjectReceivingMeteDTO meteDTO;
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         meteDTO = ProjectReceivingMeteDTO.builder()
            .quantity(meteDO != null ? meteDO.getQuantity() : BigDecimal.ZERO)
            .mete(meteDO != null ? meteDO.getMete().divide(BigDecimal.valueOf(1000L)) : BigDecimal.ZERO)
            .totalArea(meteDO != null ? meteDO.getTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO)
            .build();
      } else {
         meteDTO = ProjectReceivingMeteDTO.builder()
            .quantity(meteDO != null ? meteDO.getQuantity() : BigDecimal.ZERO)
            .mete(meteDO != null ? meteDO.getMete() : BigDecimal.ZERO)
            .totalArea(meteDO != null ? meteDO.getTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO)
            .build();
      }

      return meteDTO;
   }

   @Override
   public BigDecimal getReceivingQuantity(List<Long> areaIds) {
      List<ProjectReceivingSummary> summaryList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ProjectReceivingSummary.class).in(areaIds != null, ProjectReceivingSummary::getAreaId, areaIds));
      return summaryList.stream().map(ProjectReceivingSummary::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<ProjectReceivingBoardDTO> listReceivingBoard(ReceivingBoardQueryDOParam param) {
      return this.baseMapper.selectReceivingBoard(param);
   }

   @Override
   public List<ProjectReceivingInstallDTO> listReceivingInstall(ProjectBaseQueryDTOParam dtoParam) {
      return this.baseMapper.selectReceivingInstall(dtoParam);
   }

   @Override
   public List<ProjectReceivingInstallDTO> listReceivingInstallV2(ProjectBaseQueryDTOParam dtoParam) {
      return this.baseMapper.selectReceivingInstallV2(dtoParam);
   }

   @Override
   public List<ProjectReceivingInstallDTO> getListMethodReceivingInstall(ProjectBaseQueryDTOParam doParam) {
      return this.baseMapper.getListMethodReceivingInstall(doParam);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateInstallQuantity(ProjectInstallReport report) {
      ProjectReceivingSummary receivingSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectReceivingSummary.class)
               .eq(ProjectReceivingSummary::getProjectType, report.getProjectType())
               .eq(ProjectReceivingSummary::getProductType, report.getProductType())
               .eq(ProjectReceivingSummary::getProductId, report.getProductId())
         );
      receivingSummary.setInstallQuantity(receivingSummary.getInstallQuantity().add(report.getActualQuantity()));
      this.baseMapper.updateById(receivingSummary);
      return true;
   }
}
