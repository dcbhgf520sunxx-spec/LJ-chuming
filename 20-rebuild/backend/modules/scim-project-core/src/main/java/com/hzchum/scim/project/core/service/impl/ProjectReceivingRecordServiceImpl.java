package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.project.core.api.enums.ProductTypeUpEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo._do.ProjectRejectDetail;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReceivedQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.mapper.ProjectReceivingRecordMapper;
import com.hzchum.scim.project.core.mapper.ProjectRejectDetailMapper;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectReceivingRecordServiceImpl
   extends ServiceImpl<ProjectReceivingRecordMapper, ProjectReceivingRecord>
   implements ProjectReceivingRecordService {
   @Resource
   private MeasureService measureService;
   @Resource
   private ProjectRejectDetailMapper projectRejectDetailMapper;

   @Override
   public List<ProjectReceivingRecord> listReceivingRecord(ReceivingStatementQueryDTOParam param) {
      LambdaQueryWrapper<ProjectReceivingRecord> queryWrapper = Wrappers.lambdaQuery(ProjectReceivingRecord.class)
         .ge(param.getStartDate() != null, BaseEntity::getCreateTime, param.getStartDate())
         .apply(param.getProductType() != null, "product_type & {0} > 0", param.getProductType())
         .eq(ProjectReceivingRecord::getProjectId, param.getProjectId())
         .eq(param.getMonomerId() != null && !param.getMonomerId().equals(0L), ProjectReceivingRecord::getMonomerId, param.getMonomerId())
         .eq(param.getCategory() != null, ProjectReceivingRecord::getCategory, param.getCategory())
         .eq(param.getAreaId() != null, ProjectReceivingRecord::getAreaId, param.getAreaId())
         .eq(param.getAreaType() != null, ProjectReceivingRecord::getAreaType, param.getAreaType())
         .like(param.getSupplierName() != null, ProjectReceivingRecord::getSupplierName, param.getSupplierName())
         .like(param.getSerialNumber() != null, ProjectReceivingRecord::getSerialNumber, param.getSerialNumber())
         .like(param.getName() != null, ProjectReceivingRecord::getName, param.getName())
         .orderByDesc(ProjectReceivingRecord::getId);
      if (param.getEndDate() != null) {
         queryWrapper.lt(BaseEntity::getCreateTime, param.getEndDate().plusDays(1L));
      }

      return this.baseMapper.selectList(queryWrapper);
   }

   @Override
   public List<ProjectReceivingRecord> listReceivingRecordV2(ReceivingStatementQueryDTOParam param) {
      LambdaQueryWrapper<ProjectReceivingRecord> queryWrapper = Wrappers.lambdaQuery(ProjectReceivingRecord.class)
         .ge(param.getStartDate() != null, BaseEntity::getCreateTime, param.getStartDate())
         .apply(param.getProductType() != null, "product_type & {0} > 0", param.getProductType())
         .eq(ProjectReceivingRecord::getProjectId, param.getProjectId())
         .eq(param.getSourceType() != null, ProjectReceivingRecord::getSourceType, param.getSourceType())
         .eq(param.getMonomerId() != null && !param.getMonomerId().equals(0L), ProjectReceivingRecord::getMonomerId, param.getMonomerId())
         .eq(param.getCategory() != null, ProjectReceivingRecord::getCategory, param.getCategory())
         .eq(param.getAreaId() != null, ProjectReceivingRecord::getAreaId, param.getAreaId())
         .eq(param.getAreaType() != null, ProjectReceivingRecord::getAreaType, param.getAreaType())
         .eq(param.getSupplierId() != null, ProjectReceivingRecord::getSupplierId, param.getSupplierId())
         .like(param.getSupplierName() != null, ProjectReceivingRecord::getSupplierName, param.getSupplierName())
         .like(param.getSerialNumber() != null, ProjectReceivingRecord::getSerialNumber, param.getSerialNumber())
         .like(param.getName() != null, ProjectReceivingRecord::getName, param.getName())
         .orderByDesc(ProjectReceivingRecord::getId);
      if (param.getEndDate() != null) {
         queryWrapper.lt(BaseEntity::getCreateTime, param.getEndDate().plusDays(1L));
      }

      return this.baseMapper.selectList(queryWrapper);
   }

   @Override
   public List<ProjectReceivedInstallStoreMeteDTO> getReceivedMete(Long projectId, Integer productType) {
      return this.baseMapper.getReceivedMete(projectId, productType);
   }

   @Override
   public List<ProjectReceivedInstallStoreMeteDTO> getRejectMete(Long projectId, Integer productType) {
      return this.baseMapper.getRejectMete(projectId, productType);
   }

   @Override
   public List<ProjectReceivedInstallStoreMeteDTO> getInstallMete(Long projectId, Integer productType) {
      return this.baseMapper.getInstallMete(projectId, productType);
   }

   @Override
   public List<ProjectProductDTO> getStoreDetails(String yearMonth, Long projectId, Integer productType, Integer storeType) {
      return this.baseMapper.getStoreDetails(yearMonth, projectId, productType, storeType);
   }

   @Override
   public List<ProjectProductDTO> getReceivedInstallDetails(String yearMonth, Long projectId, Integer productType, Integer storeType) {
      return this.baseMapper.getReceivedInstallDetails(yearMonth, projectId, productType, storeType);
   }

   @Override
   public List<ProjectProductDTO> getReceivedReject(String yearMonth, Long projectId, Integer productType, Integer storeType) {
      return this.baseMapper.getReceivedReject(yearMonth, projectId, productType, storeType);
   }

   @Override
   public PageVO<ProjectProductDTO> getOutReceivedPage(ProjectReceivedQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<ProjectProductDTO> canRejectList = this.getOutReceivedList(param);
      if (CollectionUtils.isEmpty(canRejectList)) {
         return new PageVO<>();
      }

      this.fillInfo(canRejectList);
      return PageUtil.listPage(pageNumber, pageSize, canRejectList);
   }

   @Override
   public List<ProjectProductDTO> getOutReceivedList(ProjectReceivedQueryDTOParam param) {
      List<ProjectProductDTO> outReceivedList = this.baseMapper.getOutReceivedPage(param);
      Map<Long, ProjectRejectDetail> auditingRejectMap = this.projectRejectDetailMapper
         .selectList(Wrappers.lambdaQuery(ProjectRejectDetail.class).eq(ProjectRejectDetail::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
         .stream()
         .collect(
            Collectors.toMap(
               ProjectRejectDetail::getReceivedId,
               e -> (ProjectRejectDetail)e,
               (existing, replacement) -> {
                  existing.setRejectQuantity(
                     (existing.getRejectQuantity() != null ? existing.getRejectQuantity() : BigDecimal.ZERO)
                        .add(replacement.getRejectQuantity() != null ? replacement.getRejectQuantity() : BigDecimal.ZERO)
                  );
                  existing.setRejectMete(existing.getRejectMete().add(replacement.getRejectMete()));
                  existing.setRejectActualReceivedMete(existing.getRejectActualReceivedMete().add(replacement.getRejectActualReceivedMete()));
                  return existing;
               }
            )
         );
      outReceivedList.forEach(e -> {
         if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(e.getProductType())) {
            e.setCanRejectMete(e.getMete().subtract(e.getRejectMete()));
            e.setCanRejectActualReceivedMete(e.getActualReceivedMete().subtract(e.getRejectActualReceivedMete()));
            SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
            if (subjectMeasureDTO.getMeasureUnit() != null) {
               e.setCanRejectQuantity(e.getQuantity().subtract(e.getRejectQuantity()));
            }

            ProjectRejectDetail projectRejectDetail = auditingRejectMap.get(e.getId());
            if (projectRejectDetail != null) {
               e.setCanRejectMete(e.getCanRejectMete().subtract(projectRejectDetail.getRejectMete()));
               e.setCanRejectActualReceivedMete(e.getCanRejectActualReceivedMete().subtract(projectRejectDetail.getRejectActualReceivedMete()));
               if (subjectMeasureDTO.getMeasureUnit() != null) {
                  e.setCanRejectQuantity(e.getCanRejectQuantity().subtract(projectRejectDetail.getRejectQuantity()));
               }
            }
         } else if (ProductTypeUpEnum.ARTIFACT.getType().equals(e.getProductType())) {
            e.setMete(e.getMete().multiply(BigDecimal.valueOf(1000L)));
            e.setCanRejectQuantity(e.getQuantity().subtract(e.getRejectQuantity()));
            e.setCanRejectActualReceivedMete(e.getActualReceivedMete().subtract(e.getRejectActualReceivedMete()));
            if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getQuantity().subtract(e.getRejectMete()));
            } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getTotalLength().subtract(e.getRejectMete()));
            } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getTotalArea().subtract(e.getRejectMete()));
            } else {
               if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != e.getWageQuotaType()) {
                  throw new BusinessException("制成品计价方式类型不存在！");
               }

               e.setCanRejectMete(e.getMete().subtract(e.getRejectMete()));
            }

            ProjectRejectDetail projectRejectDetail = auditingRejectMap.get(e.getId());
            if (projectRejectDetail != null) {
               e.setCanRejectMete(e.getCanRejectMete().subtract(projectRejectDetail.getRejectMete()));
               e.setCanRejectActualReceivedMete(e.getCanRejectActualReceivedMete().subtract(projectRejectDetail.getRejectActualReceivedMete()));
               e.setCanRejectQuantity(e.getCanRejectQuantity().subtract(projectRejectDetail.getRejectQuantity()));
            }
         } else if (ProductTypeUpEnum.ENCLOSURE.getType().equals(e.getProductType())) {
            e.setCanRejectActualReceivedMete(e.getActualReceivedMete().subtract(e.getRejectActualReceivedMete()));
            e.setCanRejectQuantity(e.getQuantity().subtract(e.getRejectQuantity()));
            if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getQuantity().subtract(e.getRejectMete()));
            } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getMete().subtract(e.getRejectMete()));
            } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == e.getWageQuotaType()) {
               e.setCanRejectMete(e.getTotalArea().subtract(e.getRejectMete()));
            } else {
               if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != e.getWageQuotaType()) {
                  throw new BusinessException("制成品计价方式类型不存在！");
               }

               e.setCanRejectMete(e.getTotalNetWeight().subtract(e.getRejectMete()));
            }

            ProjectRejectDetail projectRejectDetail = auditingRejectMap.get(e.getId());
            if (projectRejectDetail != null) {
               e.setCanRejectMete(e.getCanRejectMete().subtract(projectRejectDetail.getRejectMete()));
               e.setCanRejectActualReceivedMete(e.getCanRejectActualReceivedMete().subtract(projectRejectDetail.getRejectActualReceivedMete()));
               e.setCanRejectQuantity(e.getCanRejectQuantity().subtract(projectRejectDetail.getRejectQuantity()));
            }
         }
      });
      return outReceivedList.stream()
         .filter(e -> e.getCanRejectQuantity().compareTo(BigDecimal.ZERO) > 0 || e.getCanRejectMete().compareTo(BigDecimal.ZERO) > 0)
         .collect(Collectors.toList());
   }

   @Override
   public List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam) {
      return this.baseMapper.orderReconciliationDetail(queryDTOParam);
   }

   private void fillInfo(List<ProjectProductDTO> outReceivedList) {
      if (!CollectionUtils.isEmpty(outReceivedList)) {
         for (ProjectProductDTO productDTO : outReceivedList) {
            if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(productDTO.getProductType())) {
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(productDTO.getClassifyId());
               Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
               productDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
               productDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
               productDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
               productDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
            }
         }
      }
   }
}
