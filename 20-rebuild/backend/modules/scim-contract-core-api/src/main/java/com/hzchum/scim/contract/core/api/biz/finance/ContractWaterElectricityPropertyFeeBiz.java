package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityPropertyFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityPropertyFeeSaveParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractWaterElectricityPropertyFeeBiz extends IBiz<ContractWaterElectricityPropertyFee> {
   PageVO<ContractWaterElectricityPropertyFeeDTO> pageInfo(
      Integer year, Integer type, Long branchCompanyId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Boolean saveInfo(ContractWaterElectricityPropertyFeeSaveParam param);

   Boolean updateInfo(ContractWaterElectricityPropertyFeeSaveParam param);

   Boolean updateStatus(Long id, Boolean boolStatus);

   Boolean deleteById(Long id);

   List<ContractWaterElectricityCountDto> waterElectricityFeeStatistics(Integer year);

   void waterElectricityFeeStatisticsExport(Integer year, HttpServletResponse response);
}
