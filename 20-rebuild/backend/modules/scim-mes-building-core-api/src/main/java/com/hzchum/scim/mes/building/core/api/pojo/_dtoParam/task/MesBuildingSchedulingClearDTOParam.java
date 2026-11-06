package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingSchedulingClearDTOParam", description = "")
public class MesBuildingSchedulingClearDTOParam {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private List<Long> productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static MesBuildingSchedulingClearDTOParam.MesBuildingSchedulingClearDTOParamBuilder builder() {
      return new MesBuildingSchedulingClearDTOParam.MesBuildingSchedulingClearDTOParamBuilder();
   }

   public MesBuildingSchedulingClearDTOParam() {
   }

   public MesBuildingSchedulingClearDTOParam(final List<Long> productId, final Integer productType) {
      this.productId = productId;
      this.productType = productType;
   }

   public List<Long> getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   @JsonProperty("productId")
   public MesBuildingSchedulingClearDTOParam setProductId(final List<Long> productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingSchedulingClearDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingClearDTOParam(productId=" + this.getProductId() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingSchedulingClearDTOParam)) {
         return false;
      } else {
         MesBuildingSchedulingClearDTOParam other = (MesBuildingSchedulingClearDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               return this$productId == null ? other$productId == null : this$productId.equals(other$productId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSchedulingClearDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      return result * 59 + ($productId == null ? 43 : $productId.hashCode());
   }

   public static class MesBuildingSchedulingClearDTOParamBuilder {
      private List<Long> productId;
      private Integer productType;

      MesBuildingSchedulingClearDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingSchedulingClearDTOParam.MesBuildingSchedulingClearDTOParamBuilder productId(final List<Long> productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingSchedulingClearDTOParam.MesBuildingSchedulingClearDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingSchedulingClearDTOParam build() {
         return new MesBuildingSchedulingClearDTOParam(this.productId, this.productType);
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingClearDTOParam.MesBuildingSchedulingClearDTOParamBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
