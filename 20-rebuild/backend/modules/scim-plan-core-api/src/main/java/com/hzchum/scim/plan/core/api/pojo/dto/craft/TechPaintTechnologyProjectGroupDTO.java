package com.hzchum.scim.plan.core.api.pojo.dto.craft;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class TechPaintTechnologyProjectGroupDTO {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "totalQuantity", value = "项目清单数量", notes = "项目清单数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "paintTechnologyList", value = "涂装工艺列表", notes = "涂装工艺列表")
   private List<TechPaintTechnologyDTO> paintTechnologyList;

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public List<TechPaintTechnologyDTO> getPaintTechnologyList() {
      return this.paintTechnologyList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setPaintTechnologyList(final List<TechPaintTechnologyDTO> paintTechnologyList) {
      this.paintTechnologyList = paintTechnologyList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyProjectGroupDTO)) {
         return false;
      }

      TechPaintTechnologyProjectGroupDTO other = (TechPaintTechnologyProjectGroupDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$paintTechnologyList = this.getPaintTechnologyList();
               Object other$paintTechnologyList = other.getPaintTechnologyList();
               return this$paintTechnologyList == null ? other$paintTechnologyList == null : this$paintTechnologyList.equals(other$paintTechnologyList);
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
      return other instanceof TechPaintTechnologyProjectGroupDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $paintTechnologyList = this.getPaintTechnologyList();
      return result * 59 + ($paintTechnologyList == null ? 43 : $paintTechnologyList.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyProjectGroupDTO(projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", paintTechnologyList="
         + this.getPaintTechnologyList()
         + ")";
   }
}
