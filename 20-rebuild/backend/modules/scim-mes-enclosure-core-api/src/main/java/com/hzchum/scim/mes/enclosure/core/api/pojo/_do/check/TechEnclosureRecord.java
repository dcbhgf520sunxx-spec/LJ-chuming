package com.hzchum.scim.mes.enclosure.core.api.pojo._do.check;

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

@ApiModel(value = "TechEnclosureRecord对象", description = "")
@Entity
@TableName("tech_enclosure_record")
@Table(name = "tech_enclosure_record")
@org.hibernate.annotations.Table(appliesTo = "tech_enclosure_record")
public class TechEnclosureRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单操作记录表Id", notes = "清单操作记录表Id")
   @TableField("inventory_operation_id")
   @Column(name = "inventory_operation_id", columnDefinition = "bigint  COMMENT '清单操作记录表Id'", nullable = false)
   private Long inventoryOperationId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint default '0' COMMENT '区域ID'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(11) comment '字典类型'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型", notes = "版型")
   @TableField("plate")
   @Column(name = "plate", columnDefinition = "varchar(255)  COMMENT '版型'", nullable = false)
   private String plate;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)", notes = "展宽(mm)")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width", columnDefinition = "decimal(32,4)  COMMENT '展宽(mm)'", nullable = false)
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,4)  COMMENT '有效宽度(mm)'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "板厚(mm)", notes = "板厚(mm)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,4)  COMMENT '板厚(mm)'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "单长度(mm)", notes = "单长度(mm)")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) default '0.0000' COMMENT '单长度(mm)'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(米)")
   @TableField("accounting_volume")
   @Column(name = "accounting_volume", columnDefinition = "decimal(32,4) default 0.0 comment '核算量(米)'", nullable = false)
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "unit", value = "计量单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = " varchar(255) comment '计量单位'", nullable = false)
   private String unit;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)", notes = "单面积(mm²)")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单面积(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm²)")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) default 0.0 comment '总面积(mm²)'", nullable = false)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "weight", value = "重量(kg)", notes = "重量(kg)")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '重量(kg)'", nullable = false)
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) default 0.0 comment '总重量(kg)'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id", notes = "创建人(导入人)id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '创建人(导入人)id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "品牌", notes = "品牌")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String color;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层", notes = "涂层")
   @TableField("coating")
   @Column(name = "coating", columnDefinition = "varchar(255)  COMMENT '涂层'", nullable = true)
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层", notes = "镀层")
   @TableField("plating")
   @Column(name = "plating", columnDefinition = "varchar(255)  COMMENT '镀层'", nullable = true)
   private String plating;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数", notes = "弯折次数")
   @TableField("bend_times")
   @Column(name = "bend_times", columnDefinition = "int default '0' COMMENT '弯折次数'", nullable = false)
   private Integer bendTimes;
   @ApiModelProperty(name = "weightMeter", value = "(桁架楼承板)米重(kg/m)", notes = "(桁架楼承板)米重(kg/m)")
   @TableField("weight_meter")
   @Column(name = "weight_meter", columnDefinition = "decimal(18,4)  COMMENT '(桁架楼承板)米重(kg/m)'", nullable = true)
   private BigDecimal weightMeter;

   public static TechEnclosureRecord.TechEnclosureRecordBuilder builder() {
      return new TechEnclosureRecord.TechEnclosureRecordBuilder();
   }

   public TechEnclosureRecord() {
   }

   public TechEnclosureRecord(
      final Long id,
      final Long projectId,
      final Long inventoryOperationId,
      final Long monomerId,
      final Long areaId,
      final Long dictionaryId,
      final String name,
      final String serialNumber,
      final String plate,
      final BigDecimal unfoldedWidth,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal accountingVolume,
      final String unit,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final Long userId,
      final String brand,
      final String color,
      final String material,
      final String coating,
      final String plating,
      final String remark,
      final Integer bendTimes,
      final BigDecimal weightMeter
   ) {
      this.id = id;
      this.projectId = projectId;
      this.inventoryOperationId = inventoryOperationId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.dictionaryId = dictionaryId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.unfoldedWidth = unfoldedWidth;
      this.width = width;
      this.thickness = thickness;
      this.length = length;
      this.quantity = quantity;
      this.accountingVolume = accountingVolume;
      this.unit = unit;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.userId = userId;
      this.brand = brand;
      this.color = color;
      this.material = material;
      this.coating = coating;
      this.plating = plating;
      this.remark = remark;
      this.bendTimes = bendTimes;
      this.weightMeter = weightMeter;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAccountingVolume() {
      return this.accountingVolume;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public BigDecimal getWeightMeter() {
      return this.weightMeter;
   }

   public TechEnclosureRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechEnclosureRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechEnclosureRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechEnclosureRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechEnclosureRecord setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public TechEnclosureRecord setName(final String name) {
      this.name = name;
      return this;
   }

   public TechEnclosureRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechEnclosureRecord setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public TechEnclosureRecord setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   public TechEnclosureRecord setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public TechEnclosureRecord setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public TechEnclosureRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechEnclosureRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechEnclosureRecord setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
      return this;
   }

   public TechEnclosureRecord setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public TechEnclosureRecord setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechEnclosureRecord setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public TechEnclosureRecord setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public TechEnclosureRecord setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public TechEnclosureRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechEnclosureRecord setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public TechEnclosureRecord setColor(final String color) {
      this.color = color;
      return this;
   }

   public TechEnclosureRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechEnclosureRecord setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   public TechEnclosureRecord setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   public TechEnclosureRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechEnclosureRecord setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   public TechEnclosureRecord setWeightMeter(final BigDecimal weightMeter) {
      this.weightMeter = weightMeter;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", accountingVolume="
         + this.getAccountingVolume()
         + ", unit="
         + this.getUnit()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", userId="
         + this.getUserId()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", remark="
         + this.getRemark()
         + ", bendTimes="
         + this.getBendTimes()
         + ", weightMeter="
         + this.getWeightMeter()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureRecord)) {
         return false;
      }

      TechEnclosureRecord other = (TechEnclosureRecord)o;
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
            Object this$inventoryOperationId = this.getInventoryOperationId();
            Object other$inventoryOperationId = other.getInventoryOperationId();
            if (this$inventoryOperationId == null ? other$inventoryOperationId == null : this$inventoryOperationId.equals(other$inventoryOperationId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$dictionaryId = this.getDictionaryId();
                     Object other$dictionaryId = other.getDictionaryId();
                     if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$bendTimes = this.getBendTimes();
                              Object other$bendTimes = other.getBendTimes();
                              if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$plate = this.getPlate();
                                       Object other$plate = other.getPlate();
                                       if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                          Object this$unfoldedWidth = this.getUnfoldedWidth();
                                          Object other$unfoldedWidth = other.getUnfoldedWidth();
                                          if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$accountingVolume = this.getAccountingVolume();
                                                      Object other$accountingVolume = other.getAccountingVolume();
                                                      if (this$accountingVolume == null
                                                         ? other$accountingVolume == null
                                                         : this$accountingVolume.equals(other$accountingVolume)) {
                                                         Object this$unit = this.getUnit();
                                                         Object other$unit = other.getUnit();
                                                         if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                            Object this$surfaceArea = this.getSurfaceArea();
                                                            Object other$surfaceArea = other.getSurfaceArea();
                                                            if (this$surfaceArea == null
                                                               ? other$surfaceArea == null
                                                               : this$surfaceArea.equals(other$surfaceArea)) {
                                                               Object this$totalArea = this.getTotalArea();
                                                               Object other$totalArea = other.getTotalArea();
                                                               if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                                  Object this$weight = this.getWeight();
                                                                  Object other$weight = other.getWeight();
                                                                  if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                     Object this$totalWeight = this.getTotalWeight();
                                                                     Object other$totalWeight = other.getTotalWeight();
                                                                     if (this$totalWeight == null
                                                                        ? other$totalWeight == null
                                                                        : this$totalWeight.equals(other$totalWeight)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$material = this.getMaterial();
                                                                              Object other$material = other.getMaterial();
                                                                              if (this$material == null
                                                                                 ? other$material == null
                                                                                 : this$material.equals(other$material)) {
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
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$weightMeter = this.getWeightMeter();
                                                                                          Object other$weightMeter = other.getWeightMeter();
                                                                                          return this$weightMeter == null
                                                                                             ? other$weightMeter == null
                                                                                             : this$weightMeter.equals(other$weightMeter);
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechEnclosureRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $accountingVolume = this.getAccountingVolume();
      result = result * 59 + ($accountingVolume == null ? 43 : $accountingVolume.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $weightMeter = this.getWeightMeter();
      return result * 59 + ($weightMeter == null ? 43 : $weightMeter.hashCode());
   }

   public static class TechEnclosureRecordBuilder {
      private Long id;
      private Long projectId;
      private Long inventoryOperationId;
      private Long monomerId;
      private Long areaId;
      private Long dictionaryId;
      private String name;
      private String serialNumber;
      private String plate;
      private BigDecimal unfoldedWidth;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal accountingVolume;
      private String unit;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private Long userId;
      private String brand;
      private String color;
      private String material;
      private String coating;
      private String plating;
      private String remark;
      private Integer bendTimes;
      private BigDecimal weightMeter;

      TechEnclosureRecordBuilder() {
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder accountingVolume(final BigDecimal accountingVolume) {
         this.accountingVolume = accountingVolume;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public TechEnclosureRecord.TechEnclosureRecordBuilder weightMeter(final BigDecimal weightMeter) {
         this.weightMeter = weightMeter;
         return this;
      }

      public TechEnclosureRecord build() {
         return new TechEnclosureRecord(
            this.id,
            this.projectId,
            this.inventoryOperationId,
            this.monomerId,
            this.areaId,
            this.dictionaryId,
            this.name,
            this.serialNumber,
            this.plate,
            this.unfoldedWidth,
            this.width,
            this.thickness,
            this.length,
            this.quantity,
            this.accountingVolume,
            this.unit,
            this.surfaceArea,
            this.totalArea,
            this.weight,
            this.totalWeight,
            this.userId,
            this.brand,
            this.color,
            this.material,
            this.coating,
            this.plating,
            this.remark,
            this.bendTimes,
            this.weightMeter
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureRecord.TechEnclosureRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", dictionaryId="
            + this.dictionaryId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", accountingVolume="
            + this.accountingVolume
            + ", unit="
            + this.unit
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", userId="
            + this.userId
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", remark="
            + this.remark
            + ", bendTimes="
            + this.bendTimes
            + ", weightMeter="
            + this.weightMeter
            + ")";
      }
   }
}
