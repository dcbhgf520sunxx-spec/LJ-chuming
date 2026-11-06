package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SupplierEvaluateQueryParam", description = "供应商评价查询参数")
public class SupplierEvaluateQueryParam {
   @ApiModelProperty("评价状态: true-已评价, false-未评价, null-全部")
   private Boolean boolAnnualEvaluated;
   @ApiModelProperty("分类id")
   private Long classifyId;
   @ApiModelProperty("供应商名称或简称(模糊查询)")
   private String name;
   @ApiModelProperty("pageNumber")
   private Integer pageNumber = 1;
   @ApiModelProperty("pageSize")
   private Integer pageSize = 20;

   public Boolean getBoolAnnualEvaluated() {
      return this.boolAnnualEvaluated;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setBoolAnnualEvaluated(final Boolean boolAnnualEvaluated) {
      this.boolAnnualEvaluated = boolAnnualEvaluated;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierEvaluateQueryParam)) {
         return false;
      }

      SupplierEvaluateQueryParam other = (SupplierEvaluateQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolAnnualEvaluated = this.getBoolAnnualEvaluated();
      Object other$boolAnnualEvaluated = other.getBoolAnnualEvaluated();
      if (this$boolAnnualEvaluated == null ? other$boolAnnualEvaluated == null : this$boolAnnualEvaluated.equals(other$boolAnnualEvaluated)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$pageNumber = this.getPageNumber();
            Object other$pageNumber = other.getPageNumber();
            if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
               Object this$pageSize = this.getPageSize();
               Object other$pageSize = other.getPageSize();
               if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof SupplierEvaluateQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolAnnualEvaluated = this.getBoolAnnualEvaluated();
      result = result * 59 + ($boolAnnualEvaluated == null ? 43 : $boolAnnualEvaluated.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierEvaluateQueryParam(boolAnnualEvaluated="
         + this.getBoolAnnualEvaluated()
         + ", classifyId="
         + this.getClassifyId()
         + ", name="
         + this.getName()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
