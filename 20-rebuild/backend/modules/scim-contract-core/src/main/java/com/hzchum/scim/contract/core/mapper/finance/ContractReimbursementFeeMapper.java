package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractReimbursementFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.query.ContractReimbursementFeeQuery;
import java.util.List;

public interface ContractReimbursementFeeMapper extends BaseMapper<ContractReimbursementFee> {
   List<ContractReimbursementFeeDTO> listInfo(ContractReimbursementFeeQuery query);
}
