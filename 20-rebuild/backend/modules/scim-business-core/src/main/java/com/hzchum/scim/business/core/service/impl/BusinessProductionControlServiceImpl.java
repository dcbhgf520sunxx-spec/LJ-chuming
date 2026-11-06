package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControl;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlConditionFindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlQuantityChangeDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlService;
import com.hzchum.scim.business.core.mapper.BusinessProductionControlMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessProductionControlServiceImpl
   extends ServiceImpl<BusinessProductionControlMapper, BusinessProductionControl>
   implements BusinessProductionControlService {
   private BusinessProductionControl getByCondition(ProductionControlQuantityChangeDTOParam param) {
      return this.baseMapper
         .selectOne(
            (Wrapper<BusinessProductionControl>)((((Wrappers.<BusinessProductionControl>lambdaQuery()
                           .eq(BusinessProductionControl::getProjectId, param.getProjectId()))
                        .eq(BusinessProductionControl::getName, param.getName()))
                     .eq(BusinessProductionControl::getSpecification, param.getSpecification()))
                  .eq(BusinessProductionControl::getMaterial, param.getMaterial()))
               .eq(BusinessProductionControl::getUnit, param.getUnit())
         );
   }

   @Override
   public void updateControlList(ProductionControlQuantityChangeDTOParam param) {
      BusinessProductionControl control = this.getByCondition(param);
      if (control == null) {
         BusinessProductionControl copy = BeanUtil.copy(param, BusinessProductionControl.class);
         this.baseMapper.insert(copy);
      } else {
         control.setQuantity(control.getQuantity() + param.getQuantity());
         this.baseMapper.updateById(control);
      }
   }

   @Override
   public void removeControlList(ProductionControlQuantityChangeDTOParam param) {
      BusinessProductionControl control = this.getByCondition(param);
      Preconditions.checkArgument(control != null, "记录不存在");
      control.setQuantity(control.getQuantity() - param.getQuantity());
      this.baseMapper.updateById(control);
   }

   @Override
   public ListVO<BusinessProductionControl> listByCondition(ProductionControlConditionFindDTOParam param) {
      return new ListVO<>(
         this.baseMapper
            .selectList(
               (((Wrappers.<BusinessProductionControl>lambdaQuery()
                           .eq(param.getProjectId() != null, BusinessProductionControl::getProjectId, param.getProjectId()))
                        .eq(StringUtils.isNotBlank(param.getName()), BusinessProductionControl::getName, param.getName()))
                     .eq(StringUtils.isNotBlank(param.getSpecification()), BusinessProductionControl::getSpecification, param.getSpecification()))
                  .eq(StringUtils.isNotBlank(param.getMaterial()), BusinessProductionControl::getMaterial, param.getMaterial())
            )
      );
   }
}
