package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.math.BigDecimal;

public class StandardConfigDTO {
   private Long id;
   private Integer classificationId;
   private String specificationName;
   private Integer standardId;
   private BigDecimal value;

   StandardConfigDTO(final Long id, final Integer classificationId, final String specificationName, final Integer standardId, final BigDecimal value) {
      this.id = id;
      this.classificationId = classificationId;
      this.specificationName = specificationName;
      this.standardId = standardId;
      this.value = value;
   }

   public static StandardConfigDTO.StandardConfigDTOBuilder builder() {
      return new StandardConfigDTO.StandardConfigDTOBuilder();
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

   public Integer getStandardId() {
      return this.standardId;
   }

   public BigDecimal getValue() {
      return this.value;
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

   public void setStandardId(final Integer standardId) {
      this.standardId = standardId;
   }

   public void setValue(final BigDecimal value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StandardConfigDTO)) {
         return false;
      }

      StandardConfigDTO other = (StandardConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationId = this.getClassificationId();
         Object other$classificationId = other.getClassificationId();
         if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
               Object this$specificationName = this.getSpecificationName();
               Object other$specificationName = other.getSpecificationName();
               if (this$specificationName == null ? other$specificationName == null : this$specificationName.equals(other$specificationName)) {
                  Object this$value = this.getValue();
                  Object other$value = other.getValue();
                  return this$value == null ? other$value == null : this$value.equals(other$value);
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
      return other instanceof StandardConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $specificationName = this.getSpecificationName();
      result = result * 59 + ($specificationName == null ? 43 : $specificationName.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "StandardConfigDTO(id="
         + this.getId()
         + ", classificationId="
         + this.getClassificationId()
         + ", specificationName="
         + this.getSpecificationName()
         + ", standardId="
         + this.getStandardId()
         + ", value="
         + this.getValue()
         + ")";
   }

   public static class StandardConfigDTOBuilder {
      private Long id;
      private Integer classificationId;
      private String specificationName;
      private Integer standardId;
      private BigDecimal value;

      StandardConfigDTOBuilder() {
      }

      public StandardConfigDTO.StandardConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StandardConfigDTO.StandardConfigDTOBuilder classificationId(final Integer classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public StandardConfigDTO.StandardConfigDTOBuilder specificationName(final String specificationName) {
         this.specificationName = specificationName;
         return this;
      }

      public StandardConfigDTO.StandardConfigDTOBuilder standardId(final Integer standardId) {
         this.standardId = standardId;
         return this;
      }

      public StandardConfigDTO.StandardConfigDTOBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public StandardConfigDTO build() {
         return new StandardConfigDTO(this.id, this.classificationId, this.specificationName, this.standardId, this.value);
      }

      @Override
      public String toString() {
         return "StandardConfigDTO.StandardConfigDTOBuilder(id="
            + this.id
            + ", classificationId="
            + this.classificationId
            + ", specificationName="
            + this.specificationName
            + ", standardId="
            + this.standardId
            + ", value="
            + this.value
            + ")";
      }
   }
}
