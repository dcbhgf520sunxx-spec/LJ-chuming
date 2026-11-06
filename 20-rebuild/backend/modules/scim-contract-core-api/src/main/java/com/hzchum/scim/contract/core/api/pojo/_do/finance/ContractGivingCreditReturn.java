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

@ApiModel(value = "ContractGivingCreditReturn对象", description = "授信还款表 ")
@Entity
@TableName("contract_giving_credit_return")
@Table(name = "contract_giving_credit_return")
@org.hibernate.annotations.Table(appliesTo = "contract_giving_credit_return", comment = "授信还款表 ")
public class ContractGivingCreditReturn extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "givingCreditDetailId", value = "授信使用明细id", notes = "授信使用明细id")
   @TableField("giving_credit_detail_id")
   @Column(name = "giving_credit_detail_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '授信使用明细id'", nullable = false)
   private Long givingCreditDetailId;
   @ApiModelProperty(name = "collectionId", value = "收款id", notes = "收款id")
   @TableField("collection_id")
   @Column(name = "collection_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '收款id'", nullable = false)
   private Long collectionId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) DEFAULT 0 comment '项目属性: 1.自营 2.合营 3.包干制'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "project_manager_id", notes = "项目经理id")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20) DEFAULT 0 comment '项目经理id' ", nullable = false)
   private Long projectManagerId;
   @ApiModelProperty(name = "returnTime", value = "还款时间", notes = "还款时间")
   @TableField("return_time")
   @Column(name = "return_time", columnDefinition = "datetime(6)  COMMENT '还款时间'", nullable = false)
   private LocalDateTime returnTime;
   @ApiModelProperty(name = "principalAmount", value = "还款本金额", notes = "还款本金额")
   @TableField("principal_amount")
   @Column(name = "principal_amount", columnDefinition = "decimal(32,4)  COMMENT '还款本金额'", nullable = false)
   private BigDecimal principalAmount;
   @ApiModelProperty(name = "interestAmount", value = "还款利息额", notes = "还款利息额")
   @TableField("interest_amount")
   @Column(name = "interest_amount", columnDefinition = "decimal(32,4)  COMMENT '还款利息额'", nullable = false)
   private BigDecimal interestAmount;
   @ApiModelProperty(name = "amount", value = "还款总金额 (还款本金+还款利息)", notes = "还款总金额 (还款本金+还款利息)")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,4)  COMMENT '还款总金额 (还款本金+还款利息)'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "auditStatus", value = "收款审批状态：1 待审核 2 通过 4 不通过", notes = "收款审批状态：1 待审核 2 通过 4 不通过")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11)  COMMENT '收款审批状态 审批状态：1 待审核 2 通过 4 不通过'", nullable = false)
   private Integer auditStatus;

   public static ContractGivingCreditReturn.ContractGivingCreditReturnBuilder builder() {
      return new ContractGivingCreditReturn.ContractGivingCreditReturnBuilder();
   }

   public ContractGivingCreditReturn() {
   }

   public ContractGivingCreditReturn(
      final Long id,
      final Long givingCreditDetailId,
      final Long collectionId,
      final Long projectId,
      final Integer projectAttribute,
      final Long projectManagerId,
      final LocalDateTime returnTime,
      final BigDecimal principalAmount,
      final BigDecimal interestAmount,
      final BigDecimal amount,
      final Integer auditStatus
   ) {
      this.id = id;
      this.givingCreditDetailId = givingCreditDetailId;
      this.collectionId = collectionId;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.projectManagerId = projectManagerId;
      this.returnTime = returnTime;
      this.principalAmount = principalAmount;
      this.interestAmount = interestAmount;
      this.amount = amount;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGivingCreditDetailId() {
      return this.givingCreditDetailId;
   }

   public Long getCollectionId() {
      return this.collectionId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public BigDecimal getPrincipalAmount() {
      return this.principalAmount;
   }

   public BigDecimal getInterestAmount() {
      return this.interestAmount;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public ContractGivingCreditReturn setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditReturn setGivingCreditDetailId(final Long givingCreditDetailId) {
      this.givingCreditDetailId = givingCreditDetailId;
      return this;
   }

   public ContractGivingCreditReturn setCollectionId(final Long collectionId) {
      this.collectionId = collectionId;
      return this;
   }

   public ContractGivingCreditReturn setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCreditReturn setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ContractGivingCreditReturn setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractGivingCreditReturn setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
      return this;
   }

   public ContractGivingCreditReturn setPrincipalAmount(final BigDecimal principalAmount) {
      this.principalAmount = principalAmount;
      return this;
   }

   public ContractGivingCreditReturn setInterestAmount(final BigDecimal interestAmount) {
      this.interestAmount = interestAmount;
      return this;
   }

   public ContractGivingCreditReturn setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ContractGivingCreditReturn setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractGivingCreditReturn(id="
         + this.getId()
         + ", givingCreditDetailId="
         + this.getGivingCreditDetailId()
         + ", collectionId="
         + this.getCollectionId()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", returnTime="
         + this.getReturnTime()
         + ", principalAmount="
         + this.getPrincipalAmount()
         + ", interestAmount="
         + this.getInterestAmount()
         + ", amount="
         + this.getAmount()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditReturn)) {
         return false;
      }

      ContractGivingCreditReturn other = (ContractGivingCreditReturn)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$givingCreditDetailId = this.getGivingCreditDetailId();
         Object other$givingCreditDetailId = other.getGivingCreditDetailId();
         if (this$givingCreditDetailId == null ? other$givingCreditDetailId == null : this$givingCreditDetailId.equals(other$givingCreditDetailId)) {
            Object this$collectionId = this.getCollectionId();
            Object other$collectionId = other.getCollectionId();
            if (this$collectionId == null ? other$collectionId == null : this$collectionId.equals(other$collectionId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectAttribute = this.getProjectAttribute();
                  Object other$projectAttribute = other.getProjectAttribute();
                  if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$returnTime = this.getReturnTime();
                           Object other$returnTime = other.getReturnTime();
                           if (this$returnTime == null ? other$returnTime == null : this$returnTime.equals(other$returnTime)) {
                              Object this$principalAmount = this.getPrincipalAmount();
                              Object other$principalAmount = other.getPrincipalAmount();
                              if (this$principalAmount == null ? other$principalAmount == null : this$principalAmount.equals(other$principalAmount)) {
                                 Object this$interestAmount = this.getInterestAmount();
                                 Object other$interestAmount = other.getInterestAmount();
                                 if (this$interestAmount == null ? other$interestAmount == null : this$interestAmount.equals(other$interestAmount)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
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
      return other instanceof ContractGivingCreditReturn;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $givingCreditDetailId = this.getGivingCreditDetailId();
      result = result * 59 + ($givingCreditDetailId == null ? 43 : $givingCreditDetailId.hashCode());
      Object $collectionId = this.getCollectionId();
      result = result * 59 + ($collectionId == null ? 43 : $collectionId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $principalAmount = this.getPrincipalAmount();
      result = result * 59 + ($principalAmount == null ? 43 : $principalAmount.hashCode());
      Object $interestAmount = this.getInterestAmount();
      result = result * 59 + ($interestAmount == null ? 43 : $interestAmount.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   public static class ContractGivingCreditReturnBuilder {
      private Long id;
      private Long givingCreditDetailId;
      private Long collectionId;
      private Long projectId;
      private Integer projectAttribute;
      private Long projectManagerId;
      private LocalDateTime returnTime;
      private BigDecimal principalAmount;
      private BigDecimal interestAmount;
      private BigDecimal amount;
      private Integer auditStatus;

      ContractGivingCreditReturnBuilder() {
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder givingCreditDetailId(final Long givingCreditDetailId) {
         this.givingCreditDetailId = givingCreditDetailId;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder collectionId(final Long collectionId) {
         this.collectionId = collectionId;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder principalAmount(final BigDecimal principalAmount) {
         this.principalAmount = principalAmount;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder interestAmount(final BigDecimal interestAmount) {
         this.interestAmount = interestAmount;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractGivingCreditReturn.ContractGivingCreditReturnBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractGivingCreditReturn build() {
         return new ContractGivingCreditReturn(
            this.id,
            this.givingCreditDetailId,
            this.collectionId,
            this.projectId,
            this.projectAttribute,
            this.projectManagerId,
            this.returnTime,
            this.principalAmount,
            this.interestAmount,
            this.amount,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditReturn.ContractGivingCreditReturnBuilder(id="
            + this.id
            + ", givingCreditDetailId="
            + this.givingCreditDetailId
            + ", collectionId="
            + this.collectionId
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", projectManagerId="
            + this.projectManagerId
            + ", returnTime="
            + this.returnTime
            + ", principalAmount="
            + this.principalAmount
            + ", interestAmount="
            + this.interestAmount
            + ", amount="
            + this.amount
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
