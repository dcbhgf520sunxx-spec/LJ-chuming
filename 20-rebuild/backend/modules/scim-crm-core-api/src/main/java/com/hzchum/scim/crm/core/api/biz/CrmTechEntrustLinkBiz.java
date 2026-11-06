package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTechEntrustLink;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsApproveDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkSaveDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import java.time.LocalDateTime;
import java.util.List;

public interface CrmTechEntrustLinkBiz extends IBiz<CrmTechEntrustLink> {
   PageVO<CrmTechEntrustLinkListDTO> list(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmSettlementBusinessTypeEnum,
      Long crmProjectInformationWarehousingId,
      String userName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean delete(List<Long> id);

   Boolean save(CrmTechEntrustLinkSaveDTO crmTechEntrustLinkSaveDTO);

   List<CrmTechEntrustProjectInfoDTO> listRemain();

   List<CrmTechEntrustProjectInfoDTO> filterableProjectList();

   PageVO<CrmTechEntrustListDTO> getTechEntrustList(
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<CrmSpecialProgramsDetailDTO> getSpecialProgramsDetail(Long id);

   Boolean saveSpecialPrograms(List<CrmSpecialProgramsSaveParam> copyToList);

   Boolean specialProgramsApprove(CrmAuditCommonDTO crmAuditCommonDTO);

   CrmSpecialProgramsApproveDetailDTO getSpecialProgramsApproveDetail(Long id);

   Boolean specialProgramsCancel(Long id);
}
