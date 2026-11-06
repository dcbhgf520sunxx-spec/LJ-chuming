package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDto;
import java.time.LocalDateTime;
import java.util.List;

public interface ContractGivingCreditMapper extends BaseMapper<ContractGivingCredit> {
   List<ContractGivingCreditDto> pageSize(Long id, LocalDateTime date, Long userId, Long suretyId, String idNumber);
}
