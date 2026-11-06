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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "BusinessPrice对象", description = "商务产品计价表 ")
@Entity
@TableName("business_price")
@Table(name = "business_price", indexes = @Index(name = "project_id_index", columnList = "project_id"))
@org.hibernate.annotations.Table(appliesTo = "business_price", comment = "商务产品计价表 ")
public class BusinessPrice extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '分支机构id'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "level", value = "分支机构等级", notes = "分支机构等级")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) DEFAULT 0 COMMENT '分支机构等级'", nullable = false)
   private Integer level;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "pricingName", value = "计价名称", notes = "计价名称")
   @TableField("pricing_name")
   @Column(name = "pricing_name", columnDefinition = "varchar(255)  COMMENT '计价名称'", nullable = true)
   private String pricingName;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价方式 1重量 2长度 4面积 8数量", notes = "计价方式 1重量 2长度 4面积 8数量")
   @TableField("pricing_manner_enum")
   @Column(name = "pricing_manner_enum", columnDefinition = "int(11)  COMMENT '计价方式 1重量 2长度 4面积 8数量'", nullable = true)
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型 1千克 2吨 4米 8平米 ", notes = "计价单位 1千克 2吨 4米 8平米")
   @TableField("pricing_unit_type_enum")
   @Column(name = "pricing_unit_type_enum", columnDefinition = "int(11)  COMMENT '计价单位 1千克 2吨 4米 8平米'", nullable = true)
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   @TableField(value = "pricing_weight_type_enum", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "pricing_weight_type_enum", columnDefinition = "int(11)  COMMENT '(构件)计价重量类型 1净重 2毛重 4图纸重'", nullable = true)
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty(name = "unitPrice", value = "单价(元/kg/m/m²)", notes = "单价(元/kg/m/m²)")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价(元/kg/m/m²)'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态 1未审核 2已通过 4已驳回'", nullable = false)
   private Integer auditStatus;

   public static BusinessPrice.BusinessPriceBuilder builder() {
      return new BusinessPrice.BusinessPriceBuilder();
   }

   public BusinessPrice() {
   }

   public BusinessPrice(
      final Long id,
      final Long projectId,
      final Long branchCompanyId,
      final Integer level,
      final Integer productType,
      final String pricingName,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final BigDecimal unitPrice,
      final String remark,
      final Long createUserId,
      final Integer auditStatus
   ) {
      this.id = id;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.level = level;
      this.productType = productType;
      this.pricingName = pricingName;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.unitPrice = unitPrice;
      this.remark = remark;
      this.createUserId = createUserId;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
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

   public Integer getProductType() {
      return this.productType;
   }

   public String getPricingName() {
      return this.pricingName;
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

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public BusinessPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessPrice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessPrice setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public BusinessPrice setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public BusinessPrice setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public BusinessPrice setPricingName(final String pricingName) {
      this.pricingName = pricingName;
      return this;
   }

   public BusinessPrice setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
      return this;
   }

   public BusinessPrice setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      return this;
   }

   public BusinessPrice setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      return this;
   }

   public BusinessPrice setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessPrice setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public BusinessPrice setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public BusinessPrice setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessPrice(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", level="
         + this.getLevel()
         + ", productType="
         + this.getProductType()
         + ", pricingName="
         + this.getPricingName()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPrice)) {
         return false;
      }

      BusinessPrice other = (BusinessPrice)o;
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
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$level = this.getLevel();
               Object other$level = other.getLevel();
               if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$pricingMannerEnum = this.getPricingMannerEnum();
                     Object other$pricingMannerEnum = other.getPricingMannerEnum();
                     if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                        Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                        Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                        if (this$pricingUnitTypeEnum == null ? other$pricingUnitTypeEnum == null : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                           Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                           Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                           if (this$pricingWeightTypeEnum == null
                              ? other$pricingWeightTypeEnum == null
                              : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                              Object this$createUserId = this.getCreateUserId();
                              Object other$createUserId = other.getCreateUserId();
                              if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$pricingName = this.getPricingName();
                                    Object other$pricingName = other.getPricingName();
                                    if (this$pricingName == null ? other$pricingName == null : this$pricingName.equals(other$pricingName)) {
                                       Object this$unitPrice = this.getUnitPrice();
                                       Object other$unitPrice = other.getUnitPrice();
                                       if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof BusinessPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $pricingName = this.getPricingName();
      result = result * 59 + ($pricingName == null ? 43 : $pricingName.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class BusinessPriceBuilder {
      private Long id;
      private Long projectId;
      private Long branchCompanyId;
      private Integer level;
      private Integer productType;
      private String pricingName;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private BigDecimal unitPrice;
      private String remark;
      private Long createUserId;
      private Integer auditStatus;

      BusinessPriceBuilder() {
      }

      public BusinessPrice.BusinessPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder pricingName(final String pricingName) {
         this.pricingName = pricingName;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public BusinessPrice.BusinessPriceBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPrice build() {
         return new BusinessPrice(
            this.id,
            this.projectId,
            this.branchCompanyId,
            this.level,
            this.productType,
            this.pricingName,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.unitPrice,
            this.remark,
            this.createUserId,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "BusinessPrice.BusinessPriceBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", level="
            + this.level
            + ", productType="
            + this.productType
            + ", pricingName="
            + this.pricingName
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", unitPrice="
            + this.unitPrice
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
