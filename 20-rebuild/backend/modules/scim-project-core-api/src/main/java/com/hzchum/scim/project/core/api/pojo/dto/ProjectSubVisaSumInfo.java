package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分包签证-统计类")
public class ProjectSubVisaSumInfo {
   @ApiModelProperty("总数量")
   private int totalQuantity;
   @ApiModelProperty("审核通过数量")
   private int succeedQuantity;
   @ApiModelProperty("审核失败数量")
   private int failedQuantity;
   @ApiModelProperty("未审核数量")
   private int unCheckQuantity;

   public static ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder builder() {
      return new ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder();
   }

   public ProjectSubVisaSumInfo() {
   }

   public ProjectSubVisaSumInfo(final int totalQuantity, final int succeedQuantity, final int failedQuantity, final int unCheckQuantity) {
      this.totalQuantity = totalQuantity;
      this.succeedQuantity = succeedQuantity;
      this.failedQuantity = failedQuantity;
      this.unCheckQuantity = unCheckQuantity;
   }

   public int getTotalQuantity() {
      return this.totalQuantity;
   }

   public int getSucceedQuantity() {
      return this.succeedQuantity;
   }

   public int getFailedQuantity() {
      return this.failedQuantity;
   }

   public int getUnCheckQuantity() {
      return this.unCheckQuantity;
   }

   public void setTotalQuantity(final int totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setSucceedQuantity(final int succeedQuantity) {
      this.succeedQuantity = succeedQuantity;
   }

   public void setFailedQuantity(final int failedQuantity) {
      this.failedQuantity = failedQuantity;
   }

   public void setUnCheckQuantity(final int unCheckQuantity) {
      this.unCheckQuantity = unCheckQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectSubVisaSumInfo)) {
         return false;
      } else {
         ProjectSubVisaSumInfo other = (ProjectSubVisaSumInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getTotalQuantity() != other.getTotalQuantity()) {
            return false;
         } else if (this.getSucceedQuantity() != other.getSucceedQuantity()) {
            return false;
         } else {
            return this.getFailedQuantity() != other.getFailedQuantity() ? false : this.getUnCheckQuantity() == other.getUnCheckQuantity();
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSubVisaSumInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTotalQuantity();
      result = result * 59 + this.getSucceedQuantity();
      result = result * 59 + this.getFailedQuantity();
      return result * 59 + this.getUnCheckQuantity();
   }

   @Override
   public String toString() {
      return "ProjectSubVisaSumInfo(totalQuantity="
         + this.getTotalQuantity()
         + ", succeedQuantity="
         + this.getSucceedQuantity()
         + ", failedQuantity="
         + this.getFailedQuantity()
         + ", unCheckQuantity="
         + this.getUnCheckQuantity()
         + ")";
   }

   public static class ProjectSubVisaSumInfoBuilder {
      private int totalQuantity;
      private int succeedQuantity;
      private int failedQuantity;
      private int unCheckQuantity;

      ProjectSubVisaSumInfoBuilder() {
      }

      public ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder totalQuantity(final int totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder succeedQuantity(final int succeedQuantity) {
         this.succeedQuantity = succeedQuantity;
         return this;
      }

      public ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder failedQuantity(final int failedQuantity) {
         this.failedQuantity = failedQuantity;
         return this;
      }

      public ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder unCheckQuantity(final int unCheckQuantity) {
         this.unCheckQuantity = unCheckQuantity;
         return this;
      }

      public ProjectSubVisaSumInfo build() {
         return new ProjectSubVisaSumInfo(this.totalQuantity, this.succeedQuantity, this.failedQuantity, this.unCheckQuantity);
      }

      @Override
      public String toString() {
         return "ProjectSubVisaSumInfo.ProjectSubVisaSumInfoBuilder(totalQuantity="
            + this.totalQuantity
            + ", succeedQuantity="
            + this.succeedQuantity
            + ", failedQuantity="
            + this.failedQuantity
            + ", unCheckQuantity="
            + this.unCheckQuantity
            + ")";
      }
   }
}
