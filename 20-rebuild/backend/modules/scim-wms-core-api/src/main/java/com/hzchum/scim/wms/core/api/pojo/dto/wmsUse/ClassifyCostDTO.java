package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ClassifyCostDTO {
   @ApiModelProperty(name = "classifyId", value = "科目id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   private Long classifyId;
   @ApiModelProperty(name = "className", value = "科目名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private String classifyName;
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

   public static ClassifyCostDTO.ClassifyCostDTOBuilder builder() {
      return new ClassifyCostDTO.ClassifyCostDTOBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("className")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
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

      if (!(o instanceof ClassifyCostDTO)) {
         return false;
      }

      ClassifyCostDTO other = (ClassifyCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
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
      return other instanceof ClassifyCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      return result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
   }

   @Override
   public String toString() {
      return "ClassifyCostDTO(classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ")";
   }

   public ClassifyCostDTO(final Long classifyId, final String classifyName, final BigDecimal amount, final BigDecimal amountExcludingVAT) {
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public ClassifyCostDTO() {
   }

   public static class ClassifyCostDTOBuilder {
      private Long classifyId;
      private String classifyName;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;

      ClassifyCostDTOBuilder() {
      }

      @JsonProperty("classifyId")
      public ClassifyCostDTO.ClassifyCostDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("className")
      public ClassifyCostDTO.ClassifyCostDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("amount")
      public ClassifyCostDTO.ClassifyCostDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVAT")
      public ClassifyCostDTO.ClassifyCostDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public ClassifyCostDTO build() {
         return new ClassifyCostDTO(this.classifyId, this.classifyName, this.amount, this.amountExcludingVAT);
      }

      @Override
      public String toString() {
         return "ClassifyCostDTO.ClassifyCostDTOBuilder(classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ")";
      }
   }
}
