package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.wageQuota.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WageQuotaVORequest", description = "")
public class WageQuotaVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   @NotNull(message = "总工序id不能为空")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   @NotNull(message = "重量单价不能为空")
   private BigDecimal price;

   public static WageQuotaVORequest.WageQuotaVORequestBuilder builder() {
      return new WageQuotaVORequest.WageQuotaVORequestBuilder();
   }

   public WageQuotaVORequest() {
   }

   public WageQuotaVORequest(final Long id, final Long productProcessId, final Long processId, final BigDecimal price) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public WageQuotaVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public WageQuotaVORequest setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public WageQuotaVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("price")
   public WageQuotaVORequest setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "WageQuotaVORequest(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WageQuotaVORequest)) {
         return false;
      }

      WageQuotaVORequest other = (WageQuotaVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WageQuotaVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class WageQuotaVORequestBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private BigDecimal price;

      WageQuotaVORequestBuilder() {
      }

      @JsonProperty("id")
      public WageQuotaVORequest.WageQuotaVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public WageQuotaVORequest.WageQuotaVORequestBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public WageQuotaVORequest.WageQuotaVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("price")
      public WageQuotaVORequest.WageQuotaVORequestBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public WageQuotaVORequest build() {
         return new WageQuotaVORequest(this.id, this.productProcessId, this.processId, this.price);
      }

      @Override
      public String toString() {
         return "WageQuotaVORequest.WageQuotaVORequestBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", price="
            + this.price
            + ")";
      }
   }
}
