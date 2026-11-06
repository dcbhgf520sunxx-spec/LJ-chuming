package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "WorkShopTaskCompleteRateDTO", description = "车间任务达成率分析")
public class WorkShopTaskCompleteRateDTO {
   @ApiModelProperty(name = "workShopId", value = "车间id", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名", notes = "车间名")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "avgRate", value = "平均占比(百分比)", notes = "平均占比(百分比)")
   @JsonProperty("avgRate")
   @JSONField(name = "avgRate")
   private BigDecimal avgRate;
   @ApiModelProperty(name = "monthRateList", value = "日期比率", notes = "日期比率")
   @JsonProperty("monthRateList")
   @JSONField(name = "monthRateList")
   private List<WorkShopEachMonthRateDTO> monthRateList;

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public BigDecimal getAvgRate() {
      return this.avgRate;
   }

   public List<WorkShopEachMonthRateDTO> getMonthRateList() {
      return this.monthRateList;
   }

   @JsonProperty("workShopId")
   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("avgRate")
   public void setAvgRate(final BigDecimal avgRate) {
      this.avgRate = avgRate;
   }

   @JsonProperty("monthRateList")
   public void setMonthRateList(final List<WorkShopEachMonthRateDTO> monthRateList) {
      this.monthRateList = monthRateList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkShopTaskCompleteRateDTO)) {
         return false;
      }

      WorkShopTaskCompleteRateDTO other = (WorkShopTaskCompleteRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$workShopName = this.getWorkShopName();
         Object other$workShopName = other.getWorkShopName();
         if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
            Object this$avgRate = this.getAvgRate();
            Object other$avgRate = other.getAvgRate();
            if (this$avgRate == null ? other$avgRate == null : this$avgRate.equals(other$avgRate)) {
               Object this$monthRateList = this.getMonthRateList();
               Object other$monthRateList = other.getMonthRateList();
               return this$monthRateList == null ? other$monthRateList == null : this$monthRateList.equals(other$monthRateList);
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
      return other instanceof WorkShopTaskCompleteRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $avgRate = this.getAvgRate();
      result = result * 59 + ($avgRate == null ? 43 : $avgRate.hashCode());
      Object $monthRateList = this.getMonthRateList();
      return result * 59 + ($monthRateList == null ? 43 : $monthRateList.hashCode());
   }

   @Override
   public String toString() {
      return "WorkShopTaskCompleteRateDTO(workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", avgRate="
         + this.getAvgRate()
         + ", monthRateList="
         + this.getMonthRateList()
         + ")";
   }
}
