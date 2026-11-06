package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractCollectionDisburse对象", description = "项目收款-支出表 ")
@Entity
@TableName("contract_collection_disburse")
@Table(name = "contract_collection_disburse")
@org.hibernate.annotations.Table(appliesTo = "contract_collection_disburse", comment = "项目收款-支出表 ")
public class ContractCollectionDisburse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "应付款项目id", notes = "应付款项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '应付款项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "assetOwnerId", value = "资产所有者id(签订主体id或项目经理id)", notes = "资产所有者id(签订主体id或项目经理id)")
   @TableField("asset_owner_id")
   @Column(name = "asset_owner_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '资产所有者id(签订主体id或项目经理id)'", nullable = false)
   private Long assetOwnerId;
   @ApiModelProperty(name = "assetType", value = "资金类型 AssetTypeEnum 1签订主体资金 2项目经理资金", notes = "1公司资金 2项目经理资金")
   @TableField("asset_type")
   @Column(name = "asset_type", columnDefinition = "int(11) DEFAULT 0 COMMENT '注资类型 1签订主体资金 2项目经理资金'", nullable = false)
   private Integer assetType;
   @ApiModelProperty(name = "useAmount", value = "使用金额", notes = "使用金额")
   @TableField("use_amount")
   @Column(name = "use_amount", columnDefinition = "decimal(32,8)  COMMENT '使用金额'", nullable = false)
   private BigDecimal useAmount;
   @ApiModelProperty(name = "paymentId", value = "付款表id", notes = "付款表id")
   @TableField("payment_id")
   @Column(name = "payment_id", columnDefinition = "bigint  COMMENT '付款表id'", nullable = false)
   private Long paymentId;
   @ApiModelProperty(name = "paymentProjectId", value = "实际付款项目id", notes = "实际付款项目id")
   @TableField("payment_project_id")
   @Column(name = "payment_project_id", columnDefinition = "bigint  COMMENT '实际付款项目id'", nullable = false)
   private Long paymentProjectId;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '创建人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "auditStatus", value = "审批状态：1 待审核 2 通过 4 不通过", notes = "审批状态：1 待审核 2 通过 4 不通过")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) DEFAULT 1 COMMENT '审批状态 审批状态：1 待审核 2 通过 4 不通过'", nullable = false)
   private Integer auditStatus;

   public static ContractCollectionDisburse.ContractCollectionDisburseBuilder builder() {
      return new ContractCollectionDisburse.ContractCollectionDisburseBuilder();
   }

   public ContractCollectionDisburse() {
   }

   public ContractCollectionDisburse(
      final Long id,
      final Long projectId,
      final Long assetOwnerId,
      final Integer assetType,
      final BigDecimal useAmount,
      final Long paymentId,
      final Long paymentProjectId,
      final Long userId,
      final Integer auditStatus
   ) {
      this.id = id;
      this.projectId = projectId;
      this.assetOwnerId = assetOwnerId;
      this.assetType = assetType;
      this.useAmount = useAmount;
      this.paymentId = paymentId;
      this.paymentProjectId = paymentProjectId;
      this.userId = userId;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAssetOwnerId() {
      return this.assetOwnerId;
   }

   public Integer getAssetType() {
      return this.assetType;
   }

   public BigDecimal getUseAmount() {
      return this.useAmount;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public Long getPaymentProjectId() {
      return this.paymentProjectId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public ContractCollectionDisburse setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractCollectionDisburse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractCollectionDisburse setAssetOwnerId(final Long assetOwnerId) {
      this.assetOwnerId = assetOwnerId;
      return this;
   }

   public ContractCollectionDisburse setAssetType(final Integer assetType) {
      this.assetType = assetType;
      return this;
   }

   public ContractCollectionDisburse setUseAmount(final BigDecimal useAmount) {
      this.useAmount = useAmount;
      return this;
   }

   public ContractCollectionDisburse setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
      return this;
   }

   public ContractCollectionDisburse setPaymentProjectId(final Long paymentProjectId) {
      this.paymentProjectId = paymentProjectId;
      return this;
   }

   public ContractCollectionDisburse setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractCollectionDisburse setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractCollectionDisburse(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", assetOwnerId="
         + this.getAssetOwnerId()
         + ", assetType="
         + this.getAssetType()
         + ", useAmount="
         + this.getUseAmount()
         + ", paymentId="
         + this.getPaymentId()
         + ", paymentProjectId="
         + this.getPaymentProjectId()
         + ", userId="
         + this.getUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionDisburse)) {
         return false;
      }

      ContractCollectionDisburse other = (ContractCollectionDisburse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$assetOwnerId = this.getAssetOwnerId();
            Object other$assetOwnerId = other.getAssetOwnerId();
            if (this$assetOwnerId == null ? other$assetOwnerId == null : this$assetOwnerId.equals(other$assetOwnerId)) {
               Object this$assetType = this.getAssetType();
               Object other$assetType = other.getAssetType();
               if (this$assetType == null ? other$assetType == null : this$assetType.equals(other$assetType)) {
                  Object this$paymentId = this.getPaymentId();
                  Object other$paymentId = other.getPaymentId();
                  if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
                     Object this$paymentProjectId = this.getPaymentProjectId();
                     Object other$paymentProjectId = other.getPaymentProjectId();
                     if (this$paymentProjectId == null ? other$paymentProjectId == null : this$paymentProjectId.equals(other$paymentProjectId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$useAmount = this.getUseAmount();
                              Object other$useAmount = other.getUseAmount();
                              return this$useAmount == null ? other$useAmount == null : this$useAmount.equals(other$useAmount);
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
      return other instanceof ContractCollectionDisburse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $assetOwnerId = this.getAssetOwnerId();
      result = result * 59 + ($assetOwnerId == null ? 43 : $assetOwnerId.hashCode());
      Object $assetType = this.getAssetType();
      result = result * 59 + ($assetType == null ? 43 : $assetType.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $paymentProjectId = this.getPaymentProjectId();
      result = result * 59 + ($paymentProjectId == null ? 43 : $paymentProjectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $useAmount = this.getUseAmount();
      return result * 59 + ($useAmount == null ? 43 : $useAmount.hashCode());
   }

   public static class ContractCollectionDisburseBuilder {
      private Long id;
      private Long projectId;
      private Long assetOwnerId;
      private Integer assetType;
      private BigDecimal useAmount;
      private Long paymentId;
      private Long paymentProjectId;
      private Long userId;
      private Integer auditStatus;

      ContractCollectionDisburseBuilder() {
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder assetOwnerId(final Long assetOwnerId) {
         this.assetOwnerId = assetOwnerId;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder assetType(final Integer assetType) {
         this.assetType = assetType;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder useAmount(final BigDecimal useAmount) {
         this.useAmount = useAmount;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder paymentId(final Long paymentId) {
         this.paymentId = paymentId;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder paymentProjectId(final Long paymentProjectId) {
         this.paymentProjectId = paymentProjectId;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractCollectionDisburse.ContractCollectionDisburseBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractCollectionDisburse build() {
         return new ContractCollectionDisburse(
            this.id, this.projectId, this.assetOwnerId, this.assetType, this.useAmount, this.paymentId, this.paymentProjectId, this.userId, this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "ContractCollectionDisburse.ContractCollectionDisburseBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", assetOwnerId="
            + this.assetOwnerId
            + ", assetType="
            + this.assetType
            + ", useAmount="
            + this.useAmount
            + ", paymentId="
            + this.paymentId
            + ", paymentProjectId="
            + this.paymentProjectId
            + ", userId="
            + this.userId
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
