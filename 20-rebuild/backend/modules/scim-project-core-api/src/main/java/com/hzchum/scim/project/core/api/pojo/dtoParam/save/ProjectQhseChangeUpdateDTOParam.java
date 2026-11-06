package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectQhseChange对象", description = "质安问题整改表 ")
public class ProjectQhseChangeUpdateDTOParam extends ProjectQhseChangeSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "整改表ID不能为空")
   private Long id;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseChangeUpdateDTOParam)) {
         return false;
      }

      ProjectQhseChangeUpdateDTOParam other = (ProjectQhseChangeUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseChangeUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   public Long getId() {
      return this.id;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "ProjectQhseChangeUpdateDTOParam(id=" + this.getId() + ")";
   }
}
