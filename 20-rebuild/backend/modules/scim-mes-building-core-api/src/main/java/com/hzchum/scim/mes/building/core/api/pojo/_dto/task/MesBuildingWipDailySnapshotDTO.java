package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingWipDailySnapshotDTO", description = "每日在制品快照DTO ")
public class MesBuildingWipDailySnapshotDTO {
   @ApiModelProperty(name = "yesterdaySInventory", notes = "昨日在制品库存（吨）")
   @JsonProperty("yesterdaySInventory")
   @JSONField(name = "yesterdaySInventory")
   private BigDecimal yesterdaySInventory;
   @ApiModelProperty(name = "growthWeight", notes = "增长率值")
   @JsonProperty("growthWeight")
   @JSONField(name = "growthWeight")
   private BigDecimal growthWeight;
   @ApiModelProperty(name = "rate", notes = "增长率%")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;
   @ApiModelProperty(name = "processMap", notes = "工序名称列表")
   @JsonProperty("processMap")
   @JSONField(name = "processMap")
   private List<MesBuildingWipDailySnapshotProcessDTO> processList;
   @ApiModelProperty(name = "statisticsList", notes = "在制品统计列表")
   @JsonProperty("statisticsList")
   @JSONField(name = "statisticsList")
   private List<MesBuildingWIPStatisticsDTO> statisticsList;
   @ApiModelProperty(name = "detailList", notes = "在制品统计列表")
   @JsonProperty("detailList")
   @JSONField(name = "detailList")
   private List<MesBuildingWIPStatisticsDetailDTO> detailList;

   public static MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder builder() {
      return new MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder();
   }

   public MesBuildingWipDailySnapshotDTO(
      final BigDecimal yesterdaySInventory,
      final BigDecimal growthWeight,
      final BigDecimal rate,
      final List<MesBuildingWipDailySnapshotProcessDTO> processList,
      final List<MesBuildingWIPStatisticsDTO> statisticsList,
      final List<MesBuildingWIPStatisticsDetailDTO> detailList
   ) {
      this.yesterdaySInventory = yesterdaySInventory;
      this.growthWeight = growthWeight;
      this.rate = rate;
      this.processList = processList;
      this.statisticsList = statisticsList;
      this.detailList = detailList;
   }

   public MesBuildingWipDailySnapshotDTO() {
   }

   public BigDecimal getYesterdaySInventory() {
      return this.yesterdaySInventory;
   }

