package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractProjectAssetInjection对象", description = "内包/合营合同-注资收支记录表")
@Entity
@TableName("contract_project_asset_injection")
@Table(name = "contract_project_asset_injection")
@org.hibernate.annotations.Table(appliesTo = "contract_project_asset_injection", comment = "内包/合营合同-注资收支记录表 ")
public class ContractProjectAssetInjection extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assetInjectionTime", value = "注资日期", notes = "注资日期")
   @TableField("asset_injection_time")
   @Column(name = "asset_injection_time", columnDefinition = "datetime(6)  COMMENT '注资日期'", nullable = false)
   private LocalDateTime assetInjectionTime;
   @ApiModelProperty(name = "assetType", value = "资金类型 AssetTypeEnum 1公司资金 2项目经理资金", notes = "1公司资金 2项目经理资金")
   @TableField("asset_type")
   @Column(name = "asset_type", columnDefinition = "int(11) DEFAULT 0 COMMENT '注资类型 1公司资金 2项目经理资金'", nullable = false)
   private Integer assetType;
   @ApiModelProperty(name = "assetAmount", value = "金额", notes = "金额")
   @TableField("asset_amount")
   @Column(name = "asset_amount", columnDefinition = "decimal(32,4) COMMENT '金额'", nullable = false)
   private BigDecimal assetAmount;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "assetOwnerId", value = "资产所有者id(签订主体或项目经理id)", notes = "资产所有者id(签订主体或项目经理id)")
   @TableField("asset_owner_id")
   @Column(name = "asset_owner_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '资产所有者id(签订主体或项目经理id)'", nullable = false)
   private Long assetOwnerId;
   @ApiModelProperty(name = "contractSignBodyId", value = "签约主体id", notes = "签约主体id")
   @TableField("contract_sign_body_id")
   @Column(name = "contract_sign_body_id", columnDefinition = "bigint(20)  COMMENT '签约主体id'")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyScale", value = "签约主体注资", notes = "签约主体注资")
   @TableField("contract_sign_body_scale")
   @Column(name = "contract_sign_body_scale", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '签约主体注资'", nullable = false)
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理id'")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerScale", value = "项目经理注资", notes = "项目经理注资")
   @TableField("project_manager_scale")
   @Column(name = "project_manager_scale", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '项目经理注资'", nullable = false)
   private BigDecimal projectManagerScale;
   @ApiModelProperty(name = "assetInjectionEnum", value = "注资类型 INJECTION_TYPE", notes = "注资类型INJECTION_TYPE")
   @TableField("asset_injection_enum")
   @Column(name = "asset_injection_enum", columnDefinition = "varchar(255)  COMMENT '注资类型INJECTION_TYPE'", nullable = true)
   private String assetInjectionEnum;
   @ApiModelProperty(name = "disburseEnum", value = "支出类型", notes = "支出类型")
   @TableField("disburse_enum")
   @Column(name = "disburse_enum", columnDefinition = "int(11)  COMMENT '支出类型'", nullable = true)
   private Integer disburseEnum;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款银行", notes = "收款银行")
   @TableField("collection_deposit_bank")
   @Column(name = "collection_deposit_bank", columnDefinition = "varchar(255)  COMMENT '收款银行'", nullable = true)
   private String collectionDepositBank;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id字符串")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "varchar(255)  COMMENT '附件id'", nullable = true)
   private String attachmentId;
   @ApiModelProperty(name = "incomeOrDisburse", value = "收入支出: true收入 false支出", notes = "收入支出: true收入 false支出")
   @TableField("income_or_disburse")
   @Column(name = "income_or_disburse", columnDefinition = "tinyint(1)  DEFAULT 1 COMMENT '收入支出 1收入 0支出'", nullable = false)
   private Boolean incomeOrDisburse;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "paymentId", value = "付款id", notes = "付款id")
   @TableField("payment_id")
   @Column(name = "payment_id", columnDefinition = "bigint(20)  COMMENT '付款id'")
   private Long paymentId;
   @ApiModelProperty(name = "creatorUserId", value = "填报人id", notes = "填报人id")
   @TableField("creator_user_id")
   @Column(name = "creator_user_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '填报人id'", nullable = false)
   private Long creatorUserId;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   @TableField("voucher_number")
   @Column(name = "voucher_number", columnDefinition = "varchar(128) default '0' comment '凭证号'", nullable = false)
   private String voucherNumber;
   @ApiModelProperty(name = "residualAmount", value = "剩余金额", notes = "剩余金额")
   @TableField("residual_amount")
   @Column(name = "residual_amount", columnDefinition = "decimal(32,8)  COMMENT '剩余金额'", nullable = true)
   private BigDecimal residualAmount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "auditStatus", value = "审批状态：1 待审核 2 通过 4 不通过", notes = "审批状态：1 待审核 2 通过 4 不通过")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) DEFAULT 1 COMMENT '审批状态 审批状态：1 待审核 2 通过 4 不通过'", nullable = false)
   private Integer auditStatus;

   public static ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder builder() {
      return new ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder();
   }

   public ContractProjectAssetInjection() {
   }

   public ContractProjectAssetInjection(
      final Long id,
      final LocalDateTime assetInjectionTime,
      final Integer assetType,
      final BigDecimal assetAmount,
      final Long projectId,
      final Long assetOwnerId,
      final Long contractSignBodyId,
      final BigDecimal contractSignBodyScale,
      final Long projectManagerId,
      final BigDecimal projectManagerScale,
      final String assetInjectionEnum,
      final Integer disburseEnum,
      final String collectionDepositBank,
      final String attachmentId,
      final Boolean incomeOrDisburse,
      final Long userId,
      final Long paymentId,
      final Long creatorUserId,
      final String voucherNumber,
      final BigDecimal residualAmount,
      final String remark,
      final Integer auditStatus
   ) {
      this.id = id;
      this.assetInjectionTime = assetInjectionTime;
      this.assetType = assetType;
      this.assetAmount = assetAmount;
      this.projectId = projectId;
      this.assetOwnerId = assetOwnerId;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyScale = contractSignBodyScale;
      this.projectManagerId = projectManagerId;
      this.projectManagerScale = projectManagerScale;
      this.assetInjectionEnum = assetInjectionEnum;
      this.disburseEnum = disburseEnum;
      this.collectionDepositBank = collectionDepositBank;
      this.attachmentId = attachmentId;
      this.incomeOrDisburse = incomeOrDisburse;
      this.userId = userId;
      this.paymentId = paymentId;
      this.creatorUserId = creatorUserId;
      this.voucherNumber = voucherNumber;
      this.residualAmount = residualAmount;
      this.remark = remark;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getAssetInjectionTime() {
      return this.assetInjectionTime;
   }

   public Integer getAssetType() {
      return this.assetType;
   }

   public BigDecimal getAssetAmount() {
      return this.assetAmount;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAssetOwnerId() {
      return this.assetOwnerId;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public String getAssetInjectionEnum() {
      return this.assetInjectionEnum;
   }

   public Integer getDisburseEnum() {
      return this.disburseEnum;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public String getAttachmentId() {
      return this.attachmentId;
   }

   public Boolean getIncomeOrDisburse() {
      return this.incomeOrDisburse;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public Long getCreatorUserId() {
      return this.creatorUserId;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public BigDecimal getResidualAmount() {
      return this.residualAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public ContractProjectAssetInjection setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractProjectAssetInjection setAssetInjectionTime(final LocalDateTime assetInjectionTime) {
      this.assetInjectionTime = assetInjectionTime;
      return this;
   }

   public ContractProjectAssetInjection setAssetType(final Integer assetType) {
      this.assetType = assetType;
      return this;
   }

   public ContractProjectAssetInjection setAssetAmount(final BigDecimal assetAmount) {
      this.assetAmount = assetAmount;
      return this;
   }

   public ContractProjectAssetInjection setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectAssetInjection setAssetOwnerId(final Long assetOwnerId) {
      this.assetOwnerId = assetOwnerId;
      return this;
   }

   public ContractProjectAssetInjection setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   public ContractProjectAssetInjection setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
      return this;
   }

   public ContractProjectAssetInjection setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProjectAssetInjection setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
      return this;
   }

   public ContractProjectAssetInjection setAssetInjectionEnum(final String assetInjectionEnum) {
      this.assetInjectionEnum = assetInjectionEnum;
      return this;
   }

   public ContractProjectAssetInjection setDisburseEnum(final Integer disburseEnum) {
      this.disburseEnum = disburseEnum;
      return this;
   }

   public ContractProjectAssetInjection setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
      return this;
   }

   public ContractProjectAssetInjection setAttachmentId(final String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ContractProjectAssetInjection setIncomeOrDisburse(final Boolean incomeOrDisburse) {
      this.incomeOrDisburse = incomeOrDisburse;
      return this;
   }

   public ContractProjectAssetInjection setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractProjectAssetInjection setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
      return this;
   }

   public ContractProjectAssetInjection setCreatorUserId(final Long creatorUserId) {
      this.creatorUserId = creatorUserId;
      return this;
   }

   public ContractProjectAssetInjection setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractProjectAssetInjection setResidualAmount(final BigDecimal residualAmount) {
      this.residualAmount = residualAmount;
      return this;
   }

   public ContractProjectAssetInjection setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractProjectAssetInjection setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectAssetInjection(id="
         + this.getId()
         + ", assetInjectionTime="
         + this.getAssetInjectionTime()
         + ", assetType="
         + this.getAssetType()
         + ", assetAmount="
         + this.getAssetAmount()
         + ", projectId="
         + this.getProjectId()
         + ", assetOwnerId="
         + this.getAssetOwnerId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ", assetInjectionEnum="
         + this.getAssetInjectionEnum()
         + ", disburseEnum="
         + this.getDisburseEnum()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", incomeOrDisburse="
         + this.getIncomeOrDisburse()
         + ", userId="
         + this.getUserId()
         + ", paymentId="
         + this.getPaymentId()
         + ", creatorUserId="
         + this.getCreatorUserId()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", residualAmount="
         + this.getResidualAmount()
         + ", remark="
         + this.getRemark()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectAssetInjection)) {
         return false;
      }

      ContractProjectAssetInjection other = (ContractProjectAssetInjection)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assetType = this.getAssetType();
         Object other$assetType = other.getAssetType();
         if (this$assetType == null ? other$assetType == null : this$assetType.equals(other$assetType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$assetOwnerId = this.getAssetOwnerId();
               Object other$assetOwnerId = other.getAssetOwnerId();
               if (this$assetOwnerId == null ? other$assetOwnerId == null : this$assetOwnerId.equals(other$assetOwnerId)) {
                  Object this$contractSignBodyId = this.getContractSignBodyId();
                  Object other$contractSignBodyId = other.getContractSignBodyId();
                  if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$disburseEnum = this.getDisburseEnum();
                        Object other$disburseEnum = other.getDisburseEnum();
                        if (this$disburseEnum == null ? other$disburseEnum == null : this$disburseEnum.equals(other$disburseEnum)) {
                           Object this$incomeOrDisburse = this.getIncomeOrDisburse();
                           Object other$incomeOrDisburse = other.getIncomeOrDisburse();
                           if (this$incomeOrDisburse == null ? other$incomeOrDisburse == null : this$incomeOrDisburse.equals(other$incomeOrDisburse)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$paymentId = this.getPaymentId();
                                 Object other$paymentId = other.getPaymentId();
                                 if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
                                    Object this$creatorUserId = this.getCreatorUserId();
                                    Object other$creatorUserId = other.getCreatorUserId();
                                    if (this$creatorUserId == null ? other$creatorUserId == null : this$creatorUserId.equals(other$creatorUserId)) {
                                       Object this$auditStatus = this.getAuditStatus();
                                       Object other$auditStatus = other.getAuditStatus();
                                       if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                          Object this$assetInjectionTime = this.getAssetInjectionTime();
                                          Object other$assetInjectionTime = other.getAssetInjectionTime();
                                          if (this$assetInjectionTime == null
                                             ? other$assetInjectionTime == null
                                             : this$assetInjectionTime.equals(other$assetInjectionTime)) {
                                             Object this$assetAmount = this.getAssetAmount();
                                             Object other$assetAmount = other.getAssetAmount();
                                             if (this$assetAmount == null ? other$assetAmount == null : this$assetAmount.equals(other$assetAmount)) {
                                                Object this$contractSignBodyScale = this.getContractSignBodyScale();
                                                Object other$contractSignBodyScale = other.getContractSignBodyScale();
                                                if (this$contractSignBodyScale == null
                                                   ? other$contractSignBodyScale == null
                                                   : this$contractSignBodyScale.equals(other$contractSignBodyScale)) {
                                                   Object this$projectManagerScale = this.getProjectManagerScale();
                                                   Object other$projectManagerScale = other.getProjectManagerScale();
                                                   if (this$projectManagerScale == null
                                                      ? other$projectManagerScale == null
                                                      : this$projectManagerScale.equals(other$projectManagerScale)) {
                                                      Object this$assetInjectionEnum = this.getAssetInjectionEnum();
                                                      Object other$assetInjectionEnum = other.getAssetInjectionEnum();
                                                      if (this$assetInjectionEnum == null
                                                         ? other$assetInjectionEnum == null
                                                         : this$assetInjectionEnum.equals(other$assetInjectionEnum)) {
                                                         Object this$collectionDepositBank = this.getCollectionDepositBank();
                                                         Object other$collectionDepositBank = other.getCollectionDepositBank();
                                                         if (this$collectionDepositBank == null
                                                            ? other$collectionDepositBank == null
                                                            : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                                            Object this$attachmentId = this.getAttachmentId();
                                                            Object other$attachmentId = other.getAttachmentId();
                                                            if (this$attachmentId == null
                                                               ? other$attachmentId == null
                                                               : this$attachmentId.equals(other$attachmentId)) {
                                                               Object this$voucherNumber = this.getVoucherNumber();
                                                               Object other$voucherNumber = other.getVoucherNumber();
                                                               if (this$voucherNumber == null
                                                                  ? other$voucherNumber == null
                                                                  : this$voucherNumber.equals(other$voucherNumber)) {
                                                                  Object this$residualAmount = this.getResidualAmount();
                                                                  Object other$residualAmount = other.getResidualAmount();
                                                                  if (this$residualAmount == null
                                                                     ? other$residualAmount == null
                                                                     : this$residualAmount.equals(other$residualAmount)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectAssetInjection;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assetType = this.getAssetType();
      result = result * 59 + ($assetType == null ? 43 : $assetType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $assetOwnerId = this.getAssetOwnerId();
      result = result * 59 + ($assetOwnerId == null ? 43 : $assetOwnerId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $disburseEnum = this.getDisburseEnum();
      result = result * 59 + ($disburseEnum == null ? 43 : $disburseEnum.hashCode());
      Object $incomeOrDisburse = this.getIncomeOrDisburse();
      result = result * 59 + ($incomeOrDisburse == null ? 43 : $incomeOrDisburse.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $creatorUserId = this.getCreatorUserId();
      result = result * 59 + ($creatorUserId == null ? 43 : $creatorUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $assetInjectionTime = this.getAssetInjectionTime();
      result = result * 59 + ($assetInjectionTime == null ? 43 : $assetInjectionTime.hashCode());
      Object $assetAmount = this.getAssetAmount();
      result = result * 59 + ($assetAmount == null ? 43 : $assetAmount.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      result = result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
      Object $assetInjectionEnum = this.getAssetInjectionEnum();
      result = result * 59 + ($assetInjectionEnum == null ? 43 : $assetInjectionEnum.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $residualAmount = this.getResidualAmount();
      result = result * 59 + ($residualAmount == null ? 43 : $residualAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractProjectAssetInjectionBuilder {
      private Long id;
      private LocalDateTime assetInjectionTime;
      private Integer assetType;
      private BigDecimal assetAmount;
      private Long projectId;
      private Long assetOwnerId;
      private Long contractSignBodyId;
      private BigDecimal contractSignBodyScale;
      private Long projectManagerId;
      private BigDecimal projectManagerScale;
      private String assetInjectionEnum;
      private Integer disburseEnum;
      private String collectionDepositBank;
      private String attachmentId;
      private Boolean incomeOrDisburse;
      private Long userId;
      private Long paymentId;
      private Long creatorUserId;
      private String voucherNumber;
      private BigDecimal residualAmount;
      private String remark;
      private Integer auditStatus;

      ContractProjectAssetInjectionBuilder() {
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder assetInjectionTime(final LocalDateTime assetInjectionTime) {
         this.assetInjectionTime = assetInjectionTime;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder assetType(final Integer assetType) {
         this.assetType = assetType;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder assetAmount(final BigDecimal assetAmount) {
         this.assetAmount = assetAmount;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder assetOwnerId(final Long assetOwnerId) {
         this.assetOwnerId = assetOwnerId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder contractSignBodyScale(final BigDecimal contractSignBodyScale) {
         this.contractSignBodyScale = contractSignBodyScale;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder projectManagerScale(final BigDecimal projectManagerScale) {
         this.projectManagerScale = projectManagerScale;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder assetInjectionEnum(final String assetInjectionEnum) {
         this.assetInjectionEnum = assetInjectionEnum;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder disburseEnum(final Integer disburseEnum) {
         this.disburseEnum = disburseEnum;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder attachmentId(final String attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder incomeOrDisburse(final Boolean incomeOrDisburse) {
         this.incomeOrDisburse = incomeOrDisburse;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder paymentId(final Long paymentId) {
         this.paymentId = paymentId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder creatorUserId(final Long creatorUserId) {
         this.creatorUserId = creatorUserId;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder residualAmount(final BigDecimal residualAmount) {
         this.residualAmount = residualAmount;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractProjectAssetInjection build() {
         return new ContractProjectAssetInjection(
            this.id,
            this.assetInjectionTime,
            this.assetType,
            this.assetAmount,
            this.projectId,
            this.assetOwnerId,
            this.contractSignBodyId,
            this.contractSignBodyScale,
            this.projectManagerId,
            this.projectManagerScale,
            this.assetInjectionEnum,
            this.disburseEnum,
            this.collectionDepositBank,
            this.attachmentId,
            this.incomeOrDisburse,
            this.userId,
            this.paymentId,
            this.creatorUserId,
            this.voucherNumber,
            this.residualAmount,
            this.remark,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "ContractProjectAssetInjection.ContractProjectAssetInjectionBuilder(id="
            + this.id
            + ", assetInjectionTime="
            + this.assetInjectionTime
            + ", assetType="
            + this.assetType
            + ", assetAmount="
            + this.assetAmount
            + ", projectId="
            + this.projectId
            + ", assetOwnerId="
            + this.assetOwnerId
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyScale="
            + this.contractSignBodyScale
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerScale="
            + this.projectManagerScale
            + ", assetInjectionEnum="
            + this.assetInjectionEnum
            + ", disburseEnum="
            + this.disburseEnum
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", attachmentId="
            + this.attachmentId
            + ", incomeOrDisburse="
            + this.incomeOrDisburse
            + ", userId="
            + this.userId
            + ", paymentId="
            + this.paymentId
            + ", creatorUserId="
            + this.creatorUserId
            + ", voucherNumber="
            + this.voucherNumber
            + ", residualAmount="
            + this.residualAmount
            + ", remark="
            + this.remark
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
