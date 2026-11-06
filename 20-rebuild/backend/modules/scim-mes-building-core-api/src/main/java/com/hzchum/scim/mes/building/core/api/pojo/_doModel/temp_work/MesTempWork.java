package com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesTempWork对象", description = "点工管理表")
@Entity
@TableName("mes_temp_work")
@Table(name = "mes_temp_work")
@org.hibernate.annotations.Table(appliesTo = "mes_temp_work", comment = "点工管理表")
public class MesTempWork extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("上报日期")
   @TableField("report_date")
   @Column(name = "report_date", columnDefinition = "datetime COMMENT '上报日期'", nullable = true)
   private LocalDateTime reportDate;
   @ApiModelProperty("上报人ID")
   @TableField("reporter_id")
   @Column(name = "reporter_id", columnDefinition = "bigint(20) COMMENT '上报人ID'", nullable = true)
   private Long reporterId;
   @ApiModelProperty("所属班组ID")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) COMMENT '所属班组ID'", nullable = true)
   private Long teamId;
   @ApiModelProperty("点工类别ID")
   @TableField("temp_work_quota_config_id")
   @Column(name = "temp_work_quota_config_id", columnDefinition = "bigint(20) COMMENT '点工类别ID'", nullable = true)
   private Long tempWorkQuotaConfigId;
   @ApiModelProperty("点工原因")
   @TableField("reason")
   @Column(name = "reason", columnDefinition = "int(11) COMMENT '点工原因'", nullable = true)
   private Integer reason;
   @ApiModelProperty("项目ID")
   @TableField(value = "project_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty("工时毫秒数")
   @TableField("work_milliseconds")
   @Column(name = "work_milliseconds", columnDefinition = "bigint(20) COMMENT '工时毫秒数'", nullable = true)
   private Long workMilliseconds;
   @ApiModelProperty("工时单价(元/小时)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '工时单价(元/小时)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("点工金额(元)")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8) COMMENT '点工金额(元)'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty("核算金额(元)")
   @TableField("calculate_amount")
   @Column(name = "calculate_amount", columnDefinition = "decimal(32,8) COMMENT '核算金额(元)'", nullable = true)
   private BigDecimal calculateAmount;
   @ApiModelProperty("描述")
   @TableField(value = "description", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "description", columnDefinition = "varchar(255) COMMENT '描述'", nullable = true)
   private String description;
   @ApiModelProperty("审批状态")
   @TableField("approval_status")
   @Column(name = "approval_status", columnDefinition = "int(11) COMMENT '审批状态'", nullable = true)
   private Integer approvalStatus;
   @ApiModelProperty("审批日志ID")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20) COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty("审批日志编号")
   @TableField("approve_record_serial_number")
   @Column(name = "approve_record_serial_number", columnDefinition = "varchar(255) COMMENT '审批日志编号'", nullable = true)
   private String approveRecordSerialNumber;
   @ApiModelProperty("审批日期")
   @TableField("approval_time")
   @Column(name = "approval_time", columnDefinition = "datetime COMMENT '审批日期'", nullable = true)
   private LocalDateTime approvalTime;
   @ApiModelProperty("审批人id")
   @TableField("approval_user_id")
   @Column(name = "approval_user_id", columnDefinition = "bigint(20) COMMENT '审批人id'", nullable = true)
   private Long approvalUserId;

   public static MesTempWork.MesTempWorkBuilder builder() {
      return new MesTempWork.MesTempWorkBuilder();
   }

   public MesTempWork() {
   }

   public MesTempWork(
      final Long id,
      final LocalDateTime reportDate,
      final Long reporterId,
      final Long teamId,
      final Long tempWorkQuotaConfigId,
      final Integer reason,
      final Long projectId,
      final Long workMilliseconds,
      final BigDecimal price,
      final BigDecimal amount,
      final BigDecimal calculateAmount,
      final String description,
      final Integer approvalStatus,
      final Long approveRecordId,
      final String approveRecordSerialNumber,
      final LocalDateTime approvalTime,
      final Long approvalUserId
   ) {
      this.id = id;
      this.reportDate = reportDate;
      this.reporterId = reporterId;
      this.teamId = teamId;
      this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
      this.reason = reason;
      this.projectId = projectId;
      this.workMilliseconds = workMilliseconds;
      this.price = price;
      this.amount = amount;
      this.calculateAmount = calculateAmount;
      this.description = description;
      this.approvalStatus = approvalStatus;
      this.approveRecordId = approveRecordId;
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      this.approvalTime = approvalTime;
      this.approvalUserId = approvalUserId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public Long getReporterId() {
      return this.reporterId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getTempWorkQuotaConfigId() {
      return this.tempWorkQuotaConfigId;
   }

   public Integer getReason() {
      return this.reason;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkMilliseconds() {
      return this.workMilliseconds;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getCalculateAmount() {
      return this.calculateAmount;
   }

   public String getDescription() {
      return this.description;
   }

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getApproveRecordSerialNumber() {
      return this.approveRecordSerialNumber;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public Long getApprovalUserId() {
      return this.approvalUserId;
   }

   public MesTempWork setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesTempWork setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
      return this;
   }

   public MesTempWork setReporterId(final Long reporterId) {
      this.reporterId = reporterId;
      return this;
   }

   public MesTempWork setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesTempWork setTempWorkQuotaConfigId(final Long tempWorkQuotaConfigId) {
      this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
      return this;
   }

   public MesTempWork setReason(final Integer reason) {
      this.reason = reason;
      return this;
   }

   public MesTempWork setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesTempWork setWorkMilliseconds(final Long workMilliseconds) {
      this.workMilliseconds = workMilliseconds;
      return this;
   }

   public MesTempWork setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesTempWork setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public MesTempWork setCalculateAmount(final BigDecimal calculateAmount) {
      this.calculateAmount = calculateAmount;
      return this;
   }

   public MesTempWork setDescription(final String description) {
      this.description = description;
      return this;
   }

   public MesTempWork setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
      return this;
   }

   public MesTempWork setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public MesTempWork setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      return this;
   }

   public MesTempWork setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
      return this;
   }

   public MesTempWork setApprovalUserId(final Long approvalUserId) {
      this.approvalUserId = approvalUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesTempWork(id="
         + this.getId()
         + ", reportDate="
         + this.getReportDate()
         + ", reporterId="
         + this.getReporterId()
         + ", teamId="
         + this.getTeamId()
         + ", tempWorkQuotaConfigId="
         + this.getTempWorkQuotaConfigId()
         + ", reason="
         + this.getReason()
         + ", projectId="
         + this.getProjectId()
         + ", workMilliseconds="
         + this.getWorkMilliseconds()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", calculateAmount="
         + this.getCalculateAmount()
         + ", description="
         + this.getDescription()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", approvalUserId="
         + this.getApprovalUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWork)) {
         return false;
      }

      MesTempWork other = (MesTempWork)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reporterId = this.getReporterId();
         Object other$reporterId = other.getReporterId();
         if (this$reporterId == null ? other$reporterId == null : this$reporterId.equals(other$reporterId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$tempWorkQuotaConfigId = this.getTempWorkQuotaConfigId();
               Object other$tempWorkQuotaConfigId = other.getTempWorkQuotaConfigId();
               if (this$tempWorkQuotaConfigId == null ? other$tempWorkQuotaConfigId == null : this$tempWorkQuotaConfigId.equals(other$tempWorkQuotaConfigId)) {
                  Object this$reason = this.getReason();
                  Object other$reason = other.getReason();
                  if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$workMilliseconds = this.getWorkMilliseconds();
                        Object other$workMilliseconds = other.getWorkMilliseconds();
                        if (this$workMilliseconds == null ? other$workMilliseconds == null : this$workMilliseconds.equals(other$workMilliseconds)) {
                           Object this$approvalStatus = this.getApprovalStatus();
                           Object other$approvalStatus = other.getApprovalStatus();
                           if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
                              Object this$approveRecordId = this.getApproveRecordId();
                              Object other$approveRecordId = other.getApproveRecordId();
                              if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                 Object this$approvalUserId = this.getApprovalUserId();
                                 Object other$approvalUserId = other.getApprovalUserId();
                                 if (this$approvalUserId == null ? other$approvalUserId == null : this$approvalUserId.equals(other$approvalUserId)) {
                                    Object this$reportDate = this.getReportDate();
                                    Object other$reportDate = other.getReportDate();
                                    if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                       Object this$price = this.getPrice();
                                       Object other$price = other.getPrice();
                                       if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                          Object this$amount = this.getAmount();
                                          Object other$amount = other.getAmount();
                                          if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                             Object this$calculateAmount = this.getCalculateAmount();
                                             Object other$calculateAmount = other.getCalculateAmount();
                                             if (this$calculateAmount == null
                                                ? other$calculateAmount == null
                                                : this$calculateAmount.equals(other$calculateAmount)) {
                                                Object this$description = this.getDescription();
                                                Object other$description = other.getDescription();
                                                if (this$description == null ? other$description == null : this$description.equals(other$description)) {
                                                   Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
                                                   Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
                                                   if (this$approveRecordSerialNumber == null
                                                      ? other$approveRecordSerialNumber == null
                                                      : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber)) {
                                                      Object this$approvalTime = this.getApprovalTime();
                                                      Object other$approvalTime = other.getApprovalTime();
                                                      return this$approvalTime == null
                                                         ? other$approvalTime == null
                                                         : this$approvalTime.equals(other$approvalTime);
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
      return other instanceof MesTempWork;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reporterId = this.getReporterId();
      result = result * 59 + ($reporterId == null ? 43 : $reporterId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $tempWorkQuotaConfigId = this.getTempWorkQuotaConfigId();
      result = result * 59 + ($tempWorkQuotaConfigId == null ? 43 : $tempWorkQuotaConfigId.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workMilliseconds = this.getWorkMilliseconds();
      result = result * 59 + ($workMilliseconds == null ? 43 : $workMilliseconds.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $approvalUserId = this.getApprovalUserId();
      result = result * 59 + ($approvalUserId == null ? 43 : $approvalUserId.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $calculateAmount = this.getCalculateAmount();
      result = result * 59 + ($calculateAmount == null ? 43 : $calculateAmount.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      result = result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
      Object $approvalTime = this.getApprovalTime();
      return result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
   }

   public static class MesTempWorkBuilder {
      private Long id;
      private LocalDateTime reportDate;
      private Long reporterId;
      private Long teamId;
      private Long tempWorkQuotaConfigId;
      private Integer reason;
      private Long projectId;
      private Long workMilliseconds;
      private BigDecimal price;
      private BigDecimal amount;
      private BigDecimal calculateAmount;
      private String description;
      private Integer approvalStatus;
      private Long approveRecordId;
      private String approveRecordSerialNumber;
      private LocalDateTime approvalTime;
      private Long approvalUserId;

      MesTempWorkBuilder() {
      }

      public MesTempWork.MesTempWorkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder reportDate(final LocalDateTime reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder reporterId(final Long reporterId) {
         this.reporterId = reporterId;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder tempWorkQuotaConfigId(final Long tempWorkQuotaConfigId) {
         this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder reason(final Integer reason) {
         this.reason = reason;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder workMilliseconds(final Long workMilliseconds) {
         this.workMilliseconds = workMilliseconds;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder calculateAmount(final BigDecimal calculateAmount) {
         this.calculateAmount = calculateAmount;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder description(final String description) {
         this.description = description;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder approvalTime(final LocalDateTime approvalTime) {
         this.approvalTime = approvalTime;
         return this;
      }

      public MesTempWork.MesTempWorkBuilder approvalUserId(final Long approvalUserId) {
         this.approvalUserId = approvalUserId;
         return this;
      }

      public MesTempWork build() {
         return new MesTempWork(
            this.id,
            this.reportDate,
            this.reporterId,
            this.teamId,
            this.tempWorkQuotaConfigId,
            this.reason,
            this.projectId,
            this.workMilliseconds,
            this.price,
            this.amount,
            this.calculateAmount,
            this.description,
            this.approvalStatus,
            this.approveRecordId,
            this.approveRecordSerialNumber,
            this.approvalTime,
            this.approvalUserId
         );
      }

      @Override
      public String toString() {
         return "MesTempWork.MesTempWorkBuilder(id="
            + this.id
            + ", reportDate="
            + this.reportDate
            + ", reporterId="
            + this.reporterId
            + ", teamId="
            + this.teamId
            + ", tempWorkQuotaConfigId="
            + this.tempWorkQuotaConfigId
            + ", reason="
            + this.reason
            + ", projectId="
            + this.projectId
            + ", workMilliseconds="
            + this.workMilliseconds
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", calculateAmount="
            + this.calculateAmount
            + ", description="
            + this.description
            + ", approvalStatus="
            + this.approvalStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ", approvalTime="
            + this.approvalTime
            + ", approvalUserId="
            + this.approvalUserId
            + ")";
      }
   }
}