   public BigDecimal getGrowthWeight() {
      return this.growthWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public List<MesBuildingWipDailySnapshotProcessDTO> getProcessList() {
      return this.processList;
   }

   public List<MesBuildingWIPStatisticsDTO> getStatisticsList() {
      return this.statisticsList;
   }

   public List<MesBuildingWIPStatisticsDetailDTO> getDetailList() {
      return this.detailList;
   }

   @JsonProperty("yesterdaySInventory")
   public MesBuildingWipDailySnapshotDTO setYesterdaySInventory(final BigDecimal yesterdaySInventory) {
      this.yesterdaySInventory = yesterdaySInventory;
      return this;
   }

   @JsonProperty("growthWeight")
   public MesBuildingWipDailySnapshotDTO setGrowthWeight(final BigDecimal growthWeight) {
      this.growthWeight = growthWeight;
      return this;
   }

   @JsonProperty("rate")
   public MesBuildingWipDailySnapshotDTO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @JsonProperty("processMap")
   public MesBuildingWipDailySnapshotDTO setProcessList(final List<MesBuildingWipDailySnapshotProcessDTO> processList) {
      this.processList = processList;
      return this;
   }

   @JsonProperty("statisticsList")
   public MesBuildingWipDailySnapshotDTO setStatisticsList(final List<MesBuildingWIPStatisticsDTO> statisticsList) {
      this.statisticsList = statisticsList;
      return this;
   }

   @JsonProperty("detailList")
   public MesBuildingWipDailySnapshotDTO setDetailList(final List<MesBuildingWIPStatisticsDetailDTO> detailList) {
      this.detailList = detailList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWipDailySnapshotDTO(yesterdaySInventory="
         + this.getYesterdaySInventory()
         + ", growthWeight="
         + this.getGrowthWeight()
         + ", rate="
         + this.getRate()
         + ", processList="
         + this.getProcessList()
         + ", statisticsList="
         + this.getStatisticsList()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWipDailySnapshotDTO)) {
         return false;
      }

      MesBuildingWipDailySnapshotDTO other = (MesBuildingWipDailySnapshotDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yesterdaySInventory = this.getYesterdaySInventory();
      Object other$yesterdaySInventory = other.getYesterdaySInventory();
      if (this$yesterdaySInventory == null ? other$yesterdaySInventory == null : this$yesterdaySInventory.equals(other$yesterdaySInventory)) {
         Object this$growthWeight = this.getGrowthWeight();
         Object other$growthWeight = other.getGrowthWeight();
         if (this$growthWeight == null ? other$growthWeight == null : this$growthWeight.equals(other$growthWeight)) {
            Object this$rate = this.getRate();
            Object other$rate = other.getRate();
            if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
               Object this$processList = this.getProcessList();
               Object other$processList = other.getProcessList();
               if (this$processList == null ? other$processList == null : this$processList.equals(other$processList)) {
                  Object this$statisticsList = this.getStatisticsList();
                  Object other$statisticsList = other.getStatisticsList();
                  if (this$statisticsList == null ? other$statisticsList == null : this$statisticsList.equals(other$statisticsList)) {
                     Object this$detailList = this.getDetailList();
                     Object other$detailList = other.getDetailList();
                     return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof MesBuildingWipDailySnapshotDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yesterdaySInventory = this.getYesterdaySInventory();
      result = result * 59 + ($yesterdaySInventory == null ? 43 : $yesterdaySInventory.hashCode());
      Object $growthWeight = this.getGrowthWeight();
      result = result * 59 + ($growthWeight == null ? 43 : $growthWeight.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $processList = this.getProcessList();
      result = result * 59 + ($processList == null ? 43 : $processList.hashCode());
      Object $statisticsList = this.getStatisticsList();
      result = result * 59 + ($statisticsList == null ? 43 : $statisticsList.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   public static class MesBuildingWipDailySnapshotDTOBuilder {
      private BigDecimal yesterdaySInventory;
      private BigDecimal growthWeight;
      private BigDecimal rate;
      private List<MesBuildingWipDailySnapshotProcessDTO> processList;
      private List<MesBuildingWIPStatisticsDTO> statisticsList;
      private List<MesBuildingWIPStatisticsDetailDTO> detailList;

      MesBuildingWipDailySnapshotDTOBuilder() {
      }

      @JsonProperty("yesterdaySInventory")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder yesterdaySInventory(final BigDecimal yesterdaySInventory) {
         this.yesterdaySInventory = yesterdaySInventory;
         return this;
      }

      @JsonProperty("growthWeight")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder growthWeight(final BigDecimal growthWeight) {
         this.growthWeight = growthWeight;
         return this;
      }

      @JsonProperty("rate")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      @JsonProperty("processMap")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder processList(final List<MesBuildingWipDailySnapshotProcessDTO> processList) {
         this.processList = processList;
         return this;
      }

      @JsonProperty("statisticsList")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder statisticsList(final List<MesBuildingWIPStatisticsDTO> statisticsList) {
         this.statisticsList = statisticsList;
         return this;
      }

      @JsonProperty("detailList")
      public MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder detailList(final List<MesBuildingWIPStatisticsDetailDTO> detailList) {
         this.detailList = detailList;
         return this;
      }

      public MesBuildingWipDailySnapshotDTO build() {
         return new MesBuildingWipDailySnapshotDTO(
            this.yesterdaySInventory, this.growthWeight, this.rate, this.processList, this.statisticsList, this.detailList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWipDailySnapshotDTO.MesBuildingWipDailySnapshotDTOBuilder(yesterdaySInventory="
            + this.yesterdaySInventory
            + ", growthWeight="
            + this.growthWeight
            + ", rate="
            + this.rate
            + ", processList="
            + this.processList
            + ", statisticsList="
            + this.statisticsList
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
