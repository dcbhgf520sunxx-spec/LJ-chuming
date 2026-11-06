package com.hzchum.scim.contract.core.api.service;

import com.hzchum.scim.contract.core.api.pojo._doParam.ContractAnalysisQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractPooledAnalysisDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractQuarterPooledAnalysisDTO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractPooledAnalysisService {
   List<ContractPooledAnalysisDTO> analyse(ContractAnalysisQueryDTOParam param);

   ContractQuarterPooledAnalysisDTO departmentQuarter(ContractAnalysisQueryDTOParam param);

   Boolean pooledExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response);

   Boolean departmentExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response);

   Boolean departmentQuarterExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response);
}
