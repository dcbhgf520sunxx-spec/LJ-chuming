package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectReceivingRecord对象", description = "项目管理收货记录表DTO ")
public class ProjectReceivingRecordDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private NameInfo area;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "收货数量", notes = "收货数量")
   private Integer quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "产品核算总量(重量/长度)", notes = "产品核算总量(重量kg/长度mm)")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "totalArea", value = "总面积", notes = "围护总面积")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "areaType", value = "来源类型 0自制 1外协", notes = "来源类型 0自制 1外协")
   private Integer areaType;
   @ApiModelProperty(name = "sourceId", value = "来源ID(发运表id/订单id)", notes = "来源ID(发运表id/订单id)")
   private Long sourceId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplierId", value = "外协供应商id", notes = "外协供应商id")
   private Long supplierId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplierName", value = "外协供应商名称", notes = "外协供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "actualReceivedMete", value = "原材料实际收货量 ", notes = "原材料实际收货量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "measurePrecision", value = "计量单位精度 ", notes = "收货核算量")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingPrecision", value = "核算单位精度 ", notes = "核算单位精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   private String color;
   @ApiModelProperty(name = "basicClass", value = "材料类型", notes = "材料类型")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", notes = "科目id")
   private Long classifyId;
   private BigDecimal length;

   public static ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder builder() {
      return new ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder();
   }

   public ProjectReceivingRecordDTO() {
   }

   public ProjectReceivingRecordDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final NameInfo monomer,
      final Long areaId,
      final NameInfo area,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String serialNumber,
      final String name,
      final String specification,
      final Integer quantity,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal totalArea,
      final Integer areaType,
      final Long sourceId,
      final Long supplierId,
      final String supplierName,
      final BigDecimal actualReceivedMete,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final Integer basicClass,
      final Long classifyId,
      final BigDecimal length
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.areaId = areaId;
      this.area = area;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.totalArea = totalArea;
      this.areaType = areaType;
      this.sourceId = sourceId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.actualReceivedMete = actualReceivedMete;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.length = length;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
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

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public Long getSourceId() {
      return this.sourceId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
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

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setAreaType(final Integer areaType) {
      this.areaType = areaType;
   }

   public void setSourceId(final Long sourceId) {
      this.sourceId = sourceId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingRecordDTO)) {
         return false;
      }

      ProjectReceivingRecordDTO other = (ProjectReceivingRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$areaType = this.getAreaType();
                                 Object other$areaType = other.getAreaType();
                                 if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                    Object this$sourceId = this.getSourceId();
                                    Object other$sourceId = other.getSourceId();
                                    if (this$sourceId == null ? other$sourceId == null : this$sourceId.equals(other$sourceId)) {
                                       Object this$supplierId = this.getSupplierId();
                                       Object other$supplierId = other.getSupplierId();
                                       if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                          Object this$measurePrecision = this.getMeasurePrecision();
                                          Object other$measurePrecision = other.getMeasurePrecision();
                                          if (this$measurePrecision == null
                                             ? other$measurePrecision == null
                                             : this$measurePrecision.equals(other$measurePrecision)) {
                                             Object this$accountingPrecision = this.getAccountingPrecision();
                                             Object other$accountingPrecision = other.getAccountingPrecision();
                                             if (this$accountingPrecision == null
                                                ? other$accountingPrecision == null
                                                : this$accountingPrecision.equals(other$accountingPrecision)) {
                                                Object this$basicClass = this.getBasicClass();
                                                Object other$basicClass = other.getBasicClass();
                                                if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                                   Object this$classifyId = this.getClassifyId();
                                                   Object other$classifyId = other.getClassifyId();
                                                   if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                      Object this$monomer = this.getMonomer();
                                                      Object other$monomer = other.getMonomer();
                                                      if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                         Object this$area = this.getArea();
                                                         Object other$area = other.getArea();
                                                         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$name = this.getName();
                                                               Object other$name = other.getName();
                                                               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
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
                                                                              Object this$totalArea = this.getTotalArea();
                                                                              Object other$totalArea = other.getTotalArea();
                                                                              if (this$totalArea == null
                                                                                 ? other$totalArea == null
                                                                                 : this$totalArea.equals(other$totalArea)) {
                                                                                 Object this$supplierName = this.getSupplierName();
                                                                                 Object other$supplierName = other.getSupplierName();
                                                                                 if (this$supplierName == null
                                                                                    ? other$supplierName == null
                                                                                    : this$supplierName.equals(other$supplierName)) {
                                                                                    Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                                    Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                                    if (this$actualReceivedMete == null
                                                                                       ? other$actualReceivedMete == null
                                                                                       : this$actualReceivedMete.equals(other$actualReceivedMete)) {
                                                                                       Object this$width = this.getWidth();
                                                                                       Object other$width = other.getWidth();
                                                                                       if (this$width == null
                                                                                          ? other$width == null
                                                                                          : this$width.equals(other$width)) {
                                                                                          Object this$thickness = this.getThickness();
                                                                                          Object other$thickness = other.getThickness();
                                                                                          if (this$thickness == null
                                                                                             ? other$thickness == null
                                                                                             : this$thickness.equals(other$thickness)) {
                                                                                             Object this$color = this.getColor();
                                                                                             Object other$color = other.getColor();
                                                                                             if (this$color == null
                                                                                                ? other$color == null
                                                                                                : this$color.equals(other$color)) {
                                                                                                Object this$length = this.getLength();
                                                                                                Object other$length = other.getLength();
                                                                                                return this$length == null
                                                                                                   ? other$length == null
                                                                                                   : this$length.equals(other$length);
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
      return other instanceof ProjectReceivingRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $sourceId = this.getSourceId();
      result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $length = this.getLength();
      return result * 59 + ($length == null ? 43 : $length.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivingRecordDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", totalArea="
         + this.getTotalArea()
         + ", areaType="
         + this.getAreaType()
         + ", sourceId="
         + this.getSourceId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", length="
         + this.getLength()
         + ")";
   }

   public static class ProjectReceivingRecordDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private NameInfo monomer;
      private Long areaId;
      private NameInfo area;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String serialNumber;
      private String name;
      private String specification;
      private Integer quantity;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal totalArea;
      private Integer areaType;
      private Long sourceId;
      private Long supplierId;
      private String supplierName;
      private BigDecimal actualReceivedMete;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private Integer basicClass;
      private Long classifyId;
      private BigDecimal length;

      ProjectReceivingRecordDTOBuilder() {
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder sourceId(final Long sourceId) {
         this.sourceId = sourceId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectReceivingRecordDTO build() {
         return new ProjectReceivingRecordDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.monomer,
            this.areaId,
            this.area,
            this.projectType,
            this.productType,
            this.category,
            this.productId,
            this.serialNumber,
            this.name,
            this.specification,
            this.quantity,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.totalArea,
            this.areaType,
            this.sourceId,
            this.supplierId,
            this.supplierName,
            this.actualReceivedMete,
            this.measurePrecision,
            this.accountingPrecision,
            this.width,
            this.thickness,
            this.color,
            this.basicClass,
            this.classifyId,
            this.length
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivingRecordDTO.ProjectReceivingRecordDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", totalArea="
            + this.totalArea
            + ", areaType="
            + this.areaType
            + ", sourceId="
            + this.sourceId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", length="
            + this.length
            + ")";
      }
   }
}
