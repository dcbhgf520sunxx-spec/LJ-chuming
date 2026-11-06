package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.crm.core.api.pojo.dto.ArchivesManagementListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.ArchivesManagementListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmHeadFillOutDetail;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectDocumentationListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectDocumentationListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheProjectLeaderDetailsDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheProjectLeaderDetailsDTOV2;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParamV2;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParamV2;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmBiddingCenterBiz {
   PageVO<CrmTenderListDTO> getCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   HashMap<String, Object> getTenderListSummary(Integer crmTenderRequirementTypeEnum);

   Boolean setTenderHead(CrmSetTenderHeadParam crmSetTenderHeadParam);

   PageVO<CrmMyTenderListDTO> getMyCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   HashMap<String, Object> getMyTenderListSummary(Integer crmTenderRequirementTypeEnum);

   Boolean uploadTenderDocuments(CrmUploadTenderDocumentsParam copy);

   CrmTheProjectLeaderDetailsDTO detailsOfTheProjectLeader(Integer crmTenderRequirementTypeEnum, Long crmProjectInformationWarehousingId);

   PageVO<ArchivesManagementListDTO> archivesManagementList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      Integer pageNumber,
      Integer pageSize
   );

   List<CrmProjectDocumentationListDTO> projectDocumentationList(Integer crmTenderRequirementTypeEnum, Long crmProjectInformationWarehousingId);

   CrmApplyForBidRecordDetailDTO getTenderDetail(Long id, Integer crmTenderRequirementTypeEnum);

   void downLoadAttachment(Long id);

   void crmTenderDetailDownLoad(Long id, Integer crmTenderRequirementTypeEnum, HttpServletResponse response);

   PrintVO<List<Map<String, Object>>> downLoadCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   );

   PrintVO<List<Map<String, Object>>> myTenderListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   );

   PrintVO<List<Map<String, Object>>> archivesManagementListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName
   );

   PageVO<CrmTenderListDTOV2> getCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cStartDate,
      LocalDateTime cEndDate,
      Integer crmSpecialBubmissionStatusEnum,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSettlementBusinessTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<CrmMyTenderListDTOV2> getMyCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cStartDate,
      LocalDateTime cEndDate,
      Integer crmSpecialBubmissionStatusEnum,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmSettlementBusinessTypeEnum,
      Integer crmTenderRequirementTypeEnum
   );

   CrmApplyForBidRecordDetailDTOV2 getTenderDetailCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId
   );

   Boolean setTenderHeadCustom(CrmSetTenderHeadParamV2 crmSetTenderHeadParamV2);

   PrintVO<List<Map<String, Object>>> myTenderListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   );

   Boolean uploadTenderDocumentsCustom(CrmUploadTenderDocumentsParamV2 copy);

   PageVO<ArchivesManagementListDTOV2> archivesManagementListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      Integer crmSettlementBusinessTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> archivesManagementListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      Integer crmSettlementBusinessTypeEnum,
      String headUserName
   );

   List<CrmProjectDocumentationListDTOV2> projectDocumentationListCustom(
      Integer crmTenderRequirementTypeEnum,
      Long crmProjectInformationWarehousingId,
      Integer crmSettlementBusinessTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   );

   CrmTheProjectLeaderDetailsDTOV2 detailsOfTheProjectLeaderCustom(
      Integer crmTenderRequirementTypeEnum,
      Long crmProjectInformationWarehousingId,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   );

   void crmTenderDetailDownLoadCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId,
      HttpServletResponse response
   );

   HashMap<String, Object> getTenderListSummaryCustom(
      Integer crmTenderRequirementTypeEnum, Integer crmSpecialBubmissionStatusEnum, Integer crmSettlementBusinessTypeEnum
   );

   HashMap<String, Object> getMyTenderListSummaryCustom(Integer crmTenderRequirementTypeEnum);

   CrmHeadFillOutDetail getHeadFillOutDetail(Long id, Integer crmTenderRequirementTypeEnum);

   Boolean updateBiddingStatus(CrmSetTenderHeadParamV2 copy);
}
