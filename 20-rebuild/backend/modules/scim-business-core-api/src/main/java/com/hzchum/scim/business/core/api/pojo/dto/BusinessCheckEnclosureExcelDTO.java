package com.hzchum.scim.business.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExcelTarget("BusinessCheckEnclosureExcelDTO")
public class BusinessCheckEnclosureExcelDTO {
   @Excel(name = "项目")
   private String project;
   @Excel(name = "产品类型")
   private String typeName;
   @Excel(name = "批次")
   private String enclosurePlanName;
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
   @Excel(name = "版型")
   private String plate;
   @Excel(name = "厚度(mm)")
   private String thickness;
   @Excel(name = "品牌")
   private String brand;
   @Excel(name = "颜色")
   private String color;
   @Excel(name = "总面积(m²)")
   private BigDecimal totalArea;
   @Excel(name = "类别")
   private String categoryName;
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

   public String getEnclosurePlanName() {
      return this.enclosurePlanName;
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

   public String getPlate() {
      return this.plate;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getCategoryName() {
      return this.categoryName;
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

   public void setEnclosurePlanName(final String enclosurePlanName) {
      this.enclosurePlanName = enclosurePlanName;
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

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setCategoryName(final String categoryName) {
      this.categoryName = categoryName;
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

      if (!(o instanceof BusinessCheckEnclosureExcelDTO)) {
         return false;
      }

      BusinessCheckEnclosureExcelDTO other = (BusinessCheckEnclosureExcelDTO)o;
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
               Object this$enclosurePlanName = this.getEnclosurePlanName();
               Object other$enclosurePlanName = other.getEnclosurePlanName();
               if (this$enclosurePlanName == null ? other$enclosurePlanName == null : this$enclosurePlanName.equals(other$enclosurePlanName)) {
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
                                       Object this$plate = this.getPlate();
                                       Object other$plate = other.getPlate();
                                       if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                          Object this$thickness = this.getThickness();
                                          Object other$thickness = other.getThickness();
                                          if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                             Object this$brand = this.getBrand();
                                             Object other$brand = other.getBrand();
                                             if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                Object this$color = this.getColor();
                                                Object other$color = other.getColor();
                                                if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                   Object this$totalArea = this.getTotalArea();
                                                   Object other$totalArea = other.getTotalArea();
                                                   if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                      Object this$categoryName = this.getCategoryName();
                                                      Object other$categoryName = other.getCategoryName();
                                                      if (this$categoryName == null ? other$categoryName == null : this$categoryName.equals(other$categoryName)
                                                         )
                                                       {
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
                                                               if (this$totalAmount == null
                                                                  ? other$totalAmount == null
                                                                  : this$totalAmount.equals(other$totalAmount)) {
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
      return other instanceof BusinessCheckEnclosureExcelDTO;
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
      Object $enclosurePlanName = this.getEnclosurePlanName();
      result = result * 59 + ($enclosurePlanName == null ? 43 : $enclosurePlanName.hashCode());
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
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $categoryName = this.getCategoryName();
      result = result * 59 + ($categoryName == null ? 43 : $categoryName.hashCode());
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
      return "BusinessCheckEnclosureExcelDTO(project="
         + this.getProject()
         + ", typeName="
         + this.getTypeName()
         + ", enclosurePlanName="
         + this.getEnclosurePlanName()
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
         + ", plate="
         + this.getPlate()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", totalArea="
         + this.getTotalArea()
         + ", categoryName="
         + this.getCategoryName()
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
