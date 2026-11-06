package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.util.List;

public class QueryDeviceByMaterialDtoParam {
   private List<Long> receiveDetailId;
   private Long receiveId;

   public static QueryDeviceByMaterialDtoParam.QueryDeviceByMaterialDtoParamBuilder builder() {
      return new QueryDeviceByMaterialDtoParam.QueryDeviceByMaterialDtoParamBuilder();
   }

   public List<Long> getReceiveDetailId() {
      return this.receiveDetailId;
   }

   public Long getReceiveId() {
      return this.receiveId;
   }

   public void setReceiveDetailId(final List<Long> receiveDetailId) {
      this.receiveDetailId = receiveDetailId;
   }

   public void setReceiveId(final Long receiveId) {
      this.receiveId = receiveId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QueryDeviceByMaterialDtoParam)) {
         return false;
      } else {
         QueryDeviceByMaterialDtoParam other = (QueryDeviceByMaterialDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$receiveId = this.getReceiveId();
            Object other$receiveId = other.getReceiveId();
            if (this$receiveId == null ? other$receiveId == null : this$receiveId.equals(other$receiveId)) {
               Object this$receiveDetailId = this.getReceiveDetailId();
               Object other$receiveDetailId = other.getReceiveDetailId();
               return this$receiveDetailId == null ? other$receiveDetailId == null : this$receiveDetailId.equals(other$receiveDetailId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryDeviceByMaterialDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receiveId = this.getReceiveId();
      result = result * 59 + ($receiveId == null ? 43 : $receiveId.hashCode());
      Object $receiveDetailId = this.getReceiveDetailId();
      return result * 59 + ($receiveDetailId == null ? 43 : $receiveDetailId.hashCode());
   }

   @Override
   public String toString() {
      return "QueryDeviceByMaterialDtoParam(receiveDetailId=" + this.getReceiveDetailId() + ", receiveId=" + this.getReceiveId() + ")";
   }

   public QueryDeviceByMaterialDtoParam(final List<Long> receiveDetailId, final Long receiveId) {
      this.receiveDetailId = receiveDetailId;
      this.receiveId = receiveId;
   }

   public QueryDeviceByMaterialDtoParam() {
   }

   public static class QueryDeviceByMaterialDtoParamBuilder {
      private List<Long> receiveDetailId;
      private Long receiveId;

      QueryDeviceByMaterialDtoParamBuilder() {
      }

      public QueryDeviceByMaterialDtoParam.QueryDeviceByMaterialDtoParamBuilder receiveDetailId(final List<Long> receiveDetailId) {
         this.receiveDetailId = receiveDetailId;
         return this;
      }

      public QueryDeviceByMaterialDtoParam.QueryDeviceByMaterialDtoParamBuilder receiveId(final Long receiveId) {
         this.receiveId = receiveId;
         return this;
      }

      public QueryDeviceByMaterialDtoParam build() {
         return new QueryDeviceByMaterialDtoParam(this.receiveDetailId, this.receiveId);
      }

      @Override
      public String toString() {
         return "QueryDeviceByMaterialDtoParam.QueryDeviceByMaterialDtoParamBuilder(receiveDetailId="
            + this.receiveDetailId
            + ", receiveId="
            + this.receiveId
            + ")";
      }
   }
}
