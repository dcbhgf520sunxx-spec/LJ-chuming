package com.hzchum.scim.system.core.api.pojo.dto;

public class SysEnclosureDictionarySimpleDTO {
   private String name;
   private String remark;

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysEnclosureDictionarySimpleDTO)) {
         return false;
      } else {
         SysEnclosureDictionarySimpleDTO other = (SysEnclosureDictionarySimpleDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysEnclosureDictionarySimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SysEnclosureDictionarySimpleDTO(name=" + this.getName() + ", remark=" + this.getRemark() + ")";
   }
}
