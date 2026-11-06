package com.hzchum.scim.business.core.api.pojo.doModel;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(description = "配套件 ")
@Entity
@TableName("business_auxiliary_material")
@Table(name = "business_auxiliary_material")
public class BusinessAuxiliaryMaterial extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @Column
   private Long projectId;
   @ApiModelProperty("单体id")
   @Column
   private Long monomerId;
   @ApiModelProperty("科目id")
   @Column
   private Long classifyId;
   @ApiModelProperty("分类全称(冗余字段)")
   @Column
   private String classifyFullName;
   @ApiModelProperty("科目名称(冗余字段)")
   @Column
   private String classifyName;
   @ApiModelProperty("编号(冗余字段)")
   @Column
   private String serialNumber;
   @ApiModelProperty("规格")
   @Column
   private String specification;
   @ApiModelProperty("颜色")
   @Column
   private String color;
   @ApiModelProperty("核算单位(冗余字段)")
   @Column
   private String accountingUnit;
   @ApiModelProperty("核算精度(冗余字段)")
   @Column
   private Integer accountingPrecision;
   @Column
   private BigDecimal mete;
   @ApiModelProperty("单价")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2已审核")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '2' COMMENT '审核状态'", nullable = false)
   private Integer status;

   public static BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder builder() {
      return new BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder();
   }

   public BusinessAuxiliaryMaterial() {
   }

   public BusinessAuxiliaryMaterial(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long classifyId,
      final String classifyFullName,
      final String classifyName,
      final String serialNumber,
      final String specification,
      final String color,
      final String accountingUnit,
      final Integer accountingPrecision,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final Integer status
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.classifyId = classifyId;
      this.classifyFullName = classifyFullName;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.color = color;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.status = status;
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

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @JsonProperty("status")
   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessAuxiliaryMaterial)) {
         return false;
      }

      BusinessAuxiliaryMaterial other = (BusinessAuxiliaryMaterial)o;
      if (!other.canEqual(this)) {
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
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$accountingPrecision = this.getAccountingPrecision();
                  Object other$accountingPrecision = other.getAccountingPrecision();
                  if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$classifyFullName = this.getClassifyFullName();
                        Object other$classifyFullName = other.getClassifyFullName();
                        if (this$classifyFullName == null ? other$classifyFullName == null : this$classifyFullName.equals(other$classifyFullName)) {
                           Object this$classifyName = this.getClassifyName();
                           Object other$classifyName = other.getClassifyName();
                           if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$color = this.getColor();
                                    Object other$color = other.getColor();
                                    if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessAuxiliaryMaterial;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessAuxiliaryMaterial(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class BusinessAuxiliaryMaterialBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long classifyId;
      private String classifyFullName;
      private String classifyName;
      private String serialNumber;
      private String specification;
      private String color;
      private String accountingUnit;
      private Integer accountingPrecision;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private Integer status;

      BusinessAuxiliaryMaterialBuilder() {
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("status")
      public BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessAuxiliaryMaterial build() {
         return new BusinessAuxiliaryMaterial(
            this.id,
            this.projectId,
            this.monomerId,
            this.classifyId,
            this.classifyFullName,
            this.classifyName,
            this.serialNumber,
            this.specification,
            this.color,
            this.accountingUnit,
            this.accountingPrecision,
            this.mete,
            this.unitPrice,
            this.status
         );
      }

      @Override
      public String toString() {
         return "BusinessAuxiliaryMaterial.BusinessAuxiliaryMaterialBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", classifyId="
            + this.classifyId
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", mete="
            + this.mete
            + ", unitPrice="
            + this.unitPrice
            + ", status="
            + this.status
            + ")";
      }
   }
}
