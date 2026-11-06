package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEarnestMoney;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEarnestMoneyDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEarnestMoneyDtoParam;
import java.util.List;

public interface ContractEarnestMoneyBiz extends IBiz<ContractEarnestMoney> {
   PageVO<ContractEarnestMoneyDto> pageSize(Integer pageNumber, Integer pageSize);

   Boolean addEarnestMoney(List<ContractEarnestMoneyDtoParam> dto);

   Boolean updateEarnestMoney(ContractEarnestMoneyDtoParam dto);

   Boolean deleteEarnestMoney(List<Long> ids);

   Boolean updateEarnestMoneyStatus(Long id, Integer status);

   Boolean putEarnestMoney(ContractEarnestMoneyDtoParam dto);
}
