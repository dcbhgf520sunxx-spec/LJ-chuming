package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectSafetyProblemReportHeaderDTO", description = "治安报表头部展示")
public class ProjectSafetyProblemReportHeadDTO {
   @ApiModelProperty(name = "allQualityProblemTotal", notes = "累计质量问题总数")
   private Integer allQualityProblemTotal;
   @ApiModelProperty(name = "allSafetyProblemTotal", notes = "累计安全问题总数")
   private Integer allSafetyProblemTotal;
   @ApiModelProperty(name = "数据", notes = "数据")
   private List<ProjectSafetyProblemReportDataDTO> reportDataDTOList;

   public static ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder builder() {
      return new ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder();
   }

   public ProjectSafetyProblemReportHeadDTO() {
   }

   public ProjectSafetyProblemReportHeadDTO(
      final Integer allQualityProblemTotal, final Integer allSafetyProblemTotal, final List<ProjectSafetyProblemReportDataDTO> reportDataDTOList
   ) {
      this.allQualityProblemTotal = allQualityProblemTotal;
      this.allSafetyProblemTotal = allSafetyProblemTotal;
      this.reportDataDTOList = reportDataDTOList;
   }

   public Integer getAllQualityProblemTotal() {
      return this.allQualityProblemTotal;
   }

   public Integer getAllSafetyProblemTotal() {
      return this.allSafetyProblemTotal;
   }

   public List<ProjectSafetyProblemReportDataDTO> getReportDataDTOList() {
      return this.reportDataDTOList;
   }

   public ProjectSafetyProblemReportHeadDTO setAllQualityProblemTotal(final Integer allQualityProblemTotal) {
      this.allQualityProblemTotal = allQualityProblemTotal;
      return this;
   }

   public ProjectSafetyProblemReportHeadDTO setAllSafetyProblemTotal(final Integer allSafetyProblemTotal) {
      this.allSafetyProblemTotal = allSafetyProblemTotal;
      return this;
   }

   public ProjectSafetyProblemReportHeadDTO setReportDataDTOList(final List<ProjectSafetyProblemReportDataDTO> reportDataDTOList) {
      this.reportDataDTOList = reportDataDTOList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemReportHeadDTO)) {
         return false;
      }

      ProjectSafetyProblemReportHeadDTO other = (ProjectSafetyProblemReportHeadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$allQualityProblemTotal = this.getAllQualityProblemTotal();
      Object other$allQualityProblemTotal = other.getAllQualityProblemTotal();
      if (this$allQualityProblemTotal == null ? other$allQualityProblemTotal == null : this$allQualityProblemTotal.equals(other$allQualityProblemTotal)) {
         Object this$allSafetyProblemTotal = this.getAllSafetyProblemTotal();
         Object other$allSafetyProblemTotal = other.getAllSafetyProblemTotal();
         if (this$allSafetyProblemTotal == null ? other$allSafetyProblemTotal == null : this$allSafetyProblemTotal.equals(other$allSafetyProblemTotal)) {
            Object this$reportDataDTOList = this.getReportDataDTOList();
            Object other$reportDataDTOList = other.getReportDataDTOList();
            return this$reportDataDTOList == null ? other$reportDataDTOList == null : this$reportDataDTOList.equals(other$reportDataDTOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSafetyProblemReportHeadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $allQualityProblemTotal = this.getAllQualityProblemTotal();
      result = result * 59 + ($allQualityProblemTotal == null ? 43 : $allQualityProblemTotal.hashCode());
      Object $allSafetyProblemTotal = this.getAllSafetyProblemTotal();
      result = result * 59 + ($allSafetyProblemTotal == null ? 43 : $allSafetyProblemTotal.hashCode());
      Object $reportDataDTOList = this.getReportDataDTOList();
      return result * 59 + ($reportDataDTOList == null ? 43 : $reportDataDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemReportHeadDTO(allQualityProblemTotal="
         + this.getAllQualityProblemTotal()
         + ", allSafetyProblemTotal="
         + this.getAllSafetyProblemTotal()
         + ", reportDataDTOList="
         + this.getReportDataDTOList()
         + ")";
   }

   public static class ProjectSafetyProblemReportHeadDTOBuilder {
      private Integer allQualityProblemTotal;
      private Integer allSafetyProblemTotal;
      private List<ProjectSafetyProblemReportDataDTO> reportDataDTOList;

      ProjectSafetyProblemReportHeadDTOBuilder() {
      }

      public ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder allQualityProblemTotal(final Integer allQualityProblemTotal) {
         this.allQualityProblemTotal = allQualityProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder allSafetyProblemTotal(final Integer allSafetyProblemTotal) {
         this.allSafetyProblemTotal = allSafetyProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder reportDataDTOList(
         final List<ProjectSafetyProblemReportDataDTO> reportDataDTOList
      ) {
         this.reportDataDTOList = reportDataDTOList;
         return this;
      }

      public ProjectSafetyProblemReportHeadDTO build() {
         return new ProjectSafetyProblemReportHeadDTO(this.allQualityProblemTotal, this.allSafetyProblemTotal, this.reportDataDTOList);
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemReportHeadDTO.ProjectSafetyProblemReportHeadDTOBuilder(allQualityProblemTotal="
            + this.allQualityProblemTotal
            + ", allSafetyProblemTotal="
            + this.allSafetyProblemTotal
            + ", reportDataDTOList="
            + this.reportDataDTOList
            + ")";
      }
   }
}
