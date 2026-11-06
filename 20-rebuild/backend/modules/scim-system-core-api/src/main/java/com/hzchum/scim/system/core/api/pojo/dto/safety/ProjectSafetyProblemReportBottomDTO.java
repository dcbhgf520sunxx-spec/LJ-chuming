package com.hzchum.scim.system.core.api.pojo.dto.safety;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectSafetyProblemReportHeaderDTO", description = "治安报表底部列表展示")
public class ProjectSafetyProblemReportBottomDTO {
   @ApiModelProperty(name = "allQualityProblemTotal", notes = "累计质量问题总数")
   private Long allQualityProblemTotal;
   @ApiModelProperty(name = "allSafetyProblemTotal", notes = "累计安全问题总数")
   private Long allSafetyProblemTotal;
   @ApiModelProperty(name = "数据", notes = "数据")
   private PageVO<ProjectSafetyProblemReportListDTO> reportListDTOList;

   public static ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder builder() {
      return new ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder();
   }

   public ProjectSafetyProblemReportBottomDTO() {
   }

   public ProjectSafetyProblemReportBottomDTO(
      final Long allQualityProblemTotal, final Long allSafetyProblemTotal, final PageVO<ProjectSafetyProblemReportListDTO> reportListDTOList
   ) {
      this.allQualityProblemTotal = allQualityProblemTotal;
      this.allSafetyProblemTotal = allSafetyProblemTotal;
      this.reportListDTOList = reportListDTOList;
   }

   public Long getAllQualityProblemTotal() {
      return this.allQualityProblemTotal;
   }

   public Long getAllSafetyProblemTotal() {
      return this.allSafetyProblemTotal;
   }

   public PageVO<ProjectSafetyProblemReportListDTO> getReportListDTOList() {
      return this.reportListDTOList;
   }

   public ProjectSafetyProblemReportBottomDTO setAllQualityProblemTotal(final Long allQualityProblemTotal) {
      this.allQualityProblemTotal = allQualityProblemTotal;
      return this;
   }

   public ProjectSafetyProblemReportBottomDTO setAllSafetyProblemTotal(final Long allSafetyProblemTotal) {
      this.allSafetyProblemTotal = allSafetyProblemTotal;
      return this;
   }

   public ProjectSafetyProblemReportBottomDTO setReportListDTOList(final PageVO<ProjectSafetyProblemReportListDTO> reportListDTOList) {
      this.reportListDTOList = reportListDTOList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemReportBottomDTO)) {
         return false;
      }

      ProjectSafetyProblemReportBottomDTO other = (ProjectSafetyProblemReportBottomDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$allQualityProblemTotal = this.getAllQualityProblemTotal();
      Object other$allQualityProblemTotal = other.getAllQualityProblemTotal();
      if (this$allQualityProblemTotal == null ? other$allQualityProblemTotal == null : this$allQualityProblemTotal.equals(other$allQualityProblemTotal)) {
         Object this$allSafetyProblemTotal = this.getAllSafetyProblemTotal();
         Object other$allSafetyProblemTotal = other.getAllSafetyProblemTotal();
         if (this$allSafetyProblemTotal == null ? other$allSafetyProblemTotal == null : this$allSafetyProblemTotal.equals(other$allSafetyProblemTotal)) {
            Object this$reportListDTOList = this.getReportListDTOList();
            Object other$reportListDTOList = other.getReportListDTOList();
            return this$reportListDTOList == null ? other$reportListDTOList == null : this$reportListDTOList.equals(other$reportListDTOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSafetyProblemReportBottomDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $allQualityProblemTotal = this.getAllQualityProblemTotal();
      result = result * 59 + ($allQualityProblemTotal == null ? 43 : $allQualityProblemTotal.hashCode());
      Object $allSafetyProblemTotal = this.getAllSafetyProblemTotal();
      result = result * 59 + ($allSafetyProblemTotal == null ? 43 : $allSafetyProblemTotal.hashCode());
      Object $reportListDTOList = this.getReportListDTOList();
      return result * 59 + ($reportListDTOList == null ? 43 : $reportListDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemReportBottomDTO(allQualityProblemTotal="
         + this.getAllQualityProblemTotal()
         + ", allSafetyProblemTotal="
         + this.getAllSafetyProblemTotal()
         + ", reportListDTOList="
         + this.getReportListDTOList()
         + ")";
   }

   public static class ProjectSafetyProblemReportBottomDTOBuilder {
      private Long allQualityProblemTotal;
      private Long allSafetyProblemTotal;
      private PageVO<ProjectSafetyProblemReportListDTO> reportListDTOList;

      ProjectSafetyProblemReportBottomDTOBuilder() {
      }

      public ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder allQualityProblemTotal(final Long allQualityProblemTotal) {
         this.allQualityProblemTotal = allQualityProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder allSafetyProblemTotal(final Long allSafetyProblemTotal) {
         this.allSafetyProblemTotal = allSafetyProblemTotal;
         return this;
      }

      public ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder reportListDTOList(
         final PageVO<ProjectSafetyProblemReportListDTO> reportListDTOList
      ) {
         this.reportListDTOList = reportListDTOList;
         return this;
      }

      public ProjectSafetyProblemReportBottomDTO build() {
         return new ProjectSafetyProblemReportBottomDTO(this.allQualityProblemTotal, this.allSafetyProblemTotal, this.reportListDTOList);
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemReportBottomDTO.ProjectSafetyProblemReportBottomDTOBuilder(allQualityProblemTotal="
            + this.allQualityProblemTotal
            + ", allSafetyProblemTotal="
            + this.allSafetyProblemTotal
            + ", reportListDTOList="
            + this.reportListDTOList
            + ")";
      }
   }
}
