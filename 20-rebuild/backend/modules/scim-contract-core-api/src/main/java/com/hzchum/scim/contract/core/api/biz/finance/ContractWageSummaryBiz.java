package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageSummaryDtoParam;
import java.util.List;
import java.util.Map;

public interface ContractWageSummaryBiz extends IBiz<ContractWageSummary> {
   ListVO<ContractWageSummaryDTO> listByCondition(Integer year, Integer wageType);

   Boolean saveList(List<ContractWageSummaryDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   PrintVO<List<Map<String, Object>>> printList(Integer year, Integer wageType);
}
