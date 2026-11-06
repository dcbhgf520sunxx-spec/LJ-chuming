package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目关联用户请求类")
public class ProjectUserUpdateDTOParam {
   @ApiModelProperty("用户id列表")
   private List<Long> ids;

   public List<Long> getIds() {
      return this.ids;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserUpdateDTOParam)) {
         return false;
      }

      ProjectUserUpdateDTOParam other = (ProjectUserUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectUserUpdateDTOParam(ids=" + this.getIds() + ")";
   }
}
