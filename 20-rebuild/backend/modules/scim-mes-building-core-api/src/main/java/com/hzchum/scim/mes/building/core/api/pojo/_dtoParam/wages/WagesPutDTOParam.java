package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WagesRequest", description = "")
public class WagesPutDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static WagesPutDTOParam.WagesPutDTOParamBuilder builder() {
      return new WagesPutDTOParam.WagesPutDTOParamBuilder();
   }

   public WagesPutDTOParam(
      final Long projectId, final Long monomerId, final Long productProcessId, final Long processId, final Integer productType, final BigDecimal price
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.productType = productType;
      this.price = price;
   }

   public WagesPutDTOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("projectId")
   public WagesPutDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public WagesPutDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productProcessId")
   public WagesPutDTOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public WagesPutDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productType")
   public WagesPutDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("price")
   public WagesPutDTOParam setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "WagesPutDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", productType="
         + this.getProductType()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WagesPutDTOParam)) {
         return false;
      }

      WagesPutDTOParam other = (WagesPutDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productProcessId = this.getProductProcessId();
            Object other$productProcessId = other.getProductProcessId();
            if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof WagesPutDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class WagesPutDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long productProcessId;
      private Long processId;
      private Integer productType;
      private BigDecimal price;

      WagesPutDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public WagesPutDTOParam.WagesPutDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public WagesPutDTOParam.WagesPutDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productProcessId")
      public WagesPutDTOParam.WagesPutDTOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public WagesPutDTOParam.WagesPutDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productType")
      public WagesPutDTOParam.WagesPutDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("price")
      public WagesPutDTOParam.WagesPutDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public WagesPutDTOParam build() {
         return new WagesPutDTOParam(this.projectId, this.monomerId, this.productProcessId, this.processId, this.productType, this.price);
      }

      @Override
      public String toString() {
         return "WagesPutDTOParam.WagesPutDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", productType="
            + this.productType
            + ", price="
            + this.price
            + ")";
      }
   }
}
