package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesQuotaConfigAuxiliaryMaterial对象", description = "定额配置辅材表")
@Entity
@TableName("mes_quota_config_auxiliary_material")
@Table(name = "mes_quota_config_auxiliary_material")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_auxiliary_material", comment = "定额配置辅材表")
public class MesQuotaConfigAuxiliaryMaterial extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("类型名称")
   @TableField("type_name")
   @Column(name = "type_name", columnDefinition = "varchar(255) COMMENT '类型名称'", nullable = true)
   private String typeName;
   @ApiModelProperty("单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;

   public static MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder builder() {
      return new MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder();
   }

   public MesQuotaConfigAuxiliaryMaterial() {
   }

   public MesQuotaConfigAuxiliaryMaterial(final Long id, final String serialNumber, final String typeName, final String unit, final BigDecimal price) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.typeName = typeName;
      this.unit = unit;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesQuotaConfigAuxiliaryMaterial setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigAuxiliaryMaterial setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigAuxiliaryMaterial setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   public MesQuotaConfigAuxiliaryMaterial setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesQuotaConfigAuxiliaryMaterial setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAuxiliaryMaterial(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", typeName="
         + this.getTypeName()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAuxiliaryMaterial)) {
         return false;
      }

      MesQuotaConfigAuxiliaryMaterial other = (MesQuotaConfigAuxiliaryMaterial)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$unit = this.getUnit();
               Object other$unit = other.getUnit();
               if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                  Object this$price = this.getPrice();
                  Object other$price = other.getPrice();
                  return this$price == null ? other$price == null : this$price.equals(other$price);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigAuxiliaryMaterial;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesQuotaConfigAuxiliaryMaterialBuilder {
      private Long id;
      private String serialNumber;
      private String typeName;
      private String unit;
      private BigDecimal price;

      MesQuotaConfigAuxiliaryMaterialBuilder() {
      }

      public MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesQuotaConfigAuxiliaryMaterial build() {
         return new MesQuotaConfigAuxiliaryMaterial(this.id, this.serialNumber, this.typeName, this.unit, this.price);
      }

      @Override
      public String toString() {
         return "MesQuotaConfigAuxiliaryMaterial.MesQuotaConfigAuxiliaryMaterialBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", typeName="
            + this.typeName
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ")";
      }
   }
}
