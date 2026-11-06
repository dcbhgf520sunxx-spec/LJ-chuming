package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PointDTOParam", description = "考勤点位")
public class PointDTOParam {
   @ApiModelProperty(name = "point", value = "围栏点位", notes = "围栏点位")
   private String point;
   @ApiModelProperty(name = "sort", value = "序号", notes = "序号")
   private Integer sort;

   public static PointDTOParam.PointDTOParamBuilder builder() {
      return new PointDTOParam.PointDTOParamBuilder();
   }

   public PointDTOParam() {
   }

   public PointDTOParam(final String point, final Integer sort) {
      this.point = point;
      this.sort = sort;
   }

   public String getPoint() {
      return this.point;
   }

   public Integer getSort() {
      return this.sort;
   }

   public PointDTOParam setPoint(final String point) {
      this.point = point;
      return this;
   }

   public PointDTOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PointDTOParam)) {
         return false;
      } else {
         PointDTOParam other = (PointDTOParam)o;
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
      return other instanceof PointDTOParam;
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
      return "PointDTOParam(point=" + this.getPoint() + ", sort=" + this.getSort() + ")";
   }

   public static class PointDTOParamBuilder {
      private String point;
      private Integer sort;

      PointDTOParamBuilder() {
      }

      public PointDTOParam.PointDTOParamBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public PointDTOParam.PointDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PointDTOParam build() {
         return new PointDTOParam(this.point, this.sort);
      }

      @Override
      public String toString() {
         return "PointDTOParam.PointDTOParamBuilder(point=" + this.point + ", sort=" + this.sort + ")";
      }
   }
}
