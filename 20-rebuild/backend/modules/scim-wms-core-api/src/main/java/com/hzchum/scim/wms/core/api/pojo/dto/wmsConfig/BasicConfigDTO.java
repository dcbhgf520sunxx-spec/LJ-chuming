package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

public class BasicConfigDTO {
   private Long id;
   private String name;
   private String value;

   BasicConfigDTO(final Long id, final String name, final String value) {
      this.id = id;
      this.name = name;
      this.value = value;
   }

   public static BasicConfigDTO.BasicConfigDTOBuilder builder() {
      return new BasicConfigDTO.BasicConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicConfigDTO)) {
         return false;
      }

      BasicConfigDTO other = (BasicConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$value = this.getValue();
            Object other$value = other.getValue();
            return this$value == null ? other$value == null : this$value.equals(other$value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BasicConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "BasicConfigDTO(id=" + this.getId() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   public static class BasicConfigDTOBuilder {
      private Long id;
      private String name;
      private String value;

      BasicConfigDTOBuilder() {
      }

      public BasicConfigDTO.BasicConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BasicConfigDTO.BasicConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BasicConfigDTO.BasicConfigDTOBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public BasicConfigDTO build() {
         return new BasicConfigDTO(this.id, this.name, this.value);
      }

      @Override
      public String toString() {
         return "BasicConfigDTO.BasicConfigDTOBuilder(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ")";
      }
   }
}
