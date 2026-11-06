package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import java.util.List;

public interface ContractSettlementBiz extends IBiz<ContractSettlement> {
   List<ContractSettlementDTO> listProjectSettlement(Long projectId, Integer level, Long branchCompanyId);

   PrintVO<List<ContractSettlementDTO>> printListProjectSettlement(Long projectId, Integer level, Long branchCompanyId);

   Boolean savePreSettlement(ProjectSettlementSaveParam param);
}
