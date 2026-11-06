package com.hzchum.scim.project.core.api.pojo.dtoParam.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectLaborProductDTOParam", description = "分包产品信息请求类")
public class ProjectLaborProductDTOParam {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @NotNull(message = "产品id不能为空！")
   private Long productId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @NotNull(message = "产品数量不能为空！")
   private BigDecimal quantity;

   public static ProjectLaborProductDTOParam.ProjectLaborProductDTOParamBuilder builder() {
      return new ProjectLaborProductDTOParam.ProjectLaborProductDTOParamBuilder();
   }

   public ProjectLaborProductDTOParam() {
   }

   public ProjectLaborProductDTOParam(final Long productId, final BigDecimal quantity) {
      this.productId = productId;
      this.quantity = quantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public ProjectLaborProductDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ProjectLaborProductDTOParam setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectLaborProductDTOParam(productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectLaborProductDTOParam)) {
         return false;
      } else {
         ProjectLaborProductDTOParam other = (ProjectLaborProductDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectLaborProductDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class ProjectLaborProductDTOParamBuilder {
      private Long productId;
      private BigDecimal quantity;

      ProjectLaborProductDTOParamBuilder() {
      }

      public ProjectLaborProductDTOParam.ProjectLaborProductDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectLaborProductDTOParam.ProjectLaborProductDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectLaborProductDTOParam build() {
         return new ProjectLaborProductDTOParam(this.productId, this.quantity);
      }

      @Override
      public String toString() {
         return "ProjectLaborProductDTOParam.ProjectLaborProductDTOParamBuilder(productId=" + this.productId + ", quantity=" + this.quantity + ")";
      }
   }
}
