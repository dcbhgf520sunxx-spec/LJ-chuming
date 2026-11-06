package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.pojo.dto.SysSupplierPaymentAttributeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysSupplierPaymentAttributeParam;
import java.util.List;

public interface SysSupplierPaymentAttributeBiz extends IBiz<SysSupplierPaymentAttribute> {
   List<SysSupplierPaymentAttributeDTO> listByCondition(String name, Boolean boolEnableStatus);

   Boolean savePaymentAttribute(List<SysSupplierPaymentAttributeParam> paramList);

   Boolean updatePaymentAttribute(SysSupplierPaymentAttributeParam param);

   Boolean delPaymentAttribute(List<Long> ids);
}
