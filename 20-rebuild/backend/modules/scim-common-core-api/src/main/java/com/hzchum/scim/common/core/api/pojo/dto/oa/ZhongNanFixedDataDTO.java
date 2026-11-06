package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("表单固定数据")
public class ZhongNanFixedDataDTO {
   @ApiModelProperty("人员id")
   private Long userId;
   @ApiModelProperty("人员名字")
   private String userName;
   @ApiModelProperty("部门id")
   private Long deptId;
   @ApiModelProperty("部门名称")
   private String deptName;
   @ApiModelProperty("分部id")
   private Long sudDeptId;
   @ApiModelProperty("分部名称")
   private String sudDeptName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("申请时间")
   private LocalDateTime applicationTime;
   @ApiModelProperty(name = "purchaseType", value = "采购类型[1 原材料采购,2 制成品采购]")
   private Integer purchaseType;
   @ApiModelProperty(name = "serialNumber", value = "采购单号")
   private String serialNumber;
   @ApiModelProperty(name = "branchCompanyName", value = "签约主体")
   private String branchCompanyName;
   @ApiModelProperty(name = "supplierName", value = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "业务类型，", value = "1，创建合同，2，合同付款，3合同结算", required = true)
   private Integer businessType;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性-采购单类型[1 自营,2 合营,3 内包]")
   private Integer projectAttribute;
   @ApiModelProperty("收款单位")
   private String receivingUnit;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("已支付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("结算金额")
   private BigDecimal SettlementAmount;
   @ApiModelProperty(name = "amount", value = "合同额")
   private BigDecimal amount;
   @ApiModelProperty(name = "BoolAnnual", value = "是否是年度合同")
   private Boolean BoolAnnual;
   @ApiModelProperty(name = "attachmentList", value = "附件合集")
   private List<Attachment> attachmentList;
   @ApiModelProperty(name = "oaSupplierPaymentDTO", value = "采购订单")
   private List<OaSupplierPaymentDTO> oaSupplierPaymentDTO;
   @ApiModelProperty(name = "orderDetailAttachment", value = "采购明细生成的附件")
   private Attachment orderDetailAttachment;

   public static ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder builder() {
      return new ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder();
   }

   public ZhongNanFixedDataDTO() {
   }

   public ZhongNanFixedDataDTO(
      final Long userId,
      final String userName,
      final Long deptId,
      final String deptName,
      final Long sudDeptId,
      final String sudDeptName,
      final String projectName,
      final LocalDateTime applicationTime,
      final Integer purchaseType,
      final String serialNumber,
      final String branchCompanyName,
      final String supplierName,
      final Integer businessType,
      final Integer projectAttribute,
      final String receivingUnit,
      final String receiveBank,
      final String receiveBankAccount,
      final BigDecimal actuallyPaymentAmount,
      final BigDecimal paymentAmount,
      final BigDecimal SettlementAmount,
      final BigDecimal amount,
      final Boolean BoolAnnual,
      final List<Attachment> attachmentList,
      final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO,
      final Attachment orderDetailAttachment
   ) {
      this.userId = userId;
      this.userName = userName;
      this.deptId = deptId;
      this.deptName = deptName;
      this.sudDeptId = sudDeptId;
      this.sudDeptName = sudDeptName;
      this.projectName = projectName;
      this.applicationTime = applicationTime;
      this.purchaseType = purchaseType;
      this.serialNumber = serialNumber;
      this.branchCompanyName = branchCompanyName;
      this.supplierName = supplierName;
      this.businessType = businessType;
      this.projectAttribute = projectAttribute;
      this.receivingUnit = receivingUnit;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.paymentAmount = paymentAmount;
      this.SettlementAmount = SettlementAmount;
      this.amount = amount;
      this.BoolAnnual = BoolAnnual;
      this.attachmentList = attachmentList;
      this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
      this.orderDetailAttachment = orderDetailAttachment;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public Long getSudDeptId() {
      return this.sudDeptId;
   }

   public String getSudDeptName() {
      return this.sudDeptName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getReceivingUnit() {
      return this.receivingUnit;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.SettlementAmount;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolAnnual() {
      return this.BoolAnnual;
   }

   public List<Attachment> getAttachmentList() {
      return this.attachmentList;
   }

   public List<OaSupplierPaymentDTO> getOaSupplierPaymentDTO() {
      return this.oaSupplierPaymentDTO;
   }

   public Attachment getOrderDetailAttachment() {
      return this.orderDetailAttachment;
   }

   public ZhongNanFixedDataDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ZhongNanFixedDataDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ZhongNanFixedDataDTO setDeptId(final Long deptId) {
      this.deptId = deptId;
      return this;
   }

   public ZhongNanFixedDataDTO setDeptName(final String deptName) {
      this.deptName = deptName;
      return this;
   }

   public ZhongNanFixedDataDTO setSudDeptId(final Long sudDeptId) {
      this.sudDeptId = sudDeptId;
      return this;
   }

   public ZhongNanFixedDataDTO setSudDeptName(final String sudDeptName) {
      this.sudDeptName = sudDeptName;
      return this;
   }

   public ZhongNanFixedDataDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ZhongNanFixedDataDTO setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
      return this;
   }

   public ZhongNanFixedDataDTO setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
      return this;
   }

   public ZhongNanFixedDataDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ZhongNanFixedDataDTO setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public ZhongNanFixedDataDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ZhongNanFixedDataDTO setBusinessType(final Integer businessType) {
      this.businessType = businessType;
      return this;
   }

   public ZhongNanFixedDataDTO setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ZhongNanFixedDataDTO setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
      return this;
   }

   public ZhongNanFixedDataDTO setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
      return this;
   }

