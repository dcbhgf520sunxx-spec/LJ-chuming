package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractPreRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractPreRegistrationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractPreRegistrationDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractPreRegistrationService extends IService<ContractPreRegistration> {
   PageVO<ContractPreRegistrationDTO> getList(ContractPreRegistrationQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean saveContractFiledConfig(ContractPreRegistrationDTOParam dtoParam);

   ContractPreRegistrationDTO selectById(Long id);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   Boolean edit(ContractPreRegistrationDTOParam dtoParam);

   Boolean export(ContractPreRegistrationQueryDTOParam param, HttpServletResponse response);

   List<ContractPreRegistrationDTO> getUnQuoteList();
}
