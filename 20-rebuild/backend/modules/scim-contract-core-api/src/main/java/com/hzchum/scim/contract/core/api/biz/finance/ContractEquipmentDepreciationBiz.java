package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEquipmentDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEquipmentDepreciationSaveDTOParam;
import java.util.List;
import java.util.Map;

public interface ContractEquipmentDepreciationBiz extends IBiz<ContractEquipmentDepreciation> {
   PageVO<ContractEquipmentDepreciationDTO> pageInfo(
      Long branchCompanyId, String classificationName, String equipmentName, Boolean boolStatus, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO<List<Map<String, Object>>> pagePrint(Long branchCompanyId, String classificationName, String equipmentName, Boolean boolStatus);

   Boolean saveInfo(ContractEquipmentDepreciationSaveDTOParam param);

   Boolean updateInfo(ContractEquipmentDepreciationSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean boolStatus);

   Boolean deleteById(Long id);
}
