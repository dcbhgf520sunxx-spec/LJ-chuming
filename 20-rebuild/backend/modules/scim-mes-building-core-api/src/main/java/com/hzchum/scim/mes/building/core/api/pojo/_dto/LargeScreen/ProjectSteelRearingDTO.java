package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目分析数据")
public class ProjectSteelRearingDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Integer projectId;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "schedulingWeight", value = "排产量")
   private BigDecimal schedulingWeight;
   @ApiModelProperty(name = "schedulingWeight", value = "累计领料")
   private BigDecimal cumulativePicking;
   @ApiModelProperty(name = "pickedLastMonth", value = "上月领料")
   private BigDecimal pickedLastMonth;
   @ApiModelProperty(name = "pickThisMonth", value = "本月领料")
   private BigDecimal pickThisMonth;

   public static ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder builder() {
      return new ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder();
   }

   public Integer getProjectId() {
      return this.projectId;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public BigDecimal getCumulativePicking() {
      return this.cumulativePicking;
   }

   public BigDecimal getPickedLastMonth() {
      return this.pickedLastMonth;
   }

   public BigDecimal getPickThisMonth() {
      return this.pickThisMonth;
   }

   public void setProjectId(final Integer projectId) {
      this.projectId = projectId;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
   }

   public void setCumulativePicking(final BigDecimal cumulativePicking) {
      this.cumulativePicking = cumulativePicking;
   }

   public void setPickedLastMonth(final BigDecimal pickedLastMonth) {
      this.pickedLastMonth = pickedLastMonth;
   }

   public void setPickThisMonth(final BigDecimal pickThisMonth) {
      this.pickThisMonth = pickThisMonth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSteelRearingDTO)) {
         return false;
      }

      ProjectSteelRearingDTO other = (ProjectSteelRearingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$shortName = this.getShortName();
         Object other$shortName = other.getShortName();
         if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$schedulingWeight = this.getSchedulingWeight();
               Object other$schedulingWeight = other.getSchedulingWeight();
               if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
                  Object this$cumulativePicking = this.getCumulativePicking();
                  Object other$cumulativePicking = other.getCumulativePicking();
                  if (this$cumulativePicking == null ? other$cumulativePicking == null : this$cumulativePicking.equals(other$cumulativePicking)) {
                     Object this$pickedLastMonth = this.getPickedLastMonth();
                     Object other$pickedLastMonth = other.getPickedLastMonth();
                     if (this$pickedLastMonth == null ? other$pickedLastMonth == null : this$pickedLastMonth.equals(other$pickedLastMonth)) {
                        Object this$pickThisMonth = this.getPickThisMonth();
                        Object other$pickThisMonth = other.getPickThisMonth();
                        return this$pickThisMonth == null ? other$pickThisMonth == null : this$pickThisMonth.equals(other$pickThisMonth);
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
      return other instanceof ProjectSteelRearingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $cumulativePicking = this.getCumulativePicking();
      result = result * 59 + ($cumulativePicking == null ? 43 : $cumulativePicking.hashCode());
      Object $pickedLastMonth = this.getPickedLastMonth();
      result = result * 59 + ($pickedLastMonth == null ? 43 : $pickedLastMonth.hashCode());
      Object $pickThisMonth = this.getPickThisMonth();
      return result * 59 + ($pickThisMonth == null ? 43 : $pickThisMonth.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSteelRearingDTO(super="
         + super.toString()
         + ", projectId="
         + this.getProjectId()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", cumulativePicking="
         + this.getCumulativePicking()
         + ", pickedLastMonth="
         + this.getPickedLastMonth()
         + ", pickThisMonth="
         + this.getPickThisMonth()
         + ")";
   }

   public ProjectSteelRearingDTO(
      final Integer projectId,
      final String shortName,
      final String serialNumber,
      final BigDecimal schedulingWeight,
      final BigDecimal cumulativePicking,
      final BigDecimal pickedLastMonth,
      final BigDecimal pickThisMonth
   ) {
      this.projectId = projectId;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.schedulingWeight = schedulingWeight;
      this.cumulativePicking = cumulativePicking;
      this.pickedLastMonth = pickedLastMonth;
      this.pickThisMonth = pickThisMonth;
   }

   public ProjectSteelRearingDTO() {
   }

   public static class ProjectSteelRearingDTOBuilder {
      private Integer projectId;
      private String shortName;
      private String serialNumber;
      private BigDecimal schedulingWeight;
      private BigDecimal cumulativePicking;
      private BigDecimal pickedLastMonth;
      private BigDecimal pickThisMonth;

      ProjectSteelRearingDTOBuilder() {
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder projectId(final Integer projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder schedulingWeight(final BigDecimal schedulingWeight) {
         this.schedulingWeight = schedulingWeight;
         return this;
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder cumulativePicking(final BigDecimal cumulativePicking) {
         this.cumulativePicking = cumulativePicking;
         return this;
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder pickedLastMonth(final BigDecimal pickedLastMonth) {
         this.pickedLastMonth = pickedLastMonth;
         return this;
      }

      public ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder pickThisMonth(final BigDecimal pickThisMonth) {
         this.pickThisMonth = pickThisMonth;
         return this;
      }

      public ProjectSteelRearingDTO build() {
         return new ProjectSteelRearingDTO(
            this.projectId, this.shortName, this.serialNumber, this.schedulingWeight, this.cumulativePicking, this.pickedLastMonth, this.pickThisMonth
         );
      }

      @Override
      public String toString() {
         return "ProjectSteelRearingDTO.ProjectSteelRearingDTOBuilder(projectId="
            + this.projectId
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", schedulingWeight="
            + this.schedulingWeight
            + ", cumulativePicking="
            + this.cumulativePicking
            + ", pickedLastMonth="
            + this.pickedLastMonth
            + ", pickThisMonth="
            + this.pickThisMonth
            + ")";
      }
   }
}
