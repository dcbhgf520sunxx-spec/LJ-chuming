package com.hzchum.scim.scm.core.api.pojo.export;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApplyPurchaseDetailExportDTO implements Serializable {
   @Excel(name = "序号", format = "isAddIndex", orderNum = "0", width = 10.0)
   private Integer index = 1;
   @Excel(name = "编号", orderNum = "1", width = 20.0)
   private String materialSn;
   @Excel(name = "物料名称", orderNum = "2", width = 20.0)
   private String classifyName;
   @Excel(name = "型号", orderNum = "3", width = 20.0)
   private String specification;
   @Excel(name = "规格", orderNum = "4", width = 20.0)
   private String model;
   @Excel(name = "单位", orderNum = "5", width = 20.0)
   private String accountingUnit;
   @Excel(name = "申购量", orderNum = "6", isStatistics = true, width = 20.0)
   private BigDecimal mete;
   @Excel(name = "品牌", orderNum = "7", width = 20.0)
   private String brand;
   @Excel(name = "项目", orderNum = "8", width = 20.0)
   private String projectName;
   @Excel(name = "备注", orderNum = "9", width = 20.0)
   private String remark;
   @Excel(name = "需求日期", orderNum = "10", width = 20.0, exportFormat = "yyyy/MM/dd")
   private LocalDateTime arrivalTime;

   public Integer getIndex() {
      return this.index;
   }

   public String getMaterialSn() {
      return this.materialSn;
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

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public void setIndex(final Integer index) {
      this.index = index;
   }

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
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

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDetailExportDTO)) {
         return false;
      }

      ApplyPurchaseDetailExportDTO other = (ApplyPurchaseDetailExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$index = this.getIndex();
      Object other$index = other.getIndex();
      if (this$index == null ? other$index == null : this$index.equals(other$index)) {
         Object this$materialSn = this.getMaterialSn();
         Object other$materialSn = other.getMaterialSn();
         if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$model = this.getModel();
                  Object other$model = other.getModel();
                  if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                     Object this$accountingUnit = this.getAccountingUnit();
                     Object other$accountingUnit = other.getAccountingUnit();
                     if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$brand = this.getBrand();
                           Object other$brand = other.getBrand();
                           if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$arrivalTime = this.getArrivalTime();
                                    Object other$arrivalTime = other.getArrivalTime();
                                    return this$arrivalTime == null ? other$arrivalTime == null : this$arrivalTime.equals(other$arrivalTime);
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
      return other instanceof ApplyPurchaseDetailExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      return result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDetailExportDTO(index="
         + this.getIndex()
         + ", materialSn="
         + this.getMaterialSn()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", brand="
         + this.getBrand()
         + ", projectName="
         + this.getProjectName()
         + ", remark="
         + this.getRemark()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ")";
   }
}
