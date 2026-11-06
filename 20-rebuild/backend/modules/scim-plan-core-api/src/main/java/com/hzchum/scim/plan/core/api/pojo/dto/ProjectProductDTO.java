package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ProjectProductDTO", description = "区域下产品计划详情返回类(构件和围护)")
public class ProjectProductDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "plan", value = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   @JsonInclude(Include.NON_NULL)
   private EnclosurePlanDTO plan;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(name = "productId", value = "产品ID")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件 2构件 4围护 8配套件 16 围护 32 原材料", notes = "产品类型 1零件 2构件 4围护 8配套件 16 围护 32 原材料")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @JsonInclude(Include.NON_NULL)
   private Integer category;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   @JsonInclude(Include.NON_NULL)
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @JsonInclude(Include.NON_NULL)
   private String color;
   @ApiModelProperty(name = "weight", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @ApiModelProperty(name = "coating", value = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   @JsonInclude(Include.NON_NULL)
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @JsonProperty("plating")
   @JSONField(name = "plating")
   @JsonInclude(Include.NON_NULL)
   private String plating;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "canDivideQuantity", notes = "产品总数")
   @JsonProperty("canDivideQuantity")
   @JSONField(name = "canDivideQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer canDivideQuantity;
   @ApiModelProperty(name = "actualQuantity", value = "数量")
   @JsonProperty("actualQuantity")
   @JSONField(name = "actualQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer actualQuantity;
   @ApiModelProperty(name = "mete", value = "总量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @JsonInclude(Include.NON_NULL)
   private String measureUnit;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   @JsonInclude(Include.NON_NULL)
   private NameInfo process;
   @ApiModelProperty(name = "userName", value = "办理人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @JsonInclude(Include.NON_NULL)
   private String userName;
   @ApiModelProperty(name = "receivedDate", notes = "收货日期")
   @JsonProperty("receivedDate")
   @JSONField(name = "receivedDate")
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime receivedDate;
   @ApiModelProperty(name = "actualReceivedMete", value = "原材料实际收货量 ", notes = "原材料实际收货量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "measurePrecision", value = "计量单位精度 ", notes = "收货核算量")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingPrecision", value = "核算单位精度 ", notes = "核算单位精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "basicClass", value = "材料类型", notes = "材料类型")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", notes = "科目id")
   private Long classifyId;
   @ApiModelProperty(name = "purchaseSn", value = "采购合同号", notes = "采购合同号")
   private String purchaseSn;
   @ApiModelProperty(name = "purchaseDetailsId", value = "采购详情id", notes = "采购详情id")
   private Long purchaseDetailsId;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "createTime", value = "收货时间")
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   private NameInfo supplier;
   @JsonInclude(Include.NON_NULL)
   private NameInfo batch;
   @ApiModelProperty(name = "canRejectQuantity", value = "可退货数量 ", notes = "可退货数量")
   private BigDecimal canRejectQuantity = BigDecimal.ZERO;
   @ApiModelProperty(name = "canRejectMete", value = "可退货核算量 ", notes = "可退货核算量")
   private BigDecimal canRejectMete;
   @ApiModelProperty(name = "canRejectActualReceivedMete", value = "可退货实际退货量 ", notes = "可退货实际退货量")
   private BigDecimal canRejectActualReceivedMete;
   @ApiModelProperty(name = "rejectQuantity", value = "退货量 ", notes = "退货量")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量 ", notes = "实际退货量")
   private BigDecimal rejectActualReceivedMete;
   @ApiModelProperty(name = "enclosurePlanId", value = "批次id ", notes = "批次id")
   private Long enclosurePlanId;

   public static ProjectProductDTO.ProjectProductDTOBuilder builder() {
      return new ProjectProductDTO.ProjectProductDTOBuilder();
   }

   public ProjectProductDTO() {
   }

   public ProjectProductDTO(
      final Long id,
      final ProjectInfo project,
      final EnclosurePlanDTO plan,
      final NameInfo monomer,
      final Long monomerId,
      final Long areaId,
      final NameInfo area,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final Integer category,
      final String brand,
      final String plate,
      final String color,
      final BigDecimal weight,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer canDivideQuantity,
      final Integer actualQuantity,
      final BigDecimal mete,
      final String accountingUnit,
      final String measureUnit,
      final NameInfo process,
      final String userName,
      final LocalDateTime receivedDate,
      final BigDecimal actualReceivedMete,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final Integer basicClass,
      final Long classifyId,
      final String purchaseSn,
      final Long purchaseDetailsId,
      final Integer wageQuotaType,
      final LocalDateTime createTime,
      final NameInfo supplier,
      final NameInfo batch,
      final BigDecimal canRejectQuantity,
      final BigDecimal canRejectMete,
      final BigDecimal canRejectActualReceivedMete,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final BigDecimal rejectActualReceivedMete,
      final Long enclosurePlanId
   ) {
      this.id = id;
      this.project = project;
      this.plan = plan;
      this.monomer = monomer;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.area = area;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.category = category;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.weight = weight;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.canDivideQuantity = canDivideQuantity;
      this.actualQuantity = actualQuantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.measureUnit = measureUnit;
      this.process = process;
      this.userName = userName;
      this.receivedDate = receivedDate;
      this.actualReceivedMete = actualReceivedMete;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.purchaseSn = purchaseSn;
      this.purchaseDetailsId = purchaseDetailsId;
      this.wageQuotaType = wageQuotaType;
      this.createTime = createTime;
      this.supplier = supplier;
      this.batch = batch;
      this.canRejectQuantity = canRejectQuantity;
      this.canRejectMete = canRejectMete;
      this.canRejectActualReceivedMete = canRejectActualReceivedMete;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      this.enclosurePlanId = enclosurePlanId;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public EnclosurePlanDTO getPlan() {
      return this.plan;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getCanDivideQuantity() {
      return this.canDivideQuantity;
   }

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getReceivedDate() {
      return this.receivedDate;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public Long getPurchaseDetailsId() {
      return this.purchaseDetailsId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public NameInfo getSupplier() {
      return this.supplier;
   }

   public NameInfo getBatch() {
      return this.batch;
   }

   public BigDecimal getCanRejectQuantity() {
      return this.canRejectQuantity;
   }

   public BigDecimal getCanRejectMete() {
      return this.canRejectMete;
   }

   public BigDecimal getCanRejectActualReceivedMete() {
      return this.canRejectActualReceivedMete;
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

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   @JsonProperty("id")
   public ProjectProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public ProjectProductDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("plan")
   public ProjectProductDTO setPlan(final EnclosurePlanDTO plan) {
      this.plan = plan;
      return this;
   }

   public ProjectProductDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public ProjectProductDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectProductDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectProductDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productId")
   public ProjectProductDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public ProjectProductDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ProjectProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ProjectProductDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ProjectProductDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public ProjectProductDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public ProjectProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public ProjectProductDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public ProjectProductDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("category")
   public ProjectProductDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("brand")
   public ProjectProductDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public ProjectProductDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public ProjectProductDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public ProjectProductDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public ProjectProductDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public ProjectProductDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public ProjectProductDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("width")
   public ProjectProductDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public ProjectProductDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("totalLength")
   public ProjectProductDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public ProjectProductDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("canDivideQuantity")
   public ProjectProductDTO setCanDivideQuantity(final Integer canDivideQuantity) {
      this.canDivideQuantity = canDivideQuantity;
      return this;
   }

   @JsonProperty("actualQuantity")
   public ProjectProductDTO setActualQuantity(final Integer actualQuantity) {
      this.actualQuantity = actualQuantity;
      return this;
   }

   @JsonProperty("mete")
   public ProjectProductDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("accountingUnit")
   public ProjectProductDTO setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("measureUnit")
   public ProjectProductDTO setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("process")
   public ProjectProductDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("userName")
   public ProjectProductDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("receivedDate")
   public ProjectProductDTO setReceivedDate(final LocalDateTime receivedDate) {
      this.receivedDate = receivedDate;
      return this;
   }

   public ProjectProductDTO setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
      return this;
   }

   public ProjectProductDTO setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   public ProjectProductDTO setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   public ProjectProductDTO setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public ProjectProductDTO setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public ProjectProductDTO setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   public ProjectProductDTO setPurchaseDetailsId(final Long purchaseDetailsId) {
      this.purchaseDetailsId = purchaseDetailsId;
      return this;
   }

   public ProjectProductDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   public ProjectProductDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ProjectProductDTO setSupplier(final NameInfo supplier) {
      this.supplier = supplier;
      return this;
   }

   public ProjectProductDTO setBatch(final NameInfo batch) {
      this.batch = batch;
      return this;
   }

   public ProjectProductDTO setCanRejectQuantity(final BigDecimal canRejectQuantity) {
      this.canRejectQuantity = canRejectQuantity;
      return this;
   }

   public ProjectProductDTO setCanRejectMete(final BigDecimal canRejectMete) {
      this.canRejectMete = canRejectMete;
      return this;
   }

   public ProjectProductDTO setCanRejectActualReceivedMete(final BigDecimal canRejectActualReceivedMete) {
      this.canRejectActualReceivedMete = canRejectActualReceivedMete;
      return this;
   }

   public ProjectProductDTO setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
      return this;
   }

   public ProjectProductDTO setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
      return this;
   }

   public ProjectProductDTO setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      return this;
   }

   public ProjectProductDTO setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductDTO)) {
         return false;
      }

      ProjectProductDTO other = (ProjectProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$canDivideQuantity = this.getCanDivideQuantity();
                        Object other$canDivideQuantity = other.getCanDivideQuantity();
                        if (this$canDivideQuantity == null ? other$canDivideQuantity == null : this$canDivideQuantity.equals(other$canDivideQuantity)) {
                           Object this$actualQuantity = this.getActualQuantity();
                           Object other$actualQuantity = other.getActualQuantity();
                           if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                              Object this$measurePrecision = this.getMeasurePrecision();
                              Object other$measurePrecision = other.getMeasurePrecision();
                              if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                 Object this$accountingPrecision = this.getAccountingPrecision();
                                 Object other$accountingPrecision = other.getAccountingPrecision();
                                 if (this$accountingPrecision == null
                                    ? other$accountingPrecision == null
                                    : this$accountingPrecision.equals(other$accountingPrecision)) {
                                    Object this$basicClass = this.getBasicClass();
                                    Object other$basicClass = other.getBasicClass();
                                    if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                       Object this$classifyId = this.getClassifyId();
                                       Object other$classifyId = other.getClassifyId();
                                       if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                          Object this$purchaseDetailsId = this.getPurchaseDetailsId();
                                          Object other$purchaseDetailsId = other.getPurchaseDetailsId();
                                          if (this$purchaseDetailsId == null
                                             ? other$purchaseDetailsId == null
                                             : this$purchaseDetailsId.equals(other$purchaseDetailsId)) {
                                             Object this$wageQuotaType = this.getWageQuotaType();
                                             Object other$wageQuotaType = other.getWageQuotaType();
                                             if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                Object this$enclosurePlanId = this.getEnclosurePlanId();
                                                Object other$enclosurePlanId = other.getEnclosurePlanId();
                                                if (this$enclosurePlanId == null
                                                   ? other$enclosurePlanId == null
                                                   : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                                                   Object this$project = this.getProject();
                                                   Object other$project = other.getProject();
                                                   if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                      Object this$plan = this.getPlan();
                                                      Object other$plan = other.getPlan();
                                                      if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
                                                         Object this$monomer = this.getMonomer();
                                                         Object other$monomer = other.getMonomer();
                                                         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                            Object this$area = this.getArea();
                                                            Object other$area = other.getArea();
                                                            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                               Object this$name = this.getName();
                                                               Object other$name = other.getName();
                                                               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                                        Object this$length = this.getLength();
                                                                        Object other$length = other.getLength();
                                                                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                           Object this$material = this.getMaterial();
                                                                           Object other$material = other.getMaterial();
                                                                           if (this$material == null
                                                                              ? other$material == null
                                                                              : this$material.equals(other$material)) {
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
                                                                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                    if (this$totalNetWeight == null
                                                                                       ? other$totalNetWeight == null
                                                                                       : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                       Object this$grossWeight = this.getGrossWeight();
                                                                                       Object other$grossWeight = other.getGrossWeight();
                                                                                       if (this$grossWeight == null
                                                                                          ? other$grossWeight == null
                                                                                          : this$grossWeight.equals(other$grossWeight)) {
                                                                                          Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                          Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                          if (this$totalGrossWeight == null
                                                                                             ? other$totalGrossWeight == null
                                                                                             : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                             Object this$surfaceArea = this.getSurfaceArea();
                                                                                             Object other$surfaceArea = other.getSurfaceArea();
                                                                                             if (this$surfaceArea == null
                                                                                                ? other$surfaceArea == null
                                                                                                : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                Object this$brand = this.getBrand();
                                                                                                Object other$brand = other.getBrand();
                                                                                                if (this$brand == null
                                                                                                   ? other$brand == null
                                                                                                   : this$brand.equals(other$brand)) {
                                                                                                   Object this$plate = this.getPlate();
                                                                                                   Object other$plate = other.getPlate();
                                                                                                   if (this$plate == null
                                                                                                      ? other$plate == null
                                                                                                      : this$plate.equals(other$plate)) {
                                                                                                      Object this$color = this.getColor();
                                                                                                      Object other$color = other.getColor();
                                                                                                      if (this$color == null
                                                                                                         ? other$color == null
                                                                                                         : this$color.equals(other$color)) {
                                                                                                         Object this$weight = this.getWeight();
                                                                                                         Object other$weight = other.getWeight();
                                                                                                         if (this$weight == null
                                                                                                            ? other$weight == null
                                                                                                            : this$weight.equals(other$weight)) {
                                                                                                            Object this$thickness = this.getThickness();
                                                                                                            Object other$thickness = other.getThickness();
                                                                                                            if (this$thickness == null
                                                                                                               ? other$thickness == null
                                                                                                               : this$thickness.equals(other$thickness)) {
                                                                                                               Object this$coating = this.getCoating();
                                                                                                               Object other$coating = other.getCoating();
                                                                                                               if (this$coating == null
                                                                                                                  ? other$coating == null
                                                                                                                  : this$coating.equals(other$coating)) {
                                                                                                                  Object this$plating = this.getPlating();
                                                                                                                  Object other$plating = other.getPlating();
                                                                                                                  if (this$plating == null
                                                                                                                     ? other$plating == null
                                                                                                                     : this$plating.equals(other$plating)) {
                                                                                                                     Object this$width = this.getWidth();
                                                                                                                     Object other$width = other.getWidth();
                                                                                                                     if (this$width == null
                                                                                                                        ? other$width == null
                                                                                                                        : this$width.equals(other$width)) {
                                                                                                                        Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                                                        Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                                                        if (this$unfoldedWidth == null
                                                                                                                           ? other$unfoldedWidth == null
                                                                                                                           : this$unfoldedWidth.equals(
                                                                                                                              other$unfoldedWidth
                                                                                                                           )) {
                                                                                                                           Object this$totalLength = this.getTotalLength();
                                                                                                                           Object other$totalLength = other.getTotalLength();
                                                                                                                           if (this$totalLength == null
                                                                                                                              ? other$totalLength == null
                                                                                                                              : this$totalLength.equals(
                                                                                                                                 other$totalLength
                                                                                                                              )) {
                                                                                                                              Object this$totalArea = this.getTotalArea();
                                                                                                                              Object other$totalArea = other.getTotalArea();
                                                                                                                              if (this$totalArea == null
                                                                                                                                 ? other$totalArea == null
                                                                                                                                 : this$totalArea.equals(
                                                                                                                                    other$totalArea
                                                                                                                                 )) {
                                                                                                                                 Object this$mete = this.getMete();
                                                                                                                                 Object other$mete = other.getMete();
                                                                                                                                 if (this$mete == null
                                                                                                                                    ? other$mete == null
                                                                                                                                    : this$mete.equals(
                                                                                                                                       other$mete
                                                                                                                                    )) {
                                                                                                                                    Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                                    Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                                    if (this$accountingUnit
                                                                                                                                          == null
                                                                                                                                       ? other$accountingUnit
                                                                                                                                          == null
                                                                                                                                       : this$accountingUnit.equals(
                                                                                                                                          other$accountingUnit
                                                                                                                                       )) {
                                                                                                                                       Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                       Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                       if (this$measureUnit
                                                                                                                                             == null
                                                                                                                                          ? other$measureUnit
                                                                                                                                             == null
                                                                                                                                          : this$measureUnit.equals(
                                                                                                                                             other$measureUnit
                                                                                                                                          )) {
                                                                                                                                          Object this$process = this.getProcess();
                                                                                                                                          Object other$process = other.getProcess();
                                                                                                                                          if (this$process
                                                                                                                                                == null
                                                                                                                                             ? other$process
                                                                                                                                                == null
                                                                                                                                             : this$process.equals(
                                                                                                                                                other$process
                                                                                                                                             )) {
                                                                                                                                             Object this$userName = this.getUserName();
                                                                                                                                             Object other$userName = other.getUserName();
                                                                                                                                             if (this$userName
                                                                                                                                                   == null
                                                                                                                                                ? other$userName
                                                                                                                                                   == null
                                                                                                                                                : this$userName.equals(
                                                                                                                                                   other$userName
                                                                                                                                                )) {
                                                                                                                                                Object this$receivedDate = this.getReceivedDate();
                                                                                                                                                Object other$receivedDate = other.getReceivedDate();
                                                                                                                                                if (this$receivedDate
                                                                                                                                                      == null
                                                                                                                                                   ? other$receivedDate
                                                                                                                                                      == null
                                                                                                                                                   : this$receivedDate.equals(
                                                                                                                                                      other$receivedDate
                                                                                                                                                   )) {
                                                                                                                                                   Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                                                                                                   Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                                                                                                   if (this$actualReceivedMete
                                                                                                                                                         == null
                                                                                                                                                      ? other$actualReceivedMete
                                                                                                                                                         == null
                                                                                                                                                      : this$actualReceivedMete.equals(
                                                                                                                                                         other$actualReceivedMete
                                                                                                                                                      )) {
                                                                                                                                                      Object this$purchaseSn = this.getPurchaseSn();
                                                                                                                                                      Object other$purchaseSn = other.getPurchaseSn();
                                                                                                                                                      if (this$purchaseSn
                                                                                                                                                            == null
                                                                                                                                                         ? other$purchaseSn
                                                                                                                                                            == null
                                                                                                                                                         : this$purchaseSn.equals(
                                                                                                                                                            other$purchaseSn
                                                                                                                                                         )) {
                                                                                                                                                         Object this$createTime = this.getCreateTime();
                                                                                                                                                         Object other$createTime = other.getCreateTime();
                                                                                                                                                         if (this$createTime
                                                                                                                                                               == null
                                                                                                                                                            ? other$createTime
                                                                                                                                                               == null
                                                                                                                                                            : this$createTime.equals(
                                                                                                                                                               other$createTime
                                                                                                                                                            )) {
                                                                                                                                                            Object this$supplier = this.getSupplier();
                                                                                                                                                            Object other$supplier = other.getSupplier();
                                                                                                                                                            if (this$supplier
                                                                                                                                                                  == null
                                                                                                                                                               ? other$supplier
                                                                                                                                                                  == null
                                                                                                                                                               : this$supplier.equals(
                                                                                                                                                                  other$supplier
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$batch = this.getBatch();
                                                                                                                                                               Object other$batch = other.getBatch();
                                                                                                                                                               if (this$batch
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$batch
                                                                                                                                                                     == null
                                                                                                                                                                  : this$batch.equals(
                                                                                                                                                                     other$batch
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$canRejectQuantity = this.getCanRejectQuantity();
                                                                                                                                                                  Object other$canRejectQuantity = other.getCanRejectQuantity();
                                                                                                                                                                  if (this$canRejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$canRejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     : this$canRejectQuantity.equals(
                                                                                                                                                                        other$canRejectQuantity
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$canRejectMete = this.getCanRejectMete();
                                                                                                                                                                     Object other$canRejectMete = other.getCanRejectMete();
                                                                                                                                                                     if (this$canRejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$canRejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        : this$canRejectMete.equals(
                                                                                                                                                                           other$canRejectMete
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$canRejectActualReceivedMete = this.getCanRejectActualReceivedMete();
                                                                                                                                                                        Object other$canRejectActualReceivedMete = other.getCanRejectActualReceivedMete();
                                                                                                                                                                        if (this$canRejectActualReceivedMete
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$canRejectActualReceivedMete
                                                                                                                                                                              == null
                                                                                                                                                                           : this$canRejectActualReceivedMete.equals(
                                                                                                                                                                              other$canRejectActualReceivedMete
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                                                                           Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                                                                           if (this$rejectQuantity
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$rejectQuantity
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$rejectQuantity.equals(
                                                                                                                                                                                 other$rejectQuantity
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$rejectMete = this.getRejectMete();
                                                                                                                                                                              Object other$rejectMete = other.getRejectMete();
                                                                                                                                                                              if (this$rejectMete
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$rejectMete
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$rejectMete.equals(
                                                                                                                                                                                    other$rejectMete
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
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
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $canDivideQuantity = this.getCanDivideQuantity();
      result = result * 59 + ($canDivideQuantity == null ? 43 : $canDivideQuantity.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $purchaseDetailsId = this.getPurchaseDetailsId();
      result = result * 59 + ($purchaseDetailsId == null ? 43 : $purchaseDetailsId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $receivedDate = this.getReceivedDate();
      result = result * 59 + ($receivedDate == null ? 43 : $receivedDate.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $batch = this.getBatch();
      result = result * 59 + ($batch == null ? 43 : $batch.hashCode());
      Object $canRejectQuantity = this.getCanRejectQuantity();
      result = result * 59 + ($canRejectQuantity == null ? 43 : $canRejectQuantity.hashCode());
      Object $canRejectMete = this.getCanRejectMete();
      result = result * 59 + ($canRejectMete == null ? 43 : $canRejectMete.hashCode());
      Object $canRejectActualReceivedMete = this.getCanRejectActualReceivedMete();
      result = result * 59 + ($canRejectActualReceivedMete == null ? 43 : $canRejectActualReceivedMete.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      return result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", plan="
         + this.getPlan()
         + ", monomer="
         + this.getMonomer()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", category="
         + this.getCategory()
         + ", brand="
         + this.getBrand()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", canDivideQuantity="
         + this.getCanDivideQuantity()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", process="
         + this.getProcess()
         + ", userName="
         + this.getUserName()
         + ", receivedDate="
         + this.getReceivedDate()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", purchaseDetailsId="
         + this.getPurchaseDetailsId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", createTime="
         + this.getCreateTime()
         + ", supplier="
         + this.getSupplier()
         + ", batch="
         + this.getBatch()
         + ", canRejectQuantity="
         + this.getCanRejectQuantity()
         + ", canRejectMete="
         + this.getCanRejectMete()
         + ", canRejectActualReceivedMete="
         + this.getCanRejectActualReceivedMete()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ")";
   }

   public static class ProjectProductDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private EnclosurePlanDTO plan;
      private NameInfo monomer;
      private Long monomerId;
      private Long areaId;
      private NameInfo area;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private Integer category;
      private String brand;
      private String plate;
      private String color;
      private BigDecimal weight;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer canDivideQuantity;
      private Integer actualQuantity;
      private BigDecimal mete;
      private String accountingUnit;
      private String measureUnit;
      private NameInfo process;
      private String userName;
      private LocalDateTime receivedDate;
      private BigDecimal actualReceivedMete;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private Integer basicClass;
      private Long classifyId;
      private String purchaseSn;
      private Long purchaseDetailsId;
      private Integer wageQuotaType;
      private LocalDateTime createTime;
      private NameInfo supplier;
      private NameInfo batch;
      private BigDecimal canRejectQuantity;
      private BigDecimal canRejectMete;
      private BigDecimal canRejectActualReceivedMete;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private BigDecimal rejectActualReceivedMete;
      private Long enclosurePlanId;

      ProjectProductDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectProductDTO.ProjectProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public ProjectProductDTO.ProjectProductDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("plan")
      public ProjectProductDTO.ProjectProductDTOBuilder plan(final EnclosurePlanDTO plan) {
         this.plan = plan;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productId")
      public ProjectProductDTO.ProjectProductDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public ProjectProductDTO.ProjectProductDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("category")
      public ProjectProductDTO.ProjectProductDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("brand")
      public ProjectProductDTO.ProjectProductDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public ProjectProductDTO.ProjectProductDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public ProjectProductDTO.ProjectProductDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public ProjectProductDTO.ProjectProductDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public ProjectProductDTO.ProjectProductDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public ProjectProductDTO.ProjectProductDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public ProjectProductDTO.ProjectProductDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("width")
      public ProjectProductDTO.ProjectProductDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public ProjectProductDTO.ProjectProductDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      @JsonProperty("totalLength")
      public ProjectProductDTO.ProjectProductDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectProductDTO.ProjectProductDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("canDivideQuantity")
      public ProjectProductDTO.ProjectProductDTOBuilder canDivideQuantity(final Integer canDivideQuantity) {
         this.canDivideQuantity = canDivideQuantity;
         return this;
      }

      @JsonProperty("actualQuantity")
      public ProjectProductDTO.ProjectProductDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectProductDTO.ProjectProductDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ProjectProductDTO.ProjectProductDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("measureUnit")
      public ProjectProductDTO.ProjectProductDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("process")
      public ProjectProductDTO.ProjectProductDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("userName")
      public ProjectProductDTO.ProjectProductDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("receivedDate")
      public ProjectProductDTO.ProjectProductDTOBuilder receivedDate(final LocalDateTime receivedDate) {
         this.receivedDate = receivedDate;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder purchaseDetailsId(final Long purchaseDetailsId) {
         this.purchaseDetailsId = purchaseDetailsId;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder supplier(final NameInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder batch(final NameInfo batch) {
         this.batch = batch;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder canRejectQuantity(final BigDecimal canRejectQuantity) {
         this.canRejectQuantity = canRejectQuantity;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder canRejectMete(final BigDecimal canRejectMete) {
         this.canRejectMete = canRejectMete;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder canRejectActualReceivedMete(final BigDecimal canRejectActualReceivedMete) {
         this.canRejectActualReceivedMete = canRejectActualReceivedMete;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ProjectProductDTO.ProjectProductDTOBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public ProjectProductDTO build() {
         return new ProjectProductDTO(
            this.id,
            this.project,
            this.plan,
            this.monomer,
            this.monomerId,
            this.areaId,
            this.area,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.category,
            this.brand,
            this.plate,
            this.color,
            this.weight,
            this.thickness,
            this.coating,
            this.plating,
            this.width,
            this.unfoldedWidth,
            this.totalLength,
            this.totalArea,
            this.canDivideQuantity,
            this.actualQuantity,
            this.mete,
            this.accountingUnit,
            this.measureUnit,
            this.process,
            this.userName,
            this.receivedDate,
            this.actualReceivedMete,
            this.measurePrecision,
            this.accountingPrecision,
            this.basicClass,
            this.classifyId,
            this.purchaseSn,
            this.purchaseDetailsId,
            this.wageQuotaType,
            this.createTime,
            this.supplier,
            this.batch,
            this.canRejectQuantity,
            this.canRejectMete,
            this.canRejectActualReceivedMete,
            this.rejectQuantity,
            this.rejectMete,
            this.rejectActualReceivedMete,
            this.enclosurePlanId
         );
      }

      @Override
      public String toString() {
         return "ProjectProductDTO.ProjectProductDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", plan="
            + this.plan
            + ", monomer="
            + this.monomer
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", category="
            + this.category
            + ", brand="
            + this.brand
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", canDivideQuantity="
            + this.canDivideQuantity
            + ", actualQuantity="
            + this.actualQuantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", measureUnit="
            + this.measureUnit
            + ", process="
            + this.process
            + ", userName="
            + this.userName
            + ", receivedDate="
            + this.receivedDate
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", purchaseSn="
            + this.purchaseSn
            + ", purchaseDetailsId="
            + this.purchaseDetailsId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", createTime="
            + this.createTime
            + ", supplier="
            + this.supplier
            + ", batch="
            + this.batch
            + ", canRejectQuantity="
            + this.canRejectQuantity
            + ", canRejectMete="
            + this.canRejectMete
            + ", canRejectActualReceivedMete="
            + this.canRejectActualReceivedMete
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ")";
      }
   }
}
