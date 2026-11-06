package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.service.SysSupplierPaymentAttributeService;
import com.hzchum.scim.system.core.mapper.SysSupplierPaymentAttributeMapper;
import org.springframework.stereotype.Service;

@Service
public class SysSupplierPaymentReasonServiceImpl
   extends ServiceImpl<SysSupplierPaymentAttributeMapper, SysSupplierPaymentAttribute>
   implements SysSupplierPaymentAttributeService {
}
