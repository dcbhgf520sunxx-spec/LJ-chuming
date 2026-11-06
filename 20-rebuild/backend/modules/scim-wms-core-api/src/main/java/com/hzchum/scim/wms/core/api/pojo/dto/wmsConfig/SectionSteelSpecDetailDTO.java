package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.util.List;

public class SectionSteelSpecDetailDTO {
   private Long id;
   private Long sectionSteelId;
   private String specification;
   private List<SectionSteelSpecStandardDetailDTO> standard;
   private Boolean status;

   public static SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder builder() {
      return new SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder();
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

   public List<SectionSteelSpecStandardDetailDTO> getStandard() {
      return this.standard;
   }

   public Boolean getStatus() {
      return this.status;
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

   public void setStandard(final List<SectionSteelSpecStandardDetailDTO> standard) {
      this.standard = standard;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpecDetailDTO)) {
         return false;
      }

      SectionSteelSpecDetailDTO other = (SectionSteelSpecDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sectionSteelId = this.getSectionSteelId();
         Object other$sectionSteelId = other.getSectionSteelId();
         if (this$sectionSteelId == null ? other$sectionSteelId == null : this$sectionSteelId.equals(other$sectionSteelId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$standard = this.getStandard();
                  Object other$standard = other.getStandard();
                  return this$standard == null ? other$standard == null : this$standard.equals(other$standard);
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
      return other instanceof SectionSteelSpecDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sectionSteelId = this.getSectionSteelId();
      result = result * 59 + ($sectionSteelId == null ? 43 : $sectionSteelId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $standard = this.getStandard();
      return result * 59 + ($standard == null ? 43 : $standard.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelSpecDetailDTO(id="
         + this.getId()
         + ", sectionSteelId="
         + this.getSectionSteelId()
         + ", specification="
         + this.getSpecification()
         + ", standard="
         + this.getStandard()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public SectionSteelSpecDetailDTO(
      final Long id, final Long sectionSteelId, final String specification, final List<SectionSteelSpecStandardDetailDTO> standard, final Boolean status
   ) {
      this.id = id;
      this.sectionSteelId = sectionSteelId;
      this.specification = specification;
      this.standard = standard;
      this.status = status;
   }

   public SectionSteelSpecDetailDTO() {
   }

   public static class SectionSteelSpecDetailDTOBuilder {
      private Long id;
      private Long sectionSteelId;
      private String specification;
      private List<SectionSteelSpecStandardDetailDTO> standard;
      private Boolean status;

      SectionSteelSpecDetailDTOBuilder() {
      }

      public SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder sectionSteelId(final Long sectionSteelId) {
         this.sectionSteelId = sectionSteelId;
         return this;
      }

      public SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder standard(final List<SectionSteelSpecStandardDetailDTO> standard) {
         this.standard = standard;
         return this;
      }

      public SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SectionSteelSpecDetailDTO build() {
         return new SectionSteelSpecDetailDTO(this.id, this.sectionSteelId, this.specification, this.standard, this.status);
      }

      @Override
      public String toString() {
         return "SectionSteelSpecDetailDTO.SectionSteelSpecDetailDTOBuilder(id="
            + this.id
            + ", sectionSteelId="
            + this.sectionSteelId
            + ", specification="
            + this.specification
            + ", standard="
            + this.standard
            + ", status="
            + this.status
            + ")";
      }
   }
}
