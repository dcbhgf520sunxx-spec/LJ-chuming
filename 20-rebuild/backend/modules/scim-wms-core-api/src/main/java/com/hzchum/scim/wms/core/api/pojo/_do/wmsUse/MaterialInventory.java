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

@ApiModel(value = "MaterialInventory对象", description = "物料库存")
@Entity
@TableName("wms_material_inventory")
@Table(name = "wms_material_inventory")
public class MaterialInventory extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "useStatus", value = "使用状态[0 没有使用完,1 已使用完],操作表中记录物料池ID,方便溯源不对数据进行删除", notes = "使用状态[0 没有使用完,1 已使用完],操作表中记录物料池ID,方便溯源不对数据进行删除")
   @JsonProperty("useStatus")
   @JSONField(name = "useStatus")
   @TableField("use_status")
   @Column(name = "use_status", columnDefinition = "tinyint(1) default '0' COMMENT '使用状态[0 没有使用完,1 已使用完],操作表中记录物料池ID,方便溯源不对数据进行删除'", nullable = true)
   private Boolean useStatus;
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
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "model", value = "型号")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)", notes = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态(1 整料, 余料)'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]", notes = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型[1 公共库,2 项目库]'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长度'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽度'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(128)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT '核算精度'", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "核算量(在计量单位未设置时,数量=核算量)", notes = "核算量(在计量单位未设置时,数量=核算量)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量(在计量单位未设置时,数量=核算量)'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,12)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID -> wms", notes = "仓库位置ID -> wms")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID -> wms'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]", notes = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式 [1理计 , 2 磅计 ,混合计]'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号,针对物料半出后产生余料的溯源", notes = "出库单编号,针对物料半出后产生余料的溯源")
   @JsonProperty("outboundSn")
   @JSONField(name = "outboundSn")
   @TableField("outbound_SN")
   @Column(name = "outbound_SN", columnDefinition = "varchar(255)  COMMENT '出库单编号,针对物料半出后产生余料的溯源'", nullable = true)
   private String outboundSn;
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)", notes = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @JsonProperty("weightedAverageSpec")
   @JSONField(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec", columnDefinition = "varchar(128)  COMMENT '加权平均规格(将规格拆分获取不参与加权规格以*号拼接)'", nullable = true)
   private String weightedAverageSpec;
   @ApiModelProperty(name = "inventoryStartTime", value = "存储开始时间", notes = "存储开始时间")
   @JsonProperty("inventoryStartTime")
   @JSONField(name = "inventoryStartTime")
   @TableField("inventory_start_time")
   @Column(name = "inventory_start_time")
   private LocalDateTime inventoryStartTime;
   @ApiModelProperty(name = "inventoryEndTime", value = "存储结束时间", notes = "存储结束时间")
   @JsonProperty("inventoryEndTime")
   @JSONField(name = "inventoryEndTime")
   @TableField("inventory_end_time")
   @Column(name = "inventory_end_time")
   private LocalDateTime inventoryEndTime;
   @ApiModelProperty(name = "invoiceType", value = "票据类型", notes = "票据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '票据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "boolHasFrozen", value = "物料是否存在冻结", notes = "物料是否存在冻结")
   @JsonProperty("boolHasFrozen")
   @JSONField(name = "boolHasFrozen")
   @TableField("bool_has_frozen")
   @Column(name = "bool_has_frozen", columnDefinition = "tinyint(1) default '0' COMMENT '物料是否存在冻结'", nullable = true)
   private Boolean boolHasFrozen;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行的国标名称", notes = "型材执行的国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行的国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "sourceMaterielId", value = "用于确定余料来源", notes = "用于确定余料来源")
   @JsonProperty("sourceMaterielId")
   @JSONField(name = "sourceMaterielId")
   @TableField("source_materiel_id")
   @Column(name = "source_materiel_id", columnDefinition = "bigint  COMMENT '用于确定余料来源'", nullable = true)
   private Long sourceMaterielId;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件钢材理论重量", notes = "单件钢材理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(19,2)  COMMENT '单件钢材理论重量'", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材国标重量", notes = "型材国标重量")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(19,2)  COMMENT '型材国标重量'", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "serialNumber")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String serialNumber;
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
   @ApiModelProperty(name = "surplusGraphicsPath")
   @JsonProperty("surplusGraphicsPath")
   @JSONField(name = "surplusGraphicsPath")
   @TableField("surplus_graphics_path")
   @Column(name = "surplus_graphics_path", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusGraphicsPath;
   @ApiModelProperty(name = "barcode")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String barcode;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
   @ApiModelProperty(name = "boolVirtual", value = "是否虚拟", notes = "是否虚拟")
   @JsonProperty("boolVirtual")
   @JSONField(name = "boolVirtual")
   @TableField("bool_virtual")
   @Column(name = "bool_virtual", columnDefinition = "tinyint(1) default '0' COMMENT '是否虚拟'", nullable = true)
   private Boolean boolVirtual;
   @ApiModelProperty(name = "plateId", value = "云排中板材id 来自与柏楚云排系统中")
   @JsonProperty("plateId")
   @JSONField(name = "plateId")
   @TableField("plate_id")
   @Column(name = "plate_id")
   private Long plateId;
   @ApiModelProperty(name = "guid", value = "柏楚板材guid", notes = "柏楚板材guid")
   @JsonProperty("guid")
   @JSONField(name = "guid")
   @TableField("guid")
   @Column(name = "guid", columnDefinition = "varchar(255)  COMMENT '柏楚板材guid'", nullable = true)
   private String guid;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID,跨组织出库使用(重工)'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "inboundId", value = "入库单ID", notes = "入库单ID")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id", columnDefinition = "bigint  COMMENT '入库单ID,跨组织出库使用(装配式)'", nullable = true)
   private Long inboundId;
   @ApiModelProperty(name = "sourceMaterialInventoryId", value = "来源库存id", notes = "来源库存id")
   @JsonProperty("sourceMaterialInventoryId")
   @JSONField(name = "sourceMaterialInventoryId")
   @TableField("source_material_inventory_id")
   @Column(name = "source_material_inventory_id", columnDefinition = "bigint  COMMENT '来源库存id,跨组织出库使用(来自重工)'", nullable = true)
   private Long sourceMaterialInventoryId;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   @JsonProperty("boolNestSurplus")
   @JSONField(name = "boolNestSurplus")
   @TableField("bool_nest_surplus")
   @Column(name = "bool_nest_surplus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '柏楚余料'", nullable = true)
   private Boolean boolNestSurplus;
   @ApiModelProperty(name = "dxfUrl", value = "app拍照dxfUrl", notes = "app拍照dxfUrl")
   @JsonProperty("dxfUrl")
   @JSONField(name = "dxfUrl")
   @TableField("dxf_url")
   @Column(name = "dxf_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照dxfUrl'", nullable = true)
   private String dxfUrl;
   @ApiModelProperty(name = "imgUrl", value = "app拍照缩略图", notes = "app拍照缩略图")
   @JsonProperty("imgUrl")
   @JSONField(name = "imgUrl")
   @TableField("img_url")
   @Column(name = "img_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照缩略图'", nullable = true)
   private String imgUrl;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料面积", notes = "柏楚余料面积")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "decimal(32,12)  COMMENT ' 柏楚余料面积'", nullable = true)
   private BigDecimal area;
   @ApiModelProperty(name = "syncVirtualId", value = "板材虚拟物料仓id", notes = "板材虚拟物料仓id")
   @JsonProperty("syncVirtualId")
   @JSONField(name = "syncId")
   @TableField("sync_virtual_id")
   @Column(name = "sync_virtual_id", columnDefinition = "varchar(255)  COMMENT '板材虚拟物料仓id'", nullable = true)
   private String syncVirtualId;
   @ApiModelProperty(name = "stockGuid", value = "柏楚排样图guid如：切0001", notes = "柏楚排样图guid")
   @JsonProperty("stockGuid")
   @JSONField(name = "stockGuid")
   @TableField("stock_guid")
   @Column(name = "stock_guid", columnDefinition = "varchar(255)  COMMENT '柏楚板材guid'", nullable = true)
   private String stockGuid;
   @ApiModelProperty(name = "stockCutGuid", value = "切割任务guid(mes会生成子的如：切0001-01)", notes = "切割任务guid")
   @JsonProperty("stockCutGuid")
   @JSONField(name = "stockCutGuid")
   @TableField("stock_cut_guid")
   @Column(name = "stock_cut_guid", columnDefinition = "varchar(255)  COMMENT '切割任务guid'", nullable = true)
   private String stockCutGuid;
   @ApiModelProperty(name = "marking")
   @JsonProperty("marking")
   @JSONField(name = "marking")
   @TableField("marking")
   @Column(name = "marking", columnDefinition = "tinyint(1) default '0' COMMENT '是否打标（app使用）'", nullable = true)
   private Boolean marking;
   @ApiModelProperty(name = "childOrderNumber")
   @JsonProperty("childOrderNumber")
   @TableField("child_order_number")
   @Column(name = "child_order_number", columnDefinition = "varchar(255)  COMMENT '工单任务号'", nullable = true)
   private String childOrderNumber;
   @ApiModelProperty(name = "childOrderId", value = "工单id")
   @JsonProperty("childOrderId")
   @JSONField(name = "childOrderId")
   @TableField("child_order_id")
   @Column(name = "child_order_id", columnDefinition = "bigint(20) COMMENT '工单id(余料打标使用可以通过工单ID 查询余料信息)'", nullable = true)
   private Long childOrderId;
   @ApiModelProperty(name = "MaterialCodeConfigId")
   @JsonProperty("MaterialCodeConfigId")
   @JSONField(name = "MaterialCodeConfigId")
   @TableField("material_code_config_id")
   @Column(name = "material_code_config_id", columnDefinition = "varchar(255)  COMMENT '物料编码id（中南）'", nullable = true)
   private String MaterialCodeConfigId;

   public static MaterialInventory.MaterialInventoryBuilder builder() {
      return new MaterialInventory.MaterialInventoryBuilder();
   }

   public MaterialInventory() {
   }

   public MaterialInventory(
      final Long id,
      final Boolean useStatus,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final String model,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final Boolean boolPartyA,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String measureUnit,
      final Integer accountingPrecision,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final Long warehouseId,
      final Integer weightMeasurementMode,
      final String remark,
      final String outboundSn,
      final String weightedAverageSpec,
      final LocalDateTime inventoryStartTime,
      final LocalDateTime inventoryEndTime,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Boolean boolHasFrozen,
      final Long standardId,
      final String standardName,
      final Long sourceMaterielId,
      final BigDecimal oneTheoryWeight,
      final BigDecimal sectionSteelWeight,
      final String serialNumber,
      final Long monomerId,
      final Long areaId,
      final String surplusGraphicsPath,
      final String barcode,
      final String surplusSn,
      final Boolean boolVirtual,
      final Long plateId,
      final String guid,
      final Long workshopId,
      final Long outboundId,
      final Long inboundId,
      final Long sourceMaterialInventoryId,
      final Boolean boolNestSurplus,
      final String dxfUrl,
      final String imgUrl,
      final BigDecimal area,
      final String syncVirtualId,
      final String stockGuid,
      final String stockCutGuid,
      final Boolean marking,
      final String childOrderNumber,
      final Long childOrderId,
      final String MaterialCodeConfigId
   ) {
      this.id = id;
      this.useStatus = useStatus;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.model = model;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.unitNet = unitNet;
      this.warehouseId = warehouseId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.remark = remark;
      this.outboundSn = outboundSn;
      this.weightedAverageSpec = weightedAverageSpec;
      this.inventoryStartTime = inventoryStartTime;
      this.inventoryEndTime = inventoryEndTime;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.boolHasFrozen = boolHasFrozen;
      this.standardId = standardId;
      this.standardName = standardName;
      this.sourceMaterielId = sourceMaterielId;
      this.oneTheoryWeight = oneTheoryWeight;
      this.sectionSteelWeight = sectionSteelWeight;
      this.serialNumber = serialNumber;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.surplusGraphicsPath = surplusGraphicsPath;
      this.barcode = barcode;
      this.surplusSn = surplusSn;
      this.boolVirtual = boolVirtual;
      this.plateId = plateId;
      this.guid = guid;
      this.workshopId = workshopId;
      this.outboundId = outboundId;
      this.inboundId = inboundId;
      this.sourceMaterialInventoryId = sourceMaterialInventoryId;
      this.boolNestSurplus = boolNestSurplus;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.area = area;
      this.syncVirtualId = syncVirtualId;
      this.stockGuid = stockGuid;
      this.stockCutGuid = stockCutGuid;
      this.marking = marking;
      this.childOrderNumber = childOrderNumber;
      this.childOrderId = childOrderId;
      this.MaterialCodeConfigId = MaterialCodeConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getUseStatus() {
      return this.useStatus;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
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

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public LocalDateTime getInventoryStartTime() {
      return this.inventoryStartTime;
   }

   public LocalDateTime getInventoryEndTime() {
      return this.inventoryEndTime;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Boolean getBoolHasFrozen() {
      return this.boolHasFrozen;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getSourceMaterielId() {
      return this.sourceMaterielId;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSurplusGraphicsPath() {
      return this.surplusGraphicsPath;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public Boolean getBoolVirtual() {
      return this.boolVirtual;
   }

   public Long getPlateId() {
      return this.plateId;
   }

   public String getGuid() {
      return this.guid;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getSourceMaterialInventoryId() {
      return this.sourceMaterialInventoryId;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getSyncVirtualId() {
      return this.syncVirtualId;
   }

   public String getStockGuid() {
      return this.stockGuid;
   }

   public String getStockCutGuid() {
      return this.stockCutGuid;
   }

   public Boolean getMarking() {
      return this.marking;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public Long getChildOrderId() {
      return this.childOrderId;
   }

   public String getMaterialCodeConfigId() {
      return this.MaterialCodeConfigId;
   }

   @JsonProperty("id")
   public MaterialInventory setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("useStatus")
   public MaterialInventory setUseStatus(final Boolean useStatus) {
      this.useStatus = useStatus;
      return this;
   }

   @JsonProperty("basicClass")
   public MaterialInventory setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MaterialInventory setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public MaterialInventory setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public MaterialInventory setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("model")
   public MaterialInventory setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public MaterialInventory setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public MaterialInventory setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public MaterialInventory setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MaterialInventory setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("quantity")
   public MaterialInventory setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public MaterialInventory setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public MaterialInventory setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public MaterialInventory setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public MaterialInventory setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public MaterialInventory setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MaterialInventory setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public MaterialInventory setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("measureUnit")
   public MaterialInventory setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public MaterialInventory setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public MaterialInventory setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("mete")
   public MaterialInventory setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitNet")
   public MaterialInventory setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("warehouseId")
   public MaterialInventory setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public MaterialInventory setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("remark")
   public MaterialInventory setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("outboundSn")
   public MaterialInventory setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   @JsonProperty("weightedAverageSpec")
   public MaterialInventory setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   @JsonProperty("inventoryStartTime")
   public MaterialInventory setInventoryStartTime(final LocalDateTime inventoryStartTime) {
      this.inventoryStartTime = inventoryStartTime;
      return this;
   }

   @JsonProperty("inventoryEndTime")
   public MaterialInventory setInventoryEndTime(final LocalDateTime inventoryEndTime) {
      this.inventoryEndTime = inventoryEndTime;
      return this;
   }

   @JsonProperty("invoiceType")
   public MaterialInventory setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public MaterialInventory setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("boolHasFrozen")
   public MaterialInventory setBoolHasFrozen(final Boolean boolHasFrozen) {
      this.boolHasFrozen = boolHasFrozen;
      return this;
   }

   @JsonProperty("standardId")
   public MaterialInventory setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MaterialInventory setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("sourceMaterielId")
   public MaterialInventory setSourceMaterielId(final Long sourceMaterielId) {
      this.sourceMaterielId = sourceMaterielId;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public MaterialInventory setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("sectionSteelWeight")
   public MaterialInventory setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   @JsonProperty("serialNumber")
   public MaterialInventory setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("monomerId")
   public MaterialInventory setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MaterialInventory setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("surplusGraphicsPath")
   public MaterialInventory setSurplusGraphicsPath(final String surplusGraphicsPath) {
      this.surplusGraphicsPath = surplusGraphicsPath;
      return this;
   }

   @JsonProperty("barcode")
   public MaterialInventory setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("surplusSn")
   public MaterialInventory setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   @JsonProperty("boolVirtual")
   public MaterialInventory setBoolVirtual(final Boolean boolVirtual) {
      this.boolVirtual = boolVirtual;
      return this;
   }

   @JsonProperty("plateId")
   public MaterialInventory setPlateId(final Long plateId) {
      this.plateId = plateId;
      return this;
   }

   @JsonProperty("guid")
   public MaterialInventory setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   @JsonProperty("workshopId")
   public MaterialInventory setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("outboundId")
   public MaterialInventory setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("inboundId")
   public MaterialInventory setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("sourceMaterialInventoryId")
   public MaterialInventory setSourceMaterialInventoryId(final Long sourceMaterialInventoryId) {
      this.sourceMaterialInventoryId = sourceMaterialInventoryId;
      return this;
   }

   @JsonProperty("boolNestSurplus")
   public MaterialInventory setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
      return this;
   }

   @JsonProperty("dxfUrl")
   public MaterialInventory setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
      return this;
   }

   @JsonProperty("imgUrl")
   public MaterialInventory setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
      return this;
   }

   @JsonProperty("area")
   public MaterialInventory setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("syncVirtualId")
   public MaterialInventory setSyncVirtualId(final String syncVirtualId) {
      this.syncVirtualId = syncVirtualId;
      return this;
   }

   @JsonProperty("stockGuid")
   public MaterialInventory setStockGuid(final String stockGuid) {
      this.stockGuid = stockGuid;
      return this;
   }

   @JsonProperty("stockCutGuid")
   public MaterialInventory setStockCutGuid(final String stockCutGuid) {
      this.stockCutGuid = stockCutGuid;
      return this;
   }

   @JsonProperty("marking")
   public MaterialInventory setMarking(final Boolean marking) {
      this.marking = marking;
      return this;
   }

   @JsonProperty("childOrderNumber")
   public MaterialInventory setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
      return this;
   }

   @JsonProperty("childOrderId")
   public MaterialInventory setChildOrderId(final Long childOrderId) {
      this.childOrderId = childOrderId;
      return this;
   }

   @JsonProperty("MaterialCodeConfigId")
   public MaterialInventory setMaterialCodeConfigId(final String MaterialCodeConfigId) {
      this.MaterialCodeConfigId = MaterialCodeConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "MaterialInventory(id="
         + this.getId()
         + ", useStatus="
         + this.getUseStatus()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", remark="
         + this.getRemark()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", inventoryStartTime="
         + this.getInventoryStartTime()
         + ", inventoryEndTime="
         + this.getInventoryEndTime()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", boolHasFrozen="
         + this.getBoolHasFrozen()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", sourceMaterielId="
         + this.getSourceMaterielId()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", surplusGraphicsPath="
         + this.getSurplusGraphicsPath()
         + ", barcode="
         + this.getBarcode()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", boolVirtual="
         + this.getBoolVirtual()
         + ", plateId="
         + this.getPlateId()
         + ", guid="
         + this.getGuid()
         + ", workshopId="
         + this.getWorkshopId()
         + ", outboundId="
         + this.getOutboundId()
         + ", inboundId="
         + this.getInboundId()
         + ", sourceMaterialInventoryId="
         + this.getSourceMaterialInventoryId()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", area="
         + this.getArea()
         + ", syncVirtualId="
         + this.getSyncVirtualId()
         + ", stockGuid="
         + this.getStockGuid()
         + ", stockCutGuid="
         + this.getStockCutGuid()
         + ", marking="
         + this.getMarking()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", childOrderId="
         + this.getChildOrderId()
         + ", MaterialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialInventory)) {
         return false;
      }

      MaterialInventory other = (MaterialInventory)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$useStatus = this.getUseStatus();
         Object other$useStatus = other.getUseStatus();
         if (this$useStatus == null ? other$useStatus == null : this$useStatus.equals(other$useStatus)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$materialIsWhole = this.getMaterialIsWhole();
                  Object other$materialIsWhole = other.getMaterialIsWhole();
                  if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                     Object this$warehouseType = this.getWarehouseType();
                     Object other$warehouseType = other.getWarehouseType();
                     if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$boolPartyA = this.getBoolPartyA();
                           Object other$boolPartyA = other.getBoolPartyA();
                           if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                              Object this$accountingPrecision = this.getAccountingPrecision();
                              Object other$accountingPrecision = other.getAccountingPrecision();
                              if (this$accountingPrecision == null
                                 ? other$accountingPrecision == null
                                 : this$accountingPrecision.equals(other$accountingPrecision)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                    Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                    if (this$weightMeasurementMode == null
                                       ? other$weightMeasurementMode == null
                                       : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$boolHasFrozen = this.getBoolHasFrozen();
                                          Object other$boolHasFrozen = other.getBoolHasFrozen();
                                          if (this$boolHasFrozen == null ? other$boolHasFrozen == null : this$boolHasFrozen.equals(other$boolHasFrozen)) {
                                             Object this$standardId = this.getStandardId();
                                             Object other$standardId = other.getStandardId();
                                             if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                Object this$sourceMaterielId = this.getSourceMaterielId();
                                                Object other$sourceMaterielId = other.getSourceMaterielId();
                                                if (this$sourceMaterielId == null
                                                   ? other$sourceMaterielId == null
                                                   : this$sourceMaterielId.equals(other$sourceMaterielId)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$boolVirtual = this.getBoolVirtual();
                                                         Object other$boolVirtual = other.getBoolVirtual();
                                                         if (this$boolVirtual == null ? other$boolVirtual == null : this$boolVirtual.equals(other$boolVirtual)) {
                                                            Object this$plateId = this.getPlateId();
                                                            Object other$plateId = other.getPlateId();
                                                            if (this$plateId == null ? other$plateId == null : this$plateId.equals(other$plateId)) {
                                                               Object this$workshopId = this.getWorkshopId();
                                                               Object other$workshopId = other.getWorkshopId();
                                                               if (this$workshopId == null
                                                                  ? other$workshopId == null
                                                                  : this$workshopId.equals(other$workshopId)) {
                                                                  Object this$outboundId = this.getOutboundId();
                                                                  Object other$outboundId = other.getOutboundId();
                                                                  if (this$outboundId == null
                                                                     ? other$outboundId == null
                                                                     : this$outboundId.equals(other$outboundId)) {
                                                                     Object this$inboundId = this.getInboundId();
                                                                     Object other$inboundId = other.getInboundId();
                                                                     if (this$inboundId == null
                                                                        ? other$inboundId == null
                                                                        : this$inboundId.equals(other$inboundId)) {
                                                                        Object this$sourceMaterialInventoryId = this.getSourceMaterialInventoryId();
                                                                        Object other$sourceMaterialInventoryId = other.getSourceMaterialInventoryId();
                                                                        if (this$sourceMaterialInventoryId == null
                                                                           ? other$sourceMaterialInventoryId == null
                                                                           : this$sourceMaterialInventoryId.equals(other$sourceMaterialInventoryId)) {
                                                                           Object this$boolNestSurplus = this.getBoolNestSurplus();
                                                                           Object other$boolNestSurplus = other.getBoolNestSurplus();
                                                                           if (this$boolNestSurplus == null
                                                                              ? other$boolNestSurplus == null
                                                                              : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                                                              Object this$marking = this.getMarking();
                                                                              Object other$marking = other.getMarking();
                                                                              if (this$marking == null
                                                                                 ? other$marking == null
                                                                                 : this$marking.equals(other$marking)) {
                                                                                 Object this$childOrderId = this.getChildOrderId();
                                                                                 Object other$childOrderId = other.getChildOrderId();
                                                                                 if (this$childOrderId == null
                                                                                    ? other$childOrderId == null
                                                                                    : this$childOrderId.equals(other$childOrderId)) {
                                                                                    Object this$classifyName = this.getClassifyName();
                                                                                    Object other$classifyName = other.getClassifyName();
                                                                                    if (this$classifyName == null
                                                                                       ? other$classifyName == null
                                                                                       : this$classifyName.equals(other$classifyName)) {
                                                                                       Object this$specification = this.getSpecification();
                                                                                       Object other$specification = other.getSpecification();
                                                                                       if (this$specification == null
                                                                                          ? other$specification == null
                                                                                          : this$specification.equals(other$specification)) {
                                                                                          Object this$model = this.getModel();
                                                                                          Object other$model = other.getModel();
                                                                                          if (this$model == null
                                                                                             ? other$model == null
                                                                                             : this$model.equals(other$model)) {
                                                                                             Object this$quantity = this.getQuantity();
                                                                                             Object other$quantity = other.getQuantity();
                                                                                             if (this$quantity == null
                                                                                                ? other$quantity == null
                                                                                                : this$quantity.equals(other$quantity)) {
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
                                                                                                         Object this$theoryThickness = this.getTheoryThickness();
                                                                                                         Object other$theoryThickness = other.getTheoryThickness();
                                                                                                         if (this$theoryThickness == null
                                                                                                            ? other$theoryThickness == null
                                                                                                            : this$theoryThickness.equals(other$theoryThickness)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$brand = this.getBrand();
                                                                                                            Object other$brand = other.getBrand();
                                                                                                            if (this$brand == null
                                                                                                               ? other$brand == null
                                                                                                               : this$brand.equals(other$brand)) {
                                                                                                               Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                               Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                               if (this$heatNoAndBatchNo == null
                                                                                                                  ? other$heatNoAndBatchNo == null
                                                                                                                  : this$heatNoAndBatchNo.equals(
                                                                                                                     other$heatNoAndBatchNo
                                                                                                                  )) {
                                                                                                                  Object this$color = this.getColor();
                                                                                                                  Object other$color = other.getColor();
                                                                                                                  if (this$color == null
                                                                                                                     ? other$color == null
                                                                                                                     : this$color.equals(other$color)) {
                                                                                                                     Object this$measureUnit = this.getMeasureUnit();
                                                                                                                     Object other$measureUnit = other.getMeasureUnit();
                                                                                                                     if (this$measureUnit == null
                                                                                                                        ? other$measureUnit == null
                                                                                                                        : this$measureUnit.equals(
                                                                                                                           other$measureUnit
                                                                                                                        )) {
                                                                                                                        Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                        Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                        if (this$accountingUnit == null
                                                                                                                           ? other$accountingUnit == null
                                                                                                                           : this$accountingUnit.equals(
                                                                                                                              other$accountingUnit
                                                                                                                           )) {
                                                                                                                           Object this$mete = this.getMete();
                                                                                                                           Object other$mete = other.getMete();
                                                                                                                           if (this$mete == null
                                                                                                                              ? other$mete == null
                                                                                                                              : this$mete.equals(other$mete)) {
                                                                                                                              Object this$unitNet = this.getUnitNet();
                                                                                                                              Object other$unitNet = other.getUnitNet();
                                                                                                                              if (this$unitNet == null
                                                                                                                                 ? other$unitNet == null
                                                                                                                                 : this$unitNet.equals(
                                                                                                                                    other$unitNet
                                                                                                                                 )) {
                                                                                                                                 Object this$remark = this.getRemark();
                                                                                                                                 Object other$remark = other.getRemark();
                                                                                                                                 if (this$remark == null
                                                                                                                                    ? other$remark == null
                                                                                                                                    : this$remark.equals(
                                                                                                                                       other$remark
                                                                                                                                    )) {
                                                                                                                                    Object this$outboundSn = this.getOutboundSn();
                                                                                                                                    Object other$outboundSn = other.getOutboundSn();
                                                                                                                                    if (this$outboundSn == null
                                                                                                                                       ? other$outboundSn
                                                                                                                                          == null
                                                                                                                                       : this$outboundSn.equals(
                                                                                                                                          other$outboundSn
                                                                                                                                       )) {
                                                                                                                                       Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                                                       Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                                                       if (this$weightedAverageSpec
                                                                                                                                             == null
                                                                                                                                          ? other$weightedAverageSpec
                                                                                                                                             == null
                                                                                                                                          : this$weightedAverageSpec.equals(
                                                                                                                                             other$weightedAverageSpec
                                                                                                                                          )) {
                                                                                                                                          Object this$inventoryStartTime = this.getInventoryStartTime();
                                                                                                                                          Object other$inventoryStartTime = other.getInventoryStartTime();
                                                                                                                                          if (this$inventoryStartTime
                                                                                                                                                == null
                                                                                                                                             ? other$inventoryStartTime
                                                                                                                                                == null
                                                                                                                                             : this$inventoryStartTime.equals(
                                                                                                                                                other$inventoryStartTime
                                                                                                                                             )) {
                                                                                                                                             Object this$inventoryEndTime = this.getInventoryEndTime();
                                                                                                                                             Object other$inventoryEndTime = other.getInventoryEndTime();
                                                                                                                                             if (this$inventoryEndTime
                                                                                                                                                   == null
                                                                                                                                                ? other$inventoryEndTime
                                                                                                                                                   == null
                                                                                                                                                : this$inventoryEndTime.equals(
                                                                                                                                                   other$inventoryEndTime
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
                                                                                                                                                   Object this$standardName = this.getStandardName();
                                                                                                                                                   Object other$standardName = other.getStandardName();
                                                                                                                                                   if (this$standardName
                                                                                                                                                         == null
                                                                                                                                                      ? other$standardName
                                                                                                                                                         == null
                                                                                                                                                      : this$standardName.equals(
                                                                                                                                                         other$standardName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                                                                      Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                                                                      if (this$oneTheoryWeight
                                                                                                                                                            == null
                                                                                                                                                         ? other$oneTheoryWeight
                                                                                                                                                            == null
                                                                                                                                                         : this$oneTheoryWeight.equals(
                                                                                                                                                            other$oneTheoryWeight
                                                                                                                                                         )) {
                                                                                                                                                         Object this$sectionSteelWeight = this.getSectionSteelWeight();
                                                                                                                                                         Object other$sectionSteelWeight = other.getSectionSteelWeight();
                                                                                                                                                         if (this$sectionSteelWeight
                                                                                                                                                               == null
                                                                                                                                                            ? other$sectionSteelWeight
                                                                                                                                                               == null
                                                                                                                                                            : this$sectionSteelWeight.equals(
                                                                                                                                                               other$sectionSteelWeight
                                                                                                                                                            )) {
                                                                                                                                                            Object this$serialNumber = this.getSerialNumber();
                                                                                                                                                            Object other$serialNumber = other.getSerialNumber();
                                                                                                                                                            if (this$serialNumber
                                                                                                                                                                  == null
                                                                                                                                                               ? other$serialNumber
                                                                                                                                                                  == null
                                                                                                                                                               : this$serialNumber.equals(
                                                                                                                                                                  other$serialNumber
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$surplusGraphicsPath = this.getSurplusGraphicsPath();
                                                                                                                                                               Object other$surplusGraphicsPath = other.getSurplusGraphicsPath();
                                                                                                                                                               if (this$surplusGraphicsPath
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$surplusGraphicsPath
                                                                                                                                                                     == null
                                                                                                                                                                  : this$surplusGraphicsPath.equals(
                                                                                                                                                                     other$surplusGraphicsPath
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$barcode = this.getBarcode();
                                                                                                                                                                  Object other$barcode = other.getBarcode();
                                                                                                                                                                  if (this$barcode
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$barcode
                                                                                                                                                                        == null
                                                                                                                                                                     : this$barcode.equals(
                                                                                                                                                                        other$barcode
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
                                                                                                                                                                        Object this$guid = this.getGuid();
                                                                                                                                                                        Object other$guid = other.getGuid();
                                                                                                                                                                        if (this$guid
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$guid
                                                                                                                                                                              == null
                                                                                                                                                                           : this$guid.equals(
                                                                                                                                                                              other$guid
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$dxfUrl = this.getDxfUrl();
                                                                                                                                                                           Object other$dxfUrl = other.getDxfUrl();
                                                                                                                                                                           if (this$dxfUrl
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$dxfUrl
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$dxfUrl.equals(
                                                                                                                                                                                 other$dxfUrl
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$imgUrl = this.getImgUrl();
                                                                                                                                                                              Object other$imgUrl = other.getImgUrl();
                                                                                                                                                                              if (this$imgUrl
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$imgUrl
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$imgUrl.equals(
                                                                                                                                                                                    other$imgUrl
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$area = this.getArea();
                                                                                                                                                                                 Object other$area = other.getArea();
                                                                                                                                                                                 if (this$area
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$area
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$area.equals(
                                                                                                                                                                                       other$area
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$syncVirtualId = this.getSyncVirtualId();
                                                                                                                                                                                    Object other$syncVirtualId = other.getSyncVirtualId();
                                                                                                                                                                                    if (this$syncVirtualId
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$syncVirtualId
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$syncVirtualId.equals(
                                                                                                                                                                                          other$syncVirtualId
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
                                                                                                                                                                                          Object this$stockCutGuid = this.getStockCutGuid();
                                                                                                                                                                                          Object other$stockCutGuid = other.getStockCutGuid();
                                                                                                                                                                                          if (this$stockCutGuid
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$stockCutGuid
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$stockCutGuid.equals(
                                                                                                                                                                                                other$stockCutGuid
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$childOrderNumber = this.getChildOrderNumber();
                                                                                                                                                                                             Object other$childOrderNumber = other.getChildOrderNumber();
                                                                                                                                                                                             if (this$childOrderNumber
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$childOrderNumber
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$childOrderNumber.equals(
                                                                                                                                                                                                   other$childOrderNumber
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$MaterialCodeConfigId = this.getMaterialCodeConfigId();
                                                                                                                                                                                                Object other$MaterialCodeConfigId = other.getMaterialCodeConfigId();
                                                                                                                                                                                                return this$MaterialCodeConfigId
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$MaterialCodeConfigId
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$MaterialCodeConfigId.equals(
                                                                                                                                                                                                      other$MaterialCodeConfigId
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
      return other instanceof MaterialInventory;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $useStatus = this.getUseStatus();
      result = result * 59 + ($useStatus == null ? 43 : $useStatus.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolHasFrozen = this.getBoolHasFrozen();
      result = result * 59 + ($boolHasFrozen == null ? 43 : $boolHasFrozen.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $sourceMaterielId = this.getSourceMaterielId();
      result = result * 59 + ($sourceMaterielId == null ? 43 : $sourceMaterielId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolVirtual = this.getBoolVirtual();
      result = result * 59 + ($boolVirtual == null ? 43 : $boolVirtual.hashCode());
      Object $plateId = this.getPlateId();
      result = result * 59 + ($plateId == null ? 43 : $plateId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $sourceMaterialInventoryId = this.getSourceMaterialInventoryId();
      result = result * 59 + ($sourceMaterialInventoryId == null ? 43 : $sourceMaterialInventoryId.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $marking = this.getMarking();
      result = result * 59 + ($marking == null ? 43 : $marking.hashCode());
      Object $childOrderId = this.getChildOrderId();
      result = result * 59 + ($childOrderId == null ? 43 : $childOrderId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $inventoryStartTime = this.getInventoryStartTime();
      result = result * 59 + ($inventoryStartTime == null ? 43 : $inventoryStartTime.hashCode());
      Object $inventoryEndTime = this.getInventoryEndTime();
      result = result * 59 + ($inventoryEndTime == null ? 43 : $inventoryEndTime.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $surplusGraphicsPath = this.getSurplusGraphicsPath();
      result = result * 59 + ($surplusGraphicsPath == null ? 43 : $surplusGraphicsPath.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $syncVirtualId = this.getSyncVirtualId();
      result = result * 59 + ($syncVirtualId == null ? 43 : $syncVirtualId.hashCode());
      Object $stockGuid = this.getStockGuid();
      result = result * 59 + ($stockGuid == null ? 43 : $stockGuid.hashCode());
      Object $stockCutGuid = this.getStockCutGuid();
      result = result * 59 + ($stockCutGuid == null ? 43 : $stockCutGuid.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      result = result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
      Object $MaterialCodeConfigId = this.getMaterialCodeConfigId();
      return result * 59 + ($MaterialCodeConfigId == null ? 43 : $MaterialCodeConfigId.hashCode());
   }

   public static class MaterialInventoryBuilder {
      private Long id;
      private Boolean useStatus;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private String model;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private Boolean boolPartyA;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String measureUnit;
      private Integer accountingPrecision;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private Long warehouseId;
      private Integer weightMeasurementMode;
      private String remark;
      private String outboundSn;
      private String weightedAverageSpec;
      private LocalDateTime inventoryStartTime;
      private LocalDateTime inventoryEndTime;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Boolean boolHasFrozen;
      private Long standardId;
      private String standardName;
      private Long sourceMaterielId;
      private BigDecimal oneTheoryWeight;
      private BigDecimal sectionSteelWeight;
      private String serialNumber;
      private Long monomerId;
      private Long areaId;
      private String surplusGraphicsPath;
      private String barcode;
      private String surplusSn;
      private Boolean boolVirtual;
      private Long plateId;
      private String guid;
      private Long workshopId;
      private Long outboundId;
      private Long inboundId;
      private Long sourceMaterialInventoryId;
      private Boolean boolNestSurplus;
      private String dxfUrl;
      private String imgUrl;
      private BigDecimal area;
      private String syncVirtualId;
      private String stockGuid;
      private String stockCutGuid;
      private Boolean marking;
      private String childOrderNumber;
      private Long childOrderId;
      private String MaterialCodeConfigId;

      MaterialInventoryBuilder() {
      }

      @JsonProperty("id")
      public MaterialInventory.MaterialInventoryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("useStatus")
      public MaterialInventory.MaterialInventoryBuilder useStatus(final Boolean useStatus) {
         this.useStatus = useStatus;
         return this;
      }

      @JsonProperty("basicClass")
      public MaterialInventory.MaterialInventoryBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MaterialInventory.MaterialInventoryBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public MaterialInventory.MaterialInventoryBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public MaterialInventory.MaterialInventoryBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("model")
      public MaterialInventory.MaterialInventoryBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public MaterialInventory.MaterialInventoryBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public MaterialInventory.MaterialInventoryBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public MaterialInventory.MaterialInventoryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MaterialInventory.MaterialInventoryBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("quantity")
      public MaterialInventory.MaterialInventoryBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public MaterialInventory.MaterialInventoryBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public MaterialInventory.MaterialInventoryBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public MaterialInventory.MaterialInventoryBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public MaterialInventory.MaterialInventoryBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public MaterialInventory.MaterialInventoryBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MaterialInventory.MaterialInventoryBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public MaterialInventory.MaterialInventoryBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("measureUnit")
      public MaterialInventory.MaterialInventoryBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public MaterialInventory.MaterialInventoryBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public MaterialInventory.MaterialInventoryBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("mete")
      public MaterialInventory.MaterialInventoryBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitNet")
      public MaterialInventory.MaterialInventoryBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("warehouseId")
      public MaterialInventory.MaterialInventoryBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public MaterialInventory.MaterialInventoryBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("remark")
      public MaterialInventory.MaterialInventoryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("outboundSn")
      public MaterialInventory.MaterialInventoryBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      @JsonProperty("weightedAverageSpec")
      public MaterialInventory.MaterialInventoryBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      @JsonProperty("inventoryStartTime")
      public MaterialInventory.MaterialInventoryBuilder inventoryStartTime(final LocalDateTime inventoryStartTime) {
         this.inventoryStartTime = inventoryStartTime;
         return this;
      }

      @JsonProperty("inventoryEndTime")
      public MaterialInventory.MaterialInventoryBuilder inventoryEndTime(final LocalDateTime inventoryEndTime) {
         this.inventoryEndTime = inventoryEndTime;
         return this;
      }

      @JsonProperty("invoiceType")
      public MaterialInventory.MaterialInventoryBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public MaterialInventory.MaterialInventoryBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("boolHasFrozen")
      public MaterialInventory.MaterialInventoryBuilder boolHasFrozen(final Boolean boolHasFrozen) {
         this.boolHasFrozen = boolHasFrozen;
         return this;
      }

      @JsonProperty("standardId")
      public MaterialInventory.MaterialInventoryBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MaterialInventory.MaterialInventoryBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("sourceMaterielId")
      public MaterialInventory.MaterialInventoryBuilder sourceMaterielId(final Long sourceMaterielId) {
         this.sourceMaterielId = sourceMaterielId;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public MaterialInventory.MaterialInventoryBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public MaterialInventory.MaterialInventoryBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("serialNumber")
      public MaterialInventory.MaterialInventoryBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("monomerId")
      public MaterialInventory.MaterialInventoryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MaterialInventory.MaterialInventoryBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("surplusGraphicsPath")
      public MaterialInventory.MaterialInventoryBuilder surplusGraphicsPath(final String surplusGraphicsPath) {
         this.surplusGraphicsPath = surplusGraphicsPath;
         return this;
      }

      @JsonProperty("barcode")
      public MaterialInventory.MaterialInventoryBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("surplusSn")
      public MaterialInventory.MaterialInventoryBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("boolVirtual")
      public MaterialInventory.MaterialInventoryBuilder boolVirtual(final Boolean boolVirtual) {
         this.boolVirtual = boolVirtual;
         return this;
      }

      @JsonProperty("plateId")
      public MaterialInventory.MaterialInventoryBuilder plateId(final Long plateId) {
         this.plateId = plateId;
         return this;
      }

      @JsonProperty("guid")
      public MaterialInventory.MaterialInventoryBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      @JsonProperty("workshopId")
      public MaterialInventory.MaterialInventoryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("outboundId")
      public MaterialInventory.MaterialInventoryBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("inboundId")
      public MaterialInventory.MaterialInventoryBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("sourceMaterialInventoryId")
      public MaterialInventory.MaterialInventoryBuilder sourceMaterialInventoryId(final Long sourceMaterialInventoryId) {
         this.sourceMaterialInventoryId = sourceMaterialInventoryId;
         return this;
      }

      @JsonProperty("boolNestSurplus")
      public MaterialInventory.MaterialInventoryBuilder boolNestSurplus(final Boolean boolNestSurplus) {
         this.boolNestSurplus = boolNestSurplus;
         return this;
      }

      @JsonProperty("dxfUrl")
      public MaterialInventory.MaterialInventoryBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      @JsonProperty("imgUrl")
      public MaterialInventory.MaterialInventoryBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      @JsonProperty("area")
      public MaterialInventory.MaterialInventoryBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("syncVirtualId")
      public MaterialInventory.MaterialInventoryBuilder syncVirtualId(final String syncVirtualId) {
         this.syncVirtualId = syncVirtualId;
         return this;
      }

      @JsonProperty("stockGuid")
      public MaterialInventory.MaterialInventoryBuilder stockGuid(final String stockGuid) {
         this.stockGuid = stockGuid;
         return this;
      }

      @JsonProperty("stockCutGuid")
      public MaterialInventory.MaterialInventoryBuilder stockCutGuid(final String stockCutGuid) {
         this.stockCutGuid = stockCutGuid;
         return this;
      }

      @JsonProperty("marking")
      public MaterialInventory.MaterialInventoryBuilder marking(final Boolean marking) {
         this.marking = marking;
         return this;
      }

      @JsonProperty("childOrderNumber")
      public MaterialInventory.MaterialInventoryBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      @JsonProperty("childOrderId")
      public MaterialInventory.MaterialInventoryBuilder childOrderId(final Long childOrderId) {
         this.childOrderId = childOrderId;
         return this;
      }

      @JsonProperty("MaterialCodeConfigId")
      public MaterialInventory.MaterialInventoryBuilder MaterialCodeConfigId(final String MaterialCodeConfigId) {
         this.MaterialCodeConfigId = MaterialCodeConfigId;
         return this;
      }

      public MaterialInventory build() {
         return new MaterialInventory(
            this.id,
            this.useStatus,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.model,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.boolPartyA,
            this.quantity,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.measureUnit,
            this.accountingPrecision,
            this.accountingUnit,
            this.mete,
            this.unitNet,
            this.warehouseId,
            this.weightMeasurementMode,
            this.remark,
            this.outboundSn,
            this.weightedAverageSpec,
            this.inventoryStartTime,
            this.inventoryEndTime,
            this.invoiceType,
            this.taxRate,
            this.boolHasFrozen,
            this.standardId,
            this.standardName,
            this.sourceMaterielId,
            this.oneTheoryWeight,
            this.sectionSteelWeight,
            this.serialNumber,
            this.monomerId,
            this.areaId,
            this.surplusGraphicsPath,
            this.barcode,
            this.surplusSn,
            this.boolVirtual,
            this.plateId,
            this.guid,
            this.workshopId,
            this.outboundId,
            this.inboundId,
            this.sourceMaterialInventoryId,
            this.boolNestSurplus,
            this.dxfUrl,
            this.imgUrl,
            this.area,
            this.syncVirtualId,
            this.stockGuid,
            this.stockCutGuid,
            this.marking,
            this.childOrderNumber,
            this.childOrderId,
            this.MaterialCodeConfigId
         );
      }

      @Override
      public String toString() {
         return "MaterialInventory.MaterialInventoryBuilder(id="
            + this.id
            + ", useStatus="
            + this.useStatus
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
            + ", boolPartyA="
            + this.boolPartyA
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", measureUnit="
            + this.measureUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
            + ", warehouseId="
            + this.warehouseId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", remark="
            + this.remark
            + ", outboundSn="
            + this.outboundSn
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", inventoryStartTime="
            + this.inventoryStartTime
            + ", inventoryEndTime="
            + this.inventoryEndTime
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", boolHasFrozen="
            + this.boolHasFrozen
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", sourceMaterielId="
            + this.sourceMaterielId
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", serialNumber="
            + this.serialNumber
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", surplusGraphicsPath="
            + this.surplusGraphicsPath
            + ", barcode="
            + this.barcode
            + ", surplusSn="
            + this.surplusSn
            + ", boolVirtual="
            + this.boolVirtual
            + ", plateId="
            + this.plateId
            + ", guid="
            + this.guid
            + ", workshopId="
            + this.workshopId
            + ", outboundId="
            + this.outboundId
            + ", inboundId="
            + this.inboundId
            + ", sourceMaterialInventoryId="
            + this.sourceMaterialInventoryId
            + ", boolNestSurplus="
            + this.boolNestSurplus
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", area="
            + this.area
            + ", syncVirtualId="
            + this.syncVirtualId
            + ", stockGuid="
            + this.stockGuid
            + ", stockCutGuid="
            + this.stockCutGuid
            + ", marking="
            + this.marking
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", childOrderId="
            + this.childOrderId
            + ", MaterialCodeConfigId="
            + this.MaterialCodeConfigId
            + ")";
      }
   }
}
