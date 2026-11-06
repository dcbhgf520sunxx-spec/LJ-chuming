package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmMyTenderListDTO {
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
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型名称", notes = "结构类型名称")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "projectBidManagerUserName", value = "项目投标负责人", notes = "项目投标负责人")
   private String projectBidManagerUserName;
   @ApiModelProperty(name = "projectBidManagerFinishDate", value = "投标完成时间", notes = "投标完成时间")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "crmProjectBidStatus", value = "投标状态", notes = "投标状态")
   private Integer crmProjectBidStatus;

   public static CrmMyTenderListDTO.CrmMyTenderListDTOBuilder builder() {
      return new CrmMyTenderListDTO.CrmMyTenderListDTOBuilder();
   }

   public CrmMyTenderListDTO() {
   }

   public CrmMyTenderListDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String serialNumber,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final String countryName,
      final String provinceName,
      final String cityName,
      final String regionName,
      final String regionNameList,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String departmentName,
      final String informantUserName,
      final String projectBidManagerUserName,
      final LocalDateTime projectBidManagerFinishDate,
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
      this.regionNameList = regionNameList;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.projectBidManagerUserName = projectBidManagerUserName;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
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

   public String getRegionNameList() {
      return this.regionNameList;
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

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getProjectBidManagerUserName() {
      return this.projectBidManagerUserName;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public Integer getCrmProjectBidStatus() {
      return this.crmProjectBidStatus;
   }

   public CrmMyTenderListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmMyTenderListDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmMyTenderListDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmMyTenderListDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmMyTenderListDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmMyTenderListDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmMyTenderListDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmMyTenderListDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmMyTenderListDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmMyTenderListDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmMyTenderListDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmMyTenderListDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmMyTenderListDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmMyTenderListDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmMyTenderListDTO setProjectBidManagerUserName(final String projectBidManagerUserName) {
      this.projectBidManagerUserName = projectBidManagerUserName;
      return this;
   }

   public CrmMyTenderListDTO setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmMyTenderListDTO setCrmProjectBidStatus(final Integer crmProjectBidStatus) {
      this.crmProjectBidStatus = crmProjectBidStatus;
      return this;
   }

   @Override
   public String toString() {
      return "CrmMyTenderListDTO(id="
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
         + ", regionNameList="
         + this.getRegionNameList()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", projectBidManagerUserName="
         + this.getProjectBidManagerUserName()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", crmProjectBidStatus="
         + this.getCrmProjectBidStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmMyTenderListDTO)) {
         return false;
      }

      CrmMyTenderListDTO other = (CrmMyTenderListDTO)o;
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
                                    Object this$regionNameList = this.getRegionNameList();
                                    Object other$regionNameList = other.getRegionNameList();
                                    if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
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
                                                Object this$informantUserName = this.getInformantUserName();
                                                Object other$informantUserName = other.getInformantUserName();
                                                if (this$informantUserName == null
                                                   ? other$informantUserName == null
                                                   : this$informantUserName.equals(other$informantUserName)) {
                                                   Object this$projectBidManagerUserName = this.getProjectBidManagerUserName();
                                                   Object other$projectBidManagerUserName = other.getProjectBidManagerUserName();
                                                   if (this$projectBidManagerUserName == null
                                                      ? other$projectBidManagerUserName == null
                                                      : this$projectBidManagerUserName.equals(other$projectBidManagerUserName)) {
                                                      Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                                                      Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                                                      return this$projectBidManagerFinishDate == null
                                                         ? other$projectBidManagerFinishDate == null
                                                         : this$projectBidManagerFinishDate.equals(other$projectBidManagerFinishDate);
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
      return other instanceof CrmMyTenderListDTO;
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
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $projectBidManagerUserName = this.getProjectBidManagerUserName();
      result = result * 59 + ($projectBidManagerUserName == null ? 43 : $projectBidManagerUserName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      return result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
   }

   public static class CrmMyTenderListDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String serialNumber;
      private String projectName;
      private String crmEnterpriseWarehousingName;
      private String countryName;
      private String provinceName;
      private String cityName;
      private String regionName;
      private String regionNameList;
      private String structureTypeConfigurationName;
      private BigDecimal estimatedCost;
      private String departmentName;
      private String informantUserName;
      private String projectBidManagerUserName;
      private LocalDateTime projectBidManagerFinishDate;
      private Integer crmProjectBidStatus;

      CrmMyTenderListDTOBuilder() {
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder structureTypeConfigurationName(final String structureTypeConfigurationName) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder projectBidManagerUserName(final String projectBidManagerUserName) {
         this.projectBidManagerUserName = projectBidManagerUserName;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmMyTenderListDTO.CrmMyTenderListDTOBuilder crmProjectBidStatus(final Integer crmProjectBidStatus) {
         this.crmProjectBidStatus = crmProjectBidStatus;
         return this;
      }

      public CrmMyTenderListDTO build() {
         return new CrmMyTenderListDTO(
            this.id,
            this.informantDateTime,
            this.serialNumber,
            this.projectName,
            this.crmEnterpriseWarehousingName,
            this.countryName,
            this.provinceName,
            this.cityName,
            this.regionName,
            this.regionNameList,
            this.structureTypeConfigurationName,
            this.estimatedCost,
            this.departmentName,
            this.informantUserName,
            this.projectBidManagerUserName,
            this.projectBidManagerFinishDate,
            this.crmProjectBidStatus
         );
      }

      @Override
      public String toString() {
         return "CrmMyTenderListDTO.CrmMyTenderListDTOBuilder(id="
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
            + ", regionNameList="
            + this.regionNameList
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", estimatedCost="
            + this.estimatedCost
            + ", departmentName="
            + this.departmentName
            + ", informantUserName="
            + this.informantUserName
            + ", projectBidManagerUserName="
            + this.projectBidManagerUserName
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", crmProjectBidStatus="
            + this.crmProjectBidStatus
            + ")";
      }
   }
}
