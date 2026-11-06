package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.util.List;

public class ProjectPickingMeteListDTO {
   private List<ProjectPickingDTO> projectPickingSteelMeteList;
   private List<ProjectPickingDTO> projectPickingSectionSteelMeteList;

   public static ProjectPickingMeteListDTO.ProjectPickingMeteListDTOBuilder builder() {
      return new ProjectPickingMeteListDTO.ProjectPickingMeteListDTOBuilder();
   }

   public List<ProjectPickingDTO> getProjectPickingSteelMeteList() {
      return this.projectPickingSteelMeteList;
   }

   public List<ProjectPickingDTO> getProjectPickingSectionSteelMeteList() {
      return this.projectPickingSectionSteelMeteList;
   }

   public void setProjectPickingSteelMeteList(final List<ProjectPickingDTO> projectPickingSteelMeteList) {
      this.projectPickingSteelMeteList = projectPickingSteelMeteList;
   }

   public void setProjectPickingSectionSteelMeteList(final List<ProjectPickingDTO> projectPickingSectionSteelMeteList) {
      this.projectPickingSectionSteelMeteList = projectPickingSectionSteelMeteList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectPickingMeteListDTO)) {
         return false;
      } else {
         ProjectPickingMeteListDTO other = (ProjectPickingMeteListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectPickingSteelMeteList = this.getProjectPickingSteelMeteList();
            Object other$projectPickingSteelMeteList = other.getProjectPickingSteelMeteList();
            if (this$projectPickingSteelMeteList == null
               ? other$projectPickingSteelMeteList == null
               : this$projectPickingSteelMeteList.equals(other$projectPickingSteelMeteList)) {
               Object this$projectPickingSectionSteelMeteList = this.getProjectPickingSectionSteelMeteList();
               Object other$projectPickingSectionSteelMeteList = other.getProjectPickingSectionSteelMeteList();
               return this$projectPickingSectionSteelMeteList == null
                  ? other$projectPickingSectionSteelMeteList == null
                  : this$projectPickingSectionSteelMeteList.equals(other$projectPickingSectionSteelMeteList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPickingMeteListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectPickingSteelMeteList = this.getProjectPickingSteelMeteList();
      result = result * 59 + ($projectPickingSteelMeteList == null ? 43 : $projectPickingSteelMeteList.hashCode());
      Object $projectPickingSectionSteelMeteList = this.getProjectPickingSectionSteelMeteList();
      return result * 59 + ($projectPickingSectionSteelMeteList == null ? 43 : $projectPickingSectionSteelMeteList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPickingMeteListDTO(projectPickingSteelMeteList="
         + this.getProjectPickingSteelMeteList()
         + ", projectPickingSectionSteelMeteList="
         + this.getProjectPickingSectionSteelMeteList()
         + ")";
   }

   public ProjectPickingMeteListDTO(final List<ProjectPickingDTO> projectPickingSteelMeteList, final List<ProjectPickingDTO> projectPickingSectionSteelMeteList) {
      this.projectPickingSteelMeteList = projectPickingSteelMeteList;
      this.projectPickingSectionSteelMeteList = projectPickingSectionSteelMeteList;
   }

   public ProjectPickingMeteListDTO() {
   }

   public static class ProjectPickingMeteListDTOBuilder {
      private List<ProjectPickingDTO> projectPickingSteelMeteList;
      private List<ProjectPickingDTO> projectPickingSectionSteelMeteList;

      ProjectPickingMeteListDTOBuilder() {
      }

      public ProjectPickingMeteListDTO.ProjectPickingMeteListDTOBuilder projectPickingSteelMeteList(final List<ProjectPickingDTO> projectPickingSteelMeteList) {
         this.projectPickingSteelMeteList = projectPickingSteelMeteList;
         return this;
      }

      public ProjectPickingMeteListDTO.ProjectPickingMeteListDTOBuilder projectPickingSectionSteelMeteList(
         final List<ProjectPickingDTO> projectPickingSectionSteelMeteList
      ) {
         this.projectPickingSectionSteelMeteList = projectPickingSectionSteelMeteList;
         return this;
      }

      public ProjectPickingMeteListDTO build() {
         return new ProjectPickingMeteListDTO(this.projectPickingSteelMeteList, this.projectPickingSectionSteelMeteList);
      }

      @Override
      public String toString() {
         return "ProjectPickingMeteListDTO.ProjectPickingMeteListDTOBuilder(projectPickingSteelMeteList="
            + this.projectPickingSteelMeteList
            + ", projectPickingSectionSteelMeteList="
            + this.projectPickingSectionSteelMeteList
            + ")";
      }
   }
}
