package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmProjectFollowUpRecordSaveParam {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "followUpDate", value = "本次跟进日期", notes = "本次跟进日期")
   private LocalDateTime followUpDate;
   @ApiModelProperty(name = "followUpMethods", value = "跟进方式   CrmProjectInformationConfig", notes = "跟进方式   CrmProjectInformationConfig")
   private Long followUpMethods;
   @ApiModelProperty(name = "followUpAttachment", value = "跟进附件", notes = "跟进附件")
   private List<AttachmentDTO> followUpAttachment;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public LocalDateTime getFollowUpDate() {
      return this.followUpDate;
   }

   public Long getFollowUpMethods() {
      return this.followUpMethods;
   }

   public List<AttachmentDTO> getFollowUpAttachment() {
      return this.followUpAttachment;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setFollowUpDate(final LocalDateTime followUpDate) {
      this.followUpDate = followUpDate;
   }

   public void setFollowUpMethods(final Long followUpMethods) {
      this.followUpMethods = followUpMethods;
   }

   public void setFollowUpAttachment(final List<AttachmentDTO> followUpAttachment) {
      this.followUpAttachment = followUpAttachment;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectFollowUpRecordSaveParam)) {
         return false;
      }

      CrmProjectFollowUpRecordSaveParam other = (CrmProjectFollowUpRecordSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$followUpMethods = this.getFollowUpMethods();
         Object other$followUpMethods = other.getFollowUpMethods();
         if (this$followUpMethods == null ? other$followUpMethods == null : this$followUpMethods.equals(other$followUpMethods)) {
            Object this$followUpDate = this.getFollowUpDate();
            Object other$followUpDate = other.getFollowUpDate();
            if (this$followUpDate == null ? other$followUpDate == null : this$followUpDate.equals(other$followUpDate)) {
               Object this$followUpAttachment = this.getFollowUpAttachment();
               Object other$followUpAttachment = other.getFollowUpAttachment();
               if (this$followUpAttachment == null ? other$followUpAttachment == null : this$followUpAttachment.equals(other$followUpAttachment)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof CrmProjectFollowUpRecordSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $followUpMethods = this.getFollowUpMethods();
      result = result * 59 + ($followUpMethods == null ? 43 : $followUpMethods.hashCode());
      Object $followUpDate = this.getFollowUpDate();
      result = result * 59 + ($followUpDate == null ? 43 : $followUpDate.hashCode());
      Object $followUpAttachment = this.getFollowUpAttachment();
      result = result * 59 + ($followUpAttachment == null ? 43 : $followUpAttachment.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectFollowUpRecordSaveParam(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", followUpDate="
         + this.getFollowUpDate()
         + ", followUpMethods="
         + this.getFollowUpMethods()
         + ", followUpAttachment="
         + this.getFollowUpAttachment()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public CrmProjectFollowUpRecordSaveParam(
      final Long crmProjectInformationWarehousingId,
      final LocalDateTime followUpDate,
      final Long followUpMethods,
      final List<AttachmentDTO> followUpAttachment,
      final String remark
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.followUpDate = followUpDate;
      this.followUpMethods = followUpMethods;
      this.followUpAttachment = followUpAttachment;
      this.remark = remark;
   }

   public CrmProjectFollowUpRecordSaveParam() {
   }
}
