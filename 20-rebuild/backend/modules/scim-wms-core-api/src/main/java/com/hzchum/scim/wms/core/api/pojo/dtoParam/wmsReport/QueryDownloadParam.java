package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.util.List;
import javax.validation.constraints.NotEmpty;

public class QueryDownloadParam {
   @NotEmpty(message = "单据编号不能为空！")
   List<Long> ids;

   public static QueryDownloadParam.QueryDownloadParamBuilder builder() {
      return new QueryDownloadParam.QueryDownloadParamBuilder();
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryDownloadParam)) {
         return false;
      }

      QueryDownloadParam other = (QueryDownloadParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryDownloadParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   @Override
   public String toString() {
      return "QueryDownloadParam(ids=" + this.getIds() + ")";
   }

   public QueryDownloadParam(final List<Long> ids) {
      this.ids = ids;
   }

   public QueryDownloadParam() {
   }

   public static class QueryDownloadParamBuilder {
      private List<Long> ids;

      QueryDownloadParamBuilder() {
      }

      public QueryDownloadParam.QueryDownloadParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public QueryDownloadParam build() {
         return new QueryDownloadParam(this.ids);
      }

      @Override
      public String toString() {
         return "QueryDownloadParam.QueryDownloadParamBuilder(ids=" + this.ids + ")";
      }
   }
}
