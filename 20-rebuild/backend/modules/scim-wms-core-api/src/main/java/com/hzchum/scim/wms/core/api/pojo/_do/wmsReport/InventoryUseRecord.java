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

@ApiModel(value = "InventoryUseRecord对象", description = "库存使用记录")
@Entity
@TableName("wms_inventory_use_record")
@Table(name = "wms_inventory_use_record")
public class InventoryUseRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(
      name = "inventoryUseStatisticsId",
      value = "库存使用统计表ID（在结存的时候有可能会改变，因为可以结存之前的时间段，所以结存后老的数据要指向新的统计ID）",
      notes = "库存使用统计表ID（在结存的时候有可能会改变，因为可以结存之前的时间段，所以结存后老的数据要指向新的统计ID）"
   )
   @JsonProperty("inventoryUseStatisticsId")
   @JSONField(name = "inventoryUseStatisticsId")
   @TableField("inventory_use_statistics_id")
   @Column(
      name = "inventory_use_statistics_id",
      columnDefinition = "bigint  COMMENT '库存使用统计表ID（在结存的时候有可能会改变，因为可以结存之前的时间段，所以结存后老的数据要指向新的统计ID）'",
      nullable = true
   )
   private Long inventoryUseStatisticsId;
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
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "model", value = "型号", notes = "型号")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)", notes = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态(1 整料, 余料)'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]", notes = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型[1 公共库,2 项目库]'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
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
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
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
   @Column(name = "color", columnDefinition = "varchar(128)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,12)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
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
   @ApiModelProperty(name = "serialNumber", value = "物料编号", notes = "物料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID -> wms", notes = "仓库位置ID -> wms")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID -> wms'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "useType", value = "使用类型 ReceiptTypeEnum", notes = "使用类型 ReceiptTypeEnum")
   @JsonProperty("useType")
   @JSONField(name = "useType")
   @TableField("use_type")
   @Column(name = "use_type", columnDefinition = "int  COMMENT '使用类型 ReceiptTypeEnum'", nullable = true)
   private Integer useType;
   @ApiModelProperty(name = "embodyType", value = "体现类型 1体现入库 2体现出库 3体现调拨", notes = "体现类型 1体现入库 2体现出库 3体现调拨")
   @JsonProperty("embodyType")
   @JSONField(name = "embodyType")
   @TableField("embody_type")
   @Column(name = "embody_type", columnDefinition = "int  COMMENT '体现类型 1体现入库 2体现出库 3体现调拨'", nullable = true)
   private Integer embodyType;
   @ApiModelProperty(name = "dataId", value = "单据编号", notes = "单据编号")
   @JsonProperty("dataId")
   @JSONField(name = "dataId")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint COMMENT '单据编号'", nullable = true)
   private Long dataId;
   @ApiModelProperty(name = "useOrderSerialNumber", value = "使用类型单子编号", notes = "使用类型单子编号")
   @JsonProperty("useOrderSerialNumber")
   @JSONField(name = "useOrderSerialNumber")
   @TableField("use_order_serial_number")
   @Column(name = "use_order_serial_number", columnDefinition = "varchar(255) COMMENT '使用类型单子编号'", nullable = true)
   private String useOrderSerialNumber;

   public static InventoryUseRecord.InventoryUseRecordBuilder builder() {
      return new InventoryUseRecord.InventoryUseRecordBuilder();
   }

   public InventoryUseRecord() {
   }

   public InventoryUseRecord(
      final Long id,
      final Long inventoryUseStatisticsId,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final String model,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final Boolean boolPartyA,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal unitNet,
      final BigDecimal quantity,
      final BigDecimal mete,
      final Long standardId,
      final String standardName,
      final String serialNumber,
      final Long workshopId,
      final Long warehouseId,
      final Integer useType,
      final Integer embodyType,
      final Long dataId,
      final String useOrderSerialNumber
   ) {
      this.id = id;
      this.inventoryUseStatisticsId = inventoryUseStatisticsId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.model = model;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.unitNet = unitNet;
      this.quantity = quantity;
      this.mete = mete;
      this.standardId = standardId;
      this.standardName = standardName;
      this.serialNumber = serialNumber;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.useType = useType;
      this.embodyType = embodyType;
      this.dataId = dataId;
      this.useOrderSerialNumber = useOrderSerialNumber;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInventoryUseStatisticsId() {
      return this.inventoryUseStatisticsId;
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

   public String getModel() {
      return this.model;
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

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getUseType() {
      return this.useType;
   }

   public Integer getEmbodyType() {
      return this.embodyType;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public String getUseOrderSerialNumber() {
      return this.useOrderSerialNumber;
   }

   @JsonProperty("id")
   public InventoryUseRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inventoryUseStatisticsId")
   public InventoryUseRecord setInventoryUseStatisticsId(final Long inventoryUseStatisticsId) {
      this.inventoryUseStatisticsId = inventoryUseStatisticsId;
      return this;
   }

   @JsonProperty("basicClass")
   public InventoryUseRecord setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public InventoryUseRecord setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public InventoryUseRecord setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public InventoryUseRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("model")
   public InventoryUseRecord setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public InventoryUseRecord setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public InventoryUseRecord setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public InventoryUseRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public InventoryUseRecord setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("length")
   public InventoryUseRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public InventoryUseRecord setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public InventoryUseRecord setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public InventoryUseRecord setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public InventoryUseRecord setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public InventoryUseRecord setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public InventoryUseRecord setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("unitNet")
   public InventoryUseRecord setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("quantity")
   public InventoryUseRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public InventoryUseRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("standardId")
   public InventoryUseRecord setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public InventoryUseRecord setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("serialNumber")
   public InventoryUseRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("workshopId")
   public InventoryUseRecord setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("warehouseId")
   public InventoryUseRecord setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("useType")
   public InventoryUseRecord setUseType(final Integer useType) {
      this.useType = useType;
      return this;
   }

   @JsonProperty("embodyType")
   public InventoryUseRecord setEmbodyType(final Integer embodyType) {
      this.embodyType = embodyType;
      return this;
   }

   @JsonProperty("dataId")
   public InventoryUseRecord setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   @JsonProperty("useOrderSerialNumber")
   public InventoryUseRecord setUseOrderSerialNumber(final String useOrderSerialNumber) {
      this.useOrderSerialNumber = useOrderSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "InventoryUseRecord(id="
         + this.getId()
         + ", inventoryUseStatisticsId="
         + this.getInventoryUseStatisticsId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", unitNet="
         + this.getUnitNet()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", useType="
         + this.getUseType()
         + ", embodyType="
         + this.getEmbodyType()
         + ", dataId="
         + this.getDataId()
         + ", useOrderSerialNumber="
         + this.getUseOrderSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseRecord)) {
         return false;
      }

      InventoryUseRecord other = (InventoryUseRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inventoryUseStatisticsId = this.getInventoryUseStatisticsId();
         Object other$inventoryUseStatisticsId = other.getInventoryUseStatisticsId();
         if (this$inventoryUseStatisticsId == null
            ? other$inventoryUseStatisticsId == null
            : this$inventoryUseStatisticsId.equals(other$inventoryUseStatisticsId)) {
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
                           Object this$boolPartyA = this.getBoolPartyA();
                           Object other$boolPartyA = other.getBoolPartyA();
                           if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$workshopId = this.getWorkshopId();
                                 Object other$workshopId = other.getWorkshopId();
                                 if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$useType = this.getUseType();
                                       Object other$useType = other.getUseType();
                                       if (this$useType == null ? other$useType == null : this$useType.equals(other$useType)) {
                                          Object this$embodyType = this.getEmbodyType();
                                          Object other$embodyType = other.getEmbodyType();
                                          if (this$embodyType == null ? other$embodyType == null : this$embodyType.equals(other$embodyType)) {
                                             Object this$dataId = this.getDataId();
                                             Object other$dataId = other.getDataId();
                                             if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                                                Object this$classifyName = this.getClassifyName();
                                                Object other$classifyName = other.getClassifyName();
                                                if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$model = this.getModel();
                                                      Object other$model = other.getModel();
                                                      if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$width = this.getWidth();
                                                            Object other$width = other.getWidth();
                                                            if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                        if (this$heatNoAndBatchNo == null
                                                                           ? other$heatNoAndBatchNo == null
                                                                           : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$unitNet = this.getUnitNet();
                                                                              Object other$unitNet = other.getUnitNet();
                                                                              if (this$unitNet == null
                                                                                 ? other$unitNet == null
                                                                                 : this$unitNet.equals(other$unitNet)) {
                                                                                 Object this$quantity = this.getQuantity();
                                                                                 Object other$quantity = other.getQuantity();
                                                                                 if (this$quantity == null
                                                                                    ? other$quantity == null
                                                                                    : this$quantity.equals(other$quantity)) {
                                                                                    Object this$mete = this.getMete();
                                                                                    Object other$mete = other.getMete();
                                                                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                       Object this$standardName = this.getStandardName();
                                                                                       Object other$standardName = other.getStandardName();
                                                                                       if (this$standardName == null
                                                                                          ? other$standardName == null
                                                                                          : this$standardName.equals(other$standardName)) {
                                                                                          Object this$serialNumber = this.getSerialNumber();
                                                                                          Object other$serialNumber = other.getSerialNumber();
                                                                                          if (this$serialNumber == null
                                                                                             ? other$serialNumber == null
                                                                                             : this$serialNumber.equals(other$serialNumber)) {
                                                                                             Object this$useOrderSerialNumber = this.getUseOrderSerialNumber();
                                                                                             Object other$useOrderSerialNumber = other.getUseOrderSerialNumber();
                                                                                             return this$useOrderSerialNumber == null
                                                                                                ? other$useOrderSerialNumber == null
                                                                                                : this$useOrderSerialNumber.equals(other$useOrderSerialNumber);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof InventoryUseRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inventoryUseStatisticsId = this.getInventoryUseStatisticsId();
      result = result * 59 + ($inventoryUseStatisticsId == null ? 43 : $inventoryUseStatisticsId.hashCode());
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $useType = this.getUseType();
      result = result * 59 + ($useType == null ? 43 : $useType.hashCode());
      Object $embodyType = this.getEmbodyType();
      result = result * 59 + ($embodyType == null ? 43 : $embodyType.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $useOrderSerialNumber = this.getUseOrderSerialNumber();
      return result * 59 + ($useOrderSerialNumber == null ? 43 : $useOrderSerialNumber.hashCode());
   }

   public static class InventoryUseRecordBuilder {
      private Long id;
      private Long inventoryUseStatisticsId;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private String model;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private Boolean boolPartyA;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal unitNet;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Long standardId;
      private String standardName;
      private String serialNumber;
      private Long workshopId;
      private Long warehouseId;
      private Integer useType;
      private Integer embodyType;
      private Long dataId;
      private String useOrderSerialNumber;

      InventoryUseRecordBuilder() {
      }

      @JsonProperty("id")
      public InventoryUseRecord.InventoryUseRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inventoryUseStatisticsId")
      public InventoryUseRecord.InventoryUseRecordBuilder inventoryUseStatisticsId(final Long inventoryUseStatisticsId) {
         this.inventoryUseStatisticsId = inventoryUseStatisticsId;
         return this;
      }

      @JsonProperty("basicClass")
      public InventoryUseRecord.InventoryUseRecordBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public InventoryUseRecord.InventoryUseRecordBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public InventoryUseRecord.InventoryUseRecordBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public InventoryUseRecord.InventoryUseRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("model")
      public InventoryUseRecord.InventoryUseRecordBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public InventoryUseRecord.InventoryUseRecordBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public InventoryUseRecord.InventoryUseRecordBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public InventoryUseRecord.InventoryUseRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public InventoryUseRecord.InventoryUseRecordBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("length")
      public InventoryUseRecord.InventoryUseRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public InventoryUseRecord.InventoryUseRecordBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public InventoryUseRecord.InventoryUseRecordBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public InventoryUseRecord.InventoryUseRecordBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public InventoryUseRecord.InventoryUseRecordBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public InventoryUseRecord.InventoryUseRecordBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public InventoryUseRecord.InventoryUseRecordBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("unitNet")
      public InventoryUseRecord.InventoryUseRecordBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("quantity")
      public InventoryUseRecord.InventoryUseRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public InventoryUseRecord.InventoryUseRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("standardId")
      public InventoryUseRecord.InventoryUseRecordBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public InventoryUseRecord.InventoryUseRecordBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("serialNumber")
      public InventoryUseRecord.InventoryUseRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("workshopId")
      public InventoryUseRecord.InventoryUseRecordBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("warehouseId")
      public InventoryUseRecord.InventoryUseRecordBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("useType")
      public InventoryUseRecord.InventoryUseRecordBuilder useType(final Integer useType) {
         this.useType = useType;
         return this;
      }

      @JsonProperty("embodyType")
      public InventoryUseRecord.InventoryUseRecordBuilder embodyType(final Integer embodyType) {
         this.embodyType = embodyType;
         return this;
      }

      @JsonProperty("dataId")
      public InventoryUseRecord.InventoryUseRecordBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      @JsonProperty("useOrderSerialNumber")
      public InventoryUseRecord.InventoryUseRecordBuilder useOrderSerialNumber(final String useOrderSerialNumber) {
         this.useOrderSerialNumber = useOrderSerialNumber;
         return this;
      }

      public InventoryUseRecord build() {
         return new InventoryUseRecord(
            this.id,
            this.inventoryUseStatisticsId,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.model,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.boolPartyA,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.unitNet,
            this.quantity,
            this.mete,
            this.standardId,
            this.standardName,
            this.serialNumber,
            this.workshopId,
            this.warehouseId,
            this.useType,
            this.embodyType,
            this.dataId,
            this.useOrderSerialNumber
         );
      }

      @Override
      public String toString() {
         return "InventoryUseRecord.InventoryUseRecordBuilder(id="
            + this.id
            + ", inventoryUseStatisticsId="
            + this.inventoryUseStatisticsId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
            + ", boolPartyA="
            + this.boolPartyA
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", unitNet="
            + this.unitNet
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", serialNumber="
            + this.serialNumber
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", useType="
            + this.useType
            + ", embodyType="
            + this.embodyType
            + ", dataId="
            + this.dataId
            + ", useOrderSerialNumber="
            + this.useOrderSerialNumber
            + ")";
      }
   }
}
