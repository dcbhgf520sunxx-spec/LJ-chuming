package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MonthInventoryCostDTO {
   @ApiModelProperty(name = "index", value = "序号")
   @JsonInclude(Include.NON_NULL)
   private String index;
   @ApiModelProperty(name = "className", value = "类别")
   private String className;
   @ApiModelProperty(name = "amountExcludingVAT", value = "不含税金额")
   private BigDecimal amountExcludingVAT;
   @ApiModelProperty(name = "isTitle", value = "是否是标题")
   @JsonInclude(Include.NON_NULL)
   private Boolean isTitle;
   @ApiModelProperty("占比")
   private BigDecimal ratio;

   public static MonthInventoryCostDTO.MonthInventoryCostDTOBuilder builder() {
      return new MonthInventoryCostDTO.MonthInventoryCostDTOBuilder();
   }

   public String getIndex() {
      return this.index;
   }

   public String getClassName() {
      return this.className;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public Boolean getIsTitle() {
      return this.isTitle;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public void setIndex(final String index) {
      this.index = index;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setIsTitle(final Boolean isTitle) {
      this.isTitle = isTitle;
   }

   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthInventoryCostDTO)) {
         return false;
      }

      MonthInventoryCostDTO other = (MonthInventoryCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isTitle = this.getIsTitle();
      Object other$isTitle = other.getIsTitle();
      if (this$isTitle == null ? other$isTitle == null : this$isTitle.equals(other$isTitle)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$className = this.getClassName();
            Object other$className = other.getClassName();
            if (this$className == null ? other$className == null : this$className.equals(other$className)) {
               Object this$amountExcludingVAT = this.getAmountExcludingVAT();
               Object other$amountExcludingVAT = other.getAmountExcludingVAT();
               if (this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                  Object this$ratio = this.getRatio();
                  Object other$ratio = other.getRatio();
                  return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
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
      return other instanceof MonthInventoryCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isTitle = this.getIsTitle();
      result = result * 59 + ($isTitle == null ? 43 : $isTitle.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "MonthInventoryCostDTO(index="
         + this.getIndex()
         + ", className="
         + this.getClassName()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", isTitle="
         + this.getIsTitle()
         + ", ratio="
         + this.getRatio()
         + ")";
   }

   public MonthInventoryCostDTO(final String index, final String className, final BigDecimal amountExcludingVAT, final Boolean isTitle, final BigDecimal ratio) {
      this.index = index;
      this.className = className;
      this.amountExcludingVAT = amountExcludingVAT;
      this.isTitle = isTitle;
      this.ratio = ratio;
   }

   public MonthInventoryCostDTO() {
   }

   public static class MonthInventoryCostDTOBuilder {
      private String index;
      private String className;
      private BigDecimal amountExcludingVAT;
      private Boolean isTitle;
      private BigDecimal ratio;

      MonthInventoryCostDTOBuilder() {
      }

      public MonthInventoryCostDTO.MonthInventoryCostDTOBuilder index(final String index) {
         this.index = index;
         return this;
      }

      public MonthInventoryCostDTO.MonthInventoryCostDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      public MonthInventoryCostDTO.MonthInventoryCostDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public MonthInventoryCostDTO.MonthInventoryCostDTOBuilder isTitle(final Boolean isTitle) {
         this.isTitle = isTitle;
         return this;
      }

      public MonthInventoryCostDTO.MonthInventoryCostDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public MonthInventoryCostDTO build() {
         return new MonthInventoryCostDTO(this.index, this.className, this.amountExcludingVAT, this.isTitle, this.ratio);
      }

      @Override
      public String toString() {
         return "MonthInventoryCostDTO.MonthInventoryCostDTOBuilder(index="
            + this.index
            + ", className="
            + this.className
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", isTitle="
            + this.isTitle
            + ", ratio="
            + this.ratio
            + ")";
      }
   }
}
