package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "InboundManufactured对象", description = "制成品入库表 ")
@Entity
@TableName("wms_inbound_manufactured")
@Table(name = "wms_inbound_manufactured")
public class InboundManufactured extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "入库单编号", notes = "入库单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '入库单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "purchaseId", value = "采购订单ID", notes = "采购订单ID")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '采购订单ID'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单编号", notes = "采购单编号")
   @JsonProperty("purchaseSn")
   @JSONField(name = "purchaseSn")
   @TableField("purchase_SN")
   @Column(name = "purchase_SN", columnDefinition = "varchar(255)  COMMENT '采购单编号'", nullable = true)
   private String purchaseSn;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   @TableField("license_plate")
   @Column(name = "license_plate", columnDefinition = "varchar(128)  COMMENT '车牌号'", nullable = true)
   private String licensePlate;
   @ApiModelProperty(name = "projectIds", value = "项目ID集合", notes = "项目ID集合")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID集合'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "loadingWeight", value = "过磅重量", notes = "过磅重量")
   @JsonProperty("loadingWeight")
   @JSONField(name = "loadingWeight")
   @TableField("loading_weight")
   @Column(name = "loading_weight", columnDefinition = "decimal(32,8)  COMMENT '过磅重量'", nullable = true)
   private BigDecimal loadingWeight;
   @ApiModelProperty(name = "inboundTotalWeight", value = "入库物料总重", notes = "入库物料总重")
   @JsonProperty("inboundTotalWeight")
   @JSONField(name = "inboundTotalWeight")
   @TableField("inbound_total_weight")
   @Column(name = "inbound_total_weight", columnDefinition = "decimal(32,8)  COMMENT '入库物料总重'", nullable = true)
   private BigDecimal inboundTotalWeight;
   @ApiModelProperty(name = "boolRebuild", value = "当前订单是否为重建订单", notes = "当前订单是否为重建订单")
   @JsonProperty("boolRebuild")
   @JSONField(name = "boolRebuild")
   @TableField("bool_rebuild")
   @Column(name = "bool_rebuild", columnDefinition = "tinyint(1) default '0' COMMENT '当前订单是否为重建订单'", nullable = true)
   private Boolean boolRebuild;
   @ApiModelProperty(name = "applicantId", value = " 申请人ID", notes = " 申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT ' 申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型[位运算]", notes = "物料基础类型[位运算]")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型[位运算]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 [1未审核, 2审核通过, 4退回 , 8撤销, 16审核中]", notes = "审核状态 [1未审核, 2审核通过, 4退回 , 8撤销, 16审核中]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态 [1未审核, 2审核通过, 4退回 , 8撤销, 16审核中]'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewPassTime", value = "审核通过时间", notes = "审核通过时间")
   @JsonProperty("reviewPassTime")
   @JSONField(name = "reviewPassTime")
   @TableField("review_pass_time")
   @Column(name = "review_pass_time", columnDefinition = "datetime(6)  COMMENT '审核通过时间'", nullable = true)
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "supplierId", value = "供应商ID", notes = "供应商ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint  COMMENT '供应商ID'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "freight", value = "运费", notes = "运费")
   @JsonProperty("freight")
   @JSONField(name = "freight")
   @TableField("freight")
   @Column(name = "freight", columnDefinition = "decimal(32,8)  COMMENT '运费'", nullable = true)
   private BigDecimal freight;
   @ApiModelProperty(name = "freightWeight", value = "运重", notes = "运重")
   @JsonProperty("freightWeight")
   @JSONField(name = "freightWeight")
   @TableField("freight_weight")
   @Column(name = "freight_weight", columnDefinition = "decimal(32,8)  COMMENT '运重'", nullable = true)
   private BigDecimal freightWeight;
   @ApiModelProperty(name = "originalId", value = "初始入库单ID")
   @JsonProperty("originalId")
   @JSONField(name = "originalId")
   @TableField("original_id")
   @Column(name = "original_id", columnDefinition = "bigint  COMMENT '初始入库单ID'", nullable = true)
   private Long originalId;
   @ApiModelProperty(name = "originalNumber", value = "入库单重建数量(默认0)", notes = "入库单重建数量(默认0)")
   @JsonProperty("originalNumber")
   @JSONField(name = "originalNumber")
   @TableField("original_number")
   @Column(name = "original_number", columnDefinition = "int default '0' COMMENT '入库单重建数量(默认0)'", nullable = true)
   private Integer originalNumber;
   @ApiModelProperty(name = "editable", value = "是否可修改[默认可修改]", notes = "是否可修改[默认可修改]")
   @JsonProperty("editable")
   @JSONField(name = "editable")
   @TableField("editable")
   @Column(name = "editable", columnDefinition = "tinyint(1) default '1' COMMENT '是否可修改[默认可修改]'", nullable = true)
   private Boolean editable;
   @ApiModelProperty(name = "shipmentNumber", value = "物流单号", notes = "物流单号")
   @JsonProperty("shipmentNumber")
   @JSONField(name = "shipmentNumber")
   @TableField("shipment_number")
   @Column(name = "shipment_number", columnDefinition = "varchar(255)  COMMENT '物流单号'", nullable = true)
   private String shipmentNumber;
   @ApiModelProperty(name = "amountExcludingVat", value = "入库金额[不含税]", notes = "入库金额[不含税]")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税]'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amount", value = "入库金额[含税]", notes = "入库金额[含税]")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税]'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "logisticsSupplierId", value = "物流供应商ID", notes = "物流供应商ID")
   @JsonProperty("logisticsSupplierId")
   @JSONField(name = "logisticsSupplierId")
   @TableField("logistics_supplier_id")
   @Column(name = "logistics_supplier_id", columnDefinition = "bigint  COMMENT '物流供应商ID'", nullable = true)
   private Long logisticsSupplierId;
   @ApiModelProperty(name = "establishQuantity", value = "创建数量,一天中新入库单创建的数量", notes = "创建数量,一天中新入库单创建的数量")
   @JsonProperty("establishQuantity")
   @JSONField(name = "establishQuantity")
   @TableField("establish_quantity")
   @Column(name = "establish_quantity", columnDefinition = "int  COMMENT '创建数量,一天中新入库单创建的数量'", nullable = true)
   private Integer establishQuantity;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;

   public static InboundManufactured.InboundManufacturedBuilder builder() {
      return new InboundManufactured.InboundManufacturedBuilder();
   }

   public InboundManufactured() {
   }

   public InboundManufactured(
      final Long id,
      final String serialNumber,
      final Long purchaseId,
      final String purchaseSn,
      final String licensePlate,
      final String projectIds,
      final BigDecimal loadingWeight,
      final BigDecimal inboundTotalWeight,
      final Boolean boolRebuild,
      final Long applicantId,
      final String applicantName,
      final Integer basicClass,
      final Integer reviewStatus,
      final LocalDateTime reviewPassTime,
      final Long supplierId,
      final BigDecimal freight,
      final BigDecimal freightWeight,
      final Long originalId,
      final Integer originalNumber,
      final Boolean editable,
      final String shipmentNumber,
      final BigDecimal amountExcludingVat,
      final BigDecimal amount,
      final Long logisticsSupplierId,
      final Integer establishQuantity,
      final Long approveRecordId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.licensePlate = licensePlate;
      this.projectIds = projectIds;
      this.loadingWeight = loadingWeight;
      this.inboundTotalWeight = inboundTotalWeight;
      this.boolRebuild = boolRebuild;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.reviewPassTime = reviewPassTime;
      this.supplierId = supplierId;
      this.freight = freight;
      this.freightWeight = freightWeight;
      this.originalId = originalId;
      this.originalNumber = originalNumber;
      this.editable = editable;
      this.shipmentNumber = shipmentNumber;
      this.amountExcludingVat = amountExcludingVat;
      this.amount = amount;
      this.logisticsSupplierId = logisticsSupplierId;
      this.establishQuantity = establishQuantity;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
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

   public BigDecimal getInboundTotalWeight() {
      return this.inboundTotalWeight;
   }

   public Boolean getBoolRebuild() {
      return this.boolRebuild;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getFreightWeight() {
      return this.freightWeight;
   }

   public Long getOriginalId() {
      return this.originalId;
   }

   public Integer getOriginalNumber() {
      return this.originalNumber;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getLogisticsSupplierId() {
      return this.logisticsSupplierId;
   }

   public Integer getEstablishQuantity() {
      return this.establishQuantity;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   @JsonProperty("id")
   public InboundManufactured setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public InboundManufactured setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("purchaseId")
   public InboundManufactured setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("purchaseSn")
   public InboundManufactured setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   @JsonProperty("licensePlate")
   public InboundManufactured setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("projectIds")
   public InboundManufactured setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("loadingWeight")
   public InboundManufactured setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
      return this;
   }

   @JsonProperty("inboundTotalWeight")
   public InboundManufactured setInboundTotalWeight(final BigDecimal inboundTotalWeight) {
      this.inboundTotalWeight = inboundTotalWeight;
      return this;
   }

   @JsonProperty("boolRebuild")
   public InboundManufactured setBoolRebuild(final Boolean boolRebuild) {
      this.boolRebuild = boolRebuild;
      return this;
   }

   @JsonProperty("applicantId")
   public InboundManufactured setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public InboundManufactured setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("basicClass")
   public InboundManufactured setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("reviewStatus")
   public InboundManufactured setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewPassTime")
   public InboundManufactured setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
      return this;
   }

   @JsonProperty("supplierId")
   public InboundManufactured setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("freight")
   public InboundManufactured setFreight(final BigDecimal freight) {
      this.freight = freight;
      return this;
   }

   @JsonProperty("freightWeight")
   public InboundManufactured setFreightWeight(final BigDecimal freightWeight) {
      this.freightWeight = freightWeight;
      return this;
   }

   @JsonProperty("originalId")
   public InboundManufactured setOriginalId(final Long originalId) {
      this.originalId = originalId;
      return this;
   }

   @JsonProperty("originalNumber")
   public InboundManufactured setOriginalNumber(final Integer originalNumber) {
      this.originalNumber = originalNumber;
      return this;
   }

   @JsonProperty("editable")
   public InboundManufactured setEditable(final Boolean editable) {
      this.editable = editable;
      return this;
   }

   @JsonProperty("shipmentNumber")
   public InboundManufactured setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public InboundManufactured setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amount")
   public InboundManufactured setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("logisticsSupplierId")
   public InboundManufactured setLogisticsSupplierId(final Long logisticsSupplierId) {
      this.logisticsSupplierId = logisticsSupplierId;
      return this;
   }

   @JsonProperty("establishQuantity")
   public InboundManufactured setEstablishQuantity(final Integer establishQuantity) {
      this.establishQuantity = establishQuantity;
      return this;
   }

   @JsonProperty("approveRecordId")
   public InboundManufactured setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "InboundManufactured(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", projectIds="
         + this.getProjectIds()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", inboundTotalWeight="
         + this.getInboundTotalWeight()
         + ", boolRebuild="
         + this.getBoolRebuild()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", freight="
         + this.getFreight()
         + ", freightWeight="
         + this.getFreightWeight()
         + ", originalId="
         + this.getOriginalId()
         + ", originalNumber="
         + this.getOriginalNumber()
         + ", editable="
         + this.getEditable()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", logisticsSupplierId="
         + this.getLogisticsSupplierId()
         + ", establishQuantity="
         + this.getEstablishQuantity()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundManufactured)) {
         return false;
      }

      InboundManufactured other = (InboundManufactured)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$boolRebuild = this.getBoolRebuild();
            Object other$boolRebuild = other.getBoolRebuild();
            if (this$boolRebuild == null ? other$boolRebuild == null : this$boolRebuild.equals(other$boolRebuild)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$originalId = this.getOriginalId();
                           Object other$originalId = other.getOriginalId();
                           if (this$originalId == null ? other$originalId == null : this$originalId.equals(other$originalId)) {
                              Object this$originalNumber = this.getOriginalNumber();
                              Object other$originalNumber = other.getOriginalNumber();
                              if (this$originalNumber == null ? other$originalNumber == null : this$originalNumber.equals(other$originalNumber)) {
                                 Object this$editable = this.getEditable();
                                 Object other$editable = other.getEditable();
                                 if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                    Object this$logisticsSupplierId = this.getLogisticsSupplierId();
                                    Object other$logisticsSupplierId = other.getLogisticsSupplierId();
                                    if (this$logisticsSupplierId == null
                                       ? other$logisticsSupplierId == null
                                       : this$logisticsSupplierId.equals(other$logisticsSupplierId)) {
                                       Object this$establishQuantity = this.getEstablishQuantity();
                                       Object other$establishQuantity = other.getEstablishQuantity();
                                       if (this$establishQuantity == null
                                          ? other$establishQuantity == null
                                          : this$establishQuantity.equals(other$establishQuantity)) {
                                          Object this$approveRecordId = this.getApproveRecordId();
                                          Object other$approveRecordId = other.getApproveRecordId();
                                          if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)
                                             )
                                           {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$purchaseSn = this.getPurchaseSn();
                                                Object other$purchaseSn = other.getPurchaseSn();
                                                if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                                                   Object this$licensePlate = this.getLicensePlate();
                                                   Object other$licensePlate = other.getLicensePlate();
                                                   if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                                      Object this$projectIds = this.getProjectIds();
                                                      Object other$projectIds = other.getProjectIds();
                                                      if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                         Object this$loadingWeight = this.getLoadingWeight();
                                                         Object other$loadingWeight = other.getLoadingWeight();
                                                         if (this$loadingWeight == null
                                                            ? other$loadingWeight == null
                                                            : this$loadingWeight.equals(other$loadingWeight)) {
                                                            Object this$inboundTotalWeight = this.getInboundTotalWeight();
                                                            Object other$inboundTotalWeight = other.getInboundTotalWeight();
                                                            if (this$inboundTotalWeight == null
                                                               ? other$inboundTotalWeight == null
                                                               : this$inboundTotalWeight.equals(other$inboundTotalWeight)) {
                                                               Object this$applicantName = this.getApplicantName();
                                                               Object other$applicantName = other.getApplicantName();
                                                               if (this$applicantName == null
                                                                  ? other$applicantName == null
                                                                  : this$applicantName.equals(other$applicantName)) {
                                                                  Object this$reviewPassTime = this.getReviewPassTime();
                                                                  Object other$reviewPassTime = other.getReviewPassTime();
                                                                  if (this$reviewPassTime == null
                                                                     ? other$reviewPassTime == null
                                                                     : this$reviewPassTime.equals(other$reviewPassTime)) {
                                                                     Object this$freight = this.getFreight();
                                                                     Object other$freight = other.getFreight();
                                                                     if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                                                        Object this$freightWeight = this.getFreightWeight();
                                                                        Object other$freightWeight = other.getFreightWeight();
                                                                        if (this$freightWeight == null
                                                                           ? other$freightWeight == null
                                                                           : this$freightWeight.equals(other$freightWeight)) {
                                                                           Object this$shipmentNumber = this.getShipmentNumber();
                                                                           Object other$shipmentNumber = other.getShipmentNumber();
                                                                           if (this$shipmentNumber == null
                                                                              ? other$shipmentNumber == null
                                                                              : this$shipmentNumber.equals(other$shipmentNumber)) {
                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                              if (this$amountExcludingVat == null
                                                                                 ? other$amountExcludingVat == null
                                                                                 : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                 Object this$amount = this.getAmount();
                                                                                 Object other$amount = other.getAmount();
                                                                                 return this$amount == null
                                                                                    ? other$amount == null
                                                                                    : this$amount.equals(other$amount);
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
      return other instanceof InboundManufactured;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $boolRebuild = this.getBoolRebuild();
      result = result * 59 + ($boolRebuild == null ? 43 : $boolRebuild.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $originalId = this.getOriginalId();
      result = result * 59 + ($originalId == null ? 43 : $originalId.hashCode());
      Object $originalNumber = this.getOriginalNumber();
      result = result * 59 + ($originalNumber == null ? 43 : $originalNumber.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $logisticsSupplierId = this.getLogisticsSupplierId();
      result = result * 59 + ($logisticsSupplierId == null ? 43 : $logisticsSupplierId.hashCode());
      Object $establishQuantity = this.getEstablishQuantity();
      result = result * 59 + ($establishQuantity == null ? 43 : $establishQuantity.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $inboundTotalWeight = this.getInboundTotalWeight();
      result = result * 59 + ($inboundTotalWeight == null ? 43 : $inboundTotalWeight.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $freightWeight = this.getFreightWeight();
      result = result * 59 + ($freightWeight == null ? 43 : $freightWeight.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   public static class InboundManufacturedBuilder {
      private Long id;
      private String serialNumber;
      private Long purchaseId;
      private String purchaseSn;
      private String licensePlate;
      private String projectIds;
      private BigDecimal loadingWeight;
      private BigDecimal inboundTotalWeight;
      private Boolean boolRebuild;
      private Long applicantId;
      private String applicantName;
      private Integer basicClass;
      private Integer reviewStatus;
      private LocalDateTime reviewPassTime;
      private Long supplierId;
      private BigDecimal freight;
      private BigDecimal freightWeight;
      private Long originalId;
      private Integer originalNumber;
      private Boolean editable;
      private String shipmentNumber;
      private BigDecimal amountExcludingVat;
      private BigDecimal amount;
      private Long logisticsSupplierId;
      private Integer establishQuantity;
      private Long approveRecordId;

      InboundManufacturedBuilder() {
      }

      @JsonProperty("id")
      public InboundManufactured.InboundManufacturedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public InboundManufactured.InboundManufacturedBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("purchaseId")
      public InboundManufactured.InboundManufacturedBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("purchaseSn")
      public InboundManufactured.InboundManufacturedBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      @JsonProperty("licensePlate")
      public InboundManufactured.InboundManufacturedBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("projectIds")
      public InboundManufactured.InboundManufacturedBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("loadingWeight")
      public InboundManufactured.InboundManufacturedBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      @JsonProperty("inboundTotalWeight")
      public InboundManufactured.InboundManufacturedBuilder inboundTotalWeight(final BigDecimal inboundTotalWeight) {
         this.inboundTotalWeight = inboundTotalWeight;
         return this;
      }

      @JsonProperty("boolRebuild")
      public InboundManufactured.InboundManufacturedBuilder boolRebuild(final Boolean boolRebuild) {
         this.boolRebuild = boolRebuild;
         return this;
      }

      @JsonProperty("applicantId")
      public InboundManufactured.InboundManufacturedBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public InboundManufactured.InboundManufacturedBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("basicClass")
      public InboundManufactured.InboundManufacturedBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("reviewStatus")
      public InboundManufactured.InboundManufacturedBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewPassTime")
      public InboundManufactured.InboundManufacturedBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      @JsonProperty("supplierId")
      public InboundManufactured.InboundManufacturedBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("freight")
      public InboundManufactured.InboundManufacturedBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      @JsonProperty("freightWeight")
      public InboundManufactured.InboundManufacturedBuilder freightWeight(final BigDecimal freightWeight) {
         this.freightWeight = freightWeight;
         return this;
      }

      @JsonProperty("originalId")
      public InboundManufactured.InboundManufacturedBuilder originalId(final Long originalId) {
         this.originalId = originalId;
         return this;
      }

      @JsonProperty("originalNumber")
      public InboundManufactured.InboundManufacturedBuilder originalNumber(final Integer originalNumber) {
         this.originalNumber = originalNumber;
         return this;
      }

      @JsonProperty("editable")
      public InboundManufactured.InboundManufacturedBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      @JsonProperty("shipmentNumber")
      public InboundManufactured.InboundManufacturedBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public InboundManufactured.InboundManufacturedBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amount")
      public InboundManufactured.InboundManufacturedBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("logisticsSupplierId")
      public InboundManufactured.InboundManufacturedBuilder logisticsSupplierId(final Long logisticsSupplierId) {
         this.logisticsSupplierId = logisticsSupplierId;
         return this;
      }

      @JsonProperty("establishQuantity")
      public InboundManufactured.InboundManufacturedBuilder establishQuantity(final Integer establishQuantity) {
         this.establishQuantity = establishQuantity;
         return this;
      }

      @JsonProperty("approveRecordId")
      public InboundManufactured.InboundManufacturedBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public InboundManufactured build() {
         return new InboundManufactured(
            this.id,
            this.serialNumber,
            this.purchaseId,
            this.purchaseSn,
            this.licensePlate,
            this.projectIds,
            this.loadingWeight,
            this.inboundTotalWeight,
            this.boolRebuild,
            this.applicantId,
            this.applicantName,
            this.basicClass,
            this.reviewStatus,
            this.reviewPassTime,
            this.supplierId,
            this.freight,
            this.freightWeight,
            this.originalId,
            this.originalNumber,
            this.editable,
            this.shipmentNumber,
            this.amountExcludingVat,
            this.amount,
            this.logisticsSupplierId,
            this.establishQuantity,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "InboundManufactured.InboundManufacturedBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseSn="
            + this.purchaseSn
            + ", licensePlate="
            + this.licensePlate
            + ", projectIds="
            + this.projectIds
            + ", loadingWeight="
            + this.loadingWeight
            + ", inboundTotalWeight="
            + this.inboundTotalWeight
            + ", boolRebuild="
            + this.boolRebuild
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", supplierId="
            + this.supplierId
            + ", freight="
            + this.freight
            + ", freightWeight="
            + this.freightWeight
            + ", originalId="
            + this.originalId
            + ", originalNumber="
            + this.originalNumber
            + ", editable="
            + this.editable
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amount="
            + this.amount
            + ", logisticsSupplierId="
            + this.logisticsSupplierId
            + ", establishQuantity="
            + this.establishQuantity
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
