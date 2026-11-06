package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureSchedulingClearVORequest", description = "")
public class MesEnclosureSchedulingClearVORequest {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private List<Long> productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static MesEnclosureSchedulingClearVORequest.MesEnclosureSchedulingClearVORequestBuilder builder() {
      return new MesEnclosureSchedulingClearVORequest.MesEnclosureSchedulingClearVORequestBuilder();
   }

   public MesEnclosureSchedulingClearVORequest() {
   }

   public MesEnclosureSchedulingClearVORequest(final List<Long> productId, final Integer productType) {
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
   public MesEnclosureSchedulingClearVORequest setProductId(final List<Long> productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureSchedulingClearVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSchedulingClearVORequest(productId=" + this.getProductId() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureSchedulingClearVORequest)) {
         return false;
      } else {
         MesEnclosureSchedulingClearVORequest other = (MesEnclosureSchedulingClearVORequest)o;
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
      return other instanceof MesEnclosureSchedulingClearVORequest;
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

   public static class MesEnclosureSchedulingClearVORequestBuilder {
      private List<Long> productId;
      private Integer productType;

      MesEnclosureSchedulingClearVORequestBuilder() {
      }

      @JsonProperty("productId")
      public MesEnclosureSchedulingClearVORequest.MesEnclosureSchedulingClearVORequestBuilder productId(final List<Long> productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureSchedulingClearVORequest.MesEnclosureSchedulingClearVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesEnclosureSchedulingClearVORequest build() {
         return new MesEnclosureSchedulingClearVORequest(this.productId, this.productType);
      }

      @Override
      public String toString() {
         return "MesEnclosureSchedulingClearVORequest.MesEnclosureSchedulingClearVORequestBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
