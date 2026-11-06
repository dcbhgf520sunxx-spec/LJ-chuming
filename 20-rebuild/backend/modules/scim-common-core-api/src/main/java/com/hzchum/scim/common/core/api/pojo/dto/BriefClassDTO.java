package com.hzchum.scim.common.core.api.pojo.dto;

import java.util.List;

public class BriefClassDTO {
   private String label;
   private String value;
   private List<BriefClassDTO> list;

   public static BriefClassDTO.BriefClassDTOBuilder builder() {
      return new BriefClassDTO.BriefClassDTOBuilder();
   }

   public String getLabel() {
      return this.label;
   }

   public String getValue() {
      return this.value;
   }

   public List<BriefClassDTO> getList() {
      return this.list;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setList(final List<BriefClassDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefClassDTO)) {
         return false;
      }

      BriefClassDTO other = (BriefClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$label = this.getLabel();
      Object other$label = other.getLabel();
      if (this$label == null ? other$label == null : this$label.equals(other$label)) {
         Object this$value = this.getValue();
         Object other$value = other.getValue();
         if (this$value == null ? other$value == null : this$value.equals(other$value)) {
            Object this$list = this.getList();
            Object other$list = other.getList();
            return this$list == null ? other$list == null : this$list.equals(other$list);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BriefClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BriefClassDTO(label=" + this.getLabel() + ", value=" + this.getValue() + ", list=" + this.getList() + ")";
   }

   public BriefClassDTO(final String label, final String value, final List<BriefClassDTO> list) {
      this.label = label;
      this.value = value;
      this.list = list;
   }

   public BriefClassDTO() {
   }

   public static class BriefClassDTOBuilder {
      private String label;
      private String value;
      private List<BriefClassDTO> list;

      BriefClassDTOBuilder() {
      }

      public BriefClassDTO.BriefClassDTOBuilder label(final String label) {
         this.label = label;
         return this;
      }

      public BriefClassDTO.BriefClassDTOBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public BriefClassDTO.BriefClassDTOBuilder list(final List<BriefClassDTO> list) {
         this.list = list;
         return this;
      }

      public BriefClassDTO build() {
         return new BriefClassDTO(this.label, this.value, this.list);
      }

      @Override
      public String toString() {
         return "BriefClassDTO.BriefClassDTOBuilder(label=" + this.label + ", value=" + this.value + ", list=" + this.list + ")";
      }
   }
}
