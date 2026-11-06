package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EnclosureBaseInfo {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "项目")
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体(计划)")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域(计划)")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(notes = "车间")
   @JsonInclude(Include.NON_NULL)
   private NameInfo workShop;
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   private String color;
   @ApiModelProperty(name = "material", notes = "材质")
   private String material;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "有效宽度（mm）")
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "length", notes = "单长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "weight", notes = "单重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty("总数量")
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "brand", notes = "品牌")
   private String brand;
   @ApiModelProperty("单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "quantity", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   private BigDecimal totalArea;
   @ApiModelProperty("产品id")
   private Long cargoProductId;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id", notes = "出入库id")
   private Long warehouseRecordId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   private Long packageId;
   @ApiModelProperty(name = "createTime", value = "出入库时间", notes = "出入库时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "createUserNames")
   private String createUserNames;

   public Long getLinkId() {
      return this.linkId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getWorkShop() {
      return this.workShop;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Integer getCategory() {
      return this.category;
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

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getCargoProductId() {
      return this.cargoProductId;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCreateUserNames() {
      return this.createUserNames;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setWorkShop(final NameInfo workShop) {
      this.workShop = workShop;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setCategory(final Integer category) {
      this.category = category;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setCargoProductId(final Long cargoProductId) {
      this.cargoProductId = cargoProductId;
   }

   public void setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setCreateUserNames(final String createUserNames) {
      this.createUserNames = createUserNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureBaseInfo)) {
         return false;
      }

      EnclosureBaseInfo other = (EnclosureBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$cargoProductId = this.getCargoProductId();
            Object other$cargoProductId = other.getCargoProductId();
            if (this$cargoProductId == null ? other$cargoProductId == null : this$cargoProductId.equals(other$cargoProductId)) {
               Object this$warehouseRecordId = this.getWarehouseRecordId();
               Object other$warehouseRecordId = other.getWarehouseRecordId();
               if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
                  Object this$packageId = this.getPackageId();
                  Object other$packageId = other.getPackageId();
                  if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$workShop = this.getWorkShop();
                              Object other$workShop = other.getWorkShop();
                              if (this$workShop == null ? other$workShop == null : this$workShop.equals(other$workShop)) {
                                 Object this$workshopName = this.getWorkshopName();
                                 Object other$workshopName = other.getWorkshopName();
                                 if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$plate = this.getPlate();
                                          Object other$plate = other.getPlate();
                                          if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                             Object this$color = this.getColor();
                                             Object other$color = other.getColor();
                                             if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$thickness = this.getThickness();
                                                   Object other$thickness = other.getThickness();
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                         Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                         if (this$unfoldedWidth == null
                                                            ? other$unfoldedWidth == null
                                                            : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$weight = this.getWeight();
                                                               Object other$weight = other.getWeight();
                                                               if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                  Object this$totalWeight = this.getTotalWeight();
                                                                  Object other$totalWeight = other.getTotalWeight();
                                                                  if (this$totalWeight == null
                                                                     ? other$totalWeight == null
                                                                     : this$totalWeight.equals(other$totalWeight)) {
                                                                     Object this$totalQuantity = this.getTotalQuantity();
                                                                     Object other$totalQuantity = other.getTotalQuantity();
                                                                     if (this$totalQuantity == null
                                                                        ? other$totalQuantity == null
                                                                        : this$totalQuantity.equals(other$totalQuantity)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$surfaceArea = this.getSurfaceArea();
                                                                           Object other$surfaceArea = other.getSurfaceArea();
                                                                           if (this$surfaceArea == null
                                                                              ? other$surfaceArea == null
                                                                              : this$surfaceArea.equals(other$surfaceArea)) {
                                                                              Object this$quantity = this.getQuantity();
                                                                              Object other$quantity = other.getQuantity();
                                                                              if (this$quantity == null
                                                                                 ? other$quantity == null
                                                                                 : this$quantity.equals(other$quantity)) {
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
                                                                                       Object this$createTime = this.getCreateTime();
                                                                                       Object other$createTime = other.getCreateTime();
                                                                                       if (this$createTime == null
                                                                                          ? other$createTime == null
                                                                                          : this$createTime.equals(other$createTime)) {
                                                                                          Object this$createUserNames = this.getCreateUserNames();
                                                                                          Object other$createUserNames = other.getCreateUserNames();
                                                                                          return this$createUserNames == null
                                                                                             ? other$createUserNames == null
                                                                                             : this$createUserNames.equals(other$createUserNames);
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof EnclosureBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $cargoProductId = this.getCargoProductId();
      result = result * 59 + ($cargoProductId == null ? 43 : $cargoProductId.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workShop = this.getWorkShop();
      result = result * 59 + ($workShop == null ? 43 : $workShop.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $createUserNames = this.getCreateUserNames();
      return result * 59 + ($createUserNames == null ? 43 : $createUserNames.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureBaseInfo(linkId="
         + this.getLinkId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workShop="
         + this.getWorkShop()
         + ", workshopName="
         + this.getWorkshopName()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", length="
         + this.getLength()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", brand="
         + this.getBrand()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", cargoProductId="
         + this.getCargoProductId()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", packageId="
         + this.getPackageId()
         + ", createTime="
         + this.getCreateTime()
         + ", createUserNames="
         + this.getCreateUserNames()
         + ")";
   }
}
