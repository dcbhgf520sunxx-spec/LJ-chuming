package com.hzchum.scim.crm.core.api.pojo.param.udpate;

public class CrmProjectTerminatedUpdateDTO {
   private Long id;

   public CrmProjectTerminatedUpdateDTO(final Long id) {
      this.id = id;
   }

   public CrmProjectTerminatedUpdateDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectTerminatedUpdateDTO)) {
         return false;
      }

      CrmProjectTerminatedUpdateDTO other = (CrmProjectTerminatedUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectTerminatedUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectTerminatedUpdateDTO(id=" + this.getId() + ")";
   }
}
