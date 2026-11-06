package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFinanceProcessPriceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectFinanceDTO;
import java.util.List;
import java.util.Map;

public interface ContractProjectFinanceBiz {
   PageVO<ContractProjectFinanceDTO> listProjectFinance(
      Integer year,
      Long projectId,
      Integer businessType,
      Integer projectType,
      Integer orderSourceType,
      Integer status,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printListProjectFinance(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   );

   PageVO listProjectOutbound(Long projectId, Integer basicClassEnum, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListProjectOutbound(Long projectId, Integer basicClassEnum);

   List<Map<String, Object>> listDepreciationFee(Long projectId);

   PrintVO<List<Map<String, Object>>> printListDepreciationFee(Long projectId);

   List<ContractFinanceProcessPriceDTO> listLaborFee(Long projectId);

   PrintVO<List<ContractFinanceProcessPriceDTO>> printListLaborFee(Long projectId);

   List<Map<String, Object>> listTestingFee(Long projectId);

   PrintVO<List<Map<String, Object>>> printListTestingFee(Long projectId);

   List<Map<String, Object>> listSubFee(Long projectId);

   PrintVO<List<Map<String, Object>>> printListSubFee(Long projectId);

   List<Map<String, Object>> listWaterEleFee(Long projectId);

   PrintVO<List<Map<String, Object>>> printListWaterEleFee(Long projectId);

   List<Map<String, Object>> listManagerFee(Long projectId);

   PrintVO<List<Map<String, Object>>> printListManagerFee(Long projectId);
}
