package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "DistributionProductDO", description = "")
public class DistributionProductDO {
   @ApiModelProperty(name = "completeQuantity", notes = "生产数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeTime", notes = "生产日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", notes = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "businessId", notes = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   private Long businessId;
   @ApiModelProperty(name = "assembleId", notes = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   private Long assembleId;
   @ApiModelProperty(name = "assembleSerialNumber", notes = "组立号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", notes = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category")
   private Integer category;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "brand", notes = "品牌（芯材信息）")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   private String brand;
   @ApiModelProperty(name = "type", notes = "种类（芯材信息）")
   @JsonProperty("type")
   @JSONField(name = "type")
   private String type;
   @ApiModelProperty(name = "capacity", notes = "容量（芯材信息）")
   @JsonProperty("capacity")
   @JSONField(name = "capacity")
   private String capacity;

   public static DistributionProductDO.DistributionProductDOBuilder builder() {
      return new DistributionProductDO.DistributionProductDOBuilder();
   }

   public DistributionProductDO(
      final Integer completeQuantity,
      final LocalDateTime completeTime,
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
      final Long businessId,
      final Long assembleId,
      final String assembleSerialNumber,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final Integer category,
      final String plate,
      final String color,
      final BigDecimal weight,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final String brand,
      final String type,
      final String capacity
   ) {
      this.completeQuantity = completeQuantity;
      this.completeTime = completeTime;
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
      this.businessId = businessId;
      this.assembleId = assembleId;
      this.assembleSerialNumber = assembleSerialNumber;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.category = category;
      this.plate = plate;
      this.color = color;
      this.weight = weight;
      this.thickness = thickness;
      this.width = width;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.brand = brand;
      this.type = type;
      this.capacity = capacity;
   }

   public DistributionProductDO() {
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
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

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getCategory() {
      return this.category;
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

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getType() {
      return this.type;
   }

   public String getCapacity() {
      return this.capacity;
   }

   @JsonProperty("completeQuantity")
   public DistributionProductDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeTime")
   public DistributionProductDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("name")
   public DistributionProductDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public DistributionProductDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public DistributionProductDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public DistributionProductDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public DistributionProductDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public DistributionProductDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public DistributionProductDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public DistributionProductDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public DistributionProductDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public DistributionProductDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public DistributionProductDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("drawingNumber")
   public DistributionProductDO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("remark")
   public DistributionProductDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("businessId")
   public DistributionProductDO setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("assembleId")
   public DistributionProductDO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public DistributionProductDO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @JsonProperty("producedQuantity")
   public DistributionProductDO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public DistributionProductDO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("category")
   public DistributionProductDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("plate")
   public DistributionProductDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public DistributionProductDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public DistributionProductDO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public DistributionProductDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public DistributionProductDO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("totalLength")
   public DistributionProductDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public DistributionProductDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("brand")
   public DistributionProductDO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("type")
   public DistributionProductDO setType(final String type) {
      this.type = type;
      return this;
   }

   @JsonProperty("capacity")
   public DistributionProductDO setCapacity(final String capacity) {
      this.capacity = capacity;
      return this;
   }

   @Override
   public String toString() {
      return "DistributionProductDO(completeQuantity="
         + this.getCompleteQuantity()
         + ", completeTime="
         + this.getCompleteTime()
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
         + ", businessId="
         + this.getBusinessId()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", category="
         + this.getCategory()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", brand="
         + this.getBrand()
         + ", type="
         + this.getType()
         + ", capacity="
         + this.getCapacity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DistributionProductDO)) {
         return false;
      }

      DistributionProductDO other = (DistributionProductDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$businessId = this.getBusinessId();
            Object other$businessId = other.getBusinessId();
            if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
               Object this$assembleId = this.getAssembleId();
               Object other$assembleId = other.getAssembleId();
               if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                  Object this$producedQuantity = this.getProducedQuantity();
                  Object other$producedQuantity = other.getProducedQuantity();
                  if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                     Object this$usedQuantity = this.getUsedQuantity();
                     Object other$usedQuantity = other.getUsedQuantity();
                     if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$completeTime = this.getCompleteTime();
                           Object other$completeTime = other.getCompleteTime();
                           if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
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
                                                         if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                            Object this$drawingNumber = this.getDrawingNumber();
                                                            Object other$drawingNumber = other.getDrawingNumber();
                                                            if (this$drawingNumber == null
                                                               ? other$drawingNumber == null
                                                               : this$drawingNumber.equals(other$drawingNumber)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                                  Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                                  if (this$assembleSerialNumber == null
                                                                     ? other$assembleSerialNumber == null
                                                                     : this$assembleSerialNumber.equals(other$assembleSerialNumber)) {
                                                                     Object this$plate = this.getPlate();
                                                                     Object other$plate = other.getPlate();
                                                                     if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                        Object this$color = this.getColor();
                                                                        Object other$color = other.getColor();
                                                                        if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                           Object this$weight = this.getWeight();
                                                                           Object other$weight = other.getWeight();
                                                                           if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                              Object this$thickness = this.getThickness();
                                                                              Object other$thickness = other.getThickness();
                                                                              if (this$thickness == null
                                                                                 ? other$thickness == null
                                                                                 : this$thickness.equals(other$thickness)) {
                                                                                 Object this$width = this.getWidth();
                                                                                 Object other$width = other.getWidth();
                                                                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                    Object this$totalLength = this.getTotalLength();
                                                                                    Object other$totalLength = other.getTotalLength();
                                                                                    if (this$totalLength == null
                                                                                       ? other$totalLength == null
                                                                                       : this$totalLength.equals(other$totalLength)) {
                                                                                       Object this$totalArea = this.getTotalArea();
                                                                                       Object other$totalArea = other.getTotalArea();
                                                                                       if (this$totalArea == null
                                                                                          ? other$totalArea == null
                                                                                          : this$totalArea.equals(other$totalArea)) {
                                                                                          Object this$brand = this.getBrand();
                                                                                          Object other$brand = other.getBrand();
                                                                                          if (this$brand == null
                                                                                             ? other$brand == null
                                                                                             : this$brand.equals(other$brand)) {
                                                                                             Object this$type = this.getType();
                                                                                             Object other$type = other.getType();
                                                                                             if (this$type == null
                                                                                                ? other$type == null
                                                                                                : this$type.equals(other$type)) {
                                                                                                Object this$capacity = this.getCapacity();
                                                                                                Object other$capacity = other.getCapacity();
                                                                                                return this$capacity == null
                                                                                                   ? other$capacity == null
                                                                                                   : this$capacity.equals(other$capacity);
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof DistributionProductDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
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
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $capacity = this.getCapacity();
      return result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
   }

   public static class DistributionProductDOBuilder {
      private Integer completeQuantity;
      private LocalDateTime completeTime;
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
      private Long businessId;
      private Long assembleId;
      private String assembleSerialNumber;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private Integer category;
      private String plate;
      private String color;
      private BigDecimal weight;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private String brand;
      private String type;
      private String capacity;

      DistributionProductDOBuilder() {
      }

      @JsonProperty("completeQuantity")
      public DistributionProductDO.DistributionProductDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeTime")
      public DistributionProductDO.DistributionProductDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("name")
      public DistributionProductDO.DistributionProductDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public DistributionProductDO.DistributionProductDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public DistributionProductDO.DistributionProductDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public DistributionProductDO.DistributionProductDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public DistributionProductDO.DistributionProductDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public DistributionProductDO.DistributionProductDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public DistributionProductDO.DistributionProductDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public DistributionProductDO.DistributionProductDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public DistributionProductDO.DistributionProductDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public DistributionProductDO.DistributionProductDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public DistributionProductDO.DistributionProductDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("drawingNumber")
      public DistributionProductDO.DistributionProductDOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("remark")
      public DistributionProductDO.DistributionProductDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("businessId")
      public DistributionProductDO.DistributionProductDOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("assembleId")
      public DistributionProductDO.DistributionProductDOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public DistributionProductDO.DistributionProductDOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      @JsonProperty("producedQuantity")
      public DistributionProductDO.DistributionProductDOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public DistributionProductDO.DistributionProductDOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("category")
      public DistributionProductDO.DistributionProductDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("plate")
      public DistributionProductDO.DistributionProductDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public DistributionProductDO.DistributionProductDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public DistributionProductDO.DistributionProductDOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public DistributionProductDO.DistributionProductDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public DistributionProductDO.DistributionProductDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("totalLength")
      public DistributionProductDO.DistributionProductDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public DistributionProductDO.DistributionProductDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("brand")
      public DistributionProductDO.DistributionProductDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("type")
      public DistributionProductDO.DistributionProductDOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      @JsonProperty("capacity")
      public DistributionProductDO.DistributionProductDOBuilder capacity(final String capacity) {
         this.capacity = capacity;
         return this;
      }

      public DistributionProductDO build() {
         return new DistributionProductDO(
            this.completeQuantity,
            this.completeTime,
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
            this.businessId,
            this.assembleId,
            this.assembleSerialNumber,
            this.producedQuantity,
            this.usedQuantity,
            this.category,
            this.plate,
            this.color,
            this.weight,
            this.thickness,
            this.width,
            this.totalLength,
            this.totalArea,
            this.brand,
            this.type,
            this.capacity
         );
      }

      @Override
      public String toString() {
         return "DistributionProductDO.DistributionProductDOBuilder(completeQuantity="
            + this.completeQuantity
            + ", completeTime="
            + this.completeTime
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
            + ", businessId="
            + this.businessId
            + ", assembleId="
            + this.assembleId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", category="
            + this.category
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", brand="
            + this.brand
            + ", type="
            + this.type
            + ", capacity="
            + this.capacity
            + ")";
      }
   }
}
