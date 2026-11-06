package com.hzchum.scim.business.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartAddDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartEditDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.mapper.BusinessMachinePartMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessMachinePartServiceImpl extends ServiceImpl<BusinessMachinePartMapper, BusinessMachinePart> implements BusinessMachinePartService {
   @Override
   public List<BusinessMachinePart> listByCondition(Long monomerId, Long areaId, String specification, String material, List<Long> ids) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(BusinessMachinePart.class)
               .eq(monomerId != null, BusinessMachinePart::getMonomerId, monomerId)
               .eq(areaId != null, BusinessMachinePart::getAreaId, areaId)
               .like(specification != null, BusinessMachinePart::getSpecification, specification)
               .like(material != null, BusinessMachinePart::getMaterial, material)
               .in(CollUtil.isNotEmpty(ids), BusinessMachinePart::getId, ids)
               .orderByAsc(BusinessMachinePart::getId)
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Long addBusinessInfo(MachinePartAddDtoParam param) {
      BusinessMachinePart business = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(
               BusinessMachinePart.builder()
                  .areaId(param.getAreaId())
                  .name(param.getName())
                  .specification(param.getSpecification())
                  .material(param.getMaterial())
                  .build()
            )
         );
      if (business == null) {
         business = BeanUtil.copy(param, BusinessMachinePart.class);
         business.setTotalQuantity(param.getQuantity());
         this.baseMapper.insert(business);
      } else {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
         if (business.getUnitPrice() != null) {
            business.setTotalPrice(
               business.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                  ? business.getTotalWeight().multiply(business.getUnitPrice()).divide(BigDecimal.valueOf(1000L))
                  : business.getTotalLength().multiply(business.getUnitPrice())
            );
         }

         this.baseMapper.updateById(business);
      }

      return business.getId();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void editBusinessInfo(MachinePartEditDtoParam param) {
      BusinessMachinePart business = this.baseMapper.selectById(param.getBusinessId());
      if (business != null) {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
         if (business.getUnitPrice() != null) {
            business.setTotalPrice(
               business.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                  ? business.getTotalWeight().multiply(business.getUnitPrice()).divide(BigDecimal.valueOf(1000L))
                  : business.getTotalLength().multiply(business.getUnitPrice())
            );
         }

         if (business.getTotalQuantity() == 0) {
            this.baseMapper.deleteById(business.getId());
         } else {
            this.baseMapper.updateById(business);
         }
      }
   }
}
