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

@ApiModel(value = "ProjectLaborSubsupplierOrderProductLink对象", description = "")
@Entity
@TableName("project_labor_subsupplier_order_product_link")
@Table(name = "project_labor_subsupplier_order_product_link")
public class ProjectLaborSubsupplierOrderProductLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "supplierOrderId", value = "分包id", notes = "分包id")
   @TableField("supplier_order_id")
   @Column(name = "supplier_order_id", columnDefinition = "bigint(20)  COMMENT '分包id'", nullable = true)
   private Long supplierOrderId;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商id'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) DEFAULT NULL comment '围护计划表id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '产品编号'", nullable = false)
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
   @ApiModelProperty(name = "surfaceArea", value = "单面积", notes = "单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单面积'", nullable = false)
   private BigDecimal surfaceArea;
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
   @ApiModelProperty(name = "netWeight", value = "单净重(kg)")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8) COMMENT '单净重（kg）'")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "weight", value = "单重(kg)-根据构件计量方式决定")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default '0.0' COMMENT '单重(kg)/根据构件计量方式决定 1理论重量 2磅计'")
   private BigDecimal weight;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "actualQuantity", value = "实际安装数量", notes = "实际安装数量")
   @JsonProperty("actualQuantity")
   @JSONField(name = "actualQuantity")
   @TableField("actual_quantity")
   @Column(name = "actual_quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '实际安装数量'", nullable = false)
   private BigDecimal actualQuantity;
   @ApiModelProperty(name = "mete", value = "产品总量(重量kg/长度mm)", notes = "产品总量(重量kg/长度mm)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '产品总量(重量kg/长度mm)'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "actualMete", value = "实际安装量(重量kg/长度m)", notes = "实际安装量(重量kg/长度m)")
   @JsonProperty("actualMete")
   @JSONField(name = "actualMete")
   @TableField("actual_mete")
   @Column(name = "actual_mete", columnDefinition = "decimal(32,8) default '0.00000000'  COMMENT '实际量(重量kg/长度m)'", nullable = false)
   private BigDecimal actualMete;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm2)", notes = "总面积(mm2)")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总面积(mm2)'")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "actualTotalArea", value = "实际安装面积(mm2)", notes = "实际安装面积(mm2)")
   @JsonProperty("actualTotalArea")
   @JSONField(name = "actualTotalArea")
   @TableField("actual_total_area")
   @Column(name = "actual_total_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '实际安装面积(mm2)'")
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "measureMode", notes = "计量方式 构件:1理计2磅记, 围护:1长度计量2面积计量")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11) comment '计量方式  构件:1理计2磅记, 围护:1长度计量2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;

   public static ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder builder() {
      return new ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder();
   }

   public ProjectLaborSubsupplierOrderProductLink() {
   }

   public ProjectLaborSubsupplierOrderProductLink(
      final Long id,
      final Long projectId,
      final Integer projectType,
      final Long supplierOrderId,
      final Long supplierId,
      final Long monomerId,
      final Long areaId,
      final Long enclosurePlanId,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String serialNumber,
      final String name,
      final String specification,
      final String material,
      final BigDecimal surfaceArea,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal netWeight,
      final BigDecimal weight,
      final BigDecimal quantity,
      final BigDecimal actualQuantity,
      final BigDecimal mete,
      final BigDecimal actualMete,
      final BigDecimal totalArea,
      final BigDecimal actualTotalArea,
      final Integer measureMode,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.id = id;
      this.projectId = projectId;
      this.projectType = projectType;
      this.supplierOrderId = supplierOrderId;
      this.supplierId = supplierId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.material = material;
      this.surfaceArea = surfaceArea;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.netWeight = netWeight;
      this.weight = weight;
      this.quantity = quantity;
      this.actualQuantity = actualQuantity;
      this.mete = mete;
      this.actualMete = actualMete;
      this.totalArea = totalArea;
      this.actualTotalArea = actualTotalArea;
      this.measureMode = measureMode;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Long getSupplierOrderId() {
      return this.supplierOrderId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public ProjectLaborSubsupplierOrderProductLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setSupplierOrderId(final Long supplierOrderId) {
      this.supplierOrderId = supplierOrderId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectLaborSubsupplierOrderProductLink setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ProjectLaborSubsupplierOrderProductLink setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public ProjectLaborSubsupplierOrderProductLink setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ProjectLaborSubsupplierOrderProductLink setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("actualQuantity")
   public ProjectLaborSubsupplierOrderProductLink setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
      return this;
   }

   @JsonProperty("mete")
   public ProjectLaborSubsupplierOrderProductLink setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("actualMete")
   public ProjectLaborSubsupplierOrderProductLink setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
      return this;
   }

   @JsonProperty("totalArea")
   public ProjectLaborSubsupplierOrderProductLink setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("actualTotalArea")
   public ProjectLaborSubsupplierOrderProductLink setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectLaborSubsupplierOrderProductLink setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectLaborSubsupplierOrderProductLink(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", projectType="
         + this.getProjectType()
         + ", supplierOrderId="
         + this.getSupplierOrderId()
         + ", supplierId="
         + this.getSupplierId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
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
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", netWeight="
         + this.getNetWeight()
         + ", weight="
         + this.getWeight()
         + ", quantity="
         + this.getQuantity()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", mete="
         + this.getMete()
         + ", actualMete="
         + this.getActualMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ", measureMode="
         + this.getMeasureMode()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLaborSubsupplierOrderProductLink)) {
         return false;
      }

      ProjectLaborSubsupplierOrderProductLink other = (ProjectLaborSubsupplierOrderProductLink)o;
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
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$supplierOrderId = this.getSupplierOrderId();
               Object other$supplierOrderId = other.getSupplierOrderId();
               if (this$supplierOrderId == null ? other$supplierOrderId == null : this$supplierOrderId.equals(other$supplierOrderId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$enclosurePlanId = this.getEnclosurePlanId();
                           Object other$enclosurePlanId = other.getEnclosurePlanId();
                           if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$category = this.getCategory();
                                 Object other$category = other.getCategory();
                                 if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$measureMode = this.getMeasureMode();
                                       Object other$measureMode = other.getMeasureMode();
                                       if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                      if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$width = this.getWidth();
                                                            Object other$width = other.getWidth();
                                                            if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                               Object this$thickness = this.getThickness();
                                                               Object other$thickness = other.getThickness();
                                                               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
                                                                     Object this$weight = this.getWeight();
                                                                     Object other$weight = other.getWeight();
                                                                     if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$actualQuantity = this.getActualQuantity();
                                                                           Object other$actualQuantity = other.getActualQuantity();
                                                                           if (this$actualQuantity == null
                                                                              ? other$actualQuantity == null
                                                                              : this$actualQuantity.equals(other$actualQuantity)) {
                                                                              Object this$mete = this.getMete();
                                                                              Object other$mete = other.getMete();
                                                                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                 Object this$actualMete = this.getActualMete();
                                                                                 Object other$actualMete = other.getActualMete();
                                                                                 if (this$actualMete == null
                                                                                    ? other$actualMete == null
                                                                                    : this$actualMete.equals(other$actualMete)) {
                                                                                    Object this$totalArea = this.getTotalArea();
                                                                                    Object other$totalArea = other.getTotalArea();
                                                                                    if (this$totalArea == null
                                                                                       ? other$totalArea == null
                                                                                       : this$totalArea.equals(other$totalArea)) {
                                                                                       Object this$actualTotalArea = this.getActualTotalArea();
                                                                                       Object other$actualTotalArea = other.getActualTotalArea();
                                                                                       if (this$actualTotalArea == null
                                                                                          ? other$actualTotalArea == null
                                                                                          : this$actualTotalArea.equals(other$actualTotalArea)) {
                                                                                          Object this$measureUnit = this.getMeasureUnit();
                                                                                          Object other$measureUnit = other.getMeasureUnit();
                                                                                          if (this$measureUnit == null
                                                                                             ? other$measureUnit == null
                                                                                             : this$measureUnit.equals(other$measureUnit)) {
                                                                                             Object this$accountingUnit = this.getAccountingUnit();
                                                                                             Object other$accountingUnit = other.getAccountingUnit();
                                                                                             return this$accountingUnit == null
                                                                                                ? other$accountingUnit == null
                                                                                                : this$accountingUnit.equals(other$accountingUnit);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProjectLaborSubsupplierOrderProductLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $supplierOrderId = this.getSupplierOrderId();
      result = result * 59 + ($supplierOrderId == null ? 43 : $supplierOrderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   public static class ProjectLaborSubsupplierOrderProductLinkBuilder {
      private Long id;
      private Long projectId;
      private Integer projectType;
      private Long supplierOrderId;
      private Long supplierId;
      private Long monomerId;
      private Long areaId;
      private Long enclosurePlanId;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String serialNumber;
      private String name;
      private String specification;
      private String material;
      private BigDecimal surfaceArea;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal netWeight;
      private BigDecimal weight;
      private BigDecimal quantity;
      private BigDecimal actualQuantity;
      private BigDecimal mete;
      private BigDecimal actualMete;
      private BigDecimal totalArea;
      private BigDecimal actualTotalArea;
      private Integer measureMode;
      private String measureUnit;
      private String accountingUnit;

      ProjectLaborSubsupplierOrderProductLinkBuilder() {
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder supplierOrderId(final Long supplierOrderId) {
         this.supplierOrderId = supplierOrderId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("actualQuantity")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder actualQuantity(final BigDecimal actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("actualMete")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("actualTotalArea")
      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectLaborSubsupplierOrderProductLink build() {
         return new ProjectLaborSubsupplierOrderProductLink(
            this.id,
            this.projectId,
            this.projectType,
            this.supplierOrderId,
            this.supplierId,
            this.monomerId,
            this.areaId,
            this.enclosurePlanId,
            this.productType,
            this.category,
            this.productId,
            this.serialNumber,
            this.name,
            this.specification,
            this.material,
            this.surfaceArea,
            this.length,
            this.width,
            this.thickness,
            this.netWeight,
            this.weight,
            this.quantity,
            this.actualQuantity,
            this.mete,
            this.actualMete,
            this.totalArea,
            this.actualTotalArea,
            this.measureMode,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectLaborSubsupplierOrderProductLink.ProjectLaborSubsupplierOrderProductLinkBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", projectType="
            + this.projectType
            + ", supplierOrderId="
            + this.supplierOrderId
            + ", supplierId="
            + this.supplierId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
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
            + ", surfaceArea="
            + this.surfaceArea
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", netWeight="
            + this.netWeight
            + ", weight="
            + this.weight
            + ", quantity="
            + this.quantity
            + ", actualQuantity="
            + this.actualQuantity
            + ", mete="
            + this.mete
            + ", actualMete="
            + this.actualMete
            + ", totalArea="
            + this.totalArea
            + ", actualTotalArea="
            + this.actualTotalArea
            + ", measureMode="
            + this.measureMode
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
