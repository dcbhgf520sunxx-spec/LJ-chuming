package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.math.BigDecimal;

public class OtherMaterialInventoryImportDTO {
   @Excel(name = "序号")
   private Integer order;
   @Excel(name = "物料编号")
   private String serialNumber;
   @Excel(name = "物料名称")
   private String classifyName;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "型号")
   private String model;
   @Excel(name = "计量单位")
   private String measureUnit;
   @Excel(name = "数量")
   private BigDecimal quantity;
   @Excel(name = "核算单位")
   private String accountingUnit;
   @Excel(name = "核算量")
   private BigDecimal mete;
   @Excel(name = "所属项目")
   private String projectName;
   @Excel(name = "库存位置")
   private String workshopName;

   public static OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder builder() {
      return new OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder();
   }

   public Integer getOrder() {
      return this.order;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setOrder(final Integer order) {
      this.order = order;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OtherMaterialInventoryImportDTO)) {
         return false;
      }

      OtherMaterialInventoryImportDTO other = (OtherMaterialInventoryImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$order = this.getOrder();
      Object other$order = other.getOrder();
      if (this$order == null ? other$order == null : this$order.equals(other$order)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$model = this.getModel();
                  Object other$model = other.getModel();
                  if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                     Object this$measureUnit = this.getMeasureUnit();
                     Object other$measureUnit = other.getMeasureUnit();
                     if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$accountingUnit = this.getAccountingUnit();
                           Object other$accountingUnit = other.getAccountingUnit();
                           if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
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
      return other instanceof OtherMaterialInventoryImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $order = this.getOrder();
      result = result * 59 + ($order == null ? 43 : $order.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "OtherMaterialInventoryImportDTO(order="
         + this.getOrder()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", projectName="
         + this.getProjectName()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }

   public OtherMaterialInventoryImportDTO(
      final Integer order,
      final String serialNumber,
      final String classifyName,
      final String specification,
      final String model,
      final String measureUnit,
      final BigDecimal quantity,
      final String accountingUnit,
      final BigDecimal mete,
      final String projectName,
      final String workshopName
   ) {
      this.order = order;
      this.serialNumber = serialNumber;
      this.classifyName = classifyName;
      this.specification = specification;
      this.model = model;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.projectName = projectName;
      this.workshopName = workshopName;
   }

   public OtherMaterialInventoryImportDTO() {
   }

   public static class OtherMaterialInventoryImportDTOBuilder {
      private Integer order;
      private String serialNumber;
      private String classifyName;
      private String specification;
      private String model;
      private String measureUnit;
      private BigDecimal quantity;
      private String accountingUnit;
      private BigDecimal mete;
      private String projectName;
      private String workshopName;

      OtherMaterialInventoryImportDTOBuilder() {
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder order(final Integer order) {
         this.order = order;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public OtherMaterialInventoryImportDTO build() {
         return new OtherMaterialInventoryImportDTO(
            this.order,
            this.serialNumber,
            this.classifyName,
            this.specification,
            this.model,
            this.measureUnit,
            this.quantity,
            this.accountingUnit,
            this.mete,
            this.projectName,
            this.workshopName
         );
      }

      @Override
      public String toString() {
         return "OtherMaterialInventoryImportDTO.OtherMaterialInventoryImportDTOBuilder(order="
            + this.order
            + ", serialNumber="
            + this.serialNumber
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", projectName="
            + this.projectName
            + ", workshopName="
            + this.workshopName
            + ")";
      }
   }
}
