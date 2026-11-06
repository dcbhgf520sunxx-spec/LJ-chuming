package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.app.AppVisaDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractSettlementDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParamV2;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractVisaBiz {
   PageVO<ContractVisaDTO> pageList(
      Long projectId,
      Integer status,
      String userName,
      String checkUerName,
      Integer mode,
      String year,
      Integer businessType,
      Integer type,
      Integer pageNumber,
      Integer pageSize
   );

   AppVisaDTO appVisa(Long projectId, Integer status, String userName, String checkUerName, Integer mode, String year, Integer businessType, Integer type);

   ContractVisaDetailDTO getDetail(Long id);

   void exportDetail(Long id, HttpServletResponse response);

   void exportSettlementDetail(Long id, HttpServletResponse response);

   boolean save(ContractVisaDTOParam param);

   boolean update(ContractVisaDTOParam param);

   boolean check(ContractCheckDTOParam param);

   ContractVisaProjectInfoDTO projectInfoById(Long projectId);

   boolean handle(ContractSettlementDTOParam param);

   boolean updateProjectHandle(ContractSettlementDTOParam param);

   PageVO<ContractVisaDTO> pageListV2(
      Long projectId, Integer status, String userName, String checkUerName, Integer mode, LocalDate year, Integer type, Integer pageNumber, Integer pageSize
   );

   Boolean saveV2(ContractVisaDTOParamV2 param);

   ContractVisaDetailDTO getDetailV2(Long id);

   void getDetailDownloadV2(Long id);

   boolean checkV2(ContractVisaApproveOpinionDTOParam param);

   boolean cancelApproveDetail(Long id);

   Boolean deleteVisa(List<Long> ids);
}
