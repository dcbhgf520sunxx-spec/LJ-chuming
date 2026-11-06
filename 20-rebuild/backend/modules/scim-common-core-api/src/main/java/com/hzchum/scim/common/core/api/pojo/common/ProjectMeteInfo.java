package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目-量")
public class ProjectMeteInfo {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("量")
   private BigDecimal mete;

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectMeteInfo)) {
         return false;
      } else {
         ProjectMeteInfo other = (ProjectMeteInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectMeteInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMeteInfo(projectId=" + this.getProjectId() + ", mete=" + this.getMete() + ")";
   }
}
