package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.util.List;

public class NormConfigDTOParam {
   private Long id;
   private Integer classificationId;
   private String specificationName;
   private List<NormValueDTOParam> details;

   NormConfigDTOParam(final Long id, final Integer classificationId, final String specificationName, final List<NormValueDTOParam> details) {
      this.id = id;
      this.classificationId = classificationId;
      this.specificationName = specificationName;
      this.details = details;
   }

   public static NormConfigDTOParam.NormConfigDTOParamBuilder builder() {
      return new NormConfigDTOParam.NormConfigDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getClassificationId() {
      return this.classificationId;
   }

   public String getSpecificationName() {
      return this.specificationName;
   }

   public List<NormValueDTOParam> getDetails() {
      return this.details;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationId(final Integer classificationId) {
      this.classificationId = classificationId;
   }

   public void setSpecificationName(final String specificationName) {
      this.specificationName = specificationName;
   }

   public void setDetails(final List<NormValueDTOParam> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NormConfigDTOParam)) {
         return false;
      }

      NormConfigDTOParam other = (NormConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationId = this.getClassificationId();
         Object other$classificationId = other.getClassificationId();
         if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
            Object this$specificationName = this.getSpecificationName();
            Object other$specificationName = other.getSpecificationName();
            if (this$specificationName == null ? other$specificationName == null : this$specificationName.equals(other$specificationName)) {
               Object this$details = this.getDetails();
               Object other$details = other.getDetails();
               return this$details == null ? other$details == null : this$details.equals(other$details);
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
      return other instanceof NormConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $specificationName = this.getSpecificationName();
      result = result * 59 + ($specificationName == null ? 43 : $specificationName.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "NormConfigDTOParam(id="
         + this.getId()
         + ", classificationId="
         + this.getClassificationId()
         + ", specificationName="
         + this.getSpecificationName()
         + ", details="
         + this.getDetails()
         + ")";
   }

   public static class NormConfigDTOParamBuilder {
      private Long id;
      private Integer classificationId;
      private String specificationName;
      private List<NormValueDTOParam> details;

      NormConfigDTOParamBuilder() {
      }

      public NormConfigDTOParam.NormConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public NormConfigDTOParam.NormConfigDTOParamBuilder classificationId(final Integer classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public NormConfigDTOParam.NormConfigDTOParamBuilder specificationName(final String specificationName) {
         this.specificationName = specificationName;
         return this;
      }

      public NormConfigDTOParam.NormConfigDTOParamBuilder details(final List<NormValueDTOParam> details) {
         this.details = details;
         return this;
      }

      public NormConfigDTOParam build() {
         return new NormConfigDTOParam(this.id, this.classificationId, this.specificationName, this.details);
      }

      @Override
      public String toString() {
         return "NormConfigDTOParam.NormConfigDTOParamBuilder(id="
            + this.id
            + ", classificationId="
            + this.classificationId
            + ", specificationName="
            + this.specificationName
            + ", details="
            + this.details
            + ")";
      }
   }
}
