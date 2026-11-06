package com.hzchum.scim.scm.core.api.pojo.dto;

import java.util.List;

public class BriefIdAndNameDTO {
   private Long id;
   private String name;
   private String shortName;
   List<BriefIdAndNameDTO> child;

   public static BriefIdAndNameDTO.BriefIdAndNameDTOBuilder builder() {
      return new BriefIdAndNameDTO.BriefIdAndNameDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public List<BriefIdAndNameDTO> getChild() {
      return this.child;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setChild(final List<BriefIdAndNameDTO> child) {
      this.child = child;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefIdAndNameDTO)) {
         return false;
      }

      BriefIdAndNameDTO other = (BriefIdAndNameDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$child = this.getChild();
               Object other$child = other.getChild();
               return this$child == null ? other$child == null : this$child.equals(other$child);
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
      return other instanceof BriefIdAndNameDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $child = this.getChild();
      return result * 59 + ($child == null ? 43 : $child.hashCode());
   }

   @Override
   public String toString() {
      return "BriefIdAndNameDTO(id=" + this.getId() + ", name=" + this.getName() + ", shortName=" + this.getShortName() + ", child=" + this.getChild() + ")";
   }

   public BriefIdAndNameDTO(final Long id, final String name, final String shortName, final List<BriefIdAndNameDTO> child) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.child = child;
   }

   public BriefIdAndNameDTO() {
   }

   public static class BriefIdAndNameDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private List<BriefIdAndNameDTO> child;

      BriefIdAndNameDTOBuilder() {
      }

      public BriefIdAndNameDTO.BriefIdAndNameDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefIdAndNameDTO.BriefIdAndNameDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BriefIdAndNameDTO.BriefIdAndNameDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BriefIdAndNameDTO.BriefIdAndNameDTOBuilder child(final List<BriefIdAndNameDTO> child) {
         this.child = child;
         return this;
      }

      public BriefIdAndNameDTO build() {
         return new BriefIdAndNameDTO(this.id, this.name, this.shortName, this.child);
      }

      @Override
      public String toString() {
         return "BriefIdAndNameDTO.BriefIdAndNameDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", child="
            + this.child
            + ")";
      }
   }
}
