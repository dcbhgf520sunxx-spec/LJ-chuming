package com.hzchum.scim.contract.core.biz.impl.finance;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.SupplierPaymentAuditDetailBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SupplierPaymentAuditDetail;
import com.hzchum.scim.contract.core.api.service.finance.SupplierPaymentAuditDetailService;
import com.hzchum.scim.contract.core.mapper.finance.SupplierPaymentAuditDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierPaymentAuditDetailBizImpl
   extends IBizImpl<SupplierPaymentAuditDetailService, SupplierPaymentAuditDetailMapper, SupplierPaymentAuditDetail>
   implements SupplierPaymentAuditDetailBiz {
}
