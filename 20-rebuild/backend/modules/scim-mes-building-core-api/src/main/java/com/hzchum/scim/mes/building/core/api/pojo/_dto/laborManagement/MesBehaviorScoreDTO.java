package com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("行为计分DTO")
public class MesBehaviorScoreDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("入职日期")
   private LocalDate entryDate;
   @ApiModelProperty("员工编号")
   private String number;
   @ApiModelProperty("姓名")
   private String name;
   @ApiModelProperty("年龄")
   private Integer age;
   @ApiModelProperty("性别(0: 男, 1: 女)")
   private Integer sex;
   @ApiModelProperty("民族")
   private String nation;
   @ApiModelProperty("联系方式")
   private String phone;
   @ApiModelProperty("员工类别")
   private Integer employeeCategory;
   @ApiModelProperty("考勤天数")
   private Integer attendanceDays;
   @ApiModelProperty("行为总分")
   private Integer behaviorTotalScore;
   @ApiModelProperty("已扣行为分")
   private Integer deductedBehaviorScore;
   @ApiModelProperty("剩余行为分")
   private Integer remainingBehaviorScore;
   @ApiModelProperty("累计处罚(元)")
   private BigDecimal cumulativePenalty;
   @ApiModelProperty("供应商ID(雇主单位)")
   private Long supplierId;
   @ApiModelProperty("所属单位名称(供应商名称)")
   private String supplierName;
   @ApiModelProperty("状态(1: 在岗, 2: 离职)")
   private Integer status;
   @ApiModelProperty("用户ID")
   private Long userId;

   public Long getId() {
      return this.id;
   }

   public LocalDate getEntryDate() {
      return this.entryDate;
   }

   public String getNumber() {
      return this.number;
   }

   public String getName() {
      return this.name;
   }

   public Integer getAge() {
      return this.age;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getNation() {
      return this.nation;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getEmployeeCategory() {
      return this.employeeCategory;
   }

   public Integer getAttendanceDays() {
      return this.attendanceDays;
   }

   public Integer getBehaviorTotalScore() {
      return this.behaviorTotalScore;
   }

   public Integer getDeductedBehaviorScore() {
      return this.deductedBehaviorScore;
   }

   public Integer getRemainingBehaviorScore() {
      return this.remainingBehaviorScore;
   }

   public BigDecimal getCumulativePenalty() {
      return this.cumulativePenalty;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEntryDate(final LocalDate entryDate) {
      this.entryDate = entryDate;
   }

   public void setNumber(final String number) {
      this.number = number;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAge(final Integer age) {
      this.age = age;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setNation(final String nation) {
      this.nation = nation;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setEmployeeCategory(final Integer employeeCategory) {
      this.employeeCategory = employeeCategory;
   }

   public void setAttendanceDays(final Integer attendanceDays) {
      this.attendanceDays = attendanceDays;
   }

   public void setBehaviorTotalScore(final Integer behaviorTotalScore) {
      this.behaviorTotalScore = behaviorTotalScore;
   }

   public void setDeductedBehaviorScore(final Integer deductedBehaviorScore) {
      this.deductedBehaviorScore = deductedBehaviorScore;
   }

   public void setRemainingBehaviorScore(final Integer remainingBehaviorScore) {
      this.remainingBehaviorScore = remainingBehaviorScore;
   }

   public void setCumulativePenalty(final BigDecimal cumulativePenalty) {
      this.cumulativePenalty = cumulativePenalty;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBehaviorScoreDTO)) {
         return false;
      }

      MesBehaviorScoreDTO other = (MesBehaviorScoreDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$age = this.getAge();
         Object other$age = other.getAge();
         if (this$age == null ? other$age == null : this$age.equals(other$age)) {
            Object this$sex = this.getSex();
            Object other$sex = other.getSex();
            if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
               Object this$employeeCategory = this.getEmployeeCategory();
               Object other$employeeCategory = other.getEmployeeCategory();
               if (this$employeeCategory == null ? other$employeeCategory == null : this$employeeCategory.equals(other$employeeCategory)) {
                  Object this$attendanceDays = this.getAttendanceDays();
                  Object other$attendanceDays = other.getAttendanceDays();
                  if (this$attendanceDays == null ? other$attendanceDays == null : this$attendanceDays.equals(other$attendanceDays)) {
                     Object this$behaviorTotalScore = this.getBehaviorTotalScore();
                     Object other$behaviorTotalScore = other.getBehaviorTotalScore();
                     if (this$behaviorTotalScore == null ? other$behaviorTotalScore == null : this$behaviorTotalScore.equals(other$behaviorTotalScore)) {
                        Object this$deductedBehaviorScore = this.getDeductedBehaviorScore();
                        Object other$deductedBehaviorScore = other.getDeductedBehaviorScore();
                        if (this$deductedBehaviorScore == null
                           ? other$deductedBehaviorScore == null
                           : this$deductedBehaviorScore.equals(other$deductedBehaviorScore)) {
                           Object this$remainingBehaviorScore = this.getRemainingBehaviorScore();
                           Object other$remainingBehaviorScore = other.getRemainingBehaviorScore();
                           if (this$remainingBehaviorScore == null
                              ? other$remainingBehaviorScore == null
                              : this$remainingBehaviorScore.equals(other$remainingBehaviorScore)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$entryDate = this.getEntryDate();
                                       Object other$entryDate = other.getEntryDate();
                                       if (this$entryDate == null ? other$entryDate == null : this$entryDate.equals(other$entryDate)) {
                                          Object this$number = this.getNumber();
                                          Object other$number = other.getNumber();
                                          if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$nation = this.getNation();
                                                Object other$nation = other.getNation();
                                                if (this$nation == null ? other$nation == null : this$nation.equals(other$nation)) {
                                                   Object this$phone = this.getPhone();
                                                   Object other$phone = other.getPhone();
                                                   if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                      Object this$cumulativePenalty = this.getCumulativePenalty();
                                                      Object other$cumulativePenalty = other.getCumulativePenalty();
                                                      if (this$cumulativePenalty == null
                                                         ? other$cumulativePenalty == null
                                                         : this$cumulativePenalty.equals(other$cumulativePenalty)) {
                                                         Object this$supplierName = this.getSupplierName();
                                                         Object other$supplierName = other.getSupplierName();
                                                         return this$supplierName == null
                                                            ? other$supplierName == null
                                                            : this$supplierName.equals(other$supplierName);
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
      return other instanceof MesBehaviorScoreDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $age = this.getAge();
      result = result * 59 + ($age == null ? 43 : $age.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $employeeCategory = this.getEmployeeCategory();
      result = result * 59 + ($employeeCategory == null ? 43 : $employeeCategory.hashCode());
      Object $attendanceDays = this.getAttendanceDays();
      result = result * 59 + ($attendanceDays == null ? 43 : $attendanceDays.hashCode());
      Object $behaviorTotalScore = this.getBehaviorTotalScore();
      result = result * 59 + ($behaviorTotalScore == null ? 43 : $behaviorTotalScore.hashCode());
      Object $deductedBehaviorScore = this.getDeductedBehaviorScore();
      result = result * 59 + ($deductedBehaviorScore == null ? 43 : $deductedBehaviorScore.hashCode());
      Object $remainingBehaviorScore = this.getRemainingBehaviorScore();
      result = result * 59 + ($remainingBehaviorScore == null ? 43 : $remainingBehaviorScore.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $entryDate = this.getEntryDate();
      result = result * 59 + ($entryDate == null ? 43 : $entryDate.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $nation = this.getNation();
      result = result * 59 + ($nation == null ? 43 : $nation.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $cumulativePenalty = this.getCumulativePenalty();
      result = result * 59 + ($cumulativePenalty == null ? 43 : $cumulativePenalty.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBehaviorScoreDTO(id="
         + this.getId()
         + ", entryDate="
         + this.getEntryDate()
         + ", number="
         + this.getNumber()
         + ", name="
         + this.getName()
         + ", age="
         + this.getAge()
         + ", sex="
         + this.getSex()
         + ", nation="
         + this.getNation()
         + ", phone="
         + this.getPhone()
         + ", employeeCategory="
         + this.getEmployeeCategory()
         + ", attendanceDays="
         + this.getAttendanceDays()
         + ", behaviorTotalScore="
         + this.getBehaviorTotalScore()
         + ", deductedBehaviorScore="
         + this.getDeductedBehaviorScore()
         + ", remainingBehaviorScore="
         + this.getRemainingBehaviorScore()
         + ", cumulativePenalty="
         + this.getCumulativePenalty()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
