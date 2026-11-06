package com.hzchum.scim.business.core.api.pojo.dtoParam;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class EnclosureAddDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "品类")
   private Integer category;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "plate", value = "板型")
   private String plate;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   private String plating;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "quantity", value = "新增数量")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(m2)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 1长度 2面积", notes = "计价方式 1长度 2面积")
   private Integer pricingManner;

   public static EnclosureAddDTOParam.EnclosureAddDTOParamBuilder builder() {
      return new EnclosureAddDTOParam.EnclosureAddDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureAddDTOParam)) {
         return false;
      }

      EnclosureAddDTOParam other = (EnclosureAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$enclosurePlanId = this.getEnclosurePlanId();
               Object other$enclosurePlanId = other.getEnclosurePlanId();
               if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                     Object this$bendTimes = this.getBendTimes();
                     Object other$bendTimes = other.getBendTimes();
                     if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$pricingManner = this.getPricingManner();
                           Object other$pricingManner = other.getPricingManner();
                           if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$plate = this.getPlate();
                                 Object other$plate = other.getPlate();
                                 if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$thickness = this.getThickness();
                                          Object other$thickness = other.getThickness();
                                          if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                             Object this$unfoldedWidth = this.getUnfoldedWidth();
                                             Object other$unfoldedWidth = other.getUnfoldedWidth();
                                             if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                Object this$coating = this.getCoating();
                                                Object other$coating = other.getCoating();
                                                if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                   Object this$plating = this.getPlating();
                                                   Object other$plating = other.getPlating();
                                                   if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                                      Object this$totalLength = this.getTotalLength();
                                                      Object other$totalLength = other.getTotalLength();
                                                      if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                         Object this$totalArea = this.getTotalArea();
                                                         Object other$totalArea = other.getTotalArea();
                                                         return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof EnclosureAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureAddDTOParam(projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", thickness="
         + this.getThickness()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", bendTimes="
         + this.getBendTimes()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", pricingManner="
         + this.getPricingManner()
         + ")";
   }

   public EnclosureAddDTOParam(
      final Long projectId,
      final Integer category,
      final Long areaId,
      final Long enclosurePlanId,
      final Long dictionaryId,
      final String name,
      final String plate,
      final String brand,
      final String color,
      final BigDecimal thickness,
      final BigDecimal unfoldedWidth,
      final String coating,
      final String plating,
      final Integer bendTimes,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer pricingManner
   ) {
      this.projectId = projectId;
      this.category = category;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.dictionaryId = dictionaryId;
      this.name = name;
      this.plate = plate;
      this.brand = brand;
      this.color = color;
      this.thickness = thickness;
      this.unfoldedWidth = unfoldedWidth;
      this.coating = coating;
      this.plating = plating;
      this.bendTimes = bendTimes;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.pricingManner = pricingManner;
   }

   public EnclosureAddDTOParam() {
   }

   public static class EnclosureAddDTOParamBuilder {
      private Long projectId;
      private Integer category;
      private Long areaId;
      private Long enclosurePlanId;
      private Long dictionaryId;
      private String name;
      private String plate;
      private String brand;
      private String color;
      private BigDecimal thickness;
      private BigDecimal unfoldedWidth;
      private String coating;
      private String plating;
      private Integer bendTimes;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer pricingManner;

      EnclosureAddDTOParamBuilder() {
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("areaId")
      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public EnclosureAddDTOParam.EnclosureAddDTOParamBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public EnclosureAddDTOParam build() {
         return new EnclosureAddDTOParam(
            this.projectId,
            this.category,
            this.areaId,
            this.enclosurePlanId,
            this.dictionaryId,
            this.name,
            this.plate,
            this.brand,
            this.color,
            this.thickness,
            this.unfoldedWidth,
            this.coating,
            this.plating,
            this.bendTimes,
            this.quantity,
            this.totalLength,
            this.totalArea,
            this.pricingManner
         );
      }

      @Override
      public String toString() {
         return "EnclosureAddDTOParam.EnclosureAddDTOParamBuilder(projectId="
            + this.projectId
            + ", category="
            + this.category
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", dictionaryId="
            + this.dictionaryId
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", thickness="
            + this.thickness
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", bendTimes="
            + this.bendTimes
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", pricingManner="
            + this.pricingManner
            + ")";
      }
   }
}
