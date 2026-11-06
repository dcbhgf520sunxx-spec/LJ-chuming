package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectSafetyProblemReportDataDTO", description = "治安报表头部源数据")
public class ProjectSafetyProblemReportDataDTO {
   @ApiModelProperty(name = "部门id", value = "部门id")
   private Long id;
   @ApiModelProperty(name = "部门名字")
   private String name;
   @ApiModelProperty(name = "qualityProblemTotal", notes = "质量问题总数")
   private Integer qualityProblemTotal;
   @ApiModelProperty(name = "safetyProblemTotal", notes = "安全问题总数")
   private Integer safetyProblemTotal;

   public static ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder builder() {
      return new ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder();
   }

   public ProjectSafetyProblemReportDataDTO() {
   }

   public ProjectSafetyProblemReportDataDTO(final Long id, final String name, final Integer qualityProblemTotal, final Integer safetyProblemTotal) {
      this.id = id;
      this.name = name;
      this.qualityProblemTotal = qualityProblemTotal;
      this.safetyProblemTotal = safetyProblemTotal;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQualityProblemTotal() {
      return this.qualityProblemTotal;
   }

   public Integer getSafetyProblemTotal() {
      return this.safetyProblemTotal;
   }

   public ProjectSafetyProblemReportDataDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectSafetyProblemReportDataDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectSafetyProblemReportDataDTO setQualityProblemTotal(final Integer qualityProblemTotal) {
      this.qualityProblemTotal = qualityProblemTotal;
      return this;
   }

   public ProjectSafetyProblemReportDataDTO setSafetyProblemTotal(final Integer safetyProblemTotal) {
      this.safetyProblemTotal = safetyProblemTotal;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemReportDataDTO)) {
         return false;
      }

      ProjectSafetyProblemReportDataDTO other = (ProjectSafetyProblemReportDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qualityProblemTotal = this.getQualityProblemTotal();
         Object other$qualityProblemTotal = other.getQualityProblemTotal();
         if (this$qualityProblemTotal == null ? other$qualityProblemTotal == null : this$qualityProblemTotal.equals(other$qualityProblemTotal)) {
            Object this$safetyProblemTotal = this.getSafetyProblemTotal();
            Object other$safetyProblemTotal = other.getSafetyProblemTotal();
            if (this$safetyProblemTotal == null ? other$safetyProblemTotal == null : this$safetyProblemTotal.equals(other$safetyProblemTotal)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProjectSafetyProblemReportDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qualityProblemTotal = this.getQualityProblemTotal();
      result = result * 59 + ($qualityProblemTotal == null ? 43 : $qualityProblemTotal.hashCode());
      Object $safetyProblemTotal = this.getSafetyProblemTotal();
      result = result * 59 + ($safetyProblemTotal == null ? 43 : $safetyProblemTotal.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemReportDataDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", qualityProblemTotal="
         + this.getQualityProblemTotal()
         + ", safetyProblemTotal="
         + this.getSafetyProblemTotal()
         + ")";
   }

   public static class ProjectSafetyProblemReportDataDTOBuilder {
      private Long id;
      private String name;
      private Integer qualityProblemTotal;
      private Integer safetyProblemTotal;

      ProjectSafetyProblemReportDataDTOBuilder() {
      }

      public ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder qualityProblemTotal(final Integer qualityProblemTotal) {
         this.qualityProblemTotal = qualityProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder safetyProblemTotal(final Integer safetyProblemTotal) {
         this.safetyProblemTotal = safetyProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportDataDTO build() {
         return new ProjectSafetyProblemReportDataDTO(this.id, this.name, this.qualityProblemTotal, this.safetyProblemTotal);
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemReportDataDTO.ProjectSafetyProblemReportDataDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", qualityProblemTotal="
            + this.qualityProblemTotal
            + ", safetyProblemTotal="
            + this.safetyProblemTotal
            + ")";
      }
   }
}
