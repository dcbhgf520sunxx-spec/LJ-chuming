package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

public class LastSendPersonDTO {
   private Long Id;
   private String name;
   private Long deptId;
   private String deptName;

   LastSendPersonDTO(final Long Id, final String name, final Long deptId, final String deptName) {
      this.Id = Id;
      this.name = name;
      this.deptId = deptId;
      this.deptName = deptName;
   }

   public static LastSendPersonDTO.LastSendPersonDTOBuilder builder() {
      return new LastSendPersonDTO.LastSendPersonDTOBuilder();
   }

   public Long getId() {
      return this.Id;
   }

   public String getName() {
      return this.name;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public void setId(final Long Id) {
      this.Id = Id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LastSendPersonDTO)) {
         return false;
      }

      LastSendPersonDTO other = (LastSendPersonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$Id = this.getId();
      Object other$Id = other.getId();
      if (this$Id == null ? other$Id == null : this$Id.equals(other$Id)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$deptName = this.getDeptName();
               Object other$deptName = other.getDeptName();
               return this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName);
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
      return other instanceof LastSendPersonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $Id = this.getId();
      result = result * 59 + ($Id == null ? 43 : $Id.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptName = this.getDeptName();
      return result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
   }

   @Override
   public String toString() {
      return "LastSendPersonDTO(Id=" + this.getId() + ", name=" + this.getName() + ", deptId=" + this.getDeptId() + ", deptName=" + this.getDeptName() + ")";
   }

   public static class LastSendPersonDTOBuilder {
      private Long Id;
      private String name;
      private Long deptId;
      private String deptName;

      LastSendPersonDTOBuilder() {
      }

      public LastSendPersonDTO.LastSendPersonDTOBuilder Id(final Long Id) {
         this.Id = Id;
         return this;
      }

      public LastSendPersonDTO.LastSendPersonDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public LastSendPersonDTO.LastSendPersonDTOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public LastSendPersonDTO.LastSendPersonDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public LastSendPersonDTO build() {
         return new LastSendPersonDTO(this.Id, this.name, this.deptId, this.deptName);
      }

      @Override
      public String toString() {
         return "LastSendPersonDTO.LastSendPersonDTOBuilder(Id="
            + this.Id
            + ", name="
            + this.name
            + ", deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ")";
      }
   }
}
