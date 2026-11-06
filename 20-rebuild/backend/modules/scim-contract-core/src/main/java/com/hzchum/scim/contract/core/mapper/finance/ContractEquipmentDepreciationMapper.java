package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEquipmentDepreciationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractEquipmentDepreciationMapper extends BaseMapper<ContractEquipmentDepreciation> {
   List<ContractEquipmentDepreciationDTO> listInfo(
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("classificationName") String classificationName,
      @Param("equipmentName") String equipmentName,
      @Param("boolStatus") Boolean boolStatus
   );
}
