package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目id列表")
public class ProjectUserUpdateCollectDTOParam extends ProjectUserUpdateDTOParam {
   @ApiModelProperty("项目id列表")
   private List<Long> projectIds;
   @ApiModelProperty("是否覆盖添加")
   private Boolean isCover;

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Boolean getIsCover() {
      return this.isCover;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setIsCover(final Boolean isCover) {
      this.isCover = isCover;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectUserUpdateCollectDTOParam)) {
         return false;
      } else {
         ProjectUserUpdateCollectDTOParam other = (ProjectUserUpdateCollectDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$isCover = this.getIsCover();
            Object other$isCover = other.getIsCover();
            if (this$isCover == null ? other$isCover == null : this$isCover.equals(other$isCover)) {
               Object this$projectIds = this.getProjectIds();
               Object other$projectIds = other.getProjectIds();
               return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserUpdateCollectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isCover = this.getIsCover();
      result = result * 59 + ($isCover == null ? 43 : $isCover.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectUserUpdateCollectDTOParam(projectIds=" + this.getProjectIds() + ", isCover=" + this.getIsCover() + ")";
   }
}
