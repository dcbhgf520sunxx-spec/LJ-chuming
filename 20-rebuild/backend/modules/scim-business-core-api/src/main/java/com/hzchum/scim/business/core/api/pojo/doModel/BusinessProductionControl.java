package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessProductionControl对象", description = "商务管理-生产控制 ")
@Entity
@TableName("business_production_control")
@Table(name = "business_production_control")
public class BusinessProductionControl extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "project_id", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "name", value = "钢材名称")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "specification", value = "板厚/型号")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @TableField("material")
   @Column(name = "material")
   private String material;
   @ApiModelProperty(name = "unit", value = "单位")
   @TableField("unit")
   @Column(name = "unit")
   private String unit;
   @ApiModelProperty(name = "quantity", value = "清单量")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "bool_enable_enum", value = "是否启用 0不启用 1启用")
   @TableField("bool_enable_enum")
   @Column(name = "bool_enable_enum")
   private Boolean boolEnableEnum;
   @ApiModelProperty(name = "loss_factor", value = "损耗系数")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "loss_factor")
   private BigDecimal lossFactor;
   @ApiModelProperty(name = "use_quantity", value = "实际用量（出库量）")
   @TableField("use_quantity")
   @Column(name = "use_quantity")
   private Integer useQuantity;

   public static BusinessProductionControl.BusinessProductionControlBuilder builder() {
      return new BusinessProductionControl.BusinessProductionControlBuilder();
   }

   public BusinessProductionControl() {
   }

   public BusinessProductionControl(
      final Long id,
      final Long projectId,
      final String name,
      final String specification,
      final String material,
      final String unit,
      final Integer quantity,
      final Boolean boolEnableEnum,
      final BigDecimal lossFactor,
      final Integer useQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.name = name;
      this.specification = specification;
      this.material = material;
      this.unit = unit;
      this.quantity = quantity;
      this.boolEnableEnum = boolEnableEnum;
      this.lossFactor = lossFactor;
      this.useQuantity = useQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getUnit() {
      return this.unit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public BigDecimal getLossFactor() {
      return this.lossFactor;
   }

   public Integer getUseQuantity() {
      return this.useQuantity;
   }

   public BusinessProductionControl setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessProductionControl setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessProductionControl setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessProductionControl setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public BusinessProductionControl setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public BusinessProductionControl setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public BusinessProductionControl setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public BusinessProductionControl setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
      return this;
   }

   public BusinessProductionControl setLossFactor(final BigDecimal lossFactor) {
      this.lossFactor = lossFactor;
      return this;
   }

   public BusinessProductionControl setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessProductionControl(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", lossFactor="
         + this.getLossFactor()
         + ", useQuantity="
         + this.getUseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessProductionControl)) {
         return false;
      }

      BusinessProductionControl other = (BusinessProductionControl)o;
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
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$boolEnableEnum = this.getBoolEnableEnum();
               Object other$boolEnableEnum = other.getBoolEnableEnum();
               if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
                  Object this$useQuantity = this.getUseQuantity();
                  Object other$useQuantity = other.getUseQuantity();
                  if (this$useQuantity == null ? other$useQuantity == null : this$useQuantity.equals(other$useQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                 Object this$lossFactor = this.getLossFactor();
                                 Object other$lossFactor = other.getLossFactor();
                                 return this$lossFactor == null ? other$lossFactor == null : this$lossFactor.equals(other$lossFactor);
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
      return other instanceof BusinessProductionControl;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $useQuantity = this.getUseQuantity();
      result = result * 59 + ($useQuantity == null ? 43 : $useQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $lossFactor = this.getLossFactor();
      return result * 59 + ($lossFactor == null ? 43 : $lossFactor.hashCode());
   }

   public static class BusinessProductionControlBuilder {
      private Long id;
      private Long projectId;
      private String name;
      private String specification;
      private String material;
      private String unit;
      private Integer quantity;
      private Boolean boolEnableEnum;
      private BigDecimal lossFactor;
      private Integer useQuantity;

      BusinessProductionControlBuilder() {
      }

      public BusinessProductionControl.BusinessProductionControlBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder lossFactor(final BigDecimal lossFactor) {
         this.lossFactor = lossFactor;
         return this;
      }

      public BusinessProductionControl.BusinessProductionControlBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      public BusinessProductionControl build() {
         return new BusinessProductionControl(
            this.id,
            this.projectId,
            this.name,
            this.specification,
            this.material,
            this.unit,
            this.quantity,
            this.boolEnableEnum,
            this.lossFactor,
            this.useQuantity
         );
      }

      @Override
      public String toString() {
         return "BusinessProductionControl.BusinessProductionControlBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", unit="
            + this.unit
            + ", quantity="
            + this.quantity
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ", lossFactor="
            + this.lossFactor
            + ", useQuantity="
            + this.useQuantity
            + ")";
      }
   }
}
