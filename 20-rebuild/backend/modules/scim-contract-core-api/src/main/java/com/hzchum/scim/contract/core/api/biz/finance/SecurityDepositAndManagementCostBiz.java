package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.SecurityDepositAndManagementCostDtoParam;
import java.math.BigDecimal;
import java.util.List;

public interface SecurityDepositAndManagementCostBiz extends IBiz<SecurityDepositAndManagementCost> {
   PageVO<SecurityDepositAndManagementCostDto> pagingQuery(Long projectId, Integer pageNumber, Integer pageSize);

   Boolean addSecurityDepositAndManagementCost(List<SecurityDepositAndManagementCostDtoParam> dto);

   Boolean updateSecurityDepositAndManagementCost(SecurityDepositAndManagementCostDtoParam dto);

   Boolean deleteSecurityDepositAndManagementCost(List<Long> ids);

   Boolean sendBackSecurityDepositAndManagementCost(SaveDtoParam saveDtoParam);

   BigDecimal accruingAmounts(Long projectId, Integer auditStatus);

   BigDecimal getAccruingAmounts(Long projectId);

   PageVO<SecurityDepositAndManagementCostDetailDTO> getSecurityDepositAndManagementCostDetail(
      Long projectId, Integer type, Integer pageNumber, Integer pageSize
   );
}
