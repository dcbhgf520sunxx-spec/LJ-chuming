package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

public class SectionSteelSpecDTO {
   private Long id;
   private Long sectionSteelId;
   private String specification;
   private SectionSteelSpecStandardDetailDTO detail;

   public static SectionSteelSpecDTO.SectionSteelSpecDTOBuilder builder() {
      return new SectionSteelSpecDTO.SectionSteelSpecDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getSectionSteelId() {
      return this.sectionSteelId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public SectionSteelSpecStandardDetailDTO getDetail() {
      return this.detail;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSectionSteelId(final Long sectionSteelId) {
      this.sectionSteelId = sectionSteelId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setDetail(final SectionSteelSpecStandardDetailDTO detail) {
      this.detail = detail;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpecDTO)) {
         return false;
      }

      SectionSteelSpecDTO other = (SectionSteelSpecDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sectionSteelId = this.getSectionSteelId();
         Object other$sectionSteelId = other.getSectionSteelId();
         if (this$sectionSteelId == null ? other$sectionSteelId == null : this$sectionSteelId.equals(other$sectionSteelId)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$detail = this.getDetail();
               Object other$detail = other.getDetail();
               return this$detail == null ? other$detail == null : this$detail.equals(other$detail);
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
      return other instanceof SectionSteelSpecDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sectionSteelId = this.getSectionSteelId();
      result = result * 59 + ($sectionSteelId == null ? 43 : $sectionSteelId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $detail = this.getDetail();
      return result * 59 + ($detail == null ? 43 : $detail.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelSpecDTO(id="
         + this.getId()
         + ", sectionSteelId="
         + this.getSectionSteelId()
         + ", specification="
         + this.getSpecification()
         + ", detail="
         + this.getDetail()
         + ")";
   }

   public SectionSteelSpecDTO(final Long id, final Long sectionSteelId, final String specification, final SectionSteelSpecStandardDetailDTO detail) {
      this.id = id;
      this.sectionSteelId = sectionSteelId;
      this.specification = specification;
      this.detail = detail;
   }

   public SectionSteelSpecDTO() {
   }

   public static class SectionSteelSpecDTOBuilder {
      private Long id;
      private Long sectionSteelId;
      private String specification;
      private SectionSteelSpecStandardDetailDTO detail;

      SectionSteelSpecDTOBuilder() {
      }

      public SectionSteelSpecDTO.SectionSteelSpecDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelSpecDTO.SectionSteelSpecDTOBuilder sectionSteelId(final Long sectionSteelId) {
         this.sectionSteelId = sectionSteelId;
         return this;
      }

      public SectionSteelSpecDTO.SectionSteelSpecDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SectionSteelSpecDTO.SectionSteelSpecDTOBuilder detail(final SectionSteelSpecStandardDetailDTO detail) {
         this.detail = detail;
         return this;
      }

      public SectionSteelSpecDTO build() {
         return new SectionSteelSpecDTO(this.id, this.sectionSteelId, this.specification, this.detail);
      }

      @Override
      public String toString() {
         return "SectionSteelSpecDTO.SectionSteelSpecDTOBuilder(id="
            + this.id
            + ", sectionSteelId="
            + this.sectionSteelId
            + ", specification="
            + this.specification
            + ", detail="
            + this.detail
            + ")";
      }
   }
}
