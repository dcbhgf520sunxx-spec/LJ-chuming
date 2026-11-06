package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("材料出入库费用信息")
public class MaterialOutInCostDTO {
   @ApiModelProperty(name = "yearMonth", value = "出/入日期")
   private String dateTime;
   @ApiModelProperty(name = "totalCost", value = "出库")
   private BigDecimal outCost;
   @ApiModelProperty(name = "totalCost", value = "入库")
   private BigDecimal inCost;
   @ApiModelProperty(name = "ratio", value = "周转率")
   private BigDecimal ratio;
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   @JsonInclude(Include.NON_NULL)
   private Long index;

   public static MaterialOutInCostDTO.MaterialOutInCostDTOBuilder builder() {
      return new MaterialOutInCostDTO.MaterialOutInCostDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getOutCost() {
      return this.outCost;
   }

   public BigDecimal getInCost() {
      return this.inCost;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public Long getIndex() {
      return this.index;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setOutCost(final BigDecimal outCost) {
      this.outCost = outCost;
   }

   public void setInCost(final BigDecimal inCost) {
      this.inCost = inCost;
   }

   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
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

      if (!(o instanceof MaterialOutInCostDTO)) {
         return false;
      }

      MaterialOutInCostDTO other = (MaterialOutInCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$index = this.getIndex();
      Object other$index = other.getIndex();
      if (this$index == null ? other$index == null : this$index.equals(other$index)) {
         Object this$dateTime = this.getDateTime();
         Object other$dateTime = other.getDateTime();
         if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
            Object this$outCost = this.getOutCost();
            Object other$outCost = other.getOutCost();
            if (this$outCost == null ? other$outCost == null : this$outCost.equals(other$outCost)) {
               Object this$inCost = this.getInCost();
               Object other$inCost = other.getInCost();
               if (this$inCost == null ? other$inCost == null : this$inCost.equals(other$inCost)) {
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
      return other instanceof MaterialOutInCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $outCost = this.getOutCost();
      result = result * 59 + ($outCost == null ? 43 : $outCost.hashCode());
      Object $inCost = this.getInCost();
      result = result * 59 + ($inCost == null ? 43 : $inCost.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialOutInCostDTO(dateTime="
         + this.getDateTime()
         + ", outCost="
         + this.getOutCost()
         + ", inCost="
         + this.getInCost()
         + ", ratio="
         + this.getRatio()
         + ", index="
         + this.getIndex()
         + ")";
   }

   public MaterialOutInCostDTO(final String dateTime, final BigDecimal outCost, final BigDecimal inCost, final BigDecimal ratio, final Long index) {
      this.dateTime = dateTime;
      this.outCost = outCost;
      this.inCost = inCost;
      this.ratio = ratio;
      this.index = index;
   }

   public MaterialOutInCostDTO() {
   }

   public static class MaterialOutInCostDTOBuilder {
      private String dateTime;
      private BigDecimal outCost;
      private BigDecimal inCost;
      private BigDecimal ratio;
      private Long index;

      MaterialOutInCostDTOBuilder() {
      }

      public MaterialOutInCostDTO.MaterialOutInCostDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public MaterialOutInCostDTO.MaterialOutInCostDTOBuilder outCost(final BigDecimal outCost) {
         this.outCost = outCost;
         return this;
      }

      public MaterialOutInCostDTO.MaterialOutInCostDTOBuilder inCost(final BigDecimal inCost) {
         this.inCost = inCost;
         return this;
      }

      public MaterialOutInCostDTO.MaterialOutInCostDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("index")
      public MaterialOutInCostDTO.MaterialOutInCostDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      public MaterialOutInCostDTO build() {
         return new MaterialOutInCostDTO(this.dateTime, this.outCost, this.inCost, this.ratio, this.index);
      }

      @Override
      public String toString() {
         return "MaterialOutInCostDTO.MaterialOutInCostDTOBuilder(dateTime="
            + this.dateTime
            + ", outCost="
            + this.outCost
            + ", inCost="
            + this.inCost
            + ", ratio="
            + this.ratio
            + ", index="
            + this.index
            + ")";
      }
   }
}
