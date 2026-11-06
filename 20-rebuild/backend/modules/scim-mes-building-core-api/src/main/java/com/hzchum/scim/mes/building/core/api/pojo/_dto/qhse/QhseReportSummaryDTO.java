package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QhseReportSummaryDTO", description = "问题报表汇总 ")
public class QhseReportSummaryDTO {
   @ApiModelProperty(name = "totalQualityCurrentYear", value = "当年质检问题总数")
   @JsonProperty("totalQualityCurrentYear")
   @JSONField(name = "totalQualityCurrentYear")
   private Integer totalQualityCurrentYear;
   @ApiModelProperty(name = "rectifiedQuantity", value = "已整改数量")
   @JsonProperty("rectifiedQuantity")
   @JSONField(name = "rectifiedQuantity")
   private Integer rectifiedQuantity;
   @ApiModelProperty(name = "concessionQuantity", value = "让步接收数量")
   @JsonProperty("concessionQuantity")
   @JSONField(name = "concessionQuantity")
   private Integer concessionQuantity;

   public static QhseReportSummaryDTO.QhseReportSummaryDTOBuilder builder() {
      return new QhseReportSummaryDTO.QhseReportSummaryDTOBuilder();
   }

   public QhseReportSummaryDTO() {
   }

   public QhseReportSummaryDTO(final Integer totalQualityCurrentYear, final Integer rectifiedQuantity, final Integer concessionQuantity) {
      this.totalQualityCurrentYear = totalQualityCurrentYear;
      this.rectifiedQuantity = rectifiedQuantity;
      this.concessionQuantity = concessionQuantity;
   }

   public Integer getTotalQualityCurrentYear() {
      return this.totalQualityCurrentYear;
   }

   public Integer getRectifiedQuantity() {
      return this.rectifiedQuantity;
   }

   public Integer getConcessionQuantity() {
      return this.concessionQuantity;
   }

   @JsonProperty("totalQualityCurrentYear")
   public QhseReportSummaryDTO setTotalQualityCurrentYear(final Integer totalQualityCurrentYear) {
      this.totalQualityCurrentYear = totalQualityCurrentYear;
      return this;
   }

   @JsonProperty("rectifiedQuantity")
   public QhseReportSummaryDTO setRectifiedQuantity(final Integer rectifiedQuantity) {
      this.rectifiedQuantity = rectifiedQuantity;
      return this;
   }

   @JsonProperty("concessionQuantity")
   public QhseReportSummaryDTO setConcessionQuantity(final Integer concessionQuantity) {
      this.concessionQuantity = concessionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "QhseReportSummaryDTO(totalQualityCurrentYear="
         + this.getTotalQualityCurrentYear()
         + ", rectifiedQuantity="
         + this.getRectifiedQuantity()
         + ", concessionQuantity="
         + this.getConcessionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseReportSummaryDTO)) {
         return false;
      }

      QhseReportSummaryDTO other = (QhseReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQualityCurrentYear = this.getTotalQualityCurrentYear();
      Object other$totalQualityCurrentYear = other.getTotalQualityCurrentYear();
      if (this$totalQualityCurrentYear == null ? other$totalQualityCurrentYear == null : this$totalQualityCurrentYear.equals(other$totalQualityCurrentYear)) {
         Object this$rectifiedQuantity = this.getRectifiedQuantity();
         Object other$rectifiedQuantity = other.getRectifiedQuantity();
         if (this$rectifiedQuantity == null ? other$rectifiedQuantity == null : this$rectifiedQuantity.equals(other$rectifiedQuantity)) {
            Object this$concessionQuantity = this.getConcessionQuantity();
            Object other$concessionQuantity = other.getConcessionQuantity();
            return this$concessionQuantity == null ? other$concessionQuantity == null : this$concessionQuantity.equals(other$concessionQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQualityCurrentYear = this.getTotalQualityCurrentYear();
      result = result * 59 + ($totalQualityCurrentYear == null ? 43 : $totalQualityCurrentYear.hashCode());
      Object $rectifiedQuantity = this.getRectifiedQuantity();
      result = result * 59 + ($rectifiedQuantity == null ? 43 : $rectifiedQuantity.hashCode());
      Object $concessionQuantity = this.getConcessionQuantity();
      return result * 59 + ($concessionQuantity == null ? 43 : $concessionQuantity.hashCode());
   }

   public static class QhseReportSummaryDTOBuilder {
      private Integer totalQualityCurrentYear;
      private Integer rectifiedQuantity;
      private Integer concessionQuantity;

      QhseReportSummaryDTOBuilder() {
      }

      @JsonProperty("totalQualityCurrentYear")
      public QhseReportSummaryDTO.QhseReportSummaryDTOBuilder totalQualityCurrentYear(final Integer totalQualityCurrentYear) {
         this.totalQualityCurrentYear = totalQualityCurrentYear;
         return this;
      }

      @JsonProperty("rectifiedQuantity")
      public QhseReportSummaryDTO.QhseReportSummaryDTOBuilder rectifiedQuantity(final Integer rectifiedQuantity) {
         this.rectifiedQuantity = rectifiedQuantity;
         return this;
      }

      @JsonProperty("concessionQuantity")
      public QhseReportSummaryDTO.QhseReportSummaryDTOBuilder concessionQuantity(final Integer concessionQuantity) {
         this.concessionQuantity = concessionQuantity;
         return this;
      }

      public QhseReportSummaryDTO build() {
         return new QhseReportSummaryDTO(this.totalQualityCurrentYear, this.rectifiedQuantity, this.concessionQuantity);
      }

      @Override
      public String toString() {
         return "QhseReportSummaryDTO.QhseReportSummaryDTOBuilder(totalQualityCurrentYear="
            + this.totalQualityCurrentYear
            + ", rectifiedQuantity="
            + this.rectifiedQuantity
            + ", concessionQuantity="
            + this.concessionQuantity
            + ")";
      }
   }
}
