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

@ApiModel(value = "TechChangeMachinePart对象", description = "技术变更零件表 ")
@Entity
@TableName("tech_change_machine_part")
@Table(name = "tech_change_machine_part")
@org.hibernate.annotations.Table(appliesTo = "tech_change_machine_part", comment = "技术变更零件表 ")
public class TechChangeMachinePart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeRecordId", value = "变更记录表ID", notes = "变更记录表ID")
   @TableField("change_record_id")
   @Column(name = "change_record_id", columnDefinition = "bigint(20)  COMMENT '变更记录表ID'")
   private Long changeRecordId;
   @ApiModelProperty(name = "changeArtifactId", value = "变更构件表ID", notes = "变更构件表ID")
   @TableField("change_artifact_id")
   @Column(name = "change_artifact_id", columnDefinition = "bigint(20)  COMMENT '变更构件表ID'")
   private Long changeArtifactId;
   @ApiModelProperty(name = "changeAssembleId", value = "变更部件表ID", notes = "变更部件表ID")
   @TableField("change_assemble_id")
   @Column(name = "change_assemble_id", columnDefinition = "bigint(20)  COMMENT '变更部件表ID'")
   private Long changeAssembleId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '编号'")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质'")
   private String material;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长度（mm）'")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）", notes = "单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8)  COMMENT '单净重（kg）'")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）", notes = "总净重（kg）")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8)  COMMENT '总净重（kg）'")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）", notes = "单毛重（kg）")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,8)  COMMENT '单毛重（kg）'")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）", notes = "总毛重（kg）")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,8)  COMMENT '总毛重（kg）'")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）", notes = "面积（㎡）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8)  COMMENT '面积（㎡）'", nullable = true)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "artifactRate", value = "构件数量比例", notes = "构件数量比例")
   @TableField("artifact_rate")
   @Column(name = "artifact_rate", columnDefinition = "int(11) default '1' COMMENT '构件数量比例'")
   private Integer artifactRate;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) COMMENT '规格前缀'")
   private String specPrefix;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   @TableField("bool_all_part_send_directly")
   @Column(name = "bool_all_part_send_directly", columnDefinition = "tinyint(1) default 0 comment '是否构件全部零件都是直发件 1是 0否'")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   @TableField("bool_send_directly")
   @Column(name = "bool_send_directly", columnDefinition = "tinyint(1) default 0 comment '是否直发件 1是 0否'")
   private Boolean boolSendDirectly;
   @ApiModelProperty("零件种类")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '零件种类 1零件板,2翼腹板 3型材制品'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "productClassificationEnum", value = "产品分类 1.普通构件 2.次构件 4.型材制品 8.钢板制品 16.部件")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) COMMENT '产品分类 1.普通构件 2.次构件 4.型材制品 8.钢板制品 16.部件'")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2 comment '关联类型 2普通零件(关联构件) 16翼板腹板(关联组立) 18等于组立'")
   private Integer relationType;
   @ApiModelProperty(name = "topPaintArea", value = "桥顶面油漆(单)面积(mm2)")
   @TableField("top_paint_area")
   @Column(name = "top_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '桥顶面油漆(单)面积(mm2)'")
   private BigDecimal topPaintArea;
   @ApiModelProperty(name = "innerPaintArea", value = "内表面油漆(单)面积(mm2)")
   @TableField("inner_paint_area")
   @Column(name = "inner_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '内表面油漆(单)面积(mm2)'")
   private BigDecimal innerPaintArea;
   @ApiModelProperty(name = "outerPaintArea", value = "外表面油漆(单)面积(mm2)")
   @TableField("outer_paint_area")
   @Column(name = "outer_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '外表面油漆(单)面积(mm2)'")
   private BigDecimal outerPaintArea;
   @ApiModelProperty(name = "uRibPaintArea", value = "U肋油漆(单)面积(mm2)")
   @TableField("u_rib_paint_area")
   @Column(name = "u_rib_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT 'U肋油漆(单)面积(mm2)'")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;

   public static TechChangeMachinePart.TechChangeMachinePartBuilder builder() {
      return new TechChangeMachinePart.TechChangeMachinePartBuilder();
   }

   public TechChangeMachinePart() {
   }

   public TechChangeMachinePart(
      final Long id,
      final Long changeRecordId,
      final Long changeArtifactId,
      final Long changeAssembleId,
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
      final Integer artifactRate,
      final String specPrefix,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSendDirectly,
      final Integer steelPlateTypeEnum,
      final Integer productClassificationEnum,
      final Integer relationType,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final Integer useProperty
   ) {
      this.id = id;
      this.changeRecordId = changeRecordId;
      this.changeArtifactId = changeArtifactId;
      this.changeAssembleId = changeAssembleId;
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
      this.artifactRate = artifactRate;
      this.specPrefix = specPrefix;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSendDirectly = boolSendDirectly;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.productClassificationEnum = productClassificationEnum;
      this.relationType = relationType;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.useProperty = useProperty;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeRecordId() {
      return this.changeRecordId;
   }

   public Long getChangeArtifactId() {
      return this.changeArtifactId;
   }

   public Long getChangeAssembleId() {
      return this.changeAssembleId;
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

   public Integer getArtifactRate() {
      return this.artifactRate;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
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

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public TechChangeMachinePart setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechChangeMachinePart setChangeRecordId(final Long changeRecordId) {
      this.changeRecordId = changeRecordId;
      return this;
   }

   public TechChangeMachinePart setChangeArtifactId(final Long changeArtifactId) {
      this.changeArtifactId = changeArtifactId;
      return this;
   }

   public TechChangeMachinePart setChangeAssembleId(final Long changeAssembleId) {
      this.changeAssembleId = changeAssembleId;
      return this;
   }

   public TechChangeMachinePart setName(final String name) {
      this.name = name;
      return this;
   }

   public TechChangeMachinePart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechChangeMachinePart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechChangeMachinePart setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechChangeMachinePart setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechChangeMachinePart setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechChangeMachinePart setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public TechChangeMachinePart setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public TechChangeMachinePart setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TechChangeMachinePart setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechChangeMachinePart setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechChangeMachinePart setArtifactRate(final Integer artifactRate) {
      this.artifactRate = artifactRate;
      return this;
   }

   public TechChangeMachinePart setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechChangeMachinePart setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechChangeMachinePart setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechChangeMachinePart setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   public TechChangeMachinePart setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("relationType")
   public TechChangeMachinePart setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public TechChangeMachinePart setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechChangeMachinePart setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechChangeMachinePart setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechChangeMachinePart setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   public TechChangeMachinePart setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   @Override
   public String toString() {
      return "TechChangeMachinePart(id="
         + this.getId()
         + ", changeRecordId="
         + this.getChangeRecordId()
         + ", changeArtifactId="
         + this.getChangeArtifactId()
         + ", changeAssembleId="
         + this.getChangeAssembleId()
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
         + ", artifactRate="
         + this.getArtifactRate()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", relationType="
         + this.getRelationType()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", useProperty="
         + this.getUseProperty()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeMachinePart)) {
         return false;
      }

      TechChangeMachinePart other = (TechChangeMachinePart)o;
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
            Object this$changeArtifactId = this.getChangeArtifactId();
            Object other$changeArtifactId = other.getChangeArtifactId();
            if (this$changeArtifactId == null ? other$changeArtifactId == null : this$changeArtifactId.equals(other$changeArtifactId)) {
               Object this$changeAssembleId = this.getChangeAssembleId();
               Object other$changeAssembleId = other.getChangeAssembleId();
               if (this$changeAssembleId == null ? other$changeAssembleId == null : this$changeAssembleId.equals(other$changeAssembleId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$artifactRate = this.getArtifactRate();
                     Object other$artifactRate = other.getArtifactRate();
                     if (this$artifactRate == null ? other$artifactRate == null : this$artifactRate.equals(other$artifactRate)) {
                        Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                        Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                        if (this$boolAllPartSendDirectly == null
                           ? other$boolAllPartSendDirectly == null
                           : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                           Object this$boolSendDirectly = this.getBoolSendDirectly();
                           Object other$boolSendDirectly = other.getBoolSendDirectly();
                           if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                              Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                              Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                              if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)
                                 )
                               {
                                 Object this$productClassificationEnum = this.getProductClassificationEnum();
                                 Object other$productClassificationEnum = other.getProductClassificationEnum();
                                 if (this$productClassificationEnum == null
                                    ? other$productClassificationEnum == null
                                    : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                    Object this$relationType = this.getRelationType();
                                    Object other$relationType = other.getRelationType();
                                    if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                       Object this$useProperty = this.getUseProperty();
                                       Object other$useProperty = other.getUseProperty();
                                       if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
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
                                                                        Object this$specPrefix = this.getSpecPrefix();
                                                                        Object other$specPrefix = other.getSpecPrefix();
                                                                        if (this$specPrefix == null
                                                                           ? other$specPrefix == null
                                                                           : this$specPrefix.equals(other$specPrefix)) {
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
                                                                                    return this$uRibPaintArea == null
                                                                                       ? other$uRibPaintArea == null
                                                                                       : this$uRibPaintArea.equals(other$uRibPaintArea);
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechChangeMachinePart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeRecordId = this.getChangeRecordId();
      result = result * 59 + ($changeRecordId == null ? 43 : $changeRecordId.hashCode());
      Object $changeArtifactId = this.getChangeArtifactId();
      result = result * 59 + ($changeArtifactId == null ? 43 : $changeArtifactId.hashCode());
      Object $changeAssembleId = this.getChangeAssembleId();
      result = result * 59 + ($changeAssembleId == null ? 43 : $changeAssembleId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactRate = this.getArtifactRate();
      result = result * 59 + ($artifactRate == null ? 43 : $artifactRate.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
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
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      return result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
   }

   public static class TechChangeMachinePartBuilder {
      private Long id;
      private Long changeRecordId;
      private Long changeArtifactId;
      private Long changeAssembleId;
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
      private Integer artifactRate;
      private String specPrefix;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSendDirectly;
      private Integer steelPlateTypeEnum;
      private Integer productClassificationEnum;
      private Integer relationType;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private Integer useProperty;

      TechChangeMachinePartBuilder() {
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder changeRecordId(final Long changeRecordId) {
         this.changeRecordId = changeRecordId;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder changeArtifactId(final Long changeArtifactId) {
         this.changeArtifactId = changeArtifactId;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder changeAssembleId(final Long changeAssembleId) {
         this.changeAssembleId = changeAssembleId;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder artifactRate(final Integer artifactRate) {
         this.artifactRate = artifactRate;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("relationType")
      public TechChangeMachinePart.TechChangeMachinePartBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public TechChangeMachinePart.TechChangeMachinePartBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechChangeMachinePart build() {
         return new TechChangeMachinePart(
            this.id,
            this.changeRecordId,
            this.changeArtifactId,
            this.changeAssembleId,
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
            this.artifactRate,
            this.specPrefix,
            this.boolAllPartSendDirectly,
            this.boolSendDirectly,
            this.steelPlateTypeEnum,
            this.productClassificationEnum,
            this.relationType,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.useProperty
         );
      }

      @Override
      public String toString() {
         return "TechChangeMachinePart.TechChangeMachinePartBuilder(id="
            + this.id
            + ", changeRecordId="
            + this.changeRecordId
            + ", changeArtifactId="
            + this.changeArtifactId
            + ", changeAssembleId="
            + this.changeAssembleId
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
            + ", artifactRate="
            + this.artifactRate
            + ", specPrefix="
            + this.specPrefix
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", relationType="
            + this.relationType
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", useProperty="
            + this.useProperty
            + ")";
      }
   }
}
