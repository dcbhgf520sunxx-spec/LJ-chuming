package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("结构 新增类")
public class StructureDTOParam {
   private String id;
   @ApiModelProperty(name = "type", notes = "产品种类  结构件加工 ")
   @NotBlank(message = "结构种类 不能为空")
   private String type;
   @ApiModelProperty(name = "techDesc", notes = "技术要求描述")
   @Size(max = 2000, message = "结构件-技术要求描述字数过多")
   private String techDesc;
   @Size(max = 100, message = "上传附件数量超出限制")
   @ApiModelProperty(name = "attachmentIds", notes = "附件ID字符串")
   private String attachmentIds;

   public String getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getTechDesc() {
      return this.techDesc;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setTechDesc(final String techDesc) {
      this.techDesc = techDesc;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureDTOParam)) {
         return false;
      }

      StructureDTOParam other = (StructureDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$techDesc = this.getTechDesc();
            Object other$techDesc = other.getTechDesc();
            if (this$techDesc == null ? other$techDesc == null : this$techDesc.equals(other$techDesc)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof StructureDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $techDesc = this.getTechDesc();
      result = result * 59 + ($techDesc == null ? 43 : $techDesc.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "StructureDTOParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", techDesc="
         + this.getTechDesc()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
