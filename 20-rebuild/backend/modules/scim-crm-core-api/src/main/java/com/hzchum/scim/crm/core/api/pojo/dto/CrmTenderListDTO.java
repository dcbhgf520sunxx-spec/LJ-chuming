package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmTenderListDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "项目登记日期", notes = "项目登记日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "serialNumber", value = "项目备案编号", notes = "项目备案编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案单位名称", notes = "企业备案单位名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionName", value = "区域名称", notes = "区域名称")
   private String regionName;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型名称", notes = "结构类型名称")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   private String departmentName;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "projectInformantUserIds", value = "项目投标负责人字符串ids", notes = "项目投标负责人字符串ids")
   private String projectInformantUserIds;
   @ApiModelProperty(name = "projectBidManagerUserName", value = "项目投标负责人", notes = "项目投标负责人")
   private String projectBidManagerUserName;
   @ApiModelProperty(name = "projectBidManagerFinishDate", value = "投标完成时间", notes = "投标完成时间")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "projectBidManagerActualFinishDate", value = "投标实际完成时间", notes = "投标实际完成时间")
   private LocalDateTime projectBidManagerActualFinishDate;
   @ApiModelProperty(name = "crmProjectBidStatus", value = "投标状态", notes = "投标状态")
   private Integer crmProjectBidStatus;

   public static CrmTenderListDTO.CrmTenderListDTOBuilder builder() {
      return new CrmTenderListDTO.CrmTenderListDTOBuilder();
   }

   public CrmTenderListDTO() {
   }

   public CrmTenderListDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String serialNumber,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final String countryName,
      final String provinceName,
      final String cityName,
      final String regionName,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String departmentName,
      final String regionNameList,
      final String informantUserName,
      final String projectInformantUserIds,
      final String projectBidManagerUserName,
      final LocalDateTime projectBidManagerFinishDate,
      final LocalDateTime projectBidManagerActualFinishDate,
      final Integer crmProjectBidStatus
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.countryName = countryName;
      this.provinceName = provinceName;
      this.cityName = cityName;
      this.regionName = regionName;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.departmentName = departmentName;
      this.regionNameList = regionNameList;
      this.informantUserName = informantUserName;
      this.projectInformantUserIds = projectInformantUserIds;
      this.projectBidManagerUserName = projectBidManagerUserName;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.projectBidManagerActualFinishDate = projectBidManagerActualFinishDate;
      this.crmProjectBidStatus = crmProjectBidStatus;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public String getCityName() {
      return this.cityName;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getProjectInformantUserIds() {
      return this.projectInformantUserIds;
   }

   public String getProjectBidManagerUserName() {
      return this.projectBidManagerUserName;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public LocalDateTime getProjectBidManagerActualFinishDate() {
      return this.projectBidManagerActualFinishDate;
   }

   public Integer getCrmProjectBidStatus() {
      return this.crmProjectBidStatus;
   }

   public CrmTenderListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmTenderListDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmTenderListDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmTenderListDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmTenderListDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmTenderListDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmTenderListDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmTenderListDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmTenderListDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmTenderListDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmTenderListDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmTenderListDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmTenderListDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmTenderListDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmTenderListDTO setProjectInformantUserIds(final String projectInformantUserIds) {
      this.projectInformantUserIds = projectInformantUserIds;
      return this;
   }

   public CrmTenderListDTO setProjectBidManagerUserName(final String projectBidManagerUserName) {
      this.projectBidManagerUserName = projectBidManagerUserName;
      return this;
   }

   public CrmTenderListDTO setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmTenderListDTO setProjectBidManagerActualFinishDate(final LocalDateTime projectBidManagerActualFinishDate) {
      this.projectBidManagerActualFinishDate = projectBidManagerActualFinishDate;
      return this;
   }

   public CrmTenderListDTO setCrmProjectBidStatus(final Integer crmProjectBidStatus) {
      this.crmProjectBidStatus = crmProjectBidStatus;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTenderListDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", countryName="
         + this.getCountryName()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityName="
         + this.getCityName()
         + ", regionName="
         + this.getRegionName()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", departmentName="
         + this.getDepartmentName()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", projectInformantUserIds="
         + this.getProjectInformantUserIds()
         + ", projectBidManagerUserName="
         + this.getProjectBidManagerUserName()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", projectBidManagerActualFinishDate="
         + this.getProjectBidManagerActualFinishDate()
         + ", crmProjectBidStatus="
         + this.getCrmProjectBidStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTenderListDTO)) {
         return false;
      }

      CrmTenderListDTO other = (CrmTenderListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectBidStatus = this.getCrmProjectBidStatus();
         Object other$crmProjectBidStatus = other.getCrmProjectBidStatus();
         if (this$crmProjectBidStatus == null ? other$crmProjectBidStatus == null : this$crmProjectBidStatus.equals(other$crmProjectBidStatus)) {
            Object this$informantDateTime = this.getInformantDateTime();
            Object other$informantDateTime = other.getInformantDateTime();
            if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                     Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                     if (this$crmEnterpriseWarehousingName == null
                        ? other$crmEnterpriseWarehousingName == null
                        : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                        Object this$countryName = this.getCountryName();
                        Object other$countryName = other.getCountryName();
                        if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                           Object this$provinceName = this.getProvinceName();
                           Object other$provinceName = other.getProvinceName();
                           if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                              Object this$cityName = this.getCityName();
                              Object other$cityName = other.getCityName();
                              if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                 Object this$regionName = this.getRegionName();
                                 Object other$regionName = other.getRegionName();
                                 if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                    Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                                    Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                                    if (this$structureTypeConfigurationName == null
                                       ? other$structureTypeConfigurationName == null
                                       : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                       Object this$estimatedCost = this.getEstimatedCost();
                                       Object other$estimatedCost = other.getEstimatedCost();
                                       if (this$estimatedCost == null ? other$estimatedCost == null : this$estimatedCost.equals(other$estimatedCost)) {
                                          Object this$departmentName = this.getDepartmentName();
                                          Object other$departmentName = other.getDepartmentName();
                                          if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                             Object this$regionNameList = this.getRegionNameList();
                                             Object other$regionNameList = other.getRegionNameList();
                                             if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
                                                Object this$informantUserName = this.getInformantUserName();
                                                Object other$informantUserName = other.getInformantUserName();
                                                if (this$informantUserName == null
                                                   ? other$informantUserName == null
                                                   : this$informantUserName.equals(other$informantUserName)) {
                                                   Object this$projectInformantUserIds = this.getProjectInformantUserIds();
                                                   Object other$projectInformantUserIds = other.getProjectInformantUserIds();
                                                   if (this$projectInformantUserIds == null
                                                      ? other$projectInformantUserIds == null
                                                      : this$projectInformantUserIds.equals(other$projectInformantUserIds)) {
                                                      Object this$projectBidManagerUserName = this.getProjectBidManagerUserName();
                                                      Object other$projectBidManagerUserName = other.getProjectBidManagerUserName();
                                                      if (this$projectBidManagerUserName == null
                                                         ? other$projectBidManagerUserName == null
                                                         : this$projectBidManagerUserName.equals(other$projectBidManagerUserName)) {
                                                         Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                                                         Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                                                         if (this$projectBidManagerFinishDate == null
                                                            ? other$projectBidManagerFinishDate == null
                                                            : this$projectBidManagerFinishDate.equals(other$projectBidManagerFinishDate)) {
                                                            Object this$projectBidManagerActualFinishDate = this.getProjectBidManagerActualFinishDate();
                                                            Object other$projectBidManagerActualFinishDate = other.getProjectBidManagerActualFinishDate();
                                                            return this$projectBidManagerActualFinishDate == null
                                                               ? other$projectBidManagerActualFinishDate == null
                                                               : this$projectBidManagerActualFinishDate.equals(other$projectBidManagerActualFinishDate);
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmTenderListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectBidStatus = this.getCrmProjectBidStatus();
      result = result * 59 + ($crmProjectBidStatus == null ? 43 : $crmProjectBidStatus.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $projectInformantUserIds = this.getProjectInformantUserIds();
      result = result * 59 + ($projectInformantUserIds == null ? 43 : $projectInformantUserIds.hashCode());
      Object $projectBidManagerUserName = this.getProjectBidManagerUserName();
      result = result * 59 + ($projectBidManagerUserName == null ? 43 : $projectBidManagerUserName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $projectBidManagerActualFinishDate = this.getProjectBidManagerActualFinishDate();
      return result * 59 + ($projectBidManagerActualFinishDate == null ? 43 : $projectBidManagerActualFinishDate.hashCode());
   }

   public static class CrmTenderListDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String serialNumber;
      private String projectName;
      private String crmEnterpriseWarehousingName;
      private String countryName;
      private String provinceName;
      private String cityName;
      private String regionName;
      private String structureTypeConfigurationName;
      private BigDecimal estimatedCost;
      private String departmentName;
      private String regionNameList;
      private String informantUserName;
      private String projectInformantUserIds;
      private String projectBidManagerUserName;
      private LocalDateTime projectBidManagerFinishDate;
      private LocalDateTime projectBidManagerActualFinishDate;
      private Integer crmProjectBidStatus;

      CrmTenderListDTOBuilder() {
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder structureTypeConfigurationName(final String structureTypeConfigurationName) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder projectInformantUserIds(final String projectInformantUserIds) {
         this.projectInformantUserIds = projectInformantUserIds;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder projectBidManagerUserName(final String projectBidManagerUserName) {
         this.projectBidManagerUserName = projectBidManagerUserName;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder projectBidManagerActualFinishDate(final LocalDateTime projectBidManagerActualFinishDate) {
         this.projectBidManagerActualFinishDate = projectBidManagerActualFinishDate;
         return this;
      }

      public CrmTenderListDTO.CrmTenderListDTOBuilder crmProjectBidStatus(final Integer crmProjectBidStatus) {
         this.crmProjectBidStatus = crmProjectBidStatus;
         return this;
      }

      public CrmTenderListDTO build() {
         return new CrmTenderListDTO(
            this.id,
            this.informantDateTime,
            this.serialNumber,
            this.projectName,
            this.crmEnterpriseWarehousingName,
            this.countryName,
            this.provinceName,
            this.cityName,
            this.regionName,
            this.structureTypeConfigurationName,
            this.estimatedCost,
            this.departmentName,
            this.regionNameList,
            this.informantUserName,
            this.projectInformantUserIds,
            this.projectBidManagerUserName,
            this.projectBidManagerFinishDate,
            this.projectBidManagerActualFinishDate,
            this.crmProjectBidStatus
         );
      }

      @Override
      public String toString() {
         return "CrmTenderListDTO.CrmTenderListDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", countryName="
            + this.countryName
            + ", provinceName="
            + this.provinceName
            + ", cityName="
            + this.cityName
            + ", regionName="
            + this.regionName
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", estimatedCost="
            + this.estimatedCost
            + ", departmentName="
            + this.departmentName
            + ", regionNameList="
            + this.regionNameList
            + ", informantUserName="
            + this.informantUserName
            + ", projectInformantUserIds="
            + this.projectInformantUserIds
            + ", projectBidManagerUserName="
            + this.projectBidManagerUserName
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", projectBidManagerActualFinishDate="
            + this.projectBidManagerActualFinishDate
            + ", crmProjectBidStatus="
            + this.crmProjectBidStatus
            + ")";
      }
   }
}
