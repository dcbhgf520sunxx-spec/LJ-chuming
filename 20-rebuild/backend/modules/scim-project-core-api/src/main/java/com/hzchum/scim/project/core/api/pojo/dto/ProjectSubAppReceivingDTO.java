package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("分包商-可安装产品类")
public class ProjectSubAppReceivingDTO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private NameInfo area;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "category", value = "围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "总量(重量kg/长度m)")
   private BigDecimal mete;
   @ApiModelProperty(name = "receivingQuantity", value = "收货数量", notes = "收货数量")
   private BigDecimal receivingQuantity;
   @ApiModelProperty(name = "installQuantity", value = "已审核安装数量", notes = "已审核安装数量")
   private BigDecimal installQuantity;
   @ApiModelProperty(name = "unAuditQuantity", value = "未审核安装上报数量", notes = "未审核安装上报数量")
   private BigDecimal unAuditQuantity;
   @ApiModelProperty(name = "canInstallQuantity", value = "可安装数量", notes = "可安装数量")
   private BigDecimal canInstallQuantity;
   @ApiModelProperty(name = "stockQuantity", value = "工地库存数量", notes = "工地库存数量")
   private BigDecimal stockQuantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty("构件产品序列号集合")
   @JsonInclude(Include.NON_NULL)
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   @JsonInclude(Include.NON_NULL)
   private List<Object> drawingAndSerialNumber;

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getReceivingQuantity() {
      return this.receivingQuantity;
   }

   public BigDecimal getInstallQuantity() {
      return this.installQuantity;
   }

   public BigDecimal getUnAuditQuantity() {
      return this.unAuditQuantity;
   }

   public BigDecimal getCanInstallQuantity() {
      return this.canInstallQuantity;
   }

   public BigDecimal getStockQuantity() {
      return this.stockQuantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<Object> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setReceivingQuantity(final BigDecimal receivingQuantity) {
      this.receivingQuantity = receivingQuantity;
   }

   public void setInstallQuantity(final BigDecimal installQuantity) {
      this.installQuantity = installQuantity;
   }

   public void setUnAuditQuantity(final BigDecimal unAuditQuantity) {
      this.unAuditQuantity = unAuditQuantity;
   }

   public void setCanInstallQuantity(final BigDecimal canInstallQuantity) {
      this.canInstallQuantity = canInstallQuantity;
   }

   public void setStockQuantity(final BigDecimal stockQuantity) {
      this.stockQuantity = stockQuantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<Object> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubAppReceivingDTO)) {
         return false;
      }

      ProjectSubAppReceivingDTO other = (ProjectSubAppReceivingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$netWeight = this.getNetWeight();
                                                   Object other$netWeight = other.getNetWeight();
                                                   if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                         Object this$receivingQuantity = this.getReceivingQuantity();
                                                         Object other$receivingQuantity = other.getReceivingQuantity();
                                                         if (this$receivingQuantity == null
                                                            ? other$receivingQuantity == null
                                                            : this$receivingQuantity.equals(other$receivingQuantity)) {
                                                            Object this$installQuantity = this.getInstallQuantity();
                                                            Object other$installQuantity = other.getInstallQuantity();
                                                            if (this$installQuantity == null
                                                               ? other$installQuantity == null
                                                               : this$installQuantity.equals(other$installQuantity)) {
                                                               Object this$unAuditQuantity = this.getUnAuditQuantity();
                                                               Object other$unAuditQuantity = other.getUnAuditQuantity();
                                                               if (this$unAuditQuantity == null
                                                                  ? other$unAuditQuantity == null
                                                                  : this$unAuditQuantity.equals(other$unAuditQuantity)) {
                                                                  Object this$canInstallQuantity = this.getCanInstallQuantity();
                                                                  Object other$canInstallQuantity = other.getCanInstallQuantity();
                                                                  if (this$canInstallQuantity == null
                                                                     ? other$canInstallQuantity == null
                                                                     : this$canInstallQuantity.equals(other$canInstallQuantity)) {
                                                                     Object this$stockQuantity = this.getStockQuantity();
                                                                     Object other$stockQuantity = other.getStockQuantity();
                                                                     if (this$stockQuantity == null
                                                                        ? other$stockQuantity == null
                                                                        : this$stockQuantity.equals(other$stockQuantity)) {
                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                        if (this$measureUnit == null
                                                                           ? other$measureUnit == null
                                                                           : this$measureUnit.equals(other$measureUnit)) {
                                                                           Object this$accountingUnit = this.getAccountingUnit();
                                                                           Object other$accountingUnit = other.getAccountingUnit();
                                                                           if (this$accountingUnit == null
                                                                              ? other$accountingUnit == null
                                                                              : this$accountingUnit.equals(other$accountingUnit)) {
                                                                              Object this$numbers = this.getNumbers();
                                                                              Object other$numbers = other.getNumbers();
                                                                              if (this$numbers == null
                                                                                 ? other$numbers == null
                                                                                 : this$numbers.equals(other$numbers)) {
                                                                                 Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                 Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                 return this$drawingAndSerialNumber == null
                                                                                    ? other$drawingAndSerialNumber == null
                                                                                    : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber);
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
      return other instanceof ProjectSubAppReceivingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $receivingQuantity = this.getReceivingQuantity();
      result = result * 59 + ($receivingQuantity == null ? 43 : $receivingQuantity.hashCode());
      Object $installQuantity = this.getInstallQuantity();
      result = result * 59 + ($installQuantity == null ? 43 : $installQuantity.hashCode());
      Object $unAuditQuantity = this.getUnAuditQuantity();
      result = result * 59 + ($unAuditQuantity == null ? 43 : $unAuditQuantity.hashCode());
      Object $canInstallQuantity = this.getCanInstallQuantity();
      result = result * 59 + ($canInstallQuantity == null ? 43 : $canInstallQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubAppReceivingDTO(productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", receivingQuantity="
         + this.getReceivingQuantity()
         + ", installQuantity="
         + this.getInstallQuantity()
         + ", unAuditQuantity="
         + this.getUnAuditQuantity()
         + ", canInstallQuantity="
         + this.getCanInstallQuantity()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }
}
