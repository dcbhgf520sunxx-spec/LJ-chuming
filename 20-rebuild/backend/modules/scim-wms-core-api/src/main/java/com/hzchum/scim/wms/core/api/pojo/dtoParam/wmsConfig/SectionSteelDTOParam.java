package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

public class SectionSteelDTOParam {
   private Long id;
   private Long sectionSteelId;
   private Long standardId;

   SectionSteelDTOParam(final Long id, final Long sectionSteelId, final Long standardId) {
      this.id = id;
      this.sectionSteelId = sectionSteelId;
      this.standardId = standardId;
   }

   public static SectionSteelDTOParam.SectionSteelDTOParamBuilder builder() {
      return new SectionSteelDTOParam.SectionSteelDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getSectionSteelId() {
      return this.sectionSteelId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSectionSteelId(final Long sectionSteelId) {
      this.sectionSteelId = sectionSteelId;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelDTOParam)) {
         return false;
      }

      SectionSteelDTOParam other = (SectionSteelDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sectionSteelId = this.getSectionSteelId();
         Object other$sectionSteelId = other.getSectionSteelId();
         if (this$sectionSteelId == null ? other$sectionSteelId == null : this$sectionSteelId.equals(other$sectionSteelId)) {
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            return this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SectionSteelDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sectionSteelId = this.getSectionSteelId();
      result = result * 59 + ($sectionSteelId == null ? 43 : $sectionSteelId.hashCode());
      Object $standardId = this.getStandardId();
      return result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelDTOParam(id=" + this.getId() + ", sectionSteelId=" + this.getSectionSteelId() + ", standardId=" + this.getStandardId() + ")";
   }

   public static class SectionSteelDTOParamBuilder {
      private Long id;
      private Long sectionSteelId;
      private Long standardId;

      SectionSteelDTOParamBuilder() {
      }

      public SectionSteelDTOParam.SectionSteelDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelDTOParam.SectionSteelDTOParamBuilder sectionSteelId(final Long sectionSteelId) {
         this.sectionSteelId = sectionSteelId;
         return this;
      }

      public SectionSteelDTOParam.SectionSteelDTOParamBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public SectionSteelDTOParam build() {
         return new SectionSteelDTOParam(this.id, this.sectionSteelId, this.standardId);
      }

      @Override
      public String toString() {
         return "SectionSteelDTOParam.SectionSteelDTOParamBuilder(id="
            + this.id
            + ", sectionSteelId="
            + this.sectionSteelId
            + ", standardId="
            + this.standardId
            + ")";
      }
   }
}
