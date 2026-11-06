package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("质安问题-数量统计类")
public class ProjectQhseProblemSumInfo {
   @ApiModelProperty("总数量")
   private int totalQuantity;
   @ApiModelProperty("已关闭数量")
   private int closedQuantity;
   @ApiModelProperty("未关闭数量")
   private int notCloseQuantity;

   public static ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder builder() {
      return new ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder();
   }

   public ProjectQhseProblemSumInfo() {
   }

   public ProjectQhseProblemSumInfo(final int totalQuantity, final int closedQuantity, final int notCloseQuantity) {
      this.totalQuantity = totalQuantity;
      this.closedQuantity = closedQuantity;
      this.notCloseQuantity = notCloseQuantity;
   }

   public int getTotalQuantity() {
      return this.totalQuantity;
   }

   public int getClosedQuantity() {
      return this.closedQuantity;
   }

   public int getNotCloseQuantity() {
      return this.notCloseQuantity;
   }

   public void setTotalQuantity(final int totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setClosedQuantity(final int closedQuantity) {
      this.closedQuantity = closedQuantity;
   }

   public void setNotCloseQuantity(final int notCloseQuantity) {
      this.notCloseQuantity = notCloseQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseProblemSumInfo)) {
         return false;
      } else {
         ProjectQhseProblemSumInfo other = (ProjectQhseProblemSumInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getTotalQuantity() != other.getTotalQuantity()) {
            return false;
         } else {
            return this.getClosedQuantity() != other.getClosedQuantity() ? false : this.getNotCloseQuantity() == other.getNotCloseQuantity();
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemSumInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTotalQuantity();
      result = result * 59 + this.getClosedQuantity();
      return result * 59 + this.getNotCloseQuantity();
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemSumInfo(totalQuantity="
         + this.getTotalQuantity()
         + ", closedQuantity="
         + this.getClosedQuantity()
         + ", notCloseQuantity="
         + this.getNotCloseQuantity()
         + ")";
   }

   public static class ProjectQhseProblemSumInfoBuilder {
      private int totalQuantity;
      private int closedQuantity;
      private int notCloseQuantity;

      ProjectQhseProblemSumInfoBuilder() {
      }

      public ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder totalQuantity(final int totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder closedQuantity(final int closedQuantity) {
         this.closedQuantity = closedQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder notCloseQuantity(final int notCloseQuantity) {
         this.notCloseQuantity = notCloseQuantity;
         return this;
      }

      public ProjectQhseProblemSumInfo build() {
         return new ProjectQhseProblemSumInfo(this.totalQuantity, this.closedQuantity, this.notCloseQuantity);
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemSumInfo.ProjectQhseProblemSumInfoBuilder(totalQuantity="
            + this.totalQuantity
            + ", closedQuantity="
            + this.closedQuantity
            + ", notCloseQuantity="
            + this.notCloseQuantity
            + ")";
      }
   }
}
