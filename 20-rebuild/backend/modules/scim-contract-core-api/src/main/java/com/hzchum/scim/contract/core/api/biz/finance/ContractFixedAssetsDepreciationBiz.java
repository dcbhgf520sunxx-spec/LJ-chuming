package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.FactoryBuildingDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationSaveDtoParam;
import java.util.List;
import java.util.Map;

public interface ContractFixedAssetsDepreciationBiz extends IBiz<ContractFixedAssetsDepreciation> {
   PageVO<ContractFixedAssetsDepreciationDTO> listByCondition(Integer type, String name, Boolean boolStatus, Integer pageNumber, Integer pageSize);

   Boolean saveList(List<ContractFixedAssetsDepreciationDtoParam> paramList);

   Boolean updateList(List<ContractFixedAssetsDepreciationDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   Boolean updateStatus(Long id, Boolean boolStatus);

   Boolean saveFactoryBuildingDepreciation(ContractFixedAssetsDepreciationSaveDtoParam param);

   Boolean updateFactoryBuildingDepreciation(ContractFixedAssetsDepreciationSaveDtoParam param);

   PageVO<FactoryBuildingDepreciationDTO> factoryBuildingDepreciationPage(
      Long branchCompanyId, String name, Boolean boolStatus, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO<List<Map<String, Object>>> factoryBuildingDepreciationPrint(Long branchCompanyId, String name, Boolean boolStatus);

   Boolean updateStatusFactoryBuildingDepreciation(Long id, Boolean boolStatus);

   Boolean deleteFactoryBuildingDepreciation(Long id);
}
