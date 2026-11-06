package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysSmsRecords对象", description = "")
@Entity
@TableName("sys_sms_records")
@Table(name = "sys_sms_records")
@org.hibernate.annotations.Table(appliesTo = "sys_sms_records")
public class SysSmsRecords extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "boolSuccess", value = "短信发送状态", notes = "短信发送状态")
   @TableField("bool_success")
   @Column(name = "bool_success", columnDefinition = "bit(1) DEFAULT b'0' COMMENT '是否成功：0失败，1成功'", nullable = false)
   private Boolean boolSuccess;
   @ApiModelProperty(name = "attemptCount", value = "尝试发送次数", notes = "尝试发送次数")
   @TableField("attempt_count")
   @Column(name = "attempt_count", columnDefinition = "int(11) default '0' COMMENT '尝试发送次数'", nullable = true)
   private Integer attemptCount;
   @ApiModelProperty(name = "sendTime", value = "发送时间", notes = "发送时间")
   @TableField("send_time")
   @Column(name = "send_time", columnDefinition = "datetime(6)  COMMENT '发送时间'", nullable = true)
   private LocalDateTime sendTime;
   @ApiModelProperty(name = "errorMessage", value = "发送失败原因", notes = "发送失败原因")
   @TableField("error_message")
   @Column(name = "error_message", columnDefinition = "varchar(255)  COMMENT '发送失败原因'", nullable = true)
   private String errorMessage;
   @ApiModelProperty(name = "compensationTime", value = "补偿发送时间", notes = "补偿发送时间")
   @TableField("compensation_time")
   @Column(name = "compensation_time", columnDefinition = "datetime(6)  COMMENT '补偿发送时间'", nullable = true)
   private LocalDateTime compensationTime;
   @ApiModelProperty(name = "chargingMethod", value = "收费方式", notes = "收费方式")
   @TableField("charging_method")
   @Column(name = "charging_method", columnDefinition = "varchar(255)  COMMENT '收费方式'", nullable = false)
   private String chargingMethod;
   @ApiModelProperty(name = "daysRemaining", value = "剩余天数", notes = "剩余天数")
   @TableField("days_remaining")
   @Column(name = "days_remaining", columnDefinition = "varchar(255)  COMMENT '剩余天数'", nullable = true)
   private String daysRemaining;

   public static SysSmsRecords.SysSmsRecordsBuilder builder() {
      return new SysSmsRecords.SysSmsRecordsBuilder();
   }

   public SysSmsRecords() {
   }

   public SysSmsRecords(
      final Long id,
      final Boolean boolSuccess,
      final Integer attemptCount,
      final LocalDateTime sendTime,
      final String errorMessage,
      final LocalDateTime compensationTime,
      final String chargingMethod,
      final String daysRemaining
   ) {
      this.id = id;
      this.boolSuccess = boolSuccess;
      this.attemptCount = attemptCount;
      this.sendTime = sendTime;
      this.errorMessage = errorMessage;
      this.compensationTime = compensationTime;
      this.chargingMethod = chargingMethod;
      this.daysRemaining = daysRemaining;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolSuccess() {
      return this.boolSuccess;
   }

   public Integer getAttemptCount() {
      return this.attemptCount;
   }

   public LocalDateTime getSendTime() {
      return this.sendTime;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public LocalDateTime getCompensationTime() {
      return this.compensationTime;
   }

   public String getChargingMethod() {
      return this.chargingMethod;
   }

   public String getDaysRemaining() {
      return this.daysRemaining;
   }

   public SysSmsRecords setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysSmsRecords setBoolSuccess(final Boolean boolSuccess) {
      this.boolSuccess = boolSuccess;
      return this;
   }

   public SysSmsRecords setAttemptCount(final Integer attemptCount) {
      this.attemptCount = attemptCount;
      return this;
   }

   public SysSmsRecords setSendTime(final LocalDateTime sendTime) {
      this.sendTime = sendTime;
      return this;
   }

   public SysSmsRecords setErrorMessage(final String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   public SysSmsRecords setCompensationTime(final LocalDateTime compensationTime) {
      this.compensationTime = compensationTime;
      return this;
   }

   public SysSmsRecords setChargingMethod(final String chargingMethod) {
      this.chargingMethod = chargingMethod;
      return this;
   }

   public SysSmsRecords setDaysRemaining(final String daysRemaining) {
      this.daysRemaining = daysRemaining;
      return this;
   }

   @Override
   public String toString() {
      return "SysSmsRecords(id="
         + this.getId()
         + ", boolSuccess="
         + this.getBoolSuccess()
         + ", attemptCount="
         + this.getAttemptCount()
         + ", sendTime="
         + this.getSendTime()
         + ", errorMessage="
         + this.getErrorMessage()
         + ", compensationTime="
         + this.getCompensationTime()
         + ", chargingMethod="
         + this.getChargingMethod()
         + ", daysRemaining="
         + this.getDaysRemaining()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSmsRecords)) {
         return false;
      }

      SysSmsRecords other = (SysSmsRecords)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSuccess = this.getBoolSuccess();
         Object other$boolSuccess = other.getBoolSuccess();
         if (this$boolSuccess == null ? other$boolSuccess == null : this$boolSuccess.equals(other$boolSuccess)) {
            Object this$attemptCount = this.getAttemptCount();
            Object other$attemptCount = other.getAttemptCount();
            if (this$attemptCount == null ? other$attemptCount == null : this$attemptCount.equals(other$attemptCount)) {
               Object this$sendTime = this.getSendTime();
               Object other$sendTime = other.getSendTime();
               if (this$sendTime == null ? other$sendTime == null : this$sendTime.equals(other$sendTime)) {
                  Object this$errorMessage = this.getErrorMessage();
                  Object other$errorMessage = other.getErrorMessage();
                  if (this$errorMessage == null ? other$errorMessage == null : this$errorMessage.equals(other$errorMessage)) {
                     Object this$compensationTime = this.getCompensationTime();
                     Object other$compensationTime = other.getCompensationTime();
                     if (this$compensationTime == null ? other$compensationTime == null : this$compensationTime.equals(other$compensationTime)) {
                        Object this$chargingMethod = this.getChargingMethod();
                        Object other$chargingMethod = other.getChargingMethod();
                        if (this$chargingMethod == null ? other$chargingMethod == null : this$chargingMethod.equals(other$chargingMethod)) {
                           Object this$daysRemaining = this.getDaysRemaining();
                           Object other$daysRemaining = other.getDaysRemaining();
                           return this$daysRemaining == null ? other$daysRemaining == null : this$daysRemaining.equals(other$daysRemaining);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysSmsRecords;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSuccess = this.getBoolSuccess();
      result = result * 59 + ($boolSuccess == null ? 43 : $boolSuccess.hashCode());
      Object $attemptCount = this.getAttemptCount();
      result = result * 59 + ($attemptCount == null ? 43 : $attemptCount.hashCode());
      Object $sendTime = this.getSendTime();
      result = result * 59 + ($sendTime == null ? 43 : $sendTime.hashCode());
      Object $errorMessage = this.getErrorMessage();
      result = result * 59 + ($errorMessage == null ? 43 : $errorMessage.hashCode());
      Object $compensationTime = this.getCompensationTime();
      result = result * 59 + ($compensationTime == null ? 43 : $compensationTime.hashCode());
      Object $chargingMethod = this.getChargingMethod();
      result = result * 59 + ($chargingMethod == null ? 43 : $chargingMethod.hashCode());
      Object $daysRemaining = this.getDaysRemaining();
      return result * 59 + ($daysRemaining == null ? 43 : $daysRemaining.hashCode());
   }

   public static class SysSmsRecordsBuilder {
      private Long id;
      private Boolean boolSuccess;
      private Integer attemptCount;
      private LocalDateTime sendTime;
      private String errorMessage;
      private LocalDateTime compensationTime;
      private String chargingMethod;
      private String daysRemaining;

      SysSmsRecordsBuilder() {
      }

      public SysSmsRecords.SysSmsRecordsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder boolSuccess(final Boolean boolSuccess) {
         this.boolSuccess = boolSuccess;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder attemptCount(final Integer attemptCount) {
         this.attemptCount = attemptCount;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder sendTime(final LocalDateTime sendTime) {
         this.sendTime = sendTime;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder errorMessage(final String errorMessage) {
         this.errorMessage = errorMessage;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder compensationTime(final LocalDateTime compensationTime) {
         this.compensationTime = compensationTime;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder chargingMethod(final String chargingMethod) {
         this.chargingMethod = chargingMethod;
         return this;
      }

      public SysSmsRecords.SysSmsRecordsBuilder daysRemaining(final String daysRemaining) {
         this.daysRemaining = daysRemaining;
         return this;
      }

      public SysSmsRecords build() {
         return new SysSmsRecords(
            this.id, this.boolSuccess, this.attemptCount, this.sendTime, this.errorMessage, this.compensationTime, this.chargingMethod, this.daysRemaining
         );
      }

      @Override
      public String toString() {
         return "SysSmsRecords.SysSmsRecordsBuilder(id="
            + this.id
            + ", boolSuccess="
            + this.boolSuccess
            + ", attemptCount="
            + this.attemptCount
            + ", sendTime="
            + this.sendTime
            + ", errorMessage="
            + this.errorMessage
            + ", compensationTime="
            + this.compensationTime
            + ", chargingMethod="
            + this.chargingMethod
            + ", daysRemaining="
            + this.daysRemaining
            + ")";
      }
   }
}
