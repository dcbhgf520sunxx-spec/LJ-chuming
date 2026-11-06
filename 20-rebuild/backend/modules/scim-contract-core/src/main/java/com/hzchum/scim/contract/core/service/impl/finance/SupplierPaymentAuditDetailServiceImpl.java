package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SupplierPaymentAuditDetail;
import com.hzchum.scim.contract.core.api.service.finance.SupplierPaymentAuditDetailService;
import com.hzchum.scim.contract.core.mapper.finance.SupplierPaymentAuditDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierPaymentAuditDetailServiceImpl
   extends ServiceImpl<SupplierPaymentAuditDetailMapper, SupplierPaymentAuditDetail>
   implements SupplierPaymentAuditDetailService {
}
