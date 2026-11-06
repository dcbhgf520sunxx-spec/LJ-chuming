package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesPartProcessConfig对象", description = "下发可选零件工序配置表")
@Entity
@TableName("mes_part_process_config")
@Table(name = "mes_part_process_config")
@org.hibernate.annotations.Table(appliesTo = "mes_part_process_config", comment = "下发可选零件工序配置表")
public class MesPartProcessConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productCategoryType", value = "产品科目类型[1 板材零件 2 型材零件]", notes = "产品科目类型[1 板材零件 2 型材零件]")
   @TableField("product_category_type")
   @Column(name = "product_category_type", columnDefinition = "int(11) default '0' COMMENT '产品科目类型[1 板材零件 2 型材零件]'", nullable = false)
   private Integer productCategoryType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式[1 数控切割 2 半自动切割]", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @TableField("part_prod_mode")
   @Column(name = "part_prod_mode", columnDefinition = "int(11) default '0' COMMENT '零件生产方式[1 数控切割 2 半自动切割]'", nullable = false)
   private Integer partProdMode;

   public static MesPartProcessConfig.MesPartProcessConfigBuilder builder() {
      return new MesPartProcessConfig.MesPartProcessConfigBuilder();
   }

   public MesPartProcessConfig() {
   }

   public MesPartProcessConfig(final Long id, final Integer productCategoryType, final Integer partProdMode) {
      this.id = id;
      this.productCategoryType = productCategoryType;
      this.partProdMode = partProdMode;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public MesPartProcessConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPartProcessConfig setProductCategoryType(final Integer productCategoryType) {
      this.productCategoryType = productCategoryType;
      return this;
   }

   public MesPartProcessConfig setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @Override
   public String toString() {
      return "MesPartProcessConfig(id="
         + this.getId()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPartProcessConfig)) {
         return false;
      }

      MesPartProcessConfig other = (MesPartProcessConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productCategoryType = this.getProductCategoryType();
         Object other$productCategoryType = other.getProductCategoryType();
         if (this$productCategoryType == null ? other$productCategoryType == null : this$productCategoryType.equals(other$productCategoryType)) {
            Object this$partProdMode = this.getPartProdMode();
            Object other$partProdMode = other.getPartProdMode();
            return this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesPartProcessConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      return result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
   }

   public static class MesPartProcessConfigBuilder {
      private Long id;
      private Integer productCategoryType;
      private Integer partProdMode;

      MesPartProcessConfigBuilder() {
      }

      public MesPartProcessConfig.MesPartProcessConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPartProcessConfig.MesPartProcessConfigBuilder productCategoryType(final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      public MesPartProcessConfig.MesPartProcessConfigBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesPartProcessConfig build() {
         return new MesPartProcessConfig(this.id, this.productCategoryType, this.partProdMode);
      }

      @Override
      public String toString() {
         return "MesPartProcessConfig.MesPartProcessConfigBuilder(id="
            + this.id
            + ", productCategoryType="
            + this.productCategoryType
            + ", partProdMode="
            + this.partProdMode
            + ")";
      }
   }
}
