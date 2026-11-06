package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecord;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectRecordDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractProjectRecordMapper extends BaseMapper<ContractProjectRecord> {
   List<Long> findUserIdsByUserName(@Param("userName") String operationUserName);

   List<ProjectRecordDTO> listByConditions(
      @Param("projectId") Long projectId,
      @Param("type") Integer type,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("operator") String operator
   );
}
