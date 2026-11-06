package com.hzchum.scim.business.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExcelTarget("BusinessCheckAuxiliaryMaterialExcelDTO")
public class BusinessCheckAuxiliaryMaterialExcelDTO {
   @Excel(name = "项目")
   private String project;
   @Excel(name = "产品类型")
   private String typeName;
   @Excel(name = "事由")
   private String remark;
   @Excel(name = "创建人")
   private String createUserName;
   @Excel(name = "创建时间", exportFormat = "yyyy-MM-dd HH:mm")
   private LocalDateTime createTime;
   @Excel(name = "审核人")
   private String checkUserName;
   @Excel(name = "审核时间", exportFormat = "yyyy-MM-dd HH:mm")
   private LocalDateTime checkTime;
   @Excel(name = "审核状态")
   private String status;
   @Excel(name = "名称")
   private String name;
   @Excel(name = "使用类别")
   private String usePropertyName;
   @Excel(name = "核算单位")
   private String accountingUnit;
   @Excel(name = "核算量")
   private BigDecimal mete;
   @Excel(name = "单位")
   private String measureUnit;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "数量")
   private Integer totalQuantity;
   @Excel(name = "金额(元)")
   private BigDecimal totalAmount;
   @Excel(name = "综合单价(元)")
   private String price;

   public String getProject() {
      return this.project;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public String getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public String getUsePropertyName() {
      return this.usePropertyName;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public String getPrice() {
      return this.price;
   }

   public void setProject(final String project) {
      this.project = project;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUsePropertyName(final String usePropertyName) {
      this.usePropertyName = usePropertyName;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setPrice(final String price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessCheckAuxiliaryMaterialExcelDTO)) {
         return false;
      }

      BusinessCheckAuxiliaryMaterialExcelDTO other = (BusinessCheckAuxiliaryMaterialExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$createUserName = this.getCreateUserName();
                  Object other$createUserName = other.getCreateUserName();
                  if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$checkUserName = this.getCheckUserName();
                        Object other$checkUserName = other.getCheckUserName();
                        if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                           Object this$checkTime = this.getCheckTime();
                           Object other$checkTime = other.getCheckTime();
                           if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$usePropertyName = this.getUsePropertyName();
                                    Object other$usePropertyName = other.getUsePropertyName();
                                    if (this$usePropertyName == null ? other$usePropertyName == null : this$usePropertyName.equals(other$usePropertyName)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$measureUnit = this.getMeasureUnit();
                                             Object other$measureUnit = other.getMeasureUnit();
                                             if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$totalAmount = this.getTotalAmount();
                                                   Object other$totalAmount = other.getTotalAmount();
                                                   if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                                      Object this$price = this.getPrice();
                                                      Object other$price = other.getPrice();
                                                      return this$price == null ? other$price == null : this$price.equals(other$price);
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

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessCheckAuxiliaryMaterialExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $usePropertyName = this.getUsePropertyName();
      result = result * 59 + ($usePropertyName == null ? 43 : $usePropertyName.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessCheckAuxiliaryMaterialExcelDTO(project="
         + this.getProject()
         + ", typeName="
         + this.getTypeName()
         + ", remark="
         + this.getRemark()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ", usePropertyName="
         + this.getUsePropertyName()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", specification="
         + this.getSpecification()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
