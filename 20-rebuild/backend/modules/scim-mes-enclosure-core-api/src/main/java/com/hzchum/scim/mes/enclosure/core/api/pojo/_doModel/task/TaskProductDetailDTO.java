package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureTypesettingComplete对象", description = "生产完成表 ")
public class TaskProductDetailDTO {
   @ApiModelProperty(name = "taskOrderId", notes = "工单id", value = "工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数", value = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数", value = "完成数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "totalLength", notes = "可上报长度", value = "可上报长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;

   public static TaskProductDetailDTO.TaskProductDetailDTOBuilder builder() {
      return new TaskProductDetailDTO.TaskProductDetailDTOBuilder();
   }

   public TaskProductDetailDTO() {
   }

   public TaskProductDetailDTO(final Long taskOrderId, final Integer taskQuantity, final Integer completeQuantity, final BigDecimal totalLength) {
      this.taskOrderId = taskOrderId;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.totalLength = totalLength;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   @JsonProperty("taskOrderId")
   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProductDetailDTO)) {
         return false;
      }

      TaskProductDetailDTO other = (TaskProductDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$totalLength = this.getTotalLength();
               Object other$totalLength = other.getTotalLength();
               return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof TaskProductDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "TaskProductDetailDTO(taskOrderId="
         + this.getTaskOrderId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }

   public static class TaskProductDetailDTOBuilder {
      private Long taskOrderId;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal totalLength;

      TaskProductDetailDTOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public TaskProductDetailDTO.TaskProductDetailDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TaskProductDetailDTO.TaskProductDetailDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskProductDetailDTO.TaskProductDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("totalLength")
      public TaskProductDetailDTO.TaskProductDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public TaskProductDetailDTO build() {
         return new TaskProductDetailDTO(this.taskOrderId, this.taskQuantity, this.completeQuantity, this.totalLength);
      }

      @Override
      public String toString() {
         return "TaskProductDetailDTO.TaskProductDetailDTOBuilder(taskOrderId="
            + this.taskOrderId
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", totalLength="
            + this.totalLength
            + ")";
      }
   }
}
