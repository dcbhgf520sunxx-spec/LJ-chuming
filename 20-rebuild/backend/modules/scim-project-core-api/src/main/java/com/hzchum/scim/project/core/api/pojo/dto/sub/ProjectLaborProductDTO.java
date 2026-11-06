package com.hzchum.scim.project.core.api.pojo.dto.sub;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

@ApiModel(value = "ProjectLaborProductDTO", description = "安装清单待划分产品返回类")
public class ProjectLaborProductDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "plan", value = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   @JsonInclude(Include.NON_NULL)
   private EnclosurePlanDTO plan;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(name = "productId", value = "产品ID")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "canDivideQuantity", notes = "产品总数")
   private BigDecimal canDivideQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @JsonInclude(Include.NON_NULL)
   private Integer category;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   @JsonInclude(Include.NON_NULL)
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @JsonInclude(Include.NON_NULL)
   private String color;
   @ApiModelProperty(name = "weight", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @ApiModelProperty(name = "coating", value = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   @JsonInclude(Include.NON_NULL)
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @JsonProperty("plating")
   @JSONField(name = "plating")
   @JsonInclude(Include.NON_NULL)
   private String plating;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(18,4) COMMENT '核算量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '单位'", nullable = false)
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(16)  COMMENT '单位'")
   private String accountingUnit;

   public static ProjectLaborProductDTO.ProjectLaborProductDTOBuilder builder() {
      return new ProjectLaborProductDTO.ProjectLaborProductDTOBuilder();
   }

   public ProjectLaborProductDTO() {
   }

   public ProjectLaborProductDTO(
      final Long id,
      final ProjectInfo project,
      final EnclosurePlanDTO plan,
      final NameInfo monomer,
      final NameInfo area,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal quantity,
      final BigDecimal canDivideQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final Integer category,
      final String brand,
      final String plate,
      final String color,
      final BigDecimal weight,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final BigDecimal mete,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.id = id;
      this.project = project;
      this.plan = plan;
      this.monomer = monomer;
      this.area = area;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.canDivideQuantity = canDivideQuantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.category = category;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.weight = weight;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.mete = mete;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public EnclosurePlanDTO getPlan() {
      return this.plan;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
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

   public BigDecimal getCanDivideQuantity() {
      return this.canDivideQuantity;
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

   public Integer getCategory() {
      return this.category;
   }

   public String getBrand() {
      return this.brand;
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

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   @JsonProperty("id")
   public ProjectLaborProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public ProjectLaborProductDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("plan")
   public ProjectLaborProductDTO setPlan(final EnclosurePlanDTO plan) {
      this.plan = plan;
      return this;
   }

   public ProjectLaborProductDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public ProjectLaborProductDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productId")
   public ProjectLaborProductDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ProjectLaborProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectLaborProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectLaborProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ProjectLaborProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ProjectLaborProductDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ProjectLaborProductDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectLaborProductDTO setCanDivideQuantity(final BigDecimal canDivideQuantity) {
      this.canDivideQuantity = canDivideQuantity;
      return this;
   }

   public ProjectLaborProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public ProjectLaborProductDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public ProjectLaborProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public ProjectLaborProductDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public ProjectLaborProductDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("category")
   public ProjectLaborProductDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("brand")
   public ProjectLaborProductDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public ProjectLaborProductDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public ProjectLaborProductDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public ProjectLaborProductDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public ProjectLaborProductDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public ProjectLaborProductDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public ProjectLaborProductDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("width")
   public ProjectLaborProductDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public ProjectLaborProductDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("totalLength")
   public ProjectLaborProductDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public ProjectLaborProductDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public ProjectLaborProductDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public ProjectLaborProductDTO setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectLaborProductDTO setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLaborProductDTO)) {
         return false;
      }

      ProjectLaborProductDTO other = (ProjectLaborProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$plan = this.getPlan();
                  Object other$plan = other.getPlan();
                  if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
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
                                             Object this$canDivideQuantity = this.getCanDivideQuantity();
                                             Object other$canDivideQuantity = other.getCanDivideQuantity();
                                             if (this$canDivideQuantity == null
                                                ? other$canDivideQuantity == null
                                                : this$canDivideQuantity.equals(other$canDivideQuantity)) {
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
                                                            if (this$surfaceArea == null
                                                               ? other$surfaceArea == null
                                                               : this$surfaceArea.equals(other$surfaceArea)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
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
                                                                                    Object this$width = this.getWidth();
                                                                                    Object other$width = other.getWidth();
                                                                                    if (this$width == null
                                                                                       ? other$width == null
                                                                                       : this$width.equals(other$width)) {
                                                                                       Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                       Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                       if (this$unfoldedWidth == null
                                                                                          ? other$unfoldedWidth == null
                                                                                          : this$unfoldedWidth.equals(other$unfoldedWidth)) {
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
                                                                                                Object this$mete = this.getMete();
                                                                                                Object other$mete = other.getMete();
                                                                                                if (this$mete == null
                                                                                                   ? other$mete == null
                                                                                                   : this$mete.equals(other$mete)) {
                                                                                                   Object this$measureUnit = this.getMeasureUnit();
                                                                                                   Object other$measureUnit = other.getMeasureUnit();
                                                                                                   if (this$measureUnit == null
                                                                                                      ? other$measureUnit == null
                                                                                                      : this$measureUnit.equals(other$measureUnit)) {
                                                                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                                                                      return this$accountingUnit == null
                                                                                                         ? other$accountingUnit == null
                                                                                                         : this$accountingUnit.equals(other$accountingUnit);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectLaborProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
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
      Object $canDivideQuantity = this.getCanDivideQuantity();
      result = result * 59 + ($canDivideQuantity == null ? 43 : $canDivideQuantity.hashCode());
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
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLaborProductDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", plan="
         + this.getPlan()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
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
         + ", canDivideQuantity="
         + this.getCanDivideQuantity()
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
         + ", category="
         + this.getCategory()
         + ", brand="
         + this.getBrand()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", mete="
         + this.getMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public static class ProjectLaborProductDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private EnclosurePlanDTO plan;
      private NameInfo monomer;
      private NameInfo area;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal quantity;
      private BigDecimal canDivideQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private Integer category;
      private String brand;
      private String plate;
      private String color;
      private BigDecimal weight;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal mete;
      private String measureUnit;
      private String accountingUnit;

      ProjectLaborProductDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("plan")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder plan(final EnclosurePlanDTO plan) {
         this.plan = plan;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productId")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder canDivideQuantity(final BigDecimal canDivideQuantity) {
         this.canDivideQuantity = canDivideQuantity;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("category")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("brand")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("width")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      @JsonProperty("totalLength")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectLaborProductDTO.ProjectLaborProductDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectLaborProductDTO build() {
         return new ProjectLaborProductDTO(
            this.id,
            this.project,
            this.plan,
            this.monomer,
            this.area,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.canDivideQuantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.category,
            this.brand,
            this.plate,
            this.color,
            this.weight,
            this.thickness,
            this.coating,
            this.plating,
            this.width,
            this.unfoldedWidth,
            this.totalLength,
            this.totalArea,
            this.mete,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectLaborProductDTO.ProjectLaborProductDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", plan="
            + this.plan
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
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
            + ", canDivideQuantity="
            + this.canDivideQuantity
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
            + ", category="
            + this.category
            + ", brand="
            + this.brand
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", mete="
            + this.mete
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
