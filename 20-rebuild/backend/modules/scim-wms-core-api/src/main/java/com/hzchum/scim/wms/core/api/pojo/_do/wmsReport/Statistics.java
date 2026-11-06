package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Statistics对象", description = "收发存表 按月记录不同加权价的物料信息")
@Entity
@TableName("wms_statistics")
@Table(name = "wms_statistics")
public class Statistics extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "wapId", value = "加权价ID", notes = "加权价ID")
   @JsonProperty("wapId")
   @JSONField(name = "wapId")
   @TableField("wap_id")
   @Column(name = "wap_id", columnDefinition = "bigint  COMMENT '加权价ID'", nullable = true)
   private Long wapId;
   @ApiModelProperty(name = "specs", value = "规格集 记录当前所有引用这条记录物料规格", notes = "规格集 记录当前所有引用这条记录物料规格")
   @JsonProperty("specs")
   @JSONField(name = "specs")
   @TableField("specs")
   @Column(name = "specs", columnDefinition = "text  COMMENT '规格集 记录当前所有引用这条记录物料规格'", nullable = true)
   private String specs;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT ''", nullable = true)
   private BigDecimal theoryThickness;
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
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "invoiceType", value = "收据类型", notes = "收据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '收据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "standardId", value = "国标ID", notes = "国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "国标名称", notes = "国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "totalQuantity", value = "物料总计量量", notes = "物料总计量量")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   @TableField("total_quantity")
   @Column(name = "total_quantity", columnDefinition = "decimal(32,8)  COMMENT '物料总计量量'", nullable = true)
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "totalMete", value = "物料总核算量", notes = "物料总核算量")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   @TableField("total_mete")
   @Column(name = "total_mete", columnDefinition = "decimal(32,8)  COMMENT '物料总核算量'", nullable = true)
   private BigDecimal totalMete;
   @ApiModelProperty(name = "inboundMete", value = "入库总核算", notes = "入库总核算")
   @JsonProperty("inboundMete")
   @JSONField(name = "inboundMete")
   @TableField(value = "inbound_mete", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_mete", columnDefinition = "decimal(32,8)  COMMENT '入库总核算'", nullable = true)
   private BigDecimal inboundMete;
   @ApiModelProperty(name = "inboundQuantity", value = "入库计量", notes = "入库计量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   @TableField(value = "inbound_quantity", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '入库计量'", nullable = true)
   private BigDecimal inboundQuantity;
   @ApiModelProperty(name = "inboundAmount", value = "入库总计", notes = "入库总计")
   @JsonProperty("inboundAmount")
   @JSONField(name = "inboundAmount")
   @TableField(value = "inbound_amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_amount", columnDefinition = "decimal(32,12)  COMMENT '入库总计'", nullable = true)
   private BigDecimal inboundAmount;
   @ApiModelProperty(name = "inboundAmountExcludingVat", value = "入库不含税总价", notes = "入库不含税总价")
   @JsonProperty("inboundAmountExcludingVat")
   @JSONField(name = "inboundAmountExcludingVat")
   @TableField(value = "inbound_amount_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '入库不含税总价'", nullable = true)
   private BigDecimal inboundAmountExcludingVat;
   @ApiModelProperty(name = "inboundUnitPrice", value = "入库单价", notes = "入库单价")
   @JsonProperty("inboundUnitPrice")
   @JSONField(name = "inboundUnitPrice")
   @TableField(value = "inbound_unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_unit_price", columnDefinition = "decimal(32,12)  COMMENT '入库单价'", nullable = true)
   private BigDecimal inboundUnitPrice;
   @ApiModelProperty(name = "inboundUnitPriceExcludingVat", value = "入库不含税单价", notes = "入库不含税单价")
   @JsonProperty("inboundUnitPriceExcludingVat")
   @JSONField(name = "inboundUnitPriceExcludingVat")
   @TableField(value = "inbound_unit_price_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '入库不含税单价'", nullable = true)
   private BigDecimal inboundUnitPriceExcludingVat;
   @ApiModelProperty(name = "transferMete", value = "调拨总核算", notes = "调拨总核算")
   @JsonProperty("transferMete")
   @JSONField(name = "transferMete")
   @TableField(value = "transfer_mete", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_mete", columnDefinition = "decimal(32,8)  COMMENT '调拨总核算'", nullable = true)
   private BigDecimal transferMete;
   @ApiModelProperty(name = "transferQuantity", value = "调拨总计量", notes = "调拨总计量")
   @JsonProperty("transferQuantity")
   @JSONField(name = "transferQuantity")
   @TableField(value = "transfer_quantity", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_quantity", columnDefinition = "decimal(32,8)  COMMENT '调拨总计量'", nullable = true)
   private BigDecimal transferQuantity;
   @ApiModelProperty(name = "transferAmount", value = "调拨总金额", notes = "调拨总金额")
   @JsonProperty("transferAmount")
   @JSONField(name = "transferAmount")
   @TableField(value = "transfer_amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_amount", columnDefinition = "decimal(32,12)  COMMENT '调拨总金额'", nullable = true)
   private BigDecimal transferAmount;
   @ApiModelProperty(name = "transferAmountExcludingVat", value = "调拨不含税总价", notes = "调拨不含税总价")
   @JsonProperty("transferAmountExcludingVat")
   @JSONField(name = "transferAmountExcludingVat")
   @TableField(value = "transfer_amount_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '调拨不含税总价'", nullable = true)
   private BigDecimal transferAmountExcludingVat;
   @ApiModelProperty(name = "transferUnitPrice", value = "调拨单价", notes = "调拨单价")
   @JsonProperty("transferUnitPrice")
   @JSONField(name = "transferUnitPrice")
   @TableField(value = "transfer_unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_unit_price", columnDefinition = "decimal(32,12)  COMMENT '调拨单价'", nullable = true)
   private BigDecimal transferUnitPrice;
   @ApiModelProperty(name = "transferUnitPriceExcludingVat", value = "调拨不含税单价", notes = "调拨不含税单价")
   @JsonProperty("transferUnitPriceExcludingVat")
   @JSONField(name = "transferUnitPriceExcludingVat")
   @TableField(value = "transfer_unit_price_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '调拨不含税单价'", nullable = true)
   private BigDecimal transferUnitPriceExcludingVat;
   @ApiModelProperty(name = "transferAmountNoFreight", value = "调拨总计 不含运费", notes = "调拨总计 不含运费")
   @JsonProperty("transferAmountNoFreight")
   @JSONField(name = "transferAmountNoFreight")
   @TableField(value = "transfer_amount_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '调拨总计 不含运费'", nullable = true)
   private BigDecimal transferAmountNoFreight;
   @ApiModelProperty(name = "transferAmountExcludingVatNoFreight", value = "调拨不含税总价 不含运费", notes = "调拨不含税总价 不含运费")
   @JsonProperty("transferAmountExcludingVatNoFreight")
   @JSONField(name = "transferAmountExcludingVatNoFreight")
   @TableField(value = "transfer_amount_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '调拨不含税总价 不含运费'", nullable = true)
   private BigDecimal transferAmountExcludingVatNoFreight;
   @ApiModelProperty(name = "transferUnitPriceNoFreight", value = "调拨单价 不含运费", notes = "调拨单价 不含运费")
   @JsonProperty("transferUnitPriceNoFreight")
   @JSONField(name = "transferUnitPriceNoFreight")
   @TableField(value = "transfer_unit_price_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '调拨单价 不含运费'", nullable = true)
   private BigDecimal transferUnitPriceNoFreight;
   @ApiModelProperty(name = "transferUnitPriceExcludingVatNoFreight", value = "入库不含税单价 不含运费", notes = "入库不含税单价 不含运费")
   @JsonProperty("transferUnitPriceExcludingVatNoFreight")
   @JSONField(name = "transferUnitPriceExcludingVatNoFreight")
   @TableField(value = "transfer_unit_price_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "transfer_unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库不含税单价 不含运费'", nullable = true)
   private BigDecimal transferUnitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "outboundMete", value = "出库总核算", notes = "出库总核算")
   @JsonProperty("outboundMete")
   @JSONField(name = "outboundMete")
   @TableField(value = "outbound_mete", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,8)  COMMENT '出库总核算'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundQuantity", value = "出库总计量", notes = "出库总计量")
   @JsonProperty("outboundQuantity")
   @JSONField(name = "outboundQuantity")
   @TableField(value = "outbound_quantity", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库总计量'", nullable = true)
   private BigDecimal outboundQuantity;
   @ApiModelProperty(name = "outboundAmount", value = "出库总金额", notes = "出库总金额")
   @JsonProperty("outboundAmount")
   @JSONField(name = "outboundAmount")
   @TableField(value = "outbound_amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_amount", columnDefinition = "decimal(32,12)  COMMENT '出库总金额'", nullable = true)
   private BigDecimal outboundAmount;
   @ApiModelProperty(name = "outboundAmountExcludingVat", value = "出库不含税总金额", notes = "出库不含税总金额")
   @JsonProperty("outboundAmountExcludingVat")
   @JSONField(name = "outboundAmountExcludingVat")
   @TableField(value = "outbound_amount_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '出库不含税总金额'", nullable = true)
   private BigDecimal outboundAmountExcludingVat;
   @ApiModelProperty(name = "outboundUnitPrice", value = "出库单价", notes = "出库单价")
   @JsonProperty("outboundUnitPrice")
   @JSONField(name = "outboundUnitPrice")
   @TableField(value = "outbound_unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_unit_price", columnDefinition = "decimal(32,12)  COMMENT '出库单价'", nullable = true)
   private BigDecimal outboundUnitPrice;
   @ApiModelProperty(name = "outboundUnitPriceExcludingVat", value = "出库不含税单价", notes = "出库不含税单价")
   @JsonProperty("outboundUnitPriceExcludingVat")
   @JSONField(name = "outboundUnitPriceExcludingVat")
   @TableField(value = "outbound_unit_price_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '出库不含税单价'", nullable = true)
   private BigDecimal outboundUnitPriceExcludingVat;
   @ApiModelProperty(name = "endMete")
   @JsonProperty("endMete")
   @JSONField(name = "endMete")
   @TableField("end_mete")
   @Column(name = "end_mete", columnDefinition = "decimal(32,8)  COMMENT ''", nullable = true)
   private BigDecimal endMete;
   @ApiModelProperty(name = "endQuantity")
   @JsonProperty("endQuantity")
   @JSONField(name = "endQuantity")
   @TableField("end_quantity")
   @Column(name = "end_quantity", columnDefinition = "decimal(32,8)  COMMENT ''", nullable = true)
   private BigDecimal endQuantity;
   @ApiModelProperty(name = "endAmount")
   @JsonProperty("endAmount")
   @JSONField(name = "endAmount")
   @TableField(value = "end_amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_amount", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endAmount;
   @ApiModelProperty(name = "endAmountExcludingVat")
   @JsonProperty("endAmountExcludingVat")
   @JSONField(name = "endAmountExcludingVat")
   @TableField(value = "end_amount_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endAmountExcludingVat;
   @ApiModelProperty(name = "endUnitPrice")
   @JsonProperty("endUnitPrice")
   @JSONField(name = "endUnitPrice")
   @TableField(value = "end_unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_unit_price", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endUnitPrice;
   @ApiModelProperty(name = "endUnitPriceExcludingVat")
   @JsonProperty("endUnitPriceExcludingVat")
   @JSONField(name = "endUnitPriceExcludingVat")
   @TableField(value = "end_unit_price_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endUnitPriceExcludingVat;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "specification", value = "物料规格", notes = "物料规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '物料规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "inboundAmountNoFreight", value = "入库总计 不含运费", notes = "入库总计 不含运费")
   @JsonProperty("inboundAmountNoFreight")
   @JSONField(name = "inboundAmountNoFreight")
   @TableField(value = "inbound_amount_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库总计 不含运费'", nullable = true)
   private BigDecimal inboundAmountNoFreight;
   @ApiModelProperty(name = "inboundAmountExcludingVatNoFreight", value = "入库不含税总价 不含运费", notes = "入库不含税总价 不含运费")
   @JsonProperty("inboundAmountExcludingVatNoFreight")
   @JSONField(name = "inboundAmountExcludingVatNoFreight")
   @TableField(value = "inbound_amount_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库不含税总价 不含运费'", nullable = true)
   private BigDecimal inboundAmountExcludingVatNoFreight;
   @ApiModelProperty(name = "inboundUnitPriceNoFreight", value = "入库单价 不含运费", notes = "入库单价 不含运费")
   @JsonProperty("inboundUnitPriceNoFreight")
   @JSONField(name = "inboundUnitPriceNoFreight")
   @TableField(value = "inbound_unit_price_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库单价 不含运费'", nullable = true)
   private BigDecimal inboundUnitPriceNoFreight;
   @ApiModelProperty(name = "inboundUnitPriceExcludingVatNoFreight", value = "入库不含税单价 不含运费", notes = "入库不含税单价 不含运费")
   @JsonProperty("inboundUnitPriceExcludingVatNoFreight")
   @JSONField(name = "inboundUnitPriceExcludingVatNoFreight")
   @TableField(value = "inbound_unit_price_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inbound_unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库不含税单价 不含运费'", nullable = true)
   private BigDecimal inboundUnitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "outboundAmountNoFreight", value = "出库总金额 不含运费", notes = "出库总金额 不含运费")
   @JsonProperty("outboundAmountNoFreight")
   @JSONField(name = "outboundAmountNoFreight")
   @TableField(value = "outbound_amount_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '出库总金额 不含运费'", nullable = true)
   private BigDecimal outboundAmountNoFreight;
   @ApiModelProperty(name = "outboundAmountExcludingVatNoFreight", value = "出库不含税总金额 不含运费", notes = "出库不含税总金额 不含运费")
   @JsonProperty("outboundAmountExcludingVatNoFreight")
   @JSONField(name = "outboundAmountExcludingVatNoFreight")
   @TableField(value = "outbound_amount_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '出库不含税总金额 不含运费'", nullable = true)
   private BigDecimal outboundAmountExcludingVatNoFreight;
   @ApiModelProperty(name = "outboundUnitPriceNoFreight", value = "出库单价 不含运费", notes = "出库单价 不含运费")
   @JsonProperty("outboundUnitPriceNoFreight")
   @JSONField(name = "outboundUnitPriceNoFreight")
   @TableField(value = "outbound_unit_price_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '出库单价 不含运费'", nullable = true)
   private BigDecimal outboundUnitPriceNoFreight;
   @ApiModelProperty(name = "outboundUnitPriceExcludingVatNoFreight", value = "出库不含税单价 不含运费", notes = "出库不含税单价 不含运费")
   @JsonProperty("outboundUnitPriceExcludingVatNoFreight")
   @JSONField(name = "outboundUnitPriceExcludingVatNoFreight")
   @TableField(value = "outbound_unit_price_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "outbound_unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '出库不含税单价 不含运费'", nullable = true)
   private BigDecimal outboundUnitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "endAmountNoFreight")
   @JsonProperty("endAmountNoFreight")
   @JSONField(name = "endAmountNoFreight")
   @TableField(value = "end_amount_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endAmountNoFreight;
   @ApiModelProperty(name = "endAmountExcludingVatNoFreight")
   @JsonProperty("endAmountExcludingVatNoFreight")
   @JSONField(name = "endAmountExcludingVatNoFreight")
   @TableField(value = "end_amount_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endAmountExcludingVatNoFreight;
   @ApiModelProperty(name = "endUnitPriceNoFreight")
   @JsonProperty("endUnitPriceNoFreight")
   @JSONField(name = "endUnitPriceNoFreight")
   @TableField(value = "end_unit_price_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endUnitPriceNoFreight;
   @ApiModelProperty(name = "endUnitPriceExcludingVatNoFreight")
   @JsonProperty("endUnitPriceExcludingVatNoFreight")
   @JSONField(name = "endUnitPriceExcludingVatNoFreight")
   @TableField(value = "end_unit_price_excluding_vat_no_freight", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "end_unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT ''", nullable = true)
   private BigDecimal endUnitPriceExcludingVatNoFreight;

   public static Statistics.StatisticsBuilder builder() {
      return new Statistics.StatisticsBuilder();
   }

   public Statistics() {
   }

   public Statistics(
      final Long id,
      final Long wapId,
      final String specs,
      final Integer basicClass,
      final Long classifyId,
      final Long projectId,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final BigDecimal unitNet,
      final Boolean boolPartyA,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Long standardId,
      final String standardName,
      final BigDecimal totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal inboundMete,
      final BigDecimal inboundQuantity,
      final BigDecimal inboundAmount,
      final BigDecimal inboundAmountExcludingVat,
      final BigDecimal inboundUnitPrice,
      final BigDecimal inboundUnitPriceExcludingVat,
      final BigDecimal transferMete,
      final BigDecimal transferQuantity,
      final BigDecimal transferAmount,
      final BigDecimal transferAmountExcludingVat,
      final BigDecimal transferUnitPrice,
      final BigDecimal transferUnitPriceExcludingVat,
      final BigDecimal transferAmountNoFreight,
      final BigDecimal transferAmountExcludingVatNoFreight,
      final BigDecimal transferUnitPriceNoFreight,
      final BigDecimal transferUnitPriceExcludingVatNoFreight,
      final BigDecimal outboundMete,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundAmount,
      final BigDecimal outboundAmountExcludingVat,
      final BigDecimal outboundUnitPrice,
      final BigDecimal outboundUnitPriceExcludingVat,
      final BigDecimal endMete,
      final BigDecimal endQuantity,
      final BigDecimal endAmount,
      final BigDecimal endAmountExcludingVat,
      final BigDecimal endUnitPrice,
      final BigDecimal endUnitPriceExcludingVat,
      final Long workshopId,
      final String specification,
      final BigDecimal inboundAmountNoFreight,
      final BigDecimal inboundAmountExcludingVatNoFreight,
      final BigDecimal inboundUnitPriceNoFreight,
      final BigDecimal inboundUnitPriceExcludingVatNoFreight,
      final BigDecimal outboundAmountNoFreight,
      final BigDecimal outboundAmountExcludingVatNoFreight,
      final BigDecimal outboundUnitPriceNoFreight,
      final BigDecimal outboundUnitPriceExcludingVatNoFreight,
      final BigDecimal endAmountNoFreight,
      final BigDecimal endAmountExcludingVatNoFreight,
      final BigDecimal endUnitPriceNoFreight,
      final BigDecimal endUnitPriceExcludingVatNoFreight
   ) {
      this.id = id;
      this.wapId = wapId;
      this.specs = specs;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.projectId = projectId;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.unitNet = unitNet;
      this.boolPartyA = boolPartyA;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.standardId = standardId;
      this.standardName = standardName;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.inboundMete = inboundMete;
      this.inboundQuantity = inboundQuantity;
      this.inboundAmount = inboundAmount;
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      this.inboundUnitPrice = inboundUnitPrice;
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
      this.transferMete = transferMete;
      this.transferQuantity = transferQuantity;
      this.transferAmount = transferAmount;
      this.transferAmountExcludingVat = transferAmountExcludingVat;
      this.transferUnitPrice = transferUnitPrice;
      this.transferUnitPriceExcludingVat = transferUnitPriceExcludingVat;
      this.transferAmountNoFreight = transferAmountNoFreight;
      this.transferAmountExcludingVatNoFreight = transferAmountExcludingVatNoFreight;
      this.transferUnitPriceNoFreight = transferUnitPriceNoFreight;
      this.transferUnitPriceExcludingVatNoFreight = transferUnitPriceExcludingVatNoFreight;
      this.outboundMete = outboundMete;
      this.outboundQuantity = outboundQuantity;
      this.outboundAmount = outboundAmount;
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      this.outboundUnitPrice = outboundUnitPrice;
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
      this.endMete = endMete;
      this.endQuantity = endQuantity;
      this.endAmount = endAmount;
      this.endAmountExcludingVat = endAmountExcludingVat;
      this.endUnitPrice = endUnitPrice;
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
      this.workshopId = workshopId;
      this.specification = specification;
      this.inboundAmountNoFreight = inboundAmountNoFreight;
      this.inboundAmountExcludingVatNoFreight = inboundAmountExcludingVatNoFreight;
      this.inboundUnitPriceNoFreight = inboundUnitPriceNoFreight;
      this.inboundUnitPriceExcludingVatNoFreight = inboundUnitPriceExcludingVatNoFreight;
      this.outboundAmountNoFreight = outboundAmountNoFreight;
      this.outboundAmountExcludingVatNoFreight = outboundAmountExcludingVatNoFreight;
      this.outboundUnitPriceNoFreight = outboundUnitPriceNoFreight;
      this.outboundUnitPriceExcludingVatNoFreight = outboundUnitPriceExcludingVatNoFreight;
      this.endAmountNoFreight = endAmountNoFreight;
      this.endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight;
      this.endUnitPriceNoFreight = endUnitPriceNoFreight;
      this.endUnitPriceExcludingVatNoFreight = endUnitPriceExcludingVatNoFreight;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public String getSpecs() {
      return this.specs;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getInboundAmountExcludingVat() {
      return this.inboundAmountExcludingVat;
   }

   public BigDecimal getInboundUnitPrice() {
      return this.inboundUnitPrice;
   }

   public BigDecimal getInboundUnitPriceExcludingVat() {
      return this.inboundUnitPriceExcludingVat;
   }

   public BigDecimal getTransferMete() {
      return this.transferMete;
   }

   public BigDecimal getTransferQuantity() {
      return this.transferQuantity;
   }

   public BigDecimal getTransferAmount() {
      return this.transferAmount;
   }

   public BigDecimal getTransferAmountExcludingVat() {
      return this.transferAmountExcludingVat;
   }

   public BigDecimal getTransferUnitPrice() {
      return this.transferUnitPrice;
   }

   public BigDecimal getTransferUnitPriceExcludingVat() {
      return this.transferUnitPriceExcludingVat;
   }

   public BigDecimal getTransferAmountNoFreight() {
      return this.transferAmountNoFreight;
   }

   public BigDecimal getTransferAmountExcludingVatNoFreight() {
      return this.transferAmountExcludingVatNoFreight;
   }

   public BigDecimal getTransferUnitPriceNoFreight() {
      return this.transferUnitPriceNoFreight;
   }

   public BigDecimal getTransferUnitPriceExcludingVatNoFreight() {
      return this.transferUnitPriceExcludingVatNoFreight;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getOutboundAmountExcludingVat() {
      return this.outboundAmountExcludingVat;
   }

   public BigDecimal getOutboundUnitPrice() {
      return this.outboundUnitPrice;
   }

   public BigDecimal getOutboundUnitPriceExcludingVat() {
      return this.outboundUnitPriceExcludingVat;
   }

   public BigDecimal getEndMete() {
      return this.endMete;
   }

   public BigDecimal getEndQuantity() {
      return this.endQuantity;
   }

   public BigDecimal getEndAmount() {
      return this.endAmount;
   }

   public BigDecimal getEndAmountExcludingVat() {
      return this.endAmountExcludingVat;
   }

   public BigDecimal getEndUnitPrice() {
      return this.endUnitPrice;
   }

   public BigDecimal getEndUnitPriceExcludingVat() {
      return this.endUnitPriceExcludingVat;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getInboundAmountNoFreight() {
      return this.inboundAmountNoFreight;
   }

   public BigDecimal getInboundAmountExcludingVatNoFreight() {
      return this.inboundAmountExcludingVatNoFreight;
   }

   public BigDecimal getInboundUnitPriceNoFreight() {
      return this.inboundUnitPriceNoFreight;
   }

   public BigDecimal getInboundUnitPriceExcludingVatNoFreight() {
      return this.inboundUnitPriceExcludingVatNoFreight;
   }

   public BigDecimal getOutboundAmountNoFreight() {
      return this.outboundAmountNoFreight;
   }

   public BigDecimal getOutboundAmountExcludingVatNoFreight() {
      return this.outboundAmountExcludingVatNoFreight;
   }

   public BigDecimal getOutboundUnitPriceNoFreight() {
      return this.outboundUnitPriceNoFreight;
   }

   public BigDecimal getOutboundUnitPriceExcludingVatNoFreight() {
      return this.outboundUnitPriceExcludingVatNoFreight;
   }

   public BigDecimal getEndAmountNoFreight() {
      return this.endAmountNoFreight;
   }

   public BigDecimal getEndAmountExcludingVatNoFreight() {
      return this.endAmountExcludingVatNoFreight;
   }

   public BigDecimal getEndUnitPriceNoFreight() {
      return this.endUnitPriceNoFreight;
   }

   public BigDecimal getEndUnitPriceExcludingVatNoFreight() {
      return this.endUnitPriceExcludingVatNoFreight;
   }

   @JsonProperty("id")
   public Statistics setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("wapId")
   public Statistics setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("specs")
   public Statistics setSpecs(final String specs) {
      this.specs = specs;
      return this;
   }

   @JsonProperty("basicClass")
   public Statistics setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public Statistics setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("projectId")
   public Statistics setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("thickness")
   public Statistics setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public Statistics setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public Statistics setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public Statistics setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public Statistics setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("unitNet")
   public Statistics setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Statistics setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("invoiceType")
   public Statistics setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public Statistics setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("standardId")
   public Statistics setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public Statistics setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("totalQuantity")
   public Statistics setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalMete")
   public Statistics setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("inboundMete")
   public Statistics setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public Statistics setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("inboundAmount")
   public Statistics setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVat")
   public Statistics setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("inboundUnitPrice")
   public Statistics setInboundUnitPrice(final BigDecimal inboundUnitPrice) {
      this.inboundUnitPrice = inboundUnitPrice;
      return this;
   }

   @JsonProperty("inboundUnitPriceExcludingVat")
   public Statistics setInboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("transferMete")
   public Statistics setTransferMete(final BigDecimal transferMete) {
      this.transferMete = transferMete;
      return this;
   }

   @JsonProperty("transferQuantity")
   public Statistics setTransferQuantity(final BigDecimal transferQuantity) {
      this.transferQuantity = transferQuantity;
      return this;
   }

   @JsonProperty("transferAmount")
   public Statistics setTransferAmount(final BigDecimal transferAmount) {
      this.transferAmount = transferAmount;
      return this;
   }

   @JsonProperty("transferAmountExcludingVat")
   public Statistics setTransferAmountExcludingVat(final BigDecimal transferAmountExcludingVat) {
      this.transferAmountExcludingVat = transferAmountExcludingVat;
      return this;
   }

   @JsonProperty("transferUnitPrice")
   public Statistics setTransferUnitPrice(final BigDecimal transferUnitPrice) {
      this.transferUnitPrice = transferUnitPrice;
      return this;
   }

   @JsonProperty("transferUnitPriceExcludingVat")
   public Statistics setTransferUnitPriceExcludingVat(final BigDecimal transferUnitPriceExcludingVat) {
      this.transferUnitPriceExcludingVat = transferUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("transferAmountNoFreight")
   public Statistics setTransferAmountNoFreight(final BigDecimal transferAmountNoFreight) {
      this.transferAmountNoFreight = transferAmountNoFreight;
      return this;
   }

   @JsonProperty("transferAmountExcludingVatNoFreight")
   public Statistics setTransferAmountExcludingVatNoFreight(final BigDecimal transferAmountExcludingVatNoFreight) {
      this.transferAmountExcludingVatNoFreight = transferAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("transferUnitPriceNoFreight")
   public Statistics setTransferUnitPriceNoFreight(final BigDecimal transferUnitPriceNoFreight) {
      this.transferUnitPriceNoFreight = transferUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("transferUnitPriceExcludingVatNoFreight")
   public Statistics setTransferUnitPriceExcludingVatNoFreight(final BigDecimal transferUnitPriceExcludingVatNoFreight) {
      this.transferUnitPriceExcludingVatNoFreight = transferUnitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundMete")
   public Statistics setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   @JsonProperty("outboundQuantity")
   public Statistics setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   @JsonProperty("outboundAmount")
   public Statistics setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVat")
   public Statistics setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("outboundUnitPrice")
   public Statistics setOutboundUnitPrice(final BigDecimal outboundUnitPrice) {
      this.outboundUnitPrice = outboundUnitPrice;
      return this;
   }

   @JsonProperty("outboundUnitPriceExcludingVat")
   public Statistics setOutboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("endMete")
   public Statistics setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
      return this;
   }

   @JsonProperty("endQuantity")
   public Statistics setEndQuantity(final BigDecimal endQuantity) {
      this.endQuantity = endQuantity;
      return this;
   }

   @JsonProperty("endAmount")
   public Statistics setEndAmount(final BigDecimal endAmount) {
      this.endAmount = endAmount;
      return this;
   }

   @JsonProperty("endAmountExcludingVat")
   public Statistics setEndAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
      this.endAmountExcludingVat = endAmountExcludingVat;
      return this;
   }

   @JsonProperty("endUnitPrice")
   public Statistics setEndUnitPrice(final BigDecimal endUnitPrice) {
      this.endUnitPrice = endUnitPrice;
      return this;
   }

   @JsonProperty("endUnitPriceExcludingVat")
   public Statistics setEndUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("workshopId")
   public Statistics setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("specification")
   public Statistics setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("inboundAmountNoFreight")
   public Statistics setInboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
      this.inboundAmountNoFreight = inboundAmountNoFreight;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVatNoFreight")
   public Statistics setInboundAmountExcludingVatNoFreight(final BigDecimal inboundAmountExcludingVatNoFreight) {
      this.inboundAmountExcludingVatNoFreight = inboundAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inboundUnitPriceNoFreight")
   public Statistics setInboundUnitPriceNoFreight(final BigDecimal inboundUnitPriceNoFreight) {
      this.inboundUnitPriceNoFreight = inboundUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("inboundUnitPriceExcludingVatNoFreight")
   public Statistics setInboundUnitPriceExcludingVatNoFreight(final BigDecimal inboundUnitPriceExcludingVatNoFreight) {
      this.inboundUnitPriceExcludingVatNoFreight = inboundUnitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundAmountNoFreight")
   public Statistics setOutboundAmountNoFreight(final BigDecimal outboundAmountNoFreight) {
      this.outboundAmountNoFreight = outboundAmountNoFreight;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVatNoFreight")
   public Statistics setOutboundAmountExcludingVatNoFreight(final BigDecimal outboundAmountExcludingVatNoFreight) {
      this.outboundAmountExcludingVatNoFreight = outboundAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundUnitPriceNoFreight")
   public Statistics setOutboundUnitPriceNoFreight(final BigDecimal outboundUnitPriceNoFreight) {
      this.outboundUnitPriceNoFreight = outboundUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("outboundUnitPriceExcludingVatNoFreight")
   public Statistics setOutboundUnitPriceExcludingVatNoFreight(final BigDecimal outboundUnitPriceExcludingVatNoFreight) {
      this.outboundUnitPriceExcludingVatNoFreight = outboundUnitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("endAmountNoFreight")
   public Statistics setEndAmountNoFreight(final BigDecimal endAmountNoFreight) {
      this.endAmountNoFreight = endAmountNoFreight;
      return this;
   }

   @JsonProperty("endAmountExcludingVatNoFreight")
   public Statistics setEndAmountExcludingVatNoFreight(final BigDecimal endAmountExcludingVatNoFreight) {
      this.endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("endUnitPriceNoFreight")
   public Statistics setEndUnitPriceNoFreight(final BigDecimal endUnitPriceNoFreight) {
      this.endUnitPriceNoFreight = endUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("endUnitPriceExcludingVatNoFreight")
   public Statistics setEndUnitPriceExcludingVatNoFreight(final BigDecimal endUnitPriceExcludingVatNoFreight) {
      this.endUnitPriceExcludingVatNoFreight = endUnitPriceExcludingVatNoFreight;
      return this;
   }

   @Override
   public String toString() {
      return "Statistics(id="
         + this.getId()
         + ", wapId="
         + this.getWapId()
         + ", specs="
         + this.getSpecs()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", projectId="
         + this.getProjectId()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", unitNet="
         + this.getUnitNet()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", inboundMete="
         + this.getInboundMete()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", inboundAmountExcludingVat="
         + this.getInboundAmountExcludingVat()
         + ", inboundUnitPrice="
         + this.getInboundUnitPrice()
         + ", inboundUnitPriceExcludingVat="
         + this.getInboundUnitPriceExcludingVat()
         + ", transferMete="
         + this.getTransferMete()
         + ", transferQuantity="
         + this.getTransferQuantity()
         + ", transferAmount="
         + this.getTransferAmount()
         + ", transferAmountExcludingVat="
         + this.getTransferAmountExcludingVat()
         + ", transferUnitPrice="
         + this.getTransferUnitPrice()
         + ", transferUnitPriceExcludingVat="
         + this.getTransferUnitPriceExcludingVat()
         + ", transferAmountNoFreight="
         + this.getTransferAmountNoFreight()
         + ", transferAmountExcludingVatNoFreight="
         + this.getTransferAmountExcludingVatNoFreight()
         + ", transferUnitPriceNoFreight="
         + this.getTransferUnitPriceNoFreight()
         + ", transferUnitPriceExcludingVatNoFreight="
         + this.getTransferUnitPriceExcludingVatNoFreight()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", outboundAmountExcludingVat="
         + this.getOutboundAmountExcludingVat()
         + ", outboundUnitPrice="
         + this.getOutboundUnitPrice()
         + ", outboundUnitPriceExcludingVat="
         + this.getOutboundUnitPriceExcludingVat()
         + ", endMete="
         + this.getEndMete()
         + ", endQuantity="
         + this.getEndQuantity()
         + ", endAmount="
         + this.getEndAmount()
         + ", endAmountExcludingVat="
         + this.getEndAmountExcludingVat()
         + ", endUnitPrice="
         + this.getEndUnitPrice()
         + ", endUnitPriceExcludingVat="
         + this.getEndUnitPriceExcludingVat()
         + ", workshopId="
         + this.getWorkshopId()
         + ", specification="
         + this.getSpecification()
         + ", inboundAmountNoFreight="
         + this.getInboundAmountNoFreight()
         + ", inboundAmountExcludingVatNoFreight="
         + this.getInboundAmountExcludingVatNoFreight()
         + ", inboundUnitPriceNoFreight="
         + this.getInboundUnitPriceNoFreight()
         + ", inboundUnitPriceExcludingVatNoFreight="
         + this.getInboundUnitPriceExcludingVatNoFreight()
         + ", outboundAmountNoFreight="
         + this.getOutboundAmountNoFreight()
         + ", outboundAmountExcludingVatNoFreight="
         + this.getOutboundAmountExcludingVatNoFreight()
         + ", outboundUnitPriceNoFreight="
         + this.getOutboundUnitPriceNoFreight()
         + ", outboundUnitPriceExcludingVatNoFreight="
         + this.getOutboundUnitPriceExcludingVatNoFreight()
         + ", endAmountNoFreight="
         + this.getEndAmountNoFreight()
         + ", endAmountExcludingVatNoFreight="
         + this.getEndAmountExcludingVatNoFreight()
         + ", endUnitPriceNoFreight="
         + this.getEndUnitPriceNoFreight()
         + ", endUnitPriceExcludingVatNoFreight="
         + this.getEndUnitPriceExcludingVatNoFreight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Statistics)) {
         return false;
      }

      Statistics other = (Statistics)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wapId = this.getWapId();
         Object other$wapId = other.getWapId();
         if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$standardId = this.getStandardId();
                           Object other$standardId = other.getStandardId();
                           if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                              Object this$workshopId = this.getWorkshopId();
                              Object other$workshopId = other.getWorkshopId();
                              if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                 Object this$specs = this.getSpecs();
                                 Object other$specs = other.getSpecs();
                                 if (this$specs == null ? other$specs == null : this$specs.equals(other$specs)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$theoryThickness = this.getTheoryThickness();
                                       Object other$theoryThickness = other.getTheoryThickness();
                                       if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$color = this.getColor();
                                             Object other$color = other.getColor();
                                             if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                if (this$heatNoAndBatchNo == null
                                                   ? other$heatNoAndBatchNo == null
                                                   : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                   Object this$unitNet = this.getUnitNet();
                                                   Object other$unitNet = other.getUnitNet();
                                                   if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                      Object this$taxRate = this.getTaxRate();
                                                      Object other$taxRate = other.getTaxRate();
                                                      if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                         Object this$standardName = this.getStandardName();
                                                         Object other$standardName = other.getStandardName();
                                                         if (this$standardName == null
                                                            ? other$standardName == null
                                                            : this$standardName.equals(other$standardName)) {
                                                            Object this$totalQuantity = this.getTotalQuantity();
                                                            Object other$totalQuantity = other.getTotalQuantity();
                                                            if (this$totalQuantity == null
                                                               ? other$totalQuantity == null
                                                               : this$totalQuantity.equals(other$totalQuantity)) {
                                                               Object this$totalMete = this.getTotalMete();
                                                               Object other$totalMete = other.getTotalMete();
                                                               if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                                                                  Object this$inboundMete = this.getInboundMete();
                                                                  Object other$inboundMete = other.getInboundMete();
                                                                  if (this$inboundMete == null
                                                                     ? other$inboundMete == null
                                                                     : this$inboundMete.equals(other$inboundMete)) {
                                                                     Object this$inboundQuantity = this.getInboundQuantity();
                                                                     Object other$inboundQuantity = other.getInboundQuantity();
                                                                     if (this$inboundQuantity == null
                                                                        ? other$inboundQuantity == null
                                                                        : this$inboundQuantity.equals(other$inboundQuantity)) {
                                                                        Object this$inboundAmount = this.getInboundAmount();
                                                                        Object other$inboundAmount = other.getInboundAmount();
                                                                        if (this$inboundAmount == null
                                                                           ? other$inboundAmount == null
                                                                           : this$inboundAmount.equals(other$inboundAmount)) {
                                                                           Object this$inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
                                                                           Object other$inboundAmountExcludingVat = other.getInboundAmountExcludingVat();
                                                                           if (this$inboundAmountExcludingVat == null
                                                                              ? other$inboundAmountExcludingVat == null
                                                                              : this$inboundAmountExcludingVat.equals(other$inboundAmountExcludingVat)) {
                                                                              Object this$inboundUnitPrice = this.getInboundUnitPrice();
                                                                              Object other$inboundUnitPrice = other.getInboundUnitPrice();
                                                                              if (this$inboundUnitPrice == null
                                                                                 ? other$inboundUnitPrice == null
                                                                                 : this$inboundUnitPrice.equals(other$inboundUnitPrice)) {
                                                                                 Object this$inboundUnitPriceExcludingVat = this.getInboundUnitPriceExcludingVat();
                                                                                 Object other$inboundUnitPriceExcludingVat = other.getInboundUnitPriceExcludingVat();
                                                                                 if (this$inboundUnitPriceExcludingVat == null
                                                                                    ? other$inboundUnitPriceExcludingVat == null
                                                                                    : this$inboundUnitPriceExcludingVat.equals(
                                                                                       other$inboundUnitPriceExcludingVat
                                                                                    )) {
                                                                                    Object this$transferMete = this.getTransferMete();
                                                                                    Object other$transferMete = other.getTransferMete();
                                                                                    if (this$transferMete == null
                                                                                       ? other$transferMete == null
                                                                                       : this$transferMete.equals(other$transferMete)) {
                                                                                       Object this$transferQuantity = this.getTransferQuantity();
                                                                                       Object other$transferQuantity = other.getTransferQuantity();
                                                                                       if (this$transferQuantity == null
                                                                                          ? other$transferQuantity == null
                                                                                          : this$transferQuantity.equals(other$transferQuantity)) {
                                                                                          Object this$transferAmount = this.getTransferAmount();
                                                                                          Object other$transferAmount = other.getTransferAmount();
                                                                                          if (this$transferAmount == null
                                                                                             ? other$transferAmount == null
                                                                                             : this$transferAmount.equals(other$transferAmount)) {
                                                                                             Object this$transferAmountExcludingVat = this.getTransferAmountExcludingVat();
                                                                                             Object other$transferAmountExcludingVat = other.getTransferAmountExcludingVat();
                                                                                             if (this$transferAmountExcludingVat == null
                                                                                                ? other$transferAmountExcludingVat == null
                                                                                                : this$transferAmountExcludingVat.equals(
                                                                                                   other$transferAmountExcludingVat
                                                                                                )) {
                                                                                                Object this$transferUnitPrice = this.getTransferUnitPrice();
                                                                                                Object other$transferUnitPrice = other.getTransferUnitPrice();
                                                                                                if (this$transferUnitPrice == null
                                                                                                   ? other$transferUnitPrice == null
                                                                                                   : this$transferUnitPrice.equals(other$transferUnitPrice)) {
                                                                                                   Object this$transferUnitPriceExcludingVat = this.getTransferUnitPriceExcludingVat();
                                                                                                   Object other$transferUnitPriceExcludingVat = other.getTransferUnitPriceExcludingVat();
                                                                                                   if (this$transferUnitPriceExcludingVat == null
                                                                                                      ? other$transferUnitPriceExcludingVat == null
                                                                                                      : this$transferUnitPriceExcludingVat.equals(
                                                                                                         other$transferUnitPriceExcludingVat
                                                                                                      )) {
                                                                                                      Object this$transferAmountNoFreight = this.getTransferAmountNoFreight();
                                                                                                      Object other$transferAmountNoFreight = other.getTransferAmountNoFreight();
                                                                                                      if (this$transferAmountNoFreight == null
                                                                                                         ? other$transferAmountNoFreight == null
                                                                                                         : this$transferAmountNoFreight.equals(
                                                                                                            other$transferAmountNoFreight
                                                                                                         )) {
                                                                                                         Object this$transferAmountExcludingVatNoFreight = this.getTransferAmountExcludingVatNoFreight();
                                                                                                         Object other$transferAmountExcludingVatNoFreight = other.getTransferAmountExcludingVatNoFreight();
                                                                                                         if (this$transferAmountExcludingVatNoFreight == null
                                                                                                            ? other$transferAmountExcludingVatNoFreight == null
                                                                                                            : this$transferAmountExcludingVatNoFreight.equals(
                                                                                                               other$transferAmountExcludingVatNoFreight
                                                                                                            )) {
                                                                                                            Object this$transferUnitPriceNoFreight = this.getTransferUnitPriceNoFreight();
                                                                                                            Object other$transferUnitPriceNoFreight = other.getTransferUnitPriceNoFreight();
                                                                                                            if (this$transferUnitPriceNoFreight == null
                                                                                                               ? other$transferUnitPriceNoFreight == null
                                                                                                               : this$transferUnitPriceNoFreight.equals(
                                                                                                                  other$transferUnitPriceNoFreight
                                                                                                               )) {
                                                                                                               Object this$transferUnitPriceExcludingVatNoFreight = this.getTransferUnitPriceExcludingVatNoFreight();
                                                                                                               Object other$transferUnitPriceExcludingVatNoFreight = other.getTransferUnitPriceExcludingVatNoFreight();
                                                                                                               if (this$transferUnitPriceExcludingVatNoFreight
                                                                                                                     == null
                                                                                                                  ? other$transferUnitPriceExcludingVatNoFreight
                                                                                                                     == null
                                                                                                                  : this$transferUnitPriceExcludingVatNoFreight.equals(
                                                                                                                     other$transferUnitPriceExcludingVatNoFreight
                                                                                                                  )) {
                                                                                                                  Object this$outboundMete = this.getOutboundMete();
                                                                                                                  Object other$outboundMete = other.getOutboundMete();
                                                                                                                  if (this$outboundMete == null
                                                                                                                     ? other$outboundMete == null
                                                                                                                     : this$outboundMete.equals(
                                                                                                                        other$outboundMete
                                                                                                                     )) {
                                                                                                                     Object this$outboundQuantity = this.getOutboundQuantity();
                                                                                                                     Object other$outboundQuantity = other.getOutboundQuantity();
                                                                                                                     if (this$outboundQuantity == null
                                                                                                                        ? other$outboundQuantity == null
                                                                                                                        : this$outboundQuantity.equals(
                                                                                                                           other$outboundQuantity
                                                                                                                        )) {
                                                                                                                        Object this$outboundAmount = this.getOutboundAmount();
                                                                                                                        Object other$outboundAmount = other.getOutboundAmount();
                                                                                                                        if (this$outboundAmount == null
                                                                                                                           ? other$outboundAmount == null
                                                                                                                           : this$outboundAmount.equals(
                                                                                                                              other$outboundAmount
                                                                                                                           )) {
                                                                                                                           Object this$outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
                                                                                                                           Object other$outboundAmountExcludingVat = other.getOutboundAmountExcludingVat();
                                                                                                                           if (this$outboundAmountExcludingVat
                                                                                                                                 == null
                                                                                                                              ? other$outboundAmountExcludingVat
                                                                                                                                 == null
                                                                                                                              : this$outboundAmountExcludingVat.equals(
                                                                                                                                 other$outboundAmountExcludingVat
                                                                                                                              )) {
                                                                                                                              Object this$outboundUnitPrice = this.getOutboundUnitPrice();
                                                                                                                              Object other$outboundUnitPrice = other.getOutboundUnitPrice();
                                                                                                                              if (this$outboundUnitPrice
                                                                                                                                    == null
                                                                                                                                 ? other$outboundUnitPrice
                                                                                                                                    == null
                                                                                                                                 : this$outboundUnitPrice.equals(
                                                                                                                                    other$outboundUnitPrice
                                                                                                                                 )) {
                                                                                                                                 Object this$outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
                                                                                                                                 Object other$outboundUnitPriceExcludingVat = other.getOutboundUnitPriceExcludingVat();
                                                                                                                                 if (this$outboundUnitPriceExcludingVat
                                                                                                                                       == null
                                                                                                                                    ? other$outboundUnitPriceExcludingVat
                                                                                                                                       == null
                                                                                                                                    : this$outboundUnitPriceExcludingVat.equals(
                                                                                                                                       other$outboundUnitPriceExcludingVat
                                                                                                                                    )) {
                                                                                                                                    Object this$endMete = this.getEndMete();
                                                                                                                                    Object other$endMete = other.getEndMete();
                                                                                                                                    if (this$endMete == null
                                                                                                                                       ? other$endMete == null
                                                                                                                                       : this$endMete.equals(
                                                                                                                                          other$endMete
                                                                                                                                       )) {
                                                                                                                                       Object this$endQuantity = this.getEndQuantity();
                                                                                                                                       Object other$endQuantity = other.getEndQuantity();
                                                                                                                                       if (this$endQuantity
                                                                                                                                             == null
                                                                                                                                          ? other$endQuantity
                                                                                                                                             == null
                                                                                                                                          : this$endQuantity.equals(
                                                                                                                                             other$endQuantity
                                                                                                                                          )) {
                                                                                                                                          Object this$endAmount = this.getEndAmount();
                                                                                                                                          Object other$endAmount = other.getEndAmount();
                                                                                                                                          if (this$endAmount
                                                                                                                                                == null
                                                                                                                                             ? other$endAmount
                                                                                                                                                == null
                                                                                                                                             : this$endAmount.equals(
                                                                                                                                                other$endAmount
                                                                                                                                             )) {
                                                                                                                                             Object this$endAmountExcludingVat = this.getEndAmountExcludingVat();
                                                                                                                                             Object other$endAmountExcludingVat = other.getEndAmountExcludingVat();
                                                                                                                                             if (this$endAmountExcludingVat
                                                                                                                                                   == null
                                                                                                                                                ? other$endAmountExcludingVat
                                                                                                                                                   == null
                                                                                                                                                : this$endAmountExcludingVat.equals(
                                                                                                                                                   other$endAmountExcludingVat
                                                                                                                                                )) {
                                                                                                                                                Object this$endUnitPrice = this.getEndUnitPrice();
                                                                                                                                                Object other$endUnitPrice = other.getEndUnitPrice();
                                                                                                                                                if (this$endUnitPrice
                                                                                                                                                      == null
                                                                                                                                                   ? other$endUnitPrice
                                                                                                                                                      == null
                                                                                                                                                   : this$endUnitPrice.equals(
                                                                                                                                                      other$endUnitPrice
                                                                                                                                                   )) {
                                                                                                                                                   Object this$endUnitPriceExcludingVat = this.getEndUnitPriceExcludingVat();
                                                                                                                                                   Object other$endUnitPriceExcludingVat = other.getEndUnitPriceExcludingVat();
                                                                                                                                                   if (this$endUnitPriceExcludingVat
                                                                                                                                                         == null
                                                                                                                                                      ? other$endUnitPriceExcludingVat
                                                                                                                                                         == null
                                                                                                                                                      : this$endUnitPriceExcludingVat.equals(
                                                                                                                                                         other$endUnitPriceExcludingVat
                                                                                                                                                      )) {
                                                                                                                                                      Object this$specification = this.getSpecification();
                                                                                                                                                      Object other$specification = other.getSpecification();
                                                                                                                                                      if (this$specification
                                                                                                                                                            == null
                                                                                                                                                         ? other$specification
                                                                                                                                                            == null
                                                                                                                                                         : this$specification.equals(
                                                                                                                                                            other$specification
                                                                                                                                                         )) {
                                                                                                                                                         Object this$inboundAmountNoFreight = this.getInboundAmountNoFreight();
                                                                                                                                                         Object other$inboundAmountNoFreight = other.getInboundAmountNoFreight();
                                                                                                                                                         if (this$inboundAmountNoFreight
                                                                                                                                                               == null
                                                                                                                                                            ? other$inboundAmountNoFreight
                                                                                                                                                               == null
                                                                                                                                                            : this$inboundAmountNoFreight.equals(
                                                                                                                                                               other$inboundAmountNoFreight
                                                                                                                                                            )) {
                                                                                                                                                            Object this$inboundAmountExcludingVatNoFreight = this.getInboundAmountExcludingVatNoFreight();
                                                                                                                                                            Object other$inboundAmountExcludingVatNoFreight = other.getInboundAmountExcludingVatNoFreight();
                                                                                                                                                            if (this$inboundAmountExcludingVatNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               ? other$inboundAmountExcludingVatNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               : this$inboundAmountExcludingVatNoFreight.equals(
                                                                                                                                                                  other$inboundAmountExcludingVatNoFreight
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$inboundUnitPriceNoFreight = this.getInboundUnitPriceNoFreight();
                                                                                                                                                               Object other$inboundUnitPriceNoFreight = other.getInboundUnitPriceNoFreight();
                                                                                                                                                               if (this$inboundUnitPriceNoFreight
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$inboundUnitPriceNoFreight
                                                                                                                                                                     == null
                                                                                                                                                                  : this$inboundUnitPriceNoFreight.equals(
                                                                                                                                                                     other$inboundUnitPriceNoFreight
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$inboundUnitPriceExcludingVatNoFreight = this.getInboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                                  Object other$inboundUnitPriceExcludingVatNoFreight = other.getInboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                                  if (this$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                        == null
                                                                                                                                                                     : this$inboundUnitPriceExcludingVatNoFreight.equals(
                                                                                                                                                                        other$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$outboundAmountNoFreight = this.getOutboundAmountNoFreight();
                                                                                                                                                                     Object other$outboundAmountNoFreight = other.getOutboundAmountNoFreight();
                                                                                                                                                                     if (this$outboundAmountNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$outboundAmountNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        : this$outboundAmountNoFreight.equals(
                                                                                                                                                                           other$outboundAmountNoFreight
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$outboundAmountExcludingVatNoFreight = this.getOutboundAmountExcludingVatNoFreight();
                                                                                                                                                                        Object other$outboundAmountExcludingVatNoFreight = other.getOutboundAmountExcludingVatNoFreight();
                                                                                                                                                                        if (this$outboundAmountExcludingVatNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$outboundAmountExcludingVatNoFreight
                                                                                                                                                                              == null
                                                                                                                                                                           : this$outboundAmountExcludingVatNoFreight.equals(
                                                                                                                                                                              other$outboundAmountExcludingVatNoFreight
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$outboundUnitPriceNoFreight = this.getOutboundUnitPriceNoFreight();
                                                                                                                                                                           Object other$outboundUnitPriceNoFreight = other.getOutboundUnitPriceNoFreight();
                                                                                                                                                                           if (this$outboundUnitPriceNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$outboundUnitPriceNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$outboundUnitPriceNoFreight.equals(
                                                                                                                                                                                 other$outboundUnitPriceNoFreight
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$outboundUnitPriceExcludingVatNoFreight = this.getOutboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                                              Object other$outboundUnitPriceExcludingVatNoFreight = other.getOutboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                                              if (this$outboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$outboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$outboundUnitPriceExcludingVatNoFreight.equals(
                                                                                                                                                                                    other$outboundUnitPriceExcludingVatNoFreight
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$endAmountNoFreight = this.getEndAmountNoFreight();
                                                                                                                                                                                 Object other$endAmountNoFreight = other.getEndAmountNoFreight();
                                                                                                                                                                                 if (this$endAmountNoFreight
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$endAmountNoFreight
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$endAmountNoFreight.equals(
                                                                                                                                                                                       other$endAmountNoFreight
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$endAmountExcludingVatNoFreight = this.getEndAmountExcludingVatNoFreight();
                                                                                                                                                                                    Object other$endAmountExcludingVatNoFreight = other.getEndAmountExcludingVatNoFreight();
                                                                                                                                                                                    if (this$endAmountExcludingVatNoFreight
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$endAmountExcludingVatNoFreight
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$endAmountExcludingVatNoFreight.equals(
                                                                                                                                                                                          other$endAmountExcludingVatNoFreight
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$endUnitPriceNoFreight = this.getEndUnitPriceNoFreight();
                                                                                                                                                                                       Object other$endUnitPriceNoFreight = other.getEndUnitPriceNoFreight();
                                                                                                                                                                                       if (this$endUnitPriceNoFreight
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$endUnitPriceNoFreight
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$endUnitPriceNoFreight.equals(
                                                                                                                                                                                             other$endUnitPriceNoFreight
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$endUnitPriceExcludingVatNoFreight = this.getEndUnitPriceExcludingVatNoFreight();
                                                                                                                                                                                          Object other$endUnitPriceExcludingVatNoFreight = other.getEndUnitPriceExcludingVatNoFreight();
                                                                                                                                                                                          return this$endUnitPriceExcludingVatNoFreight
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$endUnitPriceExcludingVatNoFreight
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$endUnitPriceExcludingVatNoFreight.equals(
                                                                                                                                                                                                other$endUnitPriceExcludingVatNoFreight
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Statistics;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $specs = this.getSpecs();
      result = result * 59 + ($specs == null ? 43 : $specs.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
      result = result * 59 + ($inboundAmountExcludingVat == null ? 43 : $inboundAmountExcludingVat.hashCode());
      Object $inboundUnitPrice = this.getInboundUnitPrice();
      result = result * 59 + ($inboundUnitPrice == null ? 43 : $inboundUnitPrice.hashCode());
      Object $inboundUnitPriceExcludingVat = this.getInboundUnitPriceExcludingVat();
      result = result * 59 + ($inboundUnitPriceExcludingVat == null ? 43 : $inboundUnitPriceExcludingVat.hashCode());
      Object $transferMete = this.getTransferMete();
      result = result * 59 + ($transferMete == null ? 43 : $transferMete.hashCode());
      Object $transferQuantity = this.getTransferQuantity();
      result = result * 59 + ($transferQuantity == null ? 43 : $transferQuantity.hashCode());
      Object $transferAmount = this.getTransferAmount();
      result = result * 59 + ($transferAmount == null ? 43 : $transferAmount.hashCode());
      Object $transferAmountExcludingVat = this.getTransferAmountExcludingVat();
      result = result * 59 + ($transferAmountExcludingVat == null ? 43 : $transferAmountExcludingVat.hashCode());
      Object $transferUnitPrice = this.getTransferUnitPrice();
      result = result * 59 + ($transferUnitPrice == null ? 43 : $transferUnitPrice.hashCode());
      Object $transferUnitPriceExcludingVat = this.getTransferUnitPriceExcludingVat();
      result = result * 59 + ($transferUnitPriceExcludingVat == null ? 43 : $transferUnitPriceExcludingVat.hashCode());
      Object $transferAmountNoFreight = this.getTransferAmountNoFreight();
      result = result * 59 + ($transferAmountNoFreight == null ? 43 : $transferAmountNoFreight.hashCode());
      Object $transferAmountExcludingVatNoFreight = this.getTransferAmountExcludingVatNoFreight();
      result = result * 59 + ($transferAmountExcludingVatNoFreight == null ? 43 : $transferAmountExcludingVatNoFreight.hashCode());
      Object $transferUnitPriceNoFreight = this.getTransferUnitPriceNoFreight();
      result = result * 59 + ($transferUnitPriceNoFreight == null ? 43 : $transferUnitPriceNoFreight.hashCode());
      Object $transferUnitPriceExcludingVatNoFreight = this.getTransferUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($transferUnitPriceExcludingVatNoFreight == null ? 43 : $transferUnitPriceExcludingVatNoFreight.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
      result = result * 59 + ($outboundAmountExcludingVat == null ? 43 : $outboundAmountExcludingVat.hashCode());
      Object $outboundUnitPrice = this.getOutboundUnitPrice();
      result = result * 59 + ($outboundUnitPrice == null ? 43 : $outboundUnitPrice.hashCode());
      Object $outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
      result = result * 59 + ($outboundUnitPriceExcludingVat == null ? 43 : $outboundUnitPriceExcludingVat.hashCode());
      Object $endMete = this.getEndMete();
      result = result * 59 + ($endMete == null ? 43 : $endMete.hashCode());
      Object $endQuantity = this.getEndQuantity();
      result = result * 59 + ($endQuantity == null ? 43 : $endQuantity.hashCode());
      Object $endAmount = this.getEndAmount();
      result = result * 59 + ($endAmount == null ? 43 : $endAmount.hashCode());
      Object $endAmountExcludingVat = this.getEndAmountExcludingVat();
      result = result * 59 + ($endAmountExcludingVat == null ? 43 : $endAmountExcludingVat.hashCode());
      Object $endUnitPrice = this.getEndUnitPrice();
      result = result * 59 + ($endUnitPrice == null ? 43 : $endUnitPrice.hashCode());
      Object $endUnitPriceExcludingVat = this.getEndUnitPriceExcludingVat();
      result = result * 59 + ($endUnitPriceExcludingVat == null ? 43 : $endUnitPriceExcludingVat.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $inboundAmountNoFreight = this.getInboundAmountNoFreight();
      result = result * 59 + ($inboundAmountNoFreight == null ? 43 : $inboundAmountNoFreight.hashCode());
      Object $inboundAmountExcludingVatNoFreight = this.getInboundAmountExcludingVatNoFreight();
      result = result * 59 + ($inboundAmountExcludingVatNoFreight == null ? 43 : $inboundAmountExcludingVatNoFreight.hashCode());
      Object $inboundUnitPriceNoFreight = this.getInboundUnitPriceNoFreight();
      result = result * 59 + ($inboundUnitPriceNoFreight == null ? 43 : $inboundUnitPriceNoFreight.hashCode());
      Object $inboundUnitPriceExcludingVatNoFreight = this.getInboundUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($inboundUnitPriceExcludingVatNoFreight == null ? 43 : $inboundUnitPriceExcludingVatNoFreight.hashCode());
      Object $outboundAmountNoFreight = this.getOutboundAmountNoFreight();
      result = result * 59 + ($outboundAmountNoFreight == null ? 43 : $outboundAmountNoFreight.hashCode());
      Object $outboundAmountExcludingVatNoFreight = this.getOutboundAmountExcludingVatNoFreight();
      result = result * 59 + ($outboundAmountExcludingVatNoFreight == null ? 43 : $outboundAmountExcludingVatNoFreight.hashCode());
      Object $outboundUnitPriceNoFreight = this.getOutboundUnitPriceNoFreight();
      result = result * 59 + ($outboundUnitPriceNoFreight == null ? 43 : $outboundUnitPriceNoFreight.hashCode());
      Object $outboundUnitPriceExcludingVatNoFreight = this.getOutboundUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($outboundUnitPriceExcludingVatNoFreight == null ? 43 : $outboundUnitPriceExcludingVatNoFreight.hashCode());
      Object $endAmountNoFreight = this.getEndAmountNoFreight();
      result = result * 59 + ($endAmountNoFreight == null ? 43 : $endAmountNoFreight.hashCode());
      Object $endAmountExcludingVatNoFreight = this.getEndAmountExcludingVatNoFreight();
      result = result * 59 + ($endAmountExcludingVatNoFreight == null ? 43 : $endAmountExcludingVatNoFreight.hashCode());
      Object $endUnitPriceNoFreight = this.getEndUnitPriceNoFreight();
      result = result * 59 + ($endUnitPriceNoFreight == null ? 43 : $endUnitPriceNoFreight.hashCode());
      Object $endUnitPriceExcludingVatNoFreight = this.getEndUnitPriceExcludingVatNoFreight();
      return result * 59 + ($endUnitPriceExcludingVatNoFreight == null ? 43 : $endUnitPriceExcludingVatNoFreight.hashCode());
   }

   public static class StatisticsBuilder {
      private Long id;
      private Long wapId;
      private String specs;
      private Integer basicClass;
      private Long classifyId;
      private Long projectId;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private BigDecimal unitNet;
      private Boolean boolPartyA;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Long standardId;
      private String standardName;
      private BigDecimal totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal inboundMete;
      private BigDecimal inboundQuantity;
      private BigDecimal inboundAmount;
      private BigDecimal inboundAmountExcludingVat;
      private BigDecimal inboundUnitPrice;
      private BigDecimal inboundUnitPriceExcludingVat;
      private BigDecimal transferMete;
      private BigDecimal transferQuantity;
      private BigDecimal transferAmount;
      private BigDecimal transferAmountExcludingVat;
      private BigDecimal transferUnitPrice;
      private BigDecimal transferUnitPriceExcludingVat;
      private BigDecimal transferAmountNoFreight;
      private BigDecimal transferAmountExcludingVatNoFreight;
      private BigDecimal transferUnitPriceNoFreight;
      private BigDecimal transferUnitPriceExcludingVatNoFreight;
      private BigDecimal outboundMete;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundAmount;
      private BigDecimal outboundAmountExcludingVat;
      private BigDecimal outboundUnitPrice;
      private BigDecimal outboundUnitPriceExcludingVat;
      private BigDecimal endMete;
      private BigDecimal endQuantity;
      private BigDecimal endAmount;
      private BigDecimal endAmountExcludingVat;
      private BigDecimal endUnitPrice;
      private BigDecimal endUnitPriceExcludingVat;
      private Long workshopId;
      private String specification;
      private BigDecimal inboundAmountNoFreight;
      private BigDecimal inboundAmountExcludingVatNoFreight;
      private BigDecimal inboundUnitPriceNoFreight;
      private BigDecimal inboundUnitPriceExcludingVatNoFreight;
      private BigDecimal outboundAmountNoFreight;
      private BigDecimal outboundAmountExcludingVatNoFreight;
      private BigDecimal outboundUnitPriceNoFreight;
      private BigDecimal outboundUnitPriceExcludingVatNoFreight;
      private BigDecimal endAmountNoFreight;
      private BigDecimal endAmountExcludingVatNoFreight;
      private BigDecimal endUnitPriceNoFreight;
      private BigDecimal endUnitPriceExcludingVatNoFreight;

      StatisticsBuilder() {
      }

      @JsonProperty("id")
      public Statistics.StatisticsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("wapId")
      public Statistics.StatisticsBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("specs")
      public Statistics.StatisticsBuilder specs(final String specs) {
         this.specs = specs;
         return this;
      }

      @JsonProperty("basicClass")
      public Statistics.StatisticsBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public Statistics.StatisticsBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("projectId")
      public Statistics.StatisticsBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("thickness")
      public Statistics.StatisticsBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public Statistics.StatisticsBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public Statistics.StatisticsBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public Statistics.StatisticsBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public Statistics.StatisticsBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("unitNet")
      public Statistics.StatisticsBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Statistics.StatisticsBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("invoiceType")
      public Statistics.StatisticsBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public Statistics.StatisticsBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("standardId")
      public Statistics.StatisticsBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public Statistics.StatisticsBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("totalQuantity")
      public Statistics.StatisticsBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalMete")
      public Statistics.StatisticsBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("inboundMete")
      public Statistics.StatisticsBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public Statistics.StatisticsBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("inboundAmount")
      public Statistics.StatisticsBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVat")
      public Statistics.StatisticsBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("inboundUnitPrice")
      public Statistics.StatisticsBuilder inboundUnitPrice(final BigDecimal inboundUnitPrice) {
         this.inboundUnitPrice = inboundUnitPrice;
         return this;
      }

      @JsonProperty("inboundUnitPriceExcludingVat")
      public Statistics.StatisticsBuilder inboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
         this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("transferMete")
      public Statistics.StatisticsBuilder transferMete(final BigDecimal transferMete) {
         this.transferMete = transferMete;
         return this;
      }

      @JsonProperty("transferQuantity")
      public Statistics.StatisticsBuilder transferQuantity(final BigDecimal transferQuantity) {
         this.transferQuantity = transferQuantity;
         return this;
      }

      @JsonProperty("transferAmount")
      public Statistics.StatisticsBuilder transferAmount(final BigDecimal transferAmount) {
         this.transferAmount = transferAmount;
         return this;
      }

      @JsonProperty("transferAmountExcludingVat")
      public Statistics.StatisticsBuilder transferAmountExcludingVat(final BigDecimal transferAmountExcludingVat) {
         this.transferAmountExcludingVat = transferAmountExcludingVat;
         return this;
      }

      @JsonProperty("transferUnitPrice")
      public Statistics.StatisticsBuilder transferUnitPrice(final BigDecimal transferUnitPrice) {
         this.transferUnitPrice = transferUnitPrice;
         return this;
      }

      @JsonProperty("transferUnitPriceExcludingVat")
      public Statistics.StatisticsBuilder transferUnitPriceExcludingVat(final BigDecimal transferUnitPriceExcludingVat) {
         this.transferUnitPriceExcludingVat = transferUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("transferAmountNoFreight")
      public Statistics.StatisticsBuilder transferAmountNoFreight(final BigDecimal transferAmountNoFreight) {
         this.transferAmountNoFreight = transferAmountNoFreight;
         return this;
      }

      @JsonProperty("transferAmountExcludingVatNoFreight")
      public Statistics.StatisticsBuilder transferAmountExcludingVatNoFreight(final BigDecimal transferAmountExcludingVatNoFreight) {
         this.transferAmountExcludingVatNoFreight = transferAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("transferUnitPriceNoFreight")
      public Statistics.StatisticsBuilder transferUnitPriceNoFreight(final BigDecimal transferUnitPriceNoFreight) {
         this.transferUnitPriceNoFreight = transferUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("transferUnitPriceExcludingVatNoFreight")
      public Statistics.StatisticsBuilder transferUnitPriceExcludingVatNoFreight(final BigDecimal transferUnitPriceExcludingVatNoFreight) {
         this.transferUnitPriceExcludingVatNoFreight = transferUnitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundMete")
      public Statistics.StatisticsBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      @JsonProperty("outboundQuantity")
      public Statistics.StatisticsBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      @JsonProperty("outboundAmount")
      public Statistics.StatisticsBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVat")
      public Statistics.StatisticsBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("outboundUnitPrice")
      public Statistics.StatisticsBuilder outboundUnitPrice(final BigDecimal outboundUnitPrice) {
         this.outboundUnitPrice = outboundUnitPrice;
         return this;
      }

      @JsonProperty("outboundUnitPriceExcludingVat")
      public Statistics.StatisticsBuilder outboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
         this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("endMete")
      public Statistics.StatisticsBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      @JsonProperty("endQuantity")
      public Statistics.StatisticsBuilder endQuantity(final BigDecimal endQuantity) {
         this.endQuantity = endQuantity;
         return this;
      }

      @JsonProperty("endAmount")
      public Statistics.StatisticsBuilder endAmount(final BigDecimal endAmount) {
         this.endAmount = endAmount;
         return this;
      }

      @JsonProperty("endAmountExcludingVat")
      public Statistics.StatisticsBuilder endAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
         this.endAmountExcludingVat = endAmountExcludingVat;
         return this;
      }

      @JsonProperty("endUnitPrice")
      public Statistics.StatisticsBuilder endUnitPrice(final BigDecimal endUnitPrice) {
         this.endUnitPrice = endUnitPrice;
         return this;
      }

      @JsonProperty("endUnitPriceExcludingVat")
      public Statistics.StatisticsBuilder endUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
         this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("workshopId")
      public Statistics.StatisticsBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("specification")
      public Statistics.StatisticsBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("inboundAmountNoFreight")
      public Statistics.StatisticsBuilder inboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
         this.inboundAmountNoFreight = inboundAmountNoFreight;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVatNoFreight")
      public Statistics.StatisticsBuilder inboundAmountExcludingVatNoFreight(final BigDecimal inboundAmountExcludingVatNoFreight) {
         this.inboundAmountExcludingVatNoFreight = inboundAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inboundUnitPriceNoFreight")
      public Statistics.StatisticsBuilder inboundUnitPriceNoFreight(final BigDecimal inboundUnitPriceNoFreight) {
         this.inboundUnitPriceNoFreight = inboundUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("inboundUnitPriceExcludingVatNoFreight")
      public Statistics.StatisticsBuilder inboundUnitPriceExcludingVatNoFreight(final BigDecimal inboundUnitPriceExcludingVatNoFreight) {
         this.inboundUnitPriceExcludingVatNoFreight = inboundUnitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundAmountNoFreight")
      public Statistics.StatisticsBuilder outboundAmountNoFreight(final BigDecimal outboundAmountNoFreight) {
         this.outboundAmountNoFreight = outboundAmountNoFreight;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVatNoFreight")
      public Statistics.StatisticsBuilder outboundAmountExcludingVatNoFreight(final BigDecimal outboundAmountExcludingVatNoFreight) {
         this.outboundAmountExcludingVatNoFreight = outboundAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundUnitPriceNoFreight")
      public Statistics.StatisticsBuilder outboundUnitPriceNoFreight(final BigDecimal outboundUnitPriceNoFreight) {
         this.outboundUnitPriceNoFreight = outboundUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("outboundUnitPriceExcludingVatNoFreight")
      public Statistics.StatisticsBuilder outboundUnitPriceExcludingVatNoFreight(final BigDecimal outboundUnitPriceExcludingVatNoFreight) {
         this.outboundUnitPriceExcludingVatNoFreight = outboundUnitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("endAmountNoFreight")
      public Statistics.StatisticsBuilder endAmountNoFreight(final BigDecimal endAmountNoFreight) {
         this.endAmountNoFreight = endAmountNoFreight;
         return this;
      }

      @JsonProperty("endAmountExcludingVatNoFreight")
      public Statistics.StatisticsBuilder endAmountExcludingVatNoFreight(final BigDecimal endAmountExcludingVatNoFreight) {
         this.endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("endUnitPriceNoFreight")
      public Statistics.StatisticsBuilder endUnitPriceNoFreight(final BigDecimal endUnitPriceNoFreight) {
         this.endUnitPriceNoFreight = endUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("endUnitPriceExcludingVatNoFreight")
      public Statistics.StatisticsBuilder endUnitPriceExcludingVatNoFreight(final BigDecimal endUnitPriceExcludingVatNoFreight) {
         this.endUnitPriceExcludingVatNoFreight = endUnitPriceExcludingVatNoFreight;
         return this;
      }

      public Statistics build() {
         return new Statistics(
            this.id,
            this.wapId,
            this.specs,
            this.basicClass,
            this.classifyId,
            this.projectId,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.unitNet,
            this.boolPartyA,
            this.invoiceType,
            this.taxRate,
            this.standardId,
            this.standardName,
            this.totalQuantity,
            this.totalMete,
            this.inboundMete,
            this.inboundQuantity,
            this.inboundAmount,
            this.inboundAmountExcludingVat,
            this.inboundUnitPrice,
            this.inboundUnitPriceExcludingVat,
            this.transferMete,
            this.transferQuantity,
            this.transferAmount,
            this.transferAmountExcludingVat,
            this.transferUnitPrice,
            this.transferUnitPriceExcludingVat,
            this.transferAmountNoFreight,
            this.transferAmountExcludingVatNoFreight,
            this.transferUnitPriceNoFreight,
            this.transferUnitPriceExcludingVatNoFreight,
            this.outboundMete,
            this.outboundQuantity,
            this.outboundAmount,
            this.outboundAmountExcludingVat,
            this.outboundUnitPrice,
            this.outboundUnitPriceExcludingVat,
            this.endMete,
            this.endQuantity,
            this.endAmount,
            this.endAmountExcludingVat,
            this.endUnitPrice,
            this.endUnitPriceExcludingVat,
            this.workshopId,
            this.specification,
            this.inboundAmountNoFreight,
            this.inboundAmountExcludingVatNoFreight,
            this.inboundUnitPriceNoFreight,
            this.inboundUnitPriceExcludingVatNoFreight,
            this.outboundAmountNoFreight,
            this.outboundAmountExcludingVatNoFreight,
            this.outboundUnitPriceNoFreight,
            this.outboundUnitPriceExcludingVatNoFreight,
            this.endAmountNoFreight,
            this.endAmountExcludingVatNoFreight,
            this.endUnitPriceNoFreight,
            this.endUnitPriceExcludingVatNoFreight
         );
      }

      @Override
      public String toString() {
         return "Statistics.StatisticsBuilder(id="
            + this.id
            + ", wapId="
            + this.wapId
            + ", specs="
            + this.specs
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", projectId="
            + this.projectId
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", unitNet="
            + this.unitNet
            + ", boolPartyA="
            + this.boolPartyA
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", inboundMete="
            + this.inboundMete
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", inboundAmount="
            + this.inboundAmount
            + ", inboundAmountExcludingVat="
            + this.inboundAmountExcludingVat
            + ", inboundUnitPrice="
            + this.inboundUnitPrice
            + ", inboundUnitPriceExcludingVat="
            + this.inboundUnitPriceExcludingVat
            + ", transferMete="
            + this.transferMete
            + ", transferQuantity="
            + this.transferQuantity
            + ", transferAmount="
            + this.transferAmount
            + ", transferAmountExcludingVat="
            + this.transferAmountExcludingVat
            + ", transferUnitPrice="
            + this.transferUnitPrice
            + ", transferUnitPriceExcludingVat="
            + this.transferUnitPriceExcludingVat
            + ", transferAmountNoFreight="
            + this.transferAmountNoFreight
            + ", transferAmountExcludingVatNoFreight="
            + this.transferAmountExcludingVatNoFreight
            + ", transferUnitPriceNoFreight="
            + this.transferUnitPriceNoFreight
            + ", transferUnitPriceExcludingVatNoFreight="
            + this.transferUnitPriceExcludingVatNoFreight
            + ", outboundMete="
            + this.outboundMete
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundAmount="
            + this.outboundAmount
            + ", outboundAmountExcludingVat="
            + this.outboundAmountExcludingVat
            + ", outboundUnitPrice="
            + this.outboundUnitPrice
            + ", outboundUnitPriceExcludingVat="
            + this.outboundUnitPriceExcludingVat
            + ", endMete="
            + this.endMete
            + ", endQuantity="
            + this.endQuantity
            + ", endAmount="
            + this.endAmount
            + ", endAmountExcludingVat="
            + this.endAmountExcludingVat
            + ", endUnitPrice="
            + this.endUnitPrice
            + ", endUnitPriceExcludingVat="
            + this.endUnitPriceExcludingVat
            + ", workshopId="
            + this.workshopId
            + ", specification="
            + this.specification
            + ", inboundAmountNoFreight="
            + this.inboundAmountNoFreight
            + ", inboundAmountExcludingVatNoFreight="
            + this.inboundAmountExcludingVatNoFreight
            + ", inboundUnitPriceNoFreight="
            + this.inboundUnitPriceNoFreight
            + ", inboundUnitPriceExcludingVatNoFreight="
            + this.inboundUnitPriceExcludingVatNoFreight
            + ", outboundAmountNoFreight="
            + this.outboundAmountNoFreight
            + ", outboundAmountExcludingVatNoFreight="
            + this.outboundAmountExcludingVatNoFreight
            + ", outboundUnitPriceNoFreight="
            + this.outboundUnitPriceNoFreight
            + ", outboundUnitPriceExcludingVatNoFreight="
            + this.outboundUnitPriceExcludingVatNoFreight
            + ", endAmountNoFreight="
            + this.endAmountNoFreight
            + ", endAmountExcludingVatNoFreight="
            + this.endAmountExcludingVatNoFreight
            + ", endUnitPriceNoFreight="
            + this.endUnitPriceNoFreight
            + ", endUnitPriceExcludingVatNoFreight="
            + this.endUnitPriceExcludingVatNoFreight
            + ")";
      }
   }
}
