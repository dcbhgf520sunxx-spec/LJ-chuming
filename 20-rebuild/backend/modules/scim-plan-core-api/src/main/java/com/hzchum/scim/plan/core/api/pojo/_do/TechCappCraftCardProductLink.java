package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechCappCraftCardProductLink对象", description = "")
@Entity
@TableName("tech_capp_craft_card_product_link")
@Table(name = "tech_capp_craft_card_product_link")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_product_link")
public class TechCappCraftCardProductLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺卡id", notes = "焊接工艺卡id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺卡id'", nullable = false)
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   @TableField("welding_serial_number")
   @Column(name = "welding_serial_number", columnDefinition = "varchar(255)  COMMENT '焊缝编号'", nullable = false)
   private String weldingSerialNumber;
   @ApiModelProperty(name = "productType", value = "产品类型（目前只有个构件 跟 部件进行焊接操作）", notes = "产品类型（目前只有个构件 跟 部件进行焊接操作）")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型（目前只有个构件 跟 部件进行焊接操作）'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号'", nullable = true)
   private String productSerialNumber;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "craftType", value = "工艺类型", notes = "工艺类型")
   @TableField("craft_type")
   @Column(name = "craft_type", columnDefinition = "int(11)  COMMENT '工艺类型'", nullable = false)
   private Integer craftType;

   public static TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder builder() {
      return new TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder();
   }

   public TechCappCraftCardProductLink() {
   }

   public TechCappCraftCardProductLink(
      final Long id,
      final Long productId,
      final Long techCappCraftCardStorehouseId,
      final String weldingSerialNumber,
      final Integer productType,
      final String productSerialNumber,
      final Long monomerId,
      final Long areaId,
      final Integer craftType
   ) {
      this.id = id;
      this.productId = productId;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      this.weldingSerialNumber = weldingSerialNumber;
      this.productType = productType;
      this.productSerialNumber = productSerialNumber;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.craftType = craftType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public TechCappCraftCardProductLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardProductLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechCappCraftCardProductLink setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   public TechCappCraftCardProductLink setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
      return this;
   }

   public TechCappCraftCardProductLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftCardProductLink setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public TechCappCraftCardProductLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftCardProductLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechCappCraftCardProductLink setCraftType(final Integer craftType) {
      this.craftType = craftType;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardProductLink(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", craftType="
         + this.getCraftType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardProductLink)) {
         return false;
      }

      TechCappCraftCardProductLink other = (TechCappCraftCardProductLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
            Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
            if (this$techCappCraftCardStorehouseId == null
               ? other$techCappCraftCardStorehouseId == null
               : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$craftType = this.getCraftType();
                        Object other$craftType = other.getCraftType();
                        if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
                           Object this$weldingSerialNumber = this.getWeldingSerialNumber();
                           Object other$weldingSerialNumber = other.getWeldingSerialNumber();
                           if (this$weldingSerialNumber == null
                              ? other$weldingSerialNumber == null
                              : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
                              Object this$productSerialNumber = this.getProductSerialNumber();
                              Object other$productSerialNumber = other.getProductSerialNumber();
                              return this$productSerialNumber == null
                                 ? other$productSerialNumber == null
                                 : this$productSerialNumber.equals(other$productSerialNumber);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechCappCraftCardProductLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   public static class TechCappCraftCardProductLinkBuilder {
      private Long id;
      private Long productId;
      private Long techCappCraftCardStorehouseId;
      private String weldingSerialNumber;
      private Integer productType;
      private String productSerialNumber;
      private Long monomerId;
      private Long areaId;
      private Integer craftType;

      TechCappCraftCardProductLinkBuilder() {
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder techCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder weldingSerialNumber(final String weldingSerialNumber) {
         this.weldingSerialNumber = weldingSerialNumber;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder craftType(final Integer craftType) {
         this.craftType = craftType;
         return this;
      }

      public TechCappCraftCardProductLink build() {
         return new TechCappCraftCardProductLink(
            this.id,
            this.productId,
            this.techCappCraftCardStorehouseId,
            this.weldingSerialNumber,
            this.productType,
            this.productSerialNumber,
            this.monomerId,
            this.areaId,
            this.craftType
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardProductLink.TechCappCraftCardProductLinkBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ", weldingSerialNumber="
            + this.weldingSerialNumber
            + ", productType="
            + this.productType
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", craftType="
            + this.craftType
            + ")";
      }
   }
}
