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

@ApiModel(value = "MesQuotaConfigEnclosure对象", description = "定额配置围护表")
@Entity
@TableName("mes_quota_config_enclosure")
@Table(name = "mes_quota_config_enclosure")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_enclosure", comment = "定额配置围护表")
public class MesQuotaConfigEnclosure extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("围护类型字典id")
   @TableField("enclosure_type_dictionary_id")
   @Column(name = "enclosure_type_dictionary_id", columnDefinition = "bigint(20) COMMENT '围护类型字典id'", nullable = true)
   private Long enclosureTypeDictionaryId;
   @ApiModelProperty("单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;

   public static MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder builder() {
      return new MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder();
   }

   public MesQuotaConfigEnclosure() {
   }

   public MesQuotaConfigEnclosure(final Long id, final String serialNumber, final Long enclosureTypeDictionaryId, final String unit, final BigDecimal price) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
      this.unit = unit;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getEnclosureTypeDictionaryId() {
      return this.enclosureTypeDictionaryId;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesQuotaConfigEnclosure setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigEnclosure setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigEnclosure setEnclosureTypeDictionaryId(final Long enclosureTypeDictionaryId) {
      this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
      return this;
   }

   public MesQuotaConfigEnclosure setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesQuotaConfigEnclosure setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigEnclosure(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", enclosureTypeDictionaryId="
         + this.getEnclosureTypeDictionaryId()
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

      if (!(o instanceof MesQuotaConfigEnclosure)) {
         return false;
      }

      MesQuotaConfigEnclosure other = (MesQuotaConfigEnclosure)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
         Object other$enclosureTypeDictionaryId = other.getEnclosureTypeDictionaryId();
         if (this$enclosureTypeDictionaryId == null
            ? other$enclosureTypeDictionaryId == null
            : this$enclosureTypeDictionaryId.equals(other$enclosureTypeDictionaryId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
      return other instanceof MesQuotaConfigEnclosure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
      result = result * 59 + ($enclosureTypeDictionaryId == null ? 43 : $enclosureTypeDictionaryId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesQuotaConfigEnclosureBuilder {
      private Long id;
      private String serialNumber;
      private Long enclosureTypeDictionaryId;
      private String unit;
      private BigDecimal price;

      MesQuotaConfigEnclosureBuilder() {
      }

      public MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder enclosureTypeDictionaryId(final Long enclosureTypeDictionaryId) {
         this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
         return this;
      }

      public MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesQuotaConfigEnclosure build() {
         return new MesQuotaConfigEnclosure(this.id, this.serialNumber, this.enclosureTypeDictionaryId, this.unit, this.price);
      }

      @Override
      public String toString() {
         return "MesQuotaConfigEnclosure.MesQuotaConfigEnclosureBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", enclosureTypeDictionaryId="
            + this.enclosureTypeDictionaryId
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ")";
      }
   }
}
