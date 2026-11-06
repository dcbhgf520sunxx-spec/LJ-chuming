package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "类型截面库配置对象", description = "")
@Entity
@TableName("mes_section_warehouse_config")
@Table(name = "mes_section_warehouse_config")
public class MesSectionWarehouseConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productType", value = "产品类型 1.零件 2.构件 16.组立")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) COMMENT '构件类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "productClassificationEnum", value = "产品分类 1.普通构件 2.次构件 4.型材(制品/截面) 8.钢板(制品/截面) 16.部件(截面)")
   @JsonProperty("productClassificationEnum")
   @JSONField(name = "productClassificationEnum")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) default 0  COMMENT '构件类型'", nullable = false)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "ProductSectionNameEnum", value = "产品截面类型名称枚举 1.产品名称 2.产品类型名称 4.截面类型名称 8.产品编号前缀")
   @JsonProperty("ProductSectionNameEnum")
   @JSONField(name = "ProductSectionNameEnum")
   @TableField("product_section_name_enum")
   @Column(name = "product_section_name_enum", columnDefinition = "int(11) default 0  COMMENT '构件类型'", nullable = false)
   private Integer productSectionNameEnum;

   public static MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder builder() {
      return new MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder();
   }

   public MesSectionWarehouseConfig() {
   }

   public MesSectionWarehouseConfig(final Long id, final Integer productType, final Integer productClassificationEnum, final Integer productSectionNameEnum) {
      this.id = id;
      this.productType = productType;
      this.productClassificationEnum = productClassificationEnum;
      this.productSectionNameEnum = productSectionNameEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getProductSectionNameEnum() {
      return this.productSectionNameEnum;
   }

   @JsonProperty("id")
   public MesSectionWarehouseConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesSectionWarehouseConfig setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public MesSectionWarehouseConfig setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("ProductSectionNameEnum")
   public MesSectionWarehouseConfig setProductSectionNameEnum(final Integer productSectionNameEnum) {
      this.productSectionNameEnum = productSectionNameEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesSectionWarehouseConfig(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", productSectionNameEnum="
         + this.getProductSectionNameEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSectionWarehouseConfig)) {
         return false;
      }

      MesSectionWarehouseConfig other = (MesSectionWarehouseConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productClassificationEnum = this.getProductClassificationEnum();
            Object other$productClassificationEnum = other.getProductClassificationEnum();
            if (this$productClassificationEnum == null
               ? other$productClassificationEnum == null
               : this$productClassificationEnum.equals(other$productClassificationEnum)) {
               Object this$productSectionNameEnum = this.getProductSectionNameEnum();
               Object other$productSectionNameEnum = other.getProductSectionNameEnum();
               return this$productSectionNameEnum == null
                  ? other$productSectionNameEnum == null
                  : this$productSectionNameEnum.equals(other$productSectionNameEnum);
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
      return other instanceof MesSectionWarehouseConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $productSectionNameEnum = this.getProductSectionNameEnum();
      return result * 59 + ($productSectionNameEnum == null ? 43 : $productSectionNameEnum.hashCode());
   }

   public static class MesSectionWarehouseConfigBuilder {
      private Long id;
      private Integer productType;
      private Integer productClassificationEnum;
      private Integer productSectionNameEnum;

      MesSectionWarehouseConfigBuilder() {
      }

      @JsonProperty("id")
      public MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("ProductSectionNameEnum")
      public MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder productSectionNameEnum(final Integer productSectionNameEnum) {
         this.productSectionNameEnum = productSectionNameEnum;
         return this;
      }

      public MesSectionWarehouseConfig build() {
         return new MesSectionWarehouseConfig(this.id, this.productType, this.productClassificationEnum, this.productSectionNameEnum);
      }

      @Override
      public String toString() {
         return "MesSectionWarehouseConfig.MesSectionWarehouseConfigBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", productSectionNameEnum="
            + this.productSectionNameEnum
            + ")";
      }
   }
}
