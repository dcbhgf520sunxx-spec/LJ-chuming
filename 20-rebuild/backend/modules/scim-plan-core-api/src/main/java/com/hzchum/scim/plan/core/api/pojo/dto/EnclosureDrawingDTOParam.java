package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("折边件 附件 绘图")
public class EnclosureDrawingDTOParam {
   @ApiModelProperty(name = "id", value = "围护折边件id")
   @NotNull(message = "折边件id不能为空")
   private Long id;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @NotBlank(message = "文件名称不能为空")
   private String fileName;
   @ApiModelProperty(name = "img", value = "base64文件")
   private String img;

   public Long getId() {
      return this.id;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getImg() {
      return this.img;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setImg(final String img) {
      this.img = img;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDrawingDTOParam)) {
         return false;
      }

      EnclosureDrawingDTOParam other = (EnclosureDrawingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$fileName = this.getFileName();
         Object other$fileName = other.getFileName();
         if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
            Object this$img = this.getImg();
            Object other$img = other.getImg();
            return this$img == null ? other$img == null : this$img.equals(other$img);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureDrawingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $img = this.getImg();
      return result * 59 + ($img == null ? 43 : $img.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureDrawingDTOParam(id=" + this.getId() + ", fileName=" + this.getFileName() + ", img=" + this.getImg() + ")";
   }
}
