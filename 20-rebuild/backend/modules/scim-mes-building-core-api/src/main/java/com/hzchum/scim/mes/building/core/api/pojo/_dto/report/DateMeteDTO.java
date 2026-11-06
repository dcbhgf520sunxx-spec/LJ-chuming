package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "DateMeteDTO", description = "产量统计")
@JsonInclude(Include.NON_NULL)
public class DateMeteDTO {
   @ApiModelProperty(name = "dateTime", value = "日期")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   private String dateTime;
   @ApiModelProperty(name = "taskMete", value = "排产量")
   @JsonProperty("taskMete")
   @JSONField(name = "taskMete")
   private BigDecimal taskMete;
   @ApiModelProperty(name = "mete", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "avgCost", value = "平均价格")
   @JsonProperty("avgCost")
   @JSONField(name = "avgCost")
   private BigDecimal avgCost;
   @ApiModelProperty(name = "outMete", value = "主材出库量")
   @JsonProperty("outMete")
   @JSONField(name = "outMete")
   private BigDecimal outMete;
   @ApiModelProperty(name = "sellMete", value = "主材出售量")
   @JsonProperty("sellMete")
   @JSONField(name = "sellMete")
   private BigDecimal sellMete;
   @ApiModelProperty(name = "lossMete", value = "损耗量")
   @JsonProperty("lossMete")
   @JSONField(name = "lossMete")
   private BigDecimal lossMete;
   @ApiModelProperty(name = "ratio", value = "占比")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;
   @ApiModelProperty(name = "numbers", value = "参与生产人数")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   private Integer numbers;
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   private Long index;

   public static DateMeteDTO.DateMeteDTOBuilder builder() {
      return new DateMeteDTO.DateMeteDTOBuilder();
   }

   public DateMeteDTO() {
   }

   public DateMeteDTO(
      final String dateTime,
      final BigDecimal taskMete,
      final BigDecimal mete,
      final BigDecimal avgCost,
      final BigDecimal outMete,
      final BigDecimal sellMete,
      final BigDecimal lossMete,
      final BigDecimal ratio,
      final Integer numbers,
      final Long index
   ) {
      this.dateTime = dateTime;
      this.taskMete = taskMete;
      this.mete = mete;
      this.avgCost = avgCost;
      this.outMete = outMete;
      this.sellMete = sellMete;
      this.lossMete = lossMete;
      this.ratio = ratio;
      this.numbers = numbers;
      this.index = index;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAvgCost() {
      return this.avgCost;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public BigDecimal getSellMete() {
      return this.sellMete;
   }

   public BigDecimal getLossMete() {
      return this.lossMete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public Integer getNumbers() {
      return this.numbers;
   }

   public Long getIndex() {
      return this.index;
   }

   @JsonProperty("dateTime")
   public DateMeteDTO setDateTime(final String dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("taskMete")
   public DateMeteDTO setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
      return this;
   }

   @JsonProperty("mete")
   public DateMeteDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("avgCost")
   public DateMeteDTO setAvgCost(final BigDecimal avgCost) {
      this.avgCost = avgCost;
      return this;
   }

   @JsonProperty("outMete")
   public DateMeteDTO setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
      return this;
   }

   @JsonProperty("sellMete")
   public DateMeteDTO setSellMete(final BigDecimal sellMete) {
      this.sellMete = sellMete;
      return this;
   }

   @JsonProperty("lossMete")
   public DateMeteDTO setLossMete(final BigDecimal lossMete) {
      this.lossMete = lossMete;
      return this;
   }

   @JsonProperty("ratio")
   public DateMeteDTO setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
      return this;
   }

   @JsonProperty("numbers")
   public DateMeteDTO setNumbers(final Integer numbers) {
      this.numbers = numbers;
      return this;
   }

   @JsonProperty("index")
   public DateMeteDTO setIndex(final Long index) {
      this.index = index;
      return this;
   }

   @Override
   public String toString() {
      return "DateMeteDTO(dateTime="
         + this.getDateTime()
         + ", taskMete="
         + this.getTaskMete()
         + ", mete="
         + this.getMete()
         + ", avgCost="
         + this.getAvgCost()
         + ", outMete="
         + this.getOutMete()
         + ", sellMete="
         + this.getSellMete()
         + ", lossMete="
         + this.getLossMete()
         + ", ratio="
         + this.getRatio()
         + ", numbers="
         + this.getNumbers()
         + ", index="
         + this.getIndex()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DateMeteDTO)) {
         return false;
      }

