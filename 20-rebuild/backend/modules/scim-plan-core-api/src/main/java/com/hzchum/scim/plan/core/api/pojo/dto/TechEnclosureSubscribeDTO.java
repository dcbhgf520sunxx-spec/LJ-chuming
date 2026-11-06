package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechEnclosureSubscribeDTO", description = "围护申购-返回类")
public class TechEnclosureSubscribeDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlan", value = "围护计划")
   private NameInfo enclosurePlan;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 0否(正常状态) 1是(异常状态)")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "单长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "可申购数量")
   private Integer quantity;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "weight", value = "单重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   private String plating;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;

   public static TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder builder() {
      return new TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder();
   }

   public TechEnclosureSubscribeDTO() {
   }

   public TechEnclosureSubscribeDTO(
      final Long id,
      final ProjectInfo project,
      final Integer category,
      final NameInfo enclosurePlan,
      final String specification,
      final Boolean boolStatusEnum,
      final Boolean boolAbnormalEnum,
      final String name,
      final String serialNumber,
      final String plate,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal thickness,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal surfaceArea,
      final String brand,
      final String color,
      final String material,
      final BigDecimal weight,
      final String coating,
      final String plating,
      final String remark,
      final Long dictionaryId
   ) {
      this.id = id;
      this.project = project;
      this.category = category;
      this.enclosurePlan = enclosurePlan;
      this.specification = specification;
      this.boolStatusEnum = boolStatusEnum;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.thickness = thickness;
      this.length = length;
      this.quantity = quantity;
      this.surfaceArea = surfaceArea;
      this.brand = brand;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.coating = coating;
      this.plating = plating;
      this.remark = remark;
      this.dictionaryId = dictionaryId;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getCategory() {
      return this.category;
   }

   public NameInfo getEnclosurePlan() {
      return this.enclosurePlan;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
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

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
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

   public BigDecimal getWeight() {
      return this.weight;
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

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlan(final NameInfo enclosurePlan) {
      this.enclosurePlan = enclosurePlan;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
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

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
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

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureSubscribeDTO)) {
         return false;
      }

      TechEnclosureSubscribeDTO other = (TechEnclosureSubscribeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$boolStatusEnum = this.getBoolStatusEnum();
            Object other$boolStatusEnum = other.getBoolStatusEnum();
            if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
               Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
               Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
               if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$dictionaryId = this.getDictionaryId();
                     Object other$dictionaryId = other.getDictionaryId();
                     if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$enclosurePlan = this.getEnclosurePlan();
                           Object other$enclosurePlan = other.getEnclosurePlan();
                           if (this$enclosurePlan == null ? other$enclosurePlan == null : this$enclosurePlan.equals(other$enclosurePlan)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$plate = this.getPlate();
                                       Object other$plate = other.getPlate();
                                       if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$unfoldedWidth = this.getUnfoldedWidth();
                                             Object other$unfoldedWidth = other.getUnfoldedWidth();
                                             if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                      if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$color = this.getColor();
                                                            Object other$color = other.getColor();
                                                            if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                               Object this$material = this.getMaterial();
                                                               Object other$material = other.getMaterial();
                                                               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                  Object this$weight = this.getWeight();
                                                                  Object other$weight = other.getWeight();
                                                                  if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                     Object this$coating = this.getCoating();
                                                                     Object other$coating = other.getCoating();
                                                                     if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                                        Object this$plating = this.getPlating();
                                                                        Object other$plating = other.getPlating();
                                                                        if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechEnclosureSubscribeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $enclosurePlan = this.getEnclosurePlan();
      result = result * 59 + ($enclosurePlan == null ? 43 : $enclosurePlan.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechEnclosureSubscribeDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", category="
         + this.getCategory()
         + ", enclosurePlan="
         + this.getEnclosurePlan()
         + ", specification="
         + this.getSpecification()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", weight="
         + this.getWeight()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", remark="
         + this.getRemark()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ")";
   }

   public static class TechEnclosureSubscribeDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Integer category;
      private NameInfo enclosurePlan;
      private String specification;
      private Boolean boolStatusEnum;
      private Boolean boolAbnormalEnum;
      private String name;
      private String serialNumber;
      private String plate;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal thickness;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal surfaceArea;
      private String brand;
      private String color;
      private String material;
      private BigDecimal weight;
      private String coating;
      private String plating;
      private String remark;
      private Long dictionaryId;

      TechEnclosureSubscribeDTOBuilder() {
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder enclosurePlan(final NameInfo enclosurePlan) {
         this.enclosurePlan = enclosurePlan;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechEnclosureSubscribeDTO build() {
         return new TechEnclosureSubscribeDTO(
            this.id,
            this.project,
            this.category,
            this.enclosurePlan,
            this.specification,
            this.boolStatusEnum,
            this.boolAbnormalEnum,
            this.name,
            this.serialNumber,
            this.plate,
            this.width,
            this.unfoldedWidth,
            this.thickness,
            this.length,
            this.quantity,
            this.surfaceArea,
            this.brand,
            this.color,
            this.material,
            this.weight,
            this.coating,
            this.plating,
            this.remark,
            this.dictionaryId
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureSubscribeDTO.TechEnclosureSubscribeDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", category="
            + this.category
            + ", enclosurePlan="
            + this.enclosurePlan
            + ", specification="
            + this.specification
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", surfaceArea="
            + this.surfaceArea
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", weight="
            + this.weight
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", remark="
            + this.remark
            + ", dictionaryId="
            + this.dictionaryId
            + ")";
      }
   }
}
