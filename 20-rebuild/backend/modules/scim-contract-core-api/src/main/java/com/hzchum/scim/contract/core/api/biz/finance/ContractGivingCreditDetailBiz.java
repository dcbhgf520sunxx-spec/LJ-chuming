package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDetailDto;
import java.time.LocalDateTime;

public interface ContractGivingCreditDetailBiz extends IBiz<ContractGivingCreditDetail> {
   PageVO<ContractGivingCreditDetailDto> pageSize(
      Long creditId, LocalDateTime startDate, LocalDateTime endDate, Integer auditStatus, Integer pageNumber, Integer pageSize
   );
}
