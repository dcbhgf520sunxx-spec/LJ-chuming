package com.hzchum.scim.business.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessStandardPartQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartAddDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.mapper.BusinessStandardPartMapper;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BusinessStandardPartServiceImpl extends ServiceImpl<BusinessStandardPartMapper, BusinessStandardPart> implements BusinessStandardPartService {
   @Override
   public List<BusinessStandardPart> listByCondition(BusinessStandardPartQueryDtoParam param) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(BusinessStandardPart.class)
               .eq(BusinessStandardPart::getProjectId, param.getProjectId())
               .eq(BusinessStandardPart::getRelationType, param.getRelationType())
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) && param.getMonomerId() != null,
                  BusinessStandardPart::getMonomerId,
                  param.getMonomerId()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) && param.getAreaId() != null,
                  BusinessStandardPart::getAreaId,
                  param.getAreaId()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()) && param.getCategory() != null,
                  BusinessStandardPart::getCategory,
                  param.getCategory()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()) && param.getEnclosurePlanId() != null,
                  BusinessStandardPart::getEnclosurePlanId,
                  param.getEnclosurePlanId()
               )
               .eq(param.getUseProperty() != null, BusinessStandardPart::getUseProperty, param.getUseProperty())
               .like(param.getName() != null, BusinessStandardPart::getName, param.getName())
               .like(param.getSpecification() != null, BusinessStandardPart::getSpecification, param.getSpecification())
               .like(param.getMeasureUnit() != null, BusinessStandardPart::getMeasureUnit, param.getMeasureUnit())
               .like(param.getAccountingUnit() != null, BusinessStandardPart::getAccountingUnit, param.getAccountingUnit())
               .in(CollUtil.isNotEmpty(param.getIds()), BusinessStandardPart::getId, param.getIds())
               .orderByAsc(BusinessStandardPart::getId)
         );
   }

   @Override
   public Long addBusiness(StandardPartAddDtoParam addDTOParam) {
      BusinessStandardPart businessStandardPart = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(BusinessStandardPart.class)
               .eq(BusinessStandardPart::getProjectId, addDTOParam.getProjectId())
               .eq(BusinessStandardPart::getRelationType, addDTOParam.getRelationType())
               .eq(addDTOParam.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()), BusinessStandardPart::getMonomerId, addDTOParam.getMonomerId())
               .eq(addDTOParam.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()), BusinessStandardPart::getAreaId, addDTOParam.getAreaId())
               .eq(addDTOParam.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()), BusinessStandardPart::getCategory, addDTOParam.getCategory())
               .eq(
                  addDTOParam.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()),
                  BusinessStandardPart::getEnclosurePlanId,
                  addDTOParam.getEnclosurePlanId()
               )
               .eq(BusinessStandardPart::getUseProperty, addDTOParam.getUseProperty())
               .eq(StringUtils.isNotBlank(addDTOParam.getName()), BusinessStandardPart::getName, addDTOParam.getName())
               .eq(BusinessStandardPart::getSpecification, addDTOParam.getSpecification())
               .eq(addDTOParam.getMeasureUnit() != null, BusinessStandardPart::getMeasureUnit, addDTOParam.getMeasureUnit())
               .eq(addDTOParam.getAccountingUnit() != null, BusinessStandardPart::getAccountingUnit, addDTOParam.getAccountingUnit())
               .eq(addDTOParam.getMaterialInventoryId() != null, BusinessStandardPart::getMaterialInventoryId, addDTOParam.getMaterialInventoryId())
         );
      if (businessStandardPart != null) {
         businessStandardPart.setQuantity(businessStandardPart.getQuantity().add(addDTOParam.getQuantity()));
         businessStandardPart.setMete(businessStandardPart.getMete().add(addDTOParam.getMete()));
         if (businessStandardPart.getUnitPrice() != null) {
            businessStandardPart.setTotalPrice(businessStandardPart.getUnitPrice().multiply(businessStandardPart.getMete()));
         }

         this.baseMapper.updateById(businessStandardPart);
      } else {
         businessStandardPart = BeanUtil.copy(addDTOParam, BusinessStandardPart.class);
         this.baseMapper.insert(businessStandardPart);
      }

      return businessStandardPart.getId();
   }

   @Override
   public void editBusiness(@NotNull Long businessId, @NotNull BigDecimal quantity, BigDecimal mete) {
      BusinessStandardPart businessStandardPart = this.baseMapper.selectById(businessId);
      if (businessStandardPart != null) {
         businessStandardPart.setQuantity(businessStandardPart.getQuantity().add(quantity));
         businessStandardPart.setMete(businessStandardPart.getMete().add(mete));
         if (businessStandardPart.getUnitPrice() != null) {
            businessStandardPart.setTotalPrice(businessStandardPart.getUnitPrice().multiply(businessStandardPart.getMete()));
         }

         if (businessStandardPart.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            this.baseMapper.deleteById(businessId);
         } else {
            this.baseMapper.updateById(businessStandardPart);
         }
      }
   }
}
