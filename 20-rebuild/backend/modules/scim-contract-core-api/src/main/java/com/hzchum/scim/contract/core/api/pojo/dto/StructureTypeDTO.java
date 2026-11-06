package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;

@ApiModel("合同详情-技术交底-结构返回类")
public class StructureTypeDTO {
   private String id;
   @ApiModelProperty(name = "type", notes = "产品种类  结构件加工 ")
   @NotBlank(message = "结构种类 不能为空")
   private String type;
   @ApiModelProperty(name = "techDesc", notes = "技术要求描述")
   private String techDesc;
   @ApiModelProperty(name = "attachments", notes = "附件")
   private List<AttachmentDTO> attachments;
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureTypeDTO)) {
         return false;
      }

      StructureTypeDTO other = (StructureTypeDTO)o;
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
               Object this$attachments = this.getAttachments();
               Object other$attachments = other.getAttachments();
               if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StructureTypeDTO;
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
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "StructureTypeDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", techDesc="
         + this.getTechDesc()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
