package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "LogisticsOrder对象", description = " 物流订单 ")
@Entity
@TableName("scm_logistics_order")
@Table(name = "scm_logistics_order")
public class LogisticsOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "purchaseId", value = "采购单ID")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id")
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseType", value = "采购类型")
   @JsonProperty("purchaseType")
   @JSONField(name = "purchaseType")
   @TableField("purchase_type")
   @Column(name = "purchase_type")
   private Integer purchaseType;
   @ApiModelProperty(name = "invoiceType", value = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "serialNumber", value = "物流订单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "shipmentNumber", value = "快递单编号")
   @JsonProperty("shipmentNumber")
   @JSONField(name = "shipmentNumber")
   @TableField("shipment_number")
   @Column(name = "shipment_number")
   private String shipmentNumber;
   @ApiModelProperty(name = "logisticsTransportType", value = "物流运输方式,参考枚举[LogisticsTransportTypeEnum]")
   @JsonProperty("logisticsTransportType")
   @JSONField(name = "logisticsTransportType")
   @TableField(value = "logistics_transport_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "logistics_transport_type")
   private Integer logisticsTransportType;
   @ApiModelProperty(name = "logisticsPayerType", value = "付款方,参考[LogisticsPayerEnum]")
   @JsonProperty("logisticsPayerType")
   @JSONField(name = "logisticsPayerType")
   @TableField(value = "logistics_payer_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "logistics_payer_type")
   private Integer logisticsPayerType;
   @ApiModelProperty(name = "inboundSn", value = "入库单号")
   @JsonProperty("inboundSn")
   @JSONField(name = "inboundSn")
   @TableField("inbound_SN")
   @Column(name = "inbound_SN")
   private String inboundSn;
   @ApiModelProperty(name = "inboundId", value = "入库ID")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id")
   private Long inboundId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单号")
   @JsonProperty("purchaseSn")
   @JSONField(name = "purchaseSn")
   @TableField("purchase_SN")
   @Column(name = "purchase_SN")
   private String purchaseSn;
   @ApiModelProperty(name = "licensePlate", value = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   @TableField("license_plate")
   @Column(name = "license_plate")
   private String licensePlate;
   @ApiModelProperty(name = "projectIds", value = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids")
   private String projectIds;
   @ApiModelProperty(name = "loadingWeight", value = "装载重量")
   @JsonProperty("loadingWeight")
   @JSONField(name = "loadingWeight")
   @TableField("loading_weight")
   @Column(name = "loading_weight")
   private BigDecimal loadingWeight;
   @ApiModelProperty(name = "taxRate", value = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "freight", value = "运费")
   @JsonProperty("freight")
   @JSONField(name = "freight")
   @TableField("freight")
   @Column(name = "freight")
   private BigDecimal freight;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税金额")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT")
   private BigDecimal inputVat;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "supplierId", value = "供应商ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name")
   private String supplierName;
   @ApiModelProperty(name = "applicantId", value = "创建人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "创建人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name")
   private String applicantName;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time")
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "inboundReviewStatus", value = "审核状态 [1未审核, 2审核通过, 4退回]")
   @JsonProperty("inboundReviewStatus")
   @JSONField(name = "inboundReviewStatus")
   @TableField("inbound_review_status")
   @Column(name = "inbound_review_status")
   private Integer inboundReviewStatus;
   @ApiModelProperty(name = "freightWeight", value = "运重")
   @JsonProperty("freightWeight")
   @JSONField(name = "freightWeight")
   @TableField("freight_weight")
   @Column(name = "freight_weight")
   private BigDecimal freightWeight;
   @ApiModelProperty(name = "loadingCharge", value = "装车费 含税")
   @JsonProperty("loadingCharge")
   @JSONField(name = "loadingCharge")
   @TableField("loading_charge")
   @Column(name = "loading_charge", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal loadingCharge;
   @ApiModelProperty(name = "loadingChargeExcludingVat", value = "装车费 不含税")
   @JsonProperty("loadingChargeExcludingVat")
   @JSONField(name = "loadingChargeExcludingVat")
   @TableField("loading_charge_excluding_vat")
   @Column(name = "loading_charge_excluding_vat", columnDefinition = "decimal(19,2)  COMMENT '装车费 不含税'", nullable = true)
   private BigDecimal loadingChargeExcludingVat;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型 默认为1正常 ChangeFreightEnum")
   @JsonProperty("changeFreight")
   @JSONField(name = "changeFreight")
   @TableField("change_freight")
   @Column(name = "change_freight", columnDefinition = "int(11) default 1  COMMENT '运费变更类型 默认为1正常 ChangeFreightEnum'", nullable = true)
   private Integer changeFreight;
   @ApiModelProperty(name = "freightInitial", value = "初始运费")
   @JsonProperty("freightInitial")
   @JSONField(name = "freightInitial")
   @TableField("freight_initial")
   @Column(name = "freight_initial", columnDefinition = "decimal(19,2)  COMMENT '初始运费'", nullable = true)
   private BigDecimal freightInitial;
   @ApiModelProperty(name = "amountExcludingVatInitial", value = "初始运费 不含税金额")
   @JsonProperty("amountExcludingVatInitial")
   @JSONField(name = "amountExcludingVatInitial")
   @TableField("amount_excluding_VAT_initial")
   @Column(name = "amount_excluding_VAT_initial", columnDefinition = "decimal(19,2)  COMMENT '初始运费 不含税金额'", nullable = true)
   private BigDecimal amountExcludingVatInitial;
   @ApiModelProperty(name = "inputVatInitial", value = "初始 进项税")
   @JsonProperty("inputVatInitial")
   @JSONField(name = "inputVatInitial")
   @TableField("input_VAT_initial")
   @Column(name = "input_VAT_initial", columnDefinition = "decimal(19,2)  COMMENT '初始 进项税'", nullable = true)
   private BigDecimal inputVatInitial;
   @ApiModelProperty(name = "tableNameType", value = "表名称枚举值 TableNameTypeEnum")
   @JsonProperty("tableNameType")
   @JSONField(name = "tableNameType")
   @TableField("table_name_type")
   @Column(name = "table_name_type", columnDefinition = "int default '1' COMMENT '表名称枚举值 TableNameTypeEnum'", nullable = true)
   private Integer tableNameType;

   public static LogisticsOrder.LogisticsOrderBuilder builder() {
      return new LogisticsOrder.LogisticsOrderBuilder();
   }

   public LogisticsOrder() {
   }

   public LogisticsOrder(
      final Long id,
      final Integer basicClass,
      final Long purchaseId,
      final Integer purchaseType,
      final Integer invoiceType,
      final String serialNumber,
      final String shipmentNumber,
      final Integer logisticsTransportType,
      final Integer logisticsPayerType,
      final String inboundSn,
      final Long inboundId,
      final String purchaseSn,
      final String licensePlate,
      final String projectIds,
      final BigDecimal loadingWeight,
      final BigDecimal taxRate,
      final BigDecimal freight,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final String remark,
      final Long supplierId,
      final String supplierName,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime userUpdateTime,
      final Integer inboundReviewStatus,
      final BigDecimal freightWeight,
      final BigDecimal loadingCharge,
      final BigDecimal loadingChargeExcludingVat,
      final Integer changeFreight,
      final BigDecimal freightInitial,
      final BigDecimal amountExcludingVatInitial,
      final BigDecimal inputVatInitial,
      final Integer tableNameType
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.purchaseId = purchaseId;
      this.purchaseType = purchaseType;
      this.invoiceType = invoiceType;
      this.serialNumber = serialNumber;
      this.shipmentNumber = shipmentNumber;
      this.logisticsTransportType = logisticsTransportType;
      this.logisticsPayerType = logisticsPayerType;
      this.inboundSn = inboundSn;
      this.inboundId = inboundId;
      this.purchaseSn = purchaseSn;
      this.licensePlate = licensePlate;
      this.projectIds = projectIds;
      this.loadingWeight = loadingWeight;
      this.taxRate = taxRate;
      this.freight = freight;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.remark = remark;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.userUpdateTime = userUpdateTime;
      this.inboundReviewStatus = inboundReviewStatus;
      this.freightWeight = freightWeight;
      this.loadingCharge = loadingCharge;
      this.loadingChargeExcludingVat = loadingChargeExcludingVat;
      this.changeFreight = changeFreight;
      this.freightInitial = freightInitial;
      this.amountExcludingVatInitial = amountExcludingVatInitial;
      this.inputVatInitial = inputVatInitial;
      this.tableNameType = tableNameType;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public String getInboundSn() {
      return this.inboundSn;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Integer getInboundReviewStatus() {
      return this.inboundReviewStatus;
   }

   public BigDecimal getFreightWeight() {
      return this.freightWeight;
   }

   public BigDecimal getLoadingCharge() {
      return this.loadingCharge;
   }

   public BigDecimal getLoadingChargeExcludingVat() {
      return this.loadingChargeExcludingVat;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public BigDecimal getFreightInitial() {
      return this.freightInitial;
   }

   public BigDecimal getAmountExcludingVatInitial() {
      return this.amountExcludingVatInitial;
   }

   public BigDecimal getInputVatInitial() {
      return this.inputVatInitial;
   }

   public Integer getTableNameType() {
      return this.tableNameType;
   }

   @JsonProperty("id")
   public LogisticsOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public LogisticsOrder setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("purchaseId")
   public LogisticsOrder setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("purchaseType")
   public LogisticsOrder setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
      return this;
   }

   @JsonProperty("invoiceType")
   public LogisticsOrder setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("serialNumber")
   public LogisticsOrder setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("shipmentNumber")
   public LogisticsOrder setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
      return this;
   }

   @JsonProperty("logisticsTransportType")
   public LogisticsOrder setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
      return this;
   }

   @JsonProperty("logisticsPayerType")
   public LogisticsOrder setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
      return this;
   }

   @JsonProperty("inboundSn")
   public LogisticsOrder setInboundSn(final String inboundSn) {
      this.inboundSn = inboundSn;
      return this;
   }

   @JsonProperty("inboundId")
   public LogisticsOrder setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("purchaseSn")
   public LogisticsOrder setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   @JsonProperty("licensePlate")
   public LogisticsOrder setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("projectIds")
   public LogisticsOrder setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("loadingWeight")
   public LogisticsOrder setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
      return this;
   }

   @JsonProperty("taxRate")
   public LogisticsOrder setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("freight")
   public LogisticsOrder setFreight(final BigDecimal freight) {
      this.freight = freight;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public LogisticsOrder setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public LogisticsOrder setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("remark")
   public LogisticsOrder setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("supplierId")
   public LogisticsOrder setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public LogisticsOrder setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("applicantId")
   public LogisticsOrder setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public LogisticsOrder setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public LogisticsOrder setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("inboundReviewStatus")
   public LogisticsOrder setInboundReviewStatus(final Integer inboundReviewStatus) {
      this.inboundReviewStatus = inboundReviewStatus;
      return this;
   }

   @JsonProperty("freightWeight")
   public LogisticsOrder setFreightWeight(final BigDecimal freightWeight) {
      this.freightWeight = freightWeight;
      return this;
   }

   @JsonProperty("loadingCharge")
   public LogisticsOrder setLoadingCharge(final BigDecimal loadingCharge) {
      this.loadingCharge = loadingCharge;
      return this;
   }

   @JsonProperty("loadingChargeExcludingVat")
   public LogisticsOrder setLoadingChargeExcludingVat(final BigDecimal loadingChargeExcludingVat) {
      this.loadingChargeExcludingVat = loadingChargeExcludingVat;
      return this;
   }

   @JsonProperty("changeFreight")
   public LogisticsOrder setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
      return this;
   }

   @JsonProperty("freightInitial")
   public LogisticsOrder setFreightInitial(final BigDecimal freightInitial) {
      this.freightInitial = freightInitial;
      return this;
   }

   @JsonProperty("amountExcludingVatInitial")
   public LogisticsOrder setAmountExcludingVatInitial(final BigDecimal amountExcludingVatInitial) {
      this.amountExcludingVatInitial = amountExcludingVatInitial;
      return this;
   }

   @JsonProperty("inputVatInitial")
   public LogisticsOrder setInputVatInitial(final BigDecimal inputVatInitial) {
      this.inputVatInitial = inputVatInitial;
      return this;
   }

   @JsonProperty("tableNameType")
   public LogisticsOrder setTableNameType(final Integer tableNameType) {
      this.tableNameType = tableNameType;
      return this;
   }

   @Override
   public String toString() {
      return "LogisticsOrder(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", inboundSn="
         + this.getInboundSn()
         + ", inboundId="
         + this.getInboundId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", projectIds="
         + this.getProjectIds()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", taxRate="
         + this.getTaxRate()
         + ", freight="
         + this.getFreight()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", remark="
         + this.getRemark()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", inboundReviewStatus="
         + this.getInboundReviewStatus()
         + ", freightWeight="
         + this.getFreightWeight()
         + ", loadingCharge="
         + this.getLoadingCharge()
         + ", loadingChargeExcludingVat="
         + this.getLoadingChargeExcludingVat()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", freightInitial="
         + this.getFreightInitial()
         + ", amountExcludingVatInitial="
         + this.getAmountExcludingVatInitial()
         + ", inputVatInitial="
         + this.getInputVatInitial()
         + ", tableNameType="
         + this.getTableNameType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsOrder)) {
         return false;
      }

      LogisticsOrder other = (LogisticsOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$purchaseType = this.getPurchaseType();
               Object other$purchaseType = other.getPurchaseType();
               if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$logisticsTransportType = this.getLogisticsTransportType();
                     Object other$logisticsTransportType = other.getLogisticsTransportType();
                     if (this$logisticsTransportType == null
                        ? other$logisticsTransportType == null
                        : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                        Object this$logisticsPayerType = this.getLogisticsPayerType();
                        Object other$logisticsPayerType = other.getLogisticsPayerType();
                        if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                           Object this$inboundId = this.getInboundId();
                           Object other$inboundId = other.getInboundId();
                           if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$applicantId = this.getApplicantId();
                                 Object other$applicantId = other.getApplicantId();
                                 if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                    Object this$inboundReviewStatus = this.getInboundReviewStatus();
                                    Object other$inboundReviewStatus = other.getInboundReviewStatus();
                                    if (this$inboundReviewStatus == null
                                       ? other$inboundReviewStatus == null
                                       : this$inboundReviewStatus.equals(other$inboundReviewStatus)) {
                                       Object this$changeFreight = this.getChangeFreight();
                                       Object other$changeFreight = other.getChangeFreight();
                                       if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
                                          Object this$tableNameType = this.getTableNameType();
                                          Object other$tableNameType = other.getTableNameType();
                                          if (this$tableNameType == null ? other$tableNameType == null : this$tableNameType.equals(other$tableNameType)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$shipmentNumber = this.getShipmentNumber();
                                                Object other$shipmentNumber = other.getShipmentNumber();
                                                if (this$shipmentNumber == null
                                                   ? other$shipmentNumber == null
                                                   : this$shipmentNumber.equals(other$shipmentNumber)) {
                                                   Object this$inboundSn = this.getInboundSn();
                                                   Object other$inboundSn = other.getInboundSn();
                                                   if (this$inboundSn == null ? other$inboundSn == null : this$inboundSn.equals(other$inboundSn)) {
                                                      Object this$purchaseSn = this.getPurchaseSn();
                                                      Object other$purchaseSn = other.getPurchaseSn();
                                                      if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                                                         Object this$licensePlate = this.getLicensePlate();
                                                         Object other$licensePlate = other.getLicensePlate();
                                                         if (this$licensePlate == null
                                                            ? other$licensePlate == null
                                                            : this$licensePlate.equals(other$licensePlate)) {
                                                            Object this$projectIds = this.getProjectIds();
                                                            Object other$projectIds = other.getProjectIds();
                                                            if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                               Object this$loadingWeight = this.getLoadingWeight();
                                                               Object other$loadingWeight = other.getLoadingWeight();
                                                               if (this$loadingWeight == null
                                                                  ? other$loadingWeight == null
                                                                  : this$loadingWeight.equals(other$loadingWeight)) {
                                                                  Object this$taxRate = this.getTaxRate();
                                                                  Object other$taxRate = other.getTaxRate();
                                                                  if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                     Object this$freight = this.getFreight();
                                                                     Object other$freight = other.getFreight();
                                                                     if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                                                        Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                        Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                        if (this$amountExcludingVat == null
                                                                           ? other$amountExcludingVat == null
                                                                           : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                           Object this$inputVat = this.getInputVat();
                                                                           Object other$inputVat = other.getInputVat();
                                                                           if (this$inputVat == null
                                                                              ? other$inputVat == null
                                                                              : this$inputVat.equals(other$inputVat)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$supplierName = this.getSupplierName();
                                                                                 Object other$supplierName = other.getSupplierName();
                                                                                 if (this$supplierName == null
                                                                                    ? other$supplierName == null
                                                                                    : this$supplierName.equals(other$supplierName)) {
                                                                                    Object this$applicantName = this.getApplicantName();
                                                                                    Object other$applicantName = other.getApplicantName();
                                                                                    if (this$applicantName == null
                                                                                       ? other$applicantName == null
                                                                                       : this$applicantName.equals(other$applicantName)) {
                                                                                       Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                       Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                       if (this$userUpdateTime == null
                                                                                          ? other$userUpdateTime == null
                                                                                          : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                          Object this$freightWeight = this.getFreightWeight();
                                                                                          Object other$freightWeight = other.getFreightWeight();
                                                                                          if (this$freightWeight == null
                                                                                             ? other$freightWeight == null
                                                                                             : this$freightWeight.equals(other$freightWeight)) {
                                                                                             Object this$loadingCharge = this.getLoadingCharge();
                                                                                             Object other$loadingCharge = other.getLoadingCharge();
                                                                                             if (this$loadingCharge == null
                                                                                                ? other$loadingCharge == null
                                                                                                : this$loadingCharge.equals(other$loadingCharge)) {
                                                                                                Object this$loadingChargeExcludingVat = this.getLoadingChargeExcludingVat();
                                                                                                Object other$loadingChargeExcludingVat = other.getLoadingChargeExcludingVat();
                                                                                                if (this$loadingChargeExcludingVat == null
                                                                                                   ? other$loadingChargeExcludingVat == null
                                                                                                   : this$loadingChargeExcludingVat.equals(
                                                                                                      other$loadingChargeExcludingVat
                                                                                                   )) {
                                                                                                   Object this$freightInitial = this.getFreightInitial();
                                                                                                   Object other$freightInitial = other.getFreightInitial();
                                                                                                   if (this$freightInitial == null
                                                                                                      ? other$freightInitial == null
                                                                                                      : this$freightInitial.equals(other$freightInitial)) {
                                                                                                      Object this$amountExcludingVatInitial = this.getAmountExcludingVatInitial();
                                                                                                      Object other$amountExcludingVatInitial = other.getAmountExcludingVatInitial();
                                                                                                      if (this$amountExcludingVatInitial == null
                                                                                                         ? other$amountExcludingVatInitial == null
                                                                                                         : this$amountExcludingVatInitial.equals(
                                                                                                            other$amountExcludingVatInitial
                                                                                                         )) {
                                                                                                         Object this$inputVatInitial = this.getInputVatInitial();
                                                                                                         Object other$inputVatInitial = other.getInputVatInitial();
                                                                                                         return this$inputVatInitial == null
                                                                                                            ? other$inputVatInitial == null
                                                                                                            : this$inputVatInitial.equals(other$inputVatInitial);
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
      return other instanceof LogisticsOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $inboundReviewStatus = this.getInboundReviewStatus();
      result = result * 59 + ($inboundReviewStatus == null ? 43 : $inboundReviewStatus.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $tableNameType = this.getTableNameType();
      result = result * 59 + ($tableNameType == null ? 43 : $tableNameType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $inboundSn = this.getInboundSn();
      result = result * 59 + ($inboundSn == null ? 43 : $inboundSn.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $freightWeight = this.getFreightWeight();
      result = result * 59 + ($freightWeight == null ? 43 : $freightWeight.hashCode());
      Object $loadingCharge = this.getLoadingCharge();
      result = result * 59 + ($loadingCharge == null ? 43 : $loadingCharge.hashCode());
      Object $loadingChargeExcludingVat = this.getLoadingChargeExcludingVat();
      result = result * 59 + ($loadingChargeExcludingVat == null ? 43 : $loadingChargeExcludingVat.hashCode());
      Object $freightInitial = this.getFreightInitial();
      result = result * 59 + ($freightInitial == null ? 43 : $freightInitial.hashCode());
      Object $amountExcludingVatInitial = this.getAmountExcludingVatInitial();
      result = result * 59 + ($amountExcludingVatInitial == null ? 43 : $amountExcludingVatInitial.hashCode());
      Object $inputVatInitial = this.getInputVatInitial();
      return result * 59 + ($inputVatInitial == null ? 43 : $inputVatInitial.hashCode());
   }

   public static class LogisticsOrderBuilder {
      private Long id;
      private Integer basicClass;
      private Long purchaseId;
      private Integer purchaseType;
      private Integer invoiceType;
      private String serialNumber;
      private String shipmentNumber;
      private Integer logisticsTransportType;
      private Integer logisticsPayerType;
      private String inboundSn;
      private Long inboundId;
      private String purchaseSn;
      private String licensePlate;
      private String projectIds;
      private BigDecimal loadingWeight;
      private BigDecimal taxRate;
      private BigDecimal freight;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private String remark;
      private Long supplierId;
      private String supplierName;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime userUpdateTime;
      private Integer inboundReviewStatus;
      private BigDecimal freightWeight;
      private BigDecimal loadingCharge;
      private BigDecimal loadingChargeExcludingVat;
      private Integer changeFreight;
      private BigDecimal freightInitial;
      private BigDecimal amountExcludingVatInitial;
      private BigDecimal inputVatInitial;
      private Integer tableNameType;

      LogisticsOrderBuilder() {
      }

      @JsonProperty("id")
      public LogisticsOrder.LogisticsOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public LogisticsOrder.LogisticsOrderBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("purchaseId")
      public LogisticsOrder.LogisticsOrderBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("purchaseType")
      public LogisticsOrder.LogisticsOrderBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      @JsonProperty("invoiceType")
      public LogisticsOrder.LogisticsOrderBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("serialNumber")
      public LogisticsOrder.LogisticsOrderBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("shipmentNumber")
      public LogisticsOrder.LogisticsOrderBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      @JsonProperty("logisticsTransportType")
      public LogisticsOrder.LogisticsOrderBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      @JsonProperty("logisticsPayerType")
      public LogisticsOrder.LogisticsOrderBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      @JsonProperty("inboundSn")
      public LogisticsOrder.LogisticsOrderBuilder inboundSn(final String inboundSn) {
         this.inboundSn = inboundSn;
         return this;
      }

      @JsonProperty("inboundId")
      public LogisticsOrder.LogisticsOrderBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("purchaseSn")
      public LogisticsOrder.LogisticsOrderBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      @JsonProperty("licensePlate")
      public LogisticsOrder.LogisticsOrderBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("projectIds")
      public LogisticsOrder.LogisticsOrderBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("loadingWeight")
      public LogisticsOrder.LogisticsOrderBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      @JsonProperty("taxRate")
      public LogisticsOrder.LogisticsOrderBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("freight")
      public LogisticsOrder.LogisticsOrderBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public LogisticsOrder.LogisticsOrderBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public LogisticsOrder.LogisticsOrderBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("remark")
      public LogisticsOrder.LogisticsOrderBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("supplierId")
      public LogisticsOrder.LogisticsOrderBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public LogisticsOrder.LogisticsOrderBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("applicantId")
      public LogisticsOrder.LogisticsOrderBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public LogisticsOrder.LogisticsOrderBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public LogisticsOrder.LogisticsOrderBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("inboundReviewStatus")
      public LogisticsOrder.LogisticsOrderBuilder inboundReviewStatus(final Integer inboundReviewStatus) {
         this.inboundReviewStatus = inboundReviewStatus;
         return this;
      }

      @JsonProperty("freightWeight")
      public LogisticsOrder.LogisticsOrderBuilder freightWeight(final BigDecimal freightWeight) {
         this.freightWeight = freightWeight;
         return this;
      }

      @JsonProperty("loadingCharge")
      public LogisticsOrder.LogisticsOrderBuilder loadingCharge(final BigDecimal loadingCharge) {
         this.loadingCharge = loadingCharge;
         return this;
      }

      @JsonProperty("loadingChargeExcludingVat")
      public LogisticsOrder.LogisticsOrderBuilder loadingChargeExcludingVat(final BigDecimal loadingChargeExcludingVat) {
         this.loadingChargeExcludingVat = loadingChargeExcludingVat;
         return this;
      }

      @JsonProperty("changeFreight")
      public LogisticsOrder.LogisticsOrderBuilder changeFreight(final Integer changeFreight) {
         this.changeFreight = changeFreight;
         return this;
      }

      @JsonProperty("freightInitial")
      public LogisticsOrder.LogisticsOrderBuilder freightInitial(final BigDecimal freightInitial) {
         this.freightInitial = freightInitial;
         return this;
      }

      @JsonProperty("amountExcludingVatInitial")
      public LogisticsOrder.LogisticsOrderBuilder amountExcludingVatInitial(final BigDecimal amountExcludingVatInitial) {
         this.amountExcludingVatInitial = amountExcludingVatInitial;
         return this;
      }

      @JsonProperty("inputVatInitial")
      public LogisticsOrder.LogisticsOrderBuilder inputVatInitial(final BigDecimal inputVatInitial) {
         this.inputVatInitial = inputVatInitial;
         return this;
      }

      @JsonProperty("tableNameType")
      public LogisticsOrder.LogisticsOrderBuilder tableNameType(final Integer tableNameType) {
         this.tableNameType = tableNameType;
         return this;
      }

      public LogisticsOrder build() {
         return new LogisticsOrder(
            this.id,
            this.basicClass,
            this.purchaseId,
            this.purchaseType,
            this.invoiceType,
            this.serialNumber,
            this.shipmentNumber,
            this.logisticsTransportType,
            this.logisticsPayerType,
            this.inboundSn,
            this.inboundId,
            this.purchaseSn,
            this.licensePlate,
            this.projectIds,
            this.loadingWeight,
            this.taxRate,
            this.freight,
            this.amountExcludingVat,
            this.inputVat,
            this.remark,
            this.supplierId,
            this.supplierName,
            this.applicantId,
            this.applicantName,
            this.userUpdateTime,
            this.inboundReviewStatus,
            this.freightWeight,
            this.loadingCharge,
            this.loadingChargeExcludingVat,
            this.changeFreight,
            this.freightInitial,
            this.amountExcludingVatInitial,
            this.inputVatInitial,
            this.tableNameType
         );
      }

      @Override
      public String toString() {
         return "LogisticsOrder.LogisticsOrderBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseType="
            + this.purchaseType
            + ", invoiceType="
            + this.invoiceType
            + ", serialNumber="
            + this.serialNumber
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", inboundSn="
            + this.inboundSn
            + ", inboundId="
            + this.inboundId
            + ", purchaseSn="
            + this.purchaseSn
            + ", licensePlate="
            + this.licensePlate
            + ", projectIds="
            + this.projectIds
            + ", loadingWeight="
            + this.loadingWeight
            + ", taxRate="
            + this.taxRate
            + ", freight="
            + this.freight
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", remark="
            + this.remark
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", inboundReviewStatus="
            + this.inboundReviewStatus
            + ", freightWeight="
            + this.freightWeight
            + ", loadingCharge="
            + this.loadingCharge
            + ", loadingChargeExcludingVat="
            + this.loadingChargeExcludingVat
            + ", changeFreight="
            + this.changeFreight
            + ", freightInitial="
            + this.freightInitial
            + ", amountExcludingVatInitial="
            + this.amountExcludingVatInitial
            + ", inputVatInitial="
            + this.inputVatInitial
            + ", tableNameType="
            + this.tableNameType
            + ")";
      }
   }
}
