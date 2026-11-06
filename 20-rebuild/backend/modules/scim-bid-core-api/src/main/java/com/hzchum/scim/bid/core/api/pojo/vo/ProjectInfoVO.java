package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;

public class ProjectInfoVO {
   private Integer inviteNum;
   private Integer tickSizeNum;
   private Integer winBidNum;
   private BigDecimal bidAmounts;
   private Integer inviteNumAndMonth;
   private Integer tickSizeNumAndMonth;
   private Integer winBidNumAndMonth;

   public static ProjectInfoVO.ProjectInfoVOBuilder builder() {
      return new ProjectInfoVO.ProjectInfoVOBuilder();
   }

   public Integer getInviteNum() {
      return this.inviteNum;
   }

   public Integer getTickSizeNum() {
      return this.tickSizeNum;
   }

   public Integer getWinBidNum() {
      return this.winBidNum;
   }

   public BigDecimal getBidAmounts() {
      return this.bidAmounts;
   }

   public Integer getInviteNumAndMonth() {
      return this.inviteNumAndMonth;
   }

   public Integer getTickSizeNumAndMonth() {
      return this.tickSizeNumAndMonth;
   }

   public Integer getWinBidNumAndMonth() {
      return this.winBidNumAndMonth;
   }

   public void setInviteNum(final Integer inviteNum) {
      this.inviteNum = inviteNum;
   }

   public void setTickSizeNum(final Integer tickSizeNum) {
      this.tickSizeNum = tickSizeNum;
   }

   public void setWinBidNum(final Integer winBidNum) {
      this.winBidNum = winBidNum;
   }

   public void setBidAmounts(final BigDecimal bidAmounts) {
      this.bidAmounts = bidAmounts;
   }

   public void setInviteNumAndMonth(final Integer inviteNumAndMonth) {
      this.inviteNumAndMonth = inviteNumAndMonth;
   }

   public void setTickSizeNumAndMonth(final Integer tickSizeNumAndMonth) {
      this.tickSizeNumAndMonth = tickSizeNumAndMonth;
   }

