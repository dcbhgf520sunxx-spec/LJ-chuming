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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "BusinessPriceDetail对象", description = "商务产品计价明细表 ")
@Entity
@TableName("business_price_detail")
@Table(
   name = "business_price_detail",
   indexes = {
         @Index(name = "product_type_id_index", columnList = "product_type, product_id"),
         @Index(name = "business_price_id_index", columnList = "business_price_id"),
         @Index(name = "project_id_index", columnList = "project_id"),
         @Index(name = "branch_company_id", columnList = "branch_company_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "business_price_detail", comment = "商务产品计价明细表 ")
public class BusinessPriceDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "boolAddEnum", value = "是否追加", notes = "是否追加")
   @TableField("bool_add_enum")
   @Column(name = "bool_add_enum", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否追加'", nullable = false)
   private Boolean boolAddEnum;
   @ApiModelProperty(name = "businessPriceId", value = "计价表id", notes = "计价表id")
   @TableField("business_price_id")
   @Column(name = "business_price_id", columnDefinition = "bigint(20)  COMMENT '计价表id'", nullable = false)
   private Long businessPriceId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '分支机构id'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "level", value = "分支机构等级", notes = "分支机构等级")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) DEFAULT 0 COMMENT '分支机构等级'", nullable = false)
   private Integer level;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价方式 1重量 2长度 4面积 8数量", notes = "计价方式 1重量 2长度 4面积 8数量")
   @TableField("pricing_manner_enum")
   @Column(name = "pricing_manner_enum", columnDefinition = "int(11)  COMMENT '计价方式 1重量 2长度 4面积 8数量'", nullable = true)
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型 1千克 2吨 ", notes = "计价单位 1千克 2吨")
   @TableField("pricing_unit_type_enum")
   @Column(name = "pricing_unit_type_enum", columnDefinition = "int(11)  COMMENT '计价单位 1千克 2吨'", nullable = true)
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   @TableField(value = "pricing_weight_type_enum", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "pricing_weight_type_enum", columnDefinition = "int(11)  COMMENT '(构件)计价重量类型 1净重 2毛重 4图纸重'", nullable = true)
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(11)  COMMENT '数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价'", nullable = false)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态", notes = "审核状态")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @TableField(value = "audit_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField(value = "audit_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;

   public static BusinessPriceDetail.BusinessPriceDetailBuilder builder() {
      return new BusinessPriceDetail.BusinessPriceDetailBuilder();
   }

   public BusinessPriceDetail() {
   }

   public BusinessPriceDetail(
      final Long id,
      final Boolean boolAddEnum,
      final Long businessPriceId,
      final Long projectId,
      final Long branchCompanyId,
      final Integer level,
      final Long monomerId,
      final Long areaId,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final Integer productType,
      final Long productId,
      final BigDecimal quantity,
      final BigDecimal unitPrice,
      final Long createUserId,
      final Integer auditStatus,
      final Long auditUserId,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.boolAddEnum = boolAddEnum;
      this.businessPriceId = businessPriceId;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.level = level;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.productType = productType;
      this.productId = productId;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
      this.createUserId = createUserId;
      this.auditStatus = auditStatus;
      this.auditUserId = auditUserId;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolAddEnum() {
      return this.boolAddEnum;
   }

   public Long getBusinessPriceId() {
      return this.businessPriceId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public BusinessPriceDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessPriceDetail setBoolAddEnum(final Boolean boolAddEnum) {
      this.boolAddEnum = boolAddEnum;
      return this;
   }

   public BusinessPriceDetail setBusinessPriceId(final Long businessPriceId) {
      this.businessPriceId = businessPriceId;
      return this;
   }

   public BusinessPriceDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessPriceDetail setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public BusinessPriceDetail setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public BusinessPriceDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessPriceDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessPriceDetail setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
      return this;
   }

   public BusinessPriceDetail setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      return this;
   }

   public BusinessPriceDetail setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      return this;
   }

   public BusinessPriceDetail setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public BusinessPriceDetail setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public BusinessPriceDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public BusinessPriceDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessPriceDetail setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public BusinessPriceDetail setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public BusinessPriceDetail setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public BusinessPriceDetail setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessPriceDetail(id="
         + this.getId()
         + ", boolAddEnum="
         + this.getBoolAddEnum()
         + ", businessPriceId="
         + this.getBusinessPriceId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", level="
         + this.getLevel()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", createUserId="
         + this.getCreateUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceDetail)) {
         return false;
      }

      BusinessPriceDetail other = (BusinessPriceDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolAddEnum = this.getBoolAddEnum();
         Object other$boolAddEnum = other.getBoolAddEnum();
         if (this$boolAddEnum == null ? other$boolAddEnum == null : this$boolAddEnum.equals(other$boolAddEnum)) {
            Object this$businessPriceId = this.getBusinessPriceId();
            Object other$businessPriceId = other.getBusinessPriceId();
            if (this$businessPriceId == null ? other$businessPriceId == null : this$businessPriceId.equals(other$businessPriceId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$level = this.getLevel();
                     Object other$level = other.getLevel();
                     if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$pricingMannerEnum = this.getPricingMannerEnum();
                              Object other$pricingMannerEnum = other.getPricingMannerEnum();
                              if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                                 Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                                 Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                                 if (this$pricingUnitTypeEnum == null
                                    ? other$pricingUnitTypeEnum == null
                                    : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                                    Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                                    Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                                    if (this$pricingWeightTypeEnum == null
                                       ? other$pricingWeightTypeEnum == null
                                       : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                          Object this$productId = this.getProductId();
                                          Object other$productId = other.getProductId();
                                          if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                             Object this$createUserId = this.getCreateUserId();
                                             Object other$createUserId = other.getCreateUserId();
                                             if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                                Object this$auditStatus = this.getAuditStatus();
                                                Object other$auditStatus = other.getAuditStatus();
                                                if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                                   Object this$auditUserId = this.getAuditUserId();
                                                   Object other$auditUserId = other.getAuditUserId();
                                                   if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                                      Object this$quantity = this.getQuantity();
                                                      Object other$quantity = other.getQuantity();
                                                      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$auditTime = this.getAuditTime();
                                                            Object other$auditTime = other.getAuditTime();
                                                            return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolAddEnum = this.getBoolAddEnum();
      result = result * 59 + ($boolAddEnum == null ? 43 : $boolAddEnum.hashCode());
      Object $businessPriceId = this.getBusinessPriceId();
      result = result * 59 + ($businessPriceId == null ? 43 : $businessPriceId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class BusinessPriceDetailBuilder {
      private Long id;
      private Boolean boolAddEnum;
      private Long businessPriceId;
      private Long projectId;
      private Long branchCompanyId;
      private Integer level;
      private Long monomerId;
      private Long areaId;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private Integer productType;
      private Long productId;
      private BigDecimal quantity;
      private BigDecimal unitPrice;
      private Long createUserId;
      private Integer auditStatus;
      private Long auditUserId;
      private LocalDateTime auditTime;

      BusinessPriceDetailBuilder() {
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder boolAddEnum(final Boolean boolAddEnum) {
         this.boolAddEnum = boolAddEnum;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder businessPriceId(final Long businessPriceId) {
         this.businessPriceId = businessPriceId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public BusinessPriceDetail.BusinessPriceDetailBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public BusinessPriceDetail build() {
         return new BusinessPriceDetail(
            this.id,
            this.boolAddEnum,
            this.businessPriceId,
            this.projectId,
            this.branchCompanyId,
            this.level,
            this.monomerId,
            this.areaId,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.productType,
            this.productId,
            this.quantity,
            this.unitPrice,
            this.createUserId,
            this.auditStatus,
            this.auditUserId,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceDetail.BusinessPriceDetailBuilder(id="
            + this.id
            + ", boolAddEnum="
            + this.boolAddEnum
            + ", businessPriceId="
            + this.businessPriceId
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", level="
            + this.level
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", unitPrice="
            + this.unitPrice
            + ", createUserId="
            + this.createUserId
            + ", auditStatus="
            + this.auditStatus
            + ", auditUserId="
            + this.auditUserId
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
