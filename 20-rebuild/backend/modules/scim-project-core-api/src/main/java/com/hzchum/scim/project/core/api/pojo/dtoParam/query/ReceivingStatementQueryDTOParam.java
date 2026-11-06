package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("收货报表查询类")
public class ReceivingStatementQueryDTOParam extends ProjectBaseQueryDTOParam {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "areaType", value = "来源类型 0自制 1外协", notes = "来源类型 0自制 1外协")
   private Integer areaType;
   @ApiModelProperty(name = "supplierName", value = "外协供应商名称", notes = "外协供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "sourceType", value = "来源类型 外购 自制")
   private Integer sourceType;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   @Override
   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getSourceType() {
      return this.sourceType;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setAreaType(final Integer areaType) {
      this.areaType = areaType;
   }

   @Override
   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSourceType(final Integer sourceType) {
      this.sourceType = sourceType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceivingStatementQueryDTOParam)) {
         return false;
      }

      ReceivingStatementQueryDTOParam other = (ReceivingStatementQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaType = this.getAreaType();
      Object other$areaType = other.getAreaType();
      if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
         Object this$sourceType = this.getSourceType();
         Object other$sourceType = other.getSourceType();
         if (this$sourceType == null ? other$sourceType == null : this$sourceType.equals(other$sourceType)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ReceivingStatementQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $sourceType = this.getSourceType();
      result = result * 59 + ($sourceType == null ? 43 : $sourceType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "ReceivingStatementQueryDTOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", areaType="
         + this.getAreaType()
         + ", supplierName="
         + this.getSupplierName()
         + ", sourceType="
         + this.getSourceType()
         + ")";
   }
}
