package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AssembleDTO对象", description = "组立清单信息")
public class SchedulingAssembleDTO {
   @ApiModelProperty(name = "classificationName", notes = "组立分类")
   @JsonProperty("classificationName")
   @JSONField(name = "classificationName")
   private String classificationName;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "weight", notes = "重量（kg）")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public static SchedulingAssembleDTO.SchedulingAssembleDTOBuilder builder() {
      return new SchedulingAssembleDTO.SchedulingAssembleDTOBuilder();
   }

   public SchedulingAssembleDTO() {
   }

   public SchedulingAssembleDTO(final String classificationName, final String material, final Integer quantity, final BigDecimal weight) {
      this.classificationName = classificationName;
      this.material = material;
      this.quantity = quantity;
      this.weight = weight;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("classificationName")
   public SchedulingAssembleDTO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   @JsonProperty("material")
   public SchedulingAssembleDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public SchedulingAssembleDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("weight")
   public SchedulingAssembleDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingAssembleDTO)) {
         return false;
      }

      SchedulingAssembleDTO other = (SchedulingAssembleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$classificationName = this.getClassificationName();
         Object other$classificationName = other.getClassificationName();
         if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$weight = this.getWeight();
               Object other$weight = other.getWeight();
               return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      return other instanceof SchedulingAssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "SchedulingAssembleDTO(classificationName="
         + this.getClassificationName()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   public static class SchedulingAssembleDTOBuilder {
      private String classificationName;
      private String material;
      private Integer quantity;
      private BigDecimal weight;

      SchedulingAssembleDTOBuilder() {
      }

      @JsonProperty("classificationName")
      public SchedulingAssembleDTO.SchedulingAssembleDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      @JsonProperty("material")
      public SchedulingAssembleDTO.SchedulingAssembleDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public SchedulingAssembleDTO.SchedulingAssembleDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("weight")
      public SchedulingAssembleDTO.SchedulingAssembleDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public SchedulingAssembleDTO build() {
         return new SchedulingAssembleDTO(this.classificationName, this.material, this.quantity, this.weight);
      }

      @Override
      public String toString() {
         return "SchedulingAssembleDTO.SchedulingAssembleDTOBuilder(classificationName="
            + this.classificationName
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
