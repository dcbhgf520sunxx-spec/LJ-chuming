package com.hzchum.scim.plan.core.api.pojo.dto.steel;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SteelAnalysisDTO {
   @ApiModelProperty("名称")
   private String name;
   @JSONField(serialize = false)
   @ApiModelProperty("排序")
   private Integer index;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("厚度/规格")
   private String thickness;
   @ApiModelProperty("配置id")
   private String configId;
   @ApiModelProperty("基础配置id")
   private Long basicId;
   @ApiModelProperty("清单量")
   private BigDecimal listMete;
   @ApiModelProperty("生产量")
   private BigDecimal productMete;
   @ApiModelProperty("当前库存")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal stockMete;
   @ApiModelProperty("使用量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal useMete;
   @ApiModelProperty("差异")
   private BigDecimal diff;
   @ApiModelProperty("差异率")
   private BigDecimal diffRate;

   public static SteelAnalysisDTO.SteelAnalysisDTOBuilder builder() {
      return new SteelAnalysisDTO.SteelAnalysisDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public Integer getIndex() {
      return this.index;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getConfigId() {
      return this.configId;
   }

   public Long getBasicId() {
      return this.basicId;
   }

   public BigDecimal getListMete() {
      return this.listMete;
   }

   public BigDecimal getProductMete() {
      return this.productMete;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public BigDecimal getUseMete() {
      return this.useMete;
   }

   public BigDecimal getDiff() {
      return this.diff;
   }

   public BigDecimal getDiffRate() {
      return this.diffRate;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIndex(final Integer index) {
      this.index = index;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setConfigId(final String configId) {
      this.configId = configId;
   }

   public void setBasicId(final Long basicId) {
      this.basicId = basicId;
   }

   public void setListMete(final BigDecimal listMete) {
      this.listMete = listMete;
   }

   public void setProductMete(final BigDecimal productMete) {
      this.productMete = productMete;
   }

   public void setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
   }

   public void setUseMete(final BigDecimal useMete) {
      this.useMete = useMete;
   }

   public void setDiff(final BigDecimal diff) {
      this.diff = diff;
   }

   public void setDiffRate(final BigDecimal diffRate) {
      this.diffRate = diffRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelAnalysisDTO)) {
         return false;
      }

      SteelAnalysisDTO other = (SteelAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$index = this.getIndex();
      Object other$index = other.getIndex();
      if (this$index == null ? other$index == null : this$index.equals(other$index)) {
         Object this$basicId = this.getBasicId();
         Object other$basicId = other.getBasicId();
         if (this$basicId == null ? other$basicId == null : this$basicId.equals(other$basicId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$configId = this.getConfigId();
                     Object other$configId = other.getConfigId();
                     if (this$configId == null ? other$configId == null : this$configId.equals(other$configId)) {
                        Object this$listMete = this.getListMete();
                        Object other$listMete = other.getListMete();
                        if (this$listMete == null ? other$listMete == null : this$listMete.equals(other$listMete)) {
                           Object this$productMete = this.getProductMete();
                           Object other$productMete = other.getProductMete();
                           if (this$productMete == null ? other$productMete == null : this$productMete.equals(other$productMete)) {
                              Object this$stockMete = this.getStockMete();
                              Object other$stockMete = other.getStockMete();
                              if (this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete)) {
                                 Object this$useMete = this.getUseMete();
                                 Object other$useMete = other.getUseMete();
                                 if (this$useMete == null ? other$useMete == null : this$useMete.equals(other$useMete)) {
                                    Object this$diff = this.getDiff();
                                    Object other$diff = other.getDiff();
                                    if (this$diff == null ? other$diff == null : this$diff.equals(other$diff)) {
                                       Object this$diffRate = this.getDiffRate();
                                       Object other$diffRate = other.getDiffRate();
                                       return this$diffRate == null ? other$diffRate == null : this$diffRate.equals(other$diffRate);
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
      return other instanceof SteelAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $basicId = this.getBasicId();
      result = result * 59 + ($basicId == null ? 43 : $basicId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $configId = this.getConfigId();
      result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
      Object $listMete = this.getListMete();
      result = result * 59 + ($listMete == null ? 43 : $listMete.hashCode());
      Object $productMete = this.getProductMete();
      result = result * 59 + ($productMete == null ? 43 : $productMete.hashCode());
      Object $stockMete = this.getStockMete();
      result = result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
      Object $useMete = this.getUseMete();
      result = result * 59 + ($useMete == null ? 43 : $useMete.hashCode());
      Object $diff = this.getDiff();
      result = result * 59 + ($diff == null ? 43 : $diff.hashCode());
      Object $diffRate = this.getDiffRate();
      return result * 59 + ($diffRate == null ? 43 : $diffRate.hashCode());
   }

   @Override
   public String toString() {
      return "SteelAnalysisDTO(name="
         + this.getName()
         + ", index="
         + this.getIndex()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", configId="
         + this.getConfigId()
         + ", basicId="
         + this.getBasicId()
         + ", listMete="
         + this.getListMete()
         + ", productMete="
         + this.getProductMete()
         + ", stockMete="
         + this.getStockMete()
         + ", useMete="
         + this.getUseMete()
         + ", diff="
         + this.getDiff()
         + ", diffRate="
         + this.getDiffRate()
         + ")";
   }

   public SteelAnalysisDTO(
      final String name,
      final Integer index,
      final String material,
      final String thickness,
      final String configId,
      final Long basicId,
      final BigDecimal listMete,
      final BigDecimal productMete,
      final BigDecimal stockMete,
      final BigDecimal useMete,
      final BigDecimal diff,
      final BigDecimal diffRate
   ) {
      this.name = name;
      this.index = index;
      this.material = material;
      this.thickness = thickness;
      this.configId = configId;
      this.basicId = basicId;
      this.listMete = listMete;
      this.productMete = productMete;
      this.stockMete = stockMete;
      this.useMete = useMete;
      this.diff = diff;
      this.diffRate = diffRate;
   }

   public SteelAnalysisDTO() {
   }

   public static class SteelAnalysisDTOBuilder {
      private String name;
      private Integer index;
      private String material;
      private String thickness;
      private String configId;
      private Long basicId;
      private BigDecimal listMete;
      private BigDecimal productMete;
      private BigDecimal stockMete;
      private BigDecimal useMete;
      private BigDecimal diff;
      private BigDecimal diffRate;

      SteelAnalysisDTOBuilder() {
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder index(final Integer index) {
         this.index = index;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder configId(final String configId) {
         this.configId = configId;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder basicId(final Long basicId) {
         this.basicId = basicId;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder listMete(final BigDecimal listMete) {
         this.listMete = listMete;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder productMete(final BigDecimal productMete) {
         this.productMete = productMete;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder useMete(final BigDecimal useMete) {
         this.useMete = useMete;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder diff(final BigDecimal diff) {
         this.diff = diff;
         return this;
      }

      public SteelAnalysisDTO.SteelAnalysisDTOBuilder diffRate(final BigDecimal diffRate) {
         this.diffRate = diffRate;
         return this;
      }

      public SteelAnalysisDTO build() {
         return new SteelAnalysisDTO(
            this.name,
            this.index,
            this.material,
            this.thickness,
            this.configId,
            this.basicId,
            this.listMete,
            this.productMete,
            this.stockMete,
            this.useMete,
            this.diff,
            this.diffRate
         );
      }

      @Override
      public String toString() {
         return "SteelAnalysisDTO.SteelAnalysisDTOBuilder(name="
            + this.name
            + ", index="
            + this.index
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", configId="
            + this.configId
            + ", basicId="
            + this.basicId
            + ", listMete="
            + this.listMete
            + ", productMete="
            + this.productMete
            + ", stockMete="
            + this.stockMete
            + ", useMete="
            + this.useMete
            + ", diff="
            + this.diff
            + ", diffRate="
            + this.diffRate
            + ")";
      }
   }
}
