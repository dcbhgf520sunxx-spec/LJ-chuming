package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;

public class SysAreaDTO {
   @NotBlank(message = "adcode为空")
   String adcode;
   @NotBlank(message = "name为空")
   String name;
   @NotBlank(message = "level为空")
   String level;
   @NotBlank(message = "parent为空")
   String parent;

   public String getAdcode() {
      return this.adcode;
   }

   public String getName() {
      return this.name;
   }

   public String getLevel() {
      return this.level;
   }

   public String getParent() {
      return this.parent;
   }

   public void setAdcode(final String adcode) {
      this.adcode = adcode;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setLevel(final String level) {
      this.level = level;
   }

   public void setParent(final String parent) {
      this.parent = parent;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAreaDTO)) {
         return false;
      }

      SysAreaDTO other = (SysAreaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$adcode = this.getAdcode();
      Object other$adcode = other.getAdcode();
      if (this$adcode == null ? other$adcode == null : this$adcode.equals(other$adcode)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$parent = this.getParent();
               Object other$parent = other.getParent();
               return this$parent == null ? other$parent == null : this$parent.equals(other$parent);
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
      return other instanceof SysAreaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $adcode = this.getAdcode();
      result = result * 59 + ($adcode == null ? 43 : $adcode.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $parent = this.getParent();
      return result * 59 + ($parent == null ? 43 : $parent.hashCode());
   }

   @Override
   public String toString() {
      return "SysAreaDTO(adcode=" + this.getAdcode() + ", name=" + this.getName() + ", level=" + this.getLevel() + ", parent=" + this.getParent() + ")";
   }
}
