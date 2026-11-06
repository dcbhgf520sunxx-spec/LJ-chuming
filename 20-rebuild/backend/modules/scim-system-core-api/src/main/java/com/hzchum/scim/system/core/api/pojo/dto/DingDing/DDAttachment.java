package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DDAttachment {
   @JsonProperty("spaceId")
   private String spaceId;
   @JsonProperty("fileName")
   private String fileName;
   @JsonProperty("fileSize")
   private Long fileSize;
   @JsonProperty("fileType")
   private String fileType;
   @JsonProperty("fileId")
   private String fileId;

   public static DDAttachment.DDAttachmentBuilder builder() {
      return new DDAttachment.DDAttachmentBuilder();
   }

   public String getSpaceId() {
      return this.spaceId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public Long getFileSize() {
      return this.fileSize;
   }

   public String getFileType() {
      return this.fileType;
   }

   public String getFileId() {
      return this.fileId;
   }

   @JsonProperty("spaceId")
   public void setSpaceId(final String spaceId) {
      this.spaceId = spaceId;
   }

   @JsonProperty("fileName")
   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   @JsonProperty("fileSize")
   public void setFileSize(final Long fileSize) {
      this.fileSize = fileSize;
   }

   @JsonProperty("fileType")
   public void setFileType(final String fileType) {
      this.fileType = fileType;
   }

   @JsonProperty("fileId")
   public void setFileId(final String fileId) {
      this.fileId = fileId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DDAttachment)) {
         return false;
      }

      DDAttachment other = (DDAttachment)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$fileSize = this.getFileSize();
      Object other$fileSize = other.getFileSize();
      if (this$fileSize == null ? other$fileSize == null : this$fileSize.equals(other$fileSize)) {
         Object this$spaceId = this.getSpaceId();
         Object other$spaceId = other.getSpaceId();
         if (this$spaceId == null ? other$spaceId == null : this$spaceId.equals(other$spaceId)) {
            Object this$fileName = this.getFileName();
            Object other$fileName = other.getFileName();
            if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
               Object this$fileType = this.getFileType();
               Object other$fileType = other.getFileType();
               if (this$fileType == null ? other$fileType == null : this$fileType.equals(other$fileType)) {
                  Object this$fileId = this.getFileId();
                  Object other$fileId = other.getFileId();
                  return this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId);
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
      return other instanceof DDAttachment;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fileSize = this.getFileSize();
      result = result * 59 + ($fileSize == null ? 43 : $fileSize.hashCode());
      Object $spaceId = this.getSpaceId();
      result = result * 59 + ($spaceId == null ? 43 : $spaceId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $fileType = this.getFileType();
      result = result * 59 + ($fileType == null ? 43 : $fileType.hashCode());
      Object $fileId = this.getFileId();
      return result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
   }

   @Override
   public String toString() {
      return "DDAttachment(spaceId="
         + this.getSpaceId()
         + ", fileName="
         + this.getFileName()
         + ", fileSize="
         + this.getFileSize()
         + ", fileType="
         + this.getFileType()
         + ", fileId="
         + this.getFileId()
         + ")";
   }

   public DDAttachment(final String spaceId, final String fileName, final Long fileSize, final String fileType, final String fileId) {
      this.spaceId = spaceId;
      this.fileName = fileName;
      this.fileSize = fileSize;
      this.fileType = fileType;
      this.fileId = fileId;
   }

   public DDAttachment() {
   }

   public static class DDAttachmentBuilder {
      private String spaceId;
      private String fileName;
      private Long fileSize;
      private String fileType;
      private String fileId;

      DDAttachmentBuilder() {
      }

      @JsonProperty("spaceId")
      public DDAttachment.DDAttachmentBuilder spaceId(final String spaceId) {
         this.spaceId = spaceId;
         return this;
      }

      @JsonProperty("fileName")
      public DDAttachment.DDAttachmentBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("fileSize")
      public DDAttachment.DDAttachmentBuilder fileSize(final Long fileSize) {
         this.fileSize = fileSize;
         return this;
      }

      @JsonProperty("fileType")
      public DDAttachment.DDAttachmentBuilder fileType(final String fileType) {
         this.fileType = fileType;
         return this;
      }

      @JsonProperty("fileId")
      public DDAttachment.DDAttachmentBuilder fileId(final String fileId) {
         this.fileId = fileId;
         return this;
      }

      public DDAttachment build() {
         return new DDAttachment(this.spaceId, this.fileName, this.fileSize, this.fileType, this.fileId);
      }

      @Override
      public String toString() {
         return "DDAttachment.DDAttachmentBuilder(spaceId="
            + this.spaceId
            + ", fileName="
            + this.fileName
            + ", fileSize="
            + this.fileSize
            + ", fileType="
            + this.fileType
            + ", fileId="
            + this.fileId
            + ")";
      }
   }
}
