package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;

@ExcelTarget("MesBuildingSpotStatisticsDetailDowloadDTO")
@ApiModel("抽检记录-导出DTO")
public class MesBuildingSpotStatisticsDetailDowloadDTO implements Serializable {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNumber;
   @Excel(name = "项目名称", width = 25.0)
   private String projectName;
   @Excel(name = "单体", width = 20.0)
   private String monomerName;
   @Excel(name = "构件编号", width = 18.0)
   private String serialNumber;
   @Excel(name = "构件名称", width = 16.0)
   private String name;
   @Excel(name = "构件规格", width = 18.0)
   private String specification;
   @Excel(name = "合格数", width = 10.0)
   private Integer qualifiedQuantity;
   @Excel(name = "不合格数", width = 10.0)
   private Integer unQualifiedQuantity;
   @Excel(name = "备注", width = 30.0)
   private String spotCheckRemark;
   @Excel(name = "抽检人", width = 30.0)
   private String spotCheckUserName;
   @Excel(name = "抽检日期", width = 30.0)
   private String spotCheckDate;

   public Integer getOrderNumber() {
      return this.orderNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public String getSpotCheckRemark() {
      return this.spotCheckRemark;
   }

   public String getSpotCheckUserName() {
      return this.spotCheckUserName;
   }

   public String getSpotCheckDate() {
      return this.spotCheckDate;
   }

   public void setOrderNumber(final Integer orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
   }

   public void setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
   }

   public void setSpotCheckRemark(final String spotCheckRemark) {
      this.spotCheckRemark = spotCheckRemark;
   }

   public void setSpotCheckUserName(final String spotCheckUserName) {
      this.spotCheckUserName = spotCheckUserName;
   }

   public void setSpotCheckDate(final String spotCheckDate) {
      this.spotCheckDate = spotCheckDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpotStatisticsDetailDowloadDTO)) {
         return false;
      }

      MesBuildingSpotStatisticsDetailDowloadDTO other = (MesBuildingSpotStatisticsDetailDowloadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNumber = this.getOrderNumber();
      Object other$orderNumber = other.getOrderNumber();
      if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
         Object this$qualifiedQuantity = this.getQualifiedQuantity();
         Object other$qualifiedQuantity = other.getQualifiedQuantity();
         if (this$qualifiedQuantity == null ? other$qualifiedQuantity == null : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
            Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
            Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
            if (this$unQualifiedQuantity == null ? other$unQualifiedQuantity == null : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$spotCheckRemark = this.getSpotCheckRemark();
                              Object other$spotCheckRemark = other.getSpotCheckRemark();
                              if (this$spotCheckRemark == null ? other$spotCheckRemark == null : this$spotCheckRemark.equals(other$spotCheckRemark)) {
                                 Object this$spotCheckUserName = this.getSpotCheckUserName();
                                 Object other$spotCheckUserName = other.getSpotCheckUserName();
                                 if (this$spotCheckUserName == null ? other$spotCheckUserName == null : this$spotCheckUserName.equals(other$spotCheckUserName)) {
                                    Object this$spotCheckDate = this.getSpotCheckDate();
                                    Object other$spotCheckDate = other.getSpotCheckDate();
                                    return this$spotCheckDate == null ? other$spotCheckDate == null : this$spotCheckDate.equals(other$spotCheckDate);
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
      return other instanceof MesBuildingSpotStatisticsDetailDowloadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $spotCheckRemark = this.getSpotCheckRemark();
      result = result * 59 + ($spotCheckRemark == null ? 43 : $spotCheckRemark.hashCode());
      Object $spotCheckUserName = this.getSpotCheckUserName();
      result = result * 59 + ($spotCheckUserName == null ? 43 : $spotCheckUserName.hashCode());
      Object $spotCheckDate = this.getSpotCheckDate();
      return result * 59 + ($spotCheckDate == null ? 43 : $spotCheckDate.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingSpotStatisticsDetailDowloadDTO(orderNumber="
         + this.getOrderNumber()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", spotCheckRemark="
         + this.getSpotCheckRemark()
         + ", spotCheckUserName="
         + this.getSpotCheckUserName()
         + ", spotCheckDate="
         + this.getSpotCheckDate()
         + ")";
   }
}
