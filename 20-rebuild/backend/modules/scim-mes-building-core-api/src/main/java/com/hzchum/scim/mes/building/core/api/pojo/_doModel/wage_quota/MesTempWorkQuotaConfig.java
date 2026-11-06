package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesTempWorkQuotaConfig对象", description = "点工定额配置表")
@Entity
@TableName("mes_temp_work_quota_config")
@Table(name = "mes_temp_work_quota_config")
@org.hibernate.annotations.Table(appliesTo = "mes_temp_work_quota_config", comment = "点工定额配置表")
public class MesTempWorkQuotaConfig extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("点工名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) COMMENT '点工名称'", nullable = true)
   private String name;
   @ApiModelProperty("类型")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) COMMENT '类型'", nullable = true)
   private Integer type;
   @ApiModelProperty("工时单价(元/小时)")
   @TableField(value = "price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '工时单价(元/小时)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("状态(true: 启用, false: 禁用)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) COMMENT '状态(true: 启用, false: 禁用)'", nullable = true)
   private Boolean status;

   public static MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder builder() {
      return new MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder();
   }

   public MesTempWorkQuotaConfig() {
   }

   public MesTempWorkQuotaConfig(final Long id, final String name, final Integer type, final BigDecimal price, final Boolean status) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesTempWorkQuotaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesTempWorkQuotaConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public MesTempWorkQuotaConfig setType(final Integer type) {
      this.type = type;
      return this;
   }

   public MesTempWorkQuotaConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesTempWorkQuotaConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesTempWorkQuotaConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
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

      if (!(o instanceof MesTempWorkQuotaConfig)) {
         return false;
      }

      MesTempWorkQuotaConfig other = (MesTempWorkQuotaConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
      return other instanceof MesTempWorkQuotaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesTempWorkQuotaConfigBuilder {
      private Long id;
      private String name;
      private Integer type;
      private BigDecimal price;
      private Boolean status;

      MesTempWorkQuotaConfigBuilder() {
      }

      public MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesTempWorkQuotaConfig build() {
         return new MesTempWorkQuotaConfig(this.id, this.name, this.type, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesTempWorkQuotaConfig.MesTempWorkQuotaConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", type="
            + this.type
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
