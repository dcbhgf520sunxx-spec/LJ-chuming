package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureWageQuotaDTOParam对象", description = "")
public class MesEnclosureWageQuotaDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
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
   private BigDecimal price;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder builder() {
      return new MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder();
   }

   public MesEnclosureWageQuotaDTOParam() {
   }

   public MesEnclosureWageQuotaDTOParam(final Long id, final Long productProcessId, final Long processId, final BigDecimal price, final Long userId) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.price = price;
      this.userId = userId;
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

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesEnclosureWageQuotaDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesEnclosureWageQuotaDTOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureWageQuotaDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureWageQuotaDTOParam setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureWageQuotaDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureWageQuotaDTOParam(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", price="
         + this.getPrice()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWageQuotaDTOParam)) {
         return false;
      }

      MesEnclosureWageQuotaDTOParam other = (MesEnclosureWageQuotaDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureWageQuotaDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureWageQuotaDTOParamBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private BigDecimal price;
      private Long userId;

      MesEnclosureWageQuotaDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesEnclosureWageQuotaDTOParam build() {
         return new MesEnclosureWageQuotaDTOParam(this.id, this.productProcessId, this.processId, this.price, this.userId);
      }

      @Override
      public String toString() {
         return "MesEnclosureWageQuotaDTOParam.MesEnclosureWageQuotaDTOParamBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", price="
            + this.price
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
