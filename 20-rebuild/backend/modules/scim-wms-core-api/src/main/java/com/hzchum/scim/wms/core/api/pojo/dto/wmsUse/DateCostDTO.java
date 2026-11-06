package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class DateCostDTO {
   @ApiModelProperty(name = "dateTime", value = "日期")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   private String dateTime;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "classifyId", value = "科目名id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
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
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mete", value = "不含税总价")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "avgUnitPriceExcludingVAT", value = "平均单价")
   @JsonProperty("avgUnitPriceExcludingVAT")
   @JSONField(name = "avgUnitPriceExcludingVAT")
   private BigDecimal avgUnitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   private Long index;

   public static DateCostDTO.DateCostDTOBuilder builder() {
      return new DateCostDTO.DateCostDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAvgUnitPriceExcludingVAT() {
      return this.avgUnitPriceExcludingVAT;
   }

   public Long getIndex() {
      return this.index;
   }

   @JsonProperty("dateTime")
   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("classifyName")
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

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("avgUnitPriceExcludingVAT")
   public void setAvgUnitPriceExcludingVAT(final BigDecimal avgUnitPriceExcludingVAT) {
      this.avgUnitPriceExcludingVAT = avgUnitPriceExcludingVAT;
   }

   @JsonProperty("index")
   public void setIndex(final Long index) {
      this.index = index;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DateCostDTO)) {
         return false;
      }

      DateCostDTO other = (DateCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                     Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                     if (this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$avgUnitPriceExcludingVAT = this.getAvgUnitPriceExcludingVAT();
                           Object other$avgUnitPriceExcludingVAT = other.getAvgUnitPriceExcludingVAT();
                           return this$avgUnitPriceExcludingVAT == null
                              ? other$avgUnitPriceExcludingVAT == null
                              : this$avgUnitPriceExcludingVAT.equals(other$avgUnitPriceExcludingVAT);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DateCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $avgUnitPriceExcludingVAT = this.getAvgUnitPriceExcludingVAT();
      return result * 59 + ($avgUnitPriceExcludingVAT == null ? 43 : $avgUnitPriceExcludingVAT.hashCode());
   }

   @Override
   public String toString() {
      return "DateCostDTO(dateTime="
         + this.getDateTime()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", mete="
         + this.getMete()
         + ", avgUnitPriceExcludingVAT="
         + this.getAvgUnitPriceExcludingVAT()
         + ", index="
         + this.getIndex()
         + ")";
   }

   public DateCostDTO(
      final String dateTime,
      final Long classifyId,
      final String classifyName,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal mete,
      final BigDecimal avgUnitPriceExcludingVAT,
      final Long index
   ) {
      this.dateTime = dateTime;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.mete = mete;
      this.avgUnitPriceExcludingVAT = avgUnitPriceExcludingVAT;
      this.index = index;
   }

   public DateCostDTO() {
   }

   public static class DateCostDTOBuilder {
      private String dateTime;
      private Long classifyId;
      private String classifyName;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal mete;
      private BigDecimal avgUnitPriceExcludingVAT;
      private Long index;

      DateCostDTOBuilder() {
      }

      @JsonProperty("dateTime")
      public DateCostDTO.DateCostDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("classifyId")
      public DateCostDTO.DateCostDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public DateCostDTO.DateCostDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("amount")
      public DateCostDTO.DateCostDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVAT")
      public DateCostDTO.DateCostDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      @JsonProperty("mete")
      public DateCostDTO.DateCostDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("avgUnitPriceExcludingVAT")
      public DateCostDTO.DateCostDTOBuilder avgUnitPriceExcludingVAT(final BigDecimal avgUnitPriceExcludingVAT) {
         this.avgUnitPriceExcludingVAT = avgUnitPriceExcludingVAT;
         return this;
      }

      @JsonProperty("index")
      public DateCostDTO.DateCostDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      public DateCostDTO build() {
         return new DateCostDTO(
            this.dateTime, this.classifyId, this.classifyName, this.amount, this.amountExcludingVAT, this.mete, this.avgUnitPriceExcludingVAT, this.index
         );
      }

      @Override
      public String toString() {
         return "DateCostDTO.DateCostDTOBuilder(dateTime="
            + this.dateTime
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", mete="
            + this.mete
            + ", avgUnitPriceExcludingVAT="
            + this.avgUnitPriceExcludingVAT
            + ", index="
            + this.index
            + ")";
      }
   }
}
