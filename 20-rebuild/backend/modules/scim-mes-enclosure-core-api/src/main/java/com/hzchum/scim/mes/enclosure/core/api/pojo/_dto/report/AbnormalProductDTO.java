package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "AbnormalProductDTO", description = "异常产品信息")
public class AbnormalProductDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id")
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id")
   private Long planId;
   @ApiModelProperty("变更前的id")
   private Long oldArtifactId;
   @ApiModelProperty("变更前的编号")
   private String oldArtifactSerialNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 0否(正常状态) 1是(异常状态)")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "businessId", value = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   @TableField("business_id")
   @Column(name = "business_id")
   private Long businessId;
   @ApiModelProperty(name = "assembleId", value = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   @TableField(value = "assemble_id", exist = false)
   @Column(name = "assemble_id")
   private Long assembleId;
   @ApiModelProperty(name = "assembleSerialNumber", value = "组立号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   @TableField(value = "assemble_serial_number", exist = false)
   @Column(name = "assemble_serial_number")
   private String assembleSerialNumber;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category")
   private Integer category;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   @TableField("plate")
   @Column(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "weight", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "coating", value = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   @TableField("coating")
   @Column(name = "coating")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @JsonProperty("plating")
   @JSONField(name = "plating")
   @TableField("plating")
   @Column(name = "plating")
   private String plating;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @TableField("total_length")
   @Column(name = "total_length")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "attachmentId", value = "附件id 1,2")
   @JsonProperty("attachmentId")
   @JSONField(name = "attachmentId")
   @TableField("attachment_id")
   @Column(name = "attachment_id")
   private Long attachmentId;
   @ApiModelProperty(name = "usedQuantity", value = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "machinePartFront", value = "组立零件(翼板腹板)编号前缀")
   @JsonProperty("machinePartFront")
   @JSONField(name = "machinePartFront")
   @TableField("machine_part_front")
   @Column(name = "machine_part_front")
   private String machinePartFront;
   @ApiModelProperty(name = "machinePartId", value = "组立对应零件id(非翼板腹板)")
   @JsonProperty("machinePartId")
   @JSONField(name = "machinePartId")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id")
   private Long machinePartId;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type")
   private Integer relationType;
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick")
   private String thick;
   @ApiModelProperty(name = "path", value = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField(value = "path", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "path")
   private String path;
   @ApiModelProperty(name = "nestingState", value = "排套状态")
   @JsonProperty("nestingState")
   @JSONField(name = "nestingState")
   @TableField("nesting_state")
   @Column(name = "nesting_state")
   private Integer nestingState;
   @ApiModelProperty("钢材配置id")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private Long steelId;
   @ApiModelProperty("钢材厚度/规格")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private String steelSpec;

   public static AbnormalProductDTO.AbnormalProductDTOBuilder builder() {
      return new AbnormalProductDTO.AbnormalProductDTOBuilder();
   }

   public AbnormalProductDTO() {
   }

   public AbnormalProductDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long oldArtifactId,
      final String oldArtifactSerialNumber,
      final Boolean boolStatusEnum,
      final Boolean boolAbnormalEnum,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String drawingNumber,
      final String remark,
      final Long userId,
      final Long businessId,
      final Long assembleId,
      final String assembleSerialNumber,
      final Integer producedQuantity,
      final Integer areaType,
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
      final Long attachmentId,
      final Integer usedQuantity,
      final String machinePartFront,
      final Long machinePartId,
      final Integer relationType,
      final Integer type,
      final String thick,
      final String path,
      final Integer nestingState,
      final Long steelId,
      final String steelSpec
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.oldArtifactId = oldArtifactId;
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.boolAbnormalEnum = boolAbnormalEnum;
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
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.userId = userId;
      this.businessId = businessId;
      this.assembleId = assembleId;
      this.assembleSerialNumber = assembleSerialNumber;
      this.producedQuantity = producedQuantity;
      this.areaType = areaType;
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
      this.attachmentId = attachmentId;
      this.usedQuantity = usedQuantity;
      this.machinePartFront = machinePartFront;
      this.machinePartId = machinePartId;
      this.relationType = relationType;
      this.type = type;
      this.thick = thick;
      this.path = path;
      this.nestingState = nestingState;
      this.steelId = steelId;
      this.steelSpec = steelSpec;
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

   public Long getPlanId() {
      return this.planId;
   }

   public Long getOldArtifactId() {
      return this.oldArtifactId;
   }

   public String getOldArtifactSerialNumber() {
      return this.oldArtifactSerialNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
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

   public Integer getQuantity() {
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getAreaType() {
      return this.areaType;
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

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getMachinePartFront() {
      return this.machinePartFront;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getType() {
      return this.type;
   }

   public String getThick() {
      return this.thick;
   }

   public String getPath() {
      return this.path;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   @JsonProperty("id")
   public AbnormalProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public AbnormalProductDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public AbnormalProductDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public AbnormalProductDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   public AbnormalProductDTO setOldArtifactId(final Long oldArtifactId) {
      this.oldArtifactId = oldArtifactId;
      return this;
   }

   public AbnormalProductDTO setOldArtifactSerialNumber(final String oldArtifactSerialNumber) {
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public AbnormalProductDTO setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public AbnormalProductDTO setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("name")
   public AbnormalProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public AbnormalProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AbnormalProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AbnormalProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AbnormalProductDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public AbnormalProductDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public AbnormalProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public AbnormalProductDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public AbnormalProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public AbnormalProductDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public AbnormalProductDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("drawingNumber")
   public AbnormalProductDTO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("remark")
   public AbnormalProductDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public AbnormalProductDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("businessId")
   public AbnormalProductDTO setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("assembleId")
   public AbnormalProductDTO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public AbnormalProductDTO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @JsonProperty("producedQuantity")
   public AbnormalProductDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("areaType")
   public AbnormalProductDTO setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("category")
   public AbnormalProductDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("brand")
   public AbnormalProductDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public AbnormalProductDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public AbnormalProductDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public AbnormalProductDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public AbnormalProductDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public AbnormalProductDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public AbnormalProductDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("width")
   public AbnormalProductDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public AbnormalProductDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("totalLength")
   public AbnormalProductDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public AbnormalProductDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("attachmentId")
   public AbnormalProductDTO setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   @JsonProperty("usedQuantity")
   public AbnormalProductDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("machinePartFront")
   public AbnormalProductDTO setMachinePartFront(final String machinePartFront) {
      this.machinePartFront = machinePartFront;
      return this;
   }

   @JsonProperty("machinePartId")
   public AbnormalProductDTO setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   @JsonProperty("relationType")
   public AbnormalProductDTO setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("type")
   public AbnormalProductDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("thick")
   public AbnormalProductDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("path")
   public AbnormalProductDTO setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("nestingState")
   public AbnormalProductDTO setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
      return this;
   }

   public AbnormalProductDTO setSteelId(final Long steelId) {
      this.steelId = steelId;
      return this;
   }

   public AbnormalProductDTO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalProductDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", oldArtifactId="
         + this.getOldArtifactId()
         + ", oldArtifactSerialNumber="
         + this.getOldArtifactSerialNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", businessId="
         + this.getBusinessId()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", areaType="
         + this.getAreaType()
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
         + ", attachmentId="
         + this.getAttachmentId()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", machinePartFront="
         + this.getMachinePartFront()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", relationType="
         + this.getRelationType()
         + ", type="
         + this.getType()
         + ", thick="
         + this.getThick()
         + ", path="
         + this.getPath()
         + ", nestingState="
         + this.getNestingState()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalProductDTO)) {
         return false;
      }

      AbnormalProductDTO other = (AbnormalProductDTO)o;
      if (!other.canEqual(this)) {
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
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$oldArtifactId = this.getOldArtifactId();
                  Object other$oldArtifactId = other.getOldArtifactId();
                  if (this$oldArtifactId == null ? other$oldArtifactId == null : this$oldArtifactId.equals(other$oldArtifactId)) {
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                        Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                        if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$businessId = this.getBusinessId();
                                 Object other$businessId = other.getBusinessId();
                                 if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                    Object this$assembleId = this.getAssembleId();
                                    Object other$assembleId = other.getAssembleId();
                                    if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                                       Object this$producedQuantity = this.getProducedQuantity();
                                       Object other$producedQuantity = other.getProducedQuantity();
                                       if (this$producedQuantity == null
                                          ? other$producedQuantity == null
                                          : this$producedQuantity.equals(other$producedQuantity)) {
                                          Object this$areaType = this.getAreaType();
                                          Object other$areaType = other.getAreaType();
                                          if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                             Object this$category = this.getCategory();
                                             Object other$category = other.getCategory();
                                             if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                                Object this$attachmentId = this.getAttachmentId();
                                                Object other$attachmentId = other.getAttachmentId();
                                                if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                                   Object this$usedQuantity = this.getUsedQuantity();
                                                   Object other$usedQuantity = other.getUsedQuantity();
                                                   if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                                      Object this$machinePartId = this.getMachinePartId();
                                                      Object other$machinePartId = other.getMachinePartId();
                                                      if (this$machinePartId == null
                                                         ? other$machinePartId == null
                                                         : this$machinePartId.equals(other$machinePartId)) {
                                                         Object this$relationType = this.getRelationType();
                                                         Object other$relationType = other.getRelationType();
                                                         if (this$relationType == null
                                                            ? other$relationType == null
                                                            : this$relationType.equals(other$relationType)) {
                                                            Object this$type = this.getType();
                                                            Object other$type = other.getType();
                                                            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                               Object this$nestingState = this.getNestingState();
                                                               Object other$nestingState = other.getNestingState();
                                                               if (this$nestingState == null
                                                                  ? other$nestingState == null
                                                                  : this$nestingState.equals(other$nestingState)) {
                                                                  Object this$steelId = this.getSteelId();
                                                                  Object other$steelId = other.getSteelId();
                                                                  if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                                                     Object this$oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
                                                                     Object other$oldArtifactSerialNumber = other.getOldArtifactSerialNumber();
                                                                     if (this$oldArtifactSerialNumber == null
                                                                        ? other$oldArtifactSerialNumber == null
                                                                        : this$oldArtifactSerialNumber.equals(other$oldArtifactSerialNumber)) {
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
                                                                                 if (this$length == null
                                                                                    ? other$length == null
                                                                                    : this$length.equals(other$length)) {
                                                                                    Object this$material = this.getMaterial();
                                                                                    Object other$material = other.getMaterial();
                                                                                    if (this$material == null
                                                                                       ? other$material == null
                                                                                       : this$material.equals(other$material)) {
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
                                                                                                      Object this$drawingNumber = this.getDrawingNumber();
                                                                                                      Object other$drawingNumber = other.getDrawingNumber();
                                                                                                      if (this$drawingNumber == null
                                                                                                         ? other$drawingNumber == null
                                                                                                         : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                                         Object this$remark = this.getRemark();
                                                                                                         Object other$remark = other.getRemark();
                                                                                                         if (this$remark == null
                                                                                                            ? other$remark == null
                                                                                                            : this$remark.equals(other$remark)) {
                                                                                                            Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                                                                            Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                                                                            if (this$assembleSerialNumber == null
                                                                                                               ? other$assembleSerialNumber == null
                                                                                                               : this$assembleSerialNumber.equals(
                                                                                                                  other$assembleSerialNumber
                                                                                                               )) {
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
                                                                                                                              : this$thickness.equals(
                                                                                                                                 other$thickness
                                                                                                                              )) {
                                                                                                                              Object this$coating = this.getCoating();
                                                                                                                              Object other$coating = other.getCoating();
                                                                                                                              if (this$coating == null
                                                                                                                                 ? other$coating == null
                                                                                                                                 : this$coating.equals(
                                                                                                                                    other$coating
                                                                                                                                 )) {
                                                                                                                                 Object this$plating = this.getPlating();
                                                                                                                                 Object other$plating = other.getPlating();
                                                                                                                                 if (this$plating == null
                                                                                                                                    ? other$plating == null
                                                                                                                                    : this$plating.equals(
                                                                                                                                       other$plating
                                                                                                                                    )) {
                                                                                                                                    Object this$width = this.getWidth();
                                                                                                                                    Object other$width = other.getWidth();
                                                                                                                                    if (this$width == null
                                                                                                                                       ? other$width == null
                                                                                                                                       : this$width.equals(
                                                                                                                                          other$width
                                                                                                                                       )) {
                                                                                                                                       Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                                                                       Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                                                                       if (this$unfoldedWidth
                                                                                                                                             == null
                                                                                                                                          ? other$unfoldedWidth
                                                                                                                                             == null
                                                                                                                                          : this$unfoldedWidth.equals(
                                                                                                                                             other$unfoldedWidth
                                                                                                                                          )) {
                                                                                                                                          Object this$totalLength = this.getTotalLength();
                                                                                                                                          Object other$totalLength = other.getTotalLength();
                                                                                                                                          if (this$totalLength
                                                                                                                                                == null
                                                                                                                                             ? other$totalLength
                                                                                                                                                == null
                                                                                                                                             : this$totalLength.equals(
                                                                                                                                                other$totalLength
                                                                                                                                             )) {
                                                                                                                                             Object this$totalArea = this.getTotalArea();
                                                                                                                                             Object other$totalArea = other.getTotalArea();
                                                                                                                                             if (this$totalArea
                                                                                                                                                   == null
                                                                                                                                                ? other$totalArea
                                                                                                                                                   == null
                                                                                                                                                : this$totalArea.equals(
                                                                                                                                                   other$totalArea
                                                                                                                                                )) {
                                                                                                                                                Object this$machinePartFront = this.getMachinePartFront();
                                                                                                                                                Object other$machinePartFront = other.getMachinePartFront();
                                                                                                                                                if (this$machinePartFront
                                                                                                                                                      == null
                                                                                                                                                   ? other$machinePartFront
                                                                                                                                                      == null
                                                                                                                                                   : this$machinePartFront.equals(
                                                                                                                                                      other$machinePartFront
                                                                                                                                                   )) {
                                                                                                                                                   Object this$thick = this.getThick();
                                                                                                                                                   Object other$thick = other.getThick();
                                                                                                                                                   if (this$thick
                                                                                                                                                         == null
                                                                                                                                                      ? other$thick
                                                                                                                                                         == null
                                                                                                                                                      : this$thick.equals(
                                                                                                                                                         other$thick
                                                                                                                                                      )) {
                                                                                                                                                      Object this$path = this.getPath();
                                                                                                                                                      Object other$path = other.getPath();
                                                                                                                                                      if (this$path
                                                                                                                                                            == null
                                                                                                                                                         ? other$path
                                                                                                                                                            == null
                                                                                                                                                         : this$path.equals(
                                                                                                                                                            other$path
                                                                                                                                                         )) {
                                                                                                                                                         Object this$steelSpec = this.getSteelSpec();
                                                                                                                                                         Object other$steelSpec = other.getSteelSpec();
                                                                                                                                                         return this$steelSpec
                                                                                                                                                               == null
                                                                                                                                                            ? other$steelSpec
                                                                                                                                                               == null
                                                                                                                                                            : this$steelSpec.equals(
                                                                                                                                                               other$steelSpec
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $oldArtifactId = this.getOldArtifactId();
      result = result * 59 + ($oldArtifactId == null ? 43 : $oldArtifactId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
      result = result * 59 + ($oldArtifactSerialNumber == null ? 43 : $oldArtifactSerialNumber.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      result = result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
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
      Object $machinePartFront = this.getMachinePartFront();
      result = result * 59 + ($machinePartFront == null ? 43 : $machinePartFront.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public static class AbnormalProductDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long oldArtifactId;
      private String oldArtifactSerialNumber;
      private Boolean boolStatusEnum;
      private Boolean boolAbnormalEnum;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String drawingNumber;
      private String remark;
      private Long userId;
      private Long businessId;
      private Long assembleId;
      private String assembleSerialNumber;
      private Integer producedQuantity;
      private Integer areaType;
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
      private Long attachmentId;
      private Integer usedQuantity;
      private String machinePartFront;
      private Long machinePartId;
      private Integer relationType;
      private Integer type;
      private String thick;
      private String path;
      private Integer nestingState;
      private Long steelId;
      private String steelSpec;

      AbnormalProductDTOBuilder() {
      }

      @JsonProperty("id")
      public AbnormalProductDTO.AbnormalProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public AbnormalProductDTO.AbnormalProductDTOBuilder oldArtifactId(final Long oldArtifactId) {
         this.oldArtifactId = oldArtifactId;
         return this;
      }

      public AbnormalProductDTO.AbnormalProductDTOBuilder oldArtifactSerialNumber(final String oldArtifactSerialNumber) {
         this.oldArtifactSerialNumber = oldArtifactSerialNumber;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public AbnormalProductDTO.AbnormalProductDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public AbnormalProductDTO.AbnormalProductDTOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("name")
      public AbnormalProductDTO.AbnormalProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public AbnormalProductDTO.AbnormalProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AbnormalProductDTO.AbnormalProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AbnormalProductDTO.AbnormalProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AbnormalProductDTO.AbnormalProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public AbnormalProductDTO.AbnormalProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public AbnormalProductDTO.AbnormalProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public AbnormalProductDTO.AbnormalProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public AbnormalProductDTO.AbnormalProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public AbnormalProductDTO.AbnormalProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public AbnormalProductDTO.AbnormalProductDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("drawingNumber")
      public AbnormalProductDTO.AbnormalProductDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("remark")
      public AbnormalProductDTO.AbnormalProductDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("businessId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("assembleId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public AbnormalProductDTO.AbnormalProductDTOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      @JsonProperty("producedQuantity")
      public AbnormalProductDTO.AbnormalProductDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("areaType")
      public AbnormalProductDTO.AbnormalProductDTOBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("category")
      public AbnormalProductDTO.AbnormalProductDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("brand")
      public AbnormalProductDTO.AbnormalProductDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public AbnormalProductDTO.AbnormalProductDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public AbnormalProductDTO.AbnormalProductDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public AbnormalProductDTO.AbnormalProductDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public AbnormalProductDTO.AbnormalProductDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public AbnormalProductDTO.AbnormalProductDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public AbnormalProductDTO.AbnormalProductDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("width")
      public AbnormalProductDTO.AbnormalProductDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public AbnormalProductDTO.AbnormalProductDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      @JsonProperty("totalLength")
      public AbnormalProductDTO.AbnormalProductDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public AbnormalProductDTO.AbnormalProductDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("attachmentId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      @JsonProperty("usedQuantity")
      public AbnormalProductDTO.AbnormalProductDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("machinePartFront")
      public AbnormalProductDTO.AbnormalProductDTOBuilder machinePartFront(final String machinePartFront) {
         this.machinePartFront = machinePartFront;
         return this;
      }

      @JsonProperty("machinePartId")
      public AbnormalProductDTO.AbnormalProductDTOBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      @JsonProperty("relationType")
      public AbnormalProductDTO.AbnormalProductDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("type")
      public AbnormalProductDTO.AbnormalProductDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("thick")
      public AbnormalProductDTO.AbnormalProductDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("path")
      public AbnormalProductDTO.AbnormalProductDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("nestingState")
      public AbnormalProductDTO.AbnormalProductDTOBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      public AbnormalProductDTO.AbnormalProductDTOBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public AbnormalProductDTO.AbnormalProductDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public AbnormalProductDTO build() {
         return new AbnormalProductDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.oldArtifactId,
            this.oldArtifactSerialNumber,
            this.boolStatusEnum,
            this.boolAbnormalEnum,
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
            this.drawingNumber,
            this.remark,
            this.userId,
            this.businessId,
            this.assembleId,
            this.assembleSerialNumber,
            this.producedQuantity,
            this.areaType,
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
            this.attachmentId,
            this.usedQuantity,
            this.machinePartFront,
            this.machinePartId,
            this.relationType,
            this.type,
            this.thick,
            this.path,
            this.nestingState,
            this.steelId,
            this.steelSpec
         );
      }

      @Override
      public String toString() {
         return "AbnormalProductDTO.AbnormalProductDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", oldArtifactId="
            + this.oldArtifactId
            + ", oldArtifactSerialNumber="
            + this.oldArtifactSerialNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
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
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", businessId="
            + this.businessId
            + ", assembleId="
            + this.assembleId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ", producedQuantity="
            + this.producedQuantity
            + ", areaType="
            + this.areaType
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
            + ", attachmentId="
            + this.attachmentId
            + ", usedQuantity="
            + this.usedQuantity
            + ", machinePartFront="
            + this.machinePartFront
            + ", machinePartId="
            + this.machinePartId
            + ", relationType="
            + this.relationType
            + ", type="
            + this.type
            + ", thick="
            + this.thick
            + ", path="
            + this.path
            + ", nestingState="
            + this.nestingState
            + ", steelId="
            + this.steelId
            + ", steelSpec="
            + this.steelSpec
            + ")";
      }
   }
}
