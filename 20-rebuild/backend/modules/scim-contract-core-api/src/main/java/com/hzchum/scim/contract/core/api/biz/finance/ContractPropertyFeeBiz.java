package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractPropertyFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractPropertyFeeDtoParam;
import java.util.List;
import java.util.Map;

public interface ContractPropertyFeeBiz extends IBiz<ContractPropertyFee> {
   ListVO<ContractPropertyFeeDTO> listByCondition(Integer year);

   Boolean saveList(List<ContractPropertyFeeDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   PrintVO<List<Map<String, Object>>> printList(Integer year);
}
