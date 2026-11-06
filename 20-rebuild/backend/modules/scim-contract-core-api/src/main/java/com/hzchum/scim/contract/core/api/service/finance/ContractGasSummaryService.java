package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import java.util.List;

public interface ContractGasSummaryService extends IService<ContractGasSummary> {
   List<ContractGasSummaryDTO> listByCondition(Long classifyId, Integer year);

   Boolean isExist(Long classifyId, Integer year, Integer month);

   List<MonthAmountInfo> listGasMonthAmount(Integer startMonth, Integer endMonth);
}
