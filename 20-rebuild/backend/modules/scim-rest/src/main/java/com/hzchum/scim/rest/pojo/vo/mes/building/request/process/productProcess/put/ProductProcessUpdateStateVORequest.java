package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductProcessUpdateStateVORequest", description = "")
public class ProductProcessUpdateStateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @NotNull(message = "禁用状态不能为空")
   private Boolean boolEnabledEnum;

   public static ProductProcessUpdateStateVORequest.ProductProcessUpdateStateVORequestBuilder builder() {
      return new ProductProcessUpdateStateVORequest.ProductProcessUpdateStateVORequestBuilder();
   }

   public ProductProcessUpdateStateVORequest() {
   }

   public ProductProcessUpdateStateVORequest(final Long id, final Boolean boolEnabledEnum) {
      this.id = id;
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   @JsonProperty("id")
   public ProductProcessUpdateStateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public ProductProcessUpdateStateVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProcessUpdateStateVORequest(id=" + this.getId() + ", boolEnabledEnum=" + this.getBoolEnabledEnum() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductProcessUpdateStateVORequest)) {
         return false;
      } else {
         ProductProcessUpdateStateVORequest other = (ProductProcessUpdateStateVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               return this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductProcessUpdateStateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      return result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
   }

   public static class ProductProcessUpdateStateVORequestBuilder {
      private Long id;
      private Boolean boolEnabledEnum;

      ProductProcessUpdateStateVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProductProcessUpdateStateVORequest.ProductProcessUpdateStateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public ProductProcessUpdateStateVORequest.ProductProcessUpdateStateVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      public ProductProcessUpdateStateVORequest build() {
         return new ProductProcessUpdateStateVORequest(this.id, this.boolEnabledEnum);
      }

      @Override
      public String toString() {
         return "ProductProcessUpdateStateVORequest.ProductProcessUpdateStateVORequestBuilder(id="
            + this.id
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ")";
      }
   }
}
