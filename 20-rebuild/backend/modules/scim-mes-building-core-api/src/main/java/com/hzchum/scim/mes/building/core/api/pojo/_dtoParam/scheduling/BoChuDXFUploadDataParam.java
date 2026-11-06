package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "BoChuDXFUploadParam", description = "柏楚作业上传DXF数据接口参数")
public class BoChuDXFUploadDataParam {
   @JsonProperty("part_name")
   private String part_name;
   @JsonProperty("material")
   private String material;
   @JsonProperty("thickness")
   private BigDecimal thickness;
   @JsonProperty("gas")
   private String gas;
   @JsonProperty("amount")
   private BigDecimal amount;
   @JsonProperty("rotate_lock")
   private int rotate_lock;
   @JsonProperty("prop")
   private BoChuDXFUploadPropParam prop;

   public static BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder builder() {
      return new BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder();
   }

   public BoChuDXFUploadDataParam(
      final String part_name,
      final String material,
      final BigDecimal thickness,
      final String gas,
      final BigDecimal amount,
      final int rotate_lock,
      final BoChuDXFUploadPropParam prop
   ) {
      this.part_name = part_name;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.amount = amount;
      this.rotate_lock = rotate_lock;
      this.prop = prop;
   }

   public BoChuDXFUploadDataParam() {
   }

   public String getPart_name() {
      return this.part_name;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public int getRotate_lock() {
      return this.rotate_lock;
   }

   public BoChuDXFUploadPropParam getProp() {
      return this.prop;
   }

   @JsonProperty("part_name")
   public BoChuDXFUploadDataParam setPart_name(final String part_name) {
      this.part_name = part_name;
      return this;
   }

   @JsonProperty("material")
   public BoChuDXFUploadDataParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("thickness")
   public BoChuDXFUploadDataParam setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("gas")
   public BoChuDXFUploadDataParam setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   @JsonProperty("amount")
   public BoChuDXFUploadDataParam setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("rotate_lock")
   public BoChuDXFUploadDataParam setRotate_lock(final int rotate_lock) {
      this.rotate_lock = rotate_lock;
      return this;
   }

   @JsonProperty("prop")
   public BoChuDXFUploadDataParam setProp(final BoChuDXFUploadPropParam prop) {
      this.prop = prop;
      return this;
   }

   @Override
   public String toString() {
      return "BoChuDXFUploadDataParam(part_name="
         + this.getPart_name()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", amount="
         + this.getAmount()
         + ", rotate_lock="
         + this.getRotate_lock()
         + ", prop="
         + this.getProp()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuDXFUploadDataParam)) {
         return false;
      }

      BoChuDXFUploadDataParam other = (BoChuDXFUploadDataParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getRotate_lock() != other.getRotate_lock()) {
         return false;
      }

      Object this$part_name = this.getPart_name();
      Object other$part_name = other.getPart_name();
      if (this$part_name == null ? other$part_name == null : this$part_name.equals(other$part_name)) {
         Object this$material = this.getMaterial();
         Object other$material = other.getMaterial();
         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
            Object this$thickness = this.getThickness();
            Object other$thickness = other.getThickness();
            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
               Object this$gas = this.getGas();
               Object other$gas = other.getGas();
               if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$prop = this.getProp();
                     Object other$prop = other.getProp();
                     return this$prop == null ? other$prop == null : this$prop.equals(other$prop);
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
      return other instanceof BoChuDXFUploadDataParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRotate_lock();
      Object $part_name = this.getPart_name();
      result = result * 59 + ($part_name == null ? 43 : $part_name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $prop = this.getProp();
      return result * 59 + ($prop == null ? 43 : $prop.hashCode());
   }

   public static class BoChuDXFUploadDataParamBuilder {
      private String part_name;
      private String material;
      private BigDecimal thickness;
      private String gas;
      private BigDecimal amount;
      private int rotate_lock;
      private BoChuDXFUploadPropParam prop;

      BoChuDXFUploadDataParamBuilder() {
      }

      @JsonProperty("part_name")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder part_name(final String part_name) {
         this.part_name = part_name;
         return this;
      }

      @JsonProperty("material")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("gas")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      @JsonProperty("amount")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("rotate_lock")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder rotate_lock(final int rotate_lock) {
         this.rotate_lock = rotate_lock;
         return this;
      }

      @JsonProperty("prop")
      public BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder prop(final BoChuDXFUploadPropParam prop) {
         this.prop = prop;
         return this;
      }

      public BoChuDXFUploadDataParam build() {
         return new BoChuDXFUploadDataParam(this.part_name, this.material, this.thickness, this.gas, this.amount, this.rotate_lock, this.prop);
      }

      @Override
      public String toString() {
         return "BoChuDXFUploadDataParam.BoChuDXFUploadDataParamBuilder(part_name="
            + this.part_name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", amount="
            + this.amount
            + ", rotate_lock="
            + this.rotate_lock
            + ", prop="
            + this.prop
            + ")";
      }
   }
}
