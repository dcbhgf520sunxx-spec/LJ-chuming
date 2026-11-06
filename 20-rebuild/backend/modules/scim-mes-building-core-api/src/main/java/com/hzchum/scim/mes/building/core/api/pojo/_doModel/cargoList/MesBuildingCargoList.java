package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

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

@ApiModel(value = "MesBuildingCargoList对象", description = "发运表")
@Entity
@TableName("mes_building_cargo_list")
@Table(name = "mes_building_cargo_list", indexes = @Index(name = "serialNumber_index", columnList = "serial_number", unique = true))
public class MesBuildingCargoList extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "transportMode", value = "结构运输方式 1运送到场 2客户自提", notes = "运输方式 1运送到场 2客户自提")
   @JsonProperty("transportMode")
   @JSONField(name = "transportMode")
   @TableField("transport_mode")
   @Column(name = "transport_mode", columnDefinition = "int(11) default 1  COMMENT '运输方式 1运送到场 2客户自提'")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "围护运输方式 1运送到场 2客户自提")
   @JsonProperty("enclosureTransportMode")
   @JSONField(name = "enclosureTransportMode")
   @TableField("enclosure_transport_mode")
   @Column(name = "enclosure_transport_mode", columnDefinition = "int(11) default 1 comment '围护运输方式 1运送到场 2客户自提' ")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", value = "结构计量方式 1理论计算 2磅记", notes = "结构计量方式 1理论计算 2磅记")
   @JsonProperty("structureMeasureMode")
   @JSONField(name = "structureMeasureMode")
   @TableField("structure_measure_mode")
   @Column(name = "structure_measure_mode", columnDefinition = "int(11) default 1  COMMENT '结构计量方式 1理论计算 2磅记'", nullable = true)
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", value = "围护计量方式 1 长度计量 2 面积计量", notes = "围护计量方式 1 长度计量 2 面积计量")
   @JsonProperty("enclosureMeasureMode")
   @JSONField(name = "enclosureMeasureMode")
   @TableField("enclosure_measure_mode")
   @Column(name = "enclosure_measure_mode", columnDefinition = "int(11) default 1 COMMENT '围护计量方式 1 长度计量 2 面积计量'", nullable = true)
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "supplierPriceId", value = "物流单位价格id", notes = "物流单位价格id")
   @JsonProperty("supplierPriceId")
   @JSONField(name = "supplierPriceId")
   @TableField(value = "supplier_price_id", updateStrategy = FieldStrategy.IGNORED)
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
   @TableField(value = "serial_number", updateStrategy = FieldStrategy.IGNORED)
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
   @TableField(value = "car_model", updateStrategy = FieldStrategy.IGNORED)
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
   @TableField(value = "receipt_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "receipt_name", columnDefinition = "varchar(255)  COMMENT '接收人'", nullable = true)
   private String receiptName;
   @ApiModelProperty(name = "receiptPhone", value = "接收人电话", notes = "接收人电话")
   @JsonProperty("receiptPhone")
   @JSONField(name = "receiptPhone")
   @TableField(value = "receipt_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "receipt_phone", columnDefinition = "varchar(255)  COMMENT '接收人电话'", nullable = true)
   private String receiptPhone;
   @ApiModelProperty(name = "quantity", value = "总数", notes = "总数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '总数'", nullable = false)
   private BigDecimal quantity;
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
   @ApiModelProperty(name = "userIds", value = "历史装车人id(多个以逗号分隔)", notes = "历史装车人id(多个以逗号分隔)")
   @JsonProperty("userIds")
   @JSONField(name = "userIds")
   @TableField("user_ids")
   @Column(name = "user_ids", columnDefinition = "varchar(255)  COMMENT '装车人ids(多个以逗号分隔)'")
   private String userIds;
   @ApiModelProperty(name = "userName", value = "最新装车人名称", notes = "最新装车人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '最新装车人名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "userNames", value = "历史装车人名称(多个以逗号分隔)", notes = "历史装车人名称(多个以逗号分隔)")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   @TableField("user_names")
   @Column(name = "user_names", columnDefinition = "varchar(64)  COMMENT '历史装车人名称(多个以逗号分隔)'", nullable = true)
   private String userNames;
   @ApiModelProperty(name = "actualUserId", value = "过磅人id", notes = "过磅人id")
   @JsonProperty("actualUserId")
   @JSONField(name = "actualUserId")
   @TableField(value = "actual_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "actual_user_id", columnDefinition = "bigint(20)  COMMENT '过磅人id'", nullable = true)
   private Long actualUserId;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   @JsonProperty("actualUserName")
   @JSONField(name = "actualUserName")
   @TableField(value = "actual_user_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "actual_user_name", columnDefinition = "varchar(64)  COMMENT '过磅人名称'", nullable = true)
   private String actualUserName;
   @ApiModelProperty(name = "actualTime", value = "过磅日期", notes = "过磅日期")
   @JsonProperty("actualTime")
   @JSONField(name = "actualTime")
   @TableField(value = "actual_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "actual_time", columnDefinition = "datetime  COMMENT '过磅日期'", nullable = true)
   private LocalDateTime actualTime;
   @ApiModelProperty(name = "auditUserId", value = "发运审核人id", notes = "发运审核人id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField(value = "audit_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '发运审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   @JsonProperty("auditUserName")
   @JSONField(name = "auditUserName")
   @TableField(value = "audit_user_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_user_name", columnDefinition = "varchar(64)  COMMENT '发运审核人名称'", nullable = true)
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "发运审核时间", notes = "发运审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField(value = "audit_time", updateStrategy = FieldStrategy.IGNORED)
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
   @TableField(value = "audit_receipt_time", updateStrategy = FieldStrategy.IGNORED)
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
   @ApiModelProperty(name = "relationType", value = "配套件关联类型 2构件 4围护", notes = "配套件关联类型 2构件 4围护")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) COMMENT '配套件关联类型 2构件 4围护'")
   private Integer relationType;
   @ApiModelProperty(name = "receiveAttachmentId", value = "收货附件", notes = "收货附件")
   @JsonProperty("receiveAttachmentId")
   @JSONField(name = "receiveAttachmentId")
   @TableField("receive_attachment_id")
   @Column(name = "receive_attachment_id", columnDefinition = "bigint(20)  COMMENT '收货附件'", nullable = true)
   private Long receiveAttachmentId;
   @ApiModelProperty(name = "deviceId", value = "设备编码", notes = "设备编码")
   @TableField("device_id")
   @Column(name = "device_id", columnDefinition = "varchar(255)  COMMENT '设备编码'", nullable = true)
   private Long deviceId;
   @ApiModelProperty(name = "meansConveyanceEnum", value = "运输工具 1车 2船", notes = "运输工具 1车 2船")
   @JsonProperty("meansConveyanceEnum")
   @JSONField(name = "meansConveyanceEnum")
   @TableField("means_conveyance_enum")
   @Column(name = "means_conveyance_enum", columnDefinition = "int(11) default '1' COMMENT '运输工具 1车 2船'")
   private Integer meansConveyanceEnum;

   public static MesBuildingCargoList.MesBuildingCargoListBuilder builder() {
      return new MesBuildingCargoList.MesBuildingCargoListBuilder();
   }

   public MesBuildingCargoList() {
   }

   public MesBuildingCargoList(
      final Long id,
      final Long projectId,
      final Integer transportMode,
      final Integer enclosureTransportMode,
      final Integer structureMeasureMode,
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
      final BigDecimal quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal actualWeight,
      final BigDecimal actualGrossWeight,
      final Integer status,
      final Long userId,
      final String userIds,
      final String userName,
      final String userNames,
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
      final String attachmentIds,
      final Integer relationType,
      final Long receiveAttachmentId,
      final Long deviceId,
      final Integer meansConveyanceEnum
   ) {
      this.id = id;
      this.projectId = projectId;
      this.transportMode = transportMode;
      this.enclosureTransportMode = enclosureTransportMode;
      this.structureMeasureMode = structureMeasureMode;
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
      this.userIds = userIds;
      this.userName = userName;
      this.userNames = userNames;
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
      this.relationType = relationType;
      this.receiveAttachmentId = receiveAttachmentId;
      this.deviceId = deviceId;
      this.meansConveyanceEnum = meansConveyanceEnum;
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

   public Integer getEnclosureTransportMode() {
      return this.enclosureTransportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
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

   public BigDecimal getQuantity() {
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

   public String getUserIds() {
      return this.userIds;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getUserNames() {
      return this.userNames;
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

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getReceiveAttachmentId() {
      return this.receiveAttachmentId;
   }

   public Long getDeviceId() {
      return this.deviceId;
   }

   public Integer getMeansConveyanceEnum() {
      return this.meansConveyanceEnum;
   }

   @JsonProperty("id")
   public MesBuildingCargoList setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingCargoList setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("transportMode")
   public MesBuildingCargoList setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
      return this;
   }

   @JsonProperty("enclosureTransportMode")
   public MesBuildingCargoList setEnclosureTransportMode(final Integer enclosureTransportMode) {
      this.enclosureTransportMode = enclosureTransportMode;
      return this;
   }

   @JsonProperty("structureMeasureMode")
   public MesBuildingCargoList setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   @JsonProperty("enclosureMeasureMode")
   public MesBuildingCargoList setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
      return this;
   }

   @JsonProperty("supplierPriceId")
   public MesBuildingCargoList setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
      return this;
   }

   @JsonProperty("manufactureType")
   public MesBuildingCargoList setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingCargoList setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingCargoList setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("licensePlate")
   public MesBuildingCargoList setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("carModel")
   public MesBuildingCargoList setCarModel(final String carModel) {
      this.carModel = carModel;
      return this;
   }

   @JsonProperty("driverName")
   public MesBuildingCargoList setDriverName(final String driverName) {
      this.driverName = driverName;
      return this;
   }

   @JsonProperty("driverPhone")
   public MesBuildingCargoList setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
      return this;
   }

   @JsonProperty("receiptName")
   public MesBuildingCargoList setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
      return this;
   }

   @JsonProperty("receiptPhone")
   public MesBuildingCargoList setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingCargoList setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingCargoList setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingCargoList setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("actualWeight")
   public MesBuildingCargoList setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
      return this;
   }

   @JsonProperty("actualGrossWeight")
   public MesBuildingCargoList setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingCargoList setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingCargoList setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userIds")
   public MesBuildingCargoList setUserIds(final String userIds) {
      this.userIds = userIds;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingCargoList setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("userNames")
   public MesBuildingCargoList setUserNames(final String userNames) {
      this.userNames = userNames;
      return this;
   }

   @JsonProperty("actualUserId")
   public MesBuildingCargoList setActualUserId(final Long actualUserId) {
      this.actualUserId = actualUserId;
      return this;
   }

   @JsonProperty("actualUserName")
   public MesBuildingCargoList setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   @JsonProperty("actualTime")
   public MesBuildingCargoList setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
      return this;
   }

   @JsonProperty("auditUserId")
   public MesBuildingCargoList setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditUserName")
   public MesBuildingCargoList setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   @JsonProperty("auditTime")
   public MesBuildingCargoList setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("auditReceiptId")
   public MesBuildingCargoList setAuditReceiptId(final Long auditReceiptId) {
      this.auditReceiptId = auditReceiptId;
      return this;
   }

   @JsonProperty("auditReceiptName")
   public MesBuildingCargoList setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
      return this;
   }

   @JsonProperty("auditReceiptTime")
   public MesBuildingCargoList setAuditReceiptTime(final LocalDateTime auditReceiptTime) {
      this.auditReceiptTime = auditReceiptTime;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingCargoList setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("category")
   public MesBuildingCargoList setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("boolProblemReceiving")
   public MesBuildingCargoList setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
      return this;
   }

   @JsonProperty("problemDesc")
   public MesBuildingCargoList setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
      return this;
   }

   @JsonProperty("totalPrice")
   public MesBuildingCargoList setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingCargoList setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("priceType")
   public MesBuildingCargoList setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @JsonProperty("deliveryStatus")
   public MesBuildingCargoList setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
      return this;
   }

   @JsonProperty("shipmentStatus")
   public MesBuildingCargoList setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
      return this;
   }

   @JsonProperty("statusUpdateDate")
   public MesBuildingCargoList setStatusUpdateDate(final LocalDateTime statusUpdateDate) {
      this.statusUpdateDate = statusUpdateDate;
      return this;
   }

   @JsonProperty("changeFreight")
   public MesBuildingCargoList setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
      return this;
   }

   @JsonProperty("cancelDeliveryReason")
   public MesBuildingCargoList setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
      return this;
   }

   @JsonProperty("changeFreightReason")
   public MesBuildingCargoList setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
      return this;
   }

   @JsonProperty("emptyCars")
   public MesBuildingCargoList setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
      return this;
   }

   @JsonProperty("attachmentIds")
   public MesBuildingCargoList setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("relationType")
   public MesBuildingCargoList setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("receiveAttachmentId")
   public MesBuildingCargoList setReceiveAttachmentId(final Long receiveAttachmentId) {
      this.receiveAttachmentId = receiveAttachmentId;
      return this;
   }

   public MesBuildingCargoList setDeviceId(final Long deviceId) {
      this.deviceId = deviceId;
      return this;
   }

   @JsonProperty("meansConveyanceEnum")
   public MesBuildingCargoList setMeansConveyanceEnum(final Integer meansConveyanceEnum) {
      this.meansConveyanceEnum = meansConveyanceEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCargoList(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", transportMode="
         + this.getTransportMode()
         + ", enclosureTransportMode="
         + this.getEnclosureTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
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
         + ", userIds="
         + this.getUserIds()
         + ", userName="
         + this.getUserName()
         + ", userNames="
         + this.getUserNames()
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
         + ", relationType="
         + this.getRelationType()
         + ", receiveAttachmentId="
         + this.getReceiveAttachmentId()
         + ", deviceId="
         + this.getDeviceId()
         + ", meansConveyanceEnum="
         + this.getMeansConveyanceEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCargoList)) {
         return false;
      }

      MesBuildingCargoList other = (MesBuildingCargoList)o;
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
               Object this$enclosureTransportMode = this.getEnclosureTransportMode();
               Object other$enclosureTransportMode = other.getEnclosureTransportMode();
               if (this$enclosureTransportMode == null
                  ? other$enclosureTransportMode == null
                  : this$enclosureTransportMode.equals(other$enclosureTransportMode)) {
                  Object this$structureMeasureMode = this.getStructureMeasureMode();
                  Object other$structureMeasureMode = other.getStructureMeasureMode();
                  if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
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
                                                                  Object this$relationType = this.getRelationType();
                                                                  Object other$relationType = other.getRelationType();
                                                                  if (this$relationType == null
                                                                     ? other$relationType == null
                                                                     : this$relationType.equals(other$relationType)) {
                                                                     Object this$receiveAttachmentId = this.getReceiveAttachmentId();
                                                                     Object other$receiveAttachmentId = other.getReceiveAttachmentId();
                                                                     if (this$receiveAttachmentId == null
                                                                        ? other$receiveAttachmentId == null
                                                                        : this$receiveAttachmentId.equals(other$receiveAttachmentId)) {
                                                                        Object this$deviceId = this.getDeviceId();
                                                                        Object other$deviceId = other.getDeviceId();
                                                                        if (this$deviceId == null
                                                                           ? other$deviceId == null
                                                                           : this$deviceId.equals(other$deviceId)) {
                                                                           Object this$meansConveyanceEnum = this.getMeansConveyanceEnum();
                                                                           Object other$meansConveyanceEnum = other.getMeansConveyanceEnum();
                                                                           if (this$meansConveyanceEnum == null
                                                                              ? other$meansConveyanceEnum == null
                                                                              : this$meansConveyanceEnum.equals(other$meansConveyanceEnum)) {
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
                                                                                    if (this$carModel == null
                                                                                       ? other$carModel == null
                                                                                       : this$carModel.equals(other$carModel)) {
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
                                                                                                   Object this$quantity = this.getQuantity();
                                                                                                   Object other$quantity = other.getQuantity();
                                                                                                   if (this$quantity == null
                                                                                                      ? other$quantity == null
                                                                                                      : this$quantity.equals(other$quantity)) {
                                                                                                      Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                      Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                      if (this$totalNetWeight == null
                                                                                                         ? other$totalNetWeight == null
                                                                                                         : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                                         Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                         Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                         if (this$totalGrossWeight == null
                                                                                                            ? other$totalGrossWeight == null
                                                                                                            : this$totalGrossWeight.equals(
                                                                                                               other$totalGrossWeight
                                                                                                            )) {
                                                                                                            Object this$actualWeight = this.getActualWeight();
                                                                                                            Object other$actualWeight = other.getActualWeight();
                                                                                                            if (this$actualWeight == null
                                                                                                               ? other$actualWeight == null
                                                                                                               : this$actualWeight.equals(other$actualWeight)) {
                                                                                                               Object this$actualGrossWeight = this.getActualGrossWeight();
                                                                                                               Object other$actualGrossWeight = other.getActualGrossWeight();
                                                                                                               if (this$actualGrossWeight == null
                                                                                                                  ? other$actualGrossWeight == null
                                                                                                                  : this$actualGrossWeight.equals(
                                                                                                                     other$actualGrossWeight
                                                                                                                  )) {
                                                                                                                  Object this$userIds = this.getUserIds();
                                                                                                                  Object other$userIds = other.getUserIds();
                                                                                                                  if (this$userIds == null
                                                                                                                     ? other$userIds == null
                                                                                                                     : this$userIds.equals(other$userIds)) {
                                                                                                                     Object this$userName = this.getUserName();
                                                                                                                     Object other$userName = other.getUserName();
                                                                                                                     if (this$userName == null
                                                                                                                        ? other$userName == null
                                                                                                                        : this$userName.equals(other$userName)) {
                                                                                                                        Object this$userNames = this.getUserNames();
                                                                                                                        Object other$userNames = other.getUserNames();
                                                                                                                        if (this$userNames == null
                                                                                                                           ? other$userNames == null
                                                                                                                           : this$userNames.equals(
                                                                                                                              other$userNames
                                                                                                                           )) {
                                                                                                                           Object this$actualUserName = this.getActualUserName();
                                                                                                                           Object other$actualUserName = other.getActualUserName();
                                                                                                                           if (this$actualUserName == null
                                                                                                                              ? other$actualUserName == null
                                                                                                                              : this$actualUserName.equals(
                                                                                                                                 other$actualUserName
                                                                                                                              )) {
                                                                                                                              Object this$actualTime = this.getActualTime();
                                                                                                                              Object other$actualTime = other.getActualTime();
                                                                                                                              if (this$actualTime == null
                                                                                                                                 ? other$actualTime == null
                                                                                                                                 : this$actualTime.equals(
                                                                                                                                    other$actualTime
                                                                                                                                 )) {
                                                                                                                                 Object this$auditUserName = this.getAuditUserName();
                                                                                                                                 Object other$auditUserName = other.getAuditUserName();
                                                                                                                                 if (this$auditUserName == null
                                                                                                                                    ? other$auditUserName
                                                                                                                                       == null
                                                                                                                                    : this$auditUserName.equals(
                                                                                                                                       other$auditUserName
                                                                                                                                    )) {
                                                                                                                                    Object this$auditTime = this.getAuditTime();
                                                                                                                                    Object other$auditTime = other.getAuditTime();
                                                                                                                                    if (this$auditTime == null
                                                                                                                                       ? other$auditTime
                                                                                                                                          == null
                                                                                                                                       : this$auditTime.equals(
                                                                                                                                          other$auditTime
                                                                                                                                       )) {
                                                                                                                                       Object this$auditReceiptName = this.getAuditReceiptName();
                                                                                                                                       Object other$auditReceiptName = other.getAuditReceiptName();
                                                                                                                                       if (this$auditReceiptName
                                                                                                                                             == null
                                                                                                                                          ? other$auditReceiptName
                                                                                                                                             == null
                                                                                                                                          : this$auditReceiptName.equals(
                                                                                                                                             other$auditReceiptName
                                                                                                                                          )) {
                                                                                                                                          Object this$auditReceiptTime = this.getAuditReceiptTime();
                                                                                                                                          Object other$auditReceiptTime = other.getAuditReceiptTime();
                                                                                                                                          if (this$auditReceiptTime
                                                                                                                                                == null
                                                                                                                                             ? other$auditReceiptTime
                                                                                                                                                == null
                                                                                                                                             : this$auditReceiptTime.equals(
                                                                                                                                                other$auditReceiptTime
                                                                                                                                             )) {
                                                                                                                                             Object this$remark = this.getRemark();
                                                                                                                                             Object other$remark = other.getRemark();
                                                                                                                                             if (this$remark
                                                                                                                                                   == null
                                                                                                                                                ? other$remark
                                                                                                                                                   == null
                                                                                                                                                : this$remark.equals(
                                                                                                                                                   other$remark
                                                                                                                                                )) {
                                                                                                                                                Object this$problemDesc = this.getProblemDesc();
                                                                                                                                                Object other$problemDesc = other.getProblemDesc();
                                                                                                                                                if (this$problemDesc
                                                                                                                                                      == null
                                                                                                                                                   ? other$problemDesc
                                                                                                                                                      == null
                                                                                                                                                   : this$problemDesc.equals(
                                                                                                                                                      other$problemDesc
                                                                                                                                                   )) {
                                                                                                                                                   Object this$totalPrice = this.getTotalPrice();
                                                                                                                                                   Object other$totalPrice = other.getTotalPrice();
                                                                                                                                                   if (this$totalPrice
                                                                                                                                                         == null
                                                                                                                                                      ? other$totalPrice
                                                                                                                                                         == null
                                                                                                                                                      : this$totalPrice.equals(
                                                                                                                                                         other$totalPrice
                                                                                                                                                      )) {
                                                                                                                                                      Object this$price = this.getPrice();
                                                                                                                                                      Object other$price = other.getPrice();
                                                                                                                                                      if (this$price
                                                                                                                                                            == null
                                                                                                                                                         ? other$price
                                                                                                                                                            == null
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
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$changeFreightReason = this.getChangeFreightReason();
                                                                                                                                                               Object other$changeFreightReason = other.getChangeFreightReason();
                                                                                                                                                               if (this$changeFreightReason
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$changeFreightReason
                                                                                                                                                                     == null
                                                                                                                                                                  : this$changeFreightReason.equals(
                                                                                                                                                                     other$changeFreightReason
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$emptyCars = this.getEmptyCars();
                                                                                                                                                                  Object other$emptyCars = other.getEmptyCars();
                                                                                                                                                                  if (this$emptyCars
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$emptyCars
                                                                                                                                                                        == null
                                                                                                                                                                     : this$emptyCars.equals(
                                                                                                                                                                        other$emptyCars
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
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
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingCargoList;
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
      Object $enclosureTransportMode = this.getEnclosureTransportMode();
      result = result * 59 + ($enclosureTransportMode == null ? 43 : $enclosureTransportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
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
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $receiveAttachmentId = this.getReceiveAttachmentId();
      result = result * 59 + ($receiveAttachmentId == null ? 43 : $receiveAttachmentId.hashCode());
      Object $deviceId = this.getDeviceId();
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
      Object $meansConveyanceEnum = this.getMeansConveyanceEnum();
      result = result * 59 + ($meansConveyanceEnum == null ? 43 : $meansConveyanceEnum.hashCode());
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $userIds = this.getUserIds();
      result = result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $userNames = this.getUserNames();
      result = result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
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

   public static class MesBuildingCargoListBuilder {
      private Long id;
      private Long projectId;
      private Integer transportMode;
      private Integer enclosureTransportMode;
      private Integer structureMeasureMode;
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
      private BigDecimal quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal actualWeight;
      private BigDecimal actualGrossWeight;
      private Integer status;
      private Long userId;
      private String userIds;
      private String userName;
      private String userNames;
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
      private Integer relationType;
      private Long receiveAttachmentId;
      private Long deviceId;
      private Integer meansConveyanceEnum;

      MesBuildingCargoListBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCargoList.MesBuildingCargoListBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("transportMode")
      public MesBuildingCargoList.MesBuildingCargoListBuilder transportMode(final Integer transportMode) {
         this.transportMode = transportMode;
         return this;
      }

      @JsonProperty("enclosureTransportMode")
      public MesBuildingCargoList.MesBuildingCargoListBuilder enclosureTransportMode(final Integer enclosureTransportMode) {
         this.enclosureTransportMode = enclosureTransportMode;
         return this;
      }

      @JsonProperty("structureMeasureMode")
      public MesBuildingCargoList.MesBuildingCargoListBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      @JsonProperty("enclosureMeasureMode")
      public MesBuildingCargoList.MesBuildingCargoListBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      @JsonProperty("supplierPriceId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder supplierPriceId(final Long supplierPriceId) {
         this.supplierPriceId = supplierPriceId;
         return this;
      }

      @JsonProperty("manufactureType")
      public MesBuildingCargoList.MesBuildingCargoListBuilder manufactureType(final Integer manufactureType) {
         this.manufactureType = manufactureType;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingCargoList.MesBuildingCargoListBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingCargoList.MesBuildingCargoListBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("licensePlate")
      public MesBuildingCargoList.MesBuildingCargoListBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("carModel")
      public MesBuildingCargoList.MesBuildingCargoListBuilder carModel(final String carModel) {
         this.carModel = carModel;
         return this;
      }

      @JsonProperty("driverName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      @JsonProperty("driverPhone")
      public MesBuildingCargoList.MesBuildingCargoListBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      @JsonProperty("receiptName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder receiptName(final String receiptName) {
         this.receiptName = receiptName;
         return this;
      }

      @JsonProperty("receiptPhone")
      public MesBuildingCargoList.MesBuildingCargoListBuilder receiptPhone(final String receiptPhone) {
         this.receiptPhone = receiptPhone;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingCargoList.MesBuildingCargoListBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingCargoList.MesBuildingCargoListBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingCargoList.MesBuildingCargoListBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("actualWeight")
      public MesBuildingCargoList.MesBuildingCargoListBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      @JsonProperty("actualGrossWeight")
      public MesBuildingCargoList.MesBuildingCargoListBuilder actualGrossWeight(final BigDecimal actualGrossWeight) {
         this.actualGrossWeight = actualGrossWeight;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingCargoList.MesBuildingCargoListBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userIds")
      public MesBuildingCargoList.MesBuildingCargoListBuilder userIds(final String userIds) {
         this.userIds = userIds;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("userNames")
      public MesBuildingCargoList.MesBuildingCargoListBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      @JsonProperty("actualUserId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder actualUserId(final Long actualUserId) {
         this.actualUserId = actualUserId;
         return this;
      }

      @JsonProperty("actualUserName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      @JsonProperty("actualTime")
      public MesBuildingCargoList.MesBuildingCargoListBuilder actualTime(final LocalDateTime actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      @JsonProperty("auditUserId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditUserName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      @JsonProperty("auditTime")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("auditReceiptId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditReceiptId(final Long auditReceiptId) {
         this.auditReceiptId = auditReceiptId;
         return this;
      }

      @JsonProperty("auditReceiptName")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditReceiptName(final String auditReceiptName) {
         this.auditReceiptName = auditReceiptName;
         return this;
      }

      @JsonProperty("auditReceiptTime")
      public MesBuildingCargoList.MesBuildingCargoListBuilder auditReceiptTime(final LocalDateTime auditReceiptTime) {
         this.auditReceiptTime = auditReceiptTime;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingCargoList.MesBuildingCargoListBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("category")
      public MesBuildingCargoList.MesBuildingCargoListBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("boolProblemReceiving")
      public MesBuildingCargoList.MesBuildingCargoListBuilder boolProblemReceiving(final Boolean boolProblemReceiving) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      @JsonProperty("problemDesc")
      public MesBuildingCargoList.MesBuildingCargoListBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      @JsonProperty("totalPrice")
      public MesBuildingCargoList.MesBuildingCargoListBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingCargoList.MesBuildingCargoListBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("priceType")
      public MesBuildingCargoList.MesBuildingCargoListBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      @JsonProperty("deliveryStatus")
      public MesBuildingCargoList.MesBuildingCargoListBuilder deliveryStatus(final Integer deliveryStatus) {
         this.deliveryStatus = deliveryStatus;
         return this;
      }

      @JsonProperty("shipmentStatus")
      public MesBuildingCargoList.MesBuildingCargoListBuilder shipmentStatus(final Integer shipmentStatus) {
         this.shipmentStatus = shipmentStatus;
         return this;
      }

      @JsonProperty("statusUpdateDate")
      public MesBuildingCargoList.MesBuildingCargoListBuilder statusUpdateDate(final LocalDateTime statusUpdateDate) {
         this.statusUpdateDate = statusUpdateDate;
         return this;
      }

      @JsonProperty("changeFreight")
      public MesBuildingCargoList.MesBuildingCargoListBuilder changeFreight(final Integer changeFreight) {
         this.changeFreight = changeFreight;
         return this;
      }

      @JsonProperty("cancelDeliveryReason")
      public MesBuildingCargoList.MesBuildingCargoListBuilder cancelDeliveryReason(final String cancelDeliveryReason) {
         this.cancelDeliveryReason = cancelDeliveryReason;
         return this;
      }

      @JsonProperty("changeFreightReason")
      public MesBuildingCargoList.MesBuildingCargoListBuilder changeFreightReason(final String changeFreightReason) {
         this.changeFreightReason = changeFreightReason;
         return this;
      }

      @JsonProperty("emptyCars")
      public MesBuildingCargoList.MesBuildingCargoListBuilder emptyCars(final BigDecimal emptyCars) {
         this.emptyCars = emptyCars;
         return this;
      }

      @JsonProperty("attachmentIds")
      public MesBuildingCargoList.MesBuildingCargoListBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("relationType")
      public MesBuildingCargoList.MesBuildingCargoListBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("receiveAttachmentId")
      public MesBuildingCargoList.MesBuildingCargoListBuilder receiveAttachmentId(final Long receiveAttachmentId) {
         this.receiveAttachmentId = receiveAttachmentId;
         return this;
      }

      public MesBuildingCargoList.MesBuildingCargoListBuilder deviceId(final Long deviceId) {
         this.deviceId = deviceId;
         return this;
      }

      @JsonProperty("meansConveyanceEnum")
      public MesBuildingCargoList.MesBuildingCargoListBuilder meansConveyanceEnum(final Integer meansConveyanceEnum) {
         this.meansConveyanceEnum = meansConveyanceEnum;
         return this;
      }

      public MesBuildingCargoList build() {
         return new MesBuildingCargoList(
            this.id,
            this.projectId,
            this.transportMode,
            this.enclosureTransportMode,
            this.structureMeasureMode,
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
            this.userIds,
            this.userName,
            this.userNames,
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
            this.attachmentIds,
            this.relationType,
            this.receiveAttachmentId,
            this.deviceId,
            this.meansConveyanceEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCargoList.MesBuildingCargoListBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", transportMode="
            + this.transportMode
            + ", enclosureTransportMode="
            + this.enclosureTransportMode
            + ", structureMeasureMode="
            + this.structureMeasureMode
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
            + ", userIds="
            + this.userIds
            + ", userName="
            + this.userName
            + ", userNames="
            + this.userNames
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
            + ", relationType="
            + this.relationType
            + ", receiveAttachmentId="
            + this.receiveAttachmentId
            + ", deviceId="
            + this.deviceId
            + ", meansConveyanceEnum="
            + this.meansConveyanceEnum
            + ")";
      }
   }
}
