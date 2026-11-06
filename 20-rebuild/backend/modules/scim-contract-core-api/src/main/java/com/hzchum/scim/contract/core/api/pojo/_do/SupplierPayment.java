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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SupplierPayment对象", description = "付款表")
@Entity
@TableName("contract_supplier_payment")
@Table(name = "contract_supplier_payment")
public class SupplierPayment extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("订单id ")
   @Column
   private Long orderId;
   @ApiModelProperty("OA编号")
   @Column(name = "oa_number", columnDefinition = "varchar(255) comment 'OA编号'")
   private String oaNumber;
   @ApiModelProperty("项目id ")
   @Column
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) comment '项目属性: 1.自营 2.合营 3.包干制'")
   private Integer projectAttribute;
   @ApiModelProperty("项目经理id")
   @Column
   private Long projectManagerId;
   @ApiModelProperty("供应商id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20) DEFAULT 0 comment '供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty("订单签订主体id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20) DEFAULT 0 comment '订单签订主体id'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty("付款额")
   @Column
   private BigDecimal paymentAmount;
   @ApiModelProperty("类型 1原材料-采购费 2运输费 4制成品-采购费 8分包费")
   @Column(name = "property_type", columnDefinition = "int(11) DEFAULT 1 comment '属性 1.原材料-采购费 2.运输费 4.制成品-采购费 8.分包费'", nullable = false)
   private Integer propertyType;
   @ApiModelProperty("付款单位id")
   @Column
   private Long paymentUnitId;
   @ApiModelProperty("付款单位")
   @Column
   private String paymentUnit;
   @ApiModelProperty("收款单位id(订单供应商id)")
   @Column
   private Long receivingUnitId;
   @ApiModelProperty("收款单位")
   @Column
   private String receivingUnit;
   @ApiModelProperty("编号")
   @Column
   private String serialNumber;
   @ApiModelProperty("申请金额")
   @Column
   private BigDecimal applyAmount;
   @ApiModelProperty("违约金额")
   @Column
   private BigDecimal breachAmount;
   @ApiModelProperty("是否扣除")
   @Column
   private Boolean boolDeduct;
   @ApiModelProperty("付款事由id")
   @Column
   private String paymentReasonId;
   @ApiModelProperty("付款事由名称")
   private String paymentReasonName;
   @ApiModelProperty("付款属性id")
   @TableField("payment_attribute_id")
   @Column(name = "payment_attribute_id", columnDefinition = "bigint(20) comment '付款属性id'", nullable = true)
   private Long paymentAttributeId;
   @ApiModelProperty("付款属性名称")
   @TableField("payment_attribute_name")
   @Column(name = "payment_attribute_name", columnDefinition = "varchar(255) comment '付款属性名称'", nullable = true)
   private String paymentAttributeName;
   @ApiModelProperty("付款日期")
   @Column
   private LocalDate paymentDate;
   @ApiModelProperty("收款银行")
   @Column
   private String receiveBank;
   @ApiModelProperty("收款账号")
   @Column
   private String receiveBankAccount;
   @ApiModelProperty("申请人id")
   @Column
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   @Column
   private String applyUserName;
   @ApiModelProperty("附件id字符串")
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   @Column
   private String attachmentIds;
   @ApiModelProperty("备注")
   @Column
   private String remark;
   @ApiModelProperty("实付金额")
   @Column
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款方式 1对公转账 2对私转账 4承兑汇票 8转账支票")
   @Column
   private Integer paymentMethod;
   @ApiModelProperty("付款银行")
   @Column
   private String paymentBank;
   @ApiModelProperty("付款账号")
   @Column
   private String paymentBankAccount;
   @ApiModelProperty("审核人id")
   @Column
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   @Column
   private String auditUserName;
   @ApiModelProperty("审核时间")
   @Column
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回,8撤回")
   @Column
   private Integer auditStatus;
   @ApiModelProperty("剩余金额")
   @Column
   private BigDecimal residualAmount;
   @ApiModelProperty(name = "approvalSerialNumber", value = "审批流水号", notes = "审批流水号")
   @TableField("approval_serial_number")
   @Column(
      name = "approval_serial_number",
      columnDefinition = "varchar(128) COMMENT '审批流水号 规则为当年（24）-当月-（06）-当日（28）-流水号（1）即使支付日期不相同，也需要自动形成流水号，如下一次支付流水号为2'",
      nullable = true
   )
   private String approvalSerialNumber;
   @ApiModelProperty("附件id字符串")
   @TableField("audit_attachment_ids")
   @Column(name = "audit_attachment_ids", columnDefinition = "varchar(255) COMMENT '审批附件id字符串'")
   private String auditAttachmentIds;

   public static SupplierPayment.SupplierPaymentBuilder builder() {
      return new SupplierPayment.SupplierPaymentBuilder();
   }

   public SupplierPayment() {
   }

   public SupplierPayment(
      final Long id,
      final Long orderId,
      final String oaNumber,
      final Long projectId,
      final Integer projectAttribute,
      final Long projectManagerId,
      final Long supplierId,
      final Long branchCompanyId,
      final BigDecimal paymentAmount,
      final Integer propertyType,
      final Long paymentUnitId,
      final String paymentUnit,
      final Long receivingUnitId,
      final String receivingUnit,
      final String serialNumber,
      final BigDecimal applyAmount,
      final BigDecimal breachAmount,
      final Boolean boolDeduct,
      final String paymentReasonId,
      final String paymentReasonName,
      final Long paymentAttributeId,
      final String paymentAttributeName,
      final LocalDate paymentDate,
      final String receiveBank,
      final String receiveBankAccount,
      final Long applyUserId,
      final String applyUserName,
      final String attachmentIds,
      final String remark,
      final BigDecimal actuallyPaymentAmount,
      final Integer paymentMethod,
      final String paymentBank,
      final String paymentBankAccount,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final BigDecimal residualAmount,
      final String approvalSerialNumber,
      final String auditAttachmentIds
   ) {
      this.id = id;
      this.orderId = orderId;
      this.oaNumber = oaNumber;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.branchCompanyId = branchCompanyId;
      this.paymentAmount = paymentAmount;
      this.propertyType = propertyType;
      this.paymentUnitId = paymentUnitId;
      this.paymentUnit = paymentUnit;
      this.receivingUnitId = receivingUnitId;
      this.receivingUnit = receivingUnit;
      this.serialNumber = serialNumber;
      this.applyAmount = applyAmount;
      this.breachAmount = breachAmount;
      this.boolDeduct = boolDeduct;
      this.paymentReasonId = paymentReasonId;
      this.paymentReasonName = paymentReasonName;
      this.paymentAttributeId = paymentAttributeId;
      this.paymentAttributeName = paymentAttributeName;
      this.paymentDate = paymentDate;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.paymentMethod = paymentMethod;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.residualAmount = residualAmount;
      this.approvalSerialNumber = approvalSerialNumber;
      this.auditAttachmentIds = auditAttachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getOaNumber() {
      return this.oaNumber;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
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

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public String getReceivingUnit() {
      return this.receivingUnit;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Long getPaymentAttributeId() {
      return this.paymentAttributeId;
   }

   public String getPaymentAttributeName() {
      return this.paymentAttributeName;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
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

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
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

   public BigDecimal getResidualAmount() {
      return this.residualAmount;
   }

   public String getApprovalSerialNumber() {
      return this.approvalSerialNumber;
   }

   public String getAuditAttachmentIds() {
      return this.auditAttachmentIds;
   }

   @JsonProperty("id")
   public SupplierPayment setId(final Long id) {
      this.id = id;
      return this;
   }

   public SupplierPayment setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SupplierPayment setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
      return this;
   }

   public SupplierPayment setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SupplierPayment setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SupplierPayment setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public SupplierPayment setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SupplierPayment setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public SupplierPayment setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public SupplierPayment setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
      return this;
   }

   public SupplierPayment setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
      return this;
   }

   public SupplierPayment setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
      return this;
   }

   public SupplierPayment setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
      return this;
   }

   public SupplierPayment setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
      return this;
   }

   public SupplierPayment setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SupplierPayment setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   public SupplierPayment setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
      return this;
   }

   public SupplierPayment setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
      return this;
   }

   public SupplierPayment setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
      return this;
   }

   public SupplierPayment setPaymentReasonName(final String paymentReasonName) {
      this.paymentReasonName = paymentReasonName;
      return this;
   }

   public SupplierPayment setPaymentAttributeId(final Long paymentAttributeId) {
      this.paymentAttributeId = paymentAttributeId;
      return this;
   }

   public SupplierPayment setPaymentAttributeName(final String paymentAttributeName) {
      this.paymentAttributeName = paymentAttributeName;
      return this;
   }

   public SupplierPayment setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public SupplierPayment setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
      return this;
   }

   public SupplierPayment setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
      return this;
   }

   public SupplierPayment setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierPayment setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierPayment setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SupplierPayment setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierPayment setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      return this;
   }

   public SupplierPayment setPaymentMethod(final Integer paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public SupplierPayment setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public SupplierPayment setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public SupplierPayment setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public SupplierPayment setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public SupplierPayment setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public SupplierPayment setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public SupplierPayment setResidualAmount(final BigDecimal residualAmount) {
      this.residualAmount = residualAmount;
      return this;
   }

   public SupplierPayment setApprovalSerialNumber(final String approvalSerialNumber) {
      this.approvalSerialNumber = approvalSerialNumber;
      return this;
   }

   public SupplierPayment setAuditAttachmentIds(final String auditAttachmentIds) {
      this.auditAttachmentIds = auditAttachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "SupplierPayment(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", oaNumber="
         + this.getOaNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", propertyType="
         + this.getPropertyType()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", serialNumber="
         + this.getSerialNumber()
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
         + ", paymentAttributeId="
         + this.getPaymentAttributeId()
         + ", paymentAttributeName="
         + this.getPaymentAttributeName()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", residualAmount="
         + this.getResidualAmount()
         + ", approvalSerialNumber="
         + this.getApprovalSerialNumber()
         + ", auditAttachmentIds="
         + this.getAuditAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPayment)) {
         return false;
      }

      SupplierPayment other = (SupplierPayment)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
                                       Object this$paymentAttributeId = this.getPaymentAttributeId();
                                       Object other$paymentAttributeId = other.getPaymentAttributeId();
                                       if (this$paymentAttributeId == null
                                          ? other$paymentAttributeId == null
                                          : this$paymentAttributeId.equals(other$paymentAttributeId)) {
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
                                                      Object this$oaNumber = this.getOaNumber();
                                                      Object other$oaNumber = other.getOaNumber();
                                                      if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
                                                         Object this$paymentAmount = this.getPaymentAmount();
                                                         Object other$paymentAmount = other.getPaymentAmount();
                                                         if (this$paymentAmount == null
                                                            ? other$paymentAmount == null
                                                            : this$paymentAmount.equals(other$paymentAmount)) {
                                                            Object this$paymentUnit = this.getPaymentUnit();
                                                            Object other$paymentUnit = other.getPaymentUnit();
                                                            if (this$paymentUnit == null
                                                               ? other$paymentUnit == null
                                                               : this$paymentUnit.equals(other$paymentUnit)) {
                                                               Object this$receivingUnit = this.getReceivingUnit();
                                                               Object other$receivingUnit = other.getReceivingUnit();
                                                               if (this$receivingUnit == null
                                                                  ? other$receivingUnit == null
                                                                  : this$receivingUnit.equals(other$receivingUnit)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
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
                                                                                 Object this$paymentAttributeName = this.getPaymentAttributeName();
                                                                                 Object other$paymentAttributeName = other.getPaymentAttributeName();
                                                                                 if (this$paymentAttributeName == null
                                                                                    ? other$paymentAttributeName == null
                                                                                    : this$paymentAttributeName.equals(other$paymentAttributeName)) {
                                                                                    Object this$paymentDate = this.getPaymentDate();
                                                                                    Object other$paymentDate = other.getPaymentDate();
                                                                                    if (this$paymentDate == null
                                                                                       ? other$paymentDate == null
                                                                                       : this$paymentDate.equals(other$paymentDate)) {
                                                                                       Object this$receiveBank = this.getReceiveBank();
                                                                                       Object other$receiveBank = other.getReceiveBank();
                                                                                       if (this$receiveBank == null
                                                                                          ? other$receiveBank == null
                                                                                          : this$receiveBank.equals(other$receiveBank)) {
                                                                                          Object this$receiveBankAccount = this.getReceiveBankAccount();
                                                                                          Object other$receiveBankAccount = other.getReceiveBankAccount();
                                                                                          if (this$receiveBankAccount == null
                                                                                             ? other$receiveBankAccount == null
                                                                                             : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                                                                                             Object this$applyUserName = this.getApplyUserName();
                                                                                             Object other$applyUserName = other.getApplyUserName();
                                                                                             if (this$applyUserName == null
                                                                                                ? other$applyUserName == null
                                                                                                : this$applyUserName.equals(other$applyUserName)) {
                                                                                                Object this$attachmentIds = this.getAttachmentIds();
                                                                                                Object other$attachmentIds = other.getAttachmentIds();
                                                                                                if (this$attachmentIds == null
                                                                                                   ? other$attachmentIds == null
                                                                                                   : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
                                                                                                      Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                                                                                      Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                                                                                      if (this$actuallyPaymentAmount == null
                                                                                                         ? other$actuallyPaymentAmount == null
                                                                                                         : this$actuallyPaymentAmount.equals(
                                                                                                            other$actuallyPaymentAmount
                                                                                                         )) {
                                                                                                         Object this$paymentBank = this.getPaymentBank();
                                                                                                         Object other$paymentBank = other.getPaymentBank();
                                                                                                         if (this$paymentBank == null
                                                                                                            ? other$paymentBank == null
                                                                                                            : this$paymentBank.equals(other$paymentBank)) {
                                                                                                            Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                                                                            Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                                                                            if (this$paymentBankAccount == null
                                                                                                               ? other$paymentBankAccount == null
                                                                                                               : this$paymentBankAccount.equals(
                                                                                                                  other$paymentBankAccount
                                                                                                               )) {
                                                                                                               Object this$auditUserName = this.getAuditUserName();
                                                                                                               Object other$auditUserName = other.getAuditUserName();
                                                                                                               if (this$auditUserName == null
                                                                                                                  ? other$auditUserName == null
                                                                                                                  : this$auditUserName.equals(
                                                                                                                     other$auditUserName
                                                                                                                  )) {
                                                                                                                  Object this$auditTime = this.getAuditTime();
                                                                                                                  Object other$auditTime = other.getAuditTime();
                                                                                                                  if (this$auditTime == null
                                                                                                                     ? other$auditTime == null
                                                                                                                     : this$auditTime.equals(other$auditTime)) {
                                                                                                                     Object this$residualAmount = this.getResidualAmount();
                                                                                                                     Object other$residualAmount = other.getResidualAmount();
                                                                                                                     if (this$residualAmount == null
                                                                                                                        ? other$residualAmount == null
                                                                                                                        : this$residualAmount.equals(
                                                                                                                           other$residualAmount
                                                                                                                        )) {
                                                                                                                        Object this$approvalSerialNumber = this.getApprovalSerialNumber();
                                                                                                                        Object other$approvalSerialNumber = other.getApprovalSerialNumber();
                                                                                                                        if (this$approvalSerialNumber == null
                                                                                                                           ? other$approvalSerialNumber == null
                                                                                                                           : this$approvalSerialNumber.equals(
                                                                                                                              other$approvalSerialNumber
                                                                                                                           )) {
                                                                                                                           Object this$auditAttachmentIds = this.getAuditAttachmentIds();
                                                                                                                           Object other$auditAttachmentIds = other.getAuditAttachmentIds();
                                                                                                                           return this$auditAttachmentIds
                                                                                                                                 == null
                                                                                                                              ? other$auditAttachmentIds
                                                                                                                                 == null
                                                                                                                              : this$auditAttachmentIds.equals(
                                                                                                                                 other$auditAttachmentIds
                                                                                                                              );
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
      return other instanceof SupplierPayment;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $paymentAttributeId = this.getPaymentAttributeId();
      result = result * 59 + ($paymentAttributeId == null ? 43 : $paymentAttributeId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentReasonName = this.getPaymentReasonName();
      result = result * 59 + ($paymentReasonName == null ? 43 : $paymentReasonName.hashCode());
      Object $paymentAttributeName = this.getPaymentAttributeName();
      result = result * 59 + ($paymentAttributeName == null ? 43 : $paymentAttributeName.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $residualAmount = this.getResidualAmount();
      result = result * 59 + ($residualAmount == null ? 43 : $residualAmount.hashCode());
      Object $approvalSerialNumber = this.getApprovalSerialNumber();
      result = result * 59 + ($approvalSerialNumber == null ? 43 : $approvalSerialNumber.hashCode());
      Object $auditAttachmentIds = this.getAuditAttachmentIds();
      return result * 59 + ($auditAttachmentIds == null ? 43 : $auditAttachmentIds.hashCode());
   }

   public static class SupplierPaymentBuilder {
      private Long id;
      private Long orderId;
      private String oaNumber;
      private Long projectId;
      private Integer projectAttribute;
      private Long projectManagerId;
      private Long supplierId;
      private Long branchCompanyId;
      private BigDecimal paymentAmount;
      private Integer propertyType;
      private Long paymentUnitId;
      private String paymentUnit;
      private Long receivingUnitId;
      private String receivingUnit;
      private String serialNumber;
      private BigDecimal applyAmount;
      private BigDecimal breachAmount;
      private Boolean boolDeduct;
      private String paymentReasonId;
      private String paymentReasonName;
      private Long paymentAttributeId;
      private String paymentAttributeName;
      private LocalDate paymentDate;
      private String receiveBank;
      private String receiveBankAccount;
      private Long applyUserId;
      private String applyUserName;
      private String attachmentIds;
      private String remark;
      private BigDecimal actuallyPaymentAmount;
      private Integer paymentMethod;
      private String paymentBank;
      private String paymentBankAccount;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private BigDecimal residualAmount;
      private String approvalSerialNumber;
      private String auditAttachmentIds;

      SupplierPaymentBuilder() {
      }

      @JsonProperty("id")
      public SupplierPayment.SupplierPaymentBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder oaNumber(final String oaNumber) {
         this.oaNumber = oaNumber;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder propertyType(final Integer propertyType) {
         this.propertyType = propertyType;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder receivingUnitId(final Long receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder receivingUnit(final String receivingUnit) {
         this.receivingUnit = receivingUnit;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder breachAmount(final BigDecimal breachAmount) {
         this.breachAmount = breachAmount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder boolDeduct(final Boolean boolDeduct) {
         this.boolDeduct = boolDeduct;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentReasonId(final String paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentReasonName(final String paymentReasonName) {
         this.paymentReasonName = paymentReasonName;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentAttributeId(final Long paymentAttributeId) {
         this.paymentAttributeId = paymentAttributeId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentAttributeName(final String paymentAttributeName) {
         this.paymentAttributeName = paymentAttributeName;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentDate(final LocalDate paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder receiveBank(final String receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentMethod(final Integer paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder residualAmount(final BigDecimal residualAmount) {
         this.residualAmount = residualAmount;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder approvalSerialNumber(final String approvalSerialNumber) {
         this.approvalSerialNumber = approvalSerialNumber;
         return this;
      }

      public SupplierPayment.SupplierPaymentBuilder auditAttachmentIds(final String auditAttachmentIds) {
         this.auditAttachmentIds = auditAttachmentIds;
         return this;
      }

      public SupplierPayment build() {
         return new SupplierPayment(
            this.id,
            this.orderId,
            this.oaNumber,
            this.projectId,
            this.projectAttribute,
            this.projectManagerId,
            this.supplierId,
            this.branchCompanyId,
            this.paymentAmount,
            this.propertyType,
            this.paymentUnitId,
            this.paymentUnit,
            this.receivingUnitId,
            this.receivingUnit,
            this.serialNumber,
            this.applyAmount,
            this.breachAmount,
            this.boolDeduct,
            this.paymentReasonId,
            this.paymentReasonName,
            this.paymentAttributeId,
            this.paymentAttributeName,
            this.paymentDate,
            this.receiveBank,
            this.receiveBankAccount,
            this.applyUserId,
            this.applyUserName,
            this.attachmentIds,
            this.remark,
            this.actuallyPaymentAmount,
            this.paymentMethod,
            this.paymentBank,
            this.paymentBankAccount,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.residualAmount,
            this.approvalSerialNumber,
            this.auditAttachmentIds
         );
      }

      @Override
      public String toString() {
         return "SupplierPayment.SupplierPaymentBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", oaNumber="
            + this.oaNumber
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", projectManagerId="
            + this.projectManagerId
            + ", supplierId="
            + this.supplierId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", paymentAmount="
            + this.paymentAmount
            + ", propertyType="
            + this.propertyType
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentUnit="
            + this.paymentUnit
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", receivingUnit="
            + this.receivingUnit
            + ", serialNumber="
            + this.serialNumber
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
            + ", paymentAttributeId="
            + this.paymentAttributeId
            + ", paymentAttributeName="
            + this.paymentAttributeName
            + ", paymentDate="
            + this.paymentDate
            + ", receiveBank="
            + this.receiveBank
            + ", receiveBankAccount="
            + this.receiveBankAccount
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ", paymentMethod="
            + this.paymentMethod
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", residualAmount="
            + this.residualAmount
            + ", approvalSerialNumber="
            + this.approvalSerialNumber
            + ", auditAttachmentIds="
            + this.auditAttachmentIds
            + ")";
      }
   }
}
