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

@ApiModel(value = "MoveOutboundDetail对象", description = "出库详情表 ")
@Entity
@TableName("wms_move_outbound_detail")
@Table(name = "wms_move_outbound_detail")
public class MoveOutboundDetail extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "width", value = "出库宽度", notes = "出库宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '出库宽度'", nullable = true)
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
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID -> wms", notes = "仓库位置ID -> wms")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID -> wms'", nullable = true)
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
   @ApiModelProperty(name = "areaBatchId", value = "批次ID", notes = "批次ID")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint  COMMENT '批次ID'", nullable = true)
   private Long areaBatchId;
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
   @ApiModelProperty(name = "workshopId", value = "领用车间的ID -> mes", notes = "领用车间的ID -> mes")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '领用车间的ID -> mes'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原仓库ID -> wms", notes = "原仓库ID -> wms")
   @JsonProperty("sourceWorkshopId")
   @JSONField(name = "sourceWorkshopId")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '原仓库ID -> wms'", nullable = true)
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
   @ApiModelProperty(name = "purchaseId", value = "制成品采购单Id(外协原料出库用)", notes = "制成品采购单Id(外协原料出库用)")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '制成品采购单Id(外协原料出库用)'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "applicationTime", value = "申请时间", notes = "申请时间")
   @JsonProperty("applicationTime")
   @JSONField(name = "applicationTime")
   @TableField("application_time")
   @Column(name = "application_time", columnDefinition = "datetime  COMMENT '申请时间'", nullable = true)
   private LocalDateTime applicationTime;
   @ApiModelProperty(name = "boolScheduling", value = "是否排产出库")
   @JsonProperty("boolScheduling")
   @JSONField(name = "boolScheduling")
   @TableField("bool_scheduling")
   @Column(name = "bool_scheduling", columnDefinition = "tinyint(1) default '0' COMMENT '是否排产出库'", nullable = true)
   private Boolean boolScheduling;
   @ApiModelProperty(name = "taskOrderId", value = "工单id(排产出库使用)")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) COMMENT '工单id(排产出库使用)'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "schedulingId", value = "排产id(排产出库使用)")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20) COMMENT '排产id(排产出库使用)'", nullable = true)
   private Long schedulingId;
   @ApiModelProperty(name = "receiveDetailId", value = "物联领用明细id(物联领用明细id)")
   @JsonProperty("receiveDetailId")
   @JSONField(name = "receiveDetailId")
   @TableField("receive_detail_id")
   @Column(name = "receive_detail_id", columnDefinition = "bigint(20) COMMENT '物联领用明细id(物联领用明细id)'", nullable = true)
   private Long receiveDetailId;
   @ApiModelProperty(name = "receiveId", value = "物联设备配件领料单id(物联设备配件领料)")
   @JsonProperty("receiveId")
   @JSONField(name = "receiveId")
   @TableField("receive_id")
   @Column(name = "receive_id", columnDefinition = "bigint(20) COMMENT '物联设备配件领料单id(物联设备配件领料)'", nullable = true)
   private Long receiveId;
   @ApiModelProperty(name = "stockGuid", value = "柏楚排样图guid(后期做数据查询,修复的时候使用)", notes = "柏楚排样图guid")
   @JsonProperty("stockGuid")
   @JSONField(name = "stockGuid")
   @TableField("stock_guid")
   @Column(name = "stock_guid", columnDefinition = "varchar(255)  COMMENT '柏楚板材guid'", nullable = true)
   private String stockGuid;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
   @ApiModelProperty(name = "pickingDetailId", value = "领料明细ID")
   @JsonProperty("pickingDetailId")
   @JSONField(name = "pickingDetailId")
   @TableField("picking_detail_id")
   @Column(name = "picking_detail_id", columnDefinition = "bigint(20) COMMENT '领料明细ID'", nullable = true)
   private Long pickingDetailId;
   @ApiModelProperty(name = "shipmentDetailId", value = "配套件明细ID")
   @JsonProperty("shipmentDetailId")
   @JSONField(name = "shipmentDetailId")
   @TableField("shipment_detail_id")
   @Column(name = "shipment_detail_id", columnDefinition = "bigint(20) COMMENT '配套件明细ID'", nullable = true)
   private Long shipmentDetailId;
   @ApiModelProperty(name = "handlingArea", value = "办理面积(钢板领料出库使用)")
   @JsonProperty("handlingArea")
   @JSONField(name = "handlingArea")
   @TableField("handling_area")
   @Column(name = "handling_area", columnDefinition = "decimal(32,12) COMMENT '办理面积(钢板领料出库使用)'", nullable = true)
   private BigDecimal handlingArea;
   @ApiModelProperty(name = "WmsPlantConvertNumber", value = "钢板转换单编号", notes = "钢板转换单编号(方便查询)")
   @JsonProperty("WmsPlantConvertNumber")
   @JSONField(name = "WmsPlantConvertNumber")
   @TableField("wms_plant_convert_number")
   @Column(name = "wms_plant_convert_number", columnDefinition = "varchar(255)  COMMENT '钢板转换单编号(方便查询)'", nullable = true)
   private String WmsPlantConvertNumber;
   @ApiModelProperty(name = "actualTheoryWeight", value = "实时理论重量(出库时最新密度计算的理论总重)")
   @JsonProperty("actualTheoryWeight")
   @JSONField(name = "actualTheoryWeight")
   @TableField("actual_theory_weight")
   @Column(name = "actual_theory_weight", columnDefinition = "decimal(32,12) COMMENT '实时理论重量(出库时最新密度计算的理论总重)'", nullable = true)
   private BigDecimal actualTheoryWeight;
   @ApiModelProperty(name = "isNeedRemind", value = "是否需提醒", notes = "是否需提醒")
   @JsonProperty("isNeedRemind")
   @JSONField(name = "isNeedRemind")
   @TableField("is_need_remind")
   @Column(name = "is_need_remind", columnDefinition = "tinyint(1) default '0'  COMMENT '是否需提醒'", nullable = true)
   private Boolean isNeedRemind;

   public static MoveOutboundDetail.MoveOutboundDetailBuilder builder() {
      return new MoveOutboundDetail.MoveOutboundDetailBuilder();
   }

   public MoveOutboundDetail() {
   }

   public MoveOutboundDetail(
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
      final Long areaBatchId,
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
      final Long purchaseId,
      final LocalDateTime applicationTime,
      final Boolean boolScheduling,
      final Long taskOrderId,
      final Long schedulingId,
      final Long receiveDetailId,
      final Long receiveId,
      final String stockGuid,
      final String surplusSn,
      final Long pickingDetailId,
      final Long shipmentDetailId,
      final BigDecimal handlingArea,
      final String WmsPlantConvertNumber,
      final BigDecimal actualTheoryWeight,
      final Boolean isNeedRemind
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
      this.areaBatchId = areaBatchId;
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
      this.purchaseId = purchaseId;
      this.applicationTime = applicationTime;
      this.boolScheduling = boolScheduling;
      this.taskOrderId = taskOrderId;
      this.schedulingId = schedulingId;
      this.receiveDetailId = receiveDetailId;
      this.receiveId = receiveId;
      this.stockGuid = stockGuid;
      this.surplusSn = surplusSn;
      this.pickingDetailId = pickingDetailId;
      this.shipmentDetailId = shipmentDetailId;
      this.handlingArea = handlingArea;
      this.WmsPlantConvertNumber = WmsPlantConvertNumber;
      this.actualTheoryWeight = actualTheoryWeight;
      this.isNeedRemind = isNeedRemind;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getReceiveDetailId() {
      return this.receiveDetailId;
   }

   public Long getReceiveId() {
      return this.receiveId;
   }

   public String getStockGuid() {
      return this.stockGuid;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Long getShipmentDetailId() {
      return this.shipmentDetailId;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public String getWmsPlantConvertNumber() {
      return this.WmsPlantConvertNumber;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public Boolean getIsNeedRemind() {
      return this.isNeedRemind;
   }

   @JsonProperty("id")
   public MoveOutboundDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("outboundId")
   public MoveOutboundDetail setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("projectId")
   public MoveOutboundDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("sourceProjectId")
   public MoveOutboundDetail setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public MoveOutboundDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("outboundMode")
   public MoveOutboundDetail setOutboundMode(final Integer outboundMode) {
      this.outboundMode = outboundMode;
      return this;
   }

   @JsonProperty("halfMode")
   public MoveOutboundDetail setHalfMode(final Integer halfMode) {
      this.halfMode = halfMode;
      return this;
   }

   @JsonProperty("halfSize")
   public MoveOutboundDetail setHalfSize(final BigDecimal halfSize) {
      this.halfSize = halfSize;
      return this;
   }

   @JsonProperty("basicClass")
   public MoveOutboundDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MoveOutboundDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("specification")
   public MoveOutboundDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public MoveOutboundDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public MoveOutboundDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("length")
   public MoveOutboundDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public MoveOutboundDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public MoveOutboundDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("remark")
   public MoveOutboundDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("unitNet")
   public MoveOutboundDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("unitPrice")
   public MoveOutboundDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public MoveOutboundDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inboundId")
   public MoveOutboundDetail setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("recipientId")
   public MoveOutboundDetail setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("warehouseId")
   public MoveOutboundDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("outboundTime")
   public MoveOutboundDetail setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("brand")
   public MoveOutboundDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public MoveOutboundDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MoveOutboundDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MoveOutboundDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("amount")
   public MoveOutboundDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public MoveOutboundDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public MoveOutboundDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("invoiceType")
   public MoveOutboundDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public MoveOutboundDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("outboundType")
   public MoveOutboundDetail setOutboundType(final Integer outboundType) {
      this.outboundType = outboundType;
      return this;
   }

   @JsonProperty("taxRate")
   public MoveOutboundDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("theoryThickness")
   public MoveOutboundDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("standardId")
   public MoveOutboundDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MoveOutboundDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("materialSn")
   public MoveOutboundDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("monomerId")
   public MoveOutboundDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MoveOutboundDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MoveOutboundDetail setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("sourceMonomerId")
   public MoveOutboundDetail setSourceMonomerId(final Long sourceMonomerId) {
      this.sourceMonomerId = sourceMonomerId;
      return this;
   }

   @JsonProperty("sourceAreaId")
   public MoveOutboundDetail setSourceAreaId(final Long sourceAreaId) {
      this.sourceAreaId = sourceAreaId;
      return this;
   }

   @JsonProperty("workshopId")
   public MoveOutboundDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("sourceWorkshopId")
   public MoveOutboundDetail setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   @JsonProperty("outboundRelationType")
   public MoveOutboundDetail setOutboundRelationType(final Integer outboundRelationType) {
      this.outboundRelationType = outboundRelationType;
      return this;
   }

   @JsonProperty("wapId")
   public MoveOutboundDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("boolBasicClassChange")
   public MoveOutboundDetail setBoolBasicClassChange(final Boolean boolBasicClassChange) {
      this.boolBasicClassChange = boolBasicClassChange;
      return this;
   }

   @JsonProperty("outboundAddress")
   public MoveOutboundDetail setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
      return this;
   }

   @JsonProperty("recipientName")
   public MoveOutboundDetail setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public MoveOutboundDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public MoveOutboundDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public MoveOutboundDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public MoveOutboundDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public MoveOutboundDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public MoveOutboundDetail setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("purchaseId")
   public MoveOutboundDetail setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("applicationTime")
   public MoveOutboundDetail setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
      return this;
   }

   @JsonProperty("boolScheduling")
   public MoveOutboundDetail setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MoveOutboundDetail setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MoveOutboundDetail setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("receiveDetailId")
   public MoveOutboundDetail setReceiveDetailId(final Long receiveDetailId) {
      this.receiveDetailId = receiveDetailId;
      return this;
   }

   @JsonProperty("receiveId")
   public MoveOutboundDetail setReceiveId(final Long receiveId) {
      this.receiveId = receiveId;
      return this;
   }

   @JsonProperty("stockGuid")
   public MoveOutboundDetail setStockGuid(final String stockGuid) {
      this.stockGuid = stockGuid;
      return this;
   }

   @JsonProperty("surplusSn")
   public MoveOutboundDetail setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   @JsonProperty("pickingDetailId")
   public MoveOutboundDetail setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
      return this;
   }

   @JsonProperty("shipmentDetailId")
   public MoveOutboundDetail setShipmentDetailId(final Long shipmentDetailId) {
      this.shipmentDetailId = shipmentDetailId;
      return this;
   }

   @JsonProperty("handlingArea")
   public MoveOutboundDetail setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
      return this;
   }

   @JsonProperty("WmsPlantConvertNumber")
   public MoveOutboundDetail setWmsPlantConvertNumber(final String WmsPlantConvertNumber) {
      this.WmsPlantConvertNumber = WmsPlantConvertNumber;
      return this;
   }

   @JsonProperty("actualTheoryWeight")
   public MoveOutboundDetail setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
      return this;
   }

   @JsonProperty("isNeedRemind")
   public MoveOutboundDetail setIsNeedRemind(final Boolean isNeedRemind) {
      this.isNeedRemind = isNeedRemind;
      return this;
   }

   @Override
   public String toString() {
      return "MoveOutboundDetail(id="
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
         + ", areaBatchId="
         + this.getAreaBatchId()
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
         + ", purchaseId="
         + this.getPurchaseId()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", receiveDetailId="
         + this.getReceiveDetailId()
         + ", receiveId="
         + this.getReceiveId()
         + ", stockGuid="
         + this.getStockGuid()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", shipmentDetailId="
         + this.getShipmentDetailId()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", WmsPlantConvertNumber="
         + this.getWmsPlantConvertNumber()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", isNeedRemind="
         + this.getIsNeedRemind()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveOutboundDetail)) {
         return false;
      }

      MoveOutboundDetail other = (MoveOutboundDetail)o;
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
                                                               Object this$areaBatchId = this.getAreaBatchId();
                                                               Object other$areaBatchId = other.getAreaBatchId();
                                                               if (this$areaBatchId == null
                                                                  ? other$areaBatchId == null
                                                                  : this$areaBatchId.equals(other$areaBatchId)) {
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
                                                                                             Object this$purchaseId = this.getPurchaseId();
                                                                                             Object other$purchaseId = other.getPurchaseId();
                                                                                             if (this$purchaseId == null
                                                                                                ? other$purchaseId == null
                                                                                                : this$purchaseId.equals(other$purchaseId)) {
                                                                                                Object this$boolScheduling = this.getBoolScheduling();
                                                                                                Object other$boolScheduling = other.getBoolScheduling();
                                                                                                if (this$boolScheduling == null
                                                                                                   ? other$boolScheduling == null
                                                                                                   : this$boolScheduling.equals(other$boolScheduling)) {
                                                                                                   Object this$taskOrderId = this.getTaskOrderId();
                                                                                                   Object other$taskOrderId = other.getTaskOrderId();
                                                                                                   if (this$taskOrderId == null
                                                                                                      ? other$taskOrderId == null
                                                                                                      : this$taskOrderId.equals(other$taskOrderId)) {
                                                                                                      Object this$schedulingId = this.getSchedulingId();
                                                                                                      Object other$schedulingId = other.getSchedulingId();
                                                                                                      if (this$schedulingId == null
                                                                                                         ? other$schedulingId == null
                                                                                                         : this$schedulingId.equals(other$schedulingId)) {
                                                                                                         Object this$receiveDetailId = this.getReceiveDetailId();
                                                                                                         Object other$receiveDetailId = other.getReceiveDetailId();
                                                                                                         if (this$receiveDetailId == null
                                                                                                            ? other$receiveDetailId == null
                                                                                                            : this$receiveDetailId.equals(other$receiveDetailId)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$receiveId = this.getReceiveId();
                                                                                                            Object other$receiveId = other.getReceiveId();
                                                                                                            if (this$receiveId == null
                                                                                                               ? other$receiveId == null
                                                                                                               : this$receiveId.equals(other$receiveId)) {
                                                                                                               Object this$pickingDetailId = this.getPickingDetailId();
                                                                                                               Object other$pickingDetailId = other.getPickingDetailId();
                                                                                                               if (this$pickingDetailId == null
                                                                                                                  ? other$pickingDetailId == null
                                                                                                                  : this$pickingDetailId.equals(
                                                                                                                     other$pickingDetailId
                                                                                                                  )) {
                                                                                                                  Object this$shipmentDetailId = this.getShipmentDetailId();
                                                                                                                  Object other$shipmentDetailId = other.getShipmentDetailId();
                                                                                                                  if (this$shipmentDetailId == null
                                                                                                                     ? other$shipmentDetailId == null
                                                                                                                     : this$shipmentDetailId.equals(
                                                                                                                        other$shipmentDetailId
                                                                                                                     )) {
                                                                                                                     Object this$isNeedRemind = this.getIsNeedRemind();
                                                                                                                     Object other$isNeedRemind = other.getIsNeedRemind();
                                                                                                                     if (this$isNeedRemind == null
                                                                                                                        ? other$isNeedRemind == null
                                                                                                                        : this$isNeedRemind.equals(
                                                                                                                           other$isNeedRemind
                                                                                                                        )) {
                                                                                                                        Object this$halfSize = this.getHalfSize();
                                                                                                                        Object other$halfSize = other.getHalfSize();
                                                                                                                        if (this$halfSize == null
                                                                                                                           ? other$halfSize == null
                                                                                                                           : this$halfSize.equals(
                                                                                                                              other$halfSize
                                                                                                                           )) {
                                                                                                                           Object this$specification = this.getSpecification();
                                                                                                                           Object other$specification = other.getSpecification();
                                                                                                                           if (this$specification == null
                                                                                                                              ? other$specification == null
                                                                                                                              : this$specification.equals(
                                                                                                                                 other$specification
                                                                                                                              )) {
                                                                                                                              Object this$quantity = this.getQuantity();
                                                                                                                              Object other$quantity = other.getQuantity();
                                                                                                                              if (this$quantity == null
                                                                                                                                 ? other$quantity == null
                                                                                                                                 : this$quantity.equals(
                                                                                                                                    other$quantity
                                                                                                                                 )) {
                                                                                                                                 Object this$mete = this.getMete();
                                                                                                                                 Object other$mete = other.getMete();
                                                                                                                                 if (this$mete == null
                                                                                                                                    ? other$mete == null
                                                                                                                                    : this$mete.equals(
                                                                                                                                       other$mete
                                                                                                                                    )) {
                                                                                                                                    Object this$length = this.getLength();
                                                                                                                                    Object other$length = other.getLength();
                                                                                                                                    if (this$length == null
                                                                                                                                       ? other$length == null
                                                                                                                                       : this$length.equals(
                                                                                                                                          other$length
                                                                                                                                       )) {
                                                                                                                                       Object this$width = this.getWidth();
                                                                                                                                       Object other$width = other.getWidth();
                                                                                                                                       if (this$width == null
                                                                                                                                          ? other$width == null
                                                                                                                                          : this$width.equals(
                                                                                                                                             other$width
                                                                                                                                          )) {
                                                                                                                                          Object this$thickness = this.getThickness();
                                                                                                                                          Object other$thickness = other.getThickness();
                                                                                                                                          if (this$thickness
                                                                                                                                                == null
                                                                                                                                             ? other$thickness
                                                                                                                                                == null
                                                                                                                                             : this$thickness.equals(
                                                                                                                                                other$thickness
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
                                                                                                                                                Object this$unitNet = this.getUnitNet();
                                                                                                                                                Object other$unitNet = other.getUnitNet();
                                                                                                                                                if (this$unitNet
                                                                                                                                                      == null
                                                                                                                                                   ? other$unitNet
                                                                                                                                                      == null
                                                                                                                                                   : this$unitNet.equals(
                                                                                                                                                      other$unitNet
                                                                                                                                                   )) {
                                                                                                                                                   Object this$unitPrice = this.getUnitPrice();
                                                                                                                                                   Object other$unitPrice = other.getUnitPrice();
                                                                                                                                                   if (this$unitPrice
                                                                                                                                                         == null
                                                                                                                                                      ? other$unitPrice
                                                                                                                                                         == null
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
                                                                                                                                                         if (this$outboundTime
                                                                                                                                                               == null
                                                                                                                                                            ? other$outboundTime
                                                                                                                                                               == null
                                                                                                                                                            : this$outboundTime.equals(
                                                                                                                                                               other$outboundTime
                                                                                                                                                            )) {
                                                                                                                                                            Object this$brand = this.getBrand();
                                                                                                                                                            Object other$brand = other.getBrand();
                                                                                                                                                            if (this$brand
                                                                                                                                                                  == null
                                                                                                                                                               ? other$brand
                                                                                                                                                                  == null
                                                                                                                                                               : this$brand.equals(
                                                                                                                                                                  other$brand
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$color = this.getColor();
                                                                                                                                                               Object other$color = other.getColor();
                                                                                                                                                               if (this$color
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$color
                                                                                                                                                                     == null
                                                                                                                                                                  : this$color.equals(
                                                                                                                                                                     other$color
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                                                                  Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                                                                  if (this$heatNoAndBatchNo
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$heatNoAndBatchNo
                                                                                                                                                                        == null
                                                                                                                                                                     : this$heatNoAndBatchNo.equals(
                                                                                                                                                                        other$heatNoAndBatchNo
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$amount = this.getAmount();
                                                                                                                                                                     Object other$amount = other.getAmount();
                                                                                                                                                                     if (this$amount
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$amount
                                                                                                                                                                           == null
                                                                                                                                                                        : this$amount.equals(
                                                                                                                                                                           other$amount
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                                                                        Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                                                                        if (this$amountExcludingVat
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$amountExcludingVat
                                                                                                                                                                              == null
                                                                                                                                                                           : this$amountExcludingVat.equals(
                                                                                                                                                                              other$amountExcludingVat
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$inputVat = this.getInputVat();
                                                                                                                                                                           Object other$inputVat = other.getInputVat();
                                                                                                                                                                           if (this$inputVat
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$inputVat
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$inputVat.equals(
                                                                                                                                                                                 other$inputVat
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$taxRate = this.getTaxRate();
                                                                                                                                                                              Object other$taxRate = other.getTaxRate();
                                                                                                                                                                              if (this$taxRate
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$taxRate
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$taxRate.equals(
                                                                                                                                                                                    other$taxRate
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                                                                                 Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                                                                                 if (this$theoryThickness
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$theoryThickness
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$theoryThickness.equals(
                                                                                                                                                                                       other$theoryThickness
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$standardName = this.getStandardName();
                                                                                                                                                                                    Object other$standardName = other.getStandardName();
                                                                                                                                                                                    if (this$standardName
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$standardName
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$standardName.equals(
                                                                                                                                                                                          other$standardName
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
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
                                                                                                                                                                                                            Object this$applicationTime = this.getApplicationTime();
                                                                                                                                                                                                            Object other$applicationTime = other.getApplicationTime();
                                                                                                                                                                                                            if (this$applicationTime
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$applicationTime
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$applicationTime.equals(
                                                                                                                                                                                                                  other$applicationTime
                                                                                                                                                                                                               )
                                                                                                                                                                                                               )
                                                                                                                                                                                                             {
                                                                                                                                                                                                               Object this$stockGuid = this.getStockGuid();
                                                                                                                                                                                                               Object other$stockGuid = other.getStockGuid();
                                                                                                                                                                                                               if (this$stockGuid
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  ? other$stockGuid
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  : this$stockGuid.equals(
                                                                                                                                                                                                                     other$stockGuid
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                                                                                  Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                                                                                  if (this$surplusSn
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     ? other$surplusSn
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     : this$surplusSn.equals(
                                                                                                                                                                                                                        other$surplusSn
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                   {
                                                                                                                                                                                                                     Object this$handlingArea = this.getHandlingArea();
                                                                                                                                                                                                                     Object other$handlingArea = other.getHandlingArea();
                                                                                                                                                                                                                     if (this$handlingArea
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        ? other$handlingArea
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        : this$handlingArea.equals(
                                                                                                                                                                                                                           other$handlingArea
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        Object this$WmsPlantConvertNumber = this.getWmsPlantConvertNumber();
                                                                                                                                                                                                                        Object other$WmsPlantConvertNumber = other.getWmsPlantConvertNumber();
                                                                                                                                                                                                                        if (this$WmsPlantConvertNumber
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           ? other$WmsPlantConvertNumber
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           : this$WmsPlantConvertNumber.equals(
                                                                                                                                                                                                                              other$WmsPlantConvertNumber
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                         {
                                                                                                                                                                                                                           Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                                                                                                                                                                                           Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                                                                                                                                                                                           return this$actualTheoryWeight
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              ? other$actualTheoryWeight
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              : this$actualTheoryWeight.equals(
                                                                                                                                                                                                                                 other$actualTheoryWeight
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
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MoveOutboundDetail;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
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
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $receiveDetailId = this.getReceiveDetailId();
      result = result * 59 + ($receiveDetailId == null ? 43 : $receiveDetailId.hashCode());
      Object $receiveId = this.getReceiveId();
      result = result * 59 + ($receiveId == null ? 43 : $receiveId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $shipmentDetailId = this.getShipmentDetailId();
      result = result * 59 + ($shipmentDetailId == null ? 43 : $shipmentDetailId.hashCode());
      Object $isNeedRemind = this.getIsNeedRemind();
      result = result * 59 + ($isNeedRemind == null ? 43 : $isNeedRemind.hashCode());
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
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $stockGuid = this.getStockGuid();
      result = result * 59 + ($stockGuid == null ? 43 : $stockGuid.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $WmsPlantConvertNumber = this.getWmsPlantConvertNumber();
      result = result * 59 + ($WmsPlantConvertNumber == null ? 43 : $WmsPlantConvertNumber.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   public static class MoveOutboundDetailBuilder {
      private Long id;
      private Long outboundId;
      private Long projectId;
      private Long sourceProjectId;
      private Long materialInventoryId;
      private Integer outboundMode;
      private Integer halfMode;
      private BigDecimal halfSize;
      private Integer basicClass;
      private Long classifyId;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String remark;
      private BigDecimal unitNet;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private Long inboundId;
      private Long recipientId;
      private Long warehouseId;
      private LocalDateTime outboundTime;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private Boolean boolPartyA;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Integer invoiceType;
      private Integer materialIsWhole;
      private Integer outboundType;
      private BigDecimal taxRate;
      private BigDecimal theoryThickness;
      private Long standardId;
      private String standardName;
      private String materialSn;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long sourceMonomerId;
      private Long sourceAreaId;
      private Long workshopId;
      private Long sourceWorkshopId;
      private Integer outboundRelationType;
      private Long wapId;
      private Boolean boolBasicClassChange;
      private Integer outboundAddress;
      private String recipientName;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private Integer outboundTypeSelection;
      private Long purchaseId;
      private LocalDateTime applicationTime;
      private Boolean boolScheduling;
      private Long taskOrderId;
      private Long schedulingId;
      private Long receiveDetailId;
      private Long receiveId;
      private String stockGuid;
      private String surplusSn;
      private Long pickingDetailId;
      private Long shipmentDetailId;
      private BigDecimal handlingArea;
      private String WmsPlantConvertNumber;
      private BigDecimal actualTheoryWeight;
      private Boolean isNeedRemind;

      MoveOutboundDetailBuilder() {
      }

      @JsonProperty("id")
      public MoveOutboundDetail.MoveOutboundDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("outboundId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("projectId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("sourceProjectId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("outboundMode")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundMode(final Integer outboundMode) {
         this.outboundMode = outboundMode;
         return this;
      }

      @JsonProperty("halfMode")
      public MoveOutboundDetail.MoveOutboundDetailBuilder halfMode(final Integer halfMode) {
         this.halfMode = halfMode;
         return this;
      }

      @JsonProperty("halfSize")
      public MoveOutboundDetail.MoveOutboundDetailBuilder halfSize(final BigDecimal halfSize) {
         this.halfSize = halfSize;
         return this;
      }

      @JsonProperty("basicClass")
      public MoveOutboundDetail.MoveOutboundDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("specification")
      public MoveOutboundDetail.MoveOutboundDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public MoveOutboundDetail.MoveOutboundDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public MoveOutboundDetail.MoveOutboundDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("length")
      public MoveOutboundDetail.MoveOutboundDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public MoveOutboundDetail.MoveOutboundDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public MoveOutboundDetail.MoveOutboundDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("remark")
      public MoveOutboundDetail.MoveOutboundDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("unitNet")
      public MoveOutboundDetail.MoveOutboundDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("unitPrice")
      public MoveOutboundDetail.MoveOutboundDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public MoveOutboundDetail.MoveOutboundDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inboundId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("recipientId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("warehouseId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("outboundTime")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("brand")
      public MoveOutboundDetail.MoveOutboundDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public MoveOutboundDetail.MoveOutboundDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MoveOutboundDetail.MoveOutboundDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MoveOutboundDetail.MoveOutboundDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("amount")
      public MoveOutboundDetail.MoveOutboundDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public MoveOutboundDetail.MoveOutboundDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public MoveOutboundDetail.MoveOutboundDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("invoiceType")
      public MoveOutboundDetail.MoveOutboundDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public MoveOutboundDetail.MoveOutboundDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("outboundType")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundType(final Integer outboundType) {
         this.outboundType = outboundType;
         return this;
      }

      @JsonProperty("taxRate")
      public MoveOutboundDetail.MoveOutboundDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("theoryThickness")
      public MoveOutboundDetail.MoveOutboundDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("standardId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MoveOutboundDetail.MoveOutboundDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("materialSn")
      public MoveOutboundDetail.MoveOutboundDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("monomerId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("sourceMonomerId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder sourceMonomerId(final Long sourceMonomerId) {
         this.sourceMonomerId = sourceMonomerId;
         return this;
      }

      @JsonProperty("sourceAreaId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder sourceAreaId(final Long sourceAreaId) {
         this.sourceAreaId = sourceAreaId;
         return this;
      }

      @JsonProperty("workshopId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("sourceWorkshopId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      @JsonProperty("outboundRelationType")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      @JsonProperty("wapId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("boolBasicClassChange")
      public MoveOutboundDetail.MoveOutboundDetailBuilder boolBasicClassChange(final Boolean boolBasicClassChange) {
         this.boolBasicClassChange = boolBasicClassChange;
         return this;
      }

      @JsonProperty("outboundAddress")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      @JsonProperty("recipientName")
      public MoveOutboundDetail.MoveOutboundDetailBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("outboundTypeSelection")
      public MoveOutboundDetail.MoveOutboundDetailBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      @JsonProperty("purchaseId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("applicationTime")
      public MoveOutboundDetail.MoveOutboundDetailBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      @JsonProperty("boolScheduling")
      public MoveOutboundDetail.MoveOutboundDetailBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("receiveDetailId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder receiveDetailId(final Long receiveDetailId) {
         this.receiveDetailId = receiveDetailId;
         return this;
      }

      @JsonProperty("receiveId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder receiveId(final Long receiveId) {
         this.receiveId = receiveId;
         return this;
      }

      @JsonProperty("stockGuid")
      public MoveOutboundDetail.MoveOutboundDetailBuilder stockGuid(final String stockGuid) {
         this.stockGuid = stockGuid;
         return this;
      }

      @JsonProperty("surplusSn")
      public MoveOutboundDetail.MoveOutboundDetailBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("pickingDetailId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      @JsonProperty("shipmentDetailId")
      public MoveOutboundDetail.MoveOutboundDetailBuilder shipmentDetailId(final Long shipmentDetailId) {
         this.shipmentDetailId = shipmentDetailId;
         return this;
      }

      @JsonProperty("handlingArea")
      public MoveOutboundDetail.MoveOutboundDetailBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      @JsonProperty("WmsPlantConvertNumber")
      public MoveOutboundDetail.MoveOutboundDetailBuilder WmsPlantConvertNumber(final String WmsPlantConvertNumber) {
         this.WmsPlantConvertNumber = WmsPlantConvertNumber;
         return this;
      }

      @JsonProperty("actualTheoryWeight")
      public MoveOutboundDetail.MoveOutboundDetailBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      @JsonProperty("isNeedRemind")
      public MoveOutboundDetail.MoveOutboundDetailBuilder isNeedRemind(final Boolean isNeedRemind) {
         this.isNeedRemind = isNeedRemind;
         return this;
      }

      public MoveOutboundDetail build() {
         return new MoveOutboundDetail(
            this.id,
            this.outboundId,
            this.projectId,
            this.sourceProjectId,
            this.materialInventoryId,
            this.outboundMode,
            this.halfMode,
            this.halfSize,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.quantity,
            this.mete,
            this.length,
            this.width,
            this.thickness,
            this.remark,
            this.unitNet,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.inboundId,
            this.recipientId,
            this.warehouseId,
            this.outboundTime,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.boolPartyA,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.invoiceType,
            this.materialIsWhole,
            this.outboundType,
            this.taxRate,
            this.theoryThickness,
            this.standardId,
            this.standardName,
            this.materialSn,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.sourceMonomerId,
            this.sourceAreaId,
            this.workshopId,
            this.sourceWorkshopId,
            this.outboundRelationType,
            this.wapId,
            this.boolBasicClassChange,
            this.outboundAddress,
            this.recipientName,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.outboundTypeSelection,
            this.purchaseId,
            this.applicationTime,
            this.boolScheduling,
            this.taskOrderId,
            this.schedulingId,
            this.receiveDetailId,
            this.receiveId,
            this.stockGuid,
            this.surplusSn,
            this.pickingDetailId,
            this.shipmentDetailId,
            this.handlingArea,
            this.WmsPlantConvertNumber,
            this.actualTheoryWeight,
            this.isNeedRemind
         );
      }

      @Override
      public String toString() {
         return "MoveOutboundDetail.MoveOutboundDetailBuilder(id="
            + this.id
            + ", outboundId="
            + this.outboundId
            + ", projectId="
            + this.projectId
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", outboundMode="
            + this.outboundMode
            + ", halfMode="
            + this.halfMode
            + ", halfSize="
            + this.halfSize
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", remark="
            + this.remark
            + ", unitNet="
            + this.unitNet
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inboundId="
            + this.inboundId
            + ", recipientId="
            + this.recipientId
            + ", warehouseId="
            + this.warehouseId
            + ", outboundTime="
            + this.outboundTime
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", boolPartyA="
            + this.boolPartyA
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", invoiceType="
            + this.invoiceType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", outboundType="
            + this.outboundType
            + ", taxRate="
            + this.taxRate
            + ", theoryThickness="
            + this.theoryThickness
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", materialSn="
            + this.materialSn
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", sourceMonomerId="
            + this.sourceMonomerId
            + ", sourceAreaId="
            + this.sourceAreaId
            + ", workshopId="
            + this.workshopId
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", outboundRelationType="
            + this.outboundRelationType
            + ", wapId="
            + this.wapId
            + ", boolBasicClassChange="
            + this.boolBasicClassChange
            + ", outboundAddress="
            + this.outboundAddress
            + ", recipientName="
            + this.recipientName
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", purchaseId="
            + this.purchaseId
            + ", applicationTime="
            + this.applicationTime
            + ", boolScheduling="
            + this.boolScheduling
            + ", taskOrderId="
            + this.taskOrderId
            + ", schedulingId="
            + this.schedulingId
            + ", receiveDetailId="
            + this.receiveDetailId
            + ", receiveId="
            + this.receiveId
            + ", stockGuid="
            + this.stockGuid
            + ", surplusSn="
            + this.surplusSn
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", shipmentDetailId="
            + this.shipmentDetailId
            + ", handlingArea="
            + this.handlingArea
            + ", WmsPlantConvertNumber="
            + this.WmsPlantConvertNumber
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", isNeedRemind="
            + this.isNeedRemind
            + ")";
      }
   }
}
