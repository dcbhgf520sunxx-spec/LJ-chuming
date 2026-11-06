package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;

public class SimpleUser {
   @ApiModelProperty(name = "id", value = "用户编号", notes = "用户编号")
   private Long id;
   @ApiModelProperty(name = "name", value = "用户名称", notes = "用户名称")
   private String name;
   @ApiModelProperty(name = "machineToolId", value = "机床id", notes = "机床id")
   private Long machineToolId;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleUser)) {
         return false;
      }

      SimpleUser other = (SimpleUser)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machineToolId = this.getMachineToolId();
         Object other$machineToolId = other.getMachineToolId();
         if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleUser;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleUser(id=" + this.getId() + ", name=" + this.getName() + ", machineToolId=" + this.getMachineToolId() + ")";
   }
}
