package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryReceiveDateDTOParam {
   private Integer year;
   private List<Long> projectIds;
   private List<Long> workShopIds;
   private Integer basicClass;
   private List<LocalDateTime> times;

   public static QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder builder() {
      return new QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder();
   }

   public Integer getYear() {
      return this.year;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public List<Long> getWorkShopIds() {
      return this.workShopIds;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<LocalDateTime> getTimes() {
      return this.times;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setWorkShopIds(final List<Long> workShopIds) {
      this.workShopIds = workShopIds;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setTimes(final List<LocalDateTime> times) {
      this.times = times;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReceiveDateDTOParam)) {
         return false;
      }

      QueryReceiveDateDTOParam other = (QueryReceiveDateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$projectIds = this.getProjectIds();
            Object other$projectIds = other.getProjectIds();
            if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
               Object this$workShopIds = this.getWorkShopIds();
               Object other$workShopIds = other.getWorkShopIds();
               if (this$workShopIds == null ? other$workShopIds == null : this$workShopIds.equals(other$workShopIds)) {
                  Object this$times = this.getTimes();
                  Object other$times = other.getTimes();
                  return this$times == null ? other$times == null : this$times.equals(other$times);
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
      return other instanceof QueryReceiveDateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $workShopIds = this.getWorkShopIds();
      result = result * 59 + ($workShopIds == null ? 43 : $workShopIds.hashCode());
      Object $times = this.getTimes();
      return result * 59 + ($times == null ? 43 : $times.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReceiveDateDTOParam(year="
         + this.getYear()
         + ", projectIds="
         + this.getProjectIds()
         + ", workShopIds="
         + this.getWorkShopIds()
         + ", basicClass="
         + this.getBasicClass()
         + ", times="
         + this.getTimes()
         + ")";
   }

   public QueryReceiveDateDTOParam(
      final Integer year, final List<Long> projectIds, final List<Long> workShopIds, final Integer basicClass, final List<LocalDateTime> times
   ) {
      this.year = year;
      this.projectIds = projectIds;
      this.workShopIds = workShopIds;
      this.basicClass = basicClass;
      this.times = times;
   }

   public QueryReceiveDateDTOParam() {
   }

   public static class QueryReceiveDateDTOParamBuilder {
      private Integer year;
      private List<Long> projectIds;
      private List<Long> workShopIds;
      private Integer basicClass;
      private List<LocalDateTime> times;

      QueryReceiveDateDTOParamBuilder() {
      }

      public QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder workShopIds(final List<Long> workShopIds) {
         this.workShopIds = workShopIds;
         return this;
      }

      public QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder times(final List<LocalDateTime> times) {
         this.times = times;
         return this;
      }

      public QueryReceiveDateDTOParam build() {
         return new QueryReceiveDateDTOParam(this.year, this.projectIds, this.workShopIds, this.basicClass, this.times);
      }

      @Override
      public String toString() {
         return "QueryReceiveDateDTOParam.QueryReceiveDateDTOParamBuilder(year="
            + this.year
            + ", projectIds="
            + this.projectIds
            + ", workShopIds="
            + this.workShopIds
            + ", basicClass="
            + this.basicClass
            + ", times="
            + this.times
            + ")";
      }
   }
}
