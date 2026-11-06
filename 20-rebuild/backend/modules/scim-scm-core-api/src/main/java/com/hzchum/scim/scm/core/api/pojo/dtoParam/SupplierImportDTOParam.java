package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("SupplierImportDTOParam")
public class SupplierImportDTOParam {
   @Excel(name = "序号", width = 5.0, orderNum = "1")
   private Integer orderNo;
   @Excel(name = "供应商名称", width = 15.0, orderNum = "2")
   private String name;
   @Excel(name = "供应商简称", width = 15.0, orderNum = "3")
   private String shortName;
   @Excel(name = "供应商分类(格式:使用“/”分割)", width = 30.0, orderNum = "4")
   private String typeStr;
   @Excel(name = "社会统一代码", width = 20.0, orderNum = "5")
   private String socialCode;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getTypeStr() {
      return this.typeStr;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setTypeStr(final String typeStr) {
      this.typeStr = typeStr;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierImportDTOParam)) {
         return false;
      }

      SupplierImportDTOParam other = (SupplierImportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$typeStr = this.getTypeStr();
               Object other$typeStr = other.getTypeStr();
               if (this$typeStr == null ? other$typeStr == null : this$typeStr.equals(other$typeStr)) {
                  Object this$socialCode = this.getSocialCode();
                  Object other$socialCode = other.getSocialCode();
                  return this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode);
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
      return other instanceof SupplierImportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $typeStr = this.getTypeStr();
      result = result * 59 + ($typeStr == null ? 43 : $typeStr.hashCode());
      Object $socialCode = this.getSocialCode();
      return result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierImportDTOParam(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", typeStr="
         + this.getTypeStr()
         + ", socialCode="
         + this.getSocialCode()
         + ")";
   }
}