   public void setWinBidNumAndMonth(final Integer winBidNumAndMonth) {
      this.winBidNumAndMonth = winBidNumAndMonth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInfoVO)) {
         return false;
      }

      ProjectInfoVO other = (ProjectInfoVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inviteNum = this.getInviteNum();
      Object other$inviteNum = other.getInviteNum();
      if (this$inviteNum == null ? other$inviteNum == null : this$inviteNum.equals(other$inviteNum)) {
         Object this$tickSizeNum = this.getTickSizeNum();
         Object other$tickSizeNum = other.getTickSizeNum();
         if (this$tickSizeNum == null ? other$tickSizeNum == null : this$tickSizeNum.equals(other$tickSizeNum)) {
            Object this$winBidNum = this.getWinBidNum();
            Object other$winBidNum = other.getWinBidNum();
            if (this$winBidNum == null ? other$winBidNum == null : this$winBidNum.equals(other$winBidNum)) {
               Object this$inviteNumAndMonth = this.getInviteNumAndMonth();
               Object other$inviteNumAndMonth = other.getInviteNumAndMonth();
               if (this$inviteNumAndMonth == null ? other$inviteNumAndMonth == null : this$inviteNumAndMonth.equals(other$inviteNumAndMonth)) {
                  Object this$tickSizeNumAndMonth = this.getTickSizeNumAndMonth();
                  Object other$tickSizeNumAndMonth = other.getTickSizeNumAndMonth();
                  if (this$tickSizeNumAndMonth == null ? other$tickSizeNumAndMonth == null : this$tickSizeNumAndMonth.equals(other$tickSizeNumAndMonth)) {
                     Object this$winBidNumAndMonth = this.getWinBidNumAndMonth();
                     Object other$winBidNumAndMonth = other.getWinBidNumAndMonth();
                     if (this$winBidNumAndMonth == null ? other$winBidNumAndMonth == null : this$winBidNumAndMonth.equals(other$winBidNumAndMonth)) {
                        Object this$bidAmounts = this.getBidAmounts();
                        Object other$bidAmounts = other.getBidAmounts();
                        return this$bidAmounts == null ? other$bidAmounts == null : this$bidAmounts.equals(other$bidAmounts);
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
      return other instanceof ProjectInfoVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inviteNum = this.getInviteNum();
      result = result * 59 + ($inviteNum == null ? 43 : $inviteNum.hashCode());
      Object $tickSizeNum = this.getTickSizeNum();
      result = result * 59 + ($tickSizeNum == null ? 43 : $tickSizeNum.hashCode());
      Object $winBidNum = this.getWinBidNum();
      result = result * 59 + ($winBidNum == null ? 43 : $winBidNum.hashCode());
      Object $inviteNumAndMonth = this.getInviteNumAndMonth();
      result = result * 59 + ($inviteNumAndMonth == null ? 43 : $inviteNumAndMonth.hashCode());
      Object $tickSizeNumAndMonth = this.getTickSizeNumAndMonth();
      result = result * 59 + ($tickSizeNumAndMonth == null ? 43 : $tickSizeNumAndMonth.hashCode());
      Object $winBidNumAndMonth = this.getWinBidNumAndMonth();
      result = result * 59 + ($winBidNumAndMonth == null ? 43 : $winBidNumAndMonth.hashCode());
      Object $bidAmounts = this.getBidAmounts();
      return result * 59 + ($bidAmounts == null ? 43 : $bidAmounts.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInfoVO(inviteNum="
         + this.getInviteNum()
         + ", tickSizeNum="
         + this.getTickSizeNum()
         + ", winBidNum="
         + this.getWinBidNum()
         + ", bidAmounts="
         + this.getBidAmounts()
         + ", inviteNumAndMonth="
         + this.getInviteNumAndMonth()
         + ", tickSizeNumAndMonth="
         + this.getTickSizeNumAndMonth()
         + ", winBidNumAndMonth="
         + this.getWinBidNumAndMonth()
         + ")";
   }

   public ProjectInfoVO() {
   }

   public ProjectInfoVO(
      final Integer inviteNum,
      final Integer tickSizeNum,
      final Integer winBidNum,
      final BigDecimal bidAmounts,
      final Integer inviteNumAndMonth,
      final Integer tickSizeNumAndMonth,
      final Integer winBidNumAndMonth
   ) {
      this.inviteNum = inviteNum;
      this.tickSizeNum = tickSizeNum;
      this.winBidNum = winBidNum;
      this.bidAmounts = bidAmounts;
      this.inviteNumAndMonth = inviteNumAndMonth;
      this.tickSizeNumAndMonth = tickSizeNumAndMonth;
      this.winBidNumAndMonth = winBidNumAndMonth;
   }

   public static class ProjectInfoVOBuilder {
      private Integer inviteNum;
      private Integer tickSizeNum;
      private Integer winBidNum;
      private BigDecimal bidAmounts;
      private Integer inviteNumAndMonth;
      private Integer tickSizeNumAndMonth;
      private Integer winBidNumAndMonth;

      ProjectInfoVOBuilder() {
      }

      public ProjectInfoVO.ProjectInfoVOBuilder inviteNum(final Integer inviteNum) {
         this.inviteNum = inviteNum;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder tickSizeNum(final Integer tickSizeNum) {
         this.tickSizeNum = tickSizeNum;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder winBidNum(final Integer winBidNum) {
         this.winBidNum = winBidNum;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder bidAmounts(final BigDecimal bidAmounts) {
         this.bidAmounts = bidAmounts;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder inviteNumAndMonth(final Integer inviteNumAndMonth) {
         this.inviteNumAndMonth = inviteNumAndMonth;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder tickSizeNumAndMonth(final Integer tickSizeNumAndMonth) {
         this.tickSizeNumAndMonth = tickSizeNumAndMonth;
         return this;
      }

      public ProjectInfoVO.ProjectInfoVOBuilder winBidNumAndMonth(final Integer winBidNumAndMonth) {
         this.winBidNumAndMonth = winBidNumAndMonth;
         return this;
      }

      public ProjectInfoVO build() {
         return new ProjectInfoVO(
            this.inviteNum, this.tickSizeNum, this.winBidNum, this.bidAmounts, this.inviteNumAndMonth, this.tickSizeNumAndMonth, this.winBidNumAndMonth
         );
      }

      @Override
      public String toString() {
         return "ProjectInfoVO.ProjectInfoVOBuilder(inviteNum="
            + this.inviteNum
            + ", tickSizeNum="
            + this.tickSizeNum
            + ", winBidNum="
            + this.winBidNum
            + ", bidAmounts="
            + this.bidAmounts
            + ", inviteNumAndMonth="
            + this.inviteNumAndMonth
            + ", tickSizeNumAndMonth="
            + this.tickSizeNumAndMonth
            + ", winBidNumAndMonth="
            + this.winBidNumAndMonth
            + ")";
      }
   }
}
