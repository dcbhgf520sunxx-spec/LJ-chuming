package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.FactoryBuildingDepreciationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractFixedAssetsDepreciationMapper extends BaseMapper<ContractFixedAssetsDepreciation> {
   List<ContractFixedAssetsDepreciationDTO> selectByCondition(@Param("type") Integer type, @Param("name") String name, @Param("boolStatus") Boolean boolStatus);

   List<ContractFixedAssetsDepreciation> selectByYear(@Param("year") Integer year);

   List<FactoryBuildingDepreciationDTO> factoryBuildingDepreciationList(
      @Param("branchCompanyId") Long branchCompanyId, @Param("name") String name, @Param("boolStatus") Boolean boolStatus
   );
}
