package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursement;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractReimbursementMapper extends BaseMapper<ContractReimbursement> {
   List<ReimbursementDTO> listByConditions(
      @Param("dateType") Integer dateType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("projectId") Long projectId,
      @Param("type") Integer type,
      @Param("applyDepartName") String applyDepartName,
      @Param("applyUserName") String applyUserName,
      @Param("writtenByName") String writtenByName,
      @Param("confirmStatus") Integer confirmStatus
   );

   BigDecimal selectActuallyPayAmountSum(@Param("projectId") Long projectId, Integer confirmStatus);

   BigDecimal selectTaxInSum(@Param("projectId") Long projectId, Integer confirmStatus);
}
