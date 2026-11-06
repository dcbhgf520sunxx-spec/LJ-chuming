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

@ApiModel(value = "MaterialReturnable对象", description = "可退库物料表 ")
@Entity
@TableName("wms_material_returnable")
@Table(name = "wms_material_returnable")
public class MaterialReturnable extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整[1 整料,2 余料]", notes = "物料是否完整[1 整料,2 余料]")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料是否完整[1 整料,2 余料]'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_A")
   @Column(name = "bool_party_A", columnDefinition = "tinyint(1)  COMMENT '是否甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "outboundUnitType", value = "出库单位类型", notes = "出库单位类型")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库单位类型'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "mete", value = "出库核算量", notes = "出库核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '出库核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "returnableMete", value = "可退库核算量", notes = "可退库核算量")
   @JsonProperty("returnableMete")
   @JSONField(name = "returnableMete")
   @TableField("returnable_mete")
   @Column(name = "returnable_mete", columnDefinition = "decimal(32,8)  COMMENT '可退库核算量'", nullable = true)
   private BigDecimal returnableMete;
   @ApiModelProperty(name = "singleMete", value = "出库单件核算量", notes = "出库单件核算量")
   @JsonProperty("singleMete")
   @JSONField(name = "singleMete")
   @TableField("single_mete")
   @Column(name = "single_mete", columnDefinition = "decimal(32,8)  COMMENT '出库单件核算量'", nullable = true)
   private BigDecimal singleMete;
   @ApiModelProperty(name = "singleReturnableMete", value = "可退库单件核算量", notes = "可退库单件核算量")
   @JsonProperty("singleReturnableMete")
   @JSONField(name = "singleReturnableMete")
   @TableField("single_returnable_mete")
   @Column(name = "single_returnable_mete", columnDefinition = "decimal(32,8)  COMMENT '可退库单件核算量'", nullable = true)
   private BigDecimal singleReturnableMete;
   @ApiModelProperty(name = "singleReturnableLength", value = "可退库单件定尺长度", notes = "可退库单件定尺长度")
   @JsonProperty("singleReturnableLength")
   @JSONField(name = "singleReturnableLength")
   @TableField("single_returnable_length")
   @Column(name = "single_returnable_length", columnDefinition = "decimal(32,8)  COMMENT '可退库单件定尺长度'", nullable = true)
   private BigDecimal singleReturnableLength;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
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
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,0)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
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
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "projectId", value = "出库项目", notes = "出库项目")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '出库项目'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号", notes = "出库单编号")
   @JsonProperty("outboundSn")
   @JSONField(name = "outboundSn")
   @TableField("outbound_SN")
   @Column(name = "outbound_SN", columnDefinition = "varchar(255)  COMMENT '出库单编号'", nullable = true)
   private String outboundSn;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "recipientId", value = "领用人ID", notes = "领用人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint  COMMENT '领用人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "recipientName", value = "领用人名称", notes = "领用人名称")
   @JsonProperty("recipientName")
   @JSONField(name = "recipientName")
   @TableField("recipient_name")
   @Column(name = "recipient_name", columnDefinition = "varchar(255)  COMMENT '领用人名称'", nullable = true)
   private String recipientName;
   @ApiModelProperty(name = "outboundTime", value = "出库时间", notes = "出库时间")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   @TableField("outbound_time")
   @Column(name = "outbound_time", columnDefinition = "datetime  COMMENT '出库时间'", nullable = true)
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)", notes = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @JsonProperty("weightedAverageSpec")
   @JSONField(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec", columnDefinition = "varchar(255)  COMMENT '加权平均规格(将规格拆分获取不参与加权规格以*号拼接)'", nullable = true)
   private String weightedAverageSpec;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税加权价", notes = "不含税加权价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税加权价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "outboundDetailId", value = "出库详情ID", notes = "出库详情ID")
   @JsonProperty("outboundDetailId")
   @JSONField(name = "outboundDetailId")
   @TableField("outbound_detail_id")
   @Column(name = "outbound_detail_id", columnDefinition = "bigint  COMMENT '出库详情ID'", nullable = true)
   private Long outboundDetailId;
   @ApiModelProperty(name = "boolReviewPending", value = "是否存在审核中退库单", notes = "是否存在审核中退库单")
   @JsonProperty("boolReviewPending")
   @JSONField(name = "boolReviewPending")
   @TableField("bool_review_pending")
   @Column(name = "bool_review_pending", columnDefinition = "tinyint(1) default '0' COMMENT '是否存在审核中退库单'", nullable = true)
   private Boolean boolReviewPending;
   @ApiModelProperty(name = "boolReturn", value = "是否可退库[0 已退库完, 1 没有退库完]是否", notes = "是否可退库[0 已退库完, 1 没有退库完]是否")
   @JsonProperty("boolReturn")
   @JSONField(name = "boolReturn")
   @TableField("bool_return")
   @Column(name = "bool_return", columnDefinition = "tinyint(1)  COMMENT '是否可退库[0 已退库完, 1 没有退库完]是否'", nullable = true)
   private Boolean boolReturn;
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
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID", notes = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量", notes = "单件理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(19,2)  COMMENT '单件理论重量'", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材标准重量(Kg/m)", notes = "型材标准重量(Kg/m)")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(19,2)  COMMENT '型材标准重量(Kg/m)'", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(255)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
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
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原车间ID", notes = "原车间ID")
   @JsonProperty("sourceWorkshopId")
   @JSONField(name = "sourceWorkshopId")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '原车间ID'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价 不含运费", notes = "含税单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税加权价 不含运费", notes = "不含税加权价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价  不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,8)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,8)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "outboundTypeSelection")
   @JsonProperty("outboundTypeSelection")
   @JSONField(name = "outboundTypeSelection")
   @TableField("outbound_type_selection")
   @Column(name = "outbound_type_selection", columnDefinition = "int default '1' COMMENT '出库类型 枚举类[OutboundTypeEnum]'", nullable = false)
   private Integer outboundTypeSelection;
   @ApiModelProperty(name = "areaBatchId", value = "批次ID", notes = "批次ID")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint  COMMENT '批次ID'", nullable = true)
   private Long areaBatchId;

   public static MaterialReturnable.MaterialReturnableBuilder builder() {
      return new MaterialReturnable.MaterialReturnableBuilder();
   }

   public MaterialReturnable() {
   }

   public MaterialReturnable(
      final Long id,
      final Long classifyId,
      final Integer materialIsWhole,
      final Boolean boolPartyA,
      final Integer outboundUnitType,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal returnableMete,
      final BigDecimal singleMete,
      final BigDecimal singleReturnableMete,
      final BigDecimal singleReturnableLength,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long projectId,
      final Long outboundId,
      final String outboundSn,
      final Long warehouseId,
      final Long recipientId,
      final String recipientName,
      final LocalDateTime outboundTime,
      final String weightedAverageSpec,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final Long outboundDetailId,
      final Boolean boolReviewPending,
      final Boolean boolReturn,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final String classifyName,
      final Long standardId,
      final String standardName,
      final BigDecimal oneTheoryWeight,
      final BigDecimal sectionSteelWeight,
      final String materialSn,
      final String accountingUnit,
      final Long monomerId,
      final Long areaId,
      final Long workshopId,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final Long sourceWorkshopId,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final Integer outboundTypeSelection,
      final Long areaBatchId
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.materialIsWhole = materialIsWhole;
      this.boolPartyA = boolPartyA;
      this.outboundUnitType = outboundUnitType;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.quantity = quantity;
      this.returnableMete = returnableMete;
      this.singleMete = singleMete;
      this.singleReturnableMete = singleReturnableMete;
      this.singleReturnableLength = singleReturnableLength;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.projectId = projectId;
      this.outboundId = outboundId;
      this.outboundSn = outboundSn;
      this.warehouseId = warehouseId;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.outboundTime = outboundTime;
      this.weightedAverageSpec = weightedAverageSpec;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.outboundDetailId = outboundDetailId;
      this.boolReviewPending = boolReviewPending;
      this.boolReturn = boolReturn;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.classifyName = classifyName;
      this.standardId = standardId;
      this.standardName = standardName;
      this.oneTheoryWeight = oneTheoryWeight;
      this.sectionSteelWeight = sectionSteelWeight;
      this.materialSn = materialSn;
      this.accountingUnit = accountingUnit;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.sourceWorkshopId = sourceWorkshopId;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.outboundTypeSelection = outboundTypeSelection;
      this.areaBatchId = areaBatchId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getReturnableMete() {
      return this.returnableMete;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getSingleReturnableMete() {
      return this.singleReturnableMete;
   }

   public BigDecimal getSingleReturnableLength() {
      return this.singleReturnableLength;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public Boolean getBoolReviewPending() {
      return this.boolReviewPending;
   }

   public Boolean getBoolReturn() {
      return this.boolReturn;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
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

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   @JsonProperty("id")
   public MaterialReturnable setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classifyId")
   public MaterialReturnable setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public MaterialReturnable setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MaterialReturnable setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public MaterialReturnable setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("basicClass")
   public MaterialReturnable setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public MaterialReturnable setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("mete")
   public MaterialReturnable setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public MaterialReturnable setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("returnableMete")
   public MaterialReturnable setReturnableMete(final BigDecimal returnableMete) {
      this.returnableMete = returnableMete;
      return this;
   }

   @JsonProperty("singleMete")
   public MaterialReturnable setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
      return this;
   }

   @JsonProperty("singleReturnableMete")
   public MaterialReturnable setSingleReturnableMete(final BigDecimal singleReturnableMete) {
      this.singleReturnableMete = singleReturnableMete;
      return this;
   }

   @JsonProperty("singleReturnableLength")
   public MaterialReturnable setSingleReturnableLength(final BigDecimal singleReturnableLength) {
      this.singleReturnableLength = singleReturnableLength;
      return this;
   }

   @JsonProperty("unitNet")
   public MaterialReturnable setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("length")
   public MaterialReturnable setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public MaterialReturnable setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public MaterialReturnable setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public MaterialReturnable setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public MaterialReturnable setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MaterialReturnable setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public MaterialReturnable setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("projectId")
   public MaterialReturnable setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("outboundId")
   public MaterialReturnable setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("outboundSn")
   public MaterialReturnable setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   @JsonProperty("warehouseId")
   public MaterialReturnable setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("recipientId")
   public MaterialReturnable setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("recipientName")
   public MaterialReturnable setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @JsonProperty("outboundTime")
   public MaterialReturnable setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("weightedAverageSpec")
   public MaterialReturnable setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   @JsonProperty("unitPrice")
   public MaterialReturnable setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public MaterialReturnable setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("outboundDetailId")
   public MaterialReturnable setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   @JsonProperty("boolReviewPending")
   public MaterialReturnable setBoolReviewPending(final Boolean boolReviewPending) {
      this.boolReviewPending = boolReviewPending;
      return this;
   }

   @JsonProperty("boolReturn")
   public MaterialReturnable setBoolReturn(final Boolean boolReturn) {
      this.boolReturn = boolReturn;
      return this;
   }

   @JsonProperty("invoiceType")
   public MaterialReturnable setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public MaterialReturnable setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("classifyName")
   public MaterialReturnable setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("standardId")
   public MaterialReturnable setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MaterialReturnable setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public MaterialReturnable setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("sectionSteelWeight")
   public MaterialReturnable setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   @JsonProperty("materialSn")
   public MaterialReturnable setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("accountingUnit")
   public MaterialReturnable setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("monomerId")
   public MaterialReturnable setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MaterialReturnable setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public MaterialReturnable setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("amount")
   public MaterialReturnable setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public MaterialReturnable setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("sourceWorkshopId")
   public MaterialReturnable setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public MaterialReturnable setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public MaterialReturnable setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public MaterialReturnable setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public MaterialReturnable setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public MaterialReturnable setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MaterialReturnable setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @Override
   public String toString() {
      return "MaterialReturnable(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", returnableMete="
         + this.getReturnableMete()
         + ", singleMete="
         + this.getSingleMete()
         + ", singleReturnableMete="
         + this.getSingleReturnableMete()
         + ", singleReturnableLength="
         + this.getSingleReturnableLength()
         + ", unitNet="
         + this.getUnitNet()
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
         + ", projectId="
         + this.getProjectId()
         + ", outboundId="
         + this.getOutboundId()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", boolReviewPending="
         + this.getBoolReviewPending()
         + ", boolReturn="
         + this.getBoolReturn()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", classifyName="
         + this.getClassifyName()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", materialSn="
         + this.getMaterialSn()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialReturnable)) {
         return false;
      }

      MaterialReturnable other = (MaterialReturnable)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$materialIsWhole = this.getMaterialIsWhole();
            Object other$materialIsWhole = other.getMaterialIsWhole();
            if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$outboundUnitType = this.getOutboundUnitType();
                  Object other$outboundUnitType = other.getOutboundUnitType();
                  if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$outboundId = this.getOutboundId();
                           Object other$outboundId = other.getOutboundId();
                           if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                              Object this$warehouseId = this.getWarehouseId();
                              Object other$warehouseId = other.getWarehouseId();
                              if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                 Object this$recipientId = this.getRecipientId();
                                 Object other$recipientId = other.getRecipientId();
                                 if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                    Object this$outboundDetailId = this.getOutboundDetailId();
                                    Object other$outboundDetailId = other.getOutboundDetailId();
                                    if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
                                       Object this$boolReviewPending = this.getBoolReviewPending();
                                       Object other$boolReviewPending = other.getBoolReviewPending();
                                       if (this$boolReviewPending == null
                                          ? other$boolReviewPending == null
                                          : this$boolReviewPending.equals(other$boolReviewPending)) {
                                          Object this$boolReturn = this.getBoolReturn();
                                          Object other$boolReturn = other.getBoolReturn();
                                          if (this$boolReturn == null ? other$boolReturn == null : this$boolReturn.equals(other$boolReturn)) {
                                             Object this$invoiceType = this.getInvoiceType();
                                             Object other$invoiceType = other.getInvoiceType();
                                             if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                Object this$standardId = this.getStandardId();
                                                Object other$standardId = other.getStandardId();
                                                if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$workshopId = this.getWorkshopId();
                                                         Object other$workshopId = other.getWorkshopId();
                                                         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                            Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                            Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                            if (this$sourceWorkshopId == null
                                                               ? other$sourceWorkshopId == null
                                                               : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                               Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                               Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                               if (this$outboundTypeSelection == null
                                                                  ? other$outboundTypeSelection == null
                                                                  : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                                                  Object this$areaBatchId = this.getAreaBatchId();
                                                                  Object other$areaBatchId = other.getAreaBatchId();
                                                                  if (this$areaBatchId == null
                                                                     ? other$areaBatchId == null
                                                                     : this$areaBatchId.equals(other$areaBatchId)) {
                                                                     Object this$specification = this.getSpecification();
                                                                     Object other$specification = other.getSpecification();
                                                                     if (this$specification == null
                                                                        ? other$specification == null
                                                                        : this$specification.equals(other$specification)) {
                                                                        Object this$mete = this.getMete();
                                                                        Object other$mete = other.getMete();
                                                                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                           Object this$quantity = this.getQuantity();
                                                                           Object other$quantity = other.getQuantity();
                                                                           if (this$quantity == null
                                                                              ? other$quantity == null
                                                                              : this$quantity.equals(other$quantity)) {
                                                                              Object this$returnableMete = this.getReturnableMete();
                                                                              Object other$returnableMete = other.getReturnableMete();
                                                                              if (this$returnableMete == null
                                                                                 ? other$returnableMete == null
                                                                                 : this$returnableMete.equals(other$returnableMete)) {
                                                                                 Object this$singleMete = this.getSingleMete();
                                                                                 Object other$singleMete = other.getSingleMete();
                                                                                 if (this$singleMete == null
                                                                                    ? other$singleMete == null
                                                                                    : this$singleMete.equals(other$singleMete)) {
                                                                                    Object this$singleReturnableMete = this.getSingleReturnableMete();
                                                                                    Object other$singleReturnableMete = other.getSingleReturnableMete();
                                                                                    if (this$singleReturnableMete == null
                                                                                       ? other$singleReturnableMete == null
                                                                                       : this$singleReturnableMete.equals(other$singleReturnableMete)) {
                                                                                       Object this$singleReturnableLength = this.getSingleReturnableLength();
                                                                                       Object other$singleReturnableLength = other.getSingleReturnableLength();
                                                                                       if (this$singleReturnableLength == null
                                                                                          ? other$singleReturnableLength == null
                                                                                          : this$singleReturnableLength.equals(other$singleReturnableLength)) {
                                                                                          Object this$unitNet = this.getUnitNet();
                                                                                          Object other$unitNet = other.getUnitNet();
                                                                                          if (this$unitNet == null
                                                                                             ? other$unitNet == null
                                                                                             : this$unitNet.equals(other$unitNet)) {
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
                                                                                                         : this$theoryThickness.equals(other$theoryThickness)) {
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
                                                                                                                  Object this$outboundSn = this.getOutboundSn();
                                                                                                                  Object other$outboundSn = other.getOutboundSn();
                                                                                                                  if (this$outboundSn == null
                                                                                                                     ? other$outboundSn == null
                                                                                                                     : this$outboundSn.equals(other$outboundSn)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$recipientName = this.getRecipientName();
                                                                                                                     Object other$recipientName = other.getRecipientName();
                                                                                                                     if (this$recipientName == null
                                                                                                                        ? other$recipientName == null
                                                                                                                        : this$recipientName.equals(
                                                                                                                           other$recipientName
                                                                                                                        )) {
                                                                                                                        Object this$outboundTime = this.getOutboundTime();
                                                                                                                        Object other$outboundTime = other.getOutboundTime();
                                                                                                                        if (this$outboundTime == null
                                                                                                                           ? other$outboundTime == null
                                                                                                                           : this$outboundTime.equals(
                                                                                                                              other$outboundTime
                                                                                                                           )) {
                                                                                                                           Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                                           Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                                           if (this$weightedAverageSpec == null
                                                                                                                              ? other$weightedAverageSpec
                                                                                                                                 == null
                                                                                                                              : this$weightedAverageSpec.equals(
                                                                                                                                 other$weightedAverageSpec
                                                                                                                              )) {
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
                                                                                                                                    Object this$taxRate = this.getTaxRate();
                                                                                                                                    Object other$taxRate = other.getTaxRate();
                                                                                                                                    if (this$taxRate == null
                                                                                                                                       ? other$taxRate == null
                                                                                                                                       : this$taxRate.equals(
                                                                                                                                          other$taxRate
                                                                                                                                       )) {
                                                                                                                                       Object this$classifyName = this.getClassifyName();
                                                                                                                                       Object other$classifyName = other.getClassifyName();
                                                                                                                                       if (this$classifyName
                                                                                                                                             == null
                                                                                                                                          ? other$classifyName
                                                                                                                                             == null
                                                                                                                                          : this$classifyName.equals(
                                                                                                                                             other$classifyName
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
                                                                                                                                                   Object this$materialSn = this.getMaterialSn();
                                                                                                                                                   Object other$materialSn = other.getMaterialSn();
                                                                                                                                                   if (this$materialSn
                                                                                                                                                         == null
                                                                                                                                                      ? other$materialSn
                                                                                                                                                         == null
                                                                                                                                                      : this$materialSn.equals(
                                                                                                                                                         other$materialSn
                                                                                                                                                      )) {
                                                                                                                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                                                      if (this$accountingUnit
                                                                                                                                                            == null
                                                                                                                                                         ? other$accountingUnit
                                                                                                                                                            == null
                                                                                                                                                         : this$accountingUnit.equals(
                                                                                                                                                            other$accountingUnit
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
                                                                                                                                                                        return this$amountExcludingVatNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$amountExcludingVatNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           : this$amountExcludingVatNoFreight.equals(
                                                                                                                                                                              other$amountExcludingVatNoFreight
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MaterialReturnable;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $boolReviewPending = this.getBoolReviewPending();
      result = result * 59 + ($boolReviewPending == null ? 43 : $boolReviewPending.hashCode());
      Object $boolReturn = this.getBoolReturn();
      result = result * 59 + ($boolReturn == null ? 43 : $boolReturn.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $returnableMete = this.getReturnableMete();
      result = result * 59 + ($returnableMete == null ? 43 : $returnableMete.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $singleReturnableMete = this.getSingleReturnableMete();
      result = result * 59 + ($singleReturnableMete == null ? 43 : $singleReturnableMete.hashCode());
      Object $singleReturnableLength = this.getSingleReturnableLength();
      result = result * 59 + ($singleReturnableLength == null ? 43 : $singleReturnableLength.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
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
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      return result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
   }

   public static class MaterialReturnableBuilder {
      private Long id;
      private Long classifyId;
      private Integer materialIsWhole;
      private Boolean boolPartyA;
      private Integer outboundUnitType;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal returnableMete;
      private BigDecimal singleMete;
      private BigDecimal singleReturnableMete;
      private BigDecimal singleReturnableLength;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long projectId;
      private Long outboundId;
      private String outboundSn;
      private Long warehouseId;
      private Long recipientId;
      private String recipientName;
      private LocalDateTime outboundTime;
      private String weightedAverageSpec;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private Long outboundDetailId;
      private Boolean boolReviewPending;
      private Boolean boolReturn;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private String classifyName;
      private Long standardId;
      private String standardName;
      private BigDecimal oneTheoryWeight;
      private BigDecimal sectionSteelWeight;
      private String materialSn;
      private String accountingUnit;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private Long sourceWorkshopId;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private Integer outboundTypeSelection;
      private Long areaBatchId;

      MaterialReturnableBuilder() {
      }

      @JsonProperty("id")
      public MaterialReturnable.MaterialReturnableBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public MaterialReturnable.MaterialReturnableBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public MaterialReturnable.MaterialReturnableBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MaterialReturnable.MaterialReturnableBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public MaterialReturnable.MaterialReturnableBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("basicClass")
      public MaterialReturnable.MaterialReturnableBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public MaterialReturnable.MaterialReturnableBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("mete")
      public MaterialReturnable.MaterialReturnableBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public MaterialReturnable.MaterialReturnableBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("returnableMete")
      public MaterialReturnable.MaterialReturnableBuilder returnableMete(final BigDecimal returnableMete) {
         this.returnableMete = returnableMete;
         return this;
      }

      @JsonProperty("singleMete")
      public MaterialReturnable.MaterialReturnableBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      @JsonProperty("singleReturnableMete")
      public MaterialReturnable.MaterialReturnableBuilder singleReturnableMete(final BigDecimal singleReturnableMete) {
         this.singleReturnableMete = singleReturnableMete;
         return this;
      }

      @JsonProperty("singleReturnableLength")
      public MaterialReturnable.MaterialReturnableBuilder singleReturnableLength(final BigDecimal singleReturnableLength) {
         this.singleReturnableLength = singleReturnableLength;
         return this;
      }

      @JsonProperty("unitNet")
      public MaterialReturnable.MaterialReturnableBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("length")
      public MaterialReturnable.MaterialReturnableBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public MaterialReturnable.MaterialReturnableBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public MaterialReturnable.MaterialReturnableBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public MaterialReturnable.MaterialReturnableBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public MaterialReturnable.MaterialReturnableBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MaterialReturnable.MaterialReturnableBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public MaterialReturnable.MaterialReturnableBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("projectId")
      public MaterialReturnable.MaterialReturnableBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("outboundId")
      public MaterialReturnable.MaterialReturnableBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("outboundSn")
      public MaterialReturnable.MaterialReturnableBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      @JsonProperty("warehouseId")
      public MaterialReturnable.MaterialReturnableBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("recipientId")
      public MaterialReturnable.MaterialReturnableBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("recipientName")
      public MaterialReturnable.MaterialReturnableBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      @JsonProperty("outboundTime")
      public MaterialReturnable.MaterialReturnableBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("weightedAverageSpec")
      public MaterialReturnable.MaterialReturnableBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      @JsonProperty("unitPrice")
      public MaterialReturnable.MaterialReturnableBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public MaterialReturnable.MaterialReturnableBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("outboundDetailId")
      public MaterialReturnable.MaterialReturnableBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      @JsonProperty("boolReviewPending")
      public MaterialReturnable.MaterialReturnableBuilder boolReviewPending(final Boolean boolReviewPending) {
         this.boolReviewPending = boolReviewPending;
         return this;
      }

      @JsonProperty("boolReturn")
      public MaterialReturnable.MaterialReturnableBuilder boolReturn(final Boolean boolReturn) {
         this.boolReturn = boolReturn;
         return this;
      }

      @JsonProperty("invoiceType")
      public MaterialReturnable.MaterialReturnableBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public MaterialReturnable.MaterialReturnableBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("classifyName")
      public MaterialReturnable.MaterialReturnableBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("standardId")
      public MaterialReturnable.MaterialReturnableBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MaterialReturnable.MaterialReturnableBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public MaterialReturnable.MaterialReturnableBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public MaterialReturnable.MaterialReturnableBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("materialSn")
      public MaterialReturnable.MaterialReturnableBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("accountingUnit")
      public MaterialReturnable.MaterialReturnableBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("monomerId")
      public MaterialReturnable.MaterialReturnableBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MaterialReturnable.MaterialReturnableBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public MaterialReturnable.MaterialReturnableBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("amount")
      public MaterialReturnable.MaterialReturnableBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public MaterialReturnable.MaterialReturnableBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("sourceWorkshopId")
      public MaterialReturnable.MaterialReturnableBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public MaterialReturnable.MaterialReturnableBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public MaterialReturnable.MaterialReturnableBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public MaterialReturnable.MaterialReturnableBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public MaterialReturnable.MaterialReturnableBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundTypeSelection")
      public MaterialReturnable.MaterialReturnableBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MaterialReturnable.MaterialReturnableBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public MaterialReturnable build() {
         return new MaterialReturnable(
            this.id,
            this.classifyId,
            this.materialIsWhole,
            this.boolPartyA,
            this.outboundUnitType,
            this.basicClass,
            this.specification,
            this.mete,
            this.quantity,
            this.returnableMete,
            this.singleMete,
            this.singleReturnableMete,
            this.singleReturnableLength,
            this.unitNet,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.projectId,
            this.outboundId,
            this.outboundSn,
            this.warehouseId,
            this.recipientId,
            this.recipientName,
            this.outboundTime,
            this.weightedAverageSpec,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.outboundDetailId,
            this.boolReviewPending,
            this.boolReturn,
            this.invoiceType,
            this.taxRate,
            this.classifyName,
            this.standardId,
            this.standardName,
            this.oneTheoryWeight,
            this.sectionSteelWeight,
            this.materialSn,
            this.accountingUnit,
            this.monomerId,
            this.areaId,
            this.workshopId,
            this.amount,
            this.amountExcludingVat,
            this.sourceWorkshopId,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.outboundTypeSelection,
            this.areaBatchId
         );
      }

      @Override
      public String toString() {
         return "MaterialReturnable.MaterialReturnableBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", returnableMete="
            + this.returnableMete
            + ", singleMete="
            + this.singleMete
            + ", singleReturnableMete="
            + this.singleReturnableMete
            + ", singleReturnableLength="
            + this.singleReturnableLength
            + ", unitNet="
            + this.unitNet
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
            + ", projectId="
            + this.projectId
            + ", outboundId="
            + this.outboundId
            + ", outboundSn="
            + this.outboundSn
            + ", warehouseId="
            + this.warehouseId
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", outboundTime="
            + this.outboundTime
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", boolReviewPending="
            + this.boolReviewPending
            + ", boolReturn="
            + this.boolReturn
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", classifyName="
            + this.classifyName
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", materialSn="
            + this.materialSn
            + ", accountingUnit="
            + this.accountingUnit
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workshopId="
            + this.workshopId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", areaBatchId="
            + this.areaBatchId
            + ")";
      }
   }
}
