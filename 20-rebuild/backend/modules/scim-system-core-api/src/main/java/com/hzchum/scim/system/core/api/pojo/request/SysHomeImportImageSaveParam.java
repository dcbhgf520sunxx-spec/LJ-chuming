package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysHomeImportImageSaveParam {
   @ApiModelProperty(name = "attachmentIds", value = "附件ids ", notes = "附件ids ")
   private List<AttachmentDTO> attachmentIds;

   public SysHomeImportImageSaveParam(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public SysHomeImportImageSaveParam() {
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeImportImageSaveParam)) {
         return false;
      }

      SysHomeImportImageSaveParam other = (SysHomeImportImageSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$attachmentIds = this.getAttachmentIds();
      Object other$attachmentIds = other.getAttachmentIds();
      return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeImportImageSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeImportImageSaveParam(attachmentIds=" + this.getAttachmentIds() + ")";
   }
}
