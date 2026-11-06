package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SecurityDepositAndManagementCostDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Integer id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "income", value = "收入", notes = "收入")
   private BigDecimal income;
   @ApiModelProperty(name = "securityDeductIncome", value = "保证金扣除金额", notes = "保证金扣除金额")
   private BigDecimal securityDeductIncome;
   @ApiModelProperty(name = "securityRecord", value = "保证金退还记录", notes = "保证金退还记录")
   private BigDecimal securityRecord;
   @ApiModelProperty(name = "managementDeductIncome", value = "管理费扣除记录", notes = "管理费扣除记录")
   private BigDecimal managementDeductIncome;
   @ApiModelProperty(name = "rate", value = "管理费扣除费率", notes = "管理费扣除费率")
   private String rate;
   @ApiModelProperty(name = "managementRecord", value = "管理费退还记录", notes = "管理费退还记录")
   private BigDecimal managementRecord;
   @ApiModelProperty(name = "dateTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime dateTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public SecurityDepositAndManagementCostDto() {
   }

   public SecurityDepositAndManagementCostDto(
      final Integer id,
      final Long userId,
      final Long projectId,
      final BigDecimal income,
      final BigDecimal securityDeductIncome,
      final BigDecimal securityRecord,
      final BigDecimal managementDeductIncome,
      final String rate,
      final BigDecimal managementRecord,
      final LocalDateTime dateTime,
      final String remark
   ) {
      this.id = id;
      this.userId = userId;
      this.projectId = projectId;
      this.income = income;
      this.securityDeductIncome = securityDeductIncome;
      this.securityRecord = securityRecord;
      this.managementDeductIncome = managementDeductIncome;
      this.rate = rate;
      this.managementRecord = managementRecord;
      this.dateTime = dateTime;
      this.remark = remark;
   }

   public Integer getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getSecurityDeductIncome() {
      return this.securityDeductIncome;
   }

   public BigDecimal getSecurityRecord() {
      return this.securityRecord;
   }

   public BigDecimal getManagementDeductIncome() {
      return this.managementDeductIncome;
   }

   public String getRate() {
      return this.rate;
   }

   public BigDecimal getManagementRecord() {
      return this.managementRecord;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setIncome(final BigDecimal income) {
      this.income = income;
   }

   public void setSecurityDeductIncome(final BigDecimal securityDeductIncome) {
      this.securityDeductIncome = securityDeductIncome;
   }

   public void setSecurityRecord(final BigDecimal securityRecord) {
      this.securityRecord = securityRecord;
   }

   public void setManagementDeductIncome(final BigDecimal managementDeductIncome) {
      this.managementDeductIncome = managementDeductIncome;
   }

   public void setRate(final String rate) {
      this.rate = rate;
   }

   public void setManagementRecord(final BigDecimal managementRecord) {
      this.managementRecord = managementRecord;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SecurityDepositAndManagementCostDto)) {
         return false;
      }

      SecurityDepositAndManagementCostDto other = (SecurityDepositAndManagementCostDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$income = this.getIncome();
               Object other$income = other.getIncome();
               if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                  Object this$securityDeductIncome = this.getSecurityDeductIncome();
                  Object other$securityDeductIncome = other.getSecurityDeductIncome();
                  if (this$securityDeductIncome == null ? other$securityDeductIncome == null : this$securityDeductIncome.equals(other$securityDeductIncome)) {
                     Object this$securityRecord = this.getSecurityRecord();
                     Object other$securityRecord = other.getSecurityRecord();
                     if (this$securityRecord == null ? other$securityRecord == null : this$securityRecord.equals(other$securityRecord)) {
                        Object this$managementDeductIncome = this.getManagementDeductIncome();
                        Object other$managementDeductIncome = other.getManagementDeductIncome();
                        if (this$managementDeductIncome == null
                           ? other$managementDeductIncome == null
                           : this$managementDeductIncome.equals(other$managementDeductIncome)) {
                           Object this$rate = this.getRate();
                           Object other$rate = other.getRate();
                           if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                              Object this$managementRecord = this.getManagementRecord();
                              Object other$managementRecord = other.getManagementRecord();
                              if (this$managementRecord == null ? other$managementRecord == null : this$managementRecord.equals(other$managementRecord)) {
                                 Object this$dateTime = this.getDateTime();
                                 Object other$dateTime = other.getDateTime();
                                 if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SecurityDepositAndManagementCostDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $securityDeductIncome = this.getSecurityDeductIncome();
      result = result * 59 + ($securityDeductIncome == null ? 43 : $securityDeductIncome.hashCode());
      Object $securityRecord = this.getSecurityRecord();
      result = result * 59 + ($securityRecord == null ? 43 : $securityRecord.hashCode());
      Object $managementDeductIncome = this.getManagementDeductIncome();
      result = result * 59 + ($managementDeductIncome == null ? 43 : $managementDeductIncome.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $managementRecord = this.getManagementRecord();
      result = result * 59 + ($managementRecord == null ? 43 : $managementRecord.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SecurityDepositAndManagementCostDto(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", income="
         + this.getIncome()
         + ", securityDeductIncome="
         + this.getSecurityDeductIncome()
         + ", securityRecord="
         + this.getSecurityRecord()
         + ", managementDeductIncome="
         + this.getManagementDeductIncome()
         + ", rate="
         + this.getRate()
         + ", managementRecord="
         + this.getManagementRecord()
         + ", dateTime="
         + this.getDateTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
