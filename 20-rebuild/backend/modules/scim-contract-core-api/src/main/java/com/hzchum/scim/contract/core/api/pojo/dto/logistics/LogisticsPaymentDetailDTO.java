package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.contract.core.api.pojo.dto.LogisticsPaymentInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("付款详情")
public class LogisticsPaymentDetailDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("详情")
   ListVO<LogisticsPaymentInfoDTO> listVO;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public ListVO<LogisticsPaymentInfoDTO> getListVO() {
      return this.listVO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setListVO(final ListVO<LogisticsPaymentInfoDTO> listVO) {
      this.listVO = listVO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsPaymentDetailDTO)) {
         return false;
      }

      LogisticsPaymentDetailDTO other = (LogisticsPaymentDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applyUserId = this.getApplyUserId();
         Object other$applyUserId = other.getApplyUserId();
         if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
            Object this$applyAmount = this.getApplyAmount();
            Object other$applyAmount = other.getApplyAmount();
            if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
               Object this$receiveBank = this.getReceiveBank();
               Object other$receiveBank = other.getReceiveBank();
               if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                  Object this$receiveBankAccount = this.getReceiveBankAccount();
                  Object other$receiveBankAccount = other.getReceiveBankAccount();
                  if (this$receiveBankAccount == null ? other$receiveBankAccount == null : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                     Object this$applyUserName = this.getApplyUserName();
                     Object other$applyUserName = other.getApplyUserName();
                     if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                        Object this$listVO = this.getListVO();
                        Object other$listVO = other.getListVO();
                        return this$listVO == null ? other$listVO == null : this$listVO.equals(other$listVO);
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
      return other instanceof LogisticsPaymentDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $listVO = this.getListVO();
      return result * 59 + ($listVO == null ? 43 : $listVO.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsPaymentDetailDTO(id="
         + this.getId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", listVO="
         + this.getListVO()
         + ")";
   }
}
