package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModelProperty;

public class OaAttachmentsDTO {
   @ApiModelProperty(name = "fileName", value = "文件名称")
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径")
   private String filePath;

   public static OaAttachmentsDTO.OaAttachmentsDTOBuilder builder() {
      return new OaAttachmentsDTO.OaAttachmentsDTOBuilder();
   }

   public OaAttachmentsDTO(final String fileName, final String filePath) {
      this.fileName = fileName;
      this.filePath = filePath;
   }

   public OaAttachmentsDTO() {
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   @Override
   public String toString() {
      return "OaAttachmentsDTO(fileName=" + this.getFileName() + ", filePath=" + this.getFilePath() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OaAttachmentsDTO)) {
         return false;
      } else {
         OaAttachmentsDTO other = (OaAttachmentsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$fileName = this.getFileName();
            Object other$fileName = other.getFileName();
            if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
               Object this$filePath = this.getFilePath();
               Object other$filePath = other.getFilePath();
               return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaAttachmentsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   public static class OaAttachmentsDTOBuilder {
      private String fileName;
      private String filePath;

      OaAttachmentsDTOBuilder() {
      }

      public OaAttachmentsDTO.OaAttachmentsDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public OaAttachmentsDTO.OaAttachmentsDTOBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public OaAttachmentsDTO build() {
         return new OaAttachmentsDTO(this.fileName, this.filePath);
      }

      @Override
      public String toString() {
         return "OaAttachmentsDTO.OaAttachmentsDTOBuilder(fileName=" + this.fileName + ", filePath=" + this.filePath + ")";
      }
   }
}
