package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityPropertyFeeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractWaterElectricityPropertyFeeMapper extends BaseMapper<ContractWaterElectricityPropertyFee> {
   List<ContractWaterElectricityPropertyFeeDTO> listInfo(
      @Param("year") Integer year, @Param("type") Integer type, @Param("branchCompanyId") Long branchCompanyId
   );
}
