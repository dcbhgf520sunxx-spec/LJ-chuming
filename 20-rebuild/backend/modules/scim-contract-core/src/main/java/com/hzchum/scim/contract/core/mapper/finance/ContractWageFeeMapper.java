package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageFeeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractWageFeeMapper extends BaseMapper<ContractWageFee> {
   List<ContractWageFeeDTO> listInfo(@Param("year") Integer year, @Param("branchCompanyId") Long branchCompanyId);
}
