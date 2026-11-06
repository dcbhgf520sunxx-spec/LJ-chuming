package com.hzchum.scim.project.core.api.pojo.dto.labor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("ProjectManageRosterSimpleDTO")
public class ProjectManageRosterSimpleDTO {
   private Long userId;
   @ApiModelProperty(name = "name", value = "姓名", notes = "姓名")
   private String name;
   @ApiModelProperty(name = "idNumber", value = "身份证号", notes = "身份证号")
   private String idNumber;
   @ApiModelProperty("wokeName")
   private String wokeName;
   @ApiModelProperty("联系方式")
   private String phone;
   @ApiModelProperty("已扣行为分")
   private Integer deductedBehaviorScore;
   @ApiModelProperty("累计处罚(元)")
   private BigDecimal cumulativePenalty;

   public Long getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public String getWokeName() {
      return this.wokeName;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getDeductedBehaviorScore() {
      return this.deductedBehaviorScore;
   }

   public BigDecimal getCumulativePenalty() {
      return this.cumulativePenalty;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
   }

   public void setWokeName(final String wokeName) {
      this.wokeName = wokeName;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setDeductedBehaviorScore(final Integer deductedBehaviorScore) {
      this.deductedBehaviorScore = deductedBehaviorScore;
   }

   public void setCumulativePenalty(final BigDecimal cumulativePenalty) {
      this.cumulativePenalty = cumulativePenalty;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageRosterSimpleDTO)) {
         return false;
      }

      ProjectManageRosterSimpleDTO other = (ProjectManageRosterSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$deductedBehaviorScore = this.getDeductedBehaviorScore();
         Object other$deductedBehaviorScore = other.getDeductedBehaviorScore();
         if (this$deductedBehaviorScore == null ? other$deductedBehaviorScore == null : this$deductedBehaviorScore.equals(other$deductedBehaviorScore)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$idNumber = this.getIdNumber();
               Object other$idNumber = other.getIdNumber();
               if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                  Object this$wokeName = this.getWokeName();
                  Object other$wokeName = other.getWokeName();
                  if (this$wokeName == null ? other$wokeName == null : this$wokeName.equals(other$wokeName)) {
                     Object this$phone = this.getPhone();
                     Object other$phone = other.getPhone();
                     if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                        Object this$cumulativePenalty = this.getCumulativePenalty();
                        Object other$cumulativePenalty = other.getCumulativePenalty();
                        return this$cumulativePenalty == null ? other$cumulativePenalty == null : this$cumulativePenalty.equals(other$cumulativePenalty);
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
      return other instanceof ProjectManageRosterSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $deductedBehaviorScore = this.getDeductedBehaviorScore();
      result = result * 59 + ($deductedBehaviorScore == null ? 43 : $deductedBehaviorScore.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $wokeName = this.getWokeName();
      result = result * 59 + ($wokeName == null ? 43 : $wokeName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $cumulativePenalty = this.getCumulativePenalty();
      return result * 59 + ($cumulativePenalty == null ? 43 : $cumulativePenalty.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageRosterSimpleDTO(super="
         + super.toString()
         + ", userId="
         + this.getUserId()
         + ", name="
         + this.getName()
         + ", idNumber="
         + this.getIdNumber()
         + ", wokeName="
         + this.getWokeName()
         + ", phone="
         + this.getPhone()
         + ", deductedBehaviorScore="
         + this.getDeductedBehaviorScore()
         + ", cumulativePenalty="
         + this.getCumulativePenalty()
         + ")";
   }
}
