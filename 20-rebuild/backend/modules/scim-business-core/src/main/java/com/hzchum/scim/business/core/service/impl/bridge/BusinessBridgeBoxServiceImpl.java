package com.hzchum.scim.business.core.service.impl.bridge;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo.doModel.bridge.BusinessBridgeBox;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxFindDTOParam;
import com.hzchum.scim.business.core.api.service.bridge.BusinessBridgeBoxService;
import com.hzchum.scim.business.core.mapper.bridge.BusinessBridgeBoxMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessBridgeBoxServiceImpl extends ServiceImpl<BusinessBridgeBoxMapper, BusinessBridgeBox> implements BusinessBridgeBoxService {
   @Override
   public Long addBusinessInfo(BridgeBoxAddDTOParam param) {
      BusinessBridgeBox business = this.getByCondition(BeanUtil.copy(param, BridgeBoxFindDTOParam.class));
      if (business == null) {
         BusinessBridgeBox copy = BeanUtil.copy(param, BusinessBridgeBox.class);
         copy.setTotalQuantity(param.getQuantity());
         copy.setTotalWeight(param.getTotalWeight());
         this.baseMapper.insert(copy);
         return copy.getId();
      } else {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         this.baseMapper.updateById(business);
         return business.getId();
      }
   }

   @Override
   public BusinessBridgeBox getByCondition(BridgeBoxFindDTOParam param) {
      LambdaQueryWrapper<BusinessBridgeBox> query = (LambdaQueryWrapper<BusinessBridgeBox>)(Wrappers.<BusinessBridgeBox>lambdaQuery()
            .eq(BusinessBridgeBox::getMonomerId, param.getMonomerId()))
         .eq(BusinessBridgeBox::getName, param.getName());
      if (param.getMaterial() != null) {
         query.eq(BusinessBridgeBox::getMaterial, param.getMaterial());
      }

      if (param.getSpecification() != null) {
         query.eq(BusinessBridgeBox::getSpecification, param.getSpecification());
      }

      List<BusinessBridgeBox> businessBridgeBoxes = this.baseMapper.selectList(query);
      return businessBridgeBoxes.isEmpty() ? null : businessBridgeBoxes.get(0);
   }

   @Override
   public void editBusinessInfo(BridgeBoxEditDTOParam param) {
      BusinessBridgeBox business = this.baseMapper.selectById(param.getBusinessId());
      if (business != null) {
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         if (business.getTotalQuantity() == 0) {
            this.baseMapper.deleteById(business.getId());
         } else {
            this.baseMapper.updateById(business);
         }
      }
   }
}
