package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskConditionByDateDTO", description = "日期分组")
public class TaskConditionByDateDTO {
   @ApiModelProperty(name = "date", value = "日期", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "workShopId", value = "车间id", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名", notes = "车间名")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "完成数量", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "netWeightSum", value = "总净重", notes = "总净重")
   @JsonProperty("netWeightSum")
   @JSONField(name = "netWeightSum")
   private BigDecimal netWeightSum;

   public String getDate() {
      return this.date;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getNetWeightSum() {
      return this.netWeightSum;
   }

   @JsonProperty("date")
   public void setDate(final String date) {
      this.date = date;
   }

   @JsonProperty("workShopId")
   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("netWeightSum")
   public void setNetWeightSum(final BigDecimal netWeightSum) {
      this.netWeightSum = netWeightSum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskConditionByDateDTO)) {
         return false;
      }

      TaskConditionByDateDTO other = (TaskConditionByDateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                  Object this$workShopName = this.getWorkShopName();
                  Object other$workShopName = other.getWorkShopName();
                  if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                     Object this$netWeightSum = this.getNetWeightSum();
                     Object other$netWeightSum = other.getNetWeightSum();
                     return this$netWeightSum == null ? other$netWeightSum == null : this$netWeightSum.equals(other$netWeightSum);
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
      return other instanceof TaskConditionByDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $netWeightSum = this.getNetWeightSum();
      return result * 59 + ($netWeightSum == null ? 43 : $netWeightSum.hashCode());
   }

   @Override
   public String toString() {
      return "TaskConditionByDateDTO(date="
         + this.getDate()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", netWeightSum="
         + this.getNetWeightSum()
         + ")";
   }
}
