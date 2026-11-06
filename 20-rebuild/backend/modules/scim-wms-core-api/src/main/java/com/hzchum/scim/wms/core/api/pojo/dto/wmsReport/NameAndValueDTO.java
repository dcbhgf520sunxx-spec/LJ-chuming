package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class NameAndValueDTO {
   private String name;
   private BigDecimal value;
   private BigDecimal proportion;

   public static NameAndValueDTO.NameAndValueDTOBuilder builder() {
      return new NameAndValueDTO.NameAndValueDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getValue() {
      return this.value;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final BigDecimal value) {
      this.value = value;
   }

   public void setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NameAndValueDTO)) {
         return false;
      }

      NameAndValueDTO other = (NameAndValueDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$value = this.getValue();
         Object other$value = other.getValue();
         if (this$value == null ? other$value == null : this$value.equals(other$value)) {
            Object this$proportion = this.getProportion();
            Object other$proportion = other.getProportion();
            return this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NameAndValueDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $proportion = this.getProportion();
      return result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
   }

   @Override
   public String toString() {
      return "NameAndValueDTO(name=" + this.getName() + ", value=" + this.getValue() + ", proportion=" + this.getProportion() + ")";
   }

   public NameAndValueDTO(final String name, final BigDecimal value, final BigDecimal proportion) {
      this.name = name;
      this.value = value;
      this.proportion = proportion;
   }

   public NameAndValueDTO() {
   }

   public static class NameAndValueDTOBuilder {
      private String name;
      private BigDecimal value;
      private BigDecimal proportion;

      NameAndValueDTOBuilder() {
      }

      public NameAndValueDTO.NameAndValueDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public NameAndValueDTO.NameAndValueDTOBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public NameAndValueDTO.NameAndValueDTOBuilder proportion(final BigDecimal proportion) {
         this.proportion = proportion;
         return this;
      }

      public NameAndValueDTO build() {
         return new NameAndValueDTO(this.name, this.value, this.proportion);
      }

      @Override
      public String toString() {
         return "NameAndValueDTO.NameAndValueDTOBuilder(name=" + this.name + ", value=" + this.value + ", proportion=" + this.proportion + ")";
      }
   }
}
