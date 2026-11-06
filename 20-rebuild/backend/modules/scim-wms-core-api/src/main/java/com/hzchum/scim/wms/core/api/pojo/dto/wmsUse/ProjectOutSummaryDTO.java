package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectOutSummaryDTO {
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   private ProjectInfoDTO project;
   @ApiModelProperty(name = "deepenMete", notes = "深化量/清单量")
   private BigDecimal deepenMete;
   @ApiModelProperty(name = "outMete", notes = "出库量(体现退库)")
   private BigDecimal outMete;
   @ApiModelProperty(name = "currentOutMete", notes = "当前月出库量(体现退库)")
   private BigDecimal currentOutMete;
   @ApiModelProperty(name = "lastOutMete", notes = "上月出库量(体现退库)")
   private BigDecimal lastOutMete;

   public static ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder builder() {
      return new ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder();
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public BigDecimal getDeepenMete() {
      return this.deepenMete;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public BigDecimal getCurrentOutMete() {
      return this.currentOutMete;
   }

   public BigDecimal getLastOutMete() {
      return this.lastOutMete;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setDeepenMete(final BigDecimal deepenMete) {
      this.deepenMete = deepenMete;
   }

   public void setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
   }

   public void setCurrentOutMete(final BigDecimal currentOutMete) {
      this.currentOutMete = currentOutMete;
   }

   public void setLastOutMete(final BigDecimal lastOutMete) {
      this.lastOutMete = lastOutMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectOutSummaryDTO)) {
         return false;
      }

      ProjectOutSummaryDTO other = (ProjectOutSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$deepenMete = this.getDeepenMete();
         Object other$deepenMete = other.getDeepenMete();
         if (this$deepenMete == null ? other$deepenMete == null : this$deepenMete.equals(other$deepenMete)) {
            Object this$outMete = this.getOutMete();
            Object other$outMete = other.getOutMete();
            if (this$outMete == null ? other$outMete == null : this$outMete.equals(other$outMete)) {
               Object this$currentOutMete = this.getCurrentOutMete();
               Object other$currentOutMete = other.getCurrentOutMete();
               if (this$currentOutMete == null ? other$currentOutMete == null : this$currentOutMete.equals(other$currentOutMete)) {
                  Object this$lastOutMete = this.getLastOutMete();
                  Object other$lastOutMete = other.getLastOutMete();
                  return this$lastOutMete == null ? other$lastOutMete == null : this$lastOutMete.equals(other$lastOutMete);
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
      return other instanceof ProjectOutSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $deepenMete = this.getDeepenMete();
      result = result * 59 + ($deepenMete == null ? 43 : $deepenMete.hashCode());
      Object $outMete = this.getOutMete();
      result = result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
      Object $currentOutMete = this.getCurrentOutMete();
      result = result * 59 + ($currentOutMete == null ? 43 : $currentOutMete.hashCode());
      Object $lastOutMete = this.getLastOutMete();
      return result * 59 + ($lastOutMete == null ? 43 : $lastOutMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectOutSummaryDTO(project="
         + this.getProject()
         + ", deepenMete="
         + this.getDeepenMete()
         + ", outMete="
         + this.getOutMete()
         + ", currentOutMete="
         + this.getCurrentOutMete()
         + ", lastOutMete="
         + this.getLastOutMete()
         + ")";
   }

   public ProjectOutSummaryDTO(
      final ProjectInfoDTO project, final BigDecimal deepenMete, final BigDecimal outMete, final BigDecimal currentOutMete, final BigDecimal lastOutMete
   ) {
      this.project = project;
      this.deepenMete = deepenMete;
      this.outMete = outMete;
      this.currentOutMete = currentOutMete;
      this.lastOutMete = lastOutMete;
   }

   public ProjectOutSummaryDTO() {
   }

   public static class ProjectOutSummaryDTOBuilder {
      private ProjectInfoDTO project;
      private BigDecimal deepenMete;
      private BigDecimal outMete;
      private BigDecimal currentOutMete;
      private BigDecimal lastOutMete;

      ProjectOutSummaryDTOBuilder() {
      }

      public ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder deepenMete(final BigDecimal deepenMete) {
         this.deepenMete = deepenMete;
         return this;
      }

      public ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder outMete(final BigDecimal outMete) {
         this.outMete = outMete;
         return this;
      }

      public ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder currentOutMete(final BigDecimal currentOutMete) {
         this.currentOutMete = currentOutMete;
         return this;
      }

      public ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder lastOutMete(final BigDecimal lastOutMete) {
         this.lastOutMete = lastOutMete;
         return this;
      }

      public ProjectOutSummaryDTO build() {
         return new ProjectOutSummaryDTO(this.project, this.deepenMete, this.outMete, this.currentOutMete, this.lastOutMete);
      }

      @Override
      public String toString() {
         return "ProjectOutSummaryDTO.ProjectOutSummaryDTOBuilder(project="
            + this.project
            + ", deepenMete="
            + this.deepenMete
            + ", outMete="
            + this.outMete
            + ", currentOutMete="
            + this.currentOutMete
            + ", lastOutMete="
            + this.lastOutMete
            + ")";
      }
   }
}
