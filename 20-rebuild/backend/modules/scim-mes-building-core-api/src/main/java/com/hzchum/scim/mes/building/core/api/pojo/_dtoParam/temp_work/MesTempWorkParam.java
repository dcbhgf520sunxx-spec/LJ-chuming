package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.temp_work.TempWorkReasonEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("点工新增修改参数")
public class MesTempWorkParam {
   @ApiModelProperty("上报日期")
   @NotNull(message = "上报日期不能为空")
   private LocalDateTime reportDate;
   @ApiModelProperty("上报人ID")
   @NotNull(message = "上报人不能为空")
   private Long reporterId;
   @ApiModelProperty("所属班组ID")
   @NotNull(message = "所属班组不能为空")
   private Long teamId;
   @ApiModelProperty("点工类别ID")
   @NotNull(message = "点工类别不能为空")
   private Long tempWorkQuotaConfigId;
   @ApiModelProperty("点工原因")
   @NotNull(message = "点工原因不能为空")
   @EnumValidator(value = TempWorkReasonEnum.class, message = "点工原因不存在")
   private Integer reason;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @NotNull(message = "工时不能为空")
   @ApiModelProperty("工时毫秒数")
   private Long workMilliseconds;
   @ApiModelProperty("描述")
   private String description;

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

   public String getDescription() {
      return this.description;
   }

   public void setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
   }

   public void setReporterId(final Long reporterId) {
      this.reporterId = reporterId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setTempWorkQuotaConfigId(final Long tempWorkQuotaConfigId) {
      this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
   }

   public void setReason(final Integer reason) {
      this.reason = reason;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkMilliseconds(final Long workMilliseconds) {
      this.workMilliseconds = workMilliseconds;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkParam)) {
         return false;
      }

      MesTempWorkParam other = (MesTempWorkParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                        Object this$reportDate = this.getReportDate();
                        Object other$reportDate = other.getReportDate();
                        if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                           Object this$description = this.getDescription();
                           Object other$description = other.getDescription();
                           return this$description == null ? other$description == null : this$description.equals(other$description);
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
      return other instanceof MesTempWorkParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $description = this.getDescription();
      return result * 59 + ($description == null ? 43 : $description.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkParam(reportDate="
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
         + ", description="
         + this.getDescription()
         + ")";
   }
}
