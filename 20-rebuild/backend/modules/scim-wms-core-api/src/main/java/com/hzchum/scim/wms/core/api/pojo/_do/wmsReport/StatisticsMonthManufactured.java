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

@ApiModel(value = "StatisticMonthManufactured对象", description = "制成品收发存信息 按月统计 每月期初计算 上月的期末和本月的期初")
@Entity
@TableName("wms_statistics_month_manufactured")
@Table(name = "wms_statistics_month_manufactured")
public class StatisticsMonthManufactured extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "monthStr", value = "月份 String类型yyyy-MM形式", notes = "String类型yyyy-MM形式")
   @JsonProperty("monthStr")
   @JSONField(name = "monthStr")
   @TableField("month_str")
   @Column(name = "month_str", columnDefinition = "varchar(50)  COMMENT 'String类型yyyy-MM形式'", nullable = true)
   private String monthStr;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
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
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件/围护ID", notes = "构件/围护ID")
   @JsonProperty("artifactEnclosureId")
   @JSONField(name = "artifactEnclosureId")
   @TableField("artifact_enclosure_id")
   @Column(name = "artifact_enclosure_id", columnDefinition = "bigint  COMMENT '构件/围护ID'", nullable = true)
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "manufacturedName", value = "制成品名称", notes = "制成品名称")
   @JsonProperty("manufacturedName")
   @JSONField(name = "manufacturedName")
   @TableField("manufactured_name")
   @Column(name = "manufactured_name", columnDefinition = "varchar(255)  COMMENT '制成品名称'", nullable = true)
   private String manufacturedName;
   @ApiModelProperty(name = "manufacturedSn", value = "制成品编号", notes = "制成品编号")
   @JsonProperty("manufacturedSn")
   @JSONField(name = "manufacturedSn")
   @TableField("manufactured_sn")
   @Column(name = "manufactured_sn", columnDefinition = "varchar(255)  COMMENT '制成品编号'", nullable = true)
   private String manufacturedSn;
   @ApiModelProperty(name = "material", value = "制成品材质", notes = "制成品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '制成品材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '长度(mm)'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）", notes = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '有效宽度(mm)'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,3)  COMMENT '厚度（mm）'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(128)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "weight", value = "单重（g）", notes = "单重（g）")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8)  COMMENT '单重（g）'", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）", notes = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8)  COMMENT '单面积（mm²）'", nullable = true)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WageQuotaTypeEnum")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '制成品计价方式 计价方式 WageQuotaTypeEnum'", nullable = true)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField(value = "tax_rate", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "tax_rate", columnDefinition = "decimal COMMENT '税率(百分比)'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "inboundTotalQuantity", value = "入库总数量", notes = "入库总数量")
   @JsonProperty("inboundTotalQuantity")
   @JSONField(name = "inboundTotalQuantity")
   @TableField("inbound_total_quantity")
   @Column(name = "inbound_total_quantity", columnDefinition = "decimal(32,8)  COMMENT '入库总数量'", nullable = true)
   private BigDecimal inboundTotalQuantity;
   @ApiModelProperty(name = "inboundTotalWeight", value = "入库总重（g）", notes = "入库总重（g）")
   @JsonProperty("inboundTotalWeight")
   @JSONField(name = "inboundTotalWeight")
   @TableField("inbound_total_weight")
   @Column(name = "inbound_total_weight", columnDefinition = "decimal(32,8)  COMMENT '入库总重（g）'", nullable = true)
   private BigDecimal inboundTotalWeight;
   @ApiModelProperty(name = "inboundTotalLength", value = "入库总长（mm）", notes = "入库总长（mm）")
   @JsonProperty("inboundTotalLength")
   @JSONField(name = "inboundTotalLength")
   @TableField("inbound_total_length")
   @Column(name = "inbound_total_length", columnDefinition = "decimal(32,8)  COMMENT '入库总长（mm）'", nullable = true)
   private BigDecimal inboundTotalLength;
   @ApiModelProperty(name = "inboundTotalArea", value = "入库总面积（mm²）", notes = "入库总面积（mm²）")
   @JsonProperty("inboundTotalArea")
   @JSONField(name = "inboundTotalArea")
   @TableField("inbound_total_area")
   @Column(name = "inbound_total_area", columnDefinition = "decimal(32,8)  COMMENT '入库总面积（mm²）'", nullable = true)
   private BigDecimal inboundTotalArea;
   @ApiModelProperty(name = "inboundAmountExcludingVat", value = "入库不含税总价", notes = "入库不含税总价")
   @JsonProperty("inboundAmountExcludingVat")
   @JSONField(name = "inboundAmountExcludingVat")
   @TableField("inbound_amount_excluding_vat")
   @Column(name = "inbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '入库不含税总价'", nullable = true)
   private BigDecimal inboundAmountExcludingVat;
   @ApiModelProperty(name = "inboundAmount", value = "入库总价 含税", notes = "入库总价 含税")
   @JsonProperty("inboundAmount")
   @JSONField(name = "inboundAmount")
   @TableField("inbound_amount")
   @Column(name = "inbound_amount", columnDefinition = "decimal(32,12)  COMMENT '入库总价'", nullable = true)
   private BigDecimal inboundAmount;
   @ApiModelProperty(name = "outboundTotalQuantity", value = "出库总数量", notes = "出库总数量")
   @JsonProperty("outboundTotalQuantity")
   @JSONField(name = "outboundTotalQuantity")
   @TableField("outbound_total_quantity")
   @Column(name = "outbound_total_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库总数量'", nullable = true)
   private BigDecimal outboundTotalQuantity;
   @ApiModelProperty(name = "outboundTotalWeight", value = "出库总重（g）", notes = "出库总重（g）")
   @JsonProperty("outboundTotalWeight")
   @JSONField(name = "outboundTotalWeight")
   @TableField("outbound_total_weight")
   @Column(name = "outbound_total_weight", columnDefinition = "decimal(32,8)  COMMENT '出库总重（g）'", nullable = true)
   private BigDecimal outboundTotalWeight;
   @ApiModelProperty(name = "outboundTotalLength", value = "出库总长（mm）", notes = "出库总长（mm）")
   @JsonProperty("outboundTotalLength")
   @JSONField(name = "outboundTotalLength")
   @TableField("outbound_total_length")
   @Column(name = "outbound_total_length", columnDefinition = "decimal(32,8)  COMMENT '出库总长（mm）'", nullable = true)
   private BigDecimal outboundTotalLength;
   @ApiModelProperty(name = "outboundTotalArea", value = "出库总面积（mm²）", notes = "出库总面积（mm²）")
   @JsonProperty("outboundTotalArea")
   @JSONField(name = "outboundTotalArea")
   @TableField("outbound_total_area")
   @Column(name = "outbound_total_area", columnDefinition = "decimal(32,8)  COMMENT '出库总面积（mm²）'", nullable = true)
   private BigDecimal outboundTotalArea;
   @ApiModelProperty(name = "outboundAmountExcludingVat", value = "出库不含税总价", notes = "出库不含税总价")
   @JsonProperty("outboundAmountExcludingVat")
   @JSONField(name = "outboundAmountExcludingVat")
   @TableField("outbound_amount_excluding_vat")
   @Column(name = "outbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '出库不含税总价'", nullable = true)
   private BigDecimal outboundAmountExcludingVat;
   @ApiModelProperty(name = "outboundAmount", value = "出库总价 含税", notes = "出库总价 含税")
   @JsonProperty("outboundAmount")
   @JSONField(name = "outboundAmount")
   @TableField("outbound_amount")
   @Column(name = "outbound_amount", columnDefinition = "decimal(32,12)  COMMENT '出库总价'", nullable = true)
   private BigDecimal outboundAmount;
   @ApiModelProperty(name = "returnTotalQuantity", value = "退库总数量", notes = "退库总数量")
   @JsonProperty("returnTotalQuantity")
   @JSONField(name = "returnTotalQuantity")
   @TableField("return_total_quantity")
   @Column(name = "return_total_quantity", columnDefinition = "decimal(32,8)  COMMENT '退库总数量'", nullable = true)
   private BigDecimal returnTotalQuantity;
   @ApiModelProperty(name = "returnTotalWeight", value = "退库总重（g）", notes = "退库总重（g）")
   @JsonProperty("returnTotalWeight")
   @JSONField(name = "returnTotalWeight")
   @TableField("return_total_weight")
   @Column(name = "return_total_weight", columnDefinition = "decimal(32,8)  COMMENT '退库总重（g）'", nullable = true)
   private BigDecimal returnTotalWeight;
   @ApiModelProperty(name = "returnTotalLength", value = "退库总长（mm）", notes = "退库总长（mm）")
   @JsonProperty("returnTotalLength")
   @JSONField(name = "returnTotalLength")
   @TableField("return_total_length")
   @Column(name = "return_total_length", columnDefinition = "decimal(32,8)  COMMENT '退库总长（mm）'", nullable = true)
   private BigDecimal returnTotalLength;
   @ApiModelProperty(name = "returnTotalArea", value = "退库总面积（mm²）", notes = "退库总面积（mm²）")
   @JsonProperty("returnTotalArea")
   @JSONField(name = "returnTotalArea")
   @TableField("return_total_area")
   @Column(name = "return_total_area", columnDefinition = "decimal(32,8)  COMMENT '退库总面积（mm²）'", nullable = true)
   private BigDecimal returnTotalArea;
   @ApiModelProperty(name = "returnAmountExcludingVat", value = "退库不含税总价", notes = "退库不含税总价")
   @JsonProperty("returnAmountExcludingVat")
   @JSONField(name = "returnAmountExcludingVat")
   @TableField("return_amount_excluding_vat")
   @Column(name = "return_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '退库不含税总价'", nullable = true)
   private BigDecimal returnAmountExcludingVat;
   @ApiModelProperty(name = "returnAmount", value = "退库总价 含税", notes = "退库总价 含税")
   @JsonProperty("returnAmount")
   @JSONField(name = "returnAmount")
   @TableField("return_amount")
   @Column(name = "return_amount", columnDefinition = "decimal(32,12)  COMMENT '退库总价'", nullable = true)
   private BigDecimal returnAmount;
   @ApiModelProperty(name = "beginMonthTotalQuantity", value = "期初总数量", notes = "期初总数量")
   @JsonProperty("beginMonthTotalQuantity")
   @JSONField(name = "beginMonthTotalQuantity")
   @TableField("begin_month_total_quantity")
   @Column(name = "begin_month_total_quantity", columnDefinition = "decimal(32,8)  COMMENT '期初总数量'", nullable = true)
   private BigDecimal beginMonthTotalQuantity;
   @ApiModelProperty(name = "beginMonthTotalWeight", value = "期初总重（g）", notes = "期初总重（g）")
   @JsonProperty("beginMonthTotalWeight")
   @JSONField(name = "beginMonthTotalWeight")
   @TableField("begin_month_total_weight")
   @Column(name = "begin_month_total_weight", columnDefinition = "decimal(32,8)  COMMENT '期初总重（g）'", nullable = true)
   private BigDecimal beginMonthTotalWeight;
   @ApiModelProperty(name = "beginMonthTotalLength", value = "期初总长（mm）", notes = "期初总长（mm）")
   @JsonProperty("beginMonthTotalLength")
   @JSONField(name = "beginMonthTotalLength")
   @TableField("begin_month_total_length")
   @Column(name = "begin_month_total_length", columnDefinition = "decimal(32,8)  COMMENT '期初总长（mm）'", nullable = true)
   private BigDecimal beginMonthTotalLength;
   @ApiModelProperty(name = "beginMonthTotalArea", value = "期初总面积（mm²）", notes = "期初总面积（mm²）")
   @JsonProperty("beginMonthTotalArea")
   @JSONField(name = "beginMonthTotalArea")
   @TableField("begin_month_total_area")
   @Column(name = "begin_month_total_area", columnDefinition = "decimal(32,8)  COMMENT '期初总面积（mm²）'", nullable = true)
   private BigDecimal beginMonthTotalArea;
   @ApiModelProperty(name = "beginMonthAmountExcludingVat", value = "期初不含税总价", notes = "期初不含税总价")
   @JsonProperty("beginMonthAmountExcludingVat")
   @JSONField(name = "beginMonthAmountExcludingVat")
   @TableField("begin_month_amount_excluding_vat")
   @Column(name = "begin_month_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '期初不含税总价'", nullable = true)
   private BigDecimal beginMonthAmountExcludingVat;
   @ApiModelProperty(name = "beginMonthAmount", value = "期初总价 含税", notes = "期初总价 含税")
   @JsonProperty("beginMonthAmount")
   @JSONField(name = "beginMonthAmount")
   @TableField("begin_month_amount")
   @Column(name = "begin_month_amount", columnDefinition = "decimal(32,12)  COMMENT '期初总价'", nullable = true)
   private BigDecimal beginMonthAmount;
   @ApiModelProperty(name = "endMonthTotalQuantity", value = "期末总数量", notes = "期末总数量")
   @JsonProperty("endMonthTotalQuantity")
   @JSONField(name = "endMonthTotalQuantity")
   @TableField("end_month_total_quantity")
   @Column(name = "end_month_total_quantity", columnDefinition = "decimal(32,8)  COMMENT '期末总数量'", nullable = true)
   private BigDecimal endMonthTotalQuantity;
   @ApiModelProperty(name = "endMonthTotalWeight", value = "期末总重（g）", notes = "期末总重（g）")
   @JsonProperty("endMonthTotalWeight")
   @JSONField(name = "endMonthTotalWeight")
   @TableField("end_month_total_weight")
   @Column(name = "end_month_total_weight", columnDefinition = "decimal(32,8)  COMMENT '期末总重（g）'", nullable = true)
   private BigDecimal endMonthTotalWeight;
   @ApiModelProperty(name = "endMonthTotalLength", value = "期末总长（mm）", notes = "期末总长（mm）")
   @JsonProperty("endMonthTotalLength")
   @JSONField(name = "endMonthTotalLength")
   @TableField("end_month_total_length")
   @Column(name = "end_month_total_length", columnDefinition = "decimal(32,8)  COMMENT '期末总长（mm）'", nullable = true)
   private BigDecimal endMonthTotalLength;
   @ApiModelProperty(name = "endMonthTotalArea", value = "期末总面积（mm²）", notes = "期末总面积（mm²）")
   @JsonProperty("endMonthTotalArea")
   @JSONField(name = "endMonthTotalArea")
   @TableField("end_month_total_area")
   @Column(name = "end_month_total_area", columnDefinition = "decimal(32,8)  COMMENT '期末总面积（mm²）'", nullable = true)
   private BigDecimal endMonthTotalArea;
   @ApiModelProperty(name = "endMonthAmountExcludingVat", value = "期末不含税总价", notes = "期末不含税总价")
   @JsonProperty("endMonthAmountExcludingVat")
   @JSONField(name = "endMonthAmountExcludingVat")
   @TableField("end_month_amount_excluding_vat")
   @Column(name = "end_month_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '期末不含税总价'", nullable = true)
   private BigDecimal endMonthAmountExcludingVat;
   @ApiModelProperty(name = "endMonthAmount", value = "期末总价 含税", notes = "期末总价 含税")
   @JsonProperty("endMonthAmount")
   @JSONField(name = "endMonthAmount")
   @TableField("end_month_amount")
   @Column(name = "end_month_amount", columnDefinition = "decimal(32,12)  COMMENT '期末总价'", nullable = true)
   private BigDecimal endMonthAmount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder builder() {
      return new StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder();
   }

   public StatisticsMonthManufactured() {
   }

   public StatisticsMonthManufactured(
      final Long id,
      final String monthStr,
      final Integer basicClass,
      final Long monomerId,
      final Long areaId,
      final Long projectId,
      final Long artifactEnclosureId,
      final String manufacturedName,
      final String manufacturedSn,
      final String material,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final BigDecimal weight,
      final BigDecimal surfaceArea,
      final Integer wageQuotaType,
      final BigDecimal taxRate,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal unitPrice,
      final BigDecimal inboundTotalQuantity,
      final BigDecimal inboundTotalWeight,
      final BigDecimal inboundTotalLength,
      final BigDecimal inboundTotalArea,
      final BigDecimal inboundAmountExcludingVat,
      final BigDecimal inboundAmount,
      final BigDecimal outboundTotalQuantity,
      final BigDecimal outboundTotalWeight,
      final BigDecimal outboundTotalLength,
      final BigDecimal outboundTotalArea,
      final BigDecimal outboundAmountExcludingVat,
      final BigDecimal outboundAmount,
      final BigDecimal returnTotalQuantity,
      final BigDecimal returnTotalWeight,
      final BigDecimal returnTotalLength,
      final BigDecimal returnTotalArea,
      final BigDecimal returnAmountExcludingVat,
      final BigDecimal returnAmount,
      final BigDecimal beginMonthTotalQuantity,
      final BigDecimal beginMonthTotalWeight,
      final BigDecimal beginMonthTotalLength,
      final BigDecimal beginMonthTotalArea,
      final BigDecimal beginMonthAmountExcludingVat,
      final BigDecimal beginMonthAmount,
      final BigDecimal endMonthTotalQuantity,
      final BigDecimal endMonthTotalWeight,
      final BigDecimal endMonthTotalLength,
      final BigDecimal endMonthTotalArea,
      final BigDecimal endMonthAmountExcludingVat,
      final BigDecimal endMonthAmount,
      final String remark
   ) {
      this.id = id;
      this.monthStr = monthStr;
      this.basicClass = basicClass;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectId = projectId;
      this.artifactEnclosureId = artifactEnclosureId;
      this.manufacturedName = manufacturedName;
      this.manufacturedSn = manufacturedSn;
      this.material = material;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.weight = weight;
      this.surfaceArea = surfaceArea;
      this.wageQuotaType = wageQuotaType;
      this.taxRate = taxRate;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.unitPrice = unitPrice;
      this.inboundTotalQuantity = inboundTotalQuantity;
      this.inboundTotalWeight = inboundTotalWeight;
      this.inboundTotalLength = inboundTotalLength;
      this.inboundTotalArea = inboundTotalArea;
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      this.inboundAmount = inboundAmount;
      this.outboundTotalQuantity = outboundTotalQuantity;
      this.outboundTotalWeight = outboundTotalWeight;
      this.outboundTotalLength = outboundTotalLength;
      this.outboundTotalArea = outboundTotalArea;
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      this.outboundAmount = outboundAmount;
      this.returnTotalQuantity = returnTotalQuantity;
      this.returnTotalWeight = returnTotalWeight;
      this.returnTotalLength = returnTotalLength;
      this.returnTotalArea = returnTotalArea;
      this.returnAmountExcludingVat = returnAmountExcludingVat;
      this.returnAmount = returnAmount;
      this.beginMonthTotalQuantity = beginMonthTotalQuantity;
      this.beginMonthTotalWeight = beginMonthTotalWeight;
      this.beginMonthTotalLength = beginMonthTotalLength;
      this.beginMonthTotalArea = beginMonthTotalArea;
      this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
      this.beginMonthAmount = beginMonthAmount;
      this.endMonthTotalQuantity = endMonthTotalQuantity;
      this.endMonthTotalWeight = endMonthTotalWeight;
      this.endMonthTotalLength = endMonthTotalLength;
      this.endMonthTotalArea = endMonthTotalArea;
      this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
      this.endMonthAmount = endMonthAmount;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getMonthStr() {
      return this.monthStr;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
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

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getInboundTotalQuantity() {
      return this.inboundTotalQuantity;
   }

   public BigDecimal getInboundTotalWeight() {
      return this.inboundTotalWeight;
   }

   public BigDecimal getInboundTotalLength() {
      return this.inboundTotalLength;
   }

   public BigDecimal getInboundTotalArea() {
      return this.inboundTotalArea;
   }

   public BigDecimal getInboundAmountExcludingVat() {
      return this.inboundAmountExcludingVat;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getOutboundTotalQuantity() {
      return this.outboundTotalQuantity;
   }

   public BigDecimal getOutboundTotalWeight() {
      return this.outboundTotalWeight;
   }

   public BigDecimal getOutboundTotalLength() {
      return this.outboundTotalLength;
   }

   public BigDecimal getOutboundTotalArea() {
      return this.outboundTotalArea;
   }

   public BigDecimal getOutboundAmountExcludingVat() {
      return this.outboundAmountExcludingVat;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getReturnTotalQuantity() {
      return this.returnTotalQuantity;
   }

   public BigDecimal getReturnTotalWeight() {
      return this.returnTotalWeight;
   }

   public BigDecimal getReturnTotalLength() {
      return this.returnTotalLength;
   }

   public BigDecimal getReturnTotalArea() {
      return this.returnTotalArea;
   }

   public BigDecimal getReturnAmountExcludingVat() {
      return this.returnAmountExcludingVat;
   }

   public BigDecimal getReturnAmount() {
      return this.returnAmount;
   }

   public BigDecimal getBeginMonthTotalQuantity() {
      return this.beginMonthTotalQuantity;
   }

   public BigDecimal getBeginMonthTotalWeight() {
      return this.beginMonthTotalWeight;
   }

   public BigDecimal getBeginMonthTotalLength() {
      return this.beginMonthTotalLength;
   }

   public BigDecimal getBeginMonthTotalArea() {
      return this.beginMonthTotalArea;
   }

   public BigDecimal getBeginMonthAmountExcludingVat() {
      return this.beginMonthAmountExcludingVat;
   }

   public BigDecimal getBeginMonthAmount() {
      return this.beginMonthAmount;
   }

   public BigDecimal getEndMonthTotalQuantity() {
      return this.endMonthTotalQuantity;
   }

   public BigDecimal getEndMonthTotalWeight() {
      return this.endMonthTotalWeight;
   }

   public BigDecimal getEndMonthTotalLength() {
      return this.endMonthTotalLength;
   }

   public BigDecimal getEndMonthTotalArea() {
      return this.endMonthTotalArea;
   }

   public BigDecimal getEndMonthAmountExcludingVat() {
      return this.endMonthAmountExcludingVat;
   }

   public BigDecimal getEndMonthAmount() {
      return this.endMonthAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public StatisticsMonthManufactured setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("monthStr")
   public StatisticsMonthManufactured setMonthStr(final String monthStr) {
      this.monthStr = monthStr;
      return this;
   }

   @JsonProperty("basicClass")
   public StatisticsMonthManufactured setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("monomerId")
   public StatisticsMonthManufactured setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public StatisticsMonthManufactured setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("projectId")
   public StatisticsMonthManufactured setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public StatisticsMonthManufactured setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("manufacturedName")
   public StatisticsMonthManufactured setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
      return this;
   }

   @JsonProperty("manufacturedSn")
   public StatisticsMonthManufactured setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
      return this;
   }

   @JsonProperty("material")
   public StatisticsMonthManufactured setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("specification")
   public StatisticsMonthManufactured setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public StatisticsMonthManufactured setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public StatisticsMonthManufactured setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public StatisticsMonthManufactured setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public StatisticsMonthManufactured setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public StatisticsMonthManufactured setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public StatisticsMonthManufactured setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public StatisticsMonthManufactured setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public StatisticsMonthManufactured setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("taxRate")
   public StatisticsMonthManufactured setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public StatisticsMonthManufactured setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public StatisticsMonthManufactured setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("inboundTotalQuantity")
   public StatisticsMonthManufactured setInboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
      this.inboundTotalQuantity = inboundTotalQuantity;
      return this;
   }

   @JsonProperty("inboundTotalWeight")
   public StatisticsMonthManufactured setInboundTotalWeight(final BigDecimal inboundTotalWeight) {
      this.inboundTotalWeight = inboundTotalWeight;
      return this;
   }

   @JsonProperty("inboundTotalLength")
   public StatisticsMonthManufactured setInboundTotalLength(final BigDecimal inboundTotalLength) {
      this.inboundTotalLength = inboundTotalLength;
      return this;
   }

   @JsonProperty("inboundTotalArea")
   public StatisticsMonthManufactured setInboundTotalArea(final BigDecimal inboundTotalArea) {
      this.inboundTotalArea = inboundTotalArea;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVat")
   public StatisticsMonthManufactured setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("inboundAmount")
   public StatisticsMonthManufactured setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
      return this;
   }

   @JsonProperty("outboundTotalQuantity")
   public StatisticsMonthManufactured setOutboundTotalQuantity(final BigDecimal outboundTotalQuantity) {
      this.outboundTotalQuantity = outboundTotalQuantity;
      return this;
   }

   @JsonProperty("outboundTotalWeight")
   public StatisticsMonthManufactured setOutboundTotalWeight(final BigDecimal outboundTotalWeight) {
      this.outboundTotalWeight = outboundTotalWeight;
      return this;
   }

   @JsonProperty("outboundTotalLength")
   public StatisticsMonthManufactured setOutboundTotalLength(final BigDecimal outboundTotalLength) {
      this.outboundTotalLength = outboundTotalLength;
      return this;
   }

   @JsonProperty("outboundTotalArea")
   public StatisticsMonthManufactured setOutboundTotalArea(final BigDecimal outboundTotalArea) {
      this.outboundTotalArea = outboundTotalArea;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVat")
   public StatisticsMonthManufactured setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("outboundAmount")
   public StatisticsMonthManufactured setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
      return this;
   }

   @JsonProperty("returnTotalQuantity")
   public StatisticsMonthManufactured setReturnTotalQuantity(final BigDecimal returnTotalQuantity) {
      this.returnTotalQuantity = returnTotalQuantity;
      return this;
   }

   @JsonProperty("returnTotalWeight")
   public StatisticsMonthManufactured setReturnTotalWeight(final BigDecimal returnTotalWeight) {
      this.returnTotalWeight = returnTotalWeight;
      return this;
   }

   @JsonProperty("returnTotalLength")
   public StatisticsMonthManufactured setReturnTotalLength(final BigDecimal returnTotalLength) {
      this.returnTotalLength = returnTotalLength;
      return this;
   }

   @JsonProperty("returnTotalArea")
   public StatisticsMonthManufactured setReturnTotalArea(final BigDecimal returnTotalArea) {
      this.returnTotalArea = returnTotalArea;
      return this;
   }

   @JsonProperty("returnAmountExcludingVat")
   public StatisticsMonthManufactured setReturnAmountExcludingVat(final BigDecimal returnAmountExcludingVat) {
      this.returnAmountExcludingVat = returnAmountExcludingVat;
      return this;
   }

   @JsonProperty("returnAmount")
   public StatisticsMonthManufactured setReturnAmount(final BigDecimal returnAmount) {
      this.returnAmount = returnAmount;
      return this;
   }

   @JsonProperty("beginMonthTotalQuantity")
   public StatisticsMonthManufactured setBeginMonthTotalQuantity(final BigDecimal beginMonthTotalQuantity) {
      this.beginMonthTotalQuantity = beginMonthTotalQuantity;
      return this;
   }

   @JsonProperty("beginMonthTotalWeight")
   public StatisticsMonthManufactured setBeginMonthTotalWeight(final BigDecimal beginMonthTotalWeight) {
      this.beginMonthTotalWeight = beginMonthTotalWeight;
      return this;
   }

   @JsonProperty("beginMonthTotalLength")
   public StatisticsMonthManufactured setBeginMonthTotalLength(final BigDecimal beginMonthTotalLength) {
      this.beginMonthTotalLength = beginMonthTotalLength;
      return this;
   }

   @JsonProperty("beginMonthTotalArea")
   public StatisticsMonthManufactured setBeginMonthTotalArea(final BigDecimal beginMonthTotalArea) {
      this.beginMonthTotalArea = beginMonthTotalArea;
      return this;
   }

   @JsonProperty("beginMonthAmountExcludingVat")
   public StatisticsMonthManufactured setBeginMonthAmountExcludingVat(final BigDecimal beginMonthAmountExcludingVat) {
      this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
      return this;
   }

   @JsonProperty("beginMonthAmount")
   public StatisticsMonthManufactured setBeginMonthAmount(final BigDecimal beginMonthAmount) {
      this.beginMonthAmount = beginMonthAmount;
      return this;
   }

   @JsonProperty("endMonthTotalQuantity")
   public StatisticsMonthManufactured setEndMonthTotalQuantity(final BigDecimal endMonthTotalQuantity) {
      this.endMonthTotalQuantity = endMonthTotalQuantity;
      return this;
   }

   @JsonProperty("endMonthTotalWeight")
   public StatisticsMonthManufactured setEndMonthTotalWeight(final BigDecimal endMonthTotalWeight) {
      this.endMonthTotalWeight = endMonthTotalWeight;
      return this;
   }

   @JsonProperty("endMonthTotalLength")
   public StatisticsMonthManufactured setEndMonthTotalLength(final BigDecimal endMonthTotalLength) {
      this.endMonthTotalLength = endMonthTotalLength;
      return this;
   }

   @JsonProperty("endMonthTotalArea")
   public StatisticsMonthManufactured setEndMonthTotalArea(final BigDecimal endMonthTotalArea) {
      this.endMonthTotalArea = endMonthTotalArea;
      return this;
   }

   @JsonProperty("endMonthAmountExcludingVat")
   public StatisticsMonthManufactured setEndMonthAmountExcludingVat(final BigDecimal endMonthAmountExcludingVat) {
      this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
      return this;
   }

   @JsonProperty("endMonthAmount")
   public StatisticsMonthManufactured setEndMonthAmount(final BigDecimal endMonthAmount) {
      this.endMonthAmount = endMonthAmount;
      return this;
   }

   @JsonProperty("remark")
   public StatisticsMonthManufactured setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "StatisticsMonthManufactured(id="
         + this.getId()
         + ", monthStr="
         + this.getMonthStr()
         + ", basicClass="
         + this.getBasicClass()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectId="
         + this.getProjectId()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", taxRate="
         + this.getTaxRate()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", inboundTotalQuantity="
         + this.getInboundTotalQuantity()
         + ", inboundTotalWeight="
         + this.getInboundTotalWeight()
         + ", inboundTotalLength="
         + this.getInboundTotalLength()
         + ", inboundTotalArea="
         + this.getInboundTotalArea()
         + ", inboundAmountExcludingVat="
         + this.getInboundAmountExcludingVat()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", outboundTotalQuantity="
         + this.getOutboundTotalQuantity()
         + ", outboundTotalWeight="
         + this.getOutboundTotalWeight()
         + ", outboundTotalLength="
         + this.getOutboundTotalLength()
         + ", outboundTotalArea="
         + this.getOutboundTotalArea()
         + ", outboundAmountExcludingVat="
         + this.getOutboundAmountExcludingVat()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", returnTotalQuantity="
         + this.getReturnTotalQuantity()
         + ", returnTotalWeight="
         + this.getReturnTotalWeight()
         + ", returnTotalLength="
         + this.getReturnTotalLength()
         + ", returnTotalArea="
         + this.getReturnTotalArea()
         + ", returnAmountExcludingVat="
         + this.getReturnAmountExcludingVat()
         + ", returnAmount="
         + this.getReturnAmount()
         + ", beginMonthTotalQuantity="
         + this.getBeginMonthTotalQuantity()
         + ", beginMonthTotalWeight="
         + this.getBeginMonthTotalWeight()
         + ", beginMonthTotalLength="
         + this.getBeginMonthTotalLength()
         + ", beginMonthTotalArea="
         + this.getBeginMonthTotalArea()
         + ", beginMonthAmountExcludingVat="
         + this.getBeginMonthAmountExcludingVat()
         + ", beginMonthAmount="
         + this.getBeginMonthAmount()
         + ", endMonthTotalQuantity="
         + this.getEndMonthTotalQuantity()
         + ", endMonthTotalWeight="
         + this.getEndMonthTotalWeight()
         + ", endMonthTotalLength="
         + this.getEndMonthTotalLength()
         + ", endMonthTotalArea="
         + this.getEndMonthTotalArea()
         + ", endMonthAmountExcludingVat="
         + this.getEndMonthAmountExcludingVat()
         + ", endMonthAmount="
         + this.getEndMonthAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsMonthManufactured)) {
         return false;
      }

      StatisticsMonthManufactured other = (StatisticsMonthManufactured)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                     Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                     if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                        Object this$wageQuotaType = this.getWageQuotaType();
                        Object other$wageQuotaType = other.getWageQuotaType();
                        if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                           Object this$monthStr = this.getMonthStr();
                           Object other$monthStr = other.getMonthStr();
                           if (this$monthStr == null ? other$monthStr == null : this$monthStr.equals(other$monthStr)) {
                              Object this$manufacturedName = this.getManufacturedName();
                              Object other$manufacturedName = other.getManufacturedName();
                              if (this$manufacturedName == null ? other$manufacturedName == null : this$manufacturedName.equals(other$manufacturedName)) {
                                 Object this$manufacturedSn = this.getManufacturedSn();
                                 Object other$manufacturedSn = other.getManufacturedSn();
                                 if (this$manufacturedSn == null ? other$manufacturedSn == null : this$manufacturedSn.equals(other$manufacturedSn)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$weight = this.getWeight();
                                                         Object other$weight = other.getWeight();
                                                         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                            Object this$surfaceArea = this.getSurfaceArea();
                                                            Object other$surfaceArea = other.getSurfaceArea();
                                                            if (this$surfaceArea == null
                                                               ? other$surfaceArea == null
                                                               : this$surfaceArea.equals(other$surfaceArea)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                  Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                  if (this$unitPriceExcludingVat == null
                                                                     ? other$unitPriceExcludingVat == null
                                                                     : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                                                     Object this$unitPrice = this.getUnitPrice();
                                                                     Object other$unitPrice = other.getUnitPrice();
                                                                     if (this$unitPrice == null
                                                                        ? other$unitPrice == null
                                                                        : this$unitPrice.equals(other$unitPrice)) {
                                                                        Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                                                        Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                                                        if (this$inboundTotalQuantity == null
                                                                           ? other$inboundTotalQuantity == null
                                                                           : this$inboundTotalQuantity.equals(other$inboundTotalQuantity)) {
                                                                           Object this$inboundTotalWeight = this.getInboundTotalWeight();
                                                                           Object other$inboundTotalWeight = other.getInboundTotalWeight();
                                                                           if (this$inboundTotalWeight == null
                                                                              ? other$inboundTotalWeight == null
                                                                              : this$inboundTotalWeight.equals(other$inboundTotalWeight)) {
                                                                              Object this$inboundTotalLength = this.getInboundTotalLength();
                                                                              Object other$inboundTotalLength = other.getInboundTotalLength();
                                                                              if (this$inboundTotalLength == null
                                                                                 ? other$inboundTotalLength == null
                                                                                 : this$inboundTotalLength.equals(other$inboundTotalLength)) {
                                                                                 Object this$inboundTotalArea = this.getInboundTotalArea();
                                                                                 Object other$inboundTotalArea = other.getInboundTotalArea();
                                                                                 if (this$inboundTotalArea == null
                                                                                    ? other$inboundTotalArea == null
                                                                                    : this$inboundTotalArea.equals(other$inboundTotalArea)) {
                                                                                    Object this$inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
                                                                                    Object other$inboundAmountExcludingVat = other.getInboundAmountExcludingVat();
                                                                                    if (this$inboundAmountExcludingVat == null
                                                                                       ? other$inboundAmountExcludingVat == null
                                                                                       : this$inboundAmountExcludingVat.equals(other$inboundAmountExcludingVat)
                                                                                       )
                                                                                     {
                                                                                       Object this$inboundAmount = this.getInboundAmount();
                                                                                       Object other$inboundAmount = other.getInboundAmount();
                                                                                       if (this$inboundAmount == null
                                                                                          ? other$inboundAmount == null
                                                                                          : this$inboundAmount.equals(other$inboundAmount)) {
                                                                                          Object this$outboundTotalQuantity = this.getOutboundTotalQuantity();
                                                                                          Object other$outboundTotalQuantity = other.getOutboundTotalQuantity();
                                                                                          if (this$outboundTotalQuantity == null
                                                                                             ? other$outboundTotalQuantity == null
                                                                                             : this$outboundTotalQuantity.equals(other$outboundTotalQuantity)) {
                                                                                             Object this$outboundTotalWeight = this.getOutboundTotalWeight();
                                                                                             Object other$outboundTotalWeight = other.getOutboundTotalWeight();
                                                                                             if (this$outboundTotalWeight == null
                                                                                                ? other$outboundTotalWeight == null
                                                                                                : this$outboundTotalWeight.equals(other$outboundTotalWeight)) {
                                                                                                Object this$outboundTotalLength = this.getOutboundTotalLength();
                                                                                                Object other$outboundTotalLength = other.getOutboundTotalLength();
                                                                                                if (this$outboundTotalLength == null
                                                                                                   ? other$outboundTotalLength == null
                                                                                                   : this$outboundTotalLength.equals(other$outboundTotalLength)
                                                                                                   )
                                                                                                 {
                                                                                                   Object this$outboundTotalArea = this.getOutboundTotalArea();
                                                                                                   Object other$outboundTotalArea = other.getOutboundTotalArea();
                                                                                                   if (this$outboundTotalArea == null
                                                                                                      ? other$outboundTotalArea == null
                                                                                                      : this$outboundTotalArea.equals(other$outboundTotalArea)) {
                                                                                                      Object this$outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
                                                                                                      Object other$outboundAmountExcludingVat = other.getOutboundAmountExcludingVat();
                                                                                                      if (this$outboundAmountExcludingVat == null
                                                                                                         ? other$outboundAmountExcludingVat == null
                                                                                                         : this$outboundAmountExcludingVat.equals(
                                                                                                            other$outboundAmountExcludingVat
                                                                                                         )) {
                                                                                                         Object this$outboundAmount = this.getOutboundAmount();
                                                                                                         Object other$outboundAmount = other.getOutboundAmount();
                                                                                                         if (this$outboundAmount == null
                                                                                                            ? other$outboundAmount == null
                                                                                                            : this$outboundAmount.equals(other$outboundAmount)) {
                                                                                                            Object this$returnTotalQuantity = this.getReturnTotalQuantity();
                                                                                                            Object other$returnTotalQuantity = other.getReturnTotalQuantity();
                                                                                                            if (this$returnTotalQuantity == null
                                                                                                               ? other$returnTotalQuantity == null
                                                                                                               : this$returnTotalQuantity.equals(
                                                                                                                  other$returnTotalQuantity
                                                                                                               )) {
                                                                                                               Object this$returnTotalWeight = this.getReturnTotalWeight();
                                                                                                               Object other$returnTotalWeight = other.getReturnTotalWeight();
                                                                                                               if (this$returnTotalWeight == null
                                                                                                                  ? other$returnTotalWeight == null
                                                                                                                  : this$returnTotalWeight.equals(
                                                                                                                     other$returnTotalWeight
                                                                                                                  )) {
                                                                                                                  Object this$returnTotalLength = this.getReturnTotalLength();
                                                                                                                  Object other$returnTotalLength = other.getReturnTotalLength();
                                                                                                                  if (this$returnTotalLength == null
                                                                                                                     ? other$returnTotalLength == null
                                                                                                                     : this$returnTotalLength.equals(
                                                                                                                        other$returnTotalLength
                                                                                                                     )) {
                                                                                                                     Object this$returnTotalArea = this.getReturnTotalArea();
                                                                                                                     Object other$returnTotalArea = other.getReturnTotalArea();
                                                                                                                     if (this$returnTotalArea == null
                                                                                                                        ? other$returnTotalArea == null
                                                                                                                        : this$returnTotalArea.equals(
                                                                                                                           other$returnTotalArea
                                                                                                                        )) {
                                                                                                                        Object this$returnAmountExcludingVat = this.getReturnAmountExcludingVat();
                                                                                                                        Object other$returnAmountExcludingVat = other.getReturnAmountExcludingVat();
                                                                                                                        if (this$returnAmountExcludingVat
                                                                                                                              == null
                                                                                                                           ? other$returnAmountExcludingVat
                                                                                                                              == null
                                                                                                                           : this$returnAmountExcludingVat.equals(
                                                                                                                              other$returnAmountExcludingVat
                                                                                                                           )) {
                                                                                                                           Object this$returnAmount = this.getReturnAmount();
                                                                                                                           Object other$returnAmount = other.getReturnAmount();
                                                                                                                           if (this$returnAmount == null
                                                                                                                              ? other$returnAmount == null
                                                                                                                              : this$returnAmount.equals(
                                                                                                                                 other$returnAmount
                                                                                                                              )) {
                                                                                                                              Object this$beginMonthTotalQuantity = this.getBeginMonthTotalQuantity();
                                                                                                                              Object other$beginMonthTotalQuantity = other.getBeginMonthTotalQuantity();
                                                                                                                              if (this$beginMonthTotalQuantity
                                                                                                                                    == null
                                                                                                                                 ? other$beginMonthTotalQuantity
                                                                                                                                    == null
                                                                                                                                 : this$beginMonthTotalQuantity.equals(
                                                                                                                                    other$beginMonthTotalQuantity
                                                                                                                                 )) {
                                                                                                                                 Object this$beginMonthTotalWeight = this.getBeginMonthTotalWeight();
                                                                                                                                 Object other$beginMonthTotalWeight = other.getBeginMonthTotalWeight();
                                                                                                                                 if (this$beginMonthTotalWeight
                                                                                                                                       == null
                                                                                                                                    ? other$beginMonthTotalWeight
                                                                                                                                       == null
                                                                                                                                    : this$beginMonthTotalWeight.equals(
                                                                                                                                       other$beginMonthTotalWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$beginMonthTotalLength = this.getBeginMonthTotalLength();
                                                                                                                                    Object other$beginMonthTotalLength = other.getBeginMonthTotalLength();
                                                                                                                                    if (this$beginMonthTotalLength
                                                                                                                                          == null
                                                                                                                                       ? other$beginMonthTotalLength
                                                                                                                                          == null
                                                                                                                                       : this$beginMonthTotalLength.equals(
                                                                                                                                          other$beginMonthTotalLength
                                                                                                                                       )) {
                                                                                                                                       Object this$beginMonthTotalArea = this.getBeginMonthTotalArea();
                                                                                                                                       Object other$beginMonthTotalArea = other.getBeginMonthTotalArea();
                                                                                                                                       if (this$beginMonthTotalArea
                                                                                                                                             == null
                                                                                                                                          ? other$beginMonthTotalArea
                                                                                                                                             == null
                                                                                                                                          : this$beginMonthTotalArea.equals(
                                                                                                                                             other$beginMonthTotalArea
                                                                                                                                          )) {
                                                                                                                                          Object this$beginMonthAmountExcludingVat = this.getBeginMonthAmountExcludingVat();
                                                                                                                                          Object other$beginMonthAmountExcludingVat = other.getBeginMonthAmountExcludingVat();
                                                                                                                                          if (this$beginMonthAmountExcludingVat
                                                                                                                                                == null
                                                                                                                                             ? other$beginMonthAmountExcludingVat
                                                                                                                                                == null
                                                                                                                                             : this$beginMonthAmountExcludingVat.equals(
                                                                                                                                                other$beginMonthAmountExcludingVat
                                                                                                                                             )) {
                                                                                                                                             Object this$beginMonthAmount = this.getBeginMonthAmount();
                                                                                                                                             Object other$beginMonthAmount = other.getBeginMonthAmount();
                                                                                                                                             if (this$beginMonthAmount
                                                                                                                                                   == null
                                                                                                                                                ? other$beginMonthAmount
                                                                                                                                                   == null
                                                                                                                                                : this$beginMonthAmount.equals(
                                                                                                                                                   other$beginMonthAmount
                                                                                                                                                )) {
                                                                                                                                                Object this$endMonthTotalQuantity = this.getEndMonthTotalQuantity();
                                                                                                                                                Object other$endMonthTotalQuantity = other.getEndMonthTotalQuantity();
                                                                                                                                                if (this$endMonthTotalQuantity
                                                                                                                                                      == null
                                                                                                                                                   ? other$endMonthTotalQuantity
                                                                                                                                                      == null
                                                                                                                                                   : this$endMonthTotalQuantity.equals(
                                                                                                                                                      other$endMonthTotalQuantity
                                                                                                                                                   )) {
                                                                                                                                                   Object this$endMonthTotalWeight = this.getEndMonthTotalWeight();
                                                                                                                                                   Object other$endMonthTotalWeight = other.getEndMonthTotalWeight();
                                                                                                                                                   if (this$endMonthTotalWeight
                                                                                                                                                         == null
                                                                                                                                                      ? other$endMonthTotalWeight
                                                                                                                                                         == null
                                                                                                                                                      : this$endMonthTotalWeight.equals(
                                                                                                                                                         other$endMonthTotalWeight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$endMonthTotalLength = this.getEndMonthTotalLength();
                                                                                                                                                      Object other$endMonthTotalLength = other.getEndMonthTotalLength();
                                                                                                                                                      if (this$endMonthTotalLength
                                                                                                                                                            == null
                                                                                                                                                         ? other$endMonthTotalLength
                                                                                                                                                            == null
                                                                                                                                                         : this$endMonthTotalLength.equals(
                                                                                                                                                            other$endMonthTotalLength
                                                                                                                                                         )) {
                                                                                                                                                         Object this$endMonthTotalArea = this.getEndMonthTotalArea();
                                                                                                                                                         Object other$endMonthTotalArea = other.getEndMonthTotalArea();
                                                                                                                                                         if (this$endMonthTotalArea
                                                                                                                                                               == null
                                                                                                                                                            ? other$endMonthTotalArea
                                                                                                                                                               == null
                                                                                                                                                            : this$endMonthTotalArea.equals(
                                                                                                                                                               other$endMonthTotalArea
                                                                                                                                                            )) {
                                                                                                                                                            Object this$endMonthAmountExcludingVat = this.getEndMonthAmountExcludingVat();
                                                                                                                                                            Object other$endMonthAmountExcludingVat = other.getEndMonthAmountExcludingVat();
                                                                                                                                                            if (this$endMonthAmountExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               ? other$endMonthAmountExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               : this$endMonthAmountExcludingVat.equals(
                                                                                                                                                                  other$endMonthAmountExcludingVat
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$endMonthAmount = this.getEndMonthAmount();
                                                                                                                                                               Object other$endMonthAmount = other.getEndMonthAmount();
                                                                                                                                                               if (this$endMonthAmount
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$endMonthAmount
                                                                                                                                                                     == null
                                                                                                                                                                  : this$endMonthAmount.equals(
                                                                                                                                                                     other$endMonthAmount
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                                                                  return this$remark
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$remark
                                                                                                                                                                        == null
                                                                                                                                                                     : this$remark.equals(
                                                                                                                                                                        other$remark
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof StatisticsMonthManufactured;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $monthStr = this.getMonthStr();
      result = result * 59 + ($monthStr == null ? 43 : $monthStr.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalWeight = this.getInboundTotalWeight();
      result = result * 59 + ($inboundTotalWeight == null ? 43 : $inboundTotalWeight.hashCode());
      Object $inboundTotalLength = this.getInboundTotalLength();
      result = result * 59 + ($inboundTotalLength == null ? 43 : $inboundTotalLength.hashCode());
      Object $inboundTotalArea = this.getInboundTotalArea();
      result = result * 59 + ($inboundTotalArea == null ? 43 : $inboundTotalArea.hashCode());
      Object $inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
      result = result * 59 + ($inboundAmountExcludingVat == null ? 43 : $inboundAmountExcludingVat.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $outboundTotalQuantity = this.getOutboundTotalQuantity();
      result = result * 59 + ($outboundTotalQuantity == null ? 43 : $outboundTotalQuantity.hashCode());
      Object $outboundTotalWeight = this.getOutboundTotalWeight();
      result = result * 59 + ($outboundTotalWeight == null ? 43 : $outboundTotalWeight.hashCode());
      Object $outboundTotalLength = this.getOutboundTotalLength();
      result = result * 59 + ($outboundTotalLength == null ? 43 : $outboundTotalLength.hashCode());
      Object $outboundTotalArea = this.getOutboundTotalArea();
      result = result * 59 + ($outboundTotalArea == null ? 43 : $outboundTotalArea.hashCode());
      Object $outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
      result = result * 59 + ($outboundAmountExcludingVat == null ? 43 : $outboundAmountExcludingVat.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $returnTotalQuantity = this.getReturnTotalQuantity();
      result = result * 59 + ($returnTotalQuantity == null ? 43 : $returnTotalQuantity.hashCode());
      Object $returnTotalWeight = this.getReturnTotalWeight();
      result = result * 59 + ($returnTotalWeight == null ? 43 : $returnTotalWeight.hashCode());
      Object $returnTotalLength = this.getReturnTotalLength();
      result = result * 59 + ($returnTotalLength == null ? 43 : $returnTotalLength.hashCode());
      Object $returnTotalArea = this.getReturnTotalArea();
      result = result * 59 + ($returnTotalArea == null ? 43 : $returnTotalArea.hashCode());
      Object $returnAmountExcludingVat = this.getReturnAmountExcludingVat();
      result = result * 59 + ($returnAmountExcludingVat == null ? 43 : $returnAmountExcludingVat.hashCode());
      Object $returnAmount = this.getReturnAmount();
      result = result * 59 + ($returnAmount == null ? 43 : $returnAmount.hashCode());
      Object $beginMonthTotalQuantity = this.getBeginMonthTotalQuantity();
      result = result * 59 + ($beginMonthTotalQuantity == null ? 43 : $beginMonthTotalQuantity.hashCode());
      Object $beginMonthTotalWeight = this.getBeginMonthTotalWeight();
      result = result * 59 + ($beginMonthTotalWeight == null ? 43 : $beginMonthTotalWeight.hashCode());
      Object $beginMonthTotalLength = this.getBeginMonthTotalLength();
      result = result * 59 + ($beginMonthTotalLength == null ? 43 : $beginMonthTotalLength.hashCode());
      Object $beginMonthTotalArea = this.getBeginMonthTotalArea();
      result = result * 59 + ($beginMonthTotalArea == null ? 43 : $beginMonthTotalArea.hashCode());
      Object $beginMonthAmountExcludingVat = this.getBeginMonthAmountExcludingVat();
      result = result * 59 + ($beginMonthAmountExcludingVat == null ? 43 : $beginMonthAmountExcludingVat.hashCode());
      Object $beginMonthAmount = this.getBeginMonthAmount();
      result = result * 59 + ($beginMonthAmount == null ? 43 : $beginMonthAmount.hashCode());
      Object $endMonthTotalQuantity = this.getEndMonthTotalQuantity();
      result = result * 59 + ($endMonthTotalQuantity == null ? 43 : $endMonthTotalQuantity.hashCode());
      Object $endMonthTotalWeight = this.getEndMonthTotalWeight();
      result = result * 59 + ($endMonthTotalWeight == null ? 43 : $endMonthTotalWeight.hashCode());
      Object $endMonthTotalLength = this.getEndMonthTotalLength();
      result = result * 59 + ($endMonthTotalLength == null ? 43 : $endMonthTotalLength.hashCode());
      Object $endMonthTotalArea = this.getEndMonthTotalArea();
      result = result * 59 + ($endMonthTotalArea == null ? 43 : $endMonthTotalArea.hashCode());
      Object $endMonthAmountExcludingVat = this.getEndMonthAmountExcludingVat();
      result = result * 59 + ($endMonthAmountExcludingVat == null ? 43 : $endMonthAmountExcludingVat.hashCode());
      Object $endMonthAmount = this.getEndMonthAmount();
      result = result * 59 + ($endMonthAmount == null ? 43 : $endMonthAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class StatisticsMonthManufacturedBuilder {
      private Long id;
      private String monthStr;
      private Integer basicClass;
      private Long monomerId;
      private Long areaId;
      private Long projectId;
      private Long artifactEnclosureId;
      private String manufacturedName;
      private String manufacturedSn;
      private String material;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private BigDecimal weight;
      private BigDecimal surfaceArea;
      private Integer wageQuotaType;
      private BigDecimal taxRate;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal unitPrice;
      private BigDecimal inboundTotalQuantity;
      private BigDecimal inboundTotalWeight;
      private BigDecimal inboundTotalLength;
      private BigDecimal inboundTotalArea;
      private BigDecimal inboundAmountExcludingVat;
      private BigDecimal inboundAmount;
      private BigDecimal outboundTotalQuantity;
      private BigDecimal outboundTotalWeight;
      private BigDecimal outboundTotalLength;
      private BigDecimal outboundTotalArea;
      private BigDecimal outboundAmountExcludingVat;
      private BigDecimal outboundAmount;
      private BigDecimal returnTotalQuantity;
      private BigDecimal returnTotalWeight;
      private BigDecimal returnTotalLength;
      private BigDecimal returnTotalArea;
      private BigDecimal returnAmountExcludingVat;
      private BigDecimal returnAmount;
      private BigDecimal beginMonthTotalQuantity;
      private BigDecimal beginMonthTotalWeight;
      private BigDecimal beginMonthTotalLength;
      private BigDecimal beginMonthTotalArea;
      private BigDecimal beginMonthAmountExcludingVat;
      private BigDecimal beginMonthAmount;
      private BigDecimal endMonthTotalQuantity;
      private BigDecimal endMonthTotalWeight;
      private BigDecimal endMonthTotalLength;
      private BigDecimal endMonthTotalArea;
      private BigDecimal endMonthAmountExcludingVat;
      private BigDecimal endMonthAmount;
      private String remark;

      StatisticsMonthManufacturedBuilder() {
      }

      @JsonProperty("id")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("monthStr")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder monthStr(final String monthStr) {
         this.monthStr = monthStr;
         return this;
      }

      @JsonProperty("basicClass")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("monomerId")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("projectId")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("manufacturedName")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      @JsonProperty("manufacturedSn")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      @JsonProperty("material")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("specification")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("taxRate")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("inboundTotalQuantity")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
         this.inboundTotalQuantity = inboundTotalQuantity;
         return this;
      }

      @JsonProperty("inboundTotalWeight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundTotalWeight(final BigDecimal inboundTotalWeight) {
         this.inboundTotalWeight = inboundTotalWeight;
         return this;
      }

      @JsonProperty("inboundTotalLength")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundTotalLength(final BigDecimal inboundTotalLength) {
         this.inboundTotalLength = inboundTotalLength;
         return this;
      }

      @JsonProperty("inboundTotalArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundTotalArea(final BigDecimal inboundTotalArea) {
         this.inboundTotalArea = inboundTotalArea;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("inboundAmount")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      @JsonProperty("outboundTotalQuantity")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundTotalQuantity(final BigDecimal outboundTotalQuantity) {
         this.outboundTotalQuantity = outboundTotalQuantity;
         return this;
      }

      @JsonProperty("outboundTotalWeight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundTotalWeight(final BigDecimal outboundTotalWeight) {
         this.outboundTotalWeight = outboundTotalWeight;
         return this;
      }

      @JsonProperty("outboundTotalLength")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundTotalLength(final BigDecimal outboundTotalLength) {
         this.outboundTotalLength = outboundTotalLength;
         return this;
      }

      @JsonProperty("outboundTotalArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundTotalArea(final BigDecimal outboundTotalArea) {
         this.outboundTotalArea = outboundTotalArea;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("outboundAmount")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      @JsonProperty("returnTotalQuantity")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnTotalQuantity(final BigDecimal returnTotalQuantity) {
         this.returnTotalQuantity = returnTotalQuantity;
         return this;
      }

      @JsonProperty("returnTotalWeight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnTotalWeight(final BigDecimal returnTotalWeight) {
         this.returnTotalWeight = returnTotalWeight;
         return this;
      }

      @JsonProperty("returnTotalLength")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnTotalLength(final BigDecimal returnTotalLength) {
         this.returnTotalLength = returnTotalLength;
         return this;
      }

      @JsonProperty("returnTotalArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnTotalArea(final BigDecimal returnTotalArea) {
         this.returnTotalArea = returnTotalArea;
         return this;
      }

      @JsonProperty("returnAmountExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnAmountExcludingVat(final BigDecimal returnAmountExcludingVat) {
         this.returnAmountExcludingVat = returnAmountExcludingVat;
         return this;
      }

      @JsonProperty("returnAmount")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder returnAmount(final BigDecimal returnAmount) {
         this.returnAmount = returnAmount;
         return this;
      }

      @JsonProperty("beginMonthTotalQuantity")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthTotalQuantity(final BigDecimal beginMonthTotalQuantity) {
         this.beginMonthTotalQuantity = beginMonthTotalQuantity;
         return this;
      }

      @JsonProperty("beginMonthTotalWeight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthTotalWeight(final BigDecimal beginMonthTotalWeight) {
         this.beginMonthTotalWeight = beginMonthTotalWeight;
         return this;
      }

      @JsonProperty("beginMonthTotalLength")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthTotalLength(final BigDecimal beginMonthTotalLength) {
         this.beginMonthTotalLength = beginMonthTotalLength;
         return this;
      }

      @JsonProperty("beginMonthTotalArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthTotalArea(final BigDecimal beginMonthTotalArea) {
         this.beginMonthTotalArea = beginMonthTotalArea;
         return this;
      }

      @JsonProperty("beginMonthAmountExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthAmountExcludingVat(final BigDecimal beginMonthAmountExcludingVat) {
         this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
         return this;
      }

      @JsonProperty("beginMonthAmount")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder beginMonthAmount(final BigDecimal beginMonthAmount) {
         this.beginMonthAmount = beginMonthAmount;
         return this;
      }

      @JsonProperty("endMonthTotalQuantity")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthTotalQuantity(final BigDecimal endMonthTotalQuantity) {
         this.endMonthTotalQuantity = endMonthTotalQuantity;
         return this;
      }

      @JsonProperty("endMonthTotalWeight")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthTotalWeight(final BigDecimal endMonthTotalWeight) {
         this.endMonthTotalWeight = endMonthTotalWeight;
         return this;
      }

      @JsonProperty("endMonthTotalLength")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthTotalLength(final BigDecimal endMonthTotalLength) {
         this.endMonthTotalLength = endMonthTotalLength;
         return this;
      }

      @JsonProperty("endMonthTotalArea")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthTotalArea(final BigDecimal endMonthTotalArea) {
         this.endMonthTotalArea = endMonthTotalArea;
         return this;
      }

      @JsonProperty("endMonthAmountExcludingVat")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthAmountExcludingVat(final BigDecimal endMonthAmountExcludingVat) {
         this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
         return this;
      }

      @JsonProperty("endMonthAmount")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder endMonthAmount(final BigDecimal endMonthAmount) {
         this.endMonthAmount = endMonthAmount;
         return this;
      }

      @JsonProperty("remark")
      public StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public StatisticsMonthManufactured build() {
         return new StatisticsMonthManufactured(
            this.id,
            this.monthStr,
            this.basicClass,
            this.monomerId,
            this.areaId,
            this.projectId,
            this.artifactEnclosureId,
            this.manufacturedName,
            this.manufacturedSn,
            this.material,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.color,
            this.weight,
            this.surfaceArea,
            this.wageQuotaType,
            this.taxRate,
            this.unitPriceExcludingVat,
            this.unitPrice,
            this.inboundTotalQuantity,
            this.inboundTotalWeight,
            this.inboundTotalLength,
            this.inboundTotalArea,
            this.inboundAmountExcludingVat,
            this.inboundAmount,
            this.outboundTotalQuantity,
            this.outboundTotalWeight,
            this.outboundTotalLength,
            this.outboundTotalArea,
            this.outboundAmountExcludingVat,
            this.outboundAmount,
            this.returnTotalQuantity,
            this.returnTotalWeight,
            this.returnTotalLength,
            this.returnTotalArea,
            this.returnAmountExcludingVat,
            this.returnAmount,
            this.beginMonthTotalQuantity,
            this.beginMonthTotalWeight,
            this.beginMonthTotalLength,
            this.beginMonthTotalArea,
            this.beginMonthAmountExcludingVat,
            this.beginMonthAmount,
            this.endMonthTotalQuantity,
            this.endMonthTotalWeight,
            this.endMonthTotalLength,
            this.endMonthTotalArea,
            this.endMonthAmountExcludingVat,
            this.endMonthAmount,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "StatisticsMonthManufactured.StatisticsMonthManufacturedBuilder(id="
            + this.id
            + ", monthStr="
            + this.monthStr
            + ", basicClass="
            + this.basicClass
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectId="
            + this.projectId
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", surfaceArea="
            + this.surfaceArea
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", taxRate="
            + this.taxRate
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", unitPrice="
            + this.unitPrice
            + ", inboundTotalQuantity="
            + this.inboundTotalQuantity
            + ", inboundTotalWeight="
            + this.inboundTotalWeight
            + ", inboundTotalLength="
            + this.inboundTotalLength
            + ", inboundTotalArea="
            + this.inboundTotalArea
            + ", inboundAmountExcludingVat="
            + this.inboundAmountExcludingVat
            + ", inboundAmount="
            + this.inboundAmount
            + ", outboundTotalQuantity="
            + this.outboundTotalQuantity
            + ", outboundTotalWeight="
            + this.outboundTotalWeight
            + ", outboundTotalLength="
            + this.outboundTotalLength
            + ", outboundTotalArea="
            + this.outboundTotalArea
            + ", outboundAmountExcludingVat="
            + this.outboundAmountExcludingVat
            + ", outboundAmount="
            + this.outboundAmount
            + ", returnTotalQuantity="
            + this.returnTotalQuantity
            + ", returnTotalWeight="
            + this.returnTotalWeight
            + ", returnTotalLength="
            + this.returnTotalLength
            + ", returnTotalArea="
            + this.returnTotalArea
            + ", returnAmountExcludingVat="
            + this.returnAmountExcludingVat
            + ", returnAmount="
            + this.returnAmount
            + ", beginMonthTotalQuantity="
            + this.beginMonthTotalQuantity
            + ", beginMonthTotalWeight="
            + this.beginMonthTotalWeight
            + ", beginMonthTotalLength="
            + this.beginMonthTotalLength
            + ", beginMonthTotalArea="
            + this.beginMonthTotalArea
            + ", beginMonthAmountExcludingVat="
            + this.beginMonthAmountExcludingVat
            + ", beginMonthAmount="
            + this.beginMonthAmount
            + ", endMonthTotalQuantity="
            + this.endMonthTotalQuantity
            + ", endMonthTotalWeight="
            + this.endMonthTotalWeight
            + ", endMonthTotalLength="
            + this.endMonthTotalLength
            + ", endMonthTotalArea="
            + this.endMonthTotalArea
            + ", endMonthAmountExcludingVat="
            + this.endMonthAmountExcludingVat
            + ", endMonthAmount="
            + this.endMonthAmount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
