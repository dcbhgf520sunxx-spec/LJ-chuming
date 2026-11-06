package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

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

@ApiModel(value = "InventoryDetailsRecord对象", description = "存货明细记录")
@Entity
@TableName("wms_inventory_details_record")
@Table(name = "wms_inventory_details_record")
public class InventoryDetailsRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "statisticsId", value = "收发存ID", notes = "收发存ID")
   @JsonProperty("statisticsId")
   @JSONField(name = "statisticsId")
   @TableField("statistics_id")
   @Column(name = "statistics_id", columnDefinition = "bigint  COMMENT '收发存ID'", nullable = true)
   private Long statisticsId;
   @ApiModelProperty(name = "receiptId", value = "单据ID", notes = "单据ID")
   @JsonProperty("receiptId")
   @JSONField(name = "receiptId")
   @TableField("receipt_id")
   @Column(name = "receipt_id", columnDefinition = "bigint  COMMENT '单据ID'", nullable = true)
   private Long receiptId;
   @ApiModelProperty(name = "receiptSerialNumber", value = "单据编号", notes = "单据编号")
   @JsonProperty("receiptSerialNumber")
   @JSONField(name = "receiptSerialNumber")
   @TableField("receipt_serial_number")
   @Column(name = "receipt_serial_number", columnDefinition = "varchar(255)  COMMENT '单据编号'", nullable = true)
   private String receiptSerialNumber;
   @ApiModelProperty(name = "receiptType", value = "单据类型 [ ReceiptTypeEnum ]", notes = "单据类型 [ ReceiptTypeEnum ]")
   @JsonProperty("receiptType")
   @JSONField(name = "receiptType")
   @TableField("receipt_type")
   @Column(name = "receipt_type", columnDefinition = "int  COMMENT '单据类型 [ ReceiptTypeEnum ]'", nullable = true)
   private Integer receiptType;
   @ApiModelProperty(name = "summary", value = "摘要[入库记录供应商,出库记录出库项目编号]", notes = "摘要[入库记录供应商,出库记录出库项目编号]")
   @JsonProperty("summary")
   @JSONField(name = "summary")
   @TableField("summary")
   @Column(name = "summary", columnDefinition = "varchar(255)  COMMENT '摘要[入库记录供应商,出库记录出库项目编号]'", nullable = true)
   private String summary;
   @ApiModelProperty(name = "detailKey", value = "详情键(物料规格JSON)", notes = "详情键(物料规格JSON)")
   @JsonProperty("detailKey")
   @JSONField(name = "detailKey")
   @TableField("detail_key")
   @Column(name = "detail_key", columnDefinition = "text  COMMENT '详情键(物料规格JSON)'", nullable = true)
   private String detailKey;
   @ApiModelProperty(name = "inboundMete", value = "入库总核算", notes = "入库总核算")
   @JsonProperty("inboundMete")
   @JSONField(name = "inboundMete")
   @TableField("inbound_mete")
   @Column(name = "inbound_mete", columnDefinition = "decimal(32,8)  COMMENT '入库总核算'", nullable = true)
   private BigDecimal inboundMete;
   @ApiModelProperty(name = "inboundQuantity", value = "入库计量", notes = "入库计量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   @TableField("inbound_quantity")
   @Column(name = "inbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '入库计量'", nullable = true)
   private BigDecimal inboundQuantity;
   @ApiModelProperty(name = "inboundAmount", value = "入库总计", notes = "入库总计")
   @JsonProperty("inboundAmount")
   @JSONField(name = "inboundAmount")
   @TableField("inbound_amount")
   @Column(name = "inbound_amount", columnDefinition = "decimal(32,12)  COMMENT '入库总计'", nullable = true)
   private BigDecimal inboundAmount;
   @ApiModelProperty(name = "inboundAmountExcludingVat", value = "入库不含税总价", notes = "入库不含税总价")
   @JsonProperty("inboundAmountExcludingVat")
   @JSONField(name = "inboundAmountExcludingVat")
   @TableField("inbound_amount_excluding_vat")
   @Column(name = "inbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '入库不含税总价'", nullable = true)
   private BigDecimal inboundAmountExcludingVat;
   @ApiModelProperty(name = "inboundUnitPrice", value = "入库单价", notes = "入库单价")
   @JsonProperty("inboundUnitPrice")
   @JSONField(name = "inboundUnitPrice")
   @TableField("inbound_unit_price")
   @Column(name = "inbound_unit_price", columnDefinition = "decimal(32,12)  COMMENT '入库单价'", nullable = true)
   private BigDecimal inboundUnitPrice;
   @ApiModelProperty(name = "inboundUnitPriceExcludingVat", value = "入库不含税单价", notes = "入库不含税单价")
   @JsonProperty("inboundUnitPriceExcludingVat")
   @JSONField(name = "inboundUnitPriceExcludingVat")
   @TableField("inbound_unit_price_excluding_vat")
   @Column(name = "inbound_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '入库不含税单价'", nullable = true)
   private BigDecimal inboundUnitPriceExcludingVat;
   @ApiModelProperty(name = "outboundMete", value = "出库总核算", notes = "出库总核算")
   @JsonProperty("outboundMete")
   @JSONField(name = "outboundMete")
   @TableField("outbound_mete")
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,8)  COMMENT '出库总核算'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundQuantity", value = "出库总计量", notes = "出库总计量")
   @JsonProperty("outboundQuantity")
   @JSONField(name = "outboundQuantity")
   @TableField("outbound_quantity")
   @Column(name = "outbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库总计量'", nullable = true)
   private BigDecimal outboundQuantity;
   @ApiModelProperty(name = "outboundAmount", value = "出库总金额", notes = "出库总金额")
   @JsonProperty("outboundAmount")
   @JSONField(name = "outboundAmount")
   @TableField("outbound_amount")
   @Column(name = "outbound_amount", columnDefinition = "decimal(32,12)  COMMENT '出库总金额'", nullable = true)
   private BigDecimal outboundAmount;
   @ApiModelProperty(name = "outboundAmountExcludingVat", value = "出库不含税总金额", notes = "出库不含税总金额")
   @JsonProperty("outboundAmountExcludingVat")
   @JSONField(name = "outboundAmountExcludingVat")
   @TableField("outbound_amount_excluding_vat")
   @Column(name = "outbound_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '出库不含税总金额'", nullable = true)
   private BigDecimal outboundAmountExcludingVat;
   @ApiModelProperty(name = "outboundUnitPrice", value = "出库单价", notes = "出库单价")
   @JsonProperty("outboundUnitPrice")
   @JSONField(name = "outboundUnitPrice")
   @TableField("outbound_unit_price")
   @Column(name = "outbound_unit_price", columnDefinition = "decimal(32,12)  COMMENT '出库单价'", nullable = true)
   private BigDecimal outboundUnitPrice;
   @ApiModelProperty(name = "outboundUnitPriceExcludingVat", value = "出库不含税单价", notes = "出库不含税单价")
   @JsonProperty("outboundUnitPriceExcludingVat")
   @JSONField(name = "outboundUnitPriceExcludingVat")
   @TableField("outbound_unit_price_excluding_vat")
   @Column(name = "outbound_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '出库不含税单价'", nullable = true)
   private BigDecimal outboundUnitPriceExcludingVat;
   @ApiModelProperty(name = "endMete", value = "库存核算量", notes = "库存核算量")
   @JsonProperty("endMete")
   @JSONField(name = "endMete")
   @TableField("end_mete")
   @Column(name = "end_mete", columnDefinition = "decimal(32,8)  COMMENT '库存核算量'", nullable = true)
   private BigDecimal endMete;
   @ApiModelProperty(name = "endQuantity", value = "库存计量量", notes = "库存计量量")
   @JsonProperty("endQuantity")
   @JSONField(name = "endQuantity")
   @TableField("end_quantity")
   @Column(name = "end_quantity", columnDefinition = "decimal(32,8)  COMMENT '库存计量量'", nullable = true)
   private BigDecimal endQuantity;
   @ApiModelProperty(name = "endAmount", value = "库存金额", notes = "库存金额")
   @JsonProperty("endAmount")
   @JSONField(name = "endAmount")
   @TableField("end_amount")
   @Column(name = "end_amount", columnDefinition = "decimal(32,12)  COMMENT '库存金额'", nullable = true)
   private BigDecimal endAmount;
   @ApiModelProperty(name = "endAmountExcludingVat", value = "库存不含税金额", notes = "库存不含税金额")
   @JsonProperty("endAmountExcludingVat")
   @JSONField(name = "endAmountExcludingVat")
   @TableField("end_amount_excluding_vat")
   @Column(name = "end_amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '库存不含税金额'", nullable = true)
   private BigDecimal endAmountExcludingVat;
   @ApiModelProperty(name = "endUnitPrice", value = "单价", notes = "单价")
   @JsonProperty("endUnitPrice")
   @JSONField(name = "endUnitPrice")
   @TableField("end_unit_price")
   @Column(name = "end_unit_price", columnDefinition = "decimal(32,12)  COMMENT '单价'", nullable = true)
   private BigDecimal endUnitPrice;
   @ApiModelProperty(name = "endUnitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("endUnitPriceExcludingVat")
   @JSONField(name = "endUnitPriceExcludingVat")
   @TableField("end_unit_price_excluding_vat")
   @Column(name = "end_unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal endUnitPriceExcludingVat;
   @ApiModelProperty(name = "weightedPriceType", value = "加权价类型", notes = "加权价类型")
   @JsonProperty("weightedPriceType")
   @JSONField(name = "weightedPriceType")
   @TableField("weighted_price_type")
   @Column(name = "weighted_price_type", columnDefinition = "int(11)  COMMENT '加权价类型'", nullable = true)
   private Integer weightedPriceType;

   public static InventoryDetailsRecord.InventoryDetailsRecordBuilder builder() {
      return new InventoryDetailsRecord.InventoryDetailsRecordBuilder();
   }

   public InventoryDetailsRecord() {
   }

   public InventoryDetailsRecord(
      final Long id,
      final Long statisticsId,
      final Long receiptId,
      final String receiptSerialNumber,
      final Integer receiptType,
      final String summary,
      final String detailKey,
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
      final Integer weightedPriceType
   ) {
      this.id = id;
      this.statisticsId = statisticsId;
      this.receiptId = receiptId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.receiptType = receiptType;
      this.summary = summary;
      this.detailKey = detailKey;
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
      this.weightedPriceType = weightedPriceType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStatisticsId() {
      return this.statisticsId;
   }

   public Long getReceiptId() {
      return this.receiptId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public Integer getReceiptType() {
      return this.receiptType;
   }

   public String getSummary() {
      return this.summary;
   }

   public String getDetailKey() {
      return this.detailKey;
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

   public Integer getWeightedPriceType() {
      return this.weightedPriceType;
   }

   @JsonProperty("id")
   public InventoryDetailsRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("statisticsId")
   public InventoryDetailsRecord setStatisticsId(final Long statisticsId) {
      this.statisticsId = statisticsId;
      return this;
   }

   @JsonProperty("receiptId")
   public InventoryDetailsRecord setReceiptId(final Long receiptId) {
      this.receiptId = receiptId;
      return this;
   }

   @JsonProperty("receiptSerialNumber")
   public InventoryDetailsRecord setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
      return this;
   }

   @JsonProperty("receiptType")
   public InventoryDetailsRecord setReceiptType(final Integer receiptType) {
      this.receiptType = receiptType;
      return this;
   }

   @JsonProperty("summary")
   public InventoryDetailsRecord setSummary(final String summary) {
      this.summary = summary;
      return this;
   }

   @JsonProperty("detailKey")
   public InventoryDetailsRecord setDetailKey(final String detailKey) {
      this.detailKey = detailKey;
      return this;
   }

   @JsonProperty("inboundMete")
   public InventoryDetailsRecord setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public InventoryDetailsRecord setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("inboundAmount")
   public InventoryDetailsRecord setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
      return this;
   }

   @JsonProperty("inboundAmountExcludingVat")
   public InventoryDetailsRecord setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("inboundUnitPrice")
   public InventoryDetailsRecord setInboundUnitPrice(final BigDecimal inboundUnitPrice) {
      this.inboundUnitPrice = inboundUnitPrice;
      return this;
   }

   @JsonProperty("inboundUnitPriceExcludingVat")
   public InventoryDetailsRecord setInboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("outboundMete")
   public InventoryDetailsRecord setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   @JsonProperty("outboundQuantity")
   public InventoryDetailsRecord setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   @JsonProperty("outboundAmount")
   public InventoryDetailsRecord setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
      return this;
   }

   @JsonProperty("outboundAmountExcludingVat")
   public InventoryDetailsRecord setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      return this;
   }

   @JsonProperty("outboundUnitPrice")
   public InventoryDetailsRecord setOutboundUnitPrice(final BigDecimal outboundUnitPrice) {
      this.outboundUnitPrice = outboundUnitPrice;
      return this;
   }

   @JsonProperty("outboundUnitPriceExcludingVat")
   public InventoryDetailsRecord setOutboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("endMete")
   public InventoryDetailsRecord setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
      return this;
   }

   @JsonProperty("endQuantity")
   public InventoryDetailsRecord setEndQuantity(final BigDecimal endQuantity) {
      this.endQuantity = endQuantity;
      return this;
   }

   @JsonProperty("endAmount")
   public InventoryDetailsRecord setEndAmount(final BigDecimal endAmount) {
      this.endAmount = endAmount;
      return this;
   }

   @JsonProperty("endAmountExcludingVat")
   public InventoryDetailsRecord setEndAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
      this.endAmountExcludingVat = endAmountExcludingVat;
      return this;
   }

   @JsonProperty("endUnitPrice")
   public InventoryDetailsRecord setEndUnitPrice(final BigDecimal endUnitPrice) {
      this.endUnitPrice = endUnitPrice;
      return this;
   }

   @JsonProperty("endUnitPriceExcludingVat")
   public InventoryDetailsRecord setEndUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
      return this;
   }

   @JsonProperty("weightedPriceType")
   public InventoryDetailsRecord setWeightedPriceType(final Integer weightedPriceType) {
      this.weightedPriceType = weightedPriceType;
      return this;
   }

   @Override
   public String toString() {
      return "InventoryDetailsRecord(id="
         + this.getId()
         + ", statisticsId="
         + this.getStatisticsId()
         + ", receiptId="
         + this.getReceiptId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", receiptType="
         + this.getReceiptType()
         + ", summary="
         + this.getSummary()
         + ", detailKey="
         + this.getDetailKey()
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
         + ", weightedPriceType="
         + this.getWeightedPriceType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryDetailsRecord)) {
         return false;
      }

      InventoryDetailsRecord other = (InventoryDetailsRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$statisticsId = this.getStatisticsId();
         Object other$statisticsId = other.getStatisticsId();
         if (this$statisticsId == null ? other$statisticsId == null : this$statisticsId.equals(other$statisticsId)) {
            Object this$receiptId = this.getReceiptId();
            Object other$receiptId = other.getReceiptId();
            if (this$receiptId == null ? other$receiptId == null : this$receiptId.equals(other$receiptId)) {
               Object this$receiptType = this.getReceiptType();
               Object other$receiptType = other.getReceiptType();
               if (this$receiptType == null ? other$receiptType == null : this$receiptType.equals(other$receiptType)) {
                  Object this$weightedPriceType = this.getWeightedPriceType();
                  Object other$weightedPriceType = other.getWeightedPriceType();
                  if (this$weightedPriceType == null ? other$weightedPriceType == null : this$weightedPriceType.equals(other$weightedPriceType)) {
                     Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                     Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                     if (this$receiptSerialNumber == null ? other$receiptSerialNumber == null : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                        Object this$summary = this.getSummary();
                        Object other$summary = other.getSummary();
                        if (this$summary == null ? other$summary == null : this$summary.equals(other$summary)) {
                           Object this$detailKey = this.getDetailKey();
                           Object other$detailKey = other.getDetailKey();
                           if (this$detailKey == null ? other$detailKey == null : this$detailKey.equals(other$detailKey)) {
                              Object this$inboundMete = this.getInboundMete();
                              Object other$inboundMete = other.getInboundMete();
                              if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                 Object this$inboundQuantity = this.getInboundQuantity();
                                 Object other$inboundQuantity = other.getInboundQuantity();
                                 if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                                    Object this$inboundAmount = this.getInboundAmount();
                                    Object other$inboundAmount = other.getInboundAmount();
                                    if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
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
                                                : this$inboundUnitPriceExcludingVat.equals(other$inboundUnitPriceExcludingVat)) {
                                                Object this$outboundMete = this.getOutboundMete();
                                                Object other$outboundMete = other.getOutboundMete();
                                                if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
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
                                                            : this$outboundAmountExcludingVat.equals(other$outboundAmountExcludingVat)) {
                                                            Object this$outboundUnitPrice = this.getOutboundUnitPrice();
                                                            Object other$outboundUnitPrice = other.getOutboundUnitPrice();
                                                            if (this$outboundUnitPrice == null
                                                               ? other$outboundUnitPrice == null
                                                               : this$outboundUnitPrice.equals(other$outboundUnitPrice)) {
                                                               Object this$outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
                                                               Object other$outboundUnitPriceExcludingVat = other.getOutboundUnitPriceExcludingVat();
                                                               if (this$outboundUnitPriceExcludingVat == null
                                                                  ? other$outboundUnitPriceExcludingVat == null
                                                                  : this$outboundUnitPriceExcludingVat.equals(other$outboundUnitPriceExcludingVat)) {
                                                                  Object this$endMete = this.getEndMete();
                                                                  Object other$endMete = other.getEndMete();
                                                                  if (this$endMete == null ? other$endMete == null : this$endMete.equals(other$endMete)) {
                                                                     Object this$endQuantity = this.getEndQuantity();
                                                                     Object other$endQuantity = other.getEndQuantity();
                                                                     if (this$endQuantity == null
                                                                        ? other$endQuantity == null
                                                                        : this$endQuantity.equals(other$endQuantity)) {
                                                                        Object this$endAmount = this.getEndAmount();
                                                                        Object other$endAmount = other.getEndAmount();
                                                                        if (this$endAmount == null
                                                                           ? other$endAmount == null
                                                                           : this$endAmount.equals(other$endAmount)) {
                                                                           Object this$endAmountExcludingVat = this.getEndAmountExcludingVat();
                                                                           Object other$endAmountExcludingVat = other.getEndAmountExcludingVat();
                                                                           if (this$endAmountExcludingVat == null
                                                                              ? other$endAmountExcludingVat == null
                                                                              : this$endAmountExcludingVat.equals(other$endAmountExcludingVat)) {
                                                                              Object this$endUnitPrice = this.getEndUnitPrice();
                                                                              Object other$endUnitPrice = other.getEndUnitPrice();
                                                                              if (this$endUnitPrice == null
                                                                                 ? other$endUnitPrice == null
                                                                                 : this$endUnitPrice.equals(other$endUnitPrice)) {
                                                                                 Object this$endUnitPriceExcludingVat = this.getEndUnitPriceExcludingVat();
                                                                                 Object other$endUnitPriceExcludingVat = other.getEndUnitPriceExcludingVat();
                                                                                 return this$endUnitPriceExcludingVat == null
                                                                                    ? other$endUnitPriceExcludingVat == null
                                                                                    : this$endUnitPriceExcludingVat.equals(other$endUnitPriceExcludingVat);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof InventoryDetailsRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $statisticsId = this.getStatisticsId();
      result = result * 59 + ($statisticsId == null ? 43 : $statisticsId.hashCode());
      Object $receiptId = this.getReceiptId();
      result = result * 59 + ($receiptId == null ? 43 : $receiptId.hashCode());
      Object $receiptType = this.getReceiptType();
      result = result * 59 + ($receiptType == null ? 43 : $receiptType.hashCode());
      Object $weightedPriceType = this.getWeightedPriceType();
      result = result * 59 + ($weightedPriceType == null ? 43 : $weightedPriceType.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $summary = this.getSummary();
      result = result * 59 + ($summary == null ? 43 : $summary.hashCode());
      Object $detailKey = this.getDetailKey();
      result = result * 59 + ($detailKey == null ? 43 : $detailKey.hashCode());
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
      return result * 59 + ($endUnitPriceExcludingVat == null ? 43 : $endUnitPriceExcludingVat.hashCode());
   }

   public static class InventoryDetailsRecordBuilder {
      private Long id;
      private Long statisticsId;
      private Long receiptId;
      private String receiptSerialNumber;
      private Integer receiptType;
      private String summary;
      private String detailKey;
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
      private Integer weightedPriceType;

      InventoryDetailsRecordBuilder() {
      }

      @JsonProperty("id")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("statisticsId")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder statisticsId(final Long statisticsId) {
         this.statisticsId = statisticsId;
         return this;
      }

      @JsonProperty("receiptId")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder receiptId(final Long receiptId) {
         this.receiptId = receiptId;
         return this;
      }

      @JsonProperty("receiptSerialNumber")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      @JsonProperty("receiptType")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder receiptType(final Integer receiptType) {
         this.receiptType = receiptType;
         return this;
      }

      @JsonProperty("summary")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder summary(final String summary) {
         this.summary = summary;
         return this;
      }

      @JsonProperty("detailKey")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder detailKey(final String detailKey) {
         this.detailKey = detailKey;
         return this;
      }

      @JsonProperty("inboundMete")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("inboundAmount")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      @JsonProperty("inboundAmountExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("inboundUnitPrice")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundUnitPrice(final BigDecimal inboundUnitPrice) {
         this.inboundUnitPrice = inboundUnitPrice;
         return this;
      }

      @JsonProperty("inboundUnitPriceExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder inboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
         this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("outboundMete")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      @JsonProperty("outboundQuantity")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      @JsonProperty("outboundAmount")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      @JsonProperty("outboundAmountExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      @JsonProperty("outboundUnitPrice")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundUnitPrice(final BigDecimal outboundUnitPrice) {
         this.outboundUnitPrice = outboundUnitPrice;
         return this;
      }

      @JsonProperty("outboundUnitPriceExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder outboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
         this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("endMete")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      @JsonProperty("endQuantity")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endQuantity(final BigDecimal endQuantity) {
         this.endQuantity = endQuantity;
         return this;
      }

      @JsonProperty("endAmount")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endAmount(final BigDecimal endAmount) {
         this.endAmount = endAmount;
         return this;
      }

      @JsonProperty("endAmountExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
         this.endAmountExcludingVat = endAmountExcludingVat;
         return this;
      }

      @JsonProperty("endUnitPrice")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endUnitPrice(final BigDecimal endUnitPrice) {
         this.endUnitPrice = endUnitPrice;
         return this;
      }

      @JsonProperty("endUnitPriceExcludingVat")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder endUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
         this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
         return this;
      }

      @JsonProperty("weightedPriceType")
      public InventoryDetailsRecord.InventoryDetailsRecordBuilder weightedPriceType(final Integer weightedPriceType) {
         this.weightedPriceType = weightedPriceType;
         return this;
      }

      public InventoryDetailsRecord build() {
         return new InventoryDetailsRecord(
            this.id,
            this.statisticsId,
            this.receiptId,
            this.receiptSerialNumber,
            this.receiptType,
            this.summary,
            this.detailKey,
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
            this.weightedPriceType
         );
      }

      @Override
      public String toString() {
         return "InventoryDetailsRecord.InventoryDetailsRecordBuilder(id="
            + this.id
            + ", statisticsId="
            + this.statisticsId
            + ", receiptId="
            + this.receiptId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", receiptType="
            + this.receiptType
            + ", summary="
            + this.summary
            + ", detailKey="
            + this.detailKey
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
            + ", weightedPriceType="
            + this.weightedPriceType
            + ")";
      }
   }
}
