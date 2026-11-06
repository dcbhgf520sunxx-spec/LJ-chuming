package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ClassCostDTO {
   @ApiModelProperty(name = "basicClass", value = "科目类别")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   private Integer basicClass;
   @ApiModelProperty(name = "className", value = "科目类别名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private String className;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "amount", value = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "amountExcludingVAT", value = "不含税总价")
   @JsonProperty("amountExcludingVAT")
   @JSONField(name = "amountExcludingVAT")
   private BigDecimal amountExcludingVAT;

   public static ClassCostDTO.ClassCostDTOBuilder builder() {
      return new ClassCostDTO.ClassCostDTOBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassName() {
      return this.className;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("className")
   public void setClassName(final String className) {
      this.className = className;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("amountExcludingVAT")
   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClassCostDTO)) {
         return false;
      }

      ClassCostDTO other = (ClassCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$className = this.getClassName();
         Object other$className = other.getClassName();
         if (this$className == null ? other$className == null : this$className.equals(other$className)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountExcludingVAT = this.getAmountExcludingVAT();
               Object other$amountExcludingVAT = other.getAmountExcludingVAT();
               return this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT);
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
      return other instanceof ClassCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      return result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
   }

   @Override
   public String toString() {
      return "ClassCostDTO(basicClass="
         + this.getBasicClass()
         + ", className="
         + this.getClassName()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ")";
   }

   public ClassCostDTO(final Integer basicClass, final String className, final BigDecimal amount, final BigDecimal amountExcludingVAT) {
      this.basicClass = basicClass;
      this.className = className;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public ClassCostDTO() {
   }

   public static class ClassCostDTOBuilder {
      private Integer basicClass;
      private String className;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;

      ClassCostDTOBuilder() {
      }

      @JsonProperty("basicClass")
      public ClassCostDTO.ClassCostDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("className")
      public ClassCostDTO.ClassCostDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      @JsonProperty("amount")
      public ClassCostDTO.ClassCostDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVAT")
      public ClassCostDTO.ClassCostDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public ClassCostDTO build() {
         return new ClassCostDTO(this.basicClass, this.className, this.amount, this.amountExcludingVAT);
      }

      @Override
      public String toString() {
         return "ClassCostDTO.ClassCostDTOBuilder(basicClass="
            + this.basicClass
            + ", className="
            + this.className
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ")";
      }
   }
}
