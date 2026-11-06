package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel("围护导入记录DTO")
public class TechEnclosureRecordDTO {
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单操作记录表Id", notes = "清单操作记录表Id")
   private Long inventoryOperationId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;
   @ApiModelProperty(name = "dictionaryName", value = "字典名称", notes = "字典名称")
   private String dictionaryName;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型", notes = "版型")
   private String plate;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)", notes = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "板厚(mm)", notes = "板厚(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "单长度(mm)", notes = "单长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(米)")
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)", notes = "单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm²)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "weight", value = "重量(kg)", notes = "重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)", notes = "总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id", notes = "创建人(导入人)id")
   private Long userId;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "品牌", notes = "品牌")
   private String color;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层", notes = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层", notes = "镀层")
   private String plating;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数", notes = "弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "weightMeter", value = "(桁架楼承板)米重(kg/m)", notes = "(桁架楼承板)米重(kg/m)")
   private BigDecimal weightMeter;

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

   public String getDictionaryName() {
      return this.dictionaryName;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDictionaryName(final String dictionaryName) {
      this.dictionaryName = dictionaryName;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   public void setWeightMeter(final BigDecimal weightMeter) {
      this.weightMeter = weightMeter;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureRecordDTO)) {
         return false;
      }

      TechEnclosureRecordDTO other = (TechEnclosureRecordDTO)o;
      if (!other.canEqual(this)) {
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
                                 Object this$dictionaryName = this.getDictionaryName();
                                 Object other$dictionaryName = other.getDictionaryName();
                                 if (this$dictionaryName == null ? other$dictionaryName == null : this$dictionaryName.equals(other$dictionaryName)) {
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
                                                                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)
                                                                     )
                                                                   {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechEnclosureRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $dictionaryName = this.getDictionaryName();
      result = result * 59 + ($dictionaryName == null ? 43 : $dictionaryName.hashCode());
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

   @Override
   public String toString() {
      return "TechEnclosureRecordDTO(id="
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
         + ", dictionaryName="
         + this.getDictionaryName()
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
}
