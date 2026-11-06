package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "套料切割文件类型", description = "套料切割文件类型")
public class NestCutFileTypeDTO {
   private String title;
   private String extension;
   private String template_file;

   public static NestCutFileTypeDTO.NestCutFileTypeDTOBuilder builder() {
      return new NestCutFileTypeDTO.NestCutFileTypeDTOBuilder();
   }

   public NestCutFileTypeDTO(final String title, final String extension, final String template_file) {
      this.title = title;
      this.extension = extension;
      this.template_file = template_file;
   }

   public NestCutFileTypeDTO() {
   }

   public String getTitle() {
      return this.title;
   }

   public String getExtension() {
      return this.extension;
   }

   public String getTemplate_file() {
      return this.template_file;
   }

   public NestCutFileTypeDTO setTitle(final String title) {
      this.title = title;
      return this;
   }

   public NestCutFileTypeDTO setExtension(final String extension) {
      this.extension = extension;
      return this;
   }

   public NestCutFileTypeDTO setTemplate_file(final String template_file) {
      this.template_file = template_file;
      return this;
   }

   @Override
   public String toString() {
      return "NestCutFileTypeDTO(title=" + this.getTitle() + ", extension=" + this.getExtension() + ", template_file=" + this.getTemplate_file() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestCutFileTypeDTO)) {
         return false;
      }

      NestCutFileTypeDTO other = (NestCutFileTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$title = this.getTitle();
      Object other$title = other.getTitle();
      if (this$title == null ? other$title == null : this$title.equals(other$title)) {
         Object this$extension = this.getExtension();
         Object other$extension = other.getExtension();
         if (this$extension == null ? other$extension == null : this$extension.equals(other$extension)) {
            Object this$template_file = this.getTemplate_file();
            Object other$template_file = other.getTemplate_file();
            return this$template_file == null ? other$template_file == null : this$template_file.equals(other$template_file);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NestCutFileTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $extension = this.getExtension();
      result = result * 59 + ($extension == null ? 43 : $extension.hashCode());
      Object $template_file = this.getTemplate_file();
      return result * 59 + ($template_file == null ? 43 : $template_file.hashCode());
   }

   public static class NestCutFileTypeDTOBuilder {
      private String title;
      private String extension;
      private String template_file;

      NestCutFileTypeDTOBuilder() {
      }

      public NestCutFileTypeDTO.NestCutFileTypeDTOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public NestCutFileTypeDTO.NestCutFileTypeDTOBuilder extension(final String extension) {
         this.extension = extension;
         return this;
      }

      public NestCutFileTypeDTO.NestCutFileTypeDTOBuilder template_file(final String template_file) {
         this.template_file = template_file;
         return this;
      }

      public NestCutFileTypeDTO build() {
         return new NestCutFileTypeDTO(this.title, this.extension, this.template_file);
      }

      @Override
      public String toString() {
         return "NestCutFileTypeDTO.NestCutFileTypeDTOBuilder(title="
            + this.title
            + ", extension="
            + this.extension
            + ", template_file="
            + this.template_file
            + ")";
      }
   }
}
