package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.hzchum.pangu.common.valid.Update;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SysChangeReasonDTOParam {
   @NotNull(groups = Update.class, message = "变更id不能为空")
   private Long id;
   @NotEmpty(message = "变更原因不能为空")
   private String name;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysChangeReasonDTOParam)) {
         return false;
      } else {
         SysChangeReasonDTOParam other = (SysChangeReasonDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysChangeReasonDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysChangeReasonDTOParam(id=" + this.getId() + ", name=" + this.getName() + ")";
   }
}
