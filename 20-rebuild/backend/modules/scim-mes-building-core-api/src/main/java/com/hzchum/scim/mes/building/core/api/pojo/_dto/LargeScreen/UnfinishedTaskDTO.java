package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class UnfinishedTaskDTO {
   @ApiModelProperty(name = "dateStr", value = "计划完成时间")
   private String dateStr;
   @ApiModelProperty(name = "finishingRate", value = "完成率")
   private BigDecimal finishingRate;
   @ApiModelProperty(name = "project", value = "项目")
   private String project;
   @ApiModelProperty(name = "orderNumber", value = "工单号")
   private String orderNumber;
   @ApiModelProperty(name = "taskOrderId", value = "工单Id")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskQuantity", value = "任务数")
   private Integer taskQuantity;
   @ApiModelProperty(name = "unfinishedQuantity", value = "未完成数")
   private Integer unfinishedQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "齐套数")
   private Integer completeQuantity;

   public String getDateStr() {
      return this.dateStr;
   }

   public BigDecimal getFinishingRate() {
      return this.finishingRate;
   }

   public String getProject() {
      return this.project;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getUnfinishedQuantity() {
      return this.unfinishedQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public void setDateStr(final String dateStr) {
      this.dateStr = dateStr;
   }

   public void setFinishingRate(final BigDecimal finishingRate) {
      this.finishingRate = finishingRate;
   }

   public void setProject(final String project) {
      this.project = project;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setUnfinishedQuantity(final Integer unfinishedQuantity) {
      this.unfinishedQuantity = unfinishedQuantity;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnfinishedTaskDTO)) {
         return false;
      }

      UnfinishedTaskDTO other = (UnfinishedTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$unfinishedQuantity = this.getUnfinishedQuantity();
            Object other$unfinishedQuantity = other.getUnfinishedQuantity();
            if (this$unfinishedQuantity == null ? other$unfinishedQuantity == null : this$unfinishedQuantity.equals(other$unfinishedQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$dateStr = this.getDateStr();
                  Object other$dateStr = other.getDateStr();
                  if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
                     Object this$finishingRate = this.getFinishingRate();
                     Object other$finishingRate = other.getFinishingRate();
                     if (this$finishingRate == null ? other$finishingRate == null : this$finishingRate.equals(other$finishingRate)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$orderNumber = this.getOrderNumber();
                           Object other$orderNumber = other.getOrderNumber();
                           return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof UnfinishedTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $unfinishedQuantity = this.getUnfinishedQuantity();
      result = result * 59 + ($unfinishedQuantity == null ? 43 : $unfinishedQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $finishingRate = this.getFinishingRate();
      result = result * 59 + ($finishingRate == null ? 43 : $finishingRate.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   @Override
   public String toString() {
      return "UnfinishedTaskDTO(dateStr="
         + this.getDateStr()
         + ", finishingRate="
         + this.getFinishingRate()
         + ", project="
         + this.getProject()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", unfinishedQuantity="
         + this.getUnfinishedQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }
}
