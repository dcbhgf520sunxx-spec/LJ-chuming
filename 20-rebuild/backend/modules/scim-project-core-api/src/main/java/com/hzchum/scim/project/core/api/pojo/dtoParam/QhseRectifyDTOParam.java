package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("整改请求类")
public class QhseRectifyDTOParam {
   @NotNull(message = "id不能为空")
   @ApiModelProperty(name = "id", value = "整改id")
   private Long id;
   @ApiModelProperty(name = "rectifyOpinion", value = "整改意见")
   private String rectifyOpinion;
   @ApiModelProperty(name = "rectifyAttachmentIds", value = "整改图片id列表")
   private List<Long> rectifyAttachmentIds;

   public Long getId() {
      return this.id;
   }

   public String getRectifyOpinion() {
      return this.rectifyOpinion;
   }

   public List<Long> getRectifyAttachmentIds() {
      return this.rectifyAttachmentIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRectifyOpinion(final String rectifyOpinion) {
      this.rectifyOpinion = rectifyOpinion;
   }

   public void setRectifyAttachmentIds(final List<Long> rectifyAttachmentIds) {
      this.rectifyAttachmentIds = rectifyAttachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseRectifyDTOParam)) {
         return false;
      }

      QhseRectifyDTOParam other = (QhseRectifyDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rectifyOpinion = this.getRectifyOpinion();
         Object other$rectifyOpinion = other.getRectifyOpinion();
         if (this$rectifyOpinion == null ? other$rectifyOpinion == null : this$rectifyOpinion.equals(other$rectifyOpinion)) {
            Object this$rectifyAttachmentIds = this.getRectifyAttachmentIds();
            Object other$rectifyAttachmentIds = other.getRectifyAttachmentIds();
            return this$rectifyAttachmentIds == null ? other$rectifyAttachmentIds == null : this$rectifyAttachmentIds.equals(other$rectifyAttachmentIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseRectifyDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rectifyOpinion = this.getRectifyOpinion();
      result = result * 59 + ($rectifyOpinion == null ? 43 : $rectifyOpinion.hashCode());
      Object $rectifyAttachmentIds = this.getRectifyAttachmentIds();
      return result * 59 + ($rectifyAttachmentIds == null ? 43 : $rectifyAttachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "QhseRectifyDTOParam(id="
         + this.getId()
         + ", rectifyOpinion="
         + this.getRectifyOpinion()
         + ", rectifyAttachmentIds="
         + this.getRectifyAttachmentIds()
         + ")";
   }
}
