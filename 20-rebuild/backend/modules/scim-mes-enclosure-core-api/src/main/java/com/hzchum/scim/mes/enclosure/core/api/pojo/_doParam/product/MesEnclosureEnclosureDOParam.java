package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("MesEnclosureEnclosureDOParam")
public class MesEnclosureEnclosureDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "boolStatusEnum", notes = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "businessId", notes = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   private Long businessId;
   @ApiModelProperty(name = "brand", notes = "品牌（芯材信息）")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   private String brand;
   @ApiModelProperty(name = "type", notes = "种类（芯材信息）")
   @JsonProperty("type")
   @JSONField(name = "type")
   private String type;
   @ApiModelProperty(name = "capacity", notes = "容量（芯材信息）")
   @JsonProperty("capacity")
   @JSONField(name = "capacity")
   private String capacity;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "statusType", notes = "1:未排产,2:未排产完成,4:已排产完成")
   @JsonProperty("statusType")
   @JSONField(name = "statusType")
   private Integer statusType;

   public static MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder builder() {
      return new MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder();
   }

   public MesEnclosureEnclosureDOParam() {
   }

   public MesEnclosureEnclosureDOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Boolean boolStatusEnum,
      final Integer category,
      final String name,
      final String serialNumber,
      final String plate,
      final String color,
      final String material,
      final BigDecimal weight,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final String remark,
      final Long businessId,
      final String brand,
      final String type,
      final String capacity,
      final Boolean boolAbnormalEnum,
      final Integer statusType
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.boolStatusEnum = boolStatusEnum;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.remark = remark;
      this.businessId = businessId;
      this.brand = brand;
      this.type = type;
      this.capacity = capacity;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.statusType = statusType;
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

   public Long getPlanId() {
      return this.planId;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
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

   public String getRemark() {
      return this.remark;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getType() {
      return this.type;
   }

   public String getCapacity() {
      return this.capacity;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public Integer getStatusType() {
      return this.statusType;
   }

   @JsonProperty("id")
   public MesEnclosureEnclosureDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureEnclosureDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureEnclosureDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureEnclosureDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public MesEnclosureEnclosureDOParam setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureEnclosureDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureEnclosureDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureEnclosureDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public MesEnclosureEnclosureDOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public MesEnclosureEnclosureDOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureEnclosureDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public MesEnclosureEnclosureDOParam setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public MesEnclosureEnclosureDOParam setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public MesEnclosureEnclosureDOParam setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureEnclosureDOParam setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureEnclosureDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public MesEnclosureEnclosureDOParam setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public MesEnclosureEnclosureDOParam setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureEnclosureDOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("businessId")
   public MesEnclosureEnclosureDOParam setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("brand")
   public MesEnclosureEnclosureDOParam setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureEnclosureDOParam setType(final String type) {
      this.type = type;
      return this;
   }

   @JsonProperty("capacity")
   public MesEnclosureEnclosureDOParam setCapacity(final String capacity) {
      this.capacity = capacity;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesEnclosureEnclosureDOParam setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("statusType")
   public MesEnclosureEnclosureDOParam setStatusType(final Integer statusType) {
      this.statusType = statusType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureEnclosureDOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
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
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", remark="
         + this.getRemark()
         + ", businessId="
         + this.getBusinessId()
         + ", brand="
         + this.getBrand()
         + ", type="
         + this.getType()
         + ", capacity="
         + this.getCapacity()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", statusType="
         + this.getStatusType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureEnclosureDOParam)) {
         return false;
      }

      MesEnclosureEnclosureDOParam other = (MesEnclosureEnclosureDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$boolStatusEnum = this.getBoolStatusEnum();
                  Object other$boolStatusEnum = other.getBoolStatusEnum();
                  if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$businessId = this.getBusinessId();
                           Object other$businessId = other.getBusinessId();
                           if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                              Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                              Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                              if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                 Object this$statusType = this.getStatusType();
                                 Object other$statusType = other.getStatusType();
                                 if (this$statusType == null ? other$statusType == null : this$statusType.equals(other$statusType)) {
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
                                                   Object this$weight = this.getWeight();
                                                   Object other$weight = other.getWeight();
                                                   if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$totalLength = this.getTotalLength();
                                                               Object other$totalLength = other.getTotalLength();
                                                               if (this$totalLength == null
                                                                  ? other$totalLength == null
                                                                  : this$totalLength.equals(other$totalLength)) {
                                                                  Object this$totalArea = this.getTotalArea();
                                                                  Object other$totalArea = other.getTotalArea();
                                                                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)
                                                                     )
                                                                   {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$type = this.getType();
                                                                           Object other$type = other.getType();
                                                                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                                              Object this$capacity = this.getCapacity();
                                                                              Object other$capacity = other.getCapacity();
                                                                              return this$capacity == null
                                                                                 ? other$capacity == null
                                                                                 : this$capacity.equals(other$capacity);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureEnclosureDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $statusType = this.getStatusType();
      result = result * 59 + ($statusType == null ? 43 : $statusType.hashCode());
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
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $capacity = this.getCapacity();
      return result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
   }

   public static class MesEnclosureEnclosureDOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Boolean boolStatusEnum;
      private Integer category;
      private String name;
      private String serialNumber;
      private String plate;
      private String color;
      private String material;
      private BigDecimal weight;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private String remark;
      private Long businessId;
      private String brand;
      private String type;
      private String capacity;
      private Boolean boolAbnormalEnum;
      private Integer statusType;

      MesEnclosureEnclosureDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("businessId")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("brand")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder type(final String type) {
         this.type = type;
         return this;
      }

      @JsonProperty("capacity")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder capacity(final String capacity) {
         this.capacity = capacity;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("statusType")
      public MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder statusType(final Integer statusType) {
         this.statusType = statusType;
         return this;
      }

      public MesEnclosureEnclosureDOParam build() {
         return new MesEnclosureEnclosureDOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.boolStatusEnum,
            this.category,
            this.name,
            this.serialNumber,
            this.plate,
            this.color,
            this.material,
            this.weight,
            this.thickness,
            this.width,
            this.length,
            this.quantity,
            this.totalLength,
            this.totalArea,
            this.remark,
            this.businessId,
            this.brand,
            this.type,
            this.capacity,
            this.boolAbnormalEnum,
            this.statusType
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureEnclosureDOParam.MesEnclosureEnclosureDOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
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
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", remark="
            + this.remark
            + ", businessId="
            + this.businessId
            + ", brand="
            + this.brand
            + ", type="
            + this.type
            + ", capacity="
            + this.capacity
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", statusType="
            + this.statusType
            + ")";
      }
   }
}
