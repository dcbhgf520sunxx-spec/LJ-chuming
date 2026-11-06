package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRegistrationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractRegistrationDTOParam;
import javax.servlet.http.HttpServletResponse;

public interface ContractRegistrationService extends IService<ContractRegistration> {
   PageVO<ContractRegistrationDTO> getList(ContractRegistrationQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean saveContractRegistration(ContractRegistrationDTOParam dtoParam);

   ContractRegistrationDTO selectById(Long id);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   Boolean edit(ContractRegistrationDTOParam dtoParam);

   Boolean export(ContractRegistrationQueryDTOParam param, HttpServletResponse response);
}
