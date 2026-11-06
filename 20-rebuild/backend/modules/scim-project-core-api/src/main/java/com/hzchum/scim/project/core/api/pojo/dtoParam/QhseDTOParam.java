package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class QhseDTOParam {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "问题类别 1质量问题2安全问题3环境问题")
   @NotNull(message = "问题类别不能为空")
   private Integer category;
   @ApiModelProperty(name = "type", value = "问题类型")
   @NotNull(message = "问题类型不能为空")
   private String type;
   @ApiModelProperty(name = "boolTempUserEnum", value = "是否为临时用户（临时用户主送人为供应商 非临时用户为项目下用户）")
   @NotNull(message = "是否为临时用户不能为空")
   private Boolean boolTempUserEnum;
   @ApiModelProperty(name = "responsibleUserId", value = "主送人id")
   @NotNull(message = "主送人不能为空")
   private Long responsibleUserId;
   @ApiModelProperty(name = "ccUserId", value = "抄送人id")
   private List<Long> ccUserIds;
   @ApiModelProperty(name = "attachmentId", value = "问题图片")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "description", value = "描述")
   private String description;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getType() {
      return this.type;
   }

   public Boolean getBoolTempUserEnum() {
      return this.boolTempUserEnum;
   }

   public Long getResponsibleUserId() {
      return this.responsibleUserId;
   }

   public List<Long> getCcUserIds() {
      return this.ccUserIds;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getDescription() {
      return this.description;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setBoolTempUserEnum(final Boolean boolTempUserEnum) {
      this.boolTempUserEnum = boolTempUserEnum;
   }

   public void setResponsibleUserId(final Long responsibleUserId) {
      this.responsibleUserId = responsibleUserId;
   }

   public void setCcUserIds(final List<Long> ccUserIds) {
      this.ccUserIds = ccUserIds;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseDTOParam)) {
         return false;
      }

      QhseDTOParam other = (QhseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$boolTempUserEnum = this.getBoolTempUserEnum();
            Object other$boolTempUserEnum = other.getBoolTempUserEnum();
            if (this$boolTempUserEnum == null ? other$boolTempUserEnum == null : this$boolTempUserEnum.equals(other$boolTempUserEnum)) {
               Object this$responsibleUserId = this.getResponsibleUserId();
               Object other$responsibleUserId = other.getResponsibleUserId();
               if (this$responsibleUserId == null ? other$responsibleUserId == null : this$responsibleUserId.equals(other$responsibleUserId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$ccUserIds = this.getCcUserIds();
                     Object other$ccUserIds = other.getCcUserIds();
                     if (this$ccUserIds == null ? other$ccUserIds == null : this$ccUserIds.equals(other$ccUserIds)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$description = this.getDescription();
                           Object other$description = other.getDescription();
                           return this$description == null ? other$description == null : this$description.equals(other$description);
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
      return other instanceof QhseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $boolTempUserEnum = this.getBoolTempUserEnum();
      result = result * 59 + ($boolTempUserEnum == null ? 43 : $boolTempUserEnum.hashCode());
      Object $responsibleUserId = this.getResponsibleUserId();
      result = result * 59 + ($responsibleUserId == null ? 43 : $responsibleUserId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $ccUserIds = this.getCcUserIds();
      result = result * 59 + ($ccUserIds == null ? 43 : $ccUserIds.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $description = this.getDescription();
      return result * 59 + ($description == null ? 43 : $description.hashCode());
   }

   @Override
   public String toString() {
      return "QhseDTOParam(projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", type="
         + this.getType()
         + ", boolTempUserEnum="
         + this.getBoolTempUserEnum()
         + ", responsibleUserId="
         + this.getResponsibleUserId()
         + ", ccUserIds="
         + this.getCcUserIds()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", description="
         + this.getDescription()
         + ")";
   }
}