      DateMeteDTO other = (DateMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$numbers = this.getNumbers();
      Object other$numbers = other.getNumbers();
      if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$taskMete = this.getTaskMete();
               Object other$taskMete = other.getTaskMete();
               if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$avgCost = this.getAvgCost();
                     Object other$avgCost = other.getAvgCost();
                     if (this$avgCost == null ? other$avgCost == null : this$avgCost.equals(other$avgCost)) {
                        Object this$outMete = this.getOutMete();
                        Object other$outMete = other.getOutMete();
                        if (this$outMete == null ? other$outMete == null : this$outMete.equals(other$outMete)) {
                           Object this$sellMete = this.getSellMete();
                           Object other$sellMete = other.getSellMete();
                           if (this$sellMete == null ? other$sellMete == null : this$sellMete.equals(other$sellMete)) {
                              Object this$lossMete = this.getLossMete();
                              Object other$lossMete = other.getLossMete();
                              if (this$lossMete == null ? other$lossMete == null : this$lossMete.equals(other$lossMete)) {
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
      return other instanceof DateMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $avgCost = this.getAvgCost();
      result = result * 59 + ($avgCost == null ? 43 : $avgCost.hashCode());
      Object $outMete = this.getOutMete();
      result = result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
      Object $sellMete = this.getSellMete();
      result = result * 59 + ($sellMete == null ? 43 : $sellMete.hashCode());
      Object $lossMete = this.getLossMete();
      result = result * 59 + ($lossMete == null ? 43 : $lossMete.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   public static class DateMeteDTOBuilder {
      private String dateTime;
      private BigDecimal taskMete;
      private BigDecimal mete;
      private BigDecimal avgCost;
      private BigDecimal outMete;
      private BigDecimal sellMete;
      private BigDecimal lossMete;
      private BigDecimal ratio;
      private Integer numbers;
      private Long index;

      DateMeteDTOBuilder() {
      }

      @JsonProperty("dateTime")
      public DateMeteDTO.DateMeteDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("taskMete")
      public DateMeteDTO.DateMeteDTOBuilder taskMete(final BigDecimal taskMete) {
         this.taskMete = taskMete;
         return this;
      }

      @JsonProperty("mete")
      public DateMeteDTO.DateMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("avgCost")
      public DateMeteDTO.DateMeteDTOBuilder avgCost(final BigDecimal avgCost) {
         this.avgCost = avgCost;
         return this;
      }

      @JsonProperty("outMete")
      public DateMeteDTO.DateMeteDTOBuilder outMete(final BigDecimal outMete) {
         this.outMete = outMete;
         return this;
      }

      @JsonProperty("sellMete")
      public DateMeteDTO.DateMeteDTOBuilder sellMete(final BigDecimal sellMete) {
         this.sellMete = sellMete;
         return this;
      }

      @JsonProperty("lossMete")
      public DateMeteDTO.DateMeteDTOBuilder lossMete(final BigDecimal lossMete) {
         this.lossMete = lossMete;
         return this;
      }

      @JsonProperty("ratio")
      public DateMeteDTO.DateMeteDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("numbers")
      public DateMeteDTO.DateMeteDTOBuilder numbers(final Integer numbers) {
         this.numbers = numbers;
         return this;
      }

      @JsonProperty("index")
      public DateMeteDTO.DateMeteDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      public DateMeteDTO build() {
         return new DateMeteDTO(
            this.dateTime, this.taskMete, this.mete, this.avgCost, this.outMete, this.sellMete, this.lossMete, this.ratio, this.numbers, this.index
         );
      }

      @Override
      public String toString() {
         return "DateMeteDTO.DateMeteDTOBuilder(dateTime="
            + this.dateTime
            + ", taskMete="
            + this.taskMete
            + ", mete="
            + this.mete
            + ", avgCost="
            + this.avgCost
            + ", outMete="
            + this.outMete
            + ", sellMete="
            + this.sellMete
            + ", lossMete="
            + this.lossMete
            + ", ratio="
            + this.ratio
            + ", numbers="
            + this.numbers
            + ", index="
            + this.index
            + ")";
      }
   }
}
