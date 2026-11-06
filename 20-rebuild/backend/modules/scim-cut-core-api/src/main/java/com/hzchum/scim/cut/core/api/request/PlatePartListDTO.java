package com.hzchum.scim.cut.core.api.request;

import java.math.BigDecimal;
import java.util.List;

public class PlatePartListDTO {
   List<PartDTO> list;
   private String ncName;
   private String specification;
   private Double surplusWeight;
   private String material;
   private BigDecimal thick;
   private Integer num;

   public static PlatePartListDTO.PlatePartListDTOBuilder builder() {
      return new PlatePartListDTO.PlatePartListDTOBuilder();
   }

   public PlatePartListDTO() {
   }

   public PlatePartListDTO(
      final List<PartDTO> list,
      final String ncName,
      final String specification,
      final Double surplusWeight,
      final String material,
      final BigDecimal thick,
      final Integer num
   ) {
      this.list = list;
      this.ncName = ncName;
      this.specification = specification;
      this.surplusWeight = surplusWeight;
      this.material = material;
      this.thick = thick;
      this.num = num;
   }

   public List<PartDTO> getList() {
      return this.list;
   }

   public String getNcName() {
      return this.ncName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Double getSurplusWeight() {
      return this.surplusWeight;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public Integer getNum() {
      return this.num;
   }

   public void setList(final List<PartDTO> list) {
      this.list = list;
   }

   public void setNcName(final String ncName) {
      this.ncName = ncName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSurplusWeight(final Double surplusWeight) {
      this.surplusWeight = surplusWeight;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setNum(final Integer num) {
      this.num = num;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlatePartListDTO)) {
         return false;
      }

      PlatePartListDTO other = (PlatePartListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$surplusWeight = this.getSurplusWeight();
      Object other$surplusWeight = other.getSurplusWeight();
      if (this$surplusWeight == null ? other$surplusWeight == null : this$surplusWeight.equals(other$surplusWeight)) {
         Object this$num = this.getNum();
         Object other$num = other.getNum();
         if (this$num == null ? other$num == null : this$num.equals(other$num)) {
            Object this$list = this.getList();
            Object other$list = other.getList();
            if (this$list == null ? other$list == null : this$list.equals(other$list)) {
               Object this$ncName = this.getNcName();
               Object other$ncName = other.getNcName();
               if (this$ncName == null ? other$ncName == null : this$ncName.equals(other$ncName)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$thick = this.getThick();
                        Object other$thick = other.getThick();
                        return this$thick == null ? other$thick == null : this$thick.equals(other$thick);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlatePartListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $surplusWeight = this.getSurplusWeight();
      result = result * 59 + ($surplusWeight == null ? 43 : $surplusWeight.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $ncName = this.getNcName();
      result = result * 59 + ($ncName == null ? 43 : $ncName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      return result * 59 + ($thick == null ? 43 : $thick.hashCode());
   }

   @Override
   public String toString() {
      return "PlatePartListDTO(list="
         + this.getList()
         + ", ncName="
         + this.getNcName()
         + ", specification="
         + this.getSpecification()
         + ", surplusWeight="
         + this.getSurplusWeight()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", num="
         + this.getNum()
         + ")";
   }

   public static class PlatePartListDTOBuilder {
      private List<PartDTO> list;
      private String ncName;
      private String specification;
      private Double surplusWeight;
      private String material;
      private BigDecimal thick;
      private Integer num;

      PlatePartListDTOBuilder() {
      }

      public PlatePartListDTO.PlatePartListDTOBuilder list(final List<PartDTO> list) {
         this.list = list;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder ncName(final String ncName) {
         this.ncName = ncName;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder surplusWeight(final Double surplusWeight) {
         this.surplusWeight = surplusWeight;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public PlatePartListDTO.PlatePartListDTOBuilder num(final Integer num) {
         this.num = num;
         return this;
      }

      public PlatePartListDTO build() {
         return new PlatePartListDTO(this.list, this.ncName, this.specification, this.surplusWeight, this.material, this.thick, this.num);
      }

      @Override
      public String toString() {
         return "PlatePartListDTO.PlatePartListDTOBuilder(list="
            + this.list
            + ", ncName="
            + this.ncName
            + ", specification="
            + this.specification
            + ", surplusWeight="
            + this.surplusWeight
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", num="
            + this.num
            + ")";
      }
   }
}
