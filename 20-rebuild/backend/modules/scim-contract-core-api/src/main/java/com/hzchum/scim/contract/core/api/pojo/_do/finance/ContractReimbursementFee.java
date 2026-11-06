package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "ContractReimbursementFee对象", description = "报销费用表")
@Entity
@TableName("contract_reimbursement_fee")
@Table(name = "contract_reimbursement_fee")
@org.hibernate.annotations.Table(appliesTo = "contract_reimbursement_fee", comment = "报销费用表")
public class ContractReimbursementFee extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "reimbursementDate", value = "报销日期", notes = "报销日期")
   @TableField("reimbursement_date")
   @Column(name = "reimbursement_date", columnDefinition = "datetime  COMMENT '报销日期'", nullable = true)
   private LocalDateTime reimbursementDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类型ID", notes = "费用类型ID")
   @TableField("expense_type_id")
   @Column(name = "expense_type_id", columnDefinition = "bigint(20)  COMMENT '费用类型ID'", nullable = true)
   private Long expenseTypeId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "reimbursementAmount", value = "报销金额(元)", notes = "报销金额(元)")
   @TableField("reimbursement_amount")
   @Column(name = "reimbursement_amount", columnDefinition = "decimal(32,8)  COMMENT '报销金额(元)'", nullable = true)
   private BigDecimal reimbursementAmount;
   @ApiModelProperty(name = "deptId", value = "部门ID", notes = "部门ID")
   @TableField("dept_id")
   @Column(name = "dept_id", columnDefinition = "bigint(20)  COMMENT '部门ID'", nullable = true)
   private Long deptId;
   @ApiModelProperty(name = "reimburserId", value = "报销人ID", notes = "报销人ID")
   @TableField("reimburser_id")
   @Column(name = "reimburser_id", columnDefinition = "bigint(20)  COMMENT '报销人ID'", nullable = true)
   private Long reimburserId;
   @ApiModelProperty(name = "reimbursementVoucherNumber", value = "报销凭证号", notes = "报销凭证号")
   @TableField("reimbursement_voucher_number")
   @Column(name = "reimbursement_voucher_number", columnDefinition = "varchar(255)  COMMENT '报销凭证号'", nullable = true)
   private String reimbursementVoucherNumber;
   @ApiModelProperty(name = "writtenById", value = "填报人ID", notes = "填报人ID")
   @TableField("written_by_id")
   @Column(name = "written_by_id", columnDefinition = "bigint(20)  COMMENT '填报人ID'", nullable = true)
   private Long writtenById;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   @TableField(value = "attachment_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件id字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审批状态 1未审批 2已通过 4已驳回'", nullable = false)
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   @TableField("auditor_id")
   @Column(name = "auditor_id", columnDefinition = "bigint(20) comment '审核人id'")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   @TableField("auditor_name")
   @Column(name = "auditor_name", columnDefinition = "varchar(128) comment '审核人名字'")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6) comment '审核时间'")
   private LocalDateTime auditTime;

   public static ContractReimbursementFee.ContractReimbursementFeeBuilder builder() {
      return new ContractReimbursementFee.ContractReimbursementFeeBuilder();
   }

   public ContractReimbursementFee() {
   }

   public ContractReimbursementFee(
      final Long id,
      final LocalDateTime reimbursementDate,
      final Long branchCompanyId,
      final Long expenseTypeId,
      final Long projectId,
      final BigDecimal reimbursementAmount,
      final Long deptId,
      final Long reimburserId,
      final String reimbursementVoucherNumber,
      final Long writtenById,
      final String attachmentIds,
      final String remark,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.reimbursementDate = reimbursementDate;
      this.branchCompanyId = branchCompanyId;
      this.expenseTypeId = expenseTypeId;
      this.projectId = projectId;
      this.reimbursementAmount = reimbursementAmount;
      this.deptId = deptId;
      this.reimburserId = reimburserId;
      this.reimbursementVoucherNumber = reimbursementVoucherNumber;
      this.writtenById = writtenById;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getReimbursementDate() {
      return this.reimbursementDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getReimbursementAmount() {
      return this.reimbursementAmount;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Long getReimburserId() {
      return this.reimburserId;
   }

   public String getReimbursementVoucherNumber() {
      return this.reimbursementVoucherNumber;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public ContractReimbursementFee setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractReimbursementFee setReimbursementDate(final LocalDateTime reimbursementDate) {
      this.reimbursementDate = reimbursementDate;
      return this;
   }

   public ContractReimbursementFee setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ContractReimbursementFee setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
      return this;
   }

   public ContractReimbursementFee setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractReimbursementFee setReimbursementAmount(final BigDecimal reimbursementAmount) {
      this.reimbursementAmount = reimbursementAmount;
      return this;
   }

   public ContractReimbursementFee setDeptId(final Long deptId) {
      this.deptId = deptId;
      return this;
   }

   public ContractReimbursementFee setReimburserId(final Long reimburserId) {
      this.reimburserId = reimburserId;
      return this;
   }

   public ContractReimbursementFee setReimbursementVoucherNumber(final String reimbursementVoucherNumber) {
      this.reimbursementVoucherNumber = reimbursementVoucherNumber;
      return this;
   }

   public ContractReimbursementFee setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractReimbursementFee setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractReimbursementFee setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractReimbursementFee setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractReimbursementFee setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractReimbursementFee setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractReimbursementFee setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractReimbursementFee(id="
         + this.getId()
         + ", reimbursementDate="
         + this.getReimbursementDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", projectId="
         + this.getProjectId()
         + ", reimbursementAmount="
         + this.getReimbursementAmount()
         + ", deptId="
         + this.getDeptId()
         + ", reimburserId="
         + this.getReimburserId()
         + ", reimbursementVoucherNumber="
         + this.getReimbursementVoucherNumber()
         + ", writtenById="
         + this.getWrittenById()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementFee)) {
         return false;
      }

      ContractReimbursementFee other = (ContractReimbursementFee)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$deptId = this.getDeptId();
                  Object other$deptId = other.getDeptId();
                  if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                     Object this$reimburserId = this.getReimburserId();
                     Object other$reimburserId = other.getReimburserId();
                     if (this$reimburserId == null ? other$reimburserId == null : this$reimburserId.equals(other$reimburserId)) {
                        Object this$writtenById = this.getWrittenById();
                        Object other$writtenById = other.getWrittenById();
                        if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                           Object this$auditStatusEnum = this.getAuditStatusEnum();
                           Object other$auditStatusEnum = other.getAuditStatusEnum();
                           if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                              Object this$auditorId = this.getAuditorId();
                              Object other$auditorId = other.getAuditorId();
                              if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                 Object this$reimbursementDate = this.getReimbursementDate();
                                 Object other$reimbursementDate = other.getReimbursementDate();
                                 if (this$reimbursementDate == null ? other$reimbursementDate == null : this$reimbursementDate.equals(other$reimbursementDate)) {
                                    Object this$reimbursementAmount = this.getReimbursementAmount();
                                    Object other$reimbursementAmount = other.getReimbursementAmount();
                                    if (this$reimbursementAmount == null
                                       ? other$reimbursementAmount == null
                                       : this$reimbursementAmount.equals(other$reimbursementAmount)) {
                                       Object this$reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
                                       Object other$reimbursementVoucherNumber = other.getReimbursementVoucherNumber();
                                       if (this$reimbursementVoucherNumber == null
                                          ? other$reimbursementVoucherNumber == null
                                          : this$reimbursementVoucherNumber.equals(other$reimbursementVoucherNumber)) {
                                          Object this$attachmentIds = this.getAttachmentIds();
                                          Object other$attachmentIds = other.getAttachmentIds();
                                          if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$auditorName = this.getAuditorName();
                                                Object other$auditorName = other.getAuditorName();
                                                if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                                   Object this$auditTime = this.getAuditTime();
                                                   Object other$auditTime = other.getAuditTime();
                                                   return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof ContractReimbursementFee;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $reimburserId = this.getReimburserId();
      result = result * 59 + ($reimburserId == null ? 43 : $reimburserId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $reimbursementDate = this.getReimbursementDate();
      result = result * 59 + ($reimbursementDate == null ? 43 : $reimbursementDate.hashCode());
      Object $reimbursementAmount = this.getReimbursementAmount();
      result = result * 59 + ($reimbursementAmount == null ? 43 : $reimbursementAmount.hashCode());
      Object $reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
      result = result * 59 + ($reimbursementVoucherNumber == null ? 43 : $reimbursementVoucherNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class ContractReimbursementFeeBuilder {
      private Long id;
      private LocalDateTime reimbursementDate;
      private Long branchCompanyId;
      private Long expenseTypeId;
      private Long projectId;
      private BigDecimal reimbursementAmount;
      private Long deptId;
      private Long reimburserId;
      private String reimbursementVoucherNumber;
      private Long writtenById;
      private String attachmentIds;
      private String remark;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractReimbursementFeeBuilder() {
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder reimbursementDate(final LocalDateTime reimbursementDate) {
         this.reimbursementDate = reimbursementDate;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder reimbursementAmount(final BigDecimal reimbursementAmount) {
         this.reimbursementAmount = reimbursementAmount;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder reimburserId(final Long reimburserId) {
         this.reimburserId = reimburserId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder reimbursementVoucherNumber(final String reimbursementVoucherNumber) {
         this.reimbursementVoucherNumber = reimbursementVoucherNumber;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractReimbursementFee.ContractReimbursementFeeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractReimbursementFee build() {
         return new ContractReimbursementFee(
            this.id,
            this.reimbursementDate,
            this.branchCompanyId,
            this.expenseTypeId,
            this.projectId,
            this.reimbursementAmount,
            this.deptId,
            this.reimburserId,
            this.reimbursementVoucherNumber,
            this.writtenById,
            this.attachmentIds,
            this.remark,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractReimbursementFee.ContractReimbursementFeeBuilder(id="
            + this.id
            + ", reimbursementDate="
            + this.reimbursementDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", projectId="
            + this.projectId
            + ", reimbursementAmount="
            + this.reimbursementAmount
            + ", deptId="
            + this.deptId
            + ", reimburserId="
            + this.reimburserId
            + ", reimbursementVoucherNumber="
            + this.reimbursementVoucherNumber
            + ", writtenById="
            + this.writtenById
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
