package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursement;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementConfirmDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ReimbursementEditDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ContractReimbursementService extends IService<ContractReimbursement> {
   PageVO<ReimbursementDTO> listReimbursements(
      Integer dateType,
      LocalDate startDate,
      LocalDate endDate,
      Long projectId,
      Integer type,
      String applyDepartName,
      String applyUserName,
      String writtenByName,
      Integer confirmStatus,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   PrintVO<List<Map<String, Object>>> printReimbursements(
      Integer dateType,
      LocalDate startDate,
      LocalDate endDate,
      Long projectId,
      Integer type,
      String applyDepartName,
      String applyUserName,
      String writtenByName,
      Integer confirmStatus
   );

   BigDecimal getSumActuallyPayAmount(Long projectId);

   Boolean saveReimbursement(ReimbursementSaveDTOParam saveDTOParam);

   Boolean updateReimbursement(ReimbursementEditDTOParam updateDTOParam);

   Boolean confirmReimbursement(ReimbursementConfirmDTOParam confirmDTOParam);
}
