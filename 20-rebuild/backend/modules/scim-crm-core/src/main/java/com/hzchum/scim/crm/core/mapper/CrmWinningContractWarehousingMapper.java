package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmWinningContractWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingPageDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface CrmWinningContractWarehousingMapper extends BaseMapper<CrmWinningContractWarehousing> {
   List<CrmWinningContractWarehousingPageDTO> getContractList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectName") String projectName,
      @Param("serialNumber") String serialNumber,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("userId") Long userId,
      @Param("crmCanLookDeptIds") Set<Long> crmCanLookDeptIds,
      @Param("crmProjectScheduleTypeEnum") Integer crmProjectScheduleTypeEnum,
      @Param("condition") String condition,
      @Param("tenderRequirement") List<Integer> tenderRequirement
   );

   List<CrmSpecialProgramsDTO> getSpecialProgramsList(
      @Param("reportingStatus") Boolean reportingStatus,
      @Param("crmSubmissionStatusEnum") Integer crmSubmissionStatusEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectName") String projectName,
      @Param("projectNumber") String projectNumber,
      @Param("currentUserId") Long currentUserId,
      @Param("crmCanLookDeptIds") Set<Long> crmCanLookDeptIds
   );
}
