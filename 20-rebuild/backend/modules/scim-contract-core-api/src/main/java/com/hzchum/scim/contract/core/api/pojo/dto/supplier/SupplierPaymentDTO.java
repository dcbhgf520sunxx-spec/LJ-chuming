package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("付款表dto")
public class SupplierPaymentDTO {
   @ApiModelProperty(name = "id", value = "付款表id")
   private Long id;
   @ApiModelProperty("订单id ")
   private Long orderId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("订单编号")
   private String serialNumber;
   @JsonInclude(Include.NON_EMPTY)
   @ApiModelProperty("订单列表")
   private List<String> serialNumberList;
   @JsonInclude(Include.NON_EMPTY)
   @ApiModelProperty("项目名称列表")
   private List<String> projectNameList;
   @ApiModelProperty("属性 1采购费 2物流费")
   private Integer propertyType;
   @ApiModelProperty("付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty("付款单位")
   private String paymentUnit;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("收款单位id")
   private Long receivingUnitId;
   @ApiModelProperty("收款单位")
   private String receivingUnit;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("违约金额")
   private BigDecimal breachAmount;
   @ApiModelProperty("是否扣除")
   private Boolean boolDeduct;
   @ApiModelProperty("付款事由id")
   private String paymentReasonId;
   @ApiModelProperty("付款事由名称")
   private String paymentReasonName;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款方式 1对公转账 2对私转账 4承兑汇票 8转账支票")
   private Integer paymentMethod;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("付款详情列表")
   List<SupplierPaymentDetailDTO> paymentDetails;
   @ApiModelProperty("审核人id")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回")
   private Integer auditStatus;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;

   public static SupplierPaymentDTO.SupplierPaymentDTOBuilder builder() {
      return new SupplierPaymentDTO.SupplierPaymentDTOBuilder();
   }

   public SupplierPaymentDTO() {
   }

   public SupplierPaymentDTO(
      final Long id,
      final Long orderId,
      final String serialNumber,
      final List<String> serialNumberList,
      final List<String> projectNameList,
      final Integer propertyType,
      final Long paymentUnitId,
      final String paymentUnit,
      final String paymentBank,
      final String paymentBankAccount,
      final Long receivingUnitId,
      final String receivingUnit,
      final String receiveBank,
      final String receiveBankAccount,
      final BigDecimal applyAmount,
      final BigDecimal breachAmount,
      final Boolean boolDeduct,
      final String paymentReasonId,
      final String paymentReasonName,
      final LocalDate paymentDate,
      final Long applyUserId,
      final String applyUserName,
      final List<AttachmentDTO> attachments,
      final String remark,
      final BigDecimal actuallyPaymentAmount,
      final Integer paymentMethod,
      final List<SupplierPaymentDetailDTO> paymentDetails,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.orderId = orderId;
      this.serialNumber = serialNumber;
      this.serialNumberList = serialNumberList;
      this.projectNameList = projectNameList;
      this.propertyType = propertyType;
      this.paymentUnitId = paymentUnitId;
      this.paymentUnit = paymentUnit;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.receivingUnitId = receivingUnitId;
      this.receivingUnit = receivingUnit;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.applyAmount = applyAmount;
      this.breachAmount = breachAmount;
      this.boolDeduct = boolDeduct;
      this.paymentReasonId = paymentReasonId;
      this.paymentReasonName = paymentReasonName;
      this.paymentDate = paymentDate;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.attachments = attachments;
      this.remark = remark;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.paymentMethod = paymentMethod;
      this.paymentDetails = paymentDetails;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<String> getSerialNumberList() {
      return this.serialNumberList;
   }

   public List<String> getProjectNameList() {
      return this.projectNameList;
   }

   public Integer getPropertyType() {
      return this.propertyType;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
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

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getBreachAmount() {
      return this.breachAmount;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public String getPaymentReasonName() {
      return this.paymentReasonName;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public Integer getPaymentMethod() {
      return this.paymentMethod;
   }

   public List<SupplierPaymentDetailDTO> getPaymentDetails() {
      return this.paymentDetails;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberList(final List<String> serialNumberList) {
      this.serialNumberList = serialNumberList;
   }

   public void setProjectNameList(final List<String> projectNameList) {
      this.projectNameList = projectNameList;
   }

   public void setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
   }

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
   }

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
   }

   public void setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
   }

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setPaymentReasonName(final String paymentReasonName) {
      this.paymentReasonName = paymentReasonName;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public void setPaymentMethod(final Integer paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setPaymentDetails(final List<SupplierPaymentDetailDTO> paymentDetails) {
      this.paymentDetails = paymentDetails;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentDTO)) {
         return false;
      }

      SupplierPaymentDTO other = (SupplierPaymentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$propertyType = this.getPropertyType();
            Object other$propertyType = other.getPropertyType();
            if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
               Object this$paymentUnitId = this.getPaymentUnitId();
               Object other$paymentUnitId = other.getPaymentUnitId();
               if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
                  Object this$receivingUnitId = this.getReceivingUnitId();
                  Object other$receivingUnitId = other.getReceivingUnitId();
                  if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
                     Object this$boolDeduct = this.getBoolDeduct();
                     Object other$boolDeduct = other.getBoolDeduct();
                     if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
                        Object this$applyUserId = this.getApplyUserId();
                        Object other$applyUserId = other.getApplyUserId();
                        if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                           Object this$paymentMethod = this.getPaymentMethod();
                           Object other$paymentMethod = other.getPaymentMethod();
                           if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
                              Object this$auditUserId = this.getAuditUserId();
                              Object other$auditUserId = other.getAuditUserId();
                              if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$serialNumberList = this.getSerialNumberList();
                                       Object other$serialNumberList = other.getSerialNumberList();
                                       if (this$serialNumberList == null
                                          ? other$serialNumberList == null
                                          : this$serialNumberList.equals(other$serialNumberList)) {
                                          Object this$projectNameList = this.getProjectNameList();
                                          Object other$projectNameList = other.getProjectNameList();
                                          if (this$projectNameList == null ? other$projectNameList == null : this$projectNameList.equals(other$projectNameList)
                                             )
                                           {
                                             Object this$paymentUnit = this.getPaymentUnit();
                                             Object other$paymentUnit = other.getPaymentUnit();
                                             if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                                                Object this$paymentBank = this.getPaymentBank();
                                                Object other$paymentBank = other.getPaymentBank();
                                                if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                                                   Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                   Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                   if (this$paymentBankAccount == null
                                                      ? other$paymentBankAccount == null
                                                      : this$paymentBankAccount.equals(other$paymentBankAccount)) {
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
                                                               Object this$applyAmount = this.getApplyAmount();
                                                               Object other$applyAmount = other.getApplyAmount();
                                                               if (this$applyAmount == null
                                                                  ? other$applyAmount == null
                                                                  : this$applyAmount.equals(other$applyAmount)) {
                                                                  Object this$breachAmount = this.getBreachAmount();
                                                                  Object other$breachAmount = other.getBreachAmount();
                                                                  if (this$breachAmount == null
                                                                     ? other$breachAmount == null
                                                                     : this$breachAmount.equals(other$breachAmount)) {
                                                                     Object this$paymentReasonId = this.getPaymentReasonId();
                                                                     Object other$paymentReasonId = other.getPaymentReasonId();
                                                                     if (this$paymentReasonId == null
                                                                        ? other$paymentReasonId == null
                                                                        : this$paymentReasonId.equals(other$paymentReasonId)) {
                                                                        Object this$paymentReasonName = this.getPaymentReasonName();
                                                                        Object other$paymentReasonName = other.getPaymentReasonName();
                                                                        if (this$paymentReasonName == null
                                                                           ? other$paymentReasonName == null
                                                                           : this$paymentReasonName.equals(other$paymentReasonName)) {
                                                                           Object this$paymentDate = this.getPaymentDate();
                                                                           Object other$paymentDate = other.getPaymentDate();
                                                                           if (this$paymentDate == null
                                                                              ? other$paymentDate == null
                                                                              : this$paymentDate.equals(other$paymentDate)) {
                                                                              Object this$applyUserName = this.getApplyUserName();
                                                                              Object other$applyUserName = other.getApplyUserName();
                                                                              if (this$applyUserName == null
                                                                                 ? other$applyUserName == null
                                                                                 : this$applyUserName.equals(other$applyUserName)) {
                                                                                 Object this$attachments = this.getAttachments();
                                                                                 Object other$attachments = other.getAttachments();
                                                                                 if (this$attachments == null
                                                                                    ? other$attachments == null
                                                                                    : this$attachments.equals(other$attachments)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                                                                       Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                                                                       if (this$actuallyPaymentAmount == null
                                                                                          ? other$actuallyPaymentAmount == null
                                                                                          : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount)) {
                                                                                          Object this$paymentDetails = this.getPaymentDetails();
                                                                                          Object other$paymentDetails = other.getPaymentDetails();
                                                                                          if (this$paymentDetails == null
                                                                                             ? other$paymentDetails == null
                                                                                             : this$paymentDetails.equals(other$paymentDetails)) {
                                                                                             Object this$auditUserName = this.getAuditUserName();
                                                                                             Object other$auditUserName = other.getAuditUserName();
                                                                                             if (this$auditUserName == null
                                                                                                ? other$auditUserName == null
                                                                                                : this$auditUserName.equals(other$auditUserName)) {
                                                                                                Object this$auditTime = this.getAuditTime();
                                                                                                Object other$auditTime = other.getAuditTime();
                                                                                                if (this$auditTime == null
                                                                                                   ? other$auditTime == null
                                                                                                   : this$auditTime.equals(other$auditTime)) {
                                                                                                   Object this$createTime = this.getCreateTime();
                                                                                                   Object other$createTime = other.getCreateTime();
                                                                                                   return this$createTime == null
                                                                                                      ? other$createTime == null
                                                                                                      : this$createTime.equals(other$createTime);
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
      return other instanceof SupplierPaymentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberList = this.getSerialNumberList();
      result = result * 59 + ($serialNumberList == null ? 43 : $serialNumberList.hashCode());
      Object $projectNameList = this.getProjectNameList();
      result = result * 59 + ($projectNameList == null ? 43 : $projectNameList.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentReasonName = this.getPaymentReasonName();
      result = result * 59 + ($paymentReasonName == null ? 43 : $paymentReasonName.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $paymentDetails = this.getPaymentDetails();
      result = result * 59 + ($paymentDetails == null ? 43 : $paymentDetails.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentDTO(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberList="
         + this.getSerialNumberList()
         + ", projectNameList="
         + this.getProjectNameList()
         + ", propertyType="
         + this.getPropertyType()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", breachAmount="
         + this.getBreachAmount()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentReasonName="
         + this.getPaymentReasonName()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", paymentDetails="
         + this.getPaymentDetails()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class SupplierPaymentDTOBuilder {
      private Long id;
      private Long orderId;
      private String serialNumber;
      private List<String> serialNumberList;
      private List<String> projectNameList;
      private Integer propertyType;
      private Long paymentUnitId;
      private String paymentUnit;
      private String paymentBank;
      private String paymentBankAccount;
      private Long receivingUnitId;
      private String receivingUnit;
      private String receiveBank;
      private String receiveBankAccount;
      private BigDecimal applyAmount;
      private BigDecimal breachAmount;
      private Boolean boolDeduct;
      private String paymentReasonId;
      private String paymentReasonName;
      private LocalDate paymentDate;
      private Long applyUserId;
      private String applyUserName;
      private List<AttachmentDTO> attachments;
      private String remark;
      private BigDecimal actuallyPaymentAmount;
      private Integer paymentMethod;
      private List<SupplierPaymentDetailDTO> paymentDetails;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private LocalDateTime createTime;

      SupplierPaymentDTOBuilder() {
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder serialNumberList(final List<String> serialNumberList) {
         this.serialNumberList = serialNumberList;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder projectNameList(final List<String> projectNameList) {
         this.projectNameList = projectNameList;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder propertyType(final Integer propertyType) {
         this.propertyType = propertyType;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder receivingUnitId(final Long receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder receivingUnit(final String receivingUnit) {
         this.receivingUnit = receivingUnit;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder receiveBank(final String receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder breachAmount(final BigDecimal breachAmount) {
         this.breachAmount = breachAmount;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder boolDeduct(final Boolean boolDeduct) {
         this.boolDeduct = boolDeduct;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentReasonId(final String paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentReasonName(final String paymentReasonName) {
         this.paymentReasonName = paymentReasonName;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentDate(final LocalDate paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentMethod(final Integer paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder paymentDetails(final List<SupplierPaymentDetailDTO> paymentDetails) {
         this.paymentDetails = paymentDetails;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierPaymentDTO.SupplierPaymentDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierPaymentDTO build() {
         return new SupplierPaymentDTO(
            this.id,
            this.orderId,
            this.serialNumber,
            this.serialNumberList,
            this.projectNameList,
            this.propertyType,
            this.paymentUnitId,
            this.paymentUnit,
            this.paymentBank,
            this.paymentBankAccount,
            this.receivingUnitId,
            this.receivingUnit,
            this.receiveBank,
            this.receiveBankAccount,
            this.applyAmount,
            this.breachAmount,
            this.boolDeduct,
            this.paymentReasonId,
            this.paymentReasonName,
            this.paymentDate,
            this.applyUserId,
            this.applyUserName,
            this.attachments,
            this.remark,
            this.actuallyPaymentAmount,
            this.paymentMethod,
            this.paymentDetails,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentDTO.SupplierPaymentDTOBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberList="
            + this.serialNumberList
            + ", projectNameList="
            + this.projectNameList
            + ", propertyType="
            + this.propertyType
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", receivingUnit="
            + this.receivingUnit
            + ", receiveBank="
            + this.receiveBank
            + ", receiveBankAccount="
            + this.receiveBankAccount
            + ", applyAmount="
            + this.applyAmount
            + ", breachAmount="
            + this.breachAmount
            + ", boolDeduct="
            + this.boolDeduct
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", paymentReasonName="
            + this.paymentReasonName
            + ", paymentDate="
            + this.paymentDate
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ", paymentMethod="
            + this.paymentMethod
            + ", paymentDetails="
            + this.paymentDetails
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
