package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractAmountRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectChangeInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ChangeAuditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ContractChangeSaveDTOParam;

public interface ContractChangeBiz {
   Boolean changeProject(ContractChangeSaveDTOParam param);

   PageVO<ContractChangeDTO> listContractChanges(
      Long projectId, Integer year, Integer type, String name, String userName, String auditorName, Integer auditStatus, Integer pageNumber, Integer pageSize
   );

   ContractProjectChangeInfoDTO getByChangeId(Long changeId);

   Boolean auditProjectChange(ChangeAuditDTOParam auditDTOParam);

   ListVO<ContractAmountRecordDTO> listContractAmountRecord(Long projectId);
}
