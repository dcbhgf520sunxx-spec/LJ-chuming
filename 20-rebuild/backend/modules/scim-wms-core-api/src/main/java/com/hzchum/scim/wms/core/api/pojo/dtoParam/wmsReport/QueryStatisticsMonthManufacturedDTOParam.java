package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class QueryStatisticsMonthManufacturedDTOParam {
   @ApiModelProperty("月份")
   @NotNull(message = "月份不能为空")
   private String monthStr;
   @ApiModelProperty("制成品类型")
   private Integer basicClass;

   public static QueryStatisticsMonthManufacturedDTOParam.QueryStatisticsMonthManufacturedDTOParamBuilder builder() {
      return new QueryStatisticsMonthManufacturedDTOParam.QueryStatisticsMonthManufacturedDTOParamBuilder();
   }

   public String getMonthStr() {
      return this.monthStr;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public void setMonthStr(final String monthStr) {
      this.monthStr = monthStr;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QueryStatisticsMonthManufacturedDTOParam)) {
         return false;
      } else {
         QueryStatisticsMonthManufacturedDTOParam other = (QueryStatisticsMonthManufacturedDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$monthStr = this.getMonthStr();
               Object other$monthStr = other.getMonthStr();
               return this$monthStr == null ? other$monthStr == null : this$monthStr.equals(other$monthStr);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryStatisticsMonthManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monthStr = this.getMonthStr();
      return result * 59 + ($monthStr == null ? 43 : $monthStr.hashCode());
   }

   @Override
   public String toString() {
      return "QueryStatisticsMonthManufacturedDTOParam(monthStr=" + this.getMonthStr() + ", basicClass=" + this.getBasicClass() + ")";
   }

   public QueryStatisticsMonthManufacturedDTOParam(final String monthStr, final Integer basicClass) {
      this.monthStr = monthStr;
      this.basicClass = basicClass;
   }

   public QueryStatisticsMonthManufacturedDTOParam() {
   }

   public static class QueryStatisticsMonthManufacturedDTOParamBuilder {
      private String monthStr;
      private Integer basicClass;

      QueryStatisticsMonthManufacturedDTOParamBuilder() {
      }

      public QueryStatisticsMonthManufacturedDTOParam.QueryStatisticsMonthManufacturedDTOParamBuilder monthStr(final String monthStr) {
         this.monthStr = monthStr;
         return this;
      }

      public QueryStatisticsMonthManufacturedDTOParam.QueryStatisticsMonthManufacturedDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryStatisticsMonthManufacturedDTOParam build() {
         return new QueryStatisticsMonthManufacturedDTOParam(this.monthStr, this.basicClass);
      }

      @Override
      public String toString() {
         return "QueryStatisticsMonthManufacturedDTOParam.QueryStatisticsMonthManufacturedDTOParamBuilder(monthStr="
            + this.monthStr
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
