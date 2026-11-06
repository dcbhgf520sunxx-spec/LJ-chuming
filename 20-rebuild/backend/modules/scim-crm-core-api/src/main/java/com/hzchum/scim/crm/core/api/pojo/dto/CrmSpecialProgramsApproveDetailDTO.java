package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmSpecialProgramsApproveDetailDTO {
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
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
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "结算业务类型(直营非直营)", notes = "结算业务类型(直营非直营)")
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", value = "专项提报类型", notes = "专项提报类型")
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "businessEssentials", value = "业务要点", notes = "业务要点")
   private String businessEssentials;

   public CrmSpecialProgramsApproveDetailDTO(
      final Long id,
      final String serialNumber,
      final LocalDateTime informantDateTime,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final String regionNames,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String departmentName,
      final String informantUserName,
      final Integer crmSettlementBusinessTypeEnum,
      final Integer crmSpecialBubmissionStatusEnum,
      final String businessEssentials
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.regionNames = regionNames;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.businessEssentials = businessEssentials;
   }

   public CrmSpecialProgramsApproveDetailDTO() {
   }

   public Long getId() {
      return this.id;
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

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public String getBusinessEssentials() {
      return this.businessEssentials;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
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

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
   }

   public void setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
   }

   public void setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
   }

   public void setBusinessEssentials(final String businessEssentials) {
      this.businessEssentials = businessEssentials;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSpecialProgramsApproveDetailDTO)) {
         return false;
      }

      CrmSpecialProgramsApproveDetailDTO other = (CrmSpecialProgramsApproveDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
         Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
         if (this$crmSettlementBusinessTypeEnum == null
            ? other$crmSettlementBusinessTypeEnum == null
            : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
            Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
            Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
            if (this$crmSpecialBubmissionStatusEnum == null
               ? other$crmSpecialBubmissionStatusEnum == null
               : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$informantDateTime = this.getInformantDateTime();
                  Object other$informantDateTime = other.getInformantDateTime();
                  if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
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
                                    Object this$departmentName = this.getDepartmentName();
                                    Object other$departmentName = other.getDepartmentName();
                                    if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                       Object this$informantUserName = this.getInformantUserName();
                                       Object other$informantUserName = other.getInformantUserName();
                                       if (this$informantUserName == null
                                          ? other$informantUserName == null
                                          : this$informantUserName.equals(other$informantUserName)) {
                                          Object this$businessEssentials = this.getBusinessEssentials();
                                          Object other$businessEssentials = other.getBusinessEssentials();
                                          return this$businessEssentials == null
                                             ? other$businessEssentials == null
                                             : this$businessEssentials.equals(other$businessEssentials);
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
      return other instanceof CrmSpecialProgramsApproveDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
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
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $businessEssentials = this.getBusinessEssentials();
      return result * 59 + ($businessEssentials == null ? 43 : $businessEssentials.hashCode());
   }

   @Override
   public String toString() {
      return "CrmSpecialProgramsApproveDetailDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantDateTime="
         + this.getInformantDateTime()
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
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", businessEssentials="
         + this.getBusinessEssentials()
         + ")";
   }
}
