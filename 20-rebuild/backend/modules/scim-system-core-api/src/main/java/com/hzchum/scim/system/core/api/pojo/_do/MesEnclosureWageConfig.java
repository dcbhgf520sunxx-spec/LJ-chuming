package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesEnclosureWageConfig对象", description = "围护工价配置表")
@Entity
@TableName("mes_enclosure_wage_config")
@Table(name = "mes_enclosure_wage_config")
@org.hibernate.annotations.Table(appliesTo = "mes_enclosure_wage_config", comment = "围护工价配置表")
public class MesEnclosureWageConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "unit", value = "计量单位（统一为米）", notes = "计量单位（统一为米）")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255)  COMMENT '计量单位（统一为米）'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价（元）", notes = "单价（元）")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价（元）'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) DEFAULT 1  COMMENT '状态'", nullable = true)
   private Boolean status;

   public static MesEnclosureWageConfig.MesEnclosureWageConfigBuilder builder() {
      return new MesEnclosureWageConfig.MesEnclosureWageConfigBuilder();
   }

   public MesEnclosureWageConfig() {
   }

   public MesEnclosureWageConfig(final Long id, final Integer category, final String unit, final BigDecimal price, final Boolean status) {
      this.id = id;
      this.category = category;
      this.unit = unit;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesEnclosureWageConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureWageConfig setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public MesEnclosureWageConfig setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesEnclosureWageConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesEnclosureWageConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureWageConfig(id="
         + this.getId()
         + ", category="
         + this.getCategory()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWageConfig)) {
         return false;
      }

      MesEnclosureWageConfig other = (MesEnclosureWageConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
      return other instanceof MesEnclosureWageConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureWageConfigBuilder {
      private Long id;
      private Integer category;
      private String unit;
      private BigDecimal price;
      private Boolean status;

      MesEnclosureWageConfigBuilder() {
      }

      public MesEnclosureWageConfig.MesEnclosureWageConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureWageConfig.MesEnclosureWageConfigBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesEnclosureWageConfig.MesEnclosureWageConfigBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesEnclosureWageConfig.MesEnclosureWageConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureWageConfig.MesEnclosureWageConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesEnclosureWageConfig build() {
         return new MesEnclosureWageConfig(this.id, this.category, this.unit, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesEnclosureWageConfig.MesEnclosureWageConfigBuilder(id="
            + this.id
            + ", category="
            + this.category
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
