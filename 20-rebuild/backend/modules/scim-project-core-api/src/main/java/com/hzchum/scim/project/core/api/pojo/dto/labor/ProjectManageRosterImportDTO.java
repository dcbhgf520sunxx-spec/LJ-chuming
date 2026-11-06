package com.hzchum.scim.project.core.api.pojo.dto.labor;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.time.LocalDate;

@ExcelTarget("ProjectManageRosterImportDTO")
public class ProjectManageRosterImportDTO implements Serializable {
   @Excel(name = "*序号", orderNum = "1")
   private Integer orderNo;
   @Excel(name = "*姓名", orderNum = "2")
   private String name;
   @Excel(name = "*入职日期", orderNum = "3", databaseFormat = "yyyy/M/d")
   private LocalDate startDate;
   @Excel(name = "*民族", orderNum = "4")
   private String nation;
   @Excel(name = "*家庭住址", orderNum = "5")
   private String address;
   @Excel(name = "*联系方式", orderNum = "6")
   private String phone;
   @Excel(name = "*身份证号码", orderNum = "7")
   private String idNumber;
   @Excel(name = "*工种", orderNum = "8")
   private String workTypeName;
   @Excel(name = "*分供方", orderNum = "9")
   private String supplierName;
   private String workTypValue;
   private Long supplierId;
   private Long userId;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public String getNation() {
      return this.nation;
   }

   public String getAddress() {
      return this.address;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public String getWorkTypeName() {
      return this.workTypeName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getWorkTypValue() {
      return this.workTypValue;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setNation(final String nation) {
      this.nation = nation;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
   }

   public void setWorkTypeName(final String workTypeName) {
      this.workTypeName = workTypeName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setWorkTypValue(final String workTypValue) {
      this.workTypValue = workTypValue;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageRosterImportDTO)) {
         return false;
      }

      ProjectManageRosterImportDTO other = (ProjectManageRosterImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$nation = this.getNation();
                     Object other$nation = other.getNation();
                     if (this$nation == null ? other$nation == null : this$nation.equals(other$nation)) {
                        Object this$address = this.getAddress();
                        Object other$address = other.getAddress();
                        if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                           Object this$phone = this.getPhone();
                           Object other$phone = other.getPhone();
                           if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                              Object this$idNumber = this.getIdNumber();
                              Object other$idNumber = other.getIdNumber();
                              if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                 Object this$workTypeName = this.getWorkTypeName();
                                 Object other$workTypeName = other.getWorkTypeName();
                                 if (this$workTypeName == null ? other$workTypeName == null : this$workTypeName.equals(other$workTypeName)) {
                                    Object this$supplierName = this.getSupplierName();
                                    Object other$supplierName = other.getSupplierName();
                                    if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                       Object this$workTypValue = this.getWorkTypValue();
                                       Object other$workTypValue = other.getWorkTypValue();
                                       return this$workTypValue == null ? other$workTypValue == null : this$workTypValue.equals(other$workTypValue);
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
      return other instanceof ProjectManageRosterImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $nation = this.getNation();
      result = result * 59 + ($nation == null ? 43 : $nation.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $workTypeName = this.getWorkTypeName();
      result = result * 59 + ($workTypeName == null ? 43 : $workTypeName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $workTypValue = this.getWorkTypValue();
      return result * 59 + ($workTypValue == null ? 43 : $workTypValue.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageRosterImportDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", nation="
         + this.getNation()
         + ", address="
         + this.getAddress()
         + ", phone="
         + this.getPhone()
         + ", idNumber="
         + this.getIdNumber()
         + ", workTypeName="
         + this.getWorkTypeName()
         + ", supplierName="
         + this.getSupplierName()
         + ", workTypValue="
         + this.getWorkTypValue()
         + ", supplierId="
         + this.getSupplierId()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
