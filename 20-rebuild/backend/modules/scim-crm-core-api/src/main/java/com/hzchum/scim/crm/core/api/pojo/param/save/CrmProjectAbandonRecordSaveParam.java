package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

public class CrmProjectAbandonRecordSaveParam {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "abandonDate", value = "放弃日期", notes = "放弃日期")
   private LocalDate abandonDate;
   @ApiModelProperty(name = "abandonAttachment", value = "放弃证明", notes = "放弃证明")
   private List<AttachmentDTO> abandonAttachment;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public LocalDate getAbandonDate() {
      return this.abandonDate;
   }

   public List<AttachmentDTO> getAbandonAttachment() {
      return this.abandonAttachment;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setAbandonDate(final LocalDate abandonDate) {
      this.abandonDate = abandonDate;
   }

   public void setAbandonAttachment(final List<AttachmentDTO> abandonAttachment) {
      this.abandonAttachment = abandonAttachment;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectAbandonRecordSaveParam)) {
         return false;
      }

      CrmProjectAbandonRecordSaveParam other = (CrmProjectAbandonRecordSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$abandonDate = this.getAbandonDate();
         Object other$abandonDate = other.getAbandonDate();
         if (this$abandonDate == null ? other$abandonDate == null : this$abandonDate.equals(other$abandonDate)) {
            Object this$abandonAttachment = this.getAbandonAttachment();
            Object other$abandonAttachment = other.getAbandonAttachment();
            if (this$abandonAttachment == null ? other$abandonAttachment == null : this$abandonAttachment.equals(other$abandonAttachment)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectAbandonRecordSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $abandonDate = this.getAbandonDate();
      result = result * 59 + ($abandonDate == null ? 43 : $abandonDate.hashCode());
      Object $abandonAttachment = this.getAbandonAttachment();
      result = result * 59 + ($abandonAttachment == null ? 43 : $abandonAttachment.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectAbandonRecordSaveParam(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", abandonDate="
         + this.getAbandonDate()
         + ", abandonAttachment="
         + this.getAbandonAttachment()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public CrmProjectAbandonRecordSaveParam(
      final Long crmProjectInformationWarehousingId, final LocalDate abandonDate, final List<AttachmentDTO> abandonAttachment, final String remark
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.abandonDate = abandonDate;
      this.abandonAttachment = abandonAttachment;
      this.remark = remark;
   }

   public CrmProjectAbandonRecordSaveParam() {
   }
}
