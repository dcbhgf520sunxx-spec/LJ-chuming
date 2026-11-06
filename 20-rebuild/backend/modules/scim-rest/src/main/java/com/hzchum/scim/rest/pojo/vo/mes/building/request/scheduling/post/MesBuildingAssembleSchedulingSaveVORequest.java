package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAssembleSchedulingSaveVORequest", description = "部件排产请求类")
public class MesBuildingAssembleSchedulingSaveVORequest {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   @Min(value = 1L, message = "排产数量不能小于1")
   private Integer quantity;

   public static MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder builder() {
      return new MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder();
   }

   public MesBuildingAssembleSchedulingSaveVORequest(
      final Long productId, final Long factoryId, final Long workshopId, final Long productionLineId, final Long groupsId, final Integer quantity
   ) {
      this.productId = productId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.quantity = quantity;
   }

   public MesBuildingAssembleSchedulingSaveVORequest() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("productId")
   public MesBuildingAssembleSchedulingSaveVORequest setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingAssembleSchedulingSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingAssembleSchedulingSaveVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingAssembleSchedulingSaveVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingAssembleSchedulingSaveVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleSchedulingSaveVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleSchedulingSaveVORequest)) {
         return false;
      }

      MesBuildingAssembleSchedulingSaveVORequest other = (MesBuildingAssembleSchedulingSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesBuildingAssembleSchedulingSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSchedulingSaveVORequest(productId="
         + this.getProductId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public static class MesBuildingAssembleSchedulingSaveVORequestBuilder {
      private Long productId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Integer quantity;

      MesBuildingAssembleSchedulingSaveVORequestBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingAssembleSchedulingSaveVORequest build() {
         return new MesBuildingAssembleSchedulingSaveVORequest(
            this.productId, this.factoryId, this.workshopId, this.productionLineId, this.groupsId, this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSchedulingSaveVORequest.MesBuildingAssembleSchedulingSaveVORequestBuilder(productId="
            + this.productId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
