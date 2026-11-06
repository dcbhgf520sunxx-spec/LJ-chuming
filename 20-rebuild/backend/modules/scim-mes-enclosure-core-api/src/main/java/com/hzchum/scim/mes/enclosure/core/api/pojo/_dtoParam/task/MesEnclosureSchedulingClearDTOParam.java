package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureSchedulingClearDTOParam", description = "")
public class MesEnclosureSchedulingClearDTOParam {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private List<Long> productId;

   public static MesEnclosureSchedulingClearDTOParam.MesEnclosureSchedulingClearDTOParamBuilder builder() {
      return new MesEnclosureSchedulingClearDTOParam.MesEnclosureSchedulingClearDTOParamBuilder();
   }

   public MesEnclosureSchedulingClearDTOParam() {
   }

   public MesEnclosureSchedulingClearDTOParam(final List<Long> productId) {
      this.productId = productId;
   }

   public List<Long> getProductId() {
      return this.productId;
   }

   @JsonProperty("productId")
   public MesEnclosureSchedulingClearDTOParam setProductId(final List<Long> productId) {
      this.productId = productId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSchedulingClearDTOParam(productId=" + this.getProductId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSchedulingClearDTOParam)) {
         return false;
      }

      MesEnclosureSchedulingClearDTOParam other = (MesEnclosureSchedulingClearDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      return this$productId == null ? other$productId == null : this$productId.equals(other$productId);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureSchedulingClearDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      return result * 59 + ($productId == null ? 43 : $productId.hashCode());
   }

   public static class MesEnclosureSchedulingClearDTOParamBuilder {
      private List<Long> productId;

      MesEnclosureSchedulingClearDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesEnclosureSchedulingClearDTOParam.MesEnclosureSchedulingClearDTOParamBuilder productId(final List<Long> productId) {
         this.productId = productId;
         return this;
      }

      public MesEnclosureSchedulingClearDTOParam build() {
         return new MesEnclosureSchedulingClearDTOParam(this.productId);
      }

      @Override
      public String toString() {
         return "MesEnclosureSchedulingClearDTOParam.MesEnclosureSchedulingClearDTOParamBuilder(productId=" + this.productId + ")";
      }
   }
}
