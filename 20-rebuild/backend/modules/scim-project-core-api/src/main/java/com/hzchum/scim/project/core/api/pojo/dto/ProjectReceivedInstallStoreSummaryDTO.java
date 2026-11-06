package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("收安存汇总返回类")
public class ProjectReceivedInstallStoreSummaryDTO {
   @ApiModelProperty(name = "date", value = "月份", notes = "月份")
   private String date;
   @ApiModelProperty(name = "unit", value = "单位", notes = "单位")
   private String unit;
   @ApiModelProperty(name = "initMete", value = "期初库存", notes = "期初库存")
   private BigDecimal initMete;
   @ApiModelProperty(name = "initMete", value = "期初库存", notes = "期初库存")
   private BigDecimal receivedMete;
   @ApiModelProperty(name = "initMete", value = "期初库存", notes = "期初库存")
   private BigDecimal installMete;
   @ApiModelProperty(name = "initMete", value = "期初库存", notes = "期初库存")
   private BigDecimal endMete;

   public static ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder builder() {
      return new ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder();
   }

   public ProjectReceivedInstallStoreSummaryDTO() {
   }

   public ProjectReceivedInstallStoreSummaryDTO(
      final String date, final String unit, final BigDecimal initMete, final BigDecimal receivedMete, final BigDecimal installMete, final BigDecimal endMete
   ) {
      this.date = date;
      this.unit = unit;
      this.initMete = initMete;
      this.receivedMete = receivedMete;
      this.installMete = installMete;
      this.endMete = endMete;
   }

   public String getDate() {
      return this.date;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getInitMete() {
      return this.initMete;
   }

   public BigDecimal getReceivedMete() {
      return this.receivedMete;
   }

   public BigDecimal getInstallMete() {
      return this.installMete;
   }

   public BigDecimal getEndMete() {
      return this.endMete;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setInitMete(final BigDecimal initMete) {
      this.initMete = initMete;
   }

   public void setReceivedMete(final BigDecimal receivedMete) {
      this.receivedMete = receivedMete;
   }

   public void setInstallMete(final BigDecimal installMete) {
      this.installMete = installMete;
   }

   public void setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedInstallStoreSummaryDTO)) {
         return false;
      }

      ProjectReceivedInstallStoreSummaryDTO other = (ProjectReceivedInstallStoreSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$unit = this.getUnit();
         Object other$unit = other.getUnit();
         if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
            Object this$initMete = this.getInitMete();
            Object other$initMete = other.getInitMete();
            if (this$initMete == null ? other$initMete == null : this$initMete.equals(other$initMete)) {
               Object this$receivedMete = this.getReceivedMete();
               Object other$receivedMete = other.getReceivedMete();
               if (this$receivedMete == null ? other$receivedMete == null : this$receivedMete.equals(other$receivedMete)) {
                  Object this$installMete = this.getInstallMete();
                  Object other$installMete = other.getInstallMete();
                  if (this$installMete == null ? other$installMete == null : this$installMete.equals(other$installMete)) {
                     Object this$endMete = this.getEndMete();
                     Object other$endMete = other.getEndMete();
                     return this$endMete == null ? other$endMete == null : this$endMete.equals(other$endMete);
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
      return other instanceof ProjectReceivedInstallStoreSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $initMete = this.getInitMete();
      result = result * 59 + ($initMete == null ? 43 : $initMete.hashCode());
      Object $receivedMete = this.getReceivedMete();
      result = result * 59 + ($receivedMete == null ? 43 : $receivedMete.hashCode());
      Object $installMete = this.getInstallMete();
      result = result * 59 + ($installMete == null ? 43 : $installMete.hashCode());
      Object $endMete = this.getEndMete();
      return result * 59 + ($endMete == null ? 43 : $endMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedInstallStoreSummaryDTO(date="
         + this.getDate()
         + ", unit="
         + this.getUnit()
         + ", initMete="
         + this.getInitMete()
         + ", receivedMete="
         + this.getReceivedMete()
         + ", installMete="
         + this.getInstallMete()
         + ", endMete="
         + this.getEndMete()
         + ")";
   }

   public static class ProjectReceivedInstallStoreSummaryDTOBuilder {
      private String date;
      private String unit;
      private BigDecimal initMete;
      private BigDecimal receivedMete;
      private BigDecimal installMete;
      private BigDecimal endMete;

      ProjectReceivedInstallStoreSummaryDTOBuilder() {
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder initMete(final BigDecimal initMete) {
         this.initMete = initMete;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder receivedMete(final BigDecimal receivedMete) {
         this.receivedMete = receivedMete;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder installMete(final BigDecimal installMete) {
         this.installMete = installMete;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      public ProjectReceivedInstallStoreSummaryDTO build() {
         return new ProjectReceivedInstallStoreSummaryDTO(this.date, this.unit, this.initMete, this.receivedMete, this.installMete, this.endMete);
      }

      @Override
      public String toString() {
         return "ProjectReceivedInstallStoreSummaryDTO.ProjectReceivedInstallStoreSummaryDTOBuilder(date="
            + this.date
            + ", unit="
            + this.unit
            + ", initMete="
            + this.initMete
            + ", receivedMete="
            + this.receivedMete
            + ", installMete="
            + this.installMete
            + ", endMete="
            + this.endMete
            + ")";
      }
   }
}
