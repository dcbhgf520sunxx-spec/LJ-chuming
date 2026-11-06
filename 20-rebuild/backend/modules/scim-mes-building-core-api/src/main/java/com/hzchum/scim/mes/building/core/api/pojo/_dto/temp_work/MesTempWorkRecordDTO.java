package com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work;

import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

@ApiModel("点工记录DTO")
public class MesTempWorkRecordDTO {
   @ApiModelProperty("上报日期")
   private LocalDateTime reportDate;
   @ApiModelProperty("创建日期")
   private LocalDateTime createTime;
   @ApiModelProperty("上报人")
   private ShowInfo reporter;
   @ApiModelProperty("班组")
   private ShowInfo team;
   @ApiModelProperty("点工类型")
   private ShowInfo tempWorkQuotaConfig;
   @ApiModelProperty("点工原因")
   private Integer reason;
   @ApiModelProperty("项目")
   private ShowInfo project;
   @ApiModelProperty("工时毫秒数")
   private Long workMilliseconds;
   @ApiModelProperty("工时(h)")
   private BigDecimal workHour;
   @ApiModelProperty("描述")
   private String description;
   @ApiModelProperty("工时单价(元/时)")
   private BigDecimal price;
   @ApiModelProperty("点工金额(元)")
   private BigDecimal amount;
   @ApiModelProperty("核算金额(元)")
   private BigDecimal calculateAmount;
   @ApiModelProperty("审批状态")
   private Integer approvalStatus;
   @ApiModelProperty("审批日志ID")
   private Long approveRecordId;
   @ApiModelProperty("审核备注")
   private String approvalRemark;
   @ApiModelProperty("审批日期")
   private LocalDateTime approvalTime;

   public BigDecimal getWorkHour() {
      if (this.workHour == null && this.getWorkMilliseconds() != null) {
         Duration duration = Duration.ofMillis(this.getWorkMilliseconds());
         return BigDecimal.valueOf(duration.toHours()).add(BigDecimal.valueOf(duration.toMinutes() % 60L / 60.0)).setScale(2, RoundingMode.HALF_UP);
      } else {
         return this.workHour;
      }
   }

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public ShowInfo getReporter() {
      return this.reporter;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public ShowInfo getTempWorkQuotaConfig() {
      return this.tempWorkQuotaConfig;
   }

   public Integer getReason() {
      return this.reason;
   }

   public ShowInfo getProject() {
      return this.project;
   }

   public Long getWorkMilliseconds() {
      return this.workMilliseconds;
   }

   public String getDescription() {
      return this.description;
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

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getApprovalRemark() {
      return this.approvalRemark;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public void setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReporter(final ShowInfo reporter) {
      this.reporter = reporter;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   public void setTempWorkQuotaConfig(final ShowInfo tempWorkQuotaConfig) {
      this.tempWorkQuotaConfig = tempWorkQuotaConfig;
   }

   public void setReason(final Integer reason) {
      this.reason = reason;
   }

   public void setProject(final ShowInfo project) {
      this.project = project;
   }

   public void setWorkMilliseconds(final Long workMilliseconds) {
      this.workMilliseconds = workMilliseconds;
   }

   public void setWorkHour(final BigDecimal workHour) {
      this.workHour = workHour;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setCalculateAmount(final BigDecimal calculateAmount) {
      this.calculateAmount = calculateAmount;
   }

   public void setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setApprovalRemark(final String approvalRemark) {
      this.approvalRemark = approvalRemark;
   }

   public void setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkRecordDTO)) {
         return false;
      }

      MesTempWorkRecordDTO other = (MesTempWorkRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reason = this.getReason();
      Object other$reason = other.getReason();
      if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
         Object this$workMilliseconds = this.getWorkMilliseconds();
         Object other$workMilliseconds = other.getWorkMilliseconds();
         if (this$workMilliseconds == null ? other$workMilliseconds == null : this$workMilliseconds.equals(other$workMilliseconds)) {
            Object this$approvalStatus = this.getApprovalStatus();
            Object other$approvalStatus = other.getApprovalStatus();
            if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$reportDate = this.getReportDate();
                  Object other$reportDate = other.getReportDate();
                  if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$reporter = this.getReporter();
                        Object other$reporter = other.getReporter();
                        if (this$reporter == null ? other$reporter == null : this$reporter.equals(other$reporter)) {
                           Object this$team = this.getTeam();
                           Object other$team = other.getTeam();
                           if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                              Object this$tempWorkQuotaConfig = this.getTempWorkQuotaConfig();
                              Object other$tempWorkQuotaConfig = other.getTempWorkQuotaConfig();
                              if (this$tempWorkQuotaConfig == null
                                 ? other$tempWorkQuotaConfig == null
                                 : this$tempWorkQuotaConfig.equals(other$tempWorkQuotaConfig)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$workHour = this.getWorkHour();
                                    Object other$workHour = other.getWorkHour();
                                    if (this$workHour == null ? other$workHour == null : this$workHour.equals(other$workHour)) {
                                       Object this$description = this.getDescription();
                                       Object other$description = other.getDescription();
                                       if (this$description == null ? other$description == null : this$description.equals(other$description)) {
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
                                                   Object this$approvalRemark = this.getApprovalRemark();
                                                   Object other$approvalRemark = other.getApprovalRemark();
                                                   if (this$approvalRemark == null
                                                      ? other$approvalRemark == null
                                                      : this$approvalRemark.equals(other$approvalRemark)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesTempWorkRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $workMilliseconds = this.getWorkMilliseconds();
      result = result * 59 + ($workMilliseconds == null ? 43 : $workMilliseconds.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reporter = this.getReporter();
      result = result * 59 + ($reporter == null ? 43 : $reporter.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $tempWorkQuotaConfig = this.getTempWorkQuotaConfig();
      result = result * 59 + ($tempWorkQuotaConfig == null ? 43 : $tempWorkQuotaConfig.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workHour = this.getWorkHour();
      result = result * 59 + ($workHour == null ? 43 : $workHour.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $calculateAmount = this.getCalculateAmount();
      result = result * 59 + ($calculateAmount == null ? 43 : $calculateAmount.hashCode());
      Object $approvalRemark = this.getApprovalRemark();
      result = result * 59 + ($approvalRemark == null ? 43 : $approvalRemark.hashCode());
      Object $approvalTime = this.getApprovalTime();
      return result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkRecordDTO(reportDate="
         + this.getReportDate()
         + ", createTime="
         + this.getCreateTime()
         + ", reporter="
         + this.getReporter()
         + ", team="
         + this.getTeam()
         + ", tempWorkQuotaConfig="
         + this.getTempWorkQuotaConfig()
         + ", reason="
         + this.getReason()
         + ", project="
         + this.getProject()
         + ", workMilliseconds="
         + this.getWorkMilliseconds()
         + ", workHour="
         + this.getWorkHour()
         + ", description="
         + this.getDescription()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", calculateAmount="
         + this.getCalculateAmount()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", approvalRemark="
         + this.getApprovalRemark()
         + ", approvalTime="
         + this.getApprovalTime()
         + ")";
   }
}
