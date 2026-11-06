package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProjectManageModeTaskDTO", description = "APP劳务任务数量返回类 ")
public class ProjectManageModeTaskDTO {
   private Integer modeTask;
   private Integer quantity;

   public static ProjectManageModeTaskDTO.ProjectManageModeTaskDTOBuilder builder() {
      return new ProjectManageModeTaskDTO.ProjectManageModeTaskDTOBuilder();
   }

   public ProjectManageModeTaskDTO() {
   }

   public ProjectManageModeTaskDTO(final Integer modeTask, final Integer quantity) {
      this.modeTask = modeTask;
      this.quantity = quantity;
   }

   public Integer getModeTask() {
      return this.modeTask;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setModeTask(final Integer modeTask) {
      this.modeTask = modeTask;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectManageModeTaskDTO)) {
         return false;
      } else {
         ProjectManageModeTaskDTO other = (ProjectManageModeTaskDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$modeTask = this.getModeTask();
            Object other$modeTask = other.getModeTask();
            if (this$modeTask == null ? other$modeTask == null : this$modeTask.equals(other$modeTask)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageModeTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $modeTask = this.getModeTask();
      result = result * 59 + ($modeTask == null ? 43 : $modeTask.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageModeTaskDTO(modeTask=" + this.getModeTask() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class ProjectManageModeTaskDTOBuilder {
      private Integer modeTask;
      private Integer quantity;

      ProjectManageModeTaskDTOBuilder() {
      }

      public ProjectManageModeTaskDTO.ProjectManageModeTaskDTOBuilder modeTask(final Integer modeTask) {
         this.modeTask = modeTask;
         return this;
      }

      public ProjectManageModeTaskDTO.ProjectManageModeTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectManageModeTaskDTO build() {
         return new ProjectManageModeTaskDTO(this.modeTask, this.quantity);
      }

      @Override
      public String toString() {
         return "ProjectManageModeTaskDTO.ProjectManageModeTaskDTOBuilder(modeTask=" + this.modeTask + ", quantity=" + this.quantity + ")";
      }
   }
}
