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

@ApiModel(value = "BusinessPriceTemp对象", description = "商务价格临时表 ")
@Entity
@TableName("business_price_temp")
@Table(name = "business_price_temp")
@org.hibernate.annotations.Table(appliesTo = "business_price_temp", comment = "商务价格临时表 ")
public class BusinessPriceTemp extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2  COMMENT '关联类型 2构件 4围护'")
   private Integer relationType;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "围护分类", notes = "围护分类")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) COMMENT '围护分类'")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id", notes = "围护计划id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) COMMENT '围护计划id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目", notes = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11)  COMMENT '项目类型 1建钢 2桥梁 4立体停车库 8围护项目'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "type", value = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护", notes = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "businessId", value = "商务表id", notes = "商务表id")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20)  COMMENT '商务表id'", nullable = false)
   private Long businessId;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,4)  COMMENT '单价'", nullable = false)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 构件:0重量1长度 围护:1长度2面积", notes = "计价方式 构件:0重量1长度 围护:1长度2面积")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "bigint(11)  COMMENT '计价方式 构件:0重量1长度 围护:1长度2面积'")
   private Integer pricingManner;

   public static BusinessPriceTemp.BusinessPriceTempBuilder builder() {
      return new BusinessPriceTemp.BusinessPriceTempBuilder();
   }

   public BusinessPriceTemp() {
   }

   public BusinessPriceTemp(
      final Long id,
      final Long projectId,
      final Integer relationType,
      final Long monomerId,
      final Long areaId,
      final Integer category,
      final Long enclosurePlanId,
      final Integer projectType,
      final Integer type,
      final Long businessId,
      final BigDecimal unitPrice,
      final Integer pricingManner
   ) {
      this.id = id;
      this.projectId = projectId;
      this.relationType = relationType;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.projectType = projectType;
      this.type = type;
      this.businessId = businessId;
      this.unitPrice = unitPrice;
      this.pricingManner = pricingManner;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRelationType() {
      return this.relationType;
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

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public BusinessPriceTemp setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessPriceTemp setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessPriceTemp setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public BusinessPriceTemp setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessPriceTemp setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessPriceTemp setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public BusinessPriceTemp setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public BusinessPriceTemp setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public BusinessPriceTemp setType(final Integer type) {
      this.type = type;
      return this;
   }

   public BusinessPriceTemp setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public BusinessPriceTemp setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessPriceTemp setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessPriceTemp(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", relationType="
         + this.getRelationType()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ", businessId="
         + this.getBusinessId()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceTemp)) {
         return false;
      }

      BusinessPriceTemp other = (BusinessPriceTemp)o;
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
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
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
                           Object this$projectType = this.getProjectType();
                           Object other$projectType = other.getProjectType();
                           if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                              Object this$type = this.getType();
                              Object other$type = other.getType();
                              if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                 Object this$businessId = this.getBusinessId();
                                 Object other$businessId = other.getBusinessId();
                                 if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                    Object this$pricingManner = this.getPricingManner();
                                    Object other$pricingManner = other.getPricingManner();
                                    if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceTemp;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class BusinessPriceTempBuilder {
      private Long id;
      private Long projectId;
      private Integer relationType;
      private Long monomerId;
      private Long areaId;
      private Integer category;
      private Long enclosurePlanId;
      private Integer projectType;
      private Integer type;
      private Long businessId;
      private BigDecimal unitPrice;
      private Integer pricingManner;

      BusinessPriceTempBuilder() {
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceTemp.BusinessPriceTempBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessPriceTemp build() {
         return new BusinessPriceTemp(
            this.id,
            this.projectId,
            this.relationType,
            this.monomerId,
            this.areaId,
            this.category,
            this.enclosurePlanId,
            this.projectType,
            this.type,
            this.businessId,
            this.unitPrice,
            this.pricingManner
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceTemp.BusinessPriceTempBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", relationType="
            + this.relationType
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", projectType="
            + this.projectType
            + ", type="
            + this.type
            + ", businessId="
            + this.businessId
            + ", unitPrice="
            + this.unitPrice
            + ", pricingManner="
            + this.pricingManner
            + ")";
      }
   }
}
