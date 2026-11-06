package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamTaskCompleteDetailDTO", description = "班组任务达成率详情")
public class TeamTaskCompleteDetailDTO {
   @ApiModelProperty("项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty("项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "rate", value = "占比(百分比)", notes = "占比(百分比)")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;
   @ApiModelProperty(name = "taskWeightSum", value = "任务总净重", notes = "任务总净重")
   @JsonProperty("taskWeightSum")
   @JSONField(name = "taskWeightSum")
   private BigDecimal taskWeightSum;
   @ApiModelProperty(name = "completeQuantity", value = "完成数量", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeWeightSum", value = "完成总净重", notes = "完成总净重")
   @JsonProperty("completeWeightSum")
   @JSONField(name = "completeWeightSum")
   private BigDecimal completeWeightSum;

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public BigDecimal getTaskWeightSum() {
      return this.taskWeightSum;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteWeightSum() {
      return this.completeWeightSum;
   }

   @JsonProperty("shortName")
   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("rate")
   public void setRate(final BigDecimal rate) {
      this.rate = rate;
   }

   @JsonProperty("taskWeightSum")
   public void setTaskWeightSum(final BigDecimal taskWeightSum) {
      this.taskWeightSum = taskWeightSum;
   }

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("completeWeightSum")
   public void setCompleteWeightSum(final BigDecimal completeWeightSum) {
      this.completeWeightSum = completeWeightSum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamTaskCompleteDetailDTO)) {
         return false;
      }

      TeamTaskCompleteDetailDTO other = (TeamTaskCompleteDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$rate = this.getRate();
                  Object other$rate = other.getRate();
                  if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                     Object this$taskWeightSum = this.getTaskWeightSum();
                     Object other$taskWeightSum = other.getTaskWeightSum();
                     if (this$taskWeightSum == null ? other$taskWeightSum == null : this$taskWeightSum.equals(other$taskWeightSum)) {
                        Object this$completeWeightSum = this.getCompleteWeightSum();
                        Object other$completeWeightSum = other.getCompleteWeightSum();
                        return this$completeWeightSum == null ? other$completeWeightSum == null : this$completeWeightSum.equals(other$completeWeightSum);
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
      return other instanceof TeamTaskCompleteDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $taskWeightSum = this.getTaskWeightSum();
      result = result * 59 + ($taskWeightSum == null ? 43 : $taskWeightSum.hashCode());
      Object $completeWeightSum = this.getCompleteWeightSum();
      return result * 59 + ($completeWeightSum == null ? 43 : $completeWeightSum.hashCode());
   }

   @Override
   public String toString() {
      return "TeamTaskCompleteDetailDTO(shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", rate="
         + this.getRate()
         + ", taskWeightSum="
         + this.getTaskWeightSum()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeWeightSum="
         + this.getCompleteWeightSum()
         + ")";
   }
}
