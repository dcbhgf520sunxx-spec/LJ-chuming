package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("考勤月详情信息")
public class MesAttendanceMonthDetailsDTO {
   @ApiModelProperty(name = "rosterId", value = "花名册id", notes = "花名册id")
   private Long rosterId;
   @ApiModelProperty(name = "userName", value = "姓名", notes = "姓名")
   private String userName;
   @ApiModelProperty(name = "idCard", value = "身份证号", notes = "身份证号")
   private String idCard;
   @ApiModelProperty(name = "supplierName", value = "分包商", notes = "分包商")
   private String supplierName;
   @ApiModelProperty(name = "clockNumber", value = "打卡天数", notes = "打卡天数")
   private Long clockNumber;
   @ApiModelProperty(name = "absenceNumber", value = "缺勤天数", notes = "缺勤天数")
   private Long absenceNumber;
   @ApiModelProperty(name = "workHours", value = "标准工时", notes = "标准工时")
   private BigDecimal workHours;
   @ApiModelProperty(name = "baseHours", value = "普通工时", notes = "普通工时")
   private BigDecimal baseHours;
   @ApiModelProperty(name = "overHours", value = "加班工时", notes = "加班工时")
   private BigDecimal overHours;
   @ApiModelProperty(name = "absenceHours", value = "缺勤时长", notes = "缺勤时长")
   private BigDecimal absenceHours;

   public static MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder builder() {
      return new MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder();
   }

   public MesAttendanceMonthDetailsDTO() {
   }

