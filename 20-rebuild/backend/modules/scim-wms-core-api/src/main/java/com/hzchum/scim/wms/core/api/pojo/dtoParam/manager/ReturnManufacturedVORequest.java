package com.hzchum.scim.wms.core.api.pojo.dtoParam.manager;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ReturnManufacturedVORequest", description = "产品退库请求类")
public class ReturnManufacturedVORequest {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "退库数量", notes = "退库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "退库数量数量不能为空")
   @Min(value = 1L, message = "退库数量数量不能小于1")
   private BigDecimal quantity;
   @ApiModelProperty(name = "materialInventoryId", value = "制成品库存ID", notes = "制成品库存ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @NotNull(message = "制成品库存ID不能为空")
   private Long materialInventoryId;
   @ApiModelProperty(name = "userId", value = "退库人ID", notes = "退库人ID")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @NotNull(message = "退库人ID不能为空")
   private Long userId;
   @ApiModelProperty(name = "returnTime", value = "退库时间", notes = "退库时间")
   @JsonProperty("returnTime")
   @JSONField(name = "returnTime")
   private LocalDateTime returnTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "basicClass", value = "基础物料类型", notes = "基础物料类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   private Integer basicClass;

   public static ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder builder() {
      return new ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder();
   }

   public ReturnManufacturedVORequest(
      final Long productId,
      final BigDecimal quantity,
      final Long materialInventoryId,
      final Long userId,
      final LocalDateTime returnTime,
      final String remark,
      final Integer basicClass
   ) {
      this.productId = productId;
      this.quantity = quantity;
      this.materialInventoryId = materialInventoryId;
      this.userId = userId;
      this.returnTime = returnTime;
      this.remark = remark;
      this.basicClass = basicClass;
   }

   public ReturnManufacturedVORequest() {
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

   public LocalDateTime getReturnTime() {
      return this.returnTime;
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

   @JsonProperty("returnTime")
   public void setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
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

      if (!(o instanceof ReturnManufacturedVORequest)) {
         return false;
      }

      ReturnManufacturedVORequest other = (ReturnManufacturedVORequest)o;
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
                     Object this$returnTime = this.getReturnTime();
                     Object other$returnTime = other.getReturnTime();
                     if (this$returnTime == null ? other$returnTime == null : this$returnTime.equals(other$returnTime)) {
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
      return other instanceof ReturnManufacturedVORequest;
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
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnManufacturedVORequest(productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", userId="
         + this.getUserId()
         + ", returnTime="
         + this.getReturnTime()
         + ", remark="
         + this.getRemark()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public static class ReturnManufacturedVORequestBuilder {
      private Long productId;
      private BigDecimal quantity;
      private Long materialInventoryId;
      private Long userId;
      private LocalDateTime returnTime;
      private String remark;
      private Integer basicClass;

      ReturnManufacturedVORequestBuilder() {
      }

      @JsonProperty("productId")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("userId")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("returnTime")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      @JsonProperty("remark")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("basicClass")
      public ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnManufacturedVORequest build() {
         return new ReturnManufacturedVORequest(
            this.productId, this.quantity, this.materialInventoryId, this.userId, this.returnTime, this.remark, this.basicClass
         );
      }

      @Override
      public String toString() {
         return "ReturnManufacturedVORequest.ReturnManufacturedVORequestBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", userId="
            + this.userId
            + ", returnTime="
            + this.returnTime
            + ", remark="
            + this.remark
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
