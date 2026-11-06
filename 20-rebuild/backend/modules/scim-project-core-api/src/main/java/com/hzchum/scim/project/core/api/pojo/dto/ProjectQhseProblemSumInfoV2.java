package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("质安问题-数量统计类")
public class ProjectQhseProblemSumInfoV2 {
   @ApiModelProperty("总数量")
   private long totalQuantity;
   @ApiModelProperty("质量")
   private long qualityQuantity;
   @ApiModelProperty("安全")
   private long safetyQuantity;
   @ApiModelProperty("环境")
   private long ambienceQuantity;

   public static ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder builder() {
      return new ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder();
   }

   public ProjectQhseProblemSumInfoV2() {
   }

   public ProjectQhseProblemSumInfoV2(final long totalQuantity, final long qualityQuantity, final long safetyQuantity, final long ambienceQuantity) {
      this.totalQuantity = totalQuantity;
      this.qualityQuantity = qualityQuantity;
      this.safetyQuantity = safetyQuantity;
      this.ambienceQuantity = ambienceQuantity;
   }

   public long getTotalQuantity() {
      return this.totalQuantity;
   }

   public long getQualityQuantity() {
      return this.qualityQuantity;
   }

   public long getSafetyQuantity() {
      return this.safetyQuantity;
   }

   public long getAmbienceQuantity() {
      return this.ambienceQuantity;
   }

   public void setTotalQuantity(final long totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setQualityQuantity(final long qualityQuantity) {
      this.qualityQuantity = qualityQuantity;
   }

   public void setSafetyQuantity(final long safetyQuantity) {
      this.safetyQuantity = safetyQuantity;
   }

   public void setAmbienceQuantity(final long ambienceQuantity) {
      this.ambienceQuantity = ambienceQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseProblemSumInfoV2)) {
         return false;
      } else {
         ProjectQhseProblemSumInfoV2 other = (ProjectQhseProblemSumInfoV2)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getTotalQuantity() != other.getTotalQuantity()) {
            return false;
         } else if (this.getQualityQuantity() != other.getQualityQuantity()) {
            return false;
         } else {
            return this.getSafetyQuantity() != other.getSafetyQuantity() ? false : this.getAmbienceQuantity() == other.getAmbienceQuantity();
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemSumInfoV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $totalQuantity = this.getTotalQuantity();
      result = result * 59 + (int)($totalQuantity >>> 32 ^ $totalQuantity);
      long $qualityQuantity = this.getQualityQuantity();
      result = result * 59 + (int)($qualityQuantity >>> 32 ^ $qualityQuantity);
      long $safetyQuantity = this.getSafetyQuantity();
      result = result * 59 + (int)($safetyQuantity >>> 32 ^ $safetyQuantity);
      long $ambienceQuantity = this.getAmbienceQuantity();
      return result * 59 + (int)($ambienceQuantity >>> 32 ^ $ambienceQuantity);
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemSumInfoV2(totalQuantity="
         + this.getTotalQuantity()
         + ", qualityQuantity="
         + this.getQualityQuantity()
         + ", safetyQuantity="
         + this.getSafetyQuantity()
         + ", ambienceQuantity="
         + this.getAmbienceQuantity()
         + ")";
   }

   public static class ProjectQhseProblemSumInfoV2Builder {
      private long totalQuantity;
      private long qualityQuantity;
      private long safetyQuantity;
      private long ambienceQuantity;

      ProjectQhseProblemSumInfoV2Builder() {
      }

      public ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder totalQuantity(final long totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder qualityQuantity(final long qualityQuantity) {
         this.qualityQuantity = qualityQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder safetyQuantity(final long safetyQuantity) {
         this.safetyQuantity = safetyQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder ambienceQuantity(final long ambienceQuantity) {
         this.ambienceQuantity = ambienceQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfoV2 build() {
         return new ProjectQhseProblemSumInfoV2(this.totalQuantity, this.qualityQuantity, this.safetyQuantity, this.ambienceQuantity);
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemSumInfoV2.ProjectQhseProblemSumInfoV2Builder(totalQuantity="
            + this.totalQuantity
            + ", qualityQuantity="
            + this.qualityQuantity
            + ", safetyQuantity="
            + this.safetyQuantity
            + ", ambienceQuantity="
            + this.ambienceQuantity
            + ")";
      }
   }
}
