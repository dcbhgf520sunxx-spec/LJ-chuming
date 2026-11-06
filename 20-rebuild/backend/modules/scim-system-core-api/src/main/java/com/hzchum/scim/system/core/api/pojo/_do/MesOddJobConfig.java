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

@ApiModel(value = "MesOddJobConfig对象", description = "零工配置表")
@Entity
@TableName("mes_odd_job_config")
@Table(name = "mes_odd_job_config")
@org.hibernate.annotations.Table(appliesTo = "mes_odd_job_config", comment = "零工配置表")
public class MesOddJobConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "oddJobType", value = "零工类型", notes = "零工类型")
   @TableField("odd_job_type")
   @Column(name = "odd_job_type", columnDefinition = "varchar(255)  COMMENT '零工类型'", nullable = true)
   private String oddJobType;
   @ApiModelProperty(name = "unit", value = "计算单位", notes = "计算单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255)  COMMENT '计算单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '状态'", nullable = true)
   private Boolean status;

   public static MesOddJobConfig.MesOddJobConfigBuilder builder() {
      return new MesOddJobConfig.MesOddJobConfigBuilder();
   }

   public MesOddJobConfig() {
   }

   public MesOddJobConfig(final Long id, final String oddJobType, final String unit, final BigDecimal price, final Boolean status) {
      this.id = id;
      this.oddJobType = oddJobType;
      this.unit = unit;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getOddJobType() {
      return this.oddJobType;
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

   public MesOddJobConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesOddJobConfig setOddJobType(final String oddJobType) {
      this.oddJobType = oddJobType;
      return this;
   }

   public MesOddJobConfig setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesOddJobConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesOddJobConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesOddJobConfig(id="
         + this.getId()
         + ", oddJobType="
         + this.getOddJobType()
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

      if (!(o instanceof MesOddJobConfig)) {
         return false;
      }

      MesOddJobConfig other = (MesOddJobConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$oddJobType = this.getOddJobType();
            Object other$oddJobType = other.getOddJobType();
            if (this$oddJobType == null ? other$oddJobType == null : this$oddJobType.equals(other$oddJobType)) {
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
      return other instanceof MesOddJobConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $oddJobType = this.getOddJobType();
      result = result * 59 + ($oddJobType == null ? 43 : $oddJobType.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesOddJobConfigBuilder {
      private Long id;
      private String oddJobType;
      private String unit;
      private BigDecimal price;
      private Boolean status;

      MesOddJobConfigBuilder() {
      }

      public MesOddJobConfig.MesOddJobConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesOddJobConfig.MesOddJobConfigBuilder oddJobType(final String oddJobType) {
         this.oddJobType = oddJobType;
         return this;
      }

      public MesOddJobConfig.MesOddJobConfigBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesOddJobConfig.MesOddJobConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesOddJobConfig.MesOddJobConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesOddJobConfig build() {
         return new MesOddJobConfig(this.id, this.oddJobType, this.unit, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesOddJobConfig.MesOddJobConfigBuilder(id="
            + this.id
            + ", oddJobType="
            + this.oddJobType
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
