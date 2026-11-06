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

@ApiModel(value = "InboundDetail对象", description = "入库物料详情表 ")
@Entity
@TableName("wms_inbound_detail")
@Table(name = "wms_inbound_detail")
public class InboundDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inboundId", value = "入库单ID", notes = "入库单ID")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id", columnDefinition = "bigint  COMMENT '入库单ID'", nullable = true)
   private Long inboundId;
   @ApiModelProperty(name = "purchaseId", value = "采购订单ID", notes = "采购订单ID")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '采购订单ID'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "applyPurchaseId", value = "申购订单ID", notes = "申购订单ID")
   @JsonProperty("applyPurchaseId")
   @JSONField(name = "applyPurchaseId")
   @TableField("apply_purchase_id")
   @Column(name = "apply_purchase_id", columnDefinition = "bigint  COMMENT '申购订单ID'", nullable = true)
   private Long applyPurchaseId;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)", notes = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率(百分比)'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [InvoiceTypeEnum]", notes = "发票类型 [InvoiceTypeEnum]")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型 [InvoiceTypeEnum]'", nullable = true)
   private Integer invoiceType;
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
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,3)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "theoryWeight", value = "理论重量", notes = "理论重量")
   @JsonProperty("theoryWeight")
   @JSONField(name = "theoryWeight")
   @TableField("theory_weight")
   @Column(name = "theory_weight", columnDefinition = "decimal(32,8)  COMMENT '理论重量'", nullable = true)
   private BigDecimal theoryWeight;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
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
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(128)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(256)  COMMENT '规格'", nullable = true)
   private String specification;
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
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT '核算精度'", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度", notes = "计量精度")
   @JsonProperty("measurePrecision")
   @JSONField(name = "measurePrecision")
   @TableField("measure_precision")
   @Column(name = "measure_precision", columnDefinition = "int  COMMENT '计量精度'", nullable = true)
   private Integer measurePrecision;
   @ApiModelProperty(name = "mete", value = "核算量(在计量单位未设置时,数量=核算量)", notes = "核算量(在计量单位未设置时,数量=核算量)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量(在计量单位未设置时,数量=核算量)'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式[参考枚举 MeasureEnum]", notes = "重量计量方式[参考枚举 MeasureEnum]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式[参考枚举 MeasureEnum]'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID -> wms", notes = "仓库位置ID -> wms")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID -> wms'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amount", value = "入库总价 含税", notes = "入库总价 含税")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '入库总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "printStatus", value = "打印状态 [0 没有打印,1 已打印]", notes = "打印状态 [0 没有打印,1 已打印]")
   @JsonProperty("printStatus")
   @JSONField(name = "printStatus")
   @TableField("print_status")
   @Column(name = "print_status", columnDefinition = "tinyint(1) default '0' COMMENT '打印状态 [0 没有打印,1 已打印]'", nullable = true)
   private Boolean printStatus;
   @ApiModelProperty(name = "gasReturnStatus", value = "是否有退货 [0 没有退货,1 有退货]", notes = "是否有退货 [0 没有退货,1 有退货]")
   @JsonProperty("gasReturnStatus")
   @JSONField(name = "gasReturnStatus")
   @TableField("gas_return_status")
   @Column(name = "gas_return_status", columnDefinition = "tinyint(1) default '0' COMMENT '是否有退货 [0 没有退货,1 有退货]'", nullable = true)
   private Boolean gasReturnStatus;
   @ApiModelProperty(name = "inboundTime", value = "入库时间", notes = "入库时间")
   @JsonProperty("inboundTime")
   @JSONField(name = "inboundTime")
   @TableField("inbound_time")
   @Column(name = "inbound_time", columnDefinition = "datetime  COMMENT '入库时间'", nullable = true)
   private LocalDateTime inboundTime;
   @ApiModelProperty(name = "sectionSteelSpecIds", value = "型材规格ID集", notes = "型材规格ID集")
   @JsonProperty("sectionSteelSpecIds")
   @JSONField(name = "sectionSteelSpecIds")
   @TableField("section_steel_spec_ids")
   @Column(name = "section_steel_spec_ids", columnDefinition = "varchar(255)  COMMENT '型材规格ID集'", nullable = true)
   private String sectionSteelSpecIds;
   @ApiModelProperty(name = "specificationIds", value = "规格ID集", notes = "规格ID集")
   @JsonProperty("specificationIds")
   @JSONField(name = "specificationIds")
   @TableField("specification_ids")
   @Column(name = "specification_ids", columnDefinition = "varchar(255)  COMMENT '规格ID集'", nullable = true)
   private String specificationIds;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   @JsonProperty("scale")
   @JSONField(name = "scale")
   @TableField("scale")
   @Column(name = "scale", columnDefinition = "int  COMMENT '小数保留位数'", nullable = true)
   private Integer scale;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量", notes = "退货核算量")
   @JsonProperty("rejectMete")
   @JSONField(name = "rejectMete")
   @TableField("reject_mete")
   @Column(name = "reject_mete", columnDefinition = "decimal(32,8)  COMMENT '退货核算量'", nullable = true)
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "rejectQuantity", value = "退货计量量", notes = "退货计量量")
   @JsonProperty("rejectQuantity")
   @JSONField(name = "rejectQuantity")
   @TableField("reject_quantity")
   @Column(name = "reject_quantity", columnDefinition = "decimal(32,8)  COMMENT '退货计量量'", nullable = true)
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectReviewMete", value = "退货审核中核算", notes = "退货审核中核算")
   @JsonProperty("rejectReviewMete")
   @JSONField(name = "rejectReviewMete")
   @TableField("reject_review_mete")
   @Column(name = "reject_review_mete", columnDefinition = "decimal(32,8)  COMMENT '退货审核中核算'", nullable = true)
   private BigDecimal rejectReviewMete;
   @ApiModelProperty(name = "rejectReviewQuantity", value = "退货审核中计量", notes = "退货审核中计量")
   @JsonProperty("rejectReviewQuantity")
   @JSONField(name = "rejectReviewQuantity")
   @TableField("reject_review_quantity")
   @Column(name = "reject_review_quantity", columnDefinition = "decimal(32,8)  COMMENT '退货审核中计量'", nullable = true)
   private BigDecimal rejectReviewQuantity;
   @ApiModelProperty(name = "rejectStatus", value = "退货状态 [RejectEnum]", notes = "退货状态 [RejectEnum]")
   @JsonProperty("rejectStatus")
   @JSONField(name = "rejectStatus")
   @TableField("reject_status")
   @Column(name = "reject_status", columnDefinition = "int  COMMENT '退货状态 [RejectEnum]'", nullable = true)
   private Integer rejectStatus;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
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
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供", notes = "是否甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量", notes = "单件理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(32,8)  COMMENT '单件理论重量'", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材国标重量", notes = "型材国标重量")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(19,2)  COMMENT '型材国标重量'", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "sectionSteelSpecId", value = "型材库规格ID", notes = "型材库规格ID")
   @JsonProperty("sectionSteelSpecId")
   @JSONField(name = "sectionSteelSpecId")
   @TableField("section_steel_spec_id")
   @Column(name = "section_steel_spec_id", columnDefinition = "bigint  COMMENT '型材库规格ID'", nullable = true)
   private Long sectionSteelSpecId;
   @ApiModelProperty(name = "sectionSteelSpec", value = "型材规格", notes = "型材规格")
   @JsonProperty("sectionSteelSpec")
   @JSONField(name = "sectionSteelSpec")
   @TableField("section_steel_spec")
   @Column(name = "section_steel_spec", columnDefinition = "varchar(255)  COMMENT '型材规格'", nullable = true)
   private String sectionSteelSpec;
   @ApiModelProperty(name = "doNotSectionSteelSpec", value = "除去型材规格外的 规格", notes = "除去型材规格外的 规格")
   @JsonProperty("doNotSectionSteelSpec")
   @JSONField(name = "doNotSectionSteelSpec")
   @TableField("do_not_section_steel_spec")
   @Column(name = "do_not_section_steel_spec", columnDefinition = "varchar(255)  COMMENT '除去型材规格外的 规格'", nullable = true)
   private String doNotSectionSteelSpec;
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
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "qualityTestingEnum", value = "质检状态[对单条物料进行质检] QualityTestingEnum", notes = "质检状态[对单条物料进行质检] QualityTestingEnum")
   @JsonProperty("qualityTestingEnum")
   @JSONField(name = "qualityTestingEnum")
   @TableField("quality_testing_enum")
   @Column(name = "quality_testing_enum", columnDefinition = "int default '16' COMMENT '质检状态[对单条物料进行质检] QualityTestingEnum'", nullable = true)
   private Integer qualityTestingEnum;
   @ApiModelProperty(name = "barcode", value = "条形码", notes = "条形码")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode", columnDefinition = "varchar(255)  COMMENT '条形码'", nullable = true)
   private String barcode;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "purchaseOrderDetailId")
   @JsonProperty("purchaseOrderDetailId")
   @JSONField(name = "purchaseOrderDetailId")
   @TableField("purchase_order_detail_id")
   @Column(name = "purchase_order_detail_id", columnDefinition = "bigint  COMMENT '采购详情ID'", nullable = true)
   private Long purchaseOrderDetailId;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件/围护ID", notes = "构件/围护ID")
   @JsonProperty("artifactEnclosureId")
   @JSONField(name = "artifactEnclosureId")
   @TableField("artifact_enclosure_id")
   @Column(name = "artifact_enclosure_id", columnDefinition = "bigint  COMMENT '构件/围护ID'", nullable = true)
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "mergeId", value = "合并标识", notes = "合并标识")
   @JsonProperty("mergeId")
   @JSONField(name = "mergeId")
   @TableField("merge_id")
   @Column(name = "merge_id", columnDefinition = "bigint  COMMENT '合并标识'", nullable = true)
   private Long mergeId;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价不含运费", notes = "不含税总价不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价不含运费", notes = "不含税单价不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含运费不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税不含运费", notes = "进项税不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_VAT_no_freight")
   @Column(name = "input_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价不含运费", notes = "含税单价不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税单价不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "入库总价含税 不含运费", notes = "入库总价含税 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库总价含税 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   @JsonProperty("boolNestSurplus")
   @JSONField(name = "boolNestSurplus")
   @TableField("bool_nest_surplus")
   @Column(name = "bool_nest_surplus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '柏楚余料'", nullable = true)
   private Boolean boolNestSurplus;
   @ApiModelProperty(name = "area", value = "柏楚余料面积", notes = "柏楚余料面积")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "decimal(32,12)  COMMENT ' 柏楚余料面积'", nullable = true)
   private BigDecimal area;
   @ApiModelProperty(name = "nestSurplusCode", value = "余料编码，拍照保存的时候就生成", notes = "拍照保存的时候就生成")
   @JsonProperty("nestSurplusCode")
   @JSONField(name = "nestSurplusCode")
   @TableField("nest_surplus_code")
   @Column(name = "nest_surplus_code", columnDefinition = "varchar(255)  COMMENT '余料编码，拍照保存的时候就生成'", nullable = true)
   private String nestSurplusCode;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
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
   @ApiModelProperty(name = "steelDensity", value = "钢材密度", notes = "钢材密度")
   @JsonProperty("steelDensity")
   @JSONField(name = "steelDensity")
   @TableField("steel_density")
   @Column(name = "steel_density", columnDefinition = "decimal(10,5)  COMMENT '钢材密度'", nullable = true)
   private BigDecimal steelDensity;
   @ApiModelProperty(name = "realTime", value = "实际时间")
   @JsonProperty("realTime")
   @JSONField(name = "realTime")
   @TableField("real_time")
   @Column(name = "real_time")
   private LocalDateTime realTime;
   @ApiModelProperty(name = "wapId", value = "加权价ID", notes = "加权价ID")
   @JsonProperty("wapId")
   @JSONField(name = "wapId")
   @TableField("wap_id")
   @Column(name = "wap_id", columnDefinition = "bigint(20)  COMMENT '加权价ID'", nullable = true)
   private Long wapId;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态[1 待审核,2 审核通过, 15 该出库单已被删除]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;
   @ApiModelProperty(name = "materialInventoryId", value = "物料池ID", notes = "物料池ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_Inventory_id")
   @Column(name = "material_Inventory_id", columnDefinition = "bigint  COMMENT '物料池ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)", notes = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  default '1' COMMENT '物料状态(1 整料, 余料)'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "MaterialCodeConfigId")
   @JsonProperty("MaterialCodeConfigId")
   @JSONField(name = "MaterialCodeConfigId")
   @TableField("material_code_config_id")
   @Column(name = "material_code_config_id", columnDefinition = "varchar(255)  COMMENT '物料编码id（中南）'", nullable = true)
   private Long MaterialCodeConfigId;

   public static InboundDetail.InboundDetailBuilder builder() {
      return new InboundDetail.InboundDetailBuilder();
   }

   public InboundDetail() {
   }

   public InboundDetail(
      final Long id,
      final Long inboundId,
      final Long purchaseId,
      final Long applyPurchaseId,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer basicClass,
      final Long classifyId,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal theoryWeight,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final String specification,
      final String color,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal unitNet,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final BigDecimal mete,
      final Integer weightMeasurementMode,
      final Long warehouseId,
      final Long projectId,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final String remark,
      final Boolean printStatus,
      final Boolean gasReturnStatus,
      final LocalDateTime inboundTime,
      final String sectionSteelSpecIds,
      final String specificationIds,
      final Integer scale,
      final BigDecimal rejectMete,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectReviewMete,
      final BigDecimal rejectReviewQuantity,
      final Integer rejectStatus,
      final String classifyName,
      final Long standardId,
      final String standardName,
      final Boolean boolPartyA,
      final BigDecimal oneTheoryWeight,
      final BigDecimal sectionSteelWeight,
      final Long sectionSteelSpecId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final Long monomerId,
      final Long areaId,
      final String materialSn,
      final Integer qualityTestingEnum,
      final String barcode,
      final Long workshopId,
      final Long purchaseOrderDetailId,
      final Long artifactEnclosureId,
      final Long mergeId,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountNoFreight,
      final Boolean boolNestSurplus,
      final BigDecimal area,
      final String nestSurplusCode,
      final String surplusSn,
      final String dxfUrl,
      final String imgUrl,
      final BigDecimal steelDensity,
      final LocalDateTime realTime,
      final Long wapId,
      final Integer reviewStatus,
      final Long materialInventoryId,
      final Integer materialIsWhole,
      final Long MaterialCodeConfigId
   ) {
      this.id = id;
      this.inboundId = inboundId;
      this.purchaseId = purchaseId;
      this.applyPurchaseId = applyPurchaseId;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.theoryWeight = theoryWeight;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.mete = mete;
      this.weightMeasurementMode = weightMeasurementMode;
      this.warehouseId = warehouseId;
      this.projectId = projectId;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.remark = remark;
      this.printStatus = printStatus;
      this.gasReturnStatus = gasReturnStatus;
      this.inboundTime = inboundTime;
      this.sectionSteelSpecIds = sectionSteelSpecIds;
      this.specificationIds = specificationIds;
      this.scale = scale;
      this.rejectMete = rejectMete;
      this.rejectQuantity = rejectQuantity;
      this.rejectReviewMete = rejectReviewMete;
      this.rejectReviewQuantity = rejectReviewQuantity;
      this.rejectStatus = rejectStatus;
      this.classifyName = classifyName;
      this.standardId = standardId;
      this.standardName = standardName;
      this.boolPartyA = boolPartyA;
      this.oneTheoryWeight = oneTheoryWeight;
      this.sectionSteelWeight = sectionSteelWeight;
      this.sectionSteelSpecId = sectionSteelSpecId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.materialSn = materialSn;
      this.qualityTestingEnum = qualityTestingEnum;
      this.barcode = barcode;
      this.workshopId = workshopId;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.artifactEnclosureId = artifactEnclosureId;
      this.mergeId = mergeId;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.boolNestSurplus = boolNestSurplus;
      this.area = area;
      this.nestSurplusCode = nestSurplusCode;
      this.surplusSn = surplusSn;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.steelDensity = steelDensity;
      this.realTime = realTime;
      this.wapId = wapId;
      this.reviewStatus = reviewStatus;
      this.materialInventoryId = materialInventoryId;
      this.materialIsWhole = materialIsWhole;
      this.MaterialCodeConfigId = MaterialCodeConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
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

   public BigDecimal getTheoryWeight() {
      return this.theoryWeight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getPrintStatus() {
      return this.printStatus;
   }

   public Boolean getGasReturnStatus() {
      return this.gasReturnStatus;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public String getSectionSteelSpecIds() {
      return this.sectionSteelSpecIds;
   }

   public String getSpecificationIds() {
      return this.specificationIds;
   }

   public Integer getScale() {
      return this.scale;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectReviewMete() {
      return this.rejectReviewMete;
   }

   public BigDecimal getRejectReviewQuantity() {
      return this.rejectReviewQuantity;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
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

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public Long getSectionSteelSpecId() {
      return this.sectionSteelSpecId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public Long getMergeId() {
      return this.mergeId;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getInputVatNoFreight() {
      return this.inputVatNoFreight;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getNestSurplusCode() {
      return this.nestSurplusCode;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getMaterialCodeConfigId() {
      return this.MaterialCodeConfigId;
   }

   @JsonProperty("id")
   public InboundDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inboundId")
   public InboundDetail setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("purchaseId")
   public InboundDetail setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("applyPurchaseId")
   public InboundDetail setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
      return this;
   }

   @JsonProperty("taxRate")
   public InboundDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("invoiceType")
   public InboundDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("basicClass")
   public InboundDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public InboundDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("length")
   public InboundDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public InboundDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public InboundDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public InboundDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("theoryWeight")
   public InboundDetail setTheoryWeight(final BigDecimal theoryWeight) {
      this.theoryWeight = theoryWeight;
      return this;
   }

   @JsonProperty("quantity")
   public InboundDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("brand")
   public InboundDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public InboundDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("specification")
   public InboundDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("color")
   public InboundDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("measureUnit")
   public InboundDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingUnit")
   public InboundDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("unitNet")
   public InboundDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public InboundDetail setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("measurePrecision")
   public InboundDetail setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("mete")
   public InboundDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public InboundDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("warehouseId")
   public InboundDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("projectId")
   public InboundDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public InboundDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public InboundDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public InboundDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public InboundDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amount")
   public InboundDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("remark")
   public InboundDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("printStatus")
   public InboundDetail setPrintStatus(final Boolean printStatus) {
      this.printStatus = printStatus;
      return this;
   }

   @JsonProperty("gasReturnStatus")
   public InboundDetail setGasReturnStatus(final Boolean gasReturnStatus) {
      this.gasReturnStatus = gasReturnStatus;
      return this;
   }

   @JsonProperty("inboundTime")
   public InboundDetail setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
      return this;
   }

   @JsonProperty("sectionSteelSpecIds")
   public InboundDetail setSectionSteelSpecIds(final String sectionSteelSpecIds) {
      this.sectionSteelSpecIds = sectionSteelSpecIds;
      return this;
   }

   @JsonProperty("specificationIds")
   public InboundDetail setSpecificationIds(final String specificationIds) {
      this.specificationIds = specificationIds;
      return this;
   }

   @JsonProperty("scale")
   public InboundDetail setScale(final Integer scale) {
      this.scale = scale;
      return this;
   }

   @JsonProperty("rejectMete")
   public InboundDetail setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
      return this;
   }

   @JsonProperty("rejectQuantity")
   public InboundDetail setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
      return this;
   }

   @JsonProperty("rejectReviewMete")
   public InboundDetail setRejectReviewMete(final BigDecimal rejectReviewMete) {
      this.rejectReviewMete = rejectReviewMete;
      return this;
   }

   @JsonProperty("rejectReviewQuantity")
   public InboundDetail setRejectReviewQuantity(final BigDecimal rejectReviewQuantity) {
      this.rejectReviewQuantity = rejectReviewQuantity;
      return this;
   }

   @JsonProperty("rejectStatus")
   public InboundDetail setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
      return this;
   }

   @JsonProperty("classifyName")
   public InboundDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("standardId")
   public InboundDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public InboundDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("boolPartyA")
   public InboundDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public InboundDetail setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("sectionSteelWeight")
   public InboundDetail setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   @JsonProperty("sectionSteelSpecId")
   public InboundDetail setSectionSteelSpecId(final Long sectionSteelSpecId) {
      this.sectionSteelSpecId = sectionSteelSpecId;
      return this;
   }

   @JsonProperty("sectionSteelSpec")
   public InboundDetail setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
      return this;
   }

   @JsonProperty("doNotSectionSteelSpec")
   public InboundDetail setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      return this;
   }

   @JsonProperty("monomerId")
   public InboundDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public InboundDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("materialSn")
   public InboundDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("qualityTestingEnum")
   public InboundDetail setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
      return this;
   }

   @JsonProperty("barcode")
   public InboundDetail setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("workshopId")
   public InboundDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("purchaseOrderDetailId")
   public InboundDetail setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public InboundDetail setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("mergeId")
   public InboundDetail setMergeId(final Long mergeId) {
      this.mergeId = mergeId;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public InboundDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public InboundDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public InboundDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public InboundDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public InboundDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("boolNestSurplus")
   public InboundDetail setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
      return this;
   }

   @JsonProperty("area")
   public InboundDetail setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("nestSurplusCode")
   public InboundDetail setNestSurplusCode(final String nestSurplusCode) {
      this.nestSurplusCode = nestSurplusCode;
      return this;
   }

   @JsonProperty("surplusSn")
   public InboundDetail setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   @JsonProperty("dxfUrl")
   public InboundDetail setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
      return this;
   }

   @JsonProperty("imgUrl")
   public InboundDetail setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
      return this;
   }

   @JsonProperty("steelDensity")
   public InboundDetail setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
      return this;
   }

   @JsonProperty("realTime")
   public InboundDetail setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @JsonProperty("wapId")
   public InboundDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("reviewStatus")
   public InboundDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public InboundDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public InboundDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("MaterialCodeConfigId")
   public InboundDetail setMaterialCodeConfigId(final Long MaterialCodeConfigId) {
      this.MaterialCodeConfigId = MaterialCodeConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "InboundDetail(id="
         + this.getId()
         + ", inboundId="
         + this.getInboundId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", theoryWeight="
         + this.getTheoryWeight()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", mete="
         + this.getMete()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", printStatus="
         + this.getPrintStatus()
         + ", gasReturnStatus="
         + this.getGasReturnStatus()
         + ", inboundTime="
         + this.getInboundTime()
         + ", sectionSteelSpecIds="
         + this.getSectionSteelSpecIds()
         + ", specificationIds="
         + this.getSpecificationIds()
         + ", scale="
         + this.getScale()
         + ", rejectMete="
         + this.getRejectMete()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectReviewMete="
         + this.getRejectReviewMete()
         + ", rejectReviewQuantity="
         + this.getRejectReviewQuantity()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", classifyName="
         + this.getClassifyName()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", sectionSteelSpecId="
         + this.getSectionSteelSpecId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", barcode="
         + this.getBarcode()
         + ", workshopId="
         + this.getWorkshopId()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", mergeId="
         + this.getMergeId()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", area="
         + this.getArea()
         + ", nestSurplusCode="
         + this.getNestSurplusCode()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", steelDensity="
         + this.getSteelDensity()
         + ", realTime="
         + this.getRealTime()
         + ", wapId="
         + this.getWapId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", MaterialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetail)) {
         return false;
      }

      InboundDetail other = (InboundDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundId = this.getInboundId();
         Object other$inboundId = other.getInboundId();
         if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$applyPurchaseId = this.getApplyPurchaseId();
               Object other$applyPurchaseId = other.getApplyPurchaseId();
               if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$classifyId = this.getClassifyId();
                        Object other$classifyId = other.getClassifyId();
                        if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                           Object this$accountingPrecision = this.getAccountingPrecision();
                           Object other$accountingPrecision = other.getAccountingPrecision();
                           if (this$accountingPrecision == null
                              ? other$accountingPrecision == null
                              : this$accountingPrecision.equals(other$accountingPrecision)) {
                              Object this$measurePrecision = this.getMeasurePrecision();
                              Object other$measurePrecision = other.getMeasurePrecision();
                              if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                 Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                 Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                 if (this$weightMeasurementMode == null
                                    ? other$weightMeasurementMode == null
                                    : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$projectId = this.getProjectId();
                                       Object other$projectId = other.getProjectId();
                                       if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                          Object this$printStatus = this.getPrintStatus();
                                          Object other$printStatus = other.getPrintStatus();
                                          if (this$printStatus == null ? other$printStatus == null : this$printStatus.equals(other$printStatus)) {
                                             Object this$gasReturnStatus = this.getGasReturnStatus();
                                             Object other$gasReturnStatus = other.getGasReturnStatus();
                                             if (this$gasReturnStatus == null
                                                ? other$gasReturnStatus == null
                                                : this$gasReturnStatus.equals(other$gasReturnStatus)) {
                                                Object this$scale = this.getScale();
                                                Object other$scale = other.getScale();
                                                if (this$scale == null ? other$scale == null : this$scale.equals(other$scale)) {
                                                   Object this$rejectStatus = this.getRejectStatus();
                                                   Object other$rejectStatus = other.getRejectStatus();
                                                   if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                                                      Object this$standardId = this.getStandardId();
                                                      Object other$standardId = other.getStandardId();
                                                      if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                         Object this$boolPartyA = this.getBoolPartyA();
                                                         Object other$boolPartyA = other.getBoolPartyA();
                                                         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                                            Object this$sectionSteelSpecId = this.getSectionSteelSpecId();
                                                            Object other$sectionSteelSpecId = other.getSectionSteelSpecId();
                                                            if (this$sectionSteelSpecId == null
                                                               ? other$sectionSteelSpecId == null
                                                               : this$sectionSteelSpecId.equals(other$sectionSteelSpecId)) {
                                                               Object this$monomerId = this.getMonomerId();
                                                               Object other$monomerId = other.getMonomerId();
                                                               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                                  Object this$areaId = this.getAreaId();
                                                                  Object other$areaId = other.getAreaId();
                                                                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                                     Object this$qualityTestingEnum = this.getQualityTestingEnum();
                                                                     Object other$qualityTestingEnum = other.getQualityTestingEnum();
                                                                     if (this$qualityTestingEnum == null
                                                                        ? other$qualityTestingEnum == null
                                                                        : this$qualityTestingEnum.equals(other$qualityTestingEnum)) {
                                                                        Object this$workshopId = this.getWorkshopId();
                                                                        Object other$workshopId = other.getWorkshopId();
                                                                        if (this$workshopId == null
                                                                           ? other$workshopId == null
                                                                           : this$workshopId.equals(other$workshopId)) {
                                                                           Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
                                                                           Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
                                                                           if (this$purchaseOrderDetailId == null
                                                                              ? other$purchaseOrderDetailId == null
                                                                              : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)) {
                                                                              Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                                                                              Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                                                                              if (this$artifactEnclosureId == null
                                                                                 ? other$artifactEnclosureId == null
                                                                                 : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                                                                                 Object this$mergeId = this.getMergeId();
                                                                                 Object other$mergeId = other.getMergeId();
                                                                                 if (this$mergeId == null
                                                                                    ? other$mergeId == null
                                                                                    : this$mergeId.equals(other$mergeId)) {
                                                                                    Object this$boolNestSurplus = this.getBoolNestSurplus();
                                                                                    Object other$boolNestSurplus = other.getBoolNestSurplus();
                                                                                    if (this$boolNestSurplus == null
                                                                                       ? other$boolNestSurplus == null
                                                                                       : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                                                                       Object this$wapId = this.getWapId();
                                                                                       Object other$wapId = other.getWapId();
                                                                                       if (this$wapId == null
                                                                                          ? other$wapId == null
                                                                                          : this$wapId.equals(other$wapId)) {
                                                                                          Object this$reviewStatus = this.getReviewStatus();
                                                                                          Object other$reviewStatus = other.getReviewStatus();
                                                                                          if (this$reviewStatus == null
                                                                                             ? other$reviewStatus == null
                                                                                             : this$reviewStatus.equals(other$reviewStatus)) {
                                                                                             Object this$materialInventoryId = this.getMaterialInventoryId();
                                                                                             Object other$materialInventoryId = other.getMaterialInventoryId();
                                                                                             if (this$materialInventoryId == null
                                                                                                ? other$materialInventoryId == null
                                                                                                : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                                                                Object this$materialIsWhole = this.getMaterialIsWhole();
                                                                                                Object other$materialIsWhole = other.getMaterialIsWhole();
                                                                                                if (this$materialIsWhole == null
                                                                                                   ? other$materialIsWhole == null
                                                                                                   : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                                                                   Object this$MaterialCodeConfigId = this.getMaterialCodeConfigId();
                                                                                                   Object other$MaterialCodeConfigId = other.getMaterialCodeConfigId();
                                                                                                   if (this$MaterialCodeConfigId == null
                                                                                                      ? other$MaterialCodeConfigId == null
                                                                                                      : this$MaterialCodeConfigId.equals(
                                                                                                         other$MaterialCodeConfigId
                                                                                                      )) {
                                                                                                      Object this$taxRate = this.getTaxRate();
                                                                                                      Object other$taxRate = other.getTaxRate();
                                                                                                      if (this$taxRate == null
                                                                                                         ? other$taxRate == null
                                                                                                         : this$taxRate.equals(other$taxRate)) {
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
                                                                                                                     : this$theoryThickness.equals(
                                                                                                                        other$theoryThickness
                                                                                                                     )) {
                                                                                                                     Object this$theoryWeight = this.getTheoryWeight();
                                                                                                                     Object other$theoryWeight = other.getTheoryWeight();
                                                                                                                     if (this$theoryWeight == null
                                                                                                                        ? other$theoryWeight == null
                                                                                                                        : this$theoryWeight.equals(
                                                                                                                           other$theoryWeight
                                                                                                                        )) {
                                                                                                                        Object this$quantity = this.getQuantity();
                                                                                                                        Object other$quantity = other.getQuantity();
                                                                                                                        if (this$quantity == null
                                                                                                                           ? other$quantity == null
                                                                                                                           : this$quantity.equals(
                                                                                                                              other$quantity
                                                                                                                           )) {
                                                                                                                           Object this$brand = this.getBrand();
                                                                                                                           Object other$brand = other.getBrand();
                                                                                                                           if (this$brand == null
                                                                                                                              ? other$brand == null
                                                                                                                              : this$brand.equals(other$brand)) {
                                                                                                                              Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                              Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                              if (this$heatNoAndBatchNo == null
                                                                                                                                 ? other$heatNoAndBatchNo
                                                                                                                                    == null
                                                                                                                                 : this$heatNoAndBatchNo.equals(
                                                                                                                                    other$heatNoAndBatchNo
                                                                                                                                 )) {
                                                                                                                                 Object this$specification = this.getSpecification();
                                                                                                                                 Object other$specification = other.getSpecification();
                                                                                                                                 if (this$specification == null
                                                                                                                                    ? other$specification
                                                                                                                                       == null
                                                                                                                                    : this$specification.equals(
                                                                                                                                       other$specification
                                                                                                                                    )) {
                                                                                                                                    Object this$color = this.getColor();
                                                                                                                                    Object other$color = other.getColor();
                                                                                                                                    if (this$color == null
                                                                                                                                       ? other$color == null
                                                                                                                                       : this$color.equals(
                                                                                                                                          other$color
                                                                                                                                       )) {
                                                                                                                                       Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                       Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                       if (this$measureUnit
                                                                                                                                             == null
                                                                                                                                          ? other$measureUnit
                                                                                                                                             == null
                                                                                                                                          : this$measureUnit.equals(
                                                                                                                                             other$measureUnit
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
                                                                                                                                             Object this$unitNet = this.getUnitNet();
                                                                                                                                             Object other$unitNet = other.getUnitNet();
                                                                                                                                             if (this$unitNet
                                                                                                                                                   == null
                                                                                                                                                ? other$unitNet
                                                                                                                                                   == null
                                                                                                                                                : this$unitNet.equals(
                                                                                                                                                   other$unitNet
                                                                                                                                                )) {
                                                                                                                                                Object this$mete = this.getMete();
                                                                                                                                                Object other$mete = other.getMete();
                                                                                                                                                if (this$mete
                                                                                                                                                      == null
                                                                                                                                                   ? other$mete
                                                                                                                                                      == null
                                                                                                                                                   : this$mete.equals(
                                                                                                                                                      other$mete
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
                                                                                                                                                      Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                                                                      Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                                                                      if (this$unitPriceExcludingVat
                                                                                                                                                            == null
                                                                                                                                                         ? other$unitPriceExcludingVat
                                                                                                                                                            == null
                                                                                                                                                         : this$unitPriceExcludingVat.equals(
                                                                                                                                                            other$unitPriceExcludingVat
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
                                                                                                                                                            Object this$unitPrice = this.getUnitPrice();
                                                                                                                                                            Object other$unitPrice = other.getUnitPrice();
                                                                                                                                                            if (this$unitPrice
                                                                                                                                                                  == null
                                                                                                                                                               ? other$unitPrice
                                                                                                                                                                  == null
                                                                                                                                                               : this$unitPrice.equals(
                                                                                                                                                                  other$unitPrice
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
                                                                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                                                                  if (this$remark
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$remark
                                                                                                                                                                        == null
                                                                                                                                                                     : this$remark.equals(
                                                                                                                                                                        other$remark
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$inboundTime = this.getInboundTime();
                                                                                                                                                                     Object other$inboundTime = other.getInboundTime();
                                                                                                                                                                     if (this$inboundTime
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$inboundTime
                                                                                                                                                                           == null
                                                                                                                                                                        : this$inboundTime.equals(
                                                                                                                                                                           other$inboundTime
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$sectionSteelSpecIds = this.getSectionSteelSpecIds();
                                                                                                                                                                        Object other$sectionSteelSpecIds = other.getSectionSteelSpecIds();
                                                                                                                                                                        if (this$sectionSteelSpecIds
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$sectionSteelSpecIds
                                                                                                                                                                              == null
                                                                                                                                                                           : this$sectionSteelSpecIds.equals(
                                                                                                                                                                              other$sectionSteelSpecIds
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$specificationIds = this.getSpecificationIds();
                                                                                                                                                                           Object other$specificationIds = other.getSpecificationIds();
                                                                                                                                                                           if (this$specificationIds
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$specificationIds
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$specificationIds.equals(
                                                                                                                                                                                 other$specificationIds
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$rejectMete = this.getRejectMete();
                                                                                                                                                                              Object other$rejectMete = other.getRejectMete();
                                                                                                                                                                              if (this$rejectMete
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$rejectMete
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$rejectMete.equals(
                                                                                                                                                                                    other$rejectMete
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                                                                                 Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                                                                                 if (this$rejectQuantity
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$rejectQuantity
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$rejectQuantity.equals(
                                                                                                                                                                                       other$rejectQuantity
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$rejectReviewMete = this.getRejectReviewMete();
                                                                                                                                                                                    Object other$rejectReviewMete = other.getRejectReviewMete();
                                                                                                                                                                                    if (this$rejectReviewMete
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$rejectReviewMete
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$rejectReviewMete.equals(
                                                                                                                                                                                          other$rejectReviewMete
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$rejectReviewQuantity = this.getRejectReviewQuantity();
                                                                                                                                                                                       Object other$rejectReviewQuantity = other.getRejectReviewQuantity();
                                                                                                                                                                                       if (this$rejectReviewQuantity
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$rejectReviewQuantity
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$rejectReviewQuantity.equals(
                                                                                                                                                                                             other$rejectReviewQuantity
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$classifyName = this.getClassifyName();
                                                                                                                                                                                          Object other$classifyName = other.getClassifyName();
                                                                                                                                                                                          if (this$classifyName
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$classifyName
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$classifyName.equals(
                                                                                                                                                                                                other$classifyName
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
                                                                                                                                                                                                Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                                                                                                                Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                                                                                                                if (this$oneTheoryWeight
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$oneTheoryWeight
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$oneTheoryWeight.equals(
                                                                                                                                                                                                      other$oneTheoryWeight
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$sectionSteelWeight = this.getSectionSteelWeight();
                                                                                                                                                                                                   Object other$sectionSteelWeight = other.getSectionSteelWeight();
                                                                                                                                                                                                   if (this$sectionSteelWeight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$sectionSteelWeight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$sectionSteelWeight.equals(
                                                                                                                                                                                                         other$sectionSteelWeight
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                                                                                                                      Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                                                                                                                      if (this$sectionSteelSpec
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$sectionSteelSpec
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$sectionSteelSpec.equals(
                                                                                                                                                                                                            other$sectionSteelSpec
                                                                                                                                                                                                         )
                                                                                                                                                                                                         )
                                                                                                                                                                                                       {
                                                                                                                                                                                                         Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                                                                                                                                         Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                                                                                                                                         if (this$doNotSectionSteelSpec
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$doNotSectionSteelSpec
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$doNotSectionSteelSpec.equals(
                                                                                                                                                                                                               other$doNotSectionSteelSpec
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
                                                                                                                                                                                                                                    Object this$nestSurplusCode = this.getNestSurplusCode();
                                                                                                                                                                                                                                    Object other$nestSurplusCode = other.getNestSurplusCode();
                                                                                                                                                                                                                                    if (this$nestSurplusCode
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       ? other$nestSurplusCode
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       : this$nestSurplusCode.equals(
                                                                                                                                                                                                                                          other$nestSurplusCode
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
                                                                                                                                                                                                                                                Object this$steelDensity = this.getSteelDensity();
                                                                                                                                                                                                                                                Object other$steelDensity = other.getSteelDensity();
                                                                                                                                                                                                                                                if (this$steelDensity
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   ? other$steelDensity
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   : this$steelDensity.equals(
                                                                                                                                                                                                                                                      other$steelDensity
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                   Object this$realTime = this.getRealTime();
                                                                                                                                                                                                                                                   Object other$realTime = other.getRealTime();
                                                                                                                                                                                                                                                   return this$realTime
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      ? other$realTime
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      : this$realTime.equals(
                                                                                                                                                                                                                                                         other$realTime
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
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof InboundDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $printStatus = this.getPrintStatus();
      result = result * 59 + ($printStatus == null ? 43 : $printStatus.hashCode());
      Object $gasReturnStatus = this.getGasReturnStatus();
      result = result * 59 + ($gasReturnStatus == null ? 43 : $gasReturnStatus.hashCode());
      Object $scale = this.getScale();
      result = result * 59 + ($scale == null ? 43 : $scale.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $sectionSteelSpecId = this.getSectionSteelSpecId();
      result = result * 59 + ($sectionSteelSpecId == null ? 43 : $sectionSteelSpecId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $mergeId = this.getMergeId();
      result = result * 59 + ($mergeId == null ? 43 : $mergeId.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $MaterialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($MaterialCodeConfigId == null ? 43 : $MaterialCodeConfigId.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $theoryWeight = this.getTheoryWeight();
      result = result * 59 + ($theoryWeight == null ? 43 : $theoryWeight.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $sectionSteelSpecIds = this.getSectionSteelSpecIds();
      result = result * 59 + ($sectionSteelSpecIds == null ? 43 : $sectionSteelSpecIds.hashCode());
      Object $specificationIds = this.getSpecificationIds();
      result = result * 59 + ($specificationIds == null ? 43 : $specificationIds.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectReviewMete = this.getRejectReviewMete();
      result = result * 59 + ($rejectReviewMete == null ? 43 : $rejectReviewMete.hashCode());
      Object $rejectReviewQuantity = this.getRejectReviewQuantity();
      result = result * 59 + ($rejectReviewQuantity == null ? 43 : $rejectReviewQuantity.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $nestSurplusCode = this.getNestSurplusCode();
      result = result * 59 + ($nestSurplusCode == null ? 43 : $nestSurplusCode.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $steelDensity = this.getSteelDensity();
      result = result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class InboundDetailBuilder {
      private Long id;
      private Long inboundId;
      private Long purchaseId;
      private Long applyPurchaseId;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer basicClass;
      private Long classifyId;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal theoryWeight;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private String specification;
      private String color;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal unitNet;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private BigDecimal mete;
      private Integer weightMeasurementMode;
      private Long warehouseId;
      private Long projectId;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private String remark;
      private Boolean printStatus;
      private Boolean gasReturnStatus;
      private LocalDateTime inboundTime;
      private String sectionSteelSpecIds;
      private String specificationIds;
      private Integer scale;
      private BigDecimal rejectMete;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectReviewMete;
      private BigDecimal rejectReviewQuantity;
      private Integer rejectStatus;
      private String classifyName;
      private Long standardId;
      private String standardName;
      private Boolean boolPartyA;
      private BigDecimal oneTheoryWeight;
      private BigDecimal sectionSteelWeight;
      private Long sectionSteelSpecId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private Long monomerId;
      private Long areaId;
      private String materialSn;
      private Integer qualityTestingEnum;
      private String barcode;
      private Long workshopId;
      private Long purchaseOrderDetailId;
      private Long artifactEnclosureId;
      private Long mergeId;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountNoFreight;
      private Boolean boolNestSurplus;
      private BigDecimal area;
      private String nestSurplusCode;
      private String surplusSn;
      private String dxfUrl;
      private String imgUrl;
      private BigDecimal steelDensity;
      private LocalDateTime realTime;
      private Long wapId;
      private Integer reviewStatus;
      private Long materialInventoryId;
      private Integer materialIsWhole;
      private Long MaterialCodeConfigId;

      InboundDetailBuilder() {
      }

      @JsonProperty("id")
      public InboundDetail.InboundDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inboundId")
      public InboundDetail.InboundDetailBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("purchaseId")
      public InboundDetail.InboundDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("applyPurchaseId")
      public InboundDetail.InboundDetailBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      @JsonProperty("taxRate")
      public InboundDetail.InboundDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public InboundDetail.InboundDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("basicClass")
      public InboundDetail.InboundDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public InboundDetail.InboundDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("length")
      public InboundDetail.InboundDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public InboundDetail.InboundDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public InboundDetail.InboundDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public InboundDetail.InboundDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("theoryWeight")
      public InboundDetail.InboundDetailBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      @JsonProperty("quantity")
      public InboundDetail.InboundDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("brand")
      public InboundDetail.InboundDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public InboundDetail.InboundDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("specification")
      public InboundDetail.InboundDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("color")
      public InboundDetail.InboundDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("measureUnit")
      public InboundDetail.InboundDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingUnit")
      public InboundDetail.InboundDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public InboundDetail.InboundDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public InboundDetail.InboundDetailBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("measurePrecision")
      public InboundDetail.InboundDetailBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("mete")
      public InboundDetail.InboundDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public InboundDetail.InboundDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("warehouseId")
      public InboundDetail.InboundDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("projectId")
      public InboundDetail.InboundDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public InboundDetail.InboundDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public InboundDetail.InboundDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public InboundDetail.InboundDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public InboundDetail.InboundDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amount")
      public InboundDetail.InboundDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("remark")
      public InboundDetail.InboundDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("printStatus")
      public InboundDetail.InboundDetailBuilder printStatus(final Boolean printStatus) {
         this.printStatus = printStatus;
         return this;
      }

      @JsonProperty("gasReturnStatus")
      public InboundDetail.InboundDetailBuilder gasReturnStatus(final Boolean gasReturnStatus) {
         this.gasReturnStatus = gasReturnStatus;
         return this;
      }

      @JsonProperty("inboundTime")
      public InboundDetail.InboundDetailBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      @JsonProperty("sectionSteelSpecIds")
      public InboundDetail.InboundDetailBuilder sectionSteelSpecIds(final String sectionSteelSpecIds) {
         this.sectionSteelSpecIds = sectionSteelSpecIds;
         return this;
      }

      @JsonProperty("specificationIds")
      public InboundDetail.InboundDetailBuilder specificationIds(final String specificationIds) {
         this.specificationIds = specificationIds;
         return this;
      }

      @JsonProperty("scale")
      public InboundDetail.InboundDetailBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      @JsonProperty("rejectMete")
      public InboundDetail.InboundDetailBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      @JsonProperty("rejectQuantity")
      public InboundDetail.InboundDetailBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      @JsonProperty("rejectReviewMete")
      public InboundDetail.InboundDetailBuilder rejectReviewMete(final BigDecimal rejectReviewMete) {
         this.rejectReviewMete = rejectReviewMete;
         return this;
      }

      @JsonProperty("rejectReviewQuantity")
      public InboundDetail.InboundDetailBuilder rejectReviewQuantity(final BigDecimal rejectReviewQuantity) {
         this.rejectReviewQuantity = rejectReviewQuantity;
         return this;
      }

      @JsonProperty("rejectStatus")
      public InboundDetail.InboundDetailBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      @JsonProperty("classifyName")
      public InboundDetail.InboundDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("standardId")
      public InboundDetail.InboundDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public InboundDetail.InboundDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("boolPartyA")
      public InboundDetail.InboundDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public InboundDetail.InboundDetailBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public InboundDetail.InboundDetailBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("sectionSteelSpecId")
      public InboundDetail.InboundDetailBuilder sectionSteelSpecId(final Long sectionSteelSpecId) {
         this.sectionSteelSpecId = sectionSteelSpecId;
         return this;
      }

      @JsonProperty("sectionSteelSpec")
      public InboundDetail.InboundDetailBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      @JsonProperty("doNotSectionSteelSpec")
      public InboundDetail.InboundDetailBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      @JsonProperty("monomerId")
      public InboundDetail.InboundDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public InboundDetail.InboundDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("materialSn")
      public InboundDetail.InboundDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("qualityTestingEnum")
      public InboundDetail.InboundDetailBuilder qualityTestingEnum(final Integer qualityTestingEnum) {
         this.qualityTestingEnum = qualityTestingEnum;
         return this;
      }

      @JsonProperty("barcode")
      public InboundDetail.InboundDetailBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("workshopId")
      public InboundDetail.InboundDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("purchaseOrderDetailId")
      public InboundDetail.InboundDetailBuilder purchaseOrderDetailId(final Long purchaseOrderDetailId) {
         this.purchaseOrderDetailId = purchaseOrderDetailId;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public InboundDetail.InboundDetailBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("mergeId")
      public InboundDetail.InboundDetailBuilder mergeId(final Long mergeId) {
         this.mergeId = mergeId;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public InboundDetail.InboundDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public InboundDetail.InboundDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public InboundDetail.InboundDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public InboundDetail.InboundDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public InboundDetail.InboundDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("boolNestSurplus")
      public InboundDetail.InboundDetailBuilder boolNestSurplus(final Boolean boolNestSurplus) {
         this.boolNestSurplus = boolNestSurplus;
         return this;
      }

      @JsonProperty("area")
      public InboundDetail.InboundDetailBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("nestSurplusCode")
      public InboundDetail.InboundDetailBuilder nestSurplusCode(final String nestSurplusCode) {
         this.nestSurplusCode = nestSurplusCode;
         return this;
      }

      @JsonProperty("surplusSn")
      public InboundDetail.InboundDetailBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("dxfUrl")
      public InboundDetail.InboundDetailBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      @JsonProperty("imgUrl")
      public InboundDetail.InboundDetailBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      @JsonProperty("steelDensity")
      public InboundDetail.InboundDetailBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      @JsonProperty("realTime")
      public InboundDetail.InboundDetailBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      @JsonProperty("wapId")
      public InboundDetail.InboundDetailBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("reviewStatus")
      public InboundDetail.InboundDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public InboundDetail.InboundDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public InboundDetail.InboundDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("MaterialCodeConfigId")
      public InboundDetail.InboundDetailBuilder MaterialCodeConfigId(final Long MaterialCodeConfigId) {
         this.MaterialCodeConfigId = MaterialCodeConfigId;
         return this;
      }

      public InboundDetail build() {
         return new InboundDetail(
            this.id,
            this.inboundId,
            this.purchaseId,
            this.applyPurchaseId,
            this.taxRate,
            this.invoiceType,
            this.basicClass,
            this.classifyId,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.theoryWeight,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.specification,
            this.color,
            this.measureUnit,
            this.accountingUnit,
            this.unitNet,
            this.accountingPrecision,
            this.measurePrecision,
            this.mete,
            this.weightMeasurementMode,
            this.warehouseId,
            this.projectId,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.amount,
            this.remark,
            this.printStatus,
            this.gasReturnStatus,
            this.inboundTime,
            this.sectionSteelSpecIds,
            this.specificationIds,
            this.scale,
            this.rejectMete,
            this.rejectQuantity,
            this.rejectReviewMete,
            this.rejectReviewQuantity,
            this.rejectStatus,
            this.classifyName,
            this.standardId,
            this.standardName,
            this.boolPartyA,
            this.oneTheoryWeight,
            this.sectionSteelWeight,
            this.sectionSteelSpecId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.monomerId,
            this.areaId,
            this.materialSn,
            this.qualityTestingEnum,
            this.barcode,
            this.workshopId,
            this.purchaseOrderDetailId,
            this.artifactEnclosureId,
            this.mergeId,
            this.amountExcludingVatNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.unitPriceNoFreight,
            this.amountNoFreight,
            this.boolNestSurplus,
            this.area,
            this.nestSurplusCode,
            this.surplusSn,
            this.dxfUrl,
            this.imgUrl,
            this.steelDensity,
            this.realTime,
            this.wapId,
            this.reviewStatus,
            this.materialInventoryId,
            this.materialIsWhole,
            this.MaterialCodeConfigId
         );
      }

      @Override
      public String toString() {
         return "InboundDetail.InboundDetailBuilder(id="
            + this.id
            + ", inboundId="
            + this.inboundId
            + ", purchaseId="
            + this.purchaseId
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", theoryWeight="
            + this.theoryWeight
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitNet="
            + this.unitNet
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", mete="
            + this.mete
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", warehouseId="
            + this.warehouseId
            + ", projectId="
            + this.projectId
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPrice="
            + this.unitPrice
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ", printStatus="
            + this.printStatus
            + ", gasReturnStatus="
            + this.gasReturnStatus
            + ", inboundTime="
            + this.inboundTime
            + ", sectionSteelSpecIds="
            + this.sectionSteelSpecIds
            + ", specificationIds="
            + this.specificationIds
            + ", scale="
            + this.scale
            + ", rejectMete="
            + this.rejectMete
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectReviewMete="
            + this.rejectReviewMete
            + ", rejectReviewQuantity="
            + this.rejectReviewQuantity
            + ", rejectStatus="
            + this.rejectStatus
            + ", classifyName="
            + this.classifyName
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", boolPartyA="
            + this.boolPartyA
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", sectionSteelSpecId="
            + this.sectionSteelSpecId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", materialSn="
            + this.materialSn
            + ", qualityTestingEnum="
            + this.qualityTestingEnum
            + ", barcode="
            + this.barcode
            + ", workshopId="
            + this.workshopId
            + ", purchaseOrderDetailId="
            + this.purchaseOrderDetailId
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", mergeId="
            + this.mergeId
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", boolNestSurplus="
            + this.boolNestSurplus
            + ", area="
            + this.area
            + ", nestSurplusCode="
            + this.nestSurplusCode
            + ", surplusSn="
            + this.surplusSn
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", steelDensity="
            + this.steelDensity
            + ", realTime="
            + this.realTime
            + ", wapId="
            + this.wapId
            + ", reviewStatus="
            + this.reviewStatus
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", MaterialCodeConfigId="
            + this.MaterialCodeConfigId
            + ")";
      }
   }
}