   public ZhongNanFixedDataDTO setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
      return this;
   }

   public ZhongNanFixedDataDTO setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      return this;
   }

   public ZhongNanFixedDataDTO setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public ZhongNanFixedDataDTO setSettlementAmount(final BigDecimal SettlementAmount) {
      this.SettlementAmount = SettlementAmount;
      return this;
   }

   public ZhongNanFixedDataDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ZhongNanFixedDataDTO setBoolAnnual(final Boolean BoolAnnual) {
      this.BoolAnnual = BoolAnnual;
      return this;
   }

   public ZhongNanFixedDataDTO setAttachmentList(final List<Attachment> attachmentList) {
      this.attachmentList = attachmentList;
      return this;
   }

   public ZhongNanFixedDataDTO setOaSupplierPaymentDTO(final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO) {
      this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
      return this;
   }

   public ZhongNanFixedDataDTO setOrderDetailAttachment(final Attachment orderDetailAttachment) {
      this.orderDetailAttachment = orderDetailAttachment;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanFixedDataDTO)) {
         return false;
      }

      ZhongNanFixedDataDTO other = (ZhongNanFixedDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$sudDeptId = this.getSudDeptId();
            Object other$sudDeptId = other.getSudDeptId();
            if (this$sudDeptId == null ? other$sudDeptId == null : this$sudDeptId.equals(other$sudDeptId)) {
               Object this$purchaseType = this.getPurchaseType();
               Object other$purchaseType = other.getPurchaseType();
               if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                     Object this$projectAttribute = this.getProjectAttribute();
                     Object other$projectAttribute = other.getProjectAttribute();
                     if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                        Object this$BoolAnnual = this.getBoolAnnual();
                        Object other$BoolAnnual = other.getBoolAnnual();
                        if (this$BoolAnnual == null ? other$BoolAnnual == null : this$BoolAnnual.equals(other$BoolAnnual)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$deptName = this.getDeptName();
                              Object other$deptName = other.getDeptName();
                              if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                                 Object this$sudDeptName = this.getSudDeptName();
                                 Object other$sudDeptName = other.getSudDeptName();
                                 if (this$sudDeptName == null ? other$sudDeptName == null : this$sudDeptName.equals(other$sudDeptName)) {
                                    Object this$projectName = this.getProjectName();
                                    Object other$projectName = other.getProjectName();
                                    if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                       Object this$applicationTime = this.getApplicationTime();
                                       Object other$applicationTime = other.getApplicationTime();
                                       if (this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$branchCompanyName = this.getBranchCompanyName();
                                             Object other$branchCompanyName = other.getBranchCompanyName();
                                             if (this$branchCompanyName == null
                                                ? other$branchCompanyName == null
                                                : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                Object this$supplierName = this.getSupplierName();
                                                Object other$supplierName = other.getSupplierName();
                                                if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                   Object this$receivingUnit = this.getReceivingUnit();
                                                   Object other$receivingUnit = other.getReceivingUnit();
                                                   if (this$receivingUnit == null
                                                      ? other$receivingUnit == null
                                                      : this$receivingUnit.equals(other$receivingUnit)) {
                                                      Object this$receiveBank = this.getReceiveBank();
                                                      Object other$receiveBank = other.getReceiveBank();
                                                      if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                                                         Object this$receiveBankAccount = this.getReceiveBankAccount();
                                                         Object other$receiveBankAccount = other.getReceiveBankAccount();
                                                         if (this$receiveBankAccount == null
                                                            ? other$receiveBankAccount == null
                                                            : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                                                            Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                                            Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                                            if (this$actuallyPaymentAmount == null
                                                               ? other$actuallyPaymentAmount == null
                                                               : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount)) {
                                                               Object this$paymentAmount = this.getPaymentAmount();
                                                               Object other$paymentAmount = other.getPaymentAmount();
                                                               if (this$paymentAmount == null
                                                                  ? other$paymentAmount == null
                                                                  : this$paymentAmount.equals(other$paymentAmount)) {
                                                                  Object this$SettlementAmount = this.getSettlementAmount();
                                                                  Object other$SettlementAmount = other.getSettlementAmount();
                                                                  if (this$SettlementAmount == null
                                                                     ? other$SettlementAmount == null
                                                                     : this$SettlementAmount.equals(other$SettlementAmount)) {
                                                                     Object this$amount = this.getAmount();
                                                                     Object other$amount = other.getAmount();
                                                                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                        Object this$attachmentList = this.getAttachmentList();
                                                                        Object other$attachmentList = other.getAttachmentList();
                                                                        if (this$attachmentList == null
                                                                           ? other$attachmentList == null
                                                                           : this$attachmentList.equals(other$attachmentList)) {
                                                                           Object this$oaSupplierPaymentDTO = this.getOaSupplierPaymentDTO();
                                                                           Object other$oaSupplierPaymentDTO = other.getOaSupplierPaymentDTO();
                                                                           if (this$oaSupplierPaymentDTO == null
                                                                              ? other$oaSupplierPaymentDTO == null
                                                                              : this$oaSupplierPaymentDTO.equals(other$oaSupplierPaymentDTO)) {
                                                                              Object this$orderDetailAttachment = this.getOrderDetailAttachment();
                                                                              Object other$orderDetailAttachment = other.getOrderDetailAttachment();
                                                                              return this$orderDetailAttachment == null
                                                                                 ? other$orderDetailAttachment == null
                                                                                 : this$orderDetailAttachment.equals(other$orderDetailAttachment);
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
      return other instanceof ZhongNanFixedDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $sudDeptId = this.getSudDeptId();
      result = result * 59 + ($sudDeptId == null ? 43 : $sudDeptId.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $BoolAnnual = this.getBoolAnnual();
      result = result * 59 + ($BoolAnnual == null ? 43 : $BoolAnnual.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $sudDeptName = this.getSudDeptName();
      result = result * 59 + ($sudDeptName == null ? 43 : $sudDeptName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $SettlementAmount = this.getSettlementAmount();
      result = result * 59 + ($SettlementAmount == null ? 43 : $SettlementAmount.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $oaSupplierPaymentDTO = this.getOaSupplierPaymentDTO();
      result = result * 59 + ($oaSupplierPaymentDTO == null ? 43 : $oaSupplierPaymentDTO.hashCode());
      Object $orderDetailAttachment = this.getOrderDetailAttachment();
      return result * 59 + ($orderDetailAttachment == null ? 43 : $orderDetailAttachment.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanFixedDataDTO(userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", sudDeptId="
         + this.getSudDeptId()
         + ", sudDeptName="
         + this.getSudDeptName()
         + ", projectName="
         + this.getProjectName()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierName="
         + this.getSupplierName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", SettlementAmount="
         + this.getSettlementAmount()
         + ", amount="
         + this.getAmount()
         + ", BoolAnnual="
         + this.getBoolAnnual()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", oaSupplierPaymentDTO="
         + this.getOaSupplierPaymentDTO()
         + ", orderDetailAttachment="
         + this.getOrderDetailAttachment()
         + ")";
   }

   public static class ZhongNanFixedDataDTOBuilder {
      private Long userId;
      private String userName;
      private Long deptId;
      private String deptName;
      private Long sudDeptId;
      private String sudDeptName;
      private String projectName;
      private LocalDateTime applicationTime;
      private Integer purchaseType;
      private String serialNumber;
      private String branchCompanyName;
      private String supplierName;
      private Integer businessType;
      private Integer projectAttribute;
      private String receivingUnit;
      private String receiveBank;
      private String receiveBankAccount;
      private BigDecimal actuallyPaymentAmount;
      private BigDecimal paymentAmount;
      private BigDecimal SettlementAmount;
      private BigDecimal amount;
      private Boolean BoolAnnual;
      private List<Attachment> attachmentList;
      private List<OaSupplierPaymentDTO> oaSupplierPaymentDTO;
      private Attachment orderDetailAttachment;

      ZhongNanFixedDataDTOBuilder() {
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder sudDeptId(final Long sudDeptId) {
         this.sudDeptId = sudDeptId;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder sudDeptName(final String sudDeptName) {
         this.sudDeptName = sudDeptName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder receivingUnit(final String receivingUnit) {
         this.receivingUnit = receivingUnit;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder receiveBank(final String receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder SettlementAmount(final BigDecimal SettlementAmount) {
         this.SettlementAmount = SettlementAmount;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder BoolAnnual(final Boolean BoolAnnual) {
         this.BoolAnnual = BoolAnnual;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder attachmentList(final List<Attachment> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder oaSupplierPaymentDTO(final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO) {
         this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
         return this;
      }

      public ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder orderDetailAttachment(final Attachment orderDetailAttachment) {
         this.orderDetailAttachment = orderDetailAttachment;
         return this;
      }

      public ZhongNanFixedDataDTO build() {
         return new ZhongNanFixedDataDTO(
            this.userId,
            this.userName,
            this.deptId,
            this.deptName,
            this.sudDeptId,
            this.sudDeptName,
            this.projectName,
            this.applicationTime,
            this.purchaseType,
            this.serialNumber,
            this.branchCompanyName,
            this.supplierName,
            this.businessType,
            this.projectAttribute,
            this.receivingUnit,
            this.receiveBank,
            this.receiveBankAccount,
            this.actuallyPaymentAmount,
            this.paymentAmount,
            this.SettlementAmount,
            this.amount,
            this.BoolAnnual,
            this.attachmentList,
            this.oaSupplierPaymentDTO,
            this.orderDetailAttachment
         );
      }

      @Override
      public String toString() {
         return "ZhongNanFixedDataDTO.ZhongNanFixedDataDTOBuilder(userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", sudDeptId="
            + this.sudDeptId
            + ", sudDeptName="
            + this.sudDeptName
            + ", projectName="
            + this.projectName
            + ", applicationTime="
            + this.applicationTime
            + ", purchaseType="
            + this.purchaseType
            + ", serialNumber="
            + this.serialNumber
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierName="
            + this.supplierName
            + ", businessType="
            + this.businessType
            + ", projectAttribute="
            + this.projectAttribute
            + ", receivingUnit="
            + this.receivingUnit
            + ", receiveBank="
            + this.receiveBank
            + ", receiveBankAccount="
            + this.receiveBankAccount
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", SettlementAmount="
            + this.SettlementAmount
            + ", amount="
            + this.amount
            + ", BoolAnnual="
            + this.BoolAnnual
            + ", attachmentList="
            + this.attachmentList
            + ", oaSupplierPaymentDTO="
            + this.oaSupplierPaymentDTO
            + ", orderDetailAttachment="
            + this.orderDetailAttachment
            + ")";
      }
   }
}
