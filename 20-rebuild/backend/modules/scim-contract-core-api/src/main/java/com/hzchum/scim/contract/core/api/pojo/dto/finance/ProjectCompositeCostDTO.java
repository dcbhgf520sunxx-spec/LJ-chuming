package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目综合成本类")
public class ProjectCompositeCostDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("主材费")
   private BigDecimal mainMaterialFee;
   @ApiModelProperty("劳务费")
   private BigDecimal laborFee;
   @ApiModelProperty("辅材费")
   private BigDecimal auxiliaryMaterialFee;
   @ApiModelProperty("水电气费")
   private BigDecimal waterElectricityGasFee;
   @ApiModelProperty("折旧费")
   private BigDecimal depreciationFee;
   @ApiModelProperty("管理费")
   private BigDecimal managementFee;
   @ApiModelProperty("运输费")
   private BigDecimal transportationFee;
   @ApiModelProperty("检测费")
   private BigDecimal testingFee;
   @ApiModelProperty("分包费")
   private BigDecimal subFee;

   public static ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder builder() {
      return new ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder();
   }

   public ProjectCompositeCostDTO() {
   }

   public ProjectCompositeCostDTO(
      final Long projectId,
      final BigDecimal mainMaterialFee,
      final BigDecimal laborFee,
      final BigDecimal auxiliaryMaterialFee,
      final BigDecimal waterElectricityGasFee,
      final BigDecimal depreciationFee,
      final BigDecimal managementFee,
      final BigDecimal transportationFee,
      final BigDecimal testingFee,
      final BigDecimal subFee
   ) {
      this.projectId = projectId;
      this.mainMaterialFee = mainMaterialFee;
      this.laborFee = laborFee;
      this.auxiliaryMaterialFee = auxiliaryMaterialFee;
      this.waterElectricityGasFee = waterElectricityGasFee;
      this.depreciationFee = depreciationFee;
      this.managementFee = managementFee;
      this.transportationFee = transportationFee;
      this.testingFee = testingFee;
      this.subFee = subFee;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMainMaterialFee() {
      return this.mainMaterialFee;
   }

   public BigDecimal getLaborFee() {
      return this.laborFee;
   }

   public BigDecimal getAuxiliaryMaterialFee() {
      return this.auxiliaryMaterialFee;
   }

   public BigDecimal getWaterElectricityGasFee() {
      return this.waterElectricityGasFee;
   }

   public BigDecimal getDepreciationFee() {
      return this.depreciationFee;
   }

   public BigDecimal getManagementFee() {
      return this.managementFee;
   }

   public BigDecimal getTransportationFee() {
      return this.transportationFee;
   }

   public BigDecimal getTestingFee() {
      return this.testingFee;
   }

   public BigDecimal getSubFee() {
      return this.subFee;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMainMaterialFee(final BigDecimal mainMaterialFee) {
      this.mainMaterialFee = mainMaterialFee;
   }

   public void setLaborFee(final BigDecimal laborFee) {
      this.laborFee = laborFee;
   }

   public void setAuxiliaryMaterialFee(final BigDecimal auxiliaryMaterialFee) {
      this.auxiliaryMaterialFee = auxiliaryMaterialFee;
   }

   public void setWaterElectricityGasFee(final BigDecimal waterElectricityGasFee) {
      this.waterElectricityGasFee = waterElectricityGasFee;
   }

   public void setDepreciationFee(final BigDecimal depreciationFee) {
      this.depreciationFee = depreciationFee;
   }

   public void setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
   }

   public void setTransportationFee(final BigDecimal transportationFee) {
      this.transportationFee = transportationFee;
   }

   public void setTestingFee(final BigDecimal testingFee) {
      this.testingFee = testingFee;
   }

   public void setSubFee(final BigDecimal subFee) {
      this.subFee = subFee;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCompositeCostDTO)) {
         return false;
      }

      ProjectCompositeCostDTO other = (ProjectCompositeCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$mainMaterialFee = this.getMainMaterialFee();
         Object other$mainMaterialFee = other.getMainMaterialFee();
         if (this$mainMaterialFee == null ? other$mainMaterialFee == null : this$mainMaterialFee.equals(other$mainMaterialFee)) {
            Object this$laborFee = this.getLaborFee();
            Object other$laborFee = other.getLaborFee();
            if (this$laborFee == null ? other$laborFee == null : this$laborFee.equals(other$laborFee)) {
               Object this$auxiliaryMaterialFee = this.getAuxiliaryMaterialFee();
               Object other$auxiliaryMaterialFee = other.getAuxiliaryMaterialFee();
               if (this$auxiliaryMaterialFee == null ? other$auxiliaryMaterialFee == null : this$auxiliaryMaterialFee.equals(other$auxiliaryMaterialFee)) {
                  Object this$waterElectricityGasFee = this.getWaterElectricityGasFee();
                  Object other$waterElectricityGasFee = other.getWaterElectricityGasFee();
                  if (this$waterElectricityGasFee == null
                     ? other$waterElectricityGasFee == null
                     : this$waterElectricityGasFee.equals(other$waterElectricityGasFee)) {
                     Object this$depreciationFee = this.getDepreciationFee();
                     Object other$depreciationFee = other.getDepreciationFee();
                     if (this$depreciationFee == null ? other$depreciationFee == null : this$depreciationFee.equals(other$depreciationFee)) {
                        Object this$managementFee = this.getManagementFee();
                        Object other$managementFee = other.getManagementFee();
                        if (this$managementFee == null ? other$managementFee == null : this$managementFee.equals(other$managementFee)) {
                           Object this$transportationFee = this.getTransportationFee();
                           Object other$transportationFee = other.getTransportationFee();
                           if (this$transportationFee == null ? other$transportationFee == null : this$transportationFee.equals(other$transportationFee)) {
                              Object this$testingFee = this.getTestingFee();
                              Object other$testingFee = other.getTestingFee();
                              if (this$testingFee == null ? other$testingFee == null : this$testingFee.equals(other$testingFee)) {
                                 Object this$subFee = this.getSubFee();
                                 Object other$subFee = other.getSubFee();
                                 return this$subFee == null ? other$subFee == null : this$subFee.equals(other$subFee);
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
      return other instanceof ProjectCompositeCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mainMaterialFee = this.getMainMaterialFee();
      result = result * 59 + ($mainMaterialFee == null ? 43 : $mainMaterialFee.hashCode());
      Object $laborFee = this.getLaborFee();
      result = result * 59 + ($laborFee == null ? 43 : $laborFee.hashCode());
      Object $auxiliaryMaterialFee = this.getAuxiliaryMaterialFee();
      result = result * 59 + ($auxiliaryMaterialFee == null ? 43 : $auxiliaryMaterialFee.hashCode());
      Object $waterElectricityGasFee = this.getWaterElectricityGasFee();
      result = result * 59 + ($waterElectricityGasFee == null ? 43 : $waterElectricityGasFee.hashCode());
      Object $depreciationFee = this.getDepreciationFee();
      result = result * 59 + ($depreciationFee == null ? 43 : $depreciationFee.hashCode());
      Object $managementFee = this.getManagementFee();
      result = result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
      Object $transportationFee = this.getTransportationFee();
      result = result * 59 + ($transportationFee == null ? 43 : $transportationFee.hashCode());
      Object $testingFee = this.getTestingFee();
      result = result * 59 + ($testingFee == null ? 43 : $testingFee.hashCode());
      Object $subFee = this.getSubFee();
      return result * 59 + ($subFee == null ? 43 : $subFee.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCompositeCostDTO(projectId="
         + this.getProjectId()
         + ", mainMaterialFee="
         + this.getMainMaterialFee()
         + ", laborFee="
         + this.getLaborFee()
         + ", auxiliaryMaterialFee="
         + this.getAuxiliaryMaterialFee()
         + ", waterElectricityGasFee="
         + this.getWaterElectricityGasFee()
         + ", depreciationFee="
         + this.getDepreciationFee()
         + ", managementFee="
         + this.getManagementFee()
         + ", transportationFee="
         + this.getTransportationFee()
         + ", testingFee="
         + this.getTestingFee()
         + ", subFee="
         + this.getSubFee()
         + ")";
   }

   public static class ProjectCompositeCostDTOBuilder {
      private Long projectId;
      private BigDecimal mainMaterialFee;
      private BigDecimal laborFee;
      private BigDecimal auxiliaryMaterialFee;
      private BigDecimal waterElectricityGasFee;
      private BigDecimal depreciationFee;
      private BigDecimal managementFee;
      private BigDecimal transportationFee;
      private BigDecimal testingFee;
      private BigDecimal subFee;

      ProjectCompositeCostDTOBuilder() {
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder mainMaterialFee(final BigDecimal mainMaterialFee) {
         this.mainMaterialFee = mainMaterialFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder laborFee(final BigDecimal laborFee) {
         this.laborFee = laborFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder auxiliaryMaterialFee(final BigDecimal auxiliaryMaterialFee) {
         this.auxiliaryMaterialFee = auxiliaryMaterialFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder waterElectricityGasFee(final BigDecimal waterElectricityGasFee) {
         this.waterElectricityGasFee = waterElectricityGasFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder depreciationFee(final BigDecimal depreciationFee) {
         this.depreciationFee = depreciationFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder transportationFee(final BigDecimal transportationFee) {
         this.transportationFee = transportationFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder testingFee(final BigDecimal testingFee) {
         this.testingFee = testingFee;
         return this;
      }

      public ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder subFee(final BigDecimal subFee) {
         this.subFee = subFee;
         return this;
      }

      public ProjectCompositeCostDTO build() {
         return new ProjectCompositeCostDTO(
            this.projectId,
            this.mainMaterialFee,
            this.laborFee,
            this.auxiliaryMaterialFee,
            this.waterElectricityGasFee,
            this.depreciationFee,
            this.managementFee,
            this.transportationFee,
            this.testingFee,
            this.subFee
         );
      }

      @Override
      public String toString() {
         return "ProjectCompositeCostDTO.ProjectCompositeCostDTOBuilder(projectId="
            + this.projectId
            + ", mainMaterialFee="
            + this.mainMaterialFee
            + ", laborFee="
            + this.laborFee
            + ", auxiliaryMaterialFee="
            + this.auxiliaryMaterialFee
            + ", waterElectricityGasFee="
            + this.waterElectricityGasFee
            + ", depreciationFee="
            + this.depreciationFee
            + ", managementFee="
            + this.managementFee
            + ", transportationFee="
            + this.transportationFee
            + ", testingFee="
            + this.testingFee
            + ", subFee="
            + this.subFee
            + ")";
      }
   }
}
