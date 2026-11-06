package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList;

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

@ApiModel(value = "MesEnclosureCargoList对象", description = "发运表")
@Entity
@TableName("mes_enclosure_cargo_list")
@Table(name = "mes_enclosure_cargo_list")
public class MesEnclosureCargoList extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "transportMode", value = "运输方式 1运送到场 2客户自提", notes = "运输方式 1运送到场 2客户自提")
   @JsonProperty("transportMode")
   @JSONField(name = "transportMode")
   @TableField("transport_mode")
   @Column(name = "transport_mode", columnDefinition = "int(11)  COMMENT '运输方式 1运送到场 2客户自提'")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureMeasureMode", value = "围护计量方式 1 长度计量 2 面积计量", notes = "围护计量方式 1 长度计量 2 面积计量")
   @JsonProperty("enclosureMeasureMode")
   @JSONField(name = "enclosureMeasureMode")
   @TableField("enclosure_measure_mode")
   @Column(name = "enclosure_measure_mode", columnDefinition = "int(11)  COMMENT '围护计量方式 1 长度计量 2 面积计量'", nullable = true)
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "supplierPriceId", value = "物流单位价格id", notes = "物流单位价格id")
   @JsonProperty("supplierPriceId")
   @JSONField(name = "supplierPriceId")
   @TableField("supplier_price_id")
   @Column(name = "supplier_price_id", columnDefinition = "bigint(20)  COMMENT '物流单位价格id'", nullable = true)
   private Long supplierPriceId;
   @ApiModelProperty(name = "manufactureType", value = "制造类型 自制,2外包", notes = "制造类型 自制,2外包")
   @JsonProperty("manufactureType")
   @JSONField(name = "manufactureType")
   @TableField("manufacture_type")
   @Column(name = "manufacture_type", columnDefinition = "int(11) default '1' COMMENT '制造类型 自制,2外包'")
   private Integer manufactureType;
   @ApiModelProperty(name = "productType", value = "装载类型", notes = "装载类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '装载类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "serialNumber", value = "车次编号", notes = "车次编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '车次编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   @TableField("license_plate")
   @Column(name = "license_plate", columnDefinition = "varchar(64)  COMMENT '车牌号'", nullable = false)
   private String licensePlate;
   @ApiModelProperty(name = "carModel", value = "车型", notes = "车型")
   @JsonProperty("carModel")
   @JSONField(name = "carModel")
   @TableField("car_model")
   @Column(name = "car_model", columnDefinition = "varchar(64)  COMMENT '车型'", nullable = true)
   private String carModel;
   @ApiModelProperty(name = "driverName", value = "司机姓名", notes = "司机姓名")
   @JsonProperty("driverName")
   @JSONField(name = "driverName")
   @TableField("driver_name")
   @Column(name = "driver_name", columnDefinition = "varchar(64)  COMMENT '司机姓名'", nullable = true)
   private String driverName;
   @ApiModelProperty(name = "driverPhone", value = "司机电话", notes = "司机电话")
   @JsonProperty("driverPhone")
   @JSONField(name = "driverPhone")
   @TableField("driver_phone")
   @Column(name = "driver_phone", columnDefinition = "varchar(64)  COMMENT '司机电话'", nullable = true)
   private String driverPhone;
   @ApiModelProperty(name = "receiptName", value = "接收人", notes = "接收人")
   @JsonProperty("receiptName")
   @JSONField(name = "receiptName")
   @TableField("receipt_name")
   @Column(name = "receipt_name", columnDefinition = "varchar(255)  COMMENT '接收人'", nullable = true)
   private String receiptName;
   @ApiModelProperty(name = "receiptPhone", value = "接收人电话", notes = "接收人电话")
   @JsonProperty("receiptPhone")
   @JSONField(name = "receiptPhone")
   @TableField("receipt_phone")
   @Column(name = "receipt_phone", columnDefinition = "varchar(255)  COMMENT '接收人电话'", nullable = true)
   private String receiptPhone;
   @ApiModelProperty(name = "quantity", value = "总数", notes = "总数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '总数'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重量", notes = "总净重量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总净重量'", nullable = false)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重量", notes = "总毛重量")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总毛重量'", nullable = false)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "actualWeight", value = "过磅净量", notes = "过磅净量")
   @JsonProperty("actualWeight")
   @JSONField(name = "actualWeight")
   @TableField("actual_weight")
   @Column(name = "actual_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '过磅重量'", nullable = false)
   private BigDecimal actualWeight;
   @ApiModelProperty(name = "actualGrossWeight", value = "过磅毛重", notes = "过磅毛重")
   @JsonProperty("actualGrossWeight")
   @JSONField(name = "actualGrossWeight")
   @TableField("actual_gross_weight")
   @Column(name = "actual_gross_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '过磅毛重'", nullable = false)
   private BigDecimal actualGrossWeight;
   @ApiModelProperty(name = "status", value = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]", notes = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '1' COMMENT '发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "userId", value = "装车人id", notes = "装车人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '装车人id'")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '装车人名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "actualUserId", value = "过磅人id", notes = "过磅人id")
   @JsonProperty("actualUserId")
   @JSONField(name = "actualUserId")
   @TableField("actual_user_id")
   @Column(name = "actual_user_id", columnDefinition = "bigint(20)  COMMENT '过磅人id'", nullable = true)
   private Long actualUserId;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   @JsonProperty("actualUserName")
   @JSONField(name = "actualUserName")
   @TableField("actual_user_name")
   @Column(name = "actual_user_name", columnDefinition = "varchar(64)  COMMENT '过磅人名称'", nullable = true)
   private String actualUserName;
   @ApiModelProperty(name = "actualTime", value = "过磅日期", notes = "过磅日期")
   @JsonProperty("actualTime")
   @JSONField(name = "actualTime")
   @TableField("actual_time")
   @Column(name = "actual_time", columnDefinition = "datetime  COMMENT '过磅日期'", nullable = true)
   private LocalDateTime actualTime;
   @ApiModelProperty(name = "auditUserId", value = "发运审核人id", notes = "发运审核人id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '发运审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   @JsonProperty("auditUserName")
   @JSONField(name = "auditUserName")
   @TableField("audit_user_name")
   @Column(name = "audit_user_name", columnDefinition = "varchar(64)  COMMENT '发运审核人名称'", nullable = true)
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "发运审核时间", notes = "发运审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '发运审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditReceiptId", value = "实际收货人id", notes = "实际收货人id")
   @JsonProperty("auditReceiptId")
   @JSONField(name = "auditReceiptId")
   @TableField("audit_receipt_id")
   @Column(name = "audit_receipt_id", columnDefinition = "bigint(20)  COMMENT '实际收货人id'", nullable = true)
   private Long auditReceiptId;
   @ApiModelProperty(name = "auditReceiptName", value = "实际收货人名称", notes = "实际收货人名称")
   @JsonProperty("auditReceiptName")
   @JSONField(name = "auditReceiptName")
   @TableField("audit_receipt_name")
   @Column(name = "audit_receipt_name", columnDefinition = "varchar(64)  COMMENT '实际收货人名称'", nullable = true)
   private String auditReceiptName;
   @ApiModelProperty(name = "auditReceiptTime", value = "收货日期", notes = "收货日期")
   @JsonProperty("auditReceiptTime")
   @JSONField(name = "auditReceiptTime")
   @TableField("audit_receipt_time")
   @Column(name = "audit_receipt_time", columnDefinition = "datetime  COMMENT '收货日期'", nullable = true)
   private LocalDateTime auditReceiptTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ", notes = "是否问题收货 1问题收货 0正常收货")
   @JsonProperty("boolProblemReceiving")
   @JSONField(name = "boolProblemReceiving")
   @TableField("bool_problem_receiving")
   @Column(name = "bool_problem_receiving", columnDefinition = "tinyint(1)  COMMENT '是否问题收货 1问题收货 0正常收货'")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述 ", notes = "问题收货描述")
   @JsonProperty("problemDesc")
   @JSONField(name = "problemDesc")
   @TableField("problem_desc")
   @Column(name = "problem_desc", columnDefinition = "VARCHAR(1024) COMMENT '问题收货描述'")
   private String problemDesc;
   @ApiModelProperty(name = "totalPrice", value = "运输费 ", notes = "运输费")
   @JsonProperty("totalPrice")
   @JSONField(name = "totalPrice")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '运输费'", nullable = false)
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "price", value = "单价 ", notes = "单价")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单价'")
   private BigDecimal price;
   @ApiModelProperty(name = "priceType", value = "计价方式 ", notes = "计价方式")
   @JsonProperty("priceType")
   @JSONField(name = "priceType")
   @TableField("price_type")
   @Column(name = "price_type", columnDefinition = "int(11) default '1' COMMENT '计价方式'")
   private Integer priceType;
   @ApiModelProperty(name = "deliveryStatus", value = "发运状态(发运记录) ", notes = "发运状态(发运记录)")
   @JsonProperty("deliveryStatus")
   @JSONField(name = "deliveryStatus")
   @TableField("delivery_status")
   @Column(name = "delivery_status", columnDefinition = "tinyint(1) default 1  COMMENT '发运状态 1正常送货 2取消送货'")
   private Integer deliveryStatus;
   @ApiModelProperty(name = "shipmentStatus", value = "发运状态(收货记录) ", notes = "发运状态(收货记录)")
   @JsonProperty("shipmentStatus")
   @JSONField(name = "shipmentStatus")
   @TableField("shipment_status")
   @Column(name = "shipment_status", columnDefinition = "tinyint(1) default 1  COMMENT '发运状态 1送货中 2取消送货 4已签收'")
   private Integer shipmentStatus;
   @ApiModelProperty(name = "statusUpdateDate", value = "状态更新日期", notes = "状态更新日期")
   @JsonProperty("statusUpdateDate")
   @JSONField(name = "statusUpdateDate")
   @TableField("status_update_date")
   @Column(name = "status_update_date", columnDefinition = "datetime  COMMENT '状态更新日期'")
   private LocalDateTime statusUpdateDate;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型")
   @JsonProperty("changeFreight")
   @JSONField(name = "changeFreight")
   @TableField("change_freight")
   @Column(name = "change_freight", columnDefinition = "tinyint(1)  COMMENT '运费变更类型'")
   private Integer changeFreight;
   @ApiModelProperty(name = "cancelDeliveryReason", value = "取消送货原因")
   @JsonProperty("cancelDeliveryReason")
   @JSONField(name = "cancelDeliveryReason")
   @TableField("cancel_delivery_reason")
   @Column(name = "cancel_delivery_reason", columnDefinition = "VARCHAR(1024) COMMENT '取消送货原因'")
   private String cancelDeliveryReason;
   @ApiModelProperty(name = "changeFreightReason", value = "运费变更原因")
   @JsonProperty("changeFreightReason")
   @JSONField(name = "changeFreightReason")
   @TableField("change_freight_reason")
   @Column(name = "change_freight_reason", columnDefinition = "VARCHAR(1024) COMMENT '运费变更原因'")
   private String changeFreightReason;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   @JsonProperty("emptyCars")
   @JSONField(name = "emptyCars")
   @TableField("empty_cars")
   @Column(name = "empty_cars", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '空车重量'")
   private BigDecimal emptyCars;
   @ApiModelProperty(name = "attachmentId", value = "证据拍照附件ids")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "VARCHAR(1024) COMMENT '证据拍照附件ids'")
   private String attachmentIds;

   public static MesEnclosureCargoList.MesEnclosureCargoListBuilder builder() {
      return new MesEnclosureCargoList.MesEnclosureCargoListBuilder();
   }

   public MesEnclosureCargoList() {
   }

   public MesEnclosureCargoList(
      final Long id,
      final Long projectId,
      final Integer transportMode,
      final Integer enclosureMeasureMode,
      final Long supplierPriceId,
      final Integer manufactureType,
      final Integer productType,
      final String serialNumber,
      final String licensePlate,
      final String carModel,
      final String driverName,
      final String driverPhone,
      final String receiptName,
      final String receiptPhone,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal actualWeight,
      final BigDecimal actualGrossWeight,
      final Integer status,
      final Long userId,
      final String userName,
      final Long actualUserId,
      final String actualUserName,
      final LocalDateTime actualTime,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Long auditReceiptId,
      final String auditReceiptName,
      final LocalDateTime auditReceiptTime,
      final String remark,
      final Integer category,
      final Boolean boolProblemReceiving,
      final String problemDesc,
      final BigDecimal totalPrice,
      final BigDecimal price,
      final Integer priceType,
      final Integer deliveryStatus,
      final Integer shipmentStatus,
      final LocalDateTime statusUpdateDate,
      final Integer changeFreight,
      final String cancelDeliveryReason,
      final String changeFreightReason,
      final BigDecimal emptyCars,
      final String attachmentIds
   ) {
      this.id = id;
      this.projectId = projectId;
      this.transportMode = transportMode;
      this.enclosureMeasureMode = enclosureMeasureMode;
      this.supplierPriceId = supplierPriceId;
      this.manufactureType = manufactureType;
      this.productType = productType;
      this.serialNumber = serialNumber;
      this.licensePlate = licensePlate;
      this.carModel = carModel;
      this.driverName = driverName;
      this.driverPhone = driverPhone;
      this.receiptName = receiptName;
      this.receiptPhone = receiptPhone;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.actualWeight = actualWeight;
      this.actualGrossWeight = actualGrossWeight;
      this.status = status;
      this.userId = userId;
      this.userName = userName;
      this.actualUserId = actualUserId;
      this.actualUserName = actualUserName;
      this.actualTime = actualTime;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditReceiptId = auditReceiptId;
      this.auditReceiptName = auditReceiptName;
      this.auditReceiptTime = auditReceiptTime;
      this.remark = remark;
      this.category = category;
      this.boolProblemReceiving = boolProblemReceiving;
      this.problemDesc = problemDesc;
      this.totalPrice = totalPrice;
      this.price = price;
      this.priceType = priceType;
      this.deliveryStatus = deliveryStatus;
      this.shipmentStatus = shipmentStatus;
      this.statusUpdateDate = statusUpdateDate;
      this.changeFreight = changeFreight;
      this.cancelDeliveryReason = cancelDeliveryReason;
      this.changeFreightReason = changeFreightReason;
      this.emptyCars = emptyCars;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getReceiptPhone() {
      return this.receiptPhone;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public BigDecimal getActualGrossWeight() {
      return this.actualGrossWeight;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getActualUserId() {
      return this.actualUserId;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public LocalDateTime getActualTime() {
      return this.actualTime;
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

   public Long getAuditReceiptId() {
      return this.auditReceiptId;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public LocalDateTime getAuditReceiptTime() {
      return this.auditReceiptTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public LocalDateTime getStatusUpdateDate() {
      return this.statusUpdateDate;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public String getCancelDeliveryReason() {
      return this.cancelDeliveryReason;
   }

   public String getChangeFreightReason() {
      return this.changeFreightReason;
   }

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   @JsonProperty("id")
   public MesEnclosureCargoList setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureCargoList setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("transportMode")
   public MesEnclosureCargoList setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
      return this;
   }

   @JsonProperty("enclosureMeasureMode")
   public MesEnclosureCargoList setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
      return this;
   }

   @JsonProperty("supplierPriceId")
   public MesEnclosureCargoList setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
      return this;
   }

   @JsonProperty("manufactureType")
   public MesEnclosureCargoList setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureCargoList setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureCargoList setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("licensePlate")
   public MesEnclosureCargoList setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("carModel")
   public MesEnclosureCargoList setCarModel(final String carModel) {
      this.carModel = carModel;
      return this;
   }

   @JsonProperty("driverName")
   public MesEnclosureCargoList setDriverName(final String driverName) {
      this.driverName = driverName;
      return this;
   }

   @JsonProperty("driverPhone")
   public MesEnclosureCargoList setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
      return this;
   }

   @JsonProperty("receiptName")
   public MesEnclosureCargoList setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
      return this;
   }

   @JsonProperty("receiptPhone")
   public MesEnclosureCargoList setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureCargoList setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureCargoList setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureCargoList setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("actualWeight")
   public MesEnclosureCargoList setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
      return this;
   }

   @JsonProperty("actualGrossWeight")
   public MesEnclosureCargoList setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureCargoList setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureCargoList setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureCargoList setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("actualUserId")
   public MesEnclosureCargoList setActualUserId(final Long actualUserId) {
      this.actualUserId = actualUserId;
      return this;
   }

   @JsonProperty("actualUserName")
   public MesEnclosureCargoList setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   @JsonProperty("actualTime")
   public MesEnclosureCargoList setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
      return this;
   }

   @JsonProperty("auditUserId")
   public MesEnclosureCargoList setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditUserName")
   public MesEnclosureCargoList setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   @JsonProperty("auditTime")
   public MesEnclosureCargoList setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("auditReceiptId")
   public MesEnclosureCargoList setAuditReceiptId(final Long auditReceiptId) {
      this.auditReceiptId = auditReceiptId;
      return this;
   }

   @JsonProperty("auditReceiptName")
   public MesEnclosureCargoList setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
      return this;
   }

   @JsonProperty("auditReceiptTime")
   public MesEnclosureCargoList setAuditReceiptTime(final LocalDateTime auditReceiptTime) {
      this.auditReceiptTime = auditReceiptTime;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureCargoList setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureCargoList setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("boolProblemReceiving")
   public MesEnclosureCargoList setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
      return this;
   }

   @JsonProperty("problemDesc")
   public MesEnclosureCargoList setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
      return this;
   }

   @JsonProperty("totalPrice")
   public MesEnclosureCargoList setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureCargoList setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("priceType")
   public MesEnclosureCargoList setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @JsonProperty("deliveryStatus")
   public MesEnclosureCargoList setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
      return this;
   }

   @JsonProperty("shipmentStatus")
   public MesEnclosureCargoList setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
      return this;
   }

   @JsonProperty("statusUpdateDate")
   public MesEnclosureCargoList setStatusUpdateDate(final LocalDateTime statusUpdateDate) {
      this.statusUpdateDate = statusUpdateDate;
      return this;
   }

   @JsonProperty("changeFreight")
   public MesEnclosureCargoList setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
      return this;
   }

   @JsonProperty("cancelDeliveryReason")
   public MesEnclosureCargoList setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
      return this;
   }

   @JsonProperty("changeFreightReason")
   public MesEnclosureCargoList setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
      return this;
   }

   @JsonProperty("emptyCars")
   public MesEnclosureCargoList setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
      return this;
   }

   @JsonProperty("attachmentIds")
   public MesEnclosureCargoList setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureCargoList(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", transportMode="
         + this.getTransportMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", carModel="
         + this.getCarModel()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", actualWeight="
         + this.getActualWeight()
         + ", actualGrossWeight="
         + this.getActualGrossWeight()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", actualUserId="
         + this.getActualUserId()
         + ", actualUserName="
         + this.getActualUserName()
         + ", actualTime="
         + this.getActualTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditReceiptId="
         + this.getAuditReceiptId()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptTime="
         + this.getAuditReceiptTime()
         + ", remark="
         + this.getRemark()
         + ", category="
         + this.getCategory()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", price="
         + this.getPrice()
         + ", priceType="
         + this.getPriceType()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateDate="
         + this.getStatusUpdateDate()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", cancelDeliveryReason="
         + this.getCancelDeliveryReason()
         + ", changeFreightReason="
         + this.getChangeFreightReason()
         + ", emptyCars="
         + this.getEmptyCars()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCargoList)) {
         return false;
      }

      MesEnclosureCargoList other = (MesEnclosureCargoList)o;
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
            Object this$transportMode = this.getTransportMode();
            Object other$transportMode = other.getTransportMode();
            if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
               Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
               Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
               if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                  Object this$supplierPriceId = this.getSupplierPriceId();
                  Object other$supplierPriceId = other.getSupplierPriceId();
                  if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
                     Object this$manufactureType = this.getManufactureType();
                     Object other$manufactureType = other.getManufactureType();
                     if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$actualUserId = this.getActualUserId();
                                    Object other$actualUserId = other.getActualUserId();
                                    if (this$actualUserId == null ? other$actualUserId == null : this$actualUserId.equals(other$actualUserId)) {
                                       Object this$auditUserId = this.getAuditUserId();
                                       Object other$auditUserId = other.getAuditUserId();
                                       if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                          Object this$auditReceiptId = this.getAuditReceiptId();
                                          Object other$auditReceiptId = other.getAuditReceiptId();
                                          if (this$auditReceiptId == null ? other$auditReceiptId == null : this$auditReceiptId.equals(other$auditReceiptId)) {
                                             Object this$category = this.getCategory();
                                             Object other$category = other.getCategory();
                                             if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                                Object this$boolProblemReceiving = this.getBoolProblemReceiving();
                                                Object other$boolProblemReceiving = other.getBoolProblemReceiving();
                                                if (this$boolProblemReceiving == null
                                                   ? other$boolProblemReceiving == null
                                                   : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
                                                   Object this$priceType = this.getPriceType();
                                                   Object other$priceType = other.getPriceType();
                                                   if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                                                      Object this$deliveryStatus = this.getDeliveryStatus();
                                                      Object other$deliveryStatus = other.getDeliveryStatus();
                                                      if (this$deliveryStatus == null
                                                         ? other$deliveryStatus == null
                                                         : this$deliveryStatus.equals(other$deliveryStatus)) {
                                                         Object this$shipmentStatus = this.getShipmentStatus();
                                                         Object other$shipmentStatus = other.getShipmentStatus();
                                                         if (this$shipmentStatus == null
                                                            ? other$shipmentStatus == null
                                                            : this$shipmentStatus.equals(other$shipmentStatus)) {
                                                            Object this$changeFreight = this.getChangeFreight();
                                                            Object other$changeFreight = other.getChangeFreight();
                                                            if (this$changeFreight == null
                                                               ? other$changeFreight == null
                                                               : this$changeFreight.equals(other$changeFreight)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$licensePlate = this.getLicensePlate();
                                                                  Object other$licensePlate = other.getLicensePlate();
                                                                  if (this$licensePlate == null
                                                                     ? other$licensePlate == null
                                                                     : this$licensePlate.equals(other$licensePlate)) {
                                                                     Object this$carModel = this.getCarModel();
                                                                     Object other$carModel = other.getCarModel();
                                                                     if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                                                        Object this$driverName = this.getDriverName();
                                                                        Object other$driverName = other.getDriverName();
                                                                        if (this$driverName == null
                                                                           ? other$driverName == null
                                                                           : this$driverName.equals(other$driverName)) {
                                                                           Object this$driverPhone = this.getDriverPhone();
                                                                           Object other$driverPhone = other.getDriverPhone();
                                                                           if (this$driverPhone == null
                                                                              ? other$driverPhone == null
                                                                              : this$driverPhone.equals(other$driverPhone)) {
                                                                              Object this$receiptName = this.getReceiptName();
                                                                              Object other$receiptName = other.getReceiptName();
                                                                              if (this$receiptName == null
                                                                                 ? other$receiptName == null
                                                                                 : this$receiptName.equals(other$receiptName)) {
                                                                                 Object this$receiptPhone = this.getReceiptPhone();
                                                                                 Object other$receiptPhone = other.getReceiptPhone();
                                                                                 if (this$receiptPhone == null
                                                                                    ? other$receiptPhone == null
                                                                                    : this$receiptPhone.equals(other$receiptPhone)) {
                                                                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                    if (this$totalNetWeight == null
                                                                                       ? other$totalNetWeight == null
                                                                                       : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                       if (this$totalGrossWeight == null
                                                                                          ? other$totalGrossWeight == null
                                                                                          : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                          Object this$actualWeight = this.getActualWeight();
                                                                                          Object other$actualWeight = other.getActualWeight();
                                                                                          if (this$actualWeight == null
                                                                                             ? other$actualWeight == null
                                                                                             : this$actualWeight.equals(other$actualWeight)) {
                                                                                             Object this$actualGrossWeight = this.getActualGrossWeight();
                                                                                             Object other$actualGrossWeight = other.getActualGrossWeight();
                                                                                             if (this$actualGrossWeight == null
                                                                                                ? other$actualGrossWeight == null
                                                                                                : this$actualGrossWeight.equals(other$actualGrossWeight)) {
                                                                                                Object this$userName = this.getUserName();
                                                                                                Object other$userName = other.getUserName();
                                                                                                if (this$userName == null
                                                                                                   ? other$userName == null
                                                                                                   : this$userName.equals(other$userName)) {
                                                                                                   Object this$actualUserName = this.getActualUserName();
                                                                                                   Object other$actualUserName = other.getActualUserName();
                                                                                                   if (this$actualUserName == null
                                                                                                      ? other$actualUserName == null
                                                                                                      : this$actualUserName.equals(other$actualUserName)) {
                                                                                                      Object this$actualTime = this.getActualTime();
                                                                                                      Object other$actualTime = other.getActualTime();
                                                                                                      if (this$actualTime == null
                                                                                                         ? other$actualTime == null
                                                                                                         : this$actualTime.equals(other$actualTime)) {
                                                                                                         Object this$auditUserName = this.getAuditUserName();
                                                                                                         Object other$auditUserName = other.getAuditUserName();
                                                                                                         if (this$auditUserName == null
                                                                                                            ? other$auditUserName == null
                                                                                                            : this$auditUserName.equals(other$auditUserName)) {
                                                                                                            Object this$auditTime = this.getAuditTime();
                                                                                                            Object other$auditTime = other.getAuditTime();
                                                                                                            if (this$auditTime == null
                                                                                                               ? other$auditTime == null
                                                                                                               : this$auditTime.equals(other$auditTime)) {
                                                                                                               Object this$auditReceiptName = this.getAuditReceiptName();
                                                                                                               Object other$auditReceiptName = other.getAuditReceiptName();
                                                                                                               if (this$auditReceiptName == null
                                                                                                                  ? other$auditReceiptName == null
                                                                                                                  : this$auditReceiptName.equals(
                                                                                                                     other$auditReceiptName
                                                                                                                  )) {
                                                                                                                  Object this$auditReceiptTime = this.getAuditReceiptTime();
                                                                                                                  Object other$auditReceiptTime = other.getAuditReceiptTime();
                                                                                                                  if (this$auditReceiptTime == null
                                                                                                                     ? other$auditReceiptTime == null
                                                                                                                     : this$auditReceiptTime.equals(
                                                                                                                        other$auditReceiptTime
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     if (this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark)) {
                                                                                                                        Object this$problemDesc = this.getProblemDesc();
                                                                                                                        Object other$problemDesc = other.getProblemDesc();
                                                                                                                        if (this$problemDesc == null
                                                                                                                           ? other$problemDesc == null
                                                                                                                           : this$problemDesc.equals(
                                                                                                                              other$problemDesc
                                                                                                                           )) {
                                                                                                                           Object this$totalPrice = this.getTotalPrice();
                                                                                                                           Object other$totalPrice = other.getTotalPrice();
                                                                                                                           if (this$totalPrice == null
                                                                                                                              ? other$totalPrice == null
                                                                                                                              : this$totalPrice.equals(
                                                                                                                                 other$totalPrice
                                                                                                                              )) {
                                                                                                                              Object this$price = this.getPrice();
                                                                                                                              Object other$price = other.getPrice();
                                                                                                                              if (this$price == null
                                                                                                                                 ? other$price == null
                                                                                                                                 : this$price.equals(
                                                                                                                                    other$price
                                                                                                                                 )) {
                                                                                                                                 Object this$statusUpdateDate = this.getStatusUpdateDate();
                                                                                                                                 Object other$statusUpdateDate = other.getStatusUpdateDate();
                                                                                                                                 if (this$statusUpdateDate
                                                                                                                                       == null
                                                                                                                                    ? other$statusUpdateDate
                                                                                                                                       == null
                                                                                                                                    : this$statusUpdateDate.equals(
                                                                                                                                       other$statusUpdateDate
                                                                                                                                    )) {
                                                                                                                                    Object this$cancelDeliveryReason = this.getCancelDeliveryReason();
                                                                                                                                    Object other$cancelDeliveryReason = other.getCancelDeliveryReason();
                                                                                                                                    if (this$cancelDeliveryReason
                                                                                                                                          == null
                                                                                                                                       ? other$cancelDeliveryReason
                                                                                                                                          == null
                                                                                                                                       : this$cancelDeliveryReason.equals(
                                                                                                                                          other$cancelDeliveryReason
                                                                                                                                       )) {
                                                                                                                                       Object this$changeFreightReason = this.getChangeFreightReason();
                                                                                                                                       Object other$changeFreightReason = other.getChangeFreightReason();
                                                                                                                                       if (this$changeFreightReason
                                                                                                                                             == null
                                                                                                                                          ? other$changeFreightReason
                                                                                                                                             == null
                                                                                                                                          : this$changeFreightReason.equals(
                                                                                                                                             other$changeFreightReason
                                                                                                                                          )) {
                                                                                                                                          Object this$emptyCars = this.getEmptyCars();
                                                                                                                                          Object other$emptyCars = other.getEmptyCars();
                                                                                                                                          if (this$emptyCars
                                                                                                                                                == null
                                                                                                                                             ? other$emptyCars
                                                                                                                                                == null
                                                                                                                                             : this$emptyCars.equals(
                                                                                                                                                other$emptyCars
                                                                                                                                             )) {
                                                                                                                                             Object this$attachmentIds = this.getAttachmentIds();
                                                                                                                                             Object other$attachmentIds = other.getAttachmentIds();
                                                                                                                                             return this$attachmentIds
                                                                                                                                                   == null
                                                                                                                                                ? other$attachmentIds
                                                                                                                                                   == null
                                                                                                                                                : this$attachmentIds.equals(
                                                                                                                                                   other$attachmentIds
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureCargoList;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $actualUserId = this.getActualUserId();
      result = result * 59 + ($actualUserId == null ? 43 : $actualUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditReceiptId = this.getAuditReceiptId();
      result = result * 59 + ($auditReceiptId == null ? 43 : $auditReceiptId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      result = result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $actualTime = this.getActualTime();
      result = result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptTime = this.getAuditReceiptTime();
      result = result * 59 + ($auditReceiptTime == null ? 43 : $auditReceiptTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $statusUpdateDate = this.getStatusUpdateDate();
      result = result * 59 + ($statusUpdateDate == null ? 43 : $statusUpdateDate.hashCode());
      Object $cancelDeliveryReason = this.getCancelDeliveryReason();
      result = result * 59 + ($cancelDeliveryReason == null ? 43 : $cancelDeliveryReason.hashCode());
      Object $changeFreightReason = this.getChangeFreightReason();
      result = result * 59 + ($changeFreightReason == null ? 43 : $changeFreightReason.hashCode());
      Object $emptyCars = this.getEmptyCars();
      result = result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class MesEnclosureCargoListBuilder {
      private Long id;
      private Long projectId;
      private Integer transportMode;
      private Integer enclosureMeasureMode;
      private Long supplierPriceId;
      private Integer manufactureType;
      private Integer productType;
      private String serialNumber;
      private String licensePlate;
      private String carModel;
      private String driverName;
      private String driverPhone;
      private String receiptName;
      private String receiptPhone;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal actualWeight;
      private BigDecimal actualGrossWeight;
      private Integer status;
      private Long userId;
      private String userName;
      private Long actualUserId;
      private String actualUserName;
      private LocalDateTime actualTime;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Long auditReceiptId;
      private String auditReceiptName;
      private LocalDateTime auditReceiptTime;
      private String remark;
      private Integer category;
      private Boolean boolProblemReceiving;
      private String problemDesc;
      private BigDecimal totalPrice;
      private BigDecimal price;
      private Integer priceType;
      private Integer deliveryStatus;
      private Integer shipmentStatus;
      private LocalDateTime statusUpdateDate;
      private Integer changeFreight;
      private String cancelDeliveryReason;
      private String changeFreightReason;
      private BigDecimal emptyCars;
      private String attachmentIds;

      MesEnclosureCargoListBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("transportMode")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder transportMode(final Integer transportMode) {
         this.transportMode = transportMode;
         return this;
      }

      @JsonProperty("enclosureMeasureMode")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      @JsonProperty("supplierPriceId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder supplierPriceId(final Long supplierPriceId) {
         this.supplierPriceId = supplierPriceId;
         return this;
      }

      @JsonProperty("manufactureType")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder manufactureType(final Integer manufactureType) {
         this.manufactureType = manufactureType;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("licensePlate")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("carModel")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder carModel(final String carModel) {
         this.carModel = carModel;
         return this;
      }

      @JsonProperty("driverName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      @JsonProperty("driverPhone")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      @JsonProperty("receiptName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder receiptName(final String receiptName) {
         this.receiptName = receiptName;
         return this;
      }

      @JsonProperty("receiptPhone")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder receiptPhone(final String receiptPhone) {
         this.receiptPhone = receiptPhone;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("actualWeight")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      @JsonProperty("actualGrossWeight")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder actualGrossWeight(final BigDecimal actualGrossWeight) {
         this.actualGrossWeight = actualGrossWeight;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("actualUserId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder actualUserId(final Long actualUserId) {
         this.actualUserId = actualUserId;
         return this;
      }

      @JsonProperty("actualUserName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      @JsonProperty("actualTime")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder actualTime(final LocalDateTime actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      @JsonProperty("auditUserId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditUserName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      @JsonProperty("auditTime")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("auditReceiptId")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditReceiptId(final Long auditReceiptId) {
         this.auditReceiptId = auditReceiptId;
         return this;
      }

      @JsonProperty("auditReceiptName")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditReceiptName(final String auditReceiptName) {
         this.auditReceiptName = auditReceiptName;
         return this;
      }

      @JsonProperty("auditReceiptTime")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder auditReceiptTime(final LocalDateTime auditReceiptTime) {
         this.auditReceiptTime = auditReceiptTime;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("boolProblemReceiving")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder boolProblemReceiving(final Boolean boolProblemReceiving) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      @JsonProperty("problemDesc")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      @JsonProperty("totalPrice")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("priceType")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      @JsonProperty("deliveryStatus")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder deliveryStatus(final Integer deliveryStatus) {
         this.deliveryStatus = deliveryStatus;
         return this;
      }

      @JsonProperty("shipmentStatus")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder shipmentStatus(final Integer shipmentStatus) {
         this.shipmentStatus = shipmentStatus;
         return this;
      }

      @JsonProperty("statusUpdateDate")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder statusUpdateDate(final LocalDateTime statusUpdateDate) {
         this.statusUpdateDate = statusUpdateDate;
         return this;
      }

      @JsonProperty("changeFreight")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder changeFreight(final Integer changeFreight) {
         this.changeFreight = changeFreight;
         return this;
      }

      @JsonProperty("cancelDeliveryReason")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder cancelDeliveryReason(final String cancelDeliveryReason) {
         this.cancelDeliveryReason = cancelDeliveryReason;
         return this;
      }

      @JsonProperty("changeFreightReason")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder changeFreightReason(final String changeFreightReason) {
         this.changeFreightReason = changeFreightReason;
         return this;
      }

      @JsonProperty("emptyCars")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder emptyCars(final BigDecimal emptyCars) {
         this.emptyCars = emptyCars;
         return this;
      }

      @JsonProperty("attachmentIds")
      public MesEnclosureCargoList.MesEnclosureCargoListBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public MesEnclosureCargoList build() {
         return new MesEnclosureCargoList(
            this.id,
            this.projectId,
            this.transportMode,
            this.enclosureMeasureMode,
            this.supplierPriceId,
            this.manufactureType,
            this.productType,
            this.serialNumber,
            this.licensePlate,
            this.carModel,
            this.driverName,
            this.driverPhone,
            this.receiptName,
            this.receiptPhone,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.actualWeight,
            this.actualGrossWeight,
            this.status,
            this.userId,
            this.userName,
            this.actualUserId,
            this.actualUserName,
            this.actualTime,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditReceiptId,
            this.auditReceiptName,
            this.auditReceiptTime,
            this.remark,
            this.category,
            this.boolProblemReceiving,
            this.problemDesc,
            this.totalPrice,
            this.price,
            this.priceType,
            this.deliveryStatus,
            this.shipmentStatus,
            this.statusUpdateDate,
            this.changeFreight,
            this.cancelDeliveryReason,
            this.changeFreightReason,
            this.emptyCars,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureCargoList.MesEnclosureCargoListBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", transportMode="
            + this.transportMode
            + ", enclosureMeasureMode="
            + this.enclosureMeasureMode
            + ", supplierPriceId="
            + this.supplierPriceId
            + ", manufactureType="
            + this.manufactureType
            + ", productType="
            + this.productType
            + ", serialNumber="
            + this.serialNumber
            + ", licensePlate="
            + this.licensePlate
            + ", carModel="
            + this.carModel
            + ", driverName="
            + this.driverName
            + ", driverPhone="
            + this.driverPhone
            + ", receiptName="
            + this.receiptName
            + ", receiptPhone="
            + this.receiptPhone
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", actualWeight="
            + this.actualWeight
            + ", actualGrossWeight="
            + this.actualGrossWeight
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", actualUserId="
            + this.actualUserId
            + ", actualUserName="
            + this.actualUserName
            + ", actualTime="
            + this.actualTime
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditReceiptId="
            + this.auditReceiptId
            + ", auditReceiptName="
            + this.auditReceiptName
            + ", auditReceiptTime="
            + this.auditReceiptTime
            + ", remark="
            + this.remark
            + ", category="
            + this.category
            + ", boolProblemReceiving="
            + this.boolProblemReceiving
            + ", problemDesc="
            + this.problemDesc
            + ", totalPrice="
            + this.totalPrice
            + ", price="
            + this.price
            + ", priceType="
            + this.priceType
            + ", deliveryStatus="
            + this.deliveryStatus
            + ", shipmentStatus="
            + this.shipmentStatus
            + ", statusUpdateDate="
            + this.statusUpdateDate
            + ", changeFreight="
            + this.changeFreight
            + ", cancelDeliveryReason="
            + this.cancelDeliveryReason
            + ", changeFreightReason="
            + this.changeFreightReason
            + ", emptyCars="
            + this.emptyCars
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
