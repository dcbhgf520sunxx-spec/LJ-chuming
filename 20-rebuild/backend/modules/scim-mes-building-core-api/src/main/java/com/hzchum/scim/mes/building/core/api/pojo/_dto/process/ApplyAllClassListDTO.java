package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;

@ApiModel("应用全部种类列表")
public class ApplyAllClassListDTO {
   private Long id;
   private String className;
   private Boolean hasProcess;

   public Long getId() {
      return this.id;
   }

   public String getClassName() {
      return this.className;
   }

   public Boolean getHasProcess() {
      return this.hasProcess;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setHasProcess(final Boolean hasProcess) {
      this.hasProcess = hasProcess;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyAllClassListDTO)) {
         return false;
      }

      ApplyAllClassListDTO other = (ApplyAllClassListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$hasProcess = this.getHasProcess();
         Object other$hasProcess = other.getHasProcess();
         if (this$hasProcess == null ? other$hasProcess == null : this$hasProcess.equals(other$hasProcess)) {
            Object this$className = this.getClassName();
            Object other$className = other.getClassName();
            return this$className == null ? other$className == null : this$className.equals(other$className);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApplyAllClassListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $hasProcess = this.getHasProcess();
      result = result * 59 + ($hasProcess == null ? 43 : $hasProcess.hashCode());
      Object $className = this.getClassName();
      return result * 59 + ($className == null ? 43 : $className.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyAllClassListDTO(id=" + this.getId() + ", className=" + this.getClassName() + ", hasProcess=" + this.getHasProcess() + ")";
   }
}
