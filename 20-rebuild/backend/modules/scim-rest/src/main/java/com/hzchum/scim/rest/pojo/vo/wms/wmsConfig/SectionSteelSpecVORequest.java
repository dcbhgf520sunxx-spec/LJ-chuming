package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

import java.util.List;

public class SectionSteelSpecVORequest {
   private Long id;
   private Long sectionSteelId;
   private String specification;
   private List<StandardDetailVORequest> standard;

   public Long getId() {
      return this.id;
   }

   public Long getSectionSteelId() {
      return this.sectionSteelId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public List<StandardDetailVORequest> getStandard() {
      return this.standard;
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

   public void setStandard(final List<StandardDetailVORequest> standard) {
      this.standard = standard;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpecVORequest)) {
         return false;
      }

      SectionSteelSpecVORequest other = (SectionSteelSpecVORequest)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SectionSteelSpecVORequest;
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
      Object $standard = this.getStandard();
      return result * 59 + ($standard == null ? 43 : $standard.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelSpecVORequest(id="
         + this.getId()
         + ", sectionSteelId="
         + this.getSectionSteelId()
         + ", specification="
         + this.getSpecification()
         + ", standard="
         + this.getStandard()
         + ")";
   }
}
