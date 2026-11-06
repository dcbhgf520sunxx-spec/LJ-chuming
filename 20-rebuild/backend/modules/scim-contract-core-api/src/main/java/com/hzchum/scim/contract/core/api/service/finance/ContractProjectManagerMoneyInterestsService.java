package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectManagerMoneyInterests;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectInterestFundsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectManagerMoneyInterestsDto;
import java.time.LocalDateTime;
import java.util.List;

public interface ContractProjectManagerMoneyInterestsService extends IService<ContractProjectManagerMoneyInterests> {
   PageVO<ContractProjectManagerMoneyInterestsDto> getProjectInterest(
      Long projectId, Integer pageNumber, Integer pageSize, LocalDateTime startDate, LocalDateTime endDate
   );

   List<ContractProjectInterestFundsDto> getProjectQuarterInterest(Long projectId);
}
