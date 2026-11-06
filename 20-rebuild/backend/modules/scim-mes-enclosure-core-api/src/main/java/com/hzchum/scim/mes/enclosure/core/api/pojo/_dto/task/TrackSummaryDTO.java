package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TrackSummaryDTO", description = "APP主材跟踪汇总列表")
public class TrackSummaryDTO {
   @ApiModelProperty(name = "summaryList", notes = "汇总清单量")
   @JsonProperty("summaryList")
   @JSONField(name = "summaryList")
   private BigDecimal summaryList;
   @ApiModelProperty(name = "summaryPicking", notes = "汇总领用量")
   @JsonProperty("summaryPicking")
   @JSONField(name = "summaryPicking ")
   private BigDecimal summaryPicking;
   @ApiModelProperty(name = "steelList", notes = "钢板清单量")
   @JsonProperty("steelList")
   @JSONField(name = "steelList")
   private BigDecimal steelList;
   @ApiModelProperty(name = "steelPicking", notes = "钢板领用量")
   @JsonProperty("steelPicking")
   @JSONField(name = "steelPicking ")
   private BigDecimal steelPicking;
   @ApiModelProperty(name = "sectionList", notes = "型材清单量")
   @JsonProperty("sectionList")
   @JSONField(name = "sectionList")
   private BigDecimal sectionList;
   @ApiModelProperty(name = "sectionPicking", notes = "型材领用量")
   @JsonProperty("sectionPicking")
   @JSONField(name = "sectionPicking ")
   private BigDecimal sectionPicking;

   public static TrackSummaryDTO.TrackSummaryDTOBuilder builder() {
      return new TrackSummaryDTO.TrackSummaryDTOBuilder();
   }

   public TrackSummaryDTO() {
   }

   public TrackSummaryDTO(
      final BigDecimal summaryList,
      final BigDecimal summaryPicking,
      final BigDecimal steelList,
      final BigDecimal steelPicking,
      final BigDecimal sectionList,
      final BigDecimal sectionPicking
   ) {
      this.summaryList = summaryList;
      this.summaryPicking = summaryPicking;
      this.steelList = steelList;
      this.steelPicking = steelPicking;
      this.sectionList = sectionList;
      this.sectionPicking = sectionPicking;
   }

   public BigDecimal getSummaryList() {
      return this.summaryList;
   }

   public BigDecimal getSummaryPicking() {
      return this.summaryPicking;
   }

   public BigDecimal getSteelList() {
      return this.steelList;
   }

   public BigDecimal getSteelPicking() {
      return this.steelPicking;
   }

   public BigDecimal getSectionList() {
      return this.sectionList;
   }

   public BigDecimal getSectionPicking() {
      return this.sectionPicking;
   }

   @JsonProperty("summaryList")
   public TrackSummaryDTO setSummaryList(final BigDecimal summaryList) {
      this.summaryList = summaryList;
      return this;
   }

   @JsonProperty("summaryPicking")
   public TrackSummaryDTO setSummaryPicking(final BigDecimal summaryPicking) {
      this.summaryPicking = summaryPicking;
      return this;
   }

   @JsonProperty("steelList")
   public TrackSummaryDTO setSteelList(final BigDecimal steelList) {
      this.steelList = steelList;
      return this;
   }

   @JsonProperty("steelPicking")
   public TrackSummaryDTO setSteelPicking(final BigDecimal steelPicking) {
      this.steelPicking = steelPicking;
      return this;
   }

   @JsonProperty("sectionList")
   public TrackSummaryDTO setSectionList(final BigDecimal sectionList) {
      this.sectionList = sectionList;
      return this;
   }

   @JsonProperty("sectionPicking")
   public TrackSummaryDTO setSectionPicking(final BigDecimal sectionPicking) {
      this.sectionPicking = sectionPicking;
      return this;
   }

