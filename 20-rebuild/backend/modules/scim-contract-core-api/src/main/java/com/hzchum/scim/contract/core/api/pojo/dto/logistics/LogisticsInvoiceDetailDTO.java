package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("付款详情")
public class LogisticsInvoiceDetailDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("累计支出")
   private BigDecimal applyAmount;
   @ApiModelProperty("发票面额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("详情")
   List<LogisticsInvoiceInfoDTO> listVO;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
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

   public List<LogisticsInvoiceInfoDTO> getListVO() {
      return this.listVO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
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

   public void setListVO(final List<LogisticsInvoiceInfoDTO> listVO) {
      this.listVO = listVO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsInvoiceDetailDTO)) {
         return false;
      }

      LogisticsInvoiceDetailDTO other = (LogisticsInvoiceDetailDTO)o;
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
               Object this$invoiceAmount = this.getInvoiceAmount();
               Object other$invoiceAmount = other.getInvoiceAmount();
               if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                  Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                  Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                  if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LogisticsInvoiceDetailDTO;
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
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
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
      return "LogisticsInvoiceDetailDTO(id="
         + this.getId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
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
