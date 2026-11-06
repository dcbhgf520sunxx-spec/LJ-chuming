package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("构件基本信息")
public class ArtifactBaseInfo {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "项目")
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(notes = "批次")
   @JsonInclude(Include.NON_NULL)
   private NameInfo areaBatch;
   @ApiModelProperty(notes = "车间")
   @JsonInclude(Include.NON_NULL)
   private NameInfo workShop;
   @ApiModelProperty("车间名称")
   private String workshopName;
   @ApiModelProperty("产线名称")
   private String productionLineName;
   @ApiModelProperty("产品id")
   private Long cargoProductId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("参与计算重量（kg）")
   private BigDecimal weight;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty("总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重（kg）")
   private BigDecimal drawingWeight;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("图号")
   private String drawingNumber;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id", notes = "出入库id")
   private Long warehouseRecordId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   private Long packageId;
   @ApiModelProperty(name = "createTime", value = "出入库时间", notes = "出入库时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "产品类型名称", value = "产品类型名称）")
   private String typeName;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolShowSign", value = "页面是否显示角标")
   private Boolean boolShowSign;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
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

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public NameInfo getWorkShop() {
      return this.workShop;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getCargoProductId() {
      return this.cargoProductId;
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

   public BigDecimal getWeight() {
      return this.weight;
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

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolShowSign() {
      return this.boolShowSign;
   }

   public Integer getCodingType() {
      return this.codingType;
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

   public void setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   public void setWorkShop(final NameInfo workShop) {
      this.workShop = workShop;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   public void setCargoProductId(final Long cargoProductId) {
      this.cargoProductId = cargoProductId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolShowSign(final Boolean boolShowSign) {
      this.boolShowSign = boolShowSign;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setCreateUserNames(final String createUserNames) {
      this.createUserNames = createUserNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBaseInfo)) {
         return false;
      }

      ArtifactBaseInfo other = (ArtifactBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$cargoProductId = this.getCargoProductId();
         Object other$cargoProductId = other.getCargoProductId();
         if (this$cargoProductId == null ? other$cargoProductId == null : this$cargoProductId.equals(other$cargoProductId)) {
            Object this$warehouseRecordId = this.getWarehouseRecordId();
            Object other$warehouseRecordId = other.getWarehouseRecordId();
            if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
               Object this$packageId = this.getPackageId();
               Object other$packageId = other.getPackageId();
               if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                  Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                  Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                  if (this$boolAllPartSendDirectly == null
                     ? other$boolAllPartSendDirectly == null
                     : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                     Object this$boolShowSign = this.getBoolShowSign();
                     Object other$boolShowSign = other.getBoolShowSign();
                     if (this$boolShowSign == null ? other$boolShowSign == null : this$boolShowSign.equals(other$boolShowSign)) {
                        Object this$codingType = this.getCodingType();
                        Object other$codingType = other.getCodingType();
                        if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$areaBatch = this.getAreaBatch();
                                    Object other$areaBatch = other.getAreaBatch();
                                    if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                       Object this$workShop = this.getWorkShop();
                                       Object other$workShop = other.getWorkShop();
                                       if (this$workShop == null ? other$workShop == null : this$workShop.equals(other$workShop)) {
                                          Object this$workshopName = this.getWorkshopName();
                                          Object other$workshopName = other.getWorkshopName();
                                          if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                             Object this$productionLineName = this.getProductionLineName();
                                             Object other$productionLineName = other.getProductionLineName();
                                             if (this$productionLineName == null
                                                ? other$productionLineName == null
                                                : this$productionLineName.equals(other$productionLineName)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                                                            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                               Object this$weight = this.getWeight();
                                                               Object other$weight = other.getWeight();
                                                               if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
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
                                                                              Object this$drawingWeight = this.getDrawingWeight();
                                                                              Object other$drawingWeight = other.getDrawingWeight();
                                                                              if (this$drawingWeight == null
                                                                                 ? other$drawingWeight == null
                                                                                 : this$drawingWeight.equals(other$drawingWeight)) {
                                                                                 Object this$quantity = this.getQuantity();
                                                                                 Object other$quantity = other.getQuantity();
                                                                                 if (this$quantity == null
                                                                                    ? other$quantity == null
                                                                                    : this$quantity.equals(other$quantity)) {
                                                                                    Object this$drawingNumber = this.getDrawingNumber();
                                                                                    Object other$drawingNumber = other.getDrawingNumber();
                                                                                    if (this$drawingNumber == null
                                                                                       ? other$drawingNumber == null
                                                                                       : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                       Object this$createTime = this.getCreateTime();
                                                                                       Object other$createTime = other.getCreateTime();
                                                                                       if (this$createTime == null
                                                                                          ? other$createTime == null
                                                                                          : this$createTime.equals(other$createTime)) {
                                                                                          Object this$surfaceArea = this.getSurfaceArea();
                                                                                          Object other$surfaceArea = other.getSurfaceArea();
                                                                                          if (this$surfaceArea == null
                                                                                             ? other$surfaceArea == null
                                                                                             : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                             Object this$typeName = this.getTypeName();
                                                                                             Object other$typeName = other.getTypeName();
                                                                                             if (this$typeName == null
                                                                                                ? other$typeName == null
                                                                                                : this$typeName.equals(other$typeName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $cargoProductId = this.getCargoProductId();
      result = result * 59 + ($cargoProductId == null ? 43 : $cargoProductId.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolShowSign = this.getBoolShowSign();
      result = result * 59 + ($boolShowSign == null ? 43 : $boolShowSign.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $workShop = this.getWorkShop();
      result = result * 59 + ($workShop == null ? 43 : $workShop.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
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
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $createUserNames = this.getCreateUserNames();
      return result * 59 + ($createUserNames == null ? 43 : $createUserNames.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactBaseInfo(linkId="
         + this.getLinkId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", workShop="
         + this.getWorkShop()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", cargoProductId="
         + this.getCargoProductId()
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
         + ", weight="
         + this.getWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", quantity="
         + this.getQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", packageId="
         + this.getPackageId()
         + ", createTime="
         + this.getCreateTime()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", typeName="
         + this.getTypeName()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolShowSign="
         + this.getBoolShowSign()
         + ", codingType="
         + this.getCodingType()
         + ", createUserNames="
         + this.getCreateUserNames()
         + ")";
   }
}
