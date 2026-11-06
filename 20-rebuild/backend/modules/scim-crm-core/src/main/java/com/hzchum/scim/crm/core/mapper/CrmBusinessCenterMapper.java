package com.hzchum.scim.crm.core.mapper;

import com.hzchum.scim.crm.core.api.pojo.dto.CrmCenterProjectListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrmBusinessCenterMapper {
   List<CrmCenterProjectListDTO> getCrmCenterProjectList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("structureTypeConfigurationId") Long structureTypeConfigurationId,
      @Param("departmentIds") List<Long> departmentIds,
      @Param("projectName") String projectName,
      @Param("informantUserName") String informantUserName,
      @Param("crmEnterpriseWarehousingName") String crmEnterpriseWarehousingName,
      @Param("userId") Long userId,
      @Param("crmCanLookDeptIds") Set<Long> crmCanLookDeptIds
   );

   List<CrmSupplierWarehousingPageDTO> getCrmSupplierWarehousingPage(
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

   List<CrmGovernmentWarehousingPageDTO> getGovernmentList(
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
}
