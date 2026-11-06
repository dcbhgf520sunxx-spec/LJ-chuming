package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCenterProjectListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectFollowUpRecordDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.ProjectPublicPoolDTO;
import com.hzchum.scim.crm.core.api.pojo.param.ProjectAssignmentParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectTerminatedUpdateDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmBusinessCenterBiz {
   List<ProjectPublicPoolDTO> getProjectPublicPool(
      Long projectLevelConfigId, LocalDate startDate, LocalDate endDate, String projectName, Integer pageNumber, Integer pageSize
   );

   PageVO<ProjectPublicPoolDTO> getProjectPublicPoolAPP(
      Long projectLevelConfigId, LocalDate startDate, LocalDate endDate, String projectName, Integer pageNumber, Integer pageSize
   );

   Boolean assignmentProject(ProjectAssignmentParam projectAssignmentParam);

   HashMap<String, Object> summary();

   PageVO<CrmCenterProjectListDTO> centerProjectList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   List<CrmProjectFollowUpRecordDTO> getFollowUpRecord(Long crmProjectInformationWarehousingId);

   HashMap<String, Integer> getEnterpriseSummary();

   PageVO<CrmEnterpriseWarehousingPageDTO> getCrmEnterpriseWarehousingPage(
      Integer crmCheckStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetail(Long id);

   Boolean downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response);

   PrintVO<List<Map<String, Object>>> downLoadCrmEnterpriseWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   );

   HashMap<String, Integer> supplierSummary();

   PageVO<CrmSupplierWarehousingPageDTO> getCrmSupplierWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmSupplierWarehousingList(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   );

   CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetail(Long id);

   Boolean downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response);

   PageVO<CrmGovernmentWarehousingPageDTO> getCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   );

   CrmGovernmentWarehousingDetailDTO crmGovernmentWarehousingDetail(Long id);

   Boolean downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response);

   HashMap<String, Integer> governmentSummary();

   HashMap<String, Integer> platformSummary();

   PageVO<CrmBiddingPlatformWarehousingPageDTO> getCrmBiddingPlatformWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      String biddingPlatformName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmBiddingPlatformWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      String biddingPlatformName,
      String informantUserName
   );

   CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetail(Long id);

   Boolean downLoadCrmBiddingPlatformWarehousingDetail(Long id, HttpServletResponse response);

   PrintVO<List<Map<String, Object>>> centerProjectListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName
   );

   Boolean projectTerminated(CrmProjectTerminatedUpdateDTO dto);
}
