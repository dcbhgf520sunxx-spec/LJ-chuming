package com.hzchum.scim.business.core.api.pojo.doModel.bridge;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "BusinessBridgeBox对象", description = "分段(箱体)商务")
@Entity
@TableName("business_bridge_box")
@Table(name = "business_bridge_box")
@org.hibernate.annotations.Table(appliesTo = "business_bridge_box", comment = "分段(箱体)商务 ")
public class BusinessBridgeBox extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "boolMergeEnum", value = "是否合并计价", notes = "是否合并计价")
   @JsonProperty("boolMergeEnum")
   @JSONField(name = "boolMergeEnum")
   @TableField("bool_merge_enum")
   @Column(name = "bool_merge_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否合并计价'", nullable = false)
   private Boolean boolMergeEnum;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'")
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空", notes = "材质 若非合并计价，材质为空")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质 若非合并计价，材质为空'")
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   @TableField("total_quantity")
   @Column(name = "total_quantity", columnDefinition = "int(11) default '0' COMMENT '总数'", nullable = false)
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总重'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   @JsonProperty("totalPrice")
   @JSONField(name = "totalPrice")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8)  COMMENT '总价'")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  0重量 1长度", notes = "计价方式 0重量 1长度")
   @JsonProperty("pricingManner")
   @JSONField(name = "pricingManner")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(1) default 0 COMMENT '计价方式 0重量 1长度'", nullable = false)
   private Integer pricingManner;

   public static BusinessBridgeBox.BusinessBridgeBoxBuilder builder() {
      return new BusinessBridgeBox.BusinessBridgeBoxBuilder();
   }

   public BusinessBridgeBox() {
   }

   public BusinessBridgeBox(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Boolean boolMergeEnum,
      final String specification,
      final String name,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalWeight,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer pricingManner
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.boolMergeEnum = boolMergeEnum;
      this.specification = specification;
      this.name = name;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalWeight = totalWeight;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.pricingManner = pricingManner;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Boolean getBoolMergeEnum() {
      return this.boolMergeEnum;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   @JsonProperty("id")
   public BusinessBridgeBox setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public BusinessBridgeBox setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public BusinessBridgeBox setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("boolMergeEnum")
   public BusinessBridgeBox setBoolMergeEnum(final Boolean boolMergeEnum) {
      this.boolMergeEnum = boolMergeEnum;
      return this;
   }

   @JsonProperty("specification")
   public BusinessBridgeBox setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("name")
   public BusinessBridgeBox setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public BusinessBridgeBox setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("totalQuantity")
   public BusinessBridgeBox setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalWeight")
   public BusinessBridgeBox setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("unitPrice")
   public BusinessBridgeBox setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("totalPrice")
   public BusinessBridgeBox setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("pricingManner")
   public BusinessBridgeBox setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessBridgeBox(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", boolMergeEnum="
         + this.getBoolMergeEnum()
         + ", specification="
         + this.getSpecification()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessBridgeBox)) {
         return false;
      }

      BusinessBridgeBox other = (BusinessBridgeBox)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$boolMergeEnum = this.getBoolMergeEnum();
               Object other$boolMergeEnum = other.getBoolMergeEnum();
               if (this$boolMergeEnum == null ? other$boolMergeEnum == null : this$boolMergeEnum.equals(other$boolMergeEnum)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$pricingManner = this.getPricingManner();
                     Object other$pricingManner = other.getPricingManner();
                     if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$totalWeight = this.getTotalWeight();
                                 Object other$totalWeight = other.getTotalWeight();
                                 if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                    Object this$unitPrice = this.getUnitPrice();
                                    Object other$unitPrice = other.getUnitPrice();
                                    if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                       Object this$totalPrice = this.getTotalPrice();
                                       Object other$totalPrice = other.getTotalPrice();
                                       return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof BusinessBridgeBox;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $boolMergeEnum = this.getBoolMergeEnum();
      result = result * 59 + ($boolMergeEnum == null ? 43 : $boolMergeEnum.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   public static class BusinessBridgeBoxBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Boolean boolMergeEnum;
      private String specification;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;

      BusinessBridgeBoxBuilder() {
      }

      @JsonProperty("id")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("boolMergeEnum")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder boolMergeEnum(final Boolean boolMergeEnum) {
         this.boolMergeEnum = boolMergeEnum;
         return this;
      }

      @JsonProperty("specification")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("name")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("totalQuantity")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalWeight")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("unitPrice")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("totalPrice")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("pricingManner")
      public BusinessBridgeBox.BusinessBridgeBoxBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessBridgeBox build() {
         return new BusinessBridgeBox(
            this.id,
            this.projectId,
            this.monomerId,
            this.boolMergeEnum,
            this.specification,
            this.name,
            this.material,
            this.totalQuantity,
            this.totalWeight,
            this.unitPrice,
            this.totalPrice,
            this.pricingManner
         );
      }

      @Override
      public String toString() {
         return "BusinessBridgeBox.BusinessBridgeBoxBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", boolMergeEnum="
            + this.boolMergeEnum
            + ", specification="
            + this.specification
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalWeight="
            + this.totalWeight
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", pricingManner="
            + this.pricingManner
            + ")";
      }
   }
}
