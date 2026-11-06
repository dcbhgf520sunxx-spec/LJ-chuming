package com.hzchum.scim.mes.building.core.api.pojo._do.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingSchedulingProductionLineDTO", description = "分配生产线详情")
public class MesBuildingSchedulingProductionLineDO {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Integer productionLineId;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", notes = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "排产总数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "已下发总数量")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;

   public static MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder builder() {
      return new MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder();
   }

   public MesBuildingSchedulingProductionLineDO() {
   }

   public MesBuildingSchedulingProductionLineDO(
      final Long productId,
      final Integer productionLineId,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final Integer totalSchedulingQuantity,
      final Integer totalTaskQuantity
   ) {
      this.productId = productId;
      this.productionLineId = productionLineId;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   @JsonProperty("productId")
   public MesBuildingSchedulingProductionLineDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingSchedulingProductionLineDO setProductionLineId(final Integer productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesBuildingSchedulingProductionLineDO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MesBuildingSchedulingProductionLineDO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MesBuildingSchedulingProductionLineDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingSchedulingProductionLineDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingProductionLineDO(productId="
         + this.getProductId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSchedulingProductionLineDO)) {
         return false;
      }

      MesBuildingSchedulingProductionLineDO other = (MesBuildingSchedulingProductionLineDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$usedQuantity = this.getUsedQuantity();
               Object other$usedQuantity = other.getUsedQuantity();
               if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                  Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                  Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                  if (this$totalSchedulingQuantity == null
                     ? other$totalSchedulingQuantity == null
                     : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                     Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                     Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                     return this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity);
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
      return other instanceof MesBuildingSchedulingProductionLineDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      return result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
   }

   public static class MesBuildingSchedulingProductionLineDOBuilder {
      private Long productId;
      private Integer productionLineId;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;

      MesBuildingSchedulingProductionLineDOBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder productionLineId(final Integer productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      public MesBuildingSchedulingProductionLineDO build() {
         return new MesBuildingSchedulingProductionLineDO(
            this.productId, this.productionLineId, this.producedQuantity, this.usedQuantity, this.totalSchedulingQuantity, this.totalTaskQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingProductionLineDO.MesBuildingSchedulingProductionLineDOBuilder(productId="
            + this.productId
            + ", productionLineId="
            + this.productionLineId
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ")";
      }
   }
}
