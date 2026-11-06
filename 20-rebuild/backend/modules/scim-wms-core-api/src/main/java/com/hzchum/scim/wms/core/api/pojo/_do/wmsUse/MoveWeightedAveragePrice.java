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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MoveWeightedAveragePrice对象", description = "移动加权平均价 ")
@Entity
@TableName("wms_move_weighted_average_price")
@Table(name = "wms_move_weighted_average_price")
public class MoveWeightedAveragePrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "basicClass", value = "基础物料分类", notes = "基础物料分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料分类'", nullable = true)
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
   @ApiModelProperty(name = "specification", value = "科目不计入加权价的规格[不计入加权价的规格不同,则不合并]", notes = "科目不计入加权价的规格[不计入加权价的规格不同,则不合并]")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '科目不计入加权价的规格[不计入加权价的规格不同,则不合并]'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
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
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "mete", value = "当前库存核算量", notes = "当前库存核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '当前库存核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(128)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
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
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
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
   @ApiModelProperty(name = "outboundUnitType", value = "出库单位类型", notes = "出库单位类型")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库单位类型'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "amount", value = "总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]", notes = "总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价[ 同上]", notes = "不含税总价[ 同上]")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税总价[ 同上]'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amountNoFreight", value = "总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]", notes = "总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价[ 当前入库的总价,只做总价的加减,不进行加权后价格的加减 ]'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价[ 同上] 不含运费", notes = "不含税总价[ 同上] 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价[ 同上] 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价 不含运费", notes = "单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;

   public static MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder builder() {
      return new MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder();
   }

   public MoveWeightedAveragePrice() {
   }

   public MoveWeightedAveragePrice(
      final Long id,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final Integer basicClass,
      final Long classifyId,
      final Long projectId,
      final String specification,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String color,
      final String brand,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal unitNet,
      final Boolean boolPartyA,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal quantity,
      final Long standardId,
      final String standardName,
      final Integer outboundUnitType,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight
   ) {
      this.id = id;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.projectId = projectId;
      this.specification = specification;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.brand = brand;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.boolPartyA = boolPartyA;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.quantity = quantity;
      this.standardId = standardId;
      this.standardName = standardName;
      this.outboundUnitType = outboundUnitType;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
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

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   @JsonProperty("id")
   public MoveWeightedAveragePrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("unitPrice")
   public MoveWeightedAveragePrice setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public MoveWeightedAveragePrice setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("basicClass")
   public MoveWeightedAveragePrice setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MoveWeightedAveragePrice setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("projectId")
   public MoveWeightedAveragePrice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("specification")
   public MoveWeightedAveragePrice setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("thickness")
   public MoveWeightedAveragePrice setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MoveWeightedAveragePrice setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public MoveWeightedAveragePrice setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("brand")
   public MoveWeightedAveragePrice setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("mete")
   public MoveWeightedAveragePrice setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("accountingUnit")
   public MoveWeightedAveragePrice setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("unitNet")
   public MoveWeightedAveragePrice setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MoveWeightedAveragePrice setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("invoiceType")
   public MoveWeightedAveragePrice setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public MoveWeightedAveragePrice setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("quantity")
   public MoveWeightedAveragePrice setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("standardId")
   public MoveWeightedAveragePrice setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MoveWeightedAveragePrice setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public MoveWeightedAveragePrice setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("amount")
   public MoveWeightedAveragePrice setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public MoveWeightedAveragePrice setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public MoveWeightedAveragePrice setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public MoveWeightedAveragePrice setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public MoveWeightedAveragePrice setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public MoveWeightedAveragePrice setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @Override
   public String toString() {
      return "MoveWeightedAveragePrice(id="
         + this.getId()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", projectId="
         + this.getProjectId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", quantity="
         + this.getQuantity()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveWeightedAveragePrice)) {
         return false;
      }

      MoveWeightedAveragePrice other = (MoveWeightedAveragePrice)o;
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
                           Object this$outboundUnitType = this.getOutboundUnitType();
                           Object other$outboundUnitType = other.getOutboundUnitType();
                           if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                              Object this$unitPrice = this.getUnitPrice();
                              Object other$unitPrice = other.getUnitPrice();
                              if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                 Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                 Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                 if (this$unitPriceExcludingVat == null
                                    ? other$unitPriceExcludingVat == null
                                    : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                          Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                          if (this$heatNoAndBatchNo == null
                                             ? other$heatNoAndBatchNo == null
                                             : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                             Object this$color = this.getColor();
                                             Object other$color = other.getColor();
                                             if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                      if (this$accountingUnit == null
                                                         ? other$accountingUnit == null
                                                         : this$accountingUnit.equals(other$accountingUnit)) {
                                                         Object this$unitNet = this.getUnitNet();
                                                         Object other$unitNet = other.getUnitNet();
                                                         if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                            Object this$taxRate = this.getTaxRate();
                                                            Object other$taxRate = other.getTaxRate();
                                                            if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                               Object this$quantity = this.getQuantity();
                                                               Object other$quantity = other.getQuantity();
                                                               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                  Object this$standardName = this.getStandardName();
                                                                  Object other$standardName = other.getStandardName();
                                                                  if (this$standardName == null
                                                                     ? other$standardName == null
                                                                     : this$standardName.equals(other$standardName)) {
                                                                     Object this$amount = this.getAmount();
                                                                     Object other$amount = other.getAmount();
                                                                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                        Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                        Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                        if (this$amountExcludingVat == null
                                                                           ? other$amountExcludingVat == null
                                                                           : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                           Object this$amountNoFreight = this.getAmountNoFreight();
                                                                           Object other$amountNoFreight = other.getAmountNoFreight();
                                                                           if (this$amountNoFreight == null
                                                                              ? other$amountNoFreight == null
                                                                              : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                              Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                              Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                              if (this$amountExcludingVatNoFreight == null
                                                                                 ? other$amountExcludingVatNoFreight == null
                                                                                 : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                                                                                 Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                 Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                 if (this$unitPriceNoFreight == null
                                                                                    ? other$unitPriceNoFreight == null
                                                                                    : this$unitPriceNoFreight.equals(other$unitPriceNoFreight)) {
                                                                                    Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                                                    Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                                                    return this$unitPriceExcludingVatNoFreight == null
                                                                                       ? other$unitPriceExcludingVatNoFreight == null
                                                                                       : this$unitPriceExcludingVatNoFreight.equals(
                                                                                          other$unitPriceExcludingVatNoFreight
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MoveWeightedAveragePrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      return result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
   }

   public static class MoveWeightedAveragePriceBuilder {
      private Long id;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private Integer basicClass;
      private Long classifyId;
      private Long projectId;
      private String specification;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String color;
      private String brand;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal unitNet;
      private Boolean boolPartyA;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal quantity;
      private Long standardId;
      private String standardName;
      private Integer outboundUnitType;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;

      MoveWeightedAveragePriceBuilder() {
      }

      @JsonProperty("id")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("unitPrice")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("basicClass")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("projectId")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("specification")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("thickness")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("brand")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("mete")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("accountingUnit")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("invoiceType")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("quantity")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("standardId")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("amount")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      public MoveWeightedAveragePrice build() {
         return new MoveWeightedAveragePrice(
            this.id,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.basicClass,
            this.classifyId,
            this.projectId,
            this.specification,
            this.thickness,
            this.heatNoAndBatchNo,
            this.color,
            this.brand,
            this.mete,
            this.accountingUnit,
            this.unitNet,
            this.boolPartyA,
            this.invoiceType,
            this.taxRate,
            this.quantity,
            this.standardId,
            this.standardName,
            this.outboundUnitType,
            this.amount,
            this.amountExcludingVat,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight
         );
      }

      @Override
      public String toString() {
         return "MoveWeightedAveragePrice.MoveWeightedAveragePriceBuilder(id="
            + this.id
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", projectId="
            + this.projectId
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitNet="
            + this.unitNet
            + ", boolPartyA="
            + this.boolPartyA
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", quantity="
            + this.quantity
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ")";
      }
   }
}
