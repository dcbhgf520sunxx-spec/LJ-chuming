package com.hzchum.scim.mes.building.core.api.pojo._dto._package;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class PackageLinkDetailsCommonDTO {
   @ApiModelProperty(notes = "包详情id")
   private Long linkId;
   @ApiModelProperty(notes = "包id")
   private Long packageId;
   @ApiModelProperty(notes = "包单号")
   private String packageSerialNumber;
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
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
   @ApiModelProperty("清单数量")
   private BigDecimal quantity;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty("总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   private BigDecimal totalArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "enclosureMeasureModeEnum", value = "围护结算方式 1长度计价 2面积计价")
   private Integer enclosureMeasureModeEnum;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(notes = "入库数量")
   private BigDecimal inQuantity;
   @ApiModelProperty("打包数")
   private BigDecimal packageQuantity;
   @ApiModelProperty("库存数量(包含当前包数量)")
   private BigDecimal unPackageQuantity;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty("编号列表")
   private List<ArtifactStockNumberDO> numberList;
   @ApiModelProperty(name = "createUserNames")
   private String createUserNames;

   public static PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder builder() {
      return new PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder();
   }

   public PackageLinkDetailsCommonDTO() {
   }

   public PackageLinkDetailsCommonDTO(
      final Long linkId,
      final Long packageId,
      final String packageSerialNumber,
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Integer productType,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer enclosureMeasureModeEnum,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal inQuantity,
      final BigDecimal packageQuantity,
      final BigDecimal unPackageQuantity,
      final Boolean boolOneCode,
      final List<ArtifactStockNumberDO> numberList,
      final String createUserNames
   ) {
      this.linkId = linkId;
      this.packageId = packageId;
      this.packageSerialNumber = packageSerialNumber;
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productType = productType;
      this.productId = productId;
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
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.enclosureMeasureModeEnum = enclosureMeasureModeEnum;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
      this.boolOneCode = boolOneCode;
      this.numberList = numberList;
      this.createUserNames = createUserNames;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public String getPackageSerialNumber() {
      return this.packageSerialNumber;
   }

   public Long getId() {
      return this.id;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
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

   public BigDecimal getQuantity() {
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getEnclosureMeasureModeEnum() {
      return this.enclosureMeasureModeEnum;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getInQuantity() {
      return this.inQuantity;
   }

   public BigDecimal getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public List<ArtifactStockNumberDO> getNumberList() {
      return this.numberList;
   }

   public String getCreateUserNames() {
      return this.createUserNames;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setPackageSerialNumber(final String packageSerialNumber) {
      this.packageSerialNumber = packageSerialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
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

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setEnclosureMeasureModeEnum(final Integer enclosureMeasureModeEnum) {
      this.enclosureMeasureModeEnum = enclosureMeasureModeEnum;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setInQuantity(final BigDecimal inQuantity) {
      this.inQuantity = inQuantity;
   }

   public void setPackageQuantity(final BigDecimal packageQuantity) {
      this.packageQuantity = packageQuantity;
   }

   public void setUnPackageQuantity(final BigDecimal unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   public void setNumberList(final List<ArtifactStockNumberDO> numberList) {
      this.numberList = numberList;
   }

   public void setCreateUserNames(final String createUserNames) {
      this.createUserNames = createUserNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageLinkDetailsCommonDTO)) {
         return false;
      }

      PackageLinkDetailsCommonDTO other = (PackageLinkDetailsCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$packageId = this.getPackageId();
         Object other$packageId = other.getPackageId();
         if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$enclosureMeasureModeEnum = this.getEnclosureMeasureModeEnum();
                     Object other$enclosureMeasureModeEnum = other.getEnclosureMeasureModeEnum();
                     if (this$enclosureMeasureModeEnum == null
                        ? other$enclosureMeasureModeEnum == null
                        : this$enclosureMeasureModeEnum.equals(other$enclosureMeasureModeEnum)) {
                        Object this$boolOneCode = this.getBoolOneCode();
                        Object other$boolOneCode = other.getBoolOneCode();
                        if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                           Object this$packageSerialNumber = this.getPackageSerialNumber();
                           Object other$packageSerialNumber = other.getPackageSerialNumber();
                           if (this$packageSerialNumber == null
                              ? other$packageSerialNumber == null
                              : this$packageSerialNumber.equals(other$packageSerialNumber)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                      Object this$quantity = this.getQuantity();
                                                      Object other$quantity = other.getQuantity();
                                                      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                                                                              Object this$measureUnit = this.getMeasureUnit();
                                                                              Object other$measureUnit = other.getMeasureUnit();
                                                                              if (this$measureUnit == null
                                                                                 ? other$measureUnit == null
                                                                                 : this$measureUnit.equals(other$measureUnit)) {
                                                                                 Object this$mete = this.getMete();
                                                                                 Object other$mete = other.getMete();
                                                                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                    Object this$accountingUnit = this.getAccountingUnit();
                                                                                    Object other$accountingUnit = other.getAccountingUnit();
                                                                                    if (this$accountingUnit == null
                                                                                       ? other$accountingUnit == null
                                                                                       : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                       Object this$inQuantity = this.getInQuantity();
                                                                                       Object other$inQuantity = other.getInQuantity();
                                                                                       if (this$inQuantity == null
                                                                                          ? other$inQuantity == null
                                                                                          : this$inQuantity.equals(other$inQuantity)) {
                                                                                          Object this$packageQuantity = this.getPackageQuantity();
                                                                                          Object other$packageQuantity = other.getPackageQuantity();
                                                                                          if (this$packageQuantity == null
                                                                                             ? other$packageQuantity == null
                                                                                             : this$packageQuantity.equals(other$packageQuantity)) {
                                                                                             Object this$unPackageQuantity = this.getUnPackageQuantity();
                                                                                             Object other$unPackageQuantity = other.getUnPackageQuantity();
                                                                                             if (this$unPackageQuantity == null
                                                                                                ? other$unPackageQuantity == null
                                                                                                : this$unPackageQuantity.equals(other$unPackageQuantity)) {
                                                                                                Object this$numberList = this.getNumberList();
                                                                                                Object other$numberList = other.getNumberList();
                                                                                                if (this$numberList == null
                                                                                                   ? other$numberList == null
                                                                                                   : this$numberList.equals(other$numberList)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PackageLinkDetailsCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $enclosureMeasureModeEnum = this.getEnclosureMeasureModeEnum();
      result = result * 59 + ($enclosureMeasureModeEnum == null ? 43 : $enclosureMeasureModeEnum.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $packageSerialNumber = this.getPackageSerialNumber();
      result = result * 59 + ($packageSerialNumber == null ? 43 : $packageSerialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
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
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $createUserNames = this.getCreateUserNames();
      return result * 59 + ($createUserNames == null ? 43 : $createUserNames.hashCode());
   }

   @Override
   public String toString() {
      return "PackageLinkDetailsCommonDTO(linkId="
         + this.getLinkId()
         + ", packageId="
         + this.getPackageId()
         + ", packageSerialNumber="
         + this.getPackageSerialNumber()
         + ", id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
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
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", enclosureMeasureModeEnum="
         + this.getEnclosureMeasureModeEnum()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", inQuantity="
         + this.getInQuantity()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", numberList="
         + this.getNumberList()
         + ", createUserNames="
         + this.getCreateUserNames()
         + ")";
   }

   public static class PackageLinkDetailsCommonDTOBuilder {
      private Long linkId;
      private Long packageId;
      private String packageSerialNumber;
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Integer productType;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer enclosureMeasureModeEnum;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal inQuantity;
      private BigDecimal packageQuantity;
      private BigDecimal unPackageQuantity;
      private Boolean boolOneCode;
      private List<ArtifactStockNumberDO> numberList;
      private String createUserNames;

      PackageLinkDetailsCommonDTOBuilder() {
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder packageSerialNumber(final String packageSerialNumber) {
         this.packageSerialNumber = packageSerialNumber;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder enclosureMeasureModeEnum(final Integer enclosureMeasureModeEnum) {
         this.enclosureMeasureModeEnum = enclosureMeasureModeEnum;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder inQuantity(final BigDecimal inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder packageQuantity(final BigDecimal packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder unPackageQuantity(final BigDecimal unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder numberList(final List<ArtifactStockNumberDO> numberList) {
         this.numberList = numberList;
         return this;
      }

      public PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder createUserNames(final String createUserNames) {
         this.createUserNames = createUserNames;
         return this;
      }

      public PackageLinkDetailsCommonDTO build() {
         return new PackageLinkDetailsCommonDTO(
            this.linkId,
            this.packageId,
            this.packageSerialNumber,
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.productType,
            this.productId,
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
            this.totalLength,
            this.totalArea,
            this.enclosureMeasureModeEnum,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.inQuantity,
            this.packageQuantity,
            this.unPackageQuantity,
            this.boolOneCode,
            this.numberList,
            this.createUserNames
         );
      }

      @Override
      public String toString() {
         return "PackageLinkDetailsCommonDTO.PackageLinkDetailsCommonDTOBuilder(linkId="
            + this.linkId
            + ", packageId="
            + this.packageId
            + ", packageSerialNumber="
            + this.packageSerialNumber
            + ", id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
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
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", enclosureMeasureModeEnum="
            + this.enclosureMeasureModeEnum
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", inQuantity="
            + this.inQuantity
            + ", packageQuantity="
            + this.packageQuantity
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ", boolOneCode="
            + this.boolOneCode
            + ", numberList="
            + this.numberList
            + ", createUserNames="
            + this.createUserNames
            + ")";
      }
   }
}
