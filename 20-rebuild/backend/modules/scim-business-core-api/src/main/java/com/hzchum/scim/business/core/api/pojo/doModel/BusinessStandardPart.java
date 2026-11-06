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

@ApiModel(value = "BusinessStandardPart对象", description = "标准件商务表 ")
@Entity
@TableName("business_standard_part")
@Table(name = "business_standard_part")
@org.hibernate.annotations.Table(appliesTo = "business_standard_part", comment = "标准件商务表 ")
public class BusinessStandardPart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) comment '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) comment '围护品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件' ")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2  COMMENT '关联类型 2构件 4围护'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   @TableField("use_property")
   @Column(name = "use_property", columnDefinition = "int(11)  COMMENT '使用属性 1工地 2工厂'")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '单位'", nullable = false)
   private String measureUnit;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) default '0.0000' COMMENT '数量'")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(18,4) COMMENT '核算量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(16)  COMMENT '单位'")
   private String accountingUnit;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8) COMMENT '单价'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8) COMMENT '总价'")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "materialInventoryId", value = "WMS库存Id", notes = "WMS库存Id")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint(20)  COMMENT 'WMS库存Id'")
   private Long materialInventoryId;

   public static BusinessStandardPart.BusinessStandardPartBuilder builder() {
      return new BusinessStandardPart.BusinessStandardPartBuilder();
   }

   public BusinessStandardPart() {
   }

   public BusinessStandardPart(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer category,
      final Long enclosurePlanId,
      final String name,
      final Integer relationType,
      final Integer useProperty,
      final String specification,
      final String measureUnit,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Long materialInventoryId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.name = name;
      this.relationType = relationType;
      this.useProperty = useProperty;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.materialInventoryId = materialInventoryId;
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

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public BusinessStandardPart setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessStandardPart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessStandardPart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessStandardPart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessStandardPart setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public BusinessStandardPart setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public BusinessStandardPart setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessStandardPart setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public BusinessStandardPart setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public BusinessStandardPart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public BusinessStandardPart setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public BusinessStandardPart setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public BusinessStandardPart setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public BusinessStandardPart setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public BusinessStandardPart setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessStandardPart setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public BusinessStandardPart setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessStandardPart(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", name="
         + this.getName()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessStandardPart)) {
         return false;
      }

      BusinessStandardPart other = (BusinessStandardPart)o;
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
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$enclosurePlanId = this.getEnclosurePlanId();
                     Object other$enclosurePlanId = other.getEnclosurePlanId();
                     if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                        Object this$relationType = this.getRelationType();
                        Object other$relationType = other.getRelationType();
                        if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                           Object this$useProperty = this.getUseProperty();
                           Object other$useProperty = other.getUseProperty();
                           if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                              Object this$materialInventoryId = this.getMaterialInventoryId();
                              Object other$materialInventoryId = other.getMaterialInventoryId();
                              if (this$materialInventoryId == null
                                 ? other$materialInventoryId == null
                                 : this$materialInventoryId.equals(other$materialInventoryId)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$measureUnit = this.getMeasureUnit();
                                       Object other$measureUnit = other.getMeasureUnit();
                                       if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessStandardPart;
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
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   public static class BusinessStandardPartBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer category;
      private Long enclosurePlanId;
      private String name;
      private Integer relationType;
      private Integer useProperty;
      private String specification;
      private String measureUnit;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Long materialInventoryId;

      BusinessStandardPartBuilder() {
      }

      public BusinessStandardPart.BusinessStandardPartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessStandardPart.BusinessStandardPartBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public BusinessStandardPart.BusinessStandardPartBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public BusinessStandardPart build() {
         return new BusinessStandardPart(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.category,
            this.enclosurePlanId,
            this.name,
            this.relationType,
            this.useProperty,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.unitPrice,
            this.totalPrice,
            this.materialInventoryId
         );
      }

      @Override
      public String toString() {
         return "BusinessStandardPart.BusinessStandardPartBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", name="
            + this.name
            + ", relationType="
            + this.relationType
            + ", useProperty="
            + this.useProperty
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", materialInventoryId="
            + this.materialInventoryId
            + ")";
      }
   }
}
