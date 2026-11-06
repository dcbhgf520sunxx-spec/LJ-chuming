package com.hzchum.scim.system.core.api.pojo.request;

import java.util.List;
import javax.validation.constraints.NotNull;

public class RoleMenuUpdateRequestVO {
   @NotNull(message = "角色id不能为空")
   private Long id;
   private List<Long> menus;

   public Long getId() {
      return this.id;
   }

   public List<Long> getMenus() {
      return this.menus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMenus(final List<Long> menus) {
      this.menus = menus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RoleMenuUpdateRequestVO)) {
         return false;
      } else {
         RoleMenuUpdateRequestVO other = (RoleMenuUpdateRequestVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$menus = this.getMenus();
               Object other$menus = other.getMenus();
               return this$menus == null ? other$menus == null : this$menus.equals(other$menus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RoleMenuUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $menus = this.getMenus();
      return result * 59 + ($menus == null ? 43 : $menus.hashCode());
   }

   @Override
   public String toString() {
      return "RoleMenuUpdateRequestVO(id=" + this.getId() + ", menus=" + this.getMenus() + ")";
   }
}
