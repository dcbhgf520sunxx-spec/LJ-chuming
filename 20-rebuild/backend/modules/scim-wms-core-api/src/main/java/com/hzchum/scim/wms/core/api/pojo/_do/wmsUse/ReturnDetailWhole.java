package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "WmsReturnDetailWhole对象", description = "退库详情表 ")
@Entity
@TableName("wms_return_detail_whole")
@Table(name = "wms_return_detail_whole")
public class ReturnDetailWhole extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "科目编号", notes = "科目编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '科目编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "remark", value = "退库备注", notes = "退库备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '退库备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID", notes = "工厂ID")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂ID'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "materialReturnableId", value = "可退库物料ID", notes = "可退库物料ID")
   @TableField("material_returnable_id")
   @Column(name = "material_returnable_id", columnDefinition = "bigint(20)  COMMENT '可退库物料ID'", nullable = true)
   private Long materialReturnableId;
   @ApiModelProperty(name = "returnId", value = "退库单ID", notes = "退库单ID")
   @TableField("return_id")
   @Column(name = "return_id", columnDefinition = "bigint(20)  COMMENT '退库单ID'", nullable = true)
   private Long returnId;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = " 不含税总价", notes = " 不含税总价")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT ' 不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int(11)  COMMENT '发票类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态 1整料 2余料 MaterialIsWholeEnum", notes = "物料状态 1整料 2余料 MaterialIsWholeEnum")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int(11)  COMMENT '物料状态 1整料 2余料 MaterialIsWholeEnum'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint(20)  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供材料", notes = "是否为甲供材料")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供材料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint(20)  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原车间ID", notes = "原车间ID")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint(20)  COMMENT '原车间ID'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "boolReturns")
   @TableField("bool_returns")
   @Column(name = "bool_returns", columnDefinition = "bit(1)  COMMENT ''", nullable = true)
   private Boolean boolReturns;
   @ApiModelProperty(name = "boardId", value = "车间ID", notes = "车间ID")
   @TableField("board_id")
   @Column(name = "board_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long boardId;

   public static ReturnDetailWhole.ReturnDetailWholeBuilder builder() {
      return new ReturnDetailWhole.ReturnDetailWholeBuilder();
   }

   public ReturnDetailWhole() {
   }

   public ReturnDetailWhole(
      final Long id,
      final String serialNumber,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String remark,
      final Long projectId,
      final Long factoryId,
      final Long warehouseId,
      final Long materialReturnableId,
      final Long returnId,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Integer invoiceType,
      final Integer materialIsWhole,
      final BigDecimal unitPrice,
      final Long outboundId,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal taxRate,
      final BigDecimal theoryThickness,
      final Boolean boolPartyA,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final String materialSn,
      final Long workshopId,
      final Long sourceWorkshopId,
      final Boolean boolReturns,
      final Long boardId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.remark = remark;
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.warehouseId = warehouseId;
      this.materialReturnableId = materialReturnableId;
      this.returnId = returnId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.invoiceType = invoiceType;
      this.materialIsWhole = materialIsWhole;
      this.unitPrice = unitPrice;
      this.outboundId = outboundId;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.taxRate = taxRate;
      this.theoryThickness = theoryThickness;
      this.boolPartyA = boolPartyA;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.materialSn = materialSn;
      this.workshopId = workshopId;
      this.sourceWorkshopId = sourceWorkshopId;
      this.boolReturns = boolReturns;
      this.boardId = boardId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public Long getReturnId() {
      return this.returnId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
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

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public Boolean getBoolReturns() {
      return this.boolReturns;
   }

   public Long getBoardId() {
      return this.boardId;
   }

   public ReturnDetailWhole setId(final Long id) {
      this.id = id;
      return this;
   }

   public ReturnDetailWhole setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ReturnDetailWhole setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public ReturnDetailWhole setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public ReturnDetailWhole setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ReturnDetailWhole setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ReturnDetailWhole setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public ReturnDetailWhole setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   public ReturnDetailWhole setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ReturnDetailWhole setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public ReturnDetailWhole setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public ReturnDetailWhole setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public ReturnDetailWhole setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   public ReturnDetailWhole setColor(final String color) {
      this.color = color;
      return this;
   }

   public ReturnDetailWhole setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ReturnDetailWhole setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ReturnDetailWhole setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public ReturnDetailWhole setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public ReturnDetailWhole setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
      return this;
   }

   public ReturnDetailWhole setReturnId(final Long returnId) {
      this.returnId = returnId;
      return this;
   }

   public ReturnDetailWhole setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ReturnDetailWhole setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   public ReturnDetailWhole setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   public ReturnDetailWhole setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public ReturnDetailWhole setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   public ReturnDetailWhole setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public ReturnDetailWhole setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   public ReturnDetailWhole setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   public ReturnDetailWhole setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public ReturnDetailWhole setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   public ReturnDetailWhole setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   public ReturnDetailWhole setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   public ReturnDetailWhole setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   public ReturnDetailWhole setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ReturnDetailWhole setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ReturnDetailWhole setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   public ReturnDetailWhole setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public ReturnDetailWhole setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   public ReturnDetailWhole setBoolReturns(final Boolean boolReturns) {
      this.boolReturns = boolReturns;
      return this;
   }

   public ReturnDetailWhole setBoardId(final Long boardId) {
      this.boardId = boardId;
      return this;
   }

   @Override
   public String toString() {
      return "ReturnDetailWhole(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", returnId="
         + this.getReturnId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outboundId="
         + this.getOutboundId()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", taxRate="
         + this.getTaxRate()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", workshopId="
         + this.getWorkshopId()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", boolReturns="
         + this.getBoolReturns()
         + ", boardId="
         + this.getBoardId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDetailWhole)) {
         return false;
      }

      ReturnDetailWhole other = (ReturnDetailWhole)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$materialReturnableId = this.getMaterialReturnableId();
                        Object other$materialReturnableId = other.getMaterialReturnableId();
                        if (this$materialReturnableId == null
                           ? other$materialReturnableId == null
                           : this$materialReturnableId.equals(other$materialReturnableId)) {
                           Object this$returnId = this.getReturnId();
                           Object other$returnId = other.getReturnId();
                           if (this$returnId == null ? other$returnId == null : this$returnId.equals(other$returnId)) {
                              Object this$invoiceType = this.getInvoiceType();
                              Object other$invoiceType = other.getInvoiceType();
                              if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                 Object this$materialIsWhole = this.getMaterialIsWhole();
                                 Object other$materialIsWhole = other.getMaterialIsWhole();
                                 if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                    Object this$outboundId = this.getOutboundId();
                                    Object other$outboundId = other.getOutboundId();
                                    if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                                       Object this$boolPartyA = this.getBoolPartyA();
                                       Object other$boolPartyA = other.getBoolPartyA();
                                       if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$monomerId = this.getMonomerId();
                                             Object other$monomerId = other.getMonomerId();
                                             if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                Object this$areaId = this.getAreaId();
                                                Object other$areaId = other.getAreaId();
                                                if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                   Object this$workshopId = this.getWorkshopId();
                                                   Object other$workshopId = other.getWorkshopId();
                                                   if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                      Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                      Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                      if (this$sourceWorkshopId == null
                                                         ? other$sourceWorkshopId == null
                                                         : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                         Object this$boolReturns = this.getBoolReturns();
                                                         Object other$boolReturns = other.getBoolReturns();
                                                         if (this$boolReturns == null ? other$boolReturns == null : this$boolReturns.equals(other$boolReturns)) {
                                                            Object this$boardId = this.getBoardId();
                                                            Object other$boardId = other.getBoardId();
                                                            if (this$boardId == null ? other$boardId == null : this$boardId.equals(other$boardId)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
                                                                     Object this$quantity = this.getQuantity();
                                                                     Object other$quantity = other.getQuantity();
                                                                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                        Object this$mete = this.getMete();
                                                                        Object other$mete = other.getMete();
                                                                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                           Object this$unitNet = this.getUnitNet();
                                                                           Object other$unitNet = other.getUnitNet();
                                                                           if (this$unitNet == null
                                                                              ? other$unitNet == null
                                                                              : this$unitNet.equals(other$unitNet)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
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
                                                                                          Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                          Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                          if (this$heatNoAndBatchNo == null
                                                                                             ? other$heatNoAndBatchNo == null
                                                                                             : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                             Object this$color = this.getColor();
                                                                                             Object other$color = other.getColor();
                                                                                             if (this$color == null
                                                                                                ? other$color == null
                                                                                                : this$color.equals(other$color)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$amount = this.getAmount();
                                                                                                   Object other$amount = other.getAmount();
                                                                                                   if (this$amount == null
                                                                                                      ? other$amount == null
                                                                                                      : this$amount.equals(other$amount)) {
                                                                                                      Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                      Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                      if (this$amountExcludingVat == null
                                                                                                         ? other$amountExcludingVat == null
                                                                                                         : this$amountExcludingVat.equals(
                                                                                                            other$amountExcludingVat
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
                                                                                                               Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                               Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                               if (this$unitPriceExcludingVat == null
                                                                                                                  ? other$unitPriceExcludingVat == null
                                                                                                                  : this$unitPriceExcludingVat.equals(
                                                                                                                     other$unitPriceExcludingVat
                                                                                                                  )) {
                                                                                                                  Object this$taxRate = this.getTaxRate();
                                                                                                                  Object other$taxRate = other.getTaxRate();
                                                                                                                  if (this$taxRate == null
                                                                                                                     ? other$taxRate == null
                                                                                                                     : this$taxRate.equals(other$taxRate)) {
                                                                                                                     Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                     Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                     if (this$theoryThickness == null
                                                                                                                        ? other$theoryThickness == null
                                                                                                                        : this$theoryThickness.equals(
                                                                                                                           other$theoryThickness
                                                                                                                        )) {
                                                                                                                        Object this$standardName = this.getStandardName();
                                                                                                                        Object other$standardName = other.getStandardName();
                                                                                                                        if (this$standardName == null
                                                                                                                           ? other$standardName == null
                                                                                                                           : this$standardName.equals(
                                                                                                                              other$standardName
                                                                                                                           )) {
                                                                                                                           Object this$materialSn = this.getMaterialSn();
                                                                                                                           Object other$materialSn = other.getMaterialSn();
                                                                                                                           return this$materialSn == null
                                                                                                                              ? other$materialSn == null
                                                                                                                              : this$materialSn.equals(
                                                                                                                                 other$materialSn
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ReturnDetailWhole;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $returnId = this.getReturnId();
      result = result * 59 + ($returnId == null ? 43 : $returnId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $boolReturns = this.getBoolReturns();
      result = result * 59 + ($boolReturns == null ? 43 : $boolReturns.hashCode());
      Object $boardId = this.getBoardId();
      result = result * 59 + ($boardId == null ? 43 : $boardId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $materialSn = this.getMaterialSn();
      return result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
   }

   public static class ReturnDetailWholeBuilder {
      private Long id;
      private String serialNumber;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String remark;
      private Long projectId;
      private Long factoryId;
      private Long warehouseId;
      private Long materialReturnableId;
      private Long returnId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Integer invoiceType;
      private Integer materialIsWhole;
      private BigDecimal unitPrice;
      private Long outboundId;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal taxRate;
      private BigDecimal theoryThickness;
      private Boolean boolPartyA;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private String materialSn;
      private Long workshopId;
      private Long sourceWorkshopId;
      private Boolean boolReturns;
      private Long boardId;

      ReturnDetailWholeBuilder() {
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder returnId(final Long returnId) {
         this.returnId = returnId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      public ReturnDetailWhole.ReturnDetailWholeBuilder boardId(final Long boardId) {
         this.boardId = boardId;
         return this;
      }

      public ReturnDetailWhole build() {
         return new ReturnDetailWhole(
            this.id,
            this.serialNumber,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.quantity,
            this.mete,
            this.unitNet,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.remark,
            this.projectId,
            this.factoryId,
            this.warehouseId,
            this.materialReturnableId,
            this.returnId,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.invoiceType,
            this.materialIsWhole,
            this.unitPrice,
            this.outboundId,
            this.unitPriceExcludingVat,
            this.taxRate,
            this.theoryThickness,
            this.boolPartyA,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.materialSn,
            this.workshopId,
            this.sourceWorkshopId,
            this.boolReturns,
            this.boardId
         );
      }

      @Override
      public String toString() {
         return "ReturnDetailWhole.ReturnDetailWholeBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", remark="
            + this.remark
            + ", projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", warehouseId="
            + this.warehouseId
            + ", materialReturnableId="
            + this.materialReturnableId
            + ", returnId="
            + this.returnId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", invoiceType="
            + this.invoiceType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", unitPrice="
            + this.unitPrice
            + ", outboundId="
            + this.outboundId
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", taxRate="
            + this.taxRate
            + ", theoryThickness="
            + this.theoryThickness
            + ", boolPartyA="
            + this.boolPartyA
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", materialSn="
            + this.materialSn
            + ", workshopId="
            + this.workshopId
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", boolReturns="
            + this.boolReturns
            + ", boardId="
            + this.boardId
            + ")";
      }
   }
}
