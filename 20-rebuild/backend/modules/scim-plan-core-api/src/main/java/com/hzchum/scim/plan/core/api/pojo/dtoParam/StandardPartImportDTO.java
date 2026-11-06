package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("StandardPartImportDTO")
public class StandardPartImportDTO implements Serializable {
   @Excel(name = "序号", width = 5.0, orderNum = "1")
   private Integer orderNo;
   @Excel(name = "使用范围", width = 15.0, replace = {"工地_1", "工厂_2"}, orderNum = "2")
   private Integer useProperty;
   @Excel(name = "名称", width = 10.0, orderNum = "3")
   private String name;
   @Excel(name = "规格", width = 20.0, orderNum = "4")
   private String specification;
   @Excel(name = "计量单位", width = 10.0, orderNum = "5")
   private String measureUnit;
   @Excel(name = "数量", width = 10.0, orderNum = "6")
   private BigDecimal quantity;
   @Excel(name = "核算单位", width = 10.0, orderNum = "7")
   private String accountingUnit;
   @Excel(name = "核算量", width = 10.0, orderNum = "8")
   private BigDecimal mete;
   @Excel(name = "备注", width = 20.0, orderNum = "9")
   private String remark;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
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

   public String getRemark() {
      return this.remark;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StandardPartImportDTO)) {
         return false;
      }

      StandardPartImportDTO other = (StandardPartImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$useProperty = this.getUseProperty();
         Object other$useProperty = other.getUseProperty();
         if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StandardPartImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "StandardPartImportDTO(orderNo="
         + this.getOrderNo()
         + ", useProperty="
         + this.getUseProperty()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
