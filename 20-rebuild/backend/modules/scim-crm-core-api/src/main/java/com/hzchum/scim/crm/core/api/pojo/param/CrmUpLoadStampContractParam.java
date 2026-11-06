package com.hzchum.scim.crm.core.api.pojo.param;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmUpLoadStampContractParam {
   @ApiModelProperty(name = "id", value = "合同id")
   private Long id;
   @ApiModelProperty(name = "attachmentDTOList", value = "合同附件")
   private List<AttachmentDTO> attachmentDTOList;

   public CrmUpLoadStampContractParam(final Long id, final List<AttachmentDTO> attachmentDTOList) {
      this.id = id;
      this.attachmentDTOList = attachmentDTOList;
   }

   public CrmUpLoadStampContractParam() {
   }

   public Long getId() {
      return this.id;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmUpLoadStampContractParam)) {
         return false;
      } else {
         CrmUpLoadStampContractParam other = (CrmUpLoadStampContractParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$attachmentDTOList = this.getAttachmentDTOList();
               Object other$attachmentDTOList = other.getAttachmentDTOList();
               return this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmUpLoadStampContractParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "CrmUpLoadStampContractParam(id=" + this.getId() + ", attachmentDTOList=" + this.getAttachmentDTOList() + ")";
   }
}
