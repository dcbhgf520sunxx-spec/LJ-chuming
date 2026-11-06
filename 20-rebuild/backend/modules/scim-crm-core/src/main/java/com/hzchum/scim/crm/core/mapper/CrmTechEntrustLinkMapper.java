package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTechEntrustLink;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustListDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface CrmTechEntrustLinkMapper extends BaseMapper<CrmTechEntrustLink> {
   List<CrmTechEntrustLinkListDTO> list(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmSettlementBusinessTypeEnum,
      Long crmProjectInformationWarehousingId,
      String userName,
      String createUserName
   );

   List<CrmTechEntrustListDTO> getTechEntrustList(
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      Long currentUserId,
      Set<Long> crmCanLookDeptIds
   );
}
