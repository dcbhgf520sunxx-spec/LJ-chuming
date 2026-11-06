package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class AuxiliaryMaterialAddDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("科目id")
   private Long classifyId;
   @ApiModelProperty("分类全称(冗余字段)")
   private String classifyFullName;
   @ApiModelProperty("科目名称(冗余字段)")
   private String classifyName;
   @ApiModelProperty("编号(冗余字段)")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("颜色")
   private String color;
   @ApiModelProperty("核算单位(冗余字段)")
   private String accountingUnit;
   @ApiModelProperty("核算精度(冗余字段)")
   private Integer accountingPrecision;
   @ApiModelProperty("核算量")
   private BigDecimal mete;

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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialAddDTOParam)) {
         return false;
      }

      AuxiliaryMaterialAddDTOParam other = (AuxiliaryMaterialAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                                    return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
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
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialAddDTOParam(projectId="
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
         + ")";
   }
}
