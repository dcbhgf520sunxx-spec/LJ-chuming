package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractReimbursementFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractReimbursementFeeSaveParam;
import com.hzchum.scim.contract.core.api.pojo.query.ContractReimbursementFeeQuery;
import java.util.List;
import java.util.Map;

public interface ContractReimbursementFeeBiz extends IBiz<ContractReimbursementFee> {
   PageVO<ContractReimbursementFeeDTO> pageInfo(ContractReimbursementFeeQuery query);

   PrintVO<List<Map<String, Object>>> listPrint(ContractReimbursementFeeQuery query);

   Boolean saveInfo(ContractReimbursementFeeSaveParam param);

   Boolean updateInfo(ContractReimbursementFeeSaveParam param);

   Boolean deleteById(Long id);
}
