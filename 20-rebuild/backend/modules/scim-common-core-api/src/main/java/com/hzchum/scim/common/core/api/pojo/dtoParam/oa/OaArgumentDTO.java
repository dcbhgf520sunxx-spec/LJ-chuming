package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

public class OaArgumentDTO {
   private String fieldName;
   private Object fieldValue;

   public static OaArgumentDTO.OaArgumentDTOBuilder builder() {
      return new OaArgumentDTO.OaArgumentDTOBuilder();
   }

   public OaArgumentDTO(final String fieldName, final Object fieldValue) {
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
   }

   public OaArgumentDTO() {
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public Object getFieldValue() {
      return this.fieldValue;
   }

   public void setFieldName(final String fieldName) {
      this.fieldName = fieldName;
   }

   public void setFieldValue(final Object fieldValue) {
      this.fieldValue = fieldValue;
   }

   @Override
   public String toString() {
      return "OaArgumentDTO(fieldName=" + this.getFieldName() + ", fieldValue=" + this.getFieldValue() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OaArgumentDTO)) {
         return false;
      } else {
         OaArgumentDTO other = (OaArgumentDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$fieldName = this.getFieldName();
            Object other$fieldName = other.getFieldName();
            if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
               Object this$fieldValue = this.getFieldValue();
               Object other$fieldValue = other.getFieldValue();
               return this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaArgumentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $fieldValue = this.getFieldValue();
      return result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
   }

   public static class OaArgumentDTOBuilder {
      private String fieldName;
      private Object fieldValue;

      OaArgumentDTOBuilder() {
      }

      public OaArgumentDTO.OaArgumentDTOBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public OaArgumentDTO.OaArgumentDTOBuilder fieldValue(final Object fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public OaArgumentDTO build() {
         return new OaArgumentDTO(this.fieldName, this.fieldValue);
      }

      @Override
      public String toString() {
         return "OaArgumentDTO.OaArgumentDTOBuilder(fieldName=" + this.fieldName + ", fieldValue=" + this.fieldValue + ")";
      }
   }
}
