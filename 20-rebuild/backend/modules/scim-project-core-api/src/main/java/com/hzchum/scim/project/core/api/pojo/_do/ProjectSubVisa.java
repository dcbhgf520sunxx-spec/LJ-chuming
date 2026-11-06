package com.hzchum.scim.project.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "ProjectSubVisa对象", description = "项目管理分包签证表 ")
@Entity
@TableName("project_sub_visa")
@Table(name = "project_sub_visa")
@org.hibernate.annotations.Table(appliesTo = "project_sub_visa", comment = "项目管理分包签证表 ")
public class ProjectSubVisa extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "number", value = "流水号", notes = "流水号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "varchar(16)  COMMENT '流水号'", nullable = false)
   private String number;
   @ApiModelProperty(name = "applyDate", value = "申请日期", notes = "申请日期")
   @JsonProperty("applyDate")
   @JSONField(name = "applyDate")
   @TableField("apply_date")
   @Column(name = "apply_date", columnDefinition = "date  COMMENT '申请日期'", nullable = false)
   private LocalDate applyDate;
   @ApiModelProperty(name = "visaReasonId", value = "签证原因ID", notes = "签证原因ID")
   @JsonProperty("visaReasonId")
   @JSONField(name = "visaReasonId")
   @TableField("visa_reason_id")
   @Column(name = "visa_reason_id", columnDefinition = "bigint(20)  COMMENT '签证原因ID'", nullable = false)
   private Long visaReasonId;
   @ApiModelProperty(name = "visaReasonName", value = "签证原因", notes = "签证原因")
   @JsonProperty("visaReasonName")
   @JSONField(name = "visaReasonName")
   @TableField("visa_reason_name")
   @Column(name = "visa_reason_name", columnDefinition = "varchar(255)  COMMENT '签证原因'", nullable = false)
   private String visaReasonName;
   @ApiModelProperty(name = "visaAmount", value = "签证金额", notes = "签证金额")
   @JsonProperty("visaAmount")
   @JSONField(name = "visaAmount")
   @TableField("visa_amount")
   @Column(name = "visa_amount", columnDefinition = "decimal(32,8)  COMMENT '签证金额'", nullable = false)
   private BigDecimal visaAmount;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "subcontractOrderId", value = "分包订单ID", notes = "分包订单ID")
   @JsonProperty("subcontractOrderId")
   @JSONField(name = "subcontractOrderId")
   @TableField("subcontract_order_id")
   @Column(name = "subcontract_order_id", columnDefinition = "bigint(20)  COMMENT '分包订单ID'", nullable = false)
   private Long subcontractOrderId;
   @ApiModelProperty(name = "supplierId", value = "分包单位id", notes = "分包单位id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包单位id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '分包单位'", nullable = false)
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @JsonProperty("subcontractClassId")
   @JSONField(name = "subcontractClassId")
   @TableField("subcontract_class_id")
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20)  COMMENT '分包类别id'", nullable = false)
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   @JsonProperty("subcontractClassName")
   @JSONField(name = "subcontractClassName")
   @TableField("subcontract_class_name")
   @Column(name = "subcontract_class_name", columnDefinition = "varchar(128)  COMMENT '分包类别名称'")
   private String subcontractClassName;
   @ApiModelProperty(name = "auditUserId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人ID'")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   @JsonProperty("auditUserName")
   @JSONField(name = "auditUserName")
   @TableField("audit_user_name")
   @Column(name = "audit_user_name", columnDefinition = "varchar(128)  COMMENT '审核人'")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1待审核2通过4驳回", notes = "审核状态 1待审核2通过4驳回")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态 1待审核2通过4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6)  COMMENT '审核时间'")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "approverId", value = "审批人ID", notes = "审批人ID")
   @JsonProperty("approverId")
   @JSONField(name = "approverId")
   @TableField("approver_id")
   @Column(name = "approver_id", columnDefinition = "bigint(20)  COMMENT '审批人ID'")
   private Long approverId;
   @ApiModelProperty(name = "approverName", value = "审批人", notes = "审批人")
   @JsonProperty("approverName")
   @JSONField(name = "approverName")
   @TableField("approver_name")
   @Column(name = "approver_name", columnDefinition = "varchar(128)  COMMENT '审批人'")
   private String approverName;
   @ApiModelProperty(name = "approveTime", value = "审批时间", notes = "审批时间")
   @JsonProperty("approveTime")
   @JSONField(name = "approveTime")
   @TableField("approve_time")
   @Column(name = "approve_time", columnDefinition = "datetime(6)  COMMENT '审批时间'")
   private LocalDateTime approveTime;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(2048)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(2048)  COMMENT '备注'")
   private String remark;

   public static ProjectSubVisa.ProjectSubVisaBuilder builder() {
      return new ProjectSubVisa.ProjectSubVisaBuilder();
   }

   public ProjectSubVisa() {
   }

   public ProjectSubVisa(
      final Long id,
      final String number,
      final LocalDate applyDate,
      final Long visaReasonId,
      final String visaReasonName,
      final BigDecimal visaAmount,
      final Long projectId,
      final Long monomerId,
      final Long subcontractOrderId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final Long auditUserId,
      final String auditUserName,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final Long approverId,
      final String approverName,
      final LocalDateTime approveTime,
      final String attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.number = number;
      this.applyDate = applyDate;
      this.visaReasonId = visaReasonId;
      this.visaReasonName = visaReasonName;
      this.visaAmount = visaAmount;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.subcontractOrderId = subcontractOrderId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.approverId = approverId;
      this.approverName = approverName;
      this.approveTime = approveTime;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public Long getVisaReasonId() {
      return this.visaReasonId;
   }

   public String getVisaReasonName() {
      return this.visaReasonName;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSubcontractOrderId() {
      return this.subcontractOrderId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public String getApproverName() {
      return this.approverName;
   }

   public LocalDateTime getApproveTime() {
      return this.approveTime;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ProjectSubVisa setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("number")
   public ProjectSubVisa setNumber(final String number) {
      this.number = number;
      return this;
   }

   @JsonProperty("applyDate")
   public ProjectSubVisa setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
      return this;
   }

   @JsonProperty("visaReasonId")
   public ProjectSubVisa setVisaReasonId(final Long visaReasonId) {
      this.visaReasonId = visaReasonId;
      return this;
   }

   @JsonProperty("visaReasonName")
   public ProjectSubVisa setVisaReasonName(final String visaReasonName) {
      this.visaReasonName = visaReasonName;
      return this;
   }

   @JsonProperty("visaAmount")
   public ProjectSubVisa setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectSubVisa setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectSubVisa setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("subcontractOrderId")
   public ProjectSubVisa setSubcontractOrderId(final Long subcontractOrderId) {
      this.subcontractOrderId = subcontractOrderId;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectSubVisa setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectSubVisa setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("subcontractClassId")
   public ProjectSubVisa setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @JsonProperty("subcontractClassName")
   public ProjectSubVisa setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
      return this;
   }

   @JsonProperty("auditUserId")
   public ProjectSubVisa setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditUserName")
   public ProjectSubVisa setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   @JsonProperty("auditStatus")
   public ProjectSubVisa setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("auditTime")
   public ProjectSubVisa setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("approverId")
   public ProjectSubVisa setApproverId(final Long approverId) {
      this.approverId = approverId;
      return this;
   }

   @JsonProperty("approverName")
   public ProjectSubVisa setApproverName(final String approverName) {
      this.approverName = approverName;
      return this;
   }

   @JsonProperty("approveTime")
   public ProjectSubVisa setApproveTime(final LocalDateTime approveTime) {
      this.approveTime = approveTime;
      return this;
   }

   @JsonProperty("attachmentIds")
   public ProjectSubVisa setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("remark")
   public ProjectSubVisa setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSubVisa(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", applyDate="
         + this.getApplyDate()
         + ", visaReasonId="
         + this.getVisaReasonId()
         + ", visaReasonName="
         + this.getVisaReasonName()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", subcontractOrderId="
         + this.getSubcontractOrderId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", approverId="
         + this.getApproverId()
         + ", approverName="
         + this.getApproverName()
         + ", approveTime="
         + this.getApproveTime()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubVisa)) {
         return false;
      }

      ProjectSubVisa other = (ProjectSubVisa)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$visaReasonId = this.getVisaReasonId();
         Object other$visaReasonId = other.getVisaReasonId();
         if (this$visaReasonId == null ? other$visaReasonId == null : this$visaReasonId.equals(other$visaReasonId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$subcontractOrderId = this.getSubcontractOrderId();
                  Object other$subcontractOrderId = other.getSubcontractOrderId();
                  if (this$subcontractOrderId == null ? other$subcontractOrderId == null : this$subcontractOrderId.equals(other$subcontractOrderId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$subcontractClassId = this.getSubcontractClassId();
                        Object other$subcontractClassId = other.getSubcontractClassId();
                        if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                           Object this$auditUserId = this.getAuditUserId();
                           Object other$auditUserId = other.getAuditUserId();
                           if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                              Object this$auditStatus = this.getAuditStatus();
                              Object other$auditStatus = other.getAuditStatus();
                              if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                 Object this$approverId = this.getApproverId();
                                 Object other$approverId = other.getApproverId();
                                 if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                       Object this$applyDate = this.getApplyDate();
                                       Object other$applyDate = other.getApplyDate();
                                       if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                          Object this$visaReasonName = this.getVisaReasonName();
                                          Object other$visaReasonName = other.getVisaReasonName();
                                          if (this$visaReasonName == null ? other$visaReasonName == null : this$visaReasonName.equals(other$visaReasonName)) {
                                             Object this$visaAmount = this.getVisaAmount();
                                             Object other$visaAmount = other.getVisaAmount();
                                             if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                                                Object this$supplierName = this.getSupplierName();
                                                Object other$supplierName = other.getSupplierName();
                                                if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                   Object this$subcontractClassName = this.getSubcontractClassName();
                                                   Object other$subcontractClassName = other.getSubcontractClassName();
                                                   if (this$subcontractClassName == null
                                                      ? other$subcontractClassName == null
                                                      : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                      Object this$auditUserName = this.getAuditUserName();
                                                      Object other$auditUserName = other.getAuditUserName();
                                                      if (this$auditUserName == null
                                                         ? other$auditUserName == null
                                                         : this$auditUserName.equals(other$auditUserName)) {
                                                         Object this$auditTime = this.getAuditTime();
                                                         Object other$auditTime = other.getAuditTime();
                                                         if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                            Object this$approverName = this.getApproverName();
                                                            Object other$approverName = other.getApproverName();
                                                            if (this$approverName == null
                                                               ? other$approverName == null
                                                               : this$approverName.equals(other$approverName)) {
                                                               Object this$approveTime = this.getApproveTime();
                                                               Object other$approveTime = other.getApproveTime();
                                                               if (this$approveTime == null
                                                                  ? other$approveTime == null
                                                                  : this$approveTime.equals(other$approveTime)) {
                                                                  Object this$attachmentIds = this.getAttachmentIds();
                                                                  Object other$attachmentIds = other.getAttachmentIds();
                                                                  if (this$attachmentIds == null
                                                                     ? other$attachmentIds == null
                                                                     : this$attachmentIds.equals(other$attachmentIds)) {
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
      return other instanceof ProjectSubVisa;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $visaReasonId = this.getVisaReasonId();
      result = result * 59 + ($visaReasonId == null ? 43 : $visaReasonId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $visaReasonName = this.getVisaReasonName();
      result = result * 59 + ($visaReasonName == null ? 43 : $visaReasonName.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $approverName = this.getApproverName();
      result = result * 59 + ($approverName == null ? 43 : $approverName.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ProjectSubVisaBuilder {
      private Long id;
      private String number;
      private LocalDate applyDate;
      private Long visaReasonId;
      private String visaReasonName;
      private BigDecimal visaAmount;
      private Long projectId;
      private Long monomerId;
      private Long subcontractOrderId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private Long auditUserId;
      private String auditUserName;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private Long approverId;
      private String approverName;
      private LocalDateTime approveTime;
      private String attachmentIds;
      private String remark;

      ProjectSubVisaBuilder() {
      }

      @JsonProperty("id")
      public ProjectSubVisa.ProjectSubVisaBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("number")
      public ProjectSubVisa.ProjectSubVisaBuilder number(final String number) {
         this.number = number;
         return this;
      }

      @JsonProperty("applyDate")
      public ProjectSubVisa.ProjectSubVisaBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      @JsonProperty("visaReasonId")
      public ProjectSubVisa.ProjectSubVisaBuilder visaReasonId(final Long visaReasonId) {
         this.visaReasonId = visaReasonId;
         return this;
      }

      @JsonProperty("visaReasonName")
      public ProjectSubVisa.ProjectSubVisaBuilder visaReasonName(final String visaReasonName) {
         this.visaReasonName = visaReasonName;
         return this;
      }

      @JsonProperty("visaAmount")
      public ProjectSubVisa.ProjectSubVisaBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectSubVisa.ProjectSubVisaBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectSubVisa.ProjectSubVisaBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("subcontractOrderId")
      public ProjectSubVisa.ProjectSubVisaBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectSubVisa.ProjectSubVisaBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectSubVisa.ProjectSubVisaBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("subcontractClassId")
      public ProjectSubVisa.ProjectSubVisaBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      @JsonProperty("subcontractClassName")
      public ProjectSubVisa.ProjectSubVisaBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      @JsonProperty("auditUserId")
      public ProjectSubVisa.ProjectSubVisaBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditUserName")
      public ProjectSubVisa.ProjectSubVisaBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      @JsonProperty("auditStatus")
      public ProjectSubVisa.ProjectSubVisaBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("auditTime")
      public ProjectSubVisa.ProjectSubVisaBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("approverId")
      public ProjectSubVisa.ProjectSubVisaBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      @JsonProperty("approverName")
      public ProjectSubVisa.ProjectSubVisaBuilder approverName(final String approverName) {
         this.approverName = approverName;
         return this;
      }

      @JsonProperty("approveTime")
      public ProjectSubVisa.ProjectSubVisaBuilder approveTime(final LocalDateTime approveTime) {
         this.approveTime = approveTime;
         return this;
      }

      @JsonProperty("attachmentIds")
      public ProjectSubVisa.ProjectSubVisaBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("remark")
      public ProjectSubVisa.ProjectSubVisaBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSubVisa build() {
         return new ProjectSubVisa(
            this.id,
            this.number,
            this.applyDate,
            this.visaReasonId,
            this.visaReasonName,
            this.visaAmount,
            this.projectId,
            this.monomerId,
            this.subcontractOrderId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.auditUserId,
            this.auditUserName,
            this.auditStatus,
            this.auditTime,
            this.approverId,
            this.approverName,
            this.approveTime,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ProjectSubVisa.ProjectSubVisaBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", applyDate="
            + this.applyDate
            + ", visaReasonId="
            + this.visaReasonId
            + ", visaReasonName="
            + this.visaReasonName
            + ", visaAmount="
            + this.visaAmount
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", subcontractOrderId="
            + this.subcontractOrderId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", approverId="
            + this.approverId
            + ", approverName="
            + this.approverName
            + ", approveTime="
            + this.approveTime
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
