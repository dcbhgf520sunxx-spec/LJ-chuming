package com.hzchum.scim.wms.core.api.pojo.dtoParam.manager;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "OutboundManufacturedVORequest", description = "产品出库请求类")
public class OutboundManufacturedVORequest {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "出库数量", notes = "出库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "出库数量数量不能为空")
   @Min(value = 1L, message = "出库数量数量不能小于1")
   private BigDecimal quantity;
   @ApiModelProperty(name = "materialInventoryId", value = "制成品库存ID", notes = "制成品库存ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @NotNull(message = "制成品库存ID不能为空")
   private Long materialInventoryId;
   @ApiModelProperty(name = "userId", value = "出库人ID", notes = "出库人ID")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @NotNull(message = "出库人ID不能为空")
   private Long userId;
   @ApiModelProperty(name = "outboundTime", value = "出库时间", notes = "出库时间")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "basicClass", value = "基础物料类型", notes = "基础物料类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   private Integer basicClass;

   public static OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder builder() {
      return new OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder();
   }

   public OutboundManufacturedVORequest(
      final Long productId,
      final BigDecimal quantity,
      final Long materialInventoryId,
      final Long userId,
      final LocalDateTime outboundTime,
      final String remark,
      final Integer basicClass
   ) {
      this.productId = productId;
      this.quantity = quantity;
      this.materialInventoryId = materialInventoryId;
      this.userId = userId;
      this.outboundTime = outboundTime;
      this.remark = remark;
      this.basicClass = basicClass;
   }

   public OutboundManufacturedVORequest() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("quantity")
   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("materialInventoryId")
   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @JsonProperty("outboundTime")
   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundManufacturedVORequest)) {
         return false;
      }

      OutboundManufacturedVORequest other = (OutboundManufacturedVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundManufacturedVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundManufacturedVORequest(productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", userId="
         + this.getUserId()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", remark="
         + this.getRemark()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public static class OutboundManufacturedVORequestBuilder {
      private Long productId;
      private BigDecimal quantity;
      private Long materialInventoryId;
      private Long userId;
      private LocalDateTime outboundTime;
      private String remark;
      private Integer basicClass;

      OutboundManufacturedVORequestBuilder() {
      }

      @JsonProperty("productId")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("userId")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("outboundTime")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("remark")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("basicClass")
      public OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundManufacturedVORequest build() {
         return new OutboundManufacturedVORequest(
            this.productId, this.quantity, this.materialInventoryId, this.userId, this.outboundTime, this.remark, this.basicClass
         );
      }

      @Override
      public String toString() {
         return "OutboundManufacturedVORequest.OutboundManufacturedVORequestBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", userId="
            + this.userId
            + ", outboundTime="
            + this.outboundTime
            + ", remark="
            + this.remark
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
