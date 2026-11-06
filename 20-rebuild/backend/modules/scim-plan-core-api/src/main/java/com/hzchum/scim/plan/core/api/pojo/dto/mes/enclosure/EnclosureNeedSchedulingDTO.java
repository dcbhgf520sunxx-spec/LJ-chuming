package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "围护需要排产数据", description = "围护需要排产数据 ")
public class EnclosureNeedSchedulingDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "planName", value = "计划名称")
   private String planName;
   @ApiModelProperty(name = "dictionaryId", value = "字典id")
   private Long dictionaryId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   private BigDecimal width;
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
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "totalLength", value = "总长度(mm)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "needSchedulingQuantity", value = "可排产数量")
   private Integer needSchedulingQuantity;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   private Integer areaType;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id")
   private Long userId;

   public static EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder builder() {
      return new EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder();
   }

   public EnclosureNeedSchedulingDTO() {
   }

   public EnclosureNeedSchedulingDTO(
      final Long id,
      final Long projectId,
      final String monomerName,
      final String areaName,
      final String planName,
      final Long dictionaryId,
      final Integer category,
      final String name,
      final String serialNumber,
      final BigDecimal width,
      final String brand,
      final String plate,
      final String color,
      final String material,
      final BigDecimal weight,
      final BigDecimal thickness,
      final String coating,
      final String unit,
      final BigDecimal length,
      final BigDecimal totalLength,
      final Integer quantity,
      final Integer schedulingQuantity,
      final Integer producedQuantity,
      final Integer needSchedulingQuantity,
      final String remark,
      final Integer bendTimes,
      final Integer areaType,
      final Long userId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.planName = planName;
      this.dictionaryId = dictionaryId;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.width = width;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.thickness = thickness;
      this.coating = coating;
      this.unit = unit;
      this.length = length;
      this.totalLength = totalLength;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.producedQuantity = producedQuantity;
      this.needSchedulingQuantity = needSchedulingQuantity;
      this.remark = remark;
      this.bendTimes = bendTimes;
      this.areaType = areaType;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getPlanName() {
      return this.planName;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
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

   public BigDecimal getWidth() {
      return this.width;
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

   public String getCoating() {
      return this.coating;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getNeedSchedulingQuantity() {
      return this.needSchedulingQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public EnclosureNeedSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public EnclosureNeedSchedulingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public EnclosureNeedSchedulingDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public EnclosureNeedSchedulingDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public EnclosureNeedSchedulingDTO setPlanName(final String planName) {
      this.planName = planName;
      return this;
   }

   public EnclosureNeedSchedulingDTO setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public EnclosureNeedSchedulingDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public EnclosureNeedSchedulingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public EnclosureNeedSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public EnclosureNeedSchedulingDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public EnclosureNeedSchedulingDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public EnclosureNeedSchedulingDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public EnclosureNeedSchedulingDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   public EnclosureNeedSchedulingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public EnclosureNeedSchedulingDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public EnclosureNeedSchedulingDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public EnclosureNeedSchedulingDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   public EnclosureNeedSchedulingDTO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public EnclosureNeedSchedulingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public EnclosureNeedSchedulingDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public EnclosureNeedSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public EnclosureNeedSchedulingDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   public EnclosureNeedSchedulingDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   public EnclosureNeedSchedulingDTO setNeedSchedulingQuantity(final Integer needSchedulingQuantity) {
      this.needSchedulingQuantity = needSchedulingQuantity;
      return this;
   }

   public EnclosureNeedSchedulingDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public EnclosureNeedSchedulingDTO setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   public EnclosureNeedSchedulingDTO setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   public EnclosureNeedSchedulingDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureNeedSchedulingDTO)) {
         return false;
      }

      EnclosureNeedSchedulingDTO other = (EnclosureNeedSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$dictionaryId = this.getDictionaryId();
            Object other$dictionaryId = other.getDictionaryId();
            if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$schedulingQuantity = this.getSchedulingQuantity();
                     Object other$schedulingQuantity = other.getSchedulingQuantity();
                     if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$needSchedulingQuantity = this.getNeedSchedulingQuantity();
                           Object other$needSchedulingQuantity = other.getNeedSchedulingQuantity();
                           if (this$needSchedulingQuantity == null
                              ? other$needSchedulingQuantity == null
                              : this$needSchedulingQuantity.equals(other$needSchedulingQuantity)) {
                              Object this$bendTimes = this.getBendTimes();
                              Object other$bendTimes = other.getBendTimes();
                              if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                                 Object this$areaType = this.getAreaType();
                                 Object other$areaType = other.getAreaType();
                                 if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$monomerName = this.getMonomerName();
                                       Object other$monomerName = other.getMonomerName();
                                       if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                          Object this$areaName = this.getAreaName();
                                          Object other$areaName = other.getAreaName();
                                          if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                             Object this$planName = this.getPlanName();
                                             Object other$planName = other.getPlanName();
                                             if (this$planName == null ? other$planName == null : this$planName.equals(other$planName)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                                        if (this$thickness == null
                                                                           ? other$thickness == null
                                                                           : this$thickness.equals(other$thickness)) {
                                                                           Object this$coating = this.getCoating();
                                                                           Object other$coating = other.getCoating();
                                                                           if (this$coating == null
                                                                              ? other$coating == null
                                                                              : this$coating.equals(other$coating)) {
                                                                              Object this$unit = this.getUnit();
                                                                              Object other$unit = other.getUnit();
                                                                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                                                 Object this$length = this.getLength();
                                                                                 Object other$length = other.getLength();
                                                                                 if (this$length == null
                                                                                    ? other$length == null
                                                                                    : this$length.equals(other$length)) {
                                                                                    Object this$totalLength = this.getTotalLength();
                                                                                    Object other$totalLength = other.getTotalLength();
                                                                                    if (this$totalLength == null
                                                                                       ? other$totalLength == null
                                                                                       : this$totalLength.equals(other$totalLength)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       return this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark);
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
      return other instanceof EnclosureNeedSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $needSchedulingQuantity = this.getNeedSchedulingQuantity();
      result = result * 59 + ($needSchedulingQuantity == null ? 43 : $needSchedulingQuantity.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
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
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureNeedSchedulingDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", planName="
         + this.getPlanName()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", width="
         + this.getWidth()
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
         + ", coating="
         + this.getCoating()
         + ", unit="
         + this.getUnit()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", needSchedulingQuantity="
         + this.getNeedSchedulingQuantity()
         + ", remark="
         + this.getRemark()
         + ", bendTimes="
         + this.getBendTimes()
         + ", areaType="
         + this.getAreaType()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class EnclosureNeedSchedulingDTOBuilder {
      private Long id;
      private Long projectId;
      private String monomerName;
      private String areaName;
      private String planName;
      private Long dictionaryId;
      private Integer category;
      private String name;
      private String serialNumber;
      private BigDecimal width;
      private String brand;
      private String plate;
      private String color;
      private String material;
      private BigDecimal weight;
      private BigDecimal thickness;
      private String coating;
      private String unit;
      private BigDecimal length;
      private BigDecimal totalLength;
      private Integer quantity;
      private Integer schedulingQuantity;
      private Integer producedQuantity;
      private Integer needSchedulingQuantity;
      private String remark;
      private Integer bendTimes;
      private Integer areaType;
      private Long userId;

      EnclosureNeedSchedulingDTOBuilder() {
      }

      @JsonProperty("id")
      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder planName(final String planName) {
         this.planName = planName;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder needSchedulingQuantity(final Integer needSchedulingQuantity) {
         this.needSchedulingQuantity = needSchedulingQuantity;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      public EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public EnclosureNeedSchedulingDTO build() {
         return new EnclosureNeedSchedulingDTO(
            this.id,
            this.projectId,
            this.monomerName,
            this.areaName,
            this.planName,
            this.dictionaryId,
            this.category,
            this.name,
            this.serialNumber,
            this.width,
            this.brand,
            this.plate,
            this.color,
            this.material,
            this.weight,
            this.thickness,
            this.coating,
            this.unit,
            this.length,
            this.totalLength,
            this.quantity,
            this.schedulingQuantity,
            this.producedQuantity,
            this.needSchedulingQuantity,
            this.remark,
            this.bendTimes,
            this.areaType,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "EnclosureNeedSchedulingDTO.EnclosureNeedSchedulingDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", planName="
            + this.planName
            + ", dictionaryId="
            + this.dictionaryId
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", width="
            + this.width
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
            + ", coating="
            + this.coating
            + ", unit="
            + this.unit
            + ", length="
            + this.length
            + ", totalLength="
            + this.totalLength
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", needSchedulingQuantity="
            + this.needSchedulingQuantity
            + ", remark="
            + this.remark
            + ", bendTimes="
            + this.bendTimes
            + ", areaType="
            + this.areaType
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
