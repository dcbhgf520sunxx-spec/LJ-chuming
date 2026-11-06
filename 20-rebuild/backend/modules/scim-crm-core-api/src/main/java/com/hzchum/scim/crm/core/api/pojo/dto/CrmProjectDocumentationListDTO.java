package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import java.time.LocalDateTime;

public class CrmProjectDocumentationListDTO {
   private LocalDateTime createTime;
   private String importUserName;
   private String fileTypeName;
   private AttachmentDTO attachmentDTO;

   public static CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder builder() {
      return new CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder();
   }

   public CrmProjectDocumentationListDTO() {
   }

   public CrmProjectDocumentationListDTO(
      final LocalDateTime createTime, final String importUserName, final String fileTypeName, final AttachmentDTO attachmentDTO
   ) {
      this.createTime = createTime;
      this.importUserName = importUserName;
      this.fileTypeName = fileTypeName;
      this.attachmentDTO = attachmentDTO;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getImportUserName() {
      return this.importUserName;
   }

   public String getFileTypeName() {
      return this.fileTypeName;
   }

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
   }

   public CrmProjectDocumentationListDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmProjectDocumentationListDTO setImportUserName(final String importUserName) {
      this.importUserName = importUserName;
      return this;
   }

   public CrmProjectDocumentationListDTO setFileTypeName(final String fileTypeName) {
      this.fileTypeName = fileTypeName;
      return this;
   }

   public CrmProjectDocumentationListDTO setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectDocumentationListDTO(createTime="
         + this.getCreateTime()
         + ", importUserName="
         + this.getImportUserName()
         + ", fileTypeName="
         + this.getFileTypeName()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectDocumentationListDTO)) {
         return false;
      }

      CrmProjectDocumentationListDTO other = (CrmProjectDocumentationListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$importUserName = this.getImportUserName();
         Object other$importUserName = other.getImportUserName();
         if (this$importUserName == null ? other$importUserName == null : this$importUserName.equals(other$importUserName)) {
            Object this$fileTypeName = this.getFileTypeName();
            Object other$fileTypeName = other.getFileTypeName();
            if (this$fileTypeName == null ? other$fileTypeName == null : this$fileTypeName.equals(other$fileTypeName)) {
               Object this$attachmentDTO = this.getAttachmentDTO();
               Object other$attachmentDTO = other.getAttachmentDTO();
               return this$attachmentDTO == null ? other$attachmentDTO == null : this$attachmentDTO.equals(other$attachmentDTO);
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
      return other instanceof CrmProjectDocumentationListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $importUserName = this.getImportUserName();
      result = result * 59 + ($importUserName == null ? 43 : $importUserName.hashCode());
      Object $fileTypeName = this.getFileTypeName();
      result = result * 59 + ($fileTypeName == null ? 43 : $fileTypeName.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      return result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
   }

   public static class CrmProjectDocumentationListDTOBuilder {
      private LocalDateTime createTime;
      private String importUserName;
      private String fileTypeName;
      private AttachmentDTO attachmentDTO;

      CrmProjectDocumentationListDTOBuilder() {
      }

      public CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder importUserName(final String importUserName) {
         this.importUserName = importUserName;
         return this;
      }

      public CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder fileTypeName(final String fileTypeName) {
         this.fileTypeName = fileTypeName;
         return this;
      }

      public CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder attachmentDTO(final AttachmentDTO attachmentDTO) {
         this.attachmentDTO = attachmentDTO;
         return this;
      }

      public CrmProjectDocumentationListDTO build() {
         return new CrmProjectDocumentationListDTO(this.createTime, this.importUserName, this.fileTypeName, this.attachmentDTO);
      }

      @Override
      public String toString() {
         return "CrmProjectDocumentationListDTO.CrmProjectDocumentationListDTOBuilder(createTime="
            + this.createTime
            + ", importUserName="
            + this.importUserName
            + ", fileTypeName="
            + this.fileTypeName
            + ", attachmentDTO="
            + this.attachmentDTO
            + ")";
      }
   }
}
