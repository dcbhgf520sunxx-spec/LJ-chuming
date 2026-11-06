package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageFeeSaveParam;
import java.util.List;
import java.util.Map;

public interface ContractWageFeeBiz extends IBiz<ContractWageFee> {
   PageVO<ContractWageFeeDTO> pageInfo(Integer year, Long branchCompanyId, Integer pageNumber, Integer pageSize, List<String> sort);

   PrintVO<List<Map<String, Object>>> listPrint(Integer year, Long branchCompanyId);

   Boolean saveInfo(ContractWageFeeSaveParam param);

   Boolean updateInfo(ContractWageFeeSaveParam param);

   Boolean deleteById(Long id);
}
