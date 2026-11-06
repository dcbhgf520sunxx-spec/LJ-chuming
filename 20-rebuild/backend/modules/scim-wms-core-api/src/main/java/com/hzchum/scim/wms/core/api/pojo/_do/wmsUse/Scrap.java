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

@ApiModel(value = "Scrap对象", description = "废料表")
@Entity
@TableName("wms_scrap")
@Table(name = "wms_scrap")
public class Scrap extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "basicClass", value = "基础物料分类", notes = "基础物料分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
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
   @ApiModelProperty(name = "inventoryEndTime")
   @JsonProperty("inventoryEndTime")
   @JSONField(name = "inventoryEndTime")
   @TableField("inventory_end_time")
   @Column(name = "inventory_end_time", columnDefinition = "datetime  COMMENT ''", nullable = true)
   private LocalDateTime inventoryEndTime;
   @ApiModelProperty(name = "inventoryStartTime")
   @JsonProperty("inventoryStartTime")
   @JSONField(name = "inventoryStartTime")
   @TableField("inventory_start_time")
   @Column(name = "inventory_start_time", columnDefinition = "datetime  COMMENT ''", nullable = true)
   private LocalDateTime inventoryStartTime;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,2)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供材料", notes = "是否为甲供材料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供材料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型", notes = "仓库类型")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式", notes = "重量计量方式")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
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
   @ApiModelProperty(name = "convertNumber", value = "转换单编号", notes = "转换单编号")
   @JsonProperty("convertNumber")
   @JSONField(name = "convertNumber")
   @TableField("convert_number")
   @Column(name = "convert_number", columnDefinition = "varchar(255)  COMMENT '转换单编号'", nullable = true)
   private String convertNumber;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价  不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;

   public static Scrap.ScrapBuilder builder() {
      return new Scrap.ScrapBuilder();
   }

   public Scrap() {
   }

   public Scrap(
      final Long id,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final Integer basicClass,
      final String brand,
      final Long classifyId,
      final String color,
      final String heatNoAndBatchNo,
      final LocalDateTime inventoryEndTime,
      final LocalDateTime inventoryStartTime,
      final BigDecimal length,
      final String measureUnit,
      final BigDecimal mete,
      final Long projectId,
      final BigDecimal quantity,
      final String remark,
      final String specification,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final Boolean boolPartyA,
      final BigDecimal unitNet,
      final Long warehouseId,
      final Integer warehouseType,
      final Integer weightMeasurementMode,
      final BigDecimal width,
      final Long standardId,
      final String standardName,
      final String convertNumber,
      final Long workshopId,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight
   ) {
      this.id = id;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.basicClass = basicClass;
      this.brand = brand;
      this.classifyId = classifyId;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.inventoryEndTime = inventoryEndTime;
      this.inventoryStartTime = inventoryStartTime;
      this.length = length;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.projectId = projectId;
      this.quantity = quantity;
      this.remark = remark;
      this.specification = specification;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.boolPartyA = boolPartyA;
      this.unitNet = unitNet;
      this.warehouseId = warehouseId;
      this.warehouseType = warehouseType;
      this.weightMeasurementMode = weightMeasurementMode;
      this.width = width;
      this.standardId = standardId;
      this.standardName = standardName;
      this.convertNumber = convertNumber;
      this.workshopId = workshopId;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBrand() {
      return this.brand;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public LocalDateTime getInventoryEndTime() {
      return this.inventoryEndTime;
   }

   public LocalDateTime getInventoryStartTime() {
      return this.inventoryStartTime;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getConvertNumber() {
      return this.convertNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   @JsonProperty("id")
   public Scrap setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("amount")
   public Scrap setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public Scrap setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("basicClass")
   public Scrap setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("brand")
   public Scrap setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("classifyId")
   public Scrap setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("color")
   public Scrap setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public Scrap setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("inventoryEndTime")
   public Scrap setInventoryEndTime(final LocalDateTime inventoryEndTime) {
      this.inventoryEndTime = inventoryEndTime;
      return this;
   }

   @JsonProperty("inventoryStartTime")
   public Scrap setInventoryStartTime(final LocalDateTime inventoryStartTime) {
      this.inventoryStartTime = inventoryStartTime;
      return this;
   }

   @JsonProperty("length")
   public Scrap setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("measureUnit")
   public Scrap setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("mete")
   public Scrap setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("projectId")
   public Scrap setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public Scrap setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("remark")
   public Scrap setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("specification")
   public Scrap setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("theoryThickness")
   public Scrap setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("thickness")
   public Scrap setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Scrap setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("unitNet")
   public Scrap setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("warehouseId")
   public Scrap setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("warehouseType")
   public Scrap setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public Scrap setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("width")
   public Scrap setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("standardId")
   public Scrap setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public Scrap setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("convertNumber")
   public Scrap setConvertNumber(final String convertNumber) {
      this.convertNumber = convertNumber;
      return this;
   }

   @JsonProperty("workshopId")
   public Scrap setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public Scrap setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public Scrap setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @Override
   public String toString() {
      return "Scrap(id="
         + this.getId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", basicClass="
         + this.getBasicClass()
         + ", brand="
         + this.getBrand()
         + ", classifyId="
         + this.getClassifyId()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", inventoryEndTime="
         + this.getInventoryEndTime()
         + ", inventoryStartTime="
         + this.getInventoryStartTime()
         + ", length="
         + this.getLength()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ", specification="
         + this.getSpecification()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", unitNet="
         + this.getUnitNet()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", width="
         + this.getWidth()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", convertNumber="
         + this.getConvertNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Scrap)) {
         return false;
      }

      Scrap other = (Scrap)o;
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
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$warehouseType = this.getWarehouseType();
                        Object other$warehouseType = other.getWarehouseType();
                        if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                           Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                           Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                           if (this$weightMeasurementMode == null
                              ? other$weightMeasurementMode == null
                              : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$workshopId = this.getWorkshopId();
                                 Object other$workshopId = other.getWorkshopId();
                                 if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                       Object this$amountExcludingVat = this.getAmountExcludingVat();
                                       Object other$amountExcludingVat = other.getAmountExcludingVat();
                                       if (this$amountExcludingVat == null
                                          ? other$amountExcludingVat == null
                                          : this$amountExcludingVat.equals(other$amountExcludingVat)) {
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
                                                   Object this$inventoryEndTime = this.getInventoryEndTime();
                                                   Object other$inventoryEndTime = other.getInventoryEndTime();
                                                   if (this$inventoryEndTime == null
                                                      ? other$inventoryEndTime == null
                                                      : this$inventoryEndTime.equals(other$inventoryEndTime)) {
                                                      Object this$inventoryStartTime = this.getInventoryStartTime();
                                                      Object other$inventoryStartTime = other.getInventoryStartTime();
                                                      if (this$inventoryStartTime == null
                                                         ? other$inventoryStartTime == null
                                                         : this$inventoryStartTime.equals(other$inventoryStartTime)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$measureUnit = this.getMeasureUnit();
                                                            Object other$measureUnit = other.getMeasureUnit();
                                                            if (this$measureUnit == null
                                                               ? other$measureUnit == null
                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                               Object this$mete = this.getMete();
                                                               Object other$mete = other.getMete();
                                                               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$specification = this.getSpecification();
                                                                        Object other$specification = other.getSpecification();
                                                                        if (this$specification == null
                                                                           ? other$specification == null
                                                                           : this$specification.equals(other$specification)) {
                                                                           Object this$theoryThickness = this.getTheoryThickness();
                                                                           Object other$theoryThickness = other.getTheoryThickness();
                                                                           if (this$theoryThickness == null
                                                                              ? other$theoryThickness == null
                                                                              : this$theoryThickness.equals(other$theoryThickness)) {
                                                                              Object this$thickness = this.getThickness();
                                                                              Object other$thickness = other.getThickness();
                                                                              if (this$thickness == null
                                                                                 ? other$thickness == null
                                                                                 : this$thickness.equals(other$thickness)) {
                                                                                 Object this$unitNet = this.getUnitNet();
                                                                                 Object other$unitNet = other.getUnitNet();
                                                                                 if (this$unitNet == null
                                                                                    ? other$unitNet == null
                                                                                    : this$unitNet.equals(other$unitNet)) {
                                                                                    Object this$width = this.getWidth();
                                                                                    Object other$width = other.getWidth();
                                                                                    if (this$width == null
                                                                                       ? other$width == null
                                                                                       : this$width.equals(other$width)) {
                                                                                       Object this$standardName = this.getStandardName();
                                                                                       Object other$standardName = other.getStandardName();
                                                                                       if (this$standardName == null
                                                                                          ? other$standardName == null
                                                                                          : this$standardName.equals(other$standardName)) {
                                                                                          Object this$convertNumber = this.getConvertNumber();
                                                                                          Object other$convertNumber = other.getConvertNumber();
                                                                                          if (this$convertNumber == null
                                                                                             ? other$convertNumber == null
                                                                                             : this$convertNumber.equals(other$convertNumber)) {
                                                                                             Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                             Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                             if (this$amountNoFreight == null
                                                                                                ? other$amountNoFreight == null
                                                                                                : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                                                Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                return this$amountExcludingVatNoFreight == null
                                                                                                   ? other$amountExcludingVatNoFreight == null
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Scrap;
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $inventoryEndTime = this.getInventoryEndTime();
      result = result * 59 + ($inventoryEndTime == null ? 43 : $inventoryEndTime.hashCode());
      Object $inventoryStartTime = this.getInventoryStartTime();
      result = result * 59 + ($inventoryStartTime == null ? 43 : $inventoryStartTime.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $convertNumber = this.getConvertNumber();
      result = result * 59 + ($convertNumber == null ? 43 : $convertNumber.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      return result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
   }

   public static class ScrapBuilder {
      private Long id;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private Integer basicClass;
      private String brand;
      private Long classifyId;
      private String color;
      private String heatNoAndBatchNo;
      private LocalDateTime inventoryEndTime;
      private LocalDateTime inventoryStartTime;
      private BigDecimal length;
      private String measureUnit;
      private BigDecimal mete;
      private Long projectId;
      private BigDecimal quantity;
      private String remark;
      private String specification;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private Boolean boolPartyA;
      private BigDecimal unitNet;
      private Long warehouseId;
      private Integer warehouseType;
      private Integer weightMeasurementMode;
      private BigDecimal width;
      private Long standardId;
      private String standardName;
      private String convertNumber;
      private Long workshopId;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;

      ScrapBuilder() {
      }

      @JsonProperty("id")
      public Scrap.ScrapBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("amount")
      public Scrap.ScrapBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public Scrap.ScrapBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("basicClass")
      public Scrap.ScrapBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("brand")
      public Scrap.ScrapBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("classifyId")
      public Scrap.ScrapBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("color")
      public Scrap.ScrapBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public Scrap.ScrapBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("inventoryEndTime")
      public Scrap.ScrapBuilder inventoryEndTime(final LocalDateTime inventoryEndTime) {
         this.inventoryEndTime = inventoryEndTime;
         return this;
      }

      @JsonProperty("inventoryStartTime")
      public Scrap.ScrapBuilder inventoryStartTime(final LocalDateTime inventoryStartTime) {
         this.inventoryStartTime = inventoryStartTime;
         return this;
      }

      @JsonProperty("length")
      public Scrap.ScrapBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("measureUnit")
      public Scrap.ScrapBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("mete")
      public Scrap.ScrapBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("projectId")
      public Scrap.ScrapBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public Scrap.ScrapBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("remark")
      public Scrap.ScrapBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("specification")
      public Scrap.ScrapBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("theoryThickness")
      public Scrap.ScrapBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("thickness")
      public Scrap.ScrapBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Scrap.ScrapBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("unitNet")
      public Scrap.ScrapBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("warehouseId")
      public Scrap.ScrapBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("warehouseType")
      public Scrap.ScrapBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public Scrap.ScrapBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("width")
      public Scrap.ScrapBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("standardId")
      public Scrap.ScrapBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public Scrap.ScrapBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("convertNumber")
      public Scrap.ScrapBuilder convertNumber(final String convertNumber) {
         this.convertNumber = convertNumber;
         return this;
      }

      @JsonProperty("workshopId")
      public Scrap.ScrapBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public Scrap.ScrapBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public Scrap.ScrapBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      public Scrap build() {
         return new Scrap(
            this.id,
            this.amount,
            this.amountExcludingVat,
            this.basicClass,
            this.brand,
            this.classifyId,
            this.color,
            this.heatNoAndBatchNo,
            this.inventoryEndTime,
            this.inventoryStartTime,
            this.length,
            this.measureUnit,
            this.mete,
            this.projectId,
            this.quantity,
            this.remark,
            this.specification,
            this.theoryThickness,
            this.thickness,
            this.boolPartyA,
            this.unitNet,
            this.warehouseId,
            this.warehouseType,
            this.weightMeasurementMode,
            this.width,
            this.standardId,
            this.standardName,
            this.convertNumber,
            this.workshopId,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight
         );
      }

      @Override
      public String toString() {
         return "Scrap.ScrapBuilder(id="
            + this.id
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", basicClass="
            + this.basicClass
            + ", brand="
            + this.brand
            + ", classifyId="
            + this.classifyId
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", inventoryEndTime="
            + this.inventoryEndTime
            + ", inventoryStartTime="
            + this.inventoryStartTime
            + ", length="
            + this.length
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ", specification="
            + this.specification
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", boolPartyA="
            + this.boolPartyA
            + ", unitNet="
            + this.unitNet
            + ", warehouseId="
            + this.warehouseId
            + ", warehouseType="
            + this.warehouseType
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", width="
            + this.width
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", convertNumber="
            + this.convertNumber
            + ", workshopId="
            + this.workshopId
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ")";
      }
   }
}
