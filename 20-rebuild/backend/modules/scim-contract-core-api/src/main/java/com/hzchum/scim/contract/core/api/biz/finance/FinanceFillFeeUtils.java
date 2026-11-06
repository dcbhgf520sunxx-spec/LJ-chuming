package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import java.math.BigDecimal;

public interface FinanceFillFeeUtils {
   Integer addApproveData(Long id, Integer paymentEnum, Integer approveProcessType, Long branchCompanyId, BigDecimal feeAmount, ContractProject project);

   void removeApproveData(Long id, Integer paymentEnum, Integer approveProcessType);
}
