package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ReportDataDTO {
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "类型")
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "boolenQhse", value = "是否通过 1未通过 2通过")
   private Integer boolenQhse;
   @ApiModelProperty(name = "userId", value = "用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名")
   private String userName;
   @ApiModelProperty(name = "weight", value = "重量")
   private BigDecimal weight;

   public static ReportDataDTO.ReportDataDTOBuilder builder() {
      return new ReportDataDTO.ReportDataDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getBoolenQhse() {
      return this.boolenQhse;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setBoolenQhse(final Integer boolenQhse) {
      this.boolenQhse = boolenQhse;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportDataDTO)) {
         return false;
      }

      ReportDataDTO other = (ReportDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$boolenQhse = this.getBoolenQhse();
               Object other$boolenQhse = other.getBoolenQhse();
               if (this$boolenQhse == null ? other$boolenQhse == null : this$boolenQhse.equals(other$boolenQhse)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$weight = this.getWeight();
                        Object other$weight = other.getWeight();
                        return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReportDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolenQhse = this.getBoolenQhse();
      result = result * 59 + ($boolenQhse == null ? 43 : $boolenQhse.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "ReportDataDTO(productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", boolenQhse="
         + this.getBoolenQhse()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   public ReportDataDTO(
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final Integer boolenQhse,
      final Long userId,
      final String userName,
      final BigDecimal weight
   ) {
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.boolenQhse = boolenQhse;
      this.userId = userId;
      this.userName = userName;
      this.weight = weight;
   }

   public ReportDataDTO() {
   }

   public static class ReportDataDTOBuilder {
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private Integer boolenQhse;
      private Long userId;
      private String userName;
      private BigDecimal weight;

      ReportDataDTOBuilder() {
      }

      public ReportDataDTO.ReportDataDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder boolenQhse(final Integer boolenQhse) {
         this.boolenQhse = boolenQhse;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ReportDataDTO.ReportDataDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ReportDataDTO build() {
         return new ReportDataDTO(this.productId, this.productType, this.quantity, this.boolenQhse, this.userId, this.userName, this.weight);
      }

      @Override
      public String toString() {
         return "ReportDataDTO.ReportDataDTOBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", boolenQhse="
            + this.boolenQhse
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
