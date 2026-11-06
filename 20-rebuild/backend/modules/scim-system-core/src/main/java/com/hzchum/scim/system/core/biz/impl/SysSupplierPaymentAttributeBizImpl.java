package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.system.core.api.biz.SysSupplierPaymentAttributeBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.pojo.dto.SysSupplierPaymentAttributeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysSupplierPaymentAttributeParam;
import com.hzchum.scim.system.core.api.service.SysSupplierPaymentAttributeService;
import com.hzchum.scim.system.core.mapper.SysSupplierPaymentAttributeMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysSupplierPaymentAttributeBizImpl
   extends IBizImpl<SysSupplierPaymentAttributeService, SysSupplierPaymentAttributeMapper, SysSupplierPaymentAttribute>
   implements SysSupplierPaymentAttributeBiz {
   private final SupplierPaymentService supplierPaymentService;

   @Override
   public List<SysSupplierPaymentAttributeDTO> listByCondition(String name, Boolean boolEnableStatus) {
      List<SysSupplierPaymentAttribute> paymentAttributeList = this.baseService
         .list(
            Wrappers.lambdaQuery(SysSupplierPaymentAttribute.class)
               .like(StringUtils.isNotBlank(name), SysSupplierPaymentAttribute::getName, name)
               .eq(boolEnableStatus != null, SysSupplierPaymentAttribute::getBoolEnableStatus, true)
               .orderByAsc(SysSupplierPaymentAttribute::getSort)
               .orderByAsc(SysSupplierPaymentAttribute::getId)
         );
      return paymentAttributeList.stream().map(s -> BeanUtil.copy(s, SysSupplierPaymentAttributeDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePaymentAttribute(List<SysSupplierPaymentAttributeParam> paramList) {
      paramList.forEach(
         param -> {
            int count = this.baseService
               .count(Wrappers.lambdaQuery(SysSupplierPaymentAttribute.class).eq(SysSupplierPaymentAttribute::getName, param.getName()));
            Preconditions.checkArgument(count == 0, "付款属性已存在!");
            SysSupplierPaymentAttribute attribute = SysSupplierPaymentAttribute.builder()
               .name(param.getName())
               .boolEnableStatus(true)
               .createUserId(UserUtil.getCurrentUserId())
               .createUserName(UserUtil.getCurrentName())
               .sort(param.getSort())
               .build();
            this.baseService.save(attribute);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePaymentAttribute(SysSupplierPaymentAttributeParam param) {
      SysSupplierPaymentAttribute attribute = this.baseService.getById(param.getId());
      Preconditions.checkArgument(attribute != null, "付款属性未创建!");
      if (!param.getName().equals(attribute.getName())) {
         int count = this.baseService.count(Wrappers.lambdaQuery(SysSupplierPaymentAttribute.class).eq(SysSupplierPaymentAttribute::getName, param.getName()));
         Preconditions.checkArgument(count == 0, "付款属性已存在!");
         count = this.supplierPaymentService
            .count(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getPaymentAttributeId, param.getId())
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            );
         Preconditions.checkArgument(count == 0, "付款属性已存在付款记录!");
      }

      attribute.setName(param.getName());
      attribute.setSort(param.getSort());
      return this.baseService.updateById(attribute);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delPaymentAttribute(List<Long> ids) {
      ids.forEach(
         id -> {
            SysSupplierPaymentAttribute attribute = this.baseService.getById(id);
            Preconditions.checkArgument(attribute != null, "付款属性未创建!");
            int count = this.supplierPaymentService
               .count(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getPaymentAttributeId, id)
                     .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               );
            Preconditions.checkArgument(count == 0, "付款属性已存在付款记录!");
            this.baseService.removeById(id);
         }
      );
      return true;
   }

   public SysSupplierPaymentAttributeBizImpl(final SupplierPaymentService supplierPaymentService) {
      this.supplierPaymentService = supplierPaymentService;
   }
}
