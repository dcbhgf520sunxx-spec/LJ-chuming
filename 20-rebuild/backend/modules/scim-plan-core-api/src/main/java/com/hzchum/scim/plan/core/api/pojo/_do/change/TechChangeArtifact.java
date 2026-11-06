package com.hzchum.scim.plan.core.api.pojo._do.change;

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

@ApiModel(value = "TechChangeArtifact对象", description = "技术变更构件表 ")
@Entity
@TableName("tech_change_artifact")
@Table(name = "tech_change_artifact")
@org.hibernate.annotations.Table(appliesTo = "tech_change_artifact", comment = "技术变更构件表 ")
public class TechChangeArtifact extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeRecordId", value = "变更记录表ID", notes = "变更记录表ID")
   @TableField("change_record_id")
   @Column(name = "change_record_id", columnDefinition = "bigint(20)  COMMENT '变更记录表ID'", nullable = false)
   private Long changeRecordId;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "varchar(255) COMMENT '结构类型'")
   private String structureType;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长度（mm）'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）", notes = "单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8)  COMMENT '单净重（kg）'", nullable = false)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）", notes = "总净重（kg）")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8)  COMMENT '总净重（kg）'", nullable = false)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）", notes = "单毛重（kg）")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,8)  COMMENT '单毛重（kg）'", nullable = false)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）", notes = "总毛重（kg）")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,8)  COMMENT '总毛重（kg）'", nullable = false)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）", notes = "面积（㎡）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8)  COMMENT '面积（㎡）'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   @TableField("serial_number_prefix")
   @Column(name = "serial_number_prefix", columnDefinition = "varchar(255) COMMENT '编号前缀'", nullable = false)
   private String serialNumberPrefix;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '上传人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   private Integer relationType;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   @TableField("bool_coating_enum")
   @Column(name = "bool_coating_enum", columnDefinition = "tinyint(1)  comment '是否涂装 1是 0否'")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "boolBlastingEnum", value = "是否抛丸")
   private Boolean boolBlastingEnum;
   @ApiModelProperty(name = "boolPurlineClass", value = "是否檩条")
   private Boolean boolPurlineClass;
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingWeight", value = "图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty("桥顶面油漆(单)面积(mm2)")
   private BigDecimal topPaintArea;
   @ApiModelProperty("内表面油漆(单)面积(mm2)")
   private BigDecimal innerPaintArea;
   @ApiModelProperty("外表面油漆(单)面积(mm2)")
   private BigDecimal outerPaintArea;
   @ApiModelProperty("U肋油漆(单)面积(mm2)")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty("桥顶面油漆总面积(mm2)")
   private BigDecimal totalTopPaintArea;
   @ApiModelProperty("内表面油漆总面积(mm2)")
   private BigDecimal totalInnerPaintArea;
   @ApiModelProperty("外表面油漆总面积(mm2)")
   private BigDecimal totalOuterPaintArea;
   @ApiModelProperty("U肋油漆总面积(mm2)")
   @JsonProperty("totalURibPaintArea")
   @JSONField(name = "totalURibPaintArea")
   @TableField("total_u_rib_paint_area")
   @Column(name = "total_u_rib_paint_area", columnDefinition = "bigint(20)  COMMENT 'U肋油漆总面积(mm2)'")
   private BigDecimal totalURibPaintArea;
   @ApiModelProperty(name = "boolSameNumber", value = "是否存在相同编号构件(已存在的构件数量为1)")
   @TableField("bool_same_number")
   @Column(name = "bool_same_number", columnDefinition = "tinyint(1) default 0  comment '是否存在相同编号构件(已存在的构件数量为1)'")
   private Boolean boolSameNumber;

   public static TechChangeArtifact.TechChangeArtifactBuilder builder() {
      return new TechChangeArtifact.TechChangeArtifactBuilder();
   }

   public TechChangeArtifact() {
   }

   public TechChangeArtifact(
      final Long id,
      final Long changeRecordId,
      final String structureType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String specPrefix,
      final String serialNumberPrefix,
      final Long userId,
      final Integer relationType,
      final Boolean boolCoatingEnum,
      final BigDecimal topFlangeArea,
      final Boolean boolBlastingEnum,
      final Boolean boolPurlineClass,
      final BigDecimal drawingWeight,
      final BigDecimal totalDrawingWeight,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final BigDecimal totalTopPaintArea,
      final BigDecimal totalInnerPaintArea,
      final BigDecimal totalOuterPaintArea,
      final BigDecimal totalURibPaintArea,
      final Boolean boolSameNumber
   ) {
      this.id = id;
      this.changeRecordId = changeRecordId;
      this.structureType = structureType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.userId = userId;
      this.relationType = relationType;
      this.boolCoatingEnum = boolCoatingEnum;
      this.topFlangeArea = topFlangeArea;
      this.boolBlastingEnum = boolBlastingEnum;
      this.boolPurlineClass = boolPurlineClass;
      this.drawingWeight = drawingWeight;
      this.totalDrawingWeight = totalDrawingWeight;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.totalTopPaintArea = totalTopPaintArea;
      this.totalInnerPaintArea = totalInnerPaintArea;
      this.totalOuterPaintArea = totalOuterPaintArea;
      this.totalURibPaintArea = totalURibPaintArea;
      this.boolSameNumber = boolSameNumber;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeRecordId() {
      return this.changeRecordId;
   }

   public String getStructureType() {
      return this.structureType;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
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

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public Boolean getBoolPurlineClass() {
      return this.boolPurlineClass;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public BigDecimal getTopPaintArea() {
      return this.topPaintArea;
   }

   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   public BigDecimal getURibPaintArea() {
      return this.uRibPaintArea;
   }

   public BigDecimal getTotalTopPaintArea() {
      return this.totalTopPaintArea;
   }

   public BigDecimal getTotalInnerPaintArea() {
      return this.totalInnerPaintArea;
   }

   public BigDecimal getTotalOuterPaintArea() {
      return this.totalOuterPaintArea;
   }

   public BigDecimal getTotalURibPaintArea() {
      return this.totalURibPaintArea;
   }

   public Boolean getBoolSameNumber() {
      return this.boolSameNumber;
   }

   public TechChangeArtifact setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechChangeArtifact setChangeRecordId(final Long changeRecordId) {
      this.changeRecordId = changeRecordId;
      return this;
   }

   public TechChangeArtifact setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public TechChangeArtifact setName(final String name) {
      this.name = name;
      return this;
   }

   public TechChangeArtifact setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechChangeArtifact setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechChangeArtifact setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechChangeArtifact setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechChangeArtifact setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechChangeArtifact setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public TechChangeArtifact setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public TechChangeArtifact setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TechChangeArtifact setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechChangeArtifact setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechChangeArtifact setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechChangeArtifact setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   @JsonProperty("userId")
   public TechChangeArtifact setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechChangeArtifact setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public TechChangeArtifact setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
      return this;
   }

   public TechChangeArtifact setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   public TechChangeArtifact setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
      return this;
   }

   public TechChangeArtifact setBoolPurlineClass(final Boolean boolPurlineClass) {
      this.boolPurlineClass = boolPurlineClass;
      return this;
   }

   public TechChangeArtifact setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
      return this;
   }

   public TechChangeArtifact setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
      return this;
   }

   public TechChangeArtifact setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechChangeArtifact setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechChangeArtifact setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechChangeArtifact setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   public TechChangeArtifact setTotalTopPaintArea(final BigDecimal totalTopPaintArea) {
      this.totalTopPaintArea = totalTopPaintArea;
      return this;
   }

   public TechChangeArtifact setTotalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
      this.totalInnerPaintArea = totalInnerPaintArea;
      return this;
   }

   public TechChangeArtifact setTotalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
      this.totalOuterPaintArea = totalOuterPaintArea;
      return this;
   }

   @JsonProperty("totalURibPaintArea")
   public TechChangeArtifact setTotalURibPaintArea(final BigDecimal totalURibPaintArea) {
      this.totalURibPaintArea = totalURibPaintArea;
      return this;
   }

   public TechChangeArtifact setBoolSameNumber(final Boolean boolSameNumber) {
      this.boolSameNumber = boolSameNumber;
      return this;
   }

   @Override
   public String toString() {
      return "TechChangeArtifact(id="
         + this.getId()
         + ", changeRecordId="
         + this.getChangeRecordId()
         + ", structureType="
         + this.getStructureType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
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
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", userId="
         + this.getUserId()
         + ", relationType="
         + this.getRelationType()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", boolPurlineClass="
         + this.getBoolPurlineClass()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", totalTopPaintArea="
         + this.getTotalTopPaintArea()
         + ", totalInnerPaintArea="
         + this.getTotalInnerPaintArea()
         + ", totalOuterPaintArea="
         + this.getTotalOuterPaintArea()
         + ", totalURibPaintArea="
         + this.getTotalURibPaintArea()
         + ", boolSameNumber="
         + this.getBoolSameNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifact)) {
         return false;
      }

      TechChangeArtifact other = (TechChangeArtifact)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeRecordId = this.getChangeRecordId();
         Object other$changeRecordId = other.getChangeRecordId();
         if (this$changeRecordId == null ? other$changeRecordId == null : this$changeRecordId.equals(other$changeRecordId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$relationType = this.getRelationType();
                  Object other$relationType = other.getRelationType();
                  if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                     Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                     Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                     if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                        Object this$boolBlastingEnum = this.getBoolBlastingEnum();
                        Object other$boolBlastingEnum = other.getBoolBlastingEnum();
                        if (this$boolBlastingEnum == null ? other$boolBlastingEnum == null : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
                           Object this$boolPurlineClass = this.getBoolPurlineClass();
                           Object other$boolPurlineClass = other.getBoolPurlineClass();
                           if (this$boolPurlineClass == null ? other$boolPurlineClass == null : this$boolPurlineClass.equals(other$boolPurlineClass)) {
                              Object this$boolSameNumber = this.getBoolSameNumber();
                              Object other$boolSameNumber = other.getBoolSameNumber();
                              if (this$boolSameNumber == null ? other$boolSameNumber == null : this$boolSameNumber.equals(other$boolSameNumber)) {
                                 Object this$structureType = this.getStructureType();
                                 Object other$structureType = other.getStructureType();
                                 if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$material = this.getMaterial();
                                             Object other$material = other.getMaterial();
                                             if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$netWeight = this.getNetWeight();
                                                   Object other$netWeight = other.getNetWeight();
                                                   if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                      Object this$totalNetWeight = this.getTotalNetWeight();
                                                      Object other$totalNetWeight = other.getTotalNetWeight();
                                                      if (this$totalNetWeight == null
                                                         ? other$totalNetWeight == null
                                                         : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                         Object this$grossWeight = this.getGrossWeight();
                                                         Object other$grossWeight = other.getGrossWeight();
                                                         if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
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
                                                                  Object this$specPrefix = this.getSpecPrefix();
                                                                  Object other$specPrefix = other.getSpecPrefix();
                                                                  if (this$specPrefix == null
                                                                     ? other$specPrefix == null
                                                                     : this$specPrefix.equals(other$specPrefix)) {
                                                                     Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                     Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                     if (this$serialNumberPrefix == null
                                                                        ? other$serialNumberPrefix == null
                                                                        : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                                                                        Object this$topFlangeArea = this.getTopFlangeArea();
                                                                        Object other$topFlangeArea = other.getTopFlangeArea();
                                                                        if (this$topFlangeArea == null
                                                                           ? other$topFlangeArea == null
                                                                           : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                           Object this$drawingWeight = this.getDrawingWeight();
                                                                           Object other$drawingWeight = other.getDrawingWeight();
                                                                           if (this$drawingWeight == null
                                                                              ? other$drawingWeight == null
                                                                              : this$drawingWeight.equals(other$drawingWeight)) {
                                                                              Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                                              Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                                              if (this$totalDrawingWeight == null
                                                                                 ? other$totalDrawingWeight == null
                                                                                 : this$totalDrawingWeight.equals(other$totalDrawingWeight)) {
                                                                                 Object this$topPaintArea = this.getTopPaintArea();
                                                                                 Object other$topPaintArea = other.getTopPaintArea();
                                                                                 if (this$topPaintArea == null
                                                                                    ? other$topPaintArea == null
                                                                                    : this$topPaintArea.equals(other$topPaintArea)) {
                                                                                    Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                    Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                    if (this$innerPaintArea == null
                                                                                       ? other$innerPaintArea == null
                                                                                       : this$innerPaintArea.equals(other$innerPaintArea)) {
                                                                                       Object this$outerPaintArea = this.getOuterPaintArea();
                                                                                       Object other$outerPaintArea = other.getOuterPaintArea();
                                                                                       if (this$outerPaintArea == null
                                                                                          ? other$outerPaintArea == null
                                                                                          : this$outerPaintArea.equals(other$outerPaintArea)) {
                                                                                          Object this$uRibPaintArea = this.getURibPaintArea();
                                                                                          Object other$uRibPaintArea = other.getURibPaintArea();
                                                                                          if (this$uRibPaintArea == null
                                                                                             ? other$uRibPaintArea == null
                                                                                             : this$uRibPaintArea.equals(other$uRibPaintArea)) {
                                                                                             Object this$totalTopPaintArea = this.getTotalTopPaintArea();
                                                                                             Object other$totalTopPaintArea = other.getTotalTopPaintArea();
                                                                                             if (this$totalTopPaintArea == null
                                                                                                ? other$totalTopPaintArea == null
                                                                                                : this$totalTopPaintArea.equals(other$totalTopPaintArea)) {
                                                                                                Object this$totalInnerPaintArea = this.getTotalInnerPaintArea();
                                                                                                Object other$totalInnerPaintArea = other.getTotalInnerPaintArea();
                                                                                                if (this$totalInnerPaintArea == null
                                                                                                   ? other$totalInnerPaintArea == null
                                                                                                   : this$totalInnerPaintArea.equals(other$totalInnerPaintArea)
                                                                                                   )
                                                                                                 {
                                                                                                   Object this$totalOuterPaintArea = this.getTotalOuterPaintArea();
                                                                                                   Object other$totalOuterPaintArea = other.getTotalOuterPaintArea();
                                                                                                   if (this$totalOuterPaintArea == null
                                                                                                      ? other$totalOuterPaintArea == null
                                                                                                      : this$totalOuterPaintArea.equals(
                                                                                                         other$totalOuterPaintArea
                                                                                                      )) {
                                                                                                      Object this$totalURibPaintArea = this.getTotalURibPaintArea();
                                                                                                      Object other$totalURibPaintArea = other.getTotalURibPaintArea();
                                                                                                      return this$totalURibPaintArea == null
                                                                                                         ? other$totalURibPaintArea == null
                                                                                                         : this$totalURibPaintArea.equals(
                                                                                                            other$totalURibPaintArea
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeArtifact;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeRecordId = this.getChangeRecordId();
      result = result * 59 + ($changeRecordId == null ? 43 : $changeRecordId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
      Object $boolPurlineClass = this.getBoolPurlineClass();
      result = result * 59 + ($boolPurlineClass == null ? 43 : $boolPurlineClass.hashCode());
      Object $boolSameNumber = this.getBoolSameNumber();
      result = result * 59 + ($boolSameNumber == null ? 43 : $boolSameNumber.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
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
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $totalTopPaintArea = this.getTotalTopPaintArea();
      result = result * 59 + ($totalTopPaintArea == null ? 43 : $totalTopPaintArea.hashCode());
      Object $totalInnerPaintArea = this.getTotalInnerPaintArea();
      result = result * 59 + ($totalInnerPaintArea == null ? 43 : $totalInnerPaintArea.hashCode());
      Object $totalOuterPaintArea = this.getTotalOuterPaintArea();
      result = result * 59 + ($totalOuterPaintArea == null ? 43 : $totalOuterPaintArea.hashCode());
      Object $totalURibPaintArea = this.getTotalURibPaintArea();
      return result * 59 + ($totalURibPaintArea == null ? 43 : $totalURibPaintArea.hashCode());
   }

   public static class TechChangeArtifactBuilder {
      private Long id;
      private Long changeRecordId;
      private String structureType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String specPrefix;
      private String serialNumberPrefix;
      private Long userId;
      private Integer relationType;
      private Boolean boolCoatingEnum;
      private BigDecimal topFlangeArea;
      private Boolean boolBlastingEnum;
      private Boolean boolPurlineClass;
      private BigDecimal drawingWeight;
      private BigDecimal totalDrawingWeight;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private BigDecimal totalTopPaintArea;
      private BigDecimal totalInnerPaintArea;
      private BigDecimal totalOuterPaintArea;
      private BigDecimal totalURibPaintArea;
      private Boolean boolSameNumber;

      TechChangeArtifactBuilder() {
      }

      public TechChangeArtifact.TechChangeArtifactBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder changeRecordId(final Long changeRecordId) {
         this.changeRecordId = changeRecordId;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      @JsonProperty("userId")
      public TechChangeArtifact.TechChangeArtifactBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder boolBlastingEnum(final Boolean boolBlastingEnum) {
         this.boolBlastingEnum = boolBlastingEnum;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder boolPurlineClass(final Boolean boolPurlineClass) {
         this.boolPurlineClass = boolPurlineClass;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalDrawingWeight(final BigDecimal totalDrawingWeight) {
         this.totalDrawingWeight = totalDrawingWeight;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalTopPaintArea(final BigDecimal totalTopPaintArea) {
         this.totalTopPaintArea = totalTopPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
         this.totalInnerPaintArea = totalInnerPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder totalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
         this.totalOuterPaintArea = totalOuterPaintArea;
         return this;
      }

      @JsonProperty("totalURibPaintArea")
      public TechChangeArtifact.TechChangeArtifactBuilder totalURibPaintArea(final BigDecimal totalURibPaintArea) {
         this.totalURibPaintArea = totalURibPaintArea;
         return this;
      }

      public TechChangeArtifact.TechChangeArtifactBuilder boolSameNumber(final Boolean boolSameNumber) {
         this.boolSameNumber = boolSameNumber;
         return this;
      }

      public TechChangeArtifact build() {
         return new TechChangeArtifact(
            this.id,
            this.changeRecordId,
            this.structureType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.specPrefix,
            this.serialNumberPrefix,
            this.userId,
            this.relationType,
            this.boolCoatingEnum,
            this.topFlangeArea,
            this.boolBlastingEnum,
            this.boolPurlineClass,
            this.drawingWeight,
            this.totalDrawingWeight,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.totalTopPaintArea,
            this.totalInnerPaintArea,
            this.totalOuterPaintArea,
            this.totalURibPaintArea,
            this.boolSameNumber
         );
      }

      @Override
      public String toString() {
         return "TechChangeArtifact.TechChangeArtifactBuilder(id="
            + this.id
            + ", changeRecordId="
            + this.changeRecordId
            + ", structureType="
            + this.structureType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
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
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", userId="
            + this.userId
            + ", relationType="
            + this.relationType
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", topFlangeArea="
            + this.topFlangeArea
            + ", boolBlastingEnum="
            + this.boolBlastingEnum
            + ", boolPurlineClass="
            + this.boolPurlineClass
            + ", drawingWeight="
            + this.drawingWeight
            + ", totalDrawingWeight="
            + this.totalDrawingWeight
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", totalTopPaintArea="
            + this.totalTopPaintArea
            + ", totalInnerPaintArea="
            + this.totalInnerPaintArea
            + ", totalOuterPaintArea="
            + this.totalOuterPaintArea
            + ", totalURibPaintArea="
            + this.totalURibPaintArea
            + ", boolSameNumber="
            + this.boolSameNumber
            + ")";
      }
   }
}
