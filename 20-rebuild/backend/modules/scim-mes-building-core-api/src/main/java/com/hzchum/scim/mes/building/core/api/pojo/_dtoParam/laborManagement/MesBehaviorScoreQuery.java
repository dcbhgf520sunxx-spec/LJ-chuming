package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("行为计分Query")
public class MesBehaviorScoreQuery {
   @ApiModelProperty("年份")
   private Integer year;
   @ApiModelProperty("供应商ID")
   private Long supplierId;
   @ApiModelProperty("员工类别")
   private Integer employeeCategory;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("身份证号")
   private String idNumber;
   @ApiModelProperty("手机号")
   private String phone;
   @ApiModelProperty("用户ID")
   private Long userId;

   MesBehaviorScoreQuery(
      final Integer year,
      final Long supplierId,
      final Integer employeeCategory,
      final String name,
      final String idNumber,
      final String phone,
      final Long userId
   ) {
      this.year = year;
      this.supplierId = supplierId;
      this.employeeCategory = employeeCategory;
      this.name = name;
      this.idNumber = idNumber;
      this.phone = phone;
      this.userId = userId;
   }

   public static MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder builder() {
      return new MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder();
   }

   public Integer getYear() {
      return this.year;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getEmployeeCategory() {
      return this.employeeCategory;
   }

   public String getName() {
      return this.name;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public String getPhone() {
      return this.phone;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setEmployeeCategory(final Integer employeeCategory) {
      this.employeeCategory = employeeCategory;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBehaviorScoreQuery)) {
         return false;
      }

      MesBehaviorScoreQuery other = (MesBehaviorScoreQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$employeeCategory = this.getEmployeeCategory();
            Object other$employeeCategory = other.getEmployeeCategory();
            if (this$employeeCategory == null ? other$employeeCategory == null : this$employeeCategory.equals(other$employeeCategory)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$idNumber = this.getIdNumber();
                     Object other$idNumber = other.getIdNumber();
                     if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                        Object this$phone = this.getPhone();
                        Object other$phone = other.getPhone();
                        return this$phone == null ? other$phone == null : this$phone.equals(other$phone);
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
      return other instanceof MesBehaviorScoreQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $employeeCategory = this.getEmployeeCategory();
      result = result * 59 + ($employeeCategory == null ? 43 : $employeeCategory.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   @Override
   public String toString() {
      return "MesBehaviorScoreQuery(year="
         + this.getYear()
         + ", supplierId="
         + this.getSupplierId()
         + ", employeeCategory="
         + this.getEmployeeCategory()
         + ", name="
         + this.getName()
         + ", idNumber="
         + this.getIdNumber()
         + ", phone="
         + this.getPhone()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class MesBehaviorScoreQueryBuilder {
      private Integer year;
      private Long supplierId;
      private Integer employeeCategory;
      private String name;
      private String idNumber;
      private String phone;
      private Long userId;

      MesBehaviorScoreQueryBuilder() {
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder employeeCategory(final Integer employeeCategory) {
         this.employeeCategory = employeeCategory;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBehaviorScoreQuery build() {
         return new MesBehaviorScoreQuery(this.year, this.supplierId, this.employeeCategory, this.name, this.idNumber, this.phone, this.userId);
      }

      @Override
      public String toString() {
         return "MesBehaviorScoreQuery.MesBehaviorScoreQueryBuilder(year="
            + this.year
            + ", supplierId="
            + this.supplierId
            + ", employeeCategory="
            + this.employeeCategory
            + ", name="
            + this.name
            + ", idNumber="
            + this.idNumber
            + ", phone="
            + this.phone
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
