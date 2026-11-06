package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutsourcingBookDTO {
   @ApiModelProperty("项目类型")
   private Integer projectAttributeEnum;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("清单量")
   private BigDecimal mete;
   @ApiModelProperty("计划创建人")
   private NameInfo planCreator;
   @ApiModelProperty("计划创建时间")
   private LocalDateTime planCreateTime;
   @ApiModelProperty("合同状态")
   private Integer contractStatusEnum;

   public static OutsourcingBookDTO.OutsourcingBookDTOBuilder builder() {
      return new OutsourcingBookDTO.OutsourcingBookDTOBuilder();
   }

   public Integer getProjectAttributeEnum() {
      return this.projectAttributeEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public NameInfo getPlanCreator() {
      return this.planCreator;
   }

   public LocalDateTime getPlanCreateTime() {
      return this.planCreateTime;
   }

   public Integer getContractStatusEnum() {
      return this.contractStatusEnum;
   }

   public void setProjectAttributeEnum(final Integer projectAttributeEnum) {
      this.projectAttributeEnum = projectAttributeEnum;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPlanCreator(final NameInfo planCreator) {
      this.planCreator = planCreator;
   }

   public void setPlanCreateTime(final LocalDateTime planCreateTime) {
      this.planCreateTime = planCreateTime;
   }

   public void setContractStatusEnum(final Integer contractStatusEnum) {
      this.contractStatusEnum = contractStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutsourcingBookDTO)) {
         return false;
      }

      OutsourcingBookDTO other = (OutsourcingBookDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectAttributeEnum = this.getProjectAttributeEnum();
      Object other$projectAttributeEnum = other.getProjectAttributeEnum();
      if (this$projectAttributeEnum == null ? other$projectAttributeEnum == null : this$projectAttributeEnum.equals(other$projectAttributeEnum)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$contractStatusEnum = this.getContractStatusEnum();
            Object other$contractStatusEnum = other.getContractStatusEnum();
            if (this$contractStatusEnum == null ? other$contractStatusEnum == null : this$contractStatusEnum.equals(other$contractStatusEnum)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$supplier = this.getSupplier();
                           Object other$supplier = other.getSupplier();
                           if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$planCreator = this.getPlanCreator();
                                    Object other$planCreator = other.getPlanCreator();
                                    if (this$planCreator == null ? other$planCreator == null : this$planCreator.equals(other$planCreator)) {
                                       Object this$planCreateTime = this.getPlanCreateTime();
                                       Object other$planCreateTime = other.getPlanCreateTime();
                                       return this$planCreateTime == null ? other$planCreateTime == null : this$planCreateTime.equals(other$planCreateTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof OutsourcingBookDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectAttributeEnum = this.getProjectAttributeEnum();
      result = result * 59 + ($projectAttributeEnum == null ? 43 : $projectAttributeEnum.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $contractStatusEnum = this.getContractStatusEnum();
      result = result * 59 + ($contractStatusEnum == null ? 43 : $contractStatusEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $planCreator = this.getPlanCreator();
      result = result * 59 + ($planCreator == null ? 43 : $planCreator.hashCode());
      Object $planCreateTime = this.getPlanCreateTime();
      return result * 59 + ($planCreateTime == null ? 43 : $planCreateTime.hashCode());
   }

   @Override
   public String toString() {
      return "OutsourcingBookDTO(projectAttributeEnum="
         + this.getProjectAttributeEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", supplier="
         + this.getSupplier()
         + ", unit="
         + this.getUnit()
         + ", mete="
         + this.getMete()
         + ", planCreator="
         + this.getPlanCreator()
         + ", planCreateTime="
         + this.getPlanCreateTime()
         + ", contractStatusEnum="
         + this.getContractStatusEnum()
         + ")";
   }

   public OutsourcingBookDTO(
      final Integer projectAttributeEnum,
      final String serialNumber,
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final String areaName,
      final SupplierInfo supplier,
      final String unit,
      final BigDecimal mete,
      final NameInfo planCreator,
      final LocalDateTime planCreateTime,
      final Integer contractStatusEnum
   ) {
      this.projectAttributeEnum = projectAttributeEnum;
      this.serialNumber = serialNumber;
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.supplier = supplier;
      this.unit = unit;
      this.mete = mete;
      this.planCreator = planCreator;
      this.planCreateTime = planCreateTime;
      this.contractStatusEnum = contractStatusEnum;
   }

   public OutsourcingBookDTO() {
   }

   public static class OutsourcingBookDTOBuilder {
      private Integer projectAttributeEnum;
      private String serialNumber;
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private String areaName;
      private SupplierInfo supplier;
      private String unit;
      private BigDecimal mete;
      private NameInfo planCreator;
      private LocalDateTime planCreateTime;
      private Integer contractStatusEnum;

      OutsourcingBookDTOBuilder() {
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder projectAttributeEnum(final Integer projectAttributeEnum) {
         this.projectAttributeEnum = projectAttributeEnum;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder planCreator(final NameInfo planCreator) {
         this.planCreator = planCreator;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder planCreateTime(final LocalDateTime planCreateTime) {
         this.planCreateTime = planCreateTime;
         return this;
      }

      public OutsourcingBookDTO.OutsourcingBookDTOBuilder contractStatusEnum(final Integer contractStatusEnum) {
         this.contractStatusEnum = contractStatusEnum;
         return this;
      }

      public OutsourcingBookDTO build() {
         return new OutsourcingBookDTO(
            this.projectAttributeEnum,
            this.serialNumber,
            this.project,
            this.monomerId,
            this.monomerName,
            this.areaName,
            this.supplier,
            this.unit,
            this.mete,
            this.planCreator,
            this.planCreateTime,
            this.contractStatusEnum
         );
      }

      @Override
      public String toString() {
         return "OutsourcingBookDTO.OutsourcingBookDTOBuilder(projectAttributeEnum="
            + this.projectAttributeEnum
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", supplier="
            + this.supplier
            + ", unit="
            + this.unit
            + ", mete="
            + this.mete
            + ", planCreator="
            + this.planCreator
            + ", planCreateTime="
            + this.planCreateTime
            + ", contractStatusEnum="
            + this.contractStatusEnum
            + ")";
      }
   }
}
