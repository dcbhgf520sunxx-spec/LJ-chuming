package com.hzchum.scim.mes.building.core.api.pojo._do.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PointDO", description = "考勤点位")
public class PointDO {
   @ApiModelProperty(name = "point", value = "围栏点位", notes = "围栏点位")
   private String point;
   @ApiModelProperty(name = "sort", value = "序号", notes = "序号")
   private Integer sort;

   public static PointDO.PointDOBuilder builder() {
      return new PointDO.PointDOBuilder();
   }

   public PointDO() {
   }

   public PointDO(final String point, final Integer sort) {
      this.point = point;
      this.sort = sort;
   }

   public String getPoint() {
      return this.point;
   }

   public Integer getSort() {
      return this.sort;
   }

   public PointDO setPoint(final String point) {
      this.point = point;
      return this;
   }

   public PointDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PointDO)) {
         return false;
      } else {
         PointDO other = (PointDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$point = this.getPoint();
               Object other$point = other.getPoint();
               return this$point == null ? other$point == null : this$point.equals(other$point);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PointDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $point = this.getPoint();
      return result * 59 + ($point == null ? 43 : $point.hashCode());
   }

   @Override
   public String toString() {
      return "PointDO(point=" + this.getPoint() + ", sort=" + this.getSort() + ")";
   }

   public static class PointDOBuilder {
      private String point;
      private Integer sort;

      PointDOBuilder() {
      }

      public PointDO.PointDOBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public PointDO.PointDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PointDO build() {
         return new PointDO(this.point, this.sort);
      }

      @Override
      public String toString() {
         return "PointDO.PointDOBuilder(point=" + this.point + ", sort=" + this.sort + ")";
      }
   }
}
