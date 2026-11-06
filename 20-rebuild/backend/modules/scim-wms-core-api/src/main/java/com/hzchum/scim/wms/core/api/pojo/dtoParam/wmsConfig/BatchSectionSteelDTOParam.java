package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.util.List;

public class BatchSectionSteelDTOParam {
   private List<SectionSteelDTOParam> sectionSteelIds;
   private Long standardId;

   public static BatchSectionSteelDTOParam.BatchSectionSteelDTOParamBuilder builder() {
      return new BatchSectionSteelDTOParam.BatchSectionSteelDTOParamBuilder();
   }

   public List<SectionSteelDTOParam> getSectionSteelIds() {
      return this.sectionSteelIds;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public void setSectionSteelIds(final List<SectionSteelDTOParam> sectionSteelIds) {
      this.sectionSteelIds = sectionSteelIds;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BatchSectionSteelDTOParam)) {
         return false;
      } else {
         BatchSectionSteelDTOParam other = (BatchSectionSteelDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
               Object this$sectionSteelIds = this.getSectionSteelIds();
               Object other$sectionSteelIds = other.getSectionSteelIds();
               return this$sectionSteelIds == null ? other$sectionSteelIds == null : this$sectionSteelIds.equals(other$sectionSteelIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BatchSectionSteelDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $sectionSteelIds = this.getSectionSteelIds();
      return result * 59 + ($sectionSteelIds == null ? 43 : $sectionSteelIds.hashCode());
   }

   @Override
   public String toString() {
      return "BatchSectionSteelDTOParam(sectionSteelIds=" + this.getSectionSteelIds() + ", standardId=" + this.getStandardId() + ")";
   }

   public BatchSectionSteelDTOParam(final List<SectionSteelDTOParam> sectionSteelIds, final Long standardId) {
      this.sectionSteelIds = sectionSteelIds;
      this.standardId = standardId;
   }

   public BatchSectionSteelDTOParam() {
   }

   public static class BatchSectionSteelDTOParamBuilder {
      private List<SectionSteelDTOParam> sectionSteelIds;
      private Long standardId;

      BatchSectionSteelDTOParamBuilder() {
      }

      public BatchSectionSteelDTOParam.BatchSectionSteelDTOParamBuilder sectionSteelIds(final List<SectionSteelDTOParam> sectionSteelIds) {
         this.sectionSteelIds = sectionSteelIds;
         return this;
      }

      public BatchSectionSteelDTOParam.BatchSectionSteelDTOParamBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public BatchSectionSteelDTOParam build() {
         return new BatchSectionSteelDTOParam(this.sectionSteelIds, this.standardId);
      }

      @Override
      public String toString() {
         return "BatchSectionSteelDTOParam.BatchSectionSteelDTOParamBuilder(sectionSteelIds=" + this.sectionSteelIds + ", standardId=" + this.standardId + ")";
      }
   }
}
