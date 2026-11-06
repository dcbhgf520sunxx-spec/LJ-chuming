package com.hzchum.scim.business.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExcelTarget("BusinessCheckStructuralAndDispersedExcelDTO")
public class BusinessCheckStructuralAndDispersedExcelDTO {
   @Excel(name = "项目")
   private String project;
   @Excel(name = "产品类型")
   private String typeName;
   @Excel(name = "单体")
   private String monomer;
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
   @Excel(name = "材质")
   private String material;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "总重(t)")
   private BigDecimal totalWeight;
   @Excel(name = "总长(m)")
   private BigDecimal totalLength;
   @Excel(name = "计价方式")
   private String pricingMannerName;
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

   public String getMonomer() {
      return this.monomer;
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

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public String getPricingMannerName() {
      return this.pricingMannerName;
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

   public void setMonomer(final String monomer) {
      this.monomer = monomer;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setPricingMannerName(final String pricingMannerName) {
      this.pricingMannerName = pricingMannerName;
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

      if (!(o instanceof BusinessCheckStructuralAndDispersedExcelDTO)) {
         return false;
      }

      BusinessCheckStructuralAndDispersedExcelDTO other = (BusinessCheckStructuralAndDispersedExcelDTO)o;
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
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
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
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$totalWeight = this.getTotalWeight();
                                             Object other$totalWeight = other.getTotalWeight();
                                             if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                                Object this$totalLength = this.getTotalLength();
                                                Object other$totalLength = other.getTotalLength();
                                                if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                   Object this$pricingMannerName = this.getPricingMannerName();
                                                   Object other$pricingMannerName = other.getPricingMannerName();
                                                   if (this$pricingMannerName == null
                                                      ? other$pricingMannerName == null
                                                      : this$pricingMannerName.equals(other$pricingMannerName)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessCheckStructuralAndDispersedExcelDTO;
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
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $pricingMannerName = this.getPricingMannerName();
      result = result * 59 + ($pricingMannerName == null ? 43 : $pricingMannerName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessCheckStructuralAndDispersedExcelDTO(project="
         + this.getProject()
         + ", typeName="
         + this.getTypeName()
         + ", monomer="
         + this.getMonomer()
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
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", pricingMannerName="
         + this.getPricingMannerName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
