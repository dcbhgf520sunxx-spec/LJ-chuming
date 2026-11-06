package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

@ApiModel(value = "ArtifactWarehouseVO", description = "构件出入库分析返回对象")
public class ArtifactWarehouseVO {
   @ApiModelProperty(name = "stockAndRateMap", value = "库存吨数、目标达成率")
   private Map<String, Object> stockAndRateMap;
   @ApiModelProperty(name = "statisticsMap", value = "柱状图")
   private Map<String, Object> statisticsMap;
   @ApiModelProperty(name = "recentMonthTonVOs", value = "折线统计图数据")
   private Map<String, List<TonVO>> recentMonthTonVOs;

   public Map<String, Object> getStockAndRateMap() {
      return this.stockAndRateMap;
   }

   public Map<String, Object> getStatisticsMap() {
      return this.statisticsMap;
   }

   public Map<String, List<TonVO>> getRecentMonthTonVOs() {
      return this.recentMonthTonVOs;
   }

   public void setStockAndRateMap(final Map<String, Object> stockAndRateMap) {
      this.stockAndRateMap = stockAndRateMap;
   }

   public void setStatisticsMap(final Map<String, Object> statisticsMap) {
      this.statisticsMap = statisticsMap;
   }

   public void setRecentMonthTonVOs(final Map<String, List<TonVO>> recentMonthTonVOs) {
      this.recentMonthTonVOs = recentMonthTonVOs;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactWarehouseVO)) {
         return false;
      }

      ArtifactWarehouseVO other = (ArtifactWarehouseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$stockAndRateMap = this.getStockAndRateMap();
      Object other$stockAndRateMap = other.getStockAndRateMap();
      if (this$stockAndRateMap == null ? other$stockAndRateMap == null : this$stockAndRateMap.equals(other$stockAndRateMap)) {
         Object this$statisticsMap = this.getStatisticsMap();
         Object other$statisticsMap = other.getStatisticsMap();
         if (this$statisticsMap == null ? other$statisticsMap == null : this$statisticsMap.equals(other$statisticsMap)) {
            Object this$recentMonthTonVOs = this.getRecentMonthTonVOs();
            Object other$recentMonthTonVOs = other.getRecentMonthTonVOs();
            return this$recentMonthTonVOs == null ? other$recentMonthTonVOs == null : this$recentMonthTonVOs.equals(other$recentMonthTonVOs);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactWarehouseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $stockAndRateMap = this.getStockAndRateMap();
      result = result * 59 + ($stockAndRateMap == null ? 43 : $stockAndRateMap.hashCode());
      Object $statisticsMap = this.getStatisticsMap();
      result = result * 59 + ($statisticsMap == null ? 43 : $statisticsMap.hashCode());
      Object $recentMonthTonVOs = this.getRecentMonthTonVOs();
      return result * 59 + ($recentMonthTonVOs == null ? 43 : $recentMonthTonVOs.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactWarehouseVO(stockAndRateMap="
         + this.getStockAndRateMap()
         + ", statisticsMap="
         + this.getStatisticsMap()
         + ", recentMonthTonVOs="
         + this.getRecentMonthTonVOs()
         + ")";
   }
}
