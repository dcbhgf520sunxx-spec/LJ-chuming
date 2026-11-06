package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("劳务班组质安问题排名DTO")
public class TeamProblemRanDTO {
   @ApiModelProperty(name = "劳务名字")
   private String name;
   @ApiModelProperty(name = "qualityProblemTotal", notes = "质量问题总数")
   private Integer qualityProblemTotal;
   @ApiModelProperty(name = "safetyProblemTotal", notes = "安全问题总数")
   private Integer safetyProblemTotal;
   @ApiModelProperty(name = "problemTotal", notes = "问题总数")
   private Integer problemTotal;

   public static TeamProblemRanDTO.TeamProblemRanDTOBuilder builder() {
      return new TeamProblemRanDTO.TeamProblemRanDTOBuilder();
   }

   public TeamProblemRanDTO() {
   }

   public TeamProblemRanDTO(final String name, final Integer qualityProblemTotal, final Integer safetyProblemTotal, final Integer problemTotal) {
      this.name = name;
      this.qualityProblemTotal = qualityProblemTotal;
      this.safetyProblemTotal = safetyProblemTotal;
      this.problemTotal = problemTotal;
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

   public Integer getProblemTotal() {
      return this.problemTotal;
   }

   public TeamProblemRanDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TeamProblemRanDTO setQualityProblemTotal(final Integer qualityProblemTotal) {
      this.qualityProblemTotal = qualityProblemTotal;
      return this;
   }

   public TeamProblemRanDTO setSafetyProblemTotal(final Integer safetyProblemTotal) {
      this.safetyProblemTotal = safetyProblemTotal;
      return this;
   }

   public TeamProblemRanDTO setProblemTotal(final Integer problemTotal) {
      this.problemTotal = problemTotal;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProblemRanDTO(name="
         + this.getName()
         + ", qualityProblemTotal="
         + this.getQualityProblemTotal()
         + ", safetyProblemTotal="
         + this.getSafetyProblemTotal()
         + ", problemTotal="
         + this.getProblemTotal()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProblemRanDTO)) {
         return false;
      }

      TeamProblemRanDTO other = (TeamProblemRanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qualityProblemTotal = this.getQualityProblemTotal();
      Object other$qualityProblemTotal = other.getQualityProblemTotal();
      if (this$qualityProblemTotal == null ? other$qualityProblemTotal == null : this$qualityProblemTotal.equals(other$qualityProblemTotal)) {
         Object this$safetyProblemTotal = this.getSafetyProblemTotal();
         Object other$safetyProblemTotal = other.getSafetyProblemTotal();
         if (this$safetyProblemTotal == null ? other$safetyProblemTotal == null : this$safetyProblemTotal.equals(other$safetyProblemTotal)) {
            Object this$problemTotal = this.getProblemTotal();
            Object other$problemTotal = other.getProblemTotal();
            if (this$problemTotal == null ? other$problemTotal == null : this$problemTotal.equals(other$problemTotal)) {
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
      return other instanceof TeamProblemRanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qualityProblemTotal = this.getQualityProblemTotal();
      result = result * 59 + ($qualityProblemTotal == null ? 43 : $qualityProblemTotal.hashCode());
      Object $safetyProblemTotal = this.getSafetyProblemTotal();
      result = result * 59 + ($safetyProblemTotal == null ? 43 : $safetyProblemTotal.hashCode());
      Object $problemTotal = this.getProblemTotal();
      result = result * 59 + ($problemTotal == null ? 43 : $problemTotal.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class TeamProblemRanDTOBuilder {
      private String name;
      private Integer qualityProblemTotal;
      private Integer safetyProblemTotal;
      private Integer problemTotal;

      TeamProblemRanDTOBuilder() {
      }

      public TeamProblemRanDTO.TeamProblemRanDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TeamProblemRanDTO.TeamProblemRanDTOBuilder qualityProblemTotal(final Integer qualityProblemTotal) {
         this.qualityProblemTotal = qualityProblemTotal;
         return this;
      }

      public TeamProblemRanDTO.TeamProblemRanDTOBuilder safetyProblemTotal(final Integer safetyProblemTotal) {
         this.safetyProblemTotal = safetyProblemTotal;
         return this;
      }

      public TeamProblemRanDTO.TeamProblemRanDTOBuilder problemTotal(final Integer problemTotal) {
         this.problemTotal = problemTotal;
         return this;
      }

      public TeamProblemRanDTO build() {
         return new TeamProblemRanDTO(this.name, this.qualityProblemTotal, this.safetyProblemTotal, this.problemTotal);
      }

      @Override
      public String toString() {
         return "TeamProblemRanDTO.TeamProblemRanDTOBuilder(name="
            + this.name
            + ", qualityProblemTotal="
            + this.qualityProblemTotal
            + ", safetyProblemTotal="
            + this.safetyProblemTotal
            + ", problemTotal="
            + this.problemTotal
            + ")";
      }
   }
}
