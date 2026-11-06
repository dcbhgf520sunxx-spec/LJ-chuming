package com.hzchum.scim.system.core.api.pojo.dto;

public class UserDTO {
   private Long Id;
   private String name;

   UserDTO(final Long Id, final String name) {
      this.Id = Id;
      this.name = name;
   }

   public static UserDTO.UserDTOBuilder builder() {
      return new UserDTO.UserDTOBuilder();
   }

   public Long getId() {
      return this.Id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long Id) {
      this.Id = Id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserDTO)) {
         return false;
      } else {
         UserDTO other = (UserDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$Id = this.getId();
            Object other$Id = other.getId();
            if (this$Id == null ? other$Id == null : this$Id.equals(other$Id)) {
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
      return other instanceof UserDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $Id = this.getId();
      result = result * 59 + ($Id == null ? 43 : $Id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "UserDTO(Id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class UserDTOBuilder {
      private Long Id;
      private String name;

      UserDTOBuilder() {
      }

      public UserDTO.UserDTOBuilder Id(final Long Id) {
         this.Id = Id;
         return this;
      }

      public UserDTO.UserDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UserDTO build() {
         return new UserDTO(this.Id, this.name);
      }

      @Override
      public String toString() {
         return "UserDTO.UserDTOBuilder(Id=" + this.Id + ", name=" + this.name + ")";
      }
   }
}