   public MesAttendanceMonthDetailsDTO(
      final Long rosterId,
      final String userName,
      final String idCard,
      final String supplierName,
      final Long clockNumber,
      final Long absenceNumber,
      final BigDecimal workHours,
      final BigDecimal baseHours,
      final BigDecimal overHours,
      final BigDecimal absenceHours
   ) {
      this.rosterId = rosterId;
      this.userName = userName;
      this.idCard = idCard;
      this.supplierName = supplierName;
      this.clockNumber = clockNumber;
      this.absenceNumber = absenceNumber;
      this.workHours = workHours;
      this.baseHours = baseHours;
      this.overHours = overHours;
      this.absenceHours = absenceHours;
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getIdCard() {
      return this.idCard;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getClockNumber() {
      return this.clockNumber;
   }

   public Long getAbsenceNumber() {
      return this.absenceNumber;
   }

   public BigDecimal getWorkHours() {
      return this.workHours;
   }

   public BigDecimal getBaseHours() {
      return this.baseHours;
   }

   public BigDecimal getOverHours() {
      return this.overHours;
   }

   public BigDecimal getAbsenceHours() {
      return this.absenceHours;
   }

   public MesAttendanceMonthDetailsDTO setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setIdCard(final String idCard) {
      this.idCard = idCard;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setClockNumber(final Long clockNumber) {
      this.clockNumber = clockNumber;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setAbsenceNumber(final Long absenceNumber) {
      this.absenceNumber = absenceNumber;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setWorkHours(final BigDecimal workHours) {
      this.workHours = workHours;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setBaseHours(final BigDecimal baseHours) {
      this.baseHours = baseHours;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setOverHours(final BigDecimal overHours) {
      this.overHours = overHours;
      return this;
   }

   public MesAttendanceMonthDetailsDTO setAbsenceHours(final BigDecimal absenceHours) {
      this.absenceHours = absenceHours;
      return this;
   }

   @Override
   public String toString() {
      return "MesAttendanceMonthDetailsDTO(rosterId="
         + this.getRosterId()
         + ", userName="
         + this.getUserName()
         + ", idCard="
         + this.getIdCard()
         + ", supplierName="
         + this.getSupplierName()
         + ", clockNumber="
         + this.getClockNumber()
         + ", absenceNumber="
         + this.getAbsenceNumber()
         + ", workHours="
         + this.getWorkHours()
         + ", baseHours="
         + this.getBaseHours()
         + ", overHours="
         + this.getOverHours()
         + ", absenceHours="
         + this.getAbsenceHours()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAttendanceMonthDetailsDTO)) {
         return false;
      }

      MesAttendanceMonthDetailsDTO other = (MesAttendanceMonthDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$rosterId = this.getRosterId();
      Object other$rosterId = other.getRosterId();
      if (this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId)) {
         Object this$clockNumber = this.getClockNumber();
         Object other$clockNumber = other.getClockNumber();
         if (this$clockNumber == null ? other$clockNumber == null : this$clockNumber.equals(other$clockNumber)) {
            Object this$absenceNumber = this.getAbsenceNumber();
            Object other$absenceNumber = other.getAbsenceNumber();
            if (this$absenceNumber == null ? other$absenceNumber == null : this$absenceNumber.equals(other$absenceNumber)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$idCard = this.getIdCard();
                  Object other$idCard = other.getIdCard();
                  if (this$idCard == null ? other$idCard == null : this$idCard.equals(other$idCard)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$workHours = this.getWorkHours();
                        Object other$workHours = other.getWorkHours();
                        if (this$workHours == null ? other$workHours == null : this$workHours.equals(other$workHours)) {
                           Object this$baseHours = this.getBaseHours();
                           Object other$baseHours = other.getBaseHours();
                           if (this$baseHours == null ? other$baseHours == null : this$baseHours.equals(other$baseHours)) {
                              Object this$overHours = this.getOverHours();
                              Object other$overHours = other.getOverHours();
                              if (this$overHours == null ? other$overHours == null : this$overHours.equals(other$overHours)) {
                                 Object this$absenceHours = this.getAbsenceHours();
                                 Object other$absenceHours = other.getAbsenceHours();
                                 return this$absenceHours == null ? other$absenceHours == null : this$absenceHours.equals(other$absenceHours);
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
      return other instanceof MesAttendanceMonthDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $rosterId = this.getRosterId();
      result = result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
      Object $clockNumber = this.getClockNumber();
      result = result * 59 + ($clockNumber == null ? 43 : $clockNumber.hashCode());
      Object $absenceNumber = this.getAbsenceNumber();
      result = result * 59 + ($absenceNumber == null ? 43 : $absenceNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $idCard = this.getIdCard();
      result = result * 59 + ($idCard == null ? 43 : $idCard.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $workHours = this.getWorkHours();
      result = result * 59 + ($workHours == null ? 43 : $workHours.hashCode());
      Object $baseHours = this.getBaseHours();
      result = result * 59 + ($baseHours == null ? 43 : $baseHours.hashCode());
      Object $overHours = this.getOverHours();
      result = result * 59 + ($overHours == null ? 43 : $overHours.hashCode());
      Object $absenceHours = this.getAbsenceHours();
      return result * 59 + ($absenceHours == null ? 43 : $absenceHours.hashCode());
   }

   public static class MesAttendanceMonthDetailsDTOBuilder {
      private Long rosterId;
      private String userName;
      private String idCard;
      private String supplierName;
      private Long clockNumber;
      private Long absenceNumber;
      private BigDecimal workHours;
      private BigDecimal baseHours;
      private BigDecimal overHours;
      private BigDecimal absenceHours;

      MesAttendanceMonthDetailsDTOBuilder() {
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder idCard(final String idCard) {
         this.idCard = idCard;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder clockNumber(final Long clockNumber) {
         this.clockNumber = clockNumber;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder absenceNumber(final Long absenceNumber) {
         this.absenceNumber = absenceNumber;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder workHours(final BigDecimal workHours) {
         this.workHours = workHours;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder baseHours(final BigDecimal baseHours) {
         this.baseHours = baseHours;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder overHours(final BigDecimal overHours) {
         this.overHours = overHours;
         return this;
      }

      public MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder absenceHours(final BigDecimal absenceHours) {
         this.absenceHours = absenceHours;
         return this;
      }

      public MesAttendanceMonthDetailsDTO build() {
         return new MesAttendanceMonthDetailsDTO(
            this.rosterId,
            this.userName,
            this.idCard,
            this.supplierName,
            this.clockNumber,
            this.absenceNumber,
            this.workHours,
            this.baseHours,
            this.overHours,
            this.absenceHours
         );
      }

      @Override
      public String toString() {
         return "MesAttendanceMonthDetailsDTO.MesAttendanceMonthDetailsDTOBuilder(rosterId="
            + this.rosterId
            + ", userName="
            + this.userName
            + ", idCard="
            + this.idCard
            + ", supplierName="
            + this.supplierName
            + ", clockNumber="
            + this.clockNumber
            + ", absenceNumber="
            + this.absenceNumber
            + ", workHours="
            + this.workHours
            + ", baseHours="
            + this.baseHours
            + ", overHours="
            + this.overHours
            + ", absenceHours="
            + this.absenceHours
            + ")";
      }
   }
}
