package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护清单列表查询类")
public class EnclosureListQueryDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "dictionaryId", value = "围护类型字典id")
   private Long dictionaryId;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 true进行中 false已暂停")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "weight", value = "重量")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   private BigDecimal thickness;

   public static EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder builder() {
      return new EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder();
   }

   public EnclosureListQueryDTOParam() {
   }

   public EnclosureListQueryDTOParam(
      final Long projectId,
      final Integer category,
      final Long enclosurePlanId,
      final Long areaId,
      final Long dictionaryId,
      final Boolean boolStatusEnum,
      final String name,
      final String serialNumber,
      final String brand,
      final String plate,
      final String color,
      final String material,
      final BigDecimal weight,
      final BigDecimal thickness
   ) {
      this.projectId = projectId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.areaId = areaId;
      this.dictionaryId = dictionaryId;
      this.boolStatusEnum = boolStatusEnum;
      this.name = name;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.thickness = thickness;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureListQueryDTOParam)) {
         return false;
      }

      EnclosureListQueryDTOParam other = (EnclosureListQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$brand = this.getBrand();
                              Object other$brand = other.getBrand();
                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                 Object this$plate = this.getPlate();
                                 Object other$plate = other.getPlate();
                                 if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                    Object this$color = this.getColor();
                                    Object other$color = other.getColor();
                                    if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$weight = this.getWeight();
                                          Object other$weight = other.getWeight();
                                          if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             return this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness);
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
      return other instanceof EnclosureListQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureListQueryDTOParam(projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", areaId="
         + this.getAreaId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", brand="
         + this.getBrand()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   public static class EnclosureListQueryDTOParamBuilder {
      private Long projectId;
      private Integer category;
      private Long enclosurePlanId;
      private Long areaId;
      private Long dictionaryId;
      private Boolean boolStatusEnum;
      private String name;
      private String serialNumber;
      private String brand;
      private String plate;
      private String color;
      private String material;
      private BigDecimal weight;
      private BigDecimal thickness;

      EnclosureListQueryDTOParamBuilder() {
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public EnclosureListQueryDTOParam build() {
         return new EnclosureListQueryDTOParam(
            this.projectId,
            this.category,
            this.enclosurePlanId,
            this.areaId,
            this.dictionaryId,
            this.boolStatusEnum,
            this.name,
            this.serialNumber,
            this.brand,
            this.plate,
            this.color,
            this.material,
            this.weight,
            this.thickness
         );
      }

      @Override
      public String toString() {
         return "EnclosureListQueryDTOParam.EnclosureListQueryDTOParamBuilder(projectId="
            + this.projectId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", areaId="
            + this.areaId
            + ", dictionaryId="
            + this.dictionaryId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", brand="
            + this.brand
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}
