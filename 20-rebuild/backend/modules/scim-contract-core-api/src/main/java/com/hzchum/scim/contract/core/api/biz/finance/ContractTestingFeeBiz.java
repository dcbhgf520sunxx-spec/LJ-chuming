package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.CheckFeeDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractTestingFeeDtoParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractTestingFeeBiz extends IBiz<ContractTestingFee> {
   ListVO<ContractTestingFeeSummaryDTO> listSummary(Integer year, Long projectId, Long testingFeeTypeId);

   PageVO<ContractTestingFeeDTO> listByCondition(Integer year, Integer month, Long projectId, Long testingFeeTypeId, Integer pageNumber, Integer pageSize);

   Boolean saveList(List<ContractTestingFeeDtoParam> paramList);

   Boolean updateList(List<ContractTestingFeeDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   void exportTestingFeeExcel(Long projectId, Integer year, HttpServletResponse response);

   List<CheckFeeDto> findAll(Long projectId, Integer year);
}
