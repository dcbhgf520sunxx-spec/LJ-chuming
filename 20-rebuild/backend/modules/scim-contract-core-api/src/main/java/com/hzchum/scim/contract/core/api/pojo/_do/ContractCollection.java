package com.hzchum.scim.contract.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "ContractCollection对象", description = "收款表")
@Entity
@TableName("contract_collection")
@Table(name = "contract_collection")
public class ContractCollection extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "收款类型 1项目收款 2废料收款 CollectionTypeEnum")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' comment '收款类型 1项目收款 2废料收款'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) default 0 comment '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) DEFAULT 0 comment '项目属性: 1.自营 2.合营 3.包干制'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   @TableField("voucher_number")
   @Column(name = "voucher_number", columnDefinition = "varchar(128) default '0' comment '凭证号'", nullable = false)
   private String voucherNumber;
   @ApiModelProperty(name = "contract_waste_id", value = "废料合同id")
   @TableField("contract_waste_id")
   @Column(name = "contract_waste_id", columnDefinition = "bigint(20) default 0 comment '废料合同id'", nullable = false)
   private Long contractWasteId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位(项目合同签订主体)id")
   @TableField("collection_unit_id")
   @Column(name = "collection_unit_id", columnDefinition = "bigint(20) comment '收款单位(项目合同签订主体)id'", nullable = true)
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionUnit", value = "收款单位")
   @TableField("collection_unit")
   @Column(name = "collection_unit", columnDefinition = "varchar(128) comment '收款单位(项目合同签订主体)'")
   private String collectionUnit;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款开户行账号id")
   @TableField(value = "collection_bank_account_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "collection_bank_account_id", columnDefinition = "bigint(20) comment '收款银行id'")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   @TableField(value = "collection_deposit_bank", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "collection_deposit_bank", columnDefinition = "varchar(128) comment '收款开户行'")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款开户行账号")
   @TableField(value = "collection_bank_account", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "collection_bank_account", columnDefinition = "varchar(128) comment '收款开户行账号'")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   @TableField("collection_date")
   @Column(name = "collection_date", columnDefinition = "date comment '收款日期'", nullable = false)
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   @TableField("collection_mode")
   @Column(name = "collection_mode", columnDefinition = "int(11) comment '收款方式'", nullable = false)
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftJson", value = "承兑汇票json")
   @TableField("acceptance_draft_json")
   @Column(name = "acceptance_draft_json", columnDefinition = "varchar(1024) comment '承兑汇票json'")
   private String acceptanceDraftJson;
   @ApiModelProperty(name = "collectionAmount", value = "收款金额")
   @TableField("collection_amount")
   @Column(name = "collection_amount", columnDefinition = "decimal(32,4) comment '收款金额'", nullable = false)
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionReason", value = "收款是由")
   @TableField("collection_reason")
   @Column(name = "collection_reason", columnDefinition = "varchar(16) comment '收款是由'", nullable = true)
   private String collectionReason;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   @TableField("payment_unit")
   @Column(name = "payment_unit", columnDefinition = "varchar(128) comment '付款单位'", nullable = false)
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方开户行")
   @TableField("payment_deposit_bank")
   @Column(name = "payment_deposit_bank", columnDefinition = "varchar(128) comment '付款方开户行'")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款方银行账号")
   @TableField("payment_bank_account")
   @Column(name = "payment_bank_account", columnDefinition = "varchar(128) comment '付款方银行账号'")
   private String paymentBankAccount;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   @TableField("written_by_id")
   @Column(name = "written_by_id", columnDefinition = "bigint(20) comment '填报人id'", nullable = false)
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人名字")
   @TableField("written_by_name")
   @Column(name = "written_by_name", columnDefinition = "varchar(128) comment '填报人名字'")
   private String writtenByName;
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
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default 1 comment '审核状态  1审核中 2审核通过 4已驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   @TableField("last_editor_user_id")
   @Column(name = "last_editor_user_id", columnDefinition = "bigint(20) comment '最后编辑人id(创建人id)'")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20) default 0 comment '项目经理'", nullable = false)
   private Long projectManagerId;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "accessoryId", value = "附件id")
   @TableField("accessory_id")
   @Column(name = "accessory_id", columnDefinition = "varchar(255) comment '附件id'")
   private String accessoryId;
   @ApiModelProperty("附件id字符串")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024) comment '附件id字符串'")
   private String attachmentIds;

   public static ContractCollection.ContractCollectionBuilder builder() {
      return new ContractCollection.ContractCollectionBuilder();
   }

   public ContractCollection() {
   }

   public ContractCollection(
      final Long id,
      final Integer type,
      final Long projectId,
      final Integer projectAttribute,
      final String voucherNumber,
      final Long contractWasteId,
      final Long collectionUnitId,
      final String collectionUnit,
      final Long collectionBankAccountId,
      final String collectionDepositBank,
      final String collectionBankAccount,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final String acceptanceDraftJson,
      final BigDecimal collectionAmount,
      final String collectionReason,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final Long writtenById,
      final String writtenByName,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final Long lastEditorUserId,
      final Long projectManagerId,
      final String remark,
      final String accessoryId,
      final String attachmentIds
   ) {
      this.id = id;
      this.type = type;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.voucherNumber = voucherNumber;
      this.contractWasteId = contractWasteId;
      this.collectionUnitId = collectionUnitId;
      this.collectionUnit = collectionUnit;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftJson = acceptanceDraftJson;
      this.collectionAmount = collectionAmount;
      this.collectionReason = collectionReason;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.lastEditorUserId = lastEditorUserId;
      this.projectManagerId = projectManagerId;
      this.remark = remark;
      this.accessoryId = accessoryId;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public String getCollectionBankAccount() {
      return this.collectionBankAccount;
   }

   public LocalDate getCollectionDate() {
      return this.collectionDate;
   }

   public Integer getCollectionMode() {
      return this.collectionMode;
   }

   public String getAcceptanceDraftJson() {
      return this.acceptanceDraftJson;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public String getCollectionReason() {
      return this.collectionReason;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
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

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAccessoryId() {
      return this.accessoryId;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public ContractCollection setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractCollection setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractCollection setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractCollection setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ContractCollection setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractCollection setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
      return this;
   }

   public ContractCollection setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
      return this;
   }

   public ContractCollection setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
      return this;
   }

   public ContractCollection setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
      return this;
   }

   public ContractCollection setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
      return this;
   }

   public ContractCollection setCollectionBankAccount(final String collectionBankAccount) {
      this.collectionBankAccount = collectionBankAccount;
      return this;
   }

   public ContractCollection setCollectionDate(final LocalDate collectionDate) {
      this.collectionDate = collectionDate;
      return this;
   }

   public ContractCollection setCollectionMode(final Integer collectionMode) {
      this.collectionMode = collectionMode;
      return this;
   }

   public ContractCollection setAcceptanceDraftJson(final String acceptanceDraftJson) {
      this.acceptanceDraftJson = acceptanceDraftJson;
      return this;
   }

   public ContractCollection setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
      return this;
   }

   public ContractCollection setCollectionReason(final String collectionReason) {
      this.collectionReason = collectionReason;
      return this;
   }

   public ContractCollection setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
      return this;
   }

   public ContractCollection setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
      return this;
   }

   public ContractCollection setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public ContractCollection setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractCollection setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
      return this;
   }

   public ContractCollection setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractCollection setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractCollection setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ContractCollection setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ContractCollection setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
      return this;
   }

   public ContractCollection setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractCollection setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractCollection setAccessoryId(final String accessoryId) {
      this.accessoryId = accessoryId;
      return this;
   }

   public ContractCollection setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "ContractCollection(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
         + ", collectionDate="
         + this.getCollectionDate()
         + ", collectionMode="
         + this.getCollectionMode()
         + ", acceptanceDraftJson="
         + this.getAcceptanceDraftJson()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", collectionReason="
         + this.getCollectionReason()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", remark="
         + this.getRemark()
         + ", accessoryId="
         + this.getAccessoryId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollection)) {
         return false;
      }

      ContractCollection other = (ContractCollection)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$contractWasteId = this.getContractWasteId();
                  Object other$contractWasteId = other.getContractWasteId();
                  if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                     Object this$collectionUnitId = this.getCollectionUnitId();
                     Object other$collectionUnitId = other.getCollectionUnitId();
                     if (this$collectionUnitId == null ? other$collectionUnitId == null : this$collectionUnitId.equals(other$collectionUnitId)) {
                        Object this$collectionBankAccountId = this.getCollectionBankAccountId();
                        Object other$collectionBankAccountId = other.getCollectionBankAccountId();
                        if (this$collectionBankAccountId == null
                           ? other$collectionBankAccountId == null
                           : this$collectionBankAccountId.equals(other$collectionBankAccountId)) {
                           Object this$collectionMode = this.getCollectionMode();
                           Object other$collectionMode = other.getCollectionMode();
                           if (this$collectionMode == null ? other$collectionMode == null : this$collectionMode.equals(other$collectionMode)) {
                              Object this$writtenById = this.getWrittenById();
                              Object other$writtenById = other.getWrittenById();
                              if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                                 Object this$auditorId = this.getAuditorId();
                                 Object other$auditorId = other.getAuditorId();
                                 if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                    Object this$auditStatus = this.getAuditStatus();
                                    Object other$auditStatus = other.getAuditStatus();
                                    if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                       Object this$lastEditorUserId = this.getLastEditorUserId();
                                       Object other$lastEditorUserId = other.getLastEditorUserId();
                                       if (this$lastEditorUserId == null
                                          ? other$lastEditorUserId == null
                                          : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                                          Object this$projectManagerId = this.getProjectManagerId();
                                          Object other$projectManagerId = other.getProjectManagerId();
                                          if (this$projectManagerId == null
                                             ? other$projectManagerId == null
                                             : this$projectManagerId.equals(other$projectManagerId)) {
                                             Object this$voucherNumber = this.getVoucherNumber();
                                             Object other$voucherNumber = other.getVoucherNumber();
                                             if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                                                Object this$collectionUnit = this.getCollectionUnit();
                                                Object other$collectionUnit = other.getCollectionUnit();
                                                if (this$collectionUnit == null
                                                   ? other$collectionUnit == null
                                                   : this$collectionUnit.equals(other$collectionUnit)) {
                                                   Object this$collectionDepositBank = this.getCollectionDepositBank();
                                                   Object other$collectionDepositBank = other.getCollectionDepositBank();
                                                   if (this$collectionDepositBank == null
                                                      ? other$collectionDepositBank == null
                                                      : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                                      Object this$collectionBankAccount = this.getCollectionBankAccount();
                                                      Object other$collectionBankAccount = other.getCollectionBankAccount();
                                                      if (this$collectionBankAccount == null
                                                         ? other$collectionBankAccount == null
                                                         : this$collectionBankAccount.equals(other$collectionBankAccount)) {
                                                         Object this$collectionDate = this.getCollectionDate();
                                                         Object other$collectionDate = other.getCollectionDate();
                                                         if (this$collectionDate == null
                                                            ? other$collectionDate == null
                                                            : this$collectionDate.equals(other$collectionDate)) {
                                                            Object this$acceptanceDraftJson = this.getAcceptanceDraftJson();
                                                            Object other$acceptanceDraftJson = other.getAcceptanceDraftJson();
                                                            if (this$acceptanceDraftJson == null
                                                               ? other$acceptanceDraftJson == null
                                                               : this$acceptanceDraftJson.equals(other$acceptanceDraftJson)) {
                                                               Object this$collectionAmount = this.getCollectionAmount();
                                                               Object other$collectionAmount = other.getCollectionAmount();
                                                               if (this$collectionAmount == null
                                                                  ? other$collectionAmount == null
                                                                  : this$collectionAmount.equals(other$collectionAmount)) {
                                                                  Object this$collectionReason = this.getCollectionReason();
                                                                  Object other$collectionReason = other.getCollectionReason();
                                                                  if (this$collectionReason == null
                                                                     ? other$collectionReason == null
                                                                     : this$collectionReason.equals(other$collectionReason)) {
                                                                     Object this$paymentUnit = this.getPaymentUnit();
                                                                     Object other$paymentUnit = other.getPaymentUnit();
                                                                     if (this$paymentUnit == null
                                                                        ? other$paymentUnit == null
                                                                        : this$paymentUnit.equals(other$paymentUnit)) {
                                                                        Object this$paymentDepositBank = this.getPaymentDepositBank();
                                                                        Object other$paymentDepositBank = other.getPaymentDepositBank();
                                                                        if (this$paymentDepositBank == null
                                                                           ? other$paymentDepositBank == null
                                                                           : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                                                           Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                                           Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                                           if (this$paymentBankAccount == null
                                                                              ? other$paymentBankAccount == null
                                                                              : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                                                              Object this$writtenByName = this.getWrittenByName();
                                                                              Object other$writtenByName = other.getWrittenByName();
                                                                              if (this$writtenByName == null
                                                                                 ? other$writtenByName == null
                                                                                 : this$writtenByName.equals(other$writtenByName)) {
                                                                                 Object this$auditorName = this.getAuditorName();
                                                                                 Object other$auditorName = other.getAuditorName();
                                                                                 if (this$auditorName == null
                                                                                    ? other$auditorName == null
                                                                                    : this$auditorName.equals(other$auditorName)) {
                                                                                    Object this$auditTime = this.getAuditTime();
                                                                                    Object other$auditTime = other.getAuditTime();
                                                                                    if (this$auditTime == null
                                                                                       ? other$auditTime == null
                                                                                       : this$auditTime.equals(other$auditTime)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$accessoryId = this.getAccessoryId();
                                                                                          Object other$accessoryId = other.getAccessoryId();
                                                                                          if (this$accessoryId == null
                                                                                             ? other$accessoryId == null
                                                                                             : this$accessoryId.equals(other$accessoryId)) {
                                                                                             Object this$attachmentIds = this.getAttachmentIds();
                                                                                             Object other$attachmentIds = other.getAttachmentIds();
                                                                                             return this$attachmentIds == null
                                                                                                ? other$attachmentIds == null
                                                                                                : this$attachmentIds.equals(other$attachmentIds);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractCollection;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionBankAccount = this.getCollectionBankAccount();
      result = result * 59 + ($collectionBankAccount == null ? 43 : $collectionBankAccount.hashCode());
      Object $collectionDate = this.getCollectionDate();
      result = result * 59 + ($collectionDate == null ? 43 : $collectionDate.hashCode());
      Object $acceptanceDraftJson = this.getAcceptanceDraftJson();
      result = result * 59 + ($acceptanceDraftJson == null ? 43 : $acceptanceDraftJson.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionReason = this.getCollectionReason();
      result = result * 59 + ($collectionReason == null ? 43 : $collectionReason.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $accessoryId = this.getAccessoryId();
      result = result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class ContractCollectionBuilder {
      private Long id;
      private Integer type;
      private Long projectId;
      private Integer projectAttribute;
      private String voucherNumber;
      private Long contractWasteId;
      private Long collectionUnitId;
      private String collectionUnit;
      private Long collectionBankAccountId;
      private String collectionDepositBank;
      private String collectionBankAccount;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private String acceptanceDraftJson;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private Long writtenById;
      private String writtenByName;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private Long lastEditorUserId;
      private Long projectManagerId;
      private String remark;
      private String accessoryId;
      private String attachmentIds;

      ContractCollectionBuilder() {
      }

      public ContractCollection.ContractCollectionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder acceptanceDraftJson(final String acceptanceDraftJson) {
         this.acceptanceDraftJson = acceptanceDraftJson;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder accessoryId(final String accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractCollection.ContractCollectionBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractCollection build() {
         return new ContractCollection(
            this.id,
            this.type,
            this.projectId,
            this.projectAttribute,
            this.voucherNumber,
            this.contractWasteId,
            this.collectionUnitId,
            this.collectionUnit,
            this.collectionBankAccountId,
            this.collectionDepositBank,
            this.collectionBankAccount,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftJson,
            this.collectionAmount,
            this.collectionReason,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.writtenById,
            this.writtenByName,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.auditStatus,
            this.lastEditorUserId,
            this.projectManagerId,
            this.remark,
            this.accessoryId,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "ContractCollection.ContractCollectionBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", voucherNumber="
            + this.voucherNumber
            + ", contractWasteId="
            + this.contractWasteId
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionUnit="
            + this.collectionUnit
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionBankAccount="
            + this.collectionBankAccount
            + ", collectionDate="
            + this.collectionDate
            + ", collectionMode="
            + this.collectionMode
            + ", acceptanceDraftJson="
            + this.acceptanceDraftJson
            + ", collectionAmount="
            + this.collectionAmount
            + ", collectionReason="
            + this.collectionReason
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", projectManagerId="
            + this.projectManagerId
            + ", remark="
            + this.remark
            + ", accessoryId="
            + this.accessoryId
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