   @Override
   public String toString() {
      return "TrackSummaryDTO(summaryList="
         + this.getSummaryList()
         + ", summaryPicking="
         + this.getSummaryPicking()
         + ", steelList="
         + this.getSteelList()
         + ", steelPicking="
         + this.getSteelPicking()
         + ", sectionList="
         + this.getSectionList()
         + ", sectionPicking="
         + this.getSectionPicking()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrackSummaryDTO)) {
         return false;
      }

      TrackSummaryDTO other = (TrackSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$summaryList = this.getSummaryList();
      Object other$summaryList = other.getSummaryList();
      if (this$summaryList == null ? other$summaryList == null : this$summaryList.equals(other$summaryList)) {
         Object this$summaryPicking = this.getSummaryPicking();
         Object other$summaryPicking = other.getSummaryPicking();
         if (this$summaryPicking == null ? other$summaryPicking == null : this$summaryPicking.equals(other$summaryPicking)) {
            Object this$steelList = this.getSteelList();
            Object other$steelList = other.getSteelList();
            if (this$steelList == null ? other$steelList == null : this$steelList.equals(other$steelList)) {
               Object this$steelPicking = this.getSteelPicking();
               Object other$steelPicking = other.getSteelPicking();
               if (this$steelPicking == null ? other$steelPicking == null : this$steelPicking.equals(other$steelPicking)) {
                  Object this$sectionList = this.getSectionList();
                  Object other$sectionList = other.getSectionList();
                  if (this$sectionList == null ? other$sectionList == null : this$sectionList.equals(other$sectionList)) {
                     Object this$sectionPicking = this.getSectionPicking();
                     Object other$sectionPicking = other.getSectionPicking();
                     return this$sectionPicking == null ? other$sectionPicking == null : this$sectionPicking.equals(other$sectionPicking);
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
      return other instanceof TrackSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $summaryList = this.getSummaryList();
      result = result * 59 + ($summaryList == null ? 43 : $summaryList.hashCode());
      Object $summaryPicking = this.getSummaryPicking();
      result = result * 59 + ($summaryPicking == null ? 43 : $summaryPicking.hashCode());
      Object $steelList = this.getSteelList();
      result = result * 59 + ($steelList == null ? 43 : $steelList.hashCode());
      Object $steelPicking = this.getSteelPicking();
      result = result * 59 + ($steelPicking == null ? 43 : $steelPicking.hashCode());
      Object $sectionList = this.getSectionList();
      result = result * 59 + ($sectionList == null ? 43 : $sectionList.hashCode());
      Object $sectionPicking = this.getSectionPicking();
      return result * 59 + ($sectionPicking == null ? 43 : $sectionPicking.hashCode());
   }

   public static class TrackSummaryDTOBuilder {
      private BigDecimal summaryList;
      private BigDecimal summaryPicking;
      private BigDecimal steelList;
      private BigDecimal steelPicking;
      private BigDecimal sectionList;
      private BigDecimal sectionPicking;

      TrackSummaryDTOBuilder() {
      }

      @JsonProperty("summaryList")
      public TrackSummaryDTO.TrackSummaryDTOBuilder summaryList(final BigDecimal summaryList) {
         this.summaryList = summaryList;
         return this;
      }

      @JsonProperty("summaryPicking")
      public TrackSummaryDTO.TrackSummaryDTOBuilder summaryPicking(final BigDecimal summaryPicking) {
         this.summaryPicking = summaryPicking;
         return this;
      }

      @JsonProperty("steelList")
      public TrackSummaryDTO.TrackSummaryDTOBuilder steelList(final BigDecimal steelList) {
         this.steelList = steelList;
         return this;
      }

      @JsonProperty("steelPicking")
      public TrackSummaryDTO.TrackSummaryDTOBuilder steelPicking(final BigDecimal steelPicking) {
         this.steelPicking = steelPicking;
         return this;
      }

      @JsonProperty("sectionList")
      public TrackSummaryDTO.TrackSummaryDTOBuilder sectionList(final BigDecimal sectionList) {
         this.sectionList = sectionList;
         return this;
      }

      @JsonProperty("sectionPicking")
      public TrackSummaryDTO.TrackSummaryDTOBuilder sectionPicking(final BigDecimal sectionPicking) {
         this.sectionPicking = sectionPicking;
         return this;
      }

      public TrackSummaryDTO build() {
         return new TrackSummaryDTO(this.summaryList, this.summaryPicking, this.steelList, this.steelPicking, this.sectionList, this.sectionPicking);
      }

      @Override
      public String toString() {
         return "TrackSummaryDTO.TrackSummaryDTOBuilder(summaryList="
            + this.summaryList
            + ", summaryPicking="
            + this.summaryPicking
            + ", steelList="
            + this.steelList
            + ", steelPicking="
            + this.steelPicking
            + ", sectionList="
            + this.sectionList
            + ", sectionPicking="
            + this.sectionPicking
            + ")";
      }
   }
}
