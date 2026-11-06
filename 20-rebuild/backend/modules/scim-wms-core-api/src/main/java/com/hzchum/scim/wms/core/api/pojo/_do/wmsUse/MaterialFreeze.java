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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MaterialFreeze对象", description = "物料冻结表 ")
@Entity
@TableName("wms_material_freeze")
@Table(name = "wms_material_freeze")
public class MaterialFreeze extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "totalFreezeTypes", value = "包含冻结类型", notes = "包含冻结类型 MaterialFreezeTypeEnum")
   @JsonProperty("totalFreezeTypes")
   @JSONField(name = "totalFreezeTypes")
   @TableField("total_freeze_types")
   @Column(name = "total_freeze_types", columnDefinition = "varchar(255)  COMMENT '包含冻结类型 MaterialFreezeTypeEnum'", nullable = true)
   private String totalFreezeTypes;
   @ApiModelProperty(name = "warehouseType", value = "物料所属", notes = "物料所属")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '物料所属'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
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
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
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
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "totalBasicClass", value = "包含的基础类型", notes = "包含的基础类型")
   @JsonProperty("totalBasicClass")
   @JSONField(name = "totalBasicClass")
   @TableField("total_basic_class")
   @Column(name = "total_basic_class", columnDefinition = "int  COMMENT '包含的基础类型'", nullable = true)
   private Integer totalBasicClass;
   @ApiModelProperty(name = "totalMete", value = "总核算量", notes = "总核算量")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   @TableField("total_mete")
   @Column(name = "total_mete", columnDefinition = "decimal(32,8)  COMMENT '总核算量'", nullable = true)
   private BigDecimal totalMete;
   @ApiModelProperty(name = "totalQuantity", value = "总计量量", notes = "总计量量")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   @TableField("total_quantity")
   @Column(name = "total_quantity", columnDefinition = "decimal(32,8)  COMMENT '总计量量'", nullable = true)
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "standardId", value = "执行的国标ID", notes = "执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "执行的国标名称", notes = "执行的国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '执行的国标名称'", nullable = true)
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
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;

   public static MaterialFreeze.MaterialFreezeBuilder builder() {
      return new MaterialFreeze.MaterialFreezeBuilder();
   }

   public MaterialFreeze() {
   }

   public MaterialFreeze(
      final Long id,
      final Long materialInventoryId,
      final Integer basicClass,
      final Long classifyId,
      final String totalFreezeTypes,
      final Integer warehouseType,
      final Integer materialIsWhole,
      final String specification,
      final Boolean boolPartyA,
      final Long projectId,
      final Long warehouseId,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer totalBasicClass,
      final BigDecimal totalMete,
      final BigDecimal totalQuantity,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final Long workshopId
   ) {
      this.id = id;
      this.materialInventoryId = materialInventoryId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.totalFreezeTypes = totalFreezeTypes;
      this.warehouseType = warehouseType;
      this.materialIsWhole = materialIsWhole;
      this.specification = specification;
      this.boolPartyA = boolPartyA;
      this.projectId = projectId;
      this.warehouseId = warehouseId;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.totalBasicClass = totalBasicClass;
      this.totalMete = totalMete;
      this.totalQuantity = totalQuantity;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getTotalFreezeTypes() {
      return this.totalFreezeTypes;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
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

   public Integer getTotalBasicClass() {
      return this.totalBasicClass;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public MaterialFreeze setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public MaterialFreeze setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("basicClass")
   public MaterialFreeze setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MaterialFreeze setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("totalFreezeTypes")
   public MaterialFreeze setTotalFreezeTypes(final String totalFreezeTypes) {
      this.totalFreezeTypes = totalFreezeTypes;
      return this;
   }

   @JsonProperty("warehouseType")
   public MaterialFreeze setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public MaterialFreeze setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("specification")
   public MaterialFreeze setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MaterialFreeze setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("projectId")
   public MaterialFreeze setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("warehouseId")
   public MaterialFreeze setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("theoryThickness")
   public MaterialFreeze setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public MaterialFreeze setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MaterialFreeze setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public MaterialFreeze setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("totalBasicClass")
   public MaterialFreeze setTotalBasicClass(final Integer totalBasicClass) {
      this.totalBasicClass = totalBasicClass;
      return this;
   }

   @JsonProperty("totalMete")
   public MaterialFreeze setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("totalQuantity")
   public MaterialFreeze setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("length")
   public MaterialFreeze setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("thickness")
   public MaterialFreeze setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public MaterialFreeze setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("standardId")
   public MaterialFreeze setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MaterialFreeze setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("monomerId")
   public MaterialFreeze setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MaterialFreeze setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public MaterialFreeze setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "MaterialFreeze(id="
         + this.getId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", totalFreezeTypes="
         + this.getTotalFreezeTypes()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", specification="
         + this.getSpecification()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", projectId="
         + this.getProjectId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", totalBasicClass="
         + this.getTotalBasicClass()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreeze)) {
         return false;
      }

      MaterialFreeze other = (MaterialFreeze)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$warehouseType = this.getWarehouseType();
                  Object other$warehouseType = other.getWarehouseType();
                  if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                     Object this$materialIsWhole = this.getMaterialIsWhole();
                     Object other$materialIsWhole = other.getMaterialIsWhole();
                     if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                        Object this$boolPartyA = this.getBoolPartyA();
                        Object other$boolPartyA = other.getBoolPartyA();
                        if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                              Object this$warehouseId = this.getWarehouseId();
                              Object other$warehouseId = other.getWarehouseId();
                              if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                 Object this$totalBasicClass = this.getTotalBasicClass();
                                 Object other$totalBasicClass = other.getTotalBasicClass();
                                 if (this$totalBasicClass == null ? other$totalBasicClass == null : this$totalBasicClass.equals(other$totalBasicClass)) {
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
                                                Object this$totalFreezeTypes = this.getTotalFreezeTypes();
                                                Object other$totalFreezeTypes = other.getTotalFreezeTypes();
                                                if (this$totalFreezeTypes == null
                                                   ? other$totalFreezeTypes == null
                                                   : this$totalFreezeTypes.equals(other$totalFreezeTypes)) {
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
                                                                  Object this$totalMete = this.getTotalMete();
                                                                  Object other$totalMete = other.getTotalMete();
                                                                  if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)
                                                                     )
                                                                   {
                                                                     Object this$totalQuantity = this.getTotalQuantity();
                                                                     Object other$totalQuantity = other.getTotalQuantity();
                                                                     if (this$totalQuantity == null
                                                                        ? other$totalQuantity == null
                                                                        : this$totalQuantity.equals(other$totalQuantity)) {
                                                                        Object this$length = this.getLength();
                                                                        Object other$length = other.getLength();
                                                                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$width = this.getWidth();
                                                                              Object other$width = other.getWidth();
                                                                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MaterialFreeze;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $totalBasicClass = this.getTotalBasicClass();
      result = result * 59 + ($totalBasicClass == null ? 43 : $totalBasicClass.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $totalFreezeTypes = this.getTotalFreezeTypes();
      result = result * 59 + ($totalFreezeTypes == null ? 43 : $totalFreezeTypes.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $standardName = this.getStandardName();
      return result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
   }

   public static class MaterialFreezeBuilder {
      private Long id;
      private Long materialInventoryId;
      private Integer basicClass;
      private Long classifyId;
      private String totalFreezeTypes;
      private Integer warehouseType;
      private Integer materialIsWhole;
      private String specification;
      private Boolean boolPartyA;
      private Long projectId;
      private Long warehouseId;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer totalBasicClass;
      private BigDecimal totalMete;
      private BigDecimal totalQuantity;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;

      MaterialFreezeBuilder() {
      }

      @JsonProperty("id")
      public MaterialFreeze.MaterialFreezeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public MaterialFreeze.MaterialFreezeBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("basicClass")
      public MaterialFreeze.MaterialFreezeBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MaterialFreeze.MaterialFreezeBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("totalFreezeTypes")
      public MaterialFreeze.MaterialFreezeBuilder totalFreezeTypes(final String totalFreezeTypes) {
         this.totalFreezeTypes = totalFreezeTypes;
         return this;
      }

      @JsonProperty("warehouseType")
      public MaterialFreeze.MaterialFreezeBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public MaterialFreeze.MaterialFreezeBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("specification")
      public MaterialFreeze.MaterialFreezeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MaterialFreeze.MaterialFreezeBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("projectId")
      public MaterialFreeze.MaterialFreezeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("warehouseId")
      public MaterialFreeze.MaterialFreezeBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("theoryThickness")
      public MaterialFreeze.MaterialFreezeBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public MaterialFreeze.MaterialFreezeBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MaterialFreeze.MaterialFreezeBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public MaterialFreeze.MaterialFreezeBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("totalBasicClass")
      public MaterialFreeze.MaterialFreezeBuilder totalBasicClass(final Integer totalBasicClass) {
         this.totalBasicClass = totalBasicClass;
         return this;
      }

      @JsonProperty("totalMete")
      public MaterialFreeze.MaterialFreezeBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("totalQuantity")
      public MaterialFreeze.MaterialFreezeBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("length")
      public MaterialFreeze.MaterialFreezeBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("thickness")
      public MaterialFreeze.MaterialFreezeBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public MaterialFreeze.MaterialFreezeBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("standardId")
      public MaterialFreeze.MaterialFreezeBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MaterialFreeze.MaterialFreezeBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("monomerId")
      public MaterialFreeze.MaterialFreezeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MaterialFreeze.MaterialFreezeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public MaterialFreeze.MaterialFreezeBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MaterialFreeze build() {
         return new MaterialFreeze(
            this.id,
            this.materialInventoryId,
            this.basicClass,
            this.classifyId,
            this.totalFreezeTypes,
            this.warehouseType,
            this.materialIsWhole,
            this.specification,
            this.boolPartyA,
            this.projectId,
            this.warehouseId,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.totalBasicClass,
            this.totalMete,
            this.totalQuantity,
            this.length,
            this.thickness,
            this.width,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "MaterialFreeze.MaterialFreezeBuilder(id="
            + this.id
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", totalFreezeTypes="
            + this.totalFreezeTypes
            + ", warehouseType="
            + this.warehouseType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", specification="
            + this.specification
            + ", boolPartyA="
            + this.boolPartyA
            + ", projectId="
            + this.projectId
            + ", warehouseId="
            + this.warehouseId
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", totalBasicClass="
            + this.totalBasicClass
            + ", totalMete="
            + this.totalMete
            + ", totalQuantity="
            + this.totalQuantity
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
