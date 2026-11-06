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

@ApiModel(value = "WmsStatisticsClosingTime对象", description = "")
@Entity
@TableName("wms_statistics_closing_time")
@Table(name = "wms_statistics_closing_time")
@org.hibernate.annotations.Table(appliesTo = "wms_statistics_closing_time")
public class WmsStatisticsClosingTime extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "boolCross")
   @JsonProperty("boolCross")
   @JSONField(name = "boolCross")
   @TableField("bool_cross")
   @Column(name = "bool_cross", columnDefinition = "tinyint(1) default '0' COMMENT '是否跨组织（经典数据打通）'", nullable = true)
   private Boolean boolCross;
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
   private Long WmsClosingTimeId;
   @ApiModelProperty(name = "statisticsId", value = "收发存ID", notes = "收发存ID")
   @JsonProperty("statisticsId")
   @JSONField(name = "statisticsId")
   @TableField("statistics_id")
   @Column(name = "statistics_id", columnDefinition = "bigint  COMMENT '收发存ID'", nullable = true)
   private Long statisticsId;
   @ApiModelProperty(name = "mesWorkshopId", value = "富煌定制车间ID -> mes", notes = "富煌定制车间ID -> mes")
   @JsonProperty("mesWorkshopId")
   @JSONField(name = "mesWorkshopId")
   @TableField("mes_workshop_id")
   @Column(name = "mes_workshop_id", columnDefinition = "bigint  COMMENT '车间ID -> mes'", nullable = true)
   private Long mesWorkshopId;

   public static WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder builder() {
      return new WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder();
   }

   public WmsStatisticsClosingTime() {
   }

   public WmsStatisticsClosingTime(
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
      final Boolean boolCross,
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
      final BigDecimal endUnitPriceExcludingVatNoFreight,
      final Long WmsClosingTimeId,
      final Long statisticsId,
      final Long mesWorkshopId
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
      this.boolCross = boolCross;
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
      this.WmsClosingTimeId = WmsClosingTimeId;
      this.statisticsId = statisticsId;
      this.mesWorkshopId = mesWorkshopId;
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

   public Boolean getBoolCross() {
      return this.boolCross;
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

   public Long getWmsClosingTimeId() {
      return this.WmsClosingTimeId;
   }

   public Long getStatisticsId() {
      return this.statisticsId;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   @JsonProperty("id")
   public WmsStatisticsClosingTime setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("wapId")
   public WmsStatisticsClosingTime setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("specs")
   public WmsStatisticsClosingTime setSpecs(final String specs) {
      this.specs = specs;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsStatisticsClosingTime setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public WmsStatisticsClosingTime setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("projectId")
   public WmsStatisticsClosingTime setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("thickness")
   public WmsStatisticsClosingTime setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public WmsStatisticsClosingTime setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public WmsStatisticsClosingTime setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public WmsStatisticsClosingTime setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public WmsStatisticsClosingTime setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("unitNet")
   public WmsStatisticsClosingTime setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("boolPartyA")
   public WmsStatisticsClosingTime setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("invoiceType")
   public WmsStatisticsClosingTime setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public WmsStatisticsClosingTime setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("standardId")
   public WmsStatisticsClosingTime setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public WmsStatisticsClosingTime setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("totalQuantity")
   public WmsStatisticsClosingTime setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalMete")
   public WmsStatisticsClosingTime setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("inboundMete")
   public WmsStatisticsClosingTime setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public WmsStatisticsClosingTime setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("inboundAmount")
   public WmsStatisticsClosingTime setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVat")
   public WmsStatisticsClosingTime setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("inboundUnitPrice")
   public WmsStatisticsClosingTime setInboundUnitPrice(final BigDecimal inboundUnitPrice) {
      this.inboundUnitPrice = inboundUnitPrice;
      return this;
   }

   @JsonProperty("inboundUnitPriceExcludingVat")
   public WmsStatisticsClosingTime setInboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("outboundMete")
   public WmsStatisticsClosingTime setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   @JsonProperty("outboundQuantity")
   public WmsStatisticsClosingTime setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   @JsonProperty("outboundAmount")
   public WmsStatisticsClosingTime setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVat")
   public WmsStatisticsClosingTime setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("outboundUnitPrice")
   public WmsStatisticsClosingTime setOutboundUnitPrice(final BigDecimal outboundUnitPrice) {
      this.outboundUnitPrice = outboundUnitPrice;
      return this;
   }

   @JsonProperty("outboundUnitPriceExcludingVat")
   public WmsStatisticsClosingTime setOutboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("endMete")
   public WmsStatisticsClosingTime setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
      return this;
   }

   @JsonProperty("endQuantity")
   public WmsStatisticsClosingTime setEndQuantity(final BigDecimal endQuantity) {
      this.endQuantity = endQuantity;
      return this;
   }

   @JsonProperty("endAmount")
   public WmsStatisticsClosingTime setEndAmount(final BigDecimal endAmount) {
      this.endAmount = endAmount;
      return this;
   }

   @JsonProperty("endAmountExcludingVat")
   public WmsStatisticsClosingTime setEndAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
      this.endAmountExcludingVat = endAmountExcludingVat;
      return this;
   }

   @JsonProperty("endUnitPrice")
   public WmsStatisticsClosingTime setEndUnitPrice(final BigDecimal endUnitPrice) {
      this.endUnitPrice = endUnitPrice;
      return this;
   }

   @JsonProperty("endUnitPriceExcludingVat")
   public WmsStatisticsClosingTime setEndUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("workshopId")
   public WmsStatisticsClosingTime setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("specification")
   public WmsStatisticsClosingTime setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("boolCross")
   public WmsStatisticsClosingTime setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
      return this;
   }

   @JsonProperty("inboundAmountNoFreight")
   public WmsStatisticsClosingTime setInboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
      this.inboundAmountNoFreight = inboundAmountNoFreight;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVatNoFreight")
   public WmsStatisticsClosingTime setInboundAmountExcludingVatNoFreight(final BigDecimal inboundAmountExcludingVatNoFreight) {
      this.inboundAmountExcludingVatNoFreight = inboundAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inboundUnitPriceNoFreight")
   public WmsStatisticsClosingTime setInboundUnitPriceNoFreight(final BigDecimal inboundUnitPriceNoFreight) {
      this.inboundUnitPriceNoFreight = inboundUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("inboundUnitPriceExcludingVatNoFreight")
   public WmsStatisticsClosingTime setInboundUnitPriceExcludingVatNoFreight(final BigDecimal inboundUnitPriceExcludingVatNoFreight) {
      this.inboundUnitPriceExcludingVatNoFreight = inboundUnitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundAmountNoFreight")
   public WmsStatisticsClosingTime setOutboundAmountNoFreight(final BigDecimal outboundAmountNoFreight) {
      this.outboundAmountNoFreight = outboundAmountNoFreight;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVatNoFreight")
   public WmsStatisticsClosingTime setOutboundAmountExcludingVatNoFreight(final BigDecimal outboundAmountExcludingVatNoFreight) {
      this.outboundAmountExcludingVatNoFreight = outboundAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("outboundUnitPriceNoFreight")
   public WmsStatisticsClosingTime setOutboundUnitPriceNoFreight(final BigDecimal outboundUnitPriceNoFreight) {
      this.outboundUnitPriceNoFreight = outboundUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("outboundUnitPriceExcludingVatNoFreight")
   public WmsStatisticsClosingTime setOutboundUnitPriceExcludingVatNoFreight(final BigDecimal outboundUnitPriceExcludingVatNoFreight) {
      this.outboundUnitPriceExcludingVatNoFreight = outboundUnitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("endAmountNoFreight")
   public WmsStatisticsClosingTime setEndAmountNoFreight(final BigDecimal endAmountNoFreight) {
      this.endAmountNoFreight = endAmountNoFreight;
      return this;
   }

   @JsonProperty("endAmountExcludingVatNoFreight")
   public WmsStatisticsClosingTime setEndAmountExcludingVatNoFreight(final BigDecimal endAmountExcludingVatNoFreight) {
      this.endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("endUnitPriceNoFreight")
   public WmsStatisticsClosingTime setEndUnitPriceNoFreight(final BigDecimal endUnitPriceNoFreight) {
      this.endUnitPriceNoFreight = endUnitPriceNoFreight;
      return this;
   }

   @JsonProperty("endUnitPriceExcludingVatNoFreight")
   public WmsStatisticsClosingTime setEndUnitPriceExcludingVatNoFreight(final BigDecimal endUnitPriceExcludingVatNoFreight) {
      this.endUnitPriceExcludingVatNoFreight = endUnitPriceExcludingVatNoFreight;
      return this;
   }

   public WmsStatisticsClosingTime setWmsClosingTimeId(final Long WmsClosingTimeId) {
      this.WmsClosingTimeId = WmsClosingTimeId;
      return this;
   }

   @JsonProperty("statisticsId")
   public WmsStatisticsClosingTime setStatisticsId(final Long statisticsId) {
      this.statisticsId = statisticsId;
      return this;
   }

   @JsonProperty("mesWorkshopId")
   public WmsStatisticsClosingTime setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsStatisticsClosingTime(id="
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
         + ", boolCross="
         + this.getBoolCross()
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
         + ", WmsClosingTimeId="
         + this.getWmsClosingTimeId()
         + ", statisticsId="
         + this.getStatisticsId()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsStatisticsClosingTime)) {
         return false;
      }

      WmsStatisticsClosingTime other = (WmsStatisticsClosingTime)o;
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
                                 Object this$boolCross = this.getBoolCross();
                                 Object other$boolCross = other.getBoolCross();
                                 if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
                                    Object this$WmsClosingTimeId = this.getWmsClosingTimeId();
                                    Object other$WmsClosingTimeId = other.getWmsClosingTimeId();
                                    if (this$WmsClosingTimeId == null ? other$WmsClosingTimeId == null : this$WmsClosingTimeId.equals(other$WmsClosingTimeId)) {
                                       Object this$statisticsId = this.getStatisticsId();
                                       Object other$statisticsId = other.getStatisticsId();
                                       if (this$statisticsId == null ? other$statisticsId == null : this$statisticsId.equals(other$statisticsId)) {
                                          Object this$mesWorkshopId = this.getMesWorkshopId();
                                          Object other$mesWorkshopId = other.getMesWorkshopId();
                                          if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                                             Object this$specs = this.getSpecs();
                                             Object other$specs = other.getSpecs();
                                             if (this$specs == null ? other$specs == null : this$specs.equals(other$specs)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$theoryThickness = this.getTheoryThickness();
                                                   Object other$theoryThickness = other.getTheoryThickness();
                                                   if (this$theoryThickness == null
                                                      ? other$theoryThickness == null
                                                      : this$theoryThickness.equals(other$theoryThickness)) {
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
                                                                           if (this$totalMete == null
                                                                              ? other$totalMete == null
                                                                              : this$totalMete.equals(other$totalMete)) {
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
                                                                                          : this$inboundAmountExcludingVat.equals(
                                                                                             other$inboundAmountExcludingVat
                                                                                          )) {
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
                                                                                                Object this$outboundMete = this.getOutboundMete();
                                                                                                Object other$outboundMete = other.getOutboundMete();
                                                                                                if (this$outboundMete == null
                                                                                                   ? other$outboundMete == null
                                                                                                   : this$outboundMete.equals(other$outboundMete)) {
                                                                                                   Object this$outboundQuantity = this.getOutboundQuantity();
                                                                                                   Object other$outboundQuantity = other.getOutboundQuantity();
                                                                                                   if (this$outboundQuantity == null
                                                                                                      ? other$outboundQuantity == null
                                                                                                      : this$outboundQuantity.equals(other$outboundQuantity)) {
                                                                                                      Object this$outboundAmount = this.getOutboundAmount();
                                                                                                      Object other$outboundAmount = other.getOutboundAmount();
                                                                                                      if (this$outboundAmount == null
                                                                                                         ? other$outboundAmount == null
                                                                                                         : this$outboundAmount.equals(other$outboundAmount)) {
                                                                                                         Object this$outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
                                                                                                         Object other$outboundAmountExcludingVat = other.getOutboundAmountExcludingVat();
                                                                                                         if (this$outboundAmountExcludingVat == null
                                                                                                            ? other$outboundAmountExcludingVat == null
                                                                                                            : this$outboundAmountExcludingVat.equals(
                                                                                                               other$outboundAmountExcludingVat
                                                                                                            )) {
                                                                                                            Object this$outboundUnitPrice = this.getOutboundUnitPrice();
                                                                                                            Object other$outboundUnitPrice = other.getOutboundUnitPrice();
                                                                                                            if (this$outboundUnitPrice == null
                                                                                                               ? other$outboundUnitPrice == null
                                                                                                               : this$outboundUnitPrice.equals(
                                                                                                                  other$outboundUnitPrice
                                                                                                               )) {
                                                                                                               Object this$outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
                                                                                                               Object other$outboundUnitPriceExcludingVat = other.getOutboundUnitPriceExcludingVat();
                                                                                                               if (this$outboundUnitPriceExcludingVat == null
                                                                                                                  ? other$outboundUnitPriceExcludingVat == null
                                                                                                                  : this$outboundUnitPriceExcludingVat.equals(
                                                                                                                     other$outboundUnitPriceExcludingVat
                                                                                                                  )) {
                                                                                                                  Object this$endMete = this.getEndMete();
                                                                                                                  Object other$endMete = other.getEndMete();
                                                                                                                  if (this$endMete == null
                                                                                                                     ? other$endMete == null
                                                                                                                     : this$endMete.equals(other$endMete)) {
                                                                                                                     Object this$endQuantity = this.getEndQuantity();
                                                                                                                     Object other$endQuantity = other.getEndQuantity();
                                                                                                                     if (this$endQuantity == null
                                                                                                                        ? other$endQuantity == null
                                                                                                                        : this$endQuantity.equals(
                                                                                                                           other$endQuantity
                                                                                                                        )) {
                                                                                                                        Object this$endAmount = this.getEndAmount();
                                                                                                                        Object other$endAmount = other.getEndAmount();
                                                                                                                        if (this$endAmount == null
                                                                                                                           ? other$endAmount == null
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
                                                                                                                              if (this$endUnitPrice == null
                                                                                                                                 ? other$endUnitPrice == null
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
                                                                                                                                             )) {
                                                                                                                                             Object this$inboundUnitPriceNoFreight = this.getInboundUnitPriceNoFreight();
                                                                                                                                             Object other$inboundUnitPriceNoFreight = other.getInboundUnitPriceNoFreight();
                                                                                                                                             if (this$inboundUnitPriceNoFreight
                                                                                                                                                   == null
                                                                                                                                                ? other$inboundUnitPriceNoFreight
                                                                                                                                                   == null
                                                                                                                                                : this$inboundUnitPriceNoFreight.equals(
                                                                                                                                                   other$inboundUnitPriceNoFreight
                                                                                                                                                )) {
                                                                                                                                                Object this$inboundUnitPriceExcludingVatNoFreight = this.getInboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                Object other$inboundUnitPriceExcludingVatNoFreight = other.getInboundUnitPriceExcludingVatNoFreight();
                                                                                                                                                if (this$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                      == null
                                                                                                                                                   ? other$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                      == null
                                                                                                                                                   : this$inboundUnitPriceExcludingVatNoFreight.equals(
                                                                                                                                                      other$inboundUnitPriceExcludingVatNoFreight
                                                                                                                                                   )) {
                                                                                                                                                   Object this$outboundAmountNoFreight = this.getOutboundAmountNoFreight();
                                                                                                                                                   Object other$outboundAmountNoFreight = other.getOutboundAmountNoFreight();
                                                                                                                                                   if (this$outboundAmountNoFreight
                                                                                                                                                         == null
                                                                                                                                                      ? other$outboundAmountNoFreight
                                                                                                                                                         == null
                                                                                                                                                      : this$outboundAmountNoFreight.equals(
                                                                                                                                                         other$outboundAmountNoFreight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$outboundAmountExcludingVatNoFreight = this.getOutboundAmountExcludingVatNoFreight();
                                                                                                                                                      Object other$outboundAmountExcludingVatNoFreight = other.getOutboundAmountExcludingVatNoFreight();
                                                                                                                                                      if (this$outboundAmountExcludingVatNoFreight
                                                                                                                                                            == null
                                                                                                                                                         ? other$outboundAmountExcludingVatNoFreight
                                                                                                                                                            == null
                                                                                                                                                         : this$outboundAmountExcludingVatNoFreight.equals(
                                                                                                                                                            other$outboundAmountExcludingVatNoFreight
                                                                                                                                                         )) {
                                                                                                                                                         Object this$outboundUnitPriceNoFreight = this.getOutboundUnitPriceNoFreight();
                                                                                                                                                         Object other$outboundUnitPriceNoFreight = other.getOutboundUnitPriceNoFreight();
                                                                                                                                                         if (this$outboundUnitPriceNoFreight
                                                                                                                                                               == null
                                                                                                                                                            ? other$outboundUnitPriceNoFreight
                                                                                                                                                               == null
                                                                                                                                                            : this$outboundUnitPriceNoFreight.equals(
                                                                                                                                                               other$outboundUnitPriceNoFreight
                                                                                                                                                            )) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsStatisticsClosingTime;
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
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $WmsClosingTimeId = this.getWmsClosingTimeId();
      result = result * 59 + ($WmsClosingTimeId == null ? 43 : $WmsClosingTimeId.hashCode());
      Object $statisticsId = this.getStatisticsId();
      result = result * 59 + ($statisticsId == null ? 43 : $statisticsId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
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

   public static class WmsStatisticsClosingTimeBuilder {
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
      private Boolean boolCross;
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
      private Long WmsClosingTimeId;
      private Long statisticsId;
      private Long mesWorkshopId;

      WmsStatisticsClosingTimeBuilder() {
      }

      @JsonProperty("id")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("wapId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("specs")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder specs(final String specs) {
         this.specs = specs;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("projectId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("thickness")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("unitNet")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("boolPartyA")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("invoiceType")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("standardId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("totalQuantity")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalMete")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("inboundMete")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("inboundAmount")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("inboundUnitPrice")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundUnitPrice(final BigDecimal inboundUnitPrice) {
         this.inboundUnitPrice = inboundUnitPrice;
         return this;
      }

      @JsonProperty("inboundUnitPriceExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
         this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("outboundMete")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      @JsonProperty("outboundQuantity")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      @JsonProperty("outboundAmount")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("outboundUnitPrice")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundUnitPrice(final BigDecimal outboundUnitPrice) {
         this.outboundUnitPrice = outboundUnitPrice;
         return this;
      }

      @JsonProperty("outboundUnitPriceExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
         this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("endMete")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      @JsonProperty("endQuantity")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endQuantity(final BigDecimal endQuantity) {
         this.endQuantity = endQuantity;
         return this;
      }

      @JsonProperty("endAmount")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endAmount(final BigDecimal endAmount) {
         this.endAmount = endAmount;
         return this;
      }

      @JsonProperty("endAmountExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
         this.endAmountExcludingVat = endAmountExcludingVat;
         return this;
      }

      @JsonProperty("endUnitPrice")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endUnitPrice(final BigDecimal endUnitPrice) {
         this.endUnitPrice = endUnitPrice;
         return this;
      }

      @JsonProperty("endUnitPriceExcludingVat")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
         this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("workshopId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("specification")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("boolCross")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      @JsonProperty("inboundAmountNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
         this.inboundAmountNoFreight = inboundAmountNoFreight;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundAmountExcludingVatNoFreight(final BigDecimal inboundAmountExcludingVatNoFreight) {
         this.inboundAmountExcludingVatNoFreight = inboundAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inboundUnitPriceNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundUnitPriceNoFreight(final BigDecimal inboundUnitPriceNoFreight) {
         this.inboundUnitPriceNoFreight = inboundUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("inboundUnitPriceExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder inboundUnitPriceExcludingVatNoFreight(
         final BigDecimal inboundUnitPriceExcludingVatNoFreight
      ) {
         this.inboundUnitPriceExcludingVatNoFreight = inboundUnitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundAmountNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundAmountNoFreight(final BigDecimal outboundAmountNoFreight) {
         this.outboundAmountNoFreight = outboundAmountNoFreight;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundAmountExcludingVatNoFreight(final BigDecimal outboundAmountExcludingVatNoFreight) {
         this.outboundAmountExcludingVatNoFreight = outboundAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("outboundUnitPriceNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundUnitPriceNoFreight(final BigDecimal outboundUnitPriceNoFreight) {
         this.outboundUnitPriceNoFreight = outboundUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("outboundUnitPriceExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder outboundUnitPriceExcludingVatNoFreight(
         final BigDecimal outboundUnitPriceExcludingVatNoFreight
      ) {
         this.outboundUnitPriceExcludingVatNoFreight = outboundUnitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("endAmountNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endAmountNoFreight(final BigDecimal endAmountNoFreight) {
         this.endAmountNoFreight = endAmountNoFreight;
         return this;
      }

      @JsonProperty("endAmountExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endAmountExcludingVatNoFreight(final BigDecimal endAmountExcludingVatNoFreight) {
         this.endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("endUnitPriceNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endUnitPriceNoFreight(final BigDecimal endUnitPriceNoFreight) {
         this.endUnitPriceNoFreight = endUnitPriceNoFreight;
         return this;
      }

      @JsonProperty("endUnitPriceExcludingVatNoFreight")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder endUnitPriceExcludingVatNoFreight(final BigDecimal endUnitPriceExcludingVatNoFreight) {
         this.endUnitPriceExcludingVatNoFreight = endUnitPriceExcludingVatNoFreight;
         return this;
      }

      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder WmsClosingTimeId(final Long WmsClosingTimeId) {
         this.WmsClosingTimeId = WmsClosingTimeId;
         return this;
      }

      @JsonProperty("statisticsId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder statisticsId(final Long statisticsId) {
         this.statisticsId = statisticsId;
         return this;
      }

      @JsonProperty("mesWorkshopId")
      public WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public WmsStatisticsClosingTime build() {
         return new WmsStatisticsClosingTime(
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
            this.boolCross,
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
            this.endUnitPriceExcludingVatNoFreight,
            this.WmsClosingTimeId,
            this.statisticsId,
            this.mesWorkshopId
         );
      }

      @Override
      public String toString() {
         return "WmsStatisticsClosingTime.WmsStatisticsClosingTimeBuilder(id="
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
            + ", boolCross="
            + this.boolCross
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
            + ", WmsClosingTimeId="
            + this.WmsClosingTimeId
            + ", statisticsId="
            + this.statisticsId
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ")";
      }
   }
}
