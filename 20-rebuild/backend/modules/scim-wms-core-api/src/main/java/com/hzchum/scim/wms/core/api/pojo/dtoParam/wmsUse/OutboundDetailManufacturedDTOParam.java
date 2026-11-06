package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public class OutboundDetailManufacturedDTOParam {
   @ApiModelProperty("物料仓库ID")
   @NotNull(message = "物料仓库ID")
   private Long materialId;
   @ApiModelProperty("制成品出库数量")
   @NotNull(message = "制成品出库数量不能为空")
   private BigDecimal quantity;
   @ApiModelProperty("领用人ID")
   @NotNull(message = "领用人ID不能为空")
   private Long recipientId;
   @ApiModelProperty("出库时间")
   private LocalDateTime outboundTime;
   @ApiModelProperty("备注")
   private String remark;

   public static OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder builder() {
      return new OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder();
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailManufacturedDTOParam)) {
         return false;
      }

      OutboundDetailManufacturedDTOParam other = (OutboundDetailManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialId = this.getMaterialId();
      Object other$materialId = other.getMaterialId();
      if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
         Object this$recipientId = this.getRecipientId();
         Object other$recipientId = other.getRecipientId();
         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$outboundTime = this.getOutboundTime();
               Object other$outboundTime = other.getOutboundTime();
               if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof OutboundDetailManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailManufacturedDTOParam(materialId="
         + this.getMaterialId()
         + ", quantity="
         + this.getQuantity()
         + ", recipientId="
         + this.getRecipientId()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public OutboundDetailManufacturedDTOParam(
      final Long materialId, final BigDecimal quantity, final Long recipientId, final LocalDateTime outboundTime, final String remark
   ) {
      this.materialId = materialId;
      this.quantity = quantity;
      this.recipientId = recipientId;
      this.outboundTime = outboundTime;
      this.remark = remark;
   }

   public OutboundDetailManufacturedDTOParam() {
   }

   public static class OutboundDetailManufacturedDTOParamBuilder {
      private Long materialId;
      private BigDecimal quantity;
      private Long recipientId;
      private LocalDateTime outboundTime;
      private String remark;

      OutboundDetailManufacturedDTOParamBuilder() {
      }

      public OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDetailManufacturedDTOParam build() {
         return new OutboundDetailManufacturedDTOParam(this.materialId, this.quantity, this.recipientId, this.outboundTime, this.remark);
      }

      @Override
      public String toString() {
         return "OutboundDetailManufacturedDTOParam.OutboundDetailManufacturedDTOParamBuilder(materialId="
            + this.materialId
            + ", quantity="
            + this.quantity
            + ", recipientId="
            + this.recipientId
            + ", outboundTime="
            + this.outboundTime
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
