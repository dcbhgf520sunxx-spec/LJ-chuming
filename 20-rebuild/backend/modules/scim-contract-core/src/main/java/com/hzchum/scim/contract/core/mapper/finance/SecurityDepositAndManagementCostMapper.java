package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDto;
import java.util.List;

public interface SecurityDepositAndManagementCostMapper extends BaseMapper<SecurityDepositAndManagementCost> {
   List<SecurityDepositAndManagementCostDto> pageSizeList(Long projectId);
}
