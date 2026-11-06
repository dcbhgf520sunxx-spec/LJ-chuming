package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("收货/安装量")
public class ProjectReceivedInstallStoreMeteDTO {
   @ApiModelProperty(name = "date", value = "月份", notes = "月份")
   private String date;
   @ApiModelProperty(name = "mete", value = "收安量", notes = "收安量")
   private BigDecimal mete;

   public static ProjectReceivedInstallStoreMeteDTO.ProjectReceivedInstallStoreMeteDTOBuilder builder() {
      return new ProjectReceivedInstallStoreMeteDTO.ProjectReceivedInstallStoreMeteDTOBuilder();
   }

   public ProjectReceivedInstallStoreMeteDTO() {
   }

   public ProjectReceivedInstallStoreMeteDTO(final String date, final BigDecimal mete) {
      this.date = date;
      this.mete = mete;
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectReceivedInstallStoreMeteDTO)) {
         return false;
      } else {
         ProjectReceivedInstallStoreMeteDTO other = (ProjectReceivedInstallStoreMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivedInstallStoreMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedInstallStoreMeteDTO(date=" + this.getDate() + ", mete=" + this.getMete() + ")";
   }

   public static class ProjectReceivedInstallStoreMeteDTOBuilder {
      private String date;
      private BigDecimal mete;

      ProjectReceivedInstallStoreMeteDTOBuilder() {
      }

      public ProjectReceivedInstallStoreMeteDTO.ProjectReceivedInstallStoreMeteDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public ProjectReceivedInstallStoreMeteDTO.ProjectReceivedInstallStoreMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectReceivedInstallStoreMeteDTO build() {
         return new ProjectReceivedInstallStoreMeteDTO(this.date, this.mete);
      }

      @Override
      public String toString() {
         return "ProjectReceivedInstallStoreMeteDTO.ProjectReceivedInstallStoreMeteDTOBuilder(date=" + this.date + ", mete=" + this.mete + ")";
      }
   }
}
