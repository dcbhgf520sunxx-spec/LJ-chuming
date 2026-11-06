package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricity;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityDtoParam;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ContractWaterElectricityBiz extends IBiz<ContractWaterElectricity> {
   ListVO<ContractWaterElectricityDTO> listByCondition(Integer year, Integer type, Integer childType);

   Boolean saveList(List<ContractWaterElectricityDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   PrintVO<List<Map<String, Object>>> printWaterElectricityList(Integer year, Integer type, Integer childType);

   ListVO<ContractWaterElectricityCountDto> countWaterElectricity(Integer year);

   void exportWaterElectricityExcel(Integer year, HttpServletResponse response);
}
