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

@ApiModel(value = "StorageList对象", description = "入库表 ")
@Entity
@TableName("wms_inbound")
@Table(name = "wms_inbound")
public class Inbound extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
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
   @ApiModelProperty(name = "projectIds", value = "项目ID根据采购订单项目ID", notes = "项目ID根据采购订单项目ID")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID根据采购订单项目ID'", nullable = true)
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
   @ApiModelProperty(name = "serialNumber", value = "入库单编号", notes = "入库单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '入库单编号'", nullable = true)
   private String serialNumber;
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
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "editorId", value = "最后编辑人", notes = "最后编辑人")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint  COMMENT '最后编辑人'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "editorName", value = "最后编辑人名称", notes = "最后编辑人名称")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '最后编辑人名称'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型[位运算]", notes = "物料基础类型[位运算]")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型[位运算]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 [1未审核, 2审核通过, 4退回]", notes = "审核状态 [1未审核, 2审核通过, 4退回]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态 [1未审核, 2审核通过, 4退回]'", nullable = true)
   private Integer reviewStatus;
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
   @ApiModelProperty(name = "freightWeight", value = "运重")
   @JsonProperty("freightWeight")
   @JSONField(name = "freightWeight")
   @TableField("freight_weight")
   @Column(name = "freight_weight")
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
   @ApiModelProperty(name = "approvalComments", value = "审核意见", notes = "审核意见")
   @JsonProperty("approvalComments")
   @JSONField(name = "approvalComments")
   @TableField("approval_comments")
   @Column(name = "approval_comments", columnDefinition = "text  COMMENT '审核意见'", nullable = true)
   private String approvalComments;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式[参考枚举 MeasureEnum]", notes = "重量计量方式[参考枚举 MeasureEnum]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式[参考枚举 MeasureEnum]'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "printStatus", value = "打印状态 [true 1 已打印]", notes = "打印状态 [true 1 已打印]")
   @JsonProperty("printStatus")
   @JSONField(name = "printStatus")
   @TableField("print_status")
   @Column(name = "print_status", columnDefinition = "tinyint(1) default '0' COMMENT '打印状态 [true 1 已打印]'", nullable = true)
   private Boolean printStatus;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime(1)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime(1)  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "rejectStatus", value = "退库状态,参考枚举[RejectEnum],取值优先级[审核中>部分退库>全部退库]", notes = "退库状态,参考枚举[RejectEnum],取值优先级[审核中>部分退库>全部退库]")
   @JsonProperty("rejectStatus")
   @JSONField(name = "rejectStatus")
   @TableField("reject_status")
   @Column(name = "reject_status", columnDefinition = "int  COMMENT '退库状态,参考枚举[RejectEnum],取值优先级[审核中>部分退库>全部退库]'", nullable = true)
   private Integer rejectStatus;
   @ApiModelProperty(name = "shipmentNumber", value = "物流单号", notes = "物流单号")
   @JsonProperty("shipmentNumber")
   @JSONField(name = "shipmentNumber")
   @TableField("shipment_number")
   @Column(name = "shipment_number", columnDefinition = "varchar(255)  COMMENT '物流单号'", nullable = true)
   private String shipmentNumber;
   @ApiModelProperty(name = "amountExcludingVat", value = "入库金额[不含税]", notes = "入库金额[不含税]")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税]'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "入库金额[不含税 不含运费]", notes = "入库金额[不含税 不含运费]")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税 不含运费]'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "amount", value = "入库金额[含税]", notes = "入库金额[含税]")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税]'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountNoFreight", value = "入库金额[含税 不含运费]", notes = "入库金额[含税 不含运费]")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税 不含运费]'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "logisticsSupplierId", value = "物流供应商ID", notes = "物流供应商ID")
   @JsonProperty("logisticsSupplierId")
   @JSONField(name = "logisticsSupplierId")
   @TableField("logistics_supplier_id")
   @Column(name = "logistics_supplier_id", columnDefinition = "bigint  COMMENT '物流供应商ID'", nullable = true)
   private Long logisticsSupplierId;
   @ApiModelProperty(name = "boolPartyA")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "bit(1)  COMMENT '是否甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "qualityTestingEnum", value = "质检状态", notes = "质检状态")
   @JsonProperty("qualityTestingEnum")
   @JSONField(name = "qualityTestingEnum")
   @TableField("quality_testing_enum")
   @Column(name = "quality_testing_enum", columnDefinition = "int default '16' COMMENT '质检状态'", nullable = true)
   private Integer qualityTestingEnum;
   @ApiModelProperty(name = "attachmentIds", value = "质检附件", notes = "质检附件")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '质检附件'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "qualityTestingUserId", value = "质检人ID", notes = "质检人ID")
   @JsonProperty("qualityTestingUserId")
   @JSONField(name = "qualityTestingUserId")
   @TableField("quality_testing_user_id")
   @Column(name = "quality_testing_user_id", columnDefinition = "bigint  COMMENT '质检人ID'", nullable = true)
   private Long qualityTestingUserId;
   @ApiModelProperty(name = "qualityTestingUserName", value = "质检人名称", notes = "质检人名称")
   @JsonProperty("qualityTestingUserName")
   @JSONField(name = "qualityTestingUserName")
   @TableField("quality_testing_user_name")
   @Column(name = "quality_testing_user_name", columnDefinition = "varchar(255)  COMMENT '质检人名称'", nullable = true)
   private String qualityTestingUserName;
   @ApiModelProperty(name = "qualityTestingTime", value = "质检时间", notes = "质检时间")
   @JsonProperty("qualityTestingTime")
   @JSONField(name = "qualityTestingTime")
   @TableField("quality_testing_time")
   @Column(name = "quality_testing_time", columnDefinition = "datetime  COMMENT '质检时间'", nullable = true)
   private LocalDateTime qualityTestingTime;
   @ApiModelProperty(name = "qualityTestingRemark", value = "质检备注", notes = "质检备注")
   @JsonProperty("qualityTestingRemark")
   @JSONField(name = "qualityTestingRemark")
   @TableField("quality_testing_remark")
   @Column(name = "quality_testing_remark", columnDefinition = "varchar(255)  COMMENT '质检备注'", nullable = true)
   private String qualityTestingRemark;
   @ApiModelProperty(name = "establishQuantity", value = "创建数量,一天中新入库单创建的数量", notes = "创建数量,一天中新入库单创建的数量")
   @JsonProperty("establishQuantity")
   @JSONField(name = "establishQuantity")
   @TableField("establish_quantity")
   @Column(name = "establish_quantity", columnDefinition = "int  COMMENT '创建数量,一天中新入库单创建的数量'", nullable = true)
   private Integer establishQuantity;
   @ApiModelProperty(name = "freightTaxRate", value = "运费税率", notes = "运费税率")
   @JsonProperty("freightTaxRate")
   @JSONField(name = "freightTaxRate")
   @TableField("freight_tax_rate")
   @Column(name = "freight_tax_rate", columnDefinition = "decimal(19,2)  COMMENT '运费税率'", nullable = true)
   private BigDecimal freightTaxRate;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID,跨组织出库使用(重工方)'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "loadingCharge", value = "装车费")
   @JsonProperty("loadingCharge")
   @JSONField(name = "loadingCharge")
   @TableField("loading_charge")
   @Column(name = "loading_charge", columnDefinition = "decimal(19,2)  COMMENT '装车费'", nullable = true)
   private BigDecimal loadingCharge;
   @ApiModelProperty(name = "classifyIds", value = "科目ID集")
   @JsonProperty("classifyIds")
   @JSONField(name = "classifyIds")
   @TableField("classify_ids")
   @Column(name = "classify_ids", columnDefinition = "varchar(5000) COMMENT '科目ID集'", nullable = true)
   private String classifyIds;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   @JsonProperty("boolNestSurplus")
   @JSONField(name = "boolNestSurplus")
   @TableField("bool_nest_surplus")
   @Column(name = "bool_nest_surplus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '柏楚余料'", nullable = true)
   private Boolean boolNestSurplus;
   @ApiModelProperty(name = "mesWorkshopId", value = "车间(中南定制)", notes = "车间(中南定制)")
   @JsonProperty("mesWorkshopId")
   @JSONField(name = "mesWorkshopId")
   @TableField("mes_workshop_Id")
   @Column(name = "mes_workshop_Id", columnDefinition = "bigint  COMMENT '车间(中南定制)'", nullable = true)
   private Long mesWorkshopId;
   @ApiModelProperty(name = "inboundWay", value = "入库方式 InboundWayEnum", notes = "入库方式 InboundWayEnum")
   @JsonProperty("inboundWay")
   @JSONField(name = "inboundWay")
   @TableField("inbound_way")
   @Column(name = "inbound_way", columnDefinition = "int default '1' COMMENT '入库方式[1.普通入库 2.期初入库]'", nullable = true)
   private Integer inboundWay;
   @ApiModelProperty(name = "freightJson", value = "运费信息", notes = "运费信息")
   @JsonProperty("freightJson")
   @JSONField(name = "freightJson")
   @TableField("freight_json")
   @Column(name = "freight_json", columnDefinition = "json COMMENT '运费信息'", nullable = true)
   private String freightJson;

   public static Inbound.InboundBuilder builder() {
      return new Inbound.InboundBuilder();
   }

   public Inbound() {
   }

   public Inbound(
      final Long id,
      final Long purchaseId,
      final String purchaseSn,
      final String licensePlate,
      final String projectIds,
      final BigDecimal loadingWeight,
      final BigDecimal inboundTotalWeight,
      final String serialNumber,
      final Boolean boolRebuild,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final Long editorId,
      final String editorName,
      final Integer basicClass,
      final Integer reviewStatus,
      final Long supplierId,
      final BigDecimal freight,
      final BigDecimal freightWeight,
      final Long originalId,
      final Integer originalNumber,
      final Boolean editable,
      final String approvalComments,
      final Integer weightMeasurementMode,
      final Boolean printStatus,
      final LocalDateTime reviewTime,
      final LocalDateTime userUpdateTime,
      final Integer rejectStatus,
      final String shipmentNumber,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal amount,
      final BigDecimal amountNoFreight,
      final Long logisticsSupplierId,
      final Boolean boolPartyA,
      final Integer qualityTestingEnum,
      final String attachmentIds,
      final Long qualityTestingUserId,
      final String qualityTestingUserName,
      final LocalDateTime qualityTestingTime,
      final String qualityTestingRemark,
      final Integer establishQuantity,
      final BigDecimal freightTaxRate,
      final Long outboundId,
      final Long approveRecordId,
      final BigDecimal loadingCharge,
      final String classifyIds,
      final Boolean boolNestSurplus,
      final Long mesWorkshopId,
      final Integer inboundWay,
      final String freightJson
   ) {
      this.id = id;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.licensePlate = licensePlate;
      this.projectIds = projectIds;
      this.loadingWeight = loadingWeight;
      this.inboundTotalWeight = inboundTotalWeight;
      this.serialNumber = serialNumber;
      this.boolRebuild = boolRebuild;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.editorId = editorId;
      this.editorName = editorName;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.supplierId = supplierId;
      this.freight = freight;
      this.freightWeight = freightWeight;
      this.originalId = originalId;
      this.originalNumber = originalNumber;
      this.editable = editable;
      this.approvalComments = approvalComments;
      this.weightMeasurementMode = weightMeasurementMode;
      this.printStatus = printStatus;
      this.reviewTime = reviewTime;
      this.userUpdateTime = userUpdateTime;
      this.rejectStatus = rejectStatus;
      this.shipmentNumber = shipmentNumber;
      this.amountExcludingVat = amountExcludingVat;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.amount = amount;
      this.amountNoFreight = amountNoFreight;
      this.logisticsSupplierId = logisticsSupplierId;
      this.boolPartyA = boolPartyA;
      this.qualityTestingEnum = qualityTestingEnum;
      this.attachmentIds = attachmentIds;
      this.qualityTestingUserId = qualityTestingUserId;
      this.qualityTestingUserName = qualityTestingUserName;
      this.qualityTestingTime = qualityTestingTime;
      this.qualityTestingRemark = qualityTestingRemark;
      this.establishQuantity = establishQuantity;
      this.freightTaxRate = freightTaxRate;
      this.outboundId = outboundId;
      this.approveRecordId = approveRecordId;
      this.loadingCharge = loadingCharge;
      this.classifyIds = classifyIds;
      this.boolNestSurplus = boolNestSurplus;
      this.mesWorkshopId = mesWorkshopId;
      this.inboundWay = inboundWay;
      this.freightJson = freightJson;
   }

   public Long getId() {
      return this.id;
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

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
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

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Boolean getPrintStatus() {
      return this.printStatus;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public Long getLogisticsSupplierId() {
      return this.logisticsSupplierId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Long getQualityTestingUserId() {
      return this.qualityTestingUserId;
   }

   public String getQualityTestingUserName() {
      return this.qualityTestingUserName;
   }

   public LocalDateTime getQualityTestingTime() {
      return this.qualityTestingTime;
   }

   public String getQualityTestingRemark() {
      return this.qualityTestingRemark;
   }

   public Integer getEstablishQuantity() {
      return this.establishQuantity;
   }

   public BigDecimal getFreightTaxRate() {
      return this.freightTaxRate;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public BigDecimal getLoadingCharge() {
      return this.loadingCharge;
   }

   public String getClassifyIds() {
      return this.classifyIds;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public String getFreightJson() {
      return this.freightJson;
   }

   @JsonProperty("id")
   public Inbound setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("purchaseId")
   public Inbound setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("purchaseSn")
   public Inbound setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   @JsonProperty("licensePlate")
   public Inbound setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("projectIds")
   public Inbound setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("loadingWeight")
   public Inbound setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
      return this;
   }

   @JsonProperty("inboundTotalWeight")
   public Inbound setInboundTotalWeight(final BigDecimal inboundTotalWeight) {
      this.inboundTotalWeight = inboundTotalWeight;
      return this;
   }

   @JsonProperty("serialNumber")
   public Inbound setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("boolRebuild")
   public Inbound setBoolRebuild(final Boolean boolRebuild) {
      this.boolRebuild = boolRebuild;
      return this;
   }

   @JsonProperty("applicantId")
   public Inbound setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public Inbound setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerId")
   public Inbound setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Inbound setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("editorId")
   public Inbound setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("editorName")
   public Inbound setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("basicClass")
   public Inbound setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("reviewStatus")
   public Inbound setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("supplierId")
   public Inbound setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("freight")
   public Inbound setFreight(final BigDecimal freight) {
      this.freight = freight;
      return this;
   }

   @JsonProperty("freightWeight")
   public Inbound setFreightWeight(final BigDecimal freightWeight) {
      this.freightWeight = freightWeight;
      return this;
   }

   @JsonProperty("originalId")
   public Inbound setOriginalId(final Long originalId) {
      this.originalId = originalId;
      return this;
   }

   @JsonProperty("originalNumber")
   public Inbound setOriginalNumber(final Integer originalNumber) {
      this.originalNumber = originalNumber;
      return this;
   }

   @JsonProperty("editable")
   public Inbound setEditable(final Boolean editable) {
      this.editable = editable;
      return this;
   }

   @JsonProperty("approvalComments")
   public Inbound setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public Inbound setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("printStatus")
   public Inbound setPrintStatus(final Boolean printStatus) {
      this.printStatus = printStatus;
      return this;
   }

   @JsonProperty("reviewTime")
   public Inbound setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Inbound setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("rejectStatus")
   public Inbound setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
      return this;
   }

   @JsonProperty("shipmentNumber")
   public Inbound setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public Inbound setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public Inbound setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amount")
   public Inbound setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public Inbound setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("logisticsSupplierId")
   public Inbound setLogisticsSupplierId(final Long logisticsSupplierId) {
      this.logisticsSupplierId = logisticsSupplierId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Inbound setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("qualityTestingEnum")
   public Inbound setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
      return this;
   }

   @JsonProperty("attachmentIds")
   public Inbound setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("qualityTestingUserId")
   public Inbound setQualityTestingUserId(final Long qualityTestingUserId) {
      this.qualityTestingUserId = qualityTestingUserId;
      return this;
   }

   @JsonProperty("qualityTestingUserName")
   public Inbound setQualityTestingUserName(final String qualityTestingUserName) {
      this.qualityTestingUserName = qualityTestingUserName;
      return this;
   }

   @JsonProperty("qualityTestingTime")
   public Inbound setQualityTestingTime(final LocalDateTime qualityTestingTime) {
      this.qualityTestingTime = qualityTestingTime;
      return this;
   }

   @JsonProperty("qualityTestingRemark")
   public Inbound setQualityTestingRemark(final String qualityTestingRemark) {
      this.qualityTestingRemark = qualityTestingRemark;
      return this;
   }

   @JsonProperty("establishQuantity")
   public Inbound setEstablishQuantity(final Integer establishQuantity) {
      this.establishQuantity = establishQuantity;
      return this;
   }

   @JsonProperty("freightTaxRate")
   public Inbound setFreightTaxRate(final BigDecimal freightTaxRate) {
      this.freightTaxRate = freightTaxRate;
      return this;
   }

   @JsonProperty("outboundId")
   public Inbound setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("approveRecordId")
   public Inbound setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("loadingCharge")
   public Inbound setLoadingCharge(final BigDecimal loadingCharge) {
      this.loadingCharge = loadingCharge;
      return this;
   }

   @JsonProperty("classifyIds")
   public Inbound setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
      return this;
   }

   @JsonProperty("boolNestSurplus")
   public Inbound setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
      return this;
   }

   @JsonProperty("mesWorkshopId")
   public Inbound setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
      return this;
   }

   @JsonProperty("inboundWay")
   public Inbound setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
      return this;
   }

   @JsonProperty("freightJson")
   public Inbound setFreightJson(final String freightJson) {
      this.freightJson = freightJson;
      return this;
   }

   @Override
   public String toString() {
      return "Inbound(id="
         + this.getId()
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
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolRebuild="
         + this.getBoolRebuild()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
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
         + ", approvalComments="
         + this.getApprovalComments()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", printStatus="
         + this.getPrintStatus()
         + ", reviewTime="
         + this.getReviewTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", amount="
         + this.getAmount()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", logisticsSupplierId="
         + this.getLogisticsSupplierId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", qualityTestingUserId="
         + this.getQualityTestingUserId()
         + ", qualityTestingUserName="
         + this.getQualityTestingUserName()
         + ", qualityTestingTime="
         + this.getQualityTestingTime()
         + ", qualityTestingRemark="
         + this.getQualityTestingRemark()
         + ", establishQuantity="
         + this.getEstablishQuantity()
         + ", freightTaxRate="
         + this.getFreightTaxRate()
         + ", outboundId="
         + this.getOutboundId()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", loadingCharge="
         + this.getLoadingCharge()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", inboundWay="
         + this.getInboundWay()
         + ", freightJson="
         + this.getFreightJson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Inbound)) {
         return false;
      }

      Inbound other = (Inbound)o;
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
                  Object this$reviewerId = this.getReviewerId();
                  Object other$reviewerId = other.getReviewerId();
                  if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                     Object this$editorId = this.getEditorId();
                     Object other$editorId = other.getEditorId();
                     if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
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
                                          Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                          Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                          if (this$weightMeasurementMode == null
                                             ? other$weightMeasurementMode == null
                                             : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                             Object this$printStatus = this.getPrintStatus();
                                             Object other$printStatus = other.getPrintStatus();
                                             if (this$printStatus == null ? other$printStatus == null : this$printStatus.equals(other$printStatus)) {
                                                Object this$rejectStatus = this.getRejectStatus();
                                                Object other$rejectStatus = other.getRejectStatus();
                                                if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                                                   Object this$logisticsSupplierId = this.getLogisticsSupplierId();
                                                   Object other$logisticsSupplierId = other.getLogisticsSupplierId();
                                                   if (this$logisticsSupplierId == null
                                                      ? other$logisticsSupplierId == null
                                                      : this$logisticsSupplierId.equals(other$logisticsSupplierId)) {
                                                      Object this$boolPartyA = this.getBoolPartyA();
                                                      Object other$boolPartyA = other.getBoolPartyA();
                                                      if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                                         Object this$qualityTestingEnum = this.getQualityTestingEnum();
                                                         Object other$qualityTestingEnum = other.getQualityTestingEnum();
                                                         if (this$qualityTestingEnum == null
                                                            ? other$qualityTestingEnum == null
                                                            : this$qualityTestingEnum.equals(other$qualityTestingEnum)) {
                                                            Object this$qualityTestingUserId = this.getQualityTestingUserId();
                                                            Object other$qualityTestingUserId = other.getQualityTestingUserId();
                                                            if (this$qualityTestingUserId == null
                                                               ? other$qualityTestingUserId == null
                                                               : this$qualityTestingUserId.equals(other$qualityTestingUserId)) {
                                                               Object this$establishQuantity = this.getEstablishQuantity();
                                                               Object other$establishQuantity = other.getEstablishQuantity();
                                                               if (this$establishQuantity == null
                                                                  ? other$establishQuantity == null
                                                                  : this$establishQuantity.equals(other$establishQuantity)) {
                                                                  Object this$outboundId = this.getOutboundId();
                                                                  Object other$outboundId = other.getOutboundId();
                                                                  if (this$outboundId == null
                                                                     ? other$outboundId == null
                                                                     : this$outboundId.equals(other$outboundId)) {
                                                                     Object this$approveRecordId = this.getApproveRecordId();
                                                                     Object other$approveRecordId = other.getApproveRecordId();
                                                                     if (this$approveRecordId == null
                                                                        ? other$approveRecordId == null
                                                                        : this$approveRecordId.equals(other$approveRecordId)) {
                                                                        Object this$boolNestSurplus = this.getBoolNestSurplus();
                                                                        Object other$boolNestSurplus = other.getBoolNestSurplus();
                                                                        if (this$boolNestSurplus == null
                                                                           ? other$boolNestSurplus == null
                                                                           : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                                                           Object this$mesWorkshopId = this.getMesWorkshopId();
                                                                           Object other$mesWorkshopId = other.getMesWorkshopId();
                                                                           if (this$mesWorkshopId == null
                                                                              ? other$mesWorkshopId == null
                                                                              : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                                                                              Object this$inboundWay = this.getInboundWay();
                                                                              Object other$inboundWay = other.getInboundWay();
                                                                              if (this$inboundWay == null
                                                                                 ? other$inboundWay == null
                                                                                 : this$inboundWay.equals(other$inboundWay)) {
                                                                                 Object this$purchaseSn = this.getPurchaseSn();
                                                                                 Object other$purchaseSn = other.getPurchaseSn();
                                                                                 if (this$purchaseSn == null
                                                                                    ? other$purchaseSn == null
                                                                                    : this$purchaseSn.equals(other$purchaseSn)) {
                                                                                    Object this$licensePlate = this.getLicensePlate();
                                                                                    Object other$licensePlate = other.getLicensePlate();
                                                                                    if (this$licensePlate == null
                                                                                       ? other$licensePlate == null
                                                                                       : this$licensePlate.equals(other$licensePlate)) {
                                                                                       Object this$projectIds = this.getProjectIds();
                                                                                       Object other$projectIds = other.getProjectIds();
                                                                                       if (this$projectIds == null
                                                                                          ? other$projectIds == null
                                                                                          : this$projectIds.equals(other$projectIds)) {
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
                                                                                                Object this$serialNumber = this.getSerialNumber();
                                                                                                Object other$serialNumber = other.getSerialNumber();
                                                                                                if (this$serialNumber == null
                                                                                                   ? other$serialNumber == null
                                                                                                   : this$serialNumber.equals(other$serialNumber)) {
                                                                                                   Object this$applicantName = this.getApplicantName();
                                                                                                   Object other$applicantName = other.getApplicantName();
                                                                                                   if (this$applicantName == null
                                                                                                      ? other$applicantName == null
                                                                                                      : this$applicantName.equals(other$applicantName)) {
                                                                                                      Object this$reviewerName = this.getReviewerName();
                                                                                                      Object other$reviewerName = other.getReviewerName();
                                                                                                      if (this$reviewerName == null
                                                                                                         ? other$reviewerName == null
                                                                                                         : this$reviewerName.equals(other$reviewerName)) {
                                                                                                         Object this$editorName = this.getEditorName();
                                                                                                         Object other$editorName = other.getEditorName();
                                                                                                         if (this$editorName == null
                                                                                                            ? other$editorName == null
                                                                                                            : this$editorName.equals(other$editorName)) {
                                                                                                            Object this$freight = this.getFreight();
                                                                                                            Object other$freight = other.getFreight();
                                                                                                            if (this$freight == null
                                                                                                               ? other$freight == null
                                                                                                               : this$freight.equals(other$freight)) {
                                                                                                               Object this$freightWeight = this.getFreightWeight();
                                                                                                               Object other$freightWeight = other.getFreightWeight();
                                                                                                               if (this$freightWeight == null
                                                                                                                  ? other$freightWeight == null
                                                                                                                  : this$freightWeight.equals(
                                                                                                                     other$freightWeight
                                                                                                                  )) {
                                                                                                                  Object this$approvalComments = this.getApprovalComments();
                                                                                                                  Object other$approvalComments = other.getApprovalComments();
                                                                                                                  if (this$approvalComments == null
                                                                                                                     ? other$approvalComments == null
                                                                                                                     : this$approvalComments.equals(
                                                                                                                        other$approvalComments
                                                                                                                     )) {
                                                                                                                     Object this$reviewTime = this.getReviewTime();
                                                                                                                     Object other$reviewTime = other.getReviewTime();
                                                                                                                     if (this$reviewTime == null
                                                                                                                        ? other$reviewTime == null
                                                                                                                        : this$reviewTime.equals(
                                                                                                                           other$reviewTime
                                                                                                                        )) {
                                                                                                                        Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                                        Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                                        if (this$userUpdateTime == null
                                                                                                                           ? other$userUpdateTime == null
                                                                                                                           : this$userUpdateTime.equals(
                                                                                                                              other$userUpdateTime
                                                                                                                           )) {
                                                                                                                           Object this$shipmentNumber = this.getShipmentNumber();
                                                                                                                           Object other$shipmentNumber = other.getShipmentNumber();
                                                                                                                           if (this$shipmentNumber == null
                                                                                                                              ? other$shipmentNumber == null
                                                                                                                              : this$shipmentNumber.equals(
                                                                                                                                 other$shipmentNumber
                                                                                                                              )) {
                                                                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                              if (this$amountExcludingVat
                                                                                                                                    == null
                                                                                                                                 ? other$amountExcludingVat
                                                                                                                                    == null
                                                                                                                                 : this$amountExcludingVat.equals(
                                                                                                                                    other$amountExcludingVat
                                                                                                                                 )) {
                                                                                                                                 Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                                                 Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                                                 if (this$amountExcludingVatNoFreight
                                                                                                                                       == null
                                                                                                                                    ? other$amountExcludingVatNoFreight
                                                                                                                                       == null
                                                                                                                                    : this$amountExcludingVatNoFreight.equals(
                                                                                                                                       other$amountExcludingVatNoFreight
                                                                                                                                    )) {
                                                                                                                                    Object this$amount = this.getAmount();
                                                                                                                                    Object other$amount = other.getAmount();
                                                                                                                                    if (this$amount == null
                                                                                                                                       ? other$amount == null
                                                                                                                                       : this$amount.equals(
                                                                                                                                          other$amount
                                                                                                                                       )) {
                                                                                                                                       Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                       Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                       if (this$amountNoFreight
                                                                                                                                             == null
                                                                                                                                          ? other$amountNoFreight
                                                                                                                                             == null
                                                                                                                                          : this$amountNoFreight.equals(
                                                                                                                                             other$amountNoFreight
                                                                                                                                          )) {
                                                                                                                                          Object this$attachmentIds = this.getAttachmentIds();
                                                                                                                                          Object other$attachmentIds = other.getAttachmentIds();
                                                                                                                                          if (this$attachmentIds
                                                                                                                                                == null
                                                                                                                                             ? other$attachmentIds
                                                                                                                                                == null
                                                                                                                                             : this$attachmentIds.equals(
                                                                                                                                                other$attachmentIds
                                                                                                                                             )) {
                                                                                                                                             Object this$qualityTestingUserName = this.getQualityTestingUserName();
                                                                                                                                             Object other$qualityTestingUserName = other.getQualityTestingUserName();
                                                                                                                                             if (this$qualityTestingUserName
                                                                                                                                                   == null
                                                                                                                                                ? other$qualityTestingUserName
                                                                                                                                                   == null
                                                                                                                                                : this$qualityTestingUserName.equals(
                                                                                                                                                   other$qualityTestingUserName
                                                                                                                                                )) {
                                                                                                                                                Object this$qualityTestingTime = this.getQualityTestingTime();
                                                                                                                                                Object other$qualityTestingTime = other.getQualityTestingTime();
                                                                                                                                                if (this$qualityTestingTime
                                                                                                                                                      == null
                                                                                                                                                   ? other$qualityTestingTime
                                                                                                                                                      == null
                                                                                                                                                   : this$qualityTestingTime.equals(
                                                                                                                                                      other$qualityTestingTime
                                                                                                                                                   )) {
                                                                                                                                                   Object this$qualityTestingRemark = this.getQualityTestingRemark();
                                                                                                                                                   Object other$qualityTestingRemark = other.getQualityTestingRemark();
                                                                                                                                                   if (this$qualityTestingRemark
                                                                                                                                                         == null
                                                                                                                                                      ? other$qualityTestingRemark
                                                                                                                                                         == null
                                                                                                                                                      : this$qualityTestingRemark.equals(
                                                                                                                                                         other$qualityTestingRemark
                                                                                                                                                      )) {
                                                                                                                                                      Object this$freightTaxRate = this.getFreightTaxRate();
                                                                                                                                                      Object other$freightTaxRate = other.getFreightTaxRate();
                                                                                                                                                      if (this$freightTaxRate
                                                                                                                                                            == null
                                                                                                                                                         ? other$freightTaxRate
                                                                                                                                                            == null
                                                                                                                                                         : this$freightTaxRate.equals(
                                                                                                                                                            other$freightTaxRate
                                                                                                                                                         )) {
                                                                                                                                                         Object this$loadingCharge = this.getLoadingCharge();
                                                                                                                                                         Object other$loadingCharge = other.getLoadingCharge();
                                                                                                                                                         if (this$loadingCharge
                                                                                                                                                               == null
                                                                                                                                                            ? other$loadingCharge
                                                                                                                                                               == null
                                                                                                                                                            : this$loadingCharge.equals(
                                                                                                                                                               other$loadingCharge
                                                                                                                                                            )) {
                                                                                                                                                            Object this$classifyIds = this.getClassifyIds();
                                                                                                                                                            Object other$classifyIds = other.getClassifyIds();
                                                                                                                                                            if (this$classifyIds
                                                                                                                                                                  == null
                                                                                                                                                               ? other$classifyIds
                                                                                                                                                                  == null
                                                                                                                                                               : this$classifyIds.equals(
                                                                                                                                                                  other$classifyIds
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$freightJson = this.getFreightJson();
                                                                                                                                                               Object other$freightJson = other.getFreightJson();
                                                                                                                                                               return this$freightJson
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$freightJson
                                                                                                                                                                     == null
                                                                                                                                                                  : this$freightJson.equals(
                                                                                                                                                                     other$freightJson
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
      return other instanceof Inbound;
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
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
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
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $printStatus = this.getPrintStatus();
      result = result * 59 + ($printStatus == null ? 43 : $printStatus.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $logisticsSupplierId = this.getLogisticsSupplierId();
      result = result * 59 + ($logisticsSupplierId == null ? 43 : $logisticsSupplierId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $qualityTestingUserId = this.getQualityTestingUserId();
      result = result * 59 + ($qualityTestingUserId == null ? 43 : $qualityTestingUserId.hashCode());
      Object $establishQuantity = this.getEstablishQuantity();
      result = result * 59 + ($establishQuantity == null ? 43 : $establishQuantity.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
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
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $freightWeight = this.getFreightWeight();
      result = result * 59 + ($freightWeight == null ? 43 : $freightWeight.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $qualityTestingUserName = this.getQualityTestingUserName();
      result = result * 59 + ($qualityTestingUserName == null ? 43 : $qualityTestingUserName.hashCode());
      Object $qualityTestingTime = this.getQualityTestingTime();
      result = result * 59 + ($qualityTestingTime == null ? 43 : $qualityTestingTime.hashCode());
      Object $qualityTestingRemark = this.getQualityTestingRemark();
      result = result * 59 + ($qualityTestingRemark == null ? 43 : $qualityTestingRemark.hashCode());
      Object $freightTaxRate = this.getFreightTaxRate();
      result = result * 59 + ($freightTaxRate == null ? 43 : $freightTaxRate.hashCode());
      Object $loadingCharge = this.getLoadingCharge();
      result = result * 59 + ($loadingCharge == null ? 43 : $loadingCharge.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $freightJson = this.getFreightJson();
      return result * 59 + ($freightJson == null ? 43 : $freightJson.hashCode());
   }

   public static class InboundBuilder {
      private Long id;
      private Long purchaseId;
      private String purchaseSn;
      private String licensePlate;
      private String projectIds;
      private BigDecimal loadingWeight;
      private BigDecimal inboundTotalWeight;
      private String serialNumber;
      private Boolean boolRebuild;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;
      private Long editorId;
      private String editorName;
      private Integer basicClass;
      private Integer reviewStatus;
      private Long supplierId;
      private BigDecimal freight;
      private BigDecimal freightWeight;
      private Long originalId;
      private Integer originalNumber;
      private Boolean editable;
      private String approvalComments;
      private Integer weightMeasurementMode;
      private Boolean printStatus;
      private LocalDateTime reviewTime;
      private LocalDateTime userUpdateTime;
      private Integer rejectStatus;
      private String shipmentNumber;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal amount;
      private BigDecimal amountNoFreight;
      private Long logisticsSupplierId;
      private Boolean boolPartyA;
      private Integer qualityTestingEnum;
      private String attachmentIds;
      private Long qualityTestingUserId;
      private String qualityTestingUserName;
      private LocalDateTime qualityTestingTime;
      private String qualityTestingRemark;
      private Integer establishQuantity;
      private BigDecimal freightTaxRate;
      private Long outboundId;
      private Long approveRecordId;
      private BigDecimal loadingCharge;
      private String classifyIds;
      private Boolean boolNestSurplus;
      private Long mesWorkshopId;
      private Integer inboundWay;
      private String freightJson;

      InboundBuilder() {
      }

      @JsonProperty("id")
      public Inbound.InboundBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("purchaseId")
      public Inbound.InboundBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("purchaseSn")
      public Inbound.InboundBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      @JsonProperty("licensePlate")
      public Inbound.InboundBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("projectIds")
      public Inbound.InboundBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("loadingWeight")
      public Inbound.InboundBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      @JsonProperty("inboundTotalWeight")
      public Inbound.InboundBuilder inboundTotalWeight(final BigDecimal inboundTotalWeight) {
         this.inboundTotalWeight = inboundTotalWeight;
         return this;
      }

      @JsonProperty("serialNumber")
      public Inbound.InboundBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("boolRebuild")
      public Inbound.InboundBuilder boolRebuild(final Boolean boolRebuild) {
         this.boolRebuild = boolRebuild;
         return this;
      }

      @JsonProperty("applicantId")
      public Inbound.InboundBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public Inbound.InboundBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerId")
      public Inbound.InboundBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Inbound.InboundBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("editorId")
      public Inbound.InboundBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("editorName")
      public Inbound.InboundBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("basicClass")
      public Inbound.InboundBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("reviewStatus")
      public Inbound.InboundBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("supplierId")
      public Inbound.InboundBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("freight")
      public Inbound.InboundBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      @JsonProperty("freightWeight")
      public Inbound.InboundBuilder freightWeight(final BigDecimal freightWeight) {
         this.freightWeight = freightWeight;
         return this;
      }

      @JsonProperty("originalId")
      public Inbound.InboundBuilder originalId(final Long originalId) {
         this.originalId = originalId;
         return this;
      }

      @JsonProperty("originalNumber")
      public Inbound.InboundBuilder originalNumber(final Integer originalNumber) {
         this.originalNumber = originalNumber;
         return this;
      }

      @JsonProperty("editable")
      public Inbound.InboundBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      @JsonProperty("approvalComments")
      public Inbound.InboundBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public Inbound.InboundBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("printStatus")
      public Inbound.InboundBuilder printStatus(final Boolean printStatus) {
         this.printStatus = printStatus;
         return this;
      }

      @JsonProperty("reviewTime")
      public Inbound.InboundBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Inbound.InboundBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("rejectStatus")
      public Inbound.InboundBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      @JsonProperty("shipmentNumber")
      public Inbound.InboundBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public Inbound.InboundBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public Inbound.InboundBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amount")
      public Inbound.InboundBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public Inbound.InboundBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("logisticsSupplierId")
      public Inbound.InboundBuilder logisticsSupplierId(final Long logisticsSupplierId) {
         this.logisticsSupplierId = logisticsSupplierId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Inbound.InboundBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("qualityTestingEnum")
      public Inbound.InboundBuilder qualityTestingEnum(final Integer qualityTestingEnum) {
         this.qualityTestingEnum = qualityTestingEnum;
         return this;
      }

      @JsonProperty("attachmentIds")
      public Inbound.InboundBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("qualityTestingUserId")
      public Inbound.InboundBuilder qualityTestingUserId(final Long qualityTestingUserId) {
         this.qualityTestingUserId = qualityTestingUserId;
         return this;
      }

      @JsonProperty("qualityTestingUserName")
      public Inbound.InboundBuilder qualityTestingUserName(final String qualityTestingUserName) {
         this.qualityTestingUserName = qualityTestingUserName;
         return this;
      }

      @JsonProperty("qualityTestingTime")
      public Inbound.InboundBuilder qualityTestingTime(final LocalDateTime qualityTestingTime) {
         this.qualityTestingTime = qualityTestingTime;
         return this;
      }

      @JsonProperty("qualityTestingRemark")
      public Inbound.InboundBuilder qualityTestingRemark(final String qualityTestingRemark) {
         this.qualityTestingRemark = qualityTestingRemark;
         return this;
      }

      @JsonProperty("establishQuantity")
      public Inbound.InboundBuilder establishQuantity(final Integer establishQuantity) {
         this.establishQuantity = establishQuantity;
         return this;
      }

      @JsonProperty("freightTaxRate")
      public Inbound.InboundBuilder freightTaxRate(final BigDecimal freightTaxRate) {
         this.freightTaxRate = freightTaxRate;
         return this;
      }

      @JsonProperty("outboundId")
      public Inbound.InboundBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("approveRecordId")
      public Inbound.InboundBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("loadingCharge")
      public Inbound.InboundBuilder loadingCharge(final BigDecimal loadingCharge) {
         this.loadingCharge = loadingCharge;
         return this;
      }

      @JsonProperty("classifyIds")
      public Inbound.InboundBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      @JsonProperty("boolNestSurplus")
      public Inbound.InboundBuilder boolNestSurplus(final Boolean boolNestSurplus) {
         this.boolNestSurplus = boolNestSurplus;
         return this;
      }

      @JsonProperty("mesWorkshopId")
      public Inbound.InboundBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      @JsonProperty("inboundWay")
      public Inbound.InboundBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      @JsonProperty("freightJson")
      public Inbound.InboundBuilder freightJson(final String freightJson) {
         this.freightJson = freightJson;
         return this;
      }

      public Inbound build() {
         return new Inbound(
            this.id,
            this.purchaseId,
            this.purchaseSn,
            this.licensePlate,
            this.projectIds,
            this.loadingWeight,
            this.inboundTotalWeight,
            this.serialNumber,
            this.boolRebuild,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName,
            this.editorId,
            this.editorName,
            this.basicClass,
            this.reviewStatus,
            this.supplierId,
            this.freight,
            this.freightWeight,
            this.originalId,
            this.originalNumber,
            this.editable,
            this.approvalComments,
            this.weightMeasurementMode,
            this.printStatus,
            this.reviewTime,
            this.userUpdateTime,
            this.rejectStatus,
            this.shipmentNumber,
            this.amountExcludingVat,
            this.amountExcludingVatNoFreight,
            this.amount,
            this.amountNoFreight,
            this.logisticsSupplierId,
            this.boolPartyA,
            this.qualityTestingEnum,
            this.attachmentIds,
            this.qualityTestingUserId,
            this.qualityTestingUserName,
            this.qualityTestingTime,
            this.qualityTestingRemark,
            this.establishQuantity,
            this.freightTaxRate,
            this.outboundId,
            this.approveRecordId,
            this.loadingCharge,
            this.classifyIds,
            this.boolNestSurplus,
            this.mesWorkshopId,
            this.inboundWay,
            this.freightJson
         );
      }

      @Override
      public String toString() {
         return "Inbound.InboundBuilder(id="
            + this.id
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
            + ", serialNumber="
            + this.serialNumber
            + ", boolRebuild="
            + this.boolRebuild
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
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
            + ", approvalComments="
            + this.approvalComments
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", printStatus="
            + this.printStatus
            + ", reviewTime="
            + this.reviewTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", rejectStatus="
            + this.rejectStatus
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", amount="
            + this.amount
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", logisticsSupplierId="
            + this.logisticsSupplierId
            + ", boolPartyA="
            + this.boolPartyA
            + ", qualityTestingEnum="
            + this.qualityTestingEnum
            + ", attachmentIds="
            + this.attachmentIds
            + ", qualityTestingUserId="
            + this.qualityTestingUserId
            + ", qualityTestingUserName="
            + this.qualityTestingUserName
            + ", qualityTestingTime="
            + this.qualityTestingTime
            + ", qualityTestingRemark="
            + this.qualityTestingRemark
            + ", establishQuantity="
            + this.establishQuantity
            + ", freightTaxRate="
            + this.freightTaxRate
            + ", outboundId="
            + this.outboundId
            + ", approveRecordId="
            + this.approveRecordId
            + ", loadingCharge="
            + this.loadingCharge
            + ", classifyIds="
            + this.classifyIds
            + ", boolNestSurplus="
            + this.boolNestSurplus
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", inboundWay="
            + this.inboundWay
            + ", freightJson="
            + this.freightJson
            + ")";
      }
   }
}
