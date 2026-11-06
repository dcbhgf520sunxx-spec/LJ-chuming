package com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "OutStaffPutRequest", description = "")
public class OutStaffPutRequest {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "班组id不能为空")
   private Long teamId;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "wage", notes = "工价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   @NotNull(message = "工价不能为空")
   private BigDecimal wage;

   public static OutStaffPutRequest.OutStaffPutRequestBuilder builder() {
      return new OutStaffPutRequest.OutStaffPutRequestBuilder();
   }

   public OutStaffPutRequest(final Long productId, final Long teamId, final Integer productType, final BigDecimal wage) {
      this.productId = productId;
      this.teamId = teamId;
      this.productType = productType;
      this.wage = wage;
   }

   public OutStaffPutRequest() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   @JsonProperty("productId")
   public OutStaffPutRequest setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("teamId")
   public OutStaffPutRequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("productType")
   public OutStaffPutRequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("wage")
   public OutStaffPutRequest setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffPutRequest(productId="
         + this.getProductId()
         + ", teamId="
         + this.getTeamId()
         + ", productType="
         + this.getProductType()
         + ", wage="
         + this.getWage()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffPutRequest)) {
         return false;
      }

      OutStaffPutRequest other = (OutStaffPutRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$wage = this.getWage();
               Object other$wage = other.getWage();
               return this$wage == null ? other$wage == null : this$wage.equals(other$wage);
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
      return other instanceof OutStaffPutRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $wage = this.getWage();
      return result * 59 + ($wage == null ? 43 : $wage.hashCode());
   }

   public static class OutStaffPutRequestBuilder {
      private Long productId;
      private Long teamId;
      private Integer productType;
      private BigDecimal wage;

      OutStaffPutRequestBuilder() {
      }

      @JsonProperty("productId")
      public OutStaffPutRequest.OutStaffPutRequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("teamId")
      public OutStaffPutRequest.OutStaffPutRequestBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("productType")
      public OutStaffPutRequest.OutStaffPutRequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("wage")
      public OutStaffPutRequest.OutStaffPutRequestBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      public OutStaffPutRequest build() {
         return new OutStaffPutRequest(this.productId, this.teamId, this.productType, this.wage);
      }

      @Override
      public String toString() {
         return "OutStaffPutRequest.OutStaffPutRequestBuilder(productId="
            + this.productId
            + ", teamId="
            + this.teamId
            + ", productType="
            + this.productType
            + ", wage="
            + this.wage
            + ")";
      }
   }
}
