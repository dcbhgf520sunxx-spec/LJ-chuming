package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.io.Serializable;

public class SpecificationDetailDTO implements Serializable {
   private Long id;
   private Integer sort;
   private String value;
   private String code;
   private Boolean boolUsed;

   public static SpecificationDetailDTO.SpecificationDetailDTOBuilder builder() {
      return new SpecificationDetailDTO.SpecificationDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getValue() {
      return this.value;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setValue(final String value) {
      this.value = value;
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

      if (!(o instanceof SpecificationDetailDTO)) {
         return false;
      }

      SpecificationDetailDTO other = (SpecificationDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      return "SpecificationDetailDTO(id="
         + this.getId()
         + ", sort="
         + this.getSort()
         + ", value="
         + this.getValue()
         + ", code="
         + this.getCode()
         + ", boolUsed="
         + this.getBoolUsed()
         + ")";
   }

   public SpecificationDetailDTO(final Long id, final Integer sort, final String value, final String code, final Boolean boolUsed) {
      this.id = id;
      this.sort = sort;
      this.value = value;
      this.code = code;
      this.boolUsed = boolUsed;
   }

   public SpecificationDetailDTO() {
   }

   public static class SpecificationDetailDTOBuilder {
      private Long id;
      private Integer sort;
      private String value;
      private String code;
      private Boolean boolUsed;

      SpecificationDetailDTOBuilder() {
      }

      public SpecificationDetailDTO.SpecificationDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SpecificationDetailDTO.SpecificationDetailDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SpecificationDetailDTO.SpecificationDetailDTOBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public SpecificationDetailDTO.SpecificationDetailDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SpecificationDetailDTO.SpecificationDetailDTOBuilder boolUsed(final Boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public SpecificationDetailDTO build() {
         return new SpecificationDetailDTO(this.id, this.sort, this.value, this.code, this.boolUsed);
      }

      @Override
      public String toString() {
         return "SpecificationDetailDTO.SpecificationDetailDTOBuilder(id="
            + this.id
            + ", sort="
            + this.sort
            + ", value="
            + this.value
            + ", code="
            + this.code
            + ", boolUsed="
            + this.boolUsed
            + ")";
      }
   }
}
