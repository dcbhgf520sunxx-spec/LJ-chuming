package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.get;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "PdfUtilDTO", description = "零件套料pdf路径类")
public class PdfUtilDTO {
   private String fileName;
   private String httpUrl;

   public static PdfUtilDTO.PdfUtilDTOBuilder builder() {
      return new PdfUtilDTO.PdfUtilDTOBuilder();
   }

   public PdfUtilDTO() {
   }

   public PdfUtilDTO(final String fileName, final String httpUrl) {
      this.fileName = fileName;
      this.httpUrl = httpUrl;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getHttpUrl() {
      return this.httpUrl;
   }

   public PdfUtilDTO setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public PdfUtilDTO setHttpUrl(final String httpUrl) {
      this.httpUrl = httpUrl;
      return this;
   }

   @Override
   public String toString() {
      return "PdfUtilDTO(fileName=" + this.getFileName() + ", httpUrl=" + this.getHttpUrl() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PdfUtilDTO)) {
         return false;
      } else {
         PdfUtilDTO other = (PdfUtilDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$fileName = this.getFileName();
            Object other$fileName = other.getFileName();
            if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
               Object this$httpUrl = this.getHttpUrl();
               Object other$httpUrl = other.getHttpUrl();
               return this$httpUrl == null ? other$httpUrl == null : this$httpUrl.equals(other$httpUrl);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PdfUtilDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $httpUrl = this.getHttpUrl();
      return result * 59 + ($httpUrl == null ? 43 : $httpUrl.hashCode());
   }

   public static class PdfUtilDTOBuilder {
      private String fileName;
      private String httpUrl;

      PdfUtilDTOBuilder() {
      }

      public PdfUtilDTO.PdfUtilDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public PdfUtilDTO.PdfUtilDTOBuilder httpUrl(final String httpUrl) {
         this.httpUrl = httpUrl;
         return this;
      }

      public PdfUtilDTO build() {
         return new PdfUtilDTO(this.fileName, this.httpUrl);
      }

      @Override
      public String toString() {
         return "PdfUtilDTO.PdfUtilDTOBuilder(fileName=" + this.fileName + ", httpUrl=" + this.httpUrl + ")";
      }
   }
}
