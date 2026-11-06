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

@ApiModel(value = "LabelPrintDetail对象", description = "标签打印详情记录 ")
@Entity
@TableName("wms_print_detail")
@Table(name = "wms_print_detail")
public class PrintDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "printId", value = "打印记录ID", notes = "打印记录ID")
   @JsonProperty("printId")
   @JSONField(name = "printId")
   @TableField("print_id")
   @Column(name = "print_id", columnDefinition = "bigint  COMMENT '打印记录ID'", nullable = true)
   private Long printId;
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
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "boolPrinted", value = "是否已打印(当前打印数量与物料数量相同为true)", notes = "是否已打印(当前打印数量与物料数量相同为true)")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", columnDefinition = "tinyint(1) default '0' COMMENT '是否已打印(当前打印数量与物料数量相同为true)'", nullable = true)
   private Boolean boolPrinted;
   @ApiModelProperty(name = "printNumber", value = "打印数量", notes = "打印数量")
   @JsonProperty("printNumber")
   @JSONField(name = "printNumber")
   @TableField("print_number")
   @Column(name = "print_number", columnDefinition = "int default '0' COMMENT '打印数量'", nullable = true)
   private Integer printNumber;
   @ApiModelProperty(name = "printShareNumber", value = "打印份数", notes = "打印份数")
   @JsonProperty("printShareNumber")
   @JSONField(name = "printShareNumber")
   @TableField("print_share_number")
   @Column(name = "print_share_number", columnDefinition = "int default '0' COMMENT '打印份数'", nullable = true)
   private Integer printShareNumber;
   @ApiModelProperty(name = "notPrintNumber", value = "未打印份数", notes = "未打印份数")
   @JsonProperty("notPrintNumber")
   @JSONField(name = "notPrintNumber")
   @TableField("not_print_number")
   @Column(name = "not_print_number", columnDefinition = "int  COMMENT '未打印份数'", nullable = true)
   private Integer notPrintNumber;
   @ApiModelProperty(name = "printerId", value = "打印操作人ID", notes = "打印操作人ID")
   @JsonProperty("printerId")
   @JSONField(name = "printerId")
   @TableField("printer_id")
   @Column(name = "printer_id", columnDefinition = "bigint  COMMENT '打印操作人ID'", nullable = true)
   private Long printerId;
   @ApiModelProperty(name = "printerName", value = "打印操作人名称", notes = "打印操作人名称")
   @JsonProperty("printerName")
   @JSONField(name = "printerName")
   @TableField("printer_name")
   @Column(name = "printer_name", columnDefinition = "varchar(255)  COMMENT '打印操作人名称'", nullable = true)
   private String printerName;
   @ApiModelProperty(name = "printTime", value = "打印时间", notes = "打印时间")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime  COMMENT '打印时间'", nullable = true)
   private LocalDateTime printTime;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "barcode", value = "条形码", notes = "条形码")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode", columnDefinition = "varchar(255)  COMMENT '条形码'", nullable = true)
   private String barcode;
   @ApiModelProperty(name = "type", value = "物料产生类型[ MaterialLabelPrintTypeEnum ]", notes = "物料产生类型[ MaterialLabelPrintTypeEnum ]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '物料产生类型[ MaterialLabelPrintTypeEnum ]'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供", notes = "是否甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "bit(1)  COMMENT '是否甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(19,2)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "宽", notes = "宽")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(19,2)  COMMENT '宽'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "厚", notes = "厚")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(19,2)  COMMENT '厚'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "receiptDetailId", value = "单据详情单ID", notes = "单据详情单ID")
   @JsonProperty("receiptDetailId")
   @JSONField(name = "receiptDetailId")
   @TableField("receipt_detail_id")
   @Column(name = "receipt_detail_id", columnDefinition = "bigint  COMMENT '单据详情单ID'", nullable = true)
   private Long receiptDetailId;
   @ApiModelProperty(name = "standardId", value = "执行国标ID", notes = "执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "执行国标名称", notes = "执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '执行国标名称'", nullable = true)
   private String standardName;
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
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整[1 整料,2 余料]", notes = "物料是否完整[1 整料,2 余料]")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料是否完整[1 整料,2 余料]'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;

   public static PrintDetail.PrintDetailBuilder builder() {
      return new PrintDetail.PrintDetailBuilder();
   }

   public PrintDetail() {
   }

   public PrintDetail(
      final Long id,
      final Long printId,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final BigDecimal mete,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final Long warehouseId,
      final Boolean boolPrinted,
      final Integer printNumber,
      final Integer printShareNumber,
      final Integer notPrintNumber,
      final Long printerId,
      final String printerName,
      final LocalDateTime printTime,
      final Long projectId,
      final String barcode,
      final Integer type,
      final Boolean boolPartyA,
      final String color,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final Long receiptDetailId,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final Integer materialIsWhole,
      final Long workshopId
   ) {
      this.id = id;
      this.printId = printId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.mete = mete;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseId = warehouseId;
      this.boolPrinted = boolPrinted;
      this.printNumber = printNumber;
      this.printShareNumber = printShareNumber;
      this.notPrintNumber = notPrintNumber;
      this.printerId = printerId;
      this.printerName = printerName;
      this.printTime = printTime;
      this.projectId = projectId;
      this.barcode = barcode;
      this.type = type;
      this.boolPartyA = boolPartyA;
      this.color = color;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.receiptDetailId = receiptDetailId;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.materialIsWhole = materialIsWhole;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPrintId() {
      return this.printId;
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

   public BigDecimal getMete() {
      return this.mete;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getPrintNumber() {
      return this.printNumber;
   }

   public Integer getPrintShareNumber() {
      return this.printShareNumber;
   }

   public Integer getNotPrintNumber() {
      return this.notPrintNumber;
   }

   public Long getPrinterId() {
      return this.printerId;
   }

   public String getPrinterName() {
      return this.printerName;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public Integer getType() {
      return this.type;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public Long getReceiptDetailId() {
      return this.receiptDetailId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public PrintDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("printId")
   public PrintDetail setPrintId(final Long printId) {
      this.printId = printId;
      return this;
   }

   @JsonProperty("basicClass")
   public PrintDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public PrintDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public PrintDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public PrintDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("mete")
   public PrintDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public PrintDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("brand")
   public PrintDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public PrintDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("warehouseId")
   public PrintDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("boolPrinted")
   public PrintDetail setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("printNumber")
   public PrintDetail setPrintNumber(final Integer printNumber) {
      this.printNumber = printNumber;
      return this;
   }

   @JsonProperty("printShareNumber")
   public PrintDetail setPrintShareNumber(final Integer printShareNumber) {
      this.printShareNumber = printShareNumber;
      return this;
   }

   @JsonProperty("notPrintNumber")
   public PrintDetail setNotPrintNumber(final Integer notPrintNumber) {
      this.notPrintNumber = notPrintNumber;
      return this;
   }

   @JsonProperty("printerId")
   public PrintDetail setPrinterId(final Long printerId) {
      this.printerId = printerId;
      return this;
   }

   @JsonProperty("printerName")
   public PrintDetail setPrinterName(final String printerName) {
      this.printerName = printerName;
      return this;
   }

   @JsonProperty("printTime")
   public PrintDetail setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @JsonProperty("projectId")
   public PrintDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("barcode")
   public PrintDetail setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("type")
   public PrintDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("boolPartyA")
   public PrintDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("color")
   public PrintDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("length")
   public PrintDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("thickness")
   public PrintDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public PrintDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("receiptDetailId")
   public PrintDetail setReceiptDetailId(final Long receiptDetailId) {
      this.receiptDetailId = receiptDetailId;
      return this;
   }

   @JsonProperty("standardId")
   public PrintDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public PrintDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("monomerId")
   public PrintDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public PrintDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public PrintDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("workshopId")
   public PrintDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "PrintDetail(id="
         + this.getId()
         + ", printId="
         + this.getPrintId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", printNumber="
         + this.getPrintNumber()
         + ", printShareNumber="
         + this.getPrintShareNumber()
         + ", notPrintNumber="
         + this.getNotPrintNumber()
         + ", printerId="
         + this.getPrinterId()
         + ", printerName="
         + this.getPrinterName()
         + ", printTime="
         + this.getPrintTime()
         + ", projectId="
         + this.getProjectId()
         + ", barcode="
         + this.getBarcode()
         + ", type="
         + this.getType()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", color="
         + this.getColor()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", receiptDetailId="
         + this.getReceiptDetailId()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintDetail)) {
         return false;
      }

      PrintDetail other = (PrintDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$printId = this.getPrintId();
         Object other$printId = other.getPrintId();
         if (this$printId == null ? other$printId == null : this$printId.equals(other$printId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$boolPrinted = this.getBoolPrinted();
                     Object other$boolPrinted = other.getBoolPrinted();
                     if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                        Object this$printNumber = this.getPrintNumber();
                        Object other$printNumber = other.getPrintNumber();
                        if (this$printNumber == null ? other$printNumber == null : this$printNumber.equals(other$printNumber)) {
                           Object this$printShareNumber = this.getPrintShareNumber();
                           Object other$printShareNumber = other.getPrintShareNumber();
                           if (this$printShareNumber == null ? other$printShareNumber == null : this$printShareNumber.equals(other$printShareNumber)) {
                              Object this$notPrintNumber = this.getNotPrintNumber();
                              Object other$notPrintNumber = other.getNotPrintNumber();
                              if (this$notPrintNumber == null ? other$notPrintNumber == null : this$notPrintNumber.equals(other$notPrintNumber)) {
                                 Object this$printerId = this.getPrinterId();
                                 Object other$printerId = other.getPrinterId();
                                 if (this$printerId == null ? other$printerId == null : this$printerId.equals(other$printerId)) {
                                    Object this$projectId = this.getProjectId();
                                    Object other$projectId = other.getProjectId();
                                    if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$boolPartyA = this.getBoolPartyA();
                                          Object other$boolPartyA = other.getBoolPartyA();
                                          if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                             Object this$receiptDetailId = this.getReceiptDetailId();
                                             Object other$receiptDetailId = other.getReceiptDetailId();
                                             if (this$receiptDetailId == null
                                                ? other$receiptDetailId == null
                                                : this$receiptDetailId.equals(other$receiptDetailId)) {
                                                Object this$standardId = this.getStandardId();
                                                Object other$standardId = other.getStandardId();
                                                if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$materialIsWhole = this.getMaterialIsWhole();
                                                         Object other$materialIsWhole = other.getMaterialIsWhole();
                                                         if (this$materialIsWhole == null
                                                            ? other$materialIsWhole == null
                                                            : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                            Object this$workshopId = this.getWorkshopId();
                                                            Object other$workshopId = other.getWorkshopId();
                                                            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
                                                                     Object this$mete = this.getMete();
                                                                     Object other$mete = other.getMete();
                                                                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$brand = this.getBrand();
                                                                           Object other$brand = other.getBrand();
                                                                           if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                              Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                              Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                              if (this$heatNoAndBatchNo == null
                                                                                 ? other$heatNoAndBatchNo == null
                                                                                 : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                 Object this$printerName = this.getPrinterName();
                                                                                 Object other$printerName = other.getPrinterName();
                                                                                 if (this$printerName == null
                                                                                    ? other$printerName == null
                                                                                    : this$printerName.equals(other$printerName)) {
                                                                                    Object this$printTime = this.getPrintTime();
                                                                                    Object other$printTime = other.getPrintTime();
                                                                                    if (this$printTime == null
                                                                                       ? other$printTime == null
                                                                                       : this$printTime.equals(other$printTime)) {
                                                                                       Object this$barcode = this.getBarcode();
                                                                                       Object other$barcode = other.getBarcode();
                                                                                       if (this$barcode == null
                                                                                          ? other$barcode == null
                                                                                          : this$barcode.equals(other$barcode)) {
                                                                                          Object this$color = this.getColor();
                                                                                          Object other$color = other.getColor();
                                                                                          if (this$color == null
                                                                                             ? other$color == null
                                                                                             : this$color.equals(other$color)) {
                                                                                             Object this$length = this.getLength();
                                                                                             Object other$length = other.getLength();
                                                                                             if (this$length == null
                                                                                                ? other$length == null
                                                                                                : this$length.equals(other$length)) {
                                                                                                Object this$thickness = this.getThickness();
                                                                                                Object other$thickness = other.getThickness();
                                                                                                if (this$thickness == null
                                                                                                   ? other$thickness == null
                                                                                                   : this$thickness.equals(other$thickness)) {
                                                                                                   Object this$width = this.getWidth();
                                                                                                   Object other$width = other.getWidth();
                                                                                                   if (this$width == null
                                                                                                      ? other$width == null
                                                                                                      : this$width.equals(other$width)) {
                                                                                                      Object this$standardName = this.getStandardName();
                                                                                                      Object other$standardName = other.getStandardName();
                                                                                                      return this$standardName == null
                                                                                                         ? other$standardName == null
                                                                                                         : this$standardName.equals(other$standardName);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PrintDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $printId = this.getPrintId();
      result = result * 59 + ($printId == null ? 43 : $printId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $printNumber = this.getPrintNumber();
      result = result * 59 + ($printNumber == null ? 43 : $printNumber.hashCode());
      Object $printShareNumber = this.getPrintShareNumber();
      result = result * 59 + ($printShareNumber == null ? 43 : $printShareNumber.hashCode());
      Object $notPrintNumber = this.getNotPrintNumber();
      result = result * 59 + ($notPrintNumber == null ? 43 : $notPrintNumber.hashCode());
      Object $printerId = this.getPrinterId();
      result = result * 59 + ($printerId == null ? 43 : $printerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $receiptDetailId = this.getReceiptDetailId();
      result = result * 59 + ($receiptDetailId == null ? 43 : $receiptDetailId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $printerName = this.getPrinterName();
      result = result * 59 + ($printerName == null ? 43 : $printerName.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $standardName = this.getStandardName();
      return result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
   }

   public static class PrintDetailBuilder {
      private Long id;
      private Long printId;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private BigDecimal mete;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private Long warehouseId;
      private Boolean boolPrinted;
      private Integer printNumber;
      private Integer printShareNumber;
      private Integer notPrintNumber;
      private Long printerId;
      private String printerName;
      private LocalDateTime printTime;
      private Long projectId;
      private String barcode;
      private Integer type;
      private Boolean boolPartyA;
      private String color;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private Long receiptDetailId;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private Integer materialIsWhole;
      private Long workshopId;

      PrintDetailBuilder() {
      }

      @JsonProperty("id")
      public PrintDetail.PrintDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("printId")
      public PrintDetail.PrintDetailBuilder printId(final Long printId) {
         this.printId = printId;
         return this;
      }

      @JsonProperty("basicClass")
      public PrintDetail.PrintDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public PrintDetail.PrintDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public PrintDetail.PrintDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public PrintDetail.PrintDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("mete")
      public PrintDetail.PrintDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public PrintDetail.PrintDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("brand")
      public PrintDetail.PrintDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public PrintDetail.PrintDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("warehouseId")
      public PrintDetail.PrintDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("boolPrinted")
      public PrintDetail.PrintDetailBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("printNumber")
      public PrintDetail.PrintDetailBuilder printNumber(final Integer printNumber) {
         this.printNumber = printNumber;
         return this;
      }

      @JsonProperty("printShareNumber")
      public PrintDetail.PrintDetailBuilder printShareNumber(final Integer printShareNumber) {
         this.printShareNumber = printShareNumber;
         return this;
      }

      @JsonProperty("notPrintNumber")
      public PrintDetail.PrintDetailBuilder notPrintNumber(final Integer notPrintNumber) {
         this.notPrintNumber = notPrintNumber;
         return this;
      }

      @JsonProperty("printerId")
      public PrintDetail.PrintDetailBuilder printerId(final Long printerId) {
         this.printerId = printerId;
         return this;
      }

      @JsonProperty("printerName")
      public PrintDetail.PrintDetailBuilder printerName(final String printerName) {
         this.printerName = printerName;
         return this;
      }

      @JsonProperty("printTime")
      public PrintDetail.PrintDetailBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      @JsonProperty("projectId")
      public PrintDetail.PrintDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("barcode")
      public PrintDetail.PrintDetailBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("type")
      public PrintDetail.PrintDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("boolPartyA")
      public PrintDetail.PrintDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("color")
      public PrintDetail.PrintDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("length")
      public PrintDetail.PrintDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("thickness")
      public PrintDetail.PrintDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public PrintDetail.PrintDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("receiptDetailId")
      public PrintDetail.PrintDetailBuilder receiptDetailId(final Long receiptDetailId) {
         this.receiptDetailId = receiptDetailId;
         return this;
      }

      @JsonProperty("standardId")
      public PrintDetail.PrintDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public PrintDetail.PrintDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("monomerId")
      public PrintDetail.PrintDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public PrintDetail.PrintDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public PrintDetail.PrintDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("workshopId")
      public PrintDetail.PrintDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public PrintDetail build() {
         return new PrintDetail(
            this.id,
            this.printId,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.mete,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.warehouseId,
            this.boolPrinted,
            this.printNumber,
            this.printShareNumber,
            this.notPrintNumber,
            this.printerId,
            this.printerName,
            this.printTime,
            this.projectId,
            this.barcode,
            this.type,
            this.boolPartyA,
            this.color,
            this.length,
            this.thickness,
            this.width,
            this.receiptDetailId,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.materialIsWhole,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "PrintDetail.PrintDetailBuilder(id="
            + this.id
            + ", printId="
            + this.printId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseId="
            + this.warehouseId
            + ", boolPrinted="
            + this.boolPrinted
            + ", printNumber="
            + this.printNumber
            + ", printShareNumber="
            + this.printShareNumber
            + ", notPrintNumber="
            + this.notPrintNumber
            + ", printerId="
            + this.printerId
            + ", printerName="
            + this.printerName
            + ", printTime="
            + this.printTime
            + ", projectId="
            + this.projectId
            + ", barcode="
            + this.barcode
            + ", type="
            + this.type
            + ", boolPartyA="
            + this.boolPartyA
            + ", color="
            + this.color
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", receiptDetailId="
            + this.receiptDetailId
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
