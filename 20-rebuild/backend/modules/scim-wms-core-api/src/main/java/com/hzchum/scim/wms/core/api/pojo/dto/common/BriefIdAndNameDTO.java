package com.hzchum.scim.wms.core.api.pojo.dto.common;

public class BriefIdAndNameDTO {
   private Long id;
   private String name;
   private Long workshopId;

   public static BriefIdAndNameDTO.BriefIdAndNameDTOBuilder builder() {
      return new BriefIdAndNameDTO.BriefIdAndNameDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
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
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
      return other instanceof BriefIdAndNameDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "BriefIdAndNameDTO(id=" + this.getId() + ", name=" + this.getName() + ", workshopId=" + this.getWorkshopId() + ")";
   }

   public BriefIdAndNameDTO(final Long id, final String name, final Long workshopId) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
   }

   public BriefIdAndNameDTO() {
   }

   public static class BriefIdAndNameDTOBuilder {
      private Long id;
      private String name;
      private Long workshopId;

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

      public BriefIdAndNameDTO.BriefIdAndNameDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public BriefIdAndNameDTO build() {
         return new BriefIdAndNameDTO(this.id, this.name, this.workshopId);
      }

      @Override
      public String toString() {
         return "BriefIdAndNameDTO.BriefIdAndNameDTOBuilder(id=" + this.id + ", name=" + this.name + ", workshopId=" + this.workshopId + ")";
      }
   }
}
