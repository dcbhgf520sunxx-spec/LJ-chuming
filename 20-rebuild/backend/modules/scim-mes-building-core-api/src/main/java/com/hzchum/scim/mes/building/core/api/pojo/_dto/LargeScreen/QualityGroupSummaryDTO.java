package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "年度质量事件分析对象")
public class QualityGroupSummaryDTO {
   private String levelOneName;
   private Integer quantity;

   public static QualityGroupSummaryDTO.QualityGroupSummaryDTOBuilder builder() {
      return new QualityGroupSummaryDTO.QualityGroupSummaryDTOBuilder();
   }

   public String getLevelOneName() {
      return this.levelOneName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QualityGroupSummaryDTO)) {
         return false;
      } else {
         QualityGroupSummaryDTO other = (QualityGroupSummaryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$levelOneName = this.getLevelOneName();
               Object other$levelOneName = other.getLevelOneName();
               return this$levelOneName == null ? other$levelOneName == null : this$levelOneName.equals(other$levelOneName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QualityGroupSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $levelOneName = this.getLevelOneName();
      return result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
   }

   @Override
   public String toString() {
      return "QualityGroupSummaryDTO(super=" + super.toString() + ", levelOneName=" + this.getLevelOneName() + ", quantity=" + this.getQuantity() + ")";
   }

   public QualityGroupSummaryDTO(final String levelOneName, final Integer quantity) {
      this.levelOneName = levelOneName;
      this.quantity = quantity;
   }

   public QualityGroupSummaryDTO() {
   }

   public static class QualityGroupSummaryDTOBuilder {
      private String levelOneName;
      private Integer quantity;

      QualityGroupSummaryDTOBuilder() {
      }

      public QualityGroupSummaryDTO.QualityGroupSummaryDTOBuilder levelOneName(final String levelOneName) {
         this.levelOneName = levelOneName;
         return this;
      }

      public QualityGroupSummaryDTO.QualityGroupSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public QualityGroupSummaryDTO build() {
         return new QualityGroupSummaryDTO(this.levelOneName, this.quantity);
      }

      @Override
      public String toString() {
         return "QualityGroupSummaryDTO.QualityGroupSummaryDTOBuilder(levelOneName=" + this.levelOneName + ", quantity=" + this.quantity + ")";
      }
   }
}
