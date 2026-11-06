package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "质检数量及问题统计数量")
public class QualityInspectionStatisticsDTO {
   private String teamName;
   private Integer inspectQuantity;
   private Integer qhseQuantity;

   public static QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder builder() {
      return new QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder();
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Integer getInspectQuantity() {
      return this.inspectQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setInspectQuantity(final Integer inspectQuantity) {
      this.inspectQuantity = inspectQuantity;
   }

   public void setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QualityInspectionStatisticsDTO)) {
         return false;
      }

      QualityInspectionStatisticsDTO other = (QualityInspectionStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inspectQuantity = this.getInspectQuantity();
      Object other$inspectQuantity = other.getInspectQuantity();
      if (this$inspectQuantity == null ? other$inspectQuantity == null : this$inspectQuantity.equals(other$inspectQuantity)) {
         Object this$qhseQuantity = this.getQhseQuantity();
         Object other$qhseQuantity = other.getQhseQuantity();
         if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
            Object this$teamName = this.getTeamName();
            Object other$teamName = other.getTeamName();
            return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QualityInspectionStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectQuantity = this.getInspectQuantity();
      result = result * 59 + ($inspectQuantity == null ? 43 : $inspectQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   @Override
   public String toString() {
      return "QualityInspectionStatisticsDTO(super="
         + super.toString()
         + ", teamName="
         + this.getTeamName()
         + ", inspectQuantity="
         + this.getInspectQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   public QualityInspectionStatisticsDTO(final String teamName, final Integer inspectQuantity, final Integer qhseQuantity) {
      this.teamName = teamName;
      this.inspectQuantity = inspectQuantity;
      this.qhseQuantity = qhseQuantity;
   }

   public QualityInspectionStatisticsDTO() {
   }

   public static class QualityInspectionStatisticsDTOBuilder {
      private String teamName;
      private Integer inspectQuantity;
      private Integer qhseQuantity;

      QualityInspectionStatisticsDTOBuilder() {
      }

      public QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder inspectQuantity(final Integer inspectQuantity) {
         this.inspectQuantity = inspectQuantity;
         return this;
      }

      public QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public QualityInspectionStatisticsDTO build() {
         return new QualityInspectionStatisticsDTO(this.teamName, this.inspectQuantity, this.qhseQuantity);
      }

      @Override
      public String toString() {
         return "QualityInspectionStatisticsDTO.QualityInspectionStatisticsDTOBuilder(teamName="
            + this.teamName
            + ", inspectQuantity="
            + this.inspectQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
