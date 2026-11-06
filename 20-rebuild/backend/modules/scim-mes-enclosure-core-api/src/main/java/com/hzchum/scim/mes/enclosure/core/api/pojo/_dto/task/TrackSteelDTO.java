package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "TrackSteelDTO", description = "APP主材跟踪钢板用量分析")
public class TrackSteelDTO {
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("厚度/规格")
   private String thickness;
   @ApiModelProperty("清单量")
   private BigDecimal listMete;
   @ApiModelProperty("当前库存")
   private BigDecimal stockMete;
   @ApiModelProperty("使用量")
   private BigDecimal useMete;

   public static TrackSteelDTO.TrackSteelDTOBuilder builder() {
      return new TrackSteelDTO.TrackSteelDTOBuilder();
   }

   public TrackSteelDTO() {
   }

   public TrackSteelDTO(
      final String name, final String material, final String thickness, final BigDecimal listMete, final BigDecimal stockMete, final BigDecimal useMete
   ) {
      this.name = name;
      this.material = material;
      this.thickness = thickness;
      this.listMete = listMete;
      this.stockMete = stockMete;
      this.useMete = useMete;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public BigDecimal getListMete() {
      return this.listMete;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public BigDecimal getUseMete() {
      return this.useMete;
   }

   public TrackSteelDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TrackSteelDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TrackSteelDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public TrackSteelDTO setListMete(final BigDecimal listMete) {
      this.listMete = listMete;
      return this;
   }

   public TrackSteelDTO setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
      return this;
   }

   public TrackSteelDTO setUseMete(final BigDecimal useMete) {
      this.useMete = useMete;
      return this;
   }

   @Override
   public String toString() {
      return "TrackSteelDTO(name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", listMete="
         + this.getListMete()
         + ", stockMete="
         + this.getStockMete()
         + ", useMete="
         + this.getUseMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrackSteelDTO)) {
         return false;
      }

      TrackSteelDTO other = (TrackSteelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$material = this.getMaterial();
         Object other$material = other.getMaterial();
         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
            Object this$thickness = this.getThickness();
            Object other$thickness = other.getThickness();
            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
               Object this$listMete = this.getListMete();
               Object other$listMete = other.getListMete();
               if (this$listMete == null ? other$listMete == null : this$listMete.equals(other$listMete)) {
                  Object this$stockMete = this.getStockMete();
                  Object other$stockMete = other.getStockMete();
                  if (this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete)) {
                     Object this$useMete = this.getUseMete();
                     Object other$useMete = other.getUseMete();
                     return this$useMete == null ? other$useMete == null : this$useMete.equals(other$useMete);
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
      return other instanceof TrackSteelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $listMete = this.getListMete();
      result = result * 59 + ($listMete == null ? 43 : $listMete.hashCode());
      Object $stockMete = this.getStockMete();
      result = result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
      Object $useMete = this.getUseMete();
      return result * 59 + ($useMete == null ? 43 : $useMete.hashCode());
   }

   public static class TrackSteelDTOBuilder {
      private String name;
      private String material;
      private String thickness;
      private BigDecimal listMete;
      private BigDecimal stockMete;
      private BigDecimal useMete;

      TrackSteelDTOBuilder() {
      }

      public TrackSteelDTO.TrackSteelDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TrackSteelDTO.TrackSteelDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TrackSteelDTO.TrackSteelDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public TrackSteelDTO.TrackSteelDTOBuilder listMete(final BigDecimal listMete) {
         this.listMete = listMete;
         return this;
      }

      public TrackSteelDTO.TrackSteelDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      public TrackSteelDTO.TrackSteelDTOBuilder useMete(final BigDecimal useMete) {
         this.useMete = useMete;
         return this;
      }

      public TrackSteelDTO build() {
         return new TrackSteelDTO(this.name, this.material, this.thickness, this.listMete, this.stockMete, this.useMete);
      }

      @Override
      public String toString() {
         return "TrackSteelDTO.TrackSteelDTOBuilder(name="
            + this.name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", listMete="
            + this.listMete
            + ", stockMete="
            + this.stockMete
            + ", useMete="
            + this.useMete
            + ")";
      }
   }
}
