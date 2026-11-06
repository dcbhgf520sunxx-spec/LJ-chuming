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

@ApiModel(value = "Barcode对象", description = "条形码记录表 ")
@Entity
@TableName("wms_barcode")
@Table(name = "wms_barcode")
public class Barcode extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础分类[1 钢板,2 型材,3 钢卷]", notes = "基础分类[1 钢板,2 型材,3 钢卷]")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础分类[1 钢板,2 型材,3 钢卷]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "type", value = "物料状态[0 公共整料,1 公共余料,2 项目整料,3 项目余料,4 甲供整料,5 甲供余料]", notes = "物料状态[0 公共整料,1 公共余料,2 项目整料,3 项目余料,4 甲供整料,5 甲供余料]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '物料状态[0 公共整料,1 公共余料,2 项目整料,3 项目余料,4 甲供整料,5 甲供余料]'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "frontSerialNumber", value = "前五项目流水号", notes = "前五项目流水号")
   @JsonProperty("frontSerialNumber")
   @JSONField(name = "frontSerialNumber")
   @TableField("front_serial_number")
   @Column(name = "front_serial_number", columnDefinition = "bigint  COMMENT '前五项目流水号'", nullable = true)
   private Long frontSerialNumber;
   @ApiModelProperty(name = "afterSerialNumber", value = "后五材料流水号", notes = "后五材料流水号")
   @JsonProperty("afterSerialNumber")
   @JSONField(name = "afterSerialNumber")
   @TableField("after_serial_number")
   @Column(name = "after_serial_number", columnDefinition = "bigint  COMMENT '后五材料流水号'", nullable = true)
   private Long afterSerialNumber;
   @ApiModelProperty(name = "publicSerialNumber", value = "公共库材料流水号", notes = "公共库材料流水号")
   @JsonProperty("publicSerialNumber")
   @JSONField(name = "publicSerialNumber")
   @TableField("public_serial_number")
   @Column(name = "public_serial_number", columnDefinition = "bigint  COMMENT '公共库材料流水号'", nullable = true)
   private Long publicSerialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)", notes = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态(1 整料, 余料)'", nullable = true)
   private Integer materialIsWhole;
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
   @ApiModelProperty(name = "value", value = "条形码", notes = "条形码")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(255)  COMMENT '条形码'", nullable = true)
   private String value;
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
   @ApiModelProperty(name = "warehouseId")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;

   public static Barcode.BarcodeBuilder builder() {
      return new Barcode.BarcodeBuilder();
   }

   public Barcode() {
   }

   public Barcode(
      final Long id,
      final Integer basicClass,
      final Integer type,
      final Long frontSerialNumber,
      final Long afterSerialNumber,
      final Long publicSerialNumber,
      final String specification,
      final Integer materialIsWhole,
      final Long projectId,
      final Boolean boolPartyA,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long standardId,
      final String standardName,
      final String value,
      final Long monomerId,
      final Long areaId,
      final Long warehouseId,
      final Long workshopId
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.type = type;
      this.frontSerialNumber = frontSerialNumber;
      this.afterSerialNumber = afterSerialNumber;
      this.publicSerialNumber = publicSerialNumber;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.standardId = standardId;
      this.standardName = standardName;
      this.value = value;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.warehouseId = warehouseId;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getFrontSerialNumber() {
      return this.frontSerialNumber;
   }

   public Long getAfterSerialNumber() {
      return this.afterSerialNumber;
   }

   public Long getPublicSerialNumber() {
      return this.publicSerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getValue() {
      return this.value;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public Barcode setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public Barcode setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("type")
   public Barcode setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("frontSerialNumber")
   public Barcode setFrontSerialNumber(final Long frontSerialNumber) {
      this.frontSerialNumber = frontSerialNumber;
      return this;
   }

   @JsonProperty("afterSerialNumber")
   public Barcode setAfterSerialNumber(final Long afterSerialNumber) {
      this.afterSerialNumber = afterSerialNumber;
      return this;
   }

   @JsonProperty("publicSerialNumber")
   public Barcode setPublicSerialNumber(final Long publicSerialNumber) {
      this.publicSerialNumber = publicSerialNumber;
      return this;
   }

   @JsonProperty("specification")
   public Barcode setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public Barcode setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("projectId")
   public Barcode setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Barcode setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("length")
   public Barcode setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public Barcode setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public Barcode setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public Barcode setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public Barcode setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public Barcode setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("standardId")
   public Barcode setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public Barcode setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("value")
   public Barcode setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("monomerId")
   public Barcode setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public Barcode setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("warehouseId")
   public Barcode setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("workshopId")
   public Barcode setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "Barcode(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", type="
         + this.getType()
         + ", frontSerialNumber="
         + this.getFrontSerialNumber()
         + ", afterSerialNumber="
         + this.getAfterSerialNumber()
         + ", publicSerialNumber="
         + this.getPublicSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
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
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", value="
         + this.getValue()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Barcode)) {
         return false;
      }

      Barcode other = (Barcode)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$frontSerialNumber = this.getFrontSerialNumber();
               Object other$frontSerialNumber = other.getFrontSerialNumber();
               if (this$frontSerialNumber == null ? other$frontSerialNumber == null : this$frontSerialNumber.equals(other$frontSerialNumber)) {
                  Object this$afterSerialNumber = this.getAfterSerialNumber();
                  Object other$afterSerialNumber = other.getAfterSerialNumber();
                  if (this$afterSerialNumber == null ? other$afterSerialNumber == null : this$afterSerialNumber.equals(other$afterSerialNumber)) {
                     Object this$publicSerialNumber = this.getPublicSerialNumber();
                     Object other$publicSerialNumber = other.getPublicSerialNumber();
                     if (this$publicSerialNumber == null ? other$publicSerialNumber == null : this$publicSerialNumber.equals(other$publicSerialNumber)) {
                        Object this$materialIsWhole = this.getMaterialIsWhole();
                        Object other$materialIsWhole = other.getMaterialIsWhole();
                        if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                                          Object this$warehouseId = this.getWarehouseId();
                                          Object other$warehouseId = other.getWarehouseId();
                                          if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                             Object this$workshopId = this.getWorkshopId();
                                             Object other$workshopId = other.getWorkshopId();
                                             if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$thickness = this.getThickness();
                                                         Object other$thickness = other.getThickness();
                                                         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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
                                                                     Object this$standardName = this.getStandardName();
                                                                     Object other$standardName = other.getStandardName();
                                                                     if (this$standardName == null
                                                                        ? other$standardName == null
                                                                        : this$standardName.equals(other$standardName)) {
                                                                        Object this$value = this.getValue();
                                                                        Object other$value = other.getValue();
                                                                        return this$value == null ? other$value == null : this$value.equals(other$value);
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Barcode;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $frontSerialNumber = this.getFrontSerialNumber();
      result = result * 59 + ($frontSerialNumber == null ? 43 : $frontSerialNumber.hashCode());
      Object $afterSerialNumber = this.getAfterSerialNumber();
      result = result * 59 + ($afterSerialNumber == null ? 43 : $afterSerialNumber.hashCode());
      Object $publicSerialNumber = this.getPublicSerialNumber();
      result = result * 59 + ($publicSerialNumber == null ? 43 : $publicSerialNumber.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
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
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class BarcodeBuilder {
      private Long id;
      private Integer basicClass;
      private Integer type;
      private Long frontSerialNumber;
      private Long afterSerialNumber;
      private Long publicSerialNumber;
      private String specification;
      private Integer materialIsWhole;
      private Long projectId;
      private Boolean boolPartyA;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long standardId;
      private String standardName;
      private String value;
      private Long monomerId;
      private Long areaId;
      private Long warehouseId;
      private Long workshopId;

      BarcodeBuilder() {
      }

      @JsonProperty("id")
      public Barcode.BarcodeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public Barcode.BarcodeBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("type")
      public Barcode.BarcodeBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("frontSerialNumber")
      public Barcode.BarcodeBuilder frontSerialNumber(final Long frontSerialNumber) {
         this.frontSerialNumber = frontSerialNumber;
         return this;
      }

      @JsonProperty("afterSerialNumber")
      public Barcode.BarcodeBuilder afterSerialNumber(final Long afterSerialNumber) {
         this.afterSerialNumber = afterSerialNumber;
         return this;
      }

      @JsonProperty("publicSerialNumber")
      public Barcode.BarcodeBuilder publicSerialNumber(final Long publicSerialNumber) {
         this.publicSerialNumber = publicSerialNumber;
         return this;
      }

      @JsonProperty("specification")
      public Barcode.BarcodeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public Barcode.BarcodeBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("projectId")
      public Barcode.BarcodeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Barcode.BarcodeBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("length")
      public Barcode.BarcodeBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public Barcode.BarcodeBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public Barcode.BarcodeBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public Barcode.BarcodeBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public Barcode.BarcodeBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public Barcode.BarcodeBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("standardId")
      public Barcode.BarcodeBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public Barcode.BarcodeBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("value")
      public Barcode.BarcodeBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("monomerId")
      public Barcode.BarcodeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public Barcode.BarcodeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("warehouseId")
      public Barcode.BarcodeBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("workshopId")
      public Barcode.BarcodeBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public Barcode build() {
         return new Barcode(
            this.id,
            this.basicClass,
            this.type,
            this.frontSerialNumber,
            this.afterSerialNumber,
            this.publicSerialNumber,
            this.specification,
            this.materialIsWhole,
            this.projectId,
            this.boolPartyA,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.standardId,
            this.standardName,
            this.value,
            this.monomerId,
            this.areaId,
            this.warehouseId,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "Barcode.BarcodeBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", type="
            + this.type
            + ", frontSerialNumber="
            + this.frontSerialNumber
            + ", afterSerialNumber="
            + this.afterSerialNumber
            + ", publicSerialNumber="
            + this.publicSerialNumber
            + ", specification="
            + this.specification
            + ", materialIsWhole="
            + this.materialIsWhole
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
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", value="
            + this.value
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", warehouseId="
            + this.warehouseId
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
