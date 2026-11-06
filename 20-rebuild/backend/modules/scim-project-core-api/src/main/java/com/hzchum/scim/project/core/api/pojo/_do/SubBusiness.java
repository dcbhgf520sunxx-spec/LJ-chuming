package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "SubBusiness对象", description = "分包商务")
@Entity
@TableName("project_sub_business")
@Table(name = "project_sub_business")
public class SubBusiness extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @Column
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @Column
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @Column
   private Long areaId;
   @ApiModelProperty(name = "supplierId", value = "供应商id")
   @Column
   private Long supplierId;
   @ApiModelProperty(name = "type", value = "产品类型")
   @Column
   private String type;
   @ApiModelProperty(name = "category", value = "类别（针对围护使用获取计量方式）")
   @Column
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   @Column
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空")
   @Column
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   @Column
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", value = "总重/总长")
   @Column
   private BigDecimal totalMete;
   @ApiModelProperty(name = "totalArea", value = "总面积")
   @Column
   private BigDecimal totalArea;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private BigDecimal unitPrice;

   public static SubBusiness.SubBusinessBuilder builder() {
      return new SubBusiness.SubBusinessBuilder();
   }

   public SubBusiness() {
   }

   public SubBusiness(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long supplierId,
      final String type,
      final Integer category,
      final String name,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal totalArea,
      final BigDecimal unitPrice
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.supplierId = supplierId;
      this.type = type;
      this.category = category;
      this.name = name;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.totalArea = totalArea;
      this.unitPrice = unitPrice;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getType() {
      return this.type;
   }

   public Integer getCategory() {
      return this.category;
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

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public SubBusiness setId(final Long id) {
      this.id = id;
      return this;
   }

   public SubBusiness setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SubBusiness setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public SubBusiness setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public SubBusiness setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SubBusiness setType(final String type) {
      this.type = type;
      return this;
   }

   public SubBusiness setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public SubBusiness setName(final String name) {
      this.name = name;
      return this;
   }

   public SubBusiness setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public SubBusiness setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public SubBusiness setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   public SubBusiness setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public SubBusiness setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "SubBusiness(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", supplierId="
         + this.getSupplierId()
         + ", type="
         + this.getType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusiness)) {
         return false;
      }

      SubBusiness other = (SubBusiness)o;
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
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$totalQuantity = this.getTotalQuantity();
                        Object other$totalQuantity = other.getTotalQuantity();
                        if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$totalMete = this.getTotalMete();
                                    Object other$totalMete = other.getTotalMete();
                                    if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                                       Object this$totalArea = this.getTotalArea();
                                       Object other$totalArea = other.getTotalArea();
                                       if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                          Object this$unitPrice = this.getUnitPrice();
                                          Object other$unitPrice = other.getUnitPrice();
                                          return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof SubBusiness;
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
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class SubBusinessBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long supplierId;
      private String type;
      private Integer category;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal totalArea;
      private BigDecimal unitPrice;

      SubBusinessBuilder() {
      }

      public SubBusiness.SubBusinessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubBusiness.SubBusinessBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubBusiness.SubBusinessBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SubBusiness.SubBusinessBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public SubBusiness.SubBusinessBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubBusiness.SubBusinessBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public SubBusiness.SubBusinessBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public SubBusiness.SubBusinessBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusiness.SubBusinessBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusiness.SubBusinessBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public SubBusiness.SubBusinessBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusiness.SubBusinessBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public SubBusiness.SubBusinessBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public SubBusiness build() {
         return new SubBusiness(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.supplierId,
            this.type,
            this.category,
            this.name,
            this.material,
            this.totalQuantity,
            this.totalMete,
            this.totalArea,
            this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "SubBusiness.SubBusinessBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", supplierId="
            + this.supplierId
            + ", type="
            + this.type
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", totalArea="
            + this.totalArea
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
