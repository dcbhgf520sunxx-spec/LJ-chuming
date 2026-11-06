package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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
import javax.persistence.Table;

@ApiModel(value = "盘亏调整明细对象", description = "盘亏调整明细")
@Entity
@TableName("wms_deficit_detail")
@Table(name = "wms_deficit_detail")
public class WmsDeficitDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "useStatus", value = "使用状态[0 没有使用完,1 已使用完],物料入库后重量会进行加权,在退库时就会产生差会产生负数,设置为已使用完")
   @JsonProperty("useStatus")
   @JSONField(name = "useStatus")
   @TableField("use_status")
   @Column(name = "use_status")
   private Boolean useStatus;
   @ApiModelProperty(name = "serialNumber", value = "物料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name")
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整[1 整料,2 余料]")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type")
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "deficitProjectId", value = "盘亏项目 前端传 成本到哪个项目上")
   @JsonProperty("deficitProjectId")
   @JSONField(name = "deficitProjectId")
   @TableField("deficit_project_id")
   @Column(name = "deficit_project_id")
   private Long deficitProjectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight")
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit")
   private String measureUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "mete", value = "总核算量,钢材为当前物料总核算,辅材为单个的核算")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "存储位置ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id")
   private Long warehouseId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id")
   private Long factoryId;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [InvoiceTypeEnum]")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @JsonProperty("weightedAverageSpec")
   @JSONField(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec")
   private String weightedAverageSpec;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id")
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name")
   private String standardName;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材标准重量(Kg/m)")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight")
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "barcode", value = "条形码")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode")
   private String barcode;
   @ApiModelProperty(name = "deficitQuantity", value = "盘亏数量")
   @JsonProperty("deficitQuantity")
   @JSONField(name = "deficitQuantity")
   @TableField("deficit_quantity")
   @Column(name = "deficit_quantity")
   private BigDecimal deficitQuantity;
   @ApiModelProperty(name = "deficitMete", value = "盘亏核算量")
   @JsonProperty("deficitMete")
   @JSONField(name = "deficitMete")
   @TableField("deficit_mete")
   @Column(name = "deficit_mete")
   private BigDecimal deficitMete;
   @ApiModelProperty(name = "deficitId", value = "盘亏单id")
   @JsonProperty("deficitId")
   @JSONField(name = "deficitId")
   @TableField("deficit_id")
   @Column(name = "deficit_id")
   private Long deficitId;
   @ApiModelProperty(name = "deficitSerialNumber", value = "盘亏单号")
   @JsonProperty("deficitSerialNumber")
   @JSONField(name = "deficitSerialNumber")
   @TableField("deficit_serial_number")
   @Column(name = "deficit_serial_number")
   private String deficitSerialNumber;
   @ApiModelProperty(name = "amount", value = "盘亏含税总价", notes = "盘亏含税总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField(value = "amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '盘亏含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField(value = "unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amountExcludingVat", value = "盘亏不含税总价", notes = "盘亏不含税总价")
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
   @ApiModelProperty(name = "inputVat", value = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat")
   private BigDecimal inputVat;
   @ApiModelProperty(name = "deficitType", value = "盘亏成本归属 1公司 2项目")
   @JsonProperty("deficitType")
   @JSONField(name = "deficitType")
   @TableField("deficit_type")
   @Column(name = "deficit_type")
   private Integer deficitType;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name")
   private String applicantName;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;
   @ApiModelProperty(name = "materialId", value = "盘亏物料id")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id")
   private Long materialId;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价 不含运费", notes = "单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = " 不含税总价 不含运费", notes = " 不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT ' 不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "realTime", value = "实际时间")
   @JsonProperty("realTime")
   @JSONField(name = "realTime")
   @TableField("real_time")
   @Column(name = "real_time")
   private LocalDateTime realTime;

   public static WmsDeficitDetail.WmsDeficitDetailBuilder builder() {
      return new WmsDeficitDetail.WmsDeficitDetailBuilder();
   }

   public WmsDeficitDetail() {
   }

   public WmsDeficitDetail(
      final Long id,
      final Boolean useStatus,
      final String serialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final Long deficitProjectId,
      final Long monomerId,
      final Long areaId,
      final Boolean boolPartyA,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal oneTheoryWeight,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String measureUnit,
      final Integer accountingPrecision,
      final String accountingUnit,
      final BigDecimal unitNet,
      final BigDecimal mete,
      final Long workshopId,
      final Long warehouseId,
      final Long factoryId,
      final Integer weightMeasurementMode,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final String remark,
      final String weightedAverageSpec,
      final Long standardId,
      final String standardName,
      final BigDecimal sectionSteelWeight,
      final String barcode,
      final BigDecimal deficitQuantity,
      final BigDecimal deficitMete,
      final Long deficitId,
      final String deficitSerialNumber,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final Integer deficitType,
      final String applicantName,
      final Integer reviewStatus,
      final Long materialId,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.useStatus = useStatus;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.deficitProjectId = deficitProjectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.boolPartyA = boolPartyA;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.oneTheoryWeight = oneTheoryWeight;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.mete = mete;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.factoryId = factoryId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.remark = remark;
      this.weightedAverageSpec = weightedAverageSpec;
      this.standardId = standardId;
      this.standardName = standardName;
      this.sectionSteelWeight = sectionSteelWeight;
      this.barcode = barcode;
      this.deficitQuantity = deficitQuantity;
      this.deficitMete = deficitMete;
      this.deficitId = deficitId;
      this.deficitSerialNumber = deficitSerialNumber;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.deficitType = deficitType;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.materialId = materialId;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.realTime = realTime;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getUseStatus() {
      return this.useStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getDeficitProjectId() {
      return this.deficitProjectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
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

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public BigDecimal getDeficitQuantity() {
      return this.deficitQuantity;
   }

   public BigDecimal getDeficitMete() {
      return this.deficitMete;
   }

   public Long getDeficitId() {
      return this.deficitId;
   }

   public String getDeficitSerialNumber() {
      return this.deficitSerialNumber;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
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

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getMaterialId() {
      return this.materialId;
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

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   @JsonProperty("id")
   public WmsDeficitDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("useStatus")
   public WmsDeficitDetail setUseStatus(final Boolean useStatus) {
      this.useStatus = useStatus;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsDeficitDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsDeficitDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public WmsDeficitDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public WmsDeficitDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public WmsDeficitDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public WmsDeficitDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public WmsDeficitDetail setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public WmsDeficitDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("deficitProjectId")
   public WmsDeficitDetail setDeficitProjectId(final Long deficitProjectId) {
      this.deficitProjectId = deficitProjectId;
      return this;
   }

   @JsonProperty("monomerId")
   public WmsDeficitDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public WmsDeficitDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public WmsDeficitDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("quantity")
   public WmsDeficitDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public WmsDeficitDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public WmsDeficitDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public WmsDeficitDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public WmsDeficitDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public WmsDeficitDetail setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("brand")
   public WmsDeficitDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public WmsDeficitDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public WmsDeficitDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("measureUnit")
   public WmsDeficitDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public WmsDeficitDetail setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public WmsDeficitDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("unitNet")
   public WmsDeficitDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("mete")
   public WmsDeficitDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("workshopId")
   public WmsDeficitDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("warehouseId")
   public WmsDeficitDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("factoryId")
   public WmsDeficitDetail setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public WmsDeficitDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("taxRate")
   public WmsDeficitDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("invoiceType")
   public WmsDeficitDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("remark")
   public WmsDeficitDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("weightedAverageSpec")
   public WmsDeficitDetail setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   @JsonProperty("standardId")
   public WmsDeficitDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public WmsDeficitDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("sectionSteelWeight")
   public WmsDeficitDetail setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   @JsonProperty("barcode")
   public WmsDeficitDetail setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("deficitQuantity")
   public WmsDeficitDetail setDeficitQuantity(final BigDecimal deficitQuantity) {
      this.deficitQuantity = deficitQuantity;
      return this;
   }

   @JsonProperty("deficitMete")
   public WmsDeficitDetail setDeficitMete(final BigDecimal deficitMete) {
      this.deficitMete = deficitMete;
      return this;
   }

   @JsonProperty("deficitId")
   public WmsDeficitDetail setDeficitId(final Long deficitId) {
      this.deficitId = deficitId;
      return this;
   }

   @JsonProperty("deficitSerialNumber")
   public WmsDeficitDetail setDeficitSerialNumber(final String deficitSerialNumber) {
      this.deficitSerialNumber = deficitSerialNumber;
      return this;
   }

   @JsonProperty("amount")
   public WmsDeficitDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("unitPrice")
   public WmsDeficitDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public WmsDeficitDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public WmsDeficitDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public WmsDeficitDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("deficitType")
   public WmsDeficitDetail setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsDeficitDetail setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsDeficitDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("materialId")
   public WmsDeficitDetail setMaterialId(final Long materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public WmsDeficitDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public WmsDeficitDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public WmsDeficitDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public WmsDeficitDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public WmsDeficitDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("realTime")
   public WmsDeficitDetail setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @Override
   public String toString() {
      return "WmsDeficitDetail(id="
         + this.getId()
         + ", useStatus="
         + this.getUseStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", deficitProjectId="
         + this.getDeficitProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
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
         + ", unitNet="
         + this.getUnitNet()
         + ", mete="
         + this.getMete()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", factoryId="
         + this.getFactoryId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", remark="
         + this.getRemark()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", barcode="
         + this.getBarcode()
         + ", deficitQuantity="
         + this.getDeficitQuantity()
         + ", deficitMete="
         + this.getDeficitMete()
         + ", deficitId="
         + this.getDeficitId()
         + ", deficitSerialNumber="
         + this.getDeficitSerialNumber()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", deficitType="
         + this.getDeficitType()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", materialId="
         + this.getMaterialId()
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
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsDeficitDetail)) {
         return false;
      }

      WmsDeficitDetail other = (WmsDeficitDetail)o;
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
                           Object this$deficitProjectId = this.getDeficitProjectId();
                           Object other$deficitProjectId = other.getDeficitProjectId();
                           if (this$deficitProjectId == null ? other$deficitProjectId == null : this$deficitProjectId.equals(other$deficitProjectId)) {
                              Object this$monomerId = this.getMonomerId();
                              Object other$monomerId = other.getMonomerId();
                              if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                 Object this$areaId = this.getAreaId();
                                 Object other$areaId = other.getAreaId();
                                 if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                    Object this$boolPartyA = this.getBoolPartyA();
                                    Object other$boolPartyA = other.getBoolPartyA();
                                    if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                       Object this$accountingPrecision = this.getAccountingPrecision();
                                       Object other$accountingPrecision = other.getAccountingPrecision();
                                       if (this$accountingPrecision == null
                                          ? other$accountingPrecision == null
                                          : this$accountingPrecision.equals(other$accountingPrecision)) {
                                          Object this$workshopId = this.getWorkshopId();
                                          Object other$workshopId = other.getWorkshopId();
                                          if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                             Object this$warehouseId = this.getWarehouseId();
                                             Object other$warehouseId = other.getWarehouseId();
                                             if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                                Object this$factoryId = this.getFactoryId();
                                                Object other$factoryId = other.getFactoryId();
                                                if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                                   Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                   Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                   if (this$weightMeasurementMode == null
                                                      ? other$weightMeasurementMode == null
                                                      : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                      Object this$invoiceType = this.getInvoiceType();
                                                      Object other$invoiceType = other.getInvoiceType();
                                                      if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                         Object this$standardId = this.getStandardId();
                                                         Object other$standardId = other.getStandardId();
                                                         if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                            Object this$deficitId = this.getDeficitId();
                                                            Object other$deficitId = other.getDeficitId();
                                                            if (this$deficitId == null ? other$deficitId == null : this$deficitId.equals(other$deficitId)) {
                                                               Object this$deficitType = this.getDeficitType();
                                                               Object other$deficitType = other.getDeficitType();
                                                               if (this$deficitType == null
                                                                  ? other$deficitType == null
                                                                  : this$deficitType.equals(other$deficitType)) {
                                                                  Object this$reviewStatus = this.getReviewStatus();
                                                                  Object other$reviewStatus = other.getReviewStatus();
                                                                  if (this$reviewStatus == null
                                                                     ? other$reviewStatus == null
                                                                     : this$reviewStatus.equals(other$reviewStatus)) {
                                                                     Object this$materialId = this.getMaterialId();
                                                                     Object other$materialId = other.getMaterialId();
                                                                     if (this$materialId == null
                                                                        ? other$materialId == null
                                                                        : this$materialId.equals(other$materialId)) {
                                                                        Object this$serialNumber = this.getSerialNumber();
                                                                        Object other$serialNumber = other.getSerialNumber();
                                                                        if (this$serialNumber == null
                                                                           ? other$serialNumber == null
                                                                           : this$serialNumber.equals(other$serialNumber)) {
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
                                                                                                : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                                Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                if (this$oneTheoryWeight == null
                                                                                                   ? other$oneTheoryWeight == null
                                                                                                   : this$oneTheoryWeight.equals(other$oneTheoryWeight)) {
                                                                                                   Object this$brand = this.getBrand();
                                                                                                   Object other$brand = other.getBrand();
                                                                                                   if (this$brand == null
                                                                                                      ? other$brand == null
                                                                                                      : this$brand.equals(other$brand)) {
                                                                                                      Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                      Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                      if (this$heatNoAndBatchNo == null
                                                                                                         ? other$heatNoAndBatchNo == null
                                                                                                         : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$color = this.getColor();
                                                                                                         Object other$color = other.getColor();
                                                                                                         if (this$color == null
                                                                                                            ? other$color == null
                                                                                                            : this$color.equals(other$color)) {
                                                                                                            Object this$measureUnit = this.getMeasureUnit();
                                                                                                            Object other$measureUnit = other.getMeasureUnit();
                                                                                                            if (this$measureUnit == null
                                                                                                               ? other$measureUnit == null
                                                                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                                                                               if (this$accountingUnit == null
                                                                                                                  ? other$accountingUnit == null
                                                                                                                  : this$accountingUnit.equals(
                                                                                                                     other$accountingUnit
                                                                                                                  )) {
                                                                                                                  Object this$unitNet = this.getUnitNet();
                                                                                                                  Object other$unitNet = other.getUnitNet();
                                                                                                                  if (this$unitNet == null
                                                                                                                     ? other$unitNet == null
                                                                                                                     : this$unitNet.equals(other$unitNet)) {
                                                                                                                     Object this$mete = this.getMete();
                                                                                                                     Object other$mete = other.getMete();
                                                                                                                     if (this$mete == null
                                                                                                                        ? other$mete == null
                                                                                                                        : this$mete.equals(other$mete)) {
                                                                                                                        Object this$taxRate = this.getTaxRate();
                                                                                                                        Object other$taxRate = other.getTaxRate();
                                                                                                                        if (this$taxRate == null
                                                                                                                           ? other$taxRate == null
                                                                                                                           : this$taxRate.equals(other$taxRate)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$remark = this.getRemark();
                                                                                                                           Object other$remark = other.getRemark();
                                                                                                                           if (this$remark == null
                                                                                                                              ? other$remark == null
                                                                                                                              : this$remark.equals(other$remark)
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                                              Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                                              if (this$weightedAverageSpec
                                                                                                                                    == null
                                                                                                                                 ? other$weightedAverageSpec
                                                                                                                                    == null
                                                                                                                                 : this$weightedAverageSpec.equals(
                                                                                                                                    other$weightedAverageSpec
                                                                                                                                 )) {
                                                                                                                                 Object this$standardName = this.getStandardName();
                                                                                                                                 Object other$standardName = other.getStandardName();
                                                                                                                                 if (this$standardName == null
                                                                                                                                    ? other$standardName
                                                                                                                                       == null
                                                                                                                                    : this$standardName.equals(
                                                                                                                                       other$standardName
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
                                                                                                                                       Object this$barcode = this.getBarcode();
                                                                                                                                       Object other$barcode = other.getBarcode();
                                                                                                                                       if (this$barcode == null
                                                                                                                                          ? other$barcode
                                                                                                                                             == null
                                                                                                                                          : this$barcode.equals(
                                                                                                                                             other$barcode
                                                                                                                                          )) {
                                                                                                                                          Object this$deficitQuantity = this.getDeficitQuantity();
                                                                                                                                          Object other$deficitQuantity = other.getDeficitQuantity();
                                                                                                                                          if (this$deficitQuantity
                                                                                                                                                == null
                                                                                                                                             ? other$deficitQuantity
                                                                                                                                                == null
                                                                                                                                             : this$deficitQuantity.equals(
                                                                                                                                                other$deficitQuantity
                                                                                                                                             )) {
                                                                                                                                             Object this$deficitMete = this.getDeficitMete();
                                                                                                                                             Object other$deficitMete = other.getDeficitMete();
                                                                                                                                             if (this$deficitMete
                                                                                                                                                   == null
                                                                                                                                                ? other$deficitMete
                                                                                                                                                   == null
                                                                                                                                                : this$deficitMete.equals(
                                                                                                                                                   other$deficitMete
                                                                                                                                                )) {
                                                                                                                                                Object this$deficitSerialNumber = this.getDeficitSerialNumber();
                                                                                                                                                Object other$deficitSerialNumber = other.getDeficitSerialNumber();
                                                                                                                                                if (this$deficitSerialNumber
                                                                                                                                                      == null
                                                                                                                                                   ? other$deficitSerialNumber
                                                                                                                                                      == null
                                                                                                                                                   : this$deficitSerialNumber.equals(
                                                                                                                                                      other$deficitSerialNumber
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
                                                                                                                                                      Object this$unitPrice = this.getUnitPrice();
                                                                                                                                                      Object other$unitPrice = other.getUnitPrice();
                                                                                                                                                      if (this$unitPrice
                                                                                                                                                            == null
                                                                                                                                                         ? other$unitPrice
                                                                                                                                                            == null
                                                                                                                                                         : this$unitPrice.equals(
                                                                                                                                                            other$unitPrice
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
                                                                                                                                                                  Object this$applicantName = this.getApplicantName();
                                                                                                                                                                  Object other$applicantName = other.getApplicantName();
                                                                                                                                                                  if (this$applicantName
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$applicantName
                                                                                                                                                                        == null
                                                                                                                                                                     : this$applicantName.equals(
                                                                                                                                                                        other$applicantName
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsDeficitDetail;
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
      Object $deficitProjectId = this.getDeficitProjectId();
      result = result * 59 + ($deficitProjectId == null ? 43 : $deficitProjectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $deficitId = this.getDeficitId();
      result = result * 59 + ($deficitId == null ? 43 : $deficitId.hashCode());
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
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
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
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
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $deficitQuantity = this.getDeficitQuantity();
      result = result * 59 + ($deficitQuantity == null ? 43 : $deficitQuantity.hashCode());
      Object $deficitMete = this.getDeficitMete();
      result = result * 59 + ($deficitMete == null ? 43 : $deficitMete.hashCode());
      Object $deficitSerialNumber = this.getDeficitSerialNumber();
      result = result * 59 + ($deficitSerialNumber == null ? 43 : $deficitSerialNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
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
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class WmsDeficitDetailBuilder {
      private Long id;
      private Boolean useStatus;
      private String serialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private Long deficitProjectId;
      private Long monomerId;
      private Long areaId;
      private Boolean boolPartyA;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal oneTheoryWeight;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String measureUnit;
      private Integer accountingPrecision;
      private String accountingUnit;
      private BigDecimal unitNet;
      private BigDecimal mete;
      private Long workshopId;
      private Long warehouseId;
      private Long factoryId;
      private Integer weightMeasurementMode;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private String remark;
      private String weightedAverageSpec;
      private Long standardId;
      private String standardName;
      private BigDecimal sectionSteelWeight;
      private String barcode;
      private BigDecimal deficitQuantity;
      private BigDecimal deficitMete;
      private Long deficitId;
      private String deficitSerialNumber;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private Integer deficitType;
      private String applicantName;
      private Integer reviewStatus;
      private Long materialId;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private LocalDateTime realTime;

      WmsDeficitDetailBuilder() {
      }

      @JsonProperty("id")
      public WmsDeficitDetail.WmsDeficitDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("useStatus")
      public WmsDeficitDetail.WmsDeficitDetailBuilder useStatus(final Boolean useStatus) {
         this.useStatus = useStatus;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsDeficitDetail.WmsDeficitDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsDeficitDetail.WmsDeficitDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public WmsDeficitDetail.WmsDeficitDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public WmsDeficitDetail.WmsDeficitDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public WmsDeficitDetail.WmsDeficitDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public WmsDeficitDetail.WmsDeficitDetailBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("deficitProjectId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitProjectId(final Long deficitProjectId) {
         this.deficitProjectId = deficitProjectId;
         return this;
      }

      @JsonProperty("monomerId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public WmsDeficitDetail.WmsDeficitDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("quantity")
      public WmsDeficitDetail.WmsDeficitDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public WmsDeficitDetail.WmsDeficitDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public WmsDeficitDetail.WmsDeficitDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public WmsDeficitDetail.WmsDeficitDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public WmsDeficitDetail.WmsDeficitDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("brand")
      public WmsDeficitDetail.WmsDeficitDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public WmsDeficitDetail.WmsDeficitDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public WmsDeficitDetail.WmsDeficitDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("measureUnit")
      public WmsDeficitDetail.WmsDeficitDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public WmsDeficitDetail.WmsDeficitDetailBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public WmsDeficitDetail.WmsDeficitDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public WmsDeficitDetail.WmsDeficitDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("mete")
      public WmsDeficitDetail.WmsDeficitDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("workshopId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("warehouseId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("factoryId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public WmsDeficitDetail.WmsDeficitDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("taxRate")
      public WmsDeficitDetail.WmsDeficitDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public WmsDeficitDetail.WmsDeficitDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("remark")
      public WmsDeficitDetail.WmsDeficitDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("weightedAverageSpec")
      public WmsDeficitDetail.WmsDeficitDetailBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      @JsonProperty("standardId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public WmsDeficitDetail.WmsDeficitDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("barcode")
      public WmsDeficitDetail.WmsDeficitDetailBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("deficitQuantity")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitQuantity(final BigDecimal deficitQuantity) {
         this.deficitQuantity = deficitQuantity;
         return this;
      }

      @JsonProperty("deficitMete")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitMete(final BigDecimal deficitMete) {
         this.deficitMete = deficitMete;
         return this;
      }

      @JsonProperty("deficitId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitId(final Long deficitId) {
         this.deficitId = deficitId;
         return this;
      }

      @JsonProperty("deficitSerialNumber")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitSerialNumber(final String deficitSerialNumber) {
         this.deficitSerialNumber = deficitSerialNumber;
         return this;
      }

      @JsonProperty("amount")
      public WmsDeficitDetail.WmsDeficitDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("unitPrice")
      public WmsDeficitDetail.WmsDeficitDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public WmsDeficitDetail.WmsDeficitDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public WmsDeficitDetail.WmsDeficitDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public WmsDeficitDetail.WmsDeficitDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("deficitType")
      public WmsDeficitDetail.WmsDeficitDetailBuilder deficitType(final Integer deficitType) {
         this.deficitType = deficitType;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsDeficitDetail.WmsDeficitDetailBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsDeficitDetail.WmsDeficitDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("materialId")
      public WmsDeficitDetail.WmsDeficitDetailBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public WmsDeficitDetail.WmsDeficitDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("realTime")
      public WmsDeficitDetail.WmsDeficitDetailBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public WmsDeficitDetail build() {
         return new WmsDeficitDetail(
            this.id,
            this.useStatus,
            this.serialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.deficitProjectId,
            this.monomerId,
            this.areaId,
            this.boolPartyA,
            this.quantity,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.oneTheoryWeight,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.measureUnit,
            this.accountingPrecision,
            this.accountingUnit,
            this.unitNet,
            this.mete,
            this.workshopId,
            this.warehouseId,
            this.factoryId,
            this.weightMeasurementMode,
            this.taxRate,
            this.invoiceType,
            this.remark,
            this.weightedAverageSpec,
            this.standardId,
            this.standardName,
            this.sectionSteelWeight,
            this.barcode,
            this.deficitQuantity,
            this.deficitMete,
            this.deficitId,
            this.deficitSerialNumber,
            this.amount,
            this.unitPrice,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.deficitType,
            this.applicantName,
            this.reviewStatus,
            this.materialId,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "WmsDeficitDetail.WmsDeficitDetailBuilder(id="
            + this.id
            + ", useStatus="
            + this.useStatus
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
            + ", deficitProjectId="
            + this.deficitProjectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
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
            + ", unitNet="
            + this.unitNet
            + ", mete="
            + this.mete
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", factoryId="
            + this.factoryId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", remark="
            + this.remark
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", barcode="
            + this.barcode
            + ", deficitQuantity="
            + this.deficitQuantity
            + ", deficitMete="
            + this.deficitMete
            + ", deficitId="
            + this.deficitId
            + ", deficitSerialNumber="
            + this.deficitSerialNumber
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", deficitType="
            + this.deficitType
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
            + ", materialId="
            + this.materialId
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
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
