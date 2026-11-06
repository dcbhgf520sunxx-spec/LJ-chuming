package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "PurchaseOrderDetail对象", description = "采购详情")
@Entity
@TableName("scm_purchase_order_detail")
@Table(name = "scm_purchase_order_detail")
public class PurchaseOrderDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "purchaseId", value = "采购订单ID", notes = "采购订单ID")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '采购订单ID'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "applyPurchaseId", value = "申购单ID")
   @JsonProperty("applyPurchaseId")
   @JSONField(name = "applyPurchaseId")
   @TableField(value = "apply_purchase_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "apply_purchase_id", columnDefinition = "bigint  COMMENT '申购单ID'", nullable = true)
   private Long applyPurchaseId;
   @ApiModelProperty(name = "applyPurchaseDetailId", value = "申购单详情ID")
   @JsonProperty("applyPurchaseDetailId")
   @JSONField(name = "applyPurchaseDetailId")
   @TableField(value = "apply_purchase_detail_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "apply_purchase_detail_id", columnDefinition = "bigint  COMMENT '申购单详情ID'", nullable = true)
   private Long applyPurchaseDetailId;
   @ApiModelProperty(name = "applyPurchaseSN", value = "申购单编号")
   @JsonProperty("applyPurchaseSN")
   @JSONField(name = "applyPurchaseSN")
   @TableField(value = "apply_purchase_sn", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "apply_purchase_sn", columnDefinition = "varchar(255)  COMMENT '申购单编号'", nullable = true)
   private String applyPurchaseSN;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件/围护ID", notes = "构件/围护ID")
   @JsonProperty("artifactEnclosureId")
   @JSONField(name = "artifactEnclosureId")
   @TableField("artifact_enclosure_id")
   @Column(name = "artifact_enclosure_id", columnDefinition = "bigint  COMMENT '构件/围护ID'", nullable = true)
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "model", value = "型号")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
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
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量", notes = "入库数量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   @TableField("inbound_quantity")
   @Column(name = "inbound_quantity", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '入库数量'", nullable = true)
   private BigDecimal inboundQuantity;
   @ApiModelProperty(name = "inboundMete", value = "入库核算量 ", notes = "入库核算量")
   @JsonProperty("inboundMete")
   @JSONField(name = "inboundMete")
   @TableField("inbound_mete")
   @Column(name = "inbound_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '入库核算量'", nullable = true)
   private BigDecimal inboundMete;
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
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1 理计,2 磅计,4 混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField(value = "weight_measurement_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "weight_measurement_mode")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "projectId", value = "所属项目")
   @JsonProperty("projectId")
   @JSONField(name = "project_id")
   @TableField("project_id")
   @Column(name = "projectId", columnDefinition = "bigint(20)")
   private Long projectId;
   @ApiModelProperty(name = "factoryId", value = "所属工厂")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)")
   private Long factoryId;
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
   @ApiModelProperty(name = "materialSn", value = "材料编号", notes = "材料编号")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '材料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "sectionSteelSpecId", value = "型材规格ID", notes = "型材规格ID")
   @JsonProperty("sectionSteelSpecId")
   @JSONField(name = "sectionSteelSpecId")
   @TableField("section_steel_spec_id")
   @Column(name = "section_steel_spec_id", columnDefinition = "bigint  COMMENT '型材规格ID'", nullable = true)
   private Long sectionSteelSpecId;
   @ApiModelProperty(name = "specificationIds", value = "规格ID集", notes = "规格ID集")
   @JsonProperty("specificationIds")
   @JSONField(name = "specificationIds")
   @TableField("specification_ids")
   @Column(name = "specification_ids", columnDefinition = "varchar(255)  COMMENT '规格ID集'", nullable = true)
   private String specificationIds;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "boolOriginalDetail", value = "是否原单子明细，默认为是", notes = "是否原单子明细，默认为是")
   @JsonProperty("boolOriginalDetail")
   @JSONField(name = "boolOriginalDetail")
   @TableField("bool_original_detail")
   @Column(name = "bool_original_detail", columnDefinition = "tinyint(1) DEFAULT '1'  COMMENT '是否原单子明细，默认为是'", nullable = true)
   private Boolean boolOriginalDetail;
   @ApiModelProperty(name = "workshopId", value = "仓库ID wms仓库", notes = "仓库ID wms仓库")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID wms仓库'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "finishedGoodsTypeName", value = "当材料为制成品的时候会有创建类型", notes = "当材料为制成品的时候会有创建类型")
   @JsonProperty("finishedGoodsTypeName")
   @JSONField(name = "finishedGoodsTypeName")
   @TableField("finished_goods_type_name")
   @Column(name = "finished_goods_type_name", columnDefinition = "varchar(255)  COMMENT '当材料为制成品的时候会有创建类型'", nullable = true)
   private String finishedGoodsTypeName;
   @ApiModelProperty(name = "manufacturedSpecification", value = "制成品自定义规格", notes = "制成品自定义规格")
   @JsonProperty("manufacturedSpecification")
   @JSONField(name = "manufacturedSpecification")
   @TableField("manufactured_specification")
   @Column(name = "manufactured_specification", columnDefinition = "varchar(255)  COMMENT '制成品自定义规格'", nullable = true)
   private String manufacturedSpecification;
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
   @ApiModelProperty(name = "weight", value = "单重（g）", notes = "单重（g）")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8)  COMMENT '单重（g）'", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重（g）", notes = "总重（g）")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8)  COMMENT '总重（g）'", nullable = true)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalLength", value = "总长（mm）", notes = "总长（mm）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,8)  COMMENT '总长（mm）'", nullable = true)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）", notes = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8)  COMMENT '单面积（mm²）'", nullable = true)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积（mm²）", notes = "总面积（mm²）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8)  COMMENT '总面积（mm²）'", nullable = true)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "manufacturedName", value = "制成品名称", notes = "制成品名称")
   @JsonProperty("manufacturedName")
   @JSONField(name = "manufacturedName")
   @TableField("manufactured_name")
   @Column(name = "manufactured_name", columnDefinition = "varchar(255)  COMMENT '制成品名称'", nullable = true)
   private String manufacturedName;
   @ApiModelProperty(
      name = "manufacturedType",
      value = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum",
      notes = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum"
   )
   @JsonProperty("manufacturedType")
   @JSONField(name = "manufacturedType")
   @TableField("manufactured_type")
   @Column(name = "manufactured_type", columnDefinition = "varchar(255)  COMMENT '制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum'", nullable = true)
   private Integer manufacturedType;
   @ApiModelProperty(name = "manufacturedSn", value = "制成品编号", notes = "制成品编号")
   @JsonProperty("manufacturedSn")
   @JSONField(name = "manufacturedSn")
   @TableField("manufactured_sn")
   @Column(name = "manufactured_sn", columnDefinition = "varchar(255)  COMMENT '制成品编号'", nullable = true)
   private String manufacturedSn;
   @ApiModelProperty(name = "manufacturedUnit", value = "制成品单位", notes = "制成品单位")
   @JsonProperty("manufacturedUnit")
   @JSONField(name = "manufacturedUnit")
   @TableField("manufactured_unit")
   @Column(name = "manufactured_unit", columnDefinition = "varchar(255)  COMMENT '制成品单位'", nullable = true)
   private String manufacturedUnit;
   @ApiModelProperty(name = "material", value = "制成品材质", notes = "制成品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '制成品材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '制成品计价方式 计价方式 WmsWageQuotaTypeEnum'", nullable = true)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "receivedQuantity", value = "收货数量", notes = "收货数量")
   @JsonProperty("receivedQuantity")
   @JSONField(name = "receivedQuantity")
   @TableField("received_quantity")
   @Column(name = "received_quantity", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '收货数量'", nullable = true)
   private BigDecimal receivedQuantity;
   @ApiModelProperty(name = "receivedMete", value = "理论收货核算量 ", notes = "理论收货核算量")
   @JsonProperty("receivedMete")
   @JSONField(name = "receivedMete")
   @TableField("received_mete")
   @Column(name = "received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '收货核算量'", nullable = true)
   private BigDecimal receivedMete;
   @ApiModelProperty(name = "actualReceivedMete", value = "实际收货核算量 ", notes = "实际收货核算量")
   @JsonProperty("actualReceivedMete")
   @JSONField(name = "actualReceivedMete")
   @TableField("actual_received_mete")
   @Column(name = "actual_received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '实际收货核算量'", nullable = true)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "steelDensity", value = "钢材密度", notes = "钢材密度")
   @JsonProperty("steelDensity")
   @JSONField(name = "steelDensity")
   @TableField("steel_density")
   @Column(name = "steel_density", columnDefinition = "decimal(10,5)  COMMENT '钢材密度'", nullable = true)
   private BigDecimal steelDensity;
   @ApiModelProperty(name = "uniqueIdentification", value = "唯一标识（用于前端导入使用）", notes = "唯一标识（用于前端导入使用）")
   @JsonProperty("uniqueIdentification")
   @JSONField(name = "uniqueIdentification")
   @TableField("unique_identification")
   @Column(name = "unique_identification", columnDefinition = "varchar(255)  COMMENT '唯一标识（用于前端导入使用）'", nullable = true)
   private String uniqueIdentification;

   public static PurchaseOrderDetail.PurchaseOrderDetailBuilder builder() {
      return new PurchaseOrderDetail.PurchaseOrderDetailBuilder();
   }

   public PurchaseOrderDetail() {
   }

   public PurchaseOrderDetail(
      final Long id,
      final Long purchaseId,
      final Long applyPurchaseId,
      final Long applyPurchaseDetailId,
      final String applyPurchaseSN,
      final Long artifactEnclosureId,
      final Long classifyId,
      final String classifyName,
      final Integer basicClass,
      final String specification,
      final String model,
      final String color,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal inboundQuantity,
      final BigDecimal inboundMete,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final Integer weightMeasurementMode,
      final Long projectId,
      final Long factoryId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final String materialSn,
      final Long sectionSteelSpecId,
      final String specificationIds,
      final Long standardId,
      final Boolean boolOriginalDetail,
      final Long workshopId,
      final String finishedGoodsTypeName,
      final String manufacturedSpecification,
      final Long monomerId,
      final Long areaId,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final String manufacturedName,
      final Integer manufacturedType,
      final String manufacturedSn,
      final String manufacturedUnit,
      final String material,
      final Integer wageQuotaType,
      final BigDecimal receivedQuantity,
      final BigDecimal receivedMete,
      final BigDecimal actualReceivedMete,
      final BigDecimal steelDensity,
      final String uniqueIdentification
   ) {
      this.id = id;
      this.purchaseId = purchaseId;
      this.applyPurchaseId = applyPurchaseId;
      this.applyPurchaseDetailId = applyPurchaseDetailId;
      this.applyPurchaseSN = applyPurchaseSN;
      this.artifactEnclosureId = artifactEnclosureId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.model = model;
      this.color = color;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.quantity = quantity;
      this.mete = mete;
      this.inboundQuantity = inboundQuantity;
      this.inboundMete = inboundMete;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.weightMeasurementMode = weightMeasurementMode;
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.materialSn = materialSn;
      this.sectionSteelSpecId = sectionSteelSpecId;
      this.specificationIds = specificationIds;
      this.standardId = standardId;
      this.boolOriginalDetail = boolOriginalDetail;
      this.workshopId = workshopId;
      this.finishedGoodsTypeName = finishedGoodsTypeName;
      this.manufacturedSpecification = manufacturedSpecification;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.manufacturedName = manufacturedName;
      this.manufacturedType = manufacturedType;
      this.manufacturedSn = manufacturedSn;
      this.manufacturedUnit = manufacturedUnit;
      this.material = material;
      this.wageQuotaType = wageQuotaType;
      this.receivedQuantity = receivedQuantity;
      this.receivedMete = receivedMete;
      this.actualReceivedMete = actualReceivedMete;
      this.steelDensity = steelDensity;
      this.uniqueIdentification = uniqueIdentification;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public Long getApplyPurchaseDetailId() {
      return this.applyPurchaseDetailId;
   }

   public String getApplyPurchaseSN() {
      return this.applyPurchaseSN;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public String getColor() {
      return this.color;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
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

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getSectionSteelSpecId() {
      return this.sectionSteelSpecId;
   }

   public String getSpecificationIds() {
      return this.specificationIds;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public Boolean getBoolOriginalDetail() {
      return this.boolOriginalDetail;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getFinishedGoodsTypeName() {
      return this.finishedGoodsTypeName;
   }

   public String getManufacturedSpecification() {
      return this.manufacturedSpecification;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public Integer getManufacturedType() {
      return this.manufacturedType;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getManufacturedUnit() {
      return this.manufacturedUnit;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getReceivedQuantity() {
      return this.receivedQuantity;
   }

   public BigDecimal getReceivedMete() {
      return this.receivedMete;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public String getUniqueIdentification() {
      return this.uniqueIdentification;
   }

   @JsonProperty("id")
   public PurchaseOrderDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("purchaseId")
   public PurchaseOrderDetail setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("applyPurchaseId")
   public PurchaseOrderDetail setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
      return this;
   }

   @JsonProperty("applyPurchaseDetailId")
   public PurchaseOrderDetail setApplyPurchaseDetailId(final Long applyPurchaseDetailId) {
      this.applyPurchaseDetailId = applyPurchaseDetailId;
      return this;
   }

   @JsonProperty("applyPurchaseSN")
   public PurchaseOrderDetail setApplyPurchaseSN(final String applyPurchaseSN) {
      this.applyPurchaseSN = applyPurchaseSN;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public PurchaseOrderDetail setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("classifyId")
   public PurchaseOrderDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public PurchaseOrderDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("basicClass")
   public PurchaseOrderDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public PurchaseOrderDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("model")
   public PurchaseOrderDetail setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("color")
   public PurchaseOrderDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("length")
   public PurchaseOrderDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public PurchaseOrderDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public PurchaseOrderDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public PurchaseOrderDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("quantity")
   public PurchaseOrderDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public PurchaseOrderDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public PurchaseOrderDetail setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("inboundMete")
   public PurchaseOrderDetail setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public PurchaseOrderDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public PurchaseOrderDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public PurchaseOrderDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public PurchaseOrderDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amount")
   public PurchaseOrderDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public PurchaseOrderDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("projectId")
   public PurchaseOrderDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("factoryId")
   public PurchaseOrderDetail setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("sectionSteelSpec")
   public PurchaseOrderDetail setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
      return this;
   }

   @JsonProperty("doNotSectionSteelSpec")
   public PurchaseOrderDetail setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      return this;
   }

   @JsonProperty("materialSn")
   public PurchaseOrderDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("sectionSteelSpecId")
   public PurchaseOrderDetail setSectionSteelSpecId(final Long sectionSteelSpecId) {
      this.sectionSteelSpecId = sectionSteelSpecId;
      return this;
   }

   @JsonProperty("specificationIds")
   public PurchaseOrderDetail setSpecificationIds(final String specificationIds) {
      this.specificationIds = specificationIds;
      return this;
   }

   @JsonProperty("standardId")
   public PurchaseOrderDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("boolOriginalDetail")
   public PurchaseOrderDetail setBoolOriginalDetail(final Boolean boolOriginalDetail) {
      this.boolOriginalDetail = boolOriginalDetail;
      return this;
   }

   @JsonProperty("workshopId")
   public PurchaseOrderDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("finishedGoodsTypeName")
   public PurchaseOrderDetail setFinishedGoodsTypeName(final String finishedGoodsTypeName) {
      this.finishedGoodsTypeName = finishedGoodsTypeName;
      return this;
   }

   @JsonProperty("manufacturedSpecification")
   public PurchaseOrderDetail setManufacturedSpecification(final String manufacturedSpecification) {
      this.manufacturedSpecification = manufacturedSpecification;
      return this;
   }

   @JsonProperty("monomerId")
   public PurchaseOrderDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public PurchaseOrderDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("weight")
   public PurchaseOrderDetail setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("totalWeight")
   public PurchaseOrderDetail setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public PurchaseOrderDetail setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("surfaceArea")
   public PurchaseOrderDetail setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("totalArea")
   public PurchaseOrderDetail setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("manufacturedName")
   public PurchaseOrderDetail setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
      return this;
   }

   @JsonProperty("manufacturedType")
   public PurchaseOrderDetail setManufacturedType(final Integer manufacturedType) {
      this.manufacturedType = manufacturedType;
      return this;
   }

   @JsonProperty("manufacturedSn")
   public PurchaseOrderDetail setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
      return this;
   }

   @JsonProperty("manufacturedUnit")
   public PurchaseOrderDetail setManufacturedUnit(final String manufacturedUnit) {
      this.manufacturedUnit = manufacturedUnit;
      return this;
   }

   @JsonProperty("material")
   public PurchaseOrderDetail setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public PurchaseOrderDetail setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("receivedQuantity")
   public PurchaseOrderDetail setReceivedQuantity(final BigDecimal receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
      return this;
   }

   @JsonProperty("receivedMete")
   public PurchaseOrderDetail setReceivedMete(final BigDecimal receivedMete) {
      this.receivedMete = receivedMete;
      return this;
   }

   @JsonProperty("actualReceivedMete")
   public PurchaseOrderDetail setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
      return this;
   }

   @JsonProperty("steelDensity")
   public PurchaseOrderDetail setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
      return this;
   }

   @JsonProperty("uniqueIdentification")
   public PurchaseOrderDetail setUniqueIdentification(final String uniqueIdentification) {
      this.uniqueIdentification = uniqueIdentification;
      return this;
   }

   @Override
   public String toString() {
      return "PurchaseOrderDetail(id="
         + this.getId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", applyPurchaseDetailId="
         + this.getApplyPurchaseDetailId()
         + ", applyPurchaseSN="
         + this.getApplyPurchaseSN()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", color="
         + this.getColor()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", inboundMete="
         + this.getInboundMete()
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
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", materialSn="
         + this.getMaterialSn()
         + ", sectionSteelSpecId="
         + this.getSectionSteelSpecId()
         + ", specificationIds="
         + this.getSpecificationIds()
         + ", standardId="
         + this.getStandardId()
         + ", boolOriginalDetail="
         + this.getBoolOriginalDetail()
         + ", workshopId="
         + this.getWorkshopId()
         + ", finishedGoodsTypeName="
         + this.getFinishedGoodsTypeName()
         + ", manufacturedSpecification="
         + this.getManufacturedSpecification()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedType="
         + this.getManufacturedType()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", manufacturedUnit="
         + this.getManufacturedUnit()
         + ", material="
         + this.getMaterial()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", receivedQuantity="
         + this.getReceivedQuantity()
         + ", receivedMete="
         + this.getReceivedMete()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", steelDensity="
         + this.getSteelDensity()
         + ", uniqueIdentification="
         + this.getUniqueIdentification()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderDetail)) {
         return false;
      }

      PurchaseOrderDetail other = (PurchaseOrderDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$applyPurchaseId = this.getApplyPurchaseId();
            Object other$applyPurchaseId = other.getApplyPurchaseId();
            if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
               Object this$applyPurchaseDetailId = this.getApplyPurchaseDetailId();
               Object other$applyPurchaseDetailId = other.getApplyPurchaseDetailId();
               if (this$applyPurchaseDetailId == null ? other$applyPurchaseDetailId == null : this$applyPurchaseDetailId.equals(other$applyPurchaseDetailId)) {
                  Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                  Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                  if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                     Object this$classifyId = this.getClassifyId();
                     Object other$classifyId = other.getClassifyId();
                     if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                           Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                           if (this$weightMeasurementMode == null
                              ? other$weightMeasurementMode == null
                              : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                              Object this$projectId = this.getProjectId();
                              Object other$projectId = other.getProjectId();
                              if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                 Object this$factoryId = this.getFactoryId();
                                 Object other$factoryId = other.getFactoryId();
                                 if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                    Object this$sectionSteelSpecId = this.getSectionSteelSpecId();
                                    Object other$sectionSteelSpecId = other.getSectionSteelSpecId();
                                    if (this$sectionSteelSpecId == null
                                       ? other$sectionSteelSpecId == null
                                       : this$sectionSteelSpecId.equals(other$sectionSteelSpecId)) {
                                       Object this$standardId = this.getStandardId();
                                       Object other$standardId = other.getStandardId();
                                       if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                          Object this$boolOriginalDetail = this.getBoolOriginalDetail();
                                          Object other$boolOriginalDetail = other.getBoolOriginalDetail();
                                          if (this$boolOriginalDetail == null
                                             ? other$boolOriginalDetail == null
                                             : this$boolOriginalDetail.equals(other$boolOriginalDetail)) {
                                             Object this$workshopId = this.getWorkshopId();
                                             Object other$workshopId = other.getWorkshopId();
                                             if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                Object this$monomerId = this.getMonomerId();
                                                Object other$monomerId = other.getMonomerId();
                                                if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                   Object this$areaId = this.getAreaId();
                                                   Object other$areaId = other.getAreaId();
                                                   if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                      Object this$manufacturedType = this.getManufacturedType();
                                                      Object other$manufacturedType = other.getManufacturedType();
                                                      if (this$manufacturedType == null
                                                         ? other$manufacturedType == null
                                                         : this$manufacturedType.equals(other$manufacturedType)) {
                                                         Object this$wageQuotaType = this.getWageQuotaType();
                                                         Object other$wageQuotaType = other.getWageQuotaType();
                                                         if (this$wageQuotaType == null
                                                            ? other$wageQuotaType == null
                                                            : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                            Object this$applyPurchaseSN = this.getApplyPurchaseSN();
                                                            Object other$applyPurchaseSN = other.getApplyPurchaseSN();
                                                            if (this$applyPurchaseSN == null
                                                               ? other$applyPurchaseSN == null
                                                               : this$applyPurchaseSN.equals(other$applyPurchaseSN)) {
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
                                                                     if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                                        Object this$color = this.getColor();
                                                                        Object other$color = other.getColor();
                                                                        if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                           Object this$length = this.getLength();
                                                                           Object other$length = other.getLength();
                                                                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                              Object this$width = this.getWidth();
                                                                              Object other$width = other.getWidth();
                                                                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                 Object this$thickness = this.getThickness();
                                                                                 Object other$thickness = other.getThickness();
                                                                                 if (this$thickness == null
                                                                                    ? other$thickness == null
                                                                                    : this$thickness.equals(other$thickness)) {
                                                                                    Object this$brand = this.getBrand();
                                                                                    Object other$brand = other.getBrand();
                                                                                    if (this$brand == null
                                                                                       ? other$brand == null
                                                                                       : this$brand.equals(other$brand)) {
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
                                                                                             Object this$inboundQuantity = this.getInboundQuantity();
                                                                                             Object other$inboundQuantity = other.getInboundQuantity();
                                                                                             if (this$inboundQuantity == null
                                                                                                ? other$inboundQuantity == null
                                                                                                : this$inboundQuantity.equals(other$inboundQuantity)) {
                                                                                                Object this$inboundMete = this.getInboundMete();
                                                                                                Object other$inboundMete = other.getInboundMete();
                                                                                                if (this$inboundMete == null
                                                                                                   ? other$inboundMete == null
                                                                                                   : this$inboundMete.equals(other$inboundMete)) {
                                                                                                   Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                   Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                   if (this$amountExcludingVat == null
                                                                                                      ? other$amountExcludingVat == null
                                                                                                      : this$amountExcludingVat.equals(other$amountExcludingVat)
                                                                                                      )
                                                                                                    {
                                                                                                      Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                      Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                      if (this$unitPriceExcludingVat == null
                                                                                                         ? other$unitPriceExcludingVat == null
                                                                                                         : this$unitPriceExcludingVat.equals(
                                                                                                            other$unitPriceExcludingVat
                                                                                                         )) {
                                                                                                         Object this$inputVat = this.getInputVat();
                                                                                                         Object other$inputVat = other.getInputVat();
                                                                                                         if (this$inputVat == null
                                                                                                            ? other$inputVat == null
                                                                                                            : this$inputVat.equals(other$inputVat)) {
                                                                                                            Object this$unitPrice = this.getUnitPrice();
                                                                                                            Object other$unitPrice = other.getUnitPrice();
                                                                                                            if (this$unitPrice == null
                                                                                                               ? other$unitPrice == null
                                                                                                               : this$unitPrice.equals(other$unitPrice)) {
                                                                                                               Object this$amount = this.getAmount();
                                                                                                               Object other$amount = other.getAmount();
                                                                                                               if (this$amount == null
                                                                                                                  ? other$amount == null
                                                                                                                  : this$amount.equals(other$amount)) {
                                                                                                                  Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                                  Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                                  if (this$sectionSteelSpec == null
                                                                                                                     ? other$sectionSteelSpec == null
                                                                                                                     : this$sectionSteelSpec.equals(
                                                                                                                        other$sectionSteelSpec
                                                                                                                     )) {
                                                                                                                     Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                                                     Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                                                     if (this$doNotSectionSteelSpec == null
                                                                                                                        ? other$doNotSectionSteelSpec == null
                                                                                                                        : this$doNotSectionSteelSpec.equals(
                                                                                                                           other$doNotSectionSteelSpec
                                                                                                                        )) {
                                                                                                                        Object this$materialSn = this.getMaterialSn();
                                                                                                                        Object other$materialSn = other.getMaterialSn();
                                                                                                                        if (this$materialSn == null
                                                                                                                           ? other$materialSn == null
                                                                                                                           : this$materialSn.equals(
                                                                                                                              other$materialSn
                                                                                                                           )) {
                                                                                                                           Object this$specificationIds = this.getSpecificationIds();
                                                                                                                           Object other$specificationIds = other.getSpecificationIds();
                                                                                                                           if (this$specificationIds == null
                                                                                                                              ? other$specificationIds == null
                                                                                                                              : this$specificationIds.equals(
                                                                                                                                 other$specificationIds
                                                                                                                              )) {
                                                                                                                              Object this$finishedGoodsTypeName = this.getFinishedGoodsTypeName();
                                                                                                                              Object other$finishedGoodsTypeName = other.getFinishedGoodsTypeName();
                                                                                                                              if (this$finishedGoodsTypeName
                                                                                                                                    == null
                                                                                                                                 ? other$finishedGoodsTypeName
                                                                                                                                    == null
                                                                                                                                 : this$finishedGoodsTypeName.equals(
                                                                                                                                    other$finishedGoodsTypeName
                                                                                                                                 )) {
                                                                                                                                 Object this$manufacturedSpecification = this.getManufacturedSpecification();
                                                                                                                                 Object other$manufacturedSpecification = other.getManufacturedSpecification();
                                                                                                                                 if (this$manufacturedSpecification
                                                                                                                                       == null
                                                                                                                                    ? other$manufacturedSpecification
                                                                                                                                       == null
                                                                                                                                    : this$manufacturedSpecification.equals(
                                                                                                                                       other$manufacturedSpecification
                                                                                                                                    )) {
                                                                                                                                    Object this$weight = this.getWeight();
                                                                                                                                    Object other$weight = other.getWeight();
                                                                                                                                    if (this$weight == null
                                                                                                                                       ? other$weight == null
                                                                                                                                       : this$weight.equals(
                                                                                                                                          other$weight
                                                                                                                                       )) {
                                                                                                                                       Object this$totalWeight = this.getTotalWeight();
                                                                                                                                       Object other$totalWeight = other.getTotalWeight();
                                                                                                                                       if (this$totalWeight
                                                                                                                                             == null
                                                                                                                                          ? other$totalWeight
                                                                                                                                             == null
                                                                                                                                          : this$totalWeight.equals(
                                                                                                                                             other$totalWeight
                                                                                                                                          )) {
                                                                                                                                          Object this$totalLength = this.getTotalLength();
                                                                                                                                          Object other$totalLength = other.getTotalLength();
                                                                                                                                          if (this$totalLength
                                                                                                                                                == null
                                                                                                                                             ? other$totalLength
                                                                                                                                                == null
                                                                                                                                             : this$totalLength.equals(
                                                                                                                                                other$totalLength
                                                                                                                                             )) {
                                                                                                                                             Object this$surfaceArea = this.getSurfaceArea();
                                                                                                                                             Object other$surfaceArea = other.getSurfaceArea();
                                                                                                                                             if (this$surfaceArea
                                                                                                                                                   == null
                                                                                                                                                ? other$surfaceArea
                                                                                                                                                   == null
                                                                                                                                                : this$surfaceArea.equals(
                                                                                                                                                   other$surfaceArea
                                                                                                                                                )) {
                                                                                                                                                Object this$totalArea = this.getTotalArea();
                                                                                                                                                Object other$totalArea = other.getTotalArea();
                                                                                                                                                if (this$totalArea
                                                                                                                                                      == null
                                                                                                                                                   ? other$totalArea
                                                                                                                                                      == null
                                                                                                                                                   : this$totalArea.equals(
                                                                                                                                                      other$totalArea
                                                                                                                                                   )) {
                                                                                                                                                   Object this$manufacturedName = this.getManufacturedName();
                                                                                                                                                   Object other$manufacturedName = other.getManufacturedName();
                                                                                                                                                   if (this$manufacturedName
                                                                                                                                                         == null
                                                                                                                                                      ? other$manufacturedName
                                                                                                                                                         == null
                                                                                                                                                      : this$manufacturedName.equals(
                                                                                                                                                         other$manufacturedName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$manufacturedSn = this.getManufacturedSn();
                                                                                                                                                      Object other$manufacturedSn = other.getManufacturedSn();
                                                                                                                                                      if (this$manufacturedSn
                                                                                                                                                            == null
                                                                                                                                                         ? other$manufacturedSn
                                                                                                                                                            == null
                                                                                                                                                         : this$manufacturedSn.equals(
                                                                                                                                                            other$manufacturedSn
                                                                                                                                                         )) {
                                                                                                                                                         Object this$manufacturedUnit = this.getManufacturedUnit();
                                                                                                                                                         Object other$manufacturedUnit = other.getManufacturedUnit();
                                                                                                                                                         if (this$manufacturedUnit
                                                                                                                                                               == null
                                                                                                                                                            ? other$manufacturedUnit
                                                                                                                                                               == null
                                                                                                                                                            : this$manufacturedUnit.equals(
                                                                                                                                                               other$manufacturedUnit
                                                                                                                                                            )) {
                                                                                                                                                            Object this$material = this.getMaterial();
                                                                                                                                                            Object other$material = other.getMaterial();
                                                                                                                                                            if (this$material
                                                                                                                                                                  == null
                                                                                                                                                               ? other$material
                                                                                                                                                                  == null
                                                                                                                                                               : this$material.equals(
                                                                                                                                                                  other$material
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$receivedQuantity = this.getReceivedQuantity();
                                                                                                                                                               Object other$receivedQuantity = other.getReceivedQuantity();
                                                                                                                                                               if (this$receivedQuantity
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$receivedQuantity
                                                                                                                                                                     == null
                                                                                                                                                                  : this$receivedQuantity.equals(
                                                                                                                                                                     other$receivedQuantity
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$receivedMete = this.getReceivedMete();
                                                                                                                                                                  Object other$receivedMete = other.getReceivedMete();
                                                                                                                                                                  if (this$receivedMete
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$receivedMete
                                                                                                                                                                        == null
                                                                                                                                                                     : this$receivedMete.equals(
                                                                                                                                                                        other$receivedMete
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                                                                                                                     Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                                                                                                                     if (this$actualReceivedMete
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$actualReceivedMete
                                                                                                                                                                           == null
                                                                                                                                                                        : this$actualReceivedMete.equals(
                                                                                                                                                                           other$actualReceivedMete
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
                                                                                                                                                                           Object this$uniqueIdentification = this.getUniqueIdentification();
                                                                                                                                                                           Object other$uniqueIdentification = other.getUniqueIdentification();
                                                                                                                                                                           return this$uniqueIdentification
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$uniqueIdentification
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$uniqueIdentification.equals(
                                                                                                                                                                                 other$uniqueIdentification
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseOrderDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $applyPurchaseDetailId = this.getApplyPurchaseDetailId();
      result = result * 59 + ($applyPurchaseDetailId == null ? 43 : $applyPurchaseDetailId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $sectionSteelSpecId = this.getSectionSteelSpecId();
      result = result * 59 + ($sectionSteelSpecId == null ? 43 : $sectionSteelSpecId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolOriginalDetail = this.getBoolOriginalDetail();
      result = result * 59 + ($boolOriginalDetail == null ? 43 : $boolOriginalDetail.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $manufacturedType = this.getManufacturedType();
      result = result * 59 + ($manufacturedType == null ? 43 : $manufacturedType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $applyPurchaseSN = this.getApplyPurchaseSN();
      result = result * 59 + ($applyPurchaseSN == null ? 43 : $applyPurchaseSN.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
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
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $specificationIds = this.getSpecificationIds();
      result = result * 59 + ($specificationIds == null ? 43 : $specificationIds.hashCode());
      Object $finishedGoodsTypeName = this.getFinishedGoodsTypeName();
      result = result * 59 + ($finishedGoodsTypeName == null ? 43 : $finishedGoodsTypeName.hashCode());
      Object $manufacturedSpecification = this.getManufacturedSpecification();
      result = result * 59 + ($manufacturedSpecification == null ? 43 : $manufacturedSpecification.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $manufacturedUnit = this.getManufacturedUnit();
      result = result * 59 + ($manufacturedUnit == null ? 43 : $manufacturedUnit.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $receivedQuantity = this.getReceivedQuantity();
      result = result * 59 + ($receivedQuantity == null ? 43 : $receivedQuantity.hashCode());
      Object $receivedMete = this.getReceivedMete();
      result = result * 59 + ($receivedMete == null ? 43 : $receivedMete.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $steelDensity = this.getSteelDensity();
      result = result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
      Object $uniqueIdentification = this.getUniqueIdentification();
      return result * 59 + ($uniqueIdentification == null ? 43 : $uniqueIdentification.hashCode());
   }

   public static class PurchaseOrderDetailBuilder {
      private Long id;
      private Long purchaseId;
      private Long applyPurchaseId;
      private Long applyPurchaseDetailId;
      private String applyPurchaseSN;
      private Long artifactEnclosureId;
      private Long classifyId;
      private String classifyName;
      private Integer basicClass;
      private String specification;
      private String model;
      private String color;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal inboundQuantity;
      private BigDecimal inboundMete;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private Integer weightMeasurementMode;
      private Long projectId;
      private Long factoryId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private String materialSn;
      private Long sectionSteelSpecId;
      private String specificationIds;
      private Long standardId;
      private Boolean boolOriginalDetail;
      private Long workshopId;
      private String finishedGoodsTypeName;
      private String manufacturedSpecification;
      private Long monomerId;
      private Long areaId;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private String manufacturedName;
      private Integer manufacturedType;
      private String manufacturedSn;
      private String manufacturedUnit;
      private String material;
      private Integer wageQuotaType;
      private BigDecimal receivedQuantity;
      private BigDecimal receivedMete;
      private BigDecimal actualReceivedMete;
      private BigDecimal steelDensity;
      private String uniqueIdentification;

      PurchaseOrderDetailBuilder() {
      }

      @JsonProperty("id")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("purchaseId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("applyPurchaseId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      @JsonProperty("applyPurchaseDetailId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder applyPurchaseDetailId(final Long applyPurchaseDetailId) {
         this.applyPurchaseDetailId = applyPurchaseDetailId;
         return this;
      }

      @JsonProperty("applyPurchaseSN")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder applyPurchaseSN(final String applyPurchaseSN) {
         this.applyPurchaseSN = applyPurchaseSN;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("classifyId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("basicClass")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("model")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("color")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("length")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("quantity")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("inboundMete")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amount")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("projectId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("factoryId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("sectionSteelSpec")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      @JsonProperty("doNotSectionSteelSpec")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      @JsonProperty("materialSn")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("sectionSteelSpecId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder sectionSteelSpecId(final Long sectionSteelSpecId) {
         this.sectionSteelSpecId = sectionSteelSpecId;
         return this;
      }

      @JsonProperty("specificationIds")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder specificationIds(final String specificationIds) {
         this.specificationIds = specificationIds;
         return this;
      }

      @JsonProperty("standardId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("boolOriginalDetail")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder boolOriginalDetail(final Boolean boolOriginalDetail) {
         this.boolOriginalDetail = boolOriginalDetail;
         return this;
      }

      @JsonProperty("workshopId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("finishedGoodsTypeName")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder finishedGoodsTypeName(final String finishedGoodsTypeName) {
         this.finishedGoodsTypeName = finishedGoodsTypeName;
         return this;
      }

      @JsonProperty("manufacturedSpecification")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder manufacturedSpecification(final String manufacturedSpecification) {
         this.manufacturedSpecification = manufacturedSpecification;
         return this;
      }

      @JsonProperty("monomerId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("weight")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("totalWeight")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("surfaceArea")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("totalArea")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("manufacturedName")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      @JsonProperty("manufacturedType")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder manufacturedType(final Integer manufacturedType) {
         this.manufacturedType = manufacturedType;
         return this;
      }

      @JsonProperty("manufacturedSn")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      @JsonProperty("manufacturedUnit")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      @JsonProperty("material")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("receivedQuantity")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder receivedQuantity(final BigDecimal receivedQuantity) {
         this.receivedQuantity = receivedQuantity;
         return this;
      }

      @JsonProperty("receivedMete")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder receivedMete(final BigDecimal receivedMete) {
         this.receivedMete = receivedMete;
         return this;
      }

      @JsonProperty("actualReceivedMete")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      @JsonProperty("steelDensity")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      @JsonProperty("uniqueIdentification")
      public PurchaseOrderDetail.PurchaseOrderDetailBuilder uniqueIdentification(final String uniqueIdentification) {
         this.uniqueIdentification = uniqueIdentification;
         return this;
      }

      public PurchaseOrderDetail build() {
         return new PurchaseOrderDetail(
            this.id,
            this.purchaseId,
            this.applyPurchaseId,
            this.applyPurchaseDetailId,
            this.applyPurchaseSN,
            this.artifactEnclosureId,
            this.classifyId,
            this.classifyName,
            this.basicClass,
            this.specification,
            this.model,
            this.color,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.quantity,
            this.mete,
            this.inboundQuantity,
            this.inboundMete,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.amount,
            this.weightMeasurementMode,
            this.projectId,
            this.factoryId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.materialSn,
            this.sectionSteelSpecId,
            this.specificationIds,
            this.standardId,
            this.boolOriginalDetail,
            this.workshopId,
            this.finishedGoodsTypeName,
            this.manufacturedSpecification,
            this.monomerId,
            this.areaId,
            this.weight,
            this.totalWeight,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.manufacturedName,
            this.manufacturedType,
            this.manufacturedSn,
            this.manufacturedUnit,
            this.material,
            this.wageQuotaType,
            this.receivedQuantity,
            this.receivedMete,
            this.actualReceivedMete,
            this.steelDensity,
            this.uniqueIdentification
         );
      }

      @Override
      public String toString() {
         return "PurchaseOrderDetail.PurchaseOrderDetailBuilder(id="
            + this.id
            + ", purchaseId="
            + this.purchaseId
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", applyPurchaseDetailId="
            + this.applyPurchaseDetailId
            + ", applyPurchaseSN="
            + this.applyPurchaseSN
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", color="
            + this.color
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", inboundMete="
            + this.inboundMete
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
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", materialSn="
            + this.materialSn
            + ", sectionSteelSpecId="
            + this.sectionSteelSpecId
            + ", specificationIds="
            + this.specificationIds
            + ", standardId="
            + this.standardId
            + ", boolOriginalDetail="
            + this.boolOriginalDetail
            + ", workshopId="
            + this.workshopId
            + ", finishedGoodsTypeName="
            + this.finishedGoodsTypeName
            + ", manufacturedSpecification="
            + this.manufacturedSpecification
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedType="
            + this.manufacturedType
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", manufacturedUnit="
            + this.manufacturedUnit
            + ", material="
            + this.material
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", receivedQuantity="
            + this.receivedQuantity
            + ", receivedMete="
            + this.receivedMete
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", steelDensity="
            + this.steelDensity
            + ", uniqueIdentification="
            + this.uniqueIdentification
            + ")";
      }
   }
}
