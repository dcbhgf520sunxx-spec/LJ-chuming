package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricity;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityDTO;
import java.util.List;

public interface ContractWaterElectricityService extends IService<ContractWaterElectricity> {
   List<ContractWaterElectricityDTO> listByCondition(Integer year, Integer type, Integer childType);

   Boolean isExist(Integer year, Integer month, Integer type, Integer childType);

   List<MonthAmountInfo> listWaterEleMonthAmount(Integer startMonth, Integer endMonth, Integer type);
}
