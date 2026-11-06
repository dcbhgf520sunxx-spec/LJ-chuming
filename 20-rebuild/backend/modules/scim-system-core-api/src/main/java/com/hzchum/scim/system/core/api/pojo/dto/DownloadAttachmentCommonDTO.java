package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;

public class DownloadAttachmentCommonDTO {
   @ApiModelProperty(name = "attachmentDTOList", notes = "附件集合")
   @NotEmpty(message = "列表不可为空")
   private List<AttachmentDTO> attachmentDTOList;

   public DownloadAttachmentCommonDTO(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   public DownloadAttachmentCommonDTO() {
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DownloadAttachmentCommonDTO)) {
         return false;
      }

      DownloadAttachmentCommonDTO other = (DownloadAttachmentCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$attachmentDTOList = this.getAttachmentDTOList();
      Object other$attachmentDTOList = other.getAttachmentDTOList();
      return this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DownloadAttachmentCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "DownloadAttachmentCommonDTO(attachmentDTOList=" + this.getAttachmentDTOList() + ")";
   }
}
