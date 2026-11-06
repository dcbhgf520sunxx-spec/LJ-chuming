package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureMachinePartSchedulingLinkDTOParam", description = "零件排产信息")
public class MesEnclosureMachinePartSchedulingLinkDTOParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   private Integer quantity;
   @ApiModelProperty(name = "needSchedulingMonth", value = "零件需要排产的日期")
   @JsonProperty("needSchedulingMonth")
   @JSONField(name = "needSchedulingMonth")
   @NotNull(message = "零件需要排产的日期")
   private LocalDateTime needSchedulingMonth;

   public static MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder builder() {
      return new MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder();
   }

   public MesEnclosureMachinePartSchedulingLinkDTOParam(final Long id, final Long productId, final Integer quantity, final LocalDateTime needSchedulingMonth) {
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.needSchedulingMonth = needSchedulingMonth;
   }

   public MesEnclosureMachinePartSchedulingLinkDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getNeedSchedulingMonth() {
      return this.needSchedulingMonth;
   }

   @JsonProperty("id")
   public MesEnclosureMachinePartSchedulingLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureMachinePartSchedulingLinkDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureMachinePartSchedulingLinkDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("needSchedulingMonth")
   public MesEnclosureMachinePartSchedulingLinkDTOParam setNeedSchedulingMonth(final LocalDateTime needSchedulingMonth) {
      this.needSchedulingMonth = needSchedulingMonth;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartSchedulingLinkDTOParam(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", needSchedulingMonth="
         + this.getNeedSchedulingMonth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartSchedulingLinkDTOParam)) {
         return false;
      }

      MesEnclosureMachinePartSchedulingLinkDTOParam other = (MesEnclosureMachinePartSchedulingLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$needSchedulingMonth = this.getNeedSchedulingMonth();
               Object other$needSchedulingMonth = other.getNeedSchedulingMonth();
               return this$needSchedulingMonth == null ? other$needSchedulingMonth == null : this$needSchedulingMonth.equals(other$needSchedulingMonth);
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
      return other instanceof MesEnclosureMachinePartSchedulingLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $needSchedulingMonth = this.getNeedSchedulingMonth();
      return result * 59 + ($needSchedulingMonth == null ? 43 : $needSchedulingMonth.hashCode());
   }

   public static class MesEnclosureMachinePartSchedulingLinkDTOParamBuilder {
      private Long id;
      private Long productId;
      private Integer quantity;
      private LocalDateTime needSchedulingMonth;

      MesEnclosureMachinePartSchedulingLinkDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("needSchedulingMonth")
      public MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder needSchedulingMonth(
         final LocalDateTime needSchedulingMonth
      ) {
         this.needSchedulingMonth = needSchedulingMonth;
         return this;
      }

      public MesEnclosureMachinePartSchedulingLinkDTOParam build() {
         return new MesEnclosureMachinePartSchedulingLinkDTOParam(this.id, this.productId, this.quantity, this.needSchedulingMonth);
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartSchedulingLinkDTOParam.MesEnclosureMachinePartSchedulingLinkDTOParamBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", needSchedulingMonth="
            + this.needSchedulingMonth
            + ")";
      }
   }
}
