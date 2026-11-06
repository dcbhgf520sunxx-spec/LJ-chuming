package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("分包app-安装报表类")
public class ProjectInstallStatementDTO {
   @ApiModelProperty("日期")
   private Integer date;
   @ApiModelProperty("项目类型 1建钢项目 2桥梁项目")
   Integer projectType;
   @ApiModelProperty("产品类型")
   Integer productType;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)", notes = "实际量(重量kg/长度mm)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际总面积(m2)", notes = "实际总面积(m2)")
   private BigDecimal actualTotalArea;

   public static ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder builder() {
      return new ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder();
   }

   public ProjectInstallStatementDTO() {
   }

   public ProjectInstallStatementDTO(
      final Integer date,
      final Integer projectType,
      final Integer productType,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea
   ) {
      this.date = date;
      this.projectType = projectType;
      this.productType = productType;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
   }

   public Integer getDate() {
      return this.date;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public void setDate(final Integer date) {
      this.date = date;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setActualQuantity(final Integer actualQuantity) {
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

      if (!(o instanceof ProjectInstallStatementDTO)) {
         return false;
      }

      ProjectInstallStatementDTO other = (ProjectInstallStatementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
      return other instanceof ProjectInstallStatementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      return result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallStatementDTO(date="
         + this.getDate()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ")";
   }

   public static class ProjectInstallStatementDTOBuilder {
      private Integer date;
      private Integer projectType;
      private Integer productType;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;

      ProjectInstallStatementDTOBuilder() {
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder date(final Integer date) {
         this.date = date;
         return this;
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallStatementDTO build() {
         return new ProjectInstallStatementDTO(this.date, this.projectType, this.productType, this.actualQuantity, this.actualMete, this.actualTotalArea);
      }

      @Override
      public String toString() {
         return "ProjectInstallStatementDTO.ProjectInstallStatementDTOBuilder(date="
            + this.date
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ")";
      }
   }
}
