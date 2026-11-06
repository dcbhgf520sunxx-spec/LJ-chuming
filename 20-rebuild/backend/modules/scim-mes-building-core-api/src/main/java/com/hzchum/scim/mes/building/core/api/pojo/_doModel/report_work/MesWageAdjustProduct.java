package com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work;

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

@ApiModel(value = "MesWageAdjustProduct对象", description = "工价调整产品表")
@Entity
@TableName("mes_wage_adjust_product")
@Table(name = "mes_wage_adjust_product")
@org.hibernate.annotations.Table(appliesTo = "mes_wage_adjust_product", comment = "工价调整产品表")
public class MesWageAdjustProduct extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("工价调整id")
   @TableField("wage_adjust_id")
   @Column(name = "wage_adjust_id", columnDefinition = "bigint(20) COMMENT '工价调整id'", nullable = true)
   private Long wageAdjustId;
   @ApiModelProperty("产品类型")
   @TableField("product_type_enum")
   @Column(name = "product_type_enum", columnDefinition = "int(11) COMMENT '产品类型'", nullable = true)
   private Integer productTypeEnum;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty("产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty("产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255) COMMENT '产品编号'", nullable = true)
   private String productSerialNumber;
   @ApiModelProperty("定额配置id")
   @TableField("quota_config_id")
   @Column(name = "quota_config_id", columnDefinition = "bigint(20) COMMENT '定额配置id'", nullable = true)
   private Long quotaConfigId;
   @ApiModelProperty("定额编号")
   @TableField("quota_number")
   @Column(name = "quota_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String quotaNumber;
   @ApiModelProperty("计算方式")
   @TableField("calculation_way")
   @Column(name = "calculation_way", columnDefinition = "int(11) COMMENT '计算方式'", nullable = true)
   private Integer calculationWay;
   @ApiModelProperty("单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty("定额工价(元/?)")
   @TableField("quota_price")
   @Column(name = "quota_price", columnDefinition = "decimal(32,8) COMMENT '定额工价(元/?)'", nullable = true)
   private BigDecimal quotaPrice;
   @ApiModelProperty("编制内单价(元)")
   @TableField("organization_inside_price")
   @Column(name = "organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '编制内单价(元)'", nullable = true)
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty("编制外单价(元)")
   @TableField("organization_outside_price")
   @Column(name = "organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '编制外单价(元)'", nullable = true)
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty("新工价(元/?)")
   @TableField("new_price")
   @Column(name = "new_price", columnDefinition = "decimal(32,8) COMMENT '新工价(元/?)'", nullable = true)
   private BigDecimal newPrice;
   @ApiModelProperty("新编制内单价(元)")
   @TableField("new_organization_inside_price")
   @Column(name = "new_organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '新编制内单价(元)'", nullable = true)
   private BigDecimal newOrganizationInsidePrice;
   @ApiModelProperty("新编制外单价(元)")
   @TableField("new_organization_outside_price")
   @Column(name = "new_organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '新编制外单价(元)'", nullable = true)
   private BigDecimal newOrganizationOutsidePrice;
   @ApiModelProperty("审批状态")
   @TableField("approval_status")
   @Column(name = "approval_status", columnDefinition = "int(11) COMMENT '审批状态'", nullable = true)
   private Integer approvalStatus;

   public static MesWageAdjustProduct.MesWageAdjustProductBuilder builder() {
      return new MesWageAdjustProduct.MesWageAdjustProductBuilder();
   }

   public MesWageAdjustProduct() {
   }

   public MesWageAdjustProduct(
      final Long id,
      final Long wageAdjustId,
      final Integer productTypeEnum,
      final Long projectId,
      final Long monomerId,
      final Long productId,
      final String productSerialNumber,
      final Long quotaConfigId,
      final String quotaNumber,
      final Integer calculationWay,
      final String unit,
      final BigDecimal quotaPrice,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice,
      final BigDecimal newPrice,
      final BigDecimal newOrganizationInsidePrice,
      final BigDecimal newOrganizationOutsidePrice,
      final Integer approvalStatus
   ) {
      this.id = id;
      this.wageAdjustId = wageAdjustId;
      this.productTypeEnum = productTypeEnum;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productId = productId;
      this.productSerialNumber = productSerialNumber;
      this.quotaConfigId = quotaConfigId;
      this.quotaNumber = quotaNumber;
      this.calculationWay = calculationWay;
      this.unit = unit;
      this.quotaPrice = quotaPrice;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
      this.newPrice = newPrice;
      this.newOrganizationInsidePrice = newOrganizationInsidePrice;
      this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
      this.approvalStatus = approvalStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWageAdjustId() {
      return this.wageAdjustId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaNumber() {
      return this.quotaNumber;
   }

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getQuotaPrice() {
      return this.quotaPrice;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public BigDecimal getNewPrice() {
      return this.newPrice;
   }

   public BigDecimal getNewOrganizationInsidePrice() {
      return this.newOrganizationInsidePrice;
   }

   public BigDecimal getNewOrganizationOutsidePrice() {
      return this.newOrganizationOutsidePrice;
   }

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public MesWageAdjustProduct setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesWageAdjustProduct setWageAdjustId(final Long wageAdjustId) {
      this.wageAdjustId = wageAdjustId;
      return this;
   }

   public MesWageAdjustProduct setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   public MesWageAdjustProduct setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesWageAdjustProduct setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesWageAdjustProduct setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesWageAdjustProduct setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public MesWageAdjustProduct setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
      return this;
   }

   public MesWageAdjustProduct setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
      return this;
   }

   public MesWageAdjustProduct setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
      return this;
   }

   public MesWageAdjustProduct setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesWageAdjustProduct setQuotaPrice(final BigDecimal quotaPrice) {
      this.quotaPrice = quotaPrice;
      return this;
   }

   public MesWageAdjustProduct setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesWageAdjustProduct setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   public MesWageAdjustProduct setNewPrice(final BigDecimal newPrice) {
      this.newPrice = newPrice;
      return this;
   }

   public MesWageAdjustProduct setNewOrganizationInsidePrice(final BigDecimal newOrganizationInsidePrice) {
      this.newOrganizationInsidePrice = newOrganizationInsidePrice;
      return this;
   }

   public MesWageAdjustProduct setNewOrganizationOutsidePrice(final BigDecimal newOrganizationOutsidePrice) {
      this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
      return this;
   }

   public MesWageAdjustProduct setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesWageAdjustProduct(id="
         + this.getId()
         + ", wageAdjustId="
         + this.getWageAdjustId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", unit="
         + this.getUnit()
         + ", quotaPrice="
         + this.getQuotaPrice()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", newPrice="
         + this.getNewPrice()
         + ", newOrganizationInsidePrice="
         + this.getNewOrganizationInsidePrice()
         + ", newOrganizationOutsidePrice="
         + this.getNewOrganizationOutsidePrice()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustProduct)) {
         return false;
      }

      MesWageAdjustProduct other = (MesWageAdjustProduct)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wageAdjustId = this.getWageAdjustId();
         Object other$wageAdjustId = other.getWageAdjustId();
         if (this$wageAdjustId == null ? other$wageAdjustId == null : this$wageAdjustId.equals(other$wageAdjustId)) {
            Object this$productTypeEnum = this.getProductTypeEnum();
            Object other$productTypeEnum = other.getProductTypeEnum();
            if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$quotaConfigId = this.getQuotaConfigId();
                        Object other$quotaConfigId = other.getQuotaConfigId();
                        if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                           Object this$calculationWay = this.getCalculationWay();
                           Object other$calculationWay = other.getCalculationWay();
                           if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
                              Object this$approvalStatus = this.getApprovalStatus();
                              Object other$approvalStatus = other.getApprovalStatus();
                              if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                 if (this$productSerialNumber == null
                                    ? other$productSerialNumber == null
                                    : this$productSerialNumber.equals(other$productSerialNumber)) {
                                    Object this$quotaNumber = this.getQuotaNumber();
                                    Object other$quotaNumber = other.getQuotaNumber();
                                    if (this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber)) {
                                       Object this$unit = this.getUnit();
                                       Object other$unit = other.getUnit();
                                       if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                          Object this$quotaPrice = this.getQuotaPrice();
                                          Object other$quotaPrice = other.getQuotaPrice();
                                          if (this$quotaPrice == null ? other$quotaPrice == null : this$quotaPrice.equals(other$quotaPrice)) {
                                             Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                                             Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                                             if (this$organizationInsidePrice == null
                                                ? other$organizationInsidePrice == null
                                                : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                                Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                                Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                                if (this$organizationOutsidePrice == null
                                                   ? other$organizationOutsidePrice == null
                                                   : this$organizationOutsidePrice.equals(other$organizationOutsidePrice)) {
                                                   Object this$newPrice = this.getNewPrice();
                                                   Object other$newPrice = other.getNewPrice();
                                                   if (this$newPrice == null ? other$newPrice == null : this$newPrice.equals(other$newPrice)) {
                                                      Object this$newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
                                                      Object other$newOrganizationInsidePrice = other.getNewOrganizationInsidePrice();
                                                      if (this$newOrganizationInsidePrice == null
                                                         ? other$newOrganizationInsidePrice == null
                                                         : this$newOrganizationInsidePrice.equals(other$newOrganizationInsidePrice)) {
                                                         Object this$newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
                                                         Object other$newOrganizationOutsidePrice = other.getNewOrganizationOutsidePrice();
                                                         return this$newOrganizationOutsidePrice == null
                                                            ? other$newOrganizationOutsidePrice == null
                                                            : this$newOrganizationOutsidePrice.equals(other$newOrganizationOutsidePrice);
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
      return other instanceof MesWageAdjustProduct;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wageAdjustId = this.getWageAdjustId();
      result = result * 59 + ($wageAdjustId == null ? 43 : $wageAdjustId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      result = result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $quotaPrice = this.getQuotaPrice();
      result = result * 59 + ($quotaPrice == null ? 43 : $quotaPrice.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $newPrice = this.getNewPrice();
      result = result * 59 + ($newPrice == null ? 43 : $newPrice.hashCode());
      Object $newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
      result = result * 59 + ($newOrganizationInsidePrice == null ? 43 : $newOrganizationInsidePrice.hashCode());
      Object $newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
      return result * 59 + ($newOrganizationOutsidePrice == null ? 43 : $newOrganizationOutsidePrice.hashCode());
   }

   public static class MesWageAdjustProductBuilder {
      private Long id;
      private Long wageAdjustId;
      private Integer productTypeEnum;
      private Long projectId;
      private Long monomerId;
      private Long productId;
      private String productSerialNumber;
      private Long quotaConfigId;
      private String quotaNumber;
      private Integer calculationWay;
      private String unit;
      private BigDecimal quotaPrice;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;
      private BigDecimal newPrice;
      private BigDecimal newOrganizationInsidePrice;
      private BigDecimal newOrganizationOutsidePrice;
      private Integer approvalStatus;

      MesWageAdjustProductBuilder() {
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder wageAdjustId(final Long wageAdjustId) {
         this.wageAdjustId = wageAdjustId;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder quotaConfigId(final Long quotaConfigId) {
         this.quotaConfigId = quotaConfigId;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder quotaNumber(final String quotaNumber) {
         this.quotaNumber = quotaNumber;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder calculationWay(final Integer calculationWay) {
         this.calculationWay = calculationWay;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder quotaPrice(final BigDecimal quotaPrice) {
         this.quotaPrice = quotaPrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder newPrice(final BigDecimal newPrice) {
         this.newPrice = newPrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder newOrganizationInsidePrice(final BigDecimal newOrganizationInsidePrice) {
         this.newOrganizationInsidePrice = newOrganizationInsidePrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder newOrganizationOutsidePrice(final BigDecimal newOrganizationOutsidePrice) {
         this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
         return this;
      }

      public MesWageAdjustProduct.MesWageAdjustProductBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesWageAdjustProduct build() {
         return new MesWageAdjustProduct(
            this.id,
            this.wageAdjustId,
            this.productTypeEnum,
            this.projectId,
            this.monomerId,
            this.productId,
            this.productSerialNumber,
            this.quotaConfigId,
            this.quotaNumber,
            this.calculationWay,
            this.unit,
            this.quotaPrice,
            this.organizationInsidePrice,
            this.organizationOutsidePrice,
            this.newPrice,
            this.newOrganizationInsidePrice,
            this.newOrganizationOutsidePrice,
            this.approvalStatus
         );
      }

      @Override
      public String toString() {
         return "MesWageAdjustProduct.MesWageAdjustProductBuilder(id="
            + this.id
            + ", wageAdjustId="
            + this.wageAdjustId
            + ", productTypeEnum="
            + this.productTypeEnum
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productId="
            + this.productId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", quotaConfigId="
            + this.quotaConfigId
            + ", quotaNumber="
            + this.quotaNumber
            + ", calculationWay="
            + this.calculationWay
            + ", unit="
            + this.unit
            + ", quotaPrice="
            + this.quotaPrice
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ", newPrice="
            + this.newPrice
            + ", newOrganizationInsidePrice="
            + this.newOrganizationInsidePrice
            + ", newOrganizationOutsidePrice="
            + this.newOrganizationOutsidePrice
            + ", approvalStatus="
            + this.approvalStatus
            + ")";
      }
   }
}
