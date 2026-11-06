package com.hzchum.scim.contract.core.api.pojo._do;

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
import javax.persistence.Table;

@ApiModel(value = "ContractInvoice对象", description = "合同发票")
@Entity
@TableName("contract_invoice")
@Table(name = "contract_invoice")
public class ContractInvoice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "开票类型 1项目开票 2废料开票 CreateInvoiceTypeEnum")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' comment '开票类型 1项目开票 2废料开票'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) default 0 comment '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   @TableField("contract_waste_id")
   @Column(name = "contract_waste_id", columnDefinition = "bigint(20) default 0 comment '废料合同id'", nullable = false)
   private Long contractWasteId;
   @ApiModelProperty(name = "invoiceAmount", value = "申请发票面额(元)")
   @TableField("invoice_amount")
   @Column(name = "invoice_amount", columnDefinition = "decimal(32,2) comment '申请发票面额(元)'", nullable = false)
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "actualInvoiceAmount", value = "实开发票面额(元)")
   @TableField("actual_invoice_amount")
   @Column(name = "actual_invoice_amount", columnDefinition = "decimal(32,2) comment '实开发票面额(元)'", nullable = true)
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   @TableField("voucher_number")
   @Column(name = "voucher_number", columnDefinition = "varchar(128) default '0' comment '凭证号'", nullable = false)
   private String voucherNumber;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位(合同签约主体ID)id")
   @TableField("invoice_unit_id")
   @Column(name = "invoice_unit_id", columnDefinition = "bigint(20) comment '开票单位ID(合同签约主体ID)'", nullable = false)
   private Long invoiceUnitId;
   @ApiModelProperty(name = "invoiceUnit", value = "开票单位")
   @TableField("invoice_unit")
   @Column(name = "invoice_unit", columnDefinition = "varchar(255) comment '开票单位(合同签约主体)'")
   private String invoiceUnit;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位(客户单位)")
   @TableField("collection_unit")
   @Column(name = "collection_unit", columnDefinition = "varchar(255) comment '收票单位(默认合同内客户单位)'")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "开票日期")
   @TableField("invoice_date")
   @Column(name = "invoice_date", columnDefinition = "datetime comment '开票日期'", nullable = false)
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @TableField("invoice_no")
   @Column(name = "invoice_no", columnDefinition = "varchar(255) comment '发票号码'", nullable = false)
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int(11) comment '发票类型 1增值专用票 2增值普发票 4收据'", nullable = false)
   private Integer invoiceType;
   @ApiModelProperty(name = "tax", value = "税额")
   @TableField("tax")
   @Column(name = "tax", columnDefinition = "decimal(32,8) default 0 comment '税额'", nullable = false)
   private BigDecimal tax;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   @TableField("bool_include_tax")
   @Column(name = "bool_include_tax", columnDefinition = "tinyint(1) default 1 COMMENT '是否含税 1含税 0免税'", nullable = false)
   private Boolean boolIncludeTax;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典配置税率value值")
   @TableField("tax_rate_type_value")
   @Column(name = "tax_rate_type_value", columnDefinition = "varchar(16) comment '税率'")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(8,4) default 0 comment '税率'", nullable = false)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceContent", value = "发票内容")
   @TableField("invoice_content")
   @Column(name = "invoice_content", columnDefinition = "varchar(255) comment '发票内容'")
   private String invoiceContent;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   @TableField("written_by_id")
   @Column(name = "written_by_id", columnDefinition = "bigint(20) comment '填报人id'", nullable = false)
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人姓名")
   @TableField("written_by_name")
   @Column(name = "written_by_name")
   private String writtenByName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1审核中 2审核通过4已驳回")
   @TableField("audit_status")
   @Column(name = "audit_status")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   @TableField("auditor_id")
   @Column(name = "auditor_id", columnDefinition = "bigint(20) comment '审核人ID'")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   @TableField("auditor_name")
   @Column(name = "auditor_name", columnDefinition = "varchar(255) comment '审核人'")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime comment '审核时间'")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   @TableField("last_editor_user_id")
   @Column(name = "last_editor_user_id", columnDefinition = "bigint(20) comment '最后编辑人id'")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20) comment '项目经理id'")
   private Long projectManagerId;
   @ApiModelProperty(name = "attachments", value = "附件id字符串")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments", columnDefinition = "varchar(1024) comment '附件ID字符串'")
   private String attachments;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方银行")
   @TableField("payment_deposit_bank")
   @Column(name = "payment_deposit_bank", columnDefinition = "varchar(255) comment '付款方银行'")
   private String paymentDepositBank;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位(项目合同签订主体)id")
   @TableField("collection_unit_id")
   @Column(name = "collection_unit_id", columnDefinition = "bigint(20) comment '收款单位(项目合同签订主体)id'", nullable = true)
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款方银行")
   @TableField("collection_deposit_bank")
   @Column(name = "collection_deposit_bank", columnDefinition = "varchar(255) comment '收款方银行'")
   private String collectionDepositBank;
   @ApiModelProperty(name = "priceExcludingTax", value = "不含税金额")
   @TableField("price_excluding_tax")
   @Column(name = "price_excluding_tax", columnDefinition = "decimal(32,8) default 0 comment '不含税金额'", nullable = true)
   private BigDecimal priceExcludingTax;

   public static ContractInvoice.ContractInvoiceBuilder builder() {
      return new ContractInvoice.ContractInvoiceBuilder();
   }

   public ContractInvoice() {
   }

   public ContractInvoice(
      final Long id,
      final Integer type,
      final Long projectId,
      final Long contractWasteId,
      final BigDecimal invoiceAmount,
      final BigDecimal actualInvoiceAmount,
      final String voucherNumber,
      final Long invoiceUnitId,
      final String invoiceUnit,
      final String collectionUnit,
      final LocalDateTime invoiceDate,
      final String invoiceNo,
      final Integer invoiceType,
      final BigDecimal tax,
      final Boolean boolIncludeTax,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final String invoiceContent,
      final Long writtenById,
      final String writtenByName,
      final Integer auditStatus,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Long lastEditorUserId,
      final String remark,
      final Long projectManagerId,
      final String attachments,
      final String paymentDepositBank,
      final Long collectionUnitId,
      final String collectionDepositBank,
      final BigDecimal priceExcludingTax
   ) {
      this.id = id;
      this.type = type;
      this.projectId = projectId;
      this.contractWasteId = contractWasteId;
      this.invoiceAmount = invoiceAmount;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.voucherNumber = voucherNumber;
      this.invoiceUnitId = invoiceUnitId;
      this.invoiceUnit = invoiceUnit;
      this.collectionUnit = collectionUnit;
      this.invoiceDate = invoiceDate;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.tax = tax;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.invoiceContent = invoiceContent;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.auditStatus = auditStatus;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.lastEditorUserId = lastEditorUserId;
      this.remark = remark;
      this.projectManagerId = projectManagerId;
      this.attachments = attachments;
      this.paymentDepositBank = paymentDepositBank;
      this.collectionUnitId = collectionUnitId;
      this.collectionDepositBank = collectionDepositBank;
      this.priceExcludingTax = priceExcludingTax;
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

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Long getInvoiceUnitId() {
      return this.invoiceUnitId;
   }

   public String getInvoiceUnit() {
      return this.invoiceUnit;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public String getInvoiceNo() {
      return this.invoiceNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getInvoiceContent() {
      return this.invoiceContent;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
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

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public BigDecimal getPriceExcludingTax() {
      return this.priceExcludingTax;
   }

   @JsonProperty("id")
   public ContractInvoice setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractInvoice setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractInvoice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractInvoice setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
      return this;
   }

   public ContractInvoice setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public ContractInvoice setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
      return this;
   }

   public ContractInvoice setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractInvoice setInvoiceUnitId(final Long invoiceUnitId) {
      this.invoiceUnitId = invoiceUnitId;
      return this;
   }

   public ContractInvoice setInvoiceUnit(final String invoiceUnit) {
      this.invoiceUnit = invoiceUnit;
      return this;
   }

   public ContractInvoice setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
      return this;
   }

   public ContractInvoice setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
      return this;
   }

   public ContractInvoice setInvoiceNo(final String invoiceNo) {
      this.invoiceNo = invoiceNo;
      return this;
   }

   public ContractInvoice setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public ContractInvoice setTax(final BigDecimal tax) {
      this.tax = tax;
      return this;
   }

   public ContractInvoice setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
      return this;
   }

   public ContractInvoice setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
      return this;
   }

   public ContractInvoice setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public ContractInvoice setInvoiceContent(final String invoiceContent) {
      this.invoiceContent = invoiceContent;
      return this;
   }

   public ContractInvoice setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractInvoice setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
      return this;
   }

   public ContractInvoice setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ContractInvoice setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractInvoice setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractInvoice setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ContractInvoice setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
      return this;
   }

   public ContractInvoice setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractInvoice setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractInvoice setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   public ContractInvoice setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
      return this;
   }

   public ContractInvoice setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
      return this;
   }

   public ContractInvoice setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
      return this;
   }

   public ContractInvoice setPriceExcludingTax(final BigDecimal priceExcludingTax) {
      this.priceExcludingTax = priceExcludingTax;
      return this;
   }

   @Override
   public String toString() {
      return "ContractInvoice(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", invoiceUnitId="
         + this.getInvoiceUnitId()
         + ", invoiceUnit="
         + this.getInvoiceUnit()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ", invoiceNo="
         + this.getInvoiceNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", tax="
         + this.getTax()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceContent="
         + this.getInvoiceContent()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", remark="
         + this.getRemark()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", attachments="
         + this.getAttachments()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", priceExcludingTax="
         + this.getPriceExcludingTax()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractInvoice)) {
         return false;
      }

      ContractInvoice other = (ContractInvoice)o;
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
               Object this$contractWasteId = this.getContractWasteId();
               Object other$contractWasteId = other.getContractWasteId();
               if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                  Object this$invoiceUnitId = this.getInvoiceUnitId();
                  Object other$invoiceUnitId = other.getInvoiceUnitId();
                  if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
                     Object this$invoiceType = this.getInvoiceType();
                     Object other$invoiceType = other.getInvoiceType();
                     if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                        Object this$boolIncludeTax = this.getBoolIncludeTax();
                        Object other$boolIncludeTax = other.getBoolIncludeTax();
                        if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                           Object this$writtenById = this.getWrittenById();
                           Object other$writtenById = other.getWrittenById();
                           if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                              Object this$auditStatus = this.getAuditStatus();
                              Object other$auditStatus = other.getAuditStatus();
                              if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                 Object this$auditorId = this.getAuditorId();
                                 Object other$auditorId = other.getAuditorId();
                                 if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                    Object this$lastEditorUserId = this.getLastEditorUserId();
                                    Object other$lastEditorUserId = other.getLastEditorUserId();
                                    if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                                       Object this$projectManagerId = this.getProjectManagerId();
                                       Object other$projectManagerId = other.getProjectManagerId();
                                       if (this$projectManagerId == null
                                          ? other$projectManagerId == null
                                          : this$projectManagerId.equals(other$projectManagerId)) {
                                          Object this$collectionUnitId = this.getCollectionUnitId();
                                          Object other$collectionUnitId = other.getCollectionUnitId();
                                          if (this$collectionUnitId == null
                                             ? other$collectionUnitId == null
                                             : this$collectionUnitId.equals(other$collectionUnitId)) {
                                             Object this$invoiceAmount = this.getInvoiceAmount();
                                             Object other$invoiceAmount = other.getInvoiceAmount();
                                             if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                                Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                                if (this$actualInvoiceAmount == null
                                                   ? other$actualInvoiceAmount == null
                                                   : this$actualInvoiceAmount.equals(other$actualInvoiceAmount)) {
                                                   Object this$voucherNumber = this.getVoucherNumber();
                                                   Object other$voucherNumber = other.getVoucherNumber();
                                                   if (this$voucherNumber == null
                                                      ? other$voucherNumber == null
                                                      : this$voucherNumber.equals(other$voucherNumber)) {
                                                      Object this$invoiceUnit = this.getInvoiceUnit();
                                                      Object other$invoiceUnit = other.getInvoiceUnit();
                                                      if (this$invoiceUnit == null ? other$invoiceUnit == null : this$invoiceUnit.equals(other$invoiceUnit)) {
                                                         Object this$collectionUnit = this.getCollectionUnit();
                                                         Object other$collectionUnit = other.getCollectionUnit();
                                                         if (this$collectionUnit == null
                                                            ? other$collectionUnit == null
                                                            : this$collectionUnit.equals(other$collectionUnit)) {
                                                            Object this$invoiceDate = this.getInvoiceDate();
                                                            Object other$invoiceDate = other.getInvoiceDate();
                                                            if (this$invoiceDate == null
                                                               ? other$invoiceDate == null
                                                               : this$invoiceDate.equals(other$invoiceDate)) {
                                                               Object this$invoiceNo = this.getInvoiceNo();
                                                               Object other$invoiceNo = other.getInvoiceNo();
                                                               if (this$invoiceNo == null ? other$invoiceNo == null : this$invoiceNo.equals(other$invoiceNo)) {
                                                                  Object this$tax = this.getTax();
                                                                  Object other$tax = other.getTax();
                                                                  if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                                                     Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                                     Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                                     if (this$taxRateTypeValue == null
                                                                        ? other$taxRateTypeValue == null
                                                                        : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                                        Object this$taxRate = this.getTaxRate();
                                                                        Object other$taxRate = other.getTaxRate();
                                                                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                           Object this$invoiceContent = this.getInvoiceContent();
                                                                           Object other$invoiceContent = other.getInvoiceContent();
                                                                           if (this$invoiceContent == null
                                                                              ? other$invoiceContent == null
                                                                              : this$invoiceContent.equals(other$invoiceContent)) {
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
                                                                                          Object this$attachments = this.getAttachments();
                                                                                          Object other$attachments = other.getAttachments();
                                                                                          if (this$attachments == null
                                                                                             ? other$attachments == null
                                                                                             : this$attachments.equals(other$attachments)) {
                                                                                             Object this$paymentDepositBank = this.getPaymentDepositBank();
                                                                                             Object other$paymentDepositBank = other.getPaymentDepositBank();
                                                                                             if (this$paymentDepositBank == null
                                                                                                ? other$paymentDepositBank == null
                                                                                                : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                                                                                Object this$collectionDepositBank = this.getCollectionDepositBank();
                                                                                                Object other$collectionDepositBank = other.getCollectionDepositBank();
                                                                                                if (this$collectionDepositBank == null
                                                                                                   ? other$collectionDepositBank == null
                                                                                                   : this$collectionDepositBank.equals(
                                                                                                      other$collectionDepositBank
                                                                                                   )) {
                                                                                                   Object this$priceExcludingTax = this.getPriceExcludingTax();
                                                                                                   Object other$priceExcludingTax = other.getPriceExcludingTax();
                                                                                                   return this$priceExcludingTax == null
                                                                                                      ? other$priceExcludingTax == null
                                                                                                      : this$priceExcludingTax.equals(other$priceExcludingTax);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractInvoice;
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
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      result = result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $invoiceUnit = this.getInvoiceUnit();
      result = result * 59 + ($invoiceUnit == null ? 43 : $invoiceUnit.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceContent = this.getInvoiceContent();
      result = result * 59 + ($invoiceContent == null ? 43 : $invoiceContent.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $priceExcludingTax = this.getPriceExcludingTax();
      return result * 59 + ($priceExcludingTax == null ? 43 : $priceExcludingTax.hashCode());
   }

   public static class ContractInvoiceBuilder {
      private Long id;
      private Integer type;
      private Long projectId;
      private Long contractWasteId;
      private BigDecimal invoiceAmount;
      private BigDecimal actualInvoiceAmount;
      private String voucherNumber;
      private Long invoiceUnitId;
      private String invoiceUnit;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private Integer invoiceType;
      private BigDecimal tax;
      private Boolean boolIncludeTax;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private String invoiceContent;
      private Long writtenById;
      private String writtenByName;
      private Integer auditStatus;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Long lastEditorUserId;
      private String remark;
      private Long projectManagerId;
      private String attachments;
      private String paymentDepositBank;
      private Long collectionUnitId;
      private String collectionDepositBank;
      private BigDecimal priceExcludingTax;

      ContractInvoiceBuilder() {
      }

      @JsonProperty("id")
      public ContractInvoice.ContractInvoiceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceUnitId(final Long invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceUnit(final String invoiceUnit) {
         this.invoiceUnit = invoiceUnit;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder tax(final BigDecimal tax) {
         this.tax = tax;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractInvoice.ContractInvoiceBuilder priceExcludingTax(final BigDecimal priceExcludingTax) {
         this.priceExcludingTax = priceExcludingTax;
         return this;
      }

      public ContractInvoice build() {
         return new ContractInvoice(
            this.id,
            this.type,
            this.projectId,
            this.contractWasteId,
            this.invoiceAmount,
            this.actualInvoiceAmount,
            this.voucherNumber,
            this.invoiceUnitId,
            this.invoiceUnit,
            this.collectionUnit,
            this.invoiceDate,
            this.invoiceNo,
            this.invoiceType,
            this.tax,
            this.boolIncludeTax,
            this.taxRateTypeValue,
            this.taxRate,
            this.invoiceContent,
            this.writtenById,
            this.writtenByName,
            this.auditStatus,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.lastEditorUserId,
            this.remark,
            this.projectManagerId,
            this.attachments,
            this.paymentDepositBank,
            this.collectionUnitId,
            this.collectionDepositBank,
            this.priceExcludingTax
         );
      }

      @Override
      public String toString() {
         return "ContractInvoice.ContractInvoiceBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", contractWasteId="
            + this.contractWasteId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", voucherNumber="
            + this.voucherNumber
            + ", invoiceUnitId="
            + this.invoiceUnitId
            + ", invoiceUnit="
            + this.invoiceUnit
            + ", collectionUnit="
            + this.collectionUnit
            + ", invoiceDate="
            + this.invoiceDate
            + ", invoiceNo="
            + this.invoiceNo
            + ", invoiceType="
            + this.invoiceType
            + ", tax="
            + this.tax
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", invoiceContent="
            + this.invoiceContent
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", auditStatus="
            + this.auditStatus
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", remark="
            + this.remark
            + ", projectManagerId="
            + this.projectManagerId
            + ", attachments="
            + this.attachments
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", priceExcludingTax="
            + this.priceExcludingTax
            + ")";
      }
   }
}
