package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SaveContractDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractCollectionUpdateDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ContractCollectionBiz {
   PageVO<ContractCollectionDTO> pageList(ContractCollectionQueryDtoParam param, Integer pageNumber, Integer pageSize);

   BigDecimal getSummaryCollection(ContractCollectionQueryDtoParam param);

   PrintVO<List<Map<String, Object>>> printList(ContractCollectionQueryDtoParam param);

   Boolean saveList(Integer type, List<ContractCollectionSaveDTOParam> saveParams);

   Boolean auditCollection(ContractCheckDtoParam param);

   Boolean updateCollection(ContractCollectionUpdateDTOParam editDTOParam);

   Boolean deleteCollection(Long id);

   PageVO<ContractCollectionWarningDTO> listCollectionWarning(Integer year, Long projectId, Boolean boolArrears, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printCollectionWarnings(Integer year, Long projectId, Boolean boolArrears);

   SaveContractDto getProject(Long projectId, Integer level);

   Boolean saveCollection(ContractCollectionSaveDTOParam param);

   PrintVO<List<Map<String, Object>>> downloadCollectionLedger(Long projectId, Integer level);

   PageVO<ContractCollectionV2DTO> listCollectionLedger(Long projectId, Integer level, Integer pageNumber, Integer pageSize);

   List<CostSummaryValueDTO> getProjectDisburse(Long projectId, List<LocalDate> yearMonthDateList);
}
