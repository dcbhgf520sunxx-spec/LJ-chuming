package com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse;

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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsSurplusDetail对象", description = "")
@Entity
@TableName("wms_surplus_detail")
@Table(name = "wms_surplus_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_surplus_detail")
public class WmsSurplusDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String specification;
   @ApiModelProperty(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "bit(1)  COMMENT ''", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String color;
   @ApiModelProperty(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String remark;
   @ApiModelProperty(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String weightedAverageSpec;
   @ApiModelProperty(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String barcode;
   @ApiModelProperty(name = "surplusId")
   @TableField("surplus_id")
   @Column(name = "surplus_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long surplusId;
   @ApiModelProperty(name = "surplusSerialNumber")
   @TableField("surplus_serial_number")
   @Column(name = "surplus_serial_number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusSerialNumber;
   @ApiModelProperty(name = "amount", value = "含税总价", notes = "含税总价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价 不含运费", notes = "单价 不含运费")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = " 不含税总价 不含运费", notes = " 不含税总价 不含运费")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT ' 不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "supplierId", value = "供应商id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint  COMMENT '供应商id'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "inboundTime", value = "入库时间", notes = "入库时间")
   @JsonProperty("inboundTime")
   @JSONField(name = "inboundTime")
   @TableField("inbound_time")
   @Column(name = "inbound_time", columnDefinition = "datetime  COMMENT '入库时间'", nullable = true)
   private LocalDateTime inboundTime;
   @ApiModelProperty(name = "theoryWeight", value = "理论重量", notes = "理论重量")
   @JsonProperty("theoryWeight")
   @JSONField(name = "theoryWeight")
   @TableField("theory_weight")
   @Column(name = "theory_weight", columnDefinition = "decimal(32,8)  COMMENT '理论重量'", nullable = true)
   private BigDecimal theoryWeight;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度", notes = "计量精度")
   @JsonProperty("measurePrecision")
   @JSONField(name = "measurePrecision")
   @TableField("measure_precision")
   @Column(name = "measure_precision", columnDefinition = "int  COMMENT '计量精度'", nullable = true)
   private Integer measurePrecision;
   @ApiModelProperty(name = "printStatus", value = "打印状态 [0 没有打印,1 已打印]", notes = "打印状态 [0 没有打印,1 已打印]")
   @JsonProperty("printStatus")
   @JSONField(name = "printStatus")
   @TableField("print_status")
   @Column(name = "print_status", columnDefinition = "tinyint(1) default '0' COMMENT '打印状态 [0 没有打印,1 已打印]'", nullable = true)
   private Boolean printStatus;
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
   @ApiModelProperty(name = "classifyFullName", value = "分类全称 ")
   @JsonProperty("classifyFullName")
   @JSONField(name = "classifyFullName")
   @TableField("classify_full_name")
   @Column(name = "classify_full_name")
   private String classifyFullName;
   @ApiModelProperty(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long reviewerId;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         WmsSurplusDetail that = (WmsSurplusDetail)o;
         return Objects.equals(this.getClassifyId(), that.getClassifyId())
            && Objects.equals(this.getSpecification(), that.getSpecification())
            && Objects.equals(this.getMaterialIsWhole(), that.getMaterialIsWhole())
            && Objects.equals(this.getProjectId(), that.getProjectId())
            && Objects.equals(this.getBoolPartyA(), that.getBoolPartyA())
            && Objects.equals(
               this.getLength() != null ? this.getLength().stripTrailingZeros() : null, that.getLength() != null ? that.getLength().stripTrailingZeros() : null
            )
            && Objects.equals(
               this.getWidth() != null ? this.getWidth().stripTrailingZeros() : null, that.getWidth() != null ? that.getWidth().stripTrailingZeros() : null
            )
            && Objects.equals(
               this.getThickness() != null ? this.getThickness().stripTrailingZeros() : null,
               that.getThickness() != null ? that.getThickness().stripTrailingZeros() : null
            )
            && Objects.equals(this.getBrand(), that.getBrand())
            && Objects.equals(this.getHeatNoAndBatchNo(), that.getHeatNoAndBatchNo())
            && Objects.equals(this.getColor(), that.getColor())
            && Objects.equals(
               this.getUnitNet() != null ? this.getUnitNet().stripTrailingZeros() : null,
               that.getUnitNet() != null ? that.getUnitNet().stripTrailingZeros() : null
            )
            && Objects.equals(this.getFactoryId(), that.getFactoryId())
            && Objects.equals(
               this.getTaxRate() != null ? this.getTaxRate().stripTrailingZeros() : null,
               that.getTaxRate() != null ? that.getTaxRate().stripTrailingZeros() : null
            )
            && Objects.equals(this.getInvoiceType(), that.getInvoiceType())
            && Objects.equals(this.getBarcode(), that.getBarcode())
            && Objects.equals(
               this.getUnitPrice() != null ? this.getUnitPrice().stripTrailingZeros() : null,
               that.getUnitPrice() != null ? that.getUnitPrice().stripTrailingZeros() : null
            )
            && Objects.equals(this.getApplicantName(), that.getApplicantName())
            && Objects.equals(this.getReviewStatus(), that.getReviewStatus())
            && Objects.equals(this.getWorkshopId(), that.getWorkshopId())
            && Objects.equals(this.getSupplierId(), that.getSupplierId())
            && Objects.equals(this.getSerialNumber(), that.getSerialNumber());
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(
         super.hashCode(),
         this.getClassifyId(),
         this.getSpecification(),
         this.getMaterialIsWhole(),
         this.getProjectId(),
         this.getBoolPartyA(),
         this.getLength(),
         this.getWidth(),
         this.getThickness(),
         this.getBrand(),
         this.getHeatNoAndBatchNo(),
         this.getColor(),
         this.getUnitNet(),
         this.getFactoryId(),
         this.getTaxRate(),
         this.getInvoiceType(),
         this.getBarcode(),
         this.getUnitPrice(),
         this.getInputVat(),
         this.getApplicantName(),
         this.getReviewStatus(),
         this.getWorkshopId(),
         this.getSupplierId(),
         this.getSerialNumber()
      );
   }

   public static WmsSurplusDetail.WmsSurplusDetailBuilder builder() {
      return new WmsSurplusDetail.WmsSurplusDetailBuilder();
   }

   public WmsSurplusDetail() {
   }

   public WmsSurplusDetail(
      final Long id,
      final String serialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final Integer materialIsWhole,
      final Long projectId,
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
      final Long warehouseId,
      final Long factoryId,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final String remark,
      final String weightedAverageSpec,
      final Long standardId,
      final String standardName,
      final BigDecimal sectionSteelWeight,
      final String barcode,
      final Long surplusId,
      final String surplusSerialNumber,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final String applicantName,
      final Integer reviewStatus,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final Long workshopId,
      final Long supplierId,
      final LocalDateTime inboundTime,
      final BigDecimal theoryWeight,
      final Integer measurePrecision,
      final Boolean printStatus,
      final String sectionSteelSpecIds,
      final String specificationIds,
      final Integer scale,
      final Long sectionSteelSpecId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final String classifyFullName,
      final String reviewerName,
      final Long reviewerId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
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
      this.warehouseId = warehouseId;
      this.factoryId = factoryId;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.remark = remark;
      this.weightedAverageSpec = weightedAverageSpec;
      this.standardId = standardId;
      this.standardName = standardName;
      this.sectionSteelWeight = sectionSteelWeight;
      this.barcode = barcode;
      this.surplusId = surplusId;
      this.surplusSerialNumber = surplusSerialNumber;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.workshopId = workshopId;
      this.supplierId = supplierId;
      this.inboundTime = inboundTime;
      this.theoryWeight = theoryWeight;
      this.measurePrecision = measurePrecision;
      this.printStatus = printStatus;
      this.sectionSteelSpecIds = sectionSteelSpecIds;
      this.specificationIds = specificationIds;
      this.scale = scale;
      this.sectionSteelSpecId = sectionSteelSpecId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.classifyFullName = classifyFullName;
      this.reviewerName = reviewerName;
      this.reviewerId = reviewerId;
   }

   public Long getId() {
      return this.id;
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

   public Long getProjectId() {
      return this.projectId;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getFactoryId() {
      return this.factoryId;
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

   public Long getSurplusId() {
      return this.surplusId;
   }

   public String getSurplusSerialNumber() {
      return this.surplusSerialNumber;
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

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public BigDecimal getTheoryWeight() {
      return this.theoryWeight;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Boolean getPrintStatus() {
      return this.printStatus;
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

   public Long getSectionSteelSpecId() {
      return this.sectionSteelSpecId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public WmsSurplusDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsSurplusDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsSurplusDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public WmsSurplusDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public WmsSurplusDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   public WmsSurplusDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public WmsSurplusDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   public WmsSurplusDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsSurplusDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public WmsSurplusDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public WmsSurplusDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   public WmsSurplusDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public WmsSurplusDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public WmsSurplusDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public WmsSurplusDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public WmsSurplusDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   public WmsSurplusDetail setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   public WmsSurplusDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public WmsSurplusDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   public WmsSurplusDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   public WmsSurplusDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public WmsSurplusDetail setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   public WmsSurplusDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public WmsSurplusDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   public WmsSurplusDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public WmsSurplusDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public WmsSurplusDetail setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public WmsSurplusDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public WmsSurplusDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public WmsSurplusDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public WmsSurplusDetail setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   public WmsSurplusDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   public WmsSurplusDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   public WmsSurplusDetail setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   public WmsSurplusDetail setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   public WmsSurplusDetail setSurplusId(final Long surplusId) {
      this.surplusId = surplusId;
      return this;
   }

   public WmsSurplusDetail setSurplusSerialNumber(final String surplusSerialNumber) {
      this.surplusSerialNumber = surplusSerialNumber;
      return this;
   }

   public WmsSurplusDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public WmsSurplusDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public WmsSurplusDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   public WmsSurplusDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   public WmsSurplusDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   public WmsSurplusDetail setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsSurplusDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsSurplusDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   public WmsSurplusDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   public WmsSurplusDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   public WmsSurplusDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   public WmsSurplusDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   public WmsSurplusDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public WmsSurplusDetail setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("inboundTime")
   public WmsSurplusDetail setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
      return this;
   }

   @JsonProperty("theoryWeight")
   public WmsSurplusDetail setTheoryWeight(final BigDecimal theoryWeight) {
      this.theoryWeight = theoryWeight;
      return this;
   }

   @JsonProperty("measurePrecision")
   public WmsSurplusDetail setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("printStatus")
   public WmsSurplusDetail setPrintStatus(final Boolean printStatus) {
      this.printStatus = printStatus;
      return this;
   }

   @JsonProperty("sectionSteelSpecIds")
   public WmsSurplusDetail setSectionSteelSpecIds(final String sectionSteelSpecIds) {
      this.sectionSteelSpecIds = sectionSteelSpecIds;
      return this;
   }

   @JsonProperty("specificationIds")
   public WmsSurplusDetail setSpecificationIds(final String specificationIds) {
      this.specificationIds = specificationIds;
      return this;
   }

   @JsonProperty("scale")
   public WmsSurplusDetail setScale(final Integer scale) {
      this.scale = scale;
      return this;
   }

   @JsonProperty("sectionSteelSpecId")
   public WmsSurplusDetail setSectionSteelSpecId(final Long sectionSteelSpecId) {
      this.sectionSteelSpecId = sectionSteelSpecId;
      return this;
   }

   @JsonProperty("sectionSteelSpec")
   public WmsSurplusDetail setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
      return this;
   }

   @JsonProperty("doNotSectionSteelSpec")
   public WmsSurplusDetail setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      return this;
   }

   @JsonProperty("classifyFullName")
   public WmsSurplusDetail setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
      return this;
   }

   public WmsSurplusDetail setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   public WmsSurplusDetail setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsSurplusDetail(id="
         + this.getId()
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
         + ", projectId="
         + this.getProjectId()
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
         + ", warehouseId="
         + this.getWarehouseId()
         + ", factoryId="
         + this.getFactoryId()
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
         + ", surplusId="
         + this.getSurplusId()
         + ", surplusSerialNumber="
         + this.getSurplusSerialNumber()
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
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
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
         + ", workshopId="
         + this.getWorkshopId()
         + ", supplierId="
         + this.getSupplierId()
         + ", inboundTime="
         + this.getInboundTime()
         + ", theoryWeight="
         + this.getTheoryWeight()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", printStatus="
         + this.getPrintStatus()
         + ", sectionSteelSpecIds="
         + this.getSectionSteelSpecIds()
         + ", specificationIds="
         + this.getSpecificationIds()
         + ", scale="
         + this.getScale()
         + ", sectionSteelSpecId="
         + this.getSectionSteelSpecId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewerId="
         + this.getReviewerId()
         + ")";
   }

   public static class WmsSurplusDetailBuilder {
      private Long id;
      private String serialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private Integer materialIsWhole;
      private Long projectId;
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
      private Long warehouseId;
      private Long factoryId;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private String remark;
      private String weightedAverageSpec;
      private Long standardId;
      private String standardName;
      private BigDecimal sectionSteelWeight;
      private String barcode;
      private Long surplusId;
      private String surplusSerialNumber;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private String applicantName;
      private Integer reviewStatus;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private Long workshopId;
      private Long supplierId;
      private LocalDateTime inboundTime;
      private BigDecimal theoryWeight;
      private Integer measurePrecision;
      private Boolean printStatus;
      private String sectionSteelSpecIds;
      private String specificationIds;
      private Integer scale;
      private Long sectionSteelSpecId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private String classifyFullName;
      private String reviewerName;
      private Long reviewerId;

      WmsSurplusDetailBuilder() {
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder surplusId(final Long surplusId) {
         this.surplusId = surplusId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder surplusSerialNumber(final String surplusSerialNumber) {
         this.surplusSerialNumber = surplusSerialNumber;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("inboundTime")
      public WmsSurplusDetail.WmsSurplusDetailBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      @JsonProperty("theoryWeight")
      public WmsSurplusDetail.WmsSurplusDetailBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      @JsonProperty("measurePrecision")
      public WmsSurplusDetail.WmsSurplusDetailBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("printStatus")
      public WmsSurplusDetail.WmsSurplusDetailBuilder printStatus(final Boolean printStatus) {
         this.printStatus = printStatus;
         return this;
      }

      @JsonProperty("sectionSteelSpecIds")
      public WmsSurplusDetail.WmsSurplusDetailBuilder sectionSteelSpecIds(final String sectionSteelSpecIds) {
         this.sectionSteelSpecIds = sectionSteelSpecIds;
         return this;
      }

      @JsonProperty("specificationIds")
      public WmsSurplusDetail.WmsSurplusDetailBuilder specificationIds(final String specificationIds) {
         this.specificationIds = specificationIds;
         return this;
      }

      @JsonProperty("scale")
      public WmsSurplusDetail.WmsSurplusDetailBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      @JsonProperty("sectionSteelSpecId")
      public WmsSurplusDetail.WmsSurplusDetailBuilder sectionSteelSpecId(final Long sectionSteelSpecId) {
         this.sectionSteelSpecId = sectionSteelSpecId;
         return this;
      }

      @JsonProperty("sectionSteelSpec")
      public WmsSurplusDetail.WmsSurplusDetailBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      @JsonProperty("doNotSectionSteelSpec")
      public WmsSurplusDetail.WmsSurplusDetailBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      @JsonProperty("classifyFullName")
      public WmsSurplusDetail.WmsSurplusDetailBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public WmsSurplusDetail.WmsSurplusDetailBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public WmsSurplusDetail build() {
         return new WmsSurplusDetail(
            this.id,
            this.serialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.materialIsWhole,
            this.projectId,
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
            this.warehouseId,
            this.factoryId,
            this.taxRate,
            this.invoiceType,
            this.remark,
            this.weightedAverageSpec,
            this.standardId,
            this.standardName,
            this.sectionSteelWeight,
            this.barcode,
            this.surplusId,
            this.surplusSerialNumber,
            this.amount,
            this.unitPrice,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.applicantName,
            this.reviewStatus,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.workshopId,
            this.supplierId,
            this.inboundTime,
            this.theoryWeight,
            this.measurePrecision,
            this.printStatus,
            this.sectionSteelSpecIds,
            this.specificationIds,
            this.scale,
            this.sectionSteelSpecId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.classifyFullName,
            this.reviewerName,
            this.reviewerId
         );
      }

      @Override
      public String toString() {
         return "WmsSurplusDetail.WmsSurplusDetailBuilder(id="
            + this.id
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
            + ", projectId="
            + this.projectId
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
            + ", warehouseId="
            + this.warehouseId
            + ", factoryId="
            + this.factoryId
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
            + ", surplusId="
            + this.surplusId
            + ", surplusSerialNumber="
            + this.surplusSerialNumber
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
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
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
            + ", workshopId="
            + this.workshopId
            + ", supplierId="
            + this.supplierId
            + ", inboundTime="
            + this.inboundTime
            + ", theoryWeight="
            + this.theoryWeight
            + ", measurePrecision="
            + this.measurePrecision
            + ", printStatus="
            + this.printStatus
            + ", sectionSteelSpecIds="
            + this.sectionSteelSpecIds
            + ", specificationIds="
            + this.specificationIds
            + ", scale="
            + this.scale
            + ", sectionSteelSpecId="
            + this.sectionSteelSpecId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", classifyFullName="
            + this.classifyFullName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewerId="
            + this.reviewerId
            + ")";
      }
   }
}
