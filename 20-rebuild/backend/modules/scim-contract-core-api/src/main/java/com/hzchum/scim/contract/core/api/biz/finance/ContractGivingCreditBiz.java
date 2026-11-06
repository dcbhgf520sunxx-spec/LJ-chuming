package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGivingCreditDtoParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ContractGivingCreditBiz extends IBiz<ContractGivingCredit> {
   PageVO<ContractGivingCreditDto> pageSize(LocalDateTime date, Long userId, Long suretyId, String idNumber, Integer pageNumber, Integer pageSize);

   Boolean saveContractGivingCredit(ContractGivingCreditDtoParam param);

   Boolean delContractGivingCredit(List<Long> ids);

   Boolean putContractGivingCredit(ContractGivingCreditDtoParam param);

   Boolean putContractGivingCreditStatus(Long id, Integer status);

   ContractGivingCreditDto getContractGivingCredit(Long id);

   PrintVO<List<Map<String, Object>>> download(Integer year, Long userId, Long suretyId, String idNumber);

   List<ProjectInfo> getProject(Long projectManagerId);
}
