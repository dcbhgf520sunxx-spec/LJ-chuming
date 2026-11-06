package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysHomeImportImagePageDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件集合", notes = "附件集合")
   private List<AttachmentDTO> attachmentDTOList;

   public static SysHomeImportImagePageDTO.SysHomeImportImagePageDTOBuilder builder() {
      return new SysHomeImportImagePageDTO.SysHomeImportImagePageDTOBuilder();
   }

   public SysHomeImportImagePageDTO() {
   }

   public SysHomeImportImagePageDTO(final Long id, final List<AttachmentDTO> attachmentDTOList) {
      this.id = id;
      this.attachmentDTOList = attachmentDTOList;
   }

   public Long getId() {
      return this.id;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public SysHomeImportImagePageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeImportImagePageDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeImportImagePageDTO(id=" + this.getId() + ", attachmentDTOList=" + this.getAttachmentDTOList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysHomeImportImagePageDTO)) {
         return false;
      } else {
         SysHomeImportImagePageDTO other = (SysHomeImportImagePageDTO)o;
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
      return other instanceof SysHomeImportImagePageDTO;
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

   public static class SysHomeImportImagePageDTOBuilder {
      private Long id;
      private List<AttachmentDTO> attachmentDTOList;

      SysHomeImportImagePageDTOBuilder() {
      }

      public SysHomeImportImagePageDTO.SysHomeImportImagePageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeImportImagePageDTO.SysHomeImportImagePageDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public SysHomeImportImagePageDTO build() {
         return new SysHomeImportImagePageDTO(this.id, this.attachmentDTOList);
      }

      @Override
      public String toString() {
         return "SysHomeImportImagePageDTO.SysHomeImportImagePageDTOBuilder(id=" + this.id + ", attachmentDTOList=" + this.attachmentDTOList + ")";
      }
   }
}
