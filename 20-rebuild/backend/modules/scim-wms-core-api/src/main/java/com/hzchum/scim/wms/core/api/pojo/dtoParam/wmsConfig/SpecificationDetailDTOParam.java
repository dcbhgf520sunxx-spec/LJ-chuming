package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

public class SpecificationDetailDTOParam {
   private Long id;
   private Long specificationId;
   private String value;
   private Integer sort;
   private String code;
   private Boolean boolUsed;

   public Long getId() {
      return this.id;
   }

   public Long getSpecificationId() {
      return this.specificationId;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getCode() {
      return this.code;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecificationId(final Long specificationId) {
      this.specificationId = specificationId;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecificationDetailDTOParam)) {
         return false;
      }

      SpecificationDetailDTOParam other = (SpecificationDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specificationId = this.getSpecificationId();
         Object other$specificationId = other.getSpecificationId();
         if (this$specificationId == null ? other$specificationId == null : this$specificationId.equals(other$specificationId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$boolUsed = this.getBoolUsed();
               Object other$boolUsed = other.getBoolUsed();
               if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                  Object this$value = this.getValue();
                  Object other$value = other.getValue();
                  if (this$value == null ? other$value == null : this$value.equals(other$value)) {
                     Object this$code = this.getCode();
                     Object other$code = other.getCode();
                     return this$code == null ? other$code == null : this$code.equals(other$code);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specificationId = this.getSpecificationId();
      result = result * 59 + ($specificationId == null ? 43 : $specificationId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "SpecificationDetailDTOParam(id="
         + this.getId()
         + ", specificationId="
         + this.getSpecificationId()
         + ", value="
         + this.getValue()
         + ", sort="
         + this.getSort()
         + ", code="
         + this.getCode()
         + ", boolUsed="
         + this.getBoolUsed()
         + ")";
   }
}
