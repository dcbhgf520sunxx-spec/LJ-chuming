package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.WmsGasClassificationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGasSummaryDtoParam;
import java.util.List;
import java.util.Map;

public interface ContractGasSummaryBiz extends IBiz<ContractGasSummary> {
   ListVO<WmsGasClassificationDTO> listWmsGasClass();

   ListVO<ContractGasSummaryDTO> listGasSummary(Long classifyId, Integer year);

   Boolean saveList(List<ContractGasSummaryDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   PrintVO<List<Map<String, Object>>> printList(Long classifyId, Integer year);
}
