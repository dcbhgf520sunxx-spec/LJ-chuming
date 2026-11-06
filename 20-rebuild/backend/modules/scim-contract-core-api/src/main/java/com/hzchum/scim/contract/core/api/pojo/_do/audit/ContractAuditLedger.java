package com.hzchum.scim.contract.core.api.pojo._do.audit;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "ContractAuditLedger对象", description = "审批管理 ")
@Entity
@TableName("contract_audit_ledger")
@Table(name = "contract_audit_ledger", indexes = @Index(name = "payment_enum", columnList = "payment_enum"))
@org.hibernate.annotations.Table(appliesTo = "contract_audit_ledger", comment = "审批管理 ")
public class ContractAuditLedger extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "paymentEnum", value = "审批详细类型", notes = "审批详细类型")
   @TableField("payment_enum")
   @Column(name = "payment_enum", columnDefinition = "int(11)  COMMENT '审批详细类型'", nullable = false)
   private Integer paymentEnum;
   @ApiModelProperty(name = "filingDate", value = "申请日期", notes = "申请日期")
   @TableField("filing_date")
   @Column(name = "filing_date", columnDefinition = "datetime(6)  COMMENT '申请日期'", nullable = false)
   private LocalDateTime filingDate;
   @ApiModelProperty(name = "oaNumber", value = "OA编号", notes = "OA编号")
   @TableField("oa_number")
   @Column(name = "oa_number", columnDefinition = "varchar(255)  COMMENT 'OA编号'", nullable = true)
   private String oaNumber;
   @ApiModelProperty(name = "initiatorId", value = "发起人", notes = "发起人")
   @TableField("initiator_id")
   @Column(name = "initiator_id", columnDefinition = "bigint(20)  COMMENT '发起人'", nullable = true)
   private Long initiatorId;
   @ApiModelProperty(name = "paymentId", value = "付款id", notes = "付款id")
   @TableField("payment_id")
   @Column(name = "payment_id", columnDefinition = "varchar(255)  COMMENT '付款id or 发票id'", nullable = true)
   private String paymentId;
   @ApiModelProperty(name = "contractId", value = "采购/分包合同id", notes = "采购/分包合同id")
   @TableField("contract_id")
   @Column(name = "contract_id", columnDefinition = "varchar(255)  COMMENT '采购/分包合同id'", nullable = true)
   private String contractId;
   @ApiModelProperty(name = "contractNumber", value = "采购/分包合同号/项目编号", notes = "采购/分包合同号/项目编号")
   @TableField("contract_number")
   @Column(name = "contract_number", columnDefinition = "varchar(255)  COMMENT '采购/分包合同号/项目编号'", nullable = true)
   private String contractNumber;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "varchar(255)  COMMENT '所属项目'", nullable = true)
   private String projectId;
   @ApiModelProperty(name = "contractSignBodyId", value = "签订主体id", notes = "签订主体id")
   @TableField("contract_sign_body_id")
   @Column(name = "contract_sign_body_id", columnDefinition = "bigint(20)  COMMENT '签订主体id'", nullable = true)
   private Long contractSignBodyId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理", notes = "项目经理")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理'", nullable = true)
   private Long projectManagerId;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "applyAmount", value = "申请金额", notes = "申请金额")
   @TableField("apply_amount")
   @Column(name = "apply_amount", columnDefinition = "decimal(32,4)  COMMENT '申请金额'", nullable = true)
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "paymentAmount", value = "实付金额", notes = "实付金额")
   @TableField("payment_amount")
   @Column(name = "payment_amount", columnDefinition = "decimal(32,4)  COMMENT '实付金额'", nullable = true)
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "writtenById", value = "填报人", notes = "填报人")
   @TableField("written_by_id")
   @Column(name = "written_by_id", columnDefinition = "bigint(20)  COMMENT '填报人'", nullable = true)
   private Long writtenById;
   @ApiModelProperty(name = "submitDate", value = "填报日期", notes = "填报日期")
   @TableField("submit_date")
   @Column(name = "submit_date", columnDefinition = "datetime(6)  COMMENT '填报日期'", nullable = true)
   private LocalDateTime submitDate;
   @ApiModelProperty(name = "auditType", value = "审批大类型", notes = "审批大类型")
   @TableField("audit_type")
   @Column(name = "audit_type", columnDefinition = "int(11)  COMMENT '审批大类型(分包审批、采购审批、项目审批、费用录入审批)'", nullable = false)
   private Integer auditType;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1:审核中2:审核通过4:驳回", notes = "审核状态 1:审核中2:审核通过4:驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审核状态 1:审核中2:审核通过4:驳回8:撤销'", nullable = false)
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "actuallyPayAmount", value = "本次实付金额", notes = "本次实付金额")
   @TableField("actually_pay_amount")
   @Column(name = "actually_pay_amount", columnDefinition = "decimal(32,4)  COMMENT '本次实付金额'", nullable = true)
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "paymentType", value = "付款类型", notes = "付款类型")
   @TableField("payment_type")
   @Column(name = "payment_type", columnDefinition = "int(11)  COMMENT '付款类型'", nullable = true)
   private Integer paymentType;
   @ApiModelProperty(name = "paymentDate", value = "付款日期", notes = "付款日期")
   @TableField("payment_date")
   @Column(name = "payment_date", columnDefinition = "datetime(6)  COMMENT '付款日期'", nullable = true)
   private LocalDateTime paymentDate;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号", notes = "凭证号")
   @TableField("voucher_number")
   @Column(name = "voucher_number", columnDefinition = "varchar(255)  COMMENT '凭证号'", nullable = true)
   private String voucherNumber;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @TableField(value = "project_attribute", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_attribute", columnDefinition = "int(11) comment '项目属性: 1.自营 2.合营 3.包干制'")
   private Integer projectAttribute;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20)  COMMENT '附件id'", nullable = true)
   private Long attachmentId;
   @ApiModelProperty("附件id字符串")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id字符串'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "approvalTime", value = "审批时间", notes = "审批时间")
   @TableField("approval_time")
   @Column(name = "approval_time", columnDefinition = "datetime(6)  COMMENT '审批时间'", nullable = true)
   private LocalDateTime approvalTime;
   @ApiModelProperty("审批日志表ID wms_approve_record")
   @Column(name = "approve_record_id", columnDefinition = "bigint comment '审批日志表ID wms_approve_record'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "requestId", value = "提交OA审批流成功返回的ID", notes = "提交OA审批流成功返回的ID")
   @JsonProperty("requestId")
   @JSONField(name = "requestId")
   @TableField("request_id")
   @Column(name = "request_id", columnDefinition = "varchar(20) COMMENT '提交OA审批流成功返回的ID'")
   private String requestId;

   public static ContractAuditLedger.ContractAuditLedgerBuilder builder() {
      return new ContractAuditLedger.ContractAuditLedgerBuilder();
   }

   public ContractAuditLedger() {
   }

   public ContractAuditLedger(
      final Long id,
      final Integer paymentEnum,
      final LocalDateTime filingDate,
      final String oaNumber,
      final Long initiatorId,
      final String paymentId,
      final String contractId,
      final String contractNumber,
      final String projectId,
      final Long contractSignBodyId,
      final Long projectManagerId,
      final Long supplierId,
      final BigDecimal applyAmount,
      final BigDecimal paymentAmount,
      final Long writtenById,
      final LocalDateTime submitDate,
      final Integer auditType,
      final Integer auditStatusEnum,
      final BigDecimal actuallyPayAmount,
      final Integer paymentType,
      final LocalDateTime paymentDate,
      final String voucherNumber,
      final Integer projectAttribute,
      final Long attachmentId,
      final String attachmentIds,
      final LocalDateTime approvalTime,
      final Long approveRecordId,
      final String requestId
   ) {
      this.id = id;
      this.paymentEnum = paymentEnum;
      this.filingDate = filingDate;
      this.oaNumber = oaNumber;
      this.initiatorId = initiatorId;
      this.paymentId = paymentId;
      this.contractId = contractId;
      this.contractNumber = contractNumber;
      this.projectId = projectId;
      this.contractSignBodyId = contractSignBodyId;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.applyAmount = applyAmount;
      this.paymentAmount = paymentAmount;
      this.writtenById = writtenById;
      this.submitDate = submitDate;
      this.auditType = auditType;
      this.auditStatusEnum = auditStatusEnum;
      this.actuallyPayAmount = actuallyPayAmount;
      this.paymentType = paymentType;
      this.paymentDate = paymentDate;
      this.voucherNumber = voucherNumber;
      this.projectAttribute = projectAttribute;
      this.attachmentId = attachmentId;
      this.attachmentIds = attachmentIds;
      this.approvalTime = approvalTime;
      this.approveRecordId = approveRecordId;
      this.requestId = requestId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public LocalDateTime getFilingDate() {
      return this.filingDate;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public Long getInitiatorId() {
      return this.initiatorId;
   }

   public String getPaymentId() {
      return this.paymentId;
   }

   public String getContractId() {
      return this.contractId;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public LocalDateTime getSubmitDate() {
      return this.submitDate;
   }

   public Integer getAuditType() {
      return this.auditType;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public ContractAuditLedger setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractAuditLedger setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public ContractAuditLedger setFilingDate(final LocalDateTime filingDate) {
      this.filingDate = filingDate;
      return this;
   }

   public ContractAuditLedger setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
      return this;
   }

   public ContractAuditLedger setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
      return this;
   }

   public ContractAuditLedger setPaymentId(final String paymentId) {
      this.paymentId = paymentId;
      return this;
   }

   public ContractAuditLedger setContractId(final String contractId) {
      this.contractId = contractId;
      return this;
   }

   public ContractAuditLedger setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   public ContractAuditLedger setProjectId(final String projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractAuditLedger setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   public ContractAuditLedger setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractAuditLedger setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ContractAuditLedger setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   public ContractAuditLedger setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public ContractAuditLedger setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractAuditLedger setSubmitDate(final LocalDateTime submitDate) {
      this.submitDate = submitDate;
      return this;
   }

   public ContractAuditLedger setAuditType(final Integer auditType) {
      this.auditType = auditType;
      return this;
   }

   public ContractAuditLedger setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractAuditLedger setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
      return this;
   }

   public ContractAuditLedger setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
      return this;
   }

   public ContractAuditLedger setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public ContractAuditLedger setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractAuditLedger setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ContractAuditLedger setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ContractAuditLedger setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractAuditLedger setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
      return this;
   }

   public ContractAuditLedger setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("requestId")
   public ContractAuditLedger setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractAuditLedger(id="
         + this.getId()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", filingDate="
         + this.getFilingDate()
         + ", oaNumber="
         + this.getOaNumber()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", paymentId="
         + this.getPaymentId()
         + ", contractId="
         + this.getContractId()
         + ", contractNumber="
         + this.getContractNumber()
         + ", projectId="
         + this.getProjectId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", writtenById="
         + this.getWrittenById()
         + ", submitDate="
         + this.getSubmitDate()
         + ", auditType="
         + this.getAuditType()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", requestId="
         + this.getRequestId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAuditLedger)) {
         return false;
      }

      ContractAuditLedger other = (ContractAuditLedger)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentEnum = this.getPaymentEnum();
         Object other$paymentEnum = other.getPaymentEnum();
         if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
            Object this$initiatorId = this.getInitiatorId();
            Object other$initiatorId = other.getInitiatorId();
            if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
               Object this$contractSignBodyId = this.getContractSignBodyId();
               Object other$contractSignBodyId = other.getContractSignBodyId();
               if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$writtenById = this.getWrittenById();
                        Object other$writtenById = other.getWrittenById();
                        if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                           Object this$auditType = this.getAuditType();
                           Object other$auditType = other.getAuditType();
                           if (this$auditType == null ? other$auditType == null : this$auditType.equals(other$auditType)) {
                              Object this$auditStatusEnum = this.getAuditStatusEnum();
                              Object other$auditStatusEnum = other.getAuditStatusEnum();
                              if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                                 Object this$paymentType = this.getPaymentType();
                                 Object other$paymentType = other.getPaymentType();
                                 if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
                                    Object this$projectAttribute = this.getProjectAttribute();
                                    Object other$projectAttribute = other.getProjectAttribute();
                                    if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                                       Object this$attachmentId = this.getAttachmentId();
                                       Object other$attachmentId = other.getAttachmentId();
                                       if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                          Object this$approveRecordId = this.getApproveRecordId();
                                          Object other$approveRecordId = other.getApproveRecordId();
                                          if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)
                                             )
                                           {
                                             Object this$filingDate = this.getFilingDate();
                                             Object other$filingDate = other.getFilingDate();
                                             if (this$filingDate == null ? other$filingDate == null : this$filingDate.equals(other$filingDate)) {
                                                Object this$oaNumber = this.getOaNumber();
                                                Object other$oaNumber = other.getOaNumber();
                                                if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
                                                   Object this$paymentId = this.getPaymentId();
                                                   Object other$paymentId = other.getPaymentId();
                                                   if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
                                                      Object this$contractId = this.getContractId();
                                                      Object other$contractId = other.getContractId();
                                                      if (this$contractId == null ? other$contractId == null : this$contractId.equals(other$contractId)) {
                                                         Object this$contractNumber = this.getContractNumber();
                                                         Object other$contractNumber = other.getContractNumber();
                                                         if (this$contractNumber == null
                                                            ? other$contractNumber == null
                                                            : this$contractNumber.equals(other$contractNumber)) {
                                                            Object this$projectId = this.getProjectId();
                                                            Object other$projectId = other.getProjectId();
                                                            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                                               Object this$applyAmount = this.getApplyAmount();
                                                               Object other$applyAmount = other.getApplyAmount();
                                                               if (this$applyAmount == null
                                                                  ? other$applyAmount == null
                                                                  : this$applyAmount.equals(other$applyAmount)) {
                                                                  Object this$paymentAmount = this.getPaymentAmount();
                                                                  Object other$paymentAmount = other.getPaymentAmount();
                                                                  if (this$paymentAmount == null
                                                                     ? other$paymentAmount == null
                                                                     : this$paymentAmount.equals(other$paymentAmount)) {
                                                                     Object this$submitDate = this.getSubmitDate();
                                                                     Object other$submitDate = other.getSubmitDate();
                                                                     if (this$submitDate == null
                                                                        ? other$submitDate == null
                                                                        : this$submitDate.equals(other$submitDate)) {
                                                                        Object this$actuallyPayAmount = this.getActuallyPayAmount();
                                                                        Object other$actuallyPayAmount = other.getActuallyPayAmount();
                                                                        if (this$actuallyPayAmount == null
                                                                           ? other$actuallyPayAmount == null
                                                                           : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                                                                           Object this$paymentDate = this.getPaymentDate();
                                                                           Object other$paymentDate = other.getPaymentDate();
                                                                           if (this$paymentDate == null
                                                                              ? other$paymentDate == null
                                                                              : this$paymentDate.equals(other$paymentDate)) {
                                                                              Object this$voucherNumber = this.getVoucherNumber();
                                                                              Object other$voucherNumber = other.getVoucherNumber();
                                                                              if (this$voucherNumber == null
                                                                                 ? other$voucherNumber == null
                                                                                 : this$voucherNumber.equals(other$voucherNumber)) {
                                                                                 Object this$attachmentIds = this.getAttachmentIds();
                                                                                 Object other$attachmentIds = other.getAttachmentIds();
                                                                                 if (this$attachmentIds == null
                                                                                    ? other$attachmentIds == null
                                                                                    : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                    Object this$approvalTime = this.getApprovalTime();
                                                                                    Object other$approvalTime = other.getApprovalTime();
                                                                                    if (this$approvalTime == null
                                                                                       ? other$approvalTime == null
                                                                                       : this$approvalTime.equals(other$approvalTime)) {
                                                                                       Object this$requestId = this.getRequestId();
                                                                                       Object other$requestId = other.getRequestId();
                                                                                       return this$requestId == null
                                                                                          ? other$requestId == null
                                                                                          : this$requestId.equals(other$requestId);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractAuditLedger;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditType = this.getAuditType();
      result = result * 59 + ($auditType == null ? 43 : $auditType.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $filingDate = this.getFilingDate();
      result = result * 59 + ($filingDate == null ? 43 : $filingDate.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $contractId = this.getContractId();
      result = result * 59 + ($contractId == null ? 43 : $contractId.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $submitDate = this.getSubmitDate();
      result = result * 59 + ($submitDate == null ? 43 : $submitDate.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $approvalTime = this.getApprovalTime();
      result = result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
      Object $requestId = this.getRequestId();
      return result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
   }

   public static class ContractAuditLedgerBuilder {
      private Long id;
      private Integer paymentEnum;
      private LocalDateTime filingDate;
      private String oaNumber;
      private Long initiatorId;
      private String paymentId;
      private String contractId;
      private String contractNumber;
      private String projectId;
      private Long contractSignBodyId;
      private Long projectManagerId;
      private Long supplierId;
      private BigDecimal applyAmount;
      private BigDecimal paymentAmount;
      private Long writtenById;
      private LocalDateTime submitDate;
      private Integer auditType;
      private Integer auditStatusEnum;
      private BigDecimal actuallyPayAmount;
      private Integer paymentType;
      private LocalDateTime paymentDate;
      private String voucherNumber;
      private Integer projectAttribute;
      private Long attachmentId;
      private String attachmentIds;
      private LocalDateTime approvalTime;
      private Long approveRecordId;
      private String requestId;

      ContractAuditLedgerBuilder() {
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder filingDate(final LocalDateTime filingDate) {
         this.filingDate = filingDate;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder oaNumber(final String oaNumber) {
         this.oaNumber = oaNumber;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder initiatorId(final Long initiatorId) {
         this.initiatorId = initiatorId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder paymentId(final String paymentId) {
         this.paymentId = paymentId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder contractId(final String contractId) {
         this.contractId = contractId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder projectId(final String projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder submitDate(final LocalDateTime submitDate) {
         this.submitDate = submitDate;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder auditType(final Integer auditType) {
         this.auditType = auditType;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder approvalTime(final LocalDateTime approvalTime) {
         this.approvalTime = approvalTime;
         return this;
      }

      public ContractAuditLedger.ContractAuditLedgerBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("requestId")
      public ContractAuditLedger.ContractAuditLedgerBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public ContractAuditLedger build() {
         return new ContractAuditLedger(
            this.id,
            this.paymentEnum,
            this.filingDate,
            this.oaNumber,
            this.initiatorId,
            this.paymentId,
            this.contractId,
            this.contractNumber,
            this.projectId,
            this.contractSignBodyId,
            this.projectManagerId,
            this.supplierId,
            this.applyAmount,
            this.paymentAmount,
            this.writtenById,
            this.submitDate,
            this.auditType,
            this.auditStatusEnum,
            this.actuallyPayAmount,
            this.paymentType,
            this.paymentDate,
            this.voucherNumber,
            this.projectAttribute,
            this.attachmentId,
            this.attachmentIds,
            this.approvalTime,
            this.approveRecordId,
            this.requestId
         );
      }

      @Override
      public String toString() {
         return "ContractAuditLedger.ContractAuditLedgerBuilder(id="
            + this.id
            + ", paymentEnum="
            + this.paymentEnum
            + ", filingDate="
            + this.filingDate
            + ", oaNumber="
            + this.oaNumber
            + ", initiatorId="
            + this.initiatorId
            + ", paymentId="
            + this.paymentId
            + ", contractId="
            + this.contractId
            + ", contractNumber="
            + this.contractNumber
            + ", projectId="
            + this.projectId
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", projectManagerId="
            + this.projectManagerId
            + ", supplierId="
            + this.supplierId
            + ", applyAmount="
            + this.applyAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", writtenById="
            + this.writtenById
            + ", submitDate="
            + this.submitDate
            + ", auditType="
            + this.auditType
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ", paymentType="
            + this.paymentType
            + ", paymentDate="
            + this.paymentDate
            + ", voucherNumber="
            + this.voucherNumber
            + ", projectAttribute="
            + this.projectAttribute
            + ", attachmentId="
            + this.attachmentId
            + ", attachmentIds="
            + this.attachmentIds
            + ", approvalTime="
            + this.approvalTime
            + ", approveRecordId="
            + this.approveRecordId
            + ", requestId="
            + this.requestId
            + ")";
      }
   }
}
