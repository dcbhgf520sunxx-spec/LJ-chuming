package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "自动切割任务")
public class APPAutoCutTaskDTO {
   private LocalDateTime nestingTime;
   private String jobNumber;
   private LocalDateTime completeTime;
   private LocalDateTime askCompleteTime;
   private String userName;
   private String cutName;
   private Integer quantity;
   private Integer completeQuantity;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private LocalDateTime schedulingDate;
   @ApiModelProperty(name = "nestCutPlateId", notes = "nestCutPlateId")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   private Long nestCutPlateId;

   public static APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder builder() {
      return new APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder();
   }

   public APPAutoCutTaskDTO() {
   }

   public APPAutoCutTaskDTO(
      final LocalDateTime nestingTime,
      final String jobNumber,
      final LocalDateTime completeTime,
      final LocalDateTime askCompleteTime,
      final String userName,
      final String cutName,
      final Integer quantity,
      final Integer completeQuantity,
      final LocalDateTime schedulingDate,
      final Long nestCutPlateId
   ) {
      this.nestingTime = nestingTime;
      this.jobNumber = jobNumber;
      this.completeTime = completeTime;
      this.askCompleteTime = askCompleteTime;
      this.userName = userName;
      this.cutName = cutName;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.schedulingDate = schedulingDate;
      this.nestCutPlateId = nestCutPlateId;
   }

   public LocalDateTime getNestingTime() {
      return this.nestingTime;
   }

   public String getJobNumber() {
      return this.jobNumber;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getCutName() {
      return this.cutName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public LocalDateTime getSchedulingDate() {
      return this.schedulingDate;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public APPAutoCutTaskDTO setNestingTime(final LocalDateTime nestingTime) {
      this.nestingTime = nestingTime;
      return this;
   }

   public APPAutoCutTaskDTO setJobNumber(final String jobNumber) {
      this.jobNumber = jobNumber;
      return this;
   }

   public APPAutoCutTaskDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   public APPAutoCutTaskDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public APPAutoCutTaskDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public APPAutoCutTaskDTO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   public APPAutoCutTaskDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public APPAutoCutTaskDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("schedulingDate")
   public APPAutoCutTaskDTO setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public APPAutoCutTaskDTO setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @Override
   public String toString() {
      return "APPAutoCutTaskDTO(nestingTime="
         + this.getNestingTime()
         + ", jobNumber="
         + this.getJobNumber()
         + ", completeTime="
         + this.getCompleteTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", userName="
         + this.getUserName()
         + ", cutName="
         + this.getCutName()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPAutoCutTaskDTO)) {
         return false;
      }

      APPAutoCutTaskDTO other = (APPAutoCutTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$nestingTime = this.getNestingTime();
               Object other$nestingTime = other.getNestingTime();
               if (this$nestingTime == null ? other$nestingTime == null : this$nestingTime.equals(other$nestingTime)) {
                  Object this$jobNumber = this.getJobNumber();
                  Object other$jobNumber = other.getJobNumber();
                  if (this$jobNumber == null ? other$jobNumber == null : this$jobNumber.equals(other$jobNumber)) {
                     Object this$completeTime = this.getCompleteTime();
                     Object other$completeTime = other.getCompleteTime();
                     if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                        Object this$askCompleteTime = this.getAskCompleteTime();
                        Object other$askCompleteTime = other.getAskCompleteTime();
                        if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$cutName = this.getCutName();
                              Object other$cutName = other.getCutName();
                              if (this$cutName == null ? other$cutName == null : this$cutName.equals(other$cutName)) {
                                 Object this$schedulingDate = this.getSchedulingDate();
                                 Object other$schedulingDate = other.getSchedulingDate();
                                 return this$schedulingDate == null ? other$schedulingDate == null : this$schedulingDate.equals(other$schedulingDate);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof APPAutoCutTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $nestingTime = this.getNestingTime();
      result = result * 59 + ($nestingTime == null ? 43 : $nestingTime.hashCode());
      Object $jobNumber = this.getJobNumber();
      result = result * 59 + ($jobNumber == null ? 43 : $jobNumber.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      return result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
   }

   public static class APPAutoCutTaskDTOBuilder {
      private LocalDateTime nestingTime;
      private String jobNumber;
      private LocalDateTime completeTime;
      private LocalDateTime askCompleteTime;
      private String userName;
      private String cutName;
      private Integer quantity;
      private Integer completeQuantity;
      private LocalDateTime schedulingDate;
      private Long nestCutPlateId;

      APPAutoCutTaskDTOBuilder() {
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder nestingTime(final LocalDateTime nestingTime) {
         this.nestingTime = nestingTime;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder jobNumber(final String jobNumber) {
         this.jobNumber = jobNumber;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("schedulingDate")
      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      public APPAutoCutTaskDTO build() {
         return new APPAutoCutTaskDTO(
            this.nestingTime,
            this.jobNumber,
            this.completeTime,
            this.askCompleteTime,
            this.userName,
            this.cutName,
            this.quantity,
            this.completeQuantity,
            this.schedulingDate,
            this.nestCutPlateId
         );
      }

      @Override
      public String toString() {
         return "APPAutoCutTaskDTO.APPAutoCutTaskDTOBuilder(nestingTime="
            + this.nestingTime
            + ", jobNumber="
            + this.jobNumber
            + ", completeTime="
            + this.completeTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", userName="
            + this.userName
            + ", cutName="
            + this.cutName
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", schedulingDate="
            + this.schedulingDate
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ")";
      }
   }
}
