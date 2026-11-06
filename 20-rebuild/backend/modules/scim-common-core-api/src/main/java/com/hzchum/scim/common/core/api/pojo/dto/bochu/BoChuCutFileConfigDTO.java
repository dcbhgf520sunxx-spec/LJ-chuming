package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("柏楚nc切割文件配置DTO")
public class BoChuCutFileConfigDTO {
   @JsonProperty("title")
   @Alias("title")
   private String title;
   @JsonProperty("extension")
   @Alias("extension")
   private String extension;
   @JsonProperty("template_file")
   @Alias("template_file")
   private String templateFile;

   public String getTitle() {
      return this.title;
   }

   public String getExtension() {
      return this.extension;
   }

   public String getTemplateFile() {
      return this.templateFile;
   }

   @JsonProperty("title")
   public void setTitle(final String title) {
      this.title = title;
   }

   @JsonProperty("extension")
   public void setExtension(final String extension) {
      this.extension = extension;
   }

   @JsonProperty("template_file")
   public void setTemplateFile(final String templateFile) {
      this.templateFile = templateFile;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuCutFileConfigDTO)) {
         return false;
      }

      BoChuCutFileConfigDTO other = (BoChuCutFileConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$title = this.getTitle();
      Object other$title = other.getTitle();
      if (this$title == null ? other$title == null : this$title.equals(other$title)) {
         Object this$extension = this.getExtension();
         Object other$extension = other.getExtension();
         if (this$extension == null ? other$extension == null : this$extension.equals(other$extension)) {
            Object this$templateFile = this.getTemplateFile();
            Object other$templateFile = other.getTemplateFile();
            return this$templateFile == null ? other$templateFile == null : this$templateFile.equals(other$templateFile);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BoChuCutFileConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $extension = this.getExtension();
      result = result * 59 + ($extension == null ? 43 : $extension.hashCode());
      Object $templateFile = this.getTemplateFile();
      return result * 59 + ($templateFile == null ? 43 : $templateFile.hashCode());
   }

   @Override
   public String toString() {
      return "BoChuCutFileConfigDTO(title=" + this.getTitle() + ", extension=" + this.getExtension() + ", templateFile=" + this.getTemplateFile() + ")";
   }
}
