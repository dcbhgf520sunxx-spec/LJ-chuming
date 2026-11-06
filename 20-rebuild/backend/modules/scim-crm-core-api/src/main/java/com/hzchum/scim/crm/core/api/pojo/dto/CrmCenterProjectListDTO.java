package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CrmCenterProjectListDTO {
   @ApiModelProperty(name = "id", value = "项目备案id", notes = "项目备案id")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "serialNumber", value = "项目备案号", notes = "项目备案号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型 structureTypeConfigurationName", notes = "结构类型 structureTypeConfigurationName")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "projectLevelConfigName", value = "项目级别 projectLevelConfigName", notes = "项目级别 projectLevelConfigName")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "departmentName", value = "所属部门名称", notes = "所属部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "validityOfRegistration", value = "项目剩余天数", notes = "项目剩余天数")
   private Integer validityOfRegistration;
   @ApiModelProperty(name = "validityOfRegistrationDate", value = "项目有效期到期日期", notes = "项目有效期到期日期")
   private LocalDate validityOfRegistrationDate;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态", notes = "当前状态")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "informationOperatorUserName", value = "项目信息可操作人名称", notes = "项目信息可操作人名称")
   private String informationOperatorUserName;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "lastDistributionTime", value = "最后分配时间", notes = "最后分配时间")
   private LocalDateTime lastDistributionTime;

   public CrmCenterProjectListDTO(
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
      final String projectLevelConfigName,
      final String departmentName,
      final String informantUserName,
      final String createUserName,
      final Integer validityOfRegistration,
      final LocalDate validityOfRegistrationDate,
      final Integer crmProjectScheduleTypeEnum,
      final String informationOperatorUserName,
      final Integer crmCountryTypeEnum,
      final LocalDateTime lastDistributionTime
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
      this.projectLevelConfigName = projectLevelConfigName;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.createUserName = createUserName;
      this.validityOfRegistration = validityOfRegistration;
      this.validityOfRegistrationDate = validityOfRegistrationDate;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.informationOperatorUserName = informationOperatorUserName;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.lastDistributionTime = lastDistributionTime;
   }

   public CrmCenterProjectListDTO() {
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

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getValidityOfRegistration() {
      return this.validityOfRegistration;
   }

   public LocalDate getValidityOfRegistrationDate() {
      return this.validityOfRegistrationDate;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getInformationOperatorUserName() {
      return this.informationOperatorUserName;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public LocalDateTime getLastDistributionTime() {
      return this.lastDistributionTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
   }

   public void setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
   }

   public void setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
   }

   public void setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setValidityOfRegistration(final Integer validityOfRegistration) {
      this.validityOfRegistration = validityOfRegistration;
   }

   public void setValidityOfRegistrationDate(final LocalDate validityOfRegistrationDate) {
      this.validityOfRegistrationDate = validityOfRegistrationDate;
   }

   public void setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
   }

   public void setInformationOperatorUserName(final String informationOperatorUserName) {
      this.informationOperatorUserName = informationOperatorUserName;
   }

   public void setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
   }

   public void setLastDistributionTime(final LocalDateTime lastDistributionTime) {
      this.lastDistributionTime = lastDistributionTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmCenterProjectListDTO)) {
         return false;
      }

      CrmCenterProjectListDTO other = (CrmCenterProjectListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$validityOfRegistration = this.getValidityOfRegistration();
         Object other$validityOfRegistration = other.getValidityOfRegistration();
         if (this$validityOfRegistration == null ? other$validityOfRegistration == null : this$validityOfRegistration.equals(other$validityOfRegistration)) {
            Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
            Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
            if (this$crmProjectScheduleTypeEnum == null
               ? other$crmProjectScheduleTypeEnum == null
               : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
               Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
               Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
               if (this$crmCountryTypeEnum == null ? other$crmCountryTypeEnum == null : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
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
                                                   Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                                                   Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                                                   if (this$projectLevelConfigName == null
                                                      ? other$projectLevelConfigName == null
                                                      : this$projectLevelConfigName.equals(other$projectLevelConfigName)) {
                                                      Object this$departmentName = this.getDepartmentName();
                                                      Object other$departmentName = other.getDepartmentName();
                                                      if (this$departmentName == null
                                                         ? other$departmentName == null
                                                         : this$departmentName.equals(other$departmentName)) {
                                                         Object this$informantUserName = this.getInformantUserName();
                                                         Object other$informantUserName = other.getInformantUserName();
                                                         if (this$informantUserName == null
                                                            ? other$informantUserName == null
                                                            : this$informantUserName.equals(other$informantUserName)) {
                                                            Object this$createUserName = this.getCreateUserName();
                                                            Object other$createUserName = other.getCreateUserName();
                                                            if (this$createUserName == null
                                                               ? other$createUserName == null
                                                               : this$createUserName.equals(other$createUserName)) {
                                                               Object this$validityOfRegistrationDate = this.getValidityOfRegistrationDate();
                                                               Object other$validityOfRegistrationDate = other.getValidityOfRegistrationDate();
                                                               if (this$validityOfRegistrationDate == null
                                                                  ? other$validityOfRegistrationDate == null
                                                                  : this$validityOfRegistrationDate.equals(other$validityOfRegistrationDate)) {
                                                                  Object this$informationOperatorUserName = this.getInformationOperatorUserName();
                                                                  Object other$informationOperatorUserName = other.getInformationOperatorUserName();
                                                                  if (this$informationOperatorUserName == null
                                                                     ? other$informationOperatorUserName == null
                                                                     : this$informationOperatorUserName.equals(other$informationOperatorUserName)) {
                                                                     Object this$lastDistributionTime = this.getLastDistributionTime();
                                                                     Object other$lastDistributionTime = other.getLastDistributionTime();
                                                                     return this$lastDistributionTime == null
                                                                        ? other$lastDistributionTime == null
                                                                        : this$lastDistributionTime.equals(other$lastDistributionTime);
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
      return other instanceof CrmCenterProjectListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $validityOfRegistration = this.getValidityOfRegistration();
      result = result * 59 + ($validityOfRegistration == null ? 43 : $validityOfRegistration.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
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
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $validityOfRegistrationDate = this.getValidityOfRegistrationDate();
      result = result * 59 + ($validityOfRegistrationDate == null ? 43 : $validityOfRegistrationDate.hashCode());
      Object $informationOperatorUserName = this.getInformationOperatorUserName();
      result = result * 59 + ($informationOperatorUserName == null ? 43 : $informationOperatorUserName.hashCode());
      Object $lastDistributionTime = this.getLastDistributionTime();
      return result * 59 + ($lastDistributionTime == null ? 43 : $lastDistributionTime.hashCode());
   }

   @Override
   public String toString() {
      return "CrmCenterProjectListDTO(id="
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
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", createUserName="
         + this.getCreateUserName()
         + ", validityOfRegistration="
         + this.getValidityOfRegistration()
         + ", validityOfRegistrationDate="
         + this.getValidityOfRegistrationDate()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", informationOperatorUserName="
         + this.getInformationOperatorUserName()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", lastDistributionTime="
         + this.getLastDistributionTime()
         + ")";
   }
}
