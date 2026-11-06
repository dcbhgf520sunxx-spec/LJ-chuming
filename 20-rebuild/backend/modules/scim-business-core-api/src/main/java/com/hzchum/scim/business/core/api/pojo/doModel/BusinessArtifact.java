package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessArtifact对象", description = "结构")
@Entity
@TableName("business_artifact")
@Table(name = "business_artifact")
@org.hibernate.annotations.Table(appliesTo = "business_artifact", comment = "结构商务表")
public class BusinessArtifact extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
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
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空", notes = "材质 若非合并计价，材质为空")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质 若非合并计价，材质为空'", nullable = true)
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   @TableField("total_quantity")
   @Column(name = "total_quantity", columnDefinition = "int(11) default '0' COMMENT '总数'", nullable = false)
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重(kg)", notes = "总重(kg)")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总重(kg)'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalWeight", value = "总长(m)", notes = "总长(m)")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,8) default '0.00' COMMENT '总长(m)'", nullable = false)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   @JsonProperty("totalPrice")
   @JSONField(name = "totalPrice")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8)  COMMENT '总价'", nullable = true)
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  0重量 1长度", notes = "计价方式  0重量 1长度")
   @JsonProperty("pricingManner")
   @JSONField(name = "pricingManner")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(1) default 0 COMMENT '计价方式 0重量 1长度'", nullable = false)
   private Integer pricingManner;

   public static BusinessArtifact.BusinessArtifactBuilder builder() {
      return new BusinessArtifact.BusinessArtifactBuilder();
   }

   public BusinessArtifact() {
   }

   public BusinessArtifact(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Boolean boolMergeEnum,
      final String specification,
      final String name,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer pricingManner
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.boolMergeEnum = boolMergeEnum;
      this.specification = specification;
      this.name = name;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
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
   public BusinessArtifact setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public BusinessArtifact setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public BusinessArtifact setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessArtifact setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessArtifact setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("boolMergeEnum")
   public BusinessArtifact setBoolMergeEnum(final Boolean boolMergeEnum) {
      this.boolMergeEnum = boolMergeEnum;
      return this;
   }

   @JsonProperty("specification")
   public BusinessArtifact setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("name")
   public BusinessArtifact setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public BusinessArtifact setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("totalQuantity")
   public BusinessArtifact setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalWeight")
   public BusinessArtifact setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public BusinessArtifact setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("unitPrice")
   public BusinessArtifact setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("totalPrice")
   public BusinessArtifact setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("pricingManner")
   public BusinessArtifact setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessArtifact(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
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
         + ", totalLength="
         + this.getTotalLength()
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

      if (!(o instanceof BusinessArtifact)) {
         return false;
      }

      BusinessArtifact other = (BusinessArtifact)o;
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
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
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
                                          Object this$totalLength = this.getTotalLength();
                                          Object other$totalLength = other.getTotalLength();
                                          if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
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
      return other instanceof BusinessArtifact;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
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
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   public static class BusinessArtifactBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Boolean boolMergeEnum;
      private String specification;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;

      BusinessArtifactBuilder() {
      }

      @JsonProperty("id")
      public BusinessArtifact.BusinessArtifactBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public BusinessArtifact.BusinessArtifactBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public BusinessArtifact.BusinessArtifactBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessArtifact.BusinessArtifactBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessArtifact.BusinessArtifactBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("boolMergeEnum")
      public BusinessArtifact.BusinessArtifactBuilder boolMergeEnum(final Boolean boolMergeEnum) {
         this.boolMergeEnum = boolMergeEnum;
         return this;
      }

      @JsonProperty("specification")
      public BusinessArtifact.BusinessArtifactBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("name")
      public BusinessArtifact.BusinessArtifactBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public BusinessArtifact.BusinessArtifactBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("totalQuantity")
      public BusinessArtifact.BusinessArtifactBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalWeight")
      public BusinessArtifact.BusinessArtifactBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public BusinessArtifact.BusinessArtifactBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("unitPrice")
      public BusinessArtifact.BusinessArtifactBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("totalPrice")
      public BusinessArtifact.BusinessArtifactBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("pricingManner")
      public BusinessArtifact.BusinessArtifactBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessArtifact build() {
         return new BusinessArtifact(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.boolMergeEnum,
            this.specification,
            this.name,
            this.material,
            this.totalQuantity,
            this.totalWeight,
            this.totalLength,
            this.unitPrice,
            this.totalPrice,
            this.pricingManner
         );
      }

      @Override
      public String toString() {
         return "BusinessArtifact.BusinessArtifactBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
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
            + ", totalLength="
            + this.totalLength
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
