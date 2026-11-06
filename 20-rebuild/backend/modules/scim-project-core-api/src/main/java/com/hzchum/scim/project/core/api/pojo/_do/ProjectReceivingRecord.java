package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectReceivingRecord对象", description = "项目管理收货记录表 ")
@Entity
@TableName("project_receiving_record")
@Table(name = "project_receiving_record")
@org.hibernate.annotations.Table(appliesTo = "project_receiving_record", comment = "项目管理收货记录表 ")
public class ProjectReceivingRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 2构件 4围护 8配套件'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'")
   private Integer category;
   @ApiModelProperty(name = "measureMode", notes = "计量方式 构件:1理计2磅记, 围护:1长度计量2面积计量")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11) comment '计量方式  构件:1理计2磅记, 围护:1长度计量2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '产品编号'")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '产品名称'")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64) COMMENT '材质'")
   private String material;
   @ApiModelProperty(name = "length", value = "单长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8) COMMENT '单长度(mm)'")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "围护宽度(mm)")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8) COMMENT '围护展宽(mm)'")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8) COMMENT '厚度（mm）'")
   private BigDecimal thickness;
   @ApiModelProperty(name = "quantity", value = "收货数量", notes = "收货数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '收货数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重(kg)")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8) COMMENT '单净重（kg）'")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "weight", value = "单重(kg)-根据构件计量方式决定")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default '0.0' COMMENT '单重(kg)/根据构件计量方式决定 1理论重量 2磅计'")
   private BigDecimal weight;
   @ApiModelProperty(name = "mete", value = "产品总量(重量kg/长度mm)", notes = "产品总量(重量kg/长度mm)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '产品总量(重量kg/长度mm)'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm2)", notes = "总面积(mm2)")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总面积(mm2)'")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;
   @ApiModelProperty(name = "areaType", value = "来源类型 0自制 1外协", notes = "来源类型 0自制 1外协")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type", columnDefinition = "int(11)  COMMENT '来源类型 0自制 1外协'", nullable = false)
   private Integer areaType;
   @ApiModelProperty(name = "sourceId", value = "来源id", notes = "发运表id/订单id")
   @JsonProperty("sourceId")
   @JSONField(name = "sourceId")
   @TableField("source_id")
   @Column(name = "source_id", columnDefinition = "bigint(20)  COMMENT '发运表id/订单id'", nullable = false)
   private Long sourceId;
   @ApiModelProperty(name = "source_type", value = "来源类型", notes = "参考 SourceTypeEnum")
   @JsonProperty("sourceType")
   @JSONField(name = "sourceType")
   @TableField("source_type")
   @Column(name = "source_type", columnDefinition = "int(11) default '1'  COMMENT '参考 SourceTypeEnum'", nullable = false)
   private Integer sourceType;
   @ApiModelProperty(name = "supplierId", value = "外协供应商id", notes = "外协供应商id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '外协供应商id'")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "外协供应商名称", notes = "外协供应商名称")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(64)  COMMENT '外协供应商名称'")
   private String supplierName;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ", notes = "是否问题收货 1问题收货 0正常收货")
   @JsonProperty("boolProblemReceiving")
   @JSONField(name = "boolProblemReceiving")
   @TableField("bool_problem_receiving")
   @Column(name = "bool_problem_receiving", columnDefinition = "tinyint(1)  COMMENT '是否问题收货 1问题收货 0正常收货'")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述 ", notes = "问题收货描述")
   @JsonProperty("problemDesc")
   @JSONField(name = "problemDesc")
   @TableField("problem_desc")
   @Column(name = "problem_desc", columnDefinition = "VARCHAR(1024) COMMENT '问题收货描述'")
   private String problemDesc;
   @ApiModelProperty(name = "problemId", value = "问题记录id", notes = "问题记录id")
   @JsonProperty("problemId")
   @JSONField(name = "problemId")
   @TableField("problem_id")
   @Column(name = "problem_id", columnDefinition = "bigint(20)  COMMENT '问题记录id'")
   private Long problemId;
   @ApiModelProperty(name = "purchaseDetailsId", value = "采购详情id", notes = "采购详情id")
   @JsonProperty("purchaseDetailsId")
   @JSONField(name = "purchaseDetailsId")
   @TableField("purchase_details_id")
   @Column(name = "purchase_details_id", columnDefinition = "bigint(20)  COMMENT '采购详情id'")
   private Long purchaseDetailsId;
   @ApiModelProperty(name = "operateRecordId", value = "操作记录id", notes = "操作记录id")
   @JsonProperty("operateRecordId")
   @JSONField(name = "operateRecordId")
   @TableField("operate_record_id")
   @Column(name = "operate_record_id", columnDefinition = "bigint(20)  COMMENT '操作记录id'")
   private Long operateRecordId;
   @ApiModelProperty(name = "classifyId", value = "科目id", notes = "科目id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目id'")
   private Long classifyId;
   @ApiModelProperty(name = "actualReceivedMete", value = "实际收货核算量 ", notes = "实际收货核算量")
   @JsonProperty("actualReceivedMete")
   @JSONField(name = "actualReceivedMete")
   @TableField("actual_received_mete")
   @Column(name = "actual_received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '实际收货核算量'", nullable = true)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "linkId", value = "车次详情id", notes = "车次详情id")
   @JsonProperty("linkId")
   @JSONField(name = "linkId")
   @TableField("link_id")
   @Column(name = "link_id", columnDefinition = "bigint(20)  COMMENT '车次详情id'")
   private Long linkId;
   @ApiModelProperty(name = "rejectQuantity", value = "退货量 ", notes = "退货量")
   @JsonProperty("rejectQuantity")
   @JSONField(name = "rejectQuantity")
   @TableField("reject_quantity")
   @Column(name = "reject_quantity", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '退货数量'", nullable = true)
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   @JsonProperty("rejectMete")
   @JSONField(name = "rejectMete")
   @TableField("reject_mete")
   @Column(name = "reject_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '退货核算量'", nullable = true)
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量 ", notes = "实际退货量")
   @JsonProperty("rejectActualReceivedMete")
   @JSONField(name = "rejectActualReceivedMete")
   @TableField("reject_actual_received_mete")
   @Column(name = "reject_actual_received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '实际退货量'", nullable = true)
   private BigDecimal rejectActualReceivedMete;

   public static ProjectReceivingRecord.ProjectReceivingRecordBuilder builder() {
      return new ProjectReceivingRecord.ProjectReceivingRecordBuilder();
   }

   public ProjectReceivingRecord() {
   }

   public ProjectReceivingRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Integer measureMode,
      final Long productId,
      final String serialNumber,
      final String name,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal quantity,
      final BigDecimal netWeight,
      final BigDecimal weight,
      final BigDecimal mete,
      final BigDecimal totalArea,
      final String measureUnit,
      final String accountingUnit,
      final Integer areaType,
      final Long sourceId,
      final Integer sourceType,
      final Long supplierId,
      final String supplierName,
      final Boolean boolProblemReceiving,
      final String problemDesc,
      final Long problemId,
      final Long purchaseDetailsId,
      final Long operateRecordId,
      final Long classifyId,
      final BigDecimal actualReceivedMete,
      final Long linkId,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final BigDecimal rejectActualReceivedMete
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.measureMode = measureMode;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.weight = weight;
      this.mete = mete;
      this.totalArea = totalArea;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.areaType = areaType;
      this.sourceId = sourceId;
      this.sourceType = sourceType;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.boolProblemReceiving = boolProblemReceiving;
      this.problemDesc = problemDesc;
      this.problemId = problemId;
      this.purchaseDetailsId = purchaseDetailsId;
      this.operateRecordId = operateRecordId;
      this.classifyId = classifyId;
      this.actualReceivedMete = actualReceivedMete;
      this.linkId = linkId;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   public Long getId() {
      return this.id;
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

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public Long getSourceId() {
      return this.sourceId;
   }

   public Integer getSourceType() {
      return this.sourceType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public Long getPurchaseDetailsId() {
      return this.purchaseDetailsId;
   }

   public Long getOperateRecordId() {
      return this.operateRecordId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public BigDecimal getRejectActualReceivedMete() {
      return this.rejectActualReceivedMete;
   }

   @JsonProperty("id")
   public ProjectReceivingRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectReceivingRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectReceivingRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProjectReceivingRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectReceivingRecord setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("productType")
   public ProjectReceivingRecord setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProjectReceivingRecord setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public ProjectReceivingRecord setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @JsonProperty("productId")
   public ProjectReceivingRecord setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectReceivingRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ProjectReceivingRecord setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public ProjectReceivingRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ProjectReceivingRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ProjectReceivingRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ProjectReceivingRecord setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public ProjectReceivingRecord setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public ProjectReceivingRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectReceivingRecord setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public ProjectReceivingRecord setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("mete")
   public ProjectReceivingRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("totalArea")
   public ProjectReceivingRecord setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public ProjectReceivingRecord setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectReceivingRecord setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("areaType")
   public ProjectReceivingRecord setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("sourceId")
   public ProjectReceivingRecord setSourceId(final Long sourceId) {
      this.sourceId = sourceId;
      return this;
   }

   @JsonProperty("sourceType")
   public ProjectReceivingRecord setSourceType(final Integer sourceType) {
      this.sourceType = sourceType;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectReceivingRecord setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectReceivingRecord setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("boolProblemReceiving")
   public ProjectReceivingRecord setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
      return this;
   }

   @JsonProperty("problemDesc")
   public ProjectReceivingRecord setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
      return this;
   }

   @JsonProperty("problemId")
   public ProjectReceivingRecord setProblemId(final Long problemId) {
      this.problemId = problemId;
      return this;
   }

   @JsonProperty("purchaseDetailsId")
   public ProjectReceivingRecord setPurchaseDetailsId(final Long purchaseDetailsId) {
      this.purchaseDetailsId = purchaseDetailsId;
      return this;
   }

   @JsonProperty("operateRecordId")
   public ProjectReceivingRecord setOperateRecordId(final Long operateRecordId) {
      this.operateRecordId = operateRecordId;
      return this;
   }

   @JsonProperty("classifyId")
   public ProjectReceivingRecord setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("actualReceivedMete")
   public ProjectReceivingRecord setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
      return this;
   }

   @JsonProperty("linkId")
   public ProjectReceivingRecord setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   @JsonProperty("rejectQuantity")
   public ProjectReceivingRecord setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
      return this;
   }

   @JsonProperty("rejectMete")
   public ProjectReceivingRecord setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
      return this;
   }

   @JsonProperty("rejectActualReceivedMete")
   public ProjectReceivingRecord setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectReceivingRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", measureMode="
         + this.getMeasureMode()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", weight="
         + this.getWeight()
         + ", mete="
         + this.getMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", areaType="
         + this.getAreaType()
         + ", sourceId="
         + this.getSourceId()
         + ", sourceType="
         + this.getSourceType()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", problemId="
         + this.getProblemId()
         + ", purchaseDetailsId="
         + this.getPurchaseDetailsId()
         + ", operateRecordId="
         + this.getOperateRecordId()
         + ", classifyId="
         + this.getClassifyId()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", linkId="
         + this.getLinkId()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingRecord)) {
         return false;
      }

      ProjectReceivingRecord other = (ProjectReceivingRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$measureMode = this.getMeasureMode();
                           Object other$measureMode = other.getMeasureMode();
                           if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$areaType = this.getAreaType();
                                 Object other$areaType = other.getAreaType();
                                 if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                    Object this$sourceId = this.getSourceId();
                                    Object other$sourceId = other.getSourceId();
                                    if (this$sourceId == null ? other$sourceId == null : this$sourceId.equals(other$sourceId)) {
                                       Object this$sourceType = this.getSourceType();
                                       Object other$sourceType = other.getSourceType();
                                       if (this$sourceType == null ? other$sourceType == null : this$sourceType.equals(other$sourceType)) {
                                          Object this$supplierId = this.getSupplierId();
                                          Object other$supplierId = other.getSupplierId();
                                          if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                             Object this$boolProblemReceiving = this.getBoolProblemReceiving();
                                             Object other$boolProblemReceiving = other.getBoolProblemReceiving();
                                             if (this$boolProblemReceiving == null
                                                ? other$boolProblemReceiving == null
                                                : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
                                                Object this$problemId = this.getProblemId();
                                                Object other$problemId = other.getProblemId();
                                                if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
                                                   Object this$purchaseDetailsId = this.getPurchaseDetailsId();
                                                   Object other$purchaseDetailsId = other.getPurchaseDetailsId();
                                                   if (this$purchaseDetailsId == null
                                                      ? other$purchaseDetailsId == null
                                                      : this$purchaseDetailsId.equals(other$purchaseDetailsId)) {
                                                      Object this$operateRecordId = this.getOperateRecordId();
                                                      Object other$operateRecordId = other.getOperateRecordId();
                                                      if (this$operateRecordId == null
                                                         ? other$operateRecordId == null
                                                         : this$operateRecordId.equals(other$operateRecordId)) {
                                                         Object this$classifyId = this.getClassifyId();
                                                         Object other$classifyId = other.getClassifyId();
                                                         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                            Object this$linkId = this.getLinkId();
                                                            Object other$linkId = other.getLinkId();
                                                            if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$name = this.getName();
                                                                  Object other$name = other.getName();
                                                                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                     Object this$specification = this.getSpecification();
                                                                     Object other$specification = other.getSpecification();
                                                                     if (this$specification == null
                                                                        ? other$specification == null
                                                                        : this$specification.equals(other$specification)) {
                                                                        Object this$material = this.getMaterial();
                                                                        Object other$material = other.getMaterial();
                                                                        if (this$material == null
                                                                           ? other$material == null
                                                                           : this$material.equals(other$material)) {
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
                                                                                    Object this$quantity = this.getQuantity();
                                                                                    Object other$quantity = other.getQuantity();
                                                                                    if (this$quantity == null
                                                                                       ? other$quantity == null
                                                                                       : this$quantity.equals(other$quantity)) {
                                                                                       Object this$netWeight = this.getNetWeight();
                                                                                       Object other$netWeight = other.getNetWeight();
                                                                                       if (this$netWeight == null
                                                                                          ? other$netWeight == null
                                                                                          : this$netWeight.equals(other$netWeight)) {
                                                                                          Object this$weight = this.getWeight();
                                                                                          Object other$weight = other.getWeight();
                                                                                          if (this$weight == null
                                                                                             ? other$weight == null
                                                                                             : this$weight.equals(other$weight)) {
                                                                                             Object this$mete = this.getMete();
                                                                                             Object other$mete = other.getMete();
                                                                                             if (this$mete == null
                                                                                                ? other$mete == null
                                                                                                : this$mete.equals(other$mete)) {
                                                                                                Object this$totalArea = this.getTotalArea();
                                                                                                Object other$totalArea = other.getTotalArea();
                                                                                                if (this$totalArea == null
                                                                                                   ? other$totalArea == null
                                                                                                   : this$totalArea.equals(other$totalArea)) {
                                                                                                   Object this$measureUnit = this.getMeasureUnit();
                                                                                                   Object other$measureUnit = other.getMeasureUnit();
                                                                                                   if (this$measureUnit == null
                                                                                                      ? other$measureUnit == null
                                                                                                      : this$measureUnit.equals(other$measureUnit)) {
                                                                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                                                                      if (this$accountingUnit == null
                                                                                                         ? other$accountingUnit == null
                                                                                                         : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                         Object this$supplierName = this.getSupplierName();
                                                                                                         Object other$supplierName = other.getSupplierName();
                                                                                                         if (this$supplierName == null
                                                                                                            ? other$supplierName == null
                                                                                                            : this$supplierName.equals(other$supplierName)) {
                                                                                                            Object this$problemDesc = this.getProblemDesc();
                                                                                                            Object other$problemDesc = other.getProblemDesc();
                                                                                                            if (this$problemDesc == null
                                                                                                               ? other$problemDesc == null
                                                                                                               : this$problemDesc.equals(other$problemDesc)) {
                                                                                                               Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                                                               Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                                                               if (this$actualReceivedMete == null
                                                                                                                  ? other$actualReceivedMete == null
                                                                                                                  : this$actualReceivedMete.equals(
                                                                                                                     other$actualReceivedMete
                                                                                                                  )) {
                                                                                                                  Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                  Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                  if (this$rejectQuantity == null
                                                                                                                     ? other$rejectQuantity == null
                                                                                                                     : this$rejectQuantity.equals(
                                                                                                                        other$rejectQuantity
                                                                                                                     )) {
                                                                                                                     Object this$rejectMete = this.getRejectMete();
                                                                                                                     Object other$rejectMete = other.getRejectMete();
                                                                                                                     if (this$rejectMete == null
                                                                                                                        ? other$rejectMete == null
                                                                                                                        : this$rejectMete.equals(
                                                                                                                           other$rejectMete
                                                                                                                        )) {
                                                                                                                        Object this$rejectActualReceivedMete = this.getRejectActualReceivedMete();
                                                                                                                        Object other$rejectActualReceivedMete = other.getRejectActualReceivedMete();
                                                                                                                        return this$rejectActualReceivedMete
                                                                                                                              == null
                                                                                                                           ? other$rejectActualReceivedMete
                                                                                                                              == null
                                                                                                                           : this$rejectActualReceivedMete.equals(
                                                                                                                              other$rejectActualReceivedMete
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivingRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $sourceId = this.getSourceId();
      result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
      Object $sourceType = this.getSourceType();
      result = result * 59 + ($sourceType == null ? 43 : $sourceType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $purchaseDetailsId = this.getPurchaseDetailsId();
      result = result * 59 + ($purchaseDetailsId == null ? 43 : $purchaseDetailsId.hashCode());
      Object $operateRecordId = this.getOperateRecordId();
      result = result * 59 + ($operateRecordId == null ? 43 : $operateRecordId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      return result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
   }

   public static class ProjectReceivingRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Integer measureMode;
      private Long productId;
      private String serialNumber;
      private String name;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal quantity;
      private BigDecimal netWeight;
      private BigDecimal weight;
      private BigDecimal mete;
      private BigDecimal totalArea;
      private String measureUnit;
      private String accountingUnit;
      private Integer areaType;
      private Long sourceId;
      private Integer sourceType;
      private Long supplierId;
      private String supplierName;
      private Boolean boolProblemReceiving;
      private String problemDesc;
      private Long problemId;
      private Long purchaseDetailsId;
      private Long operateRecordId;
      private Long classifyId;
      private BigDecimal actualReceivedMete;
      private Long linkId;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private BigDecimal rejectActualReceivedMete;

      ProjectReceivingRecordBuilder() {
      }

      @JsonProperty("id")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("productType")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      @JsonProperty("productId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("mete")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectReceivingRecord.ProjectReceivingRecordBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("areaType")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("sourceId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder sourceId(final Long sourceId) {
         this.sourceId = sourceId;
         return this;
      }

      @JsonProperty("sourceType")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder sourceType(final Integer sourceType) {
         this.sourceType = sourceType;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("boolProblemReceiving")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder boolProblemReceiving(final Boolean boolProblemReceiving) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      @JsonProperty("problemDesc")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      @JsonProperty("problemId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      @JsonProperty("purchaseDetailsId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder purchaseDetailsId(final Long purchaseDetailsId) {
         this.purchaseDetailsId = purchaseDetailsId;
         return this;
      }

      @JsonProperty("operateRecordId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder operateRecordId(final Long operateRecordId) {
         this.operateRecordId = operateRecordId;
         return this;
      }

      @JsonProperty("classifyId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("actualReceivedMete")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      @JsonProperty("linkId")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      @JsonProperty("rejectQuantity")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      @JsonProperty("rejectMete")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      @JsonProperty("rejectActualReceivedMete")
      public ProjectReceivingRecord.ProjectReceivingRecordBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ProjectReceivingRecord build() {
         return new ProjectReceivingRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.projectType,
            this.productType,
            this.category,
            this.measureMode,
            this.productId,
            this.serialNumber,
            this.name,
            this.specification,
            this.material,
            this.length,
            this.width,
            this.thickness,
            this.quantity,
            this.netWeight,
            this.weight,
            this.mete,
            this.totalArea,
            this.measureUnit,
            this.accountingUnit,
            this.areaType,
            this.sourceId,
            this.sourceType,
            this.supplierId,
            this.supplierName,
            this.boolProblemReceiving,
            this.problemDesc,
            this.problemId,
            this.purchaseDetailsId,
            this.operateRecordId,
            this.classifyId,
            this.actualReceivedMete,
            this.linkId,
            this.rejectQuantity,
            this.rejectMete,
            this.rejectActualReceivedMete
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivingRecord.ProjectReceivingRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", measureMode="
            + this.measureMode
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", weight="
            + this.weight
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", areaType="
            + this.areaType
            + ", sourceId="
            + this.sourceId
            + ", sourceType="
            + this.sourceType
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", boolProblemReceiving="
            + this.boolProblemReceiving
            + ", problemDesc="
            + this.problemDesc
            + ", problemId="
            + this.problemId
            + ", purchaseDetailsId="
            + this.purchaseDetailsId
            + ", operateRecordId="
            + this.operateRecordId
            + ", classifyId="
            + this.classifyId
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", linkId="
            + this.linkId
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ")";
      }
   }
}
