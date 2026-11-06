package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCanBeReleasedSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCheckProjectHaveRecordingDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectCanCarryOutTypeDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectCanCarryOutTypeDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDetailAPPDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmThisProjectBindEnterRecordInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectInformationWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationWarehousingUpdateParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmProjectInformationWarehousingBiz extends IBiz<CrmProjectInformationWarehousing> {
   PageVO<CrmProjectInformationWarehousingDTO> getCrmProjectInformationWarehousingList(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName,
      String condition,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean saveCrmProjectInformationWarehousing(CrmProjectInformationWarehousingSaveParam copy);

   Boolean deleteCrmProjectInformationWarehousing(Long id);

   Boolean updateCrmProjectInformationWarehousing(CrmProjectInformationWarehousingUpdateParam copy);

   CrmProjectInformationWarehousingDetailDTO crmProjectInformationWarehousingDetail(Long id);

   CrmProjectInformationWarehousingDetailAPPDTO crmProjectInformationWarehousingDetailAPP(Long id);

   Boolean downLoadCrmProjectInformationWarehousingDetail(Long id, HttpServletResponse response);

   Boolean filingTaskGrant(CrmFilingTaskGrantUpdateParam crmFilingTaskGrantUpdateParam);

   Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO);

   List<CrmCanBeReleasedSimpleDTO> canBeReleased();

   List<CrmProjectInformationWarehousingSimpleDTO> getCrmAllProjectInformationWarehousingSimpleList();

   Boolean projectFilingQuash(Long id);

   List<CrmCanBeReleasedSimpleDTO> canUpdateProjectList(Integer crmPageManagementConfigEnum, Long id);

   CrmProjectCanCarryOutTypeDTO projectCanCarryOutType(Long id);

   CrmThisProjectBindEnterRecordInfoDTO thisProjectBindEnterRecordInfo(Long id);

   PrintVO<List<Map<String, Object>>> getCrmProjectInformationWarehousingListDownLoad(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName
   );

   CrmCheckProjectHaveRecordingDTO checkProjectHaveRecording(Long id);

   CrmCheckProjectHaveRecordingDTO checkProjectHaveRecordingCustom(Long id);

   CrmProjectCanCarryOutTypeDTOV2 projectCanCarryOutTypeCustom(Long id);

   List<Integer> getCanBidApplicationType(Long id);
}
