package com.hzchum.scim.rest.pojo.vo.mes.building.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingSchedulingClearVORequest", description = "")
public class MesBuildingSchedulingClearVORequest {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private List<Long> productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static MesBuildingSchedulingClearVORequest.MesBuildingSchedulingClearVORequestBuilder builder() {
      return new MesBuildingSchedulingClearVORequest.MesBuildingSchedulingClearVORequestBuilder();
   }

   public MesBuildingSchedulingClearVORequest() {
   }

   public MesBuildingSchedulingClearVORequest(final List<Long> productId, final Integer productType) {
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
   public MesBuildingSchedulingClearVORequest setProductId(final List<Long> productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingSchedulingClearVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingClearVORequest(productId=" + this.getProductId() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingSchedulingClearVORequest)) {
         return false;
      } else {
         MesBuildingSchedulingClearVORequest other = (MesBuildingSchedulingClearVORequest)o;
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
      return other instanceof MesBuildingSchedulingClearVORequest;
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

   public static class MesBuildingSchedulingClearVORequestBuilder {
      private List<Long> productId;
      private Integer productType;

      MesBuildingSchedulingClearVORequestBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingSchedulingClearVORequest.MesBuildingSchedulingClearVORequestBuilder productId(final List<Long> productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingSchedulingClearVORequest.MesBuildingSchedulingClearVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingSchedulingClearVORequest build() {
         return new MesBuildingSchedulingClearVORequest(this.productId, this.productType);
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingClearVORequest.MesBuildingSchedulingClearVORequestBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
