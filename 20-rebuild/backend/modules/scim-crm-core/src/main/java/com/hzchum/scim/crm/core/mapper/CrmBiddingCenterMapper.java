package com.hzchum.scim.crm.core.mapper;

import com.hzchum.scim.crm.core.api.pojo.dto.ArchivesManagementListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmMyTenderListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderListDTOV2;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrmBiddingCenterMapper {
   List<CrmTenderListDTO> getCrmTenderList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("structureTypeConfigurationId") Long structureTypeConfigurationId,
      @Param("departmentId") Long departmentId,
      @Param("projectName") String projectName,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("projectInformantUserName") String projectInformantUserName,
      @Param("projectIds") List<Long> projectIds,
      @Param("crmTenderRequirementTypeEnum") Integer crmTenderRequirementTypeEnum,
      @Param("crmCanLookDeptIds") Set<Long> crmCanLookDeptIds,
      @Param("userId") Long userId
   );

   List<CrmMyTenderListDTO> getMyCrmTenderList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("structureTypeConfigurationId") Long structureTypeConfigurationId,
      @Param("departmentId") Long departmentId,
      @Param("projectName") String projectName,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("projectInformantUserName") String projectInformantUserName,
      @Param("projectIds") List<Long> projectIds,
      @Param("crmTenderRequirementTypeEnum") Integer crmTenderRequirementTypeEnum,
      @Param("userId") Long userId
   );

   List<CrmTenderListDTOV2> getCrmTenderListCustom(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("cStartDate") LocalDateTime cStartDate,
      @Param("cEndDate") LocalDateTime cEndDate,
      @Param("crmSpecialBubmissionStatusEnum") Integer crmSpecialBubmissionStatusEnum,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("structureTypeConfigurationId") Long structureTypeConfigurationId,
      @Param("departmentId") Long departmentId,
      @Param("projectName") String projectName,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("projectInformantUserName") String projectInformantUserName,
      @Param("crmTenderRequirementTypeEnum") Integer crmTenderRequirementTypeEnum,
      @Param("crmCanLookDeptIds") Set<Long> crmCanLookDeptIds,
      @Param("currentUserId") Long currentUserId,
      @Param("crmSettlementBusinessTypeEnum") Integer crmSettlementBusinessTypeEnum
   );

   List<CrmMyTenderListDTOV2> getMyCrmTenderListCustom(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("structureTypeConfigurationId") Long structureTypeConfigurationId,
      @Param("departmentId") Long departmentId,
      @Param("projectName") String projectName,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("projectInformantUserName") String projectInformantUserName,
      @Param("crmTenderRequirementTypeEnum") Integer crmTenderRequirementTypeEnum,
      @Param("currentUserId") Long currentUserId,
      @Param("crmSpecialBubmissionStatusEnum") Integer crmSpecialBubmissionStatusEnum
   );

   List<ArchivesManagementListDTOV2> archivesManagementListCustom(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("crmTenderRequirementTypeEnum") Integer crmTenderRequirementTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("applyForBidReporterName") String applyForBidReporterName,
      @Param("crmCanLookInfoDeptIdsByModuleAndUserId") Set<Long> crmCanLookInfoDeptIdsByModuleAndUserId,
      @Param("userIds") Set<Long> userIds,
      @Param("crmSettlementBusinessTypeEnum") Integer crmSettlementBusinessTypeEnum,
      Long currentUserId
   );
}
