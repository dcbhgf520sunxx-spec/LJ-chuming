package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "零件套料需要排产信息", description = "零件套料需要排产信息")
public class MachinePartNestingProductInfoDTO {
   @ApiModelProperty(name = "taskOrderId", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private String taskOrderId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "schedulingUserId", value = "排产人", notes = "排产人")
   @JsonProperty("schedulingUserId")
   @JSONField(name = "schedulingUserId")
   private Long schedulingUserId;
   @ApiModelProperty(name = "schedulingUserName", value = "排产人名", notes = "排产人名")
   @JsonProperty("schedulingUserName")
   @JSONField(name = "schedulingUserName")
   private String schedulingUserName;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private String schedulingDate;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "artifactAskCompleteTime", value = "产品id", notes = "产品id")
   @JsonProperty("artifactAskCompleteTime")
   @JSONField(name = "artifactAskCompleteTime")
   private LocalDateTime artifactAskCompleteTime;

   public static MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder builder() {
      return new MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder();
   }

   public MachinePartNestingProductInfoDTO(
      final String taskOrderId,
      final String orderNumber,
      final Long schedulingUserId,
      final String schedulingUserName,
      final String schedulingDate,
      final Integer schedulingQuantity,
      final LocalDateTime artifactAskCompleteTime
   ) {
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.schedulingUserId = schedulingUserId;
      this.schedulingUserName = schedulingUserName;
      this.schedulingDate = schedulingDate;
      this.schedulingQuantity = schedulingQuantity;
      this.artifactAskCompleteTime = artifactAskCompleteTime;
   }

   public MachinePartNestingProductInfoDTO() {
   }

   public String getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getSchedulingUserId() {
      return this.schedulingUserId;
   }

   public String getSchedulingUserName() {
      return this.schedulingUserName;
   }

   public String getSchedulingDate() {
      return this.schedulingDate;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public LocalDateTime getArtifactAskCompleteTime() {
      return this.artifactAskCompleteTime;
   }

   @JsonProperty("taskOrderId")
   public MachinePartNestingProductInfoDTO setTaskOrderId(final String taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MachinePartNestingProductInfoDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("schedulingUserId")
   public MachinePartNestingProductInfoDTO setSchedulingUserId(final Long schedulingUserId) {
      this.schedulingUserId = schedulingUserId;
      return this;
   }

   @JsonProperty("schedulingUserName")
   public MachinePartNestingProductInfoDTO setSchedulingUserName(final String schedulingUserName) {
      this.schedulingUserName = schedulingUserName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public MachinePartNestingProductInfoDTO setSchedulingDate(final String schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MachinePartNestingProductInfoDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("artifactAskCompleteTime")
   public MachinePartNestingProductInfoDTO setArtifactAskCompleteTime(final LocalDateTime artifactAskCompleteTime) {
      this.artifactAskCompleteTime = artifactAskCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingProductInfoDTO(taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", schedulingUserId="
         + this.getSchedulingUserId()
         + ", schedulingUserName="
         + this.getSchedulingUserName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", artifactAskCompleteTime="
         + this.getArtifactAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingProductInfoDTO)) {
         return false;
      }

      MachinePartNestingProductInfoDTO other = (MachinePartNestingProductInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingUserId = this.getSchedulingUserId();
      Object other$schedulingUserId = other.getSchedulingUserId();
      if (this$schedulingUserId == null ? other$schedulingUserId == null : this$schedulingUserId.equals(other$schedulingUserId)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                  Object this$schedulingUserName = this.getSchedulingUserName();
                  Object other$schedulingUserName = other.getSchedulingUserName();
                  if (this$schedulingUserName == null ? other$schedulingUserName == null : this$schedulingUserName.equals(other$schedulingUserName)) {
                     Object this$schedulingDate = this.getSchedulingDate();
                     Object other$schedulingDate = other.getSchedulingDate();
                     if (this$schedulingDate == null ? other$schedulingDate == null : this$schedulingDate.equals(other$schedulingDate)) {
                        Object this$artifactAskCompleteTime = this.getArtifactAskCompleteTime();
                        Object other$artifactAskCompleteTime = other.getArtifactAskCompleteTime();
                        return this$artifactAskCompleteTime == null
                           ? other$artifactAskCompleteTime == null
                           : this$artifactAskCompleteTime.equals(other$artifactAskCompleteTime);
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
      return other instanceof MachinePartNestingProductInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingUserId = this.getSchedulingUserId();
      result = result * 59 + ($schedulingUserId == null ? 43 : $schedulingUserId.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $schedulingUserName = this.getSchedulingUserName();
      result = result * 59 + ($schedulingUserName == null ? 43 : $schedulingUserName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $artifactAskCompleteTime = this.getArtifactAskCompleteTime();
      return result * 59 + ($artifactAskCompleteTime == null ? 43 : $artifactAskCompleteTime.hashCode());
   }

   public static class MachinePartNestingProductInfoDTOBuilder {
      private String taskOrderId;
      private String orderNumber;
      private Long schedulingUserId;
      private String schedulingUserName;
      private String schedulingDate;
      private Integer schedulingQuantity;
      private LocalDateTime artifactAskCompleteTime;

      MachinePartNestingProductInfoDTOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder taskOrderId(final String taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("schedulingUserId")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder schedulingUserId(final Long schedulingUserId) {
         this.schedulingUserId = schedulingUserId;
         return this;
      }

      @JsonProperty("schedulingUserName")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder schedulingUserName(final String schedulingUserName) {
         this.schedulingUserName = schedulingUserName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder schedulingDate(final String schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("artifactAskCompleteTime")
      public MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder artifactAskCompleteTime(final LocalDateTime artifactAskCompleteTime) {
         this.artifactAskCompleteTime = artifactAskCompleteTime;
         return this;
      }

      public MachinePartNestingProductInfoDTO build() {
         return new MachinePartNestingProductInfoDTO(
            this.taskOrderId,
            this.orderNumber,
            this.schedulingUserId,
            this.schedulingUserName,
            this.schedulingDate,
            this.schedulingQuantity,
            this.artifactAskCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingProductInfoDTO.MachinePartNestingProductInfoDTOBuilder(taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", schedulingUserId="
            + this.schedulingUserId
            + ", schedulingUserName="
            + this.schedulingUserName
            + ", schedulingDate="
            + this.schedulingDate
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", artifactAskCompleteTime="
            + this.artifactAskCompleteTime
            + ")";
      }
   }
}
