package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractManagementCostDtoParam;
import java.math.BigDecimal;
import java.util.List;

public interface ContractManagementCostBiz extends IBiz<ContractManagementCost> {
   PageVO<ContractManagementCostDto> pageSize(Integer pageNumber, Integer pageSize);

   Boolean addEarnestMoney(List<ContractManagementCostDtoParam> list);

   Boolean updateEarnestMoney(ContractManagementCostDtoParam dto);

   Boolean deleteEarnestMoney(List<Long> ids);

   Boolean updateEarnestMoneyStatus(Long id, Integer status);

   Boolean updateProjectManagementCost(SaveDtoParam dtoParam);

   BigDecimal getProjectManagementCost(Long projectId);
}
