package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCollectionQueryDoParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectIncomeExpenseDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractCollectionMapper extends BaseMapper<ContractCollection> {
   List<ContractCollectionDTO> listByCondition(ContractCollectionQueryDoParam param);

   BigDecimal selectCollectionAmount(@Param("projectId") Long projectId, @Param("auditStatus") Integer auditStatus);

   List<ContractCollectionWarningDTO> selectCollectionWarning(
      @Param("userId") Long userId, @Param("year") Integer year, @Param("projectId") Long projectId, @Param("boolArrears") Boolean boolArrears
   );

   List<ProjectIncomeExpenseDTO> selectIncomeExpenseList(@Param("year") Integer year, @Param("branchCompanyId") Long branchCompanyId);

   List<ContractCollection> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate);
}
