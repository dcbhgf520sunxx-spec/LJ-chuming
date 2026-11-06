package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessMachinePart对象", description = "商务直发零件 ")
@Entity
@TableName("business_machine_part")
@Table(name = "business_machine_part")
@org.hibernate.annotations.Table(appliesTo = "business_machine_part", comment = "商务直发零件 ")
public class BusinessMachinePart extends BaseEntity<Long> {
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
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   @TableField("total_quantity")
   @Column(name = "total_quantity", columnDefinition = "int(11)  COMMENT '总数'", nullable = false)
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)", notes = "总重量(kg)")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总重量(kg)'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)", notes = "总长度(m)")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总长度(m)'", nullable = false)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单价'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总价'")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 0重量 1长度", notes = "计价方式 0重量 1长度")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(11) default '0' COMMENT '计价方式 0重量 1长度'", nullable = false)
   private Integer pricingManner;

   public static BusinessMachinePart.BusinessMachinePartBuilder builder() {
      return new BusinessMachinePart.BusinessMachinePartBuilder();
   }

   public BusinessMachinePart() {
   }

   public BusinessMachinePart(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String specification,
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
      this.name = name;
      this.specification = specification;
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

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
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

   public BusinessMachinePart setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessMachinePart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessMachinePart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessMachinePart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessMachinePart setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessMachinePart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public BusinessMachinePart setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public BusinessMachinePart setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public BusinessMachinePart setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public BusinessMachinePart setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public BusinessMachinePart setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessMachinePart setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public BusinessMachinePart setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessMachinePart(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
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

      if (!(o instanceof BusinessMachinePart)) {
         return false;
      }

      BusinessMachinePart other = (BusinessMachinePart)o;
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
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$pricingManner = this.getPricingManner();
                     Object other$pricingManner = other.getPricingManner();
                     if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessMachinePart;
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
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
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

   public static class BusinessMachinePartBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String specification;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;

      BusinessMachinePartBuilder() {
      }

      public BusinessMachinePart.BusinessMachinePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessMachinePart.BusinessMachinePartBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessMachinePart build() {
         return new BusinessMachinePart(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.name,
            this.specification,
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
         return "BusinessMachinePart.BusinessMachinePartBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", specification="
            + this.specification
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
