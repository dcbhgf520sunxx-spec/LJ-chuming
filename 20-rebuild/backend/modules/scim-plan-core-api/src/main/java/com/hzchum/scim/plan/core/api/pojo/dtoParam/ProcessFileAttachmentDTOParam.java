package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProcessFileAttachmentDTOParam {
   @ApiModelProperty(name = "id", value = "上传附件id", notes = "上传附件id")
   @NotNull(message = "上传附件id不能为空")
   private Long attachmentId;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @NotBlank(message = "文件名称不能为空!")
   @Size(max = 50, message = "文件名称不要超过50个字符!")
   private String fileName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 200, message = "备注字数请限制在200字以内!")
   private String remark;

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessFileAttachmentDTOParam)) {
         return false;
      }

      ProcessFileAttachmentDTOParam other = (ProcessFileAttachmentDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$attachmentId = this.getAttachmentId();
      Object other$attachmentId = other.getAttachmentId();
      if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
         Object this$fileName = this.getFileName();
         Object other$fileName = other.getFileName();
         if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessFileAttachmentDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProcessFileAttachmentDTOParam(attachmentId=" + this.getAttachmentId() + ", fileName=" + this.getFileName() + ", remark=" + this.getRemark() + ")";
   }
}
