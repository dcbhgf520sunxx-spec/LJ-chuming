package com.hzchum.scim.crm.core.api.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CrmTechEntrustListDTO {
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案Name", notes = "企业备案Name")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "regionNames", value = "区域名称", notes = "区域名称")
   private String regionNames;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型Name", notes = "结构类型Name")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "projectLevelConfigId", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "crmSubmissionStatusEnum", value = "提报状态", notes = "提报状态")
   private Integer crmSubmissionStatusEnum;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "(直营非直营)", notes = "(直营非直营)")
   private Integer crmSettlementBusinessTypeEnum;

   public CrmTechEntrustListDTO() {
   }

   public CrmTechEntrustListDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String serialNumber,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final String regionNames,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String projectLevelConfigName,
      final String departmentName,
      final String informantUserName,
      final Integer crmSubmissionStatusEnum,
      final Integer crmSettlementBusinessTypeEnum
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.regionNames = regionNames;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.projectLevelConfigName = projectLevelConfigName;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
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

   public String getRegionNames() {
      return this.regionNames;
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

   public Integer getCrmSubmissionStatusEnum() {
      return this.crmSubmissionStatusEnum;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
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

   public void setRegionNames(final String regionNames) {
      this.regionNames = regionNames;
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

   public void setCrmSubmissionStatusEnum(final Integer crmSubmissionStatusEnum) {
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
   }

   public void setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTechEntrustListDTO)) {
         return false;
      }

      CrmTechEntrustListDTO other = (CrmTechEntrustListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
         Object other$crmSubmissionStatusEnum = other.getCrmSubmissionStatusEnum();
         if (this$crmSubmissionStatusEnum == null ? other$crmSubmissionStatusEnum == null : this$crmSubmissionStatusEnum.equals(other$crmSubmissionStatusEnum)) {
            Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
            Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
            if (this$crmSettlementBusinessTypeEnum == null
               ? other$crmSettlementBusinessTypeEnum == null
               : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
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
                           Object this$regionNames = this.getRegionNames();
                           Object other$regionNames = other.getRegionNames();
                           if (this$regionNames == null ? other$regionNames == null : this$regionNames.equals(other$regionNames)) {
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
                                       if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                          Object this$informantUserName = this.getInformantUserName();
                                          Object other$informantUserName = other.getInformantUserName();
                                          return this$informantUserName == null
                                             ? other$informantUserName == null
                                             : this$informantUserName.equals(other$informantUserName);
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
      return other instanceof CrmTechEntrustListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
      result = result * 59 + ($crmSubmissionStatusEnum == null ? 43 : $crmSubmissionStatusEnum.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $regionNames = this.getRegionNames();
      result = result * 59 + ($regionNames == null ? 43 : $regionNames.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      return result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmTechEntrustListDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", regionNames="
         + this.getRegionNames()
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
         + ", crmSubmissionStatusEnum="
         + this.getCrmSubmissionStatusEnum()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ")";
   }
}
