package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class PlanTechnologicalAchievementApproveRecordDTO extends PlanTechnologicalAchievementApproveRecord {
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "applicantName", value = " 申请人姓名", notes = " 申请人姓名")
   private String applicantName;
   @ApiModelProperty(name = "areaName", value = " 区域名称", notes = " 区域名称")
   private String areaName;
   @ApiModelProperty(name = "attachments", value = " 附件")
   private List<AttachmentDTO> attachments;

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanTechnologicalAchievementApproveRecordDTO)) {
         return false;
      }

      PlanTechnologicalAchievementApproveRecordDTO other = (PlanTechnologicalAchievementApproveRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$monomerName = this.getMonomerName();
         Object other$monomerName = other.getMonomerName();
         if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
            Object this$applicantName = this.getApplicantName();
            Object other$applicantName = other.getApplicantName();
            if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
               Object this$areaName = this.getAreaName();
               Object other$areaName = other.getAreaName();
               if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                  Object this$attachments = this.getAttachments();
                  Object other$attachments = other.getAttachments();
                  return this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments);
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
      return other instanceof PlanTechnologicalAchievementApproveRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "PlanTechnologicalAchievementApproveRecordDTO(projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", applicantName="
         + this.getApplicantName()
         + ", areaName="
         + this.getAreaName()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }
}
