package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "花名册查询类")
public class MesRosterQuery {
   @ApiModelProperty("状态")
   private Integer status;
   @ApiModelProperty("名族")
   private String nation;
   @ApiModelProperty("性别")
   private Integer sex;
   @ApiModelProperty("姓名")
   private String name;
   @ApiModelProperty("身份证号")
   private String idNumber;
   @ApiModelProperty("联系方式")
   private String phone;
   @ApiModelProperty("所属单位(供应商ID)")
   private Long supplierId;
   private Long id;
   private Long userId;

   MesRosterQuery(
      final Integer status,
      final String nation,
      final Integer sex,
      final String name,
      final String idNumber,
      final String phone,
      final Long supplierId,
      final Long id,
      final Long userId
   ) {
      this.status = status;
      this.nation = nation;
      this.sex = sex;
      this.name = name;
      this.idNumber = idNumber;
      this.phone = phone;
      this.supplierId = supplierId;
      this.id = id;
      this.userId = userId;
   }

   public static MesRosterQuery.MesRosterQueryBuilder builder() {
      return new MesRosterQuery.MesRosterQueryBuilder();
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getNation() {
      return this.nation;
   }

   public Integer getSex() {
      return this.sex;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setNation(final String nation) {
      this.nation = nation;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
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

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRosterQuery)) {
         return false;
      }

      MesRosterQuery other = (MesRosterQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$sex = this.getSex();
         Object other$sex = other.getSex();
         if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$nation = this.getNation();
                     Object other$nation = other.getNation();
                     if (this$nation == null ? other$nation == null : this$nation.equals(other$nation)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesRosterQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $nation = this.getNation();
      result = result * 59 + ($nation == null ? 43 : $nation.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   @Override
   public String toString() {
      return "MesRosterQuery(status="
         + this.getStatus()
         + ", nation="
         + this.getNation()
         + ", sex="
         + this.getSex()
         + ", name="
         + this.getName()
         + ", idNumber="
         + this.getIdNumber()
         + ", phone="
         + this.getPhone()
         + ", supplierId="
         + this.getSupplierId()
         + ", id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class MesRosterQueryBuilder {
      private Integer status;
      private String nation;
      private Integer sex;
      private String name;
      private String idNumber;
      private String phone;
      private Long supplierId;
      private Long id;
      private Long userId;

      MesRosterQueryBuilder() {
      }

      public MesRosterQuery.MesRosterQueryBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder nation(final String nation) {
         this.nation = nation;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder sex(final Integer sex) {
         this.sex = sex;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesRosterQuery.MesRosterQueryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesRosterQuery build() {
         return new MesRosterQuery(this.status, this.nation, this.sex, this.name, this.idNumber, this.phone, this.supplierId, this.id, this.userId);
      }

      @Override
      public String toString() {
         return "MesRosterQuery.MesRosterQueryBuilder(status="
            + this.status
            + ", nation="
            + this.nation
            + ", sex="
            + this.sex
            + ", name="
            + this.name
            + ", idNumber="
            + this.idNumber
            + ", phone="
            + this.phone
            + ", supplierId="
            + this.supplierId
            + ", id="
            + this.id
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
