package com.hzchum.scim.contract.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractSettlement对象", description = "项目预结算表")
@Entity
@TableName("contract_settlement")
@Table(name = "contract_settlement")
@org.hibernate.annotations.Table(appliesTo = "contract_settlement", comment = "项目预结算表")
public class ContractSettlement extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "amount", value = "结算额", notes = "结算额")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,4)  COMMENT '结算额'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "settlementDate", value = "结算日期", notes = "结算日期")
   @TableField("settlement_date")
   @Column(name = "settlement_date", columnDefinition = "date  COMMENT '结算日期'", nullable = false)
   private LocalDate settlementDate;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(32)  COMMENT '创建人'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态 1未审核 2已通过 4已驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   @TableField("audit_user_name")
   @Column(name = "audit_user_name", columnDefinition = "varchar(32)  COMMENT '审核人'", nullable = true)
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附加id字符串", notes = "附加id字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附加id字符串'", nullable = true)
   private String attachmentIds;

   public static ContractSettlement.ContractSettlementBuilder builder() {
      return new ContractSettlement.ContractSettlementBuilder();
   }

   public ContractSettlement() {
   }

   public ContractSettlement(
      final Long id,
      final Long projectId,
      final BigDecimal amount,
      final LocalDate settlementDate,
      final Long createUserId,
      final String createUserName,
      final Integer auditStatus,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final String remark,
      final String attachmentIds
   ) {
      this.id = id;
      this.projectId = projectId;
      this.amount = amount;
      this.settlementDate = settlementDate;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.auditStatus = auditStatus;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public LocalDate getSettlementDate() {
      return this.settlementDate;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
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

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public ContractSettlement setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractSettlement setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractSettlement setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ContractSettlement setSettlementDate(final LocalDate settlementDate) {
      this.settlementDate = settlementDate;
      return this;
   }

   public ContractSettlement setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ContractSettlement setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ContractSettlement setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ContractSettlement setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public ContractSettlement setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public ContractSettlement setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ContractSettlement setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractSettlement setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "ContractSettlement(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", amount="
         + this.getAmount()
         + ", settlementDate="
         + this.getSettlementDate()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractSettlement)) {
         return false;
      }

      ContractSettlement other = (ContractSettlement)o;
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
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                  Object this$auditUserId = this.getAuditUserId();
                  Object other$auditUserId = other.getAuditUserId();
                  if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$settlementDate = this.getSettlementDate();
                        Object other$settlementDate = other.getSettlementDate();
                        if (this$settlementDate == null ? other$settlementDate == null : this$settlementDate.equals(other$settlementDate)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                              Object this$auditUserName = this.getAuditUserName();
                              Object other$auditUserName = other.getAuditUserName();
                              if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                 Object this$auditTime = this.getAuditTime();
                                 Object other$auditTime = other.getAuditTime();
                                 if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$attachmentIds = this.getAttachmentIds();
                                       Object other$attachmentIds = other.getAttachmentIds();
                                       return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof ContractSettlement;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementDate = this.getSettlementDate();
      result = result * 59 + ($settlementDate == null ? 43 : $settlementDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class ContractSettlementBuilder {
      private Long id;
      private Long projectId;
      private BigDecimal amount;
      private LocalDate settlementDate;
      private Long createUserId;
      private String createUserName;
      private Integer auditStatus;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private String remark;
      private String attachmentIds;

      ContractSettlementBuilder() {
      }

      public ContractSettlement.ContractSettlementBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder settlementDate(final LocalDate settlementDate) {
         this.settlementDate = settlementDate;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractSettlement.ContractSettlementBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractSettlement build() {
         return new ContractSettlement(
            this.id,
            this.projectId,
            this.amount,
            this.settlementDate,
            this.createUserId,
            this.createUserName,
            this.auditStatus,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.remark,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "ContractSettlement.ContractSettlementBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", amount="
            + this.amount
            + ", settlementDate="
            + this.settlementDate
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", auditStatus="
            + this.auditStatus
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
