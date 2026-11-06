package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("安装量类")
public class ProjectInstallMeteSummaryDTO {
   @ApiModelProperty(name = "actualQuantity", value = "实际安装数量")
   private BigDecimal actualQuantity = BigDecimal.ZERO;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)")
   private BigDecimal actualMete = BigDecimal.ZERO;
   @ApiModelProperty(name = "actualTotalArea", value = "实际总面积(m2)")
   private BigDecimal actualTotalArea = BigDecimal.ZERO;

   public static ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder builder() {
      return new ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder();
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public void setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallMeteSummaryDTO)) {
         return false;
      }

      ProjectInstallMeteSummaryDTO other = (ProjectInstallMeteSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$actualQuantity = this.getActualQuantity();
      Object other$actualQuantity = other.getActualQuantity();
      if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
         Object this$actualMete = this.getActualMete();
         Object other$actualMete = other.getActualMete();
         if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
            Object this$actualTotalArea = this.getActualTotalArea();
            Object other$actualTotalArea = other.getActualTotalArea();
            return this$actualTotalArea == null ? other$actualTotalArea == null : this$actualTotalArea.equals(other$actualTotalArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallMeteSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      return result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallMeteSummaryDTO(actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ")";
   }

   public ProjectInstallMeteSummaryDTO(final BigDecimal actualQuantity, final BigDecimal actualMete, final BigDecimal actualTotalArea) {
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
   }

   public ProjectInstallMeteSummaryDTO() {
   }

   public static class ProjectInstallMeteSummaryDTOBuilder {
      private BigDecimal actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;

      ProjectInstallMeteSummaryDTOBuilder() {
      }

      public ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder actualQuantity(final BigDecimal actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallMeteSummaryDTO build() {
         return new ProjectInstallMeteSummaryDTO(this.actualQuantity, this.actualMete, this.actualTotalArea);
      }

      @Override
      public String toString() {
         return "ProjectInstallMeteSummaryDTO.ProjectInstallMeteSummaryDTOBuilder(actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ")";
      }
   }
}
