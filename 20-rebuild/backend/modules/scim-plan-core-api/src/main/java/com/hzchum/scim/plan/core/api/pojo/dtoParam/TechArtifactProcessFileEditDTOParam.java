package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "TechArtifactProcessFile对象", description = "构件工艺文件表 ")
public class TechArtifactProcessFileEditDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "文件id不能为空")
   private Long id;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @NotBlank(message = "文件名称不能为空")
   @Size(max = 50, message = "文件名称不要超过50个字符!")
   private String fileName;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @NotNull(message = "附件表id不能为空")
   private Long attachmentId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 200, message = "备注字数请限制在200字以内!")
   private String remark;

   public static TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder builder() {
      return new TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder();
   }

   public TechArtifactProcessFileEditDTOParam() {
   }

   public TechArtifactProcessFileEditDTOParam(final Long id, final String fileName, final Long attachmentId, final String remark) {
      this.id = id;
      this.fileName = fileName;
      this.attachmentId = attachmentId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getFileName() {
      return this.fileName;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileEditDTOParam)) {
         return false;
      }

      TechArtifactProcessFileEditDTOParam other = (TechArtifactProcessFileEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$attachmentId = this.getAttachmentId();
         Object other$attachmentId = other.getAttachmentId();
         if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
            Object this$fileName = this.getFileName();
            Object other$fileName = other.getFileName();
            if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechArtifactProcessFileEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileEditDTOParam(id="
         + this.getId()
         + ", fileName="
         + this.getFileName()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class TechArtifactProcessFileEditDTOParamBuilder {
      private Long id;
      private String fileName;
      private Long attachmentId;
      private String remark;

      TechArtifactProcessFileEditDTOParamBuilder() {
      }

      public TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactProcessFileEditDTOParam build() {
         return new TechArtifactProcessFileEditDTOParam(this.id, this.fileName, this.attachmentId, this.remark);
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileEditDTOParam.TechArtifactProcessFileEditDTOParamBuilder(id="
            + this.id
            + ", fileName="
            + this.fileName
            + ", attachmentId="
            + this.attachmentId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
