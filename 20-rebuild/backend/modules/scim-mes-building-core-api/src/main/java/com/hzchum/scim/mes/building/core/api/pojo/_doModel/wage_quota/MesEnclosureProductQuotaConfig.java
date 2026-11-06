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

@ApiModel(value = "MesEnclosureProductQuotaConfig对象", description = "围护产品定额配置表")
@Entity
@TableName("mes_enclosure_product_quota_config")
@Table(name = "mes_enclosure_product_quota_config")
@org.hibernate.annotations.Table(appliesTo = "mes_enclosure_product_quota_config", comment = "围护产品定额配置表")
public class MesEnclosureProductQuotaConfig extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("quota_number")
   @Column(name = "quota_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String quotaNumber;
   @ApiModelProperty("车间ids")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(500) COMMENT '车间ids'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) COMMENT '产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty("是否需要规格分类(true: 需分类, false: 无需分类)")
   @TableField("bool_specification_class")
   @Column(name = "bool_specification_class", columnDefinition = "tinyint(1) COMMENT '是否需要规格分类(true: 需分类, false: 无需分类)'", nullable = true)
   private Boolean boolSpecificationClass;
   @ApiModelProperty("规格分类")
   @TableField(value = "specification_class_enum", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "specification_class_enum", columnDefinition = "int(11) COMMENT '规格分类'", nullable = true)
   private Integer specificationClassEnum;
   @ApiModelProperty("单价(元/米)")
   @TableField(value = "price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元/米)'", nullable = true)
   private BigDecimal price;

   public static MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder builder() {
      return new MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder();
   }

   public MesEnclosureProductQuotaConfig() {
   }

   public MesEnclosureProductQuotaConfig(
      final Long id,
      final String quotaNumber,
      final String workshopIds,
      final Integer productType,
      final Boolean boolSpecificationClass,
      final Integer specificationClassEnum,
      final BigDecimal price
   ) {
      this.id = id;
      this.quotaNumber = quotaNumber;
      this.workshopIds = workshopIds;
      this.productType = productType;
      this.boolSpecificationClass = boolSpecificationClass;
      this.specificationClassEnum = specificationClassEnum;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public String getQuotaNumber() {
      return this.quotaNumber;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolSpecificationClass() {
      return this.boolSpecificationClass;
   }

   public Integer getSpecificationClassEnum() {
      return this.specificationClassEnum;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesEnclosureProductQuotaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureProductQuotaConfig setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
      return this;
   }

   public MesEnclosureProductQuotaConfig setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesEnclosureProductQuotaConfig setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesEnclosureProductQuotaConfig setBoolSpecificationClass(final Boolean boolSpecificationClass) {
      this.boolSpecificationClass = boolSpecificationClass;
      return this;
   }

   public MesEnclosureProductQuotaConfig setSpecificationClassEnum(final Integer specificationClassEnum) {
      this.specificationClassEnum = specificationClassEnum;
      return this;
   }

   public MesEnclosureProductQuotaConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfig(id="
         + this.getId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", productType="
         + this.getProductType()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", specificationClassEnum="
         + this.getSpecificationClassEnum()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfig)) {
         return false;
      }

      MesEnclosureProductQuotaConfig other = (MesEnclosureProductQuotaConfig)o;
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
            Object this$boolSpecificationClass = this.getBoolSpecificationClass();
            Object other$boolSpecificationClass = other.getBoolSpecificationClass();
            if (this$boolSpecificationClass == null ? other$boolSpecificationClass == null : this$boolSpecificationClass.equals(other$boolSpecificationClass)) {
               Object this$specificationClassEnum = this.getSpecificationClassEnum();
               Object other$specificationClassEnum = other.getSpecificationClassEnum();
               if (this$specificationClassEnum == null
                  ? other$specificationClassEnum == null
                  : this$specificationClassEnum.equals(other$specificationClassEnum)) {
                  Object this$quotaNumber = this.getQuotaNumber();
                  Object other$quotaNumber = other.getQuotaNumber();
                  if (this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber)) {
                     Object this$workshopIds = this.getWorkshopIds();
                     Object other$workshopIds = other.getWorkshopIds();
                     if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductQuotaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $specificationClassEnum = this.getSpecificationClassEnum();
      result = result * 59 + ($specificationClassEnum == null ? 43 : $specificationClassEnum.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      result = result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureProductQuotaConfigBuilder {
      private Long id;
      private String quotaNumber;
      private String workshopIds;
      private Integer productType;
      private Boolean boolSpecificationClass;
      private Integer specificationClassEnum;
      private BigDecimal price;

      MesEnclosureProductQuotaConfigBuilder() {
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder quotaNumber(final String quotaNumber) {
         this.quotaNumber = quotaNumber;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder boolSpecificationClass(final Boolean boolSpecificationClass) {
         this.boolSpecificationClass = boolSpecificationClass;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder specificationClassEnum(final Integer specificationClassEnum) {
         this.specificationClassEnum = specificationClassEnum;
         return this;
      }

      public MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureProductQuotaConfig build() {
         return new MesEnclosureProductQuotaConfig(
            this.id, this.quotaNumber, this.workshopIds, this.productType, this.boolSpecificationClass, this.specificationClassEnum, this.price
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProductQuotaConfig.MesEnclosureProductQuotaConfigBuilder(id="
            + this.id
            + ", quotaNumber="
            + this.quotaNumber
            + ", workshopIds="
            + this.workshopIds
            + ", productType="
            + this.productType
            + ", boolSpecificationClass="
            + this.boolSpecificationClass
            + ", specificationClassEnum="
            + this.specificationClassEnum
            + ", price="
            + this.price
            + ")";
      }
   }
}
