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

@ApiModel(value = "WmsBorrowDetail对象", description = "借用明细(和借用出库明细一对一)")
@Entity
@TableName("wms_borrow_detail")
@Table(name = "wms_borrow_detail")
public class WmsBorrowDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "sourceProjectId", value = "物料原项目ID", notes = "物料原项目ID")
   @JsonProperty("sourceProjectId")
   @JSONField(name = "sourceProjectId")
   @TableField("source_project_id")
   @Column(name = "source_project_id", columnDefinition = "bigint  COMMENT '物料原项目ID'", nullable = true)
   private Long sourceProjectId;
   @ApiModelProperty(name = "materialInventoryId", value = "物料池ID", notes = "物料池ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_Inventory_id")
   @Column(name = "material_Inventory_id", columnDefinition = "bigint  COMMENT '物料池ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "outboundMode", value = "出库类型 [1 整出, 2 半出]", notes = "出库类型 [1 整出, 2 半出]")
   @JsonProperty("outboundMode")
   @JSONField(name = "outboundMode")
   @TableField("outbound_mode")
   @Column(name = "outbound_mode", columnDefinition = "int  COMMENT '出库类型 [1 整出, 2 半出]'", nullable = true)
   private Integer outboundMode;
   @ApiModelProperty(name = "halfMode", value = "截取方式 [1 取长, 2 取宽]只有半出设置", notes = "截取方式 [1 取长, 2 取宽]只有半出设置")
   @JsonProperty("halfMode")
   @JSONField(name = "halfMode")
   @TableField("half_mode")
   @Column(name = "half_mode", columnDefinition = "int  COMMENT '截取方式 [1 取长, 2 取宽]只有半出设置'", nullable = true)
   private Integer halfMode;
   @ApiModelProperty(name = "halfSize", value = "截取长度", notes = "截取长度")
   @JsonProperty("halfSize")
   @JSONField(name = "halfSize")
   @TableField("half_size")
   @Column(name = "half_size", columnDefinition = "decimal(32,0)  COMMENT '截取长度'", nullable = true)
   private BigDecimal halfSize;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "quantity", value = "出库数量", notes = "出库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '出库数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "出库核算量", notes = "出库核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '出库核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "length", value = "出库长度", notes = "出库长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '出库长度'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "出库厚度", notes = "出库厚度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '出库厚度'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "物料厚度", notes = "物料厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '物料厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "unitPrice", value = "移动加权价", notes = "移动加权价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '移动加权价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税加权价", notes = "不含税加权价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,8)  COMMENT '不含税加权价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "inboundId", value = "入库单ID 即入即出物料入库ID", notes = "入库单ID 即入即出物料入库ID")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id", columnDefinition = "bigint  COMMENT '入库单ID 即入即出物料入库ID'", nullable = true)
   private Long inboundId;
   @ApiModelProperty(name = "recipientId", value = "领用人ID", notes = "领用人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint  COMMENT '领用人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "outboundTime", value = "出库时间(可修改,默认添加时设置)", notes = "出库时间(可修改,默认添加时设置)")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   @TableField("outbound_time")
   @Column(name = "outbound_time", columnDefinition = "datetime  COMMENT '出库时间(可修改,默认添加时设置)'", nullable = true)
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "invoiceType", value = "票据类型", notes = "票据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '票据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "outboundType", value = "出库类型 [1 整出, 2 半出]", notes = "出库类型 [1 整出, 2 半出]")
   @JsonProperty("outboundType")
   @JSONField(name = "outboundType")
   @TableField("outbound_type")
   @Column(name = "outbound_type", columnDefinition = "int  COMMENT '出库类型 [1 整出, 2 半出]'", nullable = true)
   private Integer outboundType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标", notes = "型材执行的国标")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行的国标", notes = "型材执行的国标")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行的国标'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "sourceMonomerId")
   @JsonProperty("sourceMonomerId")
   @JSONField(name = "sourceMonomerId")
   @TableField("source_monomer_id")
   @Column(name = "source_monomer_id", columnDefinition = "bigint  COMMENT '物料原单体ID'", nullable = true)
   private Long sourceMonomerId;
   @ApiModelProperty(name = "sourceAreaId")
   @JsonProperty("sourceAreaId")
   @JSONField(name = "sourceAreaId")
   @TableField("source_area_id")
   @Column(name = "source_area_id", columnDefinition = "bigint  COMMENT '物料原区域ID'", nullable = true)
   private Long sourceAreaId;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原车间ID", notes = "原车间ID")
   @JsonProperty("sourceWorkshopId")
   @JSONField(name = "sourceWorkshopId")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '原车间ID'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "outboundRelationType", value = "出库关联类型, 枚举 OutboundRelationTypeEnum")
   @JsonProperty("outboundRelationType")
   @JSONField(name = "outboundRelationType")
   @TableField("outbound_relation_type")
   @Column(name = "outbound_relation_type", columnDefinition = "int  COMMENT '出库关联类型, 枚举 OutboundRelationTypeEnum'", nullable = true)
   private Integer outboundRelationType;
   @ApiModelProperty(name = "wapId", value = "加权价ID", notes = "加权价ID")
   @JsonProperty("wapId")
   @JSONField(name = "wapId")
   @TableField("wap_id")
   @Column(name = "wap_id", columnDefinition = "bigint  COMMENT '加权价ID'", nullable = true)
   private Long wapId;
   @ApiModelProperty(name = "boolBasicClassChange", value = "基础科目是否转换(钢卷转钢板)", notes = "基础科目是否转换(钢卷转钢板)")
   @JsonProperty("boolBasicClassChange")
   @JSONField(name = "boolBasicClassChange")
   @TableField("bool_basic_class_change")
   @Column(name = "bool_basic_class_change", columnDefinition = "tinyint(1) default '0' COMMENT '基础科目是否转换(钢卷转钢板)'", nullable = true)
   private Boolean boolBasicClassChange;
   @ApiModelProperty(name = "outboundAddress", value = "1工厂  2工地", notes = "1工厂  2工地")
   @JsonProperty("outboundAddress")
   @JSONField(name = "outboundAddress")
   @TableField("outbound_address")
   @Column(name = "outbound_address", columnDefinition = "int  COMMENT '1工厂  2工地'", nullable = true)
   private Integer outboundAddress;
   @ApiModelProperty(name = "recipientName")
   @JsonProperty("recipientName")
   @JSONField(name = "recipientName")
   @TableField("recipient_name")
   @Column(name = "recipient_name", columnDefinition = "varchar(255)  COMMENT '领用人名'", nullable = true)
   private String recipientName;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "移动加权价 不含运费", notes = "移动加权价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,8)  COMMENT '移动加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税加权价 不含运费", notes = "不含税加权价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,8)  COMMENT '不含税加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "outboundTypeSelection")
   @JsonProperty("outboundTypeSelection")
   @JSONField(name = "outboundTypeSelection")
   @TableField("outbound_type_selection")
   @Column(name = "outbound_type_selection", columnDefinition = "int default '1' COMMENT '出库类型 枚举类[OutboundTypeEnum]'", nullable = false)
   private Integer outboundTypeSelection;
   @ApiModelProperty(name = "outboundDetailId", value = "出库单明细ID", notes = "出库单明细ID")
   @JsonProperty("outboundDetailId")
   @JSONField(name = "outboundDetailId")
   @TableField("outbound_detail_Id")
   @Column(name = "outbound_detail_Id", columnDefinition = "bigint  COMMENT '出库单明细ID'", nullable = true)
   private Long outboundDetailId;
   @ApiModelProperty(name = "remainingAmount", value = "总价 借出明细剩余金额（归还的时候用）", notes = "总价 ")
   @JsonProperty("remainingAmount")
   @JSONField(name = "remainingAmount")
   @TableField("remaining_amount")
   @Column(name = "remaining_amount", columnDefinition = "decimal(32,12)  COMMENT '总价 借出明细剩余金额'", nullable = true)
   private BigDecimal remainingAmount;
   @ApiModelProperty(name = "remainingAmountExcludingVat", value = "不含税总价 借出明细剩余金额", notes = "不含税总价 借出明细剩余金额")
   @JsonProperty("remainingAmountExcludingVat")
   @JSONField(name = "remainingAmountExcludingVat")
   @TableField("remaining_amount_excluding_vat")
   @Column(name = "remaining_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 借出明细剩余金额'", nullable = true)
   private BigDecimal remainingAmountExcludingVat;
   @ApiModelProperty(name = "remainingAmountNoFreight", value = "剩余总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("remainingAmountNoFreight")
   @JSONField(name = "remainingAmountNoFreight")
   @TableField("remaining_amount_no_freight")
   @Column(name = "remaining_amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal remainingAmountNoFreight;
   @ApiModelProperty(name = "remainingAmountExcludingVatNoFreight", value = "剩余不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("remainingAmountExcludingVatNoFreight")
   @JSONField(name = "remainingAmountExcludingVatNoFreight")
   @TableField("remaining_amount_excluding_vat_no_freight")
   @Column(name = "remaining_amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal remainingAmountExcludingVatNoFreight;
   @ApiModelProperty(name = "remainingQuantity", value = "剩余数量（借用）", notes = "剩余数量（借用）")
   @JsonProperty("remainingQuantity")
   @JSONField(name = "remainingQuantity")
   @TableField("remaining_quantity")
   @Column(name = "remaining_quantity", columnDefinition = "decimal(32,8)  COMMENT '剩余数量'", nullable = true)
   private BigDecimal remainingQuantity;
   @ApiModelProperty(name = "remainingMete", value = "剩余量", notes = "剩余量")
   @JsonProperty("remainingMete")
   @JSONField(name = "remainingMete")
   @TableField("remaining_mete")
   @Column(name = "remaining_mete", columnDefinition = "decimal(32,8)  COMMENT '剩余量'", nullable = true)
   private BigDecimal remainingMete;

   public WmsBorrowDetail() {
   }

   public WmsBorrowDetail(
      final Long id,
      final Long outboundId,
      final Long projectId,
      final Long sourceProjectId,
      final Long materialInventoryId,
      final Integer outboundMode,
      final Integer halfMode,
      final BigDecimal halfSize,
      final Integer basicClass,
      final Long classifyId,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String remark,
      final BigDecimal unitNet,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final Long inboundId,
      final Long recipientId,
      final Long warehouseId,
      final LocalDateTime outboundTime,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final Boolean boolPartyA,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Integer invoiceType,
      final Integer materialIsWhole,
      final Integer outboundType,
      final BigDecimal taxRate,
      final BigDecimal theoryThickness,
      final Long standardId,
      final String standardName,
      final String materialSn,
      final Long monomerId,
      final Long areaId,
      final Long sourceMonomerId,
      final Long sourceAreaId,
      final Long workshopId,
      final Long sourceWorkshopId,
      final Integer outboundRelationType,
      final Long wapId,
      final Boolean boolBasicClassChange,
      final Integer outboundAddress,
      final String recipientName,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final Integer outboundTypeSelection,
      final Long outboundDetailId,
      final BigDecimal remainingAmount,
      final BigDecimal remainingAmountExcludingVat,
      final BigDecimal remainingAmountNoFreight,
      final BigDecimal remainingAmountExcludingVatNoFreight,
      final BigDecimal remainingQuantity,
      final BigDecimal remainingMete
   ) {
      this.id = id;
      this.outboundId = outboundId;
      this.projectId = projectId;
      this.sourceProjectId = sourceProjectId;
      this.materialInventoryId = materialInventoryId;
      this.outboundMode = outboundMode;
      this.halfMode = halfMode;
      this.halfSize = halfSize;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.remark = remark;
      this.unitNet = unitNet;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inboundId = inboundId;
      this.recipientId = recipientId;
      this.warehouseId = warehouseId;
      this.outboundTime = outboundTime;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.boolPartyA = boolPartyA;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.invoiceType = invoiceType;
      this.materialIsWhole = materialIsWhole;
      this.outboundType = outboundType;
      this.taxRate = taxRate;
      this.theoryThickness = theoryThickness;
      this.standardId = standardId;
      this.standardName = standardName;
      this.materialSn = materialSn;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.sourceMonomerId = sourceMonomerId;
      this.sourceAreaId = sourceAreaId;
      this.workshopId = workshopId;
      this.sourceWorkshopId = sourceWorkshopId;
      this.outboundRelationType = outboundRelationType;
      this.wapId = wapId;
      this.boolBasicClassChange = boolBasicClassChange;
      this.outboundAddress = outboundAddress;
      this.recipientName = recipientName;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.outboundTypeSelection = outboundTypeSelection;
      this.outboundDetailId = outboundDetailId;
      this.remainingAmount = remainingAmount;
      this.remainingAmountExcludingVat = remainingAmountExcludingVat;
      this.remainingAmountNoFreight = remainingAmountNoFreight;
      this.remainingAmountExcludingVatNoFreight = remainingAmountExcludingVatNoFreight;
      this.remainingQuantity = remainingQuantity;
      this.remainingMete = remainingMete;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Integer getOutboundMode() {
      return this.outboundMode;
   }

   public Integer getHalfMode() {
      return this.halfMode;
   }

   public BigDecimal getHalfSize() {
      return this.halfSize;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getOutboundType() {
      return this.outboundType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getSourceMonomerId() {
      return this.sourceMonomerId;
   }

   public Long getSourceAreaId() {
      return this.sourceAreaId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public Integer getOutboundRelationType() {
      return this.outboundRelationType;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public Boolean getBoolBasicClassChange() {
      return this.boolBasicClassChange;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getInputVatNoFreight() {
      return this.inputVatNoFreight;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public BigDecimal getRemainingAmount() {
      return this.remainingAmount;
   }

   public BigDecimal getRemainingAmountExcludingVat() {
      return this.remainingAmountExcludingVat;
   }

   public BigDecimal getRemainingAmountNoFreight() {
      return this.remainingAmountNoFreight;
   }

   public BigDecimal getRemainingAmountExcludingVatNoFreight() {
      return this.remainingAmountExcludingVatNoFreight;
   }

   public BigDecimal getRemainingQuantity() {
      return this.remainingQuantity;
   }

   public BigDecimal getRemainingMete() {
      return this.remainingMete;
   }

   @JsonProperty("id")
   public WmsBorrowDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("outboundId")
   public WmsBorrowDetail setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("projectId")
   public WmsBorrowDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("sourceProjectId")
   public WmsBorrowDetail setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public WmsBorrowDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("outboundMode")
   public WmsBorrowDetail setOutboundMode(final Integer outboundMode) {
      this.outboundMode = outboundMode;
      return this;
   }

   @JsonProperty("halfMode")
   public WmsBorrowDetail setHalfMode(final Integer halfMode) {
      this.halfMode = halfMode;
      return this;
   }

   @JsonProperty("halfSize")
   public WmsBorrowDetail setHalfSize(final BigDecimal halfSize) {
      this.halfSize = halfSize;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsBorrowDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public WmsBorrowDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("specification")
   public WmsBorrowDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public WmsBorrowDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public WmsBorrowDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("length")
   public WmsBorrowDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public WmsBorrowDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public WmsBorrowDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("remark")
   public WmsBorrowDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("unitNet")
   public WmsBorrowDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("unitPrice")
   public WmsBorrowDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public WmsBorrowDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inboundId")
   public WmsBorrowDetail setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("recipientId")
   public WmsBorrowDetail setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("warehouseId")
   public WmsBorrowDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("outboundTime")
   public WmsBorrowDetail setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("brand")
   public WmsBorrowDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public WmsBorrowDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public WmsBorrowDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("boolPartyA")
   public WmsBorrowDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("amount")
   public WmsBorrowDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public WmsBorrowDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public WmsBorrowDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("invoiceType")
   public WmsBorrowDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public WmsBorrowDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("outboundType")
   public WmsBorrowDetail setOutboundType(final Integer outboundType) {
      this.outboundType = outboundType;
      return this;
   }

   @JsonProperty("taxRate")
   public WmsBorrowDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("theoryThickness")
   public WmsBorrowDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("standardId")
   public WmsBorrowDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public WmsBorrowDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("materialSn")
   public WmsBorrowDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("monomerId")
   public WmsBorrowDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public WmsBorrowDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("sourceMonomerId")
   public WmsBorrowDetail setSourceMonomerId(final Long sourceMonomerId) {
      this.sourceMonomerId = sourceMonomerId;
      return this;
   }

   @JsonProperty("sourceAreaId")
   public WmsBorrowDetail setSourceAreaId(final Long sourceAreaId) {
      this.sourceAreaId = sourceAreaId;
      return this;
   }

   @JsonProperty("workshopId")
   public WmsBorrowDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("sourceWorkshopId")
   public WmsBorrowDetail setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   @JsonProperty("outboundRelationType")
   public WmsBorrowDetail setOutboundRelationType(final Integer outboundRelationType) {
      this.outboundRelationType = outboundRelationType;
      return this;
   }

   @JsonProperty("wapId")
   public WmsBorrowDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("boolBasicClassChange")
   public WmsBorrowDetail setBoolBasicClassChange(final Boolean boolBasicClassChange) {
      this.boolBasicClassChange = boolBasicClassChange;
      return this;
   }

   @JsonProperty("outboundAddress")
   public WmsBorrowDetail setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
      return this;
   }

   @JsonProperty("recipientName")
   public WmsBorrowDetail setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public WmsBorrowDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public WmsBorrowDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public WmsBorrowDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public WmsBorrowDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public WmsBorrowDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public WmsBorrowDetail setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("outboundDetailId")
   public WmsBorrowDetail setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   @JsonProperty("remainingAmount")
   public WmsBorrowDetail setRemainingAmount(final BigDecimal remainingAmount) {
      this.remainingAmount = remainingAmount;
      return this;
   }

   @JsonProperty("remainingAmountExcludingVat")
   public WmsBorrowDetail setRemainingAmountExcludingVat(final BigDecimal remainingAmountExcludingVat) {
      this.remainingAmountExcludingVat = remainingAmountExcludingVat;
      return this;
   }

   @JsonProperty("remainingAmountNoFreight")
   public WmsBorrowDetail setRemainingAmountNoFreight(final BigDecimal remainingAmountNoFreight) {
      this.remainingAmountNoFreight = remainingAmountNoFreight;
      return this;
   }

   @JsonProperty("remainingAmountExcludingVatNoFreight")
   public WmsBorrowDetail setRemainingAmountExcludingVatNoFreight(final BigDecimal remainingAmountExcludingVatNoFreight) {
      this.remainingAmountExcludingVatNoFreight = remainingAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("remainingQuantity")
   public WmsBorrowDetail setRemainingQuantity(final BigDecimal remainingQuantity) {
      this.remainingQuantity = remainingQuantity;
      return this;
   }

   @JsonProperty("remainingMete")
   public WmsBorrowDetail setRemainingMete(final BigDecimal remainingMete) {
      this.remainingMete = remainingMete;
      return this;
   }

   @Override
   public String toString() {
      return "WmsBorrowDetail(id="
         + this.getId()
         + ", outboundId="
         + this.getOutboundId()
         + ", projectId="
         + this.getProjectId()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", outboundMode="
         + this.getOutboundMode()
         + ", halfMode="
         + this.getHalfMode()
         + ", halfSize="
         + this.getHalfSize()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", remark="
         + this.getRemark()
         + ", unitNet="
         + this.getUnitNet()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inboundId="
         + this.getInboundId()
         + ", recipientId="
         + this.getRecipientId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", outboundType="
         + this.getOutboundType()
         + ", taxRate="
         + this.getTaxRate()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", materialSn="
         + this.getMaterialSn()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", sourceMonomerId="
         + this.getSourceMonomerId()
         + ", sourceAreaId="
         + this.getSourceAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", outboundRelationType="
         + this.getOutboundRelationType()
         + ", wapId="
         + this.getWapId()
         + ", boolBasicClassChange="
         + this.getBoolBasicClassChange()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", recipientName="
         + this.getRecipientName()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", remainingAmount="
         + this.getRemainingAmount()
         + ", remainingAmountExcludingVat="
         + this.getRemainingAmountExcludingVat()
         + ", remainingAmountNoFreight="
         + this.getRemainingAmountNoFreight()
         + ", remainingAmountExcludingVatNoFreight="
         + this.getRemainingAmountExcludingVatNoFreight()
         + ", remainingQuantity="
         + this.getRemainingQuantity()
         + ", remainingMete="
         + this.getRemainingMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsBorrowDetail)) {
         return false;
      }

      WmsBorrowDetail other = (WmsBorrowDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundId = this.getOutboundId();
         Object other$outboundId = other.getOutboundId();
         if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$sourceProjectId = this.getSourceProjectId();
               Object other$sourceProjectId = other.getSourceProjectId();
               if (this$sourceProjectId == null ? other$sourceProjectId == null : this$sourceProjectId.equals(other$sourceProjectId)) {
                  Object this$materialInventoryId = this.getMaterialInventoryId();
                  Object other$materialInventoryId = other.getMaterialInventoryId();
                  if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
                     Object this$outboundMode = this.getOutboundMode();
                     Object other$outboundMode = other.getOutboundMode();
                     if (this$outboundMode == null ? other$outboundMode == null : this$outboundMode.equals(other$outboundMode)) {
                        Object this$halfMode = this.getHalfMode();
                        Object other$halfMode = other.getHalfMode();
                        if (this$halfMode == null ? other$halfMode == null : this$halfMode.equals(other$halfMode)) {
                           Object this$basicClass = this.getBasicClass();
                           Object other$basicClass = other.getBasicClass();
                           if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                              Object this$classifyId = this.getClassifyId();
                              Object other$classifyId = other.getClassifyId();
                              if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                 Object this$inboundId = this.getInboundId();
                                 Object other$inboundId = other.getInboundId();
                                 if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                                    Object this$recipientId = this.getRecipientId();
                                    Object other$recipientId = other.getRecipientId();
                                    if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                       Object this$warehouseId = this.getWarehouseId();
                                       Object other$warehouseId = other.getWarehouseId();
                                       if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                          Object this$boolPartyA = this.getBoolPartyA();
                                          Object other$boolPartyA = other.getBoolPartyA();
                                          if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                             Object this$invoiceType = this.getInvoiceType();
                                             Object other$invoiceType = other.getInvoiceType();
                                             if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                Object this$materialIsWhole = this.getMaterialIsWhole();
                                                Object other$materialIsWhole = other.getMaterialIsWhole();
                                                if (this$materialIsWhole == null
                                                   ? other$materialIsWhole == null
                                                   : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                   Object this$outboundType = this.getOutboundType();
                                                   Object other$outboundType = other.getOutboundType();
                                                   if (this$outboundType == null ? other$outboundType == null : this$outboundType.equals(other$outboundType)) {
                                                      Object this$standardId = this.getStandardId();
                                                      Object other$standardId = other.getStandardId();
                                                      if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                         Object this$monomerId = this.getMonomerId();
                                                         Object other$monomerId = other.getMonomerId();
                                                         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                            Object this$areaId = this.getAreaId();
                                                            Object other$areaId = other.getAreaId();
                                                            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                               Object this$sourceMonomerId = this.getSourceMonomerId();
                                                               Object other$sourceMonomerId = other.getSourceMonomerId();
                                                               if (this$sourceMonomerId == null
                                                                  ? other$sourceMonomerId == null
                                                                  : this$sourceMonomerId.equals(other$sourceMonomerId)) {
                                                                  Object this$sourceAreaId = this.getSourceAreaId();
                                                                  Object other$sourceAreaId = other.getSourceAreaId();
                                                                  if (this$sourceAreaId == null
                                                                     ? other$sourceAreaId == null
                                                                     : this$sourceAreaId.equals(other$sourceAreaId)) {
                                                                     Object this$workshopId = this.getWorkshopId();
                                                                     Object other$workshopId = other.getWorkshopId();
                                                                     if (this$workshopId == null
                                                                        ? other$workshopId == null
                                                                        : this$workshopId.equals(other$workshopId)) {
                                                                        Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                                        Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                                        if (this$sourceWorkshopId == null
                                                                           ? other$sourceWorkshopId == null
                                                                           : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                                           Object this$outboundRelationType = this.getOutboundRelationType();
                                                                           Object other$outboundRelationType = other.getOutboundRelationType();
                                                                           if (this$outboundRelationType == null
                                                                              ? other$outboundRelationType == null
                                                                              : this$outboundRelationType.equals(other$outboundRelationType)) {
                                                                              Object this$wapId = this.getWapId();
                                                                              Object other$wapId = other.getWapId();
                                                                              if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                                                                 Object this$boolBasicClassChange = this.getBoolBasicClassChange();
                                                                                 Object other$boolBasicClassChange = other.getBoolBasicClassChange();
                                                                                 if (this$boolBasicClassChange == null
                                                                                    ? other$boolBasicClassChange == null
                                                                                    : this$boolBasicClassChange.equals(other$boolBasicClassChange)) {
                                                                                    Object this$outboundAddress = this.getOutboundAddress();
                                                                                    Object other$outboundAddress = other.getOutboundAddress();
                                                                                    if (this$outboundAddress == null
                                                                                       ? other$outboundAddress == null
                                                                                       : this$outboundAddress.equals(other$outboundAddress)) {
                                                                                       Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                                                       Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                                                       if (this$outboundTypeSelection == null
                                                                                          ? other$outboundTypeSelection == null
                                                                                          : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                                                                          Object this$outboundDetailId = this.getOutboundDetailId();
                                                                                          Object other$outboundDetailId = other.getOutboundDetailId();
                                                                                          if (this$outboundDetailId == null
                                                                                             ? other$outboundDetailId == null
                                                                                             : this$outboundDetailId.equals(other$outboundDetailId)) {
                                                                                             Object this$halfSize = this.getHalfSize();
                                                                                             Object other$halfSize = other.getHalfSize();
                                                                                             if (this$halfSize == null
                                                                                                ? other$halfSize == null
                                                                                                : this$halfSize.equals(other$halfSize)) {
                                                                                                Object this$specification = this.getSpecification();
                                                                                                Object other$specification = other.getSpecification();
                                                                                                if (this$specification == null
                                                                                                   ? other$specification == null
                                                                                                   : this$specification.equals(other$specification)) {
                                                                                                   Object this$quantity = this.getQuantity();
                                                                                                   Object other$quantity = other.getQuantity();
                                                                                                   if (this$quantity == null
                                                                                                      ? other$quantity == null
                                                                                                      : this$quantity.equals(other$quantity)) {
                                                                                                      Object this$mete = this.getMete();
                                                                                                      Object other$mete = other.getMete();
                                                                                                      if (this$mete == null
                                                                                                         ? other$mete == null
                                                                                                         : this$mete.equals(other$mete)) {
                                                                                                         Object this$length = this.getLength();
                                                                                                         Object other$length = other.getLength();
                                                                                                         if (this$length == null
                                                                                                            ? other$length == null
                                                                                                            : this$length.equals(other$length)) {
                                                                                                            Object this$width = this.getWidth();
                                                                                                            Object other$width = other.getWidth();
                                                                                                            if (this$width == null
                                                                                                               ? other$width == null
                                                                                                               : this$width.equals(other$width)) {
                                                                                                               Object this$thickness = this.getThickness();
                                                                                                               Object other$thickness = other.getThickness();
                                                                                                               if (this$thickness == null
                                                                                                                  ? other$thickness == null
                                                                                                                  : this$thickness.equals(other$thickness)) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$unitNet = this.getUnitNet();
                                                                                                                     Object other$unitNet = other.getUnitNet();
                                                                                                                     if (this$unitNet == null
                                                                                                                        ? other$unitNet == null
                                                                                                                        : this$unitNet.equals(other$unitNet)) {
                                                                                                                        Object this$unitPrice = this.getUnitPrice();
                                                                                                                        Object other$unitPrice = other.getUnitPrice();
                                                                                                                        if (this$unitPrice == null
                                                                                                                           ? other$unitPrice == null
                                                                                                                           : this$unitPrice.equals(
                                                                                                                              other$unitPrice
                                                                                                                           )) {
                                                                                                                           Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                                           Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                                           if (this$unitPriceExcludingVat
                                                                                                                                 == null
                                                                                                                              ? other$unitPriceExcludingVat
                                                                                                                                 == null
                                                                                                                              : this$unitPriceExcludingVat.equals(
                                                                                                                                 other$unitPriceExcludingVat
                                                                                                                              )) {
                                                                                                                              Object this$outboundTime = this.getOutboundTime();
                                                                                                                              Object other$outboundTime = other.getOutboundTime();
                                                                                                                              if (this$outboundTime == null
                                                                                                                                 ? other$outboundTime == null
                                                                                                                                 : this$outboundTime.equals(
                                                                                                                                    other$outboundTime
                                                                                                                                 )) {
                                                                                                                                 Object this$brand = this.getBrand();
                                                                                                                                 Object other$brand = other.getBrand();
                                                                                                                                 if (this$brand == null
                                                                                                                                    ? other$brand == null
                                                                                                                                    : this$brand.equals(
                                                                                                                                       other$brand
                                                                                                                                    )) {
                                                                                                                                    Object this$color = this.getColor();
                                                                                                                                    Object other$color = other.getColor();
                                                                                                                                    if (this$color == null
                                                                                                                                       ? other$color == null
                                                                                                                                       : this$color.equals(
                                                                                                                                          other$color
                                                                                                                                       )) {
                                                                                                                                       Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                                       Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                                       if (this$heatNoAndBatchNo
                                                                                                                                             == null
                                                                                                                                          ? other$heatNoAndBatchNo
                                                                                                                                             == null
                                                                                                                                          : this$heatNoAndBatchNo.equals(
                                                                                                                                             other$heatNoAndBatchNo
                                                                                                                                          )) {
                                                                                                                                          Object this$amount = this.getAmount();
                                                                                                                                          Object other$amount = other.getAmount();
                                                                                                                                          if (this$amount
                                                                                                                                                == null
                                                                                                                                             ? other$amount
                                                                                                                                                == null
                                                                                                                                             : this$amount.equals(
                                                                                                                                                other$amount
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
                                                                                                                                                Object this$inputVat = this.getInputVat();
                                                                                                                                                Object other$inputVat = other.getInputVat();
                                                                                                                                                if (this$inputVat
                                                                                                                                                      == null
                                                                                                                                                   ? other$inputVat
                                                                                                                                                      == null
                                                                                                                                                   : this$inputVat.equals(
                                                                                                                                                      other$inputVat
                                                                                                                                                   )) {
                                                                                                                                                   Object this$taxRate = this.getTaxRate();
                                                                                                                                                   Object other$taxRate = other.getTaxRate();
                                                                                                                                                   if (this$taxRate
                                                                                                                                                         == null
                                                                                                                                                      ? other$taxRate
                                                                                                                                                         == null
                                                                                                                                                      : this$taxRate.equals(
                                                                                                                                                         other$taxRate
                                                                                                                                                      )) {
                                                                                                                                                      Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                                                      Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                                                      if (this$theoryThickness
                                                                                                                                                            == null
                                                                                                                                                         ? other$theoryThickness
                                                                                                                                                            == null
                                                                                                                                                         : this$theoryThickness.equals(
                                                                                                                                                            other$theoryThickness
                                                                                                                                                         )) {
                                                                                                                                                         Object this$standardName = this.getStandardName();
                                                                                                                                                         Object other$standardName = other.getStandardName();
                                                                                                                                                         if (this$standardName
                                                                                                                                                               == null
                                                                                                                                                            ? other$standardName
                                                                                                                                                               == null
                                                                                                                                                            : this$standardName.equals(
                                                                                                                                                               other$standardName
                                                                                                                                                            )) {
                                                                                                                                                            Object this$materialSn = this.getMaterialSn();
                                                                                                                                                            Object other$materialSn = other.getMaterialSn();
                                                                                                                                                            if (this$materialSn
                                                                                                                                                                  == null
                                                                                                                                                               ? other$materialSn
                                                                                                                                                                  == null
                                                                                                                                                               : this$materialSn.equals(
                                                                                                                                                                  other$materialSn
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$recipientName = this.getRecipientName();
                                                                                                                                                               Object other$recipientName = other.getRecipientName();
                                                                                                                                                               if (this$recipientName
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$recipientName
                                                                                                                                                                     == null
                                                                                                                                                                  : this$recipientName.equals(
                                                                                                                                                                     other$recipientName
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                                                  Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                                                  if (this$unitPriceNoFreight
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$unitPriceNoFreight
                                                                                                                                                                        == null
                                                                                                                                                                     : this$unitPriceNoFreight.equals(
                                                                                                                                                                        other$unitPriceNoFreight
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                                                                                                                                     Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                                                                                                                                     if (this$unitPriceExcludingVatNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$unitPriceExcludingVatNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        : this$unitPriceExcludingVatNoFreight.equals(
                                                                                                                                                                           other$unitPriceExcludingVatNoFreight
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                                                        Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                                                        if (this$amountNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$amountNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           : this$amountNoFreight.equals(
                                                                                                                                                                              other$amountNoFreight
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                                                                                           Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                                                                                           if (this$amountExcludingVatNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$amountExcludingVatNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$amountExcludingVatNoFreight.equals(
                                                                                                                                                                                 other$amountExcludingVatNoFreight
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$inputVatNoFreight = this.getInputVatNoFreight();
                                                                                                                                                                              Object other$inputVatNoFreight = other.getInputVatNoFreight();
                                                                                                                                                                              if (this$inputVatNoFreight
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$inputVatNoFreight
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$inputVatNoFreight.equals(
                                                                                                                                                                                    other$inputVatNoFreight
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$remainingAmount = this.getRemainingAmount();
                                                                                                                                                                                 Object other$remainingAmount = other.getRemainingAmount();
                                                                                                                                                                                 if (this$remainingAmount
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$remainingAmount
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$remainingAmount.equals(
                                                                                                                                                                                       other$remainingAmount
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$remainingAmountExcludingVat = this.getRemainingAmountExcludingVat();
                                                                                                                                                                                    Object other$remainingAmountExcludingVat = other.getRemainingAmountExcludingVat();
                                                                                                                                                                                    if (this$remainingAmountExcludingVat
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$remainingAmountExcludingVat
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$remainingAmountExcludingVat.equals(
                                                                                                                                                                                          other$remainingAmountExcludingVat
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$remainingAmountNoFreight = this.getRemainingAmountNoFreight();
                                                                                                                                                                                       Object other$remainingAmountNoFreight = other.getRemainingAmountNoFreight();
                                                                                                                                                                                       if (this$remainingAmountNoFreight
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$remainingAmountNoFreight
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$remainingAmountNoFreight.equals(
                                                                                                                                                                                             other$remainingAmountNoFreight
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$remainingAmountExcludingVatNoFreight = this.getRemainingAmountExcludingVatNoFreight();
                                                                                                                                                                                          Object other$remainingAmountExcludingVatNoFreight = other.getRemainingAmountExcludingVatNoFreight();
                                                                                                                                                                                          if (this$remainingAmountExcludingVatNoFreight
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$remainingAmountExcludingVatNoFreight
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$remainingAmountExcludingVatNoFreight.equals(
                                                                                                                                                                                                other$remainingAmountExcludingVatNoFreight
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$remainingQuantity = this.getRemainingQuantity();
                                                                                                                                                                                             Object other$remainingQuantity = other.getRemainingQuantity();
                                                                                                                                                                                             if (this$remainingQuantity
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$remainingQuantity
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$remainingQuantity.equals(
                                                                                                                                                                                                   other$remainingQuantity
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$remainingMete = this.getRemainingMete();
                                                                                                                                                                                                Object other$remainingMete = other.getRemainingMete();
                                                                                                                                                                                                return this$remainingMete
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$remainingMete
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$remainingMete.equals(
                                                                                                                                                                                                      other$remainingMete
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
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsBorrowDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundMode = this.getOutboundMode();
      result = result * 59 + ($outboundMode == null ? 43 : $outboundMode.hashCode());
      Object $halfMode = this.getHalfMode();
      result = result * 59 + ($halfMode == null ? 43 : $halfMode.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $outboundType = this.getOutboundType();
      result = result * 59 + ($outboundType == null ? 43 : $outboundType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $sourceMonomerId = this.getSourceMonomerId();
      result = result * 59 + ($sourceMonomerId == null ? 43 : $sourceMonomerId.hashCode());
      Object $sourceAreaId = this.getSourceAreaId();
      result = result * 59 + ($sourceAreaId == null ? 43 : $sourceAreaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $outboundRelationType = this.getOutboundRelationType();
      result = result * 59 + ($outboundRelationType == null ? 43 : $outboundRelationType.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $boolBasicClassChange = this.getBoolBasicClassChange();
      result = result * 59 + ($boolBasicClassChange == null ? 43 : $boolBasicClassChange.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $halfSize = this.getHalfSize();
      result = result * 59 + ($halfSize == null ? 43 : $halfSize.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $remainingAmount = this.getRemainingAmount();
      result = result * 59 + ($remainingAmount == null ? 43 : $remainingAmount.hashCode());
      Object $remainingAmountExcludingVat = this.getRemainingAmountExcludingVat();
      result = result * 59 + ($remainingAmountExcludingVat == null ? 43 : $remainingAmountExcludingVat.hashCode());
      Object $remainingAmountNoFreight = this.getRemainingAmountNoFreight();
      result = result * 59 + ($remainingAmountNoFreight == null ? 43 : $remainingAmountNoFreight.hashCode());
      Object $remainingAmountExcludingVatNoFreight = this.getRemainingAmountExcludingVatNoFreight();
      result = result * 59 + ($remainingAmountExcludingVatNoFreight == null ? 43 : $remainingAmountExcludingVatNoFreight.hashCode());
      Object $remainingQuantity = this.getRemainingQuantity();
      result = result * 59 + ($remainingQuantity == null ? 43 : $remainingQuantity.hashCode());
      Object $remainingMete = this.getRemainingMete();
      return result * 59 + ($remainingMete == null ? 43 : $remainingMete.hashCode());
   }
}
