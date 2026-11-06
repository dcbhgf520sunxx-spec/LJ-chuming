package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("修改(替换)技术资料")
public class DrawingUploadDTO {
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @NotBlank(message = "文件名称不能为空")
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径")
   @NotBlank(message = "文件路径不能为空")
   private String filePath;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   @NotNull(message = "上传人id不能为空")
   private Long createUserId;

   public static DrawingUploadDTO.DrawingUploadDTOBuilder builder() {
      return new DrawingUploadDTO.DrawingUploadDTOBuilder();
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DrawingUploadDTO)) {
         return false;
      }

      DrawingUploadDTO other = (DrawingUploadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createUserId = this.getCreateUserId();
      Object other$createUserId = other.getCreateUserId();
      if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
         Object this$fileName = this.getFileName();
         Object other$fileName = other.getFileName();
         if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
            Object this$filePath = this.getFilePath();
            Object other$filePath = other.getFilePath();
            return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DrawingUploadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   @Override
   public String toString() {
      return "DrawingUploadDTO(fileName=" + this.getFileName() + ", filePath=" + this.getFilePath() + ", createUserId=" + this.getCreateUserId() + ")";
   }

   public DrawingUploadDTO(final String fileName, final String filePath, final Long createUserId) {
      this.fileName = fileName;
      this.filePath = filePath;
      this.createUserId = createUserId;
   }

   public DrawingUploadDTO() {
   }

   public static class DrawingUploadDTOBuilder {
      private String fileName;
      private String filePath;
      private Long createUserId;

      DrawingUploadDTOBuilder() {
      }

      public DrawingUploadDTO.DrawingUploadDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public DrawingUploadDTO.DrawingUploadDTOBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public DrawingUploadDTO.DrawingUploadDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public DrawingUploadDTO build() {
         return new DrawingUploadDTO(this.fileName, this.filePath, this.createUserId);
      }

      @Override
      public String toString() {
         return "DrawingUploadDTO.DrawingUploadDTOBuilder(fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
