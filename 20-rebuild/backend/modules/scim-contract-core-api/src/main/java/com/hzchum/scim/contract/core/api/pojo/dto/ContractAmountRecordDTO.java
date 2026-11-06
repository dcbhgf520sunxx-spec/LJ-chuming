package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("项目合同金额变更记录类")
public class ContractAmountRecordDTO {
   @ApiModelProperty("合同额状态")
   private String status;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("操作日期")
   private LocalDate date;
   @ApiModelProperty("操作人Id")
   private Long userId;
   @ApiModelProperty("操作人名称")
   private String userName;

   public static ContractAmountRecordDTO.ContractAmountRecordDTOBuilder builder() {
      return new ContractAmountRecordDTO.ContractAmountRecordDTOBuilder();
   }

   public ContractAmountRecordDTO(final String status, final BigDecimal amount, final LocalDate date, final Long userId, final String userName) {
      this.status = status;
      this.amount = amount;
      this.date = date;
      this.userId = userId;
      this.userName = userName;
   }

   public ContractAmountRecordDTO() {
   }

   public String getStatus() {
      return this.status;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAmountRecordDTO)) {
         return false;
      }

      ContractAmountRecordDTO other = (ContractAmountRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof ContractAmountRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAmountRecordDTO(status="
         + this.getStatus()
         + ", amount="
         + this.getAmount()
         + ", date="
         + this.getDate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class ContractAmountRecordDTOBuilder {
      private String status;
      private BigDecimal amount;
      private LocalDate date;
      private Long userId;
      private String userName;

      ContractAmountRecordDTOBuilder() {
      }

      public ContractAmountRecordDTO.ContractAmountRecordDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public ContractAmountRecordDTO.ContractAmountRecordDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractAmountRecordDTO.ContractAmountRecordDTOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public ContractAmountRecordDTO.ContractAmountRecordDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractAmountRecordDTO.ContractAmountRecordDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractAmountRecordDTO build() {
         return new ContractAmountRecordDTO(this.status, this.amount, this.date, this.userId, this.userName);
      }

      @Override
      public String toString() {
         return "ContractAmountRecordDTO.ContractAmountRecordDTOBuilder(status="
            + this.status
            + ", amount="
            + this.amount
            + ", date="
            + this.date
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
