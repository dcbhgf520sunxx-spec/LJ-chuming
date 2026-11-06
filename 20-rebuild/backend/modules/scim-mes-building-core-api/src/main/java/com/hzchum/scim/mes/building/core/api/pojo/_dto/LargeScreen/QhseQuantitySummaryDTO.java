package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "年度质量事件分析")
public class QhseQuantitySummaryDTO {
   @ApiModelProperty("一级分类名称")
   private String levelOneTypeName;
   @ApiModelProperty("问题数")
   private Integer qhseQuantity;

   public static QhseQuantitySummaryDTO.QhseQuantitySummaryDTOBuilder builder() {
      return new QhseQuantitySummaryDTO.QhseQuantitySummaryDTOBuilder();
   }

   public String getLevelOneTypeName() {
      return this.levelOneTypeName;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public void setLevelOneTypeName(final String levelOneTypeName) {
      this.levelOneTypeName = levelOneTypeName;
   }

   public void setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QhseQuantitySummaryDTO)) {
         return false;
      } else {
         QhseQuantitySummaryDTO other = (QhseQuantitySummaryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$qhseQuantity = this.getQhseQuantity();
            Object other$qhseQuantity = other.getQhseQuantity();
            if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
               Object this$levelOneTypeName = this.getLevelOneTypeName();
               Object other$levelOneTypeName = other.getLevelOneTypeName();
               return this$levelOneTypeName == null ? other$levelOneTypeName == null : this$levelOneTypeName.equals(other$levelOneTypeName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseQuantitySummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $levelOneTypeName = this.getLevelOneTypeName();
      return result * 59 + ($levelOneTypeName == null ? 43 : $levelOneTypeName.hashCode());
   }

   @Override
   public String toString() {
      return "QhseQuantitySummaryDTO(super="
         + super.toString()
         + ", levelOneTypeName="
         + this.getLevelOneTypeName()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   public QhseQuantitySummaryDTO(final String levelOneTypeName, final Integer qhseQuantity) {
      this.levelOneTypeName = levelOneTypeName;
      this.qhseQuantity = qhseQuantity;
   }

   public QhseQuantitySummaryDTO() {
   }

   public static class QhseQuantitySummaryDTOBuilder {
      private String levelOneTypeName;
      private Integer qhseQuantity;

      QhseQuantitySummaryDTOBuilder() {
      }

      public QhseQuantitySummaryDTO.QhseQuantitySummaryDTOBuilder levelOneTypeName(final String levelOneTypeName) {
         this.levelOneTypeName = levelOneTypeName;
         return this;
      }

      public QhseQuantitySummaryDTO.QhseQuantitySummaryDTOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public QhseQuantitySummaryDTO build() {
         return new QhseQuantitySummaryDTO(this.levelOneTypeName, this.qhseQuantity);
      }

      @Override
      public String toString() {
         return "QhseQuantitySummaryDTO.QhseQuantitySummaryDTOBuilder(levelOneTypeName=" + this.levelOneTypeName + ", qhseQuantity=" + this.qhseQuantity + ")";
      }
   }
}
