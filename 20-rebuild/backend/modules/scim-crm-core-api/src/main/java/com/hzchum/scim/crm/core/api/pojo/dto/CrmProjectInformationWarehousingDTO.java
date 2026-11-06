package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmProjectInformationWarehousingDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "estimatedWorks", value = "预估工程量", notes = "预估工程量")
   private BigDecimal estimatedWorks;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型 CrmProjectInformationConfig", notes = "结构类型 CrmProjectInformationConfig")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "address", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "createUserName", value = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "keyProjectName", value = "重点项目名称", notes = "重点项目名称")
   private String keyProjectName;
   @ApiModelProperty(name = "projectLevelConfigName", value = "项目级别 projectLevelConfigName", notes = "项目级别 projectLevelConfigName")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "effectiveRemainingTime", value = "项目有效剩余时间", notes = "项目有效剩余时间")
   private Integer effectiveRemainingTime;
   @ApiModelProperty(name = "FollowUpTimes", value = "项目跟进次数", notes = "项目跟进次数")
   private Integer followUpTimes;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态枚举", notes = "当前状态枚举")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnumName", value = "当前状态", notes = "当前状态")
   private String crmProjectScheduleTypeEnumName;

   public static CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder builder() {
      return new CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder();
   }

   public CrmProjectInformationWarehousingDTO() {
   }

   public CrmProjectInformationWarehousingDTO(
      final Long id,
      final String regionNameList,
      final BigDecimal estimatedWorks,
      final BigDecimal estimatedCost,
      final BigDecimal areaOfStructure,
      final String structureTypeConfigurationName,
      final String address,
      final String informantUserName,
      final String createUserName,
      final String serialNumber,
      final LocalDateTime informantDateTime,
      final String projectName,
      final Integer crmCheckStatusEnum,
      final String keyProjectName,
      final String projectLevelConfigName,
      final Integer effectiveRemainingTime,
      final Integer followUpTimes,
      final Integer crmProjectScheduleTypeEnum,
      final String crmProjectScheduleTypeEnumName
   ) {
      this.id = id;
      this.regionNameList = regionNameList;
      this.estimatedWorks = estimatedWorks;
      this.estimatedCost = estimatedCost;
      this.areaOfStructure = areaOfStructure;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.address = address;
      this.informantUserName = informantUserName;
      this.createUserName = createUserName;
      this.serialNumber = serialNumber;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.keyProjectName = keyProjectName;
      this.projectLevelConfigName = projectLevelConfigName;
      this.effectiveRemainingTime = effectiveRemainingTime;
      this.followUpTimes = followUpTimes;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
   }

   public Long getId() {
      return this.id;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public BigDecimal getEstimatedWorks() {
      return this.estimatedWorks;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public String getKeyProjectName() {
      return this.keyProjectName;
   }

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public Integer getEffectiveRemainingTime() {
      return this.effectiveRemainingTime;
   }

   public Integer getFollowUpTimes() {
      return this.followUpTimes;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getCrmProjectScheduleTypeEnumName() {
      return this.crmProjectScheduleTypeEnumName;
   }

   public CrmProjectInformationWarehousingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setKeyProjectName(final String keyProjectName) {
      this.keyProjectName = keyProjectName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setEffectiveRemainingTime(final Integer effectiveRemainingTime) {
      this.effectiveRemainingTime = effectiveRemainingTime;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setFollowUpTimes(final Integer followUpTimes) {
      this.followUpTimes = followUpTimes;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      return this;
   }

   public CrmProjectInformationWarehousingDTO setCrmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousingDTO(id="
         + this.getId()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", estimatedWorks="
         + this.getEstimatedWorks()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", address="
         + this.getAddress()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", createUserName="
         + this.getCreateUserName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", projectName="
         + this.getProjectName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", keyProjectName="
         + this.getKeyProjectName()
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", effectiveRemainingTime="
         + this.getEffectiveRemainingTime()
         + ", followUpTimes="
         + this.getFollowUpTimes()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", crmProjectScheduleTypeEnumName="
         + this.getCrmProjectScheduleTypeEnumName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationWarehousingDTO)) {
         return false;
      }

      CrmProjectInformationWarehousingDTO other = (CrmProjectInformationWarehousingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
         Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
         if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
            Object this$effectiveRemainingTime = this.getEffectiveRemainingTime();
            Object other$effectiveRemainingTime = other.getEffectiveRemainingTime();
            if (this$effectiveRemainingTime == null ? other$effectiveRemainingTime == null : this$effectiveRemainingTime.equals(other$effectiveRemainingTime)) {
               Object this$followUpTimes = this.getFollowUpTimes();
               Object other$followUpTimes = other.getFollowUpTimes();
               if (this$followUpTimes == null ? other$followUpTimes == null : this$followUpTimes.equals(other$followUpTimes)) {
                  Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
                  Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
                  if (this$crmProjectScheduleTypeEnum == null
                     ? other$crmProjectScheduleTypeEnum == null
                     : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
                     Object this$regionNameList = this.getRegionNameList();
                     Object other$regionNameList = other.getRegionNameList();
                     if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
                        Object this$estimatedWorks = this.getEstimatedWorks();
                        Object other$estimatedWorks = other.getEstimatedWorks();
                        if (this$estimatedWorks == null ? other$estimatedWorks == null : this$estimatedWorks.equals(other$estimatedWorks)) {
                           Object this$estimatedCost = this.getEstimatedCost();
                           Object other$estimatedCost = other.getEstimatedCost();
                           if (this$estimatedCost == null ? other$estimatedCost == null : this$estimatedCost.equals(other$estimatedCost)) {
                              Object this$areaOfStructure = this.getAreaOfStructure();
                              Object other$areaOfStructure = other.getAreaOfStructure();
                              if (this$areaOfStructure == null ? other$areaOfStructure == null : this$areaOfStructure.equals(other$areaOfStructure)) {
                                 Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                                 Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                                 if (this$structureTypeConfigurationName == null
                                    ? other$structureTypeConfigurationName == null
                                    : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                    Object this$address = this.getAddress();
                                    Object other$address = other.getAddress();
                                    if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                       Object this$informantUserName = this.getInformantUserName();
                                       Object other$informantUserName = other.getInformantUserName();
                                       if (this$informantUserName == null
                                          ? other$informantUserName == null
                                          : this$informantUserName.equals(other$informantUserName)) {
                                          Object this$createUserName = this.getCreateUserName();
                                          Object other$createUserName = other.getCreateUserName();
                                          if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$informantDateTime = this.getInformantDateTime();
                                                Object other$informantDateTime = other.getInformantDateTime();
                                                if (this$informantDateTime == null
                                                   ? other$informantDateTime == null
                                                   : this$informantDateTime.equals(other$informantDateTime)) {
                                                   Object this$projectName = this.getProjectName();
                                                   Object other$projectName = other.getProjectName();
                                                   if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                      Object this$keyProjectName = this.getKeyProjectName();
                                                      Object other$keyProjectName = other.getKeyProjectName();
                                                      if (this$keyProjectName == null
                                                         ? other$keyProjectName == null
                                                         : this$keyProjectName.equals(other$keyProjectName)) {
                                                         Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                                                         Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                                                         if (this$projectLevelConfigName == null
                                                            ? other$projectLevelConfigName == null
                                                            : this$projectLevelConfigName.equals(other$projectLevelConfigName)) {
                                                            Object this$crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
                                                            Object other$crmProjectScheduleTypeEnumName = other.getCrmProjectScheduleTypeEnumName();
                                                            return this$crmProjectScheduleTypeEnumName == null
                                                               ? other$crmProjectScheduleTypeEnumName == null
                                                               : this$crmProjectScheduleTypeEnumName.equals(other$crmProjectScheduleTypeEnumName);
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
      return other instanceof CrmProjectInformationWarehousingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $effectiveRemainingTime = this.getEffectiveRemainingTime();
      result = result * 59 + ($effectiveRemainingTime == null ? 43 : $effectiveRemainingTime.hashCode());
      Object $followUpTimes = this.getFollowUpTimes();
      result = result * 59 + ($followUpTimes == null ? 43 : $followUpTimes.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $keyProjectName = this.getKeyProjectName();
      result = result * 59 + ($keyProjectName == null ? 43 : $keyProjectName.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
      return result * 59 + ($crmProjectScheduleTypeEnumName == null ? 43 : $crmProjectScheduleTypeEnumName.hashCode());
   }

   public static class CrmProjectInformationWarehousingDTOBuilder {
      private Long id;
      private String regionNameList;
      private BigDecimal estimatedWorks;
      private BigDecimal estimatedCost;
      private BigDecimal areaOfStructure;
      private String structureTypeConfigurationName;
      private String address;
      private String informantUserName;
      private String createUserName;
      private String serialNumber;
      private LocalDateTime informantDateTime;
      private String projectName;
      private Integer crmCheckStatusEnum;
      private String keyProjectName;
      private String projectLevelConfigName;
      private Integer effectiveRemainingTime;
      private Integer followUpTimes;
      private Integer crmProjectScheduleTypeEnum;
      private String crmProjectScheduleTypeEnumName;

      CrmProjectInformationWarehousingDTOBuilder() {
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder estimatedWorks(final BigDecimal estimatedWorks) {
         this.estimatedWorks = estimatedWorks;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder areaOfStructure(final BigDecimal areaOfStructure) {
         this.areaOfStructure = areaOfStructure;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder structureTypeConfigurationName(
         final String structureTypeConfigurationName
      ) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder keyProjectName(final String keyProjectName) {
         this.keyProjectName = keyProjectName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder projectLevelConfigName(final String projectLevelConfigName) {
         this.projectLevelConfigName = projectLevelConfigName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder effectiveRemainingTime(final Integer effectiveRemainingTime) {
         this.effectiveRemainingTime = effectiveRemainingTime;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder followUpTimes(final Integer followUpTimes) {
         this.followUpTimes = followUpTimes;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder crmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
         this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
         return this;
      }

      public CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder crmProjectScheduleTypeEnumName(
         final String crmProjectScheduleTypeEnumName
      ) {
         this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
         return this;
      }

      public CrmProjectInformationWarehousingDTO build() {
         return new CrmProjectInformationWarehousingDTO(
            this.id,
            this.regionNameList,
            this.estimatedWorks,
            this.estimatedCost,
            this.areaOfStructure,
            this.structureTypeConfigurationName,
            this.address,
            this.informantUserName,
            this.createUserName,
            this.serialNumber,
            this.informantDateTime,
            this.projectName,
            this.crmCheckStatusEnum,
            this.keyProjectName,
            this.projectLevelConfigName,
            this.effectiveRemainingTime,
            this.followUpTimes,
            this.crmProjectScheduleTypeEnum,
            this.crmProjectScheduleTypeEnumName
         );
      }

      @Override
      public String toString() {
         return "CrmProjectInformationWarehousingDTO.CrmProjectInformationWarehousingDTOBuilder(id="
            + this.id
            + ", regionNameList="
            + this.regionNameList
            + ", estimatedWorks="
            + this.estimatedWorks
            + ", estimatedCost="
            + this.estimatedCost
            + ", areaOfStructure="
            + this.areaOfStructure
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", address="
            + this.address
            + ", informantUserName="
            + this.informantUserName
            + ", createUserName="
            + this.createUserName
            + ", serialNumber="
            + this.serialNumber
            + ", informantDateTime="
            + this.informantDateTime
            + ", projectName="
            + this.projectName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", keyProjectName="
            + this.keyProjectName
            + ", projectLevelConfigName="
            + this.projectLevelConfigName
            + ", effectiveRemainingTime="
            + this.effectiveRemainingTime
            + ", followUpTimes="
            + this.followUpTimes
            + ", crmProjectScheduleTypeEnum="
            + this.crmProjectScheduleTypeEnum
            + ", crmProjectScheduleTypeEnumName="
            + this.crmProjectScheduleTypeEnumName
            + ")";
      }
   }
}
