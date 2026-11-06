package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class RejectDTOParam {
   private Long inboundId;
   private String remark;
   private Integer rejectFreightType;
   private BigDecimal freight;
   List<RejectDetailDTOParam> list;

   public static RejectDTOParam.RejectDTOParamBuilder builder() {
      return new RejectDTOParam.RejectDTOParamBuilder();
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getRejectFreightType() {
      return this.rejectFreightType;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public List<RejectDetailDTOParam> getList() {
      return this.list;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setRejectFreightType(final Integer rejectFreightType) {
      this.rejectFreightType = rejectFreightType;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setList(final List<RejectDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDTOParam)) {
         return false;
      }

      RejectDTOParam other = (RejectDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundId = this.getInboundId();
      Object other$inboundId = other.getInboundId();
      if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
         Object this$rejectFreightType = this.getRejectFreightType();
         Object other$rejectFreightType = other.getRejectFreightType();
         if (this$rejectFreightType == null ? other$rejectFreightType == null : this$rejectFreightType.equals(other$rejectFreightType)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$freight = this.getFreight();
               Object other$freight = other.getFreight();
               if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                  Object this$list = this.getList();
                  Object other$list = other.getList();
                  return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof RejectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $rejectFreightType = this.getRejectFreightType();
      result = result * 59 + ($rejectFreightType == null ? 43 : $rejectFreightType.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDTOParam(inboundId="
         + this.getInboundId()
         + ", remark="
         + this.getRemark()
         + ", rejectFreightType="
         + this.getRejectFreightType()
         + ", freight="
         + this.getFreight()
         + ", list="
         + this.getList()
         + ")";
   }

   public RejectDTOParam(
      final Long inboundId, final String remark, final Integer rejectFreightType, final BigDecimal freight, final List<RejectDetailDTOParam> list
   ) {
      this.inboundId = inboundId;
      this.remark = remark;
      this.rejectFreightType = rejectFreightType;
      this.freight = freight;
      this.list = list;
   }

   public RejectDTOParam() {
   }

   public static class RejectDTOParamBuilder {
      private Long inboundId;
      private String remark;
      private Integer rejectFreightType;
      private BigDecimal freight;
      private List<RejectDetailDTOParam> list;

      RejectDTOParamBuilder() {
      }

      public RejectDTOParam.RejectDTOParamBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public RejectDTOParam.RejectDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RejectDTOParam.RejectDTOParamBuilder rejectFreightType(final Integer rejectFreightType) {
         this.rejectFreightType = rejectFreightType;
         return this;
      }

      public RejectDTOParam.RejectDTOParamBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public RejectDTOParam.RejectDTOParamBuilder list(final List<RejectDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public RejectDTOParam build() {
         return new RejectDTOParam(this.inboundId, this.remark, this.rejectFreightType, this.freight, this.list);
      }

      @Override
      public String toString() {
         return "RejectDTOParam.RejectDTOParamBuilder(inboundId="
            + this.inboundId
            + ", remark="
            + this.remark
            + ", rejectFreightType="
            + this.rejectFreightType
            + ", freight="
            + this.freight
            + ", list="
            + this.list
            + ")";
      }
   }
}
