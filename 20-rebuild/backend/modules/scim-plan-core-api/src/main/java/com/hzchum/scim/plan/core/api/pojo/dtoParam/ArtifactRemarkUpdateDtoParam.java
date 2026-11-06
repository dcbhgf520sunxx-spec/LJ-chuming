package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtifactRemarkUpdateDtoParam {
   @ApiModelProperty(name = "id", value = "构件ID")
   @NotNull(message = "构件ID不能为空!")
   private Long id;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 250, message = "字数超出限制!")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactRemarkUpdateDtoParam)) {
         return false;
      } else {
         ArtifactRemarkUpdateDtoParam other = (ArtifactRemarkUpdateDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactRemarkUpdateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactRemarkUpdateDtoParam(id=" + this.getId() + ", remark=" + this.getRemark() + ")";
   }
}
