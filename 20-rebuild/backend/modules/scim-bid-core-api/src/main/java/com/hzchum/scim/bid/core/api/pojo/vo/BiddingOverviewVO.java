package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;

public class BiddingOverviewVO {
   private Long projectType;
   private String typeName;
   private Integer quantity;
   private BigDecimal totalAmount;

   public static BiddingOverviewVO.BiddingOverviewVOBuilder builder() {
      return new BiddingOverviewVO.BiddingOverviewVOBuilder();
   }

   public BiddingOverviewVO() {
   }

   public BiddingOverviewVO(final Long projectType, final String typeName, final Integer quantity, final BigDecimal totalAmount) {
      this.projectType = projectType;
      this.typeName = typeName;
      this.quantity = quantity;
      this.totalAmount = totalAmount;
   }

   public Long getProjectType() {
      return this.projectType;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public void setProjectType(final Long projectType) {
      this.projectType = projectType;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingOverviewVO)) {
         return false;
      }

      BiddingOverviewVO other = (BiddingOverviewVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectType = this.getProjectType();
      Object other$projectType = other.getProjectType();
      if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$totalAmount = this.getTotalAmount();
               Object other$totalAmount = other.getTotalAmount();
               return this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount);
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
      return other instanceof BiddingOverviewVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      return result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingOverviewVO(projectType="
         + this.getProjectType()
         + ", typeName="
         + this.getTypeName()
         + ", quantity="
         + this.getQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ")";
   }

   public static class BiddingOverviewVOBuilder {
      private Long projectType;
      private String typeName;
      private Integer quantity;
      private BigDecimal totalAmount;

      BiddingOverviewVOBuilder() {
      }

      public BiddingOverviewVO.BiddingOverviewVOBuilder projectType(final Long projectType) {
         this.projectType = projectType;
         return this;
      }

      public BiddingOverviewVO.BiddingOverviewVOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public BiddingOverviewVO.BiddingOverviewVOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BiddingOverviewVO.BiddingOverviewVOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public BiddingOverviewVO build() {
         return new BiddingOverviewVO(this.projectType, this.typeName, this.quantity, this.totalAmount);
      }

      @Override
      public String toString() {
         return "BiddingOverviewVO.BiddingOverviewVOBuilder(projectType="
            + this.projectType
            + ", typeName="
            + this.typeName
            + ", quantity="
            + this.quantity
            + ", totalAmount="
            + this.totalAmount
            + ")";
      }
   }
}
