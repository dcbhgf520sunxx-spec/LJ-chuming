package com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work;

import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("点工DTO类")
public class MesTempWorkDTO extends MesTempWork {
   @ApiModelProperty("上报人名称")
   private String reporterName;
   @ApiModelProperty("所属班组组长ID")
   private Long teamLeaderId;
   @ApiModelProperty("所属班组组长名称")
   private String teamLeaderName;
   @ApiModelProperty("点工类型名称")
   private String tempWorkQuotaConfigName;
   @ApiModelProperty("项目名称")
   private String projectName;
   private WmsApproveRecordFlowDTO approveRecord;

   public String getReporterName() {
      return this.reporterName;
   }

   public Long getTeamLeaderId() {
      return this.teamLeaderId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public String getTempWorkQuotaConfigName() {
      return this.tempWorkQuotaConfigName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public WmsApproveRecordFlowDTO getApproveRecord() {
      return this.approveRecord;
   }

   public void setReporterName(final String reporterName) {
      this.reporterName = reporterName;
   }

   public void setTeamLeaderId(final Long teamLeaderId) {
      this.teamLeaderId = teamLeaderId;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   public void setTempWorkQuotaConfigName(final String tempWorkQuotaConfigName) {
      this.tempWorkQuotaConfigName = tempWorkQuotaConfigName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setApproveRecord(final WmsApproveRecordFlowDTO approveRecord) {
      this.approveRecord = approveRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkDTO)) {
         return false;
      }

      MesTempWorkDTO other = (MesTempWorkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$teamLeaderId = this.getTeamLeaderId();
      Object other$teamLeaderId = other.getTeamLeaderId();
      if (this$teamLeaderId == null ? other$teamLeaderId == null : this$teamLeaderId.equals(other$teamLeaderId)) {
         Object this$reporterName = this.getReporterName();
         Object other$reporterName = other.getReporterName();
         if (this$reporterName == null ? other$reporterName == null : this$reporterName.equals(other$reporterName)) {
            Object this$teamLeaderName = this.getTeamLeaderName();
            Object other$teamLeaderName = other.getTeamLeaderName();
            if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
               Object this$tempWorkQuotaConfigName = this.getTempWorkQuotaConfigName();
               Object other$tempWorkQuotaConfigName = other.getTempWorkQuotaConfigName();
               if (this$tempWorkQuotaConfigName == null
                  ? other$tempWorkQuotaConfigName == null
                  : this$tempWorkQuotaConfigName.equals(other$tempWorkQuotaConfigName)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$approveRecord = this.getApproveRecord();
                     Object other$approveRecord = other.getApproveRecord();
                     return this$approveRecord == null ? other$approveRecord == null : this$approveRecord.equals(other$approveRecord);
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
      return other instanceof MesTempWorkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $teamLeaderId = this.getTeamLeaderId();
      result = result * 59 + ($teamLeaderId == null ? 43 : $teamLeaderId.hashCode());
      Object $reporterName = this.getReporterName();
      result = result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $tempWorkQuotaConfigName = this.getTempWorkQuotaConfigName();
      result = result * 59 + ($tempWorkQuotaConfigName == null ? 43 : $tempWorkQuotaConfigName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $approveRecord = this.getApproveRecord();
      return result * 59 + ($approveRecord == null ? 43 : $approveRecord.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkDTO(super="
         + super.toString()
         + ", reporterName="
         + this.getReporterName()
         + ", teamLeaderId="
         + this.getTeamLeaderId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", tempWorkQuotaConfigName="
         + this.getTempWorkQuotaConfigName()
         + ", projectName="
         + this.getProjectName()
         + ", approveRecord="
         + this.getApproveRecord()
         + ")";
   }
}
