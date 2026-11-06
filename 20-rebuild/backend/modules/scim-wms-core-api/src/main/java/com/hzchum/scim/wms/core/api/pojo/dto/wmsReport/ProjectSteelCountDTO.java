package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class ProjectSteelCountDTO {
   private String projectName;
   private BigDecimal techArtifactMete;
   private BigDecimal outboundMete;
   private BigDecimal outboundMeteThisMonth;

   public static ProjectSteelCountDTO.ProjectSteelCountDTOBuilder builder() {
      return new ProjectSteelCountDTO.ProjectSteelCountDTOBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getTechArtifactMete() {
      return this.techArtifactMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundMeteThisMonth() {
      return this.outboundMeteThisMonth;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setTechArtifactMete(final BigDecimal techArtifactMete) {
      this.techArtifactMete = techArtifactMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setOutboundMeteThisMonth(final BigDecimal outboundMeteThisMonth) {
      this.outboundMeteThisMonth = outboundMeteThisMonth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSteelCountDTO)) {
         return false;
      }

      ProjectSteelCountDTO other = (ProjectSteelCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$techArtifactMete = this.getTechArtifactMete();
         Object other$techArtifactMete = other.getTechArtifactMete();
         if (this$techArtifactMete == null ? other$techArtifactMete == null : this$techArtifactMete.equals(other$techArtifactMete)) {
            Object this$outboundMete = this.getOutboundMete();
            Object other$outboundMete = other.getOutboundMete();
            if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
               Object this$outboundMeteThisMonth = this.getOutboundMeteThisMonth();
               Object other$outboundMeteThisMonth = other.getOutboundMeteThisMonth();
               return this$outboundMeteThisMonth == null ? other$outboundMeteThisMonth == null : this$outboundMeteThisMonth.equals(other$outboundMeteThisMonth);
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
      return other instanceof ProjectSteelCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $techArtifactMete = this.getTechArtifactMete();
      result = result * 59 + ($techArtifactMete == null ? 43 : $techArtifactMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundMeteThisMonth = this.getOutboundMeteThisMonth();
      return result * 59 + ($outboundMeteThisMonth == null ? 43 : $outboundMeteThisMonth.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSteelCountDTO(projectName="
         + this.getProjectName()
         + ", techArtifactMete="
         + this.getTechArtifactMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundMeteThisMonth="
         + this.getOutboundMeteThisMonth()
         + ")";
   }

   public ProjectSteelCountDTO(
      final String projectName, final BigDecimal techArtifactMete, final BigDecimal outboundMete, final BigDecimal outboundMeteThisMonth
   ) {
      this.projectName = projectName;
      this.techArtifactMete = techArtifactMete;
      this.outboundMete = outboundMete;
      this.outboundMeteThisMonth = outboundMeteThisMonth;
   }

   public ProjectSteelCountDTO() {
   }

   public static class ProjectSteelCountDTOBuilder {
      private String projectName;
      private BigDecimal techArtifactMete;
      private BigDecimal outboundMete;
      private BigDecimal outboundMeteThisMonth;

      ProjectSteelCountDTOBuilder() {
      }

      public ProjectSteelCountDTO.ProjectSteelCountDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectSteelCountDTO.ProjectSteelCountDTOBuilder techArtifactMete(final BigDecimal techArtifactMete) {
         this.techArtifactMete = techArtifactMete;
         return this;
      }

      public ProjectSteelCountDTO.ProjectSteelCountDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public ProjectSteelCountDTO.ProjectSteelCountDTOBuilder outboundMeteThisMonth(final BigDecimal outboundMeteThisMonth) {
         this.outboundMeteThisMonth = outboundMeteThisMonth;
         return this;
      }

      public ProjectSteelCountDTO build() {
         return new ProjectSteelCountDTO(this.projectName, this.techArtifactMete, this.outboundMete, this.outboundMeteThisMonth);
      }

      @Override
      public String toString() {
         return "ProjectSteelCountDTO.ProjectSteelCountDTOBuilder(projectName="
            + this.projectName
            + ", techArtifactMete="
            + this.techArtifactMete
            + ", outboundMete="
            + this.outboundMete
            + ", outboundMeteThisMonth="
            + this.outboundMeteThisMonth
            + ")";
      }
   }
}
