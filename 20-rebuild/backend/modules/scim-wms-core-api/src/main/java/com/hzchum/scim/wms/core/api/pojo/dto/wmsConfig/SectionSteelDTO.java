package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.util.List;

public class SectionSteelDTO {
   private Long id;
   private Long standardId;
   private String serialNumber;
   private String name;
   private List<SectionSteelDTO> children;

   public static SectionSteelDTO.SectionSteelDTOBuilder builder() {
      return new SectionSteelDTO.SectionSteelDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public List<SectionSteelDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setChildren(final List<SectionSteelDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelDTO)) {
         return false;
      }

      SectionSteelDTO other = (SectionSteelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$standardId = this.getStandardId();
         Object other$standardId = other.getStandardId();
         if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$children = this.getChildren();
                  Object other$children = other.getChildren();
                  return this$children == null ? other$children == null : this$children.equals(other$children);
               } else {
                  return false;
               }
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
      return other instanceof SectionSteelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelDTO(id="
         + this.getId()
         + ", standardId="
         + this.getStandardId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public SectionSteelDTO(final Long id, final Long standardId, final String serialNumber, final String name, final List<SectionSteelDTO> children) {
      this.id = id;
      this.standardId = standardId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.children = children;
   }

   public SectionSteelDTO() {
   }

   public static class SectionSteelDTOBuilder {
      private Long id;
      private Long standardId;
      private String serialNumber;
      private String name;
      private List<SectionSteelDTO> children;

      SectionSteelDTOBuilder() {
      }

      public SectionSteelDTO.SectionSteelDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelDTO.SectionSteelDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public SectionSteelDTO.SectionSteelDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SectionSteelDTO.SectionSteelDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SectionSteelDTO.SectionSteelDTOBuilder children(final List<SectionSteelDTO> children) {
         this.children = children;
         return this;
      }

      public SectionSteelDTO build() {
         return new SectionSteelDTO(this.id, this.standardId, this.serialNumber, this.name, this.children);
      }

      @Override
      public String toString() {
         return "SectionSteelDTO.SectionSteelDTOBuilder(id="
            + this.id
            + ", standardId="
            + this.standardId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", children="
            + this.children
            + ")";
      }
   }
}
